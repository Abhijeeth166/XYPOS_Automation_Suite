package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Variables;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }
    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public void navigateTo_URL(String url) {
        getDriver().get(url);
    }
    public String GenerateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
    public String GenerateRandomAlphabet(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }
    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
    public void waitForTextVisible(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }
    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlertAnd_ValidateText(String text) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), text);
    }
    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitFor(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }
    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void clickUsingJavaScriptExecutor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void waitForWebElementAndClear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }
    public void fluentWaitForElementAndClick(WebElement element) {
        Duration timeout = Duration.ofSeconds(60);
        Duration pollingInterval = Duration.ofSeconds(5);
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(timeout)
                .pollingEvery(pollingInterval)
                .ignoring(Exception.class);

        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement elem = element;
                if (elem.isDisplayed() && elem.isEnabled()) {
                    elem.click();
                    return elem;
                }
                return null;
            }
        });
    }
    public void compareTexts(WebElement element1, WebElement element2, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        String text1 = element1.getText().trim();
        String text2 = element2.getText().trim();
        Assert.assertEquals(text1, text2, errorMessage);
    }
    public String waitForElementAndGetText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText().trim();
        return text;
    }
    public String fluentWaitForElementAndGetText(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE)) // max wait time
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText().trim();
        return text;
    }
    public void waitForElementAndSendNumber(WebElement element, int length) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Variables.DEFAULT_TIMEOUT_VALUE));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        String randomNumber = GenerateRandomNumber(length);
        sendKeys(element, randomNumber);
    }
    public void selectDropdownOption(WebElement element, String value) {
        waitForWebElementAndClick(element);
        List<WebElement> options = element.findElements(By.xpath("//div[@class='menu-item']"));
        boolean valueFound = false;
        for (WebElement option : options) {
            if (option.getAttribute("value").equals(value) || option.getText().equals(value)) {
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].scrollIntoView(true);", option);
                waitForWebElementAndClick(option);
                valueFound = true;
                break;
            }
        }
        if (!valueFound && !options.isEmpty()) {
            WebElement fallbackOption = options.get(1);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", fallbackOption);
            waitForWebElementAndClick(fallbackOption);
        }
    }
}