package TestClasses;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Pages.BasePage;
import Pages.CartSummaryPage;
import Pages.LoginPage;
import Pages.SelectProductScreen;
import Pages.ShrinePage;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class E2ETest extends TestBase{
	
	public static ExtentTest test;
	public static ExtentReports report;
	BasePage basePageObj; 
	LoginPage loginPageObj; 
	ShrinePage shrinePageObj; 
	Utility utilityObj;
	SelectProductScreen selProdScreenObj;
	CartSummaryPage cartSumPageObj; 
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		TestBase.setUp();
		utilityObj = new Utility(driver);
		basePageObj = new BasePage(driver);
		loginPageObj = new LoginPage(driver);
		shrinePageObj= new ShrinePage(driver);
		selProdScreenObj = new SelectProductScreen(driver); 
		cartSumPageObj= new CartSummaryPage(driver);
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("FlutterE2ETesting");
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void e2ETestFlutter() throws InterruptedException, MalformedURLException{
		
		//clicking shrineIcon on basePage. 
		basePageObj.clickShrineEle();
		
		Assert.assertEquals(true, loginPageObj.userNameEditEle().isDisplayed());
		if(loginPageObj.userNameEditEle().isDisplayed()) {
			test.log(LogStatus.PASS, "LoginPage displayed successfully");
		} else {
			test.log(LogStatus.FAIL, "LoginPage Not Displayed");
		}
		
		//performing Login
		loginPageObj.Login();
		
		Assert.assertEquals(true, shrinePageObj.openMenuEle().isDisplayed());
		if(shrinePageObj.openMenuEle().isDisplayed()) {
			test.log(LogStatus.PASS, "ShrinePage displayed successfully");
		} else {
			test.log(LogStatus.FAIL, "ShrinePage Not Displayed");
		}
		
		
		//select Clothing Filter
		shrinePageObj.selectClothingFilter();
		
		Assert.assertEquals(true, selProdScreenObj.shoppingCartEmptyEle().isDisplayed());
		if(selProdScreenObj.shoppingCartEmptyEle().isDisplayed()) {
			test.log(LogStatus.PASS, "Select Product page displayed successfully");
		} else {
			test.log(LogStatus.FAIL, "Select Product page Not Displayed");
		}
		
		//swipe and select WalterHanley white T shirt. 
		selProdScreenObj.swipeLeftfromRightWalterHenleyAndSelect();
		
		Assert.assertEquals(true, selProdScreenObj.shoppingCartOneEle().isDisplayed());
		if(selProdScreenObj.shoppingCartOneEle().isDisplayed()) {
			test.log(LogStatus.PASS, "WalterHenley item added to Cart Successfully!");
		} else {
			test.log(LogStatus.FAIL, "WalterHenley item not added to Cart!");
		}
		
		//move to Accessory filer and select ShrugBag
		shrinePageObj.selectAcessoryFilter();
		selProdScreenObj.swipeLeftfromRightShrugBag();
		Assert.assertEquals(true, selProdScreenObj.shoppingCartTwoEle().isDisplayed());
		if(selProdScreenObj.shoppingCartTwoEle().isDisplayed()) {
			test.log(LogStatus.PASS, "ShrugBag also added to Cart Successfully!");
		} else {
			test.log(LogStatus.FAIL, "ShrugBag item not added to Cart!");
		}
		
		
		//click cart with 2 items added
		selProdScreenObj.clickTwoItemCart();
		Assert.assertEquals(true, cartSumPageObj.backBtnEle().isDisplayed());
		if(cartSumPageObj.backBtnEle().isDisplayed()) {
			test.log(LogStatus.PASS, "CartSummaryPage is displayed Successfully!");
		} else {
			test.log(LogStatus.FAIL, "CartSummaryPage is not displayed!");
		}
		
		//validating total summary as $264.16
		cartSumPageObj.returnTotalSummary();
		String amountTotal=cartSumPageObj.returnTotalSummary(); 
		Assert.assertEquals(amountTotal, "$264.16");
		if(amountTotal.equalsIgnoreCase("$264.16")) {
			test.log(LogStatus.PASS, "Total amount is validated successfully, its: " + amountTotal);
		} else {
			test.log(LogStatus.FAIL, "Total amount is not validated successfully!");
		}
		
		//clearing shopping cart
		cartSumPageObj.clearCart();
		Assert.assertEquals(true, shrinePageObj.openMenuEle().isDisplayed());
		if(shrinePageObj.openMenuEle().isDisplayed()) {
			test.log(LogStatus.PASS, "ShrinePage displayed successfully after clearing the CART!");
		} else {
			test.log(LogStatus.FAIL, "ShrinePage Not Displayed after clearing the CART");
		}
		
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("Executed Completed");
		driver.quit();
		report.endTest(test);
		report.flush();
	
	}

}
