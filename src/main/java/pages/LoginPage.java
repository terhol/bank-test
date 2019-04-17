package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "uid")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public void logIn(String name, String pass){
        waitForElement(userName);
        userName.sendKeys(name);
        password.sendKeys(pass);
        loginButton.click();
    }

    public boolean isPageVisible() {
        return userName.isDisplayed();
    }

}
