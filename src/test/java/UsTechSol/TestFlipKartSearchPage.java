package UsTechSol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



import pageObject.FlipKartAddToCartPage;
import pageObject.FlipKartComparePage;
import pageObject.FlipKartHomepage;
import pageObject.FlipKartShoopingPage;
import resources.BaseDetails;
import resources.Utils; 

public class TestFlipKartSearchPage extends BaseDetails {
	public static Logger log = LogManager.getLogger(BaseDetails.class.getName());
	public WebDriver driver;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void CloseLoginwindow() throws Exception
	{
		
		
		FlipKartHomepage FKHome=new FlipKartHomepage(driver);
		//Click on the Close Email window
		FKHome.closeEmail().click();
		Actions act=new Actions(driver);
		act.moveToElement(FKHome.movetoTeselvisionsize()).click().build().perform();
		FKHome.selectScreensize().click();
		WebElement PRange= FKHome.selectPriceRange();
		Select sel=new Select(PRange);
		sel.selectByValue("20000");
		FKHome.findResolution().click();
		FKHome.selectUltraHD().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FKHome.LowToHighSort().click();
		//start product count from 0
	    int productCount = 0;
	  //list to store page numbers
	    List<WebElement> eles = null ;
	    
	    
	  //Count no of pagination link
//	    new WebDriverWait(
//	            driver, 20).until(
//	                    ExpectedConditions.presenceOfElementLocated(
//	                    		By.xpath("//nav[@class='_1ypTlJ']/a")));
	    
	    Utils Utls=new Utils(driver);
	    Utls.implicit_Wait1("Pagination");
	    eles = FKHome.GetPagination();
	  //Iterate through list
	  		for (int i = 0; i < eles.size()-1; i++) 
	  		{
	  		 
	  			//eles.get(i).click();
	  			eles.get(i).sendKeys(Keys.ENTER);
	  		        try {
	  					Thread.sleep(3000);
	  				} catch (InterruptedException e) {
	  					// TODO Auto-generated catch block
	  					e.printStackTrace();
	  				}
	  		        
	  		        //Store product element
	  		        List<WebElement> productElements = (List<WebElement>) FKHome.GetProducts();
	  		    	
	  		        //Add List size to existing pages product count
	  		        productCount = productCount + productElements.size();
	  		      
	  		    }
	  	//Capture number of total products according to the filter and print the same.(Ex : 1 to 10 products out of 55 shown)
			   String actualResult = FKHome.ActualProductcount().getText();
			   int currentCount = 24 * (eles.size()-2) + 1;
			   String expectedResult = "Showing "  + currentCount + " – " + productCount + " of " + productCount + " results for \"";  
			   System.out.println("Expected Count " +expectedResult );
			   System.out.println(" Actual Result " + actualResult);
			   
			   //start compare count from 0
			    int comparecount = 0;
			  //list to compare items numbers
			    List<WebElement> compelemnt ;
			    
			/*
			 * //Count no of compare links new WebDriverWait( driver, 20).until(
			 * ExpectedConditions.presenceOfElementLocated(
			 * By.xpath("//span[starts-with(text(),'Add to Compare')]")));
			 */
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    //5.	Add 3 televisions to compare.
			    compelemnt = FKHome.AddtoComp();
			   
			  //Iterate through list
				for (int i = 0; i < compelemnt.size()-1; i++) 
				{
				 
					compelemnt.get(i).click();
//					 
				        try {
							Thread.sleep(3000);
						} catch (InterruptedException e)
				        {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        comparecount++;
				        if (comparecount>=3)
				        	break;
				        
				    }
				FKHome.Compareclick().click();
				
				
//				new WebDriverWait(
//			            driver, 30).until(
//			                    ExpectedConditions.presenceOfElementLocated(
//			                    		By.xpath("//span[text()='3 items']")));
				
				Utls.implicit_Wait2("Television");
				//Take screenshot here with 3 televisions getting compared
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("D:\\Learnings\\UsTechSolutions\\FlipAssignment\\target\\ComparePagescreenshot.png"));
			
			   //Check the compare page product list for minimum product price
				FlipKartComparePage FKCompare=new FlipKartComparePage(driver);
				List<WebElement> list_of_products_price =FKCompare.GetProductPriceList();
				List<WebElement> list_of_products =FKCompare.GetProductNamList();
				
				String product_name;
				String product_price;
				int int_product_price;
				
				HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
				for(int i=0;i<list_of_products.size();i++) {
					product_name = list_of_products.get(i).getText();//Iterate and fetch product name
					product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
					product_price = product_price.replaceAll("[^0-9]", "");//Replace anything with space other than numbers
					int_product_price = Integer.parseInt(product_price);//Convert to Integer
					map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
				}	
				
				//Get all the keys from Hash Map
				Set<Integer> allkeys = map_final_products.keySet();
				ArrayList<Integer> array_list_product_prices = new ArrayList<Integer>(allkeys);
				
				
				//Sort the Prices in Array List using Collections class
				//this will sort in ascending order lowest at the top and highest at the bottom
				Collections.sort(array_list_product_prices);
				
				//Highest Product is
				int high_price = array_list_product_prices.get(array_list_product_prices.size()-1);
				
				System.out.println("high_price = " + high_price);
				//Low price is
				int low_price = array_list_product_prices.get(0);
				System.out.println("lowest Price = "+ low_price);
				int lowvalue=array_list_product_prices.get(0);
				
				for(int j=0;j<array_list_product_prices.size();j++)
				{
					if (lowvalue>array_list_product_prices.get(j))
					{	
						lowvalue=array_list_product_prices.get(j);
						
					}
					
				}
				System.out.println("lowest Value = "+ lowvalue);
				
				//Navigate to Add to Cart page by click on Add to cart for lowest price product
				
				FlipKartAddToCartPage FKAddtocart=FKCompare.AddtoCartBtn();
				FKAddtocart.GetHelperLink().click();
				Set <String> windowHandles = driver.getWindowHandles();

			    System.out.println(windowHandles.size());

			    for(String winHandle : driver.getWindowHandles()){

			        driver.switchTo().window(winHandle);

			    }
			    String Title1 = driver.getTitle();
			    System.out.println(Title1);
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e)
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			    FlipKartShoopingPage FKShoppingLink=FKAddtocart.ShopingLink();
			    FKShoppingLink.GetPreorderLink().click();
			    
//			    new WebDriverWait(
//			            driver, 30).until(
//			                    ExpectedConditions.presenceOfElementLocated(
//			                            By.xpath("//span[text()='Was this helpful?']")));
			    
			    Utls.implicit_Wait3("Helpful");
			    FKShoppingLink.GetHelpfulYesBtn().click();
			    
//			    new WebDriverWait(
//			            driver, 30).until(
//			                    ExpectedConditions.presenceOfElementLocated(
//			                            By.xpath("//span[text()='Thank you for your feedback']")));
			    Utls.implicit_Wait4("feedback");
			    System.out.println(FKShoppingLink.GetThankyoutext().getText());
			    FKShoppingLink.GoBacktoCart().click();
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e)
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    String Title2 = driver.getTitle();
			    System.out.println(Title2);
				
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e)
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    FKShoppingLink.getplaceorder().click();
			    
			    String Title3 = driver.getTitle();
			    System.out.println(Title3);
			    try {
					Thread.sleep(5000);
				} catch (InterruptedException e)
		        {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		log.info("Navigation to Search page is displayed");		
	}
	


	@AfterTest
	public void teardown()
	{
		driver.close();
		driver.quit();
	}

	
}
