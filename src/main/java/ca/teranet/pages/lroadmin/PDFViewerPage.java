package ca.teranet.pages.lroadmin;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PDFViewerPage extends BasePage {

	// for pdf -- selenium object can only verify pdf viewer displayed and the plugin type is PDF
	@FindBy(xpath = "//embed[@id='plugin' and @type='application/pdf']")
	public WebElementFacade button_submit;

	// after click submit button:
	// 1. verify pdf viewer displayed
	// 2. call webService to download pdf file -- many projects has this requirement
	// https://hc.apache.org/httpcomponents-core-ga/httpcore/examples/org/apache/http/examples/ElementalHttpGet.java
	// 3. compare PDF with baseline file -- as utility class

}
