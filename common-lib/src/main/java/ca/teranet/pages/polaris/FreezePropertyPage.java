package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class FreezePropertyPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//FORM[1]/P[1]")
public WebElementFacade FreezePropertyMsg_WebElement;

@FindBy(xpath = "//FORM[1]/H2[1]")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//FORM[1]/INPUT[3]")
public WebElementFacade No_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[2]")
public WebElementFacade Yes_WebButton;

}
