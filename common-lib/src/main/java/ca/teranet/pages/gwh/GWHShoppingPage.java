package ca.teranet.pages.gwh;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GWHShoppingPage extends BasePage {

	@FindBy(id = "srprsearchPlansBtn")
	public WebElementFacade button_search_plans;

	@FindBy(xpath = "//table[@class='data_tbl datamultirow']//a[contains(text(),'1990')]/following::td[1]/a")
	public WebElementFacade button_purchase_plan;

	@FindBy(id = "directCheckoutButton")
	public WebElementFacade button_direct_checkout;

	@FindBy(xpath = "//input[@name='cardholderName']")
	public WebElementFacade text_name_on_card;

	@FindBy(xpath = "//input[@id='monerisDataInput']")
	public WebElementFacade text_number_on_card;

	@FindBy(xpath = "//input[@id='monerisExpInput']")
	public WebElementFacade text_expirydate_on_card;

	@FindBy(xpath = "//input[@id='monerisCVDInput']")
	public WebElementFacade text_securitycode_on_card;

	@FindBy(xpath = "//input[@id='hppEmailAddress']")
	public WebElementFacade text_email_address_on_card;

	@FindBy(id = "finalizeOrder")
	public WebElementFacade link_finalize_order;

	@FindBy(xpath = "//a[@title='Download your purchased items']")
	public WebElementFacade button_download;

	@FindBy(xpath = "//span[@class='close-text']")
	public WebElementFacade link_close;

	@FindBy(xpath = "//div[contains(text(),'Transaction has been approved.'])")
	public WebElementFacade transactionApproved;

	@FindBy(xpath = "//p[contains(text(),'Error during the Transaction process.')]")
	public WebElementFacade msg_error_during_transaction;

	@FindBy(xpath = "//a[contains(text(),'Please click to continue shopping')]")
	public WebElementFacade link_continue_shopping;

	@FindBy(xpath = "//input[@id='processSearchButton']")
	public WebElementFacade homepage_search_button;

}
