package com.threedots.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ThreedotsLoginPage extends ThreedotsBaseAutomationPage {
	private static final Logger logger = Logger.getLogger(ThreedotsLoginPage.class.getName());

	@FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
	private WebElement lblThreedots;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Continue with Google']")
	private WebElement btnContinueWithGoogle;

	@FindBy(id = "com.google.android.gms:id/main_title")
	private WebElement lblChooseAnAccount;

	@FindBy(xpath = "//android.widget.TextView[@text = 'b2btesters05@gmail.com']")
	private WebElement lnkEmailId;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement btnBack;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement btnAddCash;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Add Dotcoins 100 100 Current Balance\"]")
	private WebElement lblAddDotcoins;

	@FindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView")
	private WebElement btnDotcoin;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Win Zone\"]")
	private WebElement lblWinZone;

	@FindBy(xpath = "//android.view.View[1]/android.widget.Button")
	private WebElement backIcon;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ImageView[1]")
	private WebElement mnuGames;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Predict And Win')]")
	private WebElement lblPredictAndWin;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Trading Arena')]")
	private WebElement lblTradingArena;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'My Games')]")
	private WebElement mnuMyGames;

	@FindBy(xpath = "//android.view.View[@content-desc=\"My Games\"]")
	private WebElement lblMyGames;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Groups')]")
	private WebElement mnuGroups;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
	private WebElement mnuHamburger;

	@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Wallet')]")
	private WebElement mnuWallets;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Groups')]")
	private WebElement tabGroups;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Trade Ideas')]")
	private WebElement tabTradeIdeas;

	@FindBy(xpath = "//android.view.View[3]/android.view.View/android.view.View")
	private WebElement editIcon;

	@FindBy(xpath = "//android.view.View[@content-desc = 'EDIT PROFILE']")
	private WebElement lblEditProfile;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Save Changes']")
	private WebElement btnSaveChanges;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Order History')]")
	private WebElement btnOrderHistory;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Contact Us')]")
	private WebElement btnContactUs;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Helpdesk']")
	private WebElement lblHelpDesk;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Give us Feedback')]")
	private WebElement btnFeedback;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'FAQ')]")
	private WebElement btnFAQ;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Quick Guide\"]")
	private WebElement lblQuickGuide;

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Privacy Policy')]")
	private WebElement btnPrivacy;

	// @FindBy(xpath = "//android.view.View[contains(@content-desc, 'Invite &
	// Earn!')]")
	// @FindBy(xpath = "//android.view.View[3]/android.view.View[2]")

	@FindBy(xpath = "//android.view.View[contains(@content-desc, ' Invite & Earn!')]")
	private WebElement lblInviteEarn;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Invite & Earn']")
	private WebElement lblInviteEarn1;

	// android.view.View[contains(@content-desc, ' Invite & Earn!')]

	@FindBy(xpath = "//android.view.View[contains(@content-desc, 'Logout')]")
	private WebElement btnLogout;

	public ThreedotsLoginPage(AppiumDriver<WebElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visualComparisionPage = new VisualComparisionPage(driver);
	}

	public String getThreedotsTitle() {
		logger.info("Starting of getThreedotsTitle method");
		this.explicitWait(lblThreedots);
		logger.info("Ending of getThreedotsTitle method");

		return lblThreedots.getText();
	}

	public void clickOnContinueWithGoogleButton() {
		logger.info("Starting of clickOnContinueWithGoogleButton method");

		this.btnContinueWithGoogle.click();

		logger.info("Ending of clickOnContinueWithGoogleButton method");
	}

	public String getChooseAnAccountTitle() {
		logger.info("Starting of getChooseAnAccountTitle method");
		logger.info("Ending of getChooseAnAccountTitle method");

		return getText(lblChooseAnAccount);
	}

	public void clickOnEmailIdLink() {
		logger.info("Starting of clickOnEmailIdLink method");

		try {
			if (lnkEmailId.isDisplayed() == true) {
				clickOnElement(lnkEmailId);
			}
		} catch (Exception e) {
			verticalScroll();
			clickOnElement(lnkEmailId);
		}

		logger.info("Ending of clickOnEmailIdLink method");
	}

	public boolean isThreedotsHomePageContains() {
		logger.info("Starting of isThreedotsHomePageContains method");

		boolean isThreedotsHomePageContains = false;

		if (isDisplayed(mnuGames) && isDisplayed(mnuGroups) && isDisplayed(mnuWallets) && isDisplayed(mnuHamburger)
				&& isDisplayed(btnAddCash)) {
			isThreedotsHomePageContains = true;
		}
		logger.info("Ending of isThreedotsHomePageContains method");

		return isThreedotsHomePageContains;
	}

	public boolean isAddDotcoinsLabelDisplayed() {
		logger.info("Starting of isAddDotcoinsLabelDisplayed method");
		logger.info("Ending of isAddDotcoinsLabelDisplayed method");

		return isDisplayed(mnuWallets);
	}

	public boolean isGroupsMenuContains() {
		logger.info("Starting of isGroupsMenuContains method");

		boolean groups = false;

		if (isDisplayed(tabGroups) && isDisplayed(tabTradeIdeas)) {
			groups = true;
			System.out.println("Groups and Trade Ideas tabs are present");
		}
		else {
			System.out.println("Groups and Trade Ideas tabs are not present");
			groups = false;
		}

		logger.info("Ending of isGroupsMenuContains method");

		return groups;
	}
	
	

	public void clickOnBackButton() {
		logger.info("Starting of clickOnBackButton method");

		this.explicitWait(btnBack);
		clickOnElement(btnBack);

		logger.info("Ending of clickOnBackButton method");
	}

	public void clickOnDotcoinButton() {
		logger.info("Starting of clickOnDotcoinButton method");

		this.btnDotcoin.click();

		logger.info("Ending of clickOnDotcoinButton method");
	}

	public void clickOnAddCashButton() {
		logger.info("Starting of clickOnAddCashButton method");

		this.explicitWait(btnAddCash);
		this.btnAddCash.click();

		logger.info("Ending of clickOnAddCashButton method");
	}

	public String getWinZoneTitle() {
		logger.info("Starting of getWinZoneTitle method");
		this.explicitWait(lblWinZone);
		logger.info("Ending of getWinZoneTitle method");

		return lblWinZone.getAttribute("content-desc");
	}

	public void clickOnBackIcon() {
		logger.info("Starting of clickOnBackIcon method");

		this.backIcon.click();

		logger.info("Ending of clickOnBackIcon method");
	}

	public void clickOnGamesMenu() {
		logger.info("Starting of clickOnGamesMenu method");

		this.explicitWait(mnuGames);
		this.mnuGames.click();
		verticalScrollUp();

		logger.info("Ending of clickOnGamesMenu method");
	}

	public void clickOnMyGamesMenu() {
		logger.info("Starting of clickOnMyGamesMenu method");

		this.mnuMyGames.click();

		logger.info("Ending of clickOnMyGamesMenu method");
	}

	public String getMyGamesLabelText() {
		logger.info("Starting of getMyGamesLabelText method");
		logger.info("Ending of getMyGamesLabelText method");

		return lblMyGames.getAttribute("content-desc");
	}

	public boolean isGamesMenuContains() {
		logger.info("Starting of isGamesMenuContains method");

		boolean isGamesMenuContains = false;

		if (isDisplayed(lblPredictAndWin) && isTradeArenaCardDisplayed()) {
			isGamesMenuContains = true;
		}
		logger.info("Ending of isGamesMenuContains method");

		return isGamesMenuContains;
	}

	public boolean isTradeArenaCardDisplayed() {
		logger.info("Starting of isTradeArenaCardDisplayed method");

		verticalScroll();

		logger.info("Ending of isTradeArenaCardDisplayed method");

		return lblTradingArena.isDisplayed();
	}

	public void clickOnGroupsMenu() {
		logger.info("Starting of clickOnGroupsMenu method");

		this.explicitWait(mnuGroups);
		this.mnuGroups.click();

		logger.info("Ending of clickOnGroupsMenu method");
	}

	public void clickOnHamburgerMenu() {
		logger.info("Starting of clickOnHamburgerMenu method");

		this.mnuHamburger.click();

		logger.info("Ending of clickOnHamburgerMenu method");
	}

	public void clickOnLogoutButton() {
		logger.info("Starting of clickOnLogoutButton method");

		this.btnLogout.click();

		logger.info("Ending of clickOnLogoutButton method");
	}

	public boolean isHamburgerMenuContains() {
		logger.info("Starting of isHamburgerMenuContains method");

		boolean isHamburgerMenuContains = false;

		if (isDisplayed(editIcon) && isDisplayed(btnOrderHistory) && isDisplayed(btnContactUs)
				&& isDisplayed(btnFeedback) && isDisplayed(btnFAQ) && isDisplayed(btnPrivacy)
				&& isDisplayed(btnLogout)) {
			isHamburgerMenuContains = true;
		}
		logger.info("Ending of isHamburgerMenuContains method");

		return isHamburgerMenuContains;
	}

	public void clickOnEditIcon() {
		logger.info("Starting of clickOnEditIcon method");

		this.editIcon.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.info("Ending of clickOnEditIcon method");
	}

	public String getEditProfileText() {
		logger.info("Starting of getEditProfileText method");
		logger.info("Ending of getEditProfileText method");

		return lblEditProfile.getAttribute("content-desc");
	}

	public boolean isSaveChangesButtonDisplayed() {
		logger.info("Starting of isSaveChangesButtonDisplayed method");
		logger.info("Ending of isSaveChangesButtonDisplayed method");

		return isDisplayed(btnSaveChanges);
	}

	public void clickOnOrderButton() {
		logger.info("Starting of clickOnOrderButton method");

		this.btnOrderHistory.click();

		logger.info("Ending of clickOnOrderButton method");
	}

	public void clickOnContactUsButton() {
		logger.info("Starting of clickOnContactUsButton method");

		this.btnContactUs.click();

		logger.info("Ending of clickOnContactUsButton method");
	}

	public String getHelpDeskText() {
		logger.info("Starting of getHelpDeskText method");
		logger.info("Ending of getHelpDeskText method");

		return getText(lblHelpDesk);
	}

	public void clickOnFeedbackButton() {
		logger.info("Starting of clickOnFeedbackButton method");

		this.btnFeedback.click();

		logger.info("Ending of clickOnFeedbackButton method");
	}

	public void clickOnFAQButton() {
		logger.info("Starting of clickOnFAQButton method");

		this.btnFAQ.click();

		logger.info("Ending of clickOnFAQButton method");
	}

	public String getQuickGuideText() {
		logger.info("Starting of getQuickGuideText method");
		logger.info("Ending of getQuickGuideText method");

		return this.lblQuickGuide.getAttribute("content-desc");
	}

	public String getInviteEarnTitle() {
		logger.info("Starting of getInviteEarnTitle method");

		this.explicitWait(lblInviteEarn);

		logger.info("Ending of getInviteEarnTitle method");

		return lblInviteEarn.getAttribute("content-desc");
	}

	public void clickOnInviteEarn() {

		logger.info("Starting of clickOnInviteEarn method");
		this.lblInviteEarn.click();

		logger.info("Ending of clickOnInviteEarn method");
	}

	public boolean isInvitEarnTextisDisplayed() {
		logger.info("Starting of isInvitEarnTextisDisplayed method");
		logger.info("Ending of isInvitEarnTextisDisplayed method");
		try {
			this.verticalScrollDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return isDisplayed(lblInviteEarn1);
	}

	public void clickOnPrivacyButton() {
		logger.info("Starting of clickOnPrivacyButton method");

		this.btnPrivacy.click();

		logger.info("Ending of clickOnPrivacyButton method");
	}
}