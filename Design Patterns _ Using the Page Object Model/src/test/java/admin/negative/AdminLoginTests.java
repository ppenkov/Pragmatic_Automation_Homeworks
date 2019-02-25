package admin.negative;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import utils.Browser;

public class AdminLoginTests {

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void unsuccesfulAdminLogin() {
        AdminLoginPage.goTo();
        AdminLoginPage.login("Joro", "parola123!");
        AdminLoginPage.verifyErrorValidationMessage("No match for Username and/or Password.",
                "The expected validation error message is INCORRECT!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }


}
