package ca.teranet.pages.gwh;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ManagePasswordPage extends BasePage {
	@FindBy(xpath = "//a[text()='Manage Password']")
	public WebElementFacade managePasswordTab;

	public By passwordChangeFrame = By.xpath("//iframe[@id='passwordchange']");

	@FindBy(xpath = "//input[@id='oldPassword']")
	public WebElementFacade oldPassword_textBox;

	@FindBy(xpath = "//input[@id='newPassword']")
	public WebElementFacade newPassword_textBox;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	public WebElementFacade confirmPassword_textBox;

	@FindBy(xpath = "//input[@id='submitButton']")
	public WebElementFacade updatePasswordBtn;

	@FindBy(xpath = "//li[@class='pwChangeError']")
	public WebElementFacade passwordChangeMessage;

}
