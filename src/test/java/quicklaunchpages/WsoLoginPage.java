package quicklaunchpages;

import org.openqa.selenium.By;

public class WsoLoginPage {
	
	public static By username=By.cssSelector("#txtUserName");
	public static By password=By.cssSelector("#txtPassword");
	public static By signin=By.cssSelector("tr:nth-child(4) input");
	public static By signedinas=By.cssSelector("#logged-user");
	public static By signout=By.cssSelector("#header-div li.right > a");
	public static By messBoxWarning=By.cssSelector("#messagebox-warning");
}
 