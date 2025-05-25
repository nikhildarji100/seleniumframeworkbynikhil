package com.saucelabs.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserManagerOptions {
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		return options ;
	}
	
	public static EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-notifications");
        // Add more Edge-specific settings here
        return options;
	}
}
