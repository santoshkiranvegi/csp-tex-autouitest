package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ConsolidatePropertyPage extends BasePage {

	@FindBy(xpath = "//FORM[1]/INPUT[9]")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
	public WebElementFacade CancelWIP_WebButton;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Correct/Update Certified Property']")
	public WebElementFacade ConfirmationHeader_WebElement;

	@FindBy(xpath = "//INPUT[@id='sourceTxt']")
	public WebElementFacade DocNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@id='viewErrorBtn']")
	public WebElementFacade ErrorDetails_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//FORM[1]/SPAN[2]")
	public WebElementFacade NewBlockDescription_WebElement;

	@FindBy(xpath = "//INPUT[@id='startConsolidateForm.propertyItem.newBlockNumber']")
	public WebElementFacade NewBlock_WebEdit;

	@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//FORM[1]/INPUT[8]")
	public WebElementFacade RemoveSelected_WebButton;

	@FindBy(xpath = "//INPUT[@id='lookupBtn']")
	public WebElementFacade RetrievePINs_WebButton;

	@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
	public WebElementFacade RetrieveWIP_WebButton;

}
