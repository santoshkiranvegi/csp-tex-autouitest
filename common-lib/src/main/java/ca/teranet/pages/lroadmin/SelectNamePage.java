package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SelectNamePage extends WebTablePage {

	private final String tableNamesXpath = "//table[@class='zebra'and @id='record']";

	// BELL At least 100 hits found. Please refine your search.
	// 100 names, displaying 1 to 20.
	@FindBy(xpath = "//form[@id='propertySearchVO']")
	public WebElementFacade form_result;

	@FindBy(xpath = "//span[@class='pagelinks']")
	public WebElementFacade links_ownerPages;

	@FindBy(xpath = "//span[@class='pagelinks']/strong")
	public WebElementFacade current_Page;

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

	public void setNamesTable() {
		this.setTablePath(tableNamesXpath);
	}

	@FindBy(xpath = tableNamesXpath + "/tbody")
	public WebElementFacade table_body;

	public WebElementFacade radioButton_select(int nameNo) {
		return findBy(tableNamesXpath + "//input[@type='radio' and @value='" + nameNo + "']");
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	@FindBy(xpath = "//input[@id='btn-back']")
	public WebElementFacade button_return;
}
