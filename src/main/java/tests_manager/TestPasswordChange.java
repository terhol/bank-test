/**
 * @author - Tereza Holm
 * <p>
 * Test for changing password and verifying if manager can log in with this new password - test cases SM1,SM2 and SM3.
 */

package tests_manager;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.WelcomePage;
import tests.BaseTest;

public class TestPasswordChange extends BaseTest {
    private final String USERNAME = "mngr188296";
    private String oldPassword = "derEpUs";
    private String newPassword = "123456";
    //TODO generator of Strings
    private String incorrectPassword = "abc";

    @Test
    public void changePasswordIncorrect() {
        login(USERNAME, oldPassword);
        chooseChangePasswordButton();
        changePasswordToNew(incorrectPassword, newPassword);
        Assert.assertTrue(isAlertPresent());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        Assert.assertTrue(changePasswordPage.getOldPasswordButton().isDisplayed());

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.logOut();
    }

    @Test
    public void changePasswordCorrect() {
        login(USERNAME, oldPassword);
        chooseChangePasswordButton();
        changePasswordToNew(oldPassword, newPassword);
        Assert.assertTrue(isAlertPresent());


        login(USERNAME, newPassword);
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.getMessage().equals("Welcome To Manager's Page of Guru99 Bank"));

        welcomePage.logOut();
    }

    @Test
    //TODO
    public void logInWithNewPassword(){
        login(USERNAME, newPassword);

    }

    private void chooseChangePasswordButton() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.chooseCategory(welcomePage.getChangePassword());
    }

    private void changePasswordToNew(String oldPass, String newPass) {
        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.fillInChangePasswordForm(oldPass, newPass);
    }
}
