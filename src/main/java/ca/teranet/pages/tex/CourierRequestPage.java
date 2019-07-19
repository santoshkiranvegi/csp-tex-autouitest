package ca.teranet.pages.tex;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CourierRequestPage extends BasePage {

	@FindBy(xpath = "//input[@id='emailAddress']")
	public WebElementFacade input_emailAddress;

	@FindBy(xpath = "//input[@id='requestorName']")
	public WebElementFacade input_requestorName;

	@FindBy(xpath = "//input[@id='companyName']")
	public WebElementFacade input_companyName;

	@FindBy(xpath = "//input[@id='streetAddress']")
	public WebElementFacade input_deliveryAddress;

	@FindBy(xpath = "//input[@id='city']")
	public WebElementFacade input_city;

	@FindBy(xpath = "//input[@id='province']")
	public WebElementFacade input_province;

	@FindBy(xpath = "//input[@id='postalCode']")
	public WebElementFacade input_postalCode;

	@FindBy(xpath = "//input[@id='phone']")
	public WebElementFacade input_phoneNumber;

	@FindBy(xpath = "//input[@id='deliveryInstructions']")
	public WebElementFacade input_deliveryInstructions;

	@FindBy(xpath = "//select[@id='selectedLro.lroNum']")
	public WebElementFacade select_lro;

	// 0-9
	public WebElementFacade input_planNumber(int planNo) {
		return findBy("//input[@name='planLroList[" + planNo + "].planNumber']");
	}

	public WebElementFacade input_planCopies(int planNo) {
		return findBy("//input[@name='planLroList[" + planNo + "].copies']");
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	// ============== negative ==================================
	// error messages
	@FindBy(xpath = "//span[@id='courierErrorMsg.errors']")
	public WebElementFacade page_errorMsg_courier;

}
