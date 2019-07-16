package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PropertyStatusPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR/TD[normalize-space()='Update Certified Property - Property Status']")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//FORM[1]/TABLE[3]")
public WebElementFacade PropertyStatusPINList_WebTable;

@FindBy(xpath = "//TD[3]/INPUT[1]")
public WebElementFacade Return_WebButton;

}
