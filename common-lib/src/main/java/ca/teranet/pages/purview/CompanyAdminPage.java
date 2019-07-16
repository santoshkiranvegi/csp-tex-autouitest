package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CompanyAdminPage extends BasePage {

	public WebElementFacade clickOnUserId(String userName) {
		return findBy("//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div[text()='" + userName + "']");
	}

	// Save button
	@FindBy(xpath = "(//a[@class='grey_button_sml']/span)[1]")
	public WebElementFacade Save_btn;

	// Company or User Logo save button
	@FindBy(xpath = "//a[@id='saveButton2']/span")
	public WebElementFacade image_Save_btn;

	// Cancel button
	@FindBy(xpath = "(//a[@class='grey_button_sml']/span)[2]")
	public WebElementFacade Cancel_btn;

	// Address text box
	@FindBy(xpath = "(//label[text()='Address']/../..//input[@class='inputTextBox'])[1]")
	public WebElementFacade address_input_box;

	// company text box
	@FindBy(xpath = "(//label[text()='Address 2']/../..//input[@class='inputTextBox'])[2]")
	public WebElementFacade company_input_box;

	// Postal Code text box
	@FindBy(xpath = "(//label[text()='Postal Code']/../..//input[@class='inputTextBox'])[1]")
	public WebElementFacade Postalode_input_box;

	// email id text box
	@FindBy(xpath = "(//label[text()='Postal Code']/../..//input[@class='inputTextBox'])[2]")
	public WebElementFacade emailId_input_box;

	// Phone text box
	@FindBy(xpath = "(//label[text()='Phone']/../..//input[@class='inputTextBox'])[2]")
	public WebElementFacade phone_input_box;

	// city text box
	@FindBy(xpath = "(//label[text()='City']/../..//input)[1]")
	public WebElementFacade city_Input_Box;

	// Dialog pop up
	@FindBy(xpath = "//div[@class='Dialog']//div[@id='feedbackbox']/p")
	public WebElementFacade popUpText;

	// Dialog pop up for success message
	@FindBy(xpath = "//div[@class='Dialog']//div[@id='feedbackbox']/div")
	public WebElementFacade SuccessMsgPopUp;

	// error message
	@FindBy(xpath = "//div[@id='content']//div[@class='errorPanel']")
	public WebElementFacade errorMsg;

	// Ok button in popup
	@FindBy(xpath = "//div[@class='Dialog']//a/span[text()='OK']")
	public WebElementFacade Ok_Btn_In_PopUp;

	public WebElementFacade user_selection(String username) {
		return findBy("//div[text()='" + username + "']");
	}

	public WebElementFacade feature_selection(String featureName) {
		return findBy("//div[contains(text(),'" + featureName + "')]/../following-sibling::td//input");
	}

	// Reset Button in profile page
	@FindBy(xpath = "(//span[contains(text(),'Reset')])[1]")
	public WebElementFacade resetBtn;

}
