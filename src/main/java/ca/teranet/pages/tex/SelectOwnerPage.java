package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SelectOwnerPage extends WebTablePage {

	private final String tableNamesXpath = "//table[@class='zebra'and @id='record']";

	// Select one or more of the following names:
	@FindBy(xpath = "//h3")
	public WebElementFacade instruction_searchName;
	//
	@FindBy(xpath = "//h5")
	public WebElementFacade note_searchName;

	@FindBy(xpath = "//form[@id='paging']")
	public WebElementFacade form_searchNamePages;

	@FindBy(xpath = "//span[@class='pagelinks']")
	public WebElementFacade links_searchNamePages;

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

	public WebElementFacade checkbox_select(int nameNo) {
		return findBy(tableNamesXpath + "//input[@name='_chk' and @value='" + (nameNo - 1) + "']");
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;
}
