package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchNameAddressPage extends BasePage {

	@FindBy(xpath = "//INPUT[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//INPUT[@id='criteriaView.address.area']")
	public WebElementFacade CityTown_WebEdit;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//TR[4]/TD[1]/INPUT[1]")
	public WebElementFacade GivenName_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='Search By Name/Address']")
	public WebElementFacade Header_WebElement;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR/TD[normalize-space()='Include active charge type documents in name search']/INPUT[1]")
	public WebElementFacade IncludeActiveCharge_WebCheckBox;

	@FindBy(xpath = "//TD/TABLE/TBODY/TR/TD[normalize-space()='Include deleted documents in name search']/INPUT[1]")
	public WebElementFacade IncludeDeletedDoc_WebCheckBox;

	@FindBy(xpath = "//input[@id='criteriaView.lastName']")
	public WebElementFacade LastName_WebEdit;

	@FindBy(xpath = "//input[@value='Search']")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//INPUT[@id='criteriaView.address.streetName']")
	public WebElementFacade StreetName_WebEdit;

	@FindBy(xpath = "//INPUT[@id='criteriaView.address.streetIdentifier']")
	public WebElementFacade StreetNumber_WebEdit;

	@FindBy(xpath = "//INPUT[@id='criteriaView.address.suffix']")
	public WebElementFacade Suffix_WebEdit;

	@FindBy(xpath = "//input[@id='criteriaView.address.unitIdentifier']")
	public WebElementFacade UnitNumber_WebEdit;

	@FindBy(xpath = "//SELECT[@id='unitTypeList']")
	public WebElementFacade UnitType_WebList;

}
