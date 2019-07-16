package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RedirectPrinterPage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

}
