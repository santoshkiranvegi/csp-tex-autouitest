package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReportPage extends BasePage {

	// Get the field value by passing field name
	// Ex: Perimeter,Area,PIN,Registration Type,Property Type
	public WebElementFacade Report_Fields(String fieldname, String data) {
		return findBy("//label[text()='" + fieldname + "']/following-sibling::span[text()='" + data + "']");
	}

	// Get the field value by passing field name
	// Ex: Property, Owner, Description
	public WebElementFacade Report_Initial_fields(String fieldname) {
		return findBy("//label[text()='" + fieldname + "']//following-sibling::a/span");
	}

}
