package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ROSCOTEXAdminPage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	@FindBy(xpath = "//h1[contains(.,'ROSCO/TEX Admin Log In')]")
	public WebElementFacade title_ROSCOTEXLogin;

	@FindBy(xpath = "//span[@class='title']")
	public WebElementFacade title_RTSZone;

	@FindBy(xpath = "//td[2]//b")
	public WebElementFacade subtitle_RTSZone;

	@FindBy(xpath = "//b[contains(.,'Results of Search By Service Request ID')]")
	public WebElementFacade title_ResultsofSearch;

	@FindBy(xpath = "//b[contains(.,'Resend Certificate/Product/Receipt Result')]")
	public WebElementFacade title_Resend;

	// login page
	@FindBy(xpath = "//input[@id='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@id='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//button[@id='login-button']")
	public WebElementFacade button_login;

	@FindBy(xpath = "//button[@id='cancel-button']")
	public WebElementFacade button_cancel;

	// function links/Log out
	public WebElementFacade link_ROSCOTEXSupport(String text) {
		return findBy("//a[contains(.,'" + text + "')]");
	}

	// subtitle for functions:
	// Search User Profile/Search By Kiosk/Search By Delivery Email
	// Search By Service Request/Search By Payment ID/Printer Redirection
	@FindBy(xpath = "//td[3]/form//b")
	public WebElementFacade functitle_RTSZone;

	// Search By page Service Request/Kiosk/Delivery Email Address
	@FindBy(xpath = "//input[@id='serviceId']")
	public WebElementFacade input_serviceId;

	// Search By Kiosk/Printer Redirection
	@FindBy(xpath = "//select[@id='kioskId']")
	public WebElementFacade select_kioskId;

	@FindBy(xpath = "//input[@id='searchDateString']")
	public WebElementFacade input_searchDate;

	@FindBy(xpath = "//input[@id='kioskId']")
	public WebElementFacade input_deliveryEmail;

	@FindBy(xpath = "//input[@id='paymentId']")
	public WebElementFacade input_paymentId;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade button_search;

	@FindBy(xpath = "//input[@id='alternativeEmail']")
	public WebElementFacade input_alterEmail;

	@FindBy(xpath = "//textarea[@id='Message']")
	public WebElementFacade text_message;

	// search user Profile
	@FindBy(xpath = "//input[@id='searchDateString']")
	public WebElementFacade input_firstName;

	@FindBy(xpath = "//input[@id='searchDateString']")
	public WebElementFacade input_lastName;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade button_submit;

	// Printer Redirection
	@FindBy(xpath = "//input[@value='GetPrinters']")
	public WebElementFacade button_getPrinter;

}
