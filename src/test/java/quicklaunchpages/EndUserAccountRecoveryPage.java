package quicklaunchpages;

import org.openqa.selenium.By;

public class EndUserAccountRecoveryPage {
	public static By securitydropdown=By.xpath("//*[@name='question0']");
	public static By Securityanswer=By.xpath("//*[@name='anwser0']");
	
	//Email
	public static By Emailtextfield=By.xpath("//*[@id='emailForRecovery']");
	public static By verifybutton=By.xpath("//button[text()='Verify']");
	
	public static By submitbutton=By.xpath("//*[@class='btn btn-primary'][text()='Submit']");
	//*[@id="Security-Questions-checkbox"]
	public static By securitycheckbox=By.xpath("//*[@id='Security-Questions-checkbox']/following-sibling::span");
	
	public static By primaryemailcheckbox=By.xpath("//*[@id='Primary-Email-checkbox']/following-sibling::span");
	
	public static By primaryphone=By.xpath("//*[@id='Primary-Phone-checkbox']/following-sibling::span");
	
			public static By clearbutton=By.cssSelector("button[ng-click='vm.openConfirmationWindow()']");
			
			public static By emailinputtext=By.xpath("//*[@id='password-id']");
			
			public static By submitbuttonafterotp=By.xpath("//*[@class=\"btn btn-warning comm-btn mrg-B20\"]");
			
			public static By countrydropdown=By.xpath("//*[@name=\"country\"][@ng-model=\"vm.countryName\"]");
			
			public static By phonenumbertext=By.xpath("//*[@id=\"phoneNumber-To-Verify\"]");
			
					public static By phoneverificationbutton=By.cssSelector("button[class='btn btn-primary comm-btn mrg-T30']");
					
					public static By phoneinputtext=By.xpath("//*[@id=\"phoneValidationCode\"]");
					
					public static By verybutton=By.xpath("//button[@class='btn btn-warning comm-btn']");
}
