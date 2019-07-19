package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PendingBulkEditsPage extends BasePage {

@FindBy(xpath = "//TR[1]/TD[2]/INPUT[2]")
public WebElementFacade AddMoreRows_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//TR[2]/TD[3]/INPUT[1]")
public WebElementFacade No_WebButton;

@FindBy(xpath = "//TABLE[@id='bulkBulkEditContent']")
public WebElementFacade PendingBulkEditsContent_WebTable;

@FindBy(xpath = "//TR[4]/TD[1]/INPUT[1]")
public WebElementFacade Remove_WebButton;

@FindBy(xpath = "//TR[2]/TD[2]/INPUT[1]")
public WebElementFacade Yes_WebButton;

}
