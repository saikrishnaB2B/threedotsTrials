package com.threedots.tests;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.threedots.pages.ThreedotsLoginPage;
import com.threedots.pages.VisualComparisionPage;
import com.threedots.vo.MobileConfigurationVO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ThreedotsBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(ThreedotsBaseAutomationTest.class.getName());

	protected static AppiumDriver<WebElement> driver = null;

	protected ThreedotsLoginPage loginPage = null;
	
	protected MobileConfigurationVO mobileConfigurationVO = null;
	protected VisualComparisionPage visualComparision = null;

	protected static Map<String, AppiumDriver<WebElement>> driversMap = new HashMap<String, AppiumDriver<WebElement>>();

	protected static Properties testDataProp = null;
	protected static Properties expectedAssertionsProp = null;
    //protected static AppiumDriverLocalService service = null;


	public enum SCREEN_ID {

		LOGIN_SCREEN, REGISTER_SCREEN, MY_INVESTMENT_SCREEN, CONFIRM_PURCHASE_SCREEN, PAYMENT_SCREEN, MENU_BAR,
		VIEW_ORDER_SCREEN, CLIENT_ORDER_DETAILS;

	} 
	
	@BeforeSuite
	public void initTestData() {

		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;
			try {
				testDataReader = new FileReader("src/main/resources/testdata.properties");
				assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	protected synchronized void initMobileDriver(MobileConfigurationVO mobileConfigurationVO) throws MalformedURLException {

		logger.info("Starting of method initMobileDriver");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", mobileConfigurationVO.getDeviceName());

		cap.setCapability("udid", mobileConfigurationVO.getUdId());

		cap.setCapability("platformName", mobileConfigurationVO.getPlatformName());

		cap.setCapability("platformVersion", mobileConfigurationVO.getPlatformVersion());

		cap.setCapability("appPackage", "com.tresscommas.threedots");

		cap.setCapability("appActivity", "com.tresscommas.threedots.MainActivity");

		driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);		

		driversMap.put(mobileConfigurationVO.getUdId(), driver);

		logger.info("Ending of method initMobileDriver");

	}

	protected synchronized AppiumDriver<WebElement> getMobileDriver(String driverKey) throws Exception {

		logger.info("Starting of method getMobileDriver");

		driver = driversMap.get(driverKey);

		// Use existing driver
		if (driver == null) {

			logger.error("Driver not initialized, Please call initDriver Method. Before calling getDriver ");

			throw new Exception("Drivier not initialized");
			// driver = initMobileDriver();
		}

		// Otherwise create new driver
		logger.info("Ending of method getMobileDriver");

		return driver;

	}

	protected synchronized void quitMobileDriver(String driverKey) {

		logger.info("Starting of method quitDriver in BaseAutomationTest ");

		AppiumDriver<WebElement> driver = null;

		driver = driversMap.get(driverKey);

		try {

			if (driver != null) {

				driver.quit();

				driver = null;

			}

		} catch (Exception ex) {

			logger.error(ex.getMessage());

			driver = null;

		}

		logger.info("Ending of method quitDriver in BaseAutomationTest");
	}

	public void resetApp() {

		driver.resetApp();

	}

	public void appLogin(String udid) throws Exception {
		logger.info("Starting of appLogin method");
		this.loginPage = new ThreedotsLoginPage(this.getMobileDriver(udid));
		loginPage.sleep(3000);
		loginPage.clickOnEmailIdLink();
		loginPage.sleep(6000);
		//loginPage.clickOnBackButton();

		logger.info("Ending of appLogin method");

	}
	
	public  AppiumDriverLocalService startService() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}
	
	public  AppiumDriverLocalService stopService() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.stop();
		return service;
	}
}



