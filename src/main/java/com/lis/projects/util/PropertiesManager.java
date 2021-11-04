package com.lis.projects.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {
    private static final Properties PROPERTIES = new Properties();

    static {
        load();
    }

    private PropertiesManager() {}

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }


    private static void load() {
        try (InputStream inputStream = PropertiesManager.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            PROPERTIES.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
