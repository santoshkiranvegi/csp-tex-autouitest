package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

	@FindBy(id = "password")
	public WebElementFacade Password_WebEdit;

	@FindBy(className = "systempagebtn")
	public WebElementFacade Submit_WebButton;

	@FindBy(id = "username")
	public WebElementFacade UserID_WebEdit;

}
