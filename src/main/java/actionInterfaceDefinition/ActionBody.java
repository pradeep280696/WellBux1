package actionInterfaceDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import actionInterface.ActionInterface;
import base.BaseClass;

public class ActionBody extends BaseClass implements ActionInterface{
	
	@Override
	public Properties globalData1() {
		
			Properties prop = new Properties();
			try {
				FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalData.properties");
				prop.load(fl);
				
				} catch (IOException e) {
				}
			return prop;
	}

	@Override
	public void PageComplete_loaded() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("return document.readyState").toString().equals("complete");
	}
	
	
}
