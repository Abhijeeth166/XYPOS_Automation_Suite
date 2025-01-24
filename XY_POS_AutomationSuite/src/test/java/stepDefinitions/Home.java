package stepDefinitions;

import io.cucumber.java.en.Then;
import pageObjects.Base_PO;
import pageObjects.Home_PO;

public class Home extends Base_PO {
    private Home_PO home_po;

    public Home(Home_PO home_po) {
        this.home_po = home_po;
    }
    @Then("verify I am present in homepage")
    public void verify_i_am_present_in_homepage() {
        home_po.validate_HomePage();
    }
}
