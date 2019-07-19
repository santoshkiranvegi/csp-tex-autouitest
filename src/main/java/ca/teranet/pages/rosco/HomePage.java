package ca.teranet.pages.rosco;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends BasePage {

	@FindBy(xpath = "//div[@id='logo-home']")
	public WebElementFacade logo_rosco;

	@FindBy(xpath = "//a[@id='cart']")
	public WebElementFacade header_cart;

	@FindBy(xpath = "//a[@href='javascript: show_login_box();']")
	public WebElementFacade header_registerAndLogin;

	// attribute href contains 'fr' -- French
	@FindBy(xpath = "//a[contains(@href, 'javascript:toggleLanguage')]")
	public WebElementFacade header_language;

	// header link
	@FindBy(xpath = "//a[@href='/lro/logout']")
	public WebElementFacade header_logout;

	@FindBy(xpath = "//a[@href=''/lro/userRegistration/initRetrieveProfile']")
	public WebElementFacade header_manageProfile;

	@FindBy(xpath = "//input[contains(@id,'btn-endsession')]")
	public WebElementFacade button_endSession;

	// login box opened from header
	@FindBy(xpath = "//form[@id='login']//h2")
	public WebElementFacade title_login;

	@FindBy(xpath = "//input[@id='login_box_userid']")
	public WebElementFacade input_header_username;

	@FindBy(xpath = "//input[@id='login_box_password']")
	public WebElementFacade input_header_password;

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

	// note: rosco is multiple languages support
	@FindBy(xpath = "//a[contains(.,'Home') or contains(.,'Accueil')]")
	public WebElementFacade menu_home;

	@FindBy(xpath = "//a[contains(.,'Services')]")
	public WebElementFacade menu_services;

	@FindBy(xpath = "//a[contains(.,'Support') or contains(.,'Soutien')]")
	public WebElementFacade menu_support;

	@FindBy(xpath = "//div[@id='services-menu']/ul[1]/li/a]")
	public WebElementFacade menu_searchPropertyViewMap;

	@FindBy(xpath = "//div[@id='services-menu']/ul[2]/li/a]")
	public WebElementFacade menu_documentView;

	@FindBy(xpath = "//div[@id='services-menu']/ul[3]/li/a]")
	public WebElementFacade menu_searchWrits;

	@FindBy(xpath = "//div[@id='services-menu']/ul[4]/li/a]")
	public WebElementFacade menu_browseMap;

	@FindBy(xpath = "//div[@id='services-menu']")
	public WebElementFacade obj_servicesMenu;

	// ============================== Terms and Condition page ================================
	// getDriver().switchTo().frame(homePage.frame_terms);
	@FindBy(xpath = "//iframe[@id='termscontent']")
	public WebElementFacade frame_terms;

	@FindBy(xpath = "//input[@name='docviewtcaccepted']")
	public WebElementFacade button_accept;

	@FindBy(xpath = "//input[@name='Cancel']")
	public WebElementFacade button_decline;

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

	@FindBy(xpath = "//div[@class='error']")
	public WebElementFacade page_errorMessage;

}
