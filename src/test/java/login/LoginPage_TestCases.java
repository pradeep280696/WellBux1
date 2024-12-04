package login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import actionInterface.ActionInterface;
import actionInterfaceDefinition.ActionBody;
import base.BaseClass;
import object.LoginPage_object;

public class LoginPage_TestCases extends BaseClass {

	
	@Test(priority = 1)
	public void Verify_ManadatoryField_validationMessage() {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();
		lgn.SignIn_button();

		String EmailField_ManadatoryMessage = act.globalData1().getProperty("EmailField_required");
		String PasswordField_MandatoryMessage = act.globalData1().getProperty("PasswordField_required");

		AssertJUnit.assertEquals(EmailField_ManadatoryMessage, lgn.Email_ManadatoryValidation_message.getText());
		AssertJUnit.assertEquals(PasswordField_MandatoryMessage, lgn.Password_ManadatoryValidation_message.getText());
		System.out.println("Validation message is visible on both Email and Password field");
	}

	@Test(priority = 2)
	public void Verify_Login_With_InvalidEmailAddress() {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.EmailField(act.globalData1().getProperty("Invalid_EmailAddress1"));
		lgn.PasswordField(act.globalData1().getProperty("validLogin_password"));
		lgn.SignIn_button();

		String invalidEmailAddress_ValidionMessage = act.globalData1().getProperty("Ivalid_EmailAddress_Message");
		AssertJUnit.assertEquals(invalidEmailAddress_ValidionMessage, lgn.Invalid_emailAddress_Message.getText());
		AssertJUnit.assertEquals(act.globalData1().getProperty("loginPage_url"), driver.getCurrentUrl());
		System.out.println("Login not happening on invalid email address: "
				+ act.globalData1().getProperty("Invalid_EmailAddress1"));
	}

	@Test(priority = 3)
	public void Verify_login_with_Non_RegisteredEmailAddress() throws InterruptedException {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.EmailField(act.globalData1().getProperty("Non_registered_EmailAddress"));
		lgn.PasswordField(act.globalData1().getProperty("validLogin_password"));
		lgn.SignIn_button();
		Thread.sleep(2000);

		String UserNotFound_Message = act.globalData1().getProperty("UserNotFound_Message");
		AssertJUnit.assertEquals(UserNotFound_Message, lgn.UserNotFound_message.getText());
		AssertJUnit.assertEquals(act.globalData1().getProperty("loginPage_url"), driver.getCurrentUrl());
		System.out.println("Login not happening on valids Non-registered email address: "
				+ act.globalData1().getProperty("Non_registered_EmailAddress"));
		System.out.println(lgn.UserNotFound_message.getText());
	}

	@Test(priority = 4)
	public void Verify_Login_With_Valid_EmailAddress_Invalid_Password() {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.EmailField(act.globalData1().getProperty("validLogin_email"));
		lgn.PasswordField(act.globalData1().getProperty("Invalid_Passowrd"));
		lgn.SignIn_button();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String PasswordDoesNotMatch_Message = act.globalData1().getProperty("PasswordDoesNotMatch_Message");
		AssertJUnit.assertEquals(PasswordDoesNotMatch_Message, lgn.PasswordDoesNotMatch_Message.getText());
		AssertJUnit.assertEquals(act.globalData1().getProperty("loginPage_url"), driver.getCurrentUrl());
		System.out.println("Login not happening on invalid password");
	}

	@Test(priority = 5)
	public void Verify_Login_with_valid_Credential() throws InterruptedException {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.EmailField(act.globalData1().getProperty("validLogin_email"));
		lgn.PasswordField(act.globalData1().getProperty("validLogin_password"));
		lgn.SignIn_button();
		Thread.sleep(2000);

		String Successful_Login_message = act.globalData1().getProperty("LoginSuccessfull_Message");
		AssertJUnit.assertEquals(lgn.LoginSuccessfull_message.getText(), Successful_Login_message);
		System.out.println("Login successful on valid credential");
	}

	@Test(priority = 6)
	public void Verify_SignUp_link_on_LoginPage() {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.SignUp_link();

		AssertJUnit.assertEquals(driver.getCurrentUrl(), act.globalData1().getProperty("SignupPage_url"));
		System.out.println("User is rediecting on the signup page after clicking on the Sign up link");
	}

	@Test(priority = 7)
	public void Verify_ForgotPassword_Link_on_LoginPage() {
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();

		lgn.ForgotPassowrd_link();

		if (driver.getPageSource().contains("Forgot password")) {
			AssertJUnit.assertTrue(true);
		} else {
			AssertJUnit.assertTrue(false);
		}
	} 
	
	@Test
	public void Verify_GooglePlay_button_on_LoginPage()
	{
		LoginPage_object lgn = new LoginPage_object(driver);
		ActionInterface act = new ActionBody();
		
		lgn.GooglePlay_btn.isEnabled();
		lgn.GooglePlay_button();
		act.PageComplete_loaded();
		
		System.out.println(driver.getCurrentUrl());

	}

}
