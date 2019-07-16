package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends BasePage {

	// Account button
	@FindBy(xpath = "//a[@id='btn_account_for_app']")
	public WebElementFacade account_btn;

	// My Profile
	@FindBy(xpath = "//a[text()='My Profile']")
	public WebElementFacade my_profile_link;

	// Back button
	@FindBy(xpath = "//div[@id='backLogo']")
	public WebElementFacade back_button;

	// Change My Password
	@FindBy(xpath = "//a[text()='Change My Password']")
	public WebElementFacade Change_My_Password_link;

	// My Preferences
	@FindBy(xpath = "//a[text()='My Preferences']")
	public WebElementFacade My_Preferences_link;

	// Activity History
	@FindBy(xpath = "//a[text()='Activity History']")
	public WebElementFacade Activity_History_link;

	// Company Admin
	@FindBy(xpath = "//a[text()='Company Admin']")
	public WebElementFacade Company_Admin_link;

	// company admin hidden

	@FindBy(xpath = "//a[@id='btn_company_admin' and @style='display: none;']")
	public WebElementFacade Company_Admin_link_hidden;

	// Manage Models
	@FindBy(xpath = "//a[text()='Manage Models']")
	public WebElementFacade Manage_Models_link;

	// Find property
	@FindBy(xpath = "//a[text()='Find property']")
	public WebElementFacade Find_property_link;

	// Find instrument images
	@FindBy(xpath = "//a[text()='Find instrument images']")
	public WebElementFacade Find_instrument_images_link;

	// Find instrument images link hidden
	@FindBy(xpath = "//a[@id='btn_find_instrument' and @style='display: none;']")
	public WebElementFacade Find_instrument_images_hidden;

	// Quick Start Guide
	@FindBy(xpath = "//a[text()='Quick Start Guide']")
	public WebElementFacade Quick_Start_Guide_link;

	// User Guide
	@FindBy(xpath = "//a[text()='User Guide']")
	public WebElementFacade User_Guide_link;

	// Logout
	@FindBy(xpath = "//a[@id='btn_logout']")
	public WebElementFacade logout_link;

	// Quick userguide PDF
	@FindBy(xpath = "//*[@type='application/pdf']")
	public WebElementFacade Quickuserguide_pdf;

}
