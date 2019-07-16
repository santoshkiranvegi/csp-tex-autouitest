package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class Description_ChildEditPage extends BasePage {

@FindBy(xpath = "//TR/TD[normalize-space()='Add Easement: S/T EASE - EXISTING S/T EASE - NO TIME LIMIT S/T EASE - TIME LIMITED S/T EASE FOR RE-ENTRY - NO TIME LIMIT S/T EASE FOR RE-ENTRY - TIME LIMITED S/T EASE IN GROSS - NO TIME LIMIT S/T EASE IN GROSS - TIME LIMITED T/W EASE - EXISTING T/W EASE - NO TIME LIMIT T/W EASE - TIME LIMITED WHOLE PIN S/T EASE AS IN WHOLE PIN S/T EASE IN GROSS AS IN']/INPUT[1]")
public WebElementFacade Add_WebButton;

@FindBy(xpath = "//TR/TD[normalize-space()='Block Number:']/INPUT[1]")
public WebElementFacade BlockNumber_WebEdit;

@FindBy(xpath = "//FORM[1]/DIV[2]/TEXTAREA[1]")
public WebElementFacade Description_WebEdit;

@FindBy(xpath = "//TR/TD/SELECT[normalize-space()='S/T EASE - EXISTING S/T EASE - NO TIME LIMIT S/T EASE - TIME LIMITED S/T EASE FOR RE-ENTRY - NO TIME LIMIT S/T EASE FOR RE-ENTRY - TIME LIMITED S/T EASE IN GROSS - NO TIME LIMIT S/T EASE IN GROSS - TIME LIMITED T/W EASE - EXISTING T/W EASE - NO TIME LIMIT T/W EASE - TIME LIMITED WHOLE PIN S/T EASE AS IN WHOLE PIN S/T EASE IN GROSS AS IN']")
public WebElementFacade EasementList_WebList;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/SELECT[1]")
public WebElementFacade Estate_WebList;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/INPUT[1]")
public WebElementFacade French_WebCheckBox;

@FindBy(xpath = "//TD/SELECT[normalize-space()='CITY OF HAMILTON']")
public WebElementFacade LowerMunicipality_WebList;

@FindBy(xpath = "//FORM[1]/DIV[2]/SPAN[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/SELECT[2]")
public WebElementFacade Qualifier_WebList;

@FindBy(xpath = "//TD[5]/SELECT[1]")
public WebElementFacade UpperMunicipality_WebList;

}
