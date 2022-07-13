package quicklaunchpages;

import org.openqa.selenium.By;

public class AccountCreationPage {
	
	public static By organizationName=By.cssSelector("#userName");
	public static By fullName=By.cssSelector("#fullName");
	public static By jobTitle=By.cssSelector("#job-title");
	public static By country=By.cssSelector("div:nth-child(2) > div >select");
	public static By phoneNumber=By.xpath("//input[@title='Phone']");
	public static By email=By.cssSelector("#email");
	public static By privacyPolicy=By.cssSelector(".pull-left span");
	public static By consent=By.cssSelector(".check-container:nth-child(2) > div:nth-child(1) > label >span");
	public static By startFreeTrial=By.cssSelector("#btn-signup");	
	public static By otp=By.cssSelector("#otp");
	public static By verify=By.cssSelector(".btn-primary.btn-width-sm");
	public static By password=By.cssSelector("#pass:nth-child(1)");
	public static By confirmPassword=By.cssSelector("#confirmPassword");
	public static By loginNow=By.cssSelector(".password-inner button");
	//public static By welcomeHeading=By.cssSelector("//span[@class='propic ng-binding']");
	public static By welcomeHeading=By.cssSelector("button[class='btn btn-primary btn-xs']");
	
	public static By profile=By.cssSelector(".pull-right >div > div");
	public static By signOut=By.xpath("//a[contains(text(),'Sign Out')]");
	public static By domainExists=By.cssSelector(".validation-section div div span");
	public static By orgNameExists=By.cssSelector(".validation-section div:nth-child(2) div span");
	public static By errorPhoneNumber=By.cssSelector(".validation-section div:nth-child(1) div div");
	//Known_issue
	public static By errorFullName=By.xpath("//span[text()=\"Minimum 1 character required for Full Name\"]");
	public static By errorDomainName=By.cssSelector(".validation-section div:nth-child(1) div div");

}
