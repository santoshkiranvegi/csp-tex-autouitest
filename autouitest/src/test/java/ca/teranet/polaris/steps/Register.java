package ca.teranet.polaris.steps;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CertifyConfirmationPage;
import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.DocumentSelectionPage;
import ca.teranet.pages.polaris.DocumentViewPopupPage;
import ca.teranet.pages.polaris.DocumentsPage;
import ca.teranet.pages.polaris.ELRSPage;
import ca.teranet.pages.polaris.FeesTaxesPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.PreSubmissionPage;
import ca.teranet.pages.polaris.RecordHistoricalConfirmationPage;
import ca.teranet.pages.polaris.RegConfirmationPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class Register extends Utility {

	PreSubmissionPage preSubmissionPage;
	DocumentDetailPage documentDetailPage;
	FeesTaxesPage feesTaxesPage;
	MainPage mainPage;
	RegConfirmationPage regConfirmationPage;
	BatchPage batchPage;
	RecordHistoricalConfirmationPage recordHistoricalConfirmationPage;
	ELRSPage eLRSPage;
	CertifyConfirmationPage certifyConfirmationPage;
	DocumentViewPopupPage documentViewPopupPage;
	LogSteps logSteps = new LogSteps();
	@Steps
	ELRSCommonSteps elrsCommonSteps;
	CertifySteps certifySteps;
	DocumentsPage documentsPage;
	DocumentSelectionPage documentSelectionPage;
	@When("user clicks on Submit button on PreSubmission page $shtName and $intRow")
	public boolean user_click_on_submit_on_presubmission_page(String shtName, String intRow) {
		boolean Register_PreSubmission_Submit = false;
		try {
			String strStepName = "Register_PreSubmission_Submit";
			String strErrorMsgs = null;
			int intRowIndex = 0;
			if (intRow.isEmpty()) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			} else {
				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			String strExpectedDocumentType = GetValueIfValid("DocumentType", shtName, intRowIndex).toUpperCase();
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRowIndex).trim();
			if (preSubmissionPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
				if (mainPage.Cancel_WebButton.isDisplayed()) {
					mainPage.Cancel_WebButton.click();
					Alert alert = mainPage.getDriver().switchTo().alert();
					alert.accept();
					WaitUtil.waitMSeconds(1000);
					elrsCommonSteps.user_navigates_to("Register");
				} else {
					logSteps.execution_log("The PreSubmission page is not ready to accept any new entry. Please cancel the previous action");
					Register_PreSubmission_Submit = false;
				}
			}
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				logSteps.execution_log("Enter data to <PreSubmission> - UnSuccessful");
				Register_PreSubmission_Submit = false;
				return false;
			}
			preSubmissionPage.Submit_WebButton.click();
			VerifyApplicationError();
			if (preSubmissionPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.isEmpty()) {
					Register_PreSubmission_Submit = false;
					VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					return false;
				}
			}
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				Register_PreSubmission_Submit = false;
				if (preSubmissionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					} else {
						logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful");
					}
				} else {
					logSteps.execution_log("Unknown page is returned - UnSuccessful");
				}
				return false;
			}
			String strHeadingText = documentDetailPage.Heading_WebTable.getText();
			if (strExpectedDocumentType.equals("APPLICATION (GENERAL) (NO PIN LAND TITLES)")) {
				strExpectedDocumentType = "APPLICATION (GENERAL)";
			}
			if (!strHeadingText.contains(strExpectedDocumentType)) {
				logSteps.execution_log("The <Document Type:> " + strExpectedDocumentType + "Not displayed on the <Document Detail> page - UnSuccessful");
				Register_PreSubmission_Submit = false;
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Register_PreSubmission_EnterData(String shtName, String intRow) {
		boolean Register_PreSubmission_EnterData = true;
		try {
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentType = GetValueIfValid("DocumentType", shtName, iLoop);
				String strDocumentAction = GetValueIfValid("DocumentAction", shtName, iLoop);
				String strFrench = GetValueIfValid("French", shtName, iLoop);
				// strErrorMsg = GetValueIfValid("ErrorMessages", shtName)
				String strRelatedDocument = GetValueIfValid("RelatedDocument", shtName, iLoop);
				String strAlternateDocument = GetValueIfValid("AlternateDocument", shtName, iLoop);
				String strDocumentNotAutomated = GetValueIfValid("DocumentNotAutomated", shtName, iLoop);
				String strMultipleRelatedDocuments = GetValueIfValid("MultipleRelatedDocuments", shtName, iLoop);
				String strTCPL = GetValueIfValid("TCPL", shtName, iLoop);
				String strHWY = GetValueIfValid("HWY", shtName, iLoop);
				String strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				String strTargetBlock = GetValueIfValid("TargetBlock", shtName, iLoop);
				String strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, iLoop);
				String strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, iLoop);
				String strEasementPINIndex = GetValueIfValid("EasementPINIndex", shtName, iLoop);
				String strEasementBlock = GetValueIfValid("EasementBlock", shtName, iLoop);
				String strEasementPINFrom = GetValueIfValid("EasementPINFrom", shtName, iLoop);
				String strEasementPINTo = GetValueIfValid("EasementPINTo", shtName, iLoop);
				String strAddPINAction = GetValueIfValid("AddPINAction", shtName, iLoop);
				String strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, iLoop);
				String strDocument = GetValueIfValid("Document", shtName, iLoop);
				WaitUtil.waitMSeconds(2000);
				setCheckBoxValue(preSubmissionPage.French_WebCheckBox, strFrench);
				preSubmissionPage.DocumentType_WebList.selectByVisibleText(strDocumentType.toUpperCase());
				switch (strDocumentAction.toUpperCase()) {
				case "ADD":
					preSubmissionPage.AddDocument_WebButton.click();
					break;
				case "CHANGE":
					preSubmissionPage.ChangeType_WebButton.click();
					break;
				}
				/*
				 * if (strDocumentAction.toUpperCase().equals("ADD")) { preSubmissionPage.AddDocument_WebButton.click(); }
				 */
				if (!strRelatedDocument.isEmpty()) {
					preSubmissionPage.RelatedDocument_WebEdit.sendKeys(strRelatedDocument);
				}
				if (!strAlternateDocument.isEmpty()) {
					preSubmissionPage.AlternateDocument_WebEdit.sendKeys(strAlternateDocument);
				}
				setCheckBoxValue(preSubmissionPage.DocumentNotAutomated_WebCheckBox, strDocumentNotAutomated);
				setCheckBoxValue(preSubmissionPage.MultipleRelatedDocuments_WebCheckBox, strMultipleRelatedDocuments);
				setCheckBoxValue(preSubmissionPage.TCPL_WebCheckBox, strTCPL);
				setCheckBoxValue(preSubmissionPage.HWY_WebCheckBox, strHWY);
				if (strAddPINAction.toUpperCase().equals("RETRIEVEPINS")) {
					if (!strRegistrationNum.isEmpty()) {
						preSubmissionPage.RegistrationNumber_WebEdit.sendKeys(strRegistrationNum);
					} else {
						if (!strDocument.isEmpty()) {
							preSubmissionPage.SourceDocumentList_WebList.selectByVisibleText(strDocument.toUpperCase());
						}
					}
					preSubmissionPage.RetrievePINs_WebButton.click();
				}
				if (NumberUtils.isNumber(strTargetPINIndex)) {
					int intTargetPINIndex = Integer.parseInt(strTargetPINIndex) - 1;
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].block")).sendKeys(strTargetBlock);
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].property")).sendKeys(strTargetPINFrom);
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].range")).sendKeys(strTargetPINTo);
				}
				if (NumberUtils.isNumber(strEasementPINIndex)) {
					int intEasementPINIndex = Integer.parseInt(strEasementPINIndex) - 1;
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].block")).sendKeys(strEasementBlock);
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].property")).sendKeys(strEasementPINFrom);
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].range")).sendKeys(strEasementPINTo);
				}
			}
			return Register_PreSubmission_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Complete Registration button on the Fees and Taxes page $shtName and $intRow")
	public boolean FeesTaxes_CompleteRegistration(String shtName, String intRow) {
		try {
			boolean FeesTaxes_CompleteRegistration = false;
			feesTaxesPage.CompleteRegistration_WebButton.click();
			return FeesTaxes_CompleteRegistration;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_RegistrationConfirmation(String shtName, String intRow, String strDocType) {
		boolean VerifyPage_RegistrationConfirmation = false;
		try {
			String strStepName = null;
			strStepName = "VerifyPage_RegistrationConfirmation";
			String oPage = null;
			int intRowIndex = 0;
			intRowIndex = 2;
			String strActualRegNumber = null;
			String strActualDocType = null;
			String strActualFees = null;
			String strActualTimeStamp = null;
			strActualRegNumber = getCellData(regConfirmationPage.Confirmation_WebTable, intRowIndex, 1);
			strActualDocType = getCellData(regConfirmationPage.Confirmation_WebTable, intRowIndex, 2);
			strActualFees = getCellData(regConfirmationPage.Confirmation_WebTable, intRowIndex, 3);
			strActualTimeStamp = getCellData(regConfirmationPage.Confirmation_WebTable, intRowIndex, 4);
			String[] arrActualTimeStamp = null;
			String strActualDate = null;
			String strActualTime = null;
			arrActualTimeStamp = (strActualTimeStamp.trim()).split(" ");
			strActualDate = arrActualTimeStamp[0];
			strActualTime = arrActualTimeStamp[1];
			oPage = null;
			CheckExpectedValue(strActualDocType, strDocType.toUpperCase());

			VerifyPage_RegistrationConfirmation = false;

			if (InStr(strActualDocType, "LR'S") > 0) {
				if (!(strActualFees.trim() == "$0.00")) {
					logSteps.execution_log("Expected value of document <" + strActualDocType + "> for <Fees and Tax Collected> is: 0.00, Actual: <" + strActualFees + "> - UnSuccessful");
					VerifyPage_RegistrationConfirmation = false;
					return false;
				} else {
					logSteps.execution_log("Verificatio of document <" + strActualDocType + "> for <Fees and Tax Collected>: 0.00 - Successful");
				}
			}
			if (shtName.isEmpty() && intRow.isEmpty()) {
				boolean intRet = false;
				intRet = Verify_Auto_RegNumber(strActualRegNumber);
				if (intRet == true) {
					VerifyPage_RegistrationConfirmation = true;
				} else {
					VerifyPage_RegistrationConfirmation = false;
				}
				return false;
			}
			String strExpectedRegNum = null;
			strExpectedRegNum = RetrieveExpectedValue("RegNumber", shtName, Integer.parseInt(intRow));
			if (!strExpectedRegNum.isEmpty() && !(strExpectedRegNum.toUpperCase() == "!RANDOM!")) {
				CheckExpectedValue(strActualRegNumber.trim(), strExpectedRegNum.toUpperCase());
			} else {
				if (!(strExpectedRegNum.toUpperCase() == "!RANDOM!")) {
					setTestData("RegNumber", shtName, Integer.parseInt(intRow), strActualRegNumber);
					setTestData("RegDate", shtName, Integer.parseInt(intRow), strActualDate);
					setTestData("RegTime", shtName, Integer.parseInt(intRow), strActualTime);
				}
			}
			setTestData("DocumentType", shtName, Integer.parseInt(intRow), strActualDocType);
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				VerifyPage_RegistrationConfirmation = false;
			} else {
				VerifyPage_RegistrationConfirmation = true;
			}
			return VerifyPage_RegistrationConfirmation;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Verify_Auto_RegNumber(String strAutoNumber) {
		boolean Verify_Auto_RegNumber = false;
		try {
			int strRegNumber_Reserved = 0;
			setTestData("RegNumber_Auto", "NewSubmission", 1, strAutoNumber);
			String strRegNumber = null;
			if (!strRegNumber.isEmpty()) {
				if (Integer.parseInt(strAutoNumber) < strRegNumber_Reserved) {
					logSteps.execution_log("Verification of <Registration Number> - UnSuccessful. Actual Value: " + strAutoNumber + ", Expected Value: should be after number" + strRegNumber_Reserved);
					Verify_Auto_RegNumber = false;
					return false;
				}
				logSteps.execution_log("<Auto Generated Number>: " + strAutoNumber + ", <Reserved Number>:" + strRegNumber_Reserved + ". Verification of <Registration Number> - Successful");
				Verify_Auto_RegNumber = true;
			}
			Verify_Auto_RegNumber = true;
			return Verify_Auto_RegNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_CompleteRegistration_ePlans(String shtName, String intRow, String strDocType) {
		try {
			String strStepName = null;
			strStepName = "VerifyPage_CompleteRegistration_ePlans";
			boolean VerifyPage_CompleteRegistration_ePlans = false;
			String strRefPlanConfirmationMsg = null;
			strRefPlanConfirmationMsg = certifyConfirmationPage.RefPlanConfirmationMsg_WebElement.getText().trim();
			if (strRefPlanConfirmationMsg.isEmpty()) {
				logSteps.execution_log("No confirmation message <Reference Plan deposited ...> is retrieved - UnSuccessful");
				return false;
			}
			String strActualPlanNumber = null;
			strActualPlanNumber = certifyConfirmationPage.PlanNumber_Link.getText().trim();
			String[] arrRefPlanMsg = null;
			String strPartMsg = null;
			String[] arrPartMsg = null;
			String strActualDate = null;
			String strActualTime = null;
			String strActualFees = null;
			arrRefPlanMsg = (strRefPlanConfirmationMsg).split("on");
			strPartMsg = arrRefPlanMsg[1].trim();
			arrPartMsg = (strPartMsg).split("at");
			strActualDate = arrPartMsg[0].trim();
			strPartMsg = arrPartMsg[1].trim();
			arrPartMsg = (strPartMsg).split(", fees");
			strActualTime = arrPartMsg[0].trim();
			strActualFees = arrPartMsg[1].trim();
			String strExpectedRegNum = null;
			strExpectedRegNum = RetrieveExpectedValue("RegNumber", shtName, Integer.parseInt(intRow));
			if (!strExpectedRegNum.isEmpty() && !(strExpectedRegNum.toUpperCase() == "!RANDOM!")) {
				CheckExpectedValue(strActualPlanNumber, strExpectedRegNum.toUpperCase());
			} else {
				if (!(strExpectedRegNum.toUpperCase() == "!RANDOM!")) {
					setTestData("RegNumber", shtName, Integer.parseInt(intRow), strActualPlanNumber);
					setTestData("RegDate", shtName, Integer.parseInt(intRow), strActualDate);
					setTestData("RegTime", shtName, Integer.parseInt(intRow), strActualTime);
				}
			}
			setTestData("DocumentType", shtName, Integer.parseInt(intRow), strDocType);
			if (!certifyConfirmationPage.NextInMyQueue_WebButton.isPresent()) {
				logSteps.execution_log("<Next In Queue> button Not exist - UnSuccessful");
				return false;
			}
			certifyConfirmationPage.PlanNumber_Link.click();
			String strRegNumber = null;
			String strActualDocType = null;

			strRegNumber = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 1, 2).trim();
			strActualDocType = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 3, 2).trim();
			if (!(strComp(strRegNumber, strActualPlanNumber) == 0)) {
				return false;
			}
			if (!(strComp(strActualDocType, strDocType) == 0)) {
				return false;
			}
			boolean intRet = false;
			intRet = certifySteps.Certify_DocumentViewPopup_Close();
			if (intRet == false) {
				return false;
			}
			VerifyPage_CompleteRegistration_ePlans = true;
			return VerifyPage_CompleteRegistration_ePlans;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FeesTaxes_EnterData(String shtName, String intRow) {
		boolean FeesTaxes_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "FeesTaxes_EnterData";
			String strDocumentIndex = null;
			String strRegDate = null;
			String strRegTime = null;
			strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, Integer.parseInt(intRow));
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			strRegDate = GetValueIfValid("RegDate", shtName, Integer.parseInt(intRow));
			strRegTime = GetValueIfValid("RegTime", shtName, Integer.parseInt(intRow));
			String strRandomDateFrom = null;
			strRandomDateFrom = GetValueIfValid("RandomDateFrom", shtName, Integer.parseInt(intRow));
			String strPaymentMethod = null;
			String strAccountNumber = null;
			String strCashDrawer = null;
			strPaymentMethod = GetValueIfValid("PaymentMethod", shtName, Integer.parseInt(intRow));
			strAccountNumber = GetValueIfValid("AccountNumber", shtName, Integer.parseInt(intRow));
			strCashDrawer = GetValueIfValid("CashDrawer", shtName, Integer.parseInt(intRow));
			if (strDocumentIndex.isEmpty() || strDocumentIndex.equals("IGNORE_VALUE")) {
				strDocumentIndex = "1";
			}
			int intDocumentIndex = 0;

			intDocumentIndex = Math.round(Integer.parseInt(strDocumentIndex)) - 1;

			String oPage = null;
			// If UCase(strRegNumber) ="!GENERATE!" Then
			if (strRegNumber.toUpperCase().equals("!GENERATE!")) {
				strRegNumber = Generate_Unique_RegNumber();
			}
			switch (strRegNumber.toUpperCase()) {
			case "!GENERATE!":
				strRegNumber = Generate_Unique_RegNumber();
				setTestData("RegNumber", shtName, Integer.parseInt(intRow), strRegNumber);
				break;
			case "!RANDOM!":
				// strRegNumber = Generate_Random_RegNumber();
				break;
			}
			if (!strRegNumber.isEmpty()) {
				feesTaxesPage.find(By.id("folder.tax[" + intDocumentIndex + "]")).sendKeys(strRegNumber);
				switch (strRegDate.toUpperCase()) {
				case "!GENERATE!":
					strRegDate = Generate_Registration_Date();
					setTestData("RegDate", shtName, Integer.parseInt(intRow), strRegDate);
					break;
				case "!RANDOM!":
					// strRegDate = Generate_Random_Date(strRandomDateFrom);
					break;
				}
				switch (strRegTime.toUpperCase()) {
				case "!GENERATE!":
					strRegTime = Generate_Registration_Time();
					setTestData("RegTime", shtName, Integer.parseInt(intRow), strRegDate);
					break;
				case "!RANDOM!":
					// strRegTime = Generate_Random_Time(strRandomDateFrom);
					break;
				}
				feesTaxesPage.find(By.name("feeAndTaxInputVOs[" + intDocumentIndex + "].registrationDate")).sendKeys(strRegDate);
				feesTaxesPage.find(By.id("feesAndTaxRecords[" + intDocumentIndex + "].registrationTime")).sendKeys(strRegTime);

			}
			if (!strPaymentMethod.isEmpty() && !(strPaymentMethod == "Cash or Cheque")) {
				feesTaxesPage.PaymentMethod_WebList.selectByVisibleText(strPaymentMethod);
				feesTaxesPage.AccountNumber_WebEdit.sendKeys(strAccountNumber);
			}
			feesTaxesPage.CashDrawer_WebEdit.sendKeys(strCashDrawer);
			oPage = null;
			FeesTaxes_EnterData = true;
			return FeesTaxes_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Complete Registration button on the Fees and Taxes page")
	public boolean user_click_on_completeRegistration_on_feetaxespage() {
		boolean FeesTaxes_CompleteRegistration = false;
		try {
			feesTaxesPage.CompleteRegistration_WebButton.click();
			FeesTaxes_CompleteRegistration = true;
			return FeesTaxes_CompleteRegistration;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Complete Registration button on the Fees and Taxespage $shtName and $intRow")
	public boolean user_click_on_completeRegistration_on_feetaxespage(String shtName, String intRow) {
		try {
			boolean FeesTaxes_CompleteRegistration = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = FeesTaxes_EnterData(shtName, intRow);
				if (intRet == false) {
					logSteps.execution_log("Enter data to <Fees and Taxes> page - UnSuccessful");
					return false;
				}
			}
			feesTaxesPage.CompleteRegistration_WebButton.click();
			WaitUtil.waitMSeconds(3000);
			strRegNumber = retrieveRegNumber();
			String strBulkFunction = null;
			strBulkFunction = "Bulk Document Registration";
			// intRet = FeesTaxes_CompleteRegistration_Batch(strBulkFunction);
			FeesTaxes_CompleteRegistration = intRet;
			VerifyApplicationError();
			return FeesTaxes_CompleteRegistration;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Submit button with data on PreSubmission page $shtName and $intRow")
	public boolean user_click_submit_on_register_presubmission_page(String shtName, String intRow) {
		boolean Register_PreSubmission_Submit = false;
		try {
			String strStepName = "Register_PreSubmission_Submit";
			int intRowIndex = 0;
			if (intRow.isEmpty()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "The data input can NOT be empty - UnSuccessful");
				// AddInfo("The data input can NOT be empty - UnSuccessful");

				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			// Define and retrieve the Document Type and Error Message for later page verification
			String strExpectedDocumentType = GetValueIfValid("DocumentType", shtName, intRowIndex).toUpperCase();
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRowIndex).trim();
			// Check if the page is ready to enter any data. If not, click cancel and navigate to the Register Documents page
			// 07-24-2012/Jenny/Comment the following codes, has to be on PreSubmission before using this keyword
			// If Browser("ELRS").Page("PreSubmission").WebTable("ErrorMsg").Exist(1) Then
			// strErrorMsgs = Trim(Browser("ELRS").Page("PreSubmission").WebTable("ErrorMsg").GetCellData(1,1))
			// If strErrorMsgs <>"" Then
			// If Browser("ELRS").Page("Main").WebButton("Cancel").Exist(1) Then
			// Browser("ELRS").Page("Main").WebButton("Cancel").Click
			// ELRS_Popup_Cancel("OK")
			// ELRS_Navigate_To_Menu("Register")
			// Else
			// Reporter.ReportEvent micFail, "The PreSubmission page is not ready to accept any new entry", "Please cancel the previous action"
			// AddInfo "The PreSubmission page is not ready to accept any new entry. Please cancel the previous action"
			// Register_PreSubmission_Submit = False
			// Exit Function
			// End If
			// End If
			// End If
			// Call function Register_PreSubmission_EnterData to enter data first
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Enter data to <PreSubmission> - UnSuccessful");
				// AddInfo("Enter data to <PreSubmission> - UnSuccessful");
				Register_PreSubmission_Submit = false;
				return false;
			}
			// Click the Submit button
			// environmentlib.Value("Test", "bTriggered", false);
			preSubmissionPage.Submit_WebButton.click();
			// Browser("ELRS").Sync
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, strStepName, "Click <Submit> button - UnSuccessful");
			// AddInfo("Click <Submit> button - UnSuccessful");
			// Register_PreSubmission_Submit = false;
			// return 0;
			// }
			// AddInfo("<Submit> button is clicked");
			// 06-29-2012/Jenny/Verify the fetal application error
			VerifyApplicationError();
			String strErrorMsgs = null;
			// Verify the error message
			if (preSubmissionPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.isEmpty()) {
					Register_PreSubmission_Submit = false;
					VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					return false;
				}
			}
			// Verify the page
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				// Report fail directly
				Register_PreSubmission_Submit = false;
				// Verify error message
				if (preSubmissionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					} else {
						// Reporter.reportEvent(Status.Failed, strStepName, "Page <Document Detail> Not displayed - UnSuccessful");
						// AddInfo("Page <Document Detail> Not displayed - UnSuccessful");
					}
				} else {
					// Reporter.reportEvent(Status.Failed, strStepName, "Unknown page is returned - UnSuccessful");
					// AddInfo("Unknown page is returned - UnSuccessful");
				}
				return false;
			}
			String strHeadingText = documentDetailPage.Heading_WebTable.getText();
			// 10-30-2012/Jenny/Update the document type for Application (General) (No PIN Land Titles)
			if (strExpectedDocumentType.equals("APPLICATION (GENERAL) (NO PIN LAND TITLES)")) {
				strExpectedDocumentType = "APPLICATION (GENERAL)";
			}
			if (!strHeadingText.contains(strExpectedDocumentType)) {
				// Reporter.reportEvent(Status.Failed, strStepName, "The <Document Type:> " + strExpectedDocumentType + "Not displayed on the <Document Detail> page - UnSuccessful");
				// AddInfo("The <Document Type:> " + strExpectedDocumentType + "Not displayed on the <Document Detail> page - UnSuccessful");
				Register_PreSubmission_Submit = false;
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "The <Document Detail> page with <Document Type:> " + strExpectedDocumentType + "displayed - Successful");
			// AddInfo("The <Document Detail> page with <Document Type:> " + strExpectedDocumentType + "displayed - Successful");
			Register_PreSubmission_Submit = true;
			return Register_PreSubmission_Submit;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Complete Registration button on the Fees and Taxes $shtName and $intRow")
	public boolean user_click_on_completeRegistration_on_feetaxes(String shtName, String intRow) {
		try {
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = FeesTaxes_EnterData(shtName, intRow);
				if (intRet == false) {
					logSteps.execution_log("Enter data to <Fees and Taxes> page - UnSuccessful");
					return false;
				}
			}
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			feesTaxesPage.CompleteRegistration_WebButton.click();
			String strBulkFunction = null;
			strBulkFunction = "Bulk Document Registration";
			// intRet = FeesTaxes_CompleteRegistration_Batch(strBulkFunction);
			boolean FeesTaxes_CompleteRegistration = intRet;
			VerifyApplicationError();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@When("user click on Complete Recording button on the Fees and Taxes page $shtName and $intRow")
	public boolean FeesTaxes_CompleteRecording(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "FeesTaxes_CompleteRecording";
			boolean FeesTaxes_CompleteRecording = false;
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = FeesTaxes_EnterData(shtName, intRow);
				feesTaxesPage.Complete_WebButton.click();
				if (strComp(strMode.trim(), "Batch") == 0) {
					String strFunction = null;
					strFunction = "Historical Document";
					intRet = FeesTaxes_CompleteRecording_Batch(strFunction);
					FeesTaxes_CompleteRecording = intRet;
					return false;
				}
				if (!recordHistoricalConfirmationPage.RecordingHistoricalResults_WebElement.isPresent()) {
					logSteps.execution_log("<Recording Historical Results> confirmation page Not displayed - UnSuccessful");
					return false;
				}
				// intRet = RecordHistorical_VerifyExist_RegNumberLink();
				FeesTaxes_CompleteRecording = true;
				return FeesTaxes_CompleteRecording;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@When("user click on Complete Recording button on the Fees and Taxes page")
	public boolean FeesTaxes_CompleteRecording() {
		try {
			String strStepName = null;
			strStepName = "FeesTaxes_CompleteRecording";
			boolean FeesTaxes_CompleteRecording = false;
			String strMode = null;
			// strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			strMode = mainPage.Mode_WebElement.getText();
			boolean intRet = false;
			feesTaxesPage.Complete_WebButton.click();
			if (strComp(strMode.trim(), "Batch") == 0) {
				String strFunction = null;
				strFunction = "Historical Document";
				intRet = FeesTaxes_CompleteRecording_Batch(strFunction);
				FeesTaxes_CompleteRecording = intRet;
				return false;
			}
			if (!recordHistoricalConfirmationPage.RecordingHistoricalResults_WebElement.isPresent()) {
				logSteps.execution_log("<Recording Historical Results> confirmation page Not displayed - UnSuccessful");
				return false;
			}
			// intRet = RecordHistorical_VerifyExist_RegNumberLink();
			FeesTaxes_CompleteRecording = true;
			return FeesTaxes_CompleteRecording;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FeesTaxes_CompleteRecording_Batch(String strFunction) {
		boolean Documents_Batch_Presub = false;
		try {
			documentsPage.OK_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			documentsPage.OK_WebButton.click();
			boolean intRet = false;
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				Documents_Batch_Presub = false;
				return false;
			}
			intRet = elrsCommonSteps.user_navigates_to("ViewBatchQ");
			WaitUtil.waitMSeconds(2000);
			mainPage.getDriver().findElement(By.xpath("//input[@value='Refresh']")).click();
			WaitUtil.waitMSeconds(2000);
			mainPage.getDriver().findElement(By.xpath("//td[contains(text(),'" + strRegNumber + "')]/..//input[@name='btn'][1]")).click();
			WaitUtil.waitMSeconds(2000);
			return Documents_Batch_Presub;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verifies uiobject exists $shtName and $intRow")
	public boolean verifyUIObjectExist(String shtName, String intRow) {
		try {
			WebElement deletionConfirmation = mainPage.getDriver().findElement(By.xpath("//td[@class='rptcolhdr']"));
			String confirmation = deletionConfirmation.getText();
			System.out.println(confirmation);
			if (deletionConfirmation.isDisplayed()) {
				logSteps.execution_log("DeletionConfirmation is displayed");
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Then("user verify uiobject exist $uiobject and $shtName and $intRow")
	public boolean verifyUIObjectExist(String uiobject, String shtName, String intRow) {
		try {
			WebElement deletionConfirmation = mainPage.getDriver().findElement(By.xpath("//*[contains(text()," + uiobject + ")]"));
			String confirmation = deletionConfirmation.getText();
			System.out.println(confirmation);
			if (deletionConfirmation.isDisplayed()) {
				// logSteps.execution_log("DeletionConfirmation is displayed");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Add Document button on the PreSubmission page $shtName and $intRow")
	public boolean Register_PreSubmissionAddDoc(String shtName, String intRow) {
		boolean Register_PreSubmissionRemove = false;
		try {
			String strStepName = "Register_PreSubmission_Cancel";
			int intRowIndex = 0;
			if (intRow.isEmpty()) {

				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				Register_PreSubmissionRemove = false;
				return false;
			}
			Register_PreSubmissionRemove = true;
			return Register_PreSubmissionRemove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Change Type button on the PreSubmission page $shtName and $intRow")
	public boolean Register_PreSubmission_Change(String shtName, String intRow) {
		boolean Register_PreSubmission_Add = false;
		try {
			int intRowIndex = 0;
			if (intRow.isEmpty()) {

				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				Register_PreSubmission_Add = false;
				return false;
			}
			Register_PreSubmission_Add = true;
			return Register_PreSubmission_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Cancel button on Presubmission page")
	public void Register_PreSubmission_Cancel() {
		preSubmissionPage.Cancel_WebButton.click();
		Alert a = mainPage.getDriver().switchTo().alert();
		a.accept();
	}

	@When("user clicks on Add Document button on the PreSubmission page $shtName and $intRow")
	public boolean Register_PreSubmissionAdd(String shtName, String intRow) {
		boolean Register_PreSubmissionRemove = false;
		try {
			String strStepName = "Register_PreSubmission_Cancel";
			int intRowIndex = 0;
			if (intRow.isEmpty()) {

				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			// String strExpectedDocumentType = GetValueIfValid("DocumentType", shtName, intRowIndex).toUpperCase();
			// String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRowIndex).trim();
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterDataForDropdown(shtName, intRow);
			if (intRet == false) {
				Register_PreSubmissionRemove = false;
				return false;
			}

			Register_PreSubmissionRemove = true;
			return Register_PreSubmissionRemove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Change Type button on the PreSubmission page $shtName and $intRow")
	public boolean Register_PreSubmission_Changetype(String shtName, String intRow) {
		boolean Register_PreSubmission_Changetype = false;
		try {
			int intRowIndex = 0;
			if (intRow.isEmpty()) {

				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = intRow.split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterDataForDropdown(shtName, intRow);
			if (intRet == false) {
				Register_PreSubmission_Changetype = false;
				return false;
			}

			Register_PreSubmission_Changetype = true;
			return Register_PreSubmission_Changetype;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Register_PreSubmission_EnterDataForDropdown(String shtName, String intRow) {
		boolean Register_PreSubmission_EnterData = true;
		try {
			String strStepName = "Register_PreSubmission_EnterData";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentType = GetValueIfValid("DocumentType", shtName, iLoop);
				String strDocumentAction = GetValueIfValid("DocumentAction", shtName, iLoop);
				String strFrench = GetValueIfValid("French", shtName, iLoop);
				String strRelatedDocument = GetValueIfValid("RelatedDocument", shtName, iLoop);
				String strAlternateDocument = GetValueIfValid("AlternateDocument", shtName, iLoop);
				String strDocumentNotAutomated = GetValueIfValid("DocumentNotAutomated", shtName, iLoop);
				String strMultipleRelatedDocuments = GetValueIfValid("MultipleRelatedDocuments", shtName, iLoop);
				String strTCPL = GetValueIfValid("TCPL", shtName, iLoop);
				String strHWY = GetValueIfValid("HWY", shtName, iLoop);
				String strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				String strTargetBlock = GetValueIfValid("TargetBlock", shtName, iLoop);
				String strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, iLoop);
				String strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, iLoop);
				String strEasementPINIndex = GetValueIfValid("EasementPINIndex", shtName, iLoop);
				String strEasementBlock = GetValueIfValid("EasementBlock", shtName, iLoop);
				String strEasementPINFrom = GetValueIfValid("EasementPINFrom", shtName, iLoop);
				String strEasementPINTo = GetValueIfValid("EasementPINTo", shtName, iLoop);
				String strAddPINAction = GetValueIfValid("AddPINAction", shtName, iLoop);
				String strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, iLoop);
				String strDocument = GetValueIfValid("Document", shtName, iLoop);
				setCheckBoxValueWithJS(preSubmissionPage.French_WebCheckBox, strFrench);
				WaitUtil.waitMSeconds(2000);

				preSubmissionPage.DocumentType_WebList.selectByVisibleText(strDocumentType.toUpperCase());

				switch (strDocumentAction.toUpperCase()) {
				case "ADD":
					preSubmissionPage.AddDocument_WebButton.click();
					break;
				case "CHANGE":
					preSubmissionPage.ChangeType_WebButton.click();
					break;
				}
				if (!strRelatedDocument.isEmpty()) {
					preSubmissionPage.RelatedDocument_WebEdit.sendKeys(strRelatedDocument);
				}
				if (!strAlternateDocument.isEmpty()) {
					preSubmissionPage.AlternateDocument_WebEdit.sendKeys(strAlternateDocument);
				}
				setCheckBoxValue(preSubmissionPage.DocumentNotAutomated_WebCheckBox, strDocumentNotAutomated);
				setCheckBoxValue(preSubmissionPage.MultipleRelatedDocuments_WebCheckBox, strMultipleRelatedDocuments);
				setCheckBoxValue(preSubmissionPage.TCPL_WebCheckBox, strTCPL);
				setCheckBoxValue(preSubmissionPage.HWY_WebCheckBox, strHWY);
				if (strAddPINAction.toUpperCase().equals("RETRIEVEPINS")) {
					if (!strRegistrationNum.isEmpty()) {
						preSubmissionPage.RegistrationNumber_WebEdit.sendKeys(strRegistrationNum);
					} else {
						if (!strDocument.isEmpty()) {
							preSubmissionPage.SourceDocumentList_WebList.selectByVisibleText(strDocument.toUpperCase());
						}
					}
					preSubmissionPage.RetrievePINs_WebButton.click();
				}
				if (NumberUtils.isNumber(strTargetPINIndex)) {
					int intTargetPINIndex = Math.round(Integer.parseInt(strTargetPINIndex)) - 1;
					WaitUtil.waitMSeconds(2000);
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].block")).sendKeys(strTargetBlock);
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].property")).sendKeys(strTargetPINFrom);
					preSubmissionPage.find(By.name("currentFolderItem.pins[" + intTargetPINIndex + "].range")).sendKeys(strTargetPINTo);
				}
				if (NumberUtils.isNumber(strEasementPINIndex)) {
					int intEasementPINIndex = Integer.parseInt(strEasementPINIndex) - 1;
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].block")).sendKeys(strEasementBlock);
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].property")).sendKeys(strEasementPINFrom);
					preSubmissionPage.find(By.name("currentFolderItem.easementPins[" + intEasementPINIndex + "].range")).sendKeys(strEasementPINTo);
				}

			}
			return Register_PreSubmission_EnterData;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Add Document button on the PreSubmission page with $PRESUBMISSIONSHEETNAME1 and $PRESUBMISSIONROWINDEX2")
	public boolean Register_PreSubmission_AddDocument(String shtName, String intRow) {
		boolean Register_PreSubmission_AddDocument = false;
		try {
			String strStepName = null;
			strStepName = "Register_PreSubmission_AddDocument";
			int intRowIndex = 0;
			if (intRow.isEmpty()) {
				Register_PreSubmission_AddDocument = false;
				return false;
			} else {

				if (intRow.contains("-")) {
					String[] arrRows = null;
					arrRows = (intRow).split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Integer.parseInt(intRow);
				}
			}
			String strDocumentType = null;
			String strDocumentIndex = null;
			strDocumentType = GetValueIfValid("DocumentType", shtName, intRowIndex);
			strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, intRowIndex);
			String oPage = null;
			int intPreCount = 0;
			List<WebElement> we = mainPage.getDriver().findElements(By.xpath("//SELECT[@id='doclist']"));
			intPreCount = we.size();
			boolean intRet = false;
			intRet = Register_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				Register_PreSubmission_AddDocument = false;
				return false;
			}
			int intNowCount = 0;
			int intItemCount = 0;
			List<WebElement> we1 = mainPage.getDriver().findElements(By.xpath("//SELECT[@id='doclist']"));
			intNowCount = we1.size();
			intItemCount = intNowCount - intPreCount;

			if (!(intItemCount == 1)) {
				Register_PreSubmission_AddDocument = false;
				return false;
			}
			String strAllItems = null;
			String strExpectedItem = null;
			strAllItems = preSubmissionPage.DocumentFolder_WebList.getAttribute("all items");
			strExpectedItem = strDocumentType + "_" + strDocumentIndex;
			if (InStr(strAllItems, strExpectedItem.toUpperCase()) > 0) {
				Register_PreSubmission_AddDocument = true;
			} else {
				Register_PreSubmission_AddDocument = false;
			}
			return Register_PreSubmission_AddDocument;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Add PIN button on the PreSubmission page")
	public boolean Register_PreSubmission_AddPIN() {
		boolean Register_PreSubmission_AddPIN = false;
		try {
			preSubmissionPage.AddPIN_WebButton.click();
			Register_PreSubmission_AddPIN = true;
			return Register_PreSubmission_AddPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Add PIN button on the PreSubmission page with $PRESUBMISSIONSHEETNAME and $PRESUBMISSIONROWINDEX2")
	public boolean Register_PreSubmission_AddPIN(String shtName, String intRow) {
		boolean Register_PreSubmission_AddPIN = false;
		try {
			String strStepName = null;
			strStepName = "Register_PreSubmission_AddPIN";
			Object oPage = null;
			int intLastPINIndex = 0;
			if (preSubmissionPage.find(By.id("pin3block")).isPresent()) {
				intLastPINIndex = 4;
			} else if (preSubmissionPage.find(By.id("pin7block")).isPresent()) {
				intLastPINIndex = 8;
			} else if (preSubmissionPage.find(By.id("pin11block")).isPresent()) {
				intLastPINIndex = 12;
			} else {
				intLastPINIndex = 16;
			}
			// environmentlib.setProperty("bTriggered", "false");
			preSubmissionPage.AddPIN_WebButton.click();
			oPage = null;
			/*
			 * if (environmentlib.getProperty("bTriggered").equals("true")) { // Reporter.reportEvent(Status.Failed,strStepName,"Click <Add PIN> button - UnSuccessful"); // utility.AddInfo("Click <Add PIN> button - UnSuccessful"); Register_PreSubmission_AddPIN = false; return false; }
			 */
			boolean intRet = false;
			intRet = VerifyPage_PreSubmission_AddPIN(intLastPINIndex);
			if (intRet == false) {
				Register_PreSubmission_AddPIN = false;
				return false;
			}
			// utility.AddInfo("Click <Add PIN> button - Successful");
			// Enter PINs if input is not empty
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Register_PreSubmission_AddPIN_EnterData(shtName, intRow);
				if (intRet == false) {
					// Reporter.reportEvent(Status.Failed,strStepName,"Enter data to <Add PIN> - UnSuccessful");
					// utility.AddInfo("Enter data to <Add PIN> - UnSuccessful");
					Register_PreSubmission_AddPIN = false;
					return false;
				}
			}
			// Reporter.reportEvent(Status.Passed,strStepName,"Successful");
			// utility.AddInfo(strStepName+" - Successful");
			Register_PreSubmission_AddPIN = true;
			return Register_PreSubmission_AddPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_PreSubmission_AddPIN(int intLastPINIndex) {
		boolean VerifyPage_PreSubmission_AddPIN = false;
		try {
			String strStepName = null;
			strStepName = "VerifyPage_PreSubmission_AddPIN";
			// String intIndex = null;
			int intStart = 0;
			int intEnd = 0;
			intStart = intLastPINIndex + 1;

			intEnd = intLastPINIndex + 4;

			for (int intIndex = intStart; intIndex <= intEnd; intIndex++) {
				if (!preSubmissionPage.find(By.id("removePIN" + (intIndex - 1))).isVisible()) {
					// Reporter.reportEvent(Status.Failed, strStepName, "Checkbox Not displayed on row " + intIndex + " after Add PIN button is clicked");
					// utility.AddInfo("Checkbox Not displayed on row " + intIndex + " after Add PIN button is clicked");
					VerifyPage_PreSubmission_AddPIN = false;
					return false;
				}

				/*
				 * if (!preSubmissionPage.htmlidpinintIndex1block_webedit.Exist(1)) { // Reporter.reportEvent(Status.Failed, strStepName, "PIN Block field Not displayed on row " + intIndex + " after Add PIN button is clicked"); // utility.AddInfo("PIN Block field Not displayed on row " + intIndex
				 * +" after Add PIN button is clicked"); VerifyPage_PreSubmission_AddPIN = false; return false; }
				 */

				/*
				 * if (!preSubmissionPage.htmlidpinintIndex1block_webedit.getText().isEmpty()) { // Reporter.reportEvent(Status.Failed, strStepName, "PIN Block field Not blank on row " + intIndex + " after Add PIN button is clicked"); // utility.AddInfo("PIN Block field Not blank on row " + intIndex +
				 * " after Add PIN button is clicked"); VerifyPage_PreSubmission_AddPIN = false; return false; }
				 */
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Successful");
			// utility.AddInfo("Verification of the page after Add PIN button clicked - Successful");
			VerifyPage_PreSubmission_AddPIN = true;
			return VerifyPage_PreSubmission_AddPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Register_PreSubmission_AddPIN_EnterData(String shtName, String intRow) {
		// Object Register_PreSubmission_AddPIN_EnterData = null;
		try {
			String strStepName = null;
			strStepName = "Register_PreSubmission_AddPIN_EnterData";
			boolean Register_PreSubmission_AddPIN_EnterData = true;
			// Check if there are multiple row numbers there
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String oPage = null;
			String strTargetPINIndex = null;
			String strTargetBlock = null;
			String strTargetPINFrom = null;
			String strTargetPINTo = null;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				strTargetBlock = GetValueIfValid("TargetBlock", shtName, iLoop);
				strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, iLoop);
				strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, iLoop);
				environmentlib.setProperty("bTriggered", "false");
				if (isNumeric(strTargetPINIndex)) {
					int intTargetPINIndex = 0;
					intTargetPINIndex = Math.round(Integer.parseInt(strTargetPINIndex)) - 1;
					preSubmissionPage.find(By.name("currentFolderItem/.pins/[" + intTargetPINIndex + "/]/.block")).sendKeys(strTargetBlock);
					preSubmissionPage.find(By.name("currentFolderItem/.pins/[" + intTargetPINIndex + "/]/.property")).sendKeys(strTargetPINFrom);
					preSubmissionPage.find(By.name("currentFolderItem/.pins/[" + intTargetPINIndex + "/]/.range")).sendKeys(strTargetPINTo);
				}
			}
			oPage = null;
			return Register_PreSubmission_AddPIN_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Remove PIN button on the PreSubmission page with $PRESUBMISSIONSHEETNAME and $PRESUBMISSIONROWINDEX2")
	public boolean Register_PreSubmission_RemovePIN(String shtName, String intRow) {
		boolean Register_PreSubmission_RemovePIN = false;
		try {
			String strStepName = null;
			int intToBeRemoved = 0;
			strStepName = "Register_PreSubmission_RemovePIN";
			String oPage = null;
			String intStatus = null;
			int intRowIndex = 0;
			intStatus = preSubmissionPage.PINNext_WebButton.getAttribute("disabled");
			if (intStatus.equals("0")) {
				preSubmissionPage.PINNext_WebButton.click();
			}
			// Only handle at most 2 pages as of 06-13-2012
			int intLastPINIndex = 0;
			intLastPINIndex = GetLastActivePINIndex();
			if (intRow.isEmpty()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The data input can NOT be empty");
				// utility.AddInfo("The data input can NOT be empty");
				Register_PreSubmission_RemovePIN = false;
				return false;
			} else {

				// int intToBeRemoved = 0;
				if (intRow.contains("-")) {
					String[] arrRows = null;
					arrRows = (intRow).split("-");
					intRowIndex = Math.round(Integer.parseInt(arrRows[0]));
					intToBeRemoved = Math.round(Integer.parseInt(arrRows[1])) - intRowIndex + 1;
				} else {
					intRowIndex = Math.round(Integer.parseInt(intRow));
					intToBeRemoved = 1;
				}
			}
			// Define and retrieve the Error Message for later page verification
			String strExpectedMsgs = null;
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRowIndex).trim();
			String strRemovePIN = null;
			boolean intRet = false;
			strRemovePIN = GetValueIfValid("RemovePIN", shtName, intRowIndex);
			if (strRemovePIN.toUpperCase() == "ON" || strRemovePIN.toUpperCase() == "YES" || strRemovePIN.toUpperCase() == "Y") {
				intRet = Register_PreSubmission_RemovePIN_SelectPIN(shtName, intRow);
				if (intRet == false) {
					Register_PreSubmission_RemovePIN = false;
					return false;
				}
			}
			preSubmissionPage.RemovePIN_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Click <Remove Selected> button - UnSuccessful");
				// utility.AddInfo("Click <Remove Selected> button - UnSuccessful");
				Register_PreSubmission_RemovePIN = false;
			}
			// utility.AddInfo("<Remove Selected> button is clicked");
			// Verify the page
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(preSubmissionPage.ErrorMsg_WebTable, 1, 1).trim();
			// Verify the error message if error message is displayed on the page
			if (strErrorMsgs != "") {
				Register_PreSubmission_RemovePIN = false;
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (!intRet == true) {
					Register_PreSubmission_RemovePIN = false;
				}
				return false;
			}
			// Verify the PIN counts after some PINs removed
			int intCurLast = 0;
			String strLastValue = null;
			String strNextLast = null;
			intCurLast = intLastPINIndex - intToBeRemoved;
			// In case of all pins are removed
			if (intCurLast == 0) {
				// strLastValue=.getWebElement("value");
				strLastValue = preSubmissionPage.find(By.id("pin0block")).getAttribute("value");
				if (strLastValue != "") {
					// Reporter.reportEvent(Status.Failed,strStepName,"Row 1 is NOT empty after all rows of pins are removed - UnSuccessful");
					// utility.AddInfo("Row 1 is NOT empty after all rows of pins are removed - UnSuccessful");
					Register_PreSubmission_RemovePIN = false;
				} else {
					// Reporter.reportEvent(Status.Passed,strStepName,"All rows are removed. All PIN fields are blank - Successful");
					// utility.AddInfo("All rows are removed. All PIN fields are blank - Successful");
					Register_PreSubmission_RemovePIN = true;
				}
				return false;
			}
			// strLastValue=.getWebElement("value");
			strLastValue = preSubmissionPage.find(By.id("pin" + (intCurLast - 1) + "block")).getAttribute("value");
			// strNextLast=.getWebElement("value");
			strNextLast = preSubmissionPage.find(By.id("pin" + intCurLast + "block")).getAttribute("value");
			if (strLastValue != "") {
				if (strNextLast.isEmpty()) {
					// Reporter.reportEvent(Status.Passed,strStepName,"<"+intToBeRemoved+"> PIN(s) Removed - Successful");
					// utility.AddInfo("<"+intToBeRemoved+"> PIN(s) Removed - Successful");
					Register_PreSubmission_RemovePIN = true;
				} else {
					// Reporter.reportEvent(Status.Failed,strStepName,"Row "+(intCurLast+1)+"Not empty after <"+intToBeRemoved+"> PIN(s) Removed from "+intLastPINIndex+"PINs list");
					// utility.AddInfo("Row "+(intCurLast+1)+"Not empty after <"+intToBeRemoved+"> PIN(s) Removed from "+intLastPINIndex+"PINs list");
					Register_PreSubmission_RemovePIN = false;
				}
			} else {
				// Reporter.reportEvent(Status.Failed,strStepName,"Row "+intCurLast+" is Empty after <"+intToBeRemoved+"> PIN(s) Removed from "+intLastPINIndex+" PINs list");
				// utility.AddInfo("Row "+intCurLast+" is empty after <"+intToBeRemoved+"> PIN(s) Removed from "+intLastPINIndex+" PINs list");
				Register_PreSubmission_RemovePIN = false;
			}
			oPage = null;
			return Register_PreSubmission_RemovePIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Register_PreSubmission_RemovePIN_SelectPIN(String shtName, String intRow) {
		// Object Register_PreSubmission_RemovePIN_SelectPIN = null;
		try {
			String strStepName = null;
			strStepName = "Register_PreSubmission_RemovePIN_SelectPIN";
			boolean Register_PreSubmission_RemovePIN_SelectPIN = true;
			// Check if there are multiple row numbers there
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			int intPINsToBeRemoved = 0;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			intPINsToBeRemoved = intEnd - intStart + 1;
			String oPage = null;

			// Object iLoop = null;
			String strRemovePIN = null;
			String strTargetPINIndex = null;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// *datatableLib.getsheet(shtName).setcurrentRow((iLoop));
				// Fetch the valid data
				strRemovePIN = GetValueIfValid("RemovePIN", shtName, iLoop);
				strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				if (!isNumeric(strTargetPINIndex)) {
					// Reporter.reportEvent(Status.Failed, strStepName, "A number has to be assigned to TargetPINIndex in order to remove it");
					// utility.AddInfo("A number has to be assigned to TargetPINIndex in order to remove it");
					Register_PreSubmission_RemovePIN_SelectPIN = false;
					oPage = null;
					return false;
				}
				// Initialization
				environmentlib.setProperty("bTriggered", "false");
				// oPage.WebCheckBox("html id:=removePin" + (Math.round(Integer.parseInt(strTargetPINIndex)) - 1)).SetValue("ON");
				if (environmentlib.getProperty("bTriggered").equals("true")) {
					// Reporter.reportEvent(Status.Failed, strStepName, "Check the Checkbox on row " + strTargetPINIndex + " - UnSuccessful");
					// utility.AddInfo("Check the Checkbox on row " + strTargetPINIndex + " - UnSuccessful");
					Register_PreSubmission_RemovePIN_SelectPIN = false;
				}
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<" + intPINsToBeRemoved + "> PIN(s) Selected - Successful");
			// utility.AddInfo("<" + intPINsToBeRemoved + "> PIN(s) Selected - Successful");
			oPage = null;
			return Register_PreSubmission_RemovePIN_SelectPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify Error message of RemovePIN on PresubmissionPage with $PRESUBMISSIONSHEETNAME and $PRESUBMISSIONROWINDEX2")
	public boolean verify_ErrorMeggage_RemovePIN(String shtName, String intRow) {
		try {
			String errormsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String Actmsg = preSubmissionPage.ErrorMsg_WebTable.getText().trim();
			if (errormsg.equalsIgnoreCase(Actmsg)) {
				// logSteps.execution_log("Message is Successfully verified");
				System.out.println("pass");
				return true;
			}
		} catch (Exception e) {
			// logSteps.execution_log("Message is not verified Successfully");
			System.out.println("Fail");
			return false;
		}
		return false;
	}

	public int GetLastActivePINIndex() {
		int GetLastActivePINIndex = 0;
		try {
			String oPage = null;
			int intLastPINIndex = 0;
			String strLastPINValue = null;
			if (preSubmissionPage.find(By.id("pin3block")).isPresent()) {
				intLastPINIndex = 4;
				for (int iLoop = 1; iLoop <= 4; iLoop++) {
					strLastPINValue = preSubmissionPage.find(By.name("selectedPINsForRemoval")).getAttribute("value");
					if (strLastPINValue.isEmpty()) {
						intLastPINIndex = iLoop - 1;
						break;
					}
				}
			} else if (preSubmissionPage.find(By.id("pin7block")).isPresent()) {
				intLastPINIndex = 8;
				for (int iLoop = 5; iLoop <= 8; iLoop++) {
					strLastPINValue = preSubmissionPage.find(By.id("pin" + (iLoop - 1) + "block")).getAttribute("value");
					if (strLastPINValue.isEmpty()) {
						intLastPINIndex = iLoop - 1;
						break;
					}
				}
			} else {
				intLastPINIndex = 12;
				for (int iLoop = 9; iLoop <= 12; iLoop++) {
					strLastPINValue = preSubmissionPage.find(By.id("pin" + (iLoop - 1) + "block")).getAttribute("value");
					if (strLastPINValue.isEmpty()) {
						intLastPINIndex = iLoop - 1;
						break;
					}
				}
			}
			oPage = null;
			GetLastActivePINIndex = intLastPINIndex;
			return GetLastActivePINIndex;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	@When("user click on Return to Document Details button on Fees and Taxes page")
	public boolean FeesTaxes_ReturnToDocumentDetails() {
		boolean FeesTaxes_ReturnToDocumentDetails = false;
		try {
			String strStepName = null;
			strStepName = "FeesTaxes_ReturnToDocumentDetails";
			feesTaxesPage.ReturnToDetails_WebButton.click();
			// logSteps.execution_log("<Return to Document Details> button is clicked");
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				// logSteps.execution_log("Unknown page is returned - UnSuccessful");
				return false;
			}
			// logSteps.execution_log("<Document Detail> page displayed");
			FeesTaxes_ReturnToDocumentDetails = true;
			return FeesTaxes_ReturnToDocumentDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}