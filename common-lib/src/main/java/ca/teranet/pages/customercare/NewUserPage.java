package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewUserPage extends BasePage {

	@FindBy(xpath = "//input[@name='userName']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@name='userId']")
	public WebElementFacade input_userID;

	@FindBy(xpath = "//input[@name='newPassword']")
	public WebElementFacade input_new_password;

	@FindBy(xpath = "//input[@name='confirmedPassword']")
	public WebElementFacade input_confirm_password;

	@FindBy(xpath = "//input[@name='firstName']")
	public WebElementFacade input_first_name;

	@FindBy(xpath = "//input[@name='lastName']")
	public WebElementFacade input_last_name;

	@FindBy(xpath = "//input[@value='Save']")
	public WebElementFacade button_save;

	public WebElementFacade checkbox_group(String group) {
		return findBy("//input[@value='" + group + "']");
	}

	@FindBy(xpath = "//td[@valign='center']")
	public WebElementFacade success_message;

}
