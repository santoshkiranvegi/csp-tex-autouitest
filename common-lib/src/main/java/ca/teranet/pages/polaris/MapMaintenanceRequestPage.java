package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class MapMaintenanceRequestPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='homePageButton']")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//INPUT[@id='correlationListButton']")
public WebElementFacade CorrelationList_WebButton;

@FindBy(xpath = "//INPUT[@id='deleteBatchRequestBtn']")
public WebElementFacade RemoveBatch_WebButton;

}
