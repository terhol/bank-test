package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.DataPropertiesReader;

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
    private WebElement dateField;

    @FindBy(name = "addr")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "state")
    private WebElement stateField;

    @FindBy(name = "pinno")
    private WebElement pinField;

    @FindBy(name = "telephoneno")
    private WebElement mobileNumberField;

    @FindBy(name = "emailid")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "sub")
    private WebElement submitButton;

public void fillInForm(String propertiesFileName){
    DataPropertiesReader reader = new DataPropertiesReader(propertiesFileName);
    nameField.sendKeys(reader.getData("CustomerName"));
    fillInGender(reader.getData("Gender"));
    //TODO date does not work
    fillInDate(reader.getData("Birthdate"));
    addressField.sendKeys(reader.getData("Address"));
    cityField.sendKeys(reader.getData("City"));
    stateField.sendKeys(reader.getData("State"));
    pinField.sendKeys(reader.getData("Pin"));
    mobileNumberField.sendKeys(reader.getData("Mobile"));
    emailField.sendKeys(reader.getData("Email"));
    passwordField.sendKeys("1!");
    submitButton.click();
}
 private void fillInGender(String gender){
    if(gender.equals("male")){
        genderMale.click();
    }
     if(gender.equals("female")){
         genderFemale.click();
     }
     else {
         System.err.println("No correct gender found, setting to male.");
         genderMale.click();
     }
 }

 private void fillInDate(String date){
    dateField.sendKeys(date.substring(0,4));
    dateField.sendKeys(Keys.ARROW_RIGHT);
    dateField.sendKeys(date.substring(5,7));
    dateField.sendKeys(date.substring(8));
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
