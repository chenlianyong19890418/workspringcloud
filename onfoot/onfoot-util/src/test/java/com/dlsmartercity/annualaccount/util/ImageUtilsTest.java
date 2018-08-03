package com.dlsmartercity.annualaccount.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dlsmartercity.annualaccount.util.DateUtils;
import com.dlsmartercity.annualaccount.util.ImageUtils;

public class ImageUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
//			ImageUtils.pressImage("C://pic//jpg", "C://pic//test.gif", 5000, 5000, 0f);
//			ImageUtils.resize("C://pic//4.jpg", 1000, 500, true);
			
			byte[] img = FileUtils.readFileToByteArray(FileUtils.getFile("D:/fe66c7bc-4862-4531-af76-a5a5e4d9fc6c.jpg"));
			img = ImageUtils.pressText(img, DateUtils.convertDate2String(new Date(), "yyyy-MM-dd HH:mm:ss"));
			
			File file = FileUtils.getFile("D:/123/12341234/", "/345/fe66c7bc-4862-4531-af76-a5a5e4d9fc6c_after.jpg");
			FileUtils.writeByteArrayToFile(file, img);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
