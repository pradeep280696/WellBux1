package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage_object extends BaseClass{
	
	
	@FindBy(id = "loginUserEmailInput")
	public WebElement EmailFld;
	
	@FindBy(id = "loginUserPwdInput")
	public WebElement PasswordFld;
	
	@FindBy(id = "loginSubmitBtn")
	public WebElement signInBtn;
	
	@FindBy(id = "loginFPLink")
	public WebElement ForgotPasswordLnk;
	
	@FindBy(id = "loginSignupLink")
	public WebElement SignUpLnk;
	
	@FindBy(xpath = "//div[@class='login__right']")
	public WebElement SignIn_title;
	
	@FindBy(id = "checkboxG1")
	public WebElement RememberMe_checkbox;
	
	@FindBy(xpath = "((//div[@class='login__input'])/div)[1]")
	public WebElement Email_ManadatoryValidation_message;
	
	@FindBy(xpath = "((//div[@class='login__input'])/div)[2]")
	public WebElement Password_ManadatoryValidation_message;
	
	@FindBy(xpath = "//div[@aria-label='User not found']")
	public WebElement UserNotFound_message;
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[1]")
	public WebElement PasswordDoesNotMatch_Message;
	
	@FindBy(xpath = "//div[@class='login__input'][1]/div")
	public WebElement Invalid_emailAddress_Message;
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[1]")
	public WebElement LoginSuccessfull_message;
	
	@FindBy(xpath = "//div[@aria-label='Password does not match.']")
	public WebElement InvalidPassword_message;
	
	@FindBy(xpath = "(//div[@class='app__store__btns']/div/a)[1]")
	public WebElement GooglePlay_btn;
	
	@FindBy(xpath = "(//div[@class='app__store__btns']/div/a)[2]")
	public WebElement AppStore_btn;

	
	
	public void Invaliv_emailAddress_validationMessage()
	{
		Invalid_emailAddress_Message.getText();
	}
	
	public void EmailField(String email)
	{
		EmailFld.clear();
		EmailFld.sendKeys(email);
	}
	
	public void PasswordField(String password)
	{
		PasswordFld.clear();
		PasswordFld.sendKeys(password);
	}
	
	public void SignIn_button()
	{
		signInBtn.click();
	}
	
	public void ForgotPassowrd_link()
	{
		ForgotPasswordLnk.click();
	}
	
	public void SignUp_link()
	{
		SignUpLnk.click();
	}
	
	public void RememberMe_checkbox()
	{
		RememberMe_checkbox.click();
	}
	
	public void GooglePlay_button()
	{
		GooglePlay_btn.click();
	}
	
	public void AppStore_button()
	{
		AppStore_btn.click();
	}
	
	public LoginPage_object(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
