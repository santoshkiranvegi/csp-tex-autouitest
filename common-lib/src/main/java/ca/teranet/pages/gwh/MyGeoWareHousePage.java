package ca.teranet.pages.gwh;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyGeoWareHousePage extends BasePage {

	// My GeoWareHouse link
	@FindBy(xpath = "//a[@title='My Geowarehouse']")
	public WebElementFacade myGeoWareHouselink;

	// company input text box
	@FindBy(xpath = "//td[@class='formfields']/input[@id='company']")
	public WebElementFacade company_Input_TextBox;

	// postal input text box
	@FindBy(xpath = "//td[@class='formfields']/input[@id='postalCode']")
	public WebElementFacade postal_Input_TextBox;

	// save settings button
	@FindBy(xpath = "//input[@value='Save Settings']")
	public WebElementFacade saveSettings_Btn;

	// profile update success message
	@FindBy(xpath = "//div[@id='infoMessages']")
	public WebElementFacade profileUpdateMessage;

	public By userProfileFrame() {
		return By.xpath("//iframe[@id='userprofile']");
	}

}
