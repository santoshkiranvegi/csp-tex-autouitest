package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MainPage extends BasePage {

	@FindBy(xpath = "//FORM[@id='generalExceptionForm']/P[1]")
	public WebElementFacade ApplicationError_WebElement;

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//SPAN[@id='bannerEnvText']")
	public WebElementFacade EnvText_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerFuncText']")
	public WebElementFacade FuncID_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerLROText']")
	public WebElementFacade LROText_WebElement;

	@FindBy(xpath = "//TD[@id='logout']")
	public WebElementFacade Logout_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerModeText']")
	public WebElementFacade Mode_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerTimeText']")
	public WebElementFacade TimeText_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerUserText']")
	public WebElementFacade UserText_WebElement;

	@FindBy(xpath = "//SPAN[@id='bannerWorkQueueTypeText']")
	public WebElementFacade WorkQueue_WebElement;

}
