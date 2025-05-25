package com.saucelabs.tests;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucelabs.lib.WebDriverLib;

public class FirstTest extends WebDriverLib{

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		launchApplication();
	}
	
	@AfterClass
	public void afterClass() {
		if (getDriver() != null) {
	        getDriver().close();
	    }
	}
	
	@Test
	public void TC01_Login() {
		System.out.println("Check");
	}
	
	
	
	
}
