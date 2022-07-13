package quicklaunchpages;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static By loginHere=By.cssSelector(".register-form h6 > a");
	public static By email=By.cssSelector("#login-username");
	public static By emaill=By.cssSelector("#branding-username");
	public static By password=By.cssSelector("#login-password");
	public static By passwordd=By.cssSelector("#branding-password");
	public static By login=By.xpath("//*[@id=\"submitButton\"]");
	public static By loginAlert=By.cssSelector("#login-alert");
	public static By emailAlert=By.cssSelector(".validation-section div:nth-child(2) span");
	public static By passwordAlert=By.xpath("//div[@class='validation-messages']");
	public static By forgotPassword=By.cssSelector("div:nth-child(2) span a");
	public static By emailAddress=By.cssSelector("#email");
	public static By send=By.cssSelector("#btn-signup");
	public static By newPassword=By.cssSelector("#password");
	public static By confirmPassword=By.cssSelector("#confirm-password");
	public static By otp=By.cssSelector("#otp");
	public static By verify=By.cssSelector(".btn-primary.btn-width-sm");
	public static By profile=By.cssSelector(".pull-right >div > div");
	public static By signOut=By.xpath("//a[contains(text(),'Sign Out')]");
	public static By termsConditions=By.cssSelector("a[href='https://www.quicklaunchsso.com/terms-and-conditions.html']");
	public static By registrationlink=By.cssSelector("a[href='/admin/registration']");
	
	//Forgot password
	public static By forgotpasswordError=By.xpath("//span[text()='Please enter a valid email address!']");
	public static By passwordmismach=By.xpath("//span[text()='Passwords do not match']");
	public static By passwordcomplexity=By.xpath("//span[text()='Password complexity requirements must be met before proceeding!']");
	public static By invalidotperror=By.xpath("//span[text()='Invalid verification code']");
	public static By eyeclick=By.xpath("//*[@class='input-group-addon']");
	public static By passwordvisible=By.xpath("//*[@id='password'][@type='text']");
	public static By passwordinvisible=By.xpath("//*[@id='password'][@type='password']");
	

	//PWMS 
	public static By pwmslogin=By.xpath("//input[@id='form-password']");
	public static By phonerecovery=By.cssSelector("#openPhoneRecovery");
	public static By pwmssign=By.xpath("//*[@id='submit-button']");
	
	
	///Add admins
	public static By configureDirectoryTab=By.xpath("//h3[normalize-space()='Configure directory']");
	public static By addNewDirectory=By.xpath("//a[normalize-space()='Add new directory']");

	public static By connectionName=By.cssSelector("#connectionName");
	public static By userNameAD=By.cssSelector("#userName");
	public static By passwordAD=By.xpath("//input[@id='password']");
	public static By connectionUrl=By.cssSelector("#connectionUrl");
	public static By baseDn=By.cssSelector("#baseDn");
	public static By userEntryObjectClass=By.cssSelector("#userEntryObjectClass");
	public static By userSearchFilter=By.cssSelector("#userSearchFilter");
	public static By userListFilter=By.cssSelector("#userListFilter");
	public static By passwordAttribute=By.cssSelector("#passwordAttribute");
	
	public static By emailAttribute=By.cssSelector("#emailAttribute");
	public static By TestConnectivity=By.cssSelector("button[ng-click='vm.testConnectivity()']");
	public static By saveConnectivity=By.cssSelector("button[ng-click='vm.saveDirectory()']");
	public static By syncLinkConnectivity=By.cssSelector("a[ng-click='vm.syncUserGroup()']");
	
	public static By deleteCreatedAD=By.cssSelector("tbody tr:nth-child(2) td:nth-child(3) a:nth-child(2) i:nth-child(1)");
	public static By ConfirmdeleteCreatedAD=By.cssSelector("button[ng-click='delete(vm.dirIdToDelete)']");

}	
