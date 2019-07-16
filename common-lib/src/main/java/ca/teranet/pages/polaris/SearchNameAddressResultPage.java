package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchNameAddressResultPage extends BasePage {

	@FindBy(xpath = "//TABLE[@id='addressSearchResults']")
	public WebElementFacade AddressResults_WebTable;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade LastName_WebEdit;

	@FindBy(xpath = "//TABLE[@id='nameResultsTable']")
	public WebElementFacade NameResults_WebTable;

	// @FindBy(xpath = "//TD/TABLE/TBODY/TR[normalize-space()='Total No. of Names']/TD[1]/INPUT[1]") public WebElementFacade NewSearch_WebButton;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR[normalize-space()='Requested Address']/TD[2]/INPUT[1]")
	public WebElementFacade RequestedAddress_WebEdit;

	// @FindBy(xpath = "//td[text()='Search By Name/Address']") public WebElementFacade ResultHeader_WebElement;

	// @FindBy(xpath = "//TD/TABLE/TBODY/TR[normalize-space()='Requested Address']/TD[3]/INPUT[1]") public WebElementFacade SelectDifferentStreet_WebButton;

	@FindBy(xpath = "//INPUT[@id='streetName']")
	public WebElementFacade StreetName_WebEdit;

	@FindBy(xpath = "//INPUT[@id='streetNumber']")
	public WebElementFacade StreetNumber_WebEdit;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR/TD[normalize-space()='Total No. of Names']/SPAN[2]/INPUT[1]")
	public WebElementFacade TotalCountOfSearch_WebEdit;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR/TD/SPAN[normalize-space()='Total No. of Names']")
	public WebElementFacade TotalNumberOfNames_WebElement;
	@FindBy(xpath = "(//table[@id='messages']//following::table//tr)[1]")
	public WebElementFacade ResultHeader_WebElement;

	@FindBy(xpath = "//input[@value='New Search']")
	public WebElementFacade NewSearch_WebButton;

	@FindBy(xpath = "//input[@value='Select Different Street']")
	public WebElementFacade SelectDifferentStreet_WebButton;

}
