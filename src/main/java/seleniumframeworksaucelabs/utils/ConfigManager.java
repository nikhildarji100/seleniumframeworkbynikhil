package seleniumframeworksaucelabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	Properties properties = new Properties();
	String file = "config.properties";
	private String baseUrl;
    private String username;
    private String password;
    private String browser;
    
    private ConfigManager() throws IOException {
        loadProperties();
    }
    
     void loadProperties() throws IOException {
    	FileInputStream fis = new FileInputStream("config.propeerties");
    	properties.load(fis);
    	// Assign values to private fields
        baseUrl = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        browser = properties.getProperty("browser");
    }
    
  // Public getters (read-only access)
     public String getBaseUrl() {
         return baseUrl;
     }

     public String getUsername() {
         return username;
     }

     public String getPassword() {
         return password;
     }

     public String getBrowser() {
         return browser;
     }
    
    

}
