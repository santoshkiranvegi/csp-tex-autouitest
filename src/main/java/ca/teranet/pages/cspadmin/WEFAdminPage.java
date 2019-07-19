package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class WEFAdminPage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	@FindBy(xpath = "//h1[contains(.,'WEF Admin Log In')]")
	public WebElementFacade title_WEFAdminLogin;

	@FindBy(xpath = "//span[contains(.,'WEF ADMIN')]")
	public WebElementFacade title_WEFAdmin;

	@FindBy(xpath = "//tr[@class='tableHeader']/td[contains(.,'Enter New Lawyer Info:')]")
	public WebElementFacade title_EnterInfo;

	@FindBy(xpath = "//b[contains(.,'Update the Lawyer Info')]")
	public WebElementFacade title_UpdateInfo;

	@FindBy(xpath = "//b[contains(.,'Create new Lawyer Result')]")
	public WebElementFacade title_NewLawyer;

	@FindBy(xpath = "//b[contains(.,'Update Lawyer Result')]")
	public WebElementFacade title_UpdateLawyer;

	// login page
	@FindBy(xpath = "//input[@id='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@id='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//button[@id='login-button']")
	public WebElementFacade button_login;

	@FindBy(xpath = "//button[@id='cancel-button']")
	public WebElementFacade button_cancel;

	public WebElementFacade link_WEFSupport(String text) {
		return findBy("//a[contains(.,'" + text + "')]");
	}

	public WebElementFacade link_lawyer(String text) {
		return findBy("//a//b[text()='" + text + "']");
	}

	// Lawyer Info
	@FindBy(xpath = "//input[@id='DNString']")
	public WebElementFacade input_DNString;

	@FindBy(xpath = "//input[@id='lsucId']")
	public WebElementFacade input_lsucId;

	@FindBy(xpath = "//input[@id='isEligible']")
	public WebElementFacade input_isEligible;

	@FindBy(xpath = "//input[@id='email']")
	public WebElementFacade input_email;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade button_search;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@value='Update']")
	public WebElementFacade button_update;

	@FindBy(xpath = "//textarea[@id='Message']")
	public WebElementFacade text_message;
}
