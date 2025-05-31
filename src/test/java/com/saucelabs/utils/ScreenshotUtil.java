package com.saucelabs.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.saucelabs.lib.WebDriverLib;

public class ScreenshotUtil extends WebDriverLib{
	
	public static String captureScreenshot() throws IOException {
		WebDriver driver = getDriver();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/test-output/FailedTestcase.png"));
		return System.getProperty("user.dir") + "/test-output/FailedTestcase.png";
	}

}
