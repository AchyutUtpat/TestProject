package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipKartShoopingPage {
	public WebDriver driver;
	public FlipKartShoopingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Preorderlink=By.xpath("//p[text()=\"What does 'Preorder' or 'Forthcoming' mean?\"]");
	By HelfulYesBtn=By.xpath("//button[text()='Yes']");
	By Thankyoutext=By.xpath("//span[text()='Thank you for your feedback']");
	By GoToCart=By.xpath("//span[text()='Cart']");
	By PlaceOrder=By.xpath("//button[contains(.,'Place Order')]");
	
	public WebElement GetPreorderLink()
	{
		System.out.println("Get Preorder Link");
		return driver.findElement(Preorderlink);
	}
	
	public WebElement GetHelpfulYesBtn()
	{
		System.out.println("Click on the Helful Yes Button");
		return driver.findElement(HelfulYesBtn);
	}

	public WebElement GetThankyoutext()
	{
		System.out.println("Get Thank you text");
		return driver.findElement(Thankyoutext);
	}
	
	public WebElement GoBacktoCart()
	{
		System.out.println("Go Back to Cart Page");
		return driver.findElement(GoToCart);
	}
	public WebElement getplaceorder()
	{
		System.out.println("Click on the Shooping cart button");
		return driver.findElement(PlaceOrder);
	}
}
