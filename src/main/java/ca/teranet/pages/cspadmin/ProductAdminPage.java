package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductAdminPage extends BasePage {

	@FindBy(xpath = "//h2[contains(.,'Login failed, please try again!')]")
	public WebElementFacade errorMsg_login;

	@FindBy(xpath = "//table[@class='prodadmin']//tr[1]/td[1]/img")
	public WebElementFacade image_unity;

	@FindBy(xpath = "//table[@class='prodadmin']//tr[1]/td[2]")
	public WebElementFacade title_productAdmin;

	@FindBy(xpath = "//tr[@class='globalHeader']")
	public WebElementFacade title_productAdminLogin;

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@name='login']")
	public WebElementFacade button_login;

	@FindBy(xpath = "//img[@src='/prodadmin/images/welcome_graphic.gif']")
	public WebElementFacade img_welcome;

	// Logout, Change Password, Support
	public WebElementFacade link_ProductAdminLogin(String text) {
		return findBy("//td[@class='buttonLogout' and contains(., '" + text + "')]");
	}

	// Products/Taxes/Price Adjustments/Revenue Categories
	// Product Categories/SAF Product List/Rate Packages/Merchants
	// Merchant Rates/Account Information/TouchLink Report/Vendor Report
	// Product Detail Report/Product Change Report/Royal Bank Summary Report/Credit Card Rate Summary Report
	// Credit Card Rate Detailed Report/Load Products\/Customers\/Cost Center
	public WebElementFacade link_ProductAdminMenu(String text) {
		return findBy("//p[@class='appmenu' and contains(., '" + text + "')]");
	}

	// Log out/Change Password/Support
	public WebElementFacade link_ProductAdmin(String text) {
		return findBy("//a[contains(., '" + text + "')]");
	}
}
