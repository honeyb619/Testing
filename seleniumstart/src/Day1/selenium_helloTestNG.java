package Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



public class selenium_helloTestNG {

	static WebDriver driver;
	
@BeforeClass
public static void setup()
{
	System.setProperty("webdriver.edge.driver", "I:\\Selenium\\edgedriver\\msedgedriver.exe");
	EdgeOptions options = new EdgeOptions();
	options.addArguments("start-maximized");
	driver =new EdgeDriver(options); 
}

  @Test(groups = "search")
  public void TextSearch() throws IOException {
	  
		driver.get("https://www.Google.com/");
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("gLFyf")));
		WebElement search = driver.findElement(By.className("gLFyf"));
		search.sendKeys("facebook");
		search.sendKeys(Keys.RETURN);
		
//		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(90));
//		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.className("result-area")));
//		System.out.println(driver.findElement(By.className("result-area")).getText());
//		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(s, new File("speedtest.png"));
  }
  
  @Test(groups = "search")
  @Parameters("myName")
  public void ImageSearch(String myName) throws Exception {
	  
		driver.get("https://www.Google.com/");
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("gLFyf")));
		WebElement search = driver.findElement(By.className("gLFyf"));
		search.sendKeys(myName);
		search.sendKeys(Keys.RETURN);
		throw new Exception("Test Exception");
//		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(90));
//		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.className("result-area")));
//		System.out.println(driver.findElement(By.className("result-area")).getText());
//		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(s, new File("speedtest.png"));
  }
  
  @Test(dependsOnGroups = "search")
  public void FailMethod() throws Exception {
	  throw new Exception("Test Exception");
  }
  
  @AfterClass
  public static void close()
  {
  	//driver.close();
  }
  
}
