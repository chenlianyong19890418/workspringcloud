package com.xinguang.xvcode.generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException, IOException {
		int width = 200;
		int height = 50;
		int count = 4;
		Generator generator = new PngVCGenerator(width, height, count);
        generator.write2out(new FileOutputStream("1.png")).close();
        System.out.println(generator.text());
        generator = new GifVCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream("1.gif")).close();
        System.out.println(generator.text());
        generator = new Gif2VCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream("2.gif")).close();
        System.out.println(generator.text());
        generator = new Gif3VCGenerator(width, height, count);//   gif
        generator.write2out(new FileOutputStream("3.gif")).close();
        System.out.println(generator.text());
	}

}
