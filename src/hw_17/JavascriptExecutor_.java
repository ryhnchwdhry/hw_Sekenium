package hw_17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptExecutor_ {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	@BeforeTest
	public void set() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/log-in");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void test01() throws InterruptedException {
		WebElement userId = driver.findElement(By.xpath("//input[@class='input' and @name='txtUserID']"));
		WebElement RememberUserID = driver.findElement(By.name("remember-me"));
		js.executeScript("arguments[0].value='rayhanc'", userId);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", RememberUserID);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 2)
	public void test02() throws InterruptedException {
		WebElement passcode = driver.findElement(By.xpath("//input[@type='password']"));
		WebElement Remember = driver.findElement(By.name("remember-me"));
		js.executeScript("arguments[0].value='imrayhanc'", passcode);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click()", Remember);
		Thread.sleep(4000);
	}
	

	@AfterTest
	public void after() {
		driver.quit();
	}

}
