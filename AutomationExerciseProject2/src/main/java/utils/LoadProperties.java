package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {
	static Properties prop = new Properties();
	static String PropFilePath = System.getProperty("user.dir")+"\\Properties\\config.properties";

	public static String getProperty(String key) {
		try {
			FileInputStream fis = new FileInputStream(PropFilePath);
			prop.load(fis);
		}catch (Exception e) {
			System.out.println("The path doesnt exist!!Please check...");
		}
		return prop.getProperty(key);
	}
}