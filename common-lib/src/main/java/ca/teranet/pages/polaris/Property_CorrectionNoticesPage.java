package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class Property_CorrectionNoticesPage extends BasePage {

	@FindBy(xpath = "//input[@value='Add New']")
	public WebElementFacade AddNew_WebButton;

	@FindBy(xpath = "//INPUT[@id='correctionNotice']")
	public WebElementFacade CorrectionNotice_WebEdit;

	@FindBy(xpath = "//FORM[1]/DIV[5]/DIV[1]")
	public WebElementFacade Notices_WebElement;

	@FindBy(xpath = "//input[@value='Remove Selected']")
	public WebElementFacade RemoveSelected_WebButton;

}
