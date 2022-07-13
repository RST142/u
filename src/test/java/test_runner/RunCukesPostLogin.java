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

@CucumberOptions(features = "classpath:EndUser_PostLogin", plugin = { "pretty", "html:target/cucumber-html-report",
"json:target/cucumber.json" }, glue = { "step_defination" }, tags = { "@Regression,@PostLogin,@UpdateFunctionality,@PostLoginLandingPage,@MobilePushLogin" })

//"json:target/cucumber.json" }, glue = { "step_defination" }, tags = { "@Regression" })
public class RunCukesPostLogin {
 
	public static utilities.Xls_Reader xls;
	String fileSeparator = File.separator;
	public TestNGCucumberRunner testNGCucumberRunner;
	public Setterclass testdata;
	Hooks hock = new Hooks(); 
	public static Object[][] features;
	public static String modulename;

	@BeforeClass
	public void onStart() {
		GlobalUtil.reportfolder = "Post-Login-Verifications";
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		features = testNGCucumberRunner.provideFeatures();

		Date d = new Date();
		HTMLReportUtil.folderName = d.toString().replace(":", "_");

		try {
			File des = new File(System.getProperty("user.dir") + fileSeparator + "ExecutionReports");
			FileUtils.cleanDirectory(des);

	    GlobalUtil.Environment = System.getenv("Environment");

		//GlobalUtil.Environment = "Preprod";

			System.out.println(GlobalUtil.Environment + "printing env");

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
	public Object[][] PostLogin() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Post-Login-Menus-Verification", "PostLoginData");
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] Update() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Update-Phone-Emial-SecurityQuestion", "PostLoginData");
	}
	@org.testng.annotations.DataProvider
	public Object[][] Mydevices() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "MyDevices and Change Password functionality", "PostLoginData");
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] PostLoginLandingPage() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Post-Login-Landing-Page", "PostLoginData");
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] MobilePush() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Mobile-Push-Login-Verification", "PostLoginData");
	}
	
	
	@Test(dataProvider = "MobilePush")
	private void MobilePush(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data.get("URL"));
	//	GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Mobile-Push-Login-Verification")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "PostLogin")) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Mobile-Push-Login-Verification");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}}
		}

	
	@Test(dataProvider = "PostLoginLandingPage")
	private void PostLoginLandingPage(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data.get("URL"));
	//	GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Post-Login-Landing-Page")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "PostLogin")) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("PreLogin-Notifications");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}}
		}
	
	
	@Test(dataProvider = "Update")
	private void Update(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data.get("URL"));
		for (Object[] objects : features) {


			if (objects[0].toString().equals("Update-Phone-Emial-SecurityQuestion")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "PostLogin")) {

				throw new SkipException("Skipping the test as runmode is N");
			}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Update Functionality");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			} }
		}

	@Test(dataProvider = "Mydevices")
	private void Mydevices(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data.get("URL"));
		for (Object[] objects : features) {

				if (objects[0].toString().equals("MyDevices and Change Password functionality")) {
					if (!DataUtil.checkRunnable(objects[0].toString(), xls, "PostLogin")) {
				
						throw new SkipException("Skipping the test as runmode is N");
			}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Update Functionality");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			} }
		}
	@Test(dataProvider = "PostLogin")
	private void PostLogin(Hashtable<String, String> data) throws InterruptedException {
		System.out.println(data.get("URL"));
		for (Object[] objects : features) {
			
			if (objects[0].toString().equals("Post-Login-Menus-Verification")) {
				if (!DataUtil.checkRunnable(objects[0].toString(), xls, "PostLogin")) {
			

				throw new SkipException("Skipping the test as runmode is N");
			}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Post Login");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			} }
		}

		// hock.afterMethodSmoke(sec);
	
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