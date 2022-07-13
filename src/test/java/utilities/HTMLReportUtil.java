package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HTMLReportUtil {

	public static ExtentReports extent;
	public static ExtentTest parentloggerr;
	public static ExtentTest logger;
	public static String folderName;
	public static ExtentHtmlReporter htmlReporter;
	public static String stepname;
	public static String html;
	static String fileSeparator = File.separator;
	public static String testFailTakeScreenshot(String imagePath) throws IOException {

		File src = ((TakesScreenshot) GlobalUtil.getDriver()).getScreenshotAs(OutputType.FILE);

		 File des = new File(System.getProperty("user.dir") +
		 "/FailedScreenshots/"  + ".jpeg");
		//File des = new File(imagePath); 

		FileUtils.copyFile(src, des);

		// System.out.println(des.getAbsolutePath());
		// System.out.println(des.getCanonicalFile());
		

		return imagePath;

		// return des.toString();
	}
	
	
	public static void htmlreportGenerator(String name)
	{
		HTMLReportUtil.htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + fileSeparator + "ExecutionReports" + fileSeparator + GlobalUtil.reportfolder
						+ HTMLReportUtil.folderName + fileSeparator + name);
		System.out.println("html report created");
		HTMLReportUtil.htmlReporter.config().setTheme(Theme.DARK);
		HTMLReportUtil.htmlReporter.config().setDocumentTitle("QuickLaunch_Automation_Report");
		HTMLReportUtil.htmlReporter.config().setEncoding("utf-8");
		HTMLReportUtil.htmlReporter.config().setReportName("QuickLaunchReport");

		HTMLReportUtil.htmlReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");
		HTMLReportUtil.extent = new ExtentReports();
		String css = ".r-img {width: 50%;}";
		HTMLReportUtil.htmlReporter.config().setCSS(css);
		HTMLReportUtil.extent.attachReporter(HTMLReportUtil.htmlReporter);
		HTMLReportUtil.extent.flush();

		String nameOS = "os.name";
		String versionOS = "os.version";
		String architectureOS = "os.arch";

		nameOS = System.getProperty(nameOS);
		versionOS = System.getProperty(versionOS);
		architectureOS = System.getProperty(architectureOS);

		HTMLReportUtil.extent.setSystemInfo(nameOS, "Executed By :-" + System.getProperty("user.name"));
		HTMLReportUtil.extent.setSystemInfo("Release version", "8.1");
	}
	

	public static String failStringRedColor(String stepName) {
		html = "<span style='color:red'><b>" + stepName + "</b></span>";
		return html;
	}

	public static String passStringGreenColor(String stepName) {
		html = "<span style='color:#008000'><b>" + stepName + " - PASSED" + "</b></span>";
		return html;
	}

}
