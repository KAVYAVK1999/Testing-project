package tent_gram_test;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.Alert;
public class Page_Tnt {
WebDriver driver;
	
	By Home=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[1]/a[1]");
	By  expectedTitle = By.xpath("/html/body/app-root/tentgram-header/nav/div/div[1]/img[1]");
	By locationclick=(By.xpath("/html/body/app-root/tentgram-home/div/div/section[1]/div[1]/div"));
	//FUJAIRAHPACKAGE
	
	    By FujairahPackage=(By.xpath("//*[@id=\"mat-tab-label-0-0\"]/div"));
	    By FujairahPacImage =(By.xpath("//*[@id=\"mat-tab-content-5-0\"]/div/section/div/div"));
		By FujairapackimgClick=(By.cssSelector(".grid-item"));
		By FujPacDow=(By.xpath("/html/body/app-root/tentgram-package/div/section/div[1]/div/a"));
		//By FUjNewtabOpen=(By.linkText("blob:https://tentgram.com/b4c70bd8-affa-411d-8b86-a96889047f6c"));
		By Reservenow=(By.xpath("/html/body/app-root/tentgram-package/div/section/div[2]/button"));
		By ReserveNowCross=(By.xpath("/html/body/app-root/tentgram-package/section/tentgram-booking/section/button/img"));
	//FujairahExperience
		
		By FujairahExperience=(By.xpath("//*[@id=\"mat-tab-label-1-1\"]/div"));
		By FujExpImageClick=(By.cssSelector(".grid-item p"));
		By FujExpWhatsApp=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[1]/div/div/div[2]"));
		By FbShareClick=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[1]/div/div/div[1]"));
	//GALLARY
		
		By GalleryRightArrow=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/ngx-gallery-arrows/div[2]/div/i"));
		By GalleryLeftArrow=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/ngx-gallery-arrows/div[1]/div/i"));
		By GalleryPhotos=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/div/div/a[1]"));
		By GalleryPhotostwo=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/div/div/a[2]"));
		By GalleryPhotosThree=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/div/div/a[4]"));
		By GallaryZoomRC=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-preview/div[1]/div/ngx-gallery-action/div/i"));
        By GalleryBack=(By.xpath("/html/body/app-root/tentgram-experience/div/div/section[3]/ngx-gallery/div/ngx-gallery-preview/div[1]/div/ngx-gallery-action/div/i"));
    //Booking
        
        By FujExpBooking=(By.xpath("/html/body/app-root/tentgram-experience/div/section/div[2]/button"));
        By FuJBookBack=(By.xpath("/html/body/app-root/tentgram-experience/section/tentgram-booking/section/button/img"));
    //EventClick
        
	    By Event=(By.xpath("//*[@id='mat-tab-label-2-2']/div"));
	    
	//FUJ Home Page EXP Image Click Zoom ArrowClick
	     By PicA=(By.xpath("/html/body/app-root/tentgram-location/div/div/section[3]/tentgram-experience-list/div[1]/div[2]/button[2]/img"));
	     By Picone=(By.xpath("/html/body/app-root/tentgram-location/div/div/section[3]/tentgram-experience-list/div[2]/swiper/div/div[1]/div[5]/div"));
	     
	//Home
	     By HomePage=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[1]/a[1]");
	//TRIPSE
	     By TripseClick=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a");
	//SUB HEADINGS CLICK
	     By TDubai =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[1]");
	     By Tkerala =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[2]");
	     By TMegalaya =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[3]");
	     By TBali =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[4]");
	     By TKashmir =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[5]");
	     By THimachal =By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[6]");
	 	 By TLadakh=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[7]");
	     By TSriLanka=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[1]/div[1]/ul/li[8]");
	//Dubai
	     
	     By clickandmore=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/div/p/a");
	 //Kerala
	     
	     By view=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[2]/section/div[1]/div[2]/div[2]/button/span");
	     By callus=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[1]/section/div[1]/p[1]/a");
	     By WhatsApp=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[1]/section/div[1]/p[2]");
	     By alert=By.xpath("(\"//a[@class='bs-alert-close']\")");
	     By Image=By.xpath("/html/body/app-root/tentgram-trips/div/section/div[1]");
	  //send
	     By Names=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[2]/div[1]/tentgram-contact-form/div/form/div[1]/input");
	     By Email=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[2]/div[1]/tentgram-contact-form/div/form/div[2]/input");
	     By Numbers=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[2]/div[1]/tentgram-contact-form/div/form/div[3]/input");
	     By SendEnq=By.xpath("/html/body/app-root/tentgram-trips/div/div/section[1]/div/div[2]/div[1]/tentgram-contact-form/div/form/div[4]/button");
	     By alerts=By.xpath("//*[@id=\"mat-dialog-0\"]/tentgram-thankyou-dialog/div");
	     By gotobacks=By.xpath("/html/body/app-root/tentgram-trips/div/div/button");
	//HimachelView
	     By viewH=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[2]/section/div[1]/div[2]/div[2]/button/span");
	//ladakView
	     By ViewL=By.xpath("/html/body/app-root/tentgram-trips-landing/div/div/section[2]/section/div[1]/div[2]/div[2]/button/span");
	//Membership
	     By Membership=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a");
	     By ViewCardm=By.xpath("/html/body/app-root/tentgram-card/div/section[1]/div/div[1]/a/button");
	     By silver=By.xpath("/html/body/app-root/tentgram-card/div/section[1]/div/div[2]/div[1]/img");
	     By gold=By.xpath("//*[@id=\"pricing\"]/div/div[2]/div[1]/div[2]/ul/li[1]");
	     By Platinam=By.xpath("7Sc8F4pJN4ooMzCxP9gadY9JhTAh3DupWXwzoM2WSZQZ");
	     By readmore=By.xpath("//*[@id=\"pricing\"]/div/div[4]/p/a");
//PIGGYBANK
	     By piggybankClick=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
	     By naught=By.xpath("/html/body/app-root/tentgram-piggybank/div/section[2]/div/div[1]/div[1]/div/div[2]/button");
	     By prime=By.xpath("/html/body/app-root/tentgram-piggybank/div/section[2]/div/div[2]/div[1]/div/div[2]/button");
	    // By crossclick=By.xpath("//*[@id=\"mat-dialog-4\"]/tentgram-login/div/div[1]/img");
	     By emailid=By.xpath("//*[@id=\"mat-dialog-5\"]/tentgram-login/div/div[3]/div[1]/input");
	     By passwd=By.xpath("//*[@id=\"password-field\"]");
	     By login=By.xpath("");
//Contact us
	     By contactus=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a");
	     By ctcName=By.xpath("/html/body/app-root/tentgram-contact-us/div/div[2]/div/div[2]/div[1]/div[1]/input");
	     By ctcEmail=By.xpath("/html/body/app-root/tentgram-contact-us/div/div[2]/div/div[2]/div[1]/div[2]/input");
	     By ctcSubject=By.xpath("/html/body/app-root/tentgram-contact-us/div/div[2]/div/div[2]/div[2]/input");
	     By ctcMessage=By.xpath("/html/body/app-root/tentgram-contact-us/div/div[2]/div/div[2]/div[3]/textarea");
	     By sendmessage=By.xpath("/html/body/app-root/tentgram-contact-us/div/div[2]/div/div[2]/div[4]/button");
	     
//BLOG
	     By BlogClick=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a");
	     By readBlog=By.xpath("//*[@id=\"page\"]/main/div/div[1]/div/section[3]/div/div/div/div/div/div/div[5]/div/div[2]/div[4]/a");
	     By comment=By.xpath("//*[@id=\"comment\"]");
	     By name2=By.xpath("//*[@id=\"author\"]");
	     By email2=By.xpath("//*[@id=\"email\"]");
	     By post=By.xpath("//*[@id=\"jltma-submit\"]");
	     By homeBlogg=By.xpath("//*[@id=\"menu-item-93\"]/a");
	     
//login
	     By loginclick=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a[1]");
	     By lgemail=By.xpath("//*[@id=\"mat-dialog-0\"]/tentgram-login/div/div[3]/div[1]/input");
	     By ldpsw=By.xpath("//*[@id=\"password-field\"]");
	     By lglogin=By.xpath("//*[@id=\"mat-dialog-8\"]/tentgram-login/div/div[3]/div[4]/button");
//Sign up
	     By Signup=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[6]/a[2]");
	     By NameSignup1=By.xpath("//*[@id=\"mat-dialog-19\"]/tentgram-signup/div/div[2]/div[1]/input");
	     By EmailSignup=By.xpath("//*[@id=\"mat-dialog-8\"]/tentgram-signup/div/div[2]/div[2]/input");
	     By phSignup=By.xpath("");
	     By pswdSignup=By.xpath("//*[@id=\"mat-dialog-11\"]/tentgram-signup/div/div[2]/div[3]/input");
	     By checkbox=By.xpath("//*[@id=\"mat-dialog-17\"]/tentgram-signup/div/div[2]/div[5]/div/label");
	     By ClickSign=By.xpath("//*[@id=\"mat-dialog-17\"]/tentgram-signup/div/div[2]/div[6]/button");
	     
//RESERVE
	     By reservehomepage=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[7]/a");
	     By FujRadio=By.xpath("//*[@id=\"mat-radio-2\"]/label/div[1]/div[1]");
	     By ReserveArrow=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/div[1]/form/div[1]/div[1]/div/button[2]/img");
	     By WaynRadio=By.xpath("//*[@id=\"mat-radio-3\"]/label/div[2]/div/p[2]");
	     By DteArro=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/div[1]/form/div[3]/div/div[1]/button/span/angular-date-range-picker/div/div/div/div[2]/div/div/div[2]/div[1]/button[2]/svg");
	     By date=By.xpath("//*[@id=\"startDate\"]");
	     By room=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/div[1]/form/div[3]/div/div[2]/div/button");
	     By waroom=By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/div[2]/div/div[3]/button[2]/span");
	     By addroom=By.xpath("//*[@id=\"cdk-overlay-24\"]/div/div/div/div/div[3]/button[2]/span");
	     By kid=By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/div[2]/div[2]/div[1]/select");
	     By Adult=By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/div[2]/div[2]/div[2]/select");
	     By noadule=By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/div[2]/div[2]/div[2]/select");
	     //By rsrv=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/div[2]/button/span");
	     By reserve=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/div[2]/button/span");
	     By recrs=By.xpath("/html/body/app-root/tentgram-header/section/tentgram-booking/section/button/img");
//reserve mesg
	     By rename=By.xpath("//*[@id=\"mat-dialog-22\"]/reserve-dialog/div/form/div/div[1]/input");
	     By reph=By.xpath("//*[@id=\"mat-dialog-23\"]/reserve-dialog/div/form/div/div[3]/input");
	     By City=By.xpath("//*[@id=\"mat-dialog-23\"]/reserve-dialog/div/form/div/div[4]/input");
	     By submit=By.xpath("//*[@id=\"mat-dialog-24\"]/reserve-dialog/div/form/button");
	     
//middle balli     
	     By BaliArw=By.xpath("/html/body/app-root/tentgram-home/div/div/section[2]/feature-list/div/button[2]/img");
//gallery click
	     By Garw=By.xpath("//*[@id=\"tentgram-experience\"]/tentgram-experience-list/div[1]/div[2]/button[2]/img");
	     By vClick=By.xpath("//*[@id=\"tentgram-trips\"]/trips-location-list/div/div[1]/button/span");
	     
//megalaya
	     By magalaya=By.xpath("//*[@id=\"tentgram-trips\"]/trips-location-list/div/div[2]/div[2]/div[2]/ul/li[2]");
//tent event
	     By teventarw=By.xpath("//*[@id=\"tentgram-events\"]/tentgram-event-list/div[1]/div[2]/button[2]/img");
	     By teventzm=By.xpath("//*[@id=\"tentgram-events\"]/tentgram-event-list/div[2]/swiper/div/div[1]/div[4]/div[1]");
	     By evegarw=By.xpath("/html/body/app-root/tentgram-event/div/div/section[3]/ngx-gallery/div/ngx-gallery-thumbnails/ngx-gallery-arrows/div[2]/div/i");
	     By learnmore=By.xpath("/html/body/app-root/tentgram-home/div/div/section[6]/info-banner/div/div/div/div/div/button/span");
//contact footer section
	     By contactf=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[1]/a[3]");
	     By aboutus=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[1]/a[2]");
	     By Guestpolicy=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[1]/a[2]");
	     By terms =By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[2]/a[1]");
	     By policy=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[2]/a[2]");
	     By faq=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[2]/div/div[2]/a[3]");
	//social media 
	     By fbclickfooter=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[3]/div[1]/div/a[1]/img");
	     By insta=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[3]/div[1]/div/a[2]/img");
	     By utube=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[3]/div[1]/div/a[3]/img");
	     By emailfooter=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[3]/div[3]/div/input");
	     By subscribe=By.xpath("/html/body/app-root/tentgram-footer/footer/div[1]/div[3]/div[3]/div/button");
	     
	 
	    
	    
	    
	    
	    
	     public Page_Tnt(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	
	public void logo()
	{
		boolean log = driver.findElement(expectedTitle).isDisplayed();
		if (log) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	}
	  public void testHomePagescrolling() throws InterruptedException 
	  
	  {
		  
	  	JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,200)");
	      
	         Thread.sleep(3000);
	      
	      JavascriptExecutor jt = (JavascriptExecutor) driver;
	      jt.executeScript("window.scrollBy(0, 3000);");
	         Thread.sleep(3000);
	      JavascriptExecutor ju = (JavascriptExecutor) driver;
		  ju.executeScript("window.scrollBy(0, -3500);");
		     Thread.sleep(3000);
		  JavascriptExecutor jw = (JavascriptExecutor) driver;
		  jw.executeScript("window.scrollBy(0, 500);");
		        Thread.sleep(3000);
	  }
	 
	public void clicklocations() throws InterruptedException 
	  {
	  	driver.findElement(locationclick).click();
	  	  Thread.sleep(4000);
//1PACKAGE	  
	  	driver.findElement(FujairahPackage).click();
		  Thread.sleep(3000);
		driver.findElement(FujairapackimgClick) .click();
		  Thread.sleep(4000);
	    driver.findElement(Reservenow).click();
			Thread.sleep(4000);
		driver.navigate().back();
			Thread.sleep(3000);
//2 EXPERIENCE
		driver.findElement(FujairahExperience).click(); 
			Thread.sleep(4000);
//image click and open new page
		driver.findElement(FujExpImageClick).click();
			Thread.sleep(3000);
		JavascriptExecutor jw = (JavascriptExecutor) driver;
		jw.executeScript("window.scrollBy(0, 500);");
			 Thread.sleep(3000);
		driver.findElement(FujExpWhatsApp).click();
			 Thread.sleep(5000);
		driver.findElement(FbShareClick).click();
			 Thread.sleep(3000);
		String currenthandlel=driver.getWindowHandle();
		driver.switchTo().window(currenthandlel);
		JavascriptExecutor jl = (JavascriptExecutor) driver;
		jl.executeScript("window.scrollBy(0, 500);");
			  Thread.sleep(3000);
		driver.findElement(GalleryRightArrow).click();
		    Thread.sleep(3000);
		driver.findElement(GalleryLeftArrow).click();
		   Thread.sleep(3000);
		driver.findElement(GalleryPhotos).click();
		   Thread.sleep(3000);
	    driver.findElement(GallaryZoomRC).click();
	      Thread.sleep(3000);
	    driver.findElement(GalleryPhotostwo).click(); 
	       Thread.sleep(3000);
	    driver.findElement(GalleryBack).click();
	       Thread.sleep(3000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 3000);");
	        Thread.sleep(3000); 
	    JavascriptExecutor jk = (JavascriptExecutor) driver;
	    jk.executeScript("window.scrollBy(0, -5000);");
	        Thread.sleep(3000); 
	    driver.findElement(FujExpBooking).click();
			 Thread.sleep(3000);
		driver.findElement(FuJBookBack).click();
	    driver.navigate().back();
	    Thread.sleep(3000);
	    
	    
//3.Events
	    
	    
	    driver.findElement(Event).click();
	          Thread.sleep(3000);
	    JavascriptExecutor jQ = (JavascriptExecutor) driver;
	    jQ.executeScript("window.scrollBy(0, 2200);");
		      Thread.sleep(3000);
		      
		JavascriptExecutor jA = (JavascriptExecutor) driver;
		jA.executeScript("window.scrollBy(0,-3000);");
		        //Thread.sleep(3000);
 //FUJ Home Page EXP Image Click Zoom ArrowClick
		driver.findElement(PicA).click();
				 Thread.sleep(3000);
		driver.findElement(Picone).click();
				 Thread.sleep(3000);
	    JavascriptExecutor jJ = (JavascriptExecutor) driver;
		jJ.executeScript("window.scrollBy(0,5000)");
				 Thread.sleep(4000); 
		driver.findElement(HomePage).click();
		         Thread.sleep(4000);
		
	  }
	  
//Middle ADVertisement	  
	public void middle() throws InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0, 4000);");
		 		  Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -2000);");
		 		  Thread.sleep(3000);
		JavascriptExecutor jB = (JavascriptExecutor) driver;
		jB.executeScript("window.scrollBy(0, -700);");
		 		  Thread.sleep(3000);
		 		  driver.findElement(BaliArw).click();
		 		  Thread.sleep(3000);
		 		  driver.findElement(BaliArw).click();
		 		  Thread.sleep(3000);
		 		  driver.findElement(BaliArw).click();
		 		  Thread.sleep(3000);
	   JavascriptExecutor jm = (JavascriptExecutor) driver;
	   jm.executeScript("window.scrollBy(0, 500);");
		 		 Thread.sleep(3000);
		 		 driver.findElement(Garw).click();
	             Thread.sleep(3000);
	             driver.findElement(Garw).click();
	             Thread.sleep(3000); 
	             
	   JavascriptExecutor jo = (JavascriptExecutor) driver;
	   jo.executeScript("window.scrollBy(0, 500);");
	             Thread.sleep(3000);
	             driver.findElement(vClick).click();
	             Thread.sleep(3000);
	    //String currenthandlel2=driver.getWindowHandle();
	   // driver.switchTo().window(currenthandlel2);         
	            //  Thread.sleep(3000);
	             
	       JavascriptExecutor jp = (JavascriptExecutor) driver;
	       jp.executeScript("window.scrollBy(0, 500);");    
	       
	       driver.findElement(HomePage).click();
	      
	       JavascriptExecutor ja = (JavascriptExecutor) driver;
	       ja.executeScript("window.scrollBy(0, 2000);");  
	       Thread.sleep(3000);
	//megalaya
	       driver.findElement(magalaya).click();
	       Thread.sleep(3000);
	       
	       JavascriptExecutor jl = (JavascriptExecutor) driver;
	       jl.executeScript("window.scrollBy(0, 500);");    
	       driver.findElement(HomePage).click();
	       JavascriptExecutor jj = (JavascriptExecutor) driver;
	       jj.executeScript("window.scrollBy(0, 2000);");  
	       Thread.sleep(3000);
	       JavascriptExecutor jw = (JavascriptExecutor) driver;
	       jw.executeScript("window.scrollBy(0, 500);");    
	       Thread.sleep(3000);
	 //tentgram event
	       driver.findElement(teventarw).click();
	       Thread.sleep(3000);
	       driver.findElement(teventzm).click();
	       Thread.sleep(3000);
	       JavascriptExecutor jr = (JavascriptExecutor) driver;
	       jr.executeScript("window.scrollBy(0, 500);");    
	       Thread.sleep(3000);
	       JavascriptExecutor jx = (JavascriptExecutor) driver;
	       jx.executeScript("window.scrollBy(0, 700);");    
	       Thread.sleep(3000);
	       driver.findElement(evegarw).click();
	       Thread.sleep(3000);
	       JavascriptExecutor jf = (JavascriptExecutor) driver;
	       jf.executeScript("window.scrollBy(0, 500);");    
	       Thread.sleep(3000);
	       driver.findElement(HomePage).click();
	       JavascriptExecutor jz = (JavascriptExecutor) driver;
	       jz.executeScript("window.scrollBy(0, 2000);");  
	       Thread.sleep(3000);
	       
	       
	}
	
	  public void learnmore() throws InterruptedException 
	  {
		  driver.findElement(learnmore).click();
		  Thread.sleep(3000);
		  JavascriptExecutor jz = (JavascriptExecutor) driver;
	      jz.executeScript("window.scrollBy(0, 2000);");  
	      Thread.sleep(3000);
	            driver.findElement(HomePage).click();
	            JavascriptExecutor jj = (JavascriptExecutor) driver;
	            jj.executeScript("window.scrollBy(0, 2000)");  
	            JavascriptExecutor jm = (JavascriptExecutor) driver;
	            jm.executeScript("window.scrollBy(0, 2000)"); 
	            Thread.sleep(3000);
	           
	  }
	  public void socialmedia(String Cuname,String Cuemail,String cusubject,String Cumessage) throws InterruptedException
	  {
		  driver.findElement(aboutus).click();
		  Thread.sleep(3000);
		  JavascriptExecutor jj = (JavascriptExecutor) driver;
          jj.executeScript("window.scrollBy(0, 2000)");  
          Thread.sleep(3000);
		         driver.findElement(contactus).click();
		         Thread.sleep(3000);
		         driver.findElement(ctcName).sendKeys(Cuname);
			     driver.findElement(ctcEmail).sendKeys(Cuemail);
			     driver.findElement(ctcSubject).sendKeys(cusubject);
			     driver.findElement(ctcMessage).sendKeys(Cumessage);
			     Thread.sleep(3000);
			     driver.findElement(sendmessage).click();
			     Thread.sleep(3000);
	       
			driver.findElement(Guestpolicy).click();
			Thread.sleep(3000);
			JavascriptExecutor jm = (JavascriptExecutor) driver;
            jm.executeScript("window.scrollBy(0, 2000)"); 
            Thread.sleep(3000);
                     
                    
                     driver.findElement(terms).click();
                     Thread.sleep(3000);
                     JavascriptExecutor jp = (JavascriptExecutor) driver;
                     jp.executeScript("window.scrollBy(0, 4000)"); 
                     Thread.sleep(3000);
                     
                     driver.findElement(faq).click();
                     Thread.sleep(3000);
                     JavascriptExecutor jn = (JavascriptExecutor) driver;
                     jn.executeScript("window.scrollBy(0, 4000)"); 
                     Thread.sleep(3000);
                     
               }
	
	       public void sicialmedia(String email2) throws InterruptedException 
	       {
	    //fb
	    	  driver.findElement(fbclickfooter).click();
	    	  Thread.sleep(5000);
	    	  String currenthandlel=driver.getWindowHandle();
	   	      driver.switchTo().window(currenthandlel);         
	   	      Thread.sleep(3000);
	   	 
	   	 //insta
	    	  driver.findElement(insta).click();
	    	  Thread.sleep(5000);
	    	  String currenthandlele=driver.getWindowHandle();
	   	      driver.switchTo().window(currenthandlele);         
	   	      Thread.sleep(3000);
	   	      
	    //utube
	   	      driver.findElement(utube).click();
	   	      Thread.sleep(5000);
	    	  String currenthandlels=driver.getWindowHandle();
	   	      driver.switchTo().window(currenthandlels);         
	   	      Thread.sleep(3000);
	   	      
	   	 //footer email
	    	  driver.findElement(emailfooter).sendKeys(email2);;
	    	  Thread.sleep(5000);
	    	  driver.findElement(subscribe).click();
	    	  Thread.sleep(5000);
	    	  driver.findElement(HomePage).click();
	    	  
	    	  driver.close();
	       }
	
	 
	
		
		
//first part	
//check home page header sections
//TRIPSE
	public void TripseClick() 
	{
		driver.findElement(TripseClick).click();
	}
	public void TDubai() 
	{
		driver.findElement(TDubai).click();
	}
	
	public void Tripse() throws InterruptedException 
	{
		driver.findElement(Tkerala).click();
		driver.findElement(TMegalaya).click();
		Thread.sleep(3000);
		driver.findElement(TBali).click();
		Thread.sleep(3000);
		driver.findElement(TKashmir).click();
		Thread.sleep(3000);
		driver.findElement(TKashmir).click();
		Thread.sleep(3000);
		driver.findElement(TLadakh).click();
		Thread.sleep(3000);
		driver.findElement(TSriLanka).click();
		Thread.sleep(3000);
	}
	public void Dubai() throws InterruptedException
	{
		driver.findElement(TDubai).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(4000); 
		driver.findElement(clickandmore).click();
		JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(4000); 
		driver.navigate().back();
	}
	
	
	

	public void viewClick( ) throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);
		JavascriptExecutor ju = (JavascriptExecutor) driver;
	    ju.executeScript("window.scrollBy(0,-1000)");
		driver.findElement(view).click();
		Thread.sleep(3000);
		
	}
	public void Himachal(String Name,String email,String Number) throws InterruptedException 
	{
		driver.findElement(THimachal).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(3000);
	    
	    JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,-500)");
	    Thread.sleep(3000);
	    //view
	    driver.findElement(viewH).click();
	    Thread.sleep(4000);
	    driver.findElement(Names).sendKeys(Name);
	    driver.findElement(Email).sendKeys(email);
	    driver.findElement(Numbers).sendKeys(Number);
	    Thread.sleep(3000);
	   // driver.findElement(SendEnq).click();
	   // Thread.sleep(3000);
	    
	    JavascriptExecutor ju = (JavascriptExecutor) driver;
	    ju.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(3000);
	    
	    JavascriptExecutor jv = (JavascriptExecutor) driver;
	    jv.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(3000);
	    driver.findElement(gotobacks).click();
	    Thread.sleep(3000);
	    driver.findElement(WhatsApp).click();
	    Thread.sleep(3000);
	    String currenthandlel=driver.getWindowHandle();
		driver.switchTo().window(currenthandlel);
		Thread.sleep(3000);
		//driver.findElement(callus).click();
		//Thread.sleep(3000);
		String currenthandlel2=driver.getWindowHandle();
		driver.switchTo().window(currenthandlel2);
	    
	    driver.findElement(TripseClick).click();
	}
	
		  
		
	
	public void Ladakh(String Name,String email,String Number) throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(TLadakh).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000); 
		JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,-500)");
	    Thread.sleep(3000);
	    //view
	    driver.findElement(ViewL).click();
	    Thread.sleep(4000);
	    driver.findElement(Names).sendKeys(Name);
	    driver.findElement(Email).sendKeys(email);
	    driver.findElement(Numbers).sendKeys(Number);
	    Thread.sleep(3000);
	    driver.findElement(SendEnq).click();
	    Thread.sleep(3000);
	    
	    JavascriptExecutor ju = (JavascriptExecutor) driver;
	    ju.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(3000);
	    //String currenthandlel2=driver.getWindowHandle();
		//driver.switchTo().window(currenthandlel2);
	    
	    driver.findElement(TripseClick).click();
		
	}
	public void Kerala() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(Tkerala).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(4000); 
		JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,-1500)");
	    Thread.sleep(3000);
	    driver.findElement(TripseClick).click();
	    Thread.sleep(3000);
	}
	public void Membership() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(Membership).click();
		Thread.sleep(3000);
		
		driver.findElement(ViewCardm).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(4000);
		driver.findElement(readmore).click();
		JavascriptExecutor jt = (JavascriptExecutor) driver;
	    jt.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(4000);
		JavascriptExecutor ju = (JavascriptExecutor) driver;
	    ju.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(4000);
		driver.findElement(Home).click();
	}
//piggybankClick
	  public void piggybank () throws InterruptedException
	 {
	           driver.findElement(piggybankClick).click();
	           Thread.sleep(2000);
	           JavascriptExecutor ju = (JavascriptExecutor) driver;
               ju.executeScript("window.scrollBy(0,2500)");
	           Thread.sleep(4000);
	           JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("window.scrollBy(0,-500)");
	           Thread.sleep(4000);
	           
	           driver.findElement(naught).click();
	           Thread.sleep(3000);
	           driver.navigate().back();
	           
	           driver.findElement(piggybankClick).click();
	           
	           JavascriptExecutor jv = (JavascriptExecutor) driver;
               jv.executeScript("window.scrollBy(0,500)");
               Thread.sleep(2000);
               
	           driver.findElement(prime).click();
	           
	           Thread.sleep(3000);
	           driver.navigate().back();
	           
	           JavascriptExecutor jw = (JavascriptExecutor) driver;
               jw.executeScript("window.scrollBy(0,2500)");
               driver.findElement(Home).click();
               Thread.sleep(3000);
        }
//Contact Us
	  public void contactus(String Cname,String Cemail,String csubject,String Cmessage) throws InterruptedException 
	  {
		driver.findElement(contactus).click();
		driver.findElement(ctcName).sendKeys(Cname);
		driver.findElement(ctcEmail).sendKeys(Cemail);
		driver.findElement(ctcSubject).sendKeys(csubject);
		driver.findElement(ctcMessage).sendKeys(Cmessage);
		Thread.sleep(3000);
		//driver.findElement(sendmessage).click();
		//Thread.sleep(3000);
		 driver.findElement(Home).click();
	  }
//BLOG
	  public void blogg(String cmd,String nameB,String emailB) throws InterruptedException
	  {
		  driver.findElement(BlogClick).click();
		  JavascriptExecutor jw = (JavascriptExecutor) driver;
          jw.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
          driver.findElement(readBlog).click();
          Thread.sleep(3000);
          JavascriptExecutor ju = (JavascriptExecutor) driver;
          ju.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
          JavascriptExecutor jm = (JavascriptExecutor) driver;
          jm.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
          JavascriptExecutor jo = (JavascriptExecutor) driver;
          jo.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
          JavascriptExecutor jk = (JavascriptExecutor) driver;
          jk.executeScript("window.scrollBy(0,1500)");
          Thread.sleep(3000);
          JavascriptExecutor jy = (JavascriptExecutor) driver;
          jy.executeScript("window.scrollBy(0,500)");
          Thread.sleep(3000);
               
                  driver.findElement(comment).sendKeys(cmd);
                  driver.findElement(name2).sendKeys(nameB);
                  driver.findElement(email2).sendKeys(emailB);
                  Thread.sleep(3000);
                 // driver.findElement(post).click();
                  Thread.sleep(3000);
                  JavascriptExecutor je = (JavascriptExecutor) driver;
                  je.executeScript("window.scrollBy(0,500)");
                  Thread.sleep(3000);
                  JavascriptExecutor jd = (JavascriptExecutor) driver;
                  jd.executeScript("window.scrollBy(0,-3500)");
                  Thread.sleep(3000);
                  JavascriptExecutor ja = (JavascriptExecutor) driver;
                  ja.executeScript("window.scrollBy(0,-1500)");
                  Thread.sleep(3000);
                  driver.findElement(homeBlogg).click();
                  Thread.sleep(3000);
	  }
	  public void Signup(String NameS ,String email, String ph,String psw) throws InterruptedException 
	  {
		  
	     driver.findElement(Signup).click();
		 Thread.sleep(3000);
		 driver.findElement(ClickSign).click();
		 String currenthandlel=driver.getWindowHandle();
		 driver.switchTo().window(currenthandlel);
		 //driver.findElement(NameSignup1).sendKeys(NameS);
		 //driver.findElement(EmailSignup).sendKeys(email);
		// driver.findElement(phSignup).sendKeys(ph);
		 //driver.findElement(pswdSignup).sendKeys(psw);
		 //driver.findElement(ClickSign).click();
		 //LOGIN
	                     //driver.findElement(loginclick).click();
	                     //driver.findElement(lgemail).sendKeys(email);
	                     //driver.findElement(passwd).sendKeys(psw);
	                     //driver.findElement(login).click();
		 //ADD BACK TO HOMEPAGE OR CLICK RESERVE
	                     driver.findElement(Home).click();
	  }
	  public void reserve() throws InterruptedException 
	  {
		driver.findElement(reservehomepage).click();
        Thread.sleep(3000);
		driver.findElement(ReserveArrow).click();
		Thread.sleep(3000);
		driver.findElement(WaynRadio).click();
		Thread.sleep(3000);
		driver.findElement(date).click();
		Thread.sleep(3000);
		//driver.findElement(DteArro).click();
		driver.findElement(room).click();
		Thread.sleep(3000);
		driver.findElement(waroom).click();
		//driver.findElement(addroom).click();
		Thread.sleep(3000);
		driver.findElement(Adult).click();
		Thread.sleep(3000);
		driver.findElement(kid).click();
		Thread.sleep(3000);
		//driver.findElement(noadule).click();
		//Thread.sleep(3000);
		//String currenthandlel2=driver.getWindowHandle();
		//driver.switchTo().window(currenthandlel2);
		//driver.findElement(TripseClick).click();
		//driver.findElement(recrs).click();
		//driver.findElement(reserve).click();
		
		
	  }
	  

	
	
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	 
		  	


