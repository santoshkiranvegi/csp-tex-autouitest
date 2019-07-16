package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreezeUnfreezePropertyPage extends BasePage {

	// @FindBy(xpath = "//TR/TD[normalize-space()='Retrieve PIN list from Document: (Enter a registration number.) or Registers to be Modified 1 - to 2 - to 3 - to 4 - to Page 1 of 1']/INPUT[7]")
	@FindBy(xpath = "//input[@value='Add PIN']")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='viewErrorBtn']")
	public WebElementFacade ErrorDetails_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	// @FindBy(xpath = "//FORM[1]/TABLE[3]/TBODY[1]/TR[1]/TD[1]/INPUT[2]")
	@FindBy(xpath = "//input[@id='currentFolderItem.registerAgainstHighwayRegister1']")
	public WebElementFacade HWY_WebCheckBox;

	@FindBy(xpath = "//input[@value='Proceed']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//TR/TD/SPAN[normalize-space()='Retrieve PINs from document:']")
	public WebElementFacade RegNumberHeader_WebElement;

	@FindBy(xpath = "//INPUT[@id='sourceTxt']")
	public WebElementFacade RegistrationNum_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='Retrieve PIN list from Document: (Enter a registration number.) or Registers to be Modified 1 - to 2 - to 3 - to 4 - to Page 1 of 1']/INPUT[6]")
	public WebElementFacade RemoveSelectedPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='lookupBtn']")
	public WebElementFacade RetrievePINs_WebButton;

	@FindBy(xpath = "//input[@id='currentFolderItem.registerAgainstTransCanadaPipeline1']")
	public WebElementFacade TCPL_WebCheckBox;

	@FindBy(xpath = "//input[@id='1']")
	public WebElementFacade Unfreeze_Update_radiobtn;

}
