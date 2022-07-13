package step_defination;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojo.GetExcelData;
import pojo.Setterclass;

import com.aventstack.extentreports.Status;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import quicklaunchpages.AccountCreationPage;
import quicklaunchpages.EndUserAccountRecoveryPage;
import quicklaunchpages.LoginPage;
import quicklaunchpages.PostLoginPage;
import quicklaunchpages.PreLoginPage;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class PreLogin extends KeywordUtil {
	String OTP; 
String username;
	@When("^Navigate to PreLogin Page$") 
	public void Navigate_to_PreLogin_Page() {
		try {
			navigateToUrl(GetExcelData.getURL(), "User Navigate to PreLogin Page");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e; 
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to PreLogin Page";
		 	Assert.fail(e.getMessage());
		}        
	}        
	@And("^Enter Username \"([^\"]*)\"$") 
    public void enter_email_id_something(String username) throws Throwable {
     //   throw new PendingException();
	 try {
		 this.username=username;
			KeywordUtil.inputText(LoginPage.emaill,username, "Enter Email for login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter email";
			Assert.fail(e.getMessage());
		}
    } 

    @And("^Enter Password for End User \"([^\"]*)\"$")
    public void enter_password_something(String password) throws Throwable {
     //   throw new PendingException();
    	try {
			KeywordUtil.inputText(LoginPage.passwordd, password, "Enter password login");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter password";
			Assert.fail(e.getMessage());
		}
    }


	@Then("^Redirected to login page of PWMS$")
    public void redirected_to_login_page_of_pwms() throws Throwable {
		try {
			KeywordUtil.waitForVisible(By.xpath("//input[@id='form-password']"));
			KeywordUtil.inputText(LoginPage.pwmslogin, GetExcelData.getEndUserPassword(), "Enter enduser password in PWMS login page.");
			KeywordUtil.click(LoginPage.pwmssign, "Click on sign in button.");
		    
		    Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter enduser Password in PWMS login page.";
			Assert.fail(e.getMessage());
		}
    }

	@And("^Enter Username$")
	public void enter_user_name() {
		try {
			KeywordUtil.inputText(PreLoginPage.username, GetExcelData.getEndUser(), "Enter User Name for login");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter User Name";
			Assert.fail(e.getMessage());
		}
	} 

	@And("^Enter User Password$")
	public void Enter_User_Password() {
		try {
			KeywordUtil.inputText(PreLoginPage.password, GetExcelData.getPassword(), "Enter User Password");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter User Password";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on Signin$")
	public void Click_on_signin() {
		try {
			KeywordUtil.click(PreLoginPage.signin, "Click on Signin button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Signin";
			Assert.fail(e.getMessage());
		} 
	}
	@Then("^The error message should appears if the user entered an invalid OTP$")
    public void the_error_message_should_appears_if_the_user_entered_an_invalid_otp() throws Throwable {
		try {
			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.PreLoginPage.invalidotpmessage, "The error message should appears if the user entered an invalid OTP");
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "The error message should appears if the user entered an invalid OTP";
			Assert.fail(e.getMessage());
		}
    }
	
	@Then("^Verify Error Notification Message$")
	public void Verify_Error_Notification_Message() {
		try {
			KeywordUtil.verifyText(PreLoginPage.notification, GetExcelData.getNotifications(), "Verify Error Notification Message" + " " + GetExcelData.getNotifications());
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = ("Verify Error Notification Message"+ " " + GetExcelData.getNotifications());
			Assert.fail(e.getMessage());
		} 
	}
	
	@Then("^Verify Error Notification PopUp$")
	public void Verify_Error_Notification_PopUp() {
		try {
			KeywordUtil.isWebElementPresent(PreLoginPage.PasswordPopUp, "PopUp is present");
			KeywordUtil.verifyText(PreLoginPage.notificationPopUp, GetExcelData.getNotifications(), "Verify Error Notification Message" + " " + GetExcelData.getNotifications());
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = ("Verify Error Notification Message"+ " " + GetExcelData.getNotifications());
			Assert.fail(e.getMessage());
		} 
	}
	
	 @Then("^Click on primary email$")
	    public void click_on_primary_email() throws Throwable {
		 try {
				KeywordUtil.click(PreLoginPage.emailmfa, "Click on primary email");
				Thread.sleep(4000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on primary email";
				Assert.fail(e.getMessage());
			}
	    }
	@And("^Click on Security Question Option$")
	public void click_on_use_security_question() {
		try {
			KeywordUtil.click(PreLoginPage.securityQuestion, "Click on Security Question Option");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Security Question Option";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Click on Mobile Push Option$")
	public void Click_on_Mobile_Push_Option() {
		try {
			KeywordUtil.click(PreLoginPage.mobilePush, "Click on Mobile Push Option");
			KeywordUtil.click(PreLoginPage.mobilePushLink, "Click on Mobile Push Option");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Mobile Push Option";
			Assert.fail(e.getMessage());
		}
	}

//	@And("^Enter Security Answer$")
//	public void Enter_Security_Answerein_textfield() {
//		try {
//			KeywordUtil.inputText(PreLoginPage.securityAnswer, GetExcelData.getSecurityquetion(),
//					"Enter Security Answer");
//		} catch (Throwable e) {
//			GlobalUtil.e = e;
//			GlobalUtil.ErrorMsg = e.getMessage();
//			GlobalUtil.stepname = "Enter Security Answer";
//			Assert.fail(e.getMessage());
//		}
//	}

	@And("^Click on Submit button$")
	public void Click_on_Submit_button() {
		try {
			KeywordUtil.click(PreLoginPage.submit, "Click on Submit Button");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit Button";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Click on Submit button for mobile push$")
	public void Click_on_Submit_button_for_mobile_push() {
		try {
			KeywordUtil.clickJS(PreLoginPage.submitMobilePushOTP, "Click on Submit Button for mobile push");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit Button for mobile push";
			Assert.fail(e.getMessage());
		}
	}


	@And("^Click on signin button to submit password$")
	public void Click_on_signin_button_to_submit_password() {
		try {
			KeywordUtil.click(PreLoginPage.submitPassword, "Click on Submit Button");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit Button";
			Assert.fail(e.getMessage());
		}
	}
	@Then("^Verify filter dropdown for untrusted devices$")
    public void Verify_filter_dropdown_for_untrusted_devices() throws Throwable {
		try {
			KeywordUtil.isWebElementPresent(PreLoginPage.MyDevicesHeadingTag, "Verify Heading Present on Devices page");
			KeywordUtil.click(PreLoginPage.filters, "Click on View all Filter");
			KeywordUtil.selectByVisibleText(PreLoginPage.filters, "Untrusted Only", "Select Untrusted devices from dropdown");
			KeywordUtil.verifyDropdownSelectedValue(PreLoginPage.filters,"Untrusted Only", "Verify dropdown selected value is untrusted");
		
			 int count = KeywordUtil.getListElements(PreLoginPage.untrusted, "Count the Number of untrusted Devices").size();
				System.out.println(count + "Device Count");
			     KeywordUtil.isWebElementVisible(PreLoginPage.untrusted, "Total no of untrusted devices "+ count);
				
			     if(!KeywordUtil.isWebElementPresentt(PreLoginPage.trusted))
				    {
				    	HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
								"Verify Untrusted device details existed on page"));
				    }
				    
				    else
				    {
				    	GlobalUtil.stepname = "Verify Untrusted device details existed on page";
						Assert.fail(e.getMessage()); 
				    }
			Thread.sleep(5000);
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify untrusted values from dropdown";
			Assert.fail(e.getMessage());
		}
    }
	@And("^Verify filter dropdown for trusted devices$")
	public void Verify_filter_dropdown_for_trusted_devices() {
		try {
			KeywordUtil.click(PreLoginPage.filters, "Click on View all Filter");
			KeywordUtil.selectByVisibleText(PreLoginPage.filters, "Trusted Only", "Select trusted devices from dropdown");
			KeywordUtil.verifyDropdownSelectedValue(PreLoginPage.filters,"Trusted Only", "Verify dropdown selected value is trusted");
			 int count = KeywordUtil.getListElements(PreLoginPage.trusted, "Count the Number of Trusted Devices").size();
				System.out.println(count + "Device Count");
			     KeywordUtil.isWebElementVisible(PreLoginPage.trusted, "Total no of trusted devices "+ count);
			     
			if(!KeywordUtil.isWebElementPresentt(PreLoginPage.untrusted))
			    {
			     	HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor(
							"Verify trusted device details existed on page"));
			    }
			    
			    else
			    {
			    	GlobalUtil.stepname = "Verify trusted device details existed on page";
					Assert.fail(e.getMessage()); 
			    }
			Thread.sleep(5000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify trusted device details existed on page";
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Then("^Redirected to the account recovery page$")
	public void redirected_to_the_account_recovery_page() throws Throwable {
		try {
			KeywordUtil.isWebElementPresent(PreLoginPage.AccountRecovery, "User is on Account Recovery Page");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "User is on Account Recovery Page";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Verify the Security Question Tab Non Configured$")
	public void verify_the_security_question_tab_non_configured() throws Throwable {
			try {
				KeywordUtil.click(PreLoginPage.SecurityTab, "Click on Security Tab");
				Thread.sleep(4000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on Security Tab";
				Assert.fail(e.getMessage());
			}
		}

	@Then("^Add Custom Security Question$")
	public void Add_Custom_Security_Question() throws Throwable {
			try { 
				Thread.sleep(3000);
				KeywordUtil.click(PreLoginPage.UpdateCustomQuestion, "Click on edit icon to add custom question");
				Thread.sleep(3000);
			    KeywordUtil.click(PreLoginPage.CustomQuestion, "Click on edit icon to add custom question");
			    Thread.sleep(3000);
			    KeywordUtil.inputText(PreLoginPage.EnterCustomQuestion, "What is your nick name", "Add Custom Security Question");
				Thread.sleep(2000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Add Custom Security Question";
				Assert.fail(e.getMessage());
			} 
		}
	
	@And("^Enter Answer for Custom Security Question$")
	public void Enter_Answer_for_Custom_Security_Question() {
		try {
			KeywordUtil.inputText(PreLoginPage.EnterCustomAnswer, GetExcelData.getSecurityquetion(),
					"Enter Security Answer");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Answer for Custom Security Question";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Submit the Security Question Changes$")
	public void Submit_the_Security_Question_Changes() {
		try {
			KeywordUtil.click(PreLoginPage.SumbitSecurityQuestion, "Submit the Security Question Changes");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit the Security Question Changes";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Update First Security Question$")
	public void Update_First_Security_Question() throws Throwable {
			try { 
				KeywordUtil.click(PreLoginPage.SelectSecurityQuestion1, "Click on Select Security Question");
				Thread.sleep(2000);
				KeywordUtil.click(PreLoginPage.SelectSecurityQuestion2, "Click on Select Security Question");
				Thread.sleep(2000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on Select Security Question";
				Assert.fail(e.getMessage());
			} 
		}
	
	
	@Then("^Verify the Security Question Tab Configured$")
	public void verify_the_security_question_non_configured() throws Throwable {
			try { 
				KeywordUtil.click(PreLoginPage.SecurityTab, "Click on Security Tab");
				Thread.sleep(4000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on Security Tab";
				Assert.fail(e.getMessage());
			} 
		}

	
	
	@Then("^Verify the Phone Tab Non Configured$")
	public void verify_the_phone_tab_non_configured() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.PhoneTab, "Click on Phone Tab");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Phone Tab";
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Then("^Verify the Phone Tab Configured$")
	public void verify_the_phone_tab_configured() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.PhoneTab, "Click on Phone Tab");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Phone Tab";
			Assert.fail(e.getMessage());
		}
	}	
	
	
	@Then("^Click on Primary Phone Update button$")
	public void Click_on_Primary_Phone_Update_button() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.UpdatePhoneButton, "Click on Primary Phone Update button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Phone Update button";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Select Country to Update Phone$")
	public void Select_Country_to_Update_Phone() {
		try {
			KeywordUtil.click(PreLoginPage.SelectCountry, "Select Country to Update Phone");
			KeywordUtil.selectByVisibleText(PreLoginPage.SelectCountry, GetExcelData.getCountry(), "Select Country");
	     	Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Country to Update Phone";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Enter Phone Number to Update$")
	public void Enter_Phone_Number_to_Update() {
		try {
		//	KeywordUtil.inputText(PreLoginPage.EnterPhonenumber, GetExcelData.getPhoneNumber(), "Enter Phone Number to Update");
			KeywordUtil.inputText(PreLoginPage.EnterPhonenumber, "9023240412", "Enter Phone Number");	

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Phone Number to Update";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Click on Verify button$")
	public void Click_on_Verify_button() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.VerifyPhoneNumber, "Click on Verify button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Verify button";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Enter OTP Received in Phone$")
    public void Enter_OTP_Received_in_Phone() throws Throwable {
       
		try {
			KeywordUtil.inputText(PreLoginPage.EnterPhoneVerificationCode,
					modules.QLRegistration.phoneverificationOTP(OTP,"+919023240412").toString(),
					"Enter OTP received in phone");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP Received in Phone";
			Assert.fail(e.getMessage());
		}
    }
	
	
	
	@Then("^Click on Phone OTP Submit button$")
	public void Click_on_Phone_OTP_Submit_button() throws Throwable {
		try {
			KeywordUtil.clickJS(PreLoginPage.SubmitPhoneButton, "Click on Phone OTP Submit button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Phone OTP Submit button";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^After login user should redirect to Account Recovery Setting$")
    public void enter_enduser_password() throws Throwable {
       // throw new PendingException();
		try {
			KeywordUtil.waitForVisible(By.cssSelector("#openPhoneRecovery"));
		    KeywordUtil.isWebElementPresent(LoginPage.phonerecovery, "User is on account recovery setting page.");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "User is on account recovery setting page";
			Assert.fail(e.getMessage());
		}
    }
	@Then("^Verify the Email Tab Non Configured$")
	public void verify_the_email_tab_non_configured() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.EmailTab, "Click on Email Tab");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Email Tab";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Verify the Email Tab Configured$")
	public void verify_the_email_tab_configured() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.EmailTab, "Click on Email Tab");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Email Tab";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Click on Email Recovery Update button$")
	public void Click_on_Email_Recovery_Update_button() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.UpdateSecondaryEmail, "Click on Email Recovery Update button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Email Recovery Update button";
			Assert.fail(e.getMessage());
		}
	}
	
	
	@When("^Enter Email Id Needs to be Updated$")
	public void Enter_Email_Id_Needs_to_be_Updated() {
		try {
			KeywordUtil.inputText(PreLoginPage.EnterUpdatedEmail, "mahajanchanchal@gmail.com", "Enter Email Address");
		//	KeywordUtil.inputText(PreLoginPage.EnterUpdatedEmail, GetExcelData.getEmailAddress(), "Enter Primary Email address in email recovery text field");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Email Id Needs to be Updated";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Click on Validate Email ID button$")
	public void Click_on_Validate_Email_ID_button() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.ValidateEmail, "Click on Validate Email ID button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Validate Email ID button";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Enter verification Code received in email$")
    public void Enter_verification_Code_received_in_email() throws Throwable {
      //  throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.EnterMailOTP,
					modules.QLRegistration.emailverificationOTP(OTP,"mahajanchanchal@gmail.com").toString(),
					"Enter OTP received in mail");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter verification Code received in email";
			Assert.fail(e.getMessage());
		}
    }
	
	@Then("^Click on Submit button for Email Id$")
	public void Click_on_Submit_button_for_Email_Id() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.SubmitUpdatedemail, "Click on Submit button for Email Id");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit button for Email Id";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Click on My Apps Menu$")
    public void Click_on_My_Apps_Menu() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.ClickonmyApp, "Click on My Apps Menu");
	
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Menus link";
			Assert.fail(e.getMessage());
		}
    }
	

	@Then("^Click on Email Option$")
	public void Click_on_email_option() {
		try {

			KeywordUtil.clickJS(PreLoginPage.sendMeEmail, "Click on Send me Email Option");
			KeywordUtil.clickJS(PreLoginPage.primaryEmail, "Click on Primary Email Option");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Send Me Email Option";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on Email Option for RC$")
	public void Click_on_email_option_for_RC() {
		try {
			KeywordUtil.clickJS(PreLoginPage.primaryEmail, "Click on Primary Email Option");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Send Me Email Option";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter OTP Received by Email$")
    public void enter_otp_received_by_email() throws Throwable {
      //  throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.EmailOTPConnection(OTP, username),
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
    }
	@Then("^Click on Text Message Option$")
	public void Click_on_Text_Message_Option() {
		try {
			KeywordUtil.click(PreLoginPage.sendMeTextMessage, "Click on Send Me Text Message Option");
			KeywordUtil.click(PreLoginPage.primaryPhone, "Click on Primary Phone Option");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Send Me Text Message Option";
			Assert.fail(e.getMessage());
		}
	}
 
	@Then("^Click on Text Message Option for RC$")
	public void Click_on_Text_Message_Option_for_RC() {
		try {
			KeywordUtil.click(PreLoginPage.primaryPhone, "Click on Primary Phone Option");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Send Me Text Message Option";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter OTP received by Phone Number$")
    public void enter_otp_received_by_phone_number() throws Throwable {
        //throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.PhoneOTPMessageConnection(OTP,username),
					"Enter OTP received in Phone Number");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Phone Number";
			Assert.fail(e.getMessage());
		}
    }
	@Then("^Click on Google Authentication Option$")
	public void Click_on_Google_Authentication_Option() {
		try {
			KeywordUtil.click(PreLoginPage.googleAuth, "Click on Google Authentication Option");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Google Authentication Option";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter OTP Received in Email$")
	public void Enter_OTP_Received_in_Email() {
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.EmailOTPConnection(OTP, GetExcelData.getEndUser()),
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Submit OTP received in Email$")
	public void Submit_OTP_received_in_Email() {
		try {
			KeywordUtil.click(PreLoginPage.submitemailotp, "Submit OTP received in Email");
			Thread.sleep(7000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit OTP received in Email";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter OTP received in Phone Number$")
	public void Enter_OTP_received_in_Phone_Number() {
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.PhoneOTPMessageConnection(OTP,GetExcelData.getEndUser()),
					"Enter OTP received in Phone Number");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Phone Number";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Submit OTP received in Phone Number$")
	public void Submit_OTP_received_in_Phone_Number() {
		try {
			KeywordUtil.click(PreLoginPage.submitemailotp, "Click on Submit Button");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit OTP received in Phone Number";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Redirected to Dashboard$") 
	public void Redirected_to_Dashboard() {
		try {
			KeywordUtil.waitForVisible(By.xpath("//div[@id='user-menu']"));
			Thread.sleep(5000);
		    if(!KeywordUtil.isWebElementPresent(PreLoginPage.header, "User is on Dashboard"))
		    {
		    	GlobalUtil.stepname = "User is on Dashboard";
				Assert.fail();
		    }
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "User is on Dashboard";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on the Menus$")
    public void click_on_the_Menus() throws Throwable {
		try {
			KeywordUtil.clickJS(PreLoginPage.PostLoginMenubar, "Click on Menu");
			KeywordUtil.hoverOnElement(By.xpath("//div[@id='user-menu']"));
			//KeywordUtil.click(PreLoginPage.Myaccount, "Click on My account");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Menus link";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Verify username on the Menu bar$")
    public void Verify_username_on_the_Menu_bar() throws Throwable {
		try {
			String printUsername=KeywordUtil.getElementText(PreLoginPage.PostLoginMenubar);
			System.out.println(printUsername);
			if  (printUsername.equals("Hello, " + GetExcelData.getEndUser() ))
				//if  (printUsername.equals(GetExcelData.getEndUser()))

			{
				KeywordUtil.isWebElementPresent(PreLoginPage.PostLoginMenubar, "Verify the username on the Menu bar");
					}
			else
			{
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Verify the username on the Menu bar";
				Assert.fail(e.getMessage());
			}
					
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify the username on the Menu bar";
			Assert.fail(e.getMessage());
		}
    }
	
	
	@And("^Enter the text in search field$")
    public void Enter_the_text_in_search_field() throws Throwable {
		try {
			KeywordUtil.inputText(PostLoginPage.search, GetExcelData.getSearch(), "Enter the text in search field");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter the text in search field";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Click on the Application$")
    public void Click_on_the_Application() throws Throwable {
		try {
			KeywordUtil.click(PostLoginPage.Application, "Click on the application");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on the application";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Navigate back to my app tab$")
    public void Navigate_back_to_my_app_tab() throws Throwable {
		try {
			KeywordUtil.ShiftTab();
			getDriver().getCurrentUrl();
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate back to my app tab";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Count the Number of Applications$")
    public void Count_the_Number_of_Applications() throws Throwable {
		try {
	     int count = KeywordUtil.getListElements(PostLoginPage.countApplication, "Count the Number of Applications").size();
		System.out.println(count + "Application Count");
	     KeywordUtil.isWebElementVisible(PostLoginPage.countApplication, "Total no of Applications "+ count);
	     
	     Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Count the Number of Applications";
			Assert.fail(e.getMessage());
		}
    }
	
	
	@And("^Click on My Account Menu$")
    public void Click_on_My_Account_Menu() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.Myaccount, "Click on My account");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on My account Menu";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Click on My Devices Menu$")
    public void Click_on_My_Devices_Menu() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.MyDevices, "Click on My Devices Menu");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on My Devices Menu";
			Assert.fail(e.getMessage());
		}
    }
	
	
	@And("^Click on My Devices Menu from dashboard$")
    public void Click_on_My_Devices_Menu_from_dashboard() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.MyDevicesmenudashboard, "Click on My Devices Menu");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on My Devices Menu from dashboard";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Verify Data is Present on Devices page$")
    public void Verify_Data_is_Present_on_Devices_page() throws Throwable {
		try {
			KeywordUtil.isWebElementPresent(PreLoginPage.MyDevicesHeadingTag, "Verify Heading Present on Devices page");
			KeywordUtil.click(PreLoginPage.filters, "Click on View all Filter");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify Data is Present on Devices page";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^Click on Change Password Menu$")
    public void Click_on_Change_Password_Menu() throws Throwable {
		try {
			KeywordUtil.clickJS(PreLoginPage.ChangePasswordmenu, "Click on Change Password Menu");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Change Password Menu";
			Assert.fail(e.getMessage());
		} 
    }
	
	@And("^Verify Change Password Heading$")
    public void Verify_Change_Password_Heading() throws Throwable {
		try {
			KeywordUtil.isWebElementPresent(PreLoginPage.ChangePasswordHeading, "Verify Change Password Heading");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Verify Change Password Heading";
			Assert.fail(e.getMessage());
		}
    }
	
	
	 @And("^Enter current and new password for password reset$")
	    public void enter_current_and_new_password_for_password_reset() throws Throwable {
		 try {
			 if(KeywordUtil.waitForVisible(PreLoginPage.currentpassword).equals(null))
			 {
				  new RuntimeException();
			 }
				KeywordUtil.inputText(PreLoginPage.currentpassword, GetExcelData.getPassword(), "Enter current password");
				Thread.sleep(3000);
				KeywordUtil.inputText(PreLoginPage.newpassword, GetExcelData.getPassword(), "Enter new password");
				Thread.sleep(3000);
				KeywordUtil.inputText(PreLoginPage.reenterpassword, GetExcelData.getPassword(), "ReEnter password");
				Thread.sleep(3000);
				KeywordUtil.click(PreLoginPage.updatebutton, "Click on update button");
				Thread.sleep(3000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Verify Change Password functionality";
				Assert.fail(e.getMessage());
			}
	    }
	 @Then("^verify password change message should appear$")
	    public void verify_password_change_message_should_appear() throws Throwable {
		 try {
				if(!KeywordUtil.isWebElementVisible(PreLoginPage.passwordchangemessage, "verify password change message should appear"))
				{
					new RuntimeException();
				}
				Thread.sleep(5000);
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "verify password change message should appear";
				Assert.fail(e.getMessage());
			}
	    }

	@And("^Click on My Apps button$")
    public void Click_on_My_Apps_button() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.MyApps, "Click on My Apps button");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on My Apps button";
			Assert.fail(e.getMessage());
		}
    }
	
	//ONCOCONC
	
	@And("^Click on My Account$")
    public void click_on_My_Accounts() throws Throwable {
		try {
			KeywordUtil.clickJS(PreLoginPage.Menubar, "Click on Menu bar");
			KeywordUtil.clickJS(PreLoginPage.Myaccount, "Click on My account");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on My account Menu";
			Assert.fail(e.getMessage());
		}
    }
	
	// --PLFPassword---------
	@Then("^Click on Primary Email$")
	public void Click_on_primary_email() {
		try {
			KeywordUtil.clickJS(PreLoginPage.PLFPprimaryEmail, "Click on Primary Email");
			
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Email";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on Primary Phone Option$")
	public void Click_on_Primary_phone() {
		try {
			KeywordUtil.clickJS(PreLoginPage.PLFPprimaryPhone, "Click on Primary Phone link");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Phone link";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on forgot Password link$")
	public void Click_on_forgot_password_link() {
		try {
			KeywordUtil.click(PreLoginPage.PLforgotPassword, "Click on Primary Phone link");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Phone link";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Enter Username to Reset Password$")
	public void enter_Username_to_Reset_Password() {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPusername, GetExcelData.getEndUser(), "Enter User Name for login");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter User Name";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on username submit button$")
	public void click_on_username_submit_button() {
		try {
			KeywordUtil.click(PreLoginPage.PLFPsubmit, "Click on username submit button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Username Submit Button";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter invalid Forgot Password Security Answer$")
	public void enter_invalid_forgot_password_security_answer() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPsecurityAnswer, "wronganswer", "Enter invalid Security Answer");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter invalid Security Answer";
			Assert.fail(e.getMessage()); 
		}
	}
	@Then("^Invalid security answer error message should displayed$")
	public void invalid_security_answer_error_message_should_displayed() throws Throwable {
		try {

			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.PreLoginPage.invaliderrormessage,
					"The error message appears if the user enter invalid security answer");
			Thread.sleep(2000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message appears if the user enter invalid security answer";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Enter invalid OTP Received by you in Email$")
	public void enter_invalid_otp_received_by_you_in_email() throws Throwable {
		try {
			KeywordUtil.inputText(PreLoginPage.otpFU, "1234", "Enter invalid OTP.");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter invalid OTP.";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter invalid Phone OTP$")
	public void enter_invalid_phone_otp() throws Throwable {
		try {
			KeywordUtil.inputText(PreLoginPage.otpFU, "1234", "Enter invalid Phone OTP");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter invalid Phone OTP";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter Username to Reset Password \"([^\"]*)\"$")
    public void enter_username_something_to_reset_password(String username) throws Throwable {
        //throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPusername, username, "Enter User Name for login");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter User Name";
			Assert.fail(e.getMessage());
		}
    }
	@And("^Enter security answer$")
	public void enter_security_answer() throws Throwable {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPsecurityAnswer, GetExcelData.getSecurityquetion(),
					"Enter Security Answer");

			KeywordUtil.click(PreLoginPage.PLFPsecuritySubmit, "Enter Security Answer");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Security Answer";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Enter Security Answer$")
	public void Enter_Security_Answerr() {
		try {
			KeywordUtil.inputText(PreLoginPage.securityAnswer, GetExcelData.getSecurityquetion(),
					"Enter Security Answer");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Security Answer";
			Assert.fail(e.getMessage());
		}
	}

	 @And("^Enter Mobile Push OTP$")
	    public void Enter_Mobile_Push_OTP() throws Throwable {
		 try {
				KeywordUtil.inputText(PreLoginPage.mobilePushOTP,
						modules.QLRegistration.MobilePushOTPMessageConnection(OTP, GetExcelData.getEndUser()), "Enter Mobile Push OTP");
				Thread.sleep(2000);
			} catch (Throwable e) {
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Enter Mobile Push OTP";
				Assert.fail(e.getMessage());
			}
	    }
	
	@And("^Click on trust this device checkbox$")
    public void click_on_trust_this_device_checkbox() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.checkbox, "Click on trust this device checkbox");
			Thread.sleep(3000); 
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on trust this device checkbox";
			Assert.fail(e.getMessage());
		}
    }


	@And("^Enter Forgot Password Security Answer$")
	public void Enter_Forgot_Password_Security_Answer() {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPsecurityAnswer, GetExcelData.getSecurityquetion(),
					"Enter Security Answer");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Forgot Password Security Answer";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on Security Submit button$")
	public void Click_on_Security_Submit_button() {
		try {
			KeywordUtil.click(PreLoginPage.PLFPsecuritySubmit, "Click on Security Submit Button");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Security Submit Button";
			Assert.fail(e.getMessage());
		}
	}  

	@When("^Enter Email OTP Received$")
	public void Enter_Email_OTP_Received() {
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.EmailOTPConnection(OTP, GetExcelData.getEndUser()),
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Enter OTP Received by you in Email$")
    public void enter_otp_received_by_you_in_email() throws Throwable {
		try {
			KeywordUtil.inputText(PreLoginPage.otpFU,
					modules.QLRegistration.EmailOTPConnection(OTP, GetExcelData.getEndUser()),
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
    }

	@When("^Submit Email OTP Received$")
	public void Submit_Email_OTP_Received() {
		try {
			KeywordUtil.clickJS(PreLoginPage.PLFPprimaryEmailSubmit, "Click on Submit Button");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit Otp";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter Phone OTP Received$")
	public void Enter_Phone_OTP_Received() {
		try {
			KeywordUtil.inputText(PreLoginPage.otp,
					modules.QLRegistration.PhoneOTPMessageConnection(OTP, GetExcelData.getEndUser()),
					"Enter Phone OTP received in Phone Number");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Phone OTP received in Phone Number";
			Assert.fail(e.getMessage());
		}
	}
	 @And("^Enter Phone OTP Received by you$")
	    public void enter_phone_otp_received_by_you() throws Throwable {
		 try {
				KeywordUtil.inputText(PreLoginPage.otpFU,
						modules.QLRegistration.PhoneOTPMessageConnection(OTP, GetExcelData.getEndUser()),
						"Enter Phone OTP received in Phone Number");
				Thread.sleep(2000);
			} catch (Throwable e) {
				GlobalUtil.e = e; 
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Enter Phone OTP received in Phone Number";
				Assert.fail(e.getMessage());
			}
	    }
	@When("^Submit Phone OTP Received$")
	public void Submit_Phone_OTP_Received() {
		try {
			KeywordUtil.click(PreLoginPage.PLFPprimaryEmailSubmit, "Click on Submit Button");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit Received OTP";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Enter New Password$")
	public void Enter_New_Password() {
		try {
			if (!KeywordUtil.inputText(PreLoginPage.PLFPnewPassword, GetExcelData.getPassword(),
					"Enter New Password")) {
				GlobalUtil.stepname = "Enter New Password";
				Assert.fail(e.getMessage());
			}
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter New Password";
			Assert.fail(e.getMessage());
		}
	}
	@Then("^Enter New Less Secure Password$")
	public void Enter_New_Less_Secure_Password() {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPnewPassword, GetExcelData.getLessSecurePassword(),
					"Enter New Less Secure Password");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter New Less Secure Password";
			Assert.fail(e.getMessage());
		}
	}
	
	@Then("^Enter Confirm Less Secure Password$")
	public void Enter_Confirm_Less_Secure_Password() {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPconfirmPassword, GetExcelData.getLessSecurePassword(),
					"Enter Confirm Less Secure Password");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Confirm Less Secure Password";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Enter Confirm Password$")
	public void Enter_Confirm_Password() {
		try {
			KeywordUtil.inputText(PreLoginPage.PLFPconfirmPassword, GetExcelData.getPassword(),
					"Enter Confirm Password");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Confirm Password";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on submit password button$")
	public void Click_on_submit_password_button() {
		try {
			KeywordUtil.click(PreLoginPage.PLFPcreatePassword, "Click on submit password button");
			Thread.sleep(15000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on submit password button";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^User should redirect to login page$")
	public void user_should_redirect_to_login_page() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.waitForVisible(By.cssSelector("#branding-sumbit-button"));
			KeywordUtil.isWebElementPresent(PreLoginPage.signin, "User is on Login Page");
			Thread.sleep(5000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "User is on Login Page";
			Assert.fail(e.getMessage());
		}
	}

	// PreLogin EndUser Forgot UserName

	@And("^Click on Forgot UserName link$")
	public void click_on_forgot_username_link() throws Throwable {
		// throw new PendingException();
		try {
			KeywordUtil.click(PreLoginPage.forgotusername, "Click on Forgot UserName linkn");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Forgot UserName link";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter email address for forgot username \"([^\"]*)\"$")
    public void enter_emailaddress_to_reset_password(String username) throws Throwable {
        //throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.enduseremail, username, "Enter Email Address of EndUser");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Email Address of EndUser";
			Assert.fail(e.getMessage());
		}
    }
	@And("^Enter email address for UserName Recovery$")
	public void enter_email_address_for_username_recovery() throws Throwable {
		try {
			KeywordUtil.inputText(PreLoginPage.enduseremail, GetExcelData.getEmailAddress(), "Enter Email Address of EndUser");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Email Address of EndUser";
			Assert.fail(e.getMessage());
		}
	}

	@And("^Click on Submit$")
	public void click_on_submit() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.submitbutton, "Click on Submit");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit";
			Assert.fail(e.getMessage());
		}
	}
 
	@Then("^Click on Primary Email Address$")
	public void click_on_primary_email_address() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.primaryemail, "Click on Primary Email Address");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Email Address";
			Assert.fail(e.getMessage());
		}
	} 

	@And("^Submit OTP$")
	public void submit_email_otp() throws Throwable {
		try {
			KeywordUtil.clickJS(PreLoginPage.PLFUsersubmit, "Click on Submit Button");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit Button";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Click on Phone Option$")
	public void click_on_phone_option() throws Throwable {
		try {
			KeywordUtil.click(PreLoginPage.PLFUserprimaryphone, "Click on Primary Phone link");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Primary Phone link";
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Navigate to End User Login Page$")
	public void navigate_to_enduser_login_page() throws Throwable {

		System.out.println(GetExcelData.getPreLoginURL() + "getPreLoginURL value");
		try {
			navigateToUrl(GetExcelData.getPreLoginURL(), "Navigate to End User Login Page");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to End User Login Page";
			Assert.fail(e.getMessage());
		}
	}
}
