package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentDetailPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='addRemovePinForm.pinToAdd.block']")
	public WebElementFacade AddBlock_WebEdit;

	@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD[normalize-space()='- 16909-0139 (LT) 16909-0140 (R) 1 of 1']/INPUT[4]")
	public WebElementFacade AddHWY_WebButton;

	@FindBy(xpath = "//input[@value='Add PIN']")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='addRemovePinForm.pinToAdd.property']")
	public WebElementFacade AddPIN_WebEdit;

	@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD[normalize-space()='- Highways Register TransCanada Pipeline 1 of 1']/INPUT[5]")
	public WebElementFacade AddTCPL_WebButton;

	@FindBy(xpath = "//INPUT[@id='submitCancel']")
	public WebElementFacade CancelRecording_WebButton;

	@FindBy(xpath = "//INPUT[contains(@value,'Cancel')]")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//A[@id='carryFwdPINsTab']")
	public WebElementFacade CarryFwdPINs_Link;

	@FindBy(xpath = "//input[@value='Close']")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//A[@id='correctionNoticesTab']")
	public WebElementFacade CorrectionNotices_Link;

	@FindBy(xpath = "//input[@value='Defer']")
	public WebElementFacade Defer_WebButton;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='Description:']")
	public WebElementFacade Description_WebElement;

	@FindBy(xpath = "//TABLE[@id='pinLinks']")
	public WebElementFacade DocPINList_WebTable;

	@FindBy(xpath = "//A[@id='documentDataTab']")
	public WebElementFacade DocumentData_Link;

	@FindBy(xpath = "//*[@id='regSummaryFrame']")
	public WebElementFacade DocumentInfo_WebTable;

	@FindBy(xpath = "//TABLE[@id='DocView']")
	public WebElementFacade DocumentInfo_WebTable1;

	@FindBy(xpath = "//TD[@id='documentTypeCol']")
	public WebElementFacade DocumentType_WebElement;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[1]")
	public WebElementFacade First_WebButton;

	@FindBy(xpath = "//input[@value='Go to Page']")
	public WebElementFacade GotoPage_WebButton;

	@FindBy(xpath = "//TABLE[@id='headingBar']")
	public WebElementFacade Heading_WebTable;

	@FindBy(xpath = "//A[@id='highwayPiplelineTab']")
	public WebElementFacade HighwayPipeline_Link;

	@FindBy(xpath = "//INPUT[@id='retrieveDocumentImage']")
	public WebElementFacade Image_WebButton;

	@FindBy(xpath = "//TD[@id='manualLRI']")
	public WebElementFacade LRIValue_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[4]")
	public WebElementFacade Last_WebButton;

	@FindBy(xpath = "//TD[@id='manualNDI']")
	public WebElementFacade NDIValue_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[3]")
	public WebElementFacade Next_WebButton;

	@FindBy(xpath = "//TABLE[@id='owners']")
	public WebElementFacade Owners_WebTable;

	@FindBy(xpath = "//A[@id='pinDetailsTab']")
	public WebElementFacade PINDetails_Link;

	@FindBy(xpath = "//INPUT[@id='gotoPageValue']")
	public WebElementFacade PageValue_WebEdit;

	@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR[2]/TD/TABLE/tbody/tr[1]/td[1]")
	public WebElementFacade Paging_WebTable;

	@FindBy(xpath = "//A[@id='partiesTab']")
	public WebElementFacade Parties_Link;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[2]")
	public WebElementFacade Previous_WebButton;

	@FindBy(xpath = "//input[@value='Proceed with Receipt']")
	public WebElementFacade ProceedWithReceipt_WebButton;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//A[@id='outstandingTab']")
	public WebElementFacade PropertyRemarks_Link;

	@FindBy(xpath = "//input[@value='Remove PIN(s)']")
	public WebElementFacade RemovePIN_WebButton;

	@FindBy(xpath = "//TD[6]/INPUT[1]")
	public WebElementFacade ReturnForCorrection_WebButton;

	@FindBy(xpath = "//TD[2]/INPUT[1]")
	public WebElementFacade Save_WebButton;

	@FindBy(xpath = "//A[@id='summaryTab']")
	public WebElementFacade Summary_Link;

	@FindBy(xpath = "//input[@value='Certify']")
	public WebElementFacade Certify_WebButton;

	@FindBy(xpath = "//input[contains(@value,'Complete Recording')]")
	public WebElementFacade CompleteRecording_WebButton;

	@FindBy(xpath = "//a[@id='partiesTab']")
	public WebElementFacade Navigate_parties;

	@FindBy(xpath = "//input[@value='Go to Page']/../../../tr[1]/td/span")
	public WebElementFacade Paging_WebTable1;

	@FindBy(xpath = "//INPUT[@value='Modify Header']")
	public WebElementFacade Modify_Header;

	@FindBy(xpath = "//input[@id='uncertDocFoundReviewed1']")
	public WebElementFacade PriorUncertifiedDocument_ChechBox;

	@FindBy(xpath = "//a[@id='pinDetailsTab']")
	public WebElementFacade Navigate_pindetails;

	@FindBy(xpath = "//input[@value='Complete Recording']")
	public WebElementFacade CompleteRecording_webbutton;

	@FindBy(xpath = "//span[@id='fullBuiltDescription0']")
	public WebElementFacade PINDetails_Description;
}
