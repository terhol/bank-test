package Drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    protected abstract void createWebDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;

        }
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();

        }
        return driver;

    }
}
