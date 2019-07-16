package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegisterAttrDetailPage extends BasePage {

@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='Title Qualifier **SUBJECT TO SUBSECTION 44(1) OF THE LAND TITLES ACT, EXCEPT PARAGRAPHS 3 AND 14 AND * ** PROVINCIAL SUCCESSION DUTIES AND EXCEPT PARAGRAPH 11 AND ESCHEATS OR FORFEITURE ** ** TO THE CROWN UP TO THE DATE OF REGISTRATION WITH AN ABSOLUTE TITLE. ** NOTE: THE NO DEALINGS INDICATOR IS IN EFFECT ON THIS PROPERTY']")
public WebElementFacade DetailsView_WebTable;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD/DIV/TABLE[normalize-space()='Registration NumberRegistration DateDocument TypeParty ToDocument RemarksStatusDeleted? A433098 1993/06/18AGREEMENTCITY OF BRANTFORD CERTIFIED No A458381 1995/06/09AGREEMENTCITY OF BRANTFORD CERTIFIED No A467553 1996/03/25AGREEMENTCERTIFIED No A468028 1996/04/11AGREEMENTCITY OF BRANTFORD CERTIFIED No A468415 1996/04/22APPLICATION TO REGISTER BYLAWNO. 1 CERTIFIED No A468416 1996/04/22APPLICATION TO REGISTER BYLAWNO. 2 CERTIFIED No A468417 1996/04/22APPLICATION TO REGISTER BYLAWNO. 3 CERTIFIED No A468418 1996/04/22TRANSFER EASEMENTUNION GAS LTD. CERTIFIED No BC24505 2003/10/10CONDOMINIUM BYLAWBY-LAW NO. 4 CERTIFIED No BC132694 2008/02/08TRANSFERUHLMAN, JAMES RANDALL UHLMAN, SANDRA LEE CERTIFIED No BC132695 2008/02/08CHARGE/MORTGAGESCOTIA MORTGAGE CORPORATION CERTIFIED No']")
public WebElementFacade Documents_WebTable;

@FindBy(xpath = "//TR/TD/TABLE/TBODY[normalize-space()='Title Qualifier NOTE: THIS PIN IS IN THE PROCESS OF BEING RETIRED BUT THE PROCESS IS NOT YET COMPLETED']/TR[1]/TD[1]")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD/DIV/TABLE[normalize-space()='NameCapacityShare POLARIS OWNER1 POLARIS OWNER2 JOINT ACCOUNT 50% POLARIS OWNER3 PARTNER POLARIS OWNER4 POLARIS OWNER5 FIDUCIAIRE POLARIS OWNER6 TENANTS COMMUNS 20% POLARIS OWNER7 FIRM NAME 10%']")
public WebElementFacade Owners_WebTable;

@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='PIN16912-0147 (LT)ACTIVE WENTWORTH (62) Estate:FEE SIMPLE Qualifier: ABSOLUTE']")
public WebElementFacade PINInfo_WebTable;

@FindBy(xpath = "//TD/TABLE/TBODY/TR[normalize-space()='1 of 1']/TD[2]/INPUT[1]")
public WebElementFacade ReturnToRegisterView_WebButton;

}