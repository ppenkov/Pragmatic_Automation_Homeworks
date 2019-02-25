package admin.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import utils.Browser;
import utils.CommongVerifications;

public class AdminLoginTests {

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
    }

    @Test
    public void adminLoginTest() {
        AdminLoginPage.goTo();
        AdminLoginPage.login("admin", "parola123!");

        CommongVerifications.verifyTitle("Dashboard", "The login was unsuccessful!");
    }

   @AfterMethod
   public void tearDown() {Browser.quit();}
}
