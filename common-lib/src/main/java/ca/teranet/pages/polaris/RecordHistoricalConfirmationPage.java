package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RecordHistoricalConfirmationPage extends BasePage {

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade RecordingHistoricalResults_WebElement;

@FindBy(xpath = "//TABLE[@id='message']")
public WebElementFacade RecordingHistoricalResults_WebTable;

}
