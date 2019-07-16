package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FindPropertyPage extends BasePage {

	// Municipality text box
	@FindBy(xpath = "//label[text()='Municipality']/following-sibling::span/input[@id='gwt-debug-propSearch-lro']")
	public WebElementFacade municipality_Text_box;

	// Address text box
	@FindBy(xpath = "//label[text()='Search using']/following-sibling::span/input[@id='gwt-debug-propSearch-address']")
	public WebElementFacade address_Text_box;

	// Search button
	@FindBy(xpath = "//a[@id='btn_search']/span[text()='Search']")
	public WebElementFacade search_Button;

	// Registered owners Header
	@FindBy(xpath = "//th[@class='GKOWYUYDOC GKOWYUYDMC']")
	public WebElementFacade headerName;

	// Autosuggested list
	@FindBy(xpath = "(//span[@class='suggestion'])[1]")
	public WebElementFacade autosuggested_list;

	// Report dropdown
	@FindBy(xpath = "//select[@id='gwt-debug-propSearch-reportSelect']")
	public WebElementFacade reporttype_dropdown;

	// OK button in Confirmation pop-up
	@FindBy(xpath = "//a[@class='grey_button_sml']/span[contains(text(),'OK')]")
	public WebElementFacade ok_Button;

	// from date in confirmation popup
	@FindBy(xpath = "(//table[@class='nsConfirmRangePanel']//input[@class='gwt-DateBox'])[1]")
	public WebElementFacade fromDate;

	// to date in confirmation popup
	@FindBy(xpath = "(//table[@class='nsConfirmRangePanel']//input[@class='gwt-DateBox'])[2]")
	public WebElementFacade toDate;

	// Property selection with Active status
	@FindBy(xpath = "//td/div[text()='ACTIVE']")
	public WebElementFacade property_select;

	// Property selection with Pin
	public WebElementFacade searchResults_Pin_Number(String pinNumber) {
		return findBy("(//td[@class='GKOWYUYDHC GKOWYUYDJC']/div[text()='" + pinNumber + "'])[1]");
	}

	// search btn in popup
	@FindBy(xpath = "(//a[@class='grey_button_sml']/span[contains(text(),'Search')])[1]")
	public WebElementFacade searchBtnInPopUp;

	// set value range
	@FindBy(xpath = "//input[@name='nsValueCritera']/..//label[text()='Sale Value Range']")
	public WebElementFacade setValueRange;

	// from range
	@FindBy(xpath = "(//table[@class='nsConfirmRangePanel']//input)[3]")
	public WebElementFacade fromRange;

	// to range
	@FindBy(xpath = "(//table[@class='nsConfirmRangePanel']//input)[4]")
	public WebElementFacade toRange;

	// address details
	public WebElementFacade address_details_with_Active_Status(String addressDetails) {
		return findBy("//td/div[text()='ACTIVE']/../preceding-sibling::td[@class='GKOWYUYDHC GKOWYUYDJD GKOWYUYDKC']/div[text()='" + addressDetails + "']");
	}

	// view btn in popup
	@FindBy(xpath = "(//a[@class='grey_button_sml']/span[contains(text(),'View')])[1]")
	public WebElementFacade viewReportInPopUp;

	// Report page
	@FindBy(xpath = "//div[@id='title_bar']/h1/span")
	public WebElementFacade report_page_title;

	// Search Results
	@FindBy(xpath = "//table[@id='gwt-debug-propSearch-results']//tr[@class='GKOWYUYDIC']")
	public WebElementFacade search_results_list;

	// result first record
	@FindBy(xpath = "//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']")
	public WebElementFacade search_results_first_record;

	// Ok button in Confirmation page
	@FindBy(xpath = "//a[@class='grey_button_sml']/span[contains(text(),'OK')]")
	public WebElementFacade confirmation_OK_btn;

	// Cancel button in Confirmation page
	@FindBy(xpath = "//div[@align='center']//a[@class='grey_button_sml' ]/span[contains(text(),'Cancel')]")
	public WebElementFacade confirmation_Cancel_btn;

	// neighbourhood sales msg in popup
	@FindBy(xpath = "//span[@class='nsConfirmCountMessage']")
	public WebElementFacade neighbourhoodsalesmsg;

	// print button in Confirmation Page
	@FindBy(xpath = "//a[@class='grey_button_sml' and @id='PrintButton']")
	public WebElementFacade confirmation_print_btn;

	// Print report button
	@FindBy(xpath = "//a[@class='printButton']/span")
	public WebElementFacade Print_report_btn;

	// Print confirmation yes radio button
	@FindBy(xpath = "//label[text()='Yes']/../input")
	public WebElementFacade Confirmation_Yes_btn;

	// Print confirmation No radio button
	@FindBy(xpath = "//label[text()='No']/../input")
	public WebElementFacade Confirmation_No_btn;

	// text area
	@FindBy(xpath = "//textarea[@class='gwt-TextArea']")
	public WebElementFacade Text_Area;

	// No results found
	@FindBy(xpath = "//div[@class='gwt-Label report_h2']")
	public WebElementFacade No_Results_Found;

	// Property selection with Address
	public WebElementFacade searchResults_Address(String address) {
		return findBy("//div[contains(text(),'" + address + "')]");
	}

	// Address in confirmation window
	public WebElementFacade addressInConformationWindow(String address) {
		return findBy("//div[@class='reportConfirmDialog']//p/span[contains(text(),'" + address + "')]");
	}

	// property in report page
	@FindBy(xpath = "//div[@id='overview_data']//label[text()='Property']/../span")
	public WebElementFacade propertyName;

	// property type
	@FindBy(xpath = "//label[text()='Property Type']/../span")
	public WebElementFacade propertyType;

	// estimated Value
	@FindBy(xpath = "//span[@class='est_value_value est_value_color']")
	public WebElementFacade estimatedValue;

	// property selection with name
	public WebElementFacade searchResults_Name(String name) {
		return findBy("//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div[text()='" + name + "']");
	}

	// warning message in popup
	@FindBy(xpath = "//div[@class='reportConfirmDialog']//div[2]/p/span")
	public WebElementFacade warningMessage;

	// message estimated value
	@FindBy(xpath = "//div[@id='estimated_value']/..//span[@class='sectionText']")
	public WebElementFacade textInEstimatedValue;

	// owner name in report page
	@FindBy(xpath = "//div[@id='overview_data']//label[text()='Owner']/..//span")
	public WebElementFacade ownerName;

	// national provience drop down
	@FindBy(xpath = "//select[@id='gwt-debug-propSearch-regions']")
	public WebElementFacade selectNationalProvience;

	// address
	@FindBy(xpath = "//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div")
	public WebElementFacade addressInFinfProperty;

	// PIN in report page
	@FindBy(xpath = "//div[@id='overview_data']//label[text()='PIN']/../span")
	public WebElementFacade pinInReport;

	// email text box
	@FindBy(xpath = "//input[@class='gwt-TextBox text_medium']")
	public WebElementFacade email_text_box;

	// number of reports in confirmation popup
	@FindBy(xpath = "//div[@class='lenderRecentReports']/a")
	public WebElementFacade reportsInPopUp;

	// consideration value
	@FindBy(xpath = "//td[@class='GKOWYUYDO GKOWYUYDAB GKOWYUYDCC'][4]/div")
	public WebElementFacade considerationValue;

	// registration Date
	@FindBy(xpath = "//td[@class='GKOWYUYDO GKOWYUYDAB GKOWYUYDCC'][5]/div")
	public WebElementFacade registerationDate;

	// distance
	@FindBy(xpath = "//td[@class='GKOWYUYDO GKOWYUYDAB GKOWYUYDCC GKOWYUYDLB']/div")
	public WebElementFacade distance;

	// broker report count
	@FindBy(xpath = "//select[@class='gwt-ListBox reportTypeSelect text']/option[@value='feature.Broker_Report']")
	public WebElementFacade ReportsCount;

}
