package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CorrectionConfirmationPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='messages']/TBODY[1]/TR[1]/TD[1]/FONT[1]")
public WebElementFacade ConfirmationMsg_WebElement;

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade Confirmation_WebElement;

@FindBy(xpath = "//TABLE[@id='message']")
public WebElementFacade CorrectionResult_WebTable;

}
