package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ViewBatchQPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='batchQueueTable']")
public WebElementFacade BatchQ_WebTable;

@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='1 of 1']/INPUT[2]")
public WebElementFacade Next_WebButton;

@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='1 of 1']/INPUT[1]")
public WebElementFacade Prev_WebButton;

}
