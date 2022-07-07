package hw_17;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Explicitlywait {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void set() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/personal");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void test01() throws InterruptedException {
		WebElement webElement = driver.findElement(By.xpath("//a[@class='header-link -login']"));
		wait.until(ExpectedConditions.visibilityOf(webElement)).click();
		driver.findElement(By.xpath("(//input[@class='input' and @name='txtUserID'])[2]")).sendKeys("rayhanc",
				Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test(enabled = false, priority = 2)
	public void test02() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='header-link -login']")));
		driver.findElement(By.xpath("(//input[@class='input' and @name='txtUserID'])[2]")).sendKeys("imrayhanc",
				Keys.RETURN);
		Thread.sleep(2000);
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
