package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LROHoursPage extends WebTablePage {

	private final String tableLROHoursXpath = "//table[@id='lroBusHrsTable']";
	private final String tableHistoricalHoursXpath = "//table[@id='his']";

	@FindBy(xpath = "//h1")
	public WebElementFacade title_lroHours;

	// Changes will take place effective next available uptime
	// All times are EST(Eastern Standard Time). Please adjust for CST(Central Standard Time).
	@FindBy(xpath = "//div[@id='lroBusHrsQueryFormDiv']")
	public WebElementFacade container_lro;

	@FindBy(xpath = "//select[@id='availableLros']")
	public WebElementFacade select_avilableLRO;

	@FindBy(xpath = "//a[@id='add']")
	public WebElementFacade button_add;

	@FindBy(xpath = "//a[@id='addAll']")
	public WebElementFacade button_addAll;

	@FindBy(xpath = "//a[@id='remove']")
	public WebElementFacade button_remove;

	@FindBy(xpath = "//a[@id='removeAll']")
	public WebElementFacade button_removeAll;

	@FindBy(xpath = "//select[@id='selectedLros']")
	public WebElementFacade select_selectedLRO;

	@FindBy(xpath = "//input[@id='lroBusHrsQuerySubmit']")
	public WebElementFacade button_submitLRO;

	// Historical records are available for 2 years
	// Records may be displayed for maximum 3 months period
	@FindBy(xpath = "//div[@id='LroHrsHistoryPeriodDiv']")
	public WebElementFacade container_period;

	@FindBy(xpath = "//input[@id='fromDate']")
	public WebElementFacade input_fromDate;

	@FindBy(xpath = "//input[@id='toDate']")
	public WebElementFacade input_toDate;

	@FindBy(xpath = "//input[@id='busHrsHistorySubmit']")
	public WebElementFacade button_submitPeriod;

	// To have no uptime: Enter times so start=end Start:1200 End:1200
	@FindBy(xpath = "//div[@id='LroHrsHistoryTableDiv']")
	public WebElementFacade container_hours;

	@FindBy(xpath = "//input[@value='Submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade button_cancel;

	public WebElementFacade menu_leftPanel(String text) {
		return findBy("//ul[@id='navigation']//a[contains(.,'" + text + "')]");
	}

	public void setLROHoursTable() {
		this.setTablePath(tableLROHoursXpath);
	}

	public void setHistoricalHoursTable() {
		this.setTablePath(tableHistoricalHoursXpath);
	}
}
