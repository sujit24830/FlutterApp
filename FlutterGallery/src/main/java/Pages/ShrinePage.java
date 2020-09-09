package Pages;

import Base.TestBase;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ShrinePage extends TestBase{
	
	public static AndroidDriver<MobileElement> driver;
	Utility utilityObj;
	private static String openMenuFilter="new UiSelector().description(\"Open menu\")";
	private static String clothingFilter="new UiSelector().description(\"CLOTHING\")";
	private static String accessoryFilter="new UiSelector().description(\"ACCESSORIES\")";
	
	public ShrinePage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		utilityObj=new Utility(driver);
	}
	
	public static String getAccessoryFilter() {
		return accessoryFilter;
	}

	public static void setAccessoryFilter(String accessoryFilter) {
		ShrinePage.accessoryFilter = accessoryFilter;
	}

	public MobileElement accessoryFilterEle() {
		MobileElement accessoryFilterEle=driver.findElementByAndroidUIAutomator(getAccessoryFilter()); 
		return accessoryFilterEle;
		
	}
		
	
	public static String getOpenMenuFilter() {
		return openMenuFilter;
	}

	public static void setOpenMenuFilter(String openMenuFilter) {
		ShrinePage.openMenuFilter = openMenuFilter;
	}

	public static String getClothingFilter() {
		return clothingFilter;
	}

	public static void setClothingFilter(String clothingFilter) {
		ShrinePage.clothingFilter = clothingFilter;
	}
	
	public MobileElement openMenuEle() {
		MobileElement openMenuEle=driver.findElementByAndroidUIAutomator(getOpenMenuFilter()); 
		return openMenuEle;
	}
	
	public MobileElement clothingFilterEle() {
		MobileElement clothingFilterEle=driver.findElementByAndroidUIAutomator(getClothingFilter()); 
		return clothingFilterEle;
	}
	
	public void selectAcessoryFilter() {
		utilityObj.moveAndClickElement(openMenuEle());
		utilityObj.moveAndClickElement(accessoryFilterEle());
	}
	
	public void selectClothingFilter() {
		utilityObj.moveAndClickElement(openMenuEle());
		utilityObj.moveAndClickElement(clothingFilterEle());
	}
	
}
