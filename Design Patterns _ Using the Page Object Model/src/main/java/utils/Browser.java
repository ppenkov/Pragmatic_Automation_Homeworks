package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * This class represents the utilization of a browser.
 */
public class Browser {
    public static WebDriver driver;

    /**
     * Method which opens a browser by passed browserType.
     * <p>
     * Valid options: chrome, firefox, opera
     *
     * @param browserType the browser type which will be opened.
     */
    public static void open(String browserType) {
        switch (browserType) {
            case "chrome":
                String chromePath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;
            case "firefox":
                break;
            case "opera":
                break;

            default:
                throw new RuntimeException("The browser that is chosen " + browserType + " is not a valid browser!");
        }

    }

    /**
     * Method which closes the browser.
     */
    public static void quit() {
        driver.quit();
    }
}
