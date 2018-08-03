package com.dlsmartercity.annualaccount.core.converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;

public class FastJsonMessageConverter implements MessageConverter, BeanClassLoaderAware {
	
	private MessageType targetType = MessageType.BYTES;

	private String encodingPropertyName;

	private String typeIdPropertyName;

	private Map<String, Class<?>> idClassMappings = new HashMap<>();

	private Map<Class<?>, String> classIdMappings = new HashMap<>();
	
	private ClassLoader beanClassLoader;
	
	private FastJsonConfig fastJsonConfig = new FastJsonConfig();
	
	public FastJsonMessageConverter() {
	}

	public void setTargetType(MessageType targetType) {
		Assert.notNull(targetType, "MessageType must not be null");
		this.targetType = targetType;
	}

	public void setEncodingPropertyName(String encodingPropertyName) {
		this.encodingPropertyName = encodingPropertyName;
	}

	public void setTypeIdPropertyName(String typeIdPropertyName) {
		this.typeIdPropertyName = typeIdPropertyName;
	}
	
	public void setTypeIdMappings(Map<String, Class<?>> typeIdMappings) {
		this.idClassMappings = new HashMap<>();
		for (Map.Entry<String, Class<?>> entry : typeIdMappings.entrySet()) {
			String id = entry.getKey();
			Class<?> clazz = entry.getValue();
			this.idClassMappings.put(id, clazz);
			this.classIdMappings.put(clazz, id);
		}
	}
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}

	public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
		this.fastJsonConfig = fastJsonConfig;
	}

	@Override
	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		Message message;
		try {
			switch (this.targetType) {
				case TEXT:
					message = mapToTextMessage(object, session);
					break;
				case BYTES:
					message = mapToBytesMessage(object, session);
					break;
				default:
					message = mapToMessage(object, session, this.targetType);
			}
		}
		catch (IOException ex) {
			throw new MessageConversionException("Could not map JSON object [" + object + "]", ex);
		}
		setTypeIdOnMessage(object, message);
		return message;
	}

	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		try {
			Class<?> targetJavaType = getJavaTypeForMessage(message);
			return convertToObject(message, targetJavaType);
		}
		catch (IOException ex) {
			throw new MessageConversionException("Failed to convert JSON message content", ex);
		}
	}
	
	protected TextMessage mapToTextMessage(Object object, Session session) throws JMSException, IOException {
		StringWriter writer = new StringWriter();
		JSON.writeJSONString(writer, object);
		TextMessage message = session.createTextMessage(writer.toString());
		return message;
	}
	
	protected BytesMessage mapToBytesMessage(Object object, Session session) throws JMSException, IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JSON.writeJSONString(os, this.fastJsonConfig.getCharset(), object);
		BytesMessage message = session.createBytesMessage();
		message.writeBytes(os.toByteArray());
		if (this.encodingPropertyName != null) {
			message.setStringProperty(this.encodingPropertyName, this.fastJsonConfig.getCharset().name());
		}
		return message;
	}
	
	protected Message mapToMessage(Object object, Session session, MessageType targetType) {
		throw new IllegalArgumentException("Unsupported message type [" + targetType +
				"]. FastJsonMessageConverter by default only supports TextMessages and BytesMessages.");
	}
	
	protected void setTypeIdOnMessage(Object object, Message message) throws JMSException {
		if (this.typeIdPropertyName != null) {
			String typeId = this.classIdMappings.get(object.getClass());
			if (typeId == null) {
				typeId = object.getClass().getName();
			}
			message.setStringProperty(this.typeIdPropertyName, typeId);
		}
	}
	
	private Object convertToObject(Message message, Class<?> targetJavaType) throws JMSException, IOException {
		if (message instanceof TextMessage) {
			return convertFromTextMessage((TextMessage) message, targetJavaType);
		} else if (message instanceof BytesMessage) {
			return convertFromBytesMessage((BytesMessage) message, targetJavaType);
		} else {
			return convertFromMessage(message, targetJavaType);
		}
	}
	
	protected Object convertFromTextMessage(TextMessage message, Class<?> targetJavaType) throws JMSException, IOException {
		String body = message.getText();
		return JSON.parseObject(body, targetJavaType);
	}
	
	protected Object convertFromBytesMessage(BytesMessage message, Class<?> targetJavaType) throws JMSException, IOException {
		String encoding = this.fastJsonConfig.getCharset().name();
		if (this.encodingPropertyName != null && message.propertyExists(this.encodingPropertyName)) {
			encoding = message.getStringProperty(this.encodingPropertyName);
		}
		byte[] bytes = new byte[(int) message.getBodyLength()];
		message.readBytes(bytes);
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		try {
			return JSON.parseObject(is, Charset.forName(encoding), targetJavaType);
		} catch (UnsupportedEncodingException ex) {
			throw new MessageConversionException("Cannot convert bytes to String", ex);
		}
	}
	
	protected Object convertFromMessage(Message message, Class<?> targetJavaType) throws JMSException, IOException {
		throw new IllegalArgumentException("Unsupported message type [" + message.getClass() +
				"]. FastJsonMessageConverter by default only supports TextMessages and BytesMessages.");
	}
	
	protected Class<?> getJavaTypeForMessage(Message message) throws JMSException {
		String typeId = message.getStringProperty(this.typeIdPropertyName);
		if (typeId == null) {
			throw new MessageConversionException("Could not find type id property [" + this.typeIdPropertyName + "]");
		}
		Class<?> mappedClass = this.idClassMappings.get(typeId);
		if (mappedClass != null) {
			return mappedClass;
		}
		try {
			Class<?> typeClass = ClassUtils.forName(typeId, this.beanClassLoader);
			return typeClass;
		} catch (Throwable ex) {
			throw new MessageConversionException("Failed to resolve type id [" + typeId + "]", ex);
		}
	}

}
