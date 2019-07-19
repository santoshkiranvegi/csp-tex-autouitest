package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChangeMyPasswordPage extends BasePage {

	// Current password text box
	@FindBy(xpath = "//label[text()='Current password']/..//following-sibling::td//input[@type='password']")
	public WebElementFacade CurrentPassword_Text_Box;

	// New password text box
	@FindBy(xpath = "//label[text()='New password']/..//following-sibling::td//input[@type='password']")
	public WebElementFacade Newpassword_Text_Box;

	// Confirm password text box
	@FindBy(xpath = "//label[text()='Confirm password']/..//following-sibling::td//input[@type='password']")
	public WebElementFacade Confirmpassword_Text_Box;

	// Save button
	@FindBy(xpath = "//a[@id='saveButton']")
	public WebElementFacade Save_btn;

	// Reset button
	@FindBy(xpath = "//a[@id='resetButton']")
	public WebElementFacade Reset_btn;

	// Error Message
	@FindBy(xpath = "(//div[@class='errorPanel'])[1]")
	public WebElementFacade ErrorMessage_lbl;

	// Success Message
	@FindBy(xpath = "//div[@id='saveSuccessPanelDiv']/div[@class='saveSuccessPanel']")
	public WebElementFacade SuccessMessage_lbl;

}
