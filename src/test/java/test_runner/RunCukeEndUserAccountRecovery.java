package test_runner;
//import org.testng.annotations.BeforeClasspackage.test_runner;

import java.io.File;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

@CucumberOptions(features = "classpath:EndUser-Configuration", plugin = { "pretty",
		"html:target/cucumber-html-report", "json:target/cucumber.json" },glue= {"step_defination"}, tags = { "@Regression" })

public class RunCukeEndUserAccountRecovery {


	public static utilities.Xls_Reader xls;
	String fileSeparator = File.separator;
	public TestNGCucumberRunner testNGCucumberRunner;
	public Setterclass testdata;
	Hooks hock = new Hooks();
	public static Object[][] features;
	public static String modulename;

	@BeforeClass
	public void onStart() {
		GlobalUtil.reportfolder = "EndUse-AccountConfiguration";
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		features = testNGCucumberRunner.provideFeatures();

		Date d = new Date();
		HTMLReportUtil.folderName = d.toString().replace(":", "_");

		try {
			File des = new File(System.getProperty("user.dir") + fileSeparator + "ExecutionReports");
			System.out.println(des);
			FileUtils.cleanDirectory(des);

		//	GlobalUtil.Environment = System.getenv("Environment");
			GlobalUtil.Environment = "Preprod";
			
			System.out.println(GlobalUtil.Environment + "  printing env");
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

	

	@DataProvider(name="AccountConfig1")
	public Object[][] AccountConfig() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "EndUser Login with AccountRecovery Configuration", "LoginData");
	}

	@Test(dataProvider="AccountConfig1")
	private void Accountconfig(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("EndUser Login with AccountRecovery Configuration")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "Login")) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	

		// hock.afterMethodSmoke(sec);
	}
	@Test(dataProvider = "AccountConfig", dependsOnMethods = "Accountconfig",enabled=false)
	private void Emailconfiguration(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("End-User_Email_Configuration in account")) {
				testdata = new Setterclass();
				testdata.settingdata(data);
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	

		// hock.afterMethodSmoke(sec);
	}
	@Test(dataProvider = "AccountConfig", dependsOnMethods = "Emailconfiguration",enabled=false)
	private void Phoneconfiguration(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("EndUser Phone Configuration in account")) {
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("testing");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	

		// hock.afterMethodSmoke(sec);
	}
	@Test(dataProvider = "AccountConfig", dependsOnMethods = "Phoneconfiguration",enabled=false)
	private void allcombinations(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("EndUser Login with combinations")) {
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("testing");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	

		// hock.afterMethodSmoke(sec);
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
