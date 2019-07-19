package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertyMaintenancePage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='ApplyToAllBtnForDesc']")
	public WebElementFacade AddtoallPINs_WebButton;

	@FindBy(xpath = "//FORM[1]/INPUT[7]")
	public WebElementFacade BulkEdit_WebButton;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Commit_WebButton;

	@FindBy(xpath = "//TR/TD[contains(text(),'Description Documents Owners Property Remarks Registration NumberThis PIN onlyAction For All PINs Document')]/DIV[1]/TABLE[1]")
	public WebElementFacade DocumentsTable_WebTable;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD/FIELDSET[normalize-space()='Properties 16948-0008 (LT) Highways Register TransCanada Pipeline']/IMG[2]")
	public WebElementFacade HappyFace_Image;

	@FindBy(xpath = "//TR/TD[normalize-space()='Maintain Property Single Edit']")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//TABLE[@id='propMaintHostTable']")
	public WebElementFacade MaintainProperty_WebTable;

	@FindBy(xpath = "//FORM[1]/FONT[1]")
	public WebElementFacade PropertyMaintenanceMsg_WebElement;

	@FindBy(xpath = "//FORM[1]/INPUT[8]")
	public WebElementFacade ReturntoDetails_WebButton;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

}
