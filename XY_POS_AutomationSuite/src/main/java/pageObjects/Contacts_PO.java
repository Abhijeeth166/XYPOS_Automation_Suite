package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.Arrays;

public class Contacts_PO extends Base_PO{

    @FindBy(how = How.XPATH, using = "//li[@class='swipeout']//div[@class='item-before']//div[@class='item-title'][1]")
    private WebElement firstTestCustomerName;

    @FindBy(how = How.XPATH, using = "//a[@class='item-link item-content xy-customer-card swipeout-content'][1]")
    private WebElement firstTestCustomer;

    @FindBy(how = How.ID, using = "search")
    private WebElement search;

    @FindBy(how = How.XPATH, using = "//div[@class='center sliding']/a[@data-xy-view-customer]")
    private WebElement customerAdded;

    public Contacts_PO() {
        super();
    }
    public void add_CustomerAndVerify() throws InterruptedException {
        sendKeys(search, "test" + Keys.RETURN);
        String customername = waitForElementAndGetText(firstTestCustomerName);
        customername = customername.replaceAll("[^a-zA-Z0-9 ]", "").trim();
        String[] customernameParts = customername.split(" ");
        Arrays.sort(customernameParts);
        String normalizedCustomerName = String.join(" ", customernameParts);
        waitForWebElementAndClick(firstTestCustomer);
        String addedcustomer = waitForElementAndGetText(customerAdded);
        addedcustomer = addedcustomer.replaceAll("[^a-zA-Z0-9 ]", "").trim();
        String[] addedcustomerParts = addedcustomer.split(" ");
        Arrays.sort(addedcustomerParts);
        String normalizedAddedCustomer = String.join(" ", addedcustomerParts);
        Assert.assertEquals(normalizedCustomerName, normalizedAddedCustomer, "Text not equal");
    }
}
