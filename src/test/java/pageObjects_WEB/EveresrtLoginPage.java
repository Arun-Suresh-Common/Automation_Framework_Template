package pageObjects_WEB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.CommonUtils;
import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;

public class EveresrtLoginPage{

	WebDriver driver;
	CommonUtils comonutil;
	PropertiesUtils probutils;
	
	@FindBy(id="email")
	WebElement	Login_username;

	@FindBy(id="password")
	WebElement	Login_password;

	@FindBy(xpath="//button[@type=\"submit\" and @value=\"Login\" ]")
	WebElement	Login_button;


	public EveresrtLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		comonutil=new CommonUtils();
		probutils=new PropertiesUtils();
	}

	public void getUrl() throws Exception
	{
		comonutil.geturls(driver, PropertiesUtils.Get_Property_input("Url",ConstantClass.webProbName));
	}

	public void userEnterCredentials() throws Exception
	{
		comonutil.sendKeys(Login_username,PropertiesUtils.Get_Property_input("loginusername",ConstantClass.webProbName));
		comonutil.sendKeys(Login_password,PropertiesUtils.Get_Property_input("password",ConstantClass.webProbName));
	}

	public void userClickLoginBut() throws Exception
	{
		comonutil.click(Login_button);
		Thread.sleep(5000);
		comonutil.click(Login_button);
	}
}

