package ca.teranet.pages.rosco;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SelectPINPage extends WebTablePage {

	private final String tablePINsXpath = "//table[@id='record']";

	// NOTE: If applicable, only the first 1000 instruments and/or 250 parties to/from will be printed on the property record.
	@FindBy(xpath = "//form[@id='propertySearchVO']")
	public WebElementFacade form_result;

	// NOTE: System has returned the first 100 of 104 hits found. Please refine your search.
	@FindBy(xpath = "//form[@id='propertySearchVO']/b")
	public WebElementFacade form_note;

	// 100 items found, displaying 81 to 100.
	// One item found.1
	// 4 items found, displaying all items.1
	@FindBy(xpath = "//span[@class='pagebanner']")
	public WebElementFacade result_num_found;

	@FindBy(xpath = "//span[@class='pagelinks']/strong")
	public WebElementFacade current_Page;

	// only more than 20 pins returned has page links
	public WebElementFacade link_gotoPage(int pageNo) {
		return findBy("//a[@title='Go to page " + pageNo + "']");
	}

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'First')]")
	public WebElementFacade link_first;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Prev')]")
	public WebElementFacade link_prev;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Next')]")
	public WebElementFacade link_next;

	@FindBy(xpath = "//span[@class='pagelinks']/a[contains(., 'Last')]")
	public WebElementFacade link_last;

	// radio button/pin
	@FindBy(xpath = "//table[@id='record']")
	public WebElementFacade table_result;

	// please verify table cell
	public void setPINsTable() {
		this.setTablePath(tablePINsXpath);
	}

	@FindBy(xpath = tablePINsXpath + "/tbody")
	public WebElementFacade table_body;

	public WebElementFacade radioButton_select(int propNo) {
		return findBy(tablePINsXpath + "//input[@type='radio' and @value='" + propNo + "']");
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@id='btn-back']")
	public WebElementFacade button_return;

}
