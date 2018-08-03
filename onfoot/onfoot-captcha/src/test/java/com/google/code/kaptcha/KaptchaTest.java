package com.google.code.kaptcha;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.kaptcha.util.Config;

public class KaptchaTest {
	
	private Config config;

	@Before
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
		properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "400");
		properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "100");
		properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "WHITE");
		properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_TO, "WHITE");
		properties.setProperty(Constants.KAPTCHA_BORDER, "no");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "80");
		properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
		properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.NoGimpy");
		properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "12");
		this.config = new Config(properties);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		Producer producer = this.config.getProducerImpl();
		String text = producer.createText();
		System.out.println(text);
		BufferedImage image = producer.createImage(text);
		ImageIO.setUseCache(false);
		ImageIO.write(image, "jpg", new File("captcha.jpg"));
	}

}
