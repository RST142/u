package step_defination;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import quicklaunchpages.TenantPolicy;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class PostExecution {
	
	@When("^Click on delete icon$") 
	public void Click_on_delete_icon() { 
		try {
			KeywordUtil.click(TenantPolicy.deleteIcon, "Click on delete icon");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on delete icon";
			Assert.fail(e.getMessage());
		}      
	}   
	 @Then("^Click on delete icon of policy$")
	    public void click_on_delete_icon_of_policy() throws Throwable {
		 try { 
				KeywordUtil.click(TenantPolicy.deleteIconofwithoutmfa, "Click on delete icon");
			} catch (Throwable e) {
				GlobalUtil.e = e;
				GlobalUtil.ErrorMsg = e.getMessage();
				GlobalUtil.stepname = "Click on delete icon";
				Assert.fail(e.getMessage());
			}
	    }
	@When("^Click on delete button$")
	public void Click_on_delete_button() {
		try {
			KeywordUtil.click(TenantPolicy.deleteButton, "Click on delete icon");
		} catch (Throwable e) {
			GlobalUtil.e = e;
			GlobalUtil.ErrorMsg = e.getMessage();
			GlobalUtil.stepname = "Click on delete icon";
			Assert.fail(e.getMessage());
		}
	} 

}
