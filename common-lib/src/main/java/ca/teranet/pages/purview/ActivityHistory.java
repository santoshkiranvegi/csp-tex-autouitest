package ca.teranet.pages.purview;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ActivityHistory extends BasePage {

	public WebElementFacade searchResults_Pin_Number(String pinNumber) {
		return findBy("(//td[@class='GKOWYUYDHC GKOWYUYDJC']/div[text()='" + pinNumber + "'])[1]");
	}

	@FindBy(xpath = "//select[@class='gwt-ListBox']")
	public WebElementFacade dropdownInActivityHistory;

	public WebElementFacade search_pin_or_address(String field) {
		return findBy("(//div[contains(text(),'" + field + "')])[1]");
	}

	@FindBy(xpath = "(//input[@class='gwt-DateBox'])[1]")
	public WebElementFacade pin_Input_textBox;

	@FindBy(xpath = "(//input[@class='gwt-DateBox'])[2]")
	public WebElementFacade fromDate_Input_textBox;

	@FindBy(xpath = "(//input[@class='gwt-DateBox'])[3]")
	public WebElementFacade toDate_Input_textBox;

	@FindBy(xpath = "//table[@class=\"GKOWYUYDPD selectableTable\"]//tr")
	public WebElementFacade rowsInSearchResults;

	public By rows = By.xpath("//table[@class='GKOWYUYDPD selectableTable']//tr[@__gwt_subrow]");

	@FindBy(xpath = "//button[text()='Search Reports']")
	public WebElementFacade searchReports;

	@FindBy(xpath = "//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div")
	public WebElementFacade date;

}