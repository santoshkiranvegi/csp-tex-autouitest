package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DeferOrCorrectionPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='abortBtn']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//INPUT[@id='saveNotes']")
public WebElementFacade Commit_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TEXTAREA[@id='usertext']")
public WebElementFacade InternalProcessingNotes_WebEdit;

}
