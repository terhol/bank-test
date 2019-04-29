package tests.tests_manager;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.MenuPage;
import pages.LoginPage;
import tests.BaseTest;
import tests.PropertiesReader;

/**
 * @author - Tereza Holm
 *
 * Test for changing password and verifying if manager can log in with this new password - test cases SM1,SM2 and SM3.
 */
//TODO better solution for case when Test changes password but fails before setting it back
public class TestPasswordChange extends BaseTest {
    //TODO generator of Strings
    private String incorrectPassword = "abc";

    @Test()
    public void changePasswordIncorrect() {
        chooseChangePasswordButton();
        changePasswordToNew(incorrectPassword, PropertiesReader.getNewPassword());
        Assert.assertTrue(isAlertPresent());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        Assert.assertTrue(changePasswordPage.isPageVisible());


    }

    @Test(priority = 1)
    public void changePasswordCorrect() {
        chooseChangePasswordButton();
        changePasswordToNew(PropertiesReader.getPassword(), PropertiesReader.getNewPassword());
        Assert.assertTrue(isAlertPresent());
        //currentPassword = newPassword;

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageVisible());

    }

    @Test(priority = 2, dependsOnMethods = {"changePasswordCorrect"})
    public void logInWithNewPassword() {
        Assert.assertTrue(isAlertPresent());
        login(PropertiesReader.getUsername(), PropertiesReader.getNewPassword());
        MenuPage menuPage = new MenuPage(driver);
        Assert.assertEquals(menuPage.getMessage(), "Welcome To Manager's Page of Guru99 Bank");

    }

    @AfterClass
    public void changePasswordBack() {

        login(PropertiesReader.getUsername(), PropertiesReader.getNewPassword());
        chooseChangePasswordButton();
        changePasswordToNew(PropertiesReader.getNewPassword(), PropertiesReader.getPassword());
        //currentPassword = oldPassword;

        isAlertPresent();
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
