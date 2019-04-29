package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage extends BasePage {

    public AddNewCustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(xpath = "//input[@name='rad1'][@value='m']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@name='rad1'][@value='f']")
    private WebElement genderFemale;





    @Override
    public boolean isPageVisible() {
        return false;
    }
}
