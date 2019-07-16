package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class WritListPage extends WebTablePage {

	private final String tableResultXpath = "//form[@id='searchForm']/table";

	// please verify table cell -- EO/Request By
	public void setWritListTable() {
		this.setTablePath(tableResultXpath);
	}

	@FindBy(xpath = tableResultXpath + "//tr[1]/td[1]")
	public WebElementFacade result_eo_title;

	@FindBy(xpath = tableResultXpath + "//tr[1]/td[2]")
	public WebElementFacade result_eo;

	@FindBy(xpath = tableResultXpath + "//tr[2]/td[1]")
	public WebElementFacade result_requestBy_title;

	@FindBy(xpath = tableResultXpath + "//tr[2]/td[2]")
	public WebElementFacade result_requestBy;

	@FindBy(xpath = tableResultXpath + "//tr[3]/td[1]")
	public WebElementFacade result_writNumber_title;

	@FindBy(xpath = tableResultXpath + "//tr[3]/td[2]")
	public WebElementFacade result_writNumber;

	public WebElementFacade desp_writ(int writNo) {
		return findBy(tableResultXpath + "//tr[" + writNo + "]//b");
	}

	public WebElementFacade link_writ(int writNo) {
		return findBy(tableResultXpath + "//tr[" + writNo + "]//a");
	}

	// only for writ search by number
	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	@FindBy(xpath = "//embed[@type='application/pdf']")
	public WebElementFacade window_PDF;

}
