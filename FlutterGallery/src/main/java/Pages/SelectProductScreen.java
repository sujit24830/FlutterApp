package Pages;

import Base.TestBase;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SelectProductScreen extends TestBase{
	
	private static String shoppingcartEmpty="new UiSelector().description(\"Shopping cart, no items\")";
	AndroidDriver<MobileElement> driver; 
	private static String shoppingcartOneItem="new UiSelector().description(\"Shopping cart, 1 item\")";
	private static String shoppingcartTwoItem="new UiSelector().description(\"Shopping cart, 2 items\")";
	Utility utilityObj; 
	
	public SelectProductScreen(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		utilityObj=new Utility(driver);
	}
	
	public static String getShoppingcartOneItem() {
		return shoppingcartOneItem;
	}

	public static void setShoppingcartOneItem(String shoppingcartOneItem) {
		SelectProductScreen.shoppingcartOneItem = shoppingcartOneItem;
	}

	public MobileElement shoppingCartOneEle() {
		MobileElement shoppingCartOneEle=driver.findElementByAndroidUIAutomator(getShoppingcartOneItem()); 
		return shoppingCartOneEle; 
	}
	
	public MobileElement shoppingCartTwoEle() {
		MobileElement shoppingCartTwoEle=driver.findElementByAndroidUIAutomator(getShoppingcartTwoItem()); 
		return shoppingCartTwoEle; 
	}
	
	public static String getShoppingcartTwoItem() {
		return shoppingcartTwoItem;
	}

	public static void setShoppingcartTwoItem(String shoppingcartTwoItem) {
		SelectProductScreen.shoppingcartTwoItem = shoppingcartTwoItem;
	}

	

	public static String getShoppingcartEmpty() {
		return shoppingcartEmpty;
	}

	public static void setShoppingcartEmpty(String shoppingcartEmpty) {
		SelectProductScreen.shoppingcartEmpty = shoppingcartEmpty;
	}
	
	public MobileElement shoppingCartEmptyEle() {
		MobileElement shoppingCartEmptyEle=driver.findElementByAndroidUIAutomator(getShoppingcartEmpty()); 
		return shoppingCartEmptyEle; 
	}

	public void swipeLeftfromRightWalterHenleyAndSelect() {
		utilityObj.swipeScreenRightToLeft(3);
		utilityObj.clickPointonScreen(35, 1570);
	}
	
	public void swipeLeftfromRightShrugBag() {
		utilityObj.swipeScreenRightToLeft(1);
		utilityObj.clickPointonScreen(1000, 1570);
	}
	
	public void clickOneItemCart() {
		utilityObj.moveAndClickElement(shoppingCartOneEle());
		
	}
	
	public void clickTwoItemCart() {
		utilityObj.moveAndClickElement(shoppingCartTwoEle());
		
	}
	
}
