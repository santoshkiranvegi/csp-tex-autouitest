package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends BasePage {

	public WebElementFacade property_tab(String tabName) {
		return findBy("//a[@href='#' and contains(.,'" + tabName + "')]");
	}

	@FindBy(xpath = "//a[@id='icon-1']")
	public WebElementFacade link_searchName;

	@FindBy(xpath = "//a[@id='icon-2']")
	public WebElementFacade link_searchProperty;

	@FindBy(xpath = "//a[@id='icon-3']")
	public WebElementFacade link_documentView;

	@FindBy(xpath = "//a[@id='icon-4']")
	public WebElementFacade link_searchWrits;

	@FindBy(xpath = "//a[@id='icon-5']")
	public WebElementFacade link_OWL;

	@FindBy(xpath = "//a[@id='icon-6']")
	public WebElementFacade link_writFiling;

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

	@FindBy(xpath = "//input[@id='requestBy']")
	public WebElementFacade input_requestBy;

	@FindBy(xpath = "//input[@id='reference']")
	public WebElementFacade input_reference;

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

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

	// Property search By Name
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElementFacade input_givenName;

	@FindBy(xpath = "//input[@id='surName']")
	public WebElementFacade input_surNameOrCompanyName;

	// Document View
	@FindBy(xpath = "//input[@id='instrumentNumber']")
	public WebElementFacade input_instrumentNumber;

	@FindBy(xpath = "//a[@href='/csp/courier/init']")
	public WebElementFacade link_courierRequest;

	// Writs search by name and OWL
	@FindBy(xpath = "//select[@id='enforcementOffice']")
	public WebElementFacade select_EO;

	public WebElementFacade select_EO_options(int optionNo) {
		return findBy("//select[@id='enforcementOffice']/option[" + (optionNo + 1) + "']");
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

	// Writs search by number
	public WebElementFacade input_writNumber(int numberNo) {
		return findBy("//input[@name='execNumbers[" + (numberNo - 1) + "]']");
	}

	// ============== negative ==================================
	// error message sometimes /span, sometimes /div, so get parent object here
	// except document view/owl/courier
	@FindBy(xpath = "//div[@id='errorSection']")
	public WebElementFacade page_errorMessage;

	// document/owl
	// @FindBy(xpath = "//div[@class='error']")
	@FindBy(xpath = "//*[@class='error' or contains(@id,'errors')]")
	public WebElementFacade page_errorMsg1_common;

	// // document specific
	// @FindBy(xpath = "//span[@id='doc.errors']")
	// public WebElementFacade page_errorMsg2_docView;
	//
	// // owl specific
	// @FindBy(xpath = "//span[@id='reference.errors']")
	// public WebElementFacade page_errorMsg2_owl;
}
