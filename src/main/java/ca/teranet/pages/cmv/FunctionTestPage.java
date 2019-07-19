package ca.teranet.pages.cmv;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FunctionTestPage extends WebTablePage {

	// login page
	@FindBy(xpath = "//strong")
	public WebElementFacade title_login;

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_userID;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@value='Reset']")
	public WebElementFacade button_reset;

	// function test page
	@FindBy(xpath = "//th")
	public WebElementFacade title_functionTest;

	@FindBy(xpath = "//input[@id='lronumber']")
	public WebElementFacade input_lro;

	@FindBy(xpath = "//input[@id='area']")
	public WebElementFacade input_area;

	@FindBy(xpath = "//input[@id='pinblock']")
	public WebElementFacade input_block;

	@FindBy(xpath = "//input[@id='pinnumber']")
	public WebElementFacade input_pin;

	@FindBy(xpath = "//input[@id='requestedby']")
	public WebElementFacade input_requestBy;

	@FindBy(xpath = "//input[@id='clientid']")
	public WebElementFacade input_clientId;

	@FindBy(xpath = "//input[@id='sessionid']")
	public WebElementFacade input_sessionId;

	@FindBy(xpath = "//textarea[@id='savedState']")
	public WebElementFacade textarea_savedState;

	@FindBy(xpath = "//input[@id='token']")
	public WebElementFacade input_ngtvToken;

	// public
	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade button_submit;

	// pdf view page
	@FindBy(xpath = "//embed[@type='application/pdf']")
	public WebElementFacade window_PDF;

}
