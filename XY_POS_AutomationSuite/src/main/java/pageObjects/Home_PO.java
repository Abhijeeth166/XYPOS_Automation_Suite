package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_PO extends Base_PO {

    @FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Home']")
    private WebElement HomePage;

    @FindBy(how = How.XPATH, using = "//a[@data-xy-new-cart]")
    private WebElement NewBag;

    public Home_PO() {
        super();
    }
    public void validate_HomePage()
    {
        waitForTextVisible(HomePage, "Home");
    }
    public void click_On_Newbag()
    {
        clickUsingJavaScriptExecutor(NewBag);
    }
}
