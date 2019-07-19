package ca.teranet.pages.gwh;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LandRegisterPage extends BasePage {

	@FindBy(xpath = "//td[text()='Description:']/following-sibling::td")
	public WebElementFacade description_text;

	@FindBy(xpath = "//td[text()='Address:']/following-sibling::td")
	public WebElementFacade data_tbl_Glenmount;

	@FindBy(xpath = "//td[text()='Municipality:']/following-sibling::td")
	public WebElementFacade data_tbl_Tornoto;

	@FindBy(xpath = "//label[text()='Land Registry Status:']/following::td")
	public WebElementFacade data_tbl_Active;

	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade cell_data_1_1;

	@FindBy(xpath = "//td[@class='propertylist1']")
	public WebElementFacade Text_propertylist1;

	@FindBy(xpath = "//td[@class='propertylist2']")
	public WebElementFacade Text_propertylist2;

	@FindBy(xpath = "//td[text()='Area:']/following-sibling::td")
	public WebElementFacade label_Area;

	@FindBy(xpath = "//td[text()='Perimeter:']/following-sibling::td")
	public WebElementFacade label_Perimeter;

	@FindBy(xpath = "//label[text()='Registration Type:']/following::td")
	public WebElementFacade Registration_text;

	@FindBy(xpath = "//td[text()='Party To:']/following-sibling::td")
	public WebElementFacade partyto_Text;

	@FindBy(xpath = "//td[text()='LRO:']/following-sibling::td")
	public WebElementFacade LRO_Text;

	@FindBy(xpath = "//img[@title='SearchÂ mortgages, liens, transfers, easements, and other registrations on title']")
	public WebElementFacade Storetag_button_frame;

	public WebElementFacade Expected_Text_beside_date(String Expected) {
		return findBy("//table[@class='data_tbl datamultirow']//td[contains(text(),'" + Expected + "') and @class ='sales_hist']");
	}

	public WebElementFacade Expected_Text_instrument_row(String Expected) {
		return findBy("//td[@class='sales_hist']/label[contains(text(),'" + Expected + "')]");

	}

}
