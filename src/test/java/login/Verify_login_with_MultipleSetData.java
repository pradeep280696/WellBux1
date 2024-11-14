package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import actionInterface.ActionInterface;
import actionInterfaceDefinition.ActionBody;
import base.BaseClass;
import loginData.Login_Test_Data;
import object.LoginPage_object;

public class Verify_login_with_MultipleSetData extends BaseClass {

	@Test(dataProvider = "LoginTestData1", dataProviderClass = Login_Test_Data.class)
	public void Verify_Login_functionality_with_multiple_SetData(String email, String password)
			throws InterruptedException {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.EmailField(email);
		lgn.PasswordField(password);
		lgn.SignIn_button();
		Thread.sleep(2000);

		if (driver.getPageSource().contains("User not found")) {
			System.out.println("This user is not registered with us: " + email);
			Assert.assertTrue(true);
		} else if (driver.getPageSource().contains("Email is invalid")) {
			System.out.println("This user is not registered with us and login not happening: " + email);
			Assert.assertTrue(true);

		}else if(driver.getPageSource().contains("Password does not match."))
		{
			System.out.println("Entered password is incorret for email: "+ email);
			Assert.assertTrue(true);
		}
		else 
		{
			System.out.println("Unknow error for this account: "+ email + "\n" + password);
			Assert.assertFalse(true);
		}
	}

}
