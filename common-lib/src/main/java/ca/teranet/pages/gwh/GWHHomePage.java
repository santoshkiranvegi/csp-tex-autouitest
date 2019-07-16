package ca.teranet.pages.gwh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GWHHomePage extends BasePage {

	// login button
	@FindBy(xpath = "//img[@src='/gwhweb/images/Store_tag_top.png']")
	public WebElementFacade img_store;

	// header link
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElementFacade header_logout;

	@FindBy(xpath = "//div[@id='catalgoue_logo_text_div']")
	public WebElementFacade header_store;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	public WebElementFacade link_login;

	@FindBy(xpath = "//textarea[@name='txt']")
	public WebElementFacade textarea_terms_and_conditions;

	// Welcome message
	@FindBy(xpath = "//div[@id='topMenuTitle']")
	public WebElementFacade welcome_message;

	// ---- Address related objects
	@FindBy(xpath = "//input[@title='Enter street number here']")
	public WebElementFacade street_number_field;

	// street name
	@FindBy(xpath = "//input[@id='stname']")
	public WebElementFacade street_name_field;

	// suite
	@FindBy(xpath = "//input[@title='Enter suite number here']")
	public WebElementFacade suite_field;

	@FindBy(id = "srprsearchPlansBtn")
	public WebElementFacade button_search_plans;

	// Item Price
	public By itemPrice = By.xpath("//div[@id='itemprice']");

	public By frameName = By.xpath("//iframe[@id='ProductDetailFrameID']");

	public By propertySearchFrame = By.xpath("//iframe[@name='PropertySearchResults']");

	// purchase button
	@FindBy(xpath = "//img[@id='purchaseRCButton']")
	public WebElementFacade purchaseButton;

	@FindBy(xpath = "//span[text()='20 Reports']")
	public WebElementFacade reports1;

	// 20 reports
	public By reports = By.xpath("//span[text()='20 Reports']/../../../li");

	// close button
	@FindBy(xpath = "//a[@class='close-container']")
	public WebElementFacade closeButton;

	// -- pin related objects
	@FindBy(id = "SEARCH_BY_PIN")
	public WebElementFacade link_pin;

	@FindBy(id = "pcode")
	public WebElementFacade input_postalcode;

	@FindBy(id = "lro")
	public WebElementFacade select_lro_province;

	@FindBy(xpath = "//input[@name='pin' and @class='srchtextin']")
	public WebElementFacade input_pin;

	@FindBy(xpath = "//input[@name='searchButton']")
	public WebElementFacade button_search;

	@FindBy(xpath = "//div[@id='suggestion']")
	public WebElementFacade message_text;

	// after search displays multiple results for address 1101 suite
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade bonis_text_message;

	// after search displays 25 result for tc32
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr'][contains(text(),'238 BONIS AVE')]")
	public WebElementFacade bonis_avemessage;

	// --- search results objects
	@FindBy(xpath = "//table[@id='pagination']//td")
	public WebElementFacade header_searchresults;

	@FindBy(xpath = "//table[@id='pagination']//td[2]")
	public WebElementFacade header_searchresults2;

	public WebElementFacade links_address_docs(String name) {
		return findBy("//table[@class='piisummarybox']//a[contains(text(),'" + name + "')]");
	}

	@FindBy(xpath = "//td[@class='propertylist1']")
	public WebElementFacade property_list;

	@FindBy(id = "searchresultcont")
	public WebElementFacade table_searchresults;

	@FindBy(xpath = "//table[@id='pagination']//td[2]")
	public WebElementFacade table_searchresults_header;

	@FindBy(id = "next")
	public WebElementFacade img_next;

	@FindBy(xpath = "//img[@src='/gwhweb/images/no_google_view_medium.png']")
	public WebElementFacade Imageicon;

	// -- instrument related objects

	@FindBy(id = "SEARCH_BY_INSTRUMENT")
	public WebElementFacade link_searchBy_instrument_plan;

	@FindBy(xpath = "//input[@name='instrument' and @class='srchtextin']")
	public WebElementFacade input_intrument_plan;

	@FindBy(xpath = "//a[contains(text(),'View Instrument/Plan ')]")
	public WebElementFacade link_instrument_plan;

	@FindBy(xpath = "//span[@id='errorConsole3']")
	public WebElementFacade error_message;

	@FindBy(xpath = "//span[@id='errorConsole1']")
	public WebElementFacade error_message1;

	@FindBy(xpath = "//span[@id='errorConsole2']")
	public WebElementFacade error_message2;

	// --- propertyDetails related objects
	@FindBy(xpath = "//div[@id='propdtlsdivwrapper']/div")
	public WebElementFacade propertyInfo;

	@FindBy(xpath = "//div[@id='mpacdatadivwrapper']//div[@id='arndtls_propdiv']")
	public WebElementFacade assessment_report;

	public WebElementFacade text_arn(String arn) {
		return findBy("//td[@class='boxed_cell' and contains(text(),'" + arn + "')]");
	}

	@FindBy(xpath = "//td[@class='legaldesc']")
	public WebElementFacade label_legaldescription;

	// -- ARN related objects
	@FindBy(id = "SEARCH_BY_ARN")
	public WebElementFacade link_search_by_ARN;

	@FindBy(xpath = "//input[@name='arn' and @class='srchtextin']")
	public WebElementFacade input_arn;

	@FindBy(xpath = "//div[@id='suggestion']")
	public WebElementFacade message_arn;

	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade text_address;

	@FindBy(xpath = "//td[@class='propertylist1']")
	public WebElementFacade text_propertylist1;

	@FindBy(xpath = "//td[@class='propertylist2']")
	public WebElementFacade text_propertylist2;

	@FindBy(xpath = "//li/a[contains(text(),'Assessment Details')]")
	public WebElementFacade name_AssessmentDetails;

	// -- LOT related objects
	@FindBy(id = "SEARCH_BY_LOT")
	public WebElementFacade link_search_by_LOT;

	@FindBy(xpath = "//select[@id='select_township']")
	public WebElementFacade select_township;

	@FindBy(xpath = "//select[@id='select_concession']")
	public WebElementFacade select_concession;

	@FindBy(xpath = "//select[@id='select_lot']")
	public WebElementFacade select_lot;

	// SearchResults - PropertyList_ ARN Tag
	public WebElementFacade tag_ARNPropertySearchResult(int i) {
		return findBy("(//div[@class='btnav']//table[@class='piisummaryboxdata']//tr[2]//td[2])[" + i + "]");

	}

	public static By searchResultsHeader = By.xpath("//span[@class='piisummaryaddrhdr']");

	// --address range
	@FindBy(xpath = "//a[@id='SEARCH_BY_ADDRESS_RANGE']")
	public WebElementFacade search_by_address_range;

	@FindBy(xpath = "//input[@title='Enter the postal code here']")
	public WebElementFacade postalCode;

	@FindBy(xpath = "//select[@id='lro']")
	public WebElementFacade lro;

	@FindBy(xpath = "//input[@name='streetNumberFrom']")
	public WebElementFacade streetNumberFrom;

	@FindBy(xpath = "//input[@name='streetName']")
	public WebElementFacade streetName;

	@FindBy(xpath = "//input[@title='Enter suite number here']")
	public WebElementFacade unitNo;

	@FindBy(xpath = "//input[@id='processSearchButton']")
	public WebElementFacade Search;

	@FindBy(xpath = "//input[@name='streetNumberTo']")
	public WebElementFacade streetNumberTo;

	// More Link after clicking on property details
	@FindBy(id = "assessmentHelpMoreId")
	public WebElementFacade lnkMore;

	// Assessment Information
	@FindBy(className = "moreText")
	public WebElementFacade assessmentInformation;

	// Dialogbox AssessmentInfo Not Available
	@FindBy(id = "contextHelpDialogId")
	public WebElementFacade dialogBoxAssessmentInfoNA;

	// Dialogbox AssessmentInfo Not Available
	@FindBy(xpath = "//button[contains(text(),'CLOSE')]")
	public WebElementFacade btnCloseAssessmentInformation;

	// Property details Report
	@FindBy(id = "propdtlsdivwrapper")
	public WebElementFacade propertyDetailsReport;

	// Assessment Roll Number
	@FindBy(xpath = "//label[contains(text(),'Assessment Roll Number')]/../../th[2]")
	public WebElementFacade lblAssessmentRollNumber;

	// Property Type
	@FindBy(xpath = "//label[contains(text(),'Property Type:')]/../following-sibling::td")
	public WebElementFacade lblPropertyType;

	// 21-02-2019
	// Sales History Information
	@FindBy(xpath = "//th/a[contains(text(),'Assessment Information')]")
	public WebElementFacade lblAssessmentInformation;

	// Assesment Information
	@FindBy(xpath = "//th[contains(text(),'Sales History Information')]")
	public WebElementFacade lblSalesHistoryInformation;

	// 22-02-2019
	// Assessnent Reports Link
	@FindBy(xpath = "//a[contains(@title,'assessment reports')]")
	public WebElementFacade lnkAssessmentReports;

	// Purchase Button
	@FindBy(id = "purchasePRButton")
	public WebElementFacade btnPurchase;

	// 25-02-2019
	// Assessment Reports Count Label
	@FindBy(xpath = "//td[@class='propertylist2']")
	public WebElementFacade lblAssessmentReportsCount;

	// list of view Report buttons
	@FindBy(xpath = "//img[contains(@id,'viewMPAC')]")
	public WebElementFacade listOfViewReports;

	// 27-02-2019
	// Link Add to Comps Report
	@FindBy(xpath = "//div[@class='icon_link']/a[contains(text(),'Add To Comps Report')]")
	public WebElementFacade lnkAddToCompsReport;

	// Last Edited Report Radio button
	@FindBy(xpath = "//legend[contains(text(),'Last Edited Report')]/following-sibling::input")
	public WebElementFacade rdbtnLastEditedReport;

	// 01-03-2019
	// Parcel Register Link
	@FindBy(xpath = "//a[contains(text(),'Parcel')]")
	public WebElementFacade lnkParcelregister;

	// Quick Checkout button
	@FindBy(id = "directCheckoutButton")
	public WebElementFacade btnQuickCheckout;

	// Card Holder Name
	@FindBy(xpath = "//input[@name='cardholderName']")
	public WebElementFacade txtNameOnTheCard;

	@FindBy(xpath = "//label[text()='Card Number']/following-sibling::input[1]")
	public WebElementFacade txtCardNumber;

	@FindBy(id = "monerisExpInput")
	public WebElementFacade txtCardExpiryDate;

	@FindBy(id = "monerisCVDInput")
	public WebElementFacade txtCardCVV;

	@FindBy(id = "finalizeOrder")
	public WebElementFacade btnFinalizeOrder;

	@FindBy(xpath = "//div[contains(text(),'Transaction has been approved')]")
	public WebElementFacade lblTransactionApproved;

	@FindBy(id = "go_to_fulfillment")
	public WebElementFacade btnDownloadProducts;

	@FindBy(xpath = "//a[contains(text(),'Download Parcel Register')]")
	public WebElementFacade lnkDownloadParcelRegister;

	// Title Bar
	public WebElementFacade title_bar(String titlebar) {
		return findBy("//th[contains(text(),'" + titlebar + "')]");
	}

	// Condominium Information title
	// Property Detail informations {1. Condominium Corporation: , Common Name: , Suite Number: }
	public WebElementFacade propDetailInfo1(String propertyname, int i) {
		return findBy("//td[contains(text(),'" + propertyname + ":" + "')]/following-sibling::td" + "[" + i + "]");

	}

	// Property Detail informations {1. SELECTED PIN: , TYPE: , Legal Level: , RELATED PINS:}
	public WebElementFacade propDetailInfo2(String propertyname, int i) {
		return findBy("//h6[contains(text(),'" + propertyname + ":" + "')]/following::td" + "[" + i + "]");

	}

	// Property Detail informations {1. LEGAL UNIT:}
	public WebElementFacade propDetailInfo3(String propertyname, int i) {
		return findBy("//h6[contains(text(),'" + propertyname + ":" + "')]/following::th" + "[" + i + "]");

	}

	// Instrument : AT2339916
	@FindBy(xpath = "//div[@class='infocont']")
	public WebElementFacade Instrument_AT2339916;

	public WebElementFacade LinkText(String Link) {
		return findBy("//a[contains(text(),'" + Link + "')]");

	}

	// Comps Report Add new options {Report Name: , Client Name: Job Number: }
	public WebElementFacade Comps_report_add_new(String Addnewtext) {
		return findBy("//input[@name='" + Addnewtext + "']");

	}

	// Comps Report Add new options {Comments:}
	@FindBy(xpath = "//textarea[@name='comments']")
	public WebElementFacade comments;

	// Comps Report Add new options {ok and cancel button , checkboxes after clicking print , checkboxes after clicking Enhanced Report}
	public WebElementFacade Comps_report_button(String button) {
		return findBy("//input[@id='" + button + "']");

	}

	// Comps Report click view and click remove
	public WebElementFacade Comps_report_Remove_view(int i) {
		return findBy("//a[contains(text(),'Add New')]/following::a[" + i + "]");
	}

	@FindBy(xpath = "//img[@id='imageflip']")
	public WebElementFacade img_flip;

	/*
	 * comps Report land registry information pin , Total Floor Area
	 */
	public WebElementFacade Comps_report_General_info(int i) {
		return findBy("//td[contains(text(),'PIN')]/following::a[" + i + "]");
	}

	// Comps Report "continue button" xpath in Remove Custom Report
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElementFacade continue_btn;

	// radio button at "select comparables report"
	@FindBy(xpath = "//input[@name='selectedReportId']")
	public WebElementFacade radio_btn;

	// Add and display button at "select comparables report"
	@FindBy(xpath = "//button[@id='addAndDisplayButton']")
	public WebElementFacade add_display;

	// Export & Print option in Comps report
	public WebElementFacade Export_Print(String text) {
		return findBy("//span[contains(text(),'" + text + "')]");
	}

	// Preview button in Print option
	public WebElementFacade button(String text) {
		return findBy("//input[@value='" + text + "']");
	}

	// information section in Print option
	public WebElementFacade Information_section(String info_sec) {
		return findBy("//h2[contains(text(),'" + info_sec + "')]");
	}

	// SearchresultsbyName - Error Message
	@FindBy(xpath = "//div[@id='errordiv4']")
	public WebElementFacade searchresultsbyName_Errormessage;

	// To Click first , last , next , previous options in search result

	public WebElementFacade searchResultPagination(String id) {
		return findBy("//a[@id='" + id + "']//img[@border='0']");
	}

	// Search result displayed xpath

	@FindBy(xpath = "//td[@align='center']")
	public WebElementFacade SearchResult_Displayed;

	// error message1
	public By errorMessage1 = By.xpath("//div[@class='error-text']/span");

	// -----------3/11/2019

	@FindBy(xpath = "//a[contains(text(),'Plan List By PIN')]")
	public WebElementFacade link_plainlist_by_pin;

	@FindBy(xpath = "//a[contains(text(),'Property Survey/SRPR Plan Search')]")
	public WebElementFacade link_Property_Survey_SRPR_Plan_Search;

	@FindBy(xpath = "//table[@class='data_tbl datamultirow']//a[contains(text(),'1990')]/following::td[1]/a")
	public WebElementFacade button_purchase_plan;

	@FindBy(xpath = "//input[@id='processSearchButton']")
	public WebElementFacade homepage_search_button;

	@FindBy(xpath = "//a[@id='SEARCH_BY_ADDRESS']")
	public WebElementFacade homepage_searchbyaddress_button;

	@FindBy(xpath = "//a[@id='SEARCH_BY_ADDRESS_RANGE']")
	public WebElementFacade homepage_searchByAddressRange_button;

	@FindBy(xpath = "//a[contains(text(),'Pin')]")
	public WebElementFacade name_Pin_link;

	public WebElementFacade Expected_ARN_Multiple_search(int i) {
		return findBy("(//div[@class='btnav']//table[@class='piisummaryboxdata']//tr[2]//td[2])[" + i + "]");

	}

	public static By carddetails() {
		return By.xpath("//iframe[@id='monerisFrame']");
	}

	@FindBy(xpath = "//th[@class='pr_storeicon_link']/a")
	public WebElementFacade button_parcel_register;

	@FindBy(xpath = "//input[@name='addToCartButton']")
	public WebElementFacade button_addto_cart;

	@FindBy(xpath = "//a[@name='_eventId_continueshopping']")
	public WebElementFacade button_continueshopping;

	@FindBy(xpath = "//a[contains(text(),'GeoWarehouse Store')]")
	public WebElementFacade tag_geowarehousestore;

	@FindBy(xpath = "//img[@name='purchaseMPAC567Button']")
	public WebElementFacade button_purchase_gwhresidential_detailed_report;

	@FindBy(xpath = "//td[@class='propertylist2']")
	public List<WebElement> text_propertylistdata;

	public static By PropertySearchResults() {
		return By.xpath("//iframe[@name='PropertySearchResults']");
	}

	public static By ProductDetailFrameID() {
		return By.xpath("//iframe[@id='ProductDetailFrameID']");
	}

	public static By paymentoptionsFrame() {
		return By.xpath("//iframe[@name='paymentoptionsFrame']");
	}

	public static By label_propertylistdata() {
		return By.xpath("//td[@class='propertylist2']");
	}

	@FindBy(xpath = "//div[@class='nonssearchwarning']//following::input[2]")
	public WebElementFacade radio_btn1;

	// Assessment Roll Number in ASSESSMENT PROPERTY INFORMATION(ARN)
	@FindBy(xpath = "//td[contains(text(),'Assessment Roll Number')]//following::td[54]")
	public WebElementFacade ARN;

	// reports viewed count in GWH
	@FindBy(xpath = "//div[@id='repViewed']")
	public WebElementFacade reports_viewed_count_gwh;

	// --SAP_InstrumentImage

	@FindBy(xpath = "//a[contains(text(),'Purchase Image')]")
	public WebElementFacade purchase_Image;

	// --parcel register active
	@FindBy(xpath = "//a[@title='SearchÂ mortgages, liens, transfers, easements, and other registrations on title']")
	public WebElementFacade parcel_register;

	// -----earlybird license renewal
	@FindBy(xpath = "//input[@name='counterSubscribeEndDate']")
	public WebElementFacade name_counterSubscribeEndDate;

	@FindBy(xpath = " //input[contains(@name,'firstName')and not(@disabled='true')]")
	public WebElementFacade FirstName;

	@FindBy(id = "price")
	public WebElementFacade renewal_price;

	@FindBy(id = "cutoffDays")
	public WebElementFacade renewal_cutoff;

	@FindBy(id = "counterMaxLimit")
	public WebElementFacade reports_viewed;

	@FindBy(id = "licenseNumMonths")
	public WebElementFacade License_months;

	@FindBy(xpath = "//select[@name='licenseType']")
	public WebElementFacade License_type;

	@FindBy(xpath = "//a[@id='geowarehousestore']") //// img[@src='/gwhweb/images/Store_tag_top.png']
	public WebElementFacade store_button;

	@FindBy(id = "itemprice")
	public WebElementFacade item_price;

	@FindBy(id = "promoStartDays")
	public WebElementFacade early_renewalstart;

	@FindBy(id = "promoEndDays")
	public WebElementFacade early_renewalcutoff;

	@FindBy(xpath = "//td[contains(text(),'Offer valid until:')]//following::td[1]")
	public WebElementFacade offervaliditydate;

	@FindBy(id = "purchaseHVButton")
	public WebElementFacade purchaseHvbutton;

	@FindBy(xpath = "//span[contains(text(),'$3,000 - Early Bird Special!')]")
	public WebElementFacade subscriptionprice_RI;

	@FindBy(xpath = "//td[contains(text(),'Offer valid until:')]//following::td[3]")
	public WebElementFacade new_SSD;

	@FindBy(xpath = "//td[contains(text(),'Offer valid until:')]//following::td[5]")
	public WebElementFacade new_SED;

	@FindBy(xpath = "//td[contains(text(),'Offer valid until:')]//following::td[7]")
	public WebElementFacade SubscriptionPeriodReports;

	@FindBy(xpath = "//input[@id='checkBoxAgreeLegal2']")
	public WebElementFacade confirmationCheckbox2;

	@FindBy(xpath = "//tr[5]//td[1]//table[1]//tbody[1]//tr[1]//td[2]")
	public WebElementFacade confirmation_text;

	@FindBy(xpath = "//td[contains(text(),'Transaction ID:')]//following::td[1]")
	public WebElementFacade transactionId;

	@FindBy(xpath = "//a[@id='mygeowarehouse']")
	public WebElementFacade mygeowarehouse;

	@FindBy(xpath = "//a[contains(text(),'Transaction History')]")
	public WebElementFacade transactionhistory;

	@FindBy(id = "fixedRangeRadio")
	public WebElementFacade daterange;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade search;

	@FindBy(xpath = "//body//div[@id='myGWH_trans_divwrapper']//tr//tr[1]//td[4]")
	public WebElementFacade transactionNumber;

	@FindBy(xpath = "//span[contains(text(),'$3,500')]")
	public WebElementFacade full_price;

	@FindBy(xpath = "//input[@name='reportsPurchased']")
	public WebElementFacade reports_purchased;

	@FindBy(xpath = "//tr[4]//td[1]//table[1]//tbody[1]//tr[1]//td[2]")
	public WebElementFacade confirmation_text2;

	@FindBy(xpath = "//input[@id='checkBoxAgreeLegal1']")
	public WebElementFacade confirmationCheckbox1;

	@FindBy(xpath = "//td[@class='product_detail_table_data']//td[2]")
	public WebElementFacade confirmation_text_geo;

	// ---RegularPrice License REnewal
	@FindBy(xpath = "//td[contains(text(),'Subscription Start Date:')]//following::td[1]")
	public WebElementFacade new_SSDRP;

	@FindBy(xpath = "//td[contains(text(),'Subscription Start Date:')]//following::td[3]")
	public WebElementFacade new_SEDRP;

	@FindBy(xpath = "//td[contains(text(),'Subscription Price:')]//following::td[1]")
	public WebElementFacade subscriptionpriceRP_RI;

	@FindBy(xpath = "//td[contains(text(),'Subscription Start Date:')]//following::td[5]")
	public WebElementFacade SubscriptionPeriodReports_RP;

	// ----sapMPac reports
	@FindBy(xpath = "//input[@name='counterSubscribeEndDate']")
	public WebElementFacade counterSubscribeEndDate;

	@FindBy(xpath = "//input[@value='Update']")
	public WebElementFacade update_button;

	@FindBy(xpath = "//a[contains(text(),'GeoWarehouse Store')]")
	public WebElementFacade Geowarehouse_store;

	@FindBy(xpath = "//img[@id='purchasePRButton']")
	public WebElementFacade purchase_button;

	@FindBy(xpath = "//input[@id='productConfig']")
	public WebElementFacade agreementCheckbox;

	@FindBy(xpath = "//input[@id='directCheckoutButton']")
	public WebElementFacade DirectCheckoutButton;
	@FindBy(xpath = "// div[@id='gwhstreetview_overlay_div']")
	public WebElementFacade streetview_overlay;

	@FindBy(xpath = "//span[contains(text(),'STREET VIEW')]") //// a[@title='Street View.']
	public WebElementFacade streetview_button;

	@FindBy(xpath = "//a[contains(text(),'View Property Details')]")
	public WebElementFacade property_details;

	@FindBy(xpath = "//span[contains(text(),'Sorry. No street view')]")
	public WebElementFacade streetview_property;

	@FindBy(xpath = "//a[contains(text(),'Property Details')]")
	public WebElementFacade propertyDetails;

	@FindBy(xpath = "//input[@name='cardholderName']")
	public WebElementFacade name_on_card;

	@FindBy(xpath = "//input[@id='monerisDataInput']")
	public WebElementFacade number_on_card;

	@FindBy(xpath = "//input[@id='monerisExpInput']")
	public WebElementFacade expirydate_on_card;

	@FindBy(xpath = "//input[@id='monerisCVDInput']")
	public WebElementFacade securitycode_on_card;

	@FindBy(id = "finalizeOrder")
	public WebElementFacade finalize_order_link;
}
