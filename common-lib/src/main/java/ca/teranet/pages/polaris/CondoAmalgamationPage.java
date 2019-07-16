package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CondoAmalgamationPage extends BasePage {

	@FindBy(xpath = "//TR[normalize-space()='Block Number']/TD[2]/INPUT[1]")
	public WebElementFacade BlockNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
	public WebElementFacade CancelWIP_WebButton;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//input[@name='propertyItem.relatedDocument']")
	public WebElementFacade RegNumber_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='Condominium Plan Number']")
	public WebElementFacade RegNumber_WebElement;

	@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
	public WebElementFacade RetrieveWIP_WebButton;

}
