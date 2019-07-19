package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeLROPage extends BasePage {

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[2]")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
	public WebElementFacade ChangeLRO_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//select[@name='selectedLroId']")
	public WebElementFacade LROList_WebList;

}
