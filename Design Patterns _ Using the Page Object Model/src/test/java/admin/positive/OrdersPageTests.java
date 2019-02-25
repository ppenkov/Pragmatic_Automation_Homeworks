package admin.positive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.DashboardPage;
import pages.OrdersPage;
import utils.Browser;

public class OrdersPageTests {

    @BeforeMethod
    public void setUp() {
        Browser.open("chrome");
        AdminLoginPage.goTo();
        AdminLoginPage.login("admin", "parola123!");
        DashboardPage.goToOrdersPage();
    }

    @Test
    public void checkIfSelectIsMultiple() {
        OrdersPage.checkIfTheSelectIsMultiple();
    }

    @Test
    public void checkNumberOfElements() {
        OrdersPage.checkTheNumberOfTheElements();
    }

    @Test
    public void checkElementByValue() {
        OrdersPage.checkTheElementByValue("0", "Missing Orders");
    }

    @Test
    public void checkElementByIndex() {
        OrdersPage.checkTheElementByIndex(2, "Canceled");
    }

    @AfterMethod
    public void tearDown() {Browser.quit();}
}
