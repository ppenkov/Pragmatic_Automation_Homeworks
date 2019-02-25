package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

public class AutomationTests {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin\n");
    }

    @Test
    public void testVariousElements()
    {
        WebElement login = driver.findElement(By.id("input-username"));
        login.sendKeys("admin");
        Assert.assertEquals(login.getAttribute("value"), "admin",  "Wrong Login! Please type the correct one!");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        Assert.assertEquals(password.getAttribute("value"), "parola123!",  "Wrong Password! Please type the correct one!");

        WebElement submitButton = driver.findElement(By.xpath("//div[@class='text-right']//button[@class='btn btn-primary']"));
        submitButton.submit();

        WebElement salesButton = driver.findElement(By.cssSelector("li#menu-sale a.parent"));
        salesButton.click();

        WebElement ordersButton = driver.findElement(By.cssSelector("li#menu-sale ul#collapse26 a"));
        ordersButton.click();

        Select orderStatus = new Select(driver.findElement(By.cssSelector("div#filter-order select#input-order-status")));

        assertFalse(orderStatus.isMultiple());

        assertEquals(orderStatus.getOptions().size(), 16);

       List<String> exp_options = Arrays.asList(new String[]{"", "Missing Orders", "Canceled", "Canceled Reversal", "Chargeback", "Complete",
               "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided"});
        List<String> act_options = new ArrayList<String>();

        List<WebElement> allOptions = orderStatus.getOptions();

        for (WebElement option : allOptions) {
           act_options.add(option.getText());
        }

        assertEquals(act_options, exp_options);

        orderStatus.selectByVisibleText("");
        assertEquals(orderStatus.getFirstSelectedOption().getText(), "");

        orderStatus.selectByValue("0");
        assertEquals(orderStatus.getFirstSelectedOption().getText(), "Missing Orders");

        orderStatus.selectByIndex(2);
        assertEquals(orderStatus.getFirstSelectedOption().getText(), "Canceled");
    }

   @AfterMethod
   public void tearDown() { driver.quit();
    }
}
