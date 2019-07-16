package ca.teranet.pages.customercare;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerMemberDetailsPage extends BasePage {

	// login button
	@FindBy(xpath = "//input[@name='reportsViewed']")
	public WebElementFacade input_reports_viewed;

	// header link
	@FindBy(xpath = "//tr[@class='globalHeader']")
	public WebElementFacade header_memberDetail;

	@FindBy(xpath = "//input[@name='customerId']")
	public WebElementFacade input_ByMember;

	@FindBy(xpath = "//input[@name='counterLicenseMaxLimit']")
	public WebElementFacade input_licensemax_limit;

	@FindBy(xpath = "//input[@name='reportsPurchased']")
	public WebElementFacade input_reports_purchased;

	@FindBy(xpath = "//input[@value='Update']")
	public WebElementFacade button_update;

	@FindBy(xpath = "//a[@title='Main Products']")
	public WebElementFacade button_main_products;

	@FindBy(xpath = "//a[contains(text(),'qtp qtpccuser ~ QTP company')]")
	public WebElementFacade link_companyname;

	public WebElementFacade language_link(String language) {
		return findBy("//a[contains(text(),'" + language + "')]");
	}

	// --- Account details
	@FindBy(xpath = "//input[@name='cardholder']")
	public WebElementFacade input_cardholder_name;

	@FindBy(xpath = "//input[@name='pan']")
	public WebElementFacade input_cardnumber;

	@FindBy(xpath = "//select[@name='exp_month']")
	public WebElementFacade list_exp_month;

	@FindBy(xpath = "//select[@name='exp_year']")
	public WebElementFacade list_exp_year;

	@FindBy(xpath = "//input[@name='cvd_value']")
	public WebElementFacade input_card_security_code;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade button_Cancel;

	@FindBy(xpath = "//table//font[contains(text(),'Successfully registered CC details.')]")
	public WebElementFacade success_message;

	@FindBy(xpath = "//table//td[contains(text(),'Your transaction has been cancelled.')]")
	public WebElementFacade failure_message;

	@FindBy(xpath = "//button[contains(text(),'Close Window')]")
	public WebElementFacade button_close_window;

	@FindBy(xpath = "//input[@name='Return to Customer Detail']")
	public WebElementFacade button_return_to_customer_detail;

	public WebElementFacade suspended_checkbox(String name) {
		return findBy("//input[@value='" + name + "']/../following-sibling::td/input[@name='ccsuspendPM']");
	}

	public WebElementFacade checkbox_TorC(String name, String productid) {
		return findBy("//input[@name='" + name + "' and @value='" + productid + "']");
	}

	// company name text box
	@FindBy(xpath = "//input[@name='company']")
	public WebElementFacade companyName_textBox;

	// company name postal code
	@FindBy(xpath = "//input[@name='postalCode']")
	public WebElementFacade postalCode_textBox;

	// 22-02-2019
	@FindBy(xpath = "//a[@title='MPAC']")
	public WebElementFacade button_MPAC;

	@FindBy(xpath = "//input[@name='countableall']")
	public WebElementFacade chkboxCountable;

	@FindBy(xpath = "//input[@name='transactionall']")
	public WebElementFacade chkboxTransactional;

	@FindBy(xpath = "//a[@title='MPAC']")
	public WebElementFacade button_MPAC_products;

	@FindBy(xpath = "//tr[@class='tableCurrentValues']//input[contains(@id,'grantaccess102')]")
	public WebElementFacade productID_select_grantaccess;

	@FindBy(xpath = "//a[@title='SRPR']")
	public WebElementFacade button_SRPR;

	@FindBy(xpath = "//input[@name='transactionall']")
	public WebElementFacade checkbox_SRPR_selectall;

	// --------------3/11/2019
	@FindBy(xpath = "//input[@value='Quick Search']")
	public WebElementFacade button_quick_search;

	@FindBy(xpath = "//a[contains(text(),'Reverse')]")
	public WebElementFacade link_Reverse;

	@FindBy(xpath = "//input[@name='quantityreturned0']")
	public WebElementFacade text_quantity_returned;

	@FindBy(xpath = "//input[@name='note']")
	public WebElementFacade text_reversal_note;

	@FindBy(xpath = "//input[@name='Finish']")
	public WebElementFacade button_finish;

	@FindBy(xpath = "//td/select[@id='licenseBundleId']")
	public WebElementFacade select_licenseBundle;

	@FindBy(xpath = "//img[@id='purchaseRCButton']")
	public WebElementFacade button_purchaseRcButton;

	@FindBy(xpath = "//a[@id='offeritem_22']")
	public WebElementFacade Button_reportpackage;

	@FindBy(xpath = "(//a/strong[(text()='ProductName2')]/../span[@class='purchase-description'])[2]")
	public WebElementFacade text_no_ofreports;

	@FindBy(xpath = "(//a/strong[(text()='ProductName2')]/../big[@class='purchase-price'])")
	public WebElementFacade text_productprice;

	@FindBy(xpath = "//a[@id='finalize_order']")
	public WebElementFacade button_checkout;

	@FindBy(xpath = "//input[@id='addToCartButton']")
	public WebElementFacade button_addtocart;

	@FindBy(xpath = "//td/span[@class='description']//following::span[1]")
	public WebElementFacade text_quantitydetails;

	@FindBy(xpath = "//td[contains(text(),'Transaction ID:')]//following-sibling::td[1]")
	public WebElementFacade text_transactionId;

	@FindBy(xpath = "//a[@class='close-container']")
	public WebElementFacade link_close_container;

	@FindBy(xpath = "//a[@id='mygeowarehouse']")
	public WebElementFacade label_mygeowarehouse;

	@FindBy(xpath = "//a[contains(text(),'Transaction History')]")
	public WebElementFacade button_TransactionHistory;

	@FindBy(xpath = "//input[@id='fixedRangeRadio']")
	public WebElementFacade radioBtn_fixedRange;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade button_search_TransactionHistory;

	@FindBy(xpath = "//th[contains(text(),'Transaction ID')]/../../..//tbody/tr/td[4]/a")
	public WebElementFacade link_Latest_TransactionId;

	@FindBy(xpath = "(//input[@type='button' and @value='Update'])[2]")
	public WebElementFacade button_Update;

	public static By transactionhistory() {
		return By.xpath("//iframe[@id='transactionhistory']");

	}

	// -----------date :-21/2/2019---------
	// create purchase button
	@FindBy(xpath = "//input[@value='Create Purchase']")
	public WebElementFacade button_CreatePurchase;

	@FindBy(xpath = "//input[@name='note']")
	public WebElementFacade text_name;

	@FindBy(xpath = "//select[@name='selectedproducts']")
	public WebElementFacade select_selected_products;

	@FindBy(xpath = "//td/select[@name='selectedproduct']")
	public WebElementFacade select_selected_product;
	// next button
	@FindBy(xpath = "//input[@value='Next >>']")
	public WebElementFacade button_Next;
	// attribute text field
	@FindBy(xpath = "//input[@name='attributevalue0_0']")
	public WebElementFacade text_attributevalue;
	// quantity text field
	@FindBy(xpath = "//input[@id='quantity0']")
	public WebElementFacade text_quantity;
	// add to cart button
	@FindBy(xpath = "//input[@type='submit']")
	public WebElementFacade button_AddToCart;
	// review purchase button
	@FindBy(xpath = "//img[@name='review_purchase']")
	public WebElementFacade button_review_purchase;
	// customer name
	@FindBy(xpath = "//input[@name='initcustomer']")
	public WebElementFacade text_initcustomer;
	// search button
	@FindBy(xpath = "//td/input[@type='submit' and @value='Search']")
	public WebElementFacade button_Search;
	// header error
	@FindBy(xpath = "//p[@class='error']")
	public WebElementFacade class_error;

	@FindBy(xpath = "//input[@name='billableactivityid']")
	public WebElementFacade text_confirmation_review_purchase;

	@FindBy(xpath = "//input[@type='text'][@name='reportsViewed']")
	public WebElementFacade reports_viewed_count_cc;

	@FindBy(xpath = "//*[@name='member_search']")
	public WebElementFacade member_search;

	@FindBy(xpath = "//*[@name='customerId']")
	public WebElementFacade customerId;

	@FindBy(xpath = "//*[@name='company_search']")
	public WebElementFacade company_search;

	@FindBy(xpath = "//*[@name='Quick Search']")
	public WebElementFacade QuickSearch;

	@FindBy(xpath = "//a[@title='MPAC']")
	public WebElementFacade button_mpac;

	@FindBy(xpath = "//input[@name='transactionall']")
	public WebElementFacade Checkbox_TorC;
}
