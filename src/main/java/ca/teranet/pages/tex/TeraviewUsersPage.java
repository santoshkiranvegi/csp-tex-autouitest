package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class TeraviewUsersPage extends BasePage {

	// getDriver().switchTo().frame(supportPage.frame_support);
	@FindBy(xpath = "//iframe[@id='tvcontent']")
	public WebElementFacade frame_tvcontent;

	// Title displayed
	@FindBy(xpath = "//h1[@id='page-title']")
	public WebElementFacade title_TVUser_page;

	// verify pageTitle --- in HomePage?
	// or just verify link exist?
	// first level menu link
	public WebElementFacade link_support(int linkNo) {
		return findBy("//ul[@class='users-menu']/li[" + linkNo + "]/a");
	}

	// second level menu link
	public WebElementFacade link_support(int linkNo, int subLinkNo) {
		return findBy("//ul[@class='users-menu']//li[" + linkNo + "]//li[" + subLinkNo + "]/a");
	}

	// page body
	@FindBy(xpath = "//body")
	public WebElementFacade page_TVUser;

	// report page
	@FindBy(xpath = "//iframe[@id='reportFrame']")
	public WebElementFacade frame_Report;

}
