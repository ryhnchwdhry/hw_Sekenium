package hw_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class H16_method {
	FirefoxDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/log-in");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(enabled = true, priority = 1)
	public void test() throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='txtUserID']")).sendKeys("IdontHaveUserId", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='txtUserID']")).clear();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.navigate().to("https://www.bankofamerica.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	@Test(enabled = true, priority = 2)
	public void maximize() throws InterruptedException {
		driver.get("https://www3.mtb.com/personal");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 3)
	public void fullScreen() throws InterruptedException {
		driver.get("https://www3.mtb.com/personal");
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 4)
	public void sizeWindow() throws InterruptedException {
		driver.get("https://www3.mtb.com/personal");
		driver.manage().window().fullscreen();
		Thread.sleep(3000);

	}

	@Test(enabled = true, priority = 5)
	public void deleteCookies() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/personal");

	}

	@Test(enabled = true, priority = 6)
	public void setSize() throws InterruptedException {
		org.openqa.selenium.Dimension dimension = new org.openqa.selenium.Dimension(1000, 800);
		driver.manage().window().setSize(dimension);
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/personal");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);
	}

	@Test(enabled = true, priority = 7)
	public void pageLoadTimeoutForWindow() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.get("https://www3.mtb.com/personal");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
