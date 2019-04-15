package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "oldpassword")
    private WebElement oldPassword;

    @FindBy(name = "newpassword")
    private WebElement newPassword;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;

    @FindBy(name = "sub")
    private WebElement submit;

    public void fillInChangePasswordForm(String oldPass, String newPass) {
        waitForElement(oldPassword);
        oldPassword.sendKeys(oldPass);
        newPassword.sendKeys(newPass);
        confirmPassword.sendKeys(newPass);
        submit.submit();

    }

    public WebElement getOldPasswordButton() {
        return oldPassword;
    }
}
