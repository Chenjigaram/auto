package com.auto.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

public final class URLProperties implements WebDriverFactoryConstants{

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String ENV_VAR = "TEST_ENVIRONMENT";
    public static String environmentRun = "ST";
    private static Properties properties;
    
    private URLProperties() {
    }

    static {
    	File URL_PATH = new File(System.getProperty("user.dir") + "/url");
        String configPath = URL_PATH + "/url.properties";
        Properties defaultProps = new Properties();
        try (FileInputStream in = new FileInputStream(configPath)) {
            defaultProps.load(in);
            properties = new Properties(defaultProps);
            String environment = System.getProperty(ENV_VAR);
            LOG.info("Test will run against environment: " + environment);
            if (environment != null && environment.trim().length() > 0) {
            	URLProperties.environmentRun = environment;
                try (FileInputStream input = new FileInputStream(URL_PATH + "/url-" + environment + ".properties")) {
                    properties.load(input);
                } catch (IOException e) {
                    LOG.error("Error whilst loading properties: {}", e.getMessage(), e);
                }
            }
        } catch (IOException e) {
        	e.printStackTrace();
            LOG.error("Error whilst loading properties: {}", e.getMessage(), e);
        }
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}