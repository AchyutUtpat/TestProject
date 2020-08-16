package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipKartAddToCartPage {
	
	
		public WebDriver driver;
		public FlipKartAddToCartPage(WebDriver driver) {
			this.driver=driver;
		}
		By helperlinkt=By.xpath("//a[@href='/s/help?otracker=undefined_footer_navlinks']");
		By ShopingLink=By.xpath("//span[text()='Shopping']");
		
		public WebElement GetHelperLink()
		{
			System.out.println("Click on the Helper link");
			return driver.findElement(helperlinkt);
		}
		public FlipKartShoopingPage ShopingLink()
		{
			driver.findElement(ShopingLink).click();
			FlipKartShoopingPage FKShoppingLink=new FlipKartShoopingPage(driver);
			return FKShoppingLink;
		}

}
