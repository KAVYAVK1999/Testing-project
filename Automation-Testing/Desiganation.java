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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Desiganation {
	private WebDriver driver;
	private WebDriverWait Wait;
	SoftAssert sa=new SoftAssert();
	private  String baseURL="https://www.wahylab.com/gendemo/";
	
	private static ExtentReports extent;
	private static ExtentTest test;
	
	
  @Test
  public void Verify_Desiganation_Click() throws IOException {
	
      test=extent.createTest("verify the desiganation click");
	  WebElement desi=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[9]/a/span")) ; 
	  desi=Wait.until(ExpectedConditions.visibilityOf(desi));
	  desi.click();
	  
  try {
		String expected = "https://www.wahylab.com/gendemo/NewMaster/showDesignation";
		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, expected);
		sa.assertAll();
		test.pass("Navigate to Desiganation page");
	}
	catch(AssertionError e) {
		System.out.println("DEFECT : The desiganation navigate to wrong page ");
		takeScreenshot("desiganation navigatation");
	}
	finally
	{
		driver.navigate().refresh();
	}}
  @Test(priority=2)
	public void desiganation_Heading() throws IOException, InterruptedException {
	    test=extent.createTest("verify the designation Heading ");
		WebElement header=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")) ;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		header= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[1]/h1")));
		try {
			String expected = "Designation Details";
			String actual =header.getText();
			sa.assertEquals(actual, expected);
			sa.assertAll();
			test.pass("designation heading pass");
		}

		catch(AssertionError e){
			System.out.println("incorrect header");
			takeScreenshot("heading");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	
	}
	@Test(priority=3)

	public void search_valid_name() throws IOException, InterruptedException {
		test=extent.createTest("search valid name");
		WebElement search=driver.findElement(By.xpath("//*[@id=\"designation_table_filter\"]/label/input"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String input = "employee";
		search.sendKeys(input);
		try {

			WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			searchresult = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_info\"]")));

			// Get the text of the search result and trim it
			String actualS = searchresult.getText().trim();

			// Use SoftAssert instead of Assert
			sa.assertEquals(actualS, input, "Search result did not match the input");

            test.pass("search valid name pass");

		} 
		catch (Exception e) 
		{
			// Log any exceptions that occur during the search operation
			System.out.println("An error occurred during the search operation: " + e.getMessage());

			// If an exception occurs, log a failed assertion using SoftAssert
			sa.fail("Exception caught: " + e.getMessage());

			// Use assertAll to mark the test result based on all assertions
			sa.assertAll();
			takeScreenshot("search fail");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}
	@Test(priority=4)
	public void Search_Invalid_Name() throws IOException, InterruptedException
	{

        test=extent.createTest("search invalid name");
		WebElement invalidSearch = driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/label[1]/input[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		invalidSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/label[1]/input[1]")));

		String input = "Denyse Alexander";
		invalidSearch.sendKeys(input); 
		try {
			WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			searchresult = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"designation_table_info\\\"]")));

			String actualS = searchresult.getText().trim();
			sa.assertEquals(actualS, input, "The search result does not match the input.");
			sa.assertAll();
			test.pass("search invalid name");
		} 
		catch (Exception e) {

			System.out.println("An error occurred during the search: " + e.getMessage());
			sa.fail("Exception caught: " + e.getMessage());
			
			takeScreenshot("search invalid name");
		} 
		finally 
		{

			driver.navigate().refresh();
			Thread.sleep(2000);

		}
	}
	@Test(priority=5)
	public void dropdown() throws InterruptedException, IOException {
        test=extent.createTest("dropdown");
		WebElement dropdown=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]/select[1]"));
		dropdown=Wait.until(ExpectedConditions.visibilityOf(dropdown));

		Select select=new Select(dropdown);
		select.selectByValue("200");
		Thread.sleep(3000);
		try
		{

			WebElement wb= driver.findElement(By.xpath("//div[@id='designation_table_info']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			wb= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='designation_table_info']")));
			String expectedN ="Showing 1 to 158 of 158 entries";
			String actualN =wb.getText();
			Assert.assertTrue(actualN.contains(expectedN)); 
            test.pass("dropdown");
		}
		catch(AssertionError e)
		{
			System.out.println("defect:dropdown is not working");
			takeScreenshot("dropdown ");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}
	@Test(priority=6)
	public void  back() throws IOException, InterruptedException {
		test=extent.createTest("verify back click");
		WebElement b =driver.findElement(By.xpath("//body/div[1]/div[1]/section[1]/ol[1]/li[2]/a[1]"));
		b=Wait.until(ExpectedConditions.visibilityOf(b));

		b.click();
		try {
			String expected = "https://www.wahylab.com/gendemo/NewMaster/showDesignation";
			String actual= driver.getCurrentUrl();
			sa.assertEquals(actual, expected);
			sa.assertAll();
            test.pass("back click");
		}
		catch(AssertionError e)
		{
			System.out.println("defect:back button is not working");
			takeScreenshot("back button ");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}
	@Test(priority=7)
	public void excel() throws IOException, InterruptedException{
        test=extent.createTest("exl");
		WebElement exl=driver.findElement(By.xpath("//span[contains(text(),'Excel')]"));
		exl=Wait.until(ExpectedConditions.visibilityOf(exl));
		exl.click();


		String expectedFileName = "GENTLEMAN.xlsx"; // Replace with expected file name

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try 
		{
			wait.until(driver -> {
				File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
				return file.exists();

			}
					);
			System.out.println("exl File downloaded successfully");
			File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
			file.delete();

		}
		catch (Exception e) 
		{
			System.out.println("file download timed out");
			Thread.sleep(2000);
			takeScreenshot("Exel file ");
			test.pass("");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}
	@Test(priority=8)
	public void pdf() throws InterruptedException, IOException{
		test=extent.createTest("pdf");
		WebElement pdf=driver.findElement(By.xpath("//span[contains(text(),'PDF')]"));
		pdf=Wait.until(ExpectedConditions.visibilityOf(pdf));
		pdf.click();
		//   try {

		// String downloadDir = "C:\\Users\\HP\\Downloads\\";  
		//String expectedFileName1 = "GENTLEMAN.pdf";
		//sa.assertEquals(downloadDir, expectedFileName1);
		//sa.assertAll();
		String expectedFileName = "GENTLEMAN.pdf"; // Replace with expected file name

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try 
		{
			wait.until(driver -> {
				File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
				return file.exists();

			}
					);
			System.out.println("pdf File downloaded successfully");
			File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
			file.delete();
			test.pass("");
		
	}
	catch (Exception e) 
	{
		System.out.println("file download timed out");
		Thread.sleep(2000);
		takeScreenshot("pdf file ");
	}

	finally
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}

@Test(priority=9)
public void print() throws IOException, InterruptedException {
	test=extent.createTest(" print");
	WebElement print=driver.findElement(By.xpath("//span[contains(text(),'Print')]"));
	print=Wait.until(ExpectedConditions.visibilityOf(print));
	Thread.sleep(2000);
	//WebElement prcancel=driver.findElement(By.xpath("//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[2]"));

	//print=wait.until(ExpectedConditions.visibilityOf(print));
	// prcancel=wait.until(ExpectedConditions.visibilityOf(prcancel));
	//Thread.sleep(2000);
	print.click();
	//String parent=driver.getWindowHandle();
	String parent=driver.getWindowHandle();
	for (String windowHandle : driver.getWindowHandles())
	{
		driver.switchTo().window(windowHandle);  
	}
	try
	{
		//		//         WebElement printt = driver.findElement(By.xpath("//*[@id=\"headerContainer\"]/h1"));
		//		//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//		//         printt= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"headerContainer\"]/h1")));
		//		//         String expectedP = "Print";
		//		//        String actualP = printt.getText();
		//		//        Assert.assertTrue(actualP.contains(expectedP));
		//		//         
		System.out.println("print");
	}
	catch(AssertionError  r)
	{
		System.out.println("Print text not verified");
	}

	finally
	{
		driver.close();
		driver.switchTo().window(parent);
	}
}
@Test(priority=10)
public void csv() throws InterruptedException, IOException
{
	test=extent.createTest(" csv");
	WebElement csv=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/a[5]"));

	csv=Wait.until(ExpectedConditions.visibilityOf(csv));
	csv.click();

	String expectedFileName = "GENTLEMAN.csv"; // Replace with expected file name

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	try 
	{
		wait.until(driver -> {
			File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
			return file.exists();
			// Assert.assertTrue(file.exists());

		});
		System.out.println("CSV File downloaded successfully");
		File file = new File("C:\\Users\\HP\\Downloads\\" + expectedFileName);
		file.delete();
		test.pass("");
	}
	catch (Exception e) 
	{
		System.out.println("file download timed out");
	}

}

@Test(priority=11)
public void sort() throws InterruptedException {
	test=extent.createTest("sort");
	try
	{
	WebElement  beforesort = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
	WebDriverWait ws =new WebDriverWait(driver, Duration.ofSeconds(15));
	beforesort= ws.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[2]")));
	String expected = beforesort.getText();
	//String sort = beforesort.getText();
	
	WebElement sortbutton = driver.findElement(By.xpath("//th[contains(text(),'Slno')]"));
	WebDriverWait wb =new WebDriverWait(driver, Duration.ofSeconds(15));
	sortbutton= wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Slno')]")));
	sortbutton.click();
	
	WebElement aftersort = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));		
	WebDriverWait wa =new WebDriverWait(driver, Duration.ofSeconds(15));
	aftersort= wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[2]")));
	String actual= aftersort.getText();
	Assert.assertEquals(actual,expected);
	//Assert.assertEquals(actual,sort);
	
	
}
	catch(AssertionError  e)
	{
		System.out.println("defect:Sort button dose not work");
	}
	finally
	{
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
	

@Test(priority= 12)
public void namesort() throws InterruptedException {
	test=extent.createTest("name sort");
	try {
		WebElement beforenamesort =  driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
		WebDriverWait wbn =new WebDriverWait(driver, Duration.ofSeconds(15));
		beforenamesort= wbn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[2]")));
	    String expected = beforenamesort.getText();
	
		WebElement sortb= driver.findElement(By.xpath("//th[contains(text(),'Action')]"));
		WebDriverWait wbb =new WebDriverWait(driver, Duration.ofSeconds(15));
		sortb= wbb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Action')]")));
	    sortb.click();
	    Thread.sleep(3000);
	    WebElement aftersort = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
	    WebDriverWait wbb1 =new WebDriverWait(driver, Duration.ofSeconds(15));
	    aftersort= wbb1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[2]/td[2]")));
	    
	    String actual = aftersort.getText();
	    Assert.assertEquals(actual, expected);
	
		
	}
		catch(AssertionError e)
		{
			System.out.println("defect:Name sort dosenot work");
		}
	finally
	{
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
	
	

@Test(priority= 13)
public void next() throws IOException, InterruptedException {
	test=extent.createTest("//a[contains(text(),'Next')]");
	WebElement next=driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
	next=Wait.until(ExpectedConditions.visibilityOf(next));
	next.click();
	WebElement data =  driver.findElement(By.xpath("//div[@id='designation_table_info']"));
	data=Wait.until(ExpectedConditions.visibilityOf(data));

	try {
		String expected = "Showing 101 to 158 of 158 entries\n"
				+ "";
		String actual = data.getText();
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}
	catch(AssertionError e)
	{
		System.out.println("defect:Not moving to next page");
		takeScreenshot("next ");
	}
	finally
	{
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
@Test(priority= 14)
public void previous() throws InterruptedException, IOException {
	test=extent.createTest("previous");
	WebElement previous=driver.findElement(By.xpath("//a[contains(text(),'Previous')]"));
	previous=Wait.until(ExpectedConditions.visibilityOf(previous));
	previous.click();
	WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
	data=Wait.until(ExpectedConditions.visibilityOf(data));

	try {
		String expected = "Showing 1 to 100 of 158 entries\n";
				

		String actual = data.getText();
		sa.assertEquals(actual, expected);
		sa.assertAll();
        test.pass("previous");
	}
	catch(AssertionError e)
	{
		System.out.println("defect:Not moving to previous page");
		takeScreenshot(" previous ");
	}
	finally
	{
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
@Test(priority=15)
public void homebutton() throws InterruptedException, IOException
{	
	test=extent.createTest("homebutton");
	WebElement home=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[1]/a"));
	home=Wait.until(ExpectedConditions.visibilityOf(home));
	home.click();
	try {
		String expected = "https://www.wahylab.com/gendemo/Dashboard";

		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, expected);
		sa.assertAll();
        test.pass("homebutton");
	}
	catch(AssertionError e)
	{
		System.out.println("defect:Not moving to previous page");
		takeScreenshot(" home page ");
	}
	finally
	{
		//
		driver.navigate().refresh();
		Thread.sleep(2000);
	}}
@Test(priority=16)
public void adddesignation() throws IOException, InterruptedException {

	WebElement add_designation=driver.findElement(By.xpath("/html/body"));
	add_designation=Wait.until(ExpectedConditions.visibilityOf(add_designation));
	add_designation.click();
	WebElement DesignationName=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/button"));
	DesignationName=Wait.until(ExpectedConditions.visibilityOf(DesignationName));
	DesignationName.click();
	//DesignationName
	WebElement name=driver.findElement(By.xpath("//input[@id='emp_name']"));
	name=Wait.until(ExpectedConditions.visibilityOf(name));
	name.click();
	name.sendKeys("empl786");
	WebElement save=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"));
	save=Wait.until(ExpectedConditions.visibilityOf(save));
	save.click();
	WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
	data=Wait.until(ExpectedConditions.visibilityOf(data));
	
	try
	{
		

		Thread.sleep(2000);
		

		String expected = "empl" ;
		String actual = data.getText().trim();
		Assert.assertEquals(actual, expected);
		//sa.assertAll();
	}
	catch(AssertionError e)
	{
		System.out.println("defect:No message");
		takeScreenshot("adduser");
	}
	finally
	{
		
		driver.navigate().refresh();
		Thread.sleep(2000);		  
	}}
@Test(priority=17,enabled=false)
public void edit() throws InterruptedException, IOException {
	WebElement edit=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[3]/center/a[1]/i"));
	edit=Wait.until(ExpectedConditions.visibilityOf(edit));

	edit.click();
	
	Thread.sleep(2000);
	WebElement DesignationNamechange=driver.findElement(By.xpath("//input[@id='emp_name']"));
	DesignationNamechange=Wait.until(ExpectedConditions.visibilityOf(DesignationNamechange));
	DesignationNamechange.click();
	//DesignationName
	
	DesignationNamechange.sendKeys("empl6789");
	WebElement save=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"));
	save=Wait.until(ExpectedConditions.visibilityOf(save));
	save.click();
	WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
	data=Wait.until(ExpectedConditions.visibilityOf(data));
	
	try
	{
		

		Thread.sleep(2000);
		

		String expected = "empl6789" ;
		String actual = data.getText().trim();
		Assert.assertEquals(actual, expected);
		//sa.assertAll();
	}
	catch(AssertionError e)
	{
		System.out.println("defect:No message");
		takeScreenshot("edit designation");
	}
	finally
	{
		
		driver.navigate().refresh();
		Thread.sleep(2000);		  
	}}
@Test(priority=18)
public void deleteValid() throws InterruptedException
{
	WebElement deleteV = driver.findElement(By.xpath("/html/body"));
	WebDriverWait d =new WebDriverWait(driver, Duration.ofSeconds(15));
	deleteV= d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
	deleteV.click();
	
	//String username = "NESSIYA";
	WebElement message = driver.findElement(By.xpath(""));
	WebDriverWait dm =new WebDriverWait(driver, Duration.ofSeconds(15));
	message= dm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[4]/div[1]/div[1]/form[1]/div[1]/h3[1]")));
	
//	try {
//		String expected = "Are you sure you want to delete ";
//		String actual = message.getText().trim();
//		Assert.assertTrue(actual.contains(expected));
//		
//			
		
	//}
	//catch(AssertionError e)
	{
		System.out.println("defect: username invalid");
	}
	
	
	WebElement cok = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
	WebDriverWait dc =new WebDriverWait(driver, Duration.ofSeconds(15));
	cok= dc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
	cok.click();
}
@Test(priority=19)
public void invalidUser() throws InterruptedException, IOException
{
	WebElement add_designation=driver.findElement(By.xpath("//button[contains(text(),'Add Designation')]"));
	add_designation=Wait.until(ExpectedConditions.visibilityOf(add_designation));
	add_designation.click();
	WebElement DesignationName=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/button"));
	DesignationName=Wait.until(ExpectedConditions.visibilityOf(DesignationName));
	DesignationName.click();
	//DesignationName
	WebElement name=driver.findElement(By.xpath("//input[@id='emp_name']"));
	name=Wait.until(ExpectedConditions.visibilityOf(name));
	name.click();
	name.sendKeys("empl@#$^78");
	WebElement save=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"));
	save=Wait.until(ExpectedConditions.visibilityOf(save));
	save.click();
	WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
	data=Wait.until(ExpectedConditions.visibilityOf(data));
	
	try
	{
		

		Thread.sleep(2000);
		

		String expected = "empl" ;
		String actual = data.getText().trim();
		Assert.assertEquals(actual, expected);
		//sa.assertAll();
	}
	catch(AssertionError e)
	{
		System.out.println("defect:No message");
		takeScreenshot("adduser");
	}
	finally
	{
		
		driver.navigate().refresh();
		Thread.sleep(2000);		  
	}}

  @BeforeClass
  public void beforeClass() {
	    extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\report\\Desiganation.html");
		extent.attachReporter(htmlReporter);
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver = new ChromeDriver();
		Wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement user=driver.findElement(By.name("username"));
		user=Wait.until(ExpectedConditions.visibilityOf(user));
		user.sendKeys("admin");
		WebElement pass=driver.findElement(By.name("password"));
		pass=Wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys("admin@gentleman");
		WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/form/button"));
		login=Wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
		driver.navigate().refresh();
		Thread.sleep(2000);	

	}
  

  @AfterTest
  public void afterTest() {
  }
  private void takeScreenshot(String testName) throws IOException  {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scrnsht = screenshot.getScreenshotAs(OutputType.FILE);
		Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\Desiganation" + testName + ".png"));
	}
	

}
