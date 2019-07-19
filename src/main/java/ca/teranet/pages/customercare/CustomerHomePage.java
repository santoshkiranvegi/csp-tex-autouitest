package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomerHomePage extends BasePage {

	// login button
	@FindBy(xpath = "//img[@name='member_search']")
	public WebElementFacade img_member_search;

	// header link
	@FindBy(xpath = "//img[@name='logout']")
	public WebElementFacade header_logout;

	@FindBy(xpath = "//input[@name='customerId']")
	public WebElementFacade input_ByMember;

	@FindBy(xpath = "//input[@value='Quick Search']")
	public WebElementFacade button_Quick_Search;

	@FindBy(xpath = "//img[@name='new_user']")
	public WebElementFacade img_new_user;

	@FindBy(xpath = "//img[@name='company_search']")
	public WebElementFacade img_company_search;

}
