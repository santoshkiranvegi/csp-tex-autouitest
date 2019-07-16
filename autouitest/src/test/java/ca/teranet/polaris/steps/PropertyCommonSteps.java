package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.MapMaintenanceRequestPage;
import ca.teranet.pages.polaris.PrintParcelPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.PropertyReportReviewPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class PropertyCommonSteps extends Utility {

	MapMaintenanceRequestPage mapMaintenanceRequestPage;
	PropertyReportReviewPage propertyReportReviewPage;
	@Steps
	LogSteps logSteps;
	BatchPage batchPage;
	PrintParcelPage printParcelPage;
	DividePropertySteps divideProperty;
	CreatePropertySteps createPropertySteps;
	OpenSubdivision openSubdivision;
	OpenCondominium openCondominium;
	CondoAmalgamation condoAmalgamation;
	CreateUnitsSteps createUnits;
	PropertyDetailSteps propertyDetail;
	PropertyDetailPage propertyDetailPage;

	@When("user clicks on Close button on propertymapmaintenanceRequest page")
	public boolean PropertyMapMaintenanceRequest_Close() {
		boolean PropertyMapMaintenanceRequest_Close = false;
		try {
			String strStepName = "PropertyMapMaintenanceRequest_Close";
			// mainPage.getDriver().switchTo().defaultContent();
			// mainPage.getDriver().switchTo().frame(mainPage.getDriver().findElement(By.name("iframeMapMaint")));
			WaitUtil.waitMSeconds(2000);
			javascriptClick(mainPage.getDriver().findElement(By.xpath("//INPUT[@id='homePageButton']")));
			// MapmaintenancePDFClose();
			// mapMaintenanceRequestPage.Close_WebButton.click();
			boolean intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Main Menu> page is NOT displayed after <Close> button is clicked on <Map Maintenance Request> page - UnSuccessful");
				// AddInfo("<Main Menu> page is NOT displayed after <Close> button is clicked on <Map Maintenance Request> page - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Main Menu> page is displayed - Successful");
			// AddInfo("<Main Menu> page is displayed - Successful");
			PropertyMapMaintenanceRequest_Close = true;
			return PropertyMapMaintenanceRequest_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@When("user click Close button on property Map Maintenance Request page")
	public boolean user_click_Close_button_on_property_Map_Maintenance_Request_page() {
		boolean PropertyMapMaintenanceRequest_Close = false;
		try {
			String strStepName = "PropertyMapMaintenanceRequest_Close";
			// mainPage.getDriver().switchTo().defaultContent();
			// mainPage.getDriver().switchTo().frame(mainPage.getDriver().findElement(By.name("iframeMapMaint")));
			WaitUtil.waitMSeconds(2000);
			javascriptClick(mainPage.getDriver().findElement(By.xpath("//INPUT[@id='homePageButton']")));
			// MapmaintenancePDFClose();
			// mapMaintenanceRequestPage.Close_WebButton.click();
			boolean intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Main Menu> page is NOT displayed after <Close> button is clicked on <Map Maintenance Request> page - UnSuccessful");
				// AddInfo("<Main Menu> page is NOT displayed after <Close> button is clicked on <Map Maintenance Request> page - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Main Menu> page is displayed - Successful");
			// AddInfo("<Main Menu> page is displayed - Successful");
			PropertyMapMaintenanceRequest_Close = true;
			return PropertyMapMaintenanceRequest_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void javascriptClick(WebElement element) {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) mainPage.getDriver();

			executor.executeScript("arguments[0].click();", element);

		} catch (Exception e) {

			throw e;

		}

	}

	@When("user click on View Draft Parcel Register or View Summary Report button to review report $strReport")
	public boolean PropertyReportReview_ViewReport(String strReport) {
		try {
			boolean intRet = false;
			boolean PropertyReportReview_ViewReport = false;
			String strButton = null;
			String strButtonName = null;
			String strReportType = null;
			String strType = null;
			switch (strReport.toUpperCase()) {
			case "VIEWDRAFTPARCELREGISTER":
				strButton = "ViewDraftParcelRegister";
				strButtonName = "View Draft Parcel Register(s)";
				strReportType = "Draft Parcel Register";
				// strType = "Parcel"
				// strType = UCase(strType)
				break;
			case "VIEWSUMMARYREPORT":
				strButton = "ViewSummaryReport";
				strButtonName = "View Summary Report";
				strReportType = "Summary Report";
				// strType = "Summary"
				break;
			}
			// propertyReportReviewPage.strButton_webbutton.click();
			propertyReportReviewPage.find(By.xpath("//*[contains(@value," + strButton + ")]")).click();
			logSteps.execution_log("<" + strButtonName + "> button is clicked");
			WaitUtil.waitMSeconds(1000);
			if (!propertyReportReviewPage.ReturnToReviewSelection_WebButton.isPresent()) {
				logSteps.execution_log("<Return To Review Selection> button Not present - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Return To Review Selection> button present - Successful");
			PropertyReportReview_ViewReport = true;
			return PropertyReportReview_ViewReport;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Return To Review Selection button on Draft Parcel Register or Summary Report PDF page")
	public boolean PropertyReportReview_ReturnToReviewSelection() {
		try {
			boolean intRet = false;
			boolean PropertyReportReview_ReturnToReviewSelection = false;
			environmentlib.setProperty("bTriggered", "false");
			propertyReportReviewPage.ReturnToReviewSelection_WebButton.click();
			logSteps.execution_log("<Return To Review Selection> button is clicked");
			if (!batchPage.PropertyReportReview_WebElement.isPresent()) {
				logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page Not displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page displayed - Successful");
			PropertyReportReview_ReturnToReviewSelection = true;
			return PropertyReportReview_ReturnToReviewSelection;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Edit Child with Row ID after Row ID is entered $shtName and $intRow")
	public boolean PropertyReportReview_EditChildWithRowID(String shtName, String intRow) {
		try {
			boolean PropertyReportReview_EditChildWithRowID = false;
			if (shtName.isEmpty() || intRow.isEmpty()) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			String strRowIndex = null;
			String strEditChildPropertyAction = null;
			String strEditChildProperty = null;
			strRowIndex = GetValueIfValid("RowID", shtName, Integer.parseInt(intRow));
			strEditChildPropertyAction = GetValueIfValid("EditChildPropertyAction", shtName, Integer.parseInt(intRow));
			strEditChildProperty = GetValueIfValid("EditChildProperty", shtName, Integer.parseInt(intRow));
			// Browser("ELRS").Page("PropertyReportReview").WebEdit("RowID").TypeStr(strRowIndex);
			propertyReportReviewPage.RowID_WebEdit.clear();
			// Browser("ELRS").Page("PropertyReportReview").WebEdit("RowID").SetValue(strRowIndex);
			propertyReportReviewPage.RowID_WebEdit.sendKeys(strRowIndex);
			propertyReportReviewPage.EditChildProperty_WebButton.click();
			logSteps.execution_log("Row ID <" + strRowIndex + "> is entered");
			logSteps.execution_log("<Edit Child/Remnant with Row ID> button is clicked");
			if (!propertyReportReviewPage.ChildProperty_WebElement.isPresent()) {
				logSteps.execution_log("Property/Block/Unit/Level <" + strRowIndex + "> edit page Not displayed - UnSuccessful");
				return false;
			}
			String strChildProperty = null;
			String strExpectedChild = null;
			boolean intRet = false;
			strChildProperty = propertyReportReviewPage.ChildProperty_WebElement.getText().trim();
			if (InStr(strChildProperty, strRowIndex) > 0) {
				logSteps.execution_log("UnExpected child <" + strChildProperty + "> edit page displayed, Expected index: <" + strRowIndex + "> - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Child <" + strChildProperty + "> edit page displayed - Successful");
			if (strEditChildProperty.toUpperCase() == "YES" || strEditChildProperty.toUpperCase() == "Y" || strEditChildProperty.toUpperCase() == "EDIT") {
				intRet = propertyDetail.PropertyDetail_Batch_EditChildProperty_UsingDataMap(shtName, intRow);
				if (intRet == false) {
					logSteps.execution_log("Edit details of one or more tabs - UnSuccessful");
					return false;
				}
			}
			String strButton = null;
			String strActionName = null;
			switch (strEditChildPropertyAction.toUpperCase()) {
			case "APPLY":
				strButton = "Apply";
				strActionName = strButton;
				break;
			case "DONOTAPPLY":
				strButton = "DoNotApply";
				strActionName = "Do Not Apply";
				break;
			default:
				logSteps.execution_log("UnKnow edit action <" + strEditChildPropertyAction + "> provided - UnSuccessful");
				return false;
			}
			// propertyDetailPage.strButton_webbutton.click();
			propertyDetailPage.find(By.xpath("//*[contains(@value," + strButton + ")]")).click();
			logSteps.execution_log("<" + strActionName + "> button is clicked");
			if (!batchPage.PropertyReportReview_WebElement.isPresent()) {
				logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page Not displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page displayed - Successful");
			PropertyReportReview_EditChildWithRowID = true;
			return PropertyReportReview_EditChildWithRowID;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Certify on Summary Report & Draft Parcel Register Review page $shtName and $intRow")
	public boolean PropertyReportReview_Certify(String shtName, String intRow) {
		try {
			boolean PropertyReportReview_Certify = false;
			if (shtName.isEmpty() || intRow.isEmpty()) {
				logSteps.execution_log("The data input can NOT be empty in order to verify the retired and created PINs - UnSuccessful");
				return false;
			}
			String strBlock = null;
			String strPIN = null;
			String strFunction = null;
			strFunction = mainPage.FuncID_WebElement.getText().trim();
			String strPlanNumber = null;
			if (strFunction == "Create Condo Amendment" || strFunction == "Condominium Amalgamation") {
				strPlanNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			} else {
				strPlanNumber = GetValueIfValid("PlanNumber", shtName, Integer.parseInt(intRow));
				String strParentPINs = null;
				String arrParentPINs[] = null;
				String strPropertyPINs = null;
				String arrPropertyPINs[] = null;
				String strTargetPINs = null;
				String arrTargetPINs[] = null;

				strParentPINs = propertyReportReviewPage.ParentPIN_WebElement.getText();
				arrParentPINs = (strParentPINs.trim()).split("Parent Pin:");
				strPropertyPINs = arrParentPINs[1].trim();
				arrPropertyPINs = (strPropertyPINs).split("(");
				strTargetPINs = arrPropertyPINs[0].trim();
				arrTargetPINs = (strTargetPINs).split("-");
				strBlock = arrTargetPINs[0].trim();
				strPIN = arrTargetPINs[1].trim();
			}
			String strRequestAction = null;
			strRequestAction = GetValueIfValid("RequestAction", shtName, Integer.parseInt(intRow));
			setCheckBoxValue(propertyReportReviewPage.ReviewStatusIndicator_WebCheckBox, "On");
			propertyReportReviewPage.Certify_WebButton.click();
			logSteps.execution_log("<Certify> button is clicked");
			logSteps.execution_log("Page <Open Property WIP Off-line Certification Request> displayed - Successful");
			String strButton = null;
			boolean intRet = false;
			switch (strRequestAction.toUpperCase()) {
			case "NO":
				strButton = "No";
				break;
			default:
				strButton = "Yes";
				break;
			}
			// Click Yes or No button
			// batchPage.strButton_webbutton.click();
			batchPage.find(By.name(strButton)).click();
			logSteps.execution_log("<" + strButton + "> button is clicked");
			if (strButton == "No") {
				if (!batchPage.PropertyReportReview_WebElement.isPresent()) {
					logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page Not displayed - UnSuccessful");
				} else {
					logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page displayed - Successful");
					PropertyReportReview_Certify = true;
				}
				return false;
			}
			if (!batchPage.BatchWIPCertifyConfirmation_WebElement.isPresent()) {
				logSteps.execution_log("<Open Property WIP Off-line Certify Confirmation> page Not displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Open Property WIP Off-line Certify Confirmation> page displayed - Successful");
			batchPage.OK_WebButton.click();
			logSteps.execution_log("<OK> button is clicked");
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			Thread.sleep(5);
			switch (strFunction) {
			case "Divide Single Property":
				intRet = propertyDetail.PropertyDetail_BulkEdit_BatchProceed_Divide(strBlock, strPIN);
				break;
			case "Open Property Subdivision":
				intRet = propertyDetail.PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision(strPlanNumber);
				break;
			case "Open Condominium Property":
				intRet = propertyDetail.PropertyDetail_BulkEdit_BatchProceed_OpenCondominium(strPlanNumber);
				break;
			case "Create Condo Amendment":
				intRet = propertyDetail.PropertyDetail_BulkEdit_BatchProceed_CreateUnits(strPlanNumber);
				break;
			case "Condominium Amalgamation":
				intRet = propertyDetail.PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation(strPlanNumber);
				break;
			default:
				logSteps.execution_log("UnKnown function <" + strFunction + "> provided - UnSuccessful");
				return false;
			}
			if (intRet == false) {
				logSteps.execution_log("Retrieve WIP to complete batch certify process - UnSuccessful");
				return false;
			}
			VerifyApplicationError();
			logSteps.execution_log("<Map Maintenance Request> page displayed - Successful");
			String strAllTexts = getPDFContent(printParcelPage.PDFIFrame);
			// strAllTexts = Browser("ELRS").Page("MapMaintenanceRequest").WinObject("PDFPage").GetVisibleText;
			Thread.sleep((2));
			switch (strFunction) {
			case "CREATE":
				intRet = createPropertySteps.RetrieveCreatedPIN_Create(strAllTexts, shtName, Integer.parseInt(intRow));
			case "Divide Single Property":
				intRet = divideProperty.RetrieveAndVerifyCreatedPIN_Divide(strAllTexts, shtName, intRow);
				break;
			case "Open Property Subdivision":
				intRet = openSubdivision.RetrievePINAndVerifyRemarks_OpenSubdivision(strAllTexts, shtName, intRow);
				break;
			case "Open Condominium Property":
				intRet = openCondominium.RetrievePINAndVerifyRemarks_OpenCondominium(strAllTexts, shtName, intRow);
				break;
			case "Create Condo Amendment":
				intRet = createUnits.RetrievePINAndVerifyRemarks_CreateUnits(strAllTexts, shtName, intRow);
				break;
			case "Condominium Amalgamation":
				intRet = condoAmalgamation.RetrievePINAndVerifyRemarks_CondoAmalgamation(strAllTexts, shtName, intRow);
				break;
			default:
				break;
			}
			logSteps.execution_log("Verification of <Map Maintenance Request> page - Successful");
			PropertyReportReview_Certify = true;
			return PropertyReportReview_Certify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrieveCreatedPINRange(String strDetailInfo, String strBlock, String shtName, String intRow) {
		boolean RetrieveCreatedPINRange = false;
		try {
			boolean intRet = false;
			String arrDetails[] = null;
			String strDetailsFrom = null;
			String strDetailsTo = null;
			String strPINFrom = null;
			String strPINTo = null;
			arrDetails = (strDetailInfo).split("TO");
			strDetailsFrom = arrDetails[0];
			strDetailsTo = arrDetails[1];
			String arrDetailsTo[] = null;
			arrDetailsTo = (strDetailsTo).split("-");
			for (int iLoop = 1; iLoop <= ubound(arrDetailsTo); iLoop++) {
				strPINTo = left(arrDetailsTo[iLoop], 4);
				if (isNumeric(strPINTo)) {
					break;
				}
			}
			strPINFrom = GetValueIfValid("PINFrom", shtName, Integer.parseInt(intRow));
			strPINTo = GetValueIfValid("PINTO", shtName, Integer.parseInt(intRow));
			if (!isNumeric(strPINFrom)) {
				if (!isNumeric(strPINTo)) {
					logSteps.execution_log("Attempt to retrieve PIN From <" + strPINFrom + "> and PIN To <" + strPINTo + "> - UnSuccessful");
					RetrieveCreatedPINRange = false;
				} else {
					logSteps.execution_log("PIN To <" + strPINTo + "> retrieved successfully, but  retrieve PIN From <" + strPINFrom + "> - UnSuccessful");
					RetrieveCreatedPINRange = false;
				}
				return false;
			}
			if (!isNumeric(strPINTo)) {
				logSteps.execution_log("PIN From <" + strPINFrom + "> retrieved successfully, but retrieve PIN To <" + strPINTo + "> - UnSuccessful");
				RetrieveCreatedPINRange = false;
				return false;
			}
			logSteps.execution_log("PINs Created: <" + strBlock + "-" + strPINFrom + " TO " + strBlock + "-" + strPINTo + ">");
			RetrieveCreatedPINRange = true;
			return RetrieveCreatedPINRange;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Correlation List button on Map Maintenance Request page for Divide Property")
	public boolean PropertyMapMaintenanceRequest_CorrelationList_Divide() {
		try {
			boolean PropertyMapMaintenanceRequest_CorrelationList_Divide = false;
			mapMaintenanceRequestPage.CorrelationList_WebButton.click();
			logSteps.execution_log("<Correlation List> button is clicked");
			logSteps.execution_log("<PIN/Description Correlation List> page displayed - Successful");
			// Browser("PINListFullView").close();
			logSteps.execution_log("<PIN/Description Correlation List> page closed - Successful");
			// Verify the map maintenance request map page
			logSteps.execution_log("Application returned to <Map Maintenance Request> page - Successful");
			PropertyMapMaintenanceRequest_CorrelationList_Divide = true;
			return PropertyMapMaintenanceRequest_CorrelationList_Divide;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Remove Batch Open Property Record button on Map Maintenance Request page")
	public boolean PropertyMapMaintenanceRequest_RemoveBatchRecord() {
		try {
			boolean PropertyMapMaintenanceRequest_RemoveBatchRecord = false;
			mapMaintenanceRequestPage.RemoveBatch_WebButton.click();
			logSteps.execution_log("<Remove Batch Open Property Record> button is clicked");
			if (!batchPage.BatchWIPDeletionConfirmation_WebElement.isPresent()) {
				logSteps.execution_log("Page <Open Property WIP Batch Record Deletion Confirmation> Not displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Page <Open Property WIP Batch Record Deletion Confirmation> displayed - Successful");
			batchPage.OK_WebButton.click();
			logSteps.execution_log("<OK> button is clicked");
			boolean intRet = false;
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			PropertyMapMaintenanceRequest_RemoveBatchRecord = true;
			return PropertyMapMaintenanceRequest_RemoveBatchRecord;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
