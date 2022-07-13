package quicklaunchpages;

import org.openqa.selenium.By;

public class FirstTimeUser {
	 public static By Firsttimeuser=By.cssSelector("li:nth-child(1) a:nth-child(1)");
	// public static By answer=By.xpath("//*[@class=\"form-group\"]/label[text()=\"Answer\"]/following-sibling::input");
	 public static By answer=By.xpath("//*[@ng-change='vm.userInputChanged(attribute.id)']");
	// public static By submitbutton=By.xpath("//*[@id='firstTimeUserModal']/div[2]/div/div[2]/form/div[2]/button[3]");
	 public static By submitbutton=By.xpath("//button[text()='Submit'][@ng-show='vm.showSubmitButton']");
	// public static By emailclick=By.xpath("//*[@id='ftuEmailAuthModal']/div[2]/div/div/div[3]/div/div[1]/a/div");
	 public static By emailclick=By.cssSelector("div[class='box custom-box tooltip-user'] div[class='input-group w100p']");
	 public static By verificationcode=By.xpath("//*[@id='Verification-Code']");
	
	// public static By submit=By.xpath("//*[@id='ftuEmailAuthModal']/div[2]/div/div/div[4]/div[6]/button");
	 
	 public static By submit=By.cssSelector("div[class='pos-relative'] button[type='button']");
	 
	 //Prerequisite 
	 
			 public static By typeusername=By.cssSelector("input[type='text']");
			 public static By searchbutton=By.cssSelector("div[class='col-md-4 pad-T20'] button[type='button']");
			 public static By deleteuser=By.cssSelector("div[class='col-sm-12 marg-B40'] button:nth-child(2)");
			 public static By clearuser=By.cssSelector("div[id='clearConfirmationModal'] button:nth-child(1)");
			 
			 
			 
			 public static By existinguser=By.xpath(" Looks like you are not a First Time User. Please use the Forgot Password option or contact the Helpdesk/Administrator for further assistance.");
			 public static By invalidusername=By.cssSelector("div[class='notifyjs-bootstrap-base notifyjs-bootstrap-error'] span");
			 public static By backbutton=By.cssSelector(" button[ng-click='vm.showOptionalFtuModal()']");
			 public static By invalidotpcode=By.cssSelector("div[class='pos-relative'] span[class='ng-binding']");
			 public static By invalidotp=By.xpath("//span[text()=\"Invalid verification code\"]");
			// public static By invalidotpcode=By.xpath("//span[text()=\"invalid verification code\"]");

			 
			 public static By sendmeanemail=By.cssSelector("div[id='ftuOptionalAuthModal'] div[class='password-recovery-box'] div:nth-child(1)");
			 public static By sendmetext=By.cssSelector(" div[class='box tooltip-user pad-A15'] a[aria-label='Send me a Text Message']");
			 
					// public static By phoneclick=By.cssSelector("div[ng-show='! vm.showPinVerification'] a[aria-label='Primary phone *******449931']");
			 public static By phoneclick=By.cssSelector("div[ng-show='! vm.showPinVerification'] a[aria-label='Primary phone ******0412']");
						 
			 public static By prodphoneclick=By.cssSelector("div[ng-show='! vm.showPinVerification'] a[aria-label='Primary phone Box']");
				
					 public static By mismatcherror=By.xpath("//*[@id=\"creat-password\"]/div[4]/div[3]/span[text()='Passwords do not match']");
					
					 
					 public static By lowsecurity=By.xpath("//div[@class='col-xs-12']//span[contains(text(),'The new password does not meet Password Policy req')]");
					 public static By passwordchangeconferm=By.xpath("//*[@id=\"passwordChangeResultModal\"]/div/div/div/div[2]/div/p");
					 public static By prodlowsecurity=By.xpath("//*[@id=\"createPasswordModal\"]/div/div/div[1]/div/div/div/div[2]/div/span[text()=\"The new password does not meet Password Policy requirements or something went wrong\"]");
					
					
}
