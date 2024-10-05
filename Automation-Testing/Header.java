package project_sep.gentelman;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Header {
	private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.wahylab.com/gendemo/";
    //driver.get("https://www.wahylab.com/gendemo/");
    private static ExtentReports extent;
	private static ExtentTest test;
	
  @Test(priority=1)
  public void HeadingURL() throws IOException {
	   
	  String expectedUrl = "https://www.wahylab.com/gendemo/Dashboard"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      Assert.assertTrue(driver.getPageSource().contains("https://www.wahylab.com/gendemo/Dashboard"));
      takeScreenshot("Heading url");
      test.pass("URL accessed successfully");
  }
  @Test(priority=2)
  public void Heading() throws IOException {
	  test=extent.createTest("Verify heading");
	  WebElement heading = driver.findElement(By.xpath("/html/body/div/header/a/span[2]"));
	  heading= wait.until(ExpectedConditions.visibilityOf(heading));
      String expected = "GENTLEMAN Chits"; 
	  Assert.assertTrue(driver.getPageSource().contains("GENTLEMAN Chits"));
	  takeScreenshot("Heading url");
	  test.pass("The correct heading is displayed");
  }
  @Test(priority=3)
  public void Verify_hamburger_button() throws IOException {
	  test=extent.createTest("Verifying hamburger button");
	  WebElement hamburger_button = driver.findElement(By.xpath("/html/body/div/header/nav/a"));
	  hamburger_button= wait.until(ExpectedConditions.visibilityOf(hamburger_button));
	  hamburger_button.click();
	  String expected = "skin-blue sidebar-mini sidebar-collapse"; 
	  Assert.assertTrue(driver.getPageSource().contains("skin-blue sidebar-mini sidebar-collapse"));
	  takeScreenshot("hamburger_button");
	  test.pass("The hamburger button is working");
  }
  @Test(priority=4)
	public void Verify_profile_button() throws IOException
	{
	  test=extent.createTest("Verifying profile button");
	  WebElement Profile=driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[1]/a"));
	  Profile= wait.until(ExpectedConditions.visibilityOf(Profile));
	  Profile.click();
	  WebElement profilebox = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[1]/ul"));
	  profilebox = wait.until(ExpectedConditions.visibilityOf(profilebox));
	  
	  Assert.assertTrue(profilebox.isDisplayed(), "Profile box is not displayed");
	  takeScreenshot("profilebox");
	  test.pass("The profile button is working");
	}
  @Test(priority=5)
	public void Verify_signout_button() throws IOException
	{
	    test=extent.createTest("Verifying Signout button");
		WebElement signout = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[1]/ul/li[2]/div[2]/a"));
		signout= wait.until(ExpectedConditions.visibilityOf(signout));
		signout.click();
		String expected = "https://www.wahylab.com/gendemo/login/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected, "The current URL does not match the expected URL after sign out.");
		takeScreenshot("signout");
		test.pass("Signout button is working");
	}
  @BeforeClass
  public void beforeClass() {
	  extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Selenium\\Gentleman\\target\\HTMLreport\\Header.html");
		extent.attachReporter(htmlReporter);
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      
      driver.get(baseUrl);
      driver.manage().window().maximize();
      Thread.sleep(1000);
        WebElement user=driver.findElement(By.name("username"));
		user=wait.until(ExpectedConditions.visibilityOf(user));
		user.sendKeys("admin");
		WebElement pass=driver.findElement(By.name("password"));
		pass=wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys("admin@gentleman");
		WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/form/button"));
		login=wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
        
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  private void takeScreenshot(String testName) throws IOException {
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      File scrnsht = screenshot.getScreenshotAs(OutputType.FILE);
      Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\Header" + testName + ".png"));
      

}}
