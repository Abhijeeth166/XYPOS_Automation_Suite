package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Login_PO;
import utils.Global_Variables;

public class Login extends Base_PO {
    private Login_PO login_po;
    public Login(Login_PO login_po) {
        this.login_po = login_po;
    }
    @Given("I access the XY login page")
    public void i_access_the_xy_login_page() {
        login_po.navigateTo_XY_Login_Page();
    }
    @When("I enter the Username for {string}")
    public void i_enter_the_username_for(String brand) {
        String username = Global_Variables.getUsername(brand);
        login_po.setUsername(username);
    }
    @When("I click on Continue button")
    public void i_click_on_continue_button() {
        login_po.clickOn_Continue();
    }
    @When("I enter the Password")
    public void i_enter_the_password() {
        login_po.setPassword();
    }
}
