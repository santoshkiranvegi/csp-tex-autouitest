package ca.teranet.pages.gwh;

import org.openqa.selenium.By;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertySearchResultsPage extends BasePage {

	// class_compsreportitem
	@FindBy(xpath = "(//*[@class='compsreport-item'])[1]")
	public WebElementFacade class_compsreportitem;

	// class_condo_pins
	@FindBy(xpath = "(//*[@class='condo_pins'])[1]")
	public WebElementFacade class_condo_pins;

	// class_condo_pins1
	@FindBy(xpath = "(//*[@class='condo_pins'])[2]")
	public WebElementFacade class_condo_pins1;

	// class_condo_pins2
	@FindBy(xpath = "(//*[@class='condo_pins'])[4]")
	public WebElementFacade class_condo_pins2;

	// class_condo_pins3
	@FindBy(xpath = "(//*[@class='condo_pins'])[5]")
	public WebElementFacade class_condo_pins3;

	// class_condo_pins4
	@FindBy(xpath = "(//*[@class='condo_pins'])[0]")
	public WebElementFacade class_condo_pins4;

	// class_data_tbldatamultirow
	@FindBy(xpath = "(//*[@class='data_tbl datamultirow'])[0]")
	public WebElementFacade class_data_tbldatamultirow;

	// class_data_tbldatamultirow1
	@FindBy(xpath = "(//*[@class='data_tbl datamultirow'])[1]")
	public WebElementFacade class_data_tbldatamultirow1;

	// class_data_tbldatamultirow2
	@FindBy(xpath = "(//*[@class='data_tbl datamultirow'])[3]")
	public WebElementFacade class_data_tbldatamultirow2;

	// class_data_tbldatamultirow3
	@FindBy(xpath = "(//*[@class='data_tbl datamultirow'])[2]")
	public WebElementFacade class_data_tbldatamultirow3;

	// class_data_tbldatasinglerowstyle
	@FindBy(xpath = "//*[@class='data_tbl datasinglerowstyle']")
	public WebElementFacade class_data_tbldatasinglerowstyle;

	// class_data_tbldatasinglerowstyle1
	@FindBy(xpath = "(//*[@class='data_tbl datasinglerowstyle'])[0]")
	public WebElementFacade class_data_tbldatasinglerowstyle1;

	// class_nameslink
	@FindBy(xpath = "(//*[@class='nameslink'])")
	public WebElementFacade class_nameslink;

	// SearchResultsData
	@FindBy(xpath = "(//*[@class='piisummaryboxdata'])")
	public WebElementFacade class_piisummaryboxdata;

	@FindBy(xpath = "//table[@class='piisummaryboxdata']")
	public WebElementFacade class_piisummaryboxdata1;

	@FindBy(xpath = "//td[@class='propertylist2']")
	public WebElementFacade Text_propertylist2;

	@FindBy(xpath = "//td[@class='propertylist1']")
	public WebElementFacade Text_propertylist1;

	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade Text_piisummaryaddrhdr;

	@FindBy(xpath = "//table[@class=' piisummaryboxdata']")
	public WebElementFacade class_piisummaryboxdata2;

	@FindBy(xpath = "//*[@class='resultcontheader']")
	public WebElementFacade class_resultcontheader;

	@FindBy(xpath = "//*[@class='yui-skin-sam']")
	public WebElementFacade class_yuiskinsam;

	@FindBy(xpath = "//*[@id='imageflip']")
	public WebElementFacade id_imageflip;

	@FindBy(xpath = "//*[@id='pagination']")
	public WebElementFacade id_pagination;

	@FindBy(xpath = "//*[@name='Search' and @id='searchPlansBtn']")
	public WebElementFacade id_searchPlansBtn;

	@FindBy(xpath = "//div[@id='suggestion']")
	public WebElementFacade id_suggestion;

	@FindBy(xpath = "(//*[@id='suggestion'])[1]")
	public WebElementFacade id_suggestion1;

	@FindBy(xpath = "//*[@id='swfdiv']")
	public WebElementFacade id_swfdiv;

	@FindBy(xpath = "//*[text() = '128890279']")
	public WebElementFacade innertext_128890279;

	@FindBy(xpath = "//a[text() = 'Add To Comps Report']")
	public WebElementFacade innertext_AddToCompsReport;

	@FindBy(xpath = "(//*[text() = 'Export'])[0]")
	public WebElementFacade innertext_Export;

	@FindBy(xpath = "(//*[text() = 'Print'])[0]")
	public WebElementFacade innertext_Print;

	@FindBy(xpath = "//*[@name='Add New']")
	public WebElementFacade name_AddNew;

	@FindBy(xpath = "//a[contains(text(),'Assessment Details')]")
	public WebElementFacade name_AssessmentDetails;

	@FindBy(xpath = "(//*[@name='AssessmentReports'])[0]")
	public WebElementFacade name_AssessmentReports;

	@FindBy(xpath = "//*[@name='Comparables Search ']")
	public WebElementFacade name_ComparablesSearch;

	@FindBy(xpath = "//*[@name='Comps Report ']")
	public WebElementFacade name_CompsReport;

	@FindBy(xpath = "//*[@name='Cultural']")
	public WebElementFacade name_Cultural;

	@FindBy(xpath = "//*[@name='Cultural ']")
	public WebElementFacade name_Cultural1;

	@FindBy(xpath = "//*[@name='Demographics']")
	public WebElementFacade name_Demographics;

	@FindBy(xpath = "//*[@name='Demographics ']")
	public WebElementFacade name_Demographics1;

	@FindBy(xpath = "//*[@name='Enhanced Report']")
	public WebElementFacade name_EnhancedReport;

	@FindBy(xpath = "//*[@name='GeoWarehouse Store']")
	public WebElementFacade name_GeoWarehouseStore;

	@FindBy(xpath = "//*[@name='Households']")
	public WebElementFacade name_Households;

	@FindBy(xpath = "//*[@name='InsuranceClaims History']")
	public WebElementFacade name_InsuranceClaimsHistory;

	@FindBy(xpath = "//*[@id='assessmentHelpMoreId' and @name='More >>']")
	public WebElementFacade name_More;

	@FindBy(xpath = "//*[@name='ParcelRegister']")
	public WebElementFacade name_ParcelRegister;

	@FindBy(xpath = "//*[@name='Pin']")
	public WebElementFacade name_Pin;

	@FindBy(xpath = "//*[@name='Plan List By PIN']")
	public WebElementFacade name_PlanListByPIN;

	@FindBy(xpath = "//*[@name='Population']")
	public WebElementFacade name_Population;

	@FindBy(xpath = "//*[@name='Print']")
	public WebElementFacade name_Print;

	@FindBy(xpath = "//*[@name='Property Details']")
	public WebElementFacade name_PropertyDetails;

	@FindBy(xpath = "(//*[@class='piisummaryboxdata' and @name='Property Details'])")
	public WebElementFacade name_PropertyDetails1;

	@FindBy(xpath = "//*[@name='Property Survey/SRPR Plan Search']")
	public WebElementFacade name_PropertySurveySRPRPlanSearch;

	@FindBy(xpath = "//*[@name='Remove']")
	public WebElementFacade name_Remove;

	@FindBy(xpath = "(//*[@name='Remove' and @visible='true'])[1]")
	public WebElementFacade name_Remove1;

	@FindBy(xpath = "(//*[@name='Search'])[1]")
	public WebElementFacade name_Search;

	@FindBy(xpath = "//*[@name='Search By Block']")
	public WebElementFacade name_SearchByBlock;

	@FindBy(xpath = "//*[@name='Socio-Economic']")
	public WebElementFacade name_SocioEconomic;

	@FindBy(xpath = "//*[@name='View']")
	public WebElementFacade name_View;

	@FindBy(xpath = "//*[@name='View Instrument/Plan']")
	public WebElementFacade name_ViewInstrumentPlan;

	@FindBy(xpath = "//*[@name='View Instrument/Plan Link']")
	public WebElementFacade name_ViewInstrumentPlanLink;

	@FindBy(xpath = "(//*[@class='data_tbl datamultirow' and @name='WebTable'])")
	public WebElementFacade name_WebTable;

	@FindBy(xpath = "(//*[@name='WebTable'])[1]")
	public WebElementFacade name_WebTable1;

	@FindBy(xpath = "//*[@name='bufferRange']")
	public WebElementFacade name_bufferRange;

	@FindBy(xpath = "//*[@name='store_tag']")
	public WebElementFacade name_store_tag;

	@FindBy(xpath = "//*[@name='store_tag' and @text='Condominium Information Condo Status Certificate']")
	public WebElementFacade name_store_tag1;

	@FindBy(xpath = "//span[]")
	public WebElementFacade webobject;

	@FindBy(xpath = "(//*[@text='Purchase Plan'])[1]")
	public WebElementFacade webobject1;

	@FindBy(xpath = "//*[@file name='button_pagination_next.gif']")
	public WebElementFacade webobject2;

	@FindBy(xpath = "//*[@file name='button_pagination_last.gif']")
	public WebElementFacade webobject3;

	@FindBy(xpath = "//*[@file name='button_pagination_prev.gif']")
	public WebElementFacade webobject4;

	@FindBy(xpath = "//*[@file name='button_pagination_first.gif']")
	public WebElementFacade webobject5;

	@FindBy(xpath = "//*[@file name='no_google_view_medium.png']")
	public WebElementFacade webobject6;

	@FindBy(xpath = "(//a[@color='#0066cc'])[6]")
	public WebElementFacade webobject7;

	@FindBy(xpath = "(//h6[])[4]")
	public WebElementFacade webobject8;

	// webobject9
	@FindBy(xpath = "(//h6[])[6]")
	public WebElementFacade webobject9;

	// demographic link
	@FindBy(xpath = "//a[contains(text(),'Demographics')]")
	public WebElementFacade demographic_link;

	// data is currently unavailable.
	@FindBy(xpath = "//div[@id='swfdiv' and @class='iframedocdiv']")
	public WebElementFacade data_msg;

	// 21 DORCHESTER CRES text
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr']")
	public WebElementFacade house_name;

	// Socio-economic link
	@FindBy(xpath = "//a[@id='demo-se-a']")
	public WebElementFacade socio_link;

	// population link
	@FindBy(xpath = "//a[@id='demo-pop-a']")
	public WebElementFacade population_link;

	// households link
	@FindBy(xpath = "//a[@id='demo-hh-a']")
	public WebElementFacade households_link;

	// cultural link
	@FindBy(xpath = "//a[@id='demo-c-a']")
	public WebElementFacade cultural_link;

	// print link
	@FindBy(xpath = "//span[contains(text(),'Print')]")
	public WebElementFacade print_link;

	// checkbox Domain Market Group
	@FindBy(xpath = "//input[@id='cbDominantMarketGroup']")
	public WebElementFacade checkbox_marketgp;

	// click on cultural check box
	@FindBy(xpath = "//div[@id='wait_c']//input[@id='cbCultural']")
	public WebElementFacade checkbox_cultural;

	// click on preview button
	@FindBy(xpath = "//div[@align='center']//input[@value='Preview']")
	public WebElementFacade preview_button;

	// special characters not allowed in pin error message
	@FindBy(xpath = "//div[contains(@style,'display: block')]/child::span[starts-with(@id,'errorConsole')]")
	public WebElementFacade disp_errormsg;

	// search result that no matching property found. please revise your search criteria
	@FindBy(xpath = "//div[@id='searchresultcont']//div[@id='suggestion']")
	public WebElementFacade noproperty_msg;

	// verifies pin number // status
	@FindBy(xpath = "//table[@class='piisummaryboxdata']//tr[2]//td[@class='propertylist2']")
	public WebElementFacade pin_status;

	// first property name when search by pin
	@FindBy(xpath = "//span[@class='piisummaryaddrhdr'][1]")
	public WebElementFacade name_property;

	// municipality and postal code
	@FindBy(xpath = "//table[@class='piisummaryboxdata']//tr[2]//td[@class='propertylist1']")
	public WebElementFacade municipality_pcode;

	// Verify Pin list in search results
	public static By verifypindetails(String pin) {
		return By.xpath("// td[@class='propertylist2' and contains(text(),'" + pin + "')]");
	}

	// PropertySearchResults frame
	public By propertySearchResultsdFrame() {
		return By.xpath("//iframe[@name='PropertySearchResults']");
	}

	// INSTRUMENT NEW WINDOW ELEMENTS

	// PlanType
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[2]")
	public WebElementFacade Plan_Type;

	// instrument new window open text
	@FindBy(xpath = "//div[@class='error-container']//div[@class='error-text']")
	public WebElementFacade instrument_newwindow_errmsg;

	// INSTRUMENT NEW WINDOW ELEMENTS
	// PlanNumber
	@FindBy(xpath = "//div[@class='docImage-container']//tr[@class='docImage-item horizontal-line-lighter']/td[1]")
	public WebElementFacade Instrument_Plan_Number;

	// PlanType
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[2]")
	public WebElementFacade Instrument_Plan_Type;

	// Attachment
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[4]")
	public WebElementFacade Attachment;

	// Format
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[5]")
	public WebElementFacade Format;

	// PageCount
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[6]")
	public WebElementFacade Page_Count;

	// Certified
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[7]")
	public WebElementFacade Certified;

	// ImageLink
	@FindBy(xpath = "//tr[@class='docImage-item horizontal-line-lighter']/td[3]")
	public WebElementFacade Image_Link;

	// Instrument Image :- After clicking on instrument link and purchase image link, it will appear in GWH.
	@FindBy(xpath = "//td[@class='product_detail_table_header_product_name']//following::td[1]")
	public WebElementFacade instrument_image;

	// Hours of service
	@FindBy(xpath = "//td[@class='product_detail_table_header_product_name']//following::td[4]")
	public WebElementFacade hours_of_service;

	//
	public WebElementFacade product_details(int i) {
		return findBy("//td[@class='product_detail_table_header_product_name']//following::td[" + i + "]");
	}

	// PLAN LIST BY PIN LINK
	@FindBy(xpath = "//a[contains(text(),'Plan List By PIN')]")
	public WebElementFacade plan_listbypin_link;

	// CIRCULAR BUFFER
	@FindBy(xpath = "//select[@id='bufferRange']")
	public WebElementFacade buffer_range;

	@FindBy(xpath = "//select[@id='bufferRange']//option[@value='25']")
	public WebElementFacade buffer_value;

	// SEARCH PLAN BUtton
	@FindBy(xpath = " //input[@id='searchPlansBtn']")
	public WebElementFacade search_planbtn;

	// Property details link
	@FindBy(xpath = " //a[contains(text(),'Property Details')]")
	public WebElementFacade propertydetails_link;
}
