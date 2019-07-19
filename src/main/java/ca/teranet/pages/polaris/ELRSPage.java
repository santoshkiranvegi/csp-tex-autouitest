package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ELRSPage extends BasePage {

	@FindBy(xpath = "//P[2]/INPUT[1]")
	public WebElementFacade Close_WebButton;

	@FindBy(xpath = "//TABLE[1]")
	public WebElementFacade ErrorDetails_WebTable;

	@FindBy(xpath = "//P[1]")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//td[text()='Documents']")
	public WebElementFacade Documents_MenuItem;

	@FindBy(xpath = "//td[text()='Properties']")
	public WebElementFacade Properties_MenuItem;

	@FindBy(xpath = "//td[text()='Search']")
	public WebElementFacade Search_MenuItem;

	@FindBy(xpath = "//td[text()='Reports']")
	public WebElementFacade Reports_MenuItem;

	@FindBy(xpath = "//td[contains(text(),'Administration')]")
	public WebElementFacade Administration_MenuItem;

}
