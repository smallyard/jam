package cn.smallyard.jam.util;

import java.io.*;
import java.util.Properties;

/**
 * read properties file
 */
public class ConfigurationUtil {
    private Properties properties = new Properties();
    private static ConfigurationUtil instance = null;
    private static final String FILE_NAME = "app.properties";

    private ConfigurationUtil() {
        try {
            InputStream stream  = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
            properties.load(stream);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigurationUtil getConfiguration() {
        if (instance == null) {
            instance = new ConfigurationUtil();
        }
        return instance;
    }


    public String getValue(String key) {
        String value = "";
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

}
