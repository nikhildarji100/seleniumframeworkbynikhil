package com.saucelabs.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserManagerOptions {
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-save-password-bubble"); // Important!

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
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
