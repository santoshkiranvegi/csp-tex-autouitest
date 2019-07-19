package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class WorkQFilterPage extends BasePage {

@FindBy(xpath = "//SELECT[@id='filterProcessState']")
public WebElementFacade ProcessState_WebList;

@FindBy(xpath = "//INPUT[@id='filterRegistrationFromDate']")
public WebElementFacade RegDateFrom_WebEdit;

@FindBy(xpath = "//INPUT[@id='filterRegistrationToDate']")
public WebElementFacade RegDateTo_WebEdit;

@FindBy(xpath = "//INPUT[@id='filterRegistrationNumberFrom']")
public WebElementFacade RegNumberFrom_WebEdit;

@FindBy(xpath = "//INPUT[@id='filterRegistrationNumberTo']")
public WebElementFacade RegNumberTo_WebEdit;

@FindBy(xpath = "//SELECT[@id='filterReservedStatus']")
public WebElementFacade ReservedStatus_WebList;

@FindBy(xpath = "//INPUT[@id='submitQuery']")
public WebElementFacade SubmitQuery_WebButton;

@FindBy(xpath = "//SELECT[@id='filterUser']")
public WebElementFacade User_WebList;

}
