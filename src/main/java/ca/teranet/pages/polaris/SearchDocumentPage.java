package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchDocumentPage extends BasePage {

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[11]/TBODY[1]/TR[1]/TD[3]/P[1]/INPUT[1]")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//TABLE[@id='CommonAttribsTable']")
	public WebElementFacade CommonAttribsTable_WebTable;

	@FindBy(xpath = "//TABLE[@id='CorrectionNotices']")
	public WebElementFacade CorrectionNotices_WebTable;

	@FindBy(xpath = "//TABLE[@id='DocView']")
	public WebElementFacade DocumentViewHeader_WebTable;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TABLE[@id='FeesTable']")
	public WebElementFacade FeesTable_WebTable;

	@FindBy(xpath = "//TABLE[@id='DocumentRemarksTable']")
	public WebElementFacade GeneralDocumentRemark_WebTable;

	@FindBy(xpath = "//FORM[1]/P[1]/SPAN[1]")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//TABLE[11]/TBODY[1]/TR[1]/TD[4]/INPUT[1]")
	public WebElementFacade Image_WebButton;

	@FindBy(xpath = "//TABLE[@id='ProcessingNotesTable']")
	public WebElementFacade InternalProcessingNotes_WebTable;

	@FindBy(xpath = "//TABLE[@id='PartyFromTable']")
	public WebElementFacade PartyFrom_WebTable;

	@FindBy(xpath = "//TABLE[@id='PartyToTable']")
	public WebElementFacade PartyTo_WebTable;

	@FindBy(xpath = "//TABLE[11]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade Print_WebButton;

	@FindBy(xpath = "//TABLE[@id='DocStatOnPINsTable']")
	public WebElementFacade PropertiesAffectedAtRegistration_WebTable;

	@FindBy(xpath = "//TABLE[@id='DocStatOnAffPINs']")
	public WebElementFacade PropertiesAffectedSubsequently_WebTable;

	@FindBy(xpath = "//INPUT[@id='documentViewSearch.docNumber']")
	public WebElementFacade RegNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@value='Search']")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//TABLE[@id='PartyFromAndPartyTo']/TBODY/TR/TD[normalize-space()='Name POLARIS OWNER']/TABLE[2]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllPartiesFrom_WebButton;

	@FindBy(xpath = "//TABLE[@id='PartyFromAndPartyTo']/TBODY/TR/TD[normalize-space()='NameCapacityShare OWNER1 OWNER2 GENERAL PARTNER OWNER3 10% OWNER4 FIRM NAME 20% OWNER5 JOINT ACCOUNT 30% OWNER6 OFFICIAL GUARDIAN 25%']/TABLE[2]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllPartiesTo_WebButton;

	@FindBy(xpath = "//TABLE[@id='PINsTable']/TBODY/TR/TD[normalize-space()='PIN PIN Status Deleted Description PIN Specific Remarks 16912-0867 (LT) Active No CREATE LAND TITLES PIN SUBJECT TO AN EASEMENT AS IN 1234567890 CITY OF HAMILTON DOCUMENT REMARKS 16912-0870 (LT) Active Yes Please see document for description. NEW EASEMENT ONLY Highways Register Active No HIGHWAYS REGISTER TransCanada Pipeline Active No TRANSCANADA PIPELINE INDEX']/TABLE[2]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllTargetRegisters_WebButton;

	@FindBy(xpath = "//TABLE[@id='PINsAffSub']/TBODY/TR/TD[normalize-space()='PIN PIN Status Deleted Description PIN Specific Remarks']/TABLE[2]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade ViewallRegistersSubsequentlyAffected_WebButton;

}
