package hw_17;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class accept_dismiss_switchTo_alert_methods {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void acceptTheAlertFromWeb() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and @type='button' and @onclick='jsConfirm()']"))
				.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("The text of the Alert is: " + alert.getText());
		alert.accept();
	}

	@Test(enabled = true, priority = 2)
	public void dismissTheAlert() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and @type='button' and @onclick='jsConfirm()']"))
				.click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	@AfterTest
	public void tearUp() {
		driver.quit();
	}

}
