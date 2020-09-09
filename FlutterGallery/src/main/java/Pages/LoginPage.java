package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Base.TestBase;
import Utility.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends TestBase{
	
	private static String usernameEditText="new UiSelector().text(\"Username\")"; 
	private static String passwordEditText="new UiSelector().text(\"Password\")";
	private static String nextBtn="new UiSelector().descriptionContains(\"NEXT\")";
	public static AndroidDriver<MobileElement> driver;
	Utility utilityObj;

	public LoginPage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		utilityObj=new Utility(driver);
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	}

	public static String getNextBtn() {
		return nextBtn;
	}

	public static void setNextBtn(String nextBtn) {
		LoginPage.nextBtn = nextBtn;
	}

	public static String getUsernameEditText() {
		return usernameEditText;
	}

	public static void setUsernameEditText(String usernameEditText) {
		LoginPage.usernameEditText = usernameEditText;
	}

	public static String getPasswordEditText() {
		return passwordEditText;
	}

	
	public static void setPasswordEditText(String passwordEditText) {
		LoginPage.passwordEditText = passwordEditText;
	}
	
	public MobileElement userNameEditEle() {
		MobileElement userNameEditEle=driver.findElementByAndroidUIAutomator(getUsernameEditText());
		return userNameEditEle; 
	}
	
	public MobileElement nextBtnEle() {
		MobileElement nextBtn=driver.findElementByAndroidUIAutomator(getNextBtn());
		return nextBtn; 
		
	}
	
	public MobileElement passwordEditEle() {
		MobileElement passwordEditEle=driver.findElementByAndroidUIAutomator(getPasswordEditText()); 
		return passwordEditEle; 
		
	}
	
	public void Login() {
		utilityObj.moveAndSendKeys(userNameEditEle(),"User1");
		utilityObj.moveAndSendKeys(passwordEditEle(),"password1");
		utilityObj.moveAndClickElement(nextBtnEle());		
	}

}
