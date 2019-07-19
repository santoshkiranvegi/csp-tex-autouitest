package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchUserProfilePage extends WebTablePage {

	private final String tableProfile = "//form[@id='voDisplayUserDetailList']//table[2]";

	public void setUserProfileTable() {
		this.setTablePath(tableProfile);
	}

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	// ROSCO/TEX Support Zone
	@FindBy(xpath = "//span[@class='title']")
	public WebElementFacade title_userProfile;

	// Results of Search By Fulfillment
	@FindBy(xpath = "//form[@id='voDisplayUserDetailList']//font/b")
	public WebElementFacade subtitle_userProfile;

	@FindBy(xpath = "//form[@id='voDisplayUserDetailList']//p[2]")
	public WebElementFacade inst_userProfile;

	@FindBy(xpath = "//a[@href='/cspadmin/userRegistration/init']")
	public WebElementFacade link_RTSZoneHome;

	public WebElementFacade link_name(int row_id) {
		return findBy(tableProfile + "//tr[" + row_id + "]/td[1]//a");
	}

}
