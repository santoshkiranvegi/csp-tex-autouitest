package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchChargeTermsAndAgreementPage extends BasePage {

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='endDate']")
	public WebElementFacade EndDate_WebEdit;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebElement;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='number']")
	public WebElementFacade FileNumber_WebEdit;

	@FindBy(xpath = "//input[@id='criteriaView.firstName']")
	public WebElementFacade GivenName_WebEdit;

	@FindBy(xpath = "//td[contains(text(),'Standard Charge Terms Selection Criteria')]")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//input[@id='criteriaView.lastName']")
	public WebElementFacade LastName_WebEdit;

	@FindBy(xpath = "//TD[2]/INPUT[1]")
	public WebElementFacade PrintReport_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='Search Standard Charge Terms By Date Results']")
	public WebElementFacade ResultsHeader_WebElement;

	@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='File NumberFile DateParty FromTotal Pages SCT12008/12/05 SMITH, JOHN 7']")
	public WebElementFacade ResultsTable_WebTable;

	@FindBy(xpath = "//INPUT[@id='searchNumber']")
	public WebElementFacade SearchByNumber_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='searchName']")
	public WebElementFacade SearchByName_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='searchDate']")
	public WebElementFacade SearchByDate_WebRadioGroup;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//INPUT[@id='sortName']")
	public WebElementFacade SortByName_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='sortDate']")
	public WebElementFacade SortByDate_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='sortNumber']")
	public WebElementFacade SortByNumber_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='startDate']")
	public WebElementFacade StartDate_WebEdit;

}
