package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class OpenSubdivisionPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
public WebElementFacade CancelWIP_WebButton;

@FindBy(xpath = "//INPUT[@id='abortBtn']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR[normalize-space()='Subdivision Plan number']/TD[2]/INPUT[1]")
public WebElementFacade PlanNumber_WebEdit;

@FindBy(xpath = "//FORM[1]/P[1]/INPUT[1]")
public WebElementFacade Proceed_WebButton;

@FindBy(xpath = "//TR[normalize-space()='Number of Remnant Properties']/TD[2]/INPUT[1]")
public WebElementFacade RemnantNumber_WebEdit;

@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
public WebElementFacade RetrieveWIP_WebButton;

@FindBy(xpath = "//TR/TD[normalize-space()='-']/INPUT[1]")
public WebElementFacade TargetBlock_WebEdit;

@FindBy(xpath = "//TR/TD[normalize-space()='-']/INPUT[2]")
public WebElementFacade TargetPIN_WebEdit;

}
