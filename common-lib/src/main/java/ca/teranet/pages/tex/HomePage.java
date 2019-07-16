package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends BasePage {

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	@FindBy(xpath = "//div[@id='logo']")
	public WebElementFacade logo_teranet;

	@FindBy(xpath = "//div[@id='express']")
	public WebElementFacade logo_teranetExpress;

	@FindBy(xpath = "//a[@id='loginarrow']")
	public WebElementFacade header_registerAndLogin;

	@FindBy(xpath = "//a[@id='cart']")
	public WebElementFacade header_shoppingCart;

	@FindBy(xpath = "//input[@id='login_box_userid']")
	public WebElementFacade input_header_username;

	@FindBy(xpath = "//input[@id='login_box_password']")
	public WebElementFacade input_header_password;

	@FindBy(xpath = "//input[@name='repl_name']")
	public WebElementFacade button_header_login;

	@FindBy(xpath = "//a[@class='btnlnkL' and contains(.,'Register')]")
	public WebElementFacade link_header_register;

	@FindBy(xpath = "//a[@class='btnlnkL' and contains(.,'Forgot Password')]")
	public WebElementFacade link_header_forgotPwd;

	@FindBy(xpath = "//a[@id='main-1']")
	public WebElementFacade button_searchName;

	@FindBy(xpath = "//a[@id='main-2']")
	public WebElementFacade button_searchProperty;

	@FindBy(xpath = "//a[@id='main-3']")
	public WebElementFacade button_documentView;

	@FindBy(xpath = "//a[@id='main-4']")
	public WebElementFacade button_searchWrits;

	@FindBy(xpath = "//a[@id='main-5']")
	public WebElementFacade button_OWL;

	@FindBy(xpath = "//a[@id='main-6']")
	public WebElementFacade button_writFiling;

	@FindBy(xpath = "//a[contains(.,'Home')]")
	public WebElementFacade menu_home;

	@FindBy(xpath = "//a[contains(.,'Services')]")
	public WebElementFacade menu_services;

	@FindBy(xpath = "//a[contains(.,'Teraview Users')]")
	public WebElementFacade menu_teraviewUser;

	@FindBy(xpath = "//a[contains(.,'Support')]")
	public WebElementFacade menu_support;

	@FindBy(xpath = "//a[contains(.,'Search Name')]")
	public WebElementFacade menu_searchName;

	@FindBy(xpath = "//a[contains(.,'Search Property')]")
	public WebElementFacade menu_searchProperty;

	@FindBy(xpath = "//a[contains(.,'Document View')]")
	public WebElementFacade menu_documentView;

	@FindBy(xpath = "//a[contains(.,'Search Writs')]")
	public WebElementFacade menu_searchWrits;

	@FindBy(xpath = "//a[contains(.,'OWL')]")
	public WebElementFacade menu_OWL;

	@FindBy(xpath = "//a[contains(.,'WritFiling')]")
	public WebElementFacade menu_writFiling;

	// Register/Login page
	@FindBy(xpath = "//form[@id='login']//h2")
	public WebElementFacade title_login;

	@FindBy(xpath = "//input[@id='j_username']")
	public WebElementFacade input_userName;

	@FindBy(xpath = "//input[@id='j_password']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@id='Email']")
	public WebElementFacade input_email;

	@FindBy(xpath = "//input[@class='button' and @id='btn-login']")
	public WebElementFacade button_login;

	@FindBy(xpath = "//input[@class='button' and @id='btn-reset']")
	public WebElementFacade button_reset;

	@FindBy(xpath = "//input[@class='button' and @id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//div[@id='login']//a[contains(.,'Forgot Password')]")
	public WebElementFacade link_forgotPwd;

	@FindBy(xpath = "//div[@id='login']//a[contains(.,'Register')]")
	public WebElementFacade link_register;

	@FindBy(xpath = "//h1[@id='page-title' or contains(@class,'w')]")
	public WebElementFacade pageTitle;

	@FindBy(xpath = "//a[@href='/csp/logout']")
	public WebElementFacade link_logout;

	@FindBy(xpath = "//a[@href='/csp/userRegistration/initRetrieveProfile']")
	public WebElementFacade link_manageProfile;

	@FindBy(xpath = "//*[@id='footer-links']//a[contains(.,'Terms of Use')]")
	public WebElementFacade link_footer_terms;

	@FindBy(xpath = "//*[@id='footer-links']//a[contains(.,'Privacy Policy')]")
	public WebElementFacade link_footer_policy;

	@FindBy(xpath = "//div[@id='main-content_w']")
	public WebElementFacade div_mainContent;

	@FindBy(xpath = "//div[@id='services-menu']")
	public WebElementFacade obj_servicesMenu;

	@FindBy(xpath = "//p[@id='pErrormsg']")
	public WebElementFacade box_errorMessage;

	@FindBy(xpath = "//div[@id='main-content_w']//*[@class='error']")
	public WebElementFacade page_errorMessage;

	@FindBy(xpath = "//object[@id='main-cspwef']")
	public WebElementFacade page_wef;
}
