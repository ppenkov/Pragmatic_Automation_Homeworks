package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class OrdersPage {

    private static final Select orderStatus = new Select(Browser.driver.findElement(By.cssSelector("div#filter-order select#input-order-status")));

    /**
     * Method which checks if the select is multiple.
     */
    public static void checkIfTheSelectIsMultiple() {
        assertFalse(orderStatus.isMultiple());
    }

    /**
     * Method which checks the number of the elements in the select.
     */
    public static void checkTheNumberOfTheElements() {
        assertEquals(orderStatus.getOptions().size(), 16);
    }

    /**
     * Method which checks an element by selected value.
     */
    public static void checkTheElementByValue(String value, String expectedValue) {
        orderStatus.selectByValue(value);
        assertEquals(orderStatus.getFirstSelectedOption().getText(), expectedValue);
    }

    /**
     * Method which checks an element by index.
     */
    public static void checkTheElementByIndex(Integer index, String expectedValue) {
        orderStatus.selectByIndex(index);
        assertEquals(orderStatus.getFirstSelectedOption().getText(), expectedValue);
    }
}
