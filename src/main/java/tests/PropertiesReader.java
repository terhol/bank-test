package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author - Tereza Holm
 *
 * Reader of WebPage properties file. This contains passwords, username and url to page.
 */
public class PropertiesReader {

    private static Properties bankProperties = new Properties();
    private static ClassLoader loader = Thread.currentThread().getContextClassLoader();


    private static void loadPropertiesFile() {
        try {
            InputStream resourceStream = loader.getResourceAsStream("WebpageProperties");
            bankProperties.load(resourceStream);
            //bankProperties.load(new FileInputStream("WebpageProperties"));
        } catch (IOException | NullPointerException e) {
            System.err.println("Could not read properties file.");
        }
    }

    public static String getPassword() {
        loadPropertiesFile();
        return bankProperties.getProperty("password");
    }

    public static String getUsername() {
        loadPropertiesFile();
        return bankProperties.getProperty("username");
    }

    public static String getUrl() {
        loadPropertiesFile();
        return bankProperties.getProperty("url");
    }

    public static  String getNewPassword() {
        loadPropertiesFile();
        return bankProperties.getProperty("newPassword");
    }

    public static String getCurrentPassword() {
        loadPropertiesFile();
        return bankProperties.getProperty("currentPassword");
    }

}

















