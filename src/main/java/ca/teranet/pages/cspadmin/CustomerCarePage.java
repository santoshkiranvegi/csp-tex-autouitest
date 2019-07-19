package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerCarePage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	@FindBy(xpath = "//table[@class='prodadmin']//tr[1]/td[1]/img")
	public WebElementFacade image_unity;

	@FindBy(xpath = "//table[@class='prodadmin']//tr[1]/td[2]")
	public WebElementFacade title_customCare;

	@FindBy(xpath = "//tr[@class='globalHeader']")
	public WebElementFacade title_customCareLogin;

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@name='login']")
	public WebElementFacade button_login;

	@FindBy(xpath = "//img[@src='/customercare/images/welcome_graphic.gif']")
	public WebElementFacade img_welcome;

	// Logout, Change Password, Support
	public WebElementFacade link_customCare(String text) {
		return findBy("//td[@class='buttonLogout' and contains(., '" + text + "')]");
	}

	// Customer, User, Purchases, Invoices & Statement, Categories
	public WebElementFacade link_customCareMenu(String text) {
		return findBy("//p[@class='appmenu' and contains(., '" + text + "')]");
	}

	public WebElementFacade link_customCareMenuItem(String text) {
		return findBy("//p[@class='menuitem' and contains(., '" + text + "')]");
	}

	@FindBy(xpath = "//a[@href='/customercare/viewCart.do']")
	public WebElementFacade link_cart;
}
