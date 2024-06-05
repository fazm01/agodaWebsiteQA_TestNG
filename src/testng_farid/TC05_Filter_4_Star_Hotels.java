package testng_farid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TC05_Filter_4_Star_Hotels {
public static ChromeOptions options = new ChromeOptions();
public static ChromeDriver driver=new ChromeDriver(options.addArguments("--remote-allow-origins=*"));
  @Test
  public void f() throws InterruptedException {
	  	Thread.sleep(8000);
	  	Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions.moveToElement(driver.findElement(By.className("ab-close-button"))).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).sendKeys("Tokyo");
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"tab-all-rooms-tab\"]/div"))).click().build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,10000)");
		
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/button"))).click().build().perform();
		
		//wait for search results
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3000)");
		//4-Stars checkmark
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SideBarLocationFilters\"]/div[6]/div[2]/ul/li[2]/span"))).click().build().perform();
		
		Thread.sleep(8000);
		
		js.executeScript("window.scrollBy(0,-3000)");
		
		Thread.sleep(1000);
		
		
		
		
		//Assert Element Present
		if( driver.findElement(By.cssSelector(".gWCdaf")).isDisplayed())
		{
			System.out.println("Four-star hotel succesfully detected in first search result");
			System.out.println("Four-star hotel filtering success");
		}
		else
		{
			System.out.println("Could not detect four-star hotel in first search result");
			System.out.println("Failed to display four-star hotels");
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
