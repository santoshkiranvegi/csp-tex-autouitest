package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class TopUpsPage extends WebTablePage {

	private final String tableTopUps = "//form[@id='voDisplayTopups']/table";

	// ================= search TopUps page=======================

	@FindBy(xpath = "//form[@id='voRetrieveTopups']/p[1]")
	public WebElementFacade note_retrieveTopUps;

	@FindBy(xpath = "//input[@id='searchStartDate']")
	public WebElementFacade input_startDate;

	@FindBy(xpath = "//input[@id='searchEndDate']")
	public WebElementFacade input_endDate;

	@FindBy(xpath = "//div[@class='form-item'][3]/div[2]//p[1]/input")
	public WebElementFacade checkbox_myAA;

	@FindBy(xpath = "//div[@class='form-item'][3]/div[2]//p[2]/input")
	public WebElementFacade checkbox_parentAA;

	@FindBy(xpath = "//input[@id='btn-retrieve']")
	public WebElementFacade button_retrieve;

	// ================ TopUps list page ============================

	public void setTopUpsTable() {
		this.setTablePath(tableTopUps);
	}

	@FindBy(xpath = "//input[@id='btn-ok']")
	public WebElementFacade button_ok;

	// ============ Create TopUps page ===============================

	@FindBy(xpath = "//form[@id='voCreateTopup']/p[2]")
	public WebElementFacade note_createTopUps;

	@FindBy(xpath = "//div[@class='form-item'][1]/select")
	public WebElementFacade select_paymentMethod;

	@FindBy(xpath = "//div[@class='form-item'][2]/select")
	public WebElementFacade select_AAPaymentMethod;

	@FindBy(xpath = "//input[@id='strAmount']")
	public WebElementFacade input_amount;

	@FindBy(xpath = "//input[@id='btn-create']")
	public WebElementFacade button_create;

	// ============= Create TopUps return page ========================

	@FindBy(xpath = "//h3")
	public WebElementFacade result_createTopUps;

	// Today's Top-Up total - 100.0
	@FindBy(xpath = "//form[@id='voConfirmTopup']/div[1]")
	public WebElementFacade message_todayTotal;

	// Latest Top-Up date - Fri Nov 02 10:14:14 EDT 2018
	@FindBy(xpath = "//form[@id='voConfirmTopup']/div[2]")
	public WebElementFacade message_latestDate;

	// Daily Top-Up limit - 50000.0
	@FindBy(xpath = "//form[@id='voConfirmTopup']/div[3]")
	public WebElementFacade message_dailyLimits;

	// ============= public objects ====================================

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	// ============== negative =========================================
	// error message
	@FindBy(xpath = "//span[@id='BusEntityPK.errors']")
	public WebElementFacade page_errorMessage;

}
