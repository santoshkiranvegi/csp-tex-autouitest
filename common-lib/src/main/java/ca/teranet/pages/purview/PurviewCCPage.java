package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PurviewCCPage extends BasePage {

	// login button

	// user name
	@FindBy(xpath = "//input[@name='j_username']")
	public WebElementFacade input_header_username;

	// password
	@FindBy(xpath = "//input[@name='j_password']")
	public WebElementFacade input_header_password;

	// login button
	@FindBy(xpath = "//input[@name='login_button']")
	public WebElementFacade login_button;

	// logout link
	@FindBy(xpath = "//a[@id='btn_logout']")
	public WebElementFacade logout_link;

	// company text box
	@FindBy(xpath = "(//input[@class='gwt-TextBox'])[1]")
	public WebElementFacade company_input_box;

	// User text box
	@FindBy(xpath = "(//input[@class='gwt-TextBox'])[2]")
	public WebElementFacade user_input_box;

	// search button
	@FindBy(xpath = "//button[@class='GICHABMD' and text()='Search']")
	public WebElementFacade search_btn;

	// search results in home page
	public WebElementFacade search_results_selection(String fieldName) {
		return findBy("//div[text()='" + fieldName + "']");
	}

	// field name verification in edit screen
	public WebElementFacade search_results_details(String fieldName) {
		return findBy("//span[@class='gwt-InlineLabel' and text()='" + fieldName + "']");
	}

	// company info edit button
	@FindBy(xpath = "(//div[@class='GICHABMOM']/a[text()='Edit'])[1]")
	public WebElementFacade companyinfo_edit_btn;

	// password change edit button
	@FindBy(xpath = "(//div[@class='GICHABMOM']/a[text()='Edit'])[2]")
	public WebElementFacade password_edit_btn;

	// active flag check box
	@FindBy(xpath = "//label[text()='Active:']/..//input")
	public WebElementFacade active_checkbox;

	// password input box
	@FindBy(xpath = "//label[text()='Password:']/..//input")
	public WebElementFacade password_change_input;

	// personal info edit button
	@FindBy(xpath = "(//div[@class='GICHABMOM']/a[text()='Edit'])[3]")
	public WebElementFacade personal_info_edit_btn;

	// role- features edit button
	@FindBy(xpath = "(//div[@class='GICHABMOM']/a[text()='Edit'])[4]")
	public WebElementFacade role_edit_btn;

	// search results in home page
	public WebElementFacade role_checkbox_select(String fieldName) {
		return findBy("//div[contains(text(),'" + fieldName + "')]/../preceding-sibling::td/div/input");
	}

	// save button
	@FindBy(xpath = "//div[@class='GICHABMOM']/a[not(contains(@style,'display: none;')) and text()='Save']")
	public WebElementFacade save_btn;

	// Cancel button
	@FindBy(xpath = "//div[@class='GICHABMOM']/a[not(contains(@style,'display: none;')) and text()='Cancel']")
	public WebElementFacade cancel_btn;

	// successfull message
	@FindBy(xpath = "//div[@style='background: yellow;']")
	public WebElementFacade profile_upate_message;

	// first name input box
	@FindBy(xpath = "//label[text()='First Name:']/..//input")
	public WebElementFacade firstname_input_box;

	// last name input box
	@FindBy(xpath = "//label[text()='Last Name:']/..//input")
	public WebElementFacade lastname_input_box;

	// title input box
	@FindBy(xpath = "//label[text()='Title:']/..//input")
	public WebElementFacade title_input_box;

	// Company input box
	@FindBy(xpath = "//label[text()='Company:']/..//input")
	public WebElementFacade company_edit_input_box;

	// Address input box
	@FindBy(xpath = "//label[text()='Street:']/..//input")
	public WebElementFacade address_input_box;

	// City input box
	@FindBy(xpath = "//label[text()='City:']/..//input")
	public WebElementFacade city_input_box;

	// Subscriptions Link
	@FindBy(xpath = "//div[text()='Subscriptions']")
	public WebElementFacade subscriptions_Link;

	// max counter value text box
	@FindBy(xpath = "(//div[@class='dialogMiddleCenterInner dialogContent']//input)[3]")
	public WebElementFacade MaximunCounterTextBox;

	// save button
	@FindBy(xpath = "//div[@class='dialogMiddleCenterInner dialogContent']//button[text()='Save']")
	public WebElementFacade saveButton;

	// add new button
	@FindBy(xpath = "(//button[text()='Add New'])[9]")
	public WebElementFacade addNewButton;

}
