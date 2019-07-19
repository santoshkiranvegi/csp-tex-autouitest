package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchRegisterPage extends BasePage {

	@FindBy(xpath = "//TD[@id='blankLine']/INPUT[1]")
	public WebElementFacade BlankLineNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@id='blockTextField']")
	public WebElementFacade Block_WebEdit;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='Certified By UserG62 2013/01/08']")
	public WebElementFacade CertifiedBy_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents Selected Date Range From: To: Document Order Forward Backward # of blank lines between documents on print out (1 to 8) Include Deleted Documents']/INPUT[7]")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//INPUT[@id='fromDateRange']")
	public WebElementFacade DateFrom_WebEdit;

	@FindBy(xpath = "//INPUT[@id='toDateRange']")
	public WebElementFacade DateTo_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents Selected Date Range From: To: Document Order Forward Backward # of blank lines between documents on print out (1 to 8) Include Deleted Documents']/INPUT[3]")
	public WebElementFacade DisplayParcel_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents']/INPUT[1]")
	public WebElementFacade DocumentFilter_WebRadioGroup;

	@FindBy(xpath = "//TR/TD[normalize-space()='Forward']/INPUT[1]")
	public WebElementFacade DocumentOrder_WebRadioGroup;

	@FindBy(xpath = "//DIV[@id='docs']/TABLE[normalize-space()='Registration NumberRegistration DateDocument TypeParty ToDocument RemarksStatusDeleted? 32080PC311 2012/11/26CONDOMINIUM PLAN (STANDARD)CERTIFIED No']")
	public WebElementFacade DocumentsTable_WebTable;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD[normalize-space()='Search by PIN']")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//TD[@id='includeDeleted']/INPUT[1]")
	public WebElementFacade IncludeDeleted_WebCheckBox;

	@FindBy(xpath = "//DIV[@id='desc']")
	public WebElementFacade NewPINs_WebElement;

	@FindBy(xpath = "//INPUT[@id='propertyTextField']")
	public WebElementFacade PIN_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents Selected Date Range From: To: Document Order Forward Backward # of blank lines between documents on print out (1 to 8) Include Deleted Documents']/INPUT[4]")
	public WebElementFacade PrintParcel_WebButton;

	@FindBy(xpath = "//DIV[@id='remarks']/TABLE/TBODY/TR/TD[normalize-space()='LINE1: PROPERTY REMARK1. LINE2: PROPERTY REMARK2. LINE3: PROPERTY REMARK3. LINE4: PROPERTY REMARK4. LINE5: PROPERTY REMARK5. LINE6: PROPERTY REMARK6.']")
	public WebElementFacade PropertyRemarks_WebElement;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR/TD[normalize-space()='DIVISION FROM 16912-0069']")
	public WebElementFacade Recently_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents Selected Date Range From: To: Document Order Forward Backward # of blank lines between documents on print out (1 to 8) Include Deleted Documents']/INPUT[6]")
	public WebElementFacade Refresh_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]")
	public WebElementFacade RegisterView_WebTable;

	@FindBy(xpath = "//FORM[1]/INPUT[4]")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//TABLE[@id='docs']/TBODY[normalize-space()='Documents Registration NumberRegistration DateDocument TypeParty ToDocument RemarksStatusDeleted? 32080PC311 2012/11/26CONDOMINIUM PLAN (STANDARD)CERTIFIED No']/TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllDocuments_WebButton;

	@FindBy(xpath = "//TABLE[@id='internalNotes']/TBODY[normalize-space()='Internal PIN Notes - NOT FOR PUBLIC VIEW']/TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllInternalPINNotes_WebButton;

	@FindBy(xpath = "//TABLE[@id='owners']/TBODY[normalize-space()='Owners NameCapacityShare POLARIS OWNER']/TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllOwners_WebButton;

	@FindBy(xpath = "//TABLE[@id='remarks']/TBODY[normalize-space()='Property Remarks']/TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllRemarks_WebButton;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewAllTitleQualifiers_WebButton;

	@FindBy(xpath = "//TABLE[@id='desc']/TBODY[normalize-space()='Description UNIT 2, LEVEL 1, WENTWORTH STANDARD CONDOMINIUM PLAN NO. 32080311 AND ITS APPURTENANT INTEREST; CITY OF HAMILTON']/TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ViewEntireDescription_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='All Documents Selected Date Range From: To: Document Order Forward Backward # of blank lines between documents on print out (1 to 8) Include Deleted Documents']/INPUT[5]")
	public WebElementFacade ViewMap_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='Forward']/INPUT[1]")

	public WebElementFacade DocumentOrderForword_WebRadioGroup;

	@FindBy(xpath = "//input[@id='sortOrder_2']")

	public WebElementFacade DocumentOrderBackword_WebRadioGroup;

	@FindBy(xpath = "//input[@id='filterType_2']")

	public WebElementFacade SelectedDateRange_WebRadioGroup;

	@FindBy(xpath = "//input[@id='filterType_1']")

	public WebElementFacade AllDocuments_WebRadioGroup;

}
