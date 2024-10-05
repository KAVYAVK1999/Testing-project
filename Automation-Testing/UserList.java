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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UserList {
	private WebDriver driver;
	private WebDriverWait wait;
	SoftAssert sa=new SoftAssert();
	private String baseUrl = "https://www.wahylab.com/gendemo/";
	private static ExtentReports extent;
	private static ExtentTest test;

	@Test(priority=1)
	public void Verify_Userlist_Click() throws IOException{
		test=extent.createTest("Verify_Userlist_Click");
		WebElement Userlist=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[2]/a/span"));
		Userlist=wait.until(ExpectedConditions.visibilityOf(Userlist));
		Userlist.click();
		try {
			String expected = "https://www.wahylab.com/gendemo/NewMaster/showLoginUsersList";
			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual, expected);
			sa.assertAll();
			test.pass("navigate to correct page");
		}
		catch(AssertionError e) {
			System.out.println("DEFECT : The Userlist navigate to wrong page ");
			takeScreenshot("Userlist navigatation");
		}
		finally
		{
			driver.navigate().refresh();
		}
	}

	@Test(priority=2)
	public void Userlist_Heading() {
		
		test=extent.createTest(" verify_Userlist_Heading");
		WebElement header=driver.findElement(By.xpath("/html/body")) ;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		header= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[1]/h1")));
		try {
			String expected = "Users List";
			String actual =header.getText();
			sa.assertEquals(actual, expected);
			sa.assertAll();
			test.pass("correct heading");
		}

		catch(AssertionError e){
			System.out.println("incorrect header");
		}
	}
	@Test(priority=3)

	public void search_valid_name() throws IOException, InterruptedException {
		
		test=extent.createTest("verify search valid name");
		WebElement search=driver.findElement(By.xpath("/html/body"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String input = "anna";
		search.sendKeys(input);
		try {

			WebElement searchresult = driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			searchresult = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]")));

			// Get the text of the search result and trim it
			String actualS = searchresult.getText().trim();

			// Use SoftAssert instead of Assert
			sa.assertEquals(actualS, input, "Search result did not match the input");
			test.pass("Search result did not match the input");


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

		test=extent.createTest("Search_Invalid_Name");
		WebElement invalidSearch = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/label[1]/input[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		invalidSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/label[1]/input[1]")));

		String input = "Denyse Alexander";
		invalidSearch.sendKeys(input); 
		try {
			WebElement searchresult = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[1]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			searchresult = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")));

			String actualS = searchresult.getText().trim();
			sa.assertEquals(actualS, input, "The search result does not match the input.");
			test.pass("The search result does not match the input");
		} 
		catch (Exception e) {

			System.out.println("An error occurred during the search: " + e.getMessage());
			sa.fail("Exception caught: " + e.getMessage());
			sa.assertAll();
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

		WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"designation_table_length\"]/label/select"));
		dropdown=wait.until(ExpectedConditions.visibilityOf(dropdown));

		Select select=new Select(dropdown);
		select.selectByValue("200");
		Thread.sleep(3000);
		try
		{

			WebElement wb= driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			wb= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_info\"]")));
			String expectedN ="Showing 1 to 100 of 356 entries";
			String actualN =wb.getText();
			Assert.assertTrue(actualN.contains(expectedN)); 

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
		
		test=extent.createTest("verify back");
		WebElement b =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[2]/a"));
		b=wait.until(ExpectedConditions.visibilityOf(b));

		b.click();
		try {
			String expected = "https://www.wahylab.com/gendemo/NewMaster/showLoginUsersList";
			String actual= driver.getCurrentUrl();
			sa.assertEquals(actual, expected);
			sa.assertAll();
           test.pass("navigate to correct page");
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
		test=extent.createTest("verify excel");

		WebElement exl=driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[2]/span"));
		exl=wait.until(ExpectedConditions.visibilityOf(exl));
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
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
		}
	}

	@Test(priority=8)
	public void pdf() throws InterruptedException, IOException{
		test=extent.createTest("verify pdf");
		WebElement pdf=driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[3]/span"));
		pdf=wait.until(ExpectedConditions.visibilityOf(pdf));
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
		test=extent.createTest("vrify print");
		WebElement print=driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[4]/span"));
		print=wait.until(ExpectedConditions.visibilityOf(print));
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
		
		test=extent.createTest("verify csv");
		WebElement csv=driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[3]/span"));

		csv=wait.until(ExpectedConditions.visibilityOf(csv));
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
		}
		catch (Exception e) 
		{
			System.out.println("file download timed out");
		}

	}

	@Test(priority=11)
	public void sort() {
		try
		{
			test=extent.createTest("verify sort");
		WebElement  beforesort = driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[100]/td[1]"));
		WebDriverWait ws =new WebDriverWait(driver, Duration.ofSeconds(15));
		beforesort= ws.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[100]/td[1]")));
		String expected = beforesort.getText();
		//String sort = beforesort.getText();
		
		WebElement sortbutton = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[5]/div[1]/div/table/thead/tr/th[1]"));
		WebDriverWait wb =new WebDriverWait(driver, Duration.ofSeconds(15));
		sortbutton= wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[5]/div[1]/div/table/thead/tr/th[1]")));
		sortbutton.click();
		
		WebElement aftersort = driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[1]"));		
		WebDriverWait wa =new WebDriverWait(driver, Duration.ofSeconds(15));
		aftersort= wa.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[1]")));
		String actual= aftersort.getText();
		Assert.assertEquals(actual,expected);
		//Assert.assertEquals(actual,sort);
		
		
	}
		catch(AssertionError  e)
		{
			System.out.println("defect:Sort button dose not work");
		}
		
		}
	
	@Test(priority= 12)
	public void namesort() throws InterruptedException {
		try {
			test=extent.createTest("verify name sort");
			WebElement beforenamesort =  driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[5]/td[2]"));
			WebDriverWait wbn =new WebDriverWait(driver, Duration.ofSeconds(15));
			beforenamesort= wbn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[5]/td[2]")));
		    String expected = beforenamesort.getText();
		
			WebElement sortb= driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[5]/div[1]/div/table/thead/tr/th[4]"));
			WebDriverWait wbb =new WebDriverWait(driver, Duration.ofSeconds(15));
			sortb= wbb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[5]/div[1]/div/table/thead/tr/th[4]")));
		    sortb.click();
		    Thread.sleep(3000);
		    WebElement aftersort = driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
		    WebDriverWait wbb1 =new WebDriverWait(driver, Duration.ofSeconds(15));
		    aftersort= wbb1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]")));
		    
		    String actual = aftersort.getText();
		    Assert.assertEquals(actual, expected);
		
			
		}
			catch(AssertionError e)
			{
				System.out.println("defect:Name sort dosenot work");
			}
		
		}
	
	@Test(priority= 13)
	public void next() throws IOException, InterruptedException {
		test=extent.createTest("verify next");
		WebElement next=driver.findElement(By.xpath("//*[@id=\"designation_table_next\"]/a"));
		next=wait.until(ExpectedConditions.visibilityOf(next));
		next.click();
		WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
		data=wait.until(ExpectedConditions.visibilityOf(data));

		try {
			String expected = "Showing 101 to 200 of 381 entries";
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
		test=extent.createTest("verify previous");
		WebElement previous=driver.findElement(By.xpath("//*[@id=\"designation_table_previous\"]/a"));
		previous=wait.until(ExpectedConditions.visibilityOf(previous));
		previous.click();
		WebElement data =  driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
		data=wait.until(ExpectedConditions.visibilityOf(data));

		try {
			String expected = "Showing 1 to 100 of 381 entries\n";

			String actual = data.getText();
			sa.assertEquals(actual, expected);
			sa.assertAll();
			test.pass("det correct text");

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
	{	test=extent.createTest("verify homebutton");
		WebElement home=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[1]/a"));
		home=wait.until(ExpectedConditions.visibilityOf(home));
		home.click();
		try {
			String expected = "https://www.wahylab.com/gendemo/Dashboard";

			String actual = driver.getCurrentUrl();
			sa.assertEquals(actual, expected);
			sa.assertAll();
            test.pass("verify url");
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
	public void adduser() throws IOException, InterruptedException {
		test=extent.createTest("verify add user");

		WebElement Userlist=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[2]/a/span"));
		Userlist=wait.until(ExpectedConditions.visibilityOf(Userlist));
		Userlist.click();
		WebElement adduser=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/button"));
		adduser=wait.until(ExpectedConditions.visibilityOf(adduser));
		adduser.click();
		//username
		WebElement name=driver.findElement(By.xpath("//*[@id=\"username1\"]"));
		name=wait.until(ExpectedConditions.visibilityOf(name));
		name.click();
		name.sendKeys("keerthimp");
		//email
		Thread.sleep(2000);
		WebElement email=driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		email=wait.until(ExpectedConditions.visibilityOf(email));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(email).click().sendKeys("keerthi13@gmail.com").perform();
		Thread.sleep(3000);
		//password
		WebElement password=driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		password=wait.until(ExpectedConditions.visibilityOf(password));
		password.click();
		password.sendKeys("keer23@8)");
		//Branch
		WebElement Branch=driver.findElement(By.xpath("//select[@id='branchSelect']"));
		Branch =wait.until(ExpectedConditions.visibilityOf(Branch));
		Branch.click();
		Select select=new Select(Branch);
		select.selectByVisibleText("Ernakulam");

		//Type
		WebElement Type=driver.findElement(By.xpath("//*[@id=\"user_type\"]"));
		Branch =wait.until(ExpectedConditions.visibilityOf(Branch));
		Branch.click();
		Select select1=new Select(Type);
		select1.selectByVisibleText("USER");
		//adduser
		WebElement adduserclick=driver.findElement(By.xpath("//*[@id=\"addUserForm\"]/div[2]/button[2]"));
		adduserclick=wait.until(ExpectedConditions.visibilityOf(adduserclick));
		adduserclick.click();
		//OK
		try
		{
			WebElement success = driver.findElement(By.xpath("/html/body/div[2]/div"));
			//WebDriverWait wh7 =new WebDriverWait(driver, Duration.ofSeconds(15));
			success= wait.until(ExpectedConditions.visibilityOf(success));


			Thread.sleep(2000);
			//try {

			String expected = "Successfully added new user" ;
			String actual = success.getText().trim();
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
			WebElement ok=driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]"));
			ok=wait.until(ExpectedConditions.visibilityOf(ok));
			ok.click();
			driver.navigate().refresh();
			Thread.sleep(2000);		  
		}}
	@Test(priority=17)
	public void edit() throws InterruptedException {
		test=extent.createTest("verify edit");
		WebElement edit=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[1]"));
		edit=wait.until(ExpectedConditions.visibilityOf(edit));

		edit.click();
		Thread.sleep(2000);

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username=wait.until(ExpectedConditions.visibilityOf(username));
		username.clear();
		username.sendKeys("annamma kp");

		WebElement useremail = driver.findElement(By.id("username"));
		useremail=wait.until(ExpectedConditions.visibilityOf(useremail));
		useremail.clear();
		useremail.sendKeys("annakp234@gmail.com");

		WebElement userpassword = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		userpassword=wait.until(ExpectedConditions.visibilityOf(userpassword));
		userpassword.clear();
		userpassword.sendKeys("anna123");

		WebElement userModify =  driver.findElement(By.xpath("//button[contains(text(),'Modify')]"));
		userModify=wait.until(ExpectedConditions.visibilityOf(userModify));
		userModify.click();

		WebElement okk = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		okk=wait.until(ExpectedConditions.visibilityOf(okk));

		okk.click();
		driver.navigate().refresh();
		Thread.sleep(2000);	
	}
	@Test(priority=18)
	public void deleteValid() throws InterruptedException
	{
		test=extent.createTest(" verify deleteValid");
		WebElement deleteV = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]"));
		WebDriverWait d =new WebDriverWait(driver, Duration.ofSeconds(15));
		deleteV= d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
		deleteV.click();
		
		String username = "NESSIYA";
		WebElement message = driver.findElement(By.xpath("//body[1]/div[1]/div[4]/div[1]/div[1]/form[1]/div[1]/h3[1]"));
		WebDriverWait dm =new WebDriverWait(driver, Duration.ofSeconds(15));
		message= dm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[4]/div[1]/div[1]/form[1]/div[1]/h3[1]")));
		
		try {
			String expected = "Are you sure you want to delete "+username +"?";
			String actual = message.getText().trim();
			Assert.assertTrue(actual.contains(expected));
			
				
			
		}
		catch(AssertionError e)
		{
			System.out.println("defect: username invalid");
		}
		
		WebElement okbutton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		WebDriverWait dd =new WebDriverWait(driver, Duration.ofSeconds(15));
		okbutton= dd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Confirm')]")));
		okbutton.click();
		WebElement cok = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		WebDriverWait dc =new WebDriverWait(driver, Duration.ofSeconds(15));
		cok= dc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		cok.click();
	}
	@Test(priority=19)
	public void invalidUser()
	{
		test=extent.createTest("verify_invalidUser");
		WebElement addUserButton = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/button"));
		WebDriverWait wh1 =new WebDriverWait(driver, Duration.ofSeconds(15));
		addUserButton= wh1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/button")));
		addUserButton.click();
		
		WebElement invalidUserName = driver.findElement(By.xpath("//input[@id='username1']"));
		WebDriverWait wh2 =new WebDriverWait(driver, Duration.ofSeconds(15));
		invalidUserName= wh2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username1']")));
		invalidUserName.sendKeys("765678");
		
		WebElement invalidPassword =driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		WebDriverWait wh3 =new WebDriverWait(driver, Duration.ofSeconds(15));
		invalidPassword= wh3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));
		invalidPassword.sendKeys("pp00y");
		
		WebElement invalidEmail = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		WebDriverWait wh4 =new WebDriverWait(driver, Duration.ofSeconds(15));
		invalidEmail= wh4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		invalidEmail.sendKeys("opop3@ag");
		
		WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'ADD USER')]"));
		WebDriverWait wh5 =new WebDriverWait(driver, Duration.ofSeconds(15));
		okButton= wh5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'ADD USER')]")));
		okButton.click();
		try {
		WebElement errorMessage = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]"));
		WebDriverWait wh =new WebDriverWait(driver, Duration.ofSeconds(15));
		errorMessage= wh.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]")));
		String expected = "invalid data";
		String actual = errorMessage.getText();
		Assert.assertTrue(actual.contains(expected));
		
		
	}
		catch(AssertionError r)
		{
			System.out.println("defect:No error message is displayed for invalid user entry");
		}
		finally
		{
			driver.navigate().refresh();
		}
		
	}
	
	@Test(priority= 20)
	public void editInvalid()
	{
//		WebElement EditIn =  driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[4]/center/button[1]"));
//		WebDriverWait wh =new WebDriverWait(driver, Duration.ofSeconds(15));
//		EditIn= wh.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[4]/center/button[1]")));
//		EditIn.click();
		test=extent.createTest("verify_editInvalid");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement EditIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/center[1]/button[1]")));
	        
	      
	        Actions actions = new Actions(driver);
	        actions.moveToElement(EditIn).click().build().perform();
		
		WebElement nameEdit =  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[2]"));
		WebDriverWait we =new WebDriverWait(driver, Duration.ofSeconds(15));
		nameEdit= we.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[2]")));
		nameEdit.clear();
		nameEdit.sendKeys("753678");
		
		WebElement emailEdit = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		WebDriverWait wl =new WebDriverWait(driver, Duration.ofSeconds(15));
		emailEdit= wl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		emailEdit.clear();
		nameEdit.sendKeys("abppdcddd@gg");
		WebElement passwordEdit = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		WebDriverWait wp =new WebDriverWait(driver, Duration.ofSeconds(15));
		passwordEdit= wp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));
		passwordEdit.clear();
		passwordEdit.sendKeys("pwtsys");
		
		WebElement submit =  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]"));
		WebDriverWait ws =new WebDriverWait(driver, Duration.ofSeconds(15));
		submit= ws.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")));
		submit.click();
		try
		{
			WebElement errormessage =  driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]"));
			WebDriverWait wr =new WebDriverWait(driver, Duration.ofSeconds(15));
			errormessage= wr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]")));
			String expected = "invalid user details";
			String actual = errormessage.getText();
			Assert.assertTrue(actual.contains(expected));
		}
		catch(AssertionError e)
		{
			System.out.println("defect:Invalid user data can be added" + e.getMessage());
		}
		finally
		{
//			WebElement delete = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]"));
//			WebDriverWait wd =new WebDriverWait(driver, Duration.ofSeconds(15));
//			delete= wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
//			
			Actions mouse=new Actions(driver);
			WebElement delete=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/center[1]/button[2]"));
			WebDriverWait wd =new WebDriverWait(driver, Duration.ofSeconds(15));
		    delete= wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/center[1]/button[2]")));
			mouse.moveToElement(delete).click().perform();
			
			Actions mouse1 = new Actions(driver);
			WebElement Confirm = driver.findElement(By.xpath(("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/center[1]/button[2]")));
			WebDriverWait wc =new WebDriverWait(driver, Duration.ofSeconds(15));
			Confirm= wc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/center[1]/button[2]")));
			mouse1.moveToElement(Confirm).click().perform();
			
			driver.navigate().refresh();
			
		}
		}

	@BeforeClass
	public void beforeClass() {
		extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Selenium\\Gentleman\\target\\HTMLreport\\Userlist.html");
		extent.attachReporter(htmlReporter);
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void afterTest() throws InterruptedException {
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
		driver.navigate().refresh();
		Thread.sleep(2000);	

	}

	@AfterTest
	public void afterTest1() {

		driver.quit();
	}

	private void takeScreenshot(String testName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File scrnsht = screenshot.getScreenshotAs(OutputType.FILE);
		Files.copy(scrnsht, new File("C:\\Users\\HP\\eclipse-workspace\\gentelman\\target\\scrnst\\Dashboard" + testName + ".png"));

	}

}
