package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	public static String Get_Property_input(String testdata,String probName) throws IOException
	{
		String userdir=System.getProperty("user.dir");
		File file=new File(userdir+"\\src\\test\\resources\\testdata\\"+probName);
		FileInputStream  fin=new FileInputStream(file);
		Properties prob=new Properties();
		prob.load(fin);
		testdata=prob.getProperty(testdata);
		return testdata;
		
		
	}
}
