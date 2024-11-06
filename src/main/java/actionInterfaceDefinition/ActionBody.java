package actionInterfaceDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import actionInterface.ActionInterface;
import base.BaseClass;

public class ActionBody extends BaseClass implements ActionInterface{

	@Override
	public Properties globalData1() {
		
			Properties prop = new Properties();
			try {
				FileInputStream fl = new FileInputStream(
						"C:\\Selenium\\WellBux1\\src\\main\\resources\\GlobalData.properties");
				prop.load(fl);
				
				} catch (IOException e) {
				}
			return prop;
	}
	
}
