package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;

import ca.teranet.pages.polaris.OpenSubdivisionPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.PropertyReportReviewPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class OpenSubdivision extends Utility {

	@Steps
	OpenSubdivisionPage openSubdivisionPage;
	ELRSCommonSteps elrscommon;
	LogSteps logSteps;
	PropertyDetailPage propertyDetailPage;
	PropertyReportReviewPage propertyReportReviewPage;

	public boolean OpenSubdivision_BatchProceed_RetrieveWIP(String strPlanNumber) {
		try {
			String strStepName = null;
			strStepName = "OpenSubdivision_BatchProceed_RetrieveWIP";
			boolean OpenSubdivision_BatchProceed_RetrieveWIP = false;
			boolean intRet = false;
			intRet = elrscommon.user_navigates_to("OpenSubdivision");
			if (intRet == false) {
				return false;
			}
			WaitUtil.waitMSeconds(2000);
			// Browser("ELRS").Page("OpenSubdivision").WebEdit("PlanNumber").TypeStr(strPlanNumber);
			openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
			// Browser("ELRS").Page("OpenSubdivision").WebEdit("PlanNumber").SetValue(strPlanNumber);
			openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
			int intCount = 0;
			intCount = 1;
			while (openSubdivisionPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				if (intCount < 10) {
					WaitUtil.waitMSeconds(2000);
					intRet = elrscommon.user_navigates_to("OpenSubdivision");
					if (intRet == false) {
						return false;
					}
					// Browser("ELRS").Page("OpenSubdivision").WebEdit("PlanNumber").TypeStr(strPlanNumber);
					openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
					// Browser("ELRS").Page("OpenSubdivision").WebEdit("PlanNumber").SetValue(strPlanNumber);
					openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
					intCount = intCount + 1;
					if (openSubdivisionPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
						break;
					}
				} else {
					logSteps.execution_log("<Retrieve WIP> button Not enabled after 10 times of attempts to input Subdivision Plan number <" + strPlanNumber + ">");
					return false;
				}
			}
			openSubdivisionPage.RetrieveWIP_WebButton.click();
			logSteps.execution_log("<Retrieve WIP> button is clicked");
			OpenSubdivision_BatchProceed_RetrieveWIP = true;
			return OpenSubdivision_BatchProceed_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrievePINAndVerifyRemarks_OpenSubdivision(String strDetailInfo, String shtName, String intRow) {
		// Object RetrievePINAndVerifyRemarks_OpenSubdivision = null;
		try {
			// Object strStepName = null;
			// Object intRet = null;
			String strStepName = "RetrievePINAndVerifyRemarks_OpenSubdivision";
			boolean RetrievePINAndVerifyRemarks_OpenSubdivision = false;
			// Object strPlanNumber = null;
			// Object strRemarks = null;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
			// Retrieve expected plan number
			String strPlanNumber = GetValueIfValid("PlanNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase();
			// String strDocumentType1 = strDocumentType.toUpperCase();
			// Set expected remarks
			String strRemarks = strDocumentType + strPlanNumber;
			if (InStr(strDetailInfo, strRemarks) > 0) {
				// Use plan number only to verify as sometimes Plan can//t be retrieved successful
				// strRemarks = "-Subdivision"&strPlanNumber
				// strRemarks = UCase(strRemarks)
				if (InStr(strDetailInfo, strPlanNumber) > 0) {
					// Reporter.reportEvent(Status.Warning, strStepName, "The expected Remarks <" + strDocumentType + " " + strPlanNumber + "> NOT displayed on the PDF page - UnSuccessful");
					// utility.AddInfo("The expected Remarks <" + strDocumentType + " " + strPlanNumber + "> NOT displayed on the PDF page - UnSuccessful");
					return false;
				}
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Remarks: " + strDocumentType + " " + strPlanNumber + "> displayed on the <Map Maintenance Request> page - Successful");
			// utility.AddInfo("<Remarks: " + strDocumentType + " " + strPlanNumber + "> displayed on the <Map Maintenance Request> page - Successful");
			RetrievePINAndVerifyRemarks_OpenSubdivision = true;
			return RetrievePINAndVerifyRemarks_OpenSubdivision;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Proceed in OpenSubdivision $OPENSUBDIVISIONSHEETNAME and $OPENSUBDIVISIONROWINDEX1")
	public boolean OpenSubdivision_Proceed(String shtName, String intRow) {
		boolean OpenSubdivision_Proceed = false;
		try {
			String strStepName = null;
			strStepName = "OpenSubdivision_Proceed";
			// Input data can//t be empty
			if (shtName.isEmpty() || intRow.isEmpty()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The data input can NOT be empty - UnSuccessful");
				// AddInfo("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			boolean intRet = false;
			// Call function to enter data
			intRet = OpenSubdivision_EnterData(shtName, intRow);
			if (intRet == false) {
				return false;
			}
			// Declare variables
			String oPage = null;
			// Retrieve data before Proceed button clicked
			String strPreBlock = openSubdivisionPage.TargetBlock_WebEdit.getValue();
			String strPrePIN = openSubdivisionPage.TargetPIN_WebEdit.getValue();
			String strPrePlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getValue();
			String strPreRemnantNumber = openSubdivisionPage.RemnantNumber_WebEdit.getValue();
			oPage = null;
			openSubdivisionPage.Proceed_WebButton.click();
			VerifyApplicationError();
			// Verify error message
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			// strErrorMsgs = Trim(Browser("ELRS").Page("OpenSubdivision").WebTable("ErrorMsg").GetCellData(1,1))
			strErrorMsgs = openSubdivisionPage.ErrorMsg_WebTable.getText().trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					OpenSubdivision_Proceed = false;
				}
				// Verify the data
				// intRet = OpenSubdivision_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPrePlanNumber, strPreRemnantNumber);
				/*
				 * if (intRet == false) { OpenSubdivision_Proceed = false; } return false;
				 */
			}
			// Verify the existance of Freeze Property page
			// If Browser("ELRS").Page("FreezeProperty").WebElement("Header").Exist (1) Then
			// intRet = VerifyFreezePropertyMessage(strExpectedMsgs)
			// If intRet = "Warning" Then
			// OpenSubdivision_Proceed = "Warning"
			// End If
			// Exit Function
			// End If
			// Verify the page
			/*
			 * if (!propertyDetailPage.ParentPINHeader_WebElement.isPresent()) { // Reporter.reportEvent(Status.Failed,strStepName,"<Property Detail> page Not displayed - UnSuccessful"); // AddInfo("<Property Detail> page Not displayed - UnSuccessful"); return false; }
			 */
			// Verify the Parent PIN
			/*
			 * intRet = propertydetai_bk.PropertyDetail_Verify_ParentPIN(shtName, intRow); if (intRet == false) { // Reporter.reportEvent(Status.Failed,strStepName,"Verification of <Property Detail> page - UnSuccessful"); // AddInfo("Verification of <Property Detail> page - UnSuccessful"); return false; }
			 */
			// Verify non-existance of Bulk Edit button as property detail page is in Bulk Edit mode
			if (!propertyDetailPage.BulkEdit_WebButton.isPresent()) {
				// logSteps.execution_log("<Property Detail Bulk Edit> page displayed - Successful");
				OpenSubdivision_Proceed = true;
			} else {
				// logSteps.execution_log("<Property Detail Bulk Edit> page Not displayed - UnSuccessful");
			}
			OpenSubdivision_Proceed = true;
			return OpenSubdivision_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean OpenSubdivision_EnterData(String shtName, String intRow) {
		boolean OpenSubdivision_EnterData = false;
		try {
			String strStepName = "OpenSubdivision_EnterData";
			// Declare variables
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strPlanNumber = null;
			String strRemnantNumber = null;
			// Fetch valid data
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			System.out.println(strTargetBlock);
			strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			strPlanNumber = GetValueIfValid("PlanNumber", shtName, Integer.parseInt(intRow));
			System.out.println(strPlanNumber);
			strRemnantNumber = GetValueIfValid("RemnantNumber", shtName, Integer.parseInt(intRow));
			// Enter data
			openSubdivisionPage.TargetBlock_WebEdit.clear();
			openSubdivisionPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
			openSubdivisionPage.TargetPIN_WebEdit.clear();
			openSubdivisionPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
			if (!strPlanNumber.isEmpty()) {
				if (strPlanNumber.equalsIgnoreCase("!GENERATE!")) {
					strPlanNumber = Generate_Unique_Randon_RegNumber();
				}
			}
			openSubdivisionPage.PlanNumber_WebEdit.clear();
			openSubdivisionPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);

			// openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
			// 02-12-2013/Jenny/Re-enter plan number if Retrieve WIP button not enabled
			if (!strPlanNumber.equals("IGNORE_VALUE") && !strPlanNumber.isEmpty()) {
				int intCount = 0;
				boolean intRet = true;
				intCount = 1;
				while (openSubdivisionPage.RetrieveWIP_WebButton.getText().equals("True")) {
					if (intCount < 10) {
						// Work around - re-navigate to the page
						Thread.sleep(5);
						intRet = elrscommon.user_navigates_to("OpenSubdivision");
						if (intRet == false) {
							return false;
						}
						openSubdivisionPage.TargetBlock_WebEdit.clear();
						openSubdivisionPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
						openSubdivisionPage.TargetPIN_WebEdit.clear();
						openSubdivisionPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
						openSubdivisionPage.PlanNumber_WebEdit.clear();
						openSubdivisionPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);
						if (!strPlanNumber.isEmpty()) {
							if (strPlanNumber.equalsIgnoreCase("!GENERATE!")) {
								strPlanNumber = Generate_Unique_RegNumber();
							}
						}
						// openSubdivisionPage.PlanNumber_WebEdit.sendKeys("strPlanNumber");
						intCount = intCount + 1;
						if (openSubdivisionPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
							break;
						}
					} else {
						logSteps.execution_log("<Retrieve WIP> button Not enabled after 10 times of attempts to input Subdivision Plan number <" + strPlanNumber + ">");
						return false;
					}
				}
			}
			openSubdivisionPage.RemnantNumber_WebEdit.sendKeys(strRemnantNumber);
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				logSteps.execution_log("Enter data to <Open Subdivision> page - UnSuccessful");
				return false;
			}
			// Report only when parent pin or plan number entered
			if (!strTargetBlock.isEmpty() || !strPlanNumber.isEmpty()) {
				// logSteps.execution_log("Parent PIN: <" + strTargetBlock + "-" + strTargetPIN + ">");
				// logSteps.execution_log("Subdivision Plan Number: <" + strPlanNumber + ">");
				// logSteps.execution_log("Enter data to <Open Subdivision> page - Successful");
			}
			OpenSubdivision_EnterData = true;
			return OpenSubdivision_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks the Cancel on the Close popup on Property Detail page")
	public boolean PropertyDetail_CancelClose() {
		boolean PropertyDetail_CancelClose = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_CancelClose";

			// Enter dta only data provided
			boolean intRet = false;
			propertyDetailPage.Cancel_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Click <Close> button - UnSuccessful");
				// utility.AddInfo("Click <Close> button - UnSuccessful");
				return false;
			}
			// utility.AddInfo("<Close> button is clicked");
			// Click Cancel on the Cancel popup
			String strAction = null;
			strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			// Verify the application returns to the Main Menu page
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Page <Main Menu> NOT displayed - UnSuccessful");
				// utility.AddInfo("Page <Main Menu> NOT displayed - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Main Menu> page displayed - Successful");
			// utility.AddInfo("<Main Menu> page displayed - Successful");
			PropertyDetail_CancelClose = true;
			return PropertyDetail_CancelClose;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks the Retrieve WIP button on the Open Subdivision page $OPENSUBDIVISIONSHEETNAME and $OPENSUBDIVISIONROWINDEX")
	public boolean OpenSubdivision_RetrieveWIP(String shtName, String intRow) {
		// Object OpenSubdivision_RetrieveWIP = null;
		try {
			String strStepName = null;
			strStepName = "OpenSubdivision_RetrieveWIP";
			boolean OpenSubdivision_RetrieveWIP = false;
			boolean intRet = false;
			// Enter data only if applicable
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = OpenSubdivision_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			// Declare variable and fetch the plan number on the screen before Retrieve WIP is clicked as expected value
			String strPrePlanNumber = null;
			strPrePlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getText();
			// Initialization
			// Click the Retrieve WIP button
			openSubdivisionPage.RetrieveWIP_WebButton.click();
			// AddInfo("<Retrieve WIP> button is clicked");
			VerifyApplicationError();
			// Verify error message
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			// Retrieve actual error message from the screen
			strErrorMsgs = getCellData(openSubdivisionPage.ErrorMsg_WebTable, 1, 1).trim();
			// Retrieve expected error message from datasheet
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				// Verify the error message
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					// Set focus
					// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
					// Retrieve expected error message from datasheet
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				} else {
					strExpectedMsgs = "";
				}
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					OpenSubdivision_RetrieveWIP = false;
				}
				// Verify the data
				intRet = OpenSubdivision_Verify_PlanNumber(strPrePlanNumber);
				if (intRet == false) {
					OpenSubdivision_RetrieveWIP = false;
				}
				return false;
			}
			// Verify the page
			if (!propertyDetailPage.ParentPINHeader_WebElement.isPresent()) {
				// 10-03-2012/Jenny/Verify if Summary Report & Draft Parcel Register Review page should be present if in batch mode
				// Object strMode = null;
				String strMode = mainPage.Mode_WebElement.getText();
				if ((strComp(strMode.trim(), "Batch") == 0) && (propertyReportReviewPage.ParentPIN_WebElement.isPresent())) {
					// Reporter.reportEvent(Status.Passed, strStepName, "<Summary Report & Draft Parcel Register Review> page displayed - Successful");
					// AddInfo("<Summary Report & Draft Parcel Register Review> page displayed - Successful");
					OpenSubdivision_RetrieveWIP = true;
					return false;
				}
				// Reporter.reportEvent(Status.Failed, strStepName, "<Property Detail> page Not displayed - UnSuccessful");
				// // AddInfo("<Property Detail> page Not displayed - UnSuccessful");
				return false;
			}
			// Verify non-existance of Bulk Edit button as property detail page is in Bulk Edit mode
			if (!propertyDetailPage.BulkEdit_WebButton.isPresent()) {
				// Reporter.reportEvent(Status.Passed, strStepName, "<Property Detail Bulk Edit> page displayed - Successful");
				// AddInfo("<Property Detail Bulk Edit> page displayed - Successful");
				OpenSubdivision_RetrieveWIP = true;
			} else {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Property Detail Bulk Edit> page Not displayed - UnSuccessful");
				// AddInfo("<Property Detail Bulk Edit> page Not displayed - UnSuccessful");
			}
			return OpenSubdivision_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean OpenSubdivision_Verify_PlanNumber(String strExpectedPlanNumber) {
		boolean OpenSubdivision_Verify_PlanNumber = false;
		try {
			String strStepName = null;
			strStepName = "OpenSubdivision_Verify_PlanNumber";

			// Declare variable
			String strPlanNumber = null;
			// Fetch current value from the screen
			strPlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getAttribute("value");
			// Verify the value
			if (strComp(strPlanNumber, strExpectedPlanNumber.toUpperCase()) == 0) {
				// Reporter.reportEvent(Status.Warning, strStepName, "Verification of Subdivision Plan number <" + strExpectedPlanNumber + "> - UnSuccessful, Actual:<" + strPlanNumber + ">");
				// utility.AddInfo("Verification of Subdivision Plan number <" + strExpectedPlanNumber + "> - UnSuccessful, Actual:<" + strPlanNumber + ">");
				logSteps.execution_log("Verification of Subdivision Plan number <" + strExpectedPlanNumber + "> - UnSuccessful, Actual:<" + strPlanNumber + ">");
			}
			OpenSubdivision_Verify_PlanNumber = true;
			return OpenSubdivision_Verify_PlanNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Cancel the Cancel Open Subdivision")

	public boolean OpenSubdivision_CancelCancel() {

		boolean OpenSubdivision_CancelCancel = false;

		try {

			String strStepName = null;

			strStepName = "OpenSubdivision_CancelCancel";

			boolean intRet = false;

			String strPreBlock = openSubdivisionPage.TargetBlock_WebEdit.getValue();

			String strPrePIN = openSubdivisionPage.TargetPIN_WebEdit.getValue();

			String strPrePlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getValue();

			String strPreRemnantNumber = openSubdivisionPage.RemnantNumber_WebEdit.getValue();

			openSubdivisionPage.Cancel_WebButton.click();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - UnSuccessful");

				return false;

			}

			// logSteps.execution_log("Click <Cancel> button - Successful");

			String strAction = null;

			strAction = "Cancel";

			intRet = elrscommon.ELRS_Popup_Cancel(strAction);

			if (intRet == false) {

				logSteps.execution_log("Click <Cancel> button on the Cancel Popup - UnSuccessful");

				return false;

			}

			if (!openSubdivisionPage.PlanNumber_WebEdit.isPresent()) {

				// logSteps.execution_log("The text box <Subdivision Plan Number> Not present on the page. Verification of the <Open Subdivision> page - UnSuccessful");

				return false;

			}

			intRet = OpenSubdivision_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPrePlanNumber, strPreRemnantNumber);

			if (intRet == false) {

				// logSteps.execution_log("Verification of the page - UnSuccessful");

				OpenSubdivision_CancelCancel = false;

				return false;

			}

			logSteps.execution_log("Verification of the page - Successful");

			OpenSubdivision_CancelCancel = true;

			return OpenSubdivision_CancelCancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user Cancel Open Subdivision")

	public boolean OpenSubdivision_Cancel() {

		boolean OpenSubdivision_Cancel = false;

		try {

			String strStepName = null;

			strStepName = "OpenSubdivision_Cancel";

			boolean intRet = false;

			openSubdivisionPage.Cancel_WebButton.click();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - UnSuccessful");

				return false;

			}

			String strAction = null;

			strAction = "OK";

			intRet = elrscommon.ELRS_Popup_Cancel(strAction);

			if (intRet == false) {

				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");

				return false;

			}

			// logSteps.execution_log("<Main Menu> page is displayed - Successful");

			OpenSubdivision_Cancel = true;

			return OpenSubdivision_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user Cancel the Cancel Open Subdivision $shtName and $intRow")

	public boolean OpenSubdivision_CancelCancel(String shtName, String intRow) {

		// Object OpenSubdivision_CancelCancel = null;

		try {

			String strStepName = null;

			strStepName = "OpenSubdivision_CancelCancel";

			boolean intRet = false;

			boolean OpenSubdivision_CancelCancel = false;

			if (!shtName.isEmpty() && !intRow.isEmpty()) {

				intRet = OpenSubdivision_EnterData(shtName, intRow);

				if (intRet == false) {

					return false;

				}

			}

			String strPreBlock = openSubdivisionPage.TargetBlock_WebEdit.getValue();

			String strPrePIN = openSubdivisionPage.TargetPIN_WebEdit.getValue();

			String strPrePlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getValue();

			String strPreRemnantNumber = openSubdivisionPage.RemnantNumber_WebEdit.getValue();

			openSubdivisionPage.Cancel_WebButton.click();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - UnSuccessful");

				return false;

			}

			String strAction = null;

			strAction = "Cancel";

			intRet = elrscommon.ELRS_Popup_Cancel(strAction);

			if (intRet == false) {

				logSteps.execution_log("Click <Cancel> button on the Cancel Popup - UnSuccessful");

				return false;

			}

			// Verify the page

			if (!openSubdivisionPage.PlanNumber_WebEdit.isPresent()) {

				logSteps.execution_log("The text box <Subdivision Plan Number> Not present on the page. Verification of the <Open Subdivision> page - UnSuccessful");

				return false;

			}

			intRet = OpenSubdivision_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPrePlanNumber, strPreRemnantNumber);

			if (intRet == false) {

				// logSteps.execution_log("Verification of the page - UnSuccessful");

				OpenSubdivision_CancelCancel = false;

				return false;

			}

			// logSteps.execution_log("Verification of the page - Successful");

			OpenSubdivision_CancelCancel = true;

			return OpenSubdivision_CancelCancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean OpenSubdivision_VerifyDataNotDiscarded(String strExpectedBlock, String strExpectedPIN, String strExpectedPlanNumber, String strExpectedRemnantNumber) {

		boolean OpenSubdivision_VerifyDataNotDiscarded = false;

		try {

			// String strStepName = null;

			String strStepName = "OpenSubdivision_VerifyDataNotDiscarded";

			// String oPage = null;

			// Retrieve data on the current screen

			String strActualBlock = openSubdivisionPage.TargetBlock_WebEdit.getValue();

			String strActualPIN = openSubdivisionPage.TargetPIN_WebEdit.getValue();

			String strActualPlanNumber = openSubdivisionPage.PlanNumber_WebEdit.getValue();

			String strActualRemnantNumber = openSubdivisionPage.RemnantNumber_WebEdit.getValue();

			// String strActualPIN = null;

			// oPage = null;

			// Verify the parent block number

			if (strComp(strActualBlock, strExpectedBlock) == 0) {

				// logSteps.execution_log("Verification of Parent Block: <" + strExpectedBlock + "> - UnSuccessful. Actual: <" + strActualBlock + ">");

				return false;

			}

			if (strComp(strActualPIN, strExpectedPIN) == 0) {

				// logSteps.execution_log("Verification of Parent PIN: <" + strExpectedBlock + "-" + strExpectedPIN + "> - UnSuccessful. Actual: <" + strActualBlock + "-" + strActualPIN + ">");

				return false;

			}

			if (strComp(strActualPlanNumber, strExpectedPlanNumber) == 0) {

				// logSteps.execution_log("Verification of Subdivision Plan Number: <" + strExpectedPlanNumber + "> - UnSuccessful. Actual: <" + strActualPlanNumber + ">");

				return false;

			}

			if (!(strComp(strActualRemnantNumber, strExpectedRemnantNumber) == 0)) {

				// logSteps.execution_log("Verification of Number of Remnant Properties: <" + strExpectedRemnantNumber + "> - UnSuccessful. Actual: <" + strActualRemnantNumber + ">");

			}

			OpenSubdivision_VerifyDataNotDiscarded = true;

			return OpenSubdivision_VerifyDataNotDiscarded;

		} catch (

		Exception e) {

			e.printStackTrace();

			return false;

		}

	}

}
