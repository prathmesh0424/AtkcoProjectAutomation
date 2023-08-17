package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;

import extentReports.ExtentReportData;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import utilities.BrowserSelect;

public class ApparelAndGiftsDefinition extends BrowserSelect {

	JSONObject jsonObject;

	@And("I should see the Promo Code box")
	public void i_should_see_the_promo_code_box() throws IOException, ParseException {

		try {
			assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'BHM23')]")).isDisplayed());
			System.out.println("Test passed -  promocode section is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed promocode section is displayed");

		} catch (Exception e) {
			System.out.println("Exception failed- promocode section is not displayed " + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed promocode section is not displayed" + e.getMessage());


		}
	}

	@And("I click on the Appreal and Gifts section")
	public void i_click_on_the_appreal_and_gifts_section() {

		try {
			driver.findElement(By.xpath("(//*[contains(text(), 'Apparel and Gifts')])[1]")).click();
			System.out.println("Test passed - Apparel and Gifts is clickabled ");
			ExtentReportData.test.log(Status.PASS, "Test case passed Apparel and Gifts is clickabled ");

		} catch (Exception e) {
			System.out.println("Exception caught- Not able to click ApparelandGifts" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed Apparel and Gifts is not clickabled " + e.getMessage());

		}

	}

	@And("I should see the T Shirt image section displayed")
	public void i_should_see_the_t_shirt_image_section_displayed() {

		try {
			By imageLoadWait = By.xpath("//img[contains(@src, 'AALogoLifestyleAASHOOT-43.jpg')]");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Maximum wait time of 10 seconds

			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(imageLoadWait));
			// driver.findElement(By.xpath((String)
			// jsonObject.get("imageLoadWait"))).isDisplayed();

			assertTrue(driver.findElement(By.xpath("//img[contains(@src, 'AALogoLifestyleAASHOOT-43.jpg')]"))
					.isDisplayed());

			System.out.println("Test Passed - African Ancestry Tee image displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed African Ancestry Tee image displayed");

		} catch (Exception e) {
			System.out.println("Exception caught - African Ancestry Tee image is not displayed" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed African Ancestry Tee image not displayed" + e.getMessage());

		}
	}

	@Then("I should see the name and pricing displayed")
	public void i_should_see_the_name_and_pricing_displayed() {
		try {

			assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'African Ancestry Tee')]")).isDisplayed());
			System.out.println("Test passed -   African Ancestry Tee text is displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed African Ancestry Tee text is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught- african Ancetry Tee text is not displayed" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed African Ancestry Tee text is not displayed" + e.getMessage());

		}

		try {
			WebElement priceteeElement = driver.findElement(By.xpath("//div[contains(@class, 'ProdPricetext')][1]"));
			String actualPrice = priceteeElement.getText();
			assertEquals(actualPrice, "Only $30.00", "Price does not match");
			System.out.println("Test passed -   price is  displayed");
			ExtentReportData.test.log(Status.PASS, "Test case passed price is displayed");

		} catch (Exception e) {
			System.out.println("Exception caught-Price is not displayed " + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed price is not displayed" + e.getMessage());

		}

	}

	@When("I click on the View More button")
	public void i_click_on_the_view_more_button() {

		try {
			driver.findElement(By.xpath("//a[contains(@class, 'ViewMorelinks') and contains(text(), 'View More')][1]"))
					.click();
			System.out.println("Test passed -   view more tee button is clicked");
			ExtentReportData.test.log(Status.PASS, "Test case passed view more tee button is clicked");

		} catch (Exception e) {
			System.out.println("Exception caught- Not able to click on view more tee button" + e.getMessage());
			ExtentReportData.test.log(Status.FAIL, "Test case failed view more tee button is not clicked" + e.getMessage());

		}
	}

	@Then("I should see the T Shirt Details Page")
	public void i_should_see_the_t_shirt_details_page() {

		try {
			assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Details')]")).isDisplayed());
			System.out.println("Test case passed- African Ancestry T shirt Details text is matched");
			ExtentReportData.test.log(Status.PASS, "Test case passed - African Ancestry T shirt Details text is matched");


		} catch (Exception e) {
			System.out.println("Exception caught - African Ancestry T shirt Details text is matched  ");
			ExtentReportData.test.log(Status.FAIL, "Test case failed - African Ancestry T shirt Details text is matched" + e.getMessage());

		}
	}

}
