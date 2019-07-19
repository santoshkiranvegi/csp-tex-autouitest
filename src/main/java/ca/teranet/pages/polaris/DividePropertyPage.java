package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DividePropertyPage extends BasePage {

	@FindBy(xpath = "//input[@name='singlePin.block']")
	public WebElementFacade Block_WebEdit;

	@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
	public WebElementFacade CancelWIP_WebButton;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//FORM[1]/INPUT[3]")
	public WebElementFacade No_WebButton;

	@FindBy(xpath = "//INPUT[@id='numNewProperties']")
	public WebElementFacade NumberOfNewProperties_WebEdit;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//input[@name='singlePin.property']")
	public WebElementFacade Property_WebEdit;

	@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
	public WebElementFacade RetrieveWIP_WebButton;

	@FindBy(xpath = "//FORM[1]/INPUT[2]")
	public WebElementFacade Yes_WebButton;

}
