package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ApplicationErrorPage extends BasePage {

@FindBy(xpath = "//TEXTAREA[@id='issueDesc']")
public WebElementFacade Description_WebEdit;

@FindBy(xpath = "//FORM[@id='generalExceptionForm']/INPUT[3]")
public WebElementFacade Submit_WebButton;

}
