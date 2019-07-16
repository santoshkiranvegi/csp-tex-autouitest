package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class EditOwnersMasterListPage extends BasePage {

@FindBy(xpath = "//TABLE[@id='editOwnersMasterListButtonsTable']/TBODY[1]/TR[1]/TD[1]/INPUT[3]")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//FORM[1]")
public WebElementFacade FullText_WebElement;

@FindBy(xpath = "//INPUT[@id='addMoreBulkOwners']")
public WebElementFacade MoreNames_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[7]")
public WebElementFacade Next_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[6]")
public WebElementFacade Prev_WebButton;

@FindBy(xpath = "//INPUT[@id='removeSelectedBulkOwnerRows']")
public WebElementFacade RemoveSelected_WebButton;

@FindBy(xpath = "//TABLE[@id='editOwnersMasterListButtonsTable']/TBODY[1]/TR[1]/TD[1]/INPUT[2]")
public WebElementFacade Save_WebButton;

@FindBy(xpath = "//TABLE[@id='editOwnersMasterListButtonsTable']/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
public WebElementFacade SingleEdit_WebButton;

}
