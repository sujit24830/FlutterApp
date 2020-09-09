package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.TestBase;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage extends TestBase{
	
	
	private static String shrineIcon="new UiSelector().descriptionContains(\"Shrine\")"; 
	AndroidDriver<MobileElement> driver;
	Utility utilityObj; 
	
	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		utilityObj=new Utility(driver);
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	}
	
	public String getShrineIcon() {
		return shrineIcon;
	}

	public void setShrineIcon(String shrineIcon) {
		this.shrineIcon = shrineIcon;
	}

	public void clickShrineEle() throws InterruptedException {
		MobileElement shrineEle=driver.findElementByAndroidUIAutomator(getShrineIcon()); 
		utilityObj.moveAndClickElement(shrineEle);
		Thread.sleep(4000);
		
	}

	
}
