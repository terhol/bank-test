package tests;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.MenuPage;
import pages.LoginPage;


/**
 * @author - Tereza Holm
 * <p>
 * Basic test page, sets up driver and tears it down before and after test.
 */
public class BaseTest {
    protected WebDriver driver;
    protected DriverManager driverManager;
    private MenuPage menuPage;

    @BeforeSuite
    public void initializeDriver() {
        driverManager = DriverManagerFactory.getWebDriver(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
    }

    @BeforeMethod
    public void navigateToPage() {
        driver.get(PropertiesReader.getUrl());
    }

    @AfterMethod
    public void logOutFromApp(){
        LoginPage loginPage = new LoginPage(driver);
        try{loginPage.isPageVisible();
        }
        catch(NoSuchElementException | TimeoutException e){
            logOut();
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public void login(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userName, password);
    }

    public void logOut() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();
        isAlertPresent();
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