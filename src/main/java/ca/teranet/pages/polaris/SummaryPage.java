package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SummaryPage extends BasePage {

	@FindBy(xpath = "//TR[normalize-space()='Add New Easements 2 No Yes']/TD[3]/INPUT[1]")
	public WebElementFacade AddNewEasements_WebRadioGroup;

	@FindBy(xpath = "//SPAN[@id='ExpiryDateRO']")
	public WebElementFacade ExpiryDate_WebElement;

	@FindBy(xpath = "//TD[normalize-space()='OK to Proceed']/INPUT[1]")
	public WebElementFacade ManualNDI_WebCheckBox;

	@FindBy(xpath = "//TABLE[@id='restrictionsTable']/TBODY/TR/TD[normalize-space()='OK to Proceed']/INPUT[1]")
	public WebElementFacade NDIRestriction_WebCheckBox;

	@FindBy(xpath = "//TABLE[@id='partListingInfoSummaryTable']")
	public WebElementFacade PINListingSummary_WebTable;

	@FindBy(xpath = "//TR/TD/TABLE/TBODY[normalize-space()='PHILLPOTTS, EWART GEORGE']/TR[1]/TD[1]")
	public WebElementFacade PartyFrom1_WebElement;

	@FindBy(xpath = "//TR/TD/TABLE/TBODY[normalize-space()='PHILLPOTTS, BARBARA CLAUDETTE']/TR[1]/TD[1]")
	public WebElementFacade PartyFrom2_WebElement;

	@FindBy(xpath = "//DIV[@id='summaryContent']/P[2]/INPUT[1]")
	public WebElementFacade RefreshSummaryInformation_WebButton;

	@FindBy(xpath = "//TR[normalize-space()='Replace Owners 1 No Yes']/TD[3]/INPUT[1]")
	public WebElementFacade ReplaceOwners_WebRadioGroup;

	@FindBy(xpath = "//TABLE[@id='uncertDoc']/TBODY/TR/TD/FONT[normalize-space()='Prior Uncertified Document(s) Found: OK to Proceed']/INPUT[1]")
	public WebElementFacade UncertDocFoundReviewed_WebCheckBox;

	@FindBy(xpath = "//input[@id='certOption1_0']")
	public WebElementFacade AddNewEasementsNO_WebRadioGroup;

	@FindBy(xpath = "//input[@id='certOption1_1']")
	public WebElementFacade AddNewEasementsYES_WebRadioGroup;

	@FindBy(xpath = "//input[@id='certOption0_0']")
	public WebElementFacade ReplaceOwnersNO_WebRadioGroup;

	@FindBy(xpath = "//input[@id='certOption0_1']")
	public WebElementFacade ReplaceOwnersYES_WebRadioGroup;

}
