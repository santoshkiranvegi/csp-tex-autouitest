package ca.teranet.pages.gwh;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class GWHPropertyDescriptionPage extends WebTablePage {

	private final String tablePropertyDespXpath = "//form[@id='propertySearchVO']/table[2]";

	@FindBy(xpath = "//input[@name='includeDeleted']")
	public WebElementFacade checkbox_includeDelete;

	public void setPropertyDespTable() {
		this.setTablePath(tablePropertyDespXpath);
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@id='btn-back']")
	public WebElementFacade button_return;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	@FindBy(xpath = "//input[@id='btn-map']")
	public WebElementFacade button_viewMap;

	@FindBy(xpath = "//embed[@type='application/pdf']")
	public WebElementFacade window_PDF;
}
