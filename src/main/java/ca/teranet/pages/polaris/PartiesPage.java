package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PartiesPage extends BasePage {

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[3]")
public WebElementFacade PartyFrom_MoreNames_WebButton;

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[2]")
public WebElementFacade PartyFrom_RemoveAll_WebButton;

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[1]")
public WebElementFacade PartyFrom_RemoveSelected_WebButton;

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[6]")
public WebElementFacade PartyTo_MoreNames_WebButton;

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[5]")
public WebElementFacade PartyTo_RemoveAll_WebButton;

@FindBy(xpath = "//DIV[@id='partiesContent']/INPUT[4]")
public WebElementFacade PartyTo_RemoveSelected_WebButton;

}
