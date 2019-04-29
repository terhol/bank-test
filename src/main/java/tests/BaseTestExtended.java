package tests;

import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTestExtended extends BaseTest {
    private String username = "mngr188296";
    private String password = "1!";

    @BeforeMethod
    public void navigateToPage() {
        driver.get("http://demo.guru99.com/V4/index.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(username, password);
    }
}
