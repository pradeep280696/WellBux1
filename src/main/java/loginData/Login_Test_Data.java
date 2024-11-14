package loginData;

import org.testng.annotations.DataProvider;

public class Login_Test_Data {

	@DataProvider(name= "LoginTestData1")
	public Object[][] LoginTestData()
	{
		Object[][] loginDATA = {{"akash2806", "Admin@123"},
				{"akash2806@gmail", "Admin@123"},
				{"ian2547@mailinator.com", "Admin@564684964964798"},
				{"ian2547@mailinator.com", "1234567"}};
		return loginDATA;
	}
	
}
