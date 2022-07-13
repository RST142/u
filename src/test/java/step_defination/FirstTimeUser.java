package step_defination;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojo.GetExcelData;
import quicklaunchpages.CpsLoginPage;
import quicklaunchpages.LoginPage;
import quicklaunchpages.PreLoginPage;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;
public class FirstTimeUser {
	String OTP;
	@And("^Click on First Time User link$")
    public void click_on_first_time_user_link() throws Throwable {
       // throw new PendingException();
		try {
			KeywordUtil.clickJS(quicklaunchpages.FirstTimeUser.Firsttimeuser, "Click on First Time User link");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on First Time User link";
			Assert.fail(e.getMessage());
		}
    }        
    
    @And("^Enter Username in Inputfield$")
    public void Enter_Username_in_Inputfield() throws Throwable {
        //throw new PendingException();
    	try {
			KeywordUtil.inputText(quicklaunchpages.FirstTimeUser.answer, GetExcelData.getEndUser(), "Enter Username in Inputfield");
		    Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Enter Username in Inputfield";
			Assert.fail(e.getMessage());
		}
    }

    @And("^Click on Submit Button$")
    public void click_on_submit_button() throws Throwable {
       // throw new PendingException();
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.submitbutton, "Click on Submit Button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Submit Button";
			Assert.fail(e.getMessage());
		}
    }
    @And("^Click on Email link$")
    public void click_on_email_link() throws Throwable {
        //throw new PendingException();
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.emailclick, "Click on Email link");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Email link";
			Assert.fail(e.getMessage());
		}
    }
    
    
    @And("^Enter Invalid Email OTP$")
    public void enter_invalid_email_otp() throws Throwable {
    	try {
			KeywordUtil.inputText(quicklaunchpages.FirstTimeUser.verificationcode, "1234",
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
    }
    @And("^Enter Email OTP$")
    public void enter_email_otp() throws Throwable {
    	try {
			KeywordUtil.inputText(quicklaunchpages.FirstTimeUser.verificationcode, modules.QLRegistration.EmailOTPConnection(OTP,GetExcelData.getEndUser()),
					"Enter OTP received in Email");
			Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter OTP received in Email";
			Assert.fail(e.getMessage());
		}
    } 
   
    @And("^Submit the OTP$")
    public void submit_the_otp() throws Throwable {
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.submit, "Click on Submit Button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Click on Submit Button";
			Assert.fail(e.getMessage());
		}
    }
    
    @And("^Click on Send me an Email Option$")
    public void click_on_send_me_an_email_option() throws Throwable {
        //throw new PendingException();
    	
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.sendmeanemail, "Click on Send me an Email Option");
			
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Click on Send me an Email Option";
			Assert.fail(e.getMessage());
		}
    }
    //Regression suites for FTU
    @And("^Enter Invalid Username in Inputfield$")
    public void enter_invalid_username_in_inputfield() throws Throwable {
    	try {
			KeywordUtil.inputText(quicklaunchpages.FirstTimeUser.answer, GetExcelData.getInvalidFullName(), "Enter Invalid Username in Inputfield");
		    Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Enter Invalid Username in Inputfield";
			Assert.fail(e.getMessage());
		}
    }
    @Then("^The error message appears if the user name is not the first time user$")
    public void the_error_message_appears_if_the_user_name_is_not_the_first_time_user() throws Throwable {
        //throw new PendingException();
    	
    	try {

			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.FirstTimeUser.invalidusername,
					"The error message appears if the user name is not the first time user");
			Thread.sleep(2000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message appears if the user name is not the first time user";
			Assert.fail(e.getMessage());
		}
    	
    }
    @Then("^The error message appears if the user entered invalid user name$")
    public void the_error_message_appears_if_the_user_entered_invalid_user_name() throws Throwable {
    	try {

			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.FirstTimeUser.invalidusername,
					"The error message appears if the user entered invalid user name");
			Thread.sleep(2000);

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "The error message appears if the user entered invalid user name";
			Assert.fail(e.getMessage());
		}
    }
    @Then("^Click on back button on submitting necessary information wizard$")
    public void verify_the_back_button_functionality_on_submitting_necessary_information_wizard() throws Throwable {
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Click on Back Button";
			Assert.fail(e.getMessage());
		}
    }
    @Then("^User should navigate to previous page$")
    public void user_should_navigate_to_previous_page() throws Throwable {
       // throw new PendingException();
    	try {
			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.FirstTimeUser.backbutton, "User should navigate to previous page");
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "User should navigate to previous page";
			Assert.fail(e.getMessage());
		}
    }
    
    @Then("^The error message appears if the user entered an invalid OTP$")
    public void the_error_message_appears_if_the_user_entered_an_invalid_otp() throws Throwable {
    	try {
			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.FirstTimeUser.invalidotp, "The error message appears if the user entered an invalid OTP");
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "The error message appears if the user entered an invalid OTP";
			Assert.fail(e.getMessage());
		}
    }
    
    @Then("^The error message appears when user entered an invalid OTP$")
    public void the_error_message_appears_when_user_entered_an_invalid_otp() throws Throwable {
    	try {
			KeywordUtil.verifyDisplayAndEnable(quicklaunchpages.FirstTimeUser.invalidotpcode, "The error message appears if the user entered an invalid OTP");
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "The error message appears if the user entered an invalid OTP";
			Assert.fail(e.getMessage());
		}
    }
    @And("^Click on Send me a Text Message Option$")
    public void click_on_send_me_a_text_message_option() throws Throwable {
        //throw new PendingException();
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.sendmetext, "Click on Send me a Text Message Option");
			
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Click on Send me a Text Message Option";
			Assert.fail(e.getMessage());
		}
    }
    @And("^Click on Phone Verification Option link$")
    public void click_on_phone_verification_option() throws Throwable {
    	try {
			KeywordUtil.click(quicklaunchpages.FirstTimeUser.phoneclick, "Click on Phone Verification Option link");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Phone Verification Option link";
			Assert.fail(e.getMessage());
		}
    
    }
    @And("^Enter Invalid Confirm Password$")
    public void enter_invalid_confirm_password() throws Throwable {
    	try {
			KeywordUtil.inputText(PreLoginPage.PLFPconfirmPassword, "Tester@12", "Enter Confirm Password");
		    Thread.sleep(2000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter Confirm Password";
			Assert.fail(e.getMessage());
		}
	
    }
    @Then("^The error message appears if the user does not meet the password policy requirement$")
    public void the_error_message_appears_if_the_user_does_not_meet_the_password_policy_requirement() throws Throwable {
    	try {
    		
			if(GlobalUtil.Environment.equals("Preprod") && KeywordUtil.isWebElementPresent(quicklaunchpages.FirstTimeUser.lowsecurity, "The new password does not meet Password Policy requirements or something went wrong"))
			{
				HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor("The new password does not meet Password Policy requirements or something went wrong"));
			}
			else if(GlobalUtil.Environment.equals("Production") && KeywordUtil.verifyDisplayAndEnabled(quicklaunchpages.FirstTimeUser.prodlowsecurity, "The new password does not meet Password Policy requirements or something went wrong"))
			{
				HTMLReportUtil.logger.log(Status.PASS, HTMLReportUtil.passStringGreenColor("The new password does not meet Password Policy requirements or something went wrong"));
				
				
			}
			else
			{
				GlobalUtil.stepname = "The error message appears if the user does not meet the password policy requirement";
				Assert.fail();
			}
			//KeywordUtil.(quicklaunchpages.FirstTimeUser.backbutton, "Click on Back Button");
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "The error message appears if the user does not meet the password policy requirement";
			Assert.fail(e.getMessage());
		}
    }

    @Then("^Submit button should be disabled$")
    public void submit_button_should_be_disabled() throws Throwable {
    	try {
    		if(!GlobalUtil.getDriver().findElement(PreLoginPage.PLFPcreatePassword).isEnabled())
			System.out.println("Submit button should be disabled");
		    Thread.sleep(15000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Submit button should be disabled";
			Assert.fail(e.getMessage());
		}
    }
    @And("^Enter Username which is not FTU$")
    public void enter_username_which_is_not_ftu() throws Throwable {
    	try {
			KeywordUtil.inputText(quicklaunchpages.FirstTimeUser.answer, "midland2", "Enter Username in Inputfield");
		    Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage(); 
			GlobalUtil.stepname = "Enter Username in Inputfield";
			Assert.fail(e.getMessage());
		}
    }
}
