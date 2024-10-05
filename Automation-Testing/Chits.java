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

public class Chits {
	

	    private WebDriver driver;
	    private WebDriverWait wait;
	    private String baseUrl = "https://www.wahylab.com/gendemo/";

	    // Elements for login page
	    private WebElement usernameField;
	    private WebElement passwordField;
	    private WebElement loginButton;
	    private WebElement signout;
	    private WebElement clickHere;
	    //report
	    private static ExtentReports extent;
		private static ExtentTest test;

  @Test(priority=1)
  
	  public void performLogin() throws InterruptedException, IOException {
	        test=extent.createTest("Verifying valid login scenario");
	        
	        usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	        usernameField.sendKeys("admin"); 
	        
	        passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	        passwordField.sendKeys("admin@gentleman");
	        
	        loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/button")));
	        loginButton.click();
	        
	        String expectedUrl = "https://www.wahylab.com/gendemo/Dashboard"; 
	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
	        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Login failed or redirected to wrong URL!");
	        
	        test.pass("The user is able to navigate to the home page");
	        takeScreenshot("performLogin");
	
	        WebElement adminclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/header/nav/div/ul/li[1]/a/span[1]")));
	        adminclick.click();
	        Thread.sleep(1000);
	       
	        signout =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul/li[2]/div[2]/a")));
	        signout.click();
  }
  
  @Test(priority=2)
  public void performInvalidLogin() throws IOException {
      
      driver.get(baseUrl);

      test=extent.createTest("Verifying InvalidLogin");
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.sendKeys("admin0888");

      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
      passwordField.sendKeys("8976567dn");

      loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/button")));
      loginButton.click();
      

      String expectedUrlinvalid = "https://www.wahylab.com/gendemo/"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrlinvalid));
      Assert.assertEquals(driver.getCurrentUrl(), expectedUrlinvalid,"Error message not display");
      test.pass("The user is unable to navigate to the home page");
      takeScreenshot("performInvalidLogin");
    
  
  }
  @Test(priority=3)
  public void performBlankLogin() throws IOException {
      
      driver.get(baseUrl);

      test=extent.createTest("Verifying performBlankLogin");
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.sendKeys("   ");

      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
      passwordField.sendKeys("    ");

      loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/button")));
      loginButton.click();

      String expectedUrl = "https://www.wahylab.com/gendemo/"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Error message not display");
      test.pass("The user is able to navigate to the home page");
      takeScreenshot("performBlankLogin");
  
  }
  @Test(priority=4)
  public void performinvalidNameLogin() throws IOException {
      
      driver.get(baseUrl);

      test=extent.createTest("Verifying invalidNameLogin ");
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.sendKeys("Adnin456");

      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
      passwordField.sendKeys("admin@gentleman");

      loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/button")));
      loginButton.click();

      String expectedUrl = "https://www.wahylab.com/gendemo/"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Error message not display");
      test.pass("The user is able to navigate to the home page Verifying invalidNameLogin");
      takeScreenshot("performinvalidNameLogin");
  
  }
  @Test(priority=5)
  public void performinvalidpasswordLogin() throws IOException {
      
      driver.get(baseUrl);

      test=extent.createTest("Verifying invalidpasswordLogin ");
      usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
      usernameField.sendKeys("admin");

      passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
      passwordField.sendKeys("admin@2345&");

      loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/button")));
      loginButton.click();

      String expectedUrl = "https://www.wahylab.com/gendemo/"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"Error message not display");
      test.pass("The user is able to navigate to the home page Verifying invalidpasswordLogin");

      takeScreenshot("performinvalidpasswordLogin");
  }
  @Test(priority=6)
  public void clickhereclick() throws IOException {
      
      driver.get(baseUrl);
      test=extent.createTest("Verifying vclickhereclick");
       clickHere = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/a/span")));
      clickHere.click();

      String expectedUrl = "https://www.wahylab.com/gendemo/login/forgot_pass"; 
      wait.until(ExpectedConditions.urlToBe(expectedUrl));
      Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"The URL did not match the expected URL");
      test.pass("The user is able to navigate to the home page ");
       takeScreenshot("clickhereclick");
  }
  
  @BeforeClass
  public void beforeClass() {
	  
			extent = new ExtentReports();
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\report.html");
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
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  private void takeScreenshot(String testName) throws IOException {
	  TakesScreenshot screenshot = (TakesScreenshot) driver;
	  File scrnsht = screenshot.getScreenshotAs(OutputType.FILE);
	  Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\login" + testName + ".png"));

	}}

