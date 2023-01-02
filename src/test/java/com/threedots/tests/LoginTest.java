package com.threedots.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.threedots.pages.ThreedotsLoginPage;
import com.threedots.pages.VisualComparisionPage;
import com.threedots.vo.MobileConfigurationVO;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Threedots App")
@Feature("Login")

public class LoginTest extends ThreedotsBaseAutomationTest {
	private ThreedotsLoginPage loginPage = null;

	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

	@BeforeClass
	@Parameters({ "deviceName", "udid", "platformName", "platformVersion" })
	public void initClass(String deviceName, String udid, String platformName, String platformVersion)
			throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(deviceName, udid, platformName,
				platformVersion);
		this.initMobileDriver(mobileConfigurationVO);
		this.loginPage = new ThreedotsLoginPage(this.getMobileDriver(udid));
		this.visualComparision = new VisualComparisionPage(driver);

		logger.info("Ending of initClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify the results on click of Continue with Google Button")
	@Description("Test Case #1, Verify the results on click of Continue with Google Button")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, Continue with Google ")
	public void verifyContinueWithGoogleFunctionality() {
		logger.info("Starting of verifyContinueWithGoogleFunctionality method");

		loginPage.sleep(4000);

		String chooseAnAccountTitle = this.loginPage.getChooseAnAccountTitle();
		Assert.assertEquals(chooseAnAccountTitle, expectedAssertionsProp.getProperty("choose.an.account.title"));

		loginPage.sleep(3000);
		loginPage.clickOnEmailIdLink();

		loginPage.sleep(6000);

		assertTrue(this.loginPage.isThreedotsHomePageContains());

		logger.info("Ending of verifyContinueWithGoogleFunctionality method");
	}

	@Test(priority = 2, description = "Verify the results on click of Dotcoins Button")
	@Description("Test Case #2, Verify the results on click of Dotcoins Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #2, Verify Dotcoins")
	public void verifyDotcoinsFunctionality() {
		logger.info("Starting of verifyDotcoinsFunctionality method");

		loginPage.sleep(3000);

		loginPage.clickOnDotcoinButton();

		String winZoneText = this.loginPage.getWinZoneTitle();
		Assert.assertEquals(winZoneText, expectedAssertionsProp.getProperty("win.zone.text"));

		loginPage.sleep(3000);
		loginPage.clickOnBackIcon();

		logger.info("Ending of verifyDotcoinsFunctionality method");
	}

	@Test(priority = 3, description = "Verify the results on click of Add Cash Button")
	@Description("Test Case #3, Verify the results on click of Add CashButton")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #3, Verify Add Cash Functionality")
	public void verifyAddCashFunctionality() {
		logger.info("Starting of verifyAddCashFunctionality method");

		loginPage.clickOnAddCashButton();
		loginPage.sleep(3000);

		assertTrue(this.loginPage.isAddDotcoinsLabelDisplayed());

		logger.info("Ending of verifyAddCashFunctionality method");
	}

	@Test(priority = 4, description = "Verify the results on click of Games Menu")
	@Description("Test Case #4, Verify the results on click of Games Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4, Verify Games Menu")
	public void verifyGamesMenu() {
		logger.info("Starting of verifyAddCashFunctionality method");

		loginPage.clickOnGamesMenu();
		loginPage.sleep(3000);

		assertTrue(this.loginPage.isGamesMenuContains());

		logger.info("Ending of verifyAddCashFunctionality method");
	}

	@Test(priority = 5, description = "Verify the results on click of My Games Menu")
	@Description("Test Case #5, Verify the results on click of My Games Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #5, Verify My Games Menu")
	public void verifyMyGamesMenu() {
		logger.info("Starting of verifyMyGamesMenu method");

		loginPage.clickOnMyGamesMenu();
		loginPage.sleep(3000);

		String myGamesTitle = this.loginPage.getMyGamesLabelText();
		Assert.assertEquals(myGamesTitle, expectedAssertionsProp.getProperty("my.games.title"));

		logger.info("Ending of verifyMyGamesMenu method");
	}

	@Test(priority = 6, description = "Verify the results on click of Groups Menu")
	@Description("Test Case #6, Verify the results on click of Groups Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #6, Verify Groups Menu")
	public void verifyGroupsMenu() {
		logger.info("Starting of verifyGroupsMenu method");

		loginPage.clickOnGroupsMenu();
		loginPage.sleep(3000);

		assertTrue(loginPage.isGroupsMenuContains());

		logger.info("Ending of verifyGroupsMenu method");
	}

	@Test(priority = 7, description = "Verify the results on click of Hamburger Menu")
	@Description("Test Case #7, Verify the results on click of Hamburger Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify Hamburger Menu")
	public void verifyHamburgerMenuFunctionality() {
		logger.info("Starting of verifyHamburgerMenuFunctionality method");

		loginPage.clickOnGamesMenu();
		loginPage.clickOnHamburgerMenu();
		loginPage.sleep(3000);

		assertTrue(this.loginPage.isHamburgerMenuContains());

		logger.info("Ending of verifyHamburgerMenuFunctionality method");
	}

	@Test(priority = 8, description = "Verify the results on click of Edit Icon")
	@Description("Test Case #8, Verify the results on click of Edit Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #8, Verify Edit Icon Functionality")
	public void verifyEditIcon() {
		logger.info("Starting of verifyEditIcon method");

		this.loginPage.clickOnEditIcon();

		String editProfileText = this.loginPage.getEditProfileText();
		Assert.assertEquals(editProfileText, expectedAssertionsProp.getProperty("edit.profile.text"));

		assertTrue(this.loginPage.isSaveChangesButtonDisplayed());

		driver.navigate().back();

		logger.info("Ending of verifyEditIcon method");
	}

	@Test(priority = 9, description = "Verify Order History Details")
	@Description("Test Case #9, Verify Order History Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #9, Verify Order History Functionality")
	public void verifyOrderHistoryDetails() {
		logger.info("Starting of verifyOrderHistoryDetails method");

		this.loginPage.clickOnOrderButton();
		loginPage.threadSleep(2000);

		String winZoneText = this.loginPage.getWinZoneTitle();
		Assert.assertEquals(winZoneText, expectedAssertionsProp.getProperty("win.zone.text"));

		driver.navigate().back();

		logger.info("Ending of verifyOrderHistoryDetails method");
	}

	@Test(priority = 10, description = "Verify Contact Us Page")
	@Description("Test Case #10, Verify Contact Us Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #10, Verify Contact Us Functionality")
	public void verifyContactDetails() {
		logger.info("Starting of verifyhamburgerMenuList method");

		this.loginPage.clickOnContactUsButton();
		loginPage.threadSleep(2000);

		String helpDeskTitle = this.loginPage.getHelpDeskText();
		Assert.assertEquals(helpDeskTitle, expectedAssertionsProp.getProperty("help.desk.text"));

		driver.navigate().back();

		logger.info("Ending of verifyhamburgerMenuList method");
	}

	@Test(priority = 11, description = "Verify FAQ page")
	@Description("Test Case #11, Verify FAQ page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #11, Verify FAQ page")
	public void verifyFAQ() {
		logger.info("Starting of verifyFAQ method");

		this.loginPage.clickOnFAQButton();
		loginPage.threadSleep(2000);

		String quickGuideTitle = this.loginPage.getQuickGuideText();
		Assert.assertEquals(quickGuideTitle, expectedAssertionsProp.getProperty("quick.guide.text"));

		driver.navigate().back();

		logger.info("Ending of verifyFAQ method");
	}

	@Test(priority = 12, description = "Verify InviteEarn Title")
	@Description("Test Case #12, Verify InviteEarn Title")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #12, Verify InviteEarn Title")
	public void verifyInviteEarnTitle() {
		logger.info("Starting of verifyInviteEarnTitle method");


		String inviteEarnTitle = this.loginPage.getInviteEarnTitle();
		Assert.assertEquals(inviteEarnTitle, expectedAssertionsProp.getProperty("invite.earn.title"));
		this.loginPage.clickOnInviteEarn();
		assertTrue(this.loginPage.isInvitEarnTextisDisplayed());
		driver.navigate().back();

		logger.info("Ending of verifyInviteEarnTitle method");
	}

	
	@Test(priority = 13, description = "Verify Logout Functionality")
	@Description("Test Case #13, Verify Logout Functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #13, Verify Logout Functionality")
	public void verifyLogoutFunctionality() {
		logger.info("Starting of verifyLogoutFunctionality method");

		driver.navigate().back();

		this.loginPage.clickOnLogoutButton();

		logger.info("Ending of verifyLogoutFunctionality method");
	}
	
	@AfterClass
	@Parameters({ "deviceName", "udid"})
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");
		this.stopService();
		//service.stop();
		this.quitMobileDriver(udid);
		logger.info("Ending of quitDriver method");
	}

}