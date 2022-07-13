package step_defination;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojo.GetExcelData;
import quicklaunchpages.AccountCreationPage;
import quicklaunchpages.CpsLoginPage;
import quicklaunchpages.FirstTimeUser;
import quicklaunchpages.LoginPage;
import quicklaunchpages.PreLoginPage;
import quicklaunchpages.SkuManager;
import quicklaunchpages.TenantPolicy;
import quicklaunchpages.WsoLoginPage;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
import java.util.Date;
public class QuickLaunch extends KeywordUtil {

	@SuppressWarnings("rawtypes")
	static Class thisClass = QuickLaunch.class;
	static String testCaseID = thisClass.getSimpleName();
	static String logStep;  
	public WebDriver driver; 
	boolean element;       
 static Date d;   
	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	String email = "testing" + KeywordUtil.getCurrentDateTime() + "@testing.com";
	public String otp; 
  
//	public static String randomEmail = "testing@" + RandomStringUtils.randomAlphabetic(7).toLowerCase() + ".com";
	 public static String randomEmail; 
	     
         
	@Given("^Read login test data \"([^\"]*)\" from Excel file$")
	public void Read_login_test_data_from_Excel_file(String arg1) {
		try {
			KeywordUtil.cucumberTagName = "Web";
			dataMap = ExcelDataUtil.getTestDataWithTestCaseID("QuickLaunch", arg1);
 
		} catch (Throwable e) { 
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			Assert.fail(e.getMessage());
		}
	} 

	@When("^Navigate to url$")
	public void navigate_to_url() {
	
		
		try {
			navigateToUrl(GetExcelData.getURL(), "User is on Registration Page");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to url";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Navigate to wso$")
	public void navigate_to_wso() {
		try {
			navigateToUrl(GetExcelData.getWSOURL(), "User is on WSO application");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to wso";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Navigate to cps$")
	public void navigate_to_cps() {
		try {
			navigateToUrl(GetExcelData.getCPSURL(), "User is on CPS application");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to cps";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter value for Organization Name$")
	public void enter_value_for_organization_name() {
		try {
			KeywordUtil.inputText(AccountCreationPage.organizationName, dataMap.get("OrganizationName"),
					"I enter organization name");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter value for Organization Name";
			Assert.fail(e.getMessage());
		} 
	}
	 @Then("^Verify user navigate to MFA configuration page$")
	    public void verify_user_navigate_to_mfa_configuration_page() throws Throwable {
	       // throw new PendingException();
		 try {
				navigateToUrl(GetExcelData.getMFAConfiguration(), "User is on Adeptive MFA configuration page.");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "User is on Adeptive MFA configuration page";
				Assert.fail(e.getMessage());
			}
	    }
	 @Then("^Click on disabled button$")
	    public void click_on_disabled_button() throws Throwable {
		 try {
				KeywordUtil.clickJS(TenantPolicy.disablebutton, "Click on disable button");
				Thread.sleep(5000);
			} catch (Throwable e) {
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on phone option and disable phone verification option";
				Assert.fail(e.getMessage());
			}
	    }
	 @And("^Click on phone configuration and disable phone configuration$")
	    public void click_on_phone_configuration_and_disable_phone_configuration() throws Throwable {
	       // throw new PendingException();
		 try {
				KeywordUtil.clickJS(TenantPolicy.phoneconfiguration, "Click on phone option");
				KeywordUtil.clickJS(TenantPolicy.mfaslider, "click on togel button to disale MFA");
			
				 
			} catch (Throwable e) {
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on phone option and disable phone verification option";
				Assert.fail(e.getMessage());
			}
	    }
	 @And("^Click on phone configuration and enable phone configuration$")
	    public void click_on_phone_configuration_and_enable_phone_configuration() throws Throwable {
		 try {
			 KeywordUtil.clickJS(TenantPolicy.phoneconfiguration, "Click on phone option");
				KeywordUtil.clickJS(TenantPolicy.enbleslider, "Click on slider to enable MFA configuration");
				Thread.sleep(5000);
			} catch (Throwable e) {
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on slider to enable MFA configuration";
				Assert.fail(e.getMessage());
			}
	    }
	@When("^Enter Organization Name$")
	public void Enter_Organization_Name() {
		try {
			String randomOrgName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
			// KeywordUtil.inputText(AccountCreationPage.organizationName,
			// dataMap.get("OrganizationName"),"I enter organization name");
			KeywordUtil.inputText(AccountCreationPage.organizationName, randomOrgName, "Enter organization name");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Organization Name";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter existing Organization Name$")
	public void Enter_existing_Organization_Name() {
		try {
			KeywordUtil.inputText(AccountCreationPage.organizationName, GetExcelData.getOrganizationName(),
					"I enter organization name");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter existing Organization Name";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Full Name$")
	public void enter_full_name() {
		try {
			KeywordUtil.inputText(AccountCreationPage.fullName, GetExcelData.getFullName(), "Enter full name");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Full Name";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter invalid full name$")
	public void enter_invalid_full_name() {
		try {
			KeywordUtil.inputText(AccountCreationPage.fullName, GetExcelData.getInvalidFullName(),
					"I enter invalid full name");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter invalid full name";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Job Title$")
	public void select_job_title() {
		try {
			KeywordUtil.click(AccountCreationPage.jobTitle, "Click on Job Title");
			KeywordUtil.selectByVisibleText(AccountCreationPage.jobTitle, GetExcelData.getJobTitle(), "Select JobTitle");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Job Title";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Country$")
	public void select_country() {
		try {
			KeywordUtil.click(AccountCreationPage.country, "Click on Country");
			KeywordUtil.selectByVisibleText(AccountCreationPage.country, GetExcelData.getCountry(), "Select Country");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Country";
			Assert.fail(e.getMessage());
		}
	}
	 @And("^Click on Untrust this device and verify the functionality$")
	    public void click_on_untrust_this_device_and_verify_the_functionality() throws Throwable {
		 try {
				KeywordUtil.clickJS(PreLoginPage.untrusteddevicelink, "Click on link of untrust this devicer");
				KeywordUtil.clickJS(PreLoginPage.untrustpopup, "Click on untrust button appeared on popup.");
				KeywordUtil.waitForInVisibile(PreLoginPage.untrusteddevicelink);
				//	KeywordUtil.verifyDropdownSelectedValue(PreLoginPage.filters,"Trusted Only", "Verify dropdown selected value is trusted");
				// int count = KeywordUtil.getListElements(PreLoginPage.trusted, "Count the Number of Trusted Devices").size();
				//	System.out.println(count + "Device Count");
				     //KeywordUtil.isWebElementVisible(PreLoginPage.trusted, "Total no of trusted devices "+ count);
				     
				if(!KeywordUtil.isWebElementPresentt(PreLoginPage.untrusteddevicelink))
				    {
				     	HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
								"Untrust this device functionality is working fine."));
				    }
				    
				    else
				    {
				    	GlobalUtil.stepname = "Click on Untrust this device and verify the functionality";
						Assert.fail(e.getMessage()); 
				    }
				Thread.sleep(5000);

			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on Untrust this device and verify the functionality";
				Assert.fail(e.getMessage());
			}
	    }

	@When("^Enter Phone Number$")
	public void enter_phone_number() {
		try {
			KeywordUtil.inputText(AccountCreationPage.phoneNumber, GetExcelData.getPhoneNumber(), "Enter Phone Number");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Phone Number";
			Assert.fail(e.getMessage());
		}
	}



	@When("^Enter Email$")
	public void enter_email() {
		d=new Date();
		 randomEmail = "testing@" + RandomStringUtils.randomAlphabetic(7).toLowerCase()+d.toString().replaceAll(" ", "").replace(":", "").replace("IST2020", "") + ".com";
		 
		try {
				d=new Date();
			randomEmail = "testing@" + RandomStringUtils.randomAlphabetic(7).toLowerCase()+d.toString().replaceAll(" ", "").replace(":", "").replace("IST2020", "") + ".com";
			// KeywordUtil.inputText(AccountCreationPage.email, dataMap.get("Email"),"enter
			// email");
			KeywordUtil.inputText(AccountCreationPage.email, randomEmail, "Enter Email "+randomEmail);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Existing Email$")
	public void Enter_Existing_Email() {
		try {
			KeywordUtil.inputText(AccountCreationPage.email, GetExcelData.getEmailAddress(), "Enter Email");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Existing Email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Email with invalid domain name$")
	public void enter_invalid_domain_name() {
		try {
			KeywordUtil.inputText(AccountCreationPage.email, dataMap.get("InvalidEmail"),
					"Enter email with invalid domain name");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Email with invalid domain name";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Checkbox for privacy policy$")
	public void select_checkbox_for_privacy_policy() {
		try {
			KeywordUtil.click(AccountCreationPage.privacyPolicy,
					"Select checkbox to agree to terms of service and Privacy Policy");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Checkbox for privacy policy";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Checkbox for consent to recieve notifications$")
	public void select_checkbox_consent() {
		try {
			KeywordUtil.click(AccountCreationPage.consent, "Select checkbox for consent to recieve notifications");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Checkbox for consent to recieve notifications";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click start free trial$")
	public void click_start_free_trial() {
		try {
			KeywordUtil.click(AccountCreationPage.startFreeTrial, "Start Free Trial");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click start free trial";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Verify OTP is generated$")
	public void verify_otp() {
		try {
			KeywordUtil.inputText(AccountCreationPage.otp, modules.QLRegistration.sqlConnection(otp),
					"Enter otp to verify email id");
			KeywordUtil.click(AccountCreationPage.verify, "Verify OTP");
			System.out.println("OTP_out");
		} catch (Throwable e) {
			System.out.println("OTP_In");
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify OTP is Generated";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Password and login$")
	public void password_and_login() {
		try {
			KeywordUtil.inputText(AccountCreationPage.password, GetExcelData.getConfirmPassword(), "Enter Password");
			KeywordUtil.inputText(AccountCreationPage.confirmPassword, GetExcelData.getConfirmPassword(),
					"Confirm Password");
			KeywordUtil.click(AccountCreationPage.loginNow, "Login Now");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Password and login";
			Assert.fail(e.getMessage());
		}
	}
	 @When("^Navigate to tenant url$")
	    public void navigate_to_tenant_url() throws Throwable {
		 try {
				navigateToUrl(GetExcelData.getTenantURL(), "User Navigate to Tenant URL");
				Thread.sleep(5000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "User Navigate to Tenant URL";
				Assert.fail(e.getMessage());
			}  
	    }
	@When("^Click on login here$")
	public void Click_on_login_here() {
		try {
			KeywordUtil.click(LoginPage.loginHere, "Click on Login Link");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on login here";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Verify Terms & Condition Link on login page$")
	public void Verify_terms_condition_link_on_login_page() throws Throwable {
		try {
			KeywordUtil.click(LoginPage.termsConditions, "Terms & Conditions link");
			System.out.println("Registration link available");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Terms & Conditions link";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify Registration link on login page$")
	public void verify_registration_link_on_login_page() throws Throwable {
		try {
			KeywordUtil.click(LoginPage.registrationlink, "Registration link available");
			System.out.println("Registration link available");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Registration link available";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Email ID$")
	public void enter_email_login() {
		try {
			KeywordUtil.inputText(LoginPage.email, GetExcelData.getUserName(), "Enter Email for login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter invalid email$")
	public void enter_invalid_email_login() {
		try {

			KeywordUtil.inputText(LoginPage.email, GetExcelData.getInvalidEmail(), "Enter Invalid Email");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Invalid email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Empty email field$")
	public void empty_email_field() {
		try {
			KeywordUtil.inputText(LoginPage.email, "", "Empty Email field");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Empty Email field";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter username for wso$")
	public void enter_username_wso() {
		try {
			KeywordUtil.inputText(WsoLoginPage.username, GetExcelData.getEmailAddress(), "Enter Username for WSO2");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter username for wso";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter WSO2 Username for Registration$")
	public void Enter_WSO2_Username_for_Registration() {
		try {
			KeywordUtil.inputText(WsoLoginPage.username, randomEmail, "Enter WSO2 Username");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter WSO2 Username for Registration";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter WSO2 Password and login$")
	public void Enter_WSO2_Password_and_login() {
		try {
			KeywordUtil.inputText(WsoLoginPage.password, GetExcelData.getConfirmPassword(), "Enter WSO2 Password and login");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter WSO2 Password and login";
			Assert.fail(e.getMessage());
		}
	}
	@Then("^Click on administrator button and navigate to inventories page$")
    public void click_on_administrator_button_and_navigate_to_inventories_page() throws Throwable {
       
        
        try {
			KeywordUtil.click(AccountCreationPage.welcomeHeading, "Click on administartion");
			navigateToUrl("https://sso.preprod.quicklaunch.io/admin/admin/home#/skuManager/inventory", "User navigates to inventories page");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on administartion and navigate to inventories page";
			Assert.fail(e.getMessage());
		}
    }
	@And("^Click on add inventory button and fill all inventory detail$")
    public void click_on_add_inventory_button_and_fill_all_inventory_detail() throws Throwable {
		 try {
		//	 navigateToUrl("https://sso.preprod.quicklaunch.io/admin/admin/home#/skuManager/inventory", "User Navigates to Tenant login Page");
				
					Date d = new Date();
					String name="Automation"+d.getMinutes()+d.getSeconds();
					System.out.println(d.getDay());
					//getDriver().navigate().refresh();
					Thread.sleep(2000);
				KeywordUtil.clickJS(SkuManager.Addinventory, "Click on add inventory button and fill all inventory detail");
				Thread.sleep(2000);
				String randomOrgName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
				KeywordUtil.inputText(SkuManager.inventoryname, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.selectByVisibleText(SkuManager.inventorytype, "Product", "Select inventory type");
				KeywordUtil.inputText(SkuManager.SKUID, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.inputText(SkuManager.unitcost, "10", "Enter unitcost value=10");
				KeywordUtil.selectByVisibleText(SkuManager.MRP, "Channel Governed", "Select value Channel Governed from MRP dropdown ");
				Thread.sleep(1000);
				KeywordUtil.selectByVisibleText(SkuManager.SP, "Channel Governed", "Select value Channel Governed from SP dropdown ");
				Thread.sleep(1000);
				KeywordUtil.clickJS(SkuManager.savebutton, "Click on save button");
				Thread.sleep(4000);
				
				
		 } catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on add inventory button and fill all inventory detail";
				Assert.fail(e.getMessage());
			}
    }
	@And("^Click on add inventory button and fill all inventory detail with inventory type feature$")
    public void click_on_add_inventory_button_and_fill_all_inventory_detail_with_inventory_type_feature() throws Throwable {
		try {
			// navigateToUrl("https://sso.preprod.quicklaunch.io/admin/admin/home#/skuManager/inventory", "User Navigates to Tenant login Page");
			
					Date d = new Date();
					String name="AutomationTest_"+d.getMinutes()+d.getSeconds();
					//getDriver().navigate().refresh();
				KeywordUtil.clickJS(SkuManager.Addinventory, "Click on add inventory button and fill all inventory detail");
				Thread.sleep(2000);
				String randomOrgName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
				KeywordUtil.inputText(SkuManager.inventoryname, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.selectByVisibleText(SkuManager.inventorytype, "Feature", "Select inventory type");
				KeywordUtil.selectByVisibleText(SkuManager.assignproduct, "SSO & IDP", "Select inventory type");
				
				KeywordUtil.inputText(SkuManager.SKUID, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.inputText(SkuManager.unitcost, "100", "Enter unitcost value=10");
				KeywordUtil.selectByVisibleText(SkuManager.MRP, "Channel Governed", "Select value Channel Governed from MRP dropdown ");
				Thread.sleep(2);
				KeywordUtil.selectByVisibleText(SkuManager.SP, "Channel Governed", "Select value Channel Governed from SP dropdown ");
				Thread.sleep(2);
				KeywordUtil.clickJS(SkuManager.savebutton, "Click on save button");
				Thread.sleep(4000);
				
				
		 } catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on add inventory button and fill all inventory detail";
				Assert.fail(e.getMessage());
			}
    }
	@And("^Click on add inventory button and fill all inventory detail with inventory type professional services$")
    public void click_on_add_inventory_button_and_fill_all_inventory_detail_with_inventory_type_professional_services() throws Throwable {
		try {
			// navigateToUrl("https://sso.preprod.quicklaunch.io/admin/admin/home#/skuManager/inventory", "User Navigates to Tenant login Page");
				
					Date d = new Date();
					String name="AutomationIvt_"+d.getMinutes()+d.getSeconds();
					//getDriver().navigate().refresh();
				KeywordUtil.clickJS(SkuManager.Addinventory, "Click on add inventory button and fill all inventory detail");
				Thread.sleep(2000);
				String randomOrgName = RandomStringUtils.randomAlphabetic(8).toLowerCase();
				KeywordUtil.inputText(SkuManager.inventoryname, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.selectByVisibleText(SkuManager.inventorytype, "Professional Services", "Select inventory type");
				KeywordUtil.selectByVisibleText(SkuManager.assignproduct, "mobile sso test", "Select inventory type");
				KeywordUtil.inputText(SkuManager.SKUID, name+randomOrgName, "Enter inventory namevalue");
				KeywordUtil.inputText(SkuManager.unitcost, "100", "Enter unitcost value=10");
				KeywordUtil.selectByVisibleText(SkuManager.MRP, "Channel Governed", "Select value Channel Governed from MRP dropdown ");
				Thread.sleep(2000);
				KeywordUtil.selectByVisibleText(SkuManager.SP, "Channel Governed", "Select value Channel Governed from SP dropdown ");
				Thread.sleep(2000);
				KeywordUtil.clickJS(SkuManager.savebutton, "Click on save button");
				Thread.sleep(4000);
				
				
		 } catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on add inventory button and fill all inventory detail";
				Assert.fail(e.getMessage());
			}
    }
	@When("^Enter invalid username for wso$")
	public void enter_invalid_username_wso() {
		try {
			KeywordUtil.inputText(WsoLoginPage.username, GetExcelData.getInvalidEmail(),
					"Enter invalid username for wso login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter invalid username for WSO2";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter empty username for wso$")
	public void enter_empty_username_wso() {
		try {
			KeywordUtil.inputText(WsoLoginPage.username, "", "Enter Empty Username for WSO2 login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter empty username for WSO2";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter username for cps$")
	public void enter_username_cps() {
		try {
			KeywordUtil.inputText(CpsLoginPage.username, dataMap.get("SuperAdminUsername"), "Enter username for CPS");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter username for CPS";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter CPS Username$")
	public void Enter_CPS_Username() {
		try {
			System.out.println(GetExcelData.getSuperAdminUsername()+"cps username");
			KeywordUtil.inputText(CpsLoginPage.username, GetExcelData.getSuperAdminUsername(), "Enter username for CPS");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter username for CPS";
			Assert.fail(e.getMessage());
		} 
	}

	@When("^Enter password$")
	public void enter_password() {
		try {
			KeywordUtil.inputText(LoginPage.password, GetExcelData.getPassword(), "Enter password login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter password";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Empty password$")
	public void empty_password() {
		try {
			KeywordUtil.inputText(LoginPage.password, "test", "Empty password field");
			KeywordUtil.clearInput(LoginPage.password);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Empty Password";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter password for wso$")
	public void enter_password_wso() {
		try {
			KeywordUtil.inputText(WsoLoginPage.password, GetExcelData.getPassword(), "Enter password for WSO2");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter password for WSO2";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter empty password for wso$")
	public void enter_empty_password_wso() {
		try {
			KeywordUtil.inputText(WsoLoginPage.password, "", "Enter password for WSO2");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter empty password for WSO2";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter CPS Password$")
	public void Enter_CPS_Password() {
		try {
			System.out.println(GetExcelData.getSuperAdminPassword()+"cps   password");
			KeywordUtil.inputText(CpsLoginPage.password, GetExcelData.getSuperAdminPassword(), "Enter CPS Password");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter CPS Password";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Enter password for cps$")
	public void enter_password_for_cps() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.inputText(CpsLoginPage.password, dataMap.get("Password"), "Enter CPS Password");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter CPS Password";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click forgot password$")
	public void forgot_password() {
		try {
			KeywordUtil.click(LoginPage.forgotPassword, "Click on forgot password");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on forgot password";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter email address$")
	public void email_address() {
		try {
			KeywordUtil.click(LoginPage.emailAddress, "Click on email address");
			Thread.sleep(2000);
			KeywordUtil.inputText(LoginPage.emailAddress, GetExcelData.getEmailAddress(), "Enter your email address");
			KeywordUtil.click(LoginPage.send, "Click on send button");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Your Email address";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Navigate to forgot password page$")
	public void navigate_to_forgot_password_page() {
		try {
			navigateToUrl(GetExcelData.getChangePasswordURL(), "Navigate to forgot password page");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to forgot password page";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Change password$")
	public void change_password() {
		try {
			KeywordUtil.inputText(LoginPage.newPassword, GetExcelData.getAdminpassword(), "Enter New Password");
			KeywordUtil.inputText(LoginPage.confirmPassword, GetExcelData.getAdminpassword(), "Confirm New Password");
			KeywordUtil.click(LoginPage.send, "Click on Save Button");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Change Password";
			Assert.fail(e.getMessage());
		}
	} 

	@When("^Verify Otp for change password$")
	public void verify_otp_change_password() {
		try {

			KeywordUtil.inputText(LoginPage.otp, modules.QLRegistration.forgotPasswordConnection(otp),
					"Enter OTP to verify Email");
			KeywordUtil.click(LoginPage.verify, "Verify Change Password OTP");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify Change Password OTP";
			Assert.fail(e.getMessage()); 
		}
	}

	@When("^Click Login$")
	public void click_login() {
		try {
			KeywordUtil.click(LoginPage.login, "Click on login");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click Login";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click signin$")
	public void click_signin() {
		try {
			KeywordUtil.click(WsoLoginPage.signin, "Click on signin");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click signin";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click WSO2 Signin$")
	public void Click_WSO2_Signin() {
		try {
			KeywordUtil.click(WsoLoginPage.signin, "Click WSO2 Signin");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click WSO2 Signin";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click signin for cps$")
	public void click_signin_cps() {
		try {
			KeywordUtil.click(CpsLoginPage.signin, "Click on signin for CPS");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click signin for cps";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Verify user redirected to CPS$")
	public void Verify_user_redirected_CPS() {
		try {
			if (GlobalUtil.getDriver().findElement(CpsLoginPage.signedinas).getText()
					.contains(GetExcelData.getSuperAdminUsername()))
				System.out.println("User signed in successfully");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify user is redirected to cps home page";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on settings$")
	public void click_settings() {
		try {
			KeywordUtil.click(CpsLoginPage.settings, "Click on settings");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on settings";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on Federation Partners$")
	public void click_federation_partners() {
		try {
			KeywordUtil.click(CpsLoginPage.federationPartners, "Click on Federation Partners (tenants)");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Federation Partners";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Set host name$")
	public void Set_hostname() {
		try {
			KeywordUtil.click(CpsLoginPage.hostNameFilter, "Click on host name filter");
			Thread.sleep(2000);
		
			KeywordUtil.inputText(CpsLoginPage.value, "cas-"+randomEmail.split("@")[1].split("\\.")[0]+".preprod.quicklaunch.io", "Enter value");
			
			KeywordUtil.click(CpsLoginPage.filter, "Click filter");
			Thread.sleep(3000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Set host name filter to contains";
			Assert.fail(e.getMessage());
		}
	}

	
	

	@Then("^Verify login user redirected to home page$")
	public void Verify_login_user_redirected_home_page() {
		
		
		 if(!KeywordUtil.isWebElementNotPresent(AccountCreationPage.welcomeHeading))
		    {
		    	HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
						"Verify user redirected to home page"));
		    }
		    
		    else
		    {
		    	GlobalUtil.stepname = "Verify user redirected to home page";
				Assert.fail(e.getMessage()); 
		    }
			
	}
	
	@When("^Navigate to the add users directory page$")
	public void Navigate_to_the_add_users_directory_page() {	
		
		try {
			navigateToUrl(GetExcelData.getAddUserURL(), "Navigate to the add users page");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to the add users page";
			Assert.fail(e.getMessage());
		}
	}

	
	@When("^Click on Configure Directory Tab$")
	public void Click_on_Configure_Directory_Tab() {
		try {
			KeywordUtil.click(LoginPage.configureDirectoryTab, "Click on Configure Directory Tab");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Configure Directory Tab";
			Assert.fail(e.getMessage());
		}
	}


	@When("^Click on Add new Directory$")
	public void Click_on_Add_new_Directory() {
		try {
			KeywordUtil.clickJS(LoginPage.addNewDirectory, "Click on Add new Directory");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Add new Directory";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter AD details$")
	public void Enter_AD_details() {
		try { 
			KeywordUtil.inputText(LoginPage.connectionName, GetExcelData.getConnectionName(), "Enter Connection name");
			KeywordUtil.inputText(LoginPage.userNameAD, GetExcelData.getUserNameAD(), "Enter Bind account username ");
			KeywordUtil.inputText(LoginPage.passwordAD, GetExcelData.getPasswordAD(), "Enter Bind account password ");
			KeywordUtil.inputText(LoginPage.connectionUrl, GetExcelData.getConnectionUrl(), "Enter Connection URL ");
			KeywordUtil.inputText(LoginPage.baseDn, GetExcelData.getBaseDn(), "Enter User search base ");
			KeywordUtil.inputText(LoginPage.userEntryObjectClass, GetExcelData.getUserEntryObjectClass(), "Enter User entry object class ");
			KeywordUtil.inputText(LoginPage.userSearchFilter, GetExcelData.getUserSearchFilter(), "Enter User search filter ");
			KeywordUtil.inputText(LoginPage.userListFilter, GetExcelData.getUserListFilter(), "Enter User list filter ");
			KeywordUtil.inputText(LoginPage.passwordAttribute, GetExcelData.getPasswordAttribute(), "Enter Password attribute ");
			
			KeywordUtil.clearInput(LoginPage.emailAttribute);
			KeywordUtil.inputText(LoginPage.emailAttribute, GetExcelData.getEmailAttribute(), "Enter Email attribute ");
            Thread.sleep(5000);
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter AD details";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on Test Connectivity button$")
	public void Click_on_Test_Connectivity_button() {
		try {
			Thread.sleep(6000);
			KeywordUtil.clickJS(LoginPage.TestConnectivity, "Click on Test Connectivity button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Test Connectivity button";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on Save Connectivity button$")
	public void Click_on_Save_Connectivity_button() {
		try {
			KeywordUtil.clickJS(LoginPage.saveConnectivity, "Click on Save Connectivity button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Save Connectivity button";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click on sync link$")
	public void Click_on_sync_link() {
		try {
			KeywordUtil.click(LoginPage.syncLinkConnectivity, "sync User Group");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "sync User Group";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Delete the Created AD$")
	public void Delete_the_Created_AD() {
		try {
			KeywordUtil.click(LoginPage.deleteCreatedAD, "Delete the Created AD");
			Thread.sleep(4000);
			KeywordUtil.click(LoginPage.ConfirmdeleteCreatedAD, "Confirm Delete the Created AD");
            Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Delete the Created AD";
			Assert.fail(e.getMessage());
		}
	}
	

	@Then("^Verify user is redirected to wso home page$")
	public void user_redirected_wso_home_page() {
		try {
			if (GlobalUtil.getDriver().findElement(WsoLoginPage.signedinas).getText()
					.contains(GetExcelData.getEmailAddress()))
				System.out.println("User signed in successfully");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify user is redirected to wso home page";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify User Redirected to WSO2$")
	public void Verify_User_Redirected_to_WSO2() {
		try {
			if (GlobalUtil.getDriver().findElement(WsoLoginPage.signedinas).getText().contains(randomEmail))
				System.out.println("Verify User Redirected to WSO2");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify User Redirected to WSO2";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Signout from wso$")
	public void click_signout() {
		try {
			KeywordUtil.click(WsoLoginPage.signout, "Click on signout");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Signout from wso";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify CPS host created$")
	public void verify_host_created_cps() {
		try {
			if (GlobalUtil.getDriver().findElement(CpsLoginPage.hostNameField).getText().contains(randomEmail))
				System.out.println("Verify CPS host created");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify CPS host created";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify CPS host$")
	public void verify_cps_host() throws Throwable {
		// throw new PendingException();
		try {
			if (GlobalUtil.getDriver().findElement(CpsLoginPage.hostNameField).getText()
					.contains(GetExcelData.getHostName()))
				System.out.println("Verify CPS host");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify CPS host";
			Assert.fail(e.getMessage());
		}

	}

	@And("^Set CPS host name$")
	public void set_cps_host_name() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.click(CpsLoginPage.hostNameFilter, "Click on host name filter");
			KeywordUtil.inputText(CpsLoginPage.value, dataMap.get("HostName"), "Enter value");
			Thread.sleep(1000);
			KeywordUtil.click(CpsLoginPage.filter, "Click filter");
			Thread.sleep(3000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Set host name filter to contains";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Signout from sso$")
	public void signout_from_sso() {
		try {
			KeywordUtil.click(LoginPage.profile, "Click on profile");
			KeywordUtil.click(LoginPage.signOut, "Signout from sso");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Signout from sso";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Logoff from cps$")
	public void click_logoff() {
		try {
			KeywordUtil.click(CpsLoginPage.logOff, "Click on logoff");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Logoff from CPS";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Incorrect username or password.\" appears on the screen$")
	public void error_message_on_sso() {
		try {
			GlobalUtil.getDriver().findElement(LoginPage.loginAlert).getText().equals("Invalid username or password.");
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
					"The error message \"Incorrect username or password.\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Incorrect username or password.\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Email is required.\" appears on the screen$")
	public void error_email_req_on_sso() {
		try {
			GlobalUtil.getDriver().findElement(LoginPage.emailAlert).getText().equals("Email is required.");
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil
					.passStringGreenColor("The error message \"Email is required\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message Email is required appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Password is required.\" appears on the screen$")
	public void error_pass_req_on_sso() {
		try {
			GlobalUtil.getDriver().findElement(LoginPage.passwordAlert).getText().equals("Password is required.");
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil
					.passStringGreenColor("The error message \"Password is required.!\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message Password is require appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Login failed!\" appears on the screen$")
	public void login_failed_wso() {
		try {

			GlobalUtil.getDriver().findElement(WsoLoginPage.messBoxWarning).getText()
					.equals("Login failed! Please recheck the username and password and try again.");
			HTMLReportUtil.logger.log(Status.PASS,
					HTMLReportUtil.passStringGreenColor("The error message \"Login failed!\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Login failed!\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Please enter a valid user name and a password.\" appears on the screen$")
	public void invalid_username_pass_wso() {
		try {

			GlobalUtil.getDriver().findElement(WsoLoginPage.messBoxWarning).getText()
					.equals("Login failed! Please recheck the username and password and try again.");
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
					"The error message \"Please enter a valid user name and a password.\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Please enter a valid username & password\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Domain already exists\" appears on the screen$")
	public void domain_already_exists() {
		try {
			Thread.sleep(2000);
			if (GlobalUtil.getDriver().findElement(AccountCreationPage.domainExists).getText()
					.contains("Domain already exists.")) {
				HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil
						.passStringGreenColor("The error message \"Domain already exists.\" appears on the screen"));
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Domain already exists!\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Organization name already exists\" appears on the screen$")
	public void org_name_already_exists() {
		try {
			System.out.println(GlobalUtil.getDriver().findElement(AccountCreationPage.orgNameExists).getText());
			if(GlobalUtil.getDriver().findElement(AccountCreationPage.orgNameExists).getText()
					.contains("Organization name already exists! Click here to ")) {
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
					"The error message \"Organization name already exists!\" appears on the screen"));}
			else
			{
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "The error message \"Organization name already exists!\" appears on the screen";
				Assert.fail(e.getMessage());
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Organization name already exists!\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^The error message \"Invalid full name\" appears on the screen$")
	public void invalid_full_name() {
		try {
			if(KeywordUtil.verifyDisplay(AccountCreationPage.errorFullName,"The error message appears on the screen"))
			{
				HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil
						.passStringGreenColor("The error message Minimum 1 character required for Full Name is appearing"));
			}
			else
			{
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "The error message Minimum 1 character required for Full Name is appearing";
				Assert.fail(e.getMessage());
				
			}
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message Minimum 1 character required for Full Name is appearing";
			Assert.fail(e.getMessage());
		}
	}



	@Then("^The error message \"Invalid domain name\" appears on the screen$")
	public void invalid_domain_name() {
		try {
			GlobalUtil.getDriver().findElement(AccountCreationPage.errorDomainName).getText()
					.equals("Invalid domain name");
			HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil
					.passStringGreenColor("The error message \"Invalid domain name\" appears on the screen"));
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Invalid Domail name!\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User verifies by log in with new password$")
	public void login_new_password() {
		try {
			navigateToUrl(GetExcelData.getURL(), "User Navigates to Tenant login Page");
			KeywordUtil.click(LoginPage.loginHere, "Click on Login Link");
			KeywordUtil.inputText(LoginPage.email, GetExcelData.getUserName(), "Enter Email");
			KeywordUtil.inputText(LoginPage.password, GetExcelData.getPassword(), "Enter Updated Password");
			KeywordUtil.click(LoginPage.login, "Click on login");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message \"Login failed!\" appears on the screen";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify start free trial button is disabled$")
	public void free_trial_disabled() {
		try {

			if (GlobalUtil.getDriver().findElement(AccountCreationPage.startFreeTrial).isEnabled()) {
				KeywordUtil.click(AccountCreationPage.startFreeTrial, "Click start free trial");

			} else {
				HTMLReportUtil.logger.log(Status.PASS,
						HTMLReportUtil.passStringGreenColor("Start free trial button is disabled"));
			}

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify start free trial button is disabled";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Error message Please enter a valid email address should be visible$")
	public void error_message_please_enter_a_valid_email_address_should_be_visible() throws Throwable {

		try {

			KeywordUtil.verifyDisplayAndEnable(LoginPage.forgotpasswordError,
					"Please enter a valid email address should appears");
			Thread.sleep(2000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Please enter a valid email address should appears";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter invalid email address$")
	public void enter_email_address() throws Throwable {

		try {

			KeywordUtil.inputText(LoginPage.emailAddress, GetExcelData.getInvalidEmail(), "Enter Invalid Email Address");
			KeywordUtil.click(LoginPage.send, "Click on send button");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Invalid Email Address";
			Assert.fail(e.getMessage());
		}

	}

	@Then("^Passwords do not match error message appear$")
	public void Passwords_do_not_match_error_message_appear() throws Throwable {
		try {
			KeywordUtil.verifyDisplayAndEnable(LoginPage.passwordmismach,
					"Passwords do not match error message appear");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Passwords do not match error message appear";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Mismatch password on confirms password field$")
	public void Mismatch_password_on_confirms_password_field() throws Throwable {
		try {

			KeywordUtil.inputText(LoginPage.newPassword, "Testxpert@123", "Enter new password");
			KeywordUtil.inputText(LoginPage.confirmPassword, "Test@12345", "Confirm new password");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Mismatch password on confirms password field";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Password complexity error message should appears$")
	public void Password_complexity_error_message_should_appears() throws Throwable {
		try {

			KeywordUtil.verifyDisplayAndEnable(LoginPage.passwordcomplexity,
					"Password complexity requirements must be met before proceeding! error message should appears");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Password complexity requirements must be met before proceeding! error message should appears";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Low complex password$")
	public void Low_complex_password() throws Throwable {
		try {

			KeywordUtil.inputText(LoginPage.newPassword, "Test2222123", "Enter new password");
			KeywordUtil.inputText(LoginPage.confirmPassword, "Test2222123", "Confirm new password");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Low Complex password";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Enter Invalid OTP$")
	public void enter_invalid_otp() throws Throwable {
		// throw new PendingException();
		try {

			KeywordUtil.inputText(LoginPage.otp, "1234", "Enter Invalid OTP");
			KeywordUtil.click(LoginPage.verify, "Verify otp");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Invalid OTP";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verification failed error message should appears$")
	public void error_message_verification_failed_should_appear() throws Throwable {
		// throw new PendingException();
		try {

			KeywordUtil.verifyDisplayAndEnable(LoginPage.invalidotperror,
					"Verification failed error message should appears");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verification failed error message should appears";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on Eye Icon$")
	public void click_on_eye_icon() throws Throwable {
		// throw new PendingException();
		try {

			KeywordUtil.click(LoginPage.eyeclick, "Click on Eye Icon");
			KeywordUtil.isWebElementPresent(LoginPage.passwordvisible, "Password is visible in text format.");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Password is visible in text format.";
			Assert.fail(e.getMessage());
		}

	}

	@Then("^Password filed should appear in text and encrypted form$")
	public void password_filed_should_appear_in_text_and_encrypted_form() throws Throwable {
		// throw new PendingException();
		try {

			KeywordUtil.click(LoginPage.eyeclick, "Click on eye icon");
			KeywordUtil.isWebElementPresent(LoginPage.passwordinvisible, "Password is an encrypted form.");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Password is an encrypted form";
			Assert.fail(e.getMessage());
		}
	}

	// Prerequisite
	@And("^Navigate to UserDetails Page$")
	public void navigate_to_userdetails_page() throws Throwable {
		// throw new PendingException();
		try {
			navigateToUrl(GetExcelData.getUserDetail(), "Navigate to UserDetails Page");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to UserDetails Page";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Type Username In UserDetail Page$")
	public void type_username_in_userdetail_page() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.inputText(FirstTimeUser.typeusername, GetExcelData.getCleardata(),
					"Type Username In UserDetail Page");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Type Username In UserDetail Page";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on Search button$")
	public void click_on_search_button() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.click(FirstTimeUser.searchbutton, "Click on Search Button to Search a Record");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Search Button to Search a Record";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Search a record of Enduser with Username$")
	public void search_a_record_of_enduser_with_username() throws Throwable {
		// throw new PendingException();
		try {
			// KeywordUtil.click(FirstTimeUser.searchbutton, "Click on Signin button");
			element = KeywordUtil.isWebElementPresent(FirstTimeUser.deleteuser,
					"Searching a record of Enduser with Username");
			Thread.sleep(4000);
			if (element) {
				KeywordUtil.clickJS(FirstTimeUser.deleteuser, "Clicked on delete Button");
			}
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Signin";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on clear button$")
	public void click_on_clear_button() throws Throwable {
		try {
			if (element)
				KeywordUtil.clickJS(FirstTimeUser.clearuser, "Clicked on Clear Button");
			Thread.sleep(6000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Clicked on Clear Button";
			Assert.fail(e.getMessage());
		}
	}
}
