package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class Documents_BulkEditPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='addDocument']")
public WebElementFacade AddDocument_WebButton;

@FindBy(xpath = "//INPUT[@id='addDocCarryFwd']")
public WebElementFacade Add_WebButton;

@FindBy(xpath = "//TD[6]/INPUT[1]")
public WebElementFacade AffectAll_WebButton;

@FindBy(xpath = "//TD[8]/INPUT[1]")
public WebElementFacade AffectNone_WebButton;

@FindBy(xpath = "//TD[7]/INPUT[1]")
public WebElementFacade AffectSome_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//INPUT[@id='docAllApplyAll']")
public WebElementFacade EveryDocumentAffects_WebButton;

@FindBy(xpath = "//INPUT[@id='bulkAddDocForm.registrationDate']")
public WebElementFacade RegDate_WebEdit;

@FindBy(xpath = "//INPUT[@id='bulkAddDocForm.registrationNumber']")
public WebElementFacade RegNumber_WebEdit;

@FindBy(xpath = "//INPUT[@id='removeSelected']")
public WebElementFacade RemoveSelected_WebButton;

@FindBy(xpath = "//INPUT[@id='removeDocCarryFwd']")
public WebElementFacade RemovefromProperties_WebButton;

}
