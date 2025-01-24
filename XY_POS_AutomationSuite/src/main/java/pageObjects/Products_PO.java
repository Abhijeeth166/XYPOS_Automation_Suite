package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Products_PO extends Base_PO {

    @FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Products']")
    private WebElement ProductsPage;

    @FindBy(how = How.XPATH, using = "//div[@class='xy-label' and normalize-space(text())='Products']")
    private WebElement productsButton;

    @FindBy(how = How.XPATH, using = "//div[@class='xy-searchbar-with-button searchbar-phone']/div[2]")
    private WebElement verificationBadge;

    @FindBy(how = How.CSS, using = "li.product-card.prod-li")
    private WebElement firstProductCard;

    @FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Product Display Page']")
    private WebElement productDisplayPage;

    @FindBy(how = How.XPATH, using = "//button[@class='addToCart addToCartFixed']//div[normalize-space(text()) = 'Add to Cart']")
    private WebElement addToCartButton;

    public Products_PO() {
        super();
    }
    public void clickOn_Products()
    {
        fluentWaitForElementAndClick(productsButton);
    }
    public void validate_ProductsPage()
    {
        waitForTextVisible(ProductsPage, "Products");
    }
    public void clickOn_VerificationBadge()
    {
        waitForWebElementAndClick(verificationBadge);
    }
    public void clickOn_FirstProduct()
    {
        waitForWebElementAndClick(firstProductCard);
    }
    public void validate_ProductsDisplayPage()
    {
        waitForTextVisible(productDisplayPage, "Product Display Page");
    }
    public void clickOn_AddToCart()
    {
        waitForWebElementAndClick(addToCartButton);
    }
}
