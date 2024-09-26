package com.stepDefenition_MOBILE;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import com.utilities.AppiumDriverUtils;
import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects_MOBILE.CulturalHQ_Login_Page;

public class CulturalHQTest {
	
	AppiumDriver driver;
	AppiumDriverUtils webdriver;
	PropertiesUtils probutils;
	CulturalHQ_Login_Page cHQ;

	@SuppressWarnings("static-access")
	@Given("User launch the CHQ mobile application")
	public void user_launch_the_mobile_application() throws Exception {
		probutils=new PropertiesUtils();
		webdriver = new AppiumDriverUtils();
		driver = webdriver.Driversetup(probutils.Get_Property_input("platformName",ConstantClass.MobileProbName));
		System.out.println("Mobile Application Launched Successfully!");
	}

	@When("User enter valid credentials")
	public void user_add_two_numbers() throws Exception {
		cHQ=new CulturalHQ_Login_Page(driver);
		cHQ.eterCredentials();
	}
	
	@Then("User verify the dashbaord")
	public void user_verify_the_results() {
		cHQ=new CulturalHQ_Login_Page(driver);
		cHQ.verifyHomeIcon();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
}

