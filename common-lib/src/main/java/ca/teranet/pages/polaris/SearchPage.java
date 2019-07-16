package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SearchPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='documentViewSearch.docNumber']")
public WebElementFacade RegNumber_WebEdit;

@FindBy(xpath = "//INPUT[@id='search']")
public WebElementFacade Search_WebButton;

}
