package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SearchByNamePage extends BasePage {

@FindBy(xpath = "//INPUT[@id='cancel']")
public WebElementFacade Cancel_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR[4]/TD[1]/INPUT[1]")
public WebElementFacade GivenName_WebEdit;

@FindBy(xpath = "//TR/TD[normalize-space()='Search by Name']")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//TR[2]/TD[1]/INPUT[1]")
public WebElementFacade LastName_WebEdit;

@FindBy(xpath = "//TD[1]/INPUT[1]")
public WebElementFacade Search_WebButton;

}
