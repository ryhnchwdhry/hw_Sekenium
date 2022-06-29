package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class P_1 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://portal.cms.gov/portal/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void test() throws InterruptedException {

		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).click();
		Thread.sleep(2000);
		boolean checkBox =driver.findElement(By.xpath("//label[@for='checkd' and @class='checkbox sr-only on']")).isSelected();

		System.out.println("is it Selected: " + checkBox );
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
