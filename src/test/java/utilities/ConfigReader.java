
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * This ConfigReader file will read the config file 
 *
 */

public class ConfigReader {
	
	
	private static final String fileSeparator = File.separator;
	/**
	 * will read the properties file with this function
	 * @param filePath
	 * @return
	 */
	private ConfigReader(){
		
	}
	public static Properties loadPropertyFile(String filePath) {
		// Read from properties file
		File file = new File(filePath);
		System.out.println("File path is "+filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			System.out.println("Error in config reader is "+e.getMessage());
			LogUtil.errorLog(ConfigReader.class, "Caught the exception", e);
		}
		return prop;

	}
	/**
	 * will get sting value from properties file
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String filePath = "src"+fileSeparator+"main"+fileSeparator+"resources"+fileSeparator+"Config"+fileSeparator+"config.properties";
		Properties prop = loadPropertyFile(filePath);
		// Open the URL in firefox browser
		 return prop.getProperty(key);
	}
	/**
	 * will get int value from properties file
	 * @param key
	 * @return
	 */
	public static int getIntValue(String key) {
		
		String filePath = "src"+fileSeparator+"main"+fileSeparator+"resources"+fileSeparator+"Config"+fileSeparator+"config.properties";
		Properties prop = loadPropertyFile(filePath);

		// Open the URL in firefox browser
		String strKey = prop.getProperty(key);

		return Integer.parseInt(strKey);
	}

}
