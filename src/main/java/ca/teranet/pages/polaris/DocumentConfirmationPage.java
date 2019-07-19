package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DocumentConfirmationPage extends BasePage {

@FindBy(xpath = "//TR[normalize-space()='Withdraw Registration']/TD[1]")
public WebElementFacade ConfirmationHeader_WebElement;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ConfirmationMsg_WebTable;

}
