package com.utilities;

import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class AppiumDriverUtils 
{
	AppiumDriver driver;
	PropertiesUtils probutils;

	@SuppressWarnings("static-access")
	public AppiumDriver Driversetup(String platformName) throws Exception
	{
		probutils=new PropertiesUtils();
		if(platformName.equals("Android"))
		{
			UiAutomator2Options options= new UiAutomator2Options();
			options.setPlatformName(platformName);
			options.setDeviceName(probutils.Get_Property_input("DeviceName",ConstantClass.MobileProbName));
			options.setAppPackage(probutils.Get_Property_input("AppPackage",ConstantClass.MobileProbName));
			options.setAppActivity(probutils.Get_Property_input("AppActivity",ConstantClass.MobileProbName));
			driver=new AndroidDriver (new URL(probutils.Get_Property_input("RemoteURL",ConstantClass.MobileProbName)), options);
		}
		else if(platformName.equals("IOS"))
		{
			XCUITestOptions options=new  XCUITestOptions();
			driver=new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		}
		
		return driver;
	}

}
