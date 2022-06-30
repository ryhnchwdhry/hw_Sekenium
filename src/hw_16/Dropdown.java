package hw_16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test(enabled = true, priority = 1)
	public void selectByIndex() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(dropElement);
		select.selectByIndex(9);
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 2)
	public void selectByValue() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(dropElement);
		select.selectByValue("search-alias=alexa-skills");
		Thread.sleep(2000);
	}

	@Test(enabled = true, priority = 3)
	public void selectByVisbleText() throws InterruptedException {
		WebElement dropElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select select = new Select(dropElement);
		select.selectByVisibleText("Amazon Devices");
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
