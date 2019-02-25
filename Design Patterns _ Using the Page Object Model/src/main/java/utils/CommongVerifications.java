package utils;

import org.testng.Assert;

public class CommongVerifications {

    /**
     * Method which verifies the title based on the provided expected title and logs a message in case of assert failure.
     *
     * @param expected     the expected title
     * @param errorMessage error message in case the assert fails.
     */
    public static void verifyTitle(String expected, String errorMessage) {
        String actualTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualTitle, expected, errorMessage);
    }
}
