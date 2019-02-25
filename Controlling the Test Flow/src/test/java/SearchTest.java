import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;
import utils.Browser;

public class SearchTest {

    @BeforeMethod
    public void setUp() {
        Browser.open();
    }

    @Test
    public void adminLoginTest() {
        HomePage.goTo();
        HomePage.searchRestaurant("булевард българия 89");

       SearchPage.verifyRestaurant("Сладкарница Стефани", "The restaurant doesn't appear!");
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
