package ca.teranet.pages.rosco;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class WritsMax60Page extends WebTablePage {

	private final String tableWritMax60Xpath = "//table[@class='zebra numbers']";

	public void setWritsMax60Table() {
		this.setTablePath(tableWritMax60Xpath);
	}

	public WebElementFacade desp_writ(int writNo) {
		return findBy(tableWritMax60Xpath + "/tbody/tr[" + writNo + "]/td[1]");
	}

	public WebElementFacade checkbox_select(int writNo) {
		return findBy(tableWritMax60Xpath + "/tbody/tr[" + writNo + "]/td[2]/input");
	}

	@FindBy(xpath = "//input[@id='btn-selectall']")
	public WebElementFacade button_selectAll;

	// (The results will not include the writ details for incomplete writs, if any.)
	@FindBy(xpath = "//tfoot/tr/td")
	public WebElementFacade note_WritMax60;

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

}
