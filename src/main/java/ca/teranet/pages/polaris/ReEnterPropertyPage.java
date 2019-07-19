package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReEnterPropertyPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
	public WebElementFacade CancelWIP_WebButton;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='noRadio']")
	public WebElementFacade ConversionType_WebRadioGroup;

	@FindBy(xpath = "//TR/TD[normalize-space()='Conversion?']")
	public WebElementFacade Conversion_WebElement;

	@FindBy(xpath = "//INPUT[@id='startReEnterForm.newBlockNumber']")
	public WebElementFacade NewBlock_WebEdit;

	@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
	public WebElementFacade RetrieveWIP_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='-']/INPUT[1]")
	public WebElementFacade TargetBlock_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='-']/INPUT[2]")
	public WebElementFacade TargetPIN_WebEdit;

	@FindBy(xpath = "//input[@value='Save']")

	public WebElementFacade Save_WebButton;

	@FindBy(xpath = "//input[@value='Close']")

	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//div[@id='startReEnterForm.errors']")

	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='noRadio']")
	public WebElementFacade ConversionTypeNO_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='ltToRRadio']")
	public WebElementFacade ConversionTypeltTo_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='rToLtRadio']")
	public WebElementFacade ConversionTyperToL_WebRadioGroup;

}
