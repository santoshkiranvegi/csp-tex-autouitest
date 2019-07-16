package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class WithdrawRegistrationPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='abortBtn']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//FORM[1]/P[1]/B[1]")
public WebElementFacade DocSummaryHeader_WebElement;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//FORM[1]/P[2]/INPUT[1]")
public WebElementFacade Proceed_WebButton;

@FindBy(xpath = "//INPUT[@id='regNo']")
public WebElementFacade RegistrationNumber_WebEdit;

}
