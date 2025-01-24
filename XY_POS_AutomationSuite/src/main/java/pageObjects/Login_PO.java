package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_Variables;

public class Login_PO extends Base_PO {

    @FindBy(how = How.NAME, using = "username")
    private WebElement Username;

    @FindBy(how = How.XPATH, using = "//a[@class='item-link list-button buttonLogin' and contains(text(),'Continue')]")
    private WebElement Continue;

    @FindBy(how = How.NAME, using = "password")
    private WebElement Password;

    @FindBy(how = How.XPATH, using = "//div[@class='homeBg']/img")
    private WebElement XyLogo;

    @FindBy(how = How.XPATH, using = "//a[text()='SIGN IN']")
    private WebElement SignIn;

    public Login_PO() {
        super();
    }
    public void navigateTo_XY_Login_Page()
    {
        navigateTo_URL(Global_Variables.URL);
    }
    public void setUsername(String username)
    {
        sendKeys(Username, username);
    }
    public void setPassword()
    {
        String password = Global_Variables.PASSWORD;
        sendKeys(Password, password);
    }
    public void clickOn_Continue()
    {
       waitForWebElementAndClick(Continue);
    }
    public void clickOn_SignIn()
    {
        waitForWebElementAndClick(SignIn);
    }
    public void validate_SuccessfulLogin_Message()
    {
        waitForAlertAnd_ValidateText("validation succeeded");
    }
    public void validate_UnSuccessfulLogin_Message()
    {
        waitForAlertAnd_ValidateText("validation failed");
    }

}
