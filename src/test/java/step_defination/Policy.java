package step_defination;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pojo.GetExcelData;
import quicklaunchpages.AccountCreationPage;
import quicklaunchpages.LoginPage;
import quicklaunchpages.PreLoginPage;
import quicklaunchpages.TenantPolicy;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

public class Policy extends KeywordUtil {
	boolean elm;
	@And("^Verify user navigate to policy page$")
	public void navigate_to_policy_page() throws Throwable { 
		
		try { 
			navigateToUrl(GetExcelData.getPolicyPage(), "Navigate to Policy Page");
			Thread.sleep(5000); 
		} catch (Throwable e) {
			GlobalUtil.e = e;  
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Navigate to Policy Page";
			Assert.fail(e.getMessage());
		}         
	}          
	@When("^Click on delete icon to delete policy$")  
	public void Click_on_delete_icon() { 
		try {
			By locator=TenantPolicy.policycount; 
			
		List<WebElement> aa=	KeywordUtil.getListElements(locator, "list of iteam");
			for(int i=0;i<5;i++) {
				elm = KeywordUtil.isWebElementPresentt(locator);
				if(elm) {
				KeywordUtil.click(TenantPolicy.deleteIcon, "Click on delete icon");
				KeywordUtil.click(TenantPolicy.deleteButton, "Click on delete icon");
				}
				else
				{
					break;
				}
				 }
				 
			
			
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on delete icon";
			Assert.fail(e.getMessage());
		}   
	} 
  
	@When("^Click on SSO Tab$")
	public void Click_on_SSO_Tab() {
		try {
			KeywordUtil.clickJS(TenantPolicy.SSO, "Click on SSO Tab");
			Thread.sleep(3000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on SSO Tab";
			Assert.fail(e.getMessage());
		}
	} 
	 @Then("^Click on edit icon of defalut policy$")
	    public void click_on_edit_icon_of_defalut_policy() throws Throwable {
	       // throw new PendingException();
		 try {
				KeywordUtil.click(TenantPolicy.editdefaultPolicy, "Click on edit policy icon");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on edit policy icon";
				Assert.fail(e.getMessage());
			}
	    }
	@When("^Click on Add Policy button$")
	public void Click_on_Add_Policy_button() {
		try {
			KeywordUtil.clickJS(TenantPolicy.AddPolicy, "Click on Add button");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Add Button";
			Assert.fail(e.getMessage());
		}
	}
	@Then("^update User Group$")
    public void update_user_group() throws Throwable {
		try {
			KeywordUtil.clickJS(TenantPolicy.groupclear, "Update User Group");
			KeywordUtil.inputText(TenantPolicy.UserGroup, GetExcelData.getUserGroup(), "Select User Group");
		    KeywordUtil.pressEnter(TenantPolicy.UserGroup);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update User Group";
			Assert.fail(e.getMessage());
		}
    }
	@When("^Select MFA cardinality$")
	public void Select_MFA_cardinality() {
		try {
			Thread.sleep(2000);
			KeywordUtil.clickJS(TenantPolicy.cardinality, "Select MFA cardinality");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select MFA cardinality";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Add policy name$")
	public void Add_policy_name() {
		try {
			KeywordUtil.inputText(TenantPolicy.policyName, GetExcelData.getPolicyName(), "Add policy name");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Add policy name";
			Assert.fail(e.getMessage());
		}
	} 

	@When("^Select Policy Status$")
	public void Select_Policy_Status() {
		try {
			KeywordUtil.click(TenantPolicy.policyStatus, "Select Policy Status");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Policy Status";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select User Group$")
	public void Select_User_Group() {
		try {
			KeywordUtil.inputText(TenantPolicy.UserGroup, GetExcelData.getUserGroup(), "Select User Group");
		    KeywordUtil.pressEnter(TenantPolicy.UserGroup);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select User Group";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Security Question Eligible factor$")
	public void Select_Security_Question_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.securityQuestion, "Required", "Select Security Question Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Security Question Eligible factor";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Phone Validation Eligible factor$")
	public void Select_Phone_Validation_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.phoneValidation, "Required", "Select Phone Validation Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Phone Validation Eligible factor";
			Assert.fail(e.getMessage());
		}
	}

	@When("^Select Email Validation Eligible factor$")
	public void Select_Email_Validation_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Required", "Select Email Validation Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Select Email Validation Eligible factor";
			Assert.fail(e.getMessage());
		}
	}
	
	 @Then("^Update policy for Security Question Eligible factor$")
	    public void update_policy_for_security_question_eligible_factor() throws Throwable {
	      //  throw new PendingException();
			try {
				KeywordUtil.selectByValue(TenantPolicy.securityQuestion, GetExcelData.getSecurityQuetion(), "Update Security Question Eligible factor");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Update Security Question Eligible factor";
				Assert.fail(e.getMessage());
			}
	    }

	    @Then("^Update policy for Phone Validation Eligible factor$")
	    public void update_policy_for_phone_validation_eligible_factor() throws Throwable {
	       // throw new PendingException();
	    	try {
				KeywordUtil.selectByValue(TenantPolicy.phoneValidation, GetExcelData.getPhoneoption(), "Update Phone Validation Eligible factor");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Update Phone Validation Eligible factor";
				Assert.fail(e.getMessage());
			}
	    }
 
	    @Then("^Update policy for Email Validation Eligible factor$")
	    public void update_policy_for_email_validation_eligible_factor() throws Throwable {
	       // throw new PendingException();
	    	try {
				KeywordUtil.selectByValue(TenantPolicy.emailValidation, GetExcelData.getEmailoption(), "Update Email Validation Eligible factor");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Update Email Validation Eligible factor";
				Assert.fail(e.getMessage());
			}
	    }
	    @Then("^Update policy for MobilePush Validation Eligible factor$")
	    public void update_policy_for_MobilePush_validation_eligible_factor() throws Throwable {
	       // throw new PendingException();
	    	try {
				KeywordUtil.selectByValue(TenantPolicy.mobilePushValidation, GetExcelData.getMobilePushoption(), "Update MobilePush Validation Eligible factor");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Update MobilePush Validation Eligible factor";
				Assert.fail(e.getMessage());
			}
	    }
	    
	@When("^Click on Save button$")
	public void Click_on_Save_button() {
		try {
			Thread.sleep(2000);
			KeywordUtil.clickJS(TenantPolicy.savebutton, "Click on Save button");
			Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Save button";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Click on edit policy icon$")
	public void Click_on_edit_policy_icon() {
		try {
			KeywordUtil.click(TenantPolicy.editPolicy, "Click on edit policy icon");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on edit policy icon";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Click on Suspicious Activities$")
	public void Click_on_Suspicious_Activities() {
		try {
			KeywordUtil.clickJS(TenantPolicy.suspicious, "Click on Suspicious Activities");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Suspicious Activities";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Click on Every Login$")
	public void Click_on_Every_Login() {
		try {
			KeywordUtil.clickJS(TenantPolicy.suspicious, "Click on every Login radio button");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on Every Login Radio button";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Update Policy Name$")
	public void Update_Policy_Name() {
		try {
			KeywordUtil.clearInput(TenantPolicy.policyName);
		    Thread.sleep(3000);
			KeywordUtil.inputText(TenantPolicy.policyName, GetExcelData.getPolicyName(), "Add policy name");

		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update policy name";
			Assert.fail(e.getMessage());
		}
	}
	//OC
	@When("^Edit User Group$")
	public void Edit_User_Group() {
		try {
			KeywordUtil.clearInput(TenantPolicy.UserGroup);
			Thread.sleep(3000);
			KeywordUtil.inputText(TenantPolicy.UserGroup, QuickLaunch.dataMap.get("UserGroup"), "Edit User Group");
			KeywordUtil.pressEnter(TenantPolicy.UserGroup);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Edit User Group";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Update Security Question Eligible factor$")
	public void Update_Security_Question_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.securityQuestion, "Optional", "Update Security Question Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Security Question Eligible factor";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Update Security Question Eligible factor Required$")
	public void Update_Security_Question_Eligible_factor_Required() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.securityQuestion, "Optional", "Update Security Question Eligible factor");
			KeywordUtil.selectByValue(TenantPolicy.securityQuestion, "Required", "Update Security Question Eligible factor Required");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Security Question Eligible factor Required";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Update Phone Validation Eligible factor$")
	public void Update_Phone_Validation_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.phoneValidation, "Optional", "Update Phone Validation Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Phone Validation Eligible factor";
			Assert.fail(e.getMessage());
		}
	}
	
	@When("^Update Phone Validation Eligible factor Required$")
	public void Update_Phone_Validation_Eligible_factor_Required() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.phoneValidation, "Optional", "Update Phone Validation Eligible factor");
			KeywordUtil.selectByValue(TenantPolicy.phoneValidation, "Required", "Update Phone Validation Eligible factor Required");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Phone Validation Eligible factor Required";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Update Email Validation Eligible factor$")
	public void Update_Email_Validation_Eligible_factor() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Optional", "Update Email Validation Eligible factor");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Email Validation Eligible factor";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Update Email Validation Eligible factor Required$")
	public void Update_Email_Validation_Eligible_factor_Required() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Optional", "Update Email Validation Eligible factor");
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Required", "Update Email Validation Eligible factor Required");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Email Validation Eligible factor Required";
			Assert.fail(e.getMessage());
		}
	}
	@When("^Update Email Validation Eligible factor Disabled$")
	public void Update_Email_Validation_Eligible_factor_Disabled() {
		try {
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Optional", "Update Email Validation Eligible factor");
			KeywordUtil.selectByValue(TenantPolicy.emailValidation, "Disabled", "Update Email Validation Eligible factor Disabled");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Update Email Validation Eligible factor Disabled";
			Assert.fail(e.getMessage());
		}
	}
	@And("^Enter Password for End User$")
    public void enter_password_for_end_user() throws Throwable {
      //  throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.password, GetExcelData.getEndUserPassword(), "Enter User Password");
		    Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Enter User Password";
			Assert.fail(e.getMessage());
		}
    }
	
	@And("^ReEnter Password for End User$")
    public void ReEnter_password_for_end_user() throws Throwable {
      //  throw new PendingException();
		try {
			KeywordUtil.inputText(PreLoginPage.EnduserPassword, GetExcelData.getEndUserPassword(), "Enter User Password");
		    Thread.sleep(4000);
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "ReEnter User Password";
			Assert.fail(e.getMessage());
		}
    }
}



