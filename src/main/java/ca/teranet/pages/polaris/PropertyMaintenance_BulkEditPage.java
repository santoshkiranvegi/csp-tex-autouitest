package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PropertyMaintenance_BulkEditPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='addToResultingEasement']")
public WebElementFacade Add_WebButton;

@FindBy(xpath = "//INPUT[@id='ApplyToAllBtnForDesc']")
public WebElementFacade AddtoallPINs_WebButton;

@FindBy(xpath = "//TR/TD[normalize-space()='Maintain Property Bulk Edit']")
public WebElementFacade BulkEditHeader_WebElement;

@FindBy(xpath = "//INPUT[@id='CommitBtn']")
public WebElementFacade Commit_WebButton;

@FindBy(xpath = "//TEXTAREA[@id='bulkForm.description']")
public WebElementFacade Description_WebEdit;

@FindBy(xpath = "//SELECT[@id='bulkEaseSelectList']")
public WebElementFacade EasementList_WebList;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//INPUT[@id='removeAllSelectedBulkEasements']")
public WebElementFacade RemoveSelected_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[8]")
public WebElementFacade ReturntoDetails_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[7]")
public WebElementFacade SingleEdit_WebButton;

}
