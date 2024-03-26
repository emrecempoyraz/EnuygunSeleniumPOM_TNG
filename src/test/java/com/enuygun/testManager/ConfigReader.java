package com.enuygun.testManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties ;

    static {
        String filePath = "src/test/resources/config.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        }catch (IOException e){
            System.out.println("Cant read to file!!");
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
