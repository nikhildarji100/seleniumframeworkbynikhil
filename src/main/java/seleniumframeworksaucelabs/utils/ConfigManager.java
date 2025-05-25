package seleniumframeworksaucelabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	Properties properties = new Properties();
	String file = "C:\\Users\\ASUS\\AutomationFrameworks\\src\\main\\resources\\config.properties";
	private String baseUrl;
    private String username;
    private String password;
    private String browser;
    private String driverPath;
    
    public ConfigManager() throws IOException {
        loadProperties();
    }
    
    public void loadProperties() throws IOException {
    	FileInputStream fis = new FileInputStream(file);
    	properties.load(fis);
    	 
        baseUrl = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        browser = properties.getProperty("browser");
        driverPath = properties.getProperty("driverPath");    }
    
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
     
     public String getDriverPath() {
         return driverPath;
     }
    
    

}
