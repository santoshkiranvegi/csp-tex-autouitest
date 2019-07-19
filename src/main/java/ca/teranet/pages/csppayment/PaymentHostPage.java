package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PaymentHostPage extends BasePage {

	// host page - Teranet
	// interac - Teranet-ROSCO
	@FindBy(xpath = "//div[@id='hppContent']/h1")
	public WebElementFacade title_page;

	// ================= payment host page ============================

	@FindBy(xpath = "//div[@id='mainContent']/p")
	public WebElementFacade instruction_paymentHost;

	@FindBy(xpath = "//input[@value='cc']")
	public WebElementFacade radiobutton_CC;

	@FindBy(xpath = "//input[@value='iop']")
	public WebElementFacade radiobutton_interac;

	@FindBy(xpath = "//form[@method='post']/div[@class='td2_bg']")
	public WebElementFacade title_paymentMethod;

	@FindBy(xpath = "//form[@method='post']/table//div[@class='td2_bg']")
	public WebElementFacade title_paymentDetail;

	@FindBy(xpath = "//form[@method='post']/table//tr[1]/td[1]/div[2]/p")
	public WebElementFacade trans_amount_cc;

	@FindBy(xpath = "//input[@name='cardholderName']")
	public WebElementFacade input_cardHolderName;

	// getDriver().switchTo().frame(paymentHostPage.frame_moneris);
	@FindBy(xpath = "//iframe[@id='monerisFrame']")
	public WebElementFacade frame_moneris;

	@FindBy(xpath = "//input[@id='monerisDataInput']")
	public WebElementFacade input_cardNumber;

	// MMYY
	@FindBy(xpath = "//input[@id='monerisExpInput']")
	public WebElementFacade input_cardExpDate;

	@FindBy(xpath = "//input[@id='monerisCVDInput']")
	public WebElementFacade input_cardsecurityCode;

	// ====================== interac page =====================================

	@FindBy(xpath = "//div[@id='hppFinancialIOP']/h4")
	public WebElementFacade title_payDetails;

	@FindBy(xpath = "//div[@id='hppFinancialIOP']/div[1]/p[1]")
	public WebElementFacade trans_amount_dc;

	@FindBy(xpath = "//div[@id='hppFinancialIOP']/div[1]/p[2]")
	public WebElementFacade order_ID;

	@FindBy(xpath = "//div[@id='hppFinancialIOP']/div[2]")
	public WebElementFacade trans_note;

	// ===================== public objects ==================================

	@FindBy(xpath = "//input[@type='button' and @name='process']")
	public WebElementFacade button_process;

	@FindBy(xpath = "//input[@type='button' and @name='cancel']")
	public WebElementFacade button_cancel;

	// ======================= negative =======================================

	public WebElementFacade page_errorMessage(int errorNo) {
		return findBy("//div[@class='errorText'][" + errorNo + "]");
	}

	@FindBy(xpath = "//div[@id='mainContent']/div[1]/ul/li")
	public WebElementFacade error_message;

	@FindBy(xpath = "//td[@id='pagetitle']")
	public WebElementFacade canceled_message;

	// /html/body/table/tbody/tr[5]/td/div/button. This is in the window of "Transaction Payment Has been Canceled"
	@FindBy(xpath = "//table//tr[5]//button")
	public WebElementFacade button_closeTheWindow;
}
