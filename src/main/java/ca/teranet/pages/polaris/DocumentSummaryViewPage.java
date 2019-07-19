package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DocumentSummaryViewPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='abortBtn']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//TABLE[@id='DocView']")
public WebElementFacade DocumentSummary_WebTable;

@FindBy(xpath = "//FORM[1]/P[2]/INPUT[1]")
public WebElementFacade Proceed_WebButton;

@FindBy(xpath = "//TD[@id='docNumber']/TABLE/TBODY/TR[normalize-space()='HT6032031']/TD[1]")
public WebElementFacade RegNumber_WebElement;

}
