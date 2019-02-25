package pages;

import org.openqa.selenium.By;
import utils.Browser;

public class DashboardPage {

    private static final By SALES_BUTTON = By.cssSelector("li#menu-sale a.parent");
    private static final By ORDER_BUTTON = By.cssSelector("li#menu-sale ul#collapse26 a");

    /**
    * Method which navigates to the Orders Page by clicking 2 buttons.
    */
    public static void goToOrdersPage() {
        Browser.driver.findElement(SALES_BUTTON).click();
        Browser.driver.findElement(ORDER_BUTTON).click();
    }
}
