/**
 * @author - Tereza Holm
 * <p>
 * Test for changing password and verifying if manager can log in with this new password - test cases SM1,SM2 and SM3.
 */

package tests.tests_manager;


import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.MenuPage;
import pages.LoginPage;
import tests.BaseTest;

public class TestPasswordChange extends BaseTest {
    private final String USERNAME = "mngr188296";
    private String oldPassword = "1!";
    private String newPassword = "123456!";
    private String currentPassword = oldPassword;
    //TODO generator of Strings
    private String incorrectPassword = "abc";

    @Test()
    public void changePasswordIncorrect() {
        login(USERNAME, currentPassword);
        chooseChangePasswordButton();
        changePasswordToNew(incorrectPassword, newPassword);
        Assert.assertTrue(isAlertPresent());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        Assert.assertTrue(changePasswordPage.isPageVisible());

        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();
        isAlertPresent();

    }

    @Test(priority = 1)
    public void changePasswordCorrect() {
        login(USERNAME, currentPassword);

        chooseChangePasswordButton();
        changePasswordToNew(oldPassword, newPassword);
        Assert.assertTrue(isAlertPresent());
        currentPassword = newPassword;

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageVisible());

    }

    @Test (priority = 2, dependsOnMethods = {"changePasswordCorrect"})
    public void logInWithNewPassword() {
        login(USERNAME, currentPassword);
        MenuPage menuPage = new MenuPage(driver);
        Assert.assertEquals(menuPage.getMessage(), "Welcome To Manager's Page of Guru99 Bank");

        menuPage.logOut();
        isAlertPresent();
    }

    @AfterClass
    public void changePasswordBack(){
        login(USERNAME, currentPassword);
        chooseChangePasswordButton();
        changePasswordToNew(newPassword, oldPassword);
        currentPassword = oldPassword;

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    private void chooseChangePasswordButton() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.chooseCategory(menuPage.getChangePassword());
    }

    private void changePasswordToNew(String oldPass, String newPass) {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillInChangePasswordForm(oldPass, newPass);
    }
}
