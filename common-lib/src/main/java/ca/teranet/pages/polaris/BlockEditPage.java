package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BlockEditPage extends BasePage {

	@FindBy(xpath = "//FORM[@id='maintainBlockELRSForm']/TABLE[2]")
	public WebElementFacade BlockInfo_WebTable;

	@FindBy(xpath = "FORM[@id='maintainBlockELRSForm']/TABLE[2]")
	public WebElementFacade Block_WebTable;

	@FindBy(xpath = "//INPUT[@id='blockNumber']")
	public WebElementFacade BlockNumber_WebEdit;
	//
	@FindBy(xpath = "//INPUT[@id='entryType']")
	public WebElementFacade BlockOption_WebRadioGroup;

	@FindBy(xpath = "//SELECT[@id='blockType']")
	public WebElementFacade BlockType_WebList;

	@FindBy(xpath = "//INPUT[@id='cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='close']")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//INPUT[@id='confirm']")
	public WebElementFacade Confirm_WebButton;

	@FindBy(xpath = "//INPUT[@id='designateDate']")
	public WebElementFacade DesignateDate_WebEdit;

	@FindBy(xpath = "//INPUT[@id='edit']")
	public WebElementFacade Edit_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='proceed']")
	public WebElementFacade Proceed_WebButton;

}
