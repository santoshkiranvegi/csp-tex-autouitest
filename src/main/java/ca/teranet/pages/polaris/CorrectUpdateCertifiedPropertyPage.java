package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CorrectUpdateCertifiedPropertyPage extends BasePage {

	@FindBy(xpath = "//TABLE[@id='startCorrectPropertyTable']/TBODY[1]/TR[1]/TD[2]/INPUT[1]")
	public WebElementFacade Block_WebEdit;

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Correct/Update Certified Property']")
	public WebElementFacade ConfirmationHeader_WebElement;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//TABLE[@id='startCorrectPropertyTable']/TBODY[1]/TR[1]/TD[2]/INPUT[2]")
	public WebElementFacade Property_WebEdit;

}
