package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties loadedProperties = new Properties();
    private static ClassLoader loader = Thread.currentThread().getContextClassLoader();

    protected static Properties loadPropertiesFile(String nameOfPropertiesFile) {
        try {
            InputStream resourceStream = loader.getResourceAsStream(nameOfPropertiesFile);
            loadedProperties.load(resourceStream);
        } catch (IOException | NullPointerException e) {
            System.err.println("Could not read properties file.");
        }
        return loadedProperties;
    }
}
