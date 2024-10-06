package tent_gran_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import tent_gram_test.Page_Tnt;



public class Test_tent {
	WebDriver driver;
	String Baseurl="https://tentgram.com/home";
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.get(Baseurl);
	}
	@Test
	public void test() throws InterruptedException
	{
		driver.manage().window().maximize();
		Page_Tnt ob =new Page_Tnt(driver);
	
		
//check home page header sections
//TRIPSE
		ob.TripseClick();
		//ob.ThreadsleepCall();
		ob.TDubai();
		//ob.ThreadsleepCall();
		ob.Tripse();
		//ob.ThreadsleepCall();
//DubaiClick
		ob.Dubai();
//KeralaClick
		ob.Kerala();
		
//HimachalClick
		ob.Himachal("Anna","anna123@gmail.com" ,"4567891023");
//LadakhClick
		ob.Ladakh("Anna","anna123@gmail.com" ,"4567891023");
		
//Membership click
		ob.Membership();
		
//PiggyBank
		ob.piggybank();
//CONTACT US
		ob.contactus("anna","anna123@gmail.com","package","package");
//Bloggclick
		ob.blogg("super","anna","Annakvp@gmail.com");
//login	
		ob.Signup("Geethu m","geethum123@gmail.com", "7300000002", "123fgh@ft");
		
//reserve
		ob.reserve();
//Home page Scrolling
		
		ob.testHomePagescrolling();
//CHECK THE MIDDEL LOCATIONS
		ob.clicklocations();
//middle advertisement
		ob.middle();
//learn more
		ob.learnmore();
		//ob.
//social media
		ob.socialmedia("annajack","annajack123@gmail.com","experience"," good packages");
		ob.sicialmedia("annajohn12@gmail.com");
}}
