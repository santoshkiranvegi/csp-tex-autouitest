package ca.teranet.pages.csppayment;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPage extends WebTablePage {
	private final String tableShoppingCartXpath = "//table[@class='zebra numbers' and @id='item']";

	public void setShoppingCartTable() {
		this.setTablePath(tableShoppingCartXpath);
	}

	public WebElementFacade button_remove(int itemNo) {
		return findBy(tableShoppingCartXpath + "/tbody/tr[" + itemNo + "]/td[5]/input[@id='btn-remove']");
	}

	@FindBy(xpath = "//input[contains(@id,'btn-checkout')]")
	public WebElementFacade button_checkout;

	@FindBy(xpath = "//input[contains(@id,'btn-continueshopping')]")
	public WebElementFacade button_continueShopping;

	@FindBy(xpath = "//div[contains(.,'empty')]/p")
	public WebElementFacade text_cartEmpty;

}
