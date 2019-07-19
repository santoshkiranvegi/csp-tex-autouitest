package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrderDetailPage extends WebTablePage {

	private final String tableOrderDetailXpath = "//form[@id='form1']/table[1]";

	public void setOrderDetailTable() {
		this.setTablePath(tableOrderDetailXpath);
	}

	@FindBy(xpath = "//form[@id='form1']/table[2]//tr[2]")
	public WebElementFacade order_subTotal;

	// others has no hst
	@FindBy(xpath = "//form[@id='form1']/table[2]//tr[2]")
	public WebElementFacade order_grandTotal;

	// writs has hst
	@FindBy(xpath = "//form[@id='form1']/table[2]//tr[2]")
	public WebElementFacade order_writ_hst;

	@FindBy(xpath = "//form[@id='form1']/table[2]//tr[3]")
	public WebElementFacade order_writ_grandTotal;

	@FindBy(xpath = "//input[@id='btn-completepurchase']")
	public WebElementFacade button_completePurchase;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	// Payment Received page
	// after click Complete Purchase button
	@FindBy(xpath = "//div[@id='main-content_w']/table//tr[2]")
	public WebElementFacade confirmation_purchaseComplete;

	// click OK button will return to order list page
	@FindBy(xpath = "//input[@id='btn-ok_en']")
	public WebElementFacade button_ok;

}
