package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CorrectCertificationPage extends BasePage {

	@FindBy(xpath = "//*[@id='documentSelection.documentNumber']")
	public WebElementFacade CorrectCertification_RegNum;

	@FindBy(xpath = "//*[@id='submitSearchByDocNumber']")
	public WebElementFacade CorrectCertification_Proceed;
}
