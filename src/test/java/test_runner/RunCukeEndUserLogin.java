package test_runner;

import java.io.File;

import java.util.Date;
import java.util.Hashtable;


import org.apache.commons.io.FileUtils;


import org.testng.SkipException;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

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
import utilities.Xls_Reader;

@CucumberOptions(features = "classpath:endUser", plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber.json" }, glue= {"step_defination"},tags = {"@Smoke,@Regression" })
public class RunCukeEndUserLogin {
	public static Xls_Reader xls;
	String fileSeparator = File.separator;
	public TestNGCucumberRunner testNGCucumberRunner;
	public Setterclass testdata;
	Hooks hock = new Hooks();
	public static Object[][] features;
	public static String modulename;

	@BeforeClass 
	public void onStart() {
		GlobalUtil.reportfolder = "End-User-Login";
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		features = testNGCucumberRunner.provideFeatures();
		
		Date d = new Date();
		HTMLReportUtil.folderName = d.toString().replace(":", "_");

		try {
			File des = new File(System.getProperty("user.dir") + fileSeparator + "ExecutionReports");
		//	FileUtils.cleanDirectory(des);
			// String fileSeparator = File.separator;
			//GlobalUtil.Environment = System.getenv("Environment");
			GlobalUtil.Environment ="Preprod";
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
	public Object[][] Security() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Security-Questions", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] emailsecurity() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Email-Security", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] phonesecurity() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Phone", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] withoutMFA() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-MFA", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithRC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-RC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCOCRC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCOCRC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCRCOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCRCOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithRCOCOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-RCOCOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCDOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCDOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithONC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-ONC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithRNC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-RNC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithoutAnyconfiguration() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Any-Account-Recovery-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginWithEmailOrPhone() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Email-Or-Phone", "LoginData");
	}

	// Data driven changes
	@org.testng.annotations.DataProvider
	public Object[][] LoginwithFourinone() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Security-Email-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] Loginwithoutphoneandemail() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Email-And-Phone-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithNASecurity() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Scenarios-With-Disable-Security-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] Loginwithoutsecurityandphone() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Security-And-Phone-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithNARCRC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-NARCRC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginWithoutSecurityQuestion() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Security-Question", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithONCOCRC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-ONCOCRC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithONCRCOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-ONCRCOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] Logindisablephone() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Scenarios-With-Disable-Phone-Configuration", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] Logindisableemail() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Disable-Email-In-Policy", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCNCOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCNCOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCONCRC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCONCRC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithRCONCOC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-RCONCOC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginWithoutPhone() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-Without-Phone", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithOCRCONC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-OCRCONC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithRCOCONC() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-RCOCONC", "LoginData");
	}

	@org.testng.annotations.DataProvider
	public Object[][] LoginwithNAcombination() {
		// super.init();

		return utilities.DataUtil.getTestData(xls, "Login-With-Disabled-Security-And-Optional-Configuration",
				"LoginData");
	}

	@Test(dataProvider = "LoginwithNAcombination")
	private void TenantLoginwithdisablesecurity(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Disabled-Security-And-Optional-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "Logindisableemail")
	private void TenantLoginwithdisableemail(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Disable-Email-In-Policy")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "Logindisablephone")
	private void TenantLoginwithdisablephone(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Scenarios-With-Disable-Phone-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "LoginwithNARCRC")
	private void TenantLoginwithNARCRC(Hashtable<String, String> data) throws InterruptedException {
		
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-NARCRC")) {
				GlobalUtil.scenarioname = "";
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "Loginwithoutsecurityandphone")
	private void TenantLoginwithoutanyconfiguration(Hashtable<String, String> data) throws InterruptedException {
		GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Any-Account-Recovery-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "Loginwithoutsecurityandphone")
	private void TenantLoginwithoutsecurityandphone(Hashtable<String, String> data) throws InterruptedException {
		GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Security-And-Phone-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "LoginwithNASecurity")
	private void TenantLoginwithNASecurity(Hashtable<String, String> data) throws InterruptedException {
		GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Scenarios-With-Disable-Security-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "Loginwithoutphoneandemail")
	private void TenantLoginwithemailandphone(Hashtable<String, String> data) throws InterruptedException {
		GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Email-And-Phone-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "LoginwithFourinone")
	private void TenantLoginfourin(Hashtable<String, String> data) throws InterruptedException {
		GlobalUtil.scenarioname = data.get("CombinationName");
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Security-Email-Configuration")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "Security")
	private void TenantLogin(Hashtable<String, String> data) throws InterruptedException {
		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Security-Questions")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

		// hock.afterMethodSmoke(sec);
	}

	@Test(dataProvider = "emailsecurity")
	private void EndUserLoginwithEmail(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Email-Security")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "phonesecurity")
	private void EndUserLoginwithPhone(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Phone")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "withoutMFA")
	private void EndUserLoginwitoutMFA(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-MFA")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithOC")
	private void loginwithoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithRC")
	private void loginwithrc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-RC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithOCOCRC")
	private void loginwithococrc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCOCRC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithOCRCOC")
	private void loginwithocrcoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCRCOC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithRCOCOC")
	private void loginwithrcococ(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-RCOCOC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithOCDOC")
	private void loginwithocdoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCDOC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);

				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithONC")
	private void loginwithonc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-ONC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-ONC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithRNC")
	private void loginwithrnc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-RNC")) {
				GlobalUtil.scenarioname = data.get("CombinationName");
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-RNC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginWithEmailOrPhone")
	private void loginwithoncoconc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-Email-Or-Phone")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginWithoutSecurityQuestion")
	private void LoginWithoutSecurityQuestion(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Security-Question")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithONCOCRC")
	private void loginwithoncocrc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-ONCOCRC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-ONCOCRC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "LoginwithONCRCOC")
	private void loginwithoncrcoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-ONCRCOC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-ONCRCOC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "LoginwithOCNCOC")
	private void loginwithocncoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCNCOC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-OCNCOC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "LoginwithOCONCRC")
	private void loginwithoconcrc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCONCRC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-OCONCRC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "LoginwithRCONCOC")
	private void loginwithrconcoc(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-RCONCOC")) {
				GlobalUtil.scenarioname = "";
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-RCONCOC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}
	}

	@Test(dataProvider = "LoginWithoutPhone")
	private void LoginWithoutPhone(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-Without-Phone")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("LoginWithoutPhone");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithOCRCONC")
	private void loginwithOCRCONC(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-OCRCONC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("OCRCONC");
				testNGCucumberRunner.runCucumber(((CucumberFeatureWrapper) objects[0]).getCucumberFeature());
			}
		}

	}

	@Test(dataProvider = "LoginwithRCOCONC")
	private void loginwithRCOCONC(Hashtable<String, String> data) throws InterruptedException {

		for (Object[] objects : features) {

			if (objects[0].toString().equals("Login-With-RCOCONC")) {
				if (!DataUtil.isRunnable(objects[0].toString(), xls)) {

					throw new SkipException("Skipping the test as runmode is N");
				}
				testdata = new Setterclass();
				testdata.settingdata(data);
				System.out.println("Login-With-RCOCONC");
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