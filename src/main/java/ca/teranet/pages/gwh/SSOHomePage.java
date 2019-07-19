package ca.teranet.pages.gwh;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SSOHomePage extends BasePage {

	// Label SSO AND DEEP LINK TEST PAGE
	@FindBy(xpath = "//p[contains(text(),'SSO AND DEEP LINK TEST PAGE')]")
	public WebElementFacade lblSSOANDDEEPLINKTESTPAGE;

	// Radio buttons Request Type: SSO Only,SSODeepLink,ManualLoginDeepLink
	public WebElementFacade requestType(String name) {
		return findBy("//input[@value='" + name + "']");
	}

	// TextBox : MLS User ID:,System ID:,Account ID:,Account Password:,etc
	public WebElementFacade txtBoxOfSSO(String name) {
		return findBy("//th[contains(text(),'" + name + "')]/../td/input");
	}

	// Radio buttons:Single Request:? Yes,No
	@FindBy(xpath = "//td[@class='ssoLink']/input[@value='true']")
	public WebElementFacade rdbtnSingleRequestYes;

	@FindBy(xpath = "//td[@class='ssoLink']/input[@value='false']")
	public WebElementFacade rdbtnSingleRequestNo;

	// Submit button
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade btnSubmit;

	// Link My Profile
	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	public WebElementFacade lnkMyProfile;

	// TextBox PIN:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.pin']")
	public WebElementFacade txtPIN;

	// TextBox CallbackID:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.callbackId']")
	public WebElementFacade txtCallbackID;

	// TextBox RequestedFeatures:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.requestedFeatures']")
	public WebElementFacade txtRequestedFeatures;

	// Link SSODeepLink URL
	@FindBy(xpath = "//th[contains(text(),'SSO / Deep Link URL:')]/..//a")
	public WebElementFacade lnkSSODeepLinkURL;

	// Logout Link
	@FindBy(xpath = "//div[contains(text(),'Logout')]/ancestor::a")
	public WebElementFacade lnkLogout;

	// I Accept Button
	@FindBy(xpath = "//input[@value='I Accept']")
	public WebElementFacade btnAccept;

	// topmenussopage
	@FindBy(xpath = "//div[@id='topmenu']")
	public WebElementFacade topmenussopage;

	// LINKLOGOUT
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElementFacade linkssologout;

	// I Decline Button
	@FindBy(xpath = "//input[@value='I Decline']")
	public WebElementFacade btnDecline;

	// 25-02-2019
	// TextBox StreetNumber:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.streetNumber']")
	public WebElementFacade txtStreetNumber;

	// TextBox StreetName:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.streetName']")
	public WebElementFacade txtStreetName;

	// TextBox SuiteNumber:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.suiteNumber']")
	public WebElementFacade txtSuiteNumber;

	// TextBox Municipality:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.municipality']")
	public WebElementFacade txtMunicipality;

	// TextBox PostalCode:
	@FindBy(xpath = "//div[@id='deepLinkFieldContainer']//input[@name='deepLinkRequestVO.postalCode']")
	public WebElementFacade txtPostalCode;

}
