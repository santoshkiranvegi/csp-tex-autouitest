package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreatePropertyPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='startCreatePropertyForm.newBlockNumber']")
	public WebElementFacade Block_WebEdit;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']/TBODY[1]/TR[1]/TD[1]/FONT[1]")
	public WebElementFacade ErrorMsg_WebElement;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='PRINT PARCEL']")
	public WebElementFacade PrintParcel_WebElement;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(name = "propertyItem.reasonCode")
	public WebElementFacade ReasonCode_WebList;

}
