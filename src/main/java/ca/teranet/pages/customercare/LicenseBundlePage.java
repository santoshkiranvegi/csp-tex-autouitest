package ca.teranet.pages.customercare;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LicenseBundlePage extends BasePage {

	@FindBy(xpath = "//button[@id='new-bundle-button']")
	public WebElementFacade new_button;

	@FindBy(xpath = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/span[@id='ui-id-1']")
	public WebElementFacade header_title;

	@FindBy(xpath = "//form[@id='editBundleForm']//input[@name='name']")
	public WebElementFacade input_name;

	@FindBy(xpath = "//form[@id='editBundleForm']//select[@name='licenseOfferId1']")
	public WebElementFacade list_licenseOfferId1;

	public WebElementFacade licenceOfferID1(String name) {
		return findBy("//form[@id='editBundleForm']//select[@name='licenseOfferId1']/option[contains(text(),'" + name + "')]");
	}

	@FindBy(xpath = "//form[@id='editBundleForm']//select[@name='licenseOfferId2']")
	public WebElementFacade list_licenseOfferId2;

	@FindBy(xpath = "//form[@id='editBundleForm']//select[@name='licenseOfferId3']")
	public WebElementFacade list_licenseOfferId3;

	@FindBy(xpath = "//input[@id='rb-licenseOffer4']")
	public WebElementFacade checkbox_licenseOfferId4;

	@FindBy(xpath = "//input[@id='rb-licenseOffer2']")
	public WebElementFacade checkbox_licenseOfferId2;

	@FindBy(xpath = "//div[@aria-describedby='dialogContentBundle']//span[contains(text(),'OK')]")
	public WebElementFacade button_ok;

	@FindBy(xpath = "//form[@id='editBundleForm']//textarea[@id='desc']")
	public WebElementFacade desc_input;

	// ---- below are the objects for new offer
	@FindBy(xpath = "//button[@id='new-offer-button']")
	public WebElementFacade button_new_offer;

	@FindBy(xpath = "//div[@class='ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix']/span[@id='ui-id-2']")
	public WebElementFacade header_offer_title; // text= Offer

	@FindBy(xpath = "//form[@id='editOfferForm']//input[@name='name']")
	public WebElementFacade input_offer_name;

	@FindBy(xpath = "//form[@id='editOfferForm']//textarea[@name='desc']")
	public WebElementFacade input_offer_description;

	@FindBy(xpath = "//form[@id='editOfferForm']//input[@name='price']")
	public WebElementFacade input_offer_price;

	@FindBy(xpath = "//form[@id='editOfferForm']//input[@name='numOfReports']")
	public WebElementFacade input_offer_numberofreports;

	@FindBy(xpath = "//div[@aria-describedby='dialogContentOffer']//span[contains(text(),'OK')]")
	public WebElementFacade button_offer_ok;

	@FindBy(xpath = "//div[@aria-describedby='dialogContentOffer']//span[contains(text(),'Cancel')]")
	public WebElementFacade button_offer_cancel;

	// ---- below are the objects for edit an offer

	@FindBy(xpath = "//button[@id='edit-offer-button']")
	public WebElementFacade button_edit_offer;

	public WebElementFacade offer_name(String name) {
		return findBy("//div[@id='license-offer-list_wrapper']//td[contains(text(),'" + name + "')]");
	}

}
