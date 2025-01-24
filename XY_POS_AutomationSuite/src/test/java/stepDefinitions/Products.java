package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Cart_PO;
import pageObjects.Products_PO;

public class Products extends Base_PO {
    private Products_PO products_po;
    private Cart_PO cart_po;

    public Products (Products_PO products_po, Cart_PO cart_po) {
        this.products_po = products_po;
        this.cart_po = cart_po;
    }
    @Then("verify i am in Products page")
    public void verify_i_am_in_products_page() {
        products_po.validate_ProductsPage();
    }
    @Then("I click on verification badge")
    public void i_click_on_verification_badge() {
        products_po.clickOn_VerificationBadge();
    }
    @Then("I click on first Product")
    public void i_click_on_first_product() {
        products_po.clickOn_FirstProduct();
    }
    @Then("verify i am in Product Display Page")
    public void verify_i_am_in_product_display_page() {
        products_po.validate_ProductsDisplayPage();
    }
    @And("I click on Add to cart button")
    public void i_click_on_add_to_cart_button() {
        products_po.clickOn_AddToCart();
    }
    @When("I click on the cart button")
    public void i_click_on_the_cart_button() {
        cart_po.clickOn_Cart();
    }
}
