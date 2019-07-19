package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PriceSummaryPage extends WebTablePage {

	private final String tablePriceSummaryXpath = "//table[@class='zebra numbers' and @id='item']";

	public void setPriceSummaryTable() {
		this.setTablePath(tablePriceSummaryXpath);
	}

	@FindBy(xpath = "//input[contains(@id,'btn-addtocart')]")
	public WebElementFacade button_addToCart;

	@FindBy(xpath = "//input[contains(@id,'btn-cancel')]")
	public WebElementFacade button_cancel;
}
