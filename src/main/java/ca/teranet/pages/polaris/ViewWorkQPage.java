package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ViewWorkQPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//SELECT[@id='filterProcessState']")
public WebElementFacade ProcessState_WebList;

@FindBy(xpath = "//INPUT[@id='submitQuery']")
public WebElementFacade SubmitQuery_WebButton;

@FindBy(xpath = "//FORM[1]/TABLE[2]")
public WebElementFacade WorkQList_WebTable;

@FindBy(xpath = "//FORM[1]/P[1]/B[1]")
public WebElementFacade WorkQueueFilter_WebElement;

}
