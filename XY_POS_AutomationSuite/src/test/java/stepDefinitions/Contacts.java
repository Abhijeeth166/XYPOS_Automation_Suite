package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.Base_PO;
import pageObjects.Cart_PO;
import pageObjects.Contacts_PO;

public class Contacts extends Base_PO {
    private Contacts_PO contacts_po;
    private Cart_PO cart_po;

    public Contacts(Contacts_PO contacts_po, Cart_PO cart_po) {
        this.contacts_po = contacts_po;
        this.cart_po = cart_po;
    }
    @Then("I add a customer to the order and verify")
    public void i_add_a_customer_to_the_order_and_verify() throws InterruptedException {
        cart_po.clickOn_CustomerMissingAlert();
        contacts_po.add_CustomerAndVerify();
    }
}
