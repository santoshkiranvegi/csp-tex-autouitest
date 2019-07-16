package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class OpenCondominiumPage extends BasePage {

@FindBy(xpath = "//input[@name='propertyItem.newBlockNumber']")
public WebElementFacade BlockNumber_WebEdit;

@FindBy(xpath = "//INPUT[@id='cancelWIPButton']")
public WebElementFacade CancelWIP_WebButton;

@FindBy(xpath = "//INPUT[@value='Cancel']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//input[@name='propertyItem.relatedDocument']")
public WebElementFacade PlanNumber_WebEdit;

@FindBy(xpath = "//input[@value='Proceed']")
public WebElementFacade Proceed_WebButton;

@FindBy(xpath = "//input[@name='propertyItem.numNewProperties']")
public WebElementFacade RemnantNumber_WebEdit;

@FindBy(xpath = "//INPUT[@id='retrieveWIPButton']")
public WebElementFacade RetrieveWIP_WebButton;

@FindBy(xpath = "//input[@name='singlePin.block']")
public WebElementFacade TargetBlock_WebEdit;

@FindBy(xpath = "//input[@name='singlePin.property']")
public WebElementFacade TargetPIN_WebEdit;

}
