package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertyDetailPage extends BasePage {

	@FindBy(xpath = "//TABLE[@id='hostMainPageTable']/TBODY[1]/TR[1]/TD[1]/FIELDSET[1]/DIV[1]/IMG[3]")
	public WebElementFacade ActiveArrow_Image;

	@FindBy(xpath = "//TABLE[@id='hostMainPageTable']/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
	public WebElementFacade AddRemnant_WebButton;

	@FindBy(xpath = "//TD[1]/INPUT[1]")
	public WebElementFacade Apply_WebButton;

	@FindBy(xpath = "//TABLE[@id='propertyDetailsButtonsTable']/TBODY[1]/TR[1]/TD[1]/INPUT[2]")
	public WebElementFacade BulkEdit_WebButton;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//A[@id='correctionNoticesTab']")
	public WebElementFacade CorrectionNotices_Link;

	@FindBy(xpath = "//A[@id='descriptionTab']")
	public WebElementFacade Description_Link;

	@FindBy(xpath = "//A[@id='bulkDescriptionTab']")
	public WebElementFacade Description_bulk_Link;

	@FindBy(xpath = "//TD[3]/INPUT[1]")
	public WebElementFacade DoNotApply_WebButton;

	@FindBy(xpath = "//A[@id='documentsTab']")
	public WebElementFacade Documents_Link;

	@FindBy(xpath = "//A[@id='bulkDocumentsTab']")
	public WebElementFacade Documents_bulk_Link;

	@FindBy(xpath = "//TABLE[@id='propertyDetailsButtonsTable']/TBODY/TR/TD[normalize-space()='Saving changes...']/INPUT[3]")
	public WebElementFacade EditOwnersMasterList_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[1]")
	public WebElementFacade First_WebButton;

	@FindBy(xpath = "//FORM[@id='divideSplitPropertyDetailsForm']")
	public WebElementFacade FullDetails_WebElement;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade GotoPage_WebButton;

	@FindBy(xpath = "//A[@id='bulkInternalNotesTab']")
	public WebElementFacade InternalPINNotes_bulk_Link;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 2']/INPUT[4]")
	public WebElementFacade Last_WebButton;

	@FindBy(xpath = "//A[@id='managersTab']")
	public WebElementFacade Managers_Link;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 2']/INPUT[3]")
	public WebElementFacade Next_WebButton;

	@FindBy(xpath = "//A[@id='ownersTab']")
	public WebElementFacade Owners_Link;

	@FindBy(xpath = "//A[@id='bulkOwnersTab']")
	public WebElementFacade Owners_bulk_Link;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[2]")
	public WebElementFacade PageValue_WebEdit;

	@FindBy(xpath = "//TABLE[@id='hostMainPageTable']/TBODY[1]/TR[1]/TD[1]/TABLE[1]")
	public WebElementFacade Paging_WebTable;

	@FindBy(xpath = "//div[@id='startCorrectPropertyELRSForm.errors']")
	public WebElementFacade ParentPINHeader_WebElement;

	@FindBy(xpath = "//table[@id='messages']//following::span[1]")
	public WebElementFacade ParentPIN_WebElement;

	@FindBy(xpath = "//A[@id='pendingBulkEditsTab']")
	public WebElementFacade PendingBulkEdits_bulk_Link;

	@FindBy(xpath = "//TR/TD[normalize-space()='1 of 3']/INPUT[2]")
	public WebElementFacade Previous_WebButton;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//TABLE[@id='hostMainPageTable']")
	public WebElementFacade PropertiesPINList_WebTable;

	@FindBy(xpath = "//A[@id='remarksTab']")
	public WebElementFacade PropertyRemarks_Link;

	@FindBy(xpath = "//A[@id='bulkRemarksTab']")
	public WebElementFacade PropertyRemarks_bulk_Link;

	@FindBy(xpath = "//TR/TD[normalize-space()='Description Property Remarks Internal PIN Notes Description: Add Easement: CONDO PLAN - S/T AND T/W EASE CONDO PLAN - S/T EASE ONLY CONDO PLAN - T/W EASE ONLY S/T EASE - EXISTING S/T EASE - NO TIME LIMIT S/T EASE - TIME LIMITED S/T EASE FOR RE-ENTRY - NO TIME LIMIT S/T EASE FOR RE-ENTRY - TIME LIMITED S/T EASE IN GROSS - NO TIME LIMIT S/T EASE IN GROSS - TIME LIMITED T/W EASE - EXISTING T/W EASE - NO TIME LIMIT T/W EASE - TIME LIMITED WHOLE PIN S/T EASE AS IN WHOLE PIN S/T EASE IN GROSS AS IN Show built easement template here... Other Property Remarks Append Replace Internal PIN Notes Append Replace']/INPUT[3]")
	public WebElementFacade PropertyStatus_WebButton;

	@FindBy(xpath = "//INPUT[@id='correlationListButton']")
	public WebElementFacade PropertyXRefReport_WebButton;

	@FindBy(xpath = "//INPUT[@id='buttonRemoveSelectedRemnant']")
	public WebElementFacade RemoveRemnant_WebButton;

	@FindBy(xpath = "//FORM[1]/INPUT[7]")
	public WebElementFacade ReturnToConfirmation_WebButton;

	@FindBy(xpath = "//input[@value='Save']")
	public WebElementFacade Save_WebButton;

	@FindBy(xpath = "//input[@value='Single Edit']")
	public WebElementFacade SingleEdit_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='Update Certified Property Bulk Edit']")
	public WebElementFacade UpdateCertifiedPropertyBulk_Header_WebElement;

	@FindBy(xpath = "//span[@id='RegSysRO0']")
	public WebElementFacade Registrationsystem;

	@FindBy(xpath = "//INPUT[@value='Close']")
	public WebElementFacade Close_WebButton;

}
