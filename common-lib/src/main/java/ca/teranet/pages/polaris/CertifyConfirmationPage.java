package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CertifyConfirmationPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='message']")
public WebElementFacade CertificationResult_WebTable;

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade Confirmation_WebElement;

@FindBy(xpath = "//INPUT[@id='submitNextInQueue']")
public WebElementFacade NextInMyQueue_WebButton;

@FindBy(xpath = "//TABLE[@id='message']/TBODY[1]/TR[1]/TD[1]/A[1]")
public WebElementFacade PlanNumber_Link;

@FindBy(xpath = "//TABLE[@id='message']/TBODY[1]/TR[1]/TD[1]")
public WebElementFacade RefPlanConfirmationMsg_WebElement;

}
