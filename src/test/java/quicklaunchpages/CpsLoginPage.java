package quicklaunchpages;

import org.openqa.selenium.By;

public class CpsLoginPage {
	
	
	public static By username=By.cssSelector("#username");
	public static By password=By.cssSelector("#password");
	public static By signin=By.cssSelector("#loginForm button");
	public static By signedinas=By.cssSelector("#menuBar div:nth-child(2)  a:nth-child(1)");
	public static By settings=By.cssSelector("#menuBar div:nth-child(2) img");
	public static By federationPartners=By.cssSelector("td:nth-child(1) li:nth-child(1) a");
	public static By hostNameFilter=By.xpath(".//*[@data-title=\"Host Name\"]/a[1]");
	public static By showItems=By.cssSelector("form > div:nth-child(1) > span");
    public static By dropdownlist=By.xpath("//select[@data-role=\"dropdownlist\"]");
	public static By contains=By.xpath(".//select/option[@value=\"contains\"]");
	public static By value=By.xpath(".//input[@class=\"k-textbox\"]");
	public static By filter=By.cssSelector(".k-primary");
	public static By hostNameField=By.cssSelector("#svcGrid tr:nth-child(1) td:nth-child(2) > div");
	public static By logOff=By.cssSelector("#menuBar a:nth-child(2)");
	public static By filterarrow=By.xpath("//*[@class=\"k-dropdown-wrap k-state-default\"]");
	public static By hostsetting=By.xpath("//*[@title='Operator']/option[text()='Contains']");
	
	
	
	
	


}

