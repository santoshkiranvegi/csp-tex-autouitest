package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchDocumentResultPage extends WebTablePage {

	private final String tableResultXpath = "//table[@id='namesLoop']";

	// please verify table cell
	public void setResultTable() {
		this.setTablePath(tableResultXpath);
	}

	public WebElementFacade link_doc(int docNo) {
		return findBy(tableResultXpath + "//tr[" + docNo + "]//a");
	}

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

}
