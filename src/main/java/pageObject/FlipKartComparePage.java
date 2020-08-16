package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.ForgotPassword;

@SuppressWarnings("unused")
public class FlipKartComparePage {
	
	public WebDriver driver;
	public FlipKartComparePage(WebDriver driver) {
		this.driver=driver;
	}

	
	By productpricelist=By.xpath("//div[@class='_1vC4OE']");
	By ProductNameList=By.xpath("//div[@class='col col-3-12 _1ouGhW'] /a");
	By AddToCartBtn=By.xpath("//button[contains(.,'ADD TO CART')]");
	
	public List<WebElement> GetProductPriceList()
	{
		System.out.println("Get all product list");
		return driver.findElements(productpricelist);
	}
	
	public List<WebElement> GetProductNamList()
	{
		System.out.println("Get all product list");
		return driver.findElements(ProductNameList);
	}
	public FlipKartAddToCartPage AddtoCartBtn()
	{
		driver.findElement(AddToCartBtn).click();
		FlipKartAddToCartPage FKAddtocart=new FlipKartAddToCartPage(driver);
		return FKAddtocart;
	}
	

}
