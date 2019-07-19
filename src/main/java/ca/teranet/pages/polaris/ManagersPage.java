package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ManagersPage extends BasePage {

	@FindBy(xpath = "//input[@id='manualNDIOn']")
	public WebElementFacade NDIIndicatorON_WebRadioGroup;

	@FindBy(xpath = "//input[@id='manualNDIOff']")
	public WebElementFacade NDIIndicatorOFF_WebRadioGroup;

	@FindBy(xpath = "//input[@id='manualLRIOn']")
	public WebElementFacade LRIIndicatorON_WebRadioGroup;

	@FindBy(xpath = "//input[@id='manualLRIOff']")
	public WebElementFacade LRIIndicatorOFF_WebRadioGroup;

	@FindBy(xpath = "//TR/TD/SELECT[normalize-space()='CROWN PATENT FIRST CONVERSION FROM BOOK MUNICIPAL APPLICATION PARTIAL TERMINATION OF A CONDOMINIUM ROADS ON CROWN LAND SUBDIVISIONS']")
	public WebElementFacade PINOrigin_WebList;

	@FindBy(xpath = "//TR/TD/SELECT[normalize-space()='ACTIVE INACTIVE']")
	public WebElementFacade Status_WebList;

}
