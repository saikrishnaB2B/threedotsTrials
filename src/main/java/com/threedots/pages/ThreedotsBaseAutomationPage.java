package com.threedots.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ThreedotsBaseAutomationPage {

	protected AppiumDriver<WebElement> driver = null;
	protected VisualComparisionPage visualComparisionPage = null;
	protected TouchAction  touchAction = null;

	private static final Logger logger = Logger.getLogger(ThreedotsBaseAutomationPage.class.getName());

	public ThreedotsBaseAutomationPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		visualComparisionPage = new VisualComparisionPage(driver);
		//touchAction = new TouchAction<>(driver);
		touchAction = new TouchAction((PerformsTouchActions) driver);
	}

	public void elementToBeClickable(String xpath) {
		logger.info("Starting of elementToBeClickable Method");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (StaleElementReferenceException se) {
			// alternate solution
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}
		logger.info("Ending of elementToBeClickable Method");

	}

	public void implicitWait() {
		logger.info("Starting of implicitWait Method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.info("Ending of implicitWait Method");
	}

	public LocalDate getFutureDate() {
		logger.info("Starting of getFutureDate method");

		LocalDate futureDate = LocalDate.now().plusMonths(1);

		logger.info("Ending of getFutureDate method");
		return futureDate;
	}

	public String getCurrentDate() {
		logger.info("Starting of getCurrentDate method");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String dateValue = formatter.format(date);
		logger.info("Ending of getCurrentDate method");
		return dateValue;
	}

	public String nextDate() {
		logger.info("Starting of nextDate method");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date futureDateTime = calendar.getTime();
		String formattedFutureDate = sdf.format(futureDateTime);
		System.out.println(formattedFutureDate);

		logger.info("Ending of nextDate method");
		return formattedFutureDate;
	}

	public void verticalScroll() {
		logger.info("Starting of verticalScroll Method");

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;
		int endX = startX;
		int startY = (int) (size.height * 0.7);
		int endY = (int) (size.height * 0.2);

		touchAction.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endX, endY))
				.release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void verticalScrollUp() {
		logger.info("Starting of verticalScrollUp Method");

		Dimension dimension = driver.manage().window().getSize();

		int start_X = (int) (dimension.width * 0.5);
		int start_Y = (int) (dimension.height * 0.2);

		int end_X = (int) (dimension.width * 0.2);
		int end_Y = (int) (dimension.height * 0.8);

		touchAction.press(PointOption.point(start_X, start_Y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(end_X, end_Y))
				.release().perform();

		logger.info("Starting of verticalScrollUp Method");
	}

	public void sleep(int sec) {
		logger.info("Starting of sleep Method");

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			logger.error("Error occurred while testing the Sleep Method", e);
		}

		logger.info("Ending of sleep Method");
	}

	public void clickAndHold(WebElement webElement1, WebElement webElement2) {
		logger.info("Starting of clickAndHold Method");

		touchAction.press(ElementOption.element(webElement1))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(ElementOption.element(webElement2))
				.release().perform();

		logger.info("Ending of clickAndHold Method");
	}

	public void back() {
		logger.info("Starting of back Method");

		driver.navigate().back();

		logger.info("Ending of back Method");
	}

	public void rightHorizontalScroll(int startIndex, int endIndex) {

		logger.info("Starting of rightHorizontalScroll Method");

		List<WebElement> e = driver.findElements(
				MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.threedots.production:id/tvProductName\")"));

		WebElement intialElement = e.get(startIndex);// 0
		WebElement finalElement = e.get(endIndex);// 2

		int midOfCoordinate = intialElement.getLocation().y + (intialElement.getSize().height / 5);

		int intialElementXCoordinate = intialElement.getLocation().x;
		int finalElementXCoordinate = finalElement.getLocation().x;

		touchAction.press(PointOption.point(finalElementXCoordinate, midOfCoordinate))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(intialElementXCoordinate, midOfCoordinate)).release().perform();

		logger.info("Ending of rightHorizontalScroll Method");
	}

	public void explicitWait(WebElement webElement) {
		logger.info("Starting of explicitWait method");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webElement));

		logger.info("Ending of explicitWait method");
	}
	public enum MOBILE_ACTIONS {
		CLICK, VISIBILE
	}

	protected WebElement findElement(WebElement webelement, MOBILE_ACTIONS mobileActions) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		switch (mobileActions) {
		case CLICK:
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			break;
		case VISIBILE:
			wait.until(ExpectedConditions.visibilityOf(webelement));
			break;
		default:
			wait.until(ExpectedConditions.visibilityOf(webelement));
		}
		return webelement;
	}

	protected void clickOnElement(WebElement webelement) {
		findElement(webelement, MOBILE_ACTIONS.CLICK).click();
	}

	protected String getText(WebElement webelement) {
		return findElement(webelement, MOBILE_ACTIONS.VISIBILE).getText();
	}

	protected void sendKeys(WebElement webelement, String keys) {
		findElement(webelement, MOBILE_ACTIONS.VISIBILE).sendKeys(keys);
	}

	protected void clear(WebElement webelement) {
		findElement(webelement, MOBILE_ACTIONS.VISIBILE).clear();
	}

	protected boolean isDisplayed(WebElement webelement) {
		return findElement(webelement, MOBILE_ACTIONS.VISIBILE).isDisplayed();
	}

	protected void waitForElementToBeVisible(WebElement webelement) {
		findElement(webelement, MOBILE_ACTIONS.VISIBILE);
	}
	
	public void threadSleep(int threadWait) {
		logger.info("Starting of threadSleep method");
		
		try {
			Thread.sleep(threadWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Ending of threadSleep method");
	}
	

public void verticalScrollDown() throws InterruptedException {
		logger.info("Starting of verticalScrollDown Method");
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int endX = startX;
		int startY = (int) (size.height * 0.4);
		int endY = (int) (size.height * 0.6);
		TouchAction t = new TouchAction((PerformsTouchActions) driver);
		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, -endY)).release().perform();

		logger.info("Ending of verticalScrollDown Method");
	}
}

