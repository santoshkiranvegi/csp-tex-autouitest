package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DescriptionPage extends BasePage {

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR[normalize-space()='SUBJECT TO AN EASEMENT OVER IN FAVOUR OF UNTIL AS IN']/TD[1]/INPUT[1]")
public WebElementFacade AddEasement1_WebCheckBox;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='SUBJECT TO AN EASEMENT OVER IN FAVOUR OF UNTIL AS IN']/INPUT[4]")
public WebElementFacade AsIn1_WebEdit;

@FindBy(xpath = "//TR/TD[normalize-space()='Block Number:']/INPUT[1]")
public WebElementFacade BlockNumber0_WebEdit;

@FindBy(xpath = "//FORM[1]/DIV[2]/TEXTAREA[1]")
public WebElementFacade Description0_WebEdit;

@FindBy(xpath = "//TR[normalize-space()='SUBJECT TO AN EASEMENT AS IN']/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[3]/INPUT[1]")
public WebElementFacade EasementAsIn0_WebEdit;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/SELECT[1]")
public WebElementFacade Estate0_WebList;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='SUBJECT TO AN EASEMENT OVER IN FAVOUR OF UNTIL AS IN']/INPUT[2]")
public WebElementFacade FavorOf1_WebEdit;

@FindBy(xpath = "//TABLE[@id='hostMainPageTable']/TBODY[1]/TR[1]/TD[2]/DIV[1]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/INPUT[1]")
public WebElementFacade French0_WebCheckBox;

@FindBy(xpath = "//TD/SELECT[normalize-space()='CITY OF HAMILTON']")
public WebElementFacade LowerMunicipality0_WebList;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='SUBJECT TO AN EASEMENT OVER IN FAVOUR OF UNTIL AS IN']/INPUT[1]")
public WebElementFacade Over1_WebEdit;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/SELECT[2]")
public WebElementFacade Qualifier0_WebList;

@FindBy(xpath = "//TR/TD/SPAN[normalize-space()='LAND TITLES']/SPAN[1]")
public WebElementFacade RegSystem_WebElement;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='SUBJECT TO AN EASEMENT OVER IN FAVOUR OF UNTIL AS IN']/INPUT[3]")
public WebElementFacade Until1_WebEdit;

}
