package ca.teranet.pages.tex;

import java.util.List;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertyDescriptionPage extends WebTablePage {

	private final String tablePropertyDespXpath = "//table[@class='zebra']";

	// NOTE: If applicable, only the first 1000 instruments and/or 250 parties to/from will be printed on the property record.
	@FindBy(xpath = "//form[@id='propertySearchVO']")
	public WebElementFacade note_form;

	// NOTE: More than 100 PINs found. Please refine your search using a different criteria.
	@FindBy(xpath = "//form[@id='propertySearchVO']/b")
	public WebElementFacade note_number;

	public void setPropertyDespTable(int propertyNo) {
		this.setTablePath(tablePropertyDespXpath + "[" + propertyNo + "]");
	}

	public List<WebElementFacade> get_property_desp_tables() {
		return findAll("//table[@class='zebra']");
	}

	public WebElementFacade checkbox_select(int propertyNo) {
		return findBy(tablePropertyDespXpath + "//input[@name='pinInfoList[" + (propertyNo - 1) + "].selectedInd']");
	}

	public WebElementFacade checkbox_includeDelete(int propertyNo) {
		return findBy(tablePropertyDespXpath + "//input[@name='pinInfoList[" + (propertyNo - 1) + "].includeDeleted']");
	}

	@FindBy(xpath = "//input[@name='SelectAll']")
	public WebElementFacade checkbox_selectAll;

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

}
