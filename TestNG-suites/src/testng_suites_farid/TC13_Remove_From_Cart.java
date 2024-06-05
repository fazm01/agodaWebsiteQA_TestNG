package testng_suites_farid;

import org.testng.annotations.Test;
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


public class TC13_Remove_From_Cart extends TC12_Add_To_Cart {
	public static ChromeOptions options = new ChromeOptions();
	public static ChromeDriver driver=new ChromeDriver(options.addArguments("--remote-allow-origins=*"));
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
		
		Thread.sleep(15000);//waiting 20 seconds until cart item appears 
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"contentReact\"]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/button"))).click().build().perform();
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("/html/body/div[12]/div/div[2]/div/div/div[2]/button[2]"))).click().build().perform();
		Thread.sleep(3000);
		if((driver.findElement(By.xpath("//*[@id=\"contentReact\"]/div/div[3]/div/div/div/div/h3")).getText()).equals("Your cart is empty"))
		{
			System.out.println("Item removed from cart succesfully");
		}
		else 
		{
			System.out.println("Failed to remove item from cart");
		}
		
  }
  @BeforeMethod
  public void beforeMethod() {
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
