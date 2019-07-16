package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class FindInstrumentImages extends BasePage {

	// Find Instrument in Municipality text box
	@FindBy(xpath = "//input[@id='gwt-debug-image_search_lro']")
	public WebElementFacade Municipality_Text_Box;

	// Instrument text box
	@FindBy(xpath = "//input[@id='gwt-debug-image_search_instrument']")
	public WebElementFacade Instrument_Text_Box;

	// Search button
	@FindBy(xpath = "//a[@id='btn_image_search']/span[text()='Search']")
	public WebElementFacade Search_btn;

	public WebElementFacade searchResults_instrument_No(String instrumentNo) {
		return findBy("//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div[text()='" + instrumentNo + "']");

	}

	// No results found
	@FindBy(xpath = "//div[@class='gwt-Label report_h2']")
	public WebElementFacade No_Results_Found;

	// PageHeader
	@FindBy(xpath = "//div[@id='title_bar']/h1/span")
	public WebElementFacade FindInstImage_page_header;

	// Search results selection
	public WebElementFacade searchResults_instrument_Number(String pinNumber) {
		return findBy("(//td[@class='GKOWYUYDHC GKOWYUYDJC GKOWYUYDKC']/div[text()='" + pinNumber + "'])[1]");
	}

}
