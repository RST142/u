package utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.DisplayOrder;


public class ExtentManager {
	private static ExtentReports extent;
    public static String  folderName;
	public static ExtentReports getInstance() {
		if (extent == null) {
		//	Date d=new Date();
			String fileName="Report.html";
			Date d = new Date();
    		folderName=d.toString().replace(":", "_");
    		
			new File(System.getProperty("user.dir")+"\\ExecutionReports").mkdirs();
			extent = new ExtentReports();

			
			//extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			//extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
				//	"Environment", "QA");
		}
		return extent;
}}
