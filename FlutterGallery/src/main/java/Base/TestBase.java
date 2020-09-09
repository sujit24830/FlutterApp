package Base;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public static AndroidDriver<MobileElement> driver; 
	public static DesiredCapabilities cap;
	public static File fileapp;
	public static FileInputStream fis; 
	public static Properties prop; 
	public static String propfilepath="./src\\main\\java\\Resources\\config.properties";
	
	public static void setUp() throws MalformedURLException {
	try {	
		fis=new FileInputStream(propfilepath);
		prop=new Properties();
		prop.load(fis);
		System.out.println("Current user directory is: " + System.getProperty("user.dir"));
	}	catch(Exception e) {
		e.printStackTrace();
	}
	
	fileapp=new File(prop.getProperty("appurl"));
	cap=new DesiredCapabilities();
	//setting DesiredCapabilities
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("capability_DEVICE_NAME"));
	cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("capability_UDID"));
	cap.setCapability("androidInstallTimeout", prop.getProperty("capability_androidInstallTimeout"));
	cap.setCapability(MobileCapabilityType.APP, fileapp.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("capability_PLATFORM_NAME"));
	cap.setCapability(MobileCapabilityType.VERSION, prop.getProperty("capability_VERSION"));
	cap.setCapability("unicodeKeyboard", prop.getProperty("capability_unicodeKeyboard"));
	cap.setCapability("resetKeyboard", prop.getProperty("capability_resetKeyboard"));
	
	//initialising Driver
	driver = new AndroidDriver<MobileElement>(new URL(prop.getProperty("appiumurl")), cap);
	
	System.out.println("Appium Server started!");
	driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	
	}
}
