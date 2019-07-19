package ca.teranet.pages.rosco;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends BasePage {

	// Name/Address/PIN/Instrument/PIN Range
	public WebElementFacade property_tab(String tabName) {
		return findBy("//a[@href='#' and contains(.,'" + tabName + "')]");
	}

	@FindBy(xpath = "//a[@id='icon-1']")
	public WebElementFacade link_searchPropertyViewMap;

	@FindBy(xpath = "//a[@id='icon-2']")
	public WebElementFacade link_documentView;

	@FindBy(xpath = "//a[@id='icon-3']")
	public WebElementFacade link_searchWrits;

	@FindBy(xpath = "//a[@id='icon-4']")
	public WebElementFacade link_browseMap;

	@FindBy(xpath = "//a[@id='icon-5']")
	public WebElementFacade link_cashPayments;

	@FindBy(xpath = "//select[@id='lro']")
	public WebElementFacade select_LRO;

	public WebElementFacade select_LRO_options(int optionNo) {
		return findBy("//select[@id='lro']/option[@value='" + (optionNo + 1) + "']");
	}

	// public input
	@FindBy(xpath = "//input[@id='fromDate']")
	public WebElementFacade input_date_from;

	@FindBy(xpath = "//input[@id='toDate']")
	public WebElementFacade input_date_to;

	// can't using id, browse map page different
	@FindBy(xpath = "//input[@name='requestBy']")
	public WebElementFacade input_requestBy;

	@FindBy(xpath = "//input[contains(@id,'btn-submit')]")
	public WebElementFacade button_submit;

	// Property search By Name
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElementFacade input_givenName;

	@FindBy(xpath = "//input[@id='surName']")
	public WebElementFacade input_surNameOrCompanyName;

	// Property search by Address
	@FindBy(xpath = "//input[@id='streetNumber']")
	public WebElementFacade input_streetNumber;

	@FindBy(xpath = "//input[@id='streetSuffix']")
	public WebElementFacade input_Suffix;

	@FindBy(xpath = "//input[@id='streetName']")
	public WebElementFacade input_streetName;

	@FindBy(xpath = "//input[@id='unitType']")
	public WebElementFacade input_unitType;

	@FindBy(xpath = "//input[@id='unitNo']")
	public WebElementFacade input_unitNumber;

	// Property search by PIN
	@FindBy(xpath = "//input[@id='pin']")
	public WebElementFacade input_pin1;

	@FindBy(xpath = "//input[@id='pin1']")
	public WebElementFacade input_pin2;

	// Property search by Instrument
	@FindBy(xpath = "//input[@id='instrumentNo']")
	public WebElementFacade input_instrumentNo;

	// Property search by PIN Range/browse map/block
	@FindBy(xpath = "//input[@id='block']")
	public WebElementFacade input_block;

	@FindBy(xpath = "//input[@id='fromPin']")
	public WebElementFacade input_fromPin;

	@FindBy(xpath = "//input[@id='toPin']")
	public WebElementFacade input_toPin;

	// Document View
	@FindBy(xpath = "//input[@id='instrumentNo' or @id='instrumentNumber']")
	public WebElementFacade input_instrumentNumber;

	// Writs public
	@FindBy(xpath = "//select[@id='enforcementOffice']")
	public WebElementFacade select_EO;

	public WebElementFacade select_EO_options(int optionNo) {
		return findBy("//select[@id='enforcementOffice']/option[" + (optionNo + 1) + "']");
	}

	@FindBy(xpath = "//input[@name='SelectAll']")
	public WebElementFacade checkbox_selectAll;

	// Writs search by name, select id begin from 0
	public WebElementFacade checkbox_select(int nameNo) {
		return findBy("//input[@id='Select['" + (nameNo - 1) + "']");
	}

	public WebElementFacade radioButton_person(int nameNo) {
		return findBy("//input[@name='names[" + (nameNo - 1) + "].type' and @value='P']");
	}

	public WebElementFacade radioButton_company(int nameNo) {
		return findBy("//input[@name='names[" + (nameNo - 1) + "].type' and @value='C']");
	}

	public WebElementFacade input_writGivenName(int nameNo) {
		return findBy("//input[@name='names[" + (nameNo - 1) + "].firstName']");
	}

	public WebElementFacade input_writSurName(int nameNo) {
		return findBy("//input[@name='names[" + (nameNo - 1) + "].lastName']");
	}

	public WebElementFacade input_writCompanyName(int nameNo) {
		return findBy("//input[@name='names[" + (nameNo - 1) + "].companyName']");
	}

	@FindBy(xpath = "//input[contains(@id,'btn-add')]")
	public WebElementFacade button_add;

	@FindBy(xpath = "//input[contains(@id,'btn-delete')]")
	public WebElementFacade button_delete;

	// Writs search by number
	public WebElementFacade input_writNumber(int numberNo) {
		return findBy("//input[@name='execNumbers[" + (numberNo - 1) + "]']");
	}

	// browse map
	@FindBy(xpath = "//select[@id='area']")
	public WebElementFacade select_area;

	// Select one or more of the following names:
	// Select one of the following PINs:
	@FindBy(xpath = "//h3")
	public WebElementFacade instruction_select;

	// ============== negative ==================================
	// error message sometimes /span, sometimes /div, so get parent object here
	// login page
	@FindBy(xpath = "//div[@class='error']")
	public WebElementFacade login_errorMessage;

	// property search/ writs search/ browse map
	@FindBy(xpath = "//div[@id='errorSection']")
	public WebElementFacade page_errorMessage;

	@FindBy(xpath = "(//*[@class='error' or contains(@id,'errors')])[2]")
	public WebElementFacade page_errorMsg1_common;
}
