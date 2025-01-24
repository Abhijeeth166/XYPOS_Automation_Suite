package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Payments_PO extends Base_PO {

    @FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Payment']")
    private WebElement paymentPage;

    @FindBy(how = How.XPATH, using = "//div[@class='xy-grid xy-payment-method']//div[normalize-space(translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ')) = 'CASH']")
    private WebElement cashPayment;

    @FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Cash']")
    private WebElement cashPaymentPage;

    @FindBy(how = How.XPATH, using = "//a[normalize-space(text()) = 'Apply Payment']")
    private WebElement applyPaymentButton;

    public Payments_PO() {
        super();
    }
    public void click_On_CashPayment() {
        waitForTextVisible(paymentPage, "Payment");
        waitForWebElementAndClick(cashPayment);
    }
    public void click_On_ApplyPayment() {
        waitForTextVisible(cashPaymentPage, "Cash");
        waitForWebElementAndClick(applyPaymentButton);
    }
}
