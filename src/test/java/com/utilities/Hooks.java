package com.utilities;

import org.junit.Before;

public class Hooks 
{
	@Before
	public static void driverInit() throws Exception
	{
		System.out.println("Before Hooks***********");
	}
	

}
