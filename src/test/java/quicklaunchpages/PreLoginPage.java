package quicklaunchpages;

import org.openqa.selenium.By;

public class PreLoginPage {

	public static By username = By.cssSelector("#branding-username");
	public static By password = By.cssSelector("#branding-password");
	public static By signin = By.cssSelector("#branding-sumbit-button");
	public static By securityQuestion = By.xpath("//*[contains(text(),' Use Security Questions')]");
	
	public static By mobilePush = By.xpath("//*[contains(text(),' Use Mobile Push')]");
	public static By mobilePushLink = By.cssSelector("#unifyedMobilePush");
	public static By mobilePushOTP = By.cssSelector("#unifyedMobilePushId");

	public static By sendMeEmail = By.xpath("//*[contains(text(),' Send me an Email')]");
	public static By sendMeTextMessage = By.xpath("//*[contains(text(),' Send me a Text Message')]");
	public static By googleAuth = By.xpath("//*[contains(text(),' Use Google Authenticator')]");
	public static By securityAnswer = By.xpath("//input[@id='securityAnswer']");
	public static By skip = By.xpath("//button[contains(text(),'Skip')]");
	public static By back = By.xpath("//button[contains(text(),'Back')]");
	
	public static By submitMobilePushOTP=By.xpath("//button[@ng-click='temp.validateSecurityCodeError=false;validateUnifyedMobilePushVerificationCode()']");
	
	public static By submit = By.cssSelector("button:nth-child(4)");

	public static By submitemailotp = By
			.xpath("//*[@id='validateSecurityCodeModal']//button[contains(text(),'Submit')]");
	public static By submitGAotp = By
			.xpath("//div[@id='validateGASecurityCodeModal']//button[contains(text(),'Submit')]");
	public static By primaryEmail = By.xpath("//input[@id='primary']");
	public static By otp = By.cssSelector("#otpValidation");
	public static By otpFU = By.xpath("//input[@placeholder='Enter verification code']");
	public static By primaryPhone = By.xpath("//input[@id='primaryPhone']");
	public static By header = By.xpath("//div[@id='user-menu']");
	public static By gaOTP = By.cssSelector("#gaOTPValidation");
	public static By emailmfa = By.cssSelector("#primary");

	// PLFPassword
	public static By PLforgotPassword = By.xpath("//*[contains(text(),'Forgot Password')]");
	public static By PLFPusername = By.xpath("//input[@id='enter-username1']");
	public static By PLFPsubmit = By.xpath("//*[@id=\"userNameAcceptModal\"]//button[2]");
	public static By PLFPsecurityAnswer = By.xpath("//input[@id='Answer0']");
	public static By PLFPsecuritySubmit = By
			.xpath("//*[@id='securityQuestionModal']//button[contains(text(),'Submit')]");
	public static By PLFPprimaryEmail = By.xpath("//*[@id='primary-Email']");
//	public static By PLFPprimaryPhone=By.xpath("//*[@id='primary-Phone']");

	public static By PLFPprimaryPhone = By.xpath("//*[@for=\"primary-Phone\"]/following-sibling::input");

	// public static By
	// PLFPprimaryEmailSubmit=By.xpath("//*[@id=\"validateSecurityCodeModal\"]/div[2]/div/div/div[5]/div[5]/button");
	public static By PLFPprimaryEmailSubmit = By
			.xpath("//div[@class='display-in pull-right'][@ng-show='!vm.forgotUserName']/button");
	// public static By PLFPnewPassword=By.cssSelector("#NewPassword");
	public static By PLFPnewPassword = By.xpath("//*[@type=\"password\"][@placeholder=\"New password\"]");
	// public static By PLFPconfirmPassword=By.cssSelector("#confirm-Password");
	public static By PLFPconfirmPassword = By.xpath("//*[@type=\"password\"][@placeholder=\"Confirm password\"]");
	public static By PLFPcreatePassword = By
			.xpath("//form[@class='ng-dirty ng-valid-parse ng-valid ng-valid-required']//button[@type='button']");

//ended

	// PLFUserName

	public static By forgotusername = By.cssSelector("li:nth-child(3) a:nth-child(1)");
	public static By enduseremail = By.xpath("//*[@id='enter-email']");
	public static By submitbutton = By.cssSelector("div[id='userNameAcceptModal'] button:nth-child(1)");
	// public static By primaryemail=By.xpath("//*[@id='primary-email']");
	// public static By primaryemail=By.xpath("//*[@id='primaryEmail']");
	public static By primaryemail = By.xpath(" //*[@id=\"validateSecurity-secondary-box\"]/input");
	public static By PLFUsersubmit = By.xpath(
			"//button[text()='Submit'][@ng-click='vm.temp.validateSecurityCodeError=false;vm.validateSecurityCode()']");
	// public static By PLFUserprimaryphone=By.xpath("//*[@id='primary-phone']");
	public static By PLFUserprimaryphone = By.xpath("//*[@for=\"primary-phone\"]/following-sibling::input");

	// ONC End user
	public static By EnduserPassword = By.xpath("//input[@id='form-password']");
	public static By submitPassword = By.xpath("//button[normalize-space()='Sign in']");
	public static By AccountRecovery = By.xpath("//h1[contains(text(),'Account Recovery Settings')]");
	public static By SecurityTab = By.cssSelector("#openSecurityQuestion");
	public static By EmailTab = By.cssSelector("#openEmailRecovery");
	public static By PhoneTab = By.cssSelector("#openPhoneRecovery");

	// ONCOCONC
	//public static By Menubar = By.xpath("//*[@class=\"dropdown-toggle\"]");
	public static By Menubar = By.xpath("//*[@class=\"user-icon\"]");
	public static By Myaccount = By.cssSelector("a[ng-click='myAccount()']");

	// PostLogin
	public static By PostLoginMenubar = By.xpath("//*[@id=\"user-menu\"]/div/ul/li/a/span[2]");
	public static By MyDevices = By.cssSelector("#user-menu > div > ul > li > ul > li:nth-child(3) > a");
	
	public static By MyDevicesmenudashboard = By.cssSelector("#user-menu > div > ul > li > ul > li:nth-child(2) > a");
	
	
	
	public static By MyDevicesHeadingTag = By.xpath("//h1[contains(text(),'Recent Devices')]");
	public static By filters = By.xpath("//select[@id='device-filter']");
	public static By ChangePasswordmenu = By.cssSelector("#user-menu > div > ul > li > ul > li:nth-child(4) > a");
	public static By ChangePasswordHeading = By.xpath("//h1[contains(text(),'Change Password')]");
	public static By MyApps = By.cssSelector("#blocked-content > div > div > div.myApp-btn-row > a");
	public static By SelectSecurityQuestion1 = By.cssSelector("#security-Question1 > option:nth-child(4)");
	public static By SelectSecurityQuestion2 = By.cssSelector("#security-Question1 > option:nth-child(3)");
	public static By SumbitSecurityQuestion = By
			.cssSelector("#forgotttenPasswordQuestions > div > form > div:nth-child(6) > div > button");
	public static By UpdateSecondaryEmail = By.cssSelector(
			"#emailRecovery > div > form > div.row.box-center > div.col-md-6.email-recovery.b-rn.b-l1 > div:nth-child(3) > div > button");
	public static By EnterUpdatedEmail = By.xpath("//*[@id=\"email-id\"]");
	public static By ValidateEmail = By.cssSelector(
			"#emailVerificationModal > div > div > form > div:nth-child(4) > div:nth-child(2) > div > button");
	public static By EnterMailOTP = By.cssSelector("#password-id");
	public static By SubmitUpdatedemail = By.cssSelector(
			"#emailVerificationModal > div > div > form > div:nth-child(5) > div:nth-child(2) > div > button");
	public static By UpdatePhoneButton = By.cssSelector(
			"#phoneRecovery > div > form > div.row.box-center > div.col-md-6.email-recovery.b-rn.b-l1 > form > div.col-md-10.col-md-offset-1 > div > button");
	public static By SelectCountryUpdatePhone = By.cssSelector("div[class='form-group'] option:nth-child(6)");
	public static By VerifyPhoneNumber = By.cssSelector(
			"#phoneVerificationModal > div > div > div > form > div:nth-child(4) > div:nth-child(3) > div > button");
	public static By EnterPhoneVerificationCode = By.cssSelector("#phoneValidationCode");
	public static By SubmitPhoneButton = By.cssSelector(
			"#phoneVerificationModal > div > div > div > form > div:nth-child(5) > div:nth-child(3) > div > button");
	public static By CustomQuestion = By.cssSelector(
			"div.col-md-6.ng-scope:nth-child(2) > div.row:nth-child(1) > div.col-xs-1.pad-L0:nth-child(2) > a:nth-child(1) > span:nth-child(1) > i");
	public static By UpdateCustomQuestion = By.xpath("//div[@class='col-xs-1 pad-L0']//span[@title='Change Question']");
	public static By EnterCustomQuestion = By.cssSelector("#security-Question-custom2");
	public static By EnterCustomAnswer = By.cssSelector("#security-Answer2");
	public static By EnterPhonenumber = By.cssSelector("#phone-For-Recovery");
	public static By ClickonmyApp = By.cssSelector("#user-menu > div > ul > li > ul > li:nth-child(1) > a");
	public static By SelectCountry = By.cssSelector("div[class='form-group'] option:nth-child(6)");
	// change password
	public static By currentpassword = By.xpath("//*[@id=\"current-password\"]");
	public static By newpassword = By.xpath("//*[@id=\"new-password\"]");

	public static By reenterpassword = By.xpath("//*[@id=\"reEnter-new-password\"]");
	public static By updatebutton = By.xpath("//*[@id=\"change-user-password\"]");

	public static By trusted = By.xpath("//b[text()='Trusted']");
	public static By untrusted = By.xpath("//b[text()='Not Trusted']");
	public static By untrusteddevicelink = By.xpath("//b[text()='Untrust this device']");
	public static By untrustpopup = By.xpath("//*[@class=\"btn btn-gray btn-width-sm\"][text()=\"Untrust\"]");
	

	public static By passwordchangemessage = By.xpath("//span[text()=\"Your password has been Changed Successfully\"]");
	public static By invaliderrormessage = By.xpath("//span[text()=\"Failed to validate Security Questions\"]");
/// Notifications
	
	public static By notification = By.cssSelector("#error-msg");
	public static By PasswordPopUp = By.cssSelector("div[class='modal-content requestapp']");
	public static By notificationPopUp = By.cssSelector("#reset-pwd");
	
	
	//FUsername
	public static By invalidotpmessage = By.xpath("//span[text()=\"Invalid verification code\"]");
	
	public static By checkbox = By.xpath("//div[@id='securityQuestionModal']//span[@class='checkmark']");
	
	
	
	
	
	
	
	
	
}
