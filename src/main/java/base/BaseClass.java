package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	public Properties prop;
		
	
	@BeforeMethod
	public void launchBrowser(){
		Properties prop = new Properties();
		try {
			FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\GlobalData.properties");
			prop.load(fl);
			
			} catch (IOException e) {
				e.printStackTrace();
			}

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("loginPage_url");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Provided browser name is invalid: " + browserName);
		}
		// driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
