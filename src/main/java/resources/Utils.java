package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public WebDriver driver;
	public Utils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void implicit_Wait1(String str) throws Exception{
		System.out.println("Entered into the wait");
        for(int i=0;i<60;i++){
            try{
                driver.findElement(By.xpath("//nav[@class='_1ypTlJ']/a")).isDisplayed();
                break;
            }catch(Exception e){Thread.sleep(2000);

            }   
        }
        
	}
	
	public void implicit_Wait2(String str) throws Exception{
		System.out.println("Entered into the wait");
        for(int i=0;i<60;i++){
            try{
                driver.findElement(By.xpath("//span[text()='3 items']")).isDisplayed();
                break;
            }catch(Exception e){Thread.sleep(2000);

            }   
        }
        
	}
	
	public void implicit_Wait3(String str) throws Exception{
		System.out.println("Entered into the wait");
        for(int i=0;i<60;i++){
            try{
                driver.findElement(By.xpath("//span[text()='Was this helpful?']")).isDisplayed();
                break;
            }catch(Exception e){Thread.sleep(2000);

            }   
        }
        
	}
	
	public void implicit_Wait4(String str) throws Exception{
		System.out.println("Entered into the wait");
        for(int i=0;i<60;i++){
            try{
                driver.findElement(By.xpath("//span[text()='Thank you for your feedback']")).isDisplayed();
                break;
            }catch(Exception e){Thread.sleep(2000);

            }   
        }
        
	}

}
