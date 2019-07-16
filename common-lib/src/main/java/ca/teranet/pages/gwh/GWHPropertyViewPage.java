package ca.teranet.pages.gwh;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GWHPropertyViewPage extends WebTablePage {

	// SEARCHBY: Label
	@FindBy(xpath = "//a[@id='SEARCH_BY_ADDRESS']/../../li[text()='SEARCH BY:']")
	public WebElementFacade label_searchBy;

	// searchByType - Link
	public WebElementFacade link_searchType(String searchType) {
		return findBy("//li[text()='SEARCH BY:']/ancestor::ul//li//a[contains(text(),'" + searchType + "')]");
	}

	// SEARCHBY_ADDRESS: Label
	@FindBy(xpath = "//li[text()='SEARCH BY:']/ancestor::ul//li/a[@id='SEARCH_BY_ADDRESS']")
	public WebElementFacade label_searchbyaddress;

	// SEARCHBY_ADDRESS_RANGE:Label
	@FindBy(xpath = "//li[text()='SEARCH BY:']/ancestor::ul//li/a[@id='SEARCH_BY_ADDRESS_RANGE']")
	public WebElementFacade label_searchbyaddressrange;

	// SEARCHBY_NAME:Label
	@FindBy(xpath = "// li[text()='SEARCH BY:']/ancestor::ul//li//a[@id='SEARCH_BY_NAME']")
	public WebElementFacade label_searchbyname;

	// SEARCHBY_PIN:Label
	@FindBy(xpath = "//li[text()='SEARCH BY:']/ancestor::ul//li//a[@id='SEARCH_BY_PIN']")
	public WebElementFacade label_searchbypin;

	// SEARCHBY_INSTRUMENT/PLAN:Label
	@FindBy(xpath = "// li[text()='SEARCH BY:']/ancestor::ul//li//a[@id='SEARCH_BY_INSTRUMENT']")
	public WebElementFacade label_searchbyinstrument;

	// SEARCHBY_LOT:Label
	@FindBy(xpath = "//li[text()='SEARCH BY:']/ancestor::ul//li//a[@id='SEARCH_BY_LOT']")
	public WebElementFacade label_searchbylot;

	// SEARCHBY_ARN:Label
	@FindBy(xpath = "// li[text()='SEARCH BY:']/ancestor::ul//li//a[@id='SEARCH_BY_ARN']")
	public WebElementFacade label_searchbyarn;

	// SEARCHFORM_HEADERROW:
	@FindBy(xpath = "//table[@id='searchform']//form[@name='propertySearchForm']/table[@id='frmtbl']/tbody/tr[1]")
	public WebElementFacade searchformheaderrow;

	// SEARCHFORM_VALUESROW:
	@FindBy(xpath = "//table[@id='searchform']//form[@name='propertySearchForm']/table[@id='frmtbl']/tbody/tr[2]")
	public WebElementFacade searchformvaluesrow;

	// SEARCHFORM: Table
	@FindBy(xpath = "//table[@id='searchform']//form[@name='propertySearchForm']/table[@id='frmtbl']")
	public WebElementFacade searchformtable;

	// Inputpostalcode: Input
	@FindBy(xpath = "//input[@type='text' and @name='postalCode']")
	public WebElementFacade inputpostalCode;

	// Selectlro: selecttype
	@FindBy(xpath = "//select[@name='lro' and@id='lro']")
	public WebElementFacade selectLRO;

	// Inputstreetnumberfrom: Input
	@FindBy(xpath = "//input[@type='text' and @name='streetNumberFrom']")
	public WebElementFacade inputStreetNumberFrom;

	// Inputstreetnumberto: Input
	@FindBy(xpath = "//input[@type='text' and @name='streetNumberTo']")
	public WebElementFacade inputStreetNumberTo;

	// Inputstreetnum: Input
	@FindBy(xpath = "//input[@type='text' and @name='streetNumber']")
	public WebElementFacade inputStreetNumber;

	// SEARCHFORM: Table
	@FindBy(xpath = "//input[@type='text' and @name='streetName']")
	public WebElementFacade inputStreetName;

	// SEARCHFORM: Table
	@FindBy(xpath = "//input[@type='text' and @name='unitNo']")
	public WebElementFacade inputSuiteNumber;

	// InputFirstName: Input
	@FindBy(xpath = "//input[@class='srchtextin' and @name='firstName']")
	public WebElementFacade inputfirstname;

	// InputLastName: Lastname
	@FindBy(xpath = "//input[@class='srchtextin' and @name='lastOrCompName']")
	public WebElementFacade inputlastorcompname;

	// SEARCHBUTTON: button
	@FindBy(xpath = "//input[@id='processSearchButton']")
	public WebElementFacade buttonSearch;

	// LinkPropertyDetails - Search Result
	@FindBy(xpath = "//table[@class='piisummarybox']//a[contains(text(), 'Property Details')]")
	public WebElementFacade searchresultpropertydetailslink;

	// Errormessage: console
	@FindBy(xpath = "//div[contains(@style,'display: block')]/child::span[starts-with(@id,'errorConsole')]")
	public WebElementFacade errormsgsearchResult;

	// ResultTitle: Title
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade resultTitle;

	// searchrowxpath
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade searchResultRowName;

	// SearchresultsbyAddressrange - No Match
	@FindBy(xpath = "//div[@id='searchresultcont']/div[@id='suggestion']")
	public WebElementFacade searchresultsbyAddressrange_Displaymessage;

	// SearchByLink
	public WebElementFacade searchByType(String searchtype) {
		return findBy("//li[text()='SEARCH BY:']/ancestor::ul//li//a[contains(text(),'" + searchtype + "')]");
	}

	// List of Webelements
	public WebElementFacade getElements(String xpath) {
		return findBy(xpath);

	}

}
