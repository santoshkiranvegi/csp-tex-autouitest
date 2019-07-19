package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class WorkQListPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='workQueueTable']")
public WebElementFacade WorkQList_WebTable;

@FindBy(xpath = "//FORM[1]/SPAN[2]/B[1]")
public WebElementFacade WorkQueueList_WebElement;

}
