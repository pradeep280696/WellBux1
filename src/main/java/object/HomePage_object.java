package object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage_object extends BaseClass{
	
	
	@FindBy(id = "menuLoginLink")
	public WebElement LoginIn_link;
	
	@FindBy(id = "menuSignUpLink")
	public WebElement SignUp_link;
	
	@FindBy(id = "menuContactLink")
	public WebElement ContactUs_link;
	
	@FindBy(id = "menusection4Link")
	public WebElement AboutWellBux_lnk;
	
	@FindBy(id = "menusection3Link")
	public WebElement BenifitOfMerchant_lnk;
	
	@FindBy(id = "menusection2Link")
	public WebElement Features_lnk;
	
	@FindBy(id = "menusection1Link")
	public WebElement EarnWellBux_lnk;
	
	public HomePage_object(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
