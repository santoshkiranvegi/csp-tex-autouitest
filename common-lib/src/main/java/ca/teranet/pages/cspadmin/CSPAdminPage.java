package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CSPAdminPage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	// link menu
	public WebElementFacade link_CSPAdmin(String text) {
		return findBy("//a[contains(.,'" + text + "')]");
	}

	// access denied
	@FindBy(xpath = "//div[@id='header']/h1[contains(., 'Access Denied')]")
	public WebElementFacade title_accessDenied;

	@FindBy(xpath = "//div[@id='header']/span[contains(., 'You are not authorized to access this page.')]")
	public WebElementFacade message_accessDenied;

	@FindBy(xpath = "//div[@id='header']/a")
	public WebElementFacade link_logout_accessDenied;

	// invalid user
	@FindBy(xpath = "//div[@id='header']/span[@class='error']")
	public WebElementFacade message_login;

}
