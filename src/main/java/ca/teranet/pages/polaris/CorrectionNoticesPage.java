package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CorrectionNoticesPage extends BasePage {

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='49244: 16912-0003 is currently frozen by USERG62. Please cancel the operation and try again.']")
	public WebElementFacade Error_WebElement;

	@FindBy(xpath = "//INPUT[@id='addNoticeButton']")
	public WebElementFacade AddNew_WebButton;

	@FindBy(xpath = "//INPUT[@id='submitCancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//TR[4]/TD[1]")
	public WebElementFacade Cancel_WebElement;

	@FindBy(xpath = "//input[@value='Commit']")
	public WebElementFacade Commit_WebButton;

	@FindBy(xpath = "//INPUT[@id='correctionNoticeText']")
	public WebElementFacade CorrectionNotice_WebEdit;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//DIV[@id='correctionNoticesContent']/TABLE[normalize-space()='CORRECTION NOTICE1 ON 2012/08/01 BY USERG62. CORRECTION NOTICE2 ON 2012/08/01 BY USERG62. ADD CORRECTION NOTICE ON 2012/08/01 BY USERG62. ADD CORRECTION NOTICE_1 ON 2012/08/01 BY USERG62. ADD CORRECTION NOTICE_1 ON 2012/08/01 BY USERG62. ADD CORRECTON NOTICE_1 ON 2012/08/01 BY USERG62.']")
	public WebElementFacade Notice_WebTable;

	@FindBy(xpath = "//FORM[1]/INPUT[6]")
	public WebElementFacade ReturntoDetails_WebButton;

	@FindBy(xpath = "//FORM[1]/SPAN[2]")
	public WebElementFacade ReviewCorrectionNotices_WebElement;

	@FindBy(xpath = "//INPUT[@value='Remove Selected']")
	public WebElementFacade RemoveSelected_WebButton;

}
