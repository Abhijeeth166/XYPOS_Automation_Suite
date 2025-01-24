package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.*;

public class Cart extends Base_PO {
    private Cart_PO cart_po;
    private Home_PO home_po;
    private Products_PO products_po;
    private Payments_PO payments_po;
    private Contacts_PO contacts_po;

    public Cart(Cart_PO cart_po, Home_PO home_po, Products_PO products_po, Payments_PO payments_po, Contacts_PO contacts_po) {
        this.cart_po = cart_po;
        this.home_po = home_po;
        this.products_po = products_po;
        this.payments_po = payments_po;
        this.contacts_po = contacts_po;
    }
    @When("I click on New Bag")
    public void i_click_on_new_bag() {
        home_po.click_On_Newbag();
    }
    @And("I click on Sales Order button")
    public void i_click_on_sales_order_button() {
        cart_po.click_On_Salesorder();
    }
    @When("I click on Products")
    public void i_click_on_products() {
        products_po.clickOn_Products();
    }
    @And("I update price of item and verify")
    public void i_update_price_of_item_and_verify() {
        cart_po.updatePriceOfItem();
    }
    @Then("I click on the Checkout button")
    public void i_click_on_the_checkout_button() {
        cart_po.click_On_CheckoutButton();
    }
    @Then("verify all required alert texts are displayed")
    public void verify_all_required_alert_texts_are_displayed(DataTable dataTable) {
        cart_po.alertsPopUp();
        cart_po.alertExist(dataTable);
    }
    @Then("I enter the ID number")
    public void i_enter_the_id_number() {
        cart_po.clickOn_ID_numberAlert();
        cart_po.verify_AddSerialNumber();
    }
    @Then("I click on the Proceed button")
    public void i_click_on_the_proceed_button() {
        cart_po.click_On_ProceedButton();
    }
    @And("I enter the Serial number")
    public void i_enter_the_serial_number() {
        cart_po.clickOn_SerialNumberRequired();
        cart_po.verify_AddSerialNumber();
    }
    @And("I select a Client Engagement Reason")
    public void i_select_a_client_engagement_reason() {
        cart_po.clickOn_ClientEngagementReason();
        cart_po.add_ClientEngagementReason();
    }
    @And("I click the Proceed button if alert is displayed else Checkout button")
    public void i_click_the_proceed_button_if_alert_is_displayed_else_checkout_button() {
        cart_po.alertsPopUp();
        cart_po.verify_AlertPresent_ForInventoryNotification();
    }
}