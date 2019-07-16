package ca.teranet.pages.csppayment;

import java.util.List;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentOptionsPage extends WebTablePage {

	private final String tablePaymentOptionsXpath = "//table[@class='zebra numbers' and @id='pr']";

	public void setPaymentOptionsTable() {
		this.setTablePath(tablePaymentOptionsXpath);
	}

	@FindBy(xpath = "//input[contains(@onclick,'onPaymentSubmit')]")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[contains(@onclick,'sendRequest')]")
	public WebElementFacade button_continueshopping;

	@FindBy(xpath = "//input[contains(@onclick,'cancelButton')]")
	public WebElementFacade button_cancel;

	@FindBy(xpath = "//input[@name='emailAddress']")
	public WebElementFacade input_email;

	// ============= payment related objects ================

	@FindBy(xpath = "//input[@name='paymentType' and @value='CD']")
	public WebElementFacade radiobutton_CCOrInteracPay;

	@FindBy(xpath = "//input[@name='paymentType' and @value='cash']")
	public WebElementFacade radiobutton_cashPay;

	@FindBy(xpath = "//input[@name='paymentType' and @value='AA']")
	public WebElementFacade radiobutton_advancedAccPay;

	@FindBy(xpath = "//select[@id='CDSelect']")
	public WebElementFacade select_CC;

	@FindBy(xpath = "//select[@id='AASelect']")
	public WebElementFacade select_AA;

	public List<WebElementFacade> get_select_CC_options() {
		return findAll("//select[@id='CDSelect']/option");
	}

	public List<WebElementFacade> get_select_AA_options() {
		return findAll("//select[@id='AASelect']/option");
	}

	@FindBy(xpath = "//A[@href='javascript:openNewWindowVault()']")
	public WebElementFacade link_saveNewCC;

	@FindBy(xpath = "//div[@class='payment_block'][1]")
	public WebElementFacade block_CC_payment;

	@FindBy(xpath = "//div[@class='payment_block'][2]")
	public WebElementFacade block_AA_payment;

	// shipping and receipts
	@FindBy(xpath = "//input[@name='destinationOption' and @value='E']")
	public WebElementFacade radiobuttton_emailOnly;

	@FindBy(xpath = "//input[@name='destinationOption' and @value='P']")
	public WebElementFacade radiobuttton_printOnly;

	@FindBy(xpath = "//input[@name='destinationOption' and @value='EP']")
	public WebElementFacade radiobuttton_both;

}
