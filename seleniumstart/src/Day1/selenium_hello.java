package Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class selenium_hello {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "I:\\Selenium\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver =new ChromeDriver(options); 
		driver.get("https://www.speedtest.net/");
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("js-start-test")));
		driver.findElement(By.className("js-start-test")).click();
		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.className("result-area")));
		System.out.println(driver.findElement(By.className("result-area")).getText());
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("speedtest.png"));
		driver.close();
	}

}
