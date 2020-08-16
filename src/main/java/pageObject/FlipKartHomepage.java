package pageObject;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipKartHomepage {
	
	public WebDriver driver;
	public FlipKartHomepage(WebDriver driver) {
		this.driver=driver;
	}

	
	By emailwin=By.cssSelector("button._29YdH8");
	By telvision=By.cssSelector("li.Wbt_B2:nth-child(2)");
	By screensize=By.xpath("//*[contains(text(),'48 - 55')]");
	By priceRange=By.xpath("//select[@class='fPjUPw']");
	By Resolution=By.xpath("//div[text()='Resolution']");
	By UltraHD=By.xpath("//div[text()='Ultra HD (4K)']");
	By LowToHigh=By.xpath("//div[text()='Price -- Low to High']");
	By Pagination=By.xpath("//nav[@class='_1ypTlJ']/a");
	By ProductElements= By.xpath("//div[@class='_3wU53n']");
	By ActualProductCnt=By.cssSelector("span[class='eGD5BM']");
	By AddtoCompare=By.xpath("//span[starts-with(text(),'Add to Compare')]");
	By ClickonCompare=By.xpath("//span[text()='COMPARE']");
	By WtforComparePage= By.xpath("//span[text()='3 items']");
	
	public WebElement closeEmail()
	{
		System.out.println("Test start with closing the Login window");
		return driver.findElement(emailwin);
	}
	public WebElement movetoTeselvisionsize()
	{
		System.out.println("Moved to television link");
		return driver.findElement(telvision);
	}
	public WebElement selectScreensize()
	{
		System.out.println("Selected the screen sizeas 48-55");
		return driver.findElement(screensize);
	}
	
	public WebElement selectPriceRange()
	{
		System.out.println("Select the Price range - 20,000 to 60,000 ");
		return driver.findElement(priceRange);
		
	}
	public WebElement findResolution()
	{
		System.out.println("Find Resolution webelement ");
		return driver.findElement(Resolution);
		
	}
	
	public WebElement selectUltraHD()
	{
		System.out.println("Select the Resolution Ultra HD(4K) ");
		return driver.findElement(UltraHD);
		
	}
	public WebElement LowToHighSort()
	{
		System.out.println("Click on the low to high sorting");
		return driver.findElement(LowToHigh);
	}
	public List<WebElement> GetPagination()
	{
		System.out.println("Get all paginations and click on it one by one");
		return driver.findElements(Pagination);
	}
	public List<WebElement> GetProducts()
	{
		System.out.println("Get all products and click on it one by one");
		return driver.findElements(ProductElements);
	}
	public WebElement ActualProductcount()
	{
		System.out.println("Get actual product count");
		return driver.findElement(ActualProductCnt);
	}
	public List<WebElement> AddtoComp()
	{
		System.out.println("Add products to compare");
		return driver.findElements(AddtoCompare);
	}
	public WebElement Compareclick()
	{
		System.out.println("Click on Compare product");
		return driver.findElement(ClickonCompare);
	}
	public WebElement WaitComparePage()
	{
		System.out.println("Wait for actual compare page");
		return driver.findElement(WtforComparePage);
	}
	
	
}
