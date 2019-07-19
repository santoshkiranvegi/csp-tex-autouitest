package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class InteracPage extends WebTablePage {

	private final String tablePaymentInfo = "//div[@class='paydetails']/table";

	// |PAY TO|Hosted Paypage Test|
	// |INVOICE NO|mhp18305152653p94|
	// |AMOUNT|CAD59.68|
	public void setPaymentInfoTable() {
		this.setTablePath(tablePaymentInfo);
	}

	@FindBy(xpath = "//a[@id='issuer_link_109']")
	public WebElementFacade link_123bank;

	// UFT
	// WebEdit("IDEBIT_ISSLANG").Set "en"
	// WebEdit("IDEBIT_VERSION").Set "1"
	// WebEdit("IDEBIT_TRACK2").Set "3728024906540591206=01121122334455000"
	// WebEdit("IDEBIT_ISSCONF").Set "123456"
	// WebEdit("IDEBIT_ISSNAME").Set "RBC"

	@FindBy(xpath = "//input[@id='IDEBIT_ISSLANG']")
	public WebElementFacade input_issLang;

	@FindBy(xpath = "//input[@id='IDEBIT_TRACK2']")
	public WebElementFacade input_track2;

	@FindBy(xpath = "//input[@id='IDEBIT_VERSION']")
	public WebElementFacade input_version;

	@FindBy(xpath = "//input[@id='IDEBIT_ISSCONF']")
	public WebElementFacade input_issConfig;

	@FindBy(xpath = "//input[@id='IDEBIT_ISSNAME']")
	public WebElementFacade input_issName;

	@FindBy(xpath = "//input[@name='FUND']")
	public WebElementFacade button_fundPayment;

	@FindBy(xpath = "//input[@name='NOT_FUND']")
	public WebElementFacade button_dontFundPayemnt;

	// ======================= negative =======================================

	public WebElementFacade page_errorMessage(int errorNo) {
		return findBy("//div[@class='errorText'][" + errorNo + "]");
	}
}
