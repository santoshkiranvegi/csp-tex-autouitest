package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CashPaymentsPage extends WebTablePage {

	// 1. list of orders page
	private final String tableOrdersXpath = "//table[@id='item']";
	private final String tablePaymentDetailsXpath = "//form[@name='viewcart']/table[1]";
	private final String tablePaymentSummaryXpath = "//form[@name='viewcart']/table[2]";

	@FindBy(xpath = "//td[@id='pagetitle']")
	public WebElementFacade title_orderList;

	// please verify table cell
	// |Order ID|Kiosk ID|Create Date|
	public void setOrdersTable() {
		this.setTablePath(tableOrdersXpath);
	}

	public WebElementFacade link_order(int orderNo) {
		return findBy(tableOrdersXpath + "//tr[" + orderNo + "]/td[1]/a");
	}

	// used for complete payment one by one
	@FindBy(xpath = tableOrdersXpath + "//tr[1]/td[1]/a")
	public WebElementFacade link_firstOrder;

	// List Cash Payment Request
	@FindBy(xpath = "//div[@id='srh']/table[3]")
	public WebElementFacade list_paymentRequest;

	// Nothing found to display.
	@FindBy(xpath = "//div[@id='srh']/form")
	public WebElementFacade nothing_display;

	// 2. end of day report page
	@FindBy(xpath = "//input[@id='date']")
	public WebElementFacade input_date;

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	// Order Details page
	public void setPaymentDetailsTable() {
		this.setTablePath(tablePaymentDetailsXpath);
	}

	public void setPaymentSummaryTable() {
		this.setTablePath(tablePaymentSummaryXpath);
	}

	@FindBy(xpath = "//input[@id='btn-completepurchase']")
	public WebElementFacade button_completePurchase;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	// Payment Received
	// after click OK button return to Cash Payments page
	@FindBy(xpath = "//input[contains(@id,'btn-ok')]")
	public WebElementFacade button_ok;

	// verify return message: The transaction is completed!
	@FindBy(xpath = "//tbody/tr[2]")
	public WebElementFacade return_msg_paymentReceived;

	// order list pagination
	@FindBy(xpath = "//form[@id='paging']")
	public WebElementFacade form_orderListPages;

	@FindBy(xpath = "//span[@class='pagelinks']")
	public WebElementFacade links_orderListPages;

	@FindBy(xpath = "//span[@class='pagelinks']/strong")
	public WebElementFacade current_Page;

	public WebElementFacade link_gotoPage(int pageNo) {
		return findBy("//a[@title='Go to page " + pageNo + "']");
	}

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'First')]")
	public WebElementFacade link_first;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Prev')]")
	public WebElementFacade link_prev;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Next')]")
	public WebElementFacade link_next;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Last')]")
	public WebElementFacade link_last;

}
