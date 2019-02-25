package bg.pragmatic.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleDDT {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://pragmatic.bg/automation/lecture15/bmicalculator.html");
	}

	@DataProvider
	public Object[][] testData() {
		String[][] testData = { 
				{ "160", "45", "17.6", "Underweight" },
				{ "168", "70", "24.8", "Normal" },
				{ "181", "89", "27.2", "Overweight" }, 
				{ "178", "100", "31.6", "Obesity" }
		};
		
		return testData;
	}

	@Test(dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String expectedBmi, String expectedBmiCategory)  {
		// Get the Height element and set the value using parameterised height
		// variable
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);

		// Get the W4eight element and set the value using parameterised Weight
		// variable
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);

		// Click on Calculate Button
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();

		// Get the Bmi element and verify its value using parameterised bmi
		// variable
		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		Assert.assertEquals(bmiLabel.getAttribute("value"), expectedBmi);

		// Get the Bmi Category element and verify its value using parameterised
		// bmiCategory variable
		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		Assert.assertEquals(bmiCategoryLabel.getAttribute("value"), expectedBmiCategory);
	}

	@AfterClass
	public void tearDown()  {
		// Close the browser
		driver.quit();
	}
}
