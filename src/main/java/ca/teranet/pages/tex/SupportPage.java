package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SupportPage extends BasePage {

	// getDriver().switchTo().frame(supportPage.frame_support);
	@FindBy(xpath = "//iframe[@id='support']")
	public WebElementFacade frame_support;

	@FindBy(xpath = "//body")
	public WebElementFacade body;

	@FindBy(xpath = "//h2")
	public WebElementFacade title_support;

	@FindBy(xpath = "//div[@id='support-item-1']")
	public WebElementFacade searchName_support;

	public WebElementFacade link_SearchName_support(int linkNo) {
		return findBy("//div[@id='support-item-1']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//div[@id='support-item-2']")
	public WebElementFacade searchProperty_support;

	public WebElementFacade link_SearchProperty_support(int linkNo) {
		return findBy("//div[@id='support-item-2']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//div[@id='support-item-3']")
	public WebElementFacade documentView_support;

	public WebElementFacade link_documentView_support(int linkNo) {
		return findBy("//div[@id='support-item-3']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//div[@id='support-item-4']")
	public WebElementFacade searchWrits_support;

	public WebElementFacade link_searchWrits_support(int linkNo) {
		return findBy("//div[@id='support-item-4']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//div[@id='support-item-5']")
	public WebElementFacade OWL_support;

	public WebElementFacade link_OWL_support(int linkNo) {
		return findBy("//div[@id='support-item-5']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//div[@id='support-item-6']")
	public WebElementFacade writFiling_support;

	public WebElementFacade link_writFiling_support(int linkNo) {
		return findBy("//div[@id='support-item-6']//ul/li[" + linkNo + "]/a");
	}

	@FindBy(xpath = "//html/body/span/span/p[1]")
	public WebElementFacade pageTitle_Term;

	@FindBy(xpath = "//html/body/div/p[2]")
	public WebElementFacade pageTitle_Policy;

	@FindBy(xpath = "//html/body/h1")
	public WebElementFacade pageTitle_Benefit;
}
