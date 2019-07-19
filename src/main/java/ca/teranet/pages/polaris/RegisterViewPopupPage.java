package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegisterViewPopupPage extends BasePage {

@FindBy(xpath = "//TR[11]/TD[2]/INPUT[4]")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//TR[12]/TD[2]/INPUT[5]")
public WebElementFacade Close_WebButton1;

@FindBy(xpath = "//DIV[@id='docs']/TABLE[normalize-space()='Registration NumberRegistration DateDocument TypeParty ToDocument RemarksStatusDeleted? HT6033529 2013/01/09NOTICECERTIFIED No']")
public WebElementFacade Documents_WebTable;

@FindBy(xpath = "//DIV[@id='desc']")
public WebElementFacade NewPINs_WebElement;

@FindBy(xpath = "//DIV[@id='owners']/TABLE[normalize-space()='NameCapacityShare TERANET OWNER REGISTERED OWNER 100%']")
public WebElementFacade Owners_WebTable;

@FindBy(xpath = "//FORM[1]/TABLE[2]")
public WebElementFacade PINDetails_WebTable;

@FindBy(xpath = "//FORM[@id='registerViewPopupELRSForm']/TABLE[2]/TBODY[1]/TR[1]/TD[2]/TABLE[1]/TBODY[1]/TR[1]/TD[2]")
public WebElementFacade PIN_WebElement;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='16912-0100 (LT)']")
public WebElementFacade PIN_WebElement1;

@FindBy(xpath = "//TR[1]/TD[2]/TABLE[1]")
public WebElementFacade PIN_WebTable;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='16906-0001 (LT)']")
public WebElementFacade PropertyPIN_WebElement;

@FindBy(xpath = "//TABLE[@id='remarks']")
public WebElementFacade PropertyRemarks_WebTable;

@FindBy(xpath = "//TABLE[@id='docs']/TBODY[normalize-space()='Documents Registration NumberRegistration DateDocument TypeParty ToDocument RemarksStatusDeleted? HT6033529 2013/01/09NOTICECERTIFIED No']/TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewAllDocuments_WebButton;

@FindBy(xpath = "//TABLE[@id='internalNotes']/TBODY[normalize-space()='Internal PIN Notes - NOT FOR PUBLIC VIEW ENTER < 6 INTERNAL PIN NOTES ON 2013/01/09 AT 16:25 BY USERG62.']/TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewAllInternalPINNotes_WebButton;

@FindBy(xpath = "//TABLE[@id='owners']/TBODY[normalize-space()='Owners NameCapacityShare TERANET OWNER REGISTERED OWNER 100%']/TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewAllOwners_WebButton;

@FindBy(xpath = "//TABLE[@id='remarks']/TBODY[normalize-space()='Property Remarks ENTER < 6 LINES OF PROPERTY REMARKS.']/TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewAllRemarks_WebButton;

@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewAllTitleQualifiers_WebButton;

@FindBy(xpath = "//TABLE[@id='desc']/TBODY[normalize-space()='Description DIVIDE LAND TITLES PIN INTO 2 PINS']/TR[2]/TD[1]/INPUT[1]")
public WebElementFacade ViewEntireDescription_WebButton;

}
