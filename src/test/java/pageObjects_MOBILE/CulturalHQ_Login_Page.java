package pageObjects_MOBILE;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.CommonUtils;
import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;

import io.appium.java_client.AppiumDriver;

public class CulturalHQ_Login_Page {
	
	AppiumDriver driver;
	CommonUtils comonutil;
	PropertiesUtils probutils;
	
	@FindBy(xpath="//android.widget.EditText")
	WebElement	inputText;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"SUBMIT\"]")
	WebElement	submit;
	
	@FindBy(xpath="//android.widget.Button")
	WebElement	signIn;
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\"ForYouUserActivities, tab, 1 of 5\"]/android.widget.ImageView")
	WebElement	homeIcon;

	public CulturalHQ_Login_Page(AppiumDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		comonutil=new CommonUtils();
	}
	
	@SuppressWarnings("static-access")
	public void eterCredentials() throws Exception
	{
		Thread.sleep(2000);
		comonutil.sendKeys(inputText,probutils.Get_Property_input("Username",ConstantClass.MobileProbName));
		comonutil.click(submit);
		Thread.sleep(5000);
		comonutil.sendKeys(inputText,probutils.Get_Property_input("password",ConstantClass.MobileProbName));
		Thread.sleep(5000);
		comonutil.click(signIn);
		Thread.sleep(5000);
	}
	
	public void verifyHomeIcon()
	{
		comonutil.isEelementPresent(homeIcon);
		
	}

}
