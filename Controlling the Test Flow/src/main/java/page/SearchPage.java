package page;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class SearchPage {

    private static final By LOC_RESULTBAR = By.xpath("//div[@class='restaurants__list']//li[4]//span[@class='name fn']");

    /**
     * Method which verifies if the searched restaurant appears on the second page
     *
     * @param expected - the expected title
     * @param errorMessage - error message in case the assert fails.
     */
    public static void verifyRestaurant(String expected, String errorMessage) {
        String actualValue = Browser.driver.findElement(LOC_RESULTBAR).getAttribute("value");
        Assert.assertEquals(actualValue, expected, errorMessage);
    }
}
