package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriderUtil {

	WebDriver driver;
	public WebDriver Driversetup(String browser)
	{
		
		String userdir=System.getProperty("user.dir");
			if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", userdir+"\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browser.equals("Firefox")) {
				System.setProperty("webdriver.firefox.driver", userdir+"\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
		return driver;
	}

	public WebDriver closeDriver()
	{
		driver.quit();;
		return driver;
	}
}
