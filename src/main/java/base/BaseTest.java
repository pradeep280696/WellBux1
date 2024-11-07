package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializerDriver() {
		Properties prop = new Properties();
		FileInputStream fl;
		try {
			fl = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties");
			prop.load(fl);
		} catch (FileNotFoundException e) {
			System.out.println("global file is not available at the iven path");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
