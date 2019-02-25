package page;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

import static org.testng.Assert.assertTrue;

public class HomePage {

    private static final By LOC_ADDRESSBAR = By.id("delivery-information-postal-index");
    private static final By LOC_SEARCH_BUTTON = By.cssSelector(".button-container>button");

    /**
     * Method which takes you to the home page
     */
    public static void goTo() {
        Browser.driver.get("https://www.foodpanda.bg/");
    }

    /**
     * Method that enters the address of the preferred restaurant and searches for it.
     *
     * @param address - the adress of the restaurant
     */
    public static void searchRestaurant(String address) {
        Browser.driver.findElement(LOC_ADDRESSBAR).sendKeys(address);

        /**
         * explicit custom-wait
         */
        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
 			WebElement message = wait.until(new ExpectedCondition<WebElement>() {
				@NullableDecl
				@Override
				public WebElement apply(@NullableDecl WebDriver input) {
					return Browser.driver.findElement(LOC_ADDRESSBAR);
				}
			});

        assertTrue(message.getAttribute("value").contains("булевард"));

        Browser.driver.findElement(LOC_SEARCH_BUTTON).click();
    }
}
