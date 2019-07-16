package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class DocViewAttrDetailPage extends BasePage {

@FindBy(xpath = "//TR/TD[normalize-space()='Name POLARIS OWNER1 POLARIS OWNER2 POLARIS OWNER3 POLARIS OWNER4 POLARIS OWNER5 POLARIS OWNER6 POLARIS OWNER7']/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]")
public WebElementFacade PartyFrom_WebTable;

@FindBy(xpath = "//TR/TD[normalize-space()='NameCapacityShare OWNER1 OWNER2 GENERAL PARTNER OWNER3 10% OWNER4 FIRM NAME 20% OWNER5 JOINT ACCOUNT 30% OWNER6 OFFICIAL GUARDIAN 25% OWNER7 PARTNER 15%']/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]")
public WebElementFacade PartyTo_WebTable;

@FindBy(xpath = "//FORM[1]/TABLE[1]")
public WebElementFacade PopupHeader_WebTable;

@FindBy(xpath = "//TR/TD[normalize-space()='PIN PIN Status Document Deleted Description PIN Specific Remarks 16912-0058 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0059 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0060 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0061 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0062 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0063 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS 16912-0064 (LT) Active No DIVIDE LAND TITLES PIN INTO 7 NEW PINS']/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]")
public WebElementFacade PropertiesAffectedSubsequentToRegistration_WebTable;

@FindBy(xpath = "//TD[2]/INPUT[1]")
public WebElementFacade ReturnToDocumentView_WebButton;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]")
public WebElementFacade TableLabel_WebElement;

}
