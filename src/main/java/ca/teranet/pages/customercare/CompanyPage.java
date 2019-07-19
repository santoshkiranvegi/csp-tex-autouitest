package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CompanyPage extends BasePage {

	@FindBy(xpath = "//select[@name='licenseBundleId']")
	public WebElementFacade list_bundle;

	@FindBy(xpath = "//input[@value='Add Member']")
	public WebElementFacade button_add_member;

	@FindBy(xpath = "//td[@id='pagetitle']")
	public WebElementFacade header_title;

	@FindBy(xpath = "//input[@name='customerId']")
	public WebElementFacade input_companyID;

	@FindBy(xpath = "//input[@value='Quick Search']")
	public WebElementFacade button_quick_search;

	@FindBy(xpath = "//tr[@class='globalHeader']/td")
	public WebElementFacade header_companypage;

}
