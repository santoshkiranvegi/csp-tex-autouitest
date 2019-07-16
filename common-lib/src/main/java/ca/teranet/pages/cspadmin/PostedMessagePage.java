package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PostedMessagePage extends WebTablePage {

	private final String tablePostedMsgXpath = "//table[@class='sofT']";

	public void setPostedMsgTable() {
		this.setTablePath(tablePostedMsgXpath);
	}

	@FindBy(xpath = "//div[@id='content']//b")
	public WebElementFacade page_subtitle;

	// 282 Messages Posted to Kiosks found, displaying 1 to 20
	@FindBy(xpath = "//span[@class='pagebanner']")
	public WebElementFacade page_result;

	@FindBy(xpath = "//span[@class='pagelinks']")
	public WebElementFacade page_links;

	@FindBy(xpath = "//span[@class='pagelinks']/strong")
	public WebElementFacade current_page;

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
}
