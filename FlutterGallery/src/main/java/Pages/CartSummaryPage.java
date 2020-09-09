package Pages;

import org.openqa.selenium.By;

import Base.TestBase;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CartSummaryPage extends TestBase{
	
	public static AndroidDriver<MobileElement> driver;
	private static String backBtn="new UiSelector().description(\"Back to Gallery\")";
	private static String quantityWAlterHenley="//*[@class='android.view.View'][3]";
	private static String clearCartBtn="new UiSelector().description(\"CLEAR CART\")";
	private static String totalsummary="new UiSelector().descriptionContains(\"264.16\")"; 
	Utility utilityObj;
	
	public CartSummaryPage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		utilityObj=new Utility(driver);
	}
	
	public static String getClearCartBtn() {
		return clearCartBtn;
	}

	public static void setClearCartBtn(String clearCartBtn) {
		CartSummaryPage.clearCartBtn = clearCartBtn;
	}

	public static String getTotalSummary() {
		return totalsummary;
	}


	public static void setTotalSummary(String totalsummary) {
		CartSummaryPage.totalsummary = totalsummary;
	}
	
	public static String getBackBtn() {
		return backBtn;
	}

	public static void setBackBtn(String backBtn) {
		CartSummaryPage.backBtn = backBtn;
	}

	public static String getQuantityWAlterHenley() {
		return quantityWAlterHenley;
	}

	public static void setQuantityWAlterHenley(String quantityWAlterHenley) {
		CartSummaryPage.quantityWAlterHenley = quantityWAlterHenley;
	}

	public MobileElement totalSummaryele() {
		MobileElement totalSummaryele=driver.findElementByAndroidUIAutomator(getTotalSummary()); 
		return totalSummaryele; 
	}
	
	public MobileElement clearCartEle() {
		MobileElement clearCartEle=driver.findElementByAndroidUIAutomator(getClearCartBtn()); 
		return clearCartEle; 
	}
	
	public MobileElement backBtnEle() {
		MobileElement backBtnEle=driver.findElementByAndroidUIAutomator(getBackBtn()); 
		return backBtnEle; 
	}
	
	public MobileElement quantityWAlterHenleyEle() {
		MobileElement quantityWAlterHenleyEle=driver.findElementByXPath(getQuantityWAlterHenley()); 
		System.out.println(quantityWAlterHenleyEle);
		return quantityWAlterHenleyEle; 
		
	}
		
	public void clearCart() {
		utilityObj.clickElement(clearCartEle());
	}
	
	public void clickBackBtn() {
		utilityObj.clickElement(backBtnEle());
	}

	public String returnTotalSummary() {
	String totalSummary=utilityObj.getContentOfElement(totalSummaryele()); 
	String amountTotal=totalSummary.substring(6); 
	return amountTotal; 
	}

}
