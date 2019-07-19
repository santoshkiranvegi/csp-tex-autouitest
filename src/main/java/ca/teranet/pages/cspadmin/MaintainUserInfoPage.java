package ca.teranet.pages.cspadmin;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MaintainUserInfoPage extends WebTablePage {

	private final String tableProfileDetail = "//form[@id='voDisplayUserDetail']//table";

	@FindBy(xpath = "//body")
	public WebElementFacade pageBody;

	public void setUserProfileDetailTable() {
		this.setTablePath(tableProfileDetail);
	}

	public WebElementFacade input_item(int row_id) {
		return findBy(tableProfileDetail + "//tr[" + row_id + "]/td[2]/input");
	}

	@FindBy(xpath = "//input[@value='Update']")
	public WebElementFacade button_update;

	@FindBy(xpath = "//a[@href='/cspadmin/userRegistration/init']")
	public WebElementFacade link_RTSZoneHome;

	// maintain user info result page
	@FindBy(xpath = "//table[@id='base']//b")
	public WebElementFacade return_msg;

}
