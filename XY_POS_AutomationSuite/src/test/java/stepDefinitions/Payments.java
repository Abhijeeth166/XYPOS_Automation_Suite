package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.Base_PO;
import pageObjects.Payments_PO;

public class Payments extends Base_PO {
    private Payments_PO payments_po;

    public Payments (Payments_PO payments_po) {
        this.payments_po = payments_po;
    }
    @And("I select the Cash payment method")
    public void i_select_the_cash_payment_method() {
        payments_po.click_On_CashPayment();
    }
    @Then("I click on the Apply Payment button")
    public void i_click_on_the_apply_payment_button() {
        payments_po.click_On_ApplyPayment();
    }
}