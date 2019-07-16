package ca.teranet.pages.rosco;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CashPaymentsNoticePage extends BasePage {

	// Your Order ID is #. Please pay cash at the ServiceOntario counter to release your search results and receipt.
	@FindBy(xpath = "//div[@id='main-content_w']/table//tr[1]")
	public WebElementFacade payment_notice;

	@FindBy(xpath = "//div/table[1]//tr[1]/td[1]/span[1]/b[1]")
	public WebElementFacade order_id;

	// after click OK button go to ROSCO homepage and logout
	@FindBy(xpath = "//input[contains(@id,'btn-ok')]")
	public WebElementFacade button_ok;

}
