package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

//Magage profile -- payment method page
public class PaymentMethodPage extends WebTablePage {

	private final String tableDebitAccounts = "//form[@id='voDisplayPaymentMethods']/table[1]";
	private final String tableCreditCards = "//form[@id='voDisplayPaymentMethods']/table[2]";
	private final String tableAdvancedAccounts = "//form[@id='voDisplayPaymentMethods']/table[3]";

	@FindBy(xpath = "//form[@id='voDisplayPaymentMethods']/div[1]//b")
	public WebElementFacade title_tableDebitAccounts;

	public void setDebitAccountsTable() {
		this.setTablePath(tableDebitAccounts);
	}

	@FindBy(xpath = "//form[@id='voDisplayPaymentMethods']/div[2]//b")
	public WebElementFacade title_tableCreditCards;

	public void setCreditCardsTable() {
		this.setTablePath(tableCreditCards);
	}

	@FindBy(xpath = "//form[@id='voDisplayPaymentMethods']/div[3]//b")
	public WebElementFacade title_tableAdvancedAccounts;

	public void setAdvancedAccountsTable() {
		this.setTablePath(tableAdvancedAccounts);
	}

	@FindBy(xpath = "//input[@id='btn-remove']")
	public WebElementFacade button_remove;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	// ============== negative ==================================
	// error message
	@FindBy(xpath = "//span[@id='busEntityPK.errors']")
	public WebElementFacade page_errorMessage;

}
