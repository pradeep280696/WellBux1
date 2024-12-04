package login;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import actionInterface.ActionInterface;
import actionInterfaceDefinition.ActionBody;
import base.BaseClass;
import object.LoginPage_object;

public class LoginSuccessfull extends BaseClass {
		
	@Test
	public void login() throws InterruptedException
	{
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface dm = new ActionBody();
		lgn.EmailField(dm.globalData1().getProperty("validLogin_email"));
		lgn.PasswordField(dm.globalData1().getProperty("validLogin_password"));
		//lgn.EmailField(prop.getProperty("validLogin_email"));
		//lgn.PasswordField(prop.getProperty("validLogin_password"));
		lgn.SignIn_button();
		Thread.sleep(5000);
	}

}
