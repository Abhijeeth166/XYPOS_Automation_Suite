package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        if (webDriver.get() == null)
        {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "chrome headless" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
    private static String getBrowserType() {
        String browserType = null;
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser");
            if (browserType != null) {
                browserType = browserType.trim().toLowerCase();
            } else {
                System.out.println("Browser type is not specified in the properties file.");
            }
        } catch (IOException ex) {
            System.out.println("Error reading config.properties: " + ex.getMessage());
        }
        return browserType;
    }
    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}