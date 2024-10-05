package project_sep.gentelman;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

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

public class ForgotPassword {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.wahylab.com/gendemo/login/forgot_pass";
    private  WebElement email;
    private  WebElement submit;
    private static ExtentReports extent;
	private static ExtentTest test;
  @Test(priority=1)
  public void forgotpswdUrl() throws InterruptedException, IOException {

	      test=extent.createTest("Verifying the URL");
			try
			{
				String expected="https://www.wahylab.com/gendemo/login/forgot_pass";
				String actual=driver.getCurrentUrl();
				Assert.assertEquals(actual,expected);
				test.pass("URL accessed successfully");
			}
			catch(AssertionError e)
			{
				System.out.println("DEFECT : Not correct URL for the password reset page");
				test.fail("Not correct URL");
				TakesScreenshot screenshot=((TakesScreenshot)driver);
				File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
				Files.copy(scrnsht, new File("C:\\Selenium\\Gentleman\\target\\Screenshots\\Forgotpassword\\frgtpswrdurl.png"));
			}
			finally
			{
				driver.navigate().refresh();
			}
  }
  @Test(priority=2)
  public void validfrgpswrest() throws IOException  {

	  test = extent.createTest("Verifying the password reset function with valid input");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"name\"]"));
		email=wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys("gentleman@gmail.com");

		WebElement submit=driver.findElement(By.xpath("/html/body/div/div[1]/form/center/input"));
		submit=wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();
		try
		{
			WebElement message = driver.findElement(By.xpath("/html/body/div/div[2]/h2"));			
			message=wait.until(ExpectedConditions.visibilityOf(message));
			Assert.assertTrue(message.isDisplayed());
			test.pass("The message is displayed");
			try 
			{
				String Expected ="Please check your email!";
				String actual = message.getText();
				Assert.assertTrue(actual.contains(Expected));
				test.pass("The correct message is displayed");
			}
			catch(AssertionError e)
			{
				System.out.println("DEFECT : Wrong message displayed for the valid scenario in password reset");
				test.fail("Wrong message displayed");
				TakesScreenshot screenshot=((TakesScreenshot)driver);
				File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
				Files.copy(scrnsht, new File("C:\\Selenium\\Gentleman\\target\\Screenshots\\Forgotpassword\\validpswrdreset1.png"));
			}
		}
		catch(NoSuchElementException  f)
		{
			System.out.println("DEFECT : No message displayed when the password reset function is performed with valid mailid");
			test.fail("No message displayed");
			TakesScreenshot screenshot=((TakesScreenshot)driver);
			File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			Files.copy(scrnsht, new File("C:\\Selenium\\Gentleman\\target\\Screenshots\\Forgotpassword\\validpswrdreset2.png"));
		}
		finally
		{
			driver.navigate().refresh();
		}
	}
  
  @Test(priority=3)
  public void invalidfrgpswrest() throws IOException  {

	  test = extent.createTest("Verifying the password reset function with invalid input");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"name\"]"));
		email=wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys("gentle@gmail.com");
		WebElement submit=driver.findElement(By.xpath("/html/body/div/div[1]/form/center/input"));
		submit=wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();

		try
		{
			WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div[3]/h2"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			message=wait.until(ExpectedConditions.visibilityOf(message));
			Assert.assertTrue(message.isDisplayed());
			test.pass("The error message is displayed");
			try 
			{
				String Expected ="Invalid Email ID !";
				String actual = message.getText();
				Assert.assertTrue(actual.contains(Expected));
				test.pass("The correct error message is displayed");
			}
			catch(AssertionError e)
			{
				System.out.println("DEFECT : Wrong message displayed for the valid scenario in password reset");
				test.fail("Wrong error message displayed");
				TakesScreenshot screenshot=((TakesScreenshot)driver);
				File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
				Files.copy(scrnsht, new File("C:\\Selenium\\Gentleman\\target\\Screenshots\\Forgotpassword\\invalidpswrdreset1.png"));
			}
		}
		catch(NoSuchElementException f)
		{
			System.out.println("DEFECT : No error message displayed when the password reset function is performed with invalid mailid");
			test.fail("No error message displayed");
			TakesScreenshot screenshot=((TakesScreenshot)driver);
			File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			Files.copy(scrnsht, new File("C:\\Selenium\\Gentleman\\target\\Screenshots\\Forgotpassword\\invalidpswrdreset2.png"));
		}
		finally
		{
			driver.navigate().refresh();
		}
        
  }
  
  @BeforeClass
  public void beforeClass() {
	    extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\report\\report");
		extent.attachReporter(htmlReporter);
	  
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
      wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      driver.get(baseUrl);
      driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  private void takeScreenshot(String testName) throws IOException {
      TakesScreenshot screenshot = (TakesScreenshot) driver;
      File scrnsht = screenshot.getScreenshotAs(OutputType.FILE);
      Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\forgotpswd" + testName + ".png"));
      
}
  }

