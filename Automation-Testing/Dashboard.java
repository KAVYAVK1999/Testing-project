package project_sep.gentelman;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Optional;
import com.google.common.io.Files;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Dashboard {
	private static final boolean True = false;
	private static final boolean False = false;
	private WebDriver driver;
    private WebDriverWait wait;
    SoftAssert sa=new SoftAssert();
    private String baseUrl = "https://www.wahylab.com/gendemo/";
    private static ExtentReports extent;
	private static ExtentTest test;
    
  @Test(priority=1)
  public void Verify_Dashboard_button() throws IOException {
	  test=extent.createTest("Verify_Dashboard_button");
	  WebElement Dashboardbtn=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[1]/a"));
		Dashboardbtn=wait.until(ExpectedConditions.visibilityOf(Dashboardbtn));
		Dashboardbtn.click();
		try {
		
		String expected = "https://www.wahylab.com/gendemo/Dashboard";
		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, expected);
		sa.assertAll();
		test.pass("get current url");
		}
		catch(AssertionError e){
			
			System.out.println("DEFECT : The Dashboard button is not working");
			takeScreenshot("Dashboard_button");
			test.pass("The Dashboard button is not working");
		}
		finally
		{
			driver.navigate().refresh();
		}
	}
		
  
  @Test(priority=2)
	public void Verify_Moreinfo_button_Designation() throws IOException {
	  test=extent.createTest("Verify_Moreinfo_button_Designation");
	  WebElement number=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[2]/div/div[1]/h3")) ;
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Designationtotal=number.getText();
		int expectedTotalEntries = Integer.parseInt(Designationtotal.replaceAll("[^0-9]", ""));
		WebElement Designationmoreinfo=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/a"));
		Designationmoreinfo=wait.until(ExpectedConditions.visibilityOf(Designationmoreinfo));
		Designationmoreinfo.click();
		try {
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showDesignation";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual, expected);
			sa.assertAll();
			test.pass("showing correct url");
			
		}
		catch (AssertionError e) {
			System.out.println("DEFECT : The Designation More info button is not working, navigated to wrong page");
			takeScreenshot("Moreinfo_button_Designation");
			}
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("designation_table_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
		
		}
		catch(AssertionError e)
		{
			System.out.println("DEFECT : The number displayed along with designation More info button is not the total number of entries in the corresponding page");
			
			takeScreenshot("Verify_Moreinfo_button_Designation_num.png");
		}
		finally
		{
			driver.navigate().back();
		}
		 
		 
		
	  }
  @Test(priority=3)
  public void Verify_Moreinfo_button_Items() throws IOException, InterruptedException {
	  test=extent.createTest("Verify_Moreinfo_button_Item");
	    WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/div[1]"));
		number=wait.until(ExpectedConditions.visibilityOf(number));
		String itemstotal=number.getText();
		int expectedTotalEntries = Integer.parseInt(itemstotal.replaceAll("[^0-9]", ""));
		WebElement items=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/a"));
		items=wait.until(ExpectedConditions.visibilityOf(items));
		items.click();
		try {
		String expected ="https://www.wahylab.com/gendemo/NewMaster/showMasterOpeningStock";
		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, expected);
		sa.assertAll();
		test.pass("showing correct url");
		}
		catch(AssertionError e) {
			System.out.println("DEFECT : The Items More info button is not working, navigated to wrong page\"");
			takeScreenshot("MoreInfo_Button_Items");
			
		}
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("items_table_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			takeScreenshot("MoreInfo_Button_Items_info");
			test.pass("showing entry correct");
		}
		catch(AssertionError | IllegalStateException | NoSuchElementException  e) {
			System.out.println("DEFECT : The number displayed along with Items More info button is not the total number of entries in the corresponding page");
		    takeScreenshot("MoreInfo_Button_Items-num");
		}
		finally
		{
			Thread.sleep(1000);
			driver.navigate().back();
		}
  }
  @Test(priority=4)
	public void Verify_Moreinfo_button_Mutual_branch_transfer_request() throws IOException
	{
	  test=extent.createTest("Verify_Moreinfo_button_Mutual_branch_transfer_request");
		WebElement number=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[4]/div/div[1]/h3"));
		number=wait.until(ExpectedConditions.visibilityOf(number));
		String mbtrstotal=number.getText();
		int expectedTotalEntries = Integer.parseInt(mbtrstotal.replaceAll("[^0-9]", ""));
		WebElement mbtr=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[4]/div/a"));
		mbtr=wait.until(ExpectedConditions.visibilityOf(mbtr));
		mbtr.click();
		try
		{
			String expected ="https://www.wahylab.com/gendemo/newMaster/showB2bRequest";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
		}
		catch(AssertionError e)
		{
			System.out.println("DEFECT : The Mutual_branch_transfer_request More info button is not working, navigated to wrong page");
			takeScreenshot("Mutual_branch_transfer_request");
			
		}
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("designation_table_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
			
			
		}
		catch(AssertionError| IllegalStateException | NoSuchElementException  e)
		{
			System.out.println("DEFECT : The number displayed along with Mutual_branch_transfer_request More info button is not the total number of entries in the corresponding page");
			takeScreenshot("Mutual_branch_transfer_r");
			
		}
		finally
		{
			driver.navigate().back();
		}
	}
  @Test(priority=5)
	public void Verify_Moreinfo_button_Branch_Stock_Request_Approval() throws IOException
	{   
	  test=extent.createTest("Verify_Moreinfo_button_Branch_Stock_Request_Approval");
		WebElement number=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[5]/div/div[1]/h3"));
		number=wait.until(ExpectedConditions.visibilityOf(number));
		String bsratotal=number.getText();
		int expectedTotalEntries = Integer.parseInt(bsratotal.replaceAll("[^0-9]", ""));
		WebElement bsra=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[5]/div/a"));
		bsra=wait.until(ExpectedConditions.visibilityOf(bsra));
		bsra.click();
		try
		{
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showBranchItemRequestsPage";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
		}
		catch(AssertionError e ) 
		{
			System.out.println("DEFECT : The Branch_Stock_Request_Approval More info button is not working, navigated to wrong page");
			takeScreenshot("Branch_Stock_Request_Approval More info button");
			
		}
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("requestTable_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
		}
		catch(AssertionError | IllegalStateException | NoSuchElementException e ) 
		{
			System.out.println("DEFECT : The number displayed along with Branch_Stock_Request_Approval More info button is not the total number of entries in the corresponding page");
			takeScreenshot("Branch_Stock_Request_Approval More info");
		}
		finally
		{
			driver.navigate().back();
		}
	}
  @Test(priority=6)
	public void Verify_Moreinfo_button_Branches() throws IOException
	{
	  test=extent.createTest("Verify_Moreinfo_button_Branches");
		WebElement number=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[6]/div/div[1]/h3"));
		number=wait.until(ExpectedConditions.visibilityOf(number));
		String bsratotal=number.getText();
		int expectedTotalEntries = Integer.parseInt(bsratotal.replaceAll("[^0-9]", ""));
		WebElement bsra=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[6]/div/a"));
		bsra=wait.until(ExpectedConditions.visibilityOf(bsra));
		bsra.click();
		try
		{
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showBranchLists";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
		}
		catch(AssertionError e)
		{
			System.out.println("DEFECT : The Branch_ More info button is not working, navigated to wrong page");
			takeScreenshot("Branch More info");
		}
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("requestTable_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
			
		}
		catch(AssertionError | IllegalStateException | NoSuchElementException e)
		{
			System.out.println("DEFECT : The number displayed along with Branch_ More info button is not the total number of entries in the corresponding page");
			takeScreenshot("Branches_ More info_table");
		}
		finally
		{
			driver.navigate().back();
		}
	}
  @Test(priority=7)
  public void Verify_Moreinfo_Button_Stocks() throws IOException, InterruptedException {
	  test=extent.createTest("Verify_Moreinfo_Button_Stocks");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[7]/div/div[1]/h3"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Stocktotal=number.getText();
	  int expectedTotalEntries = Integer.parseInt(Stocktotal.replaceAll("[^0-9]", ""));
	  WebElement Stock=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[7]/div/a"));
	  Stock=wait.until(ExpectedConditions.visibilityOf(Stock));
	  Stock.click();
	  try {
		  String Expected="https://www.wahylab.com/gendemo/NewMaster/showMasterStock";
		  String actual=driver.getCurrentUrl();
		  sa.assertEquals(actual,Expected);
		  sa.assertAll();
		  test.pass("showing correct url");
	  }
	  catch(AssertionError e) {
			System.out.println("DEFECT : The Stock More info button is not working, navigated to wrong page");
            takeScreenshot("Moreinfo_Button_Stocks");
	  }
	 try {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			
			//JavascriptExecutor jsv = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
	 
	 }
	 catch(AssertionError | IllegalStateException | NoSuchElementException  e)
		{
			System.out.println("DEFECT : The number displayed along with Stock More info button is not the total number of entries in the corresponding page");
			takeScreenshot("Moreinfo_Button_Stocks_table");
		}
		finally
		{
			driver.close();
			Thread.sleep(2000);
			beforeTest();
		}
  }
  @Test(priority=8)
  public void Categorys_More_Info_Button() throws IOException {
	  
	  test=extent.createTest("Categorys_More_Info_Button");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[8]/div/div[1]/h3"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Categorystotal=number.getText();
	  int expectedTotalEntries = Integer.parseInt(Categorystotal.replaceAll("[^0-9]", ""));
	  WebElement Categorys=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[8]/div/a"));
	  Categorys=wait.until(ExpectedConditions.visibilityOf(Categorys));
		Categorys.click();
		try {
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showCategory";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
		}
		catch (AssertionError e) {
			System.out.println("DEFECT : The Categorys More info button is not working, navigated to wrong page");
			takeScreenshot("Moreinfo_button_Category");
		}
	  try {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.id("designation_table_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			//JavascriptExecutor jsv = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtexts = driver.findElement(By.id("designation_table_info"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String texts = bottomtext.getText();
			Pattern patterns = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matchers = pattern.matcher(text);
	 
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
	  }
			catch(AssertionError | IllegalStateException | NoSuchElementException  e)
			{
				System.out.println("DEFECT : The number displayed along with Categorys More info button is not the total number of entries in the corresponding page");
				
			}
			finally
			{
				driver.navigate().back();
			}}
  @Test(priority=9)
  public void Total_Employees_More_Info_Button() throws IOException, InterruptedException{
	  
	  test=extent.createTest("Total_Employees_More_Info_Button");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[9]/div/div[1]/h3"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String TotalEmployees= number.getText();
	  int expectedTotalEntries = Integer.parseInt(TotalEmployees.replaceAll("[^0-9]", ""));
	  WebElement TotalEmployees1 =driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[9]/div/a"));
	  TotalEmployees1=wait.until(ExpectedConditions.visibilityOf(TotalEmployees1));
	  TotalEmployees1.click();
		try {
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showCategory";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing  correct url");
		}
		catch (AssertionError e) {
			System.out.println("DEFECT : The Categorys More info button is not working, navigated to wrong page");
			takeScreenshot("TotalEmployees");
		}
	  try {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
	  }
			catch(AssertionError | IllegalStateException | NoSuchElementException  e)
			{
				System.out.println("DEFECT : The number displayed along with TotalEmployees More info button is not the total number of entries in the corresponding page");
				takeScreenshot("TotalEmployees moreinfo");
			}
			finally
			{
				driver.navigate().back();
				Thread.sleep(2000);
				beforeTest();
			}}
  @Test(priority=10)
  public void Branch_Returns_More_Info_Button() throws IOException, InterruptedException{
	  
	  test=extent.createTest("Branch_Returns_More_Info_Button");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[10]/div/div[1]/h3"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Branch_Returns= number.getText();
	  int expectedTotalEntries = Integer.parseInt(Branch_Returns.replaceAll("[^0-9]", ""));
	  WebElement Branch_Return =driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[10]/div/a"));
	  Branch_Return=wait.until(ExpectedConditions.visibilityOf(Branch_Return));
	  Branch_Return.click();
	  try {
			String expected ="https://www.wahylab.com/gendemo/newMaster/showBranchReturn";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
		}
		catch (AssertionError e) {
			System.out.println("DEFECT : The Branch_Returns_More_Info_Button is not working, navigated to wrong page");
			takeScreenshot("Branch_Returns_More_Info_Button");
		}
	  try {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
			WebElement bottomtext = driver.findElement(By.xpath("//*[@id=\"requestTable_info\"]"));
			bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
			String text = bottomtext.getText();
			Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
			Matcher matcher = pattern.matcher(text);
			matcher.find();
			int actualnumber = Integer.parseInt(matcher.group(1));
			sa.assertEquals(actualnumber, expectedTotalEntries);
			sa.assertAll();
			test.pass("showing entry correct");
	  }
			catch(AssertionError | IllegalStateException | NoSuchElementException  e)
			{
				System.out.println("DEFECT : The number displayed along with Branch Returns More info button is not the total number of entries in the corresponding page");
				takeScreenshot("Branch Returns");
			}
			finally
			{
				driver.navigate().back();
				Thread.sleep(2000);
				
			}}
  @Test(priority=11)
  public void Vendors_More_Info_Button() throws IOException, InterruptedException{
	  
	  test=extent.createTest(" Vendors_More_Info_Button");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[11]/div/div[1]/h3"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Vendor= number.getText();
	  int expectedTotalEntries = Integer.parseInt(Vendor.replaceAll("[^0-9]", ""));
	  WebElement Vendors=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[11]/div/a"));
	  Vendors=wait.until(ExpectedConditions.visibilityOf(Vendors));
	  Vendors.click();
	  try {
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showVendor";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct url");
	  }
	  catch(AssertionError e) {
		  System.out.println("DEFECT : The Branch_Returns_More_Info_Button is not working, navigated to wrong page");
		  takeScreenshot("Vendors_More_Info_Button");
	  }
		  try {
			  JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
				WebElement bottomtext = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
				bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
				String text = bottomtext.getText();
				Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
				Matcher matcher = pattern.matcher(text);
				matcher.find();
				int actualnumber = Integer.parseInt(matcher.group(1));
				sa.assertEquals(actualnumber, expectedTotalEntries);
				sa.assertAll();
				test.pass("showing correct entry");
		  }
		  catch(AssertionError | IllegalStateException | NoSuchElementException  e)
			{
				System.out.println("DEFECT : The number displayed along with Vendors More info button is not the total number of entries in the corresponding page");
				takeScreenshot("Branch Returns");
			}
		  finally
			{
				driver.navigate().back();
				Thread.sleep(2000);
				
			}}
  @Test(priority=12)
  public void Reorder_Notification_Master_More_Info_Button() throws IOException, InterruptedException{
	  
	  
	  test=extent.createTest("Reorder_Notification_Master_More_Info_Button");
	  WebElement number=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[12]/div/div[1]/p/b"));
	  number=wait.until(ExpectedConditions.visibilityOf(number));
	  String Reorder_Notification_Master = number.getText();
	  int expectedTotalEntries = Integer.parseInt(Reorder_Notification_Master.replaceAll("[^0-9]", ""));
	  WebElement Reorder_Notification_Masters=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[12]/div/a"));
	  Reorder_Notification_Masters=wait.until(ExpectedConditions.visibilityOf(Reorder_Notification_Masters));
	  Reorder_Notification_Masters.click();
	  try {
			String expected ="https://www.wahylab.com/gendemo/NewMaster/showMasterReorder";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual,expected);
			sa.assertAll();
			test.pass("showing correct page url");
	  }
	  catch(AssertionError e) {
		  System.out.println("DEFECT : The Reorder_Notification_Master button is not working, navigated to wrong page");
		  takeScreenshot("Reorder_Notification_Master");
		  
	  }
		  try {
			  JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
				WebElement bottomtext = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
				bottomtext=wait.until(ExpectedConditions.visibilityOf(bottomtext));
				String text = bottomtext.getText();
				Pattern pattern = Pattern.compile("Showing 1 to 100 of (\\d+) entries");
				Matcher matcher = pattern.matcher(text);
				matcher.find();
				int actualnumber = Integer.parseInt(matcher.group(1));
				sa.assertEquals(actualnumber, expectedTotalEntries);
				sa.assertAll();
				test.pass("showing entry correct");
		  }
				catch(AssertionError | IllegalStateException | NoSuchElementException  e)
				{
					System.out.println("DEFECT : The number displayed along with Reorder_Notification_Master  More info button is not the total number of entries in the corresponding page");
					takeScreenshot("Reorder_Notification_Master");
					test.pass("The number displayed along with Reorder_Notification_Master  More info button is not the total number ");
				}
			  finally
				{
					driver.navigate().back();
					Thread.sleep(2000);
					
				}}
		  
  
  @BeforeClass
  public void beforeClass() {
	    extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\report\\report\\dashboard.html");
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
  Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\Dashboard" + testName + ".png"));

}}
