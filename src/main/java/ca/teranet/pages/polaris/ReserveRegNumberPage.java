package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReserveRegNumberPage extends BasePage {

	@FindBy(xpath = "//INPUT[@name='cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR/TD[normalize-space()='Registration Numbers Assigned:']")
	public WebElementFacade Heading_WebElement;

	@FindBy(xpath = "//INPUT[@id='reserveRegNum.numToReserve']")
	public WebElementFacade NumToReserve_WebEdit;

	@FindBy(xpath = "//input[@id='numToReserve']")
	public WebElementFacade NumberReserved_WebTable;

	@FindBy(xpath = "//FORM[1]/TABLE[2]")
	public WebElementFacade NumberReserved_old_WebTable;

	@FindBy(xpath = "//TR[8]/TD[1]/INPUT[1]")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//select[@name='seriesID']")
	public WebElementFacade SeriesID_WebList;

}
