package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage {
    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Change Password")
    private WebElement changePassword;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    private WebElement logOutButton;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
    private WebElement welcomePageMessage;


    public void clickOnChangePassword() {
        this.changePassword.click();
    }

    public void chooseCategory(WebElement element){
        element.click();
    }

    public WebElement getChangePassword() {
        return changePassword;
    }

    public String getMessage(){
        return welcomePageMessage.getText();
    }

    public void logOut(){
        logOutButton.click();
    }
}

