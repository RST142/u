package test_runner;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import pojo.Setterclass;
import step_defination.Hooks;
import utilities.ConfigReader;
import utilities.DataUtil;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;
import utilities.Xls_Reader;

@CucumberOptions(features = "classpath:EndUser_ForgotUserName", plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber.json" },glue= {"step_defination"}, tags = { "@regression,@smoke" })

public class RunCukesForgotUserName {

	public static Xls_Reader xls;
	String fileSeparator = File.separator;
	public TestNGCucumberRunner testNGCucumberRunner;
	public Setterclass testdata;
	Hooks hock = new Hooks();
	public static Object[][] features;
	public static String modulename;
	 
	@BeforeClass
	public void onStart() {
		GlobalUtil.reportfolder="EndUser-Forgot-UserName";
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		features = testNGCucumberRunner.provideFeatures();
		

		Date d = new Date();
		HTMLReportUtil.folderName = d.toString().replace(":", "_");
 
		try {
			File des = new File(System.getProperty("user.dir") + fileSeparator+ "ExecutionReports");
			FileUtils.cleanDirectory(des);
			// String fileSeparator = File.separator;
		  GlobalUtil.Environment=System.getenv("Environment");
		 
		
		  xls = new utilities.Xls_Reader(System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator
					+ "test" + fileSeparator + "resources" + fileSeparator + "testData" + fileSeparator
					 + "PreprodTestData.xlsx");

			
			File zipreport = new File(System.getProperty("user.dir") + fileSeparator + "EmailableReport");

			FileUtils.cleanDirectory(zipreport);

			HTMLReportUtil.htmlreportGenerator("Automation_Report.html");
			// Get all the common setting from excel file that are required for
			GlobalUtil.setCommonSettings(ExcelDataUtil.getCommonSettings());

			String browser = "";

			browser = GlobalUtil.getCommonSettings().getBrowser();

			String executionEnv = "";
			executionEnv = GlobalUtil.getCommonSettings().getExecutionEnv();

			String url = "";
			url = GlobalUtil.getCommonSettings().getUrl();

			if (browser == null) {
				browser = ConfigReader.getValue("defaultBrowser");
			}

			if (executionEnv == null) {
				executionEnv = ConfigReader.getValue("defaultExecutionEnvironment");
			}

			if (url == null) {
				url = ConfigReader.getValue("BASE_URL");
				GlobalUtil.getCommonSettings().setUrl(url);
			}
			LogUtil.infoLog(getClass(), " Suite started" + " at " + new Date());

		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.errorLog(getClass(), "Common Settings not properly set may not run the scripts properly");
		}

	}

	@org.testng.annotations.DataProvider
	public Object[][] forgotusername() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "End-User-Forgot-Username","ForgotUserNameData");
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] disablepasswordmanager() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "End-User-Forgot-Username with disable password manager","ForgotUserNameData");
	}
	
	@Test(dataProvider = "forgotusername")
	private void TenantLogin(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("End-User-Forgot-Username")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "ForgotUserName")) {

					throw new SkipException("Skipping the test as runmode is N");
			 }
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("End-User-Forgot-Username");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
		 }}
	}
		@Test(dataProvider = "disablepasswordmanager")
		private void disablepasswordmanger(Hashtable<String, String> data) throws InterruptedException {

			for (Object[] objects : features) {
System.out.println(objects[0].toString());
				if (objects[0].toString().equals("End-User-Forgot-Username with disable password manager")) {
					if (!DataUtil.checkRunnable(objects[0].toString(), xls, "ForgotUserName")) {

						throw new SkipException("Skipping the test as runmode is N");
				 }
					testdata = new Setterclass();
					testdata.settingdata(data);
					System.out.println("End-User-Forgot-Username");
					testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			 }
		}

	}
	
	@AfterClass
	public void onFinish() {

		LogUtil.infoLog(getClass(), " suite finished" + " at " + new Date());
		LogUtil.infoLog(getClass(),
				"\n\n+===========================================================================================================+");

		HTMLReportUtil.extent.flush();

		// RunCukesTest.extent.

		KeywordUtil.onExecutionFinish();

	}

}