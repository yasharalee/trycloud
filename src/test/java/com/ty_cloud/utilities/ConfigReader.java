package com.ty_cloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader () {}

    private static Properties prop = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("Config.properties");
            prop.load(file);
            file.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Property reader failed");
        }
    }

    public static String getProperty(String key){
       return prop.getProperty(key);
    }

}
