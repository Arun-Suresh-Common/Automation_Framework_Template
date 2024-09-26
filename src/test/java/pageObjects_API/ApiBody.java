package pageObjects_API;

import com.utilities.ConstantClass;
import com.utilities.PropertiesUtils;

public class ApiBody 
{
	public static String Base_URL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String USER_ID;
	public static String authtokenbodyrequest;
	public static String addbookbodyrequest;
	public static String bookId="9781449325883";
	PropertiesUtils probutils;
	
	public ApiBody()
	{
		probutils=new PropertiesUtils();
	}
	
	@SuppressWarnings("static-access")
	public String getBaseUrl() throws Exception
	{
		Base_URL=probutils.Get_Property_input("Base_Url",ConstantClass.apiProbName);
		return Base_URL; 
	}

	@SuppressWarnings("static-access")
	public String authtokenbody() throws Exception
	{
		USERNAME=probutils.Get_Property_input("USERNAME",ConstantClass.apiProbName);
		PASSWORD=probutils.Get_Property_input("PASSWORD",ConstantClass.apiProbName);
		authtokenbodyrequest="{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}";
		return authtokenbodyrequest;
	}
	
	@SuppressWarnings("static-access")
	public String addBookBody() throws Exception
	{
		USER_ID=probutils.Get_Property_input("USER_ID",ConstantClass.apiProbName);
		addbookbodyrequest="{ \"userId\": \"" + USER_ID + "\", " +
				"\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}";
		return addbookbodyrequest;
	}
}
