package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegConfirmationPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='Registration Number']")
public WebElementFacade Confirmation_WebTable;

@FindBy(xpath = "//FORM[1]/INPUT[3]")
public WebElementFacade NewSubmission_WebButton;

@FindBy(xpath = "//FORM[1]/P[2]/SPAN[1]")
public WebElementFacade RemoveConfirm_WebElement;

@FindBy(xpath = "//FORM[1]/INPUT[4]")
public WebElementFacade Remove_WebButton;

}
