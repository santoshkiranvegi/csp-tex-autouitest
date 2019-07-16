package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchHwyTCPLPage extends BasePage {

	@FindBy(xpath = "//input[@value='Cancel']")
	public WebElementFacade Cancel_WebButton;

	@FindBy(xpath = "//input[@name='toDateRange']")
	public WebElementFacade EndDate_WebEdit;

	@FindBy(xpath = "//TABLE[@id='messages']")
	public WebElementFacade ErrorMsg_WebTable;

	@FindBy(xpath = "//td[contains(text(),'Search TransCanada Pipeline Index')]")
	public WebElementFacade Header_WebElement;

	// @FindBy(xpath = "//TR/TD[normalize-space()='Highway Number']/INPUT[2]")
	@FindBy(xpath = "//input[@name='criteriaView.hwyNumPart1']")
	public WebElementFacade HwyNumber1_WebEdit;

	// @FindBy(xpath = "//TR/TD[normalize-space()='Highway Number']/INPUT[3]")
	@FindBy(xpath = "//input[@name='criteriaView.hwyNumPart2']")
	public WebElementFacade HwyNumber2_WebEdit;

	@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='Registration NumberRegistration DateDocument TypeDeleted?P Plan NumberRemarksHighway NumberMunicipality HT6033544 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 EAST CITY OF HAMILTON HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 EAST CITY OF HAMILTON HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 EAST UNORGANIZED TERRITORIES HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 EAST CITY OF HAMILTON HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 EAST UNORGANIZED TERRITORIES HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 WEST CITY OF HAMILTON HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 WEST UNORGANIZED TERRITORIES HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 WEST CITY OF HAMILTON HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS 401 WEST UNORGANIZED TERRITORIES HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS DVP CITY OF HAMILTON HT6033545 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS DVP UNORGANIZED TERRITORIES HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS DVP CITY OF HAMILTON HT6033546 2013/01/24 TRANSFER No P-1111-AAAAAAAAAAAAAAAAAAAAAAAAA TC38455_STEP1: HIGHWAYS REGISTER SPECIFIC DOCUMENT REMARKS DVP UNORGANIZED TERRITORIES']")
	public WebElementFacade HwyResultsTable_WebTable;

	// @FindBy(xpath = "//TR/TD[normalize-space()='Include Deleted Documents']/INPUT[1]")
	@FindBy(xpath = "//input[@name='deletedDocsIncluded']")
	public WebElementFacade IncludeDeletedDocuments_WebCheckBox;

	@FindBy(xpath = "//TR[7]/TD[1]/INPUT[2]")
	public WebElementFacade MoreHwyMunicipality_WebButton;

	// @FindBy(xpath = "//TR/TD[normalize-space()='P Plan Number P- -']/INPUT[2]")
	@FindBy(xpath = "//input[@name='criteriaView.hwyPlanNumPart1']")
	public WebElementFacade PlanNumber1_WebEdit;

	// @FindBy(xpath = "//TR/TD[normalize-space()='P Plan Number P- -']/INPUT[3]")
	@FindBy(xpath = "//input[@name='criteriaView.hwyPlanNumPart2']")
	public WebElementFacade PlanNumber2_WebEdit;

	@FindBy(xpath = "//input[@value='Print Report']")
	public WebElementFacade PrintReport_WebButton;

	// @FindBy(xpath = "//TR/TD[normalize-space()='Registration Number']/INPUT[2]")
	@FindBy(xpath = "//input[@name='criteriaView.registrationNumber']")
	public WebElementFacade RegistrationNumber_WebEdit;

	@FindBy(xpath = "//TR[7]/TD[1]/INPUT[1]")
	public WebElementFacade RemoveHwyMunicipality_WebButton;

	@FindBy(xpath = "//input[@id='searchByDate']")
	public WebElementFacade SearchBy_Date;

	@FindBy(xpath = "//input[@id='searchByMunicipality']")
	public WebElementFacade SearchBy_Municipality;

	@FindBy(xpath = "//input[contains(@value,'Search')]")
	public WebElementFacade Search_WebButton;

	@FindBy(xpath = "//INPUT[@id='sortByDate']")
	public WebElementFacade SortBy_Date;

	@FindBy(xpath = "//INPUT[@id='sortByMunicipality']")
	public WebElementFacade SortBy_Municipality;

	@FindBy(xpath = "//input[@name='fromDateRange']")
	public WebElementFacade StartDate_WebEdit;

	@FindBy(xpath = "//SELECT[@id='municipality']")
	public WebElementFacade TCPLMunicipality_WebList;

	@FindBy(xpath = "//TR/TD/TABLE[normalize-space()='Registration NumberRegistration DateDocument TypeDeleted?Survey NumberRemarksMunicipalityOther Pins/Indices HT6033547 2013/01/24 TRANSFER No 1234567890 TC38481: SEARCH TRANSCANADA PIPELINE INDEX UNORGANIZED TERRITORIES No']")
	public WebElementFacade TCPLResultsTable_WebTable;

	@FindBy(xpath = "//*[@id='searchELRSForm.errors']")
	public WebElementFacade ErrorMsg_WebTable_Tcpl;

}
