package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MonerisReceiptPage extends WebTablePage {

	private final String tableTransInfo_CSP = "//body/table/tbody/tr[1]/td[1]/table[1]";
	private final String tableTransInfo_LRO = "//body/table[1]";
	private final String tableItems = "//td/table[2]";
	private final String tableNotes = "//td/table[3]";

	public void setTransactionInfoTable() {
		if (getDriver().getCurrentUrl().contains("lro")) {
			// From ROSCO
			this.setTablePath(tableTransInfo_LRO);
		} else {
			// From TEX
			this.setTablePath(tableTransInfo_CSP);
		}
	}

	@FindBy(xpath = "//input[@id='printreceipt']")
	public WebElementFacade button_print;

	public WebElementFacade title_address(int line) {
		if (getDriver().getCurrentUrl().contains("lro")) {
			// From ROSCO
			return findBy(tableTransInfo_LRO + "/tbody/tr[" + (line + 2) + "]");
		} else {
			// From TEX
			return findBy(tableTransInfo_CSP + "/tbody/tr[" + (line + 3) + "]");
		}
	}

	// for data -- items should be separate table
	// from second row of the table
	public void setReceiptItemsTable() {
		this.setTablePath(tableItems);
	}

	public WebElementFacade get_serviceID(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 2) + "]/td[1]");
	}

	public WebElementFacade item_subTotal(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 5) + "]/td[5]");
	}

	public WebElementFacade item_hst(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 6) + "]/td[5]");
	}

	public WebElementFacade item_total(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 7) + "]/td[5]");
	}

	public WebElementFacade item_note(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 8) + "]");
	}

	public WebElementFacade item_star_note1(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 9) + "]");
	}

	public WebElementFacade item_star_note2(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 10) + "]");
	}

	public WebElementFacade item_star_note3(int itemNum) {
		return findBy(tableItems + "/tbody/tr[" + (itemNum + 11) + "]");
	}

	public WebElementFacade findTableRow(String item) {
		switch (item) {
		case "Email Receipt Sent To":
			return findBy("//td/*[contains(text(),'" + item + "')]");
		case "Customer ID:":
			return findBy("//td//*[.='" + item + "']/../..");
		default:
			return findBy("//td[.='" + item + "']/..");
		}
	}

	public WebElementFacade contact_note(int note_num) {
		return findBy(tableNotes + "/tbody/tr[" + (note_num + 1) + "]");
	}

	@FindBy(xpath = "//input[@id='return']")
	public WebElementFacade button_continueShopping;

	public WebElementFacade title_address_CSP(int line) {
		return findBy(tableTransInfo_CSP + "/tbody/tr[" + (line + 3) + "]");
	}
}
