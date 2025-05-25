package com.saucelabs.lib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.saucelabs.utils.BrowserManagerOptions;

import seleniumframeworksaucelabs.utils.ConfigManager;

public class WebDriverLib {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	static ConfigManager config = null ;
	
	public static void intiDriver() throws IOException {
		config = new ConfigManager();
		String browser = config.getBrowser();
		String path = config.getDriverPath();
		switch (browser) {
        case "chrome":
        	System.setProperty("webdriver.chrome.driver", path);
        	driver.set(new ChromeDriver(BrowserManagerOptions.getChromeOptions()));
            break;

        case "edge":
        	System.setProperty("webdriver.edge.driver", path);
        	driver.set(new EdgeDriver(BrowserManagerOptions.getEdgeOptions()));
            break;

        default:
            throw new RuntimeException("Unsupported browser:" + browser);
    }		
		
	}

	 public static WebDriver getDriver() {
	        return driver.get();
	 }
	
	 public static void launchApplication() 
			 throws IOException, InterruptedException {
		 intiDriver();
		 String url = config.getBaseUrl();
		 
		 getDriver().get(url);
	}
	 
	 
}
