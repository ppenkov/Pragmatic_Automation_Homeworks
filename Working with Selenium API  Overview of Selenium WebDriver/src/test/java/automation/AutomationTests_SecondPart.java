package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class AutomationTests_SecondPart {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
    }

    @Test
    public void testClick() {

        WebElement redColor = driver.findElement(By.cssSelector("div#tabs-1 select[name=color] option[value=rd]"));
        WebElement silverColor = driver.findElement(By.cssSelector("div#tabs-1 select[name=color] option[value=sl]"));

        Actions builder = new Actions(driver);

        builder.click(redColor).keyDown(Keys.CONTROL).click(silverColor).keyUp(Keys.CONTROL).perform();
        assertTrue(redColor.isSelected());
        assertTrue(silverColor.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
