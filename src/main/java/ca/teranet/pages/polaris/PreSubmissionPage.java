package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PreSubmissionPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='addDocBtn']")
	public WebElementFacade AddDocument_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[11]")
	public WebElementFacade AddEasePIN_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[7]")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='currentFolderItem.documentToPopulateFrom']")
	public WebElementFacade AlternateDocument_WebEdit;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='chgDocBtn']")
	public WebElementFacade ChangeType_WebButton;

	@FindBy(xpath = "//SELECT[@id='folder']")
	public WebElementFacade DocumentFolder_WebList;

	@FindBy(xpath = "//INPUT[@id='historicalCheck']")
	public WebElementFacade DocumentNotAutomated_WebCheckBox;

	@FindBy(xpath = "//SELECT[@id='doclist']")
	public WebElementFacade DocumentType_WebList;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/TABLE[1]")
	public WebElementFacade DocumentType_WebTable;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[9]")
	public WebElementFacade EasePINNext_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[8]")
	public WebElementFacade EasePINPrev_WebButton;

	@FindBy(xpath = "//INPUT[@id='editBtn']")
	public WebElementFacade Edit_WebButton;

	@FindBy(xpath = "//INPUT[@id='viewErrorBtn']")
	public WebElementFacade ErrorDetails_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='saveFolderName']")
	public WebElementFacade FolderName_WebEdit;

	@FindBy(xpath = "//input[@name='docTypeFrenchInd']")
	public WebElementFacade French_WebCheckBox;

	@FindBy(xpath = "//input[@name='currentFolderItem.registerAgainstHighwayRegister']")
	public WebElementFacade HWY_WebCheckBox;

	@FindBy(xpath = "//INPUT[@id='multipleRelatedDocuments']")
	public WebElementFacade MultipleRelatedDocuments_WebCheckBox;

	@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
	public WebElementFacade NewSubmission_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[5]")
	public WebElementFacade PINNext_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[4]")
	public WebElementFacade PINPrevious_WebButton;

	@FindBy(xpath = "//INPUT[@id='sourceTxt']")
	public WebElementFacade RegistrationNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@id='currentFolderItem.relatedDocument']")
	public WebElementFacade RelatedDocument_WebEdit;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[10]")
	public WebElementFacade RemoveEasePIN_WebButton;

	@FindBy(xpath = "//FORM[1]/TABLE[2]/TBODY[1]/TR[1]/TD[2]/INPUT[6]")
	public WebElementFacade RemovePIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='removeBtn']")
	public WebElementFacade Remove_WebButton;

	@FindBy(xpath = "//INPUT[@id='lookupBtn']")
	public WebElementFacade RetrievePINs_WebButton;

	@FindBy(xpath = "//FORM[1]/P[2]/TABLE[1]")
	public WebElementFacade RetrieveSavedFolder_WebTable;

	@FindBy(xpath = "//TABLE[@id='message']/TBODY[1]/TR[1]/TD[1]")
	public WebElementFacade SaveFolderConfirmMsg_WebElement;

	@FindBy(xpath = "//INPUT[@id='saveButton']")
	public WebElementFacade SaveFolder_WebButton;

	@FindBy(xpath = "//SELECT[@id='sourceList']")
	public WebElementFacade SourceDocumentList_WebList;

	@FindBy(xpath = "//INPUT[@id='nextBtn']")
	public WebElementFacade Submit_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='TransCanada Pipeline Highways Register']/INPUT[1]")
	public WebElementFacade TCPL_WebCheckBox;

	@FindBy(xpath = "//input[@value='Prev'][1]")
	public WebElementFacade Prev_WebButton_1;

	@FindBy(xpath = "//input[@value='Prev'][2]")
	public WebElementFacade Prev_WebButton_2;

	@FindBy(xpath = "//input[@value='Next'][1]")
	public WebElementFacade Next_WebButton_1;

	@FindBy(xpath = "//input[@value='Next'][2]")
	public WebElementFacade Next_WebButton_2;

}
