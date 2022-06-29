package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B_use_of_get_method {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.geckodriver", ".driver\\geckodriver.exe");
		// WebDriver is an interface and ChromeDriver is a concrete class
		driver = new FirefoxDriver();
		driver.get("https://www3.mtb.com/log-in");

	}
	@Test
	public void loginButtonTest() throws InterruptedException {
		driver.findElement(By.name("remember-me")).click();
		Thread.sleep(6000);
		
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}

