package com.stepDefenition_WEB;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;
import com.utilities.WebdriderUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects_WEB.EveresrtLoginPage;

public class EverestLoginTest{

	WebDriver driver;
	WebdriderUtil webdriver;
	EveresrtLoginPage everesrtLoginPage;
	PropertiesUtils probutils;

	@SuppressWarnings("static-access")
	@Before
	public void LaunchBrowser() throws Exception
	{
		probutils = new PropertiesUtils();
		webdriver = new WebdriderUtil();
		driver = webdriver.Driversetup(probutils.Get_Property_input("Browser",ConstantClass.webProbName));
	}
	
	@Given("User lauch the everest application")
	public void user_lauch_the_everest_application() throws Exception {
		
		everesrtLoginPage = new EveresrtLoginPage(driver);
		everesrtLoginPage.getUrl();
	}

	@When("User login with valid username and password")
	public void user_enter_the_valid_username_and_password() throws Exception {

		everesrtLoginPage.userEnterCredentials();
		everesrtLoginPage.userClickLoginBut();
	}

	@After
	public void close_the_browser() {
		webdriver.closeDriver();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
}
