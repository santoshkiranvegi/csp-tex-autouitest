package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class AdminPage extends BasePage {

@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ChangeLRO_WebButton;

@FindBy(xpath = "//TR/TD/SELECT[normalize-space()='POLARIS TRAINING OFFICE (0) BRANT (2) BRUCE (3) OTTAWA-CARLETON (4) DUFFERIN (7) ESSEX (12) FRONTENAC (13) KENT (24) NIAGARA NORTH (30) MIDDLESEX (33) OXFORD (41) PETERBOROUGH (45) RAINY RIVER (48) SUDBURY (53) VICTORIA (57) NIAGARA SOUTH (59) WELLINGTON (61) WENTWORTH (62) TORONTO (80) HEAD OFFICE (90) TERANET TRAINING OFFICE (99)']")
public WebElementFacade LROId_WebList;

}
