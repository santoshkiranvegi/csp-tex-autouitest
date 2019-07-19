package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentDataPage extends BasePage {

	@FindBy(xpath = "//DIV[@id='documentDataContent']/INPUT[3]")
	public WebElementFacade AddMorePlanUnit_WebButton;

	@FindBy(xpath = "//DIV[@id='documentDataContent']/INPUT[4]")
	public WebElementFacade AddMoreStreetName_WebButton;

	@FindBy(xpath = "//DIV[@id='documentDataContent']/INPUT[5]")
	public WebElementFacade AddMore_WebButton;

	@FindBy(xpath = "//INPUT[@id='registrationDetailAmount']")
	public WebElementFacade Amount_WebEdit;

	@FindBy(xpath = "//INPUT[@id='saveRemarks']")
	public WebElementFacade Apply2_WebButton;

	@FindBy(xpath = "//INPUT[@id='saveNotes']")
	public WebElementFacade Apply1_WebButton;

	@FindBy(xpath = "//INPUT[@id='condoDeclarationBeingAmended']")
	public WebElementFacade CondoDeclarationBeingAmended_WebEdit;

	@FindBy(xpath = "//INPUT[@id='condoDeclaration']")
	public WebElementFacade CondoDeclaration_WebEdit;

	@FindBy(xpath = "//INPUT[@id='condoPlanBeingAmended']")
	public WebElementFacade CondoPlanBeingAmended_WebEdit;

	@FindBy(xpath = "//INPUT[@id='planningActConsent.value']")
	public WebElementFacade ConsentIndicator_WebCheckBox;

	@FindBy(xpath = "//INPUT[@id='submitCancel']")
	public WebElementFacade DoNotApply_WebButton;

	@FindBy(xpath = "//INPUT[@id='historicalCheck']")
	public WebElementFacade DocumentNotAutomated_WebCheckBox;

	@FindBy(xpath = "//SPAN[@id='numEasementPinsId']")
	public WebElementFacade EasementPINs_WebElement;

	@FindBy(xpath = "//INPUT[@id='ExpiryDate.value']")
	public WebElementFacade ExpiryDate_WebEdit;

	@FindBy(xpath = "//INPUT[@id='sfdIndCheckbox']")
	public WebElementFacade FamilyDwelling_WebCheckBox;

	@FindBy(xpath = "//TEXTAREA[@id='notesForm.oldNote']")
	public WebElementFacade FullNotes_WebEdit;

	@FindBy(xpath = "//INPUT[@id='GoodsAndChatels.value']")
	public WebElementFacade GoodsAndChattels_WebEdit;

	@FindBy(xpath = "//IMG[contains(@id,'NotesImg')]")
	public WebElementFacade InternalNote_Image;

	@FindBy(xpath = "//TR/TH[normalize-space()='Internal Processing Notes:']")
	public WebElementFacade InternalProcessingNotes_WebElement;

	@FindBy(xpath = "//INPUT[@id='multipleRelatedDocuments']")
	public WebElementFacade MultipleRelatedDocuments_WebCheckBox;

	@FindBy(xpath = "//INPUT[@id='nameOfSurveyFirm']")
	public WebElementFacade NameOfSurveyFirm_WebEdit;

	@FindBy(xpath = "//TEXTAREA[@id='usertext']")
	public WebElementFacade NewNote_WebEdit;

	@FindBy(xpath = "//INPUT[@name='attributesVOBean.attributeVO(NumPages).value']")
	public WebElementFacade NumberOfPages_WebEdit;

	@FindBy(xpath = "//TABLE[@id='partListingInfoTable']")
	public WebElementFacade PINListing_WebTable;

	@FindBy(xpath = "//INPUT[@id='registrationDate']")
	public WebElementFacade RegistrationDate_WebEdit;

	@FindBy(xpath = "//INPUT[@id='relatedDocumentId']")
	public WebElementFacade RelatedDocument_WebEdit;

	@FindBy(xpath = "//INPUT[@id='planningActStatement.value']")
	public WebElementFacade StatementIndicator_WebCheckBox;

	@FindBy(xpath = "//INPUT[@id='surveyorsFileNumber']")
	public WebElementFacade SurveyorsFileNumber_WebEdit;

	@FindBy(xpath = "//SPAN[@id='numPinsId']")
	public WebElementFacade TargetPINs_WebElement;

	@FindBy(xpath = "//INPUT[@id='numberOfUnits']")
	public WebElementFacade TotalNewUnits_WebEdit;

	@FindBy(xpath = "//INPUT[@id='townshipMunicipality']")
	public WebElementFacade TownshipMunicipality_WebEdit;

	@FindBy(xpath = "//IMG[@id='hasNotesImg']")
	public WebElementFacade WithNote_Image;

	@FindBy(xpath = "//IMG[@id='noRemarksImg']")
	public WebElementFacade WithRemarks_Image;

	@FindBy(xpath = "//INPUT[@name='attributesVOBean.attributeVO(BoundariesActPlanNumber).value']")
	public WebElementFacade BoundariesActPlanNumber_WebEdit;
}
