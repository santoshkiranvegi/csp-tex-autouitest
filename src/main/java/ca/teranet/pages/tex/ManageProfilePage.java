package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ManageProfilePage extends WebTablePage {

	private final String tableAction = "//form[@id='voRetrieveUserDetail']/table";

	public void setManageProfileActionTable() {
		this.setTablePath(tableAction);
	}

	@FindBy(xpath = "//input[@id='Email']")
	public WebElementFacade input_email;

	@FindBy(xpath = tableAction + "//tr[1]/td[1]//input[@type='radio']")
	public WebElementFacade radiobutton_retrieveUserProfile;

	@FindBy(xpath = tableAction + "//tr[2]/td[1]//input[@type='radio']")
	public WebElementFacade radiobutton_retrievePaymentMethod;

	@FindBy(xpath = tableAction + "//tr[2]/td[2]//input[@type='checkbox']")
	public WebElementFacade checkbox_returnSuspended;

	@FindBy(xpath = tableAction + "//tr[3]/td[1]//input[@type='radio']")
	public WebElementFacade radiobutton_retrieveTopUps;

	@FindBy(xpath = tableAction + "//tr[4]/td[1]//input[@type='radio']")
	public WebElementFacade radiobutton_createNewTopUp;

	@FindBy(xpath = tableAction + "//tr[5]/td[1]//input[@type='radio']")
	public WebElementFacade radiobutton_transactionReport;

	@FindBy(xpath = "//input[@id='btn-retrieve']")
	public WebElementFacade button_retrieve;

	// ============== negative ==================================
	// error message
	@FindBy(xpath = "//span[@id='doc.errors']")
	public WebElementFacade page_errorMessage;

}
