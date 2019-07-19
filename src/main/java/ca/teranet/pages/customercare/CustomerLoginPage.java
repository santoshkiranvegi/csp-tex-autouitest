package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerLoginPage extends BasePage {

	// login button
	@FindBy(xpath = "//input[@name='login']")
	public WebElementFacade login_button;

	// header link
	@FindBy(xpath = "//img[@name='logout']")
	public WebElementFacade header_logout;

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_header_username;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_header_password;

}
