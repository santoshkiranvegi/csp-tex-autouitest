package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class UpdateCertifiedPropertyBulkPage extends BasePage {

	@FindBy(xpath = "//TR/TD[normalize-space()='Retrieve PIN list from Document: (Enter a registration number.) or Registers to be Modified 1 - to 2 - to 3 - to 4 - to Page 1 of 1']/INPUT[7]")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Update Certified Property Bulk Confirmation']")
	public WebElementFacade ConfirmationHeader_WebElement;

	@FindBy(xpath = "//INPUT[@id='viewErrorBtn']")
	public WebElementFacade ErrorDetails_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='Retrieve PIN list from Document: (Enter a registration number.)']")
	public WebElementFacade RegNumberHeader_WebElement;

	@FindBy(xpath = "//INPUT[@id='sourceTxt']")
	public WebElementFacade RegistrationNum_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='Retrieve PIN list from Document: (Enter a registration number.) or Registers to be Modified 1 - to 2 - to 3 - to 4 - to Page 1 of 1']/INPUT[6]")
	public WebElementFacade RemoveSelectedPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='lookupBtn']")
	public WebElementFacade RetrievePINs_WebButton;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

}
