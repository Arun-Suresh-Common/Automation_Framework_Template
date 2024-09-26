package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {
	
	public String geturls(WebDriver driver,String url)
	{
		driver.get(url);
		return url;
	}
	
	public WebElement click(WebElement ele)
	{
		ele.click();
		return ele;
	}

	public WebElement sendKeys(WebElement ele,String value)
	{
		ele.clear();
		ele.sendKeys(value);
		return ele;
	}
	
	public String getText(WebElement ele)
	{
		String value=ele.getText();
		return value;
	}
	
	public boolean isEelementPresent(WebElement ele)
	{
		ele.isDisplayed();
		return true;
	}
}
