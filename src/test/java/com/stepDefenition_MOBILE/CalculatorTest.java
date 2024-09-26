package com.stepDefenition_MOBILE;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utilities.AppiumDriverUtils;
import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects_MOBILE.Calculator;

public class CalculatorTest {

	AppiumDriver driver;
	AppiumDriverUtils webdriver;
	PropertiesUtils probutils;
	Calculator calc;

	@SuppressWarnings("static-access")
	@Given("User launch the mobile application")
	public void user_launch_the_mobile_application() throws Exception {
		probutils=new PropertiesUtils();
		webdriver = new AppiumDriverUtils();
		driver = webdriver.Driversetup(probutils.Get_Property_input("platformName",ConstantClass.MobileProbName));
		System.out.println("Mobile Application Launched Successfully!");
	}

	@When("User add two numbers")
	public void user_add_two_numbers() throws Exception {
		calc=new Calculator(driver);
		calc.additionTwo();
	}
	
	@Then("User verify the results")
	public void user_verify_the_results() {
		calc=new Calculator(driver);
		calc.verifyResult();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
}
