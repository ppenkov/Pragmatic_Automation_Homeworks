package bg.pragmatic.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTestData {
	
	private WebDriver driver;
	
	@DataProvider
    public static Object[][] testData() throws IOException, InvalidFormatException {
        InputStream spreadsheet = new FileInputStream("C:\\Users\\Georgi\\OneDrive\\01Kursove - Pragmatic\\Automation QA Course\\Georgi Tsvetanov Automation Course\\Selenium Module TNG\\Lecture 8\\Files in use\\Data.xlsx");
		return new SpreadsheetData(spreadsheet).getData();
    }
	
	@BeforeClass
	public void setUp() throws Exception { 
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://pragmatic.bg/automation/lecture15/bmicalculator.html");
	}

	@Test(dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String expectedBmi, String expectedBmiCategory, String expectedValidationMessage) throws Exception {
				WebElement heightField = driver.findElement(By.name("heightCMS"));
				heightField.clear();
				if (!height.equals("<Blank>"))
					heightField.sendKeys(height);
				
				WebElement weightField = driver.findElement(By.name("weightKg"));
				weightField.clear();
				if(!weight.equals("<Blank>"))
					weightField.sendKeys(weight);
		
				WebElement calculateButton = driver.findElement(By.id("Calculate"));
				calculateButton.click();
			
				if (expectedValidationMessage.equals("<Blank>")) {
					WebElement bmiField = driver.findElement(By.name("bmi"));
					Assert.assertEquals(bmiField.getAttribute("value"), expectedBmi);
					
					WebElement bmiCategoryField = driver.findElement(By.name("bmi_category"));
					Assert.assertEquals(bmiCategoryField.getAttribute("value"),expectedBmiCategory);
				}
				else {
					WebElement errorLabel = driver.findElement(By.id("error"));
					Assert.assertEquals(errorLabel.getText(), expectedValidationMessage);
				}
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		//Close the browser
		driver.quit();
	}
}
