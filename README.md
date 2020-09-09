# FlutterApp
FlutterAppE2E

FlutterApp project prerequisites:

1. Install Java SDK, Andriod Studio setup environment variables path, https://www.techotopia.com/index.php/Setting_up_an_Android_Studio_Development_Environment_-_Android_6 
2. Install Appium desktop app, https://www.toolsqa.com/mobile-automation/appium/download-and-install-appium-desktop-client/
Or: for Node.JS use: https://www.seleniumeasy.com/appium-tutorials/install-appium-on-windows-step-by-step
3. Install Eclipse, https://www.toolsqa.com/selenium-webdriver/download-and-start-eclipse/
4. Install TestNG for Eclipse, https://www.guru99.com/install-testng-in-eclipse.html
5. Setup Andriod Emulator(Only API 30 i tested, it didnt work for API lower like API 27) using -https://developer.android.com/studio/run/emulator/?


Steps to run the Automation Scripts:

1. Open Eclipse, Download the FlutterApp project from GITHUB using link: 
2. Open the Project files from the folder where files are downloaded from step 1 above, -https://www.microfocus.com/documentation/enterprise-developer/ed232/Eclipse/GUID-773A19C7-98B2-442D-9D36-240E20E3F2CE.html
3. Open andriod Studio, launch Emulator, -https://developer.android.com/studio/run/emulator
4. Open Appium Desktop, launch Appium server, -https://github.com/appium/appium-desktop
5. Open File in src/test/java. File name: E2ETest.java. 
6. Right Click on the class and Run as TestNG. 
7. Check if Flutter app is launched in Emulator. 


Tools used:
1. Java SDK 8. 
2. Eclipse with TestNG.
3. Appium Desktop.
4. Andriod Studio with API 30 level Emulator, i have used Pixel XL API 30. 

Libraries in POM.xml:
1. org.seleniumhq.selenium --> 3.141.59
2. com.relevantcodes --> 2.41.2
3. io.appium --> 7.3.0
4. org.seleniumhq.selenium --> 3.141.59
5. org.testng --> 7.1.0

Framework details:
1. This framwork is built using PageObject Model
2. Locators and methods/operations for elements are kept seperately in 'src/main/java/Pages'. 
3. In 'src/main/java/Base' has TestBase.java file for AndriodDriver initialization, setting up DesiredCapatiblities for our App. 
4. In 'src/main/java/Resources' we have config.properties file which is having all DesiredCapability and AppURL location which is used in TestBase class. 
5. I have kept all reusable methods in 'src/main/java/Utility/Utility.java' file. Used them throughout testing. 
6. Test Classes are kept in 'src/test/java/TestClasses/E2ETest.java'. 
7. Used UIAutomator for identifying the locators for Flutter app. For the page where we can select the products we dont have any way of identifying the locators hence used
coordinates after swiping the screens and selected the Walter Tshirt and Shurg Bag. 
8. Used Extent Report for producing the reports for Testing completion. 
9. Assertions are used throughout the test to make sure the Test is passed or failed. 

Challenges:
1. Finding locators is quite difficult for flutter app, i have used UIselector for finding the working technique of finding locators. 
2. Apk file App is heavy i.e. 96 MB, we need to use Git LFS to upload the project folder in GitHub. 
3. App takes time to install and load on Emulator, i didnt have actual android device hence used Emulator. 

Test Cases --> Status: 
1. Open App --> Passed. 
2. Click on shrineIcon --> Passed. 
3. Login --> Passed. 
4. Select clothing filter --> Passed. 
5. Select Walter Henley (White) tshirt --> Passed. 
6. Change filter to Accessory --> Passed. 
7. Select ShrugBag --> Passed. 
8. Click Cart with 2 Elements --> Passed. 
9. Validate Amount on Cart Summary --> Passed. 
10. Click Clear Cart --> Passed. 
