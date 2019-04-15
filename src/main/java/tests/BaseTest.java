/**
 * @author - Tereza Holm
 * <p>
 * Basic test page, sets up driver and tears it down before and after test.
 */

package tests;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeSuite
    public void initializeDriver() {
        driverManager = DriverManagerFactory.getWebDriver(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
    }

    @BeforeTest
    public void navigateToPage() {
        driver.get("http://demo.guru99.com/V3/");
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }


    public void login(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userName, password);
    }

    public boolean isAlertPresent() {
        boolean isPresent = false;
        try {
            Alert alert = driver.switchTo().alert();
            isPresent = true;
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert found.");
        }
        return isPresent;


    }

}
