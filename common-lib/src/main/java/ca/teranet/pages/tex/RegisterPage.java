package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends BasePage {

	@FindBy(xpath = "//h3")
	public WebElementFacade title_profileDetails;

	@FindBy(xpath = "//form[@id='voUserDetail']/p[2]")
	public WebElementFacade note_register;

	@FindBy(xpath = "//input[@id='email']")
	public WebElementFacade input_email;

	@FindBy(xpath = "//input[@id='companyName']")
	public WebElementFacade input_companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElementFacade input_firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElementFacade input_lastName;

	@FindBy(xpath = "//input[@id='phone']")
	public WebElementFacade input_phone;

	@FindBy(xpath = "//input[@id='fax']")
	public WebElementFacade input_fax;

	@FindBy(xpath = "//input[@id='street']")
	public WebElementFacade input_street;

	@FindBy(xpath = "//input[@id='city']")
	public WebElementFacade input_city;

	@FindBy(xpath = "//select[@id='province']")
	public WebElementFacade select_province;

	@FindBy(xpath = "//input[@id='postal']")
	public WebElementFacade input_postalCode;

	@FindBy(xpath = "//input[@id='password_1']")
	public WebElementFacade input_password;

	@FindBy(xpath = "//input[@id='password_2']")
	public WebElementFacade input_confirmPassword;

	@FindBy(xpath = "//input[@id='acceptedTermsConditions1']")
	public WebElementFacade checkbox_acceptTerms;

	@FindBy(xpath = "//form[@id='voUserDetail']//a[contains(.,'Accept Terms and Conditions')]")
	public WebElementFacade link_AcceptTerms;

	@FindBy(xpath = "//div[@id='main-content_w']/a[contains(.,'Benefits of Registration')]")
	public WebElementFacade link_Benefits;

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//div[id='main-content_w']")
	public WebElementFacade retMsg_register;

	@FindBy(xpath = "//table//a")
	public WebElementFacade link_homePage;

	// ============== negative ==================================
	// error message
	@FindBy(xpath = "//span[@id='Email.errors']")
	public WebElementFacade page_errorMessage;

}
