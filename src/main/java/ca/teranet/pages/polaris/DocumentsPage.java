package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentsPage extends BasePage {

	@FindBy(xpath = "//FORM[1]/DIV[3]/TABLE[1]/TBODY[1]/TR[2]/TD[3]/INPUT[2]")
	public WebElementFacade AffectsThisDocument_WebRadioGroup;

	@FindBy(xpath = "//input[contains(@value,'OK')]")
	public WebElementFacade OK_WebButton;

}
