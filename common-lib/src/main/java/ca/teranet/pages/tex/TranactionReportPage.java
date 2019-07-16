package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class TranactionReportPage extends WebTablePage {

	// ========== search transaction report page ================
	@FindBy(xpath = "//form[@id='voReportTransactions']/p[2]")
	public WebElementFacade note_searchTransactionReport;

	@FindBy(xpath = "//input[@id='searchStartDate']")
	public WebElementFacade input_startDate;

	@FindBy(xpath = "//input[@id='searchEndDate']")
	public WebElementFacade input_endDate;

	@FindBy(xpath = "//input[@id='searchMyTransactionsOnly1']")
	public WebElementFacade input_myTransactionsOnly;

	@FindBy(xpath = "//input[@id='searchMyTransactionsOnly2']")
	public WebElementFacade input_allTransactions;

	@FindBy(xpath = "//input[@id='btn-retrieve']")
	public WebElementFacade button_retrieve;

	// ============== search negative ===========================
	// error message
	@FindBy(xpath = "//form[@id='voReportTransactions']/*[@class='error']")
	public WebElementFacade page_errorMessage;

	// =============transaction report list page ==================
	@FindBy(xpath = "//h3")
	public WebElementFacade title_tranactionReport;

	@FindBy(xpath = "//form[@id='TSReport']/b")
	public WebElementFacade desp_tranactionReport;

	public String table_transType(int transactionNo) {
		return "//table[" + (transactionNo * 3 - 1) + "]";
	}

	public String table_transList(int transactionNo) {
		return "//table[" + (transactionNo * 3) + "]";
	}

	public String table_transSummary(int transactionNo) {
		return "//table[" + (transactionNo * 3 + 1) + "]";
	}

	public String tableRow_transLIst(int rowNo) {
		return "(//tr[@class='datagrid-element'])[" + rowNo + "]";
	}

	public void setTransTypeTable(int transactionNo) {
		this.setTablePath(table_transType(transactionNo));
	}

	public void setTransListTable(int transactionNo) {
		this.setTablePath(table_transList(transactionNo));
	}

	public void setTransSummaryTable(int transactionNo) {
		this.setTablePath(table_transSummary(transactionNo));
	}

	@FindBy(xpath = "//input[@id='btn-print']")
	public WebElementFacade button_print;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

}
