/**
 * @author - Tereza Holm
 *
 * Basic test page, sets up driver and tears it down before and after test.
 */

package tests;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.MenuPage;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected DriverManager driverManager;
    private MenuPage menuPage;

    @BeforeSuite
    public void initializeDriver() {
        driverManager = DriverManagerFactory.getWebDriver(DriverType.CHROME);
        driver = driverManager.getWebDriver();
    }

    @BeforeTest
    public void navigateToPage() {
        driver.get("http://demo.guru99.com/V4/index.php");
    }

    /*@AfterTest
    public void logOut(){
        menuPage = new MenuPage(driver);
        menuPage.logOut();
    }*/



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
        } catch (NoAlertPresentException | UnhandledAlertException e) {
            System.out.println("No alert found.");
        }
        return isPresent;


    }

}
