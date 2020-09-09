package Utility;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utility extends TestBase{
	
	public static AndroidDriver<MobileElement> driver; 
	public static Actions a ;
	public static Dimension size;  
	public static TouchAction ts;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public Utility(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		a= new Actions(driver);
		size=driver.manage().window().getSize();
		ts = new TouchAction(driver);
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("FlutterE2EDemo");
	}
	
	public String getContentOfElement(MobileElement element) {
		String contentDesc=element.getAttribute("content-desc");
		return contentDesc; 
	}
	
	public void moveAndClickElement(MobileElement element) {
		a.moveToElement(element).click().perform();
	}

	public void moveAndSendKeys(MobileElement element, String text) {
		driver.hideKeyboard();
		element.click();
		a.sendKeys(text).build().perform();
	}
	
	public void clickElement(MobileElement element) {
		element.click();
	}
	
	public void swipeScreenRightToLeft(int numberofTimes) {
		  
	    
	        int startPoint = (int) (size.width * 0.99);
	        int endPoint = (int) (size.width * 0.15);
	        int ScreenPlace =(int) (size.height*0.40);          
	        int y=(int)size.height*20;

	       
	       for(int i=0;i<=numberofTimes;i++) {
	       ts.press(PointOption.point(startPoint,ScreenPlace ))
	      .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
	      .moveTo(PointOption.point(endPoint,ScreenPlace )).release().perform();
	       }
	       
	}
	
	public void clickPointonScreen(int xoffset, int yoffset) {
		ts.press(PointOption.point(xoffset, yoffset)).release().perform();		
		
	}


}
