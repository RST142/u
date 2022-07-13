package step_defination;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pojo.GetExcelData;
import quicklaunchpages.AccountCreationPage;
import quicklaunchpages.EndUserAccountRecoveryPage;
import quicklaunchpages.FirstTimeUser;
import quicklaunchpages.LoginPage;
import quicklaunchpages.PreLoginPage;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class EndUserAccountRecovery {
	boolean element; 
	String OTP; 
	 @And("^Select quetion from security quetion dropdown$")
	    public void select_quetion_from_security_quetion_dropdown() throws Throwable {
		 try {
				KeywordUtil.click(EndUserAccountRecoveryPage.securitydropdown, "Click on Security quetion dropdown.");
				KeywordUtil.selectByVisibleText(EndUserAccountRecoveryPage.securitydropdown, "Which is your favorite movie?", "Select quetion from security quetion dropdown.");
		 	 	KeywordUtil.inputText(EndUserAccountRecoveryPage.Securityanswer, GetExcelData.getSecurityAnswer(), "Entered Security answer in textbox.");
				Thread.sleep(5000);
				KeywordUtil.click(EndUserAccountRecoveryPage.submitbutton, "Click on submit button.");
					 
		 } catch (Throwable e) {  
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Select quetion from security quetion dropdown and enter security answer in text filed.";
				Assert.fail(e.getMessage());
			}
	    }       
	  
	 @Then("^Enter Primary Email address in email recovery text field$")
	    public void enter_primary_email_address_in_email_recovery_text_field() throws Throwable {
	      //  throw new PendingException();
		 try {
			 KeywordUtil.click(PreLoginPage.EmailTab, "Click on Email Tab");
				
				KeywordUtil.inputText(EndUserAccountRecoveryPage.Emailtextfield, GetExcelData.getEmailAddress(), "Enter Primary Email address in email recovery text field");
				KeywordUtil.click(EndUserAccountRecoveryPage.verifybutton,  "Click on verify button.");
				Thread.sleep(5000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Enter Primary Email address in email recovery text field and click on verify button.";
				Assert.fail(e.getMessage());
			}
	    }
	 @And("^Click on checkbox of security sequetion,primary phone and email$")
	    public void click_on_checkbox_of_security_sequetionprimary_phone_and_email() throws Throwable {
	        //throw new PendingException();
		 try {
				// KeywordUtil.click(FirstTimeUser.searchbutton, "Click on Signin button");
				element = KeywordUtil.isWebElementPresent(FirstTimeUser.deleteuser,
						"Searching a record of Enduser with Username");
				Thread.sleep(4000);
				if (element) {
					KeywordUtil.clickJS(EndUserAccountRecoveryPage.securitycheckbox, "Clicked on security quetion checkbox.");
					KeywordUtil.clickJS(EndUserAccountRecoveryPage.primaryphone, "Clicked on primary phone checkbox.");
					KeywordUtil.clickJS(EndUserAccountRecoveryPage.primaryemailcheckbox, "Clicked on primary email checkbox.");
					KeywordUtil.clickJS(EndUserAccountRecoveryPage.clearbutton, "Clicked on clear button.");
				}
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on checkbox of security sequetion,primary phone and email";
				Assert.fail(e.getMessage());
			}
	    }
	 @Then("^Click on clear button in popup$")
	    public void click_on_clear_button_in_popup() throws Throwable {
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
	 
	 @And("^Enter OTP Received in Email for account recovery$")
	    public void enter_otp_received_in_email_for_account_recovery() throws Throwable {
	        //throw new PendingException();
		 try {
				KeywordUtil.inputText(EndUserAccountRecoveryPage.emailinputtext,
						modules.QLRegistration.emailverificationOTP(OTP, GetExcelData.getEmailAddress()),
						"Enter OTP received in Email");
				KeywordUtil.clickJS(EndUserAccountRecoveryPage.submitbuttonafterotp, "Clicked on submit Button");
				Thread.sleep(6000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Enter OTP received in Email";
				Assert.fail(e.getMessage());
			}
	    }
	 
	 @Then("^Select country drop dropdown for phone configuration$")
	    public void select_country_drop_dropdown_for_phone_configuration() throws Throwable {
		 try {
				KeywordUtil.click(EndUserAccountRecoveryPage.countrydropdown, "Select country drop dropdown for phone configuration");
				KeywordUtil.selectByVisibleText(EndUserAccountRecoveryPage.countrydropdown, GetExcelData.getCountry(), "Select Country");
				KeywordUtil.inputText(EndUserAccountRecoveryPage.phonenumbertext, "7696449931", "Enter Phone Number");	
		
				KeywordUtil.click(EndUserAccountRecoveryPage.phoneverificationbutton, "Click on verify button");
				
		 } catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Select country drop dropdown for phone configuration and click on verify button after filling phone number.";
				Assert.fail(e.getMessage());
			}
	    }
	 @And("^Enter OTP Received in phone for account recovery$")
	    public void enter_otp_received_in_phone_for_account_recovery() throws Throwable {
	        //throw new PendingException();
		 try {
				KeywordUtil.inputText(EndUserAccountRecoveryPage.phoneinputtext,
						modules.QLRegistration.phoneverificationOTP(OTP,"+917696449931").toString(),
						"Enter OTP received in phone");
				KeywordUtil.clickJS(EndUserAccountRecoveryPage.verybutton, "Clicked on submit button");
				Thread.sleep(6000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Enter OTP received in phone";
				Assert.fail(e.getMessage());
			}
	    }
}
