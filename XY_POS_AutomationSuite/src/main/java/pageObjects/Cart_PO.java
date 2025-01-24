package pageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import java.util.List;
import java.util.NoSuchElementException;

public class Cart_PO extends Base_PO {

    @FindBy(how = How.XPATH, using = "//div[@class='xy-label' and normalize-space(text())='Sales Order']")
    private WebElement salesOrderButton;

    @FindBy(how = How.XPATH, using = "//a[@class='xy-floating-cart']//i[@class='mdi mdi-shopping']")
    private WebElement cartButton;

    @FindBy(how = How.XPATH, using = "//div[@class='item-content swipeout-content item-link']//div[@class='item-inner']")
    private WebElement itemCart;

    @FindBy(how = How.CSS, using = "a.list-button.item-link[data-xy-menu-action='update']")
    private WebElement updateButton;

    @FindBy(how = How.XPATH, using = "//input[@type='number' or @data-input='price' or @placeholder='Enter price']")
    private WebElement inputField;

    @FindBy(how = How.XPATH, using = "//a[text()='Update Price']")
    private WebElement updatePriceButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='item-title-row'])[2]//div[@class='item-after']")
    private WebElement amountElement;

    @FindBy(how = How.XPATH, using = "//a[@class='button xy-payment-btn']")
    private WebElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title' and normalize-space(text())='Alerts']")
    private WebElement alertPopup;

    @FindBy(how = How.XPATH, using = "//div[contains(normalize-space(text()), 'Alerts')]")
    private WebElement alertPopupSlowear;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and normalize-space(text())='Customer Missing']")
    private WebElement customerMissing_Alert;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and normalize-space(text())='ID Number Required']")
    private WebElement IDMissing_Alert;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and normalize-space(text())='Inventory Notification']")
    private WebElement inventoryNotification;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and normalize-space(text())='Serial No. Required']")
    private WebElement serialNumberRequired_Alert;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and normalize-space(text())='Client Engagement Reason']")
    private WebElement clientEngagementReason_Alert;

    @FindBy(how = How.XPATH, using = "//div[@class='item-title-row']/div[@class='item-title' and (normalize-space(text())='Customer Missing' or normalize-space(text())='ID Number Required' or normalize-space(text())='Inventory Notification' or normalize-space(text())='Serial No. Required' or normalize-space(text())='Client Engagement Reason')]")
    private List<WebElement> alertElements;

    @FindBy(how = How.XPATH, using = "//li[@class='swipeout']//div[@class='item-title']")
    private WebElement firstTestCustomer;

    @FindBy(how = How.XPATH, using = "//a[@href='#' and @data-xy-view-customer='']")
    private WebElement customerAdded;

    @FindBy(how = How.XPATH, using = "//div[contains(normalize-space(text()), 'Add Serial No.')]")
    private WebElement addSerialNumber_Title;

    @FindBy(how = How.XPATH, using = "//input[@data-xy-serial-input or @placeholder='Enter Serial No.']")
    private WebElement enter_SerialNumberTextBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Proceed']")
    private WebElement proceedButton;

    @FindBy(how = How.XPATH, using = "//div[@class='dropdown-toggle dropdownStroke' or contains(normalize-space(text()), 'Select Reason')]")
    private WebElement selectReason_Dropdown;

    public Cart_PO() {
        super();
    }
    public void click_On_Salesorder() {
        waitForWebElementAndClick(salesOrderButton);
    }
    public void clickOn_Cart() {
        fluentWaitForElementAndClick(cartButton);
    }
    public void clickOn_ItemCart() {
        fluentWaitForElementAndClick(itemCart);
    }
    public void updatePriceOfItem() {
        clickOn_ItemCart();
        waitForWebElementAndClick(updateButton);
        waitForWebElementAndClear(inputField);
        int randomAmount = (int) (Math.random() * 1000);
        String randomAmountStr = Integer.toString(randomAmount);
        sendKeys(inputField, (randomAmountStr));
        waitForWebElementAndClick(updatePriceButton);
    }
    public void click_On_CheckoutButton() {
        fluentWaitForElementAndClick(checkoutButton);
    }
    public void alertsPopUp() {
        waitForTextVisible(alertPopup, "Alerts");
    }
    public void alertExist(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            String username = row.get(0);
            String actualAlertText = alertElements.get(i).getText().trim();
            Assert.assertEquals(username, actualAlertText);
        }
    }
    public void clickOn_CustomerMissingAlert() {
        if (customerMissing_Alert.isDisplayed()) {
            waitForWebElementAndClick(customerMissing_Alert);
        }
    }
    public void clickOn_ID_numberAlert() {
        if (IDMissing_Alert.isDisplayed()) {
            waitForWebElementAndClick(IDMissing_Alert);
        }
    }
    public void compare_CustomerNames() {
        compareTexts(firstTestCustomer, customerAdded, "values are unequal");
    }
    public void verify_AddSerialNumber() {
        waitForTextVisible(addSerialNumber_Title, "Add Serial No.");
        waitForElementAndSendNumber(enter_SerialNumberTextBox, 6);
        waitForWebElementAndClick(saveButton);
    }
    public void click_On_ProceedButton() {
        waitForWebElementAndClick(proceedButton);
    }
    public void clickOn_SerialNumberRequired() {
        if (serialNumberRequired_Alert.isDisplayed()) {
            waitForWebElementAndClick(serialNumberRequired_Alert);
        }
    }
    public void clickOn_ClientEngagementReason() {
        if (clientEngagementReason_Alert.isDisplayed()) {
            waitForWebElementAndClick(clientEngagementReason_Alert);
        }
    }
    public void add_ClientEngagementReason() {
        waitForWebElementAndClick(selectReason_Dropdown);
        selectDropdownOption(selectReason_Dropdown, "MOTO");
    }
    public void verify_AlertPresent_ForInventoryNotification() {
        try {
            if (alertPopup.isEnabled()) {
                waitForWebElementAndClick(proceedButton);
            } else {
                //click_On_CheckoutButton();
                return;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: Required elements not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}