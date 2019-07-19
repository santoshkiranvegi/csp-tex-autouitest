package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentSelectionPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='cancelButton']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='submitNextInQueue']")
	public WebElementFacade NextInMyQueue_WebButton;

	@FindBy(xpath = "//INPUT[@id='submitSearchByDocNumber']")
	public WebElementFacade Proceed_WebButton;

	@FindBy(xpath = "//INPUT[@id='documentSelection.documentNumber']")
	public WebElementFacade RegistrationNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@value='Proceed']")
	public WebElementFacade ProceedCorrectCertification_WebButton;

}
