package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RecordHistoricalPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='activeIndRadio']")
	public WebElementFacade ActiveRetiredIndicator_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='abortBtn']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//SELECT[@id='docTypeSelection']")
	public WebElementFacade DocumentType_WebList;

	@FindBy(xpath = "//INPUT[@id='submitDocumentFolder']")
	public WebElementFacade EnterHistoricalRecord_WebButton;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//INPUT[@id='frenchIndBox']")
	public WebElementFacade French_WebCheckBox;

	@FindBy(xpath = "//input[@name='date']")
	public WebElementFacade RegDate_WebEdit;

	@FindBy(xpath = "//INPUT[@id='regNo']")
	public WebElementFacade RegNumber_WebEdit;

	@FindBy(xpath = "//input[@name='time']")
	public WebElementFacade RegTime_WebEdit;

	@FindBy(xpath = "//input[@value='Go to Page']/../../../tr[1]/td/span")
	public WebElementFacade Paging_WebTable;

	@FindBy(xpath = "//input[@value='Add PIN']")
	public WebElementFacade AddPIN_WebButton;

	@FindBy(xpath = "//INPUT[@id='activeIndRadio']")
	public WebElementFacade ActiveIndicator_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='retiredIndRadio']")
	public WebElementFacade RetiredIndicator_WebRadioGroup;

}
