package extentReports;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.FileUtil;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentReportData {
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter htmlReporter;
	public static WebDriver driver;
	

	public void startTest() {

		htmlReporter = new ExtentSparkReporter(
				"C:\\Users\\Prathmesh.Nayak\\eclipse-workspace\\TestAutomation\\AtkcoProjectAutomation\\target\\HTMLReports\\HTMLReports.html");
		extent = new ExtentReports();
//		Attach the htmlReporter to the extent object
		extent.attachReporter(htmlReporter);
	}

	public void endTest() {
		if (ExtentReportData.test.getStatus() == Status.FAIL) {
			try {
				TakesScreenshot ss = (TakesScreenshot) driver;
				File source = ss.getScreenshotAs(OutputType.FILE);
				File destination = new File("./ScreenshotFolder/ScreenShot.png");
				FileUtils.copyFile(source, destination);
				String absolutePath = destination.getAbsolutePath();
				ExtentReportData.test.pass("details in form of screen capture -",
						MediaEntityBuilder.createScreenCaptureFromPath(absolutePath).build());

				System.out.println("Successfully captured a screenshot and added to report");

			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

		extent.flush();
		driver.quit();
		System.out.println("after test");
	}
}
