package pageObjects_MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;

public class Calculator {
	AppiumDriver driver;
	CommonUtils comonutil;
	
	@FindBy(id="com.google.android.calculator:id/digit_5")
	WebElement	Digit_5;
	
	@FindBy(id="com.google.android.calculator:id/digit_8")
	WebElement	Digit_8;
	
	@FindBy(id="com.google.android.calculator:id/op_add")
	WebElement	Add;
	
	@FindBy(id="com.google.android.calculator:id/result_preview")
	WebElement	results;

	public Calculator(AppiumDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		comonutil=new CommonUtils();
	}
	
	public void additionTwo() throws Exception
	{
		comonutil.click(Digit_5);
		Thread.sleep(2000);
		comonutil.click(Add);
		Thread.sleep(2000);
		comonutil.click(Digit_8);
		Thread.sleep(2000);
	}
	
	public void verifyResult()
	{
		String value=comonutil.getText(results);
		System.out.println(value);
	}


}
