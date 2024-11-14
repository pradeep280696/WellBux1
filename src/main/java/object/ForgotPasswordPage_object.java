package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ForgotPasswordPage_object extends BaseClass{
	
	
	@FindBy(xpath = "//div[@class='login__right']/h2")
	public WebElement ForgotPassword_title;
	
	@FindBy(id = "forgotPwdEmailInput")
	public WebElement Email_fld;
	
	@FindBy(id = "forgotPasswordBackBtn")
	public WebElement Back_btn;
	
	@FindBy(id = "forgotPasswordSubmitBtn")
	public WebElement ForgotPassword_btn;
	
	@FindBy(xpath = "//div[@class='login__input']/div")
	public WebElement EmailIsRequired_message;
	
	
	@FindBy(xpath = "//div[@aria-label='user not found']")
	public WebElement UserNotFound_message;
	
	@FindBy(xpath = "//div[@aria-label='OTP has been sent at your registered email']")
	public WebElement OTPSuccessfullySent_message;
	
	public void ForgotPassword_button()
	{
		ForgotPassword_btn.click();
	}
	
	public void Back_button()
	{
		Back_btn.click();
	}
	
	public void EmailField(String email)
	{
		Email_fld.sendKeys(email);
	}
	
	ForgotPasswordPage_object(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

}
