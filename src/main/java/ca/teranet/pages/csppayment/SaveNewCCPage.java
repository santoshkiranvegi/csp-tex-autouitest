package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SaveNewCCPage extends BasePage {

	// getDriver().switchTo().frame(onlineReceiptPage.frame_receipt);
	@FindBy(xpath = "//iframe[@src='registervault_iframe.jsp']")
	public WebElementFacade frame_creditCard;

	@FindBy(xpath = "//h1")
	public WebElementFacade title_page;

	@FindBy(xpath = "//div[@id='hppCustDetails']/div")
	public WebElementFacade title_customDetails;

	@FindBy(xpath = "//div[@id='hppCustDetails']/p[1]")
	public WebElementFacade custom_id;

	@FindBy(xpath = "//div[@id='hppCustDetails']/p[2]")
	public WebElementFacade custom_email;

	@FindBy(xpath = "//div[@id='hppCustDetails']/p[3]")
	public WebElementFacade custom_tel;

	@FindBy(xpath = "//div[@id='hppCustDetails']/p[4]")
	public WebElementFacade custom_note;

	@FindBy(xpath = "//div[@id='hppFinancialCC']/div[1]")
	public WebElementFacade title_accountDetials;

	@FindBy(xpath = "//div[@id='hppFinancialCC']/div[2]")
	public WebElementFacade addNewCC_desp;

	@FindBy(xpath = "//div[@id='hppFinancialCC']/div[3]")
	public WebElementFacade addNewCC_note;

	@FindBy(xpath = "//input[@id='cardholder']")
	public WebElementFacade input_cardHolder;

	@FindBy(xpath = "//input[@id='pan']")
	public WebElementFacade input_cardNumber;

	// 01-12
	@FindBy(xpath = "//select[@id='exp_month']")
	public WebElementFacade select_expMonth;

	// no before year
	@FindBy(xpath = "//select[@id='exp_year']")
	public WebElementFacade select_expYear;

	@FindBy(xpath = "//input[@id='cvd_value']")
	public WebElementFacade input_cvdValue;

	@FindBy(xpath = "//input[@id='buttonResAddCC']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@id='buttonCancelCC']")
	public WebElementFacade button_cancel;

	// *[@id="buttonResAddCC"]

	// *[@id="buttonCancelCC"]

	// ======================= negative =====================================
	// error message ?????????????
	@FindBy(xpath = "//span[@id='doc.errors']")
	public WebElementFacade page_errorMessage;

	@FindBy(xpath = "//div[@id='error_box']/ul/li")
	public WebElementFacade error_message;
	// *[@id="error_box"]/ul/li[1]/text()
	// "Cardholder name is blank or contains characters other than 0 to 9, A to Z, « space », « period » or hyphen."
	// "Please enter a valid card number. The card number should not contain spaces or hyphens."
	// "Please enter a valid expiry date."
	// "Card Security Code must be 3-4 digits."

	@FindBy(xpath = "//input[@id='errorCloseButton']")
	public WebElementFacade button_error_close;

	// ============== save new CC succeed confirmation =====================
	// Vault Registration & Update Confirmation
	@FindBy(xpath = "//table//tr[2]")
	public WebElementFacade success_confirm;

	@FindBy(xpath = "//table//tr[5]")
	public WebElementFacade custom_ID;

	// Message: Successfully registered CC details.
	// Please record your vault ID: nYQ80XVqX6X2ffEKa7C29v5h7
	// html/body/table/tbody/tr[6]/td/table/tbody/tr[1]/td[2]/font
	@FindBy(xpath = "//table//tr[6]//tbody/tr[1]/td[2]/font")
	public WebElementFacade success_message;

	// Please click here verify your items in shopping carts and check out with your new vault ID.
	@FindBy(xpath = "//table//tr[8]")
	public WebElementFacade verify_message;

	@FindBy(xpath = "//a[@href='javascript:closeWindow();']")
	public WebElementFacade link_here;

	// ============== save new CC cancel confirmation =======================

	@FindBy(xpath = "//table//tr[1]")
	public WebElementFacade cancel_confirm1;

	@FindBy(xpath = "//table//tr[2]")
	public WebElementFacade cancel_confirm2;

	@FindBy(xpath = "//button[@onclick='javascript:closeWindow()']")
	public WebElementFacade button_closeWindow;

	@FindBy(xpath = "//td[@id='pagetitle']")
	public WebElementFacade canceled_message;

	// /html/body/table/tbody/tr[5]/td/div/button
	@FindBy(xpath = "//table//tr[5]//button")
	public WebElementFacade button_closeTheWindow;
}
