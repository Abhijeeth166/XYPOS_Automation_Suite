package stepDefinitions.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Global_Variables;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;
import static org.testng.Assert.fail;

public class Hooks {
    public WebDriver driver;
    public static final String URL = Global_Variables.URL;

    @Before
    public void setup() {
        // Launch the WebDriver before starting the scenario
        try {
            getDriver();
        } catch (Exception e) {
            e.printStackTrace();
            fail("An error occurred while starting the WebDriver.");
        }
    }
    @After
    public void tearDown() {
        cleanupDriver();
    }
    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }

        try {
            int responseCode = getHttpResponseCode(URL);

            if (responseCode == 502) {
                fail("The server returned a 502 error Bad Gateway! Test cannot proceed.");
            } else if (responseCode != 200) {
                fail("Failed to load the page. HTTP response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("An error occurred while checking the URL or loading the page.");
        }
    }
    private int getHttpResponseCode(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode();
    }
}