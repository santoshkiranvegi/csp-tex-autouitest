package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BatchPage extends BasePage {

	@FindBy(xpath = "//TABLE[@id='batchQueueTable']")
	public WebElementFacade BatchQ_WebTable;

	@FindBy(xpath = "//TR/TD[normalize-space()='Open Property WIP Off-line Certification Request']")
	public WebElementFacade BatchWIPCertificationRequest_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Open Property WIP Off-line Certify Confirmation']")
	public WebElementFacade BatchWIPCertifyConfirmation_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Open Property WIP Batch Record Deletion Confirmation']")
	public WebElementFacade BatchWIPDeletionConfirmation_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Open Property WIP Batch Record Deletion']")
	public WebElementFacade BatchWIPDeletion_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Open Property WIP Off-line Bulk Edit Request']")
	public WebElementFacade BatchWIPEditRequest_WebElement;

	@FindBy(xpath = "//FORM[@id='requestParams']/P[1]")
	public WebElementFacade BatchWIPSummaryReportRequest_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Off-Line Open Property WIP Unavailable']")
	public WebElementFacade BatchWIPUnavailable_WebElement;

	@FindBy(xpath = "//TABLE[@id='message']/TBODY[1]/TR[1]/TD[1]/P[1]")
	public WebElementFacade BulkCertRequestID_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Off-Line Bulk Document Certification Confirmation (Certify)']")
	public WebElementFacade Certify_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Off-Line Bulk Property Maintenance Confirmation (Commit)']")
	public WebElementFacade Commit_WebElement;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Record Historical Document (Complete Recording) Job Confirmation.']")
	public WebElementFacade CompleteRecording_WebElement;

	@FindBy(xpath = "//TR/TD[normalize-space()='Batch Job Deletion Confirmation']")
	public WebElementFacade DeletionConfirmation_WebElement;

	@FindBy(xpath = "//INPUT[@id='discardBulkEditBatch']")
	public WebElementFacade No_WebButton;

	@FindBy(xpath = "//INPUT[@id='BatchPreSubMessageOK']")
	public WebElementFacade OK_WebButton;

	@FindBy(xpath = "//FORM[1]/P[1]")
	public WebElementFacade PreCertification_WebElement;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Schedule Off-Line Historical Document (Pre-submission) Job']")
	public WebElementFacade PreSubmission_Historical_WebElement;

	@FindBy(xpath = "//INPUT[@id='printAllIndr']")
	public WebElementFacade PrintOption_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='printParcelIndr']")
	public WebElementFacade PrintParcelRequest_WebCheckBox;

	@FindBy(xpath = "//TR/TD[normalize-space()='Summary Report & Draft Parcel Register Review']")
	public WebElementFacade PropertyReportReview_WebElement;

	@FindBy(xpath = "//TR/TD/BIG/B[normalize-space()='Off-Line Bulk Document Registration Confirmation(Receipt)']")
	public WebElementFacade Receipt_WebElement;

	@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='User Filter: ALL Users JELENA_BERGER USERG62 Job Type: ALL Jobs CERTIFICATION Correct Certified Doc Delete Registration HISTORICAL REGISTRATION UnDelete Registration']/SPAN[1]/INPUT[1]")
	public WebElementFacade Refresh_WebButton;

	@FindBy(xpath = "//INPUT[@id='fromRow']")
	public WebElementFacade RowFrom_WebEdit;

	@FindBy(xpath = "//INPUT[@id='toRow']")
	public WebElementFacade RowTo_WebEdit;

	@FindBy(xpath = "//INPUT[@id='genReportIndr']")
	public WebElementFacade SummaryReportRequest_WebCheckBox;

	@FindBy(xpath = "//INPUT[@id='confirmBulkEditBatch']")
	public WebElementFacade Yes_WebButton;

}
