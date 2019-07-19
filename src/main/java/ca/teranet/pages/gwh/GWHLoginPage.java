package ca.teranet.pages.gwh;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GWHLoginPage extends BasePage {

	@FindBy(xpath = "//a[@name='login2']/div[@class='btn-fill']")
	public WebElementFacade link_login;

	// error message that login unsuccessful
	@FindBy(xpath = "//p[contains(text(),'unsuccessful. Check your User Name and Password.')]")
	public WebElementFacade disp_errmessage;

	// Input validation error message
	@FindBy(xpath = "//table[@class='resultcontheader']//td[@align='center']")
	public WebElementFacade validation_message;

	// An error has occurred message.
	@FindBy(xpath = "//div[@class='error-container']//div[@class='error-header']")
	public WebElementFacade error_occured;

	// Username
	@FindBy(xpath = "//input[@name='userName']")
	public WebElementFacade input_header_username;

	// password
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade input_header_password;

	// Header - to check if Login is successful
	@FindBy(xpath = "//a[@id='mygeowarehouse' and @title='My Geowarehouse']")
	public WebElementFacade link_MYGEOWAREHOUSE;

	// Session not cleaned properly - Backto Ware House Link
	@FindBy(xpath = "//div[contains(text(),'Back To GeoWarehouse') and @class='btn-fill']")
	public WebElementFacade link_backtogwh;

	// Text - //p[text()='You are already logged in.']
	@FindBy(xpath = "//p[text()='You are already logged in.']")
	public WebElementFacade text_alreadyLoggedIn;

	@FindBy(xpath = "//div[contains(text(),'Logout') and @class='btn-fill']")
	public WebElementFacade link_logoutinvalidsession;

	@FindBy(xpath = "//div[contains(text(),'Logout')]/ancestor::a")
	public WebElementFacade link_logoutsessionvalid;

	@FindBy(xpath = "//span[text()='Login']")
	public WebElementFacade link_loginredirect;

	// reset password link
	@FindBy(xpath = "//form[@id='form1']//a[@name='login3']")
	public WebElementFacade resetpw_link;

	//// email for reset
	@FindBy(xpath = "//form[@id='form1']//input[@id='pwdResetRequest']")
	public WebElementFacade email_forreset;

	// reset password button
	@FindBy(xpath = "//form[@id='form1']//div[@class='btn blue']//a[@name='login2']//div[@class='btn-fill']")
	public WebElementFacade reset_passwordbtn;

	// after resetting ,message displayed Your password has been reset. The new temporary password has been sent to the email address you have provided.
	@FindBy(xpath = "//div[@id='loginFrame']//form[@id='form1']//p[1]")
	public WebElementFacade psw_rstmessage;

	// different no account found message,more than one account found, error in resetting password message
	@FindBy(xpath = "//div[@id='loginFrame']//form[@id='form1']//p[2]")
	public WebElementFacade account_error_messages;

	// Reset Password Frame
	public By resetpasswordFrame() {
		return By.xpath("//iframe[@name='FRAME1']");
	}
}
