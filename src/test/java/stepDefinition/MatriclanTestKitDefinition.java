package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import extentReports.ExtentReportData;

import org.json.simple.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilities.BrowserSelect;

public class MatriclanTestKitDefinition extends BrowserSelect {

	// WebDriver driver;
	JSONObject jsonObject;
	ExtentReportData er ;

	// assertion step - common one method -text verify json file

	@Before
	public void setup() {
		er = new ExtentReportData();
		er.startTest();
		
		try {
			FileReader reader = new FileReader(
					"C:\\Users\\Prathmesh.Nayak\\eclipse-workspace\\TestAutomation\\AtkcoProjectAutomation\\src\\test\\java\\utilities\\Config.json");
			JSONParser jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(reader);

			String selectBrowser = (String) jsonObject.get("browser");

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@After
	public void close_browser() {
		
		er = new ExtentReportData();
		er.endTest();

	}

	@Given("I launch the browser and go to the URL")
	public void i_launch_the_browser_and_go_to_the_url() throws Exception, ParseException {

		String selectBrowser = (String) jsonObject.get("browser");
		System.out.println(selectBrowser);
		// Browser select class calling JSON
		driver = BrowserSelect.getDriver(selectBrowser);

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ExtentReportData.test = ExtentReportData.extent.createTest(methodName, "Browser is open");
		ExtentReportData.test.log(Status.PASS, "Test case passed browser Opened");

	}

	@Then("I should see the homepage title")
	public void i_should_see_the_homepage_title_as() {
		try {
			By AcceptCookies = By.xpath((String) jsonObject.get("acceptCookies"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds

			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AcceptCookies));
			driver.findElement(By.xpath((String) jsonObject.get("acceptCookies"))).click();

			String Title = driver.getTitle();
			System.out.println(Title);
			// assertEquals(driver.getTitle(), ((String)jsonObject.get("homePageTitle")));
			System.out.println("Test Passed - Title matched");
			ExtentReportData.test.log(Status.PASS, "Test case passed homepage tittle is there");

		} catch (Exception e) {
			System.out.println("Exception caught title not match " + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed homepage title not matched" + e.getMessage());

		}

	}

	@And("I should see the logo displayed")
	public void i_should_see_the_logo_displayed() {
		try {
			Thread.sleep(2000);
			boolean Logo = driver.findElement(By.xpath((String) jsonObject.get("logo"))).isDisplayed();
			System.out.println(Logo);
			// Logo assertions - assertEquals(driver.getTitle(),
			// ((String)jsonObject.get("homePageTitle")));
			System.out.println("Test Passed - Logo displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Logo displayed");

		} catch (Exception e) {
			System.out.println("Exception caught - Logo not displayed" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Logo not displayed" + e.getMessage());

		}

	}

	@And("I should see the navigation menu")
	public void i_should_see_the_navigation_menu() {
		try {

			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("travelMenu"))).isDisplayed());
			System.out.println("Test passed - Travel menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Travel menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught Travel Menu" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Travel menu is not displayed" + e.getMessage());

		}

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("aboutUs"))).isDisplayed());
			System.out.println("Test passed -  About Us menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - About Us menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught About Us menu is not displaty" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed About Us menu is not displayed" + e.getMessage());

		}

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("learnMenu"))).isDisplayed());
			System.out.println("Test passed -  Learn menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Learn menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught Learn menu is not displaty" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Learn menu is not displayed" + e.getMessage());

		}

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("activateMenu"))).isDisplayed());
			System.out.println("Test passed -  Activate menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Activate menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught Activate menu is not displatyed" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Activate menu is not displayed" + e.getMessage());

		}

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("loginMenu"))).isDisplayed());
			System.out.println("Test passed -  Login menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Login menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught Login menu is not displaty" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Login menu is not displayed" + e.getMessage());

		}

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("toolsMenu"))).isDisplayed());
			System.out.println("Test passed -  Tools menu is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Tools menu is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught Tools menu is not displaty" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Tools menu is not displayed" + e.getMessage());

		}

	}

	@When("I click on the Shop Tests button")
	public void i_click_on_the_button() {
		try {

			driver.findElement(By.xpath(((String) jsonObject.get("shopTestsButton")))).click();
			System.out.println("Test passed - Click to Shop Test menu  ");
			ExtentReportData.test.log(Status.PASS, "Test case passed - Click on Shop Test menu ");

		} catch (Exception e) {
			System.out.println("Exception caught Not able to click on Shop Test menu" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL,
					"Test case failed not able to Click on Shop Test menu " + e.getMessage());

		}

	}

	@When("I am on the Shop Tests page")
	public void i_am_on_the_shop_tests_page() throws FileNotFoundException, IOException, ParseException {

		try {
			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("ancestryDNATestingKits"))).isDisplayed());
			System.out.println("Test passed -  Ancestry DNA Testing Kits title name is displayed");
			ExtentReportData.test.log(Status.PASS,
					"Test case passed - Ancestry DNA Testing Kits title name is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught- Title name  is not displayed " + e.getMessage());
			ExtentReportData.test.log(Status.FAIL,
					"Test case failed Ancestry DNA Testing Kits title name is not displayed " + e.getMessage());

		}

	}

	@And("I should see the test categories displayed")
	public void i_should_see_the_test_categories_displayed() {
		try {
			WebElement priceElement = driver.findElement(By.xpath((String) jsonObject.get("price")));
			String actualPrice = priceElement.getText();
			assertEquals(actualPrice, "Only $299.00");
			System.out.println("Test passed -   price is  displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - price is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught-Price is not display " + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed price is not displayed" + e.getMessage());

		}
	}

	@And("I should see the view more section")
	public void i_should_see_the_view_more_section() {

		try {
			driver.findElement(By.xpath((String) jsonObject.get("viewmore"))).click();
			System.out.println("Test passed -   view more button is clickable");
			ExtentReportData.test.log(Status.PASS, "Test case passed - view more button is clickable");

		} catch (Exception e) {
			System.out.println("Exception caught- Not able to click view more button" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed view more button is clickable" + e.getMessage());

		}
	}

	@When("I should be on the View More page")
	public void i_should_be_on_the_view_more_page() {

		try {
			By africanAncetryStaging = By.xpath((String) jsonObject.get("africanAncetryStaging"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(africanAncetryStaging));

			assertTrue(driver.findElement(By.xpath((String) jsonObject.get("africanAncetryStaging"))).isDisplayed());
			System.out.println("Test passed -   african Ancetry Staging is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed - african Ancetry Staging is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught- african Ancetry Staging is not displayed" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL,
					"Test case failed african Ancetry Staging is not displayed" + e.getMessage());

		}

	}

}
