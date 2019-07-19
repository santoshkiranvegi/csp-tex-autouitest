package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPOAPage extends BasePage {

	@FindBy(xpath = "//input[@id='criteriaView.lastName']")
	public WebElementFacade LastName_WebEdit;

	@FindBy(xpath = "//input[@id='criteriaView.firstName']")
	public WebElementFacade GivenName_WebEdit;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//div[contains(@id,'Form.errors')]")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//span[contains(@id,'Messages')]")
	public WebElementFacade ErrorMsgNoResultsFound_WebTable;

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

}
