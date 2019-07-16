package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ParcelConfirmationPage extends BasePage {

	@FindBy(xpath = "//table[@id='confirmationTable']//tbody//table//tbody//td[contains(@id,'BLOCK')]")
	public WebElementFacade BlockSection_WebTable;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//FORM[1]/INPUT[5]")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//TABLE[@id='descriptionSectionTable']")
	public WebElementFacade DescriptionSection_WebTable;

	@FindBy(xpath = "//TR[@id='documentsTableRow']")
	public WebElementFacade DocumentsSection_WebTable;

	@FindBy(xpath = "//FORM[1]/INPUT[6]")
	public WebElementFacade Edit_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//table[contains(@id,'INTEREST_QUALIFIER')]//td[1]")
	public WebElementFacade EstateSection_WebTable;

	@FindBy(xpath = "//table[contains(@id,'INTEREST_QUALIFIER')]//td[3]")
	public WebElementFacade QualifierSection_WebTable;

	@FindBy(xpath = "//TEXTAREA[@id='bulkForm.freeFormRemarks']")
	public WebElementFacade OtherRemarks_WebEdit;

	@FindBy(xpath = "//TR[@id='ownersTableRow']")
	public WebElementFacade OwnersSection_WebTable;

	@FindBy(xpath = "//SPAN[@id='parentPIN']")
	public WebElementFacade ParentPIN_WebElement;

	@FindBy(xpath = "//INPUT[@id='printButton']")
	public WebElementFacade Print_WebButton;

	@FindBy(xpath = "//TR[@id='remarksTableRow']/TD/SPAN/B[normalize-space()='Property Remarks']")
	public WebElementFacade PropertyRemarks_WebElement;

	@FindBy(xpath = "//input[contains(@id,'RegSys')]")
	public WebElementFacade RegSystem_WebEdit;

	@FindBy(xpath = "//TABLE[@id='remarksSectionTable']")
	public WebElementFacade RemarksSection_WebTable;

}
