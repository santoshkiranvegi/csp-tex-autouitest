package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FeesTaxesPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='idAcctNum']")
	public WebElementFacade AccountNumber_WebEdit;

	@FindBy(xpath = "//TR[9]/TD[1]/INPUT[3]")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR[normalize-space()='Cash Drawer']/TD[2]/INPUT[1]")
	public WebElementFacade CashDrawer_WebEdit;

	@FindBy(xpath = "//input[@value='Complete Registration']")
	public WebElementFacade CompleteRegistration_WebButton;

	@FindBy(xpath = "//input[contains(@value,'Complete Recording')]")
	public WebElementFacade Complete_WebButton;

	@FindBy(xpath = "//*[contains(text(),'Document Type')]")
	public WebElementFacade DocumentType_WebTable;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='Total Fees $ 70.00 Total LTT $ 96475.00 Total RST$ 0.00 Grand Total$ 96545.00']")
	public WebElementFacade FeesTable_WebTable;

	@FindBy(xpath = "//TR/TD/SPAN[normalize-space()='Fees and Taxes']")
	public WebElementFacade FeesTaxesHeading_WebElement;

	@FindBy(xpath = "//SELECT[@id='idPayMthd']")
	public WebElementFacade PaymentMethod_WebList;

	@FindBy(xpath = "//TR[9]/TD[1]/INPUT[2]")
	public WebElementFacade ReturnToDetails_WebButton;

	@FindBy(xpath = "//input[@value='Cancel Recording']")
	public WebElementFacade Cancel_Recording_WebButton;

}
