package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class InternalProcessingNotesPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='abortBtn']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[2]")
public WebElementFacade Commit_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR/TH[normalize-space()='Internal Processing Notes']")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//TEXTAREA[@id='processingNote']")
public WebElementFacade Notes_WebEdit;

}
