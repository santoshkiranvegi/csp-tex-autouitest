package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DocumentViewPopupPage extends BasePage {

@FindBy(xpath = "//TABLE[11]/TBODY[1]/TR[1]/TD[2]/P[1]/INPUT[1]")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//TABLE[@id='DocView']")
public WebElementFacade RegistrationNumber_WebTable;

}
