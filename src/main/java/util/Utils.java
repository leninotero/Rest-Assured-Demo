package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	private static String PATH_FILE = "./src/main/resources/properties/credentials.properties";
	
	public static Properties getProp() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(PATH_FILE);
		prop.load(file);
		
		return prop;		
	}

}
