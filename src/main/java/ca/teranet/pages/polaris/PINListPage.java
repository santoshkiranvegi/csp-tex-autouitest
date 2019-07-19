package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PINListPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD[normalize-space()='- 16909-0139 (LT) Highways Register 1 of 1']/INPUT[4]")
public WebElementFacade AddHWY_WebButton;

@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD[normalize-space()='- 16909-0139 (LT) Highways Register 1 of 1']/INPUT[3]")
public WebElementFacade AddPIN_WebButton;

@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD[normalize-space()='- 16909-0139 (LT) Highways Register 1 of 1']/INPUT[5]")
public WebElementFacade AddTCPL_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR/TD[normalize-space()='2 of 3']/INPUT[1]")
public WebElementFacade First_WebButton;

@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
public WebElementFacade GoToPage_WebButton;

@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD/DIV/A[normalize-space()='Highways Register']")
public WebElementFacade HighwaysRegister_Link;

@FindBy(xpath = "//TR/TD[normalize-space()='2 of 3']/INPUT[4]")
public WebElementFacade Last_WebButton;

@FindBy(xpath = "//TR/TD[normalize-space()='2 of 3']/INPUT[3]")
public WebElementFacade Next_WebButton;

@FindBy(xpath = "//INPUT[@id='addRemovePinForm.pinToAdd.block']")
public WebElementFacade PINFrom_WebEdit;

@FindBy(xpath = "//INPUT[@id='addRemovePinForm.pinToAdd.property']")
public WebElementFacade PINTo_WebEdit;

@FindBy(xpath = "//INPUT[@id='gotoPageValue']")
public WebElementFacade PageValue_WebEdit;

@FindBy(xpath = "//TR/TD[normalize-space()='2 of 3']/INPUT[2]")
public WebElementFacade Previous_WebButton;

@FindBy(xpath = "//TABLE[@id='pinLinks']/TBODY/TR/TD/DIV/A[normalize-space()='TransCanada Pipeline']")
public WebElementFacade TransCanadaPipeline_Link;

}
