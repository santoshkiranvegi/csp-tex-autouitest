package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ManageModelPage extends BasePage {
	// dropDown
	@FindBy(xpath = "//select[@class='gwt-ListBox text']")
	public WebElementFacade dropdown;

	// ID in the table
	@FindBy(xpath = "//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']")
	public WebElementFacade id;

	// Default model check box
	@FindBy(xpath = "//label[text()='Set as Default Model']/../..//input")
	public WebElementFacade defaultModelCheckBox;

	// Teranet default model
	@FindBy(xpath = "//label[text()='Use Teranet default model when AVM fails']/../..//input")
	public WebElementFacade teranetModelCheckBox;

	// Save button
	@FindBy(xpath = "(//a[@class=\"grey_button_sml\"]/span[contains(text(),'Save')])[1]")
	public WebElementFacade save_btn;

}
