package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class OnlineReceiptPage extends WebTablePage {

	private final String tableTransDetailsLeft = "//body/table[1]/tbody/tr[5]/td[1]/table";
	private final String tableTransDetailsRight = "//body/table[1]/tbody/tr[5]/td[2]/table";
	private final String tableItems = "//body/table[2]";

	@FindBy(xpath = "//div[@id='main-content_w']/table[1]/tbody/tr[1]")
	public WebElementFacade title_receiptApproved;

	@FindBy(xpath = "//div[@id='main-content_w']/table[1]/tbody/tr[2]")
	public WebElementFacade title_printReceipt;

	// getDriver().switchTo().frame(onlineReceiptPage.frame_receipt);
	@FindBy(xpath = "//iframe[@src='/csp/cartviews/receipt.jsp']")
	public WebElementFacade frame_receipt;

	@FindBy(xpath = "//iframe[@src='/csp/cartviews/receiptZero.jsp']")
	public WebElementFacade frame_receipt_0;

	@FindBy(xpath = "//input[@id='btn-printreceipt']")
	public WebElementFacade button_print;

	@FindBy(xpath = "//body/table[1]/tbody/tr[2]")
	public WebElementFacade title_receipt;

	@FindBy(xpath = "//body/table[1]/tbody/tr[4]")
	public WebElementFacade title_TransDetails;

	@FindBy(xpath = "//body/table[1]/tbody/tr[6]")
	public WebElementFacade email_receipt;

	@FindBy(xpath = "//body/table[1]/tbody/tr[4]")
	public WebElementFacade email_receipt_0;

	// for data -- custom should be separate table
	public void setTransDetails_left() {
		this.setTablePath(tableTransDetailsLeft);
	}

	public void setTransDetails_right() {
		this.setTablePath(tableTransDetailsRight);
	}

	@FindBy(xpath = "//body/table[2]/tbody/tr[1]")
	public WebElementFacade title_receiptItems;

	// for data -- items should be separate table
	// from second row of the table
	public void setReceiptItemsTable() {
		this.setTablePath(tableItems);
	}

	public WebElementFacade item_ServiceID(int itemNum) {
		return findBy("(//body//table[2]/tbody/tr[" + (itemNum + 2) + "]/td[1])[1]");
	}

	public WebElementFacade item_subTotal(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 5) + "]/td[5]");
	}

	public WebElementFacade item_hst(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 6) + "]/td[5]");
	}

	public WebElementFacade item_total(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 7) + "]/td[5]");
	}

	public WebElementFacade item_subTotal_0(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 6) + "]/td[5]");
	}

	public WebElementFacade item_hst_0(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 7) + "]/td[5]");
	}

	public WebElementFacade item_total_0(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 8) + "]/td[5]");
	}

	public WebElementFacade item_note(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 8) + "]");
	}

	public WebElementFacade item_star_note1(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 9) + "]");
	}

	public WebElementFacade item_star_note2(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 10) + "]");
	}

	public WebElementFacade item_star_note3(int itemNum) {
		return findBy("//body/table[2]/tbody/tr[" + (itemNum + 11) + "]");
	}

	@FindBy(xpath = "//body/table[3]/tbody/tr[2]")
	public WebElementFacade contact_note1;

	// For billing related questions on Search Writs, OWL and WritFiling: 1-800-208-5263 or 416-360-1190
	@FindBy(xpath = "//body/table[3]/tbody/tr[3]")
	public WebElementFacade contact_note2;

	// For ROSCO
	@FindBy(xpath = "//input[@type='button' and contains(@id,'btn-ok_')]")
	public WebElementFacade button_vcc_ok;
	////////////

	// For TEX
	@FindBy(xpath = "//input[@type='button' and @id='btn-continueshopping']")
	public WebElementFacade button_continueShopping;

	@FindBy(xpath = "//input[@type='button' and @id='btn-printreceipt']")
	public WebElementFacade button_printreceipt;
	////////////

}
