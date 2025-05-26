package seleniumframeworksaucelabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;
    private static final Properties properties = new Properties();

    private ConfigManager() throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fis = new FileInputStream(filePath);
        properties.load(fis);
    }

    public static ConfigManager getInstance() {
        if (configManager == null) {
            synchronized (ConfigManager.class) {
                if (configManager == null) {
                    try {
                        configManager = new ConfigManager();
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to load config.properties file", e);
                    }
                }
            }
        }
        return configManager;
    }

    public String getBaseUrl() {
        return properties.getProperty("url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getDriverPath() {
        return properties.getProperty("driverPath");
    }
}
