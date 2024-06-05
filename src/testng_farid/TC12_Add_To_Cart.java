package testng_farid;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC12_Add_To_Cart extends TC11_Sort_Breakfast_Included {
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(8000);
	  	Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions.moveToElement(driver.findElement(By.className("ab-close-button"))).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).sendKeys("Enzo Tokyo");
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"tab-all-rooms-tab\"]/div"))).click().build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,10000)");
		
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/button"))).click().build().perform();
		
		//wait for search results
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,300)");
		//click Enzo Tokyo
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"contentContainer\"]/div[3]/ol/li[1]/div[2]/a"))).click().build().perform();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
		Thread.sleep(5000);
	
		
		js.executeScript("window.scrollBy(0,2000)");
		
		//add to cart
		actions.moveToElement(driver.findElement(By.cssSelector(".jxFsnW"))).click().build().perform();
		Thread.sleep(5000);
		actions.moveToElement(driver.findElement(By.cssSelector(".eZCQek"))).click().build().perform();
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.cssSelector(".blnWzF"))).click().build().perform();
		
		if(driver.findElement(By.cssSelector(".cEdVhr")).isDisplayed())
		{
			System.out.println("Item added to cart succesfully");
		}
		else 
		{
			System.out.println("Failed to add item to cart");
		}
		
  }
  @BeforeMethod
  public void beforMethod() {
	  DesiredCapabilities cp=new DesiredCapabilities();
	  cp.setCapability(ChromeOptions.CAPABILITY, options);
	  options.merge(cp);
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\Farid\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver.manage().window().maximize();
	  driver.navigate().to("https://www.agoda.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
