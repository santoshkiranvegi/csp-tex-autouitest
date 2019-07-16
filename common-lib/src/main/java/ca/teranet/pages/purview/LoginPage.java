package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

	// login button
	@FindBy(xpath = "//span[text()='Login']")
	public WebElementFacade login_button;

	@FindBy(xpath = "//div[@id='logo-home']")
	public WebElementFacade logo_rosco;

	@FindBy(xpath = "//a[@href='javascript: loginbox.show();']")
	public WebElementFacade header_login;

	// header link
	@FindBy(xpath = "//a[@href='/lroadmin/logout']")
	public WebElementFacade header_logout;

	// login box opened from header
	@FindBy(xpath = "//form[@id='login']//h2")
	public WebElementFacade title_login;

	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_header_username;

	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_header_password;

	// password reset screen title
	@FindBy(xpath = "//div[@id='content']//b[text()='Password Reset'] ")
	public WebElementFacade reset_password_header;

	// old password
	@FindBy(xpath = "//input[@name='oldPassword']")
	public WebElementFacade old_password;

	// new password
	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade new_password;

	// change password button
	@FindBy(xpath = "//input[@name='change-password-submit']")
	public WebElementFacade change_password_btn;

	// retype new password
	@FindBy(xpath = "//input[@name='retypePassword']")
	public WebElementFacade retype_new_password;

	// login error
	@FindBy(xpath = "//div[@class='login-error-message']")
	public WebElementFacade login_error;

	@FindBy(xpath = "//input[@name='repl_name']")
	public WebElementFacade button_header_login;

	@FindBy(xpath = "//div[@id='rosco-nav-property']/a")
	public WebElementFacade button_searchPropertyViewMap;

	@FindBy(xpath = "//div[@id='rosco-nav-document']/a")
	public WebElementFacade button_documentView;

	@FindBy(xpath = "//div[@id='rosco-nav-writs']/a")
	public WebElementFacade button_searchWrits;

	@FindBy(xpath = "//div[@id='rosco-nav-map']/a")
	public WebElementFacade button_browseMap;

	@FindBy(xpath = "//div[@id='rosco-nav-cash']/a")
	public WebElementFacade button_cashPayment;

	@FindBy(xpath = "//a[contains(.,'Home')]")
	public WebElementFacade menu_home;

	@FindBy(xpath = "//a[contains(.,'Services')]")
	public WebElementFacade menu_services;

	public WebElementFacade menu_searchPropertyViewMap(int instanceNo) {
		return findBy("(//a[contains(.,'Search Property & View Map')])[" + instanceNo + "]");
	}

	public WebElementFacade menu_documentView(int instanceNo) {
		return findBy("(//a[contains(.,'Document View')])[" + instanceNo + "]");
	}

	public WebElementFacade menu_searchWrits(int instanceNo) {
		return findBy("(//a[contains(.,'Search Writs')])[" + instanceNo + "]");
	}

	public WebElementFacade menu_browseMap(int instanceNo) {
		return findBy("(//a[contains(.,'Browse Map')])[" + instanceNo + "]");
	}

	public WebElementFacade menu_cashPayment(int instanceNo) {
		return findBy("(//a[contains(.,'Cash Payment')])[" + instanceNo + "]");
	}

	@FindBy(xpath = "//div[@id='services-menu']")
	public WebElementFacade obj_servicesMenu;

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	// ========================================================================================
	// login page for cash payment
	@FindBy(xpath = "//input[@id='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@id='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@name='login-submit']")
	public WebElementFacade button_login;

	// =========================================================================================
	// every page title
	@FindBy(xpath = "//h1[@id='page-title' or contains(@class,'w')]")
	public WebElementFacade pageTitle;

	// =========================================================================================
	// footer
	@FindBy(xpath = "//span[@class='links']/a[1]")
	public WebElementFacade link_footer_terms;

	@FindBy(xpath = "//span[@class='links']/a[2]")
	public WebElementFacade link_footer_policy;

	@FindBy(xpath = "//div[@id='footer-msg']")
	public WebElementFacade footer_message;

	// negative
	@FindBy(xpath = "//p[@id='pErrormsg']")
	public WebElementFacade box_errorMessage;

	@FindBy(xpath = "//*[@class='error']")
	public WebElementFacade page_errorMessage;

	// @FindBy(xpath = "//div[@id='main-content_w']")
	@FindBy(xpath = "//svg[@id='map_gc']")
	public WebElementFacade map;

}
