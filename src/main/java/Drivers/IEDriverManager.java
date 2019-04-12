package Drivers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {
    protected void createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        this.driver = new InternetExplorerDriver(options);
    }
}
