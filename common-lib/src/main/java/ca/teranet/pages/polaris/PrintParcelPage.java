package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PrintParcelPage extends BasePage {

	@FindBy(xpath = "//input[@value='Certify']")
	public WebElementFacade Certify_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//input[@value='Next Property']")
	public WebElementFacade NextProperty_WebButton;

	@FindBy(xpath = "//FORM[1]/FIELDSET[1]/DIV[1]/TABLE[1]")
	public WebElementFacade ParcelTable_WebTable;

	@FindBy(xpath = "//INPUT[@id='printButton']")
	public WebElementFacade PrintParcel_WebButton;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='PRINT PARCEL']")
	public WebElementFacade PrintParcel_WebElement;

	@FindBy(xpath = "//TD[2]/INPUT[1]")
	public WebElementFacade ProceedToConfirmation_WebButton;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='Print from Property to Property']/INPUT[1]")
	public WebElementFacade PropertyFrom_WebEdit;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='Print from Property to Property']/INPUT[2]")
	public WebElementFacade PropertyTo_WebEdit;

	@FindBy(xpath = "//input[@value='Return to Property Details']")
	public WebElementFacade ReturnToPropertyDetails_WebButton;

	@FindBy(id = "iframeMapMaint")
	public WebElementFacade PDFIFrame;
}
