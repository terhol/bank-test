package tests.tests_manager;


import org.testng.annotations.Test;
import pages.AddNewCustomerPage;
import pages.MenuPage;
import tests.BaseTest;
import tests.DataPropertiesReader;

/**
 * @author - Tereza Holm
 *
 * Tests adding a new customer and account - test cases SM4 and SM5.
 */
public class TestAddNewCustomerAndAccount extends BaseTest {

    @Test
    public void addNewCustomer(){
        chooseAddNewCustomerButton();
        AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage(driver);
        addNewCustomerPage.fillInForm("CustomerProperties");
    }







    //TODO more general way to click on buttons in menu
    private void chooseAddNewCustomerButton() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.chooseCategory(menuPage.getAddNewCustomer());
    }


}
