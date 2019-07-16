package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PropertyDetail_ApplyToSomePage extends BasePage {

@FindBy(xpath = "//FORM[1]/P[1]/SELECT[1]")
public WebElementFacade AffectedPropertyList_WebList;

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade ApplyChanges_WebElement;

@FindBy(xpath = "//FORM[1]/P[1]/TABLE[1]/TBODY[1]/TR[1]/TD[4]/INPUT[1]")
public WebElementFacade No_WebButton;

@FindBy(xpath = "//FORM[1]/P[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/INPUT[1]")
public WebElementFacade Yes_WebButton;

}
