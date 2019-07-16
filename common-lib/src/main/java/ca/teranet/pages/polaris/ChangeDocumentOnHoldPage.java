package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeDocumentOnHoldPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//FORM[1]/SPAN[2]")
	public WebElementFacade Heading_WebElement;

	@FindBy(xpath = "//FORM[1]/INPUT[3]")
	public WebElementFacade PlaceOnHold_WebButton;

	@FindBy(xpath = "//FORM[1]/SPAN[4]/A[1]")
	public WebElementFacade RegistrationNumber_Link;

	@FindBy(xpath = "//INPUT[@id='regNumEntry']")
	public WebElementFacade RegistrationNumber_WebEdit;

	@FindBy(xpath = "//FORM[1]/INPUT[4]")
	public WebElementFacade RemoveHold_WebButton;

	@FindBy(xpath = "//FORM[1]/TEXTAREA[1]")
	public WebElementFacade note_WebEdit;

	@FindBy(xpath = "//TR/TD/SELECT[normalize-space()='HT HX HY HZ RO']")
	public WebElementFacade SeriesID_WebList;

	@FindBy(xpath = "//INPUT[@id='reserveRegNum.numToReserve']")
	public WebElementFacade NumToReserve_WebEdit;
}
