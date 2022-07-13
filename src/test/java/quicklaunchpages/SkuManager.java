package quicklaunchpages;

import org.openqa.selenium.By;

public class SkuManager {
	public static By Addinventory=By.xpath("//a[normalize-space()='Add new']");
	public static By inventoryname=By.xpath("//input[@placeholder='Enter inventory name']");
	
	public static By inventorytype=By.xpath("//select[@ng-model=\"inventory.inventoryType.id\"]");
	public static By assignproduct=By.xpath("//select[@ng-model=\"inventory.productId\"]");
	public static By SKUID=By.xpath("//input[@placeholder='Enter SKU ID']");
	
	public static By unitcost=By.xpath("//input[@placeholder=\"Enter item unit cost\"]");
	
	public static By MRP=By.cssSelector("select[ng-model='inventory.unitListPriceType.id']");
	public static By SP=By.cssSelector("select[ng-model='inventory.gtmListPriceType.id']");
	public static By savebutton=By.xpath("//button[normalize-space()='Save']");
	public static By productselect=By.xpath("//*[@id=\"ngViewContent\"]/div/form/div[2]/div/div/div[2]/div[2]/div/select/option[text()=\"Product\"]");
	
	
}
