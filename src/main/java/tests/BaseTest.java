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
    public void navigateToPageAndLogin() {
        DataPropertiesReader reader = new DataPropertiesReader("WebpageProperties");
        driver.get(reader.getData("url"));
        login(reader.getData("username"), reader.getData("password"));
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

    protected void login(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userName, password);
    }

    private void logOut() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();
        isAlertPresent();
    }

    protected boolean isAlertPresent() {
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