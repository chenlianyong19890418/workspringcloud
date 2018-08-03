package com.dlsmartercity.annualaccount.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class IOUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IOUtils.class);
	
	public static void closeQuietly(Closeable closeable) {
		org.apache.commons.io.IOUtils.closeQuietly(closeable);
	}
	
	public static int copy(InputStream input, OutputStream output) {
		try {
			return org.apache.commons.io.IOUtils.copy(input, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}
	
	public static void copy(InputStream input, Writer output) {
		try {
			org.apache.commons.io.IOUtils.copy(input, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void copy(InputStream input, Writer output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.copy(input, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static int copy(Reader input, Writer output) {
		try {
			return org.apache.commons.io.IOUtils.copy(input, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}
	
	public static void copy(Reader input, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.copy(input, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void copy(Reader input, OutputStream output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.copy(input, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static byte[] toByteArray(InputStream input) {
		byte[] result = new byte[0];
		try {
			result = org.apache.commons.io.IOUtils.toByteArray(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static byte[] toByteArray(Reader input) {
		byte[] result = new byte[0];
		try {
			result = org.apache.commons.io.IOUtils.toByteArray(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static String toString(InputStream input) {
		String result = "";
		try {
			result = org.apache.commons.io.IOUtils.toString(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static String toString(InputStream input, String encoding) {
		String result = "";
		try {
			result = org.apache.commons.io.IOUtils.toString(input, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static String toString(Reader input) {
		String result = "";
		try {
			result = org.apache.commons.io.IOUtils.toString(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static String toString(byte[] input) {
		String result = "";
		try {
			result = org.apache.commons.io.IOUtils.toString(input, Charset.defaultCharset().name());
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static String toString(byte[] input, String encoding) {
		String result = "";
		try {
			result = org.apache.commons.io.IOUtils.toString(input, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static List<String> readLines(InputStream input) {
		List<String> result = new ArrayList<>();
		try {
			result = org.apache.commons.io.IOUtils.readLines(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static List<String> readLines(InputStream input, String encoding) {
		List<String> result = new ArrayList<>();
		try {
			result = org.apache.commons.io.IOUtils.readLines(input, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static List<String> readLines(Reader input) {
		List<String> result = new ArrayList<>();
		try {
			result = org.apache.commons.io.IOUtils.readLines(input);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return result;
	}
	
	public static InputStream toInputStream(CharSequence input) {
		return org.apache.commons.io.IOUtils.toInputStream(input);
	}
	
	public static InputStream toInputStream(CharSequence input, String encoding) {
		return org.apache.commons.io.IOUtils.toInputStream(input, Charset.forName(encoding));
	}
	
	public static InputStream toInputStream(String input) {
		return org.apache.commons.io.IOUtils.toInputStream(input);
	}
	
	public static InputStream toInputStream(String input, String encoding) {
		return org.apache.commons.io.IOUtils.toInputStream(input, Charset.forName(encoding));
	}
	
	public static void write(byte[] data, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(byte[] data, Writer output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(byte[] data, Writer output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.write(data, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(char[] data, Writer output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(char[] data, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(char[] data, OutputStream output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.write(data, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(CharSequence data, Writer output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(CharSequence data, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(CharSequence data, OutputStream output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.write(data, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(String data, Writer output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(String data, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.write(data, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void write(String data, OutputStream output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.write(data, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void writeLines(Collection<?> lines, OutputStream output) {
		writeLines(lines, null, output);
	}
	
	public static void writeLines(Collection<?> lines, String lineEnding, OutputStream output) {
		try {
			org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, output);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void writeLines(Collection<?> lines, OutputStream output, String encoding) {
		writeLines(lines, null, output, encoding);
	}
	
	public static void writeLines(Collection<?> lines, String lineEnding, OutputStream output, String encoding) {
		try {
			org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, output, encoding);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static void writeLines(Collection<?> lines, Writer writer) {
		writeLines(lines, null, writer);
	}
	
	public static void writeLines(Collection<?> lines, String lineEnding, Writer writer) {
		try {
			org.apache.commons.io.IOUtils.writeLines(lines, lineEnding, writer);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
	
	public static int read(InputStream input, byte[] buffer) {
		try {
			return org.apache.commons.io.IOUtils.read(input, buffer);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}
	
	public static int read(InputStream input, byte[] buffer, int offset, int length) {
		try {
			return org.apache.commons.io.IOUtils.read(input, buffer, offset, length);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}
	
	public static int read(Reader input, char[] buffer) {
		try {
			return org.apache.commons.io.IOUtils.read(input, buffer);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}
	
	public static int read(Reader input, char[] buffer, int offset, int length) {
		try {
			return org.apache.commons.io.IOUtils.read(input, buffer, offset, length);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return -1;
	}

}
