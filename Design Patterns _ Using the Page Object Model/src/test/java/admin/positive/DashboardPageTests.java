package admin.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.DashboardPage;
import utils.Browser;
import utils.CommongVerifications;

public class DashboardPageTests {

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
        AdminLoginPage.goTo();
        AdminLoginPage.login("admin", "parola123!");
    }

    @Test
    public void navigatingToOrdersPage() {
        DashboardPage.goToOrdersPage();
        CommongVerifications.verifyTitle("Orders", "The login was unsuccessful!");
    }

    @AfterMethod
    public void tearDown() {Browser.quit();}
}
