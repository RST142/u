package quicklaunchpages;
import org.openqa.selenium.By;

public class TenantPolicy {
	public static By SSO=By.cssSelector("#ssoPoliciesId");
	public static By AddPolicy=By.cssSelector("#add-policy-sso");
	public static By cardinality=By.xpath("//label[contains(text(),'On every login')]");
	public static By policyName=By.cssSelector("input[placeholder='Policy Name']");
	public static By policyStatus=By.cssSelector("option[value='Enabled']");
	public static By UserGroup=By.cssSelector("input[placeholder='Select role...']");
	public static By securityQuestion=By.cssSelector("select[ng-model='vm.policy.securityQuestionStatus']");
	public static By emailValidation=By.cssSelector("select[ng-model='vm.policy.emailVerificationStatus']");
	public static By phoneValidation=By.cssSelector("select[ng-model='vm.policy.phoneVerificationStatus']");
	
	public static By mobilePushValidation=By.cssSelector("select[ng-model='vm.policy.unifyedPushAuthVerificationStatus']");

	
	public static By savebutton=By.cssSelector("button[class='btn btn-primary btn-width-sm']");
	public static By editPolicy=By.cssSelector("tbody tr:nth-child(2) td:nth-child(13) a:nth-child(1)");
	public static By editdefaultPolicy=By.cssSelector("tbody tr:nth-child(1) td:nth-child(13) a:nth-child(1) i:nth-child(1)");
	
	public static By suspicious=By.cssSelector("#On-suspicious-activities");
	public static By everyLogin=By.cssSelector("#On-every-login");

	
	public static By deleteIcon=By.cssSelector("tbody tr:nth-child(2) td:nth-child(13) a:nth-child(2)");
	public static By deleteIconofwithoutmfa=By.cssSelector("tbody tr:nth-child(3) td:nth-child(13) a:nth-child(2) i:nth-child(1)");
    
	public static By deleteButton=By.xpath("//button[contains(text(),'Delete')]");
    public static By groupclear=By.cssSelector("a[class='ui-select-match-close select2-search-choice-close']");
    public static By policycount=By.xpath(" //*[@class=\"table table-striped custab app-category-list mytable ng-scope\"]/thead/following-sibling::tbody/tr");
    
    //MFA configuration
    public static By phoneconfiguration=By.xpath(" //a[normalize-space()='Phone']");
    public static By mfaslider=By.xpath(" //div[@ng-if='vm.multiFactorAuthConfig.isPhoneAuthenticationEnabled']//span[@class='slider round']");
    public static By disablebutton=By.xpath(" //button[normalize-space()='Disable']");
    public static By enbleslider=By.xpath("//div[@ng-if='!vm.multiFactorAuthConfig.isPhoneAuthenticationEnabled']//span[@class='slider round']");

}
