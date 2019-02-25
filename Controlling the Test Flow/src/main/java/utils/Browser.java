package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    /**
     * Method which opens a browser.
     * <p>
     * Inthis example we will use only Google Chrome
     */
    public static void open() {

                String chromePath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Method which closes the browser.
     */
    public static void quit() {
        driver.quit();
    }
}
