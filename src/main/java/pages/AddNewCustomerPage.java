package pages;

import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(id = "dob")
    private WebElement date;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(name = "pinno")
    private WebElement pin;

    @FindBy(name = "telephoneno")
    private WebElement mobileNumber;

    @FindBy(name = "emailid")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "sub")
    private WebElement submitButton;

public void fillInForm(){

}








    @Override
    public boolean isPageVisible() {
        try {
            waitForElement(nameField);
            return nameField.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
