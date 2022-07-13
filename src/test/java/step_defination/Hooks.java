package step_defination;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.StepDefinitionMatch;

import utilities.ConfigReader;
import utilities.DataUtil;
import utilities.DriverUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class Hooks {
	private static final String fileSeparator = File.separator;
	String imagePath;
	String pathForLogger;
	String testCaseDescription;
	public static String featureName;
	public static String FeatureName;

	@Before 
	public void beforeMethod(Scenario scenario) {
		String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
		featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
	
		if (scenario.getName().contains("_")) {
			testCaseDescription = scenario.getName().split("_")[1];
			System.out.println(testCaseDescription);

		} else 
			testCaseDescription = scenario.getName();
			System.out.println(testCaseDescription);
		
		if (!featureName.equals(FeatureName)) {

			HTMLReportUtil.parentloggerr = HTMLReportUtil.extent.createTest(featureName);
			FeatureName = featureName;
		}

		HTMLReportUtil.logger = HTMLReportUtil.parentloggerr.createNode(testCaseDescription+" "+GlobalUtil.scenarioname);
		Collection<String> testCaseType = scenario.getSourceTagNames();
		for (String scenariotype : testCaseType) {
			HTMLReportUtil.logger.assignCategory(scenariotype.replaceAll("@", ""));
		}

		LogUtil.infoLog(getClass(),
				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());

		LogUtil.infoLog("Test Environment",
				"Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog("TestStarted", "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());
		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),
				GlobalUtil.getCommonSettings().getBrowser()));
	}

	@After 
	public void afterMethodSmoke(Scenario scenario) {

		String concatenate = ".";
		String testName = scenario.getName().split("_")[0].trim();
		if (scenario.isFailed()) {
			GlobalUtil.emailflag=true;
			GlobalUtil.emailbody="and below are the failing scenario's of "+GlobalUtil.reportfolder+" module.";
			GlobalUtil.failedtest=GlobalUtil.failedtest+"\n\n"+GlobalUtil.failedcount+". "+testName+" "+GlobalUtil.scenarioname;
		
			GlobalUtil.failedcount=GlobalUtil.failedcount+1;
			HTMLReportUtil.logger.log(Status.FAIL, HTMLReportUtil.failStringRedColor(GlobalUtil.stepname)
					+ HTMLReportUtil.failStringRedColor("  - FAILED"));
			try {
				
				Date d = new Date();
				// String scFileName = d.toString().replace(":", "_").replace(" ", "_") +
				// ".jpg";
				String scFileName = "ScreenShot_" + System.currentTimeMillis();
				String screenshotFilePath = "." + fileSeparator + "ExecutionReports" + fileSeparator + GlobalUtil.reportfolder
						+ HTMLReportUtil.folderName + fileSeparator + scFileName + ".png";

				System.out.println(screenshotFilePath);
				imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);
				System.out.println(imagePath);

				try {
					HTMLReportUtil.logger.log(Status.FAIL,
							GlobalUtil.e.toString().split("WARNING")[0] + "\n" + "Screenshot :-  ",
							MediaEntityBuilder.createScreenCaptureFromPath(concatenate + "./"+ GlobalUtil.reportfolder
									+ HTMLReportUtil.folderName + "/" + scFileName + ".png").build());

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				scenario.write("Current Page URL is " + GlobalUtil.getDriver().getCurrentUrl());

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			GlobalUtil.scenarioname="";
			LogUtil.infoLog("TestEnded",
					"Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());

		}

		// close the browsers
		DriverUtil.closeAllDriver();

	}

}