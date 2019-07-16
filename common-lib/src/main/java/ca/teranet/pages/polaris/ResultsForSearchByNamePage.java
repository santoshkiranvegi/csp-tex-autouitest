package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ResultsForSearchByNamePage extends BasePage {

	@FindBy(xpath = "//input[@value='Close']")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR[4]/TD[1]/INPUT[1]")
	public WebElementFacade GivenName_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='Results for Search by Name']")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade LastName_WebEdit;

	@FindBy(xpath = "//input[@value='New Search']")
	public WebElementFacade NewSearch_WebButton;

	@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='Party FromParty ToReg NoSystemReg. DateRemarks SMART, ANGELINA SMART, AVA HT6033536LT 2013/01/21 TC38461_STEP1: REGISTER 'POA' DOCUMENT']")
	public WebElementFacade SearchByNameResult_WebTable;

}
