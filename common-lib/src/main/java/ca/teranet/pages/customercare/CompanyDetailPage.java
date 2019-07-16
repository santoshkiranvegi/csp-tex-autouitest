package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CompanyDetailPage extends BasePage {

	@FindBy(xpath = "//input[@value='Add Member']")
	public WebElementFacade button_add_member;

	@FindBy(xpath = "//tr[@class='globalHeader']/td")
	public WebElementFacade header_companydetail;

	@FindBy(xpath = "//select[@id='licenseBundleId']")
	public WebElementFacade list_licenseBundle;

	public WebElementFacade licenseBundleID(String name) {
		return findBy("//select[@id='licenseBundleId']/option[contains(text(),'" + name + "')]");
	}

}
