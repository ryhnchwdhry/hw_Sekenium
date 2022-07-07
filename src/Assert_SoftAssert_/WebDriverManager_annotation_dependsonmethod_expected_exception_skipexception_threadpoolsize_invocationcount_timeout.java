package Assert_SoftAssert_;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager_annotation_dependsonmethod_expected_exception_skipexception_threadpoolsize_invocationcount_timeout {
	WebDriver driver;

	@BeforeTest
	public void set() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www3.mtb.com/personal");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(enabled = true, priority = 1)
	public void test01() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='homepage-hero-cta-button ']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: " + flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");
	}

	@Test(enabled = true, dependsOnMethods = "test01")
	public void test02() {
		boolean logInButton = driver.findElement(By.xpath("//a[@class='header-link -login']")).isEnabled();
		System.out.println("Is that logIn Button Enable? Ans: " + logInButton);
	}

	@Test(enabled = true, expectedExceptions = ArithmeticException.class)
	public void test03() {
		System.out.println("expectedExceptions");
		int i = 1 / 0;
	}

	@Test(enabled = true, groups = { "functionalTest" })
	public void test04() {
		String title = "M&amp;T Bank - Personal &amp; Business Banking, Mortgages, &amp; More | M&amp;T Bank";
		if (title.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}

	@Test(enabled = true, priority = 1, threadPoolSize = 1, invocationCount = 2, timeOut = 10000)
	public void test05() {
		String expected = "https://www3.mtb.com/personal";
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ...");
		System.out.println("Thread: " + Thread.currentThread().getName());

	}

	@AfterTest
	public void after() {
		driver.quit();
	}
}
