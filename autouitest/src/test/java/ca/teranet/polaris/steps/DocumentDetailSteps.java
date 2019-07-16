package ca.teranet.polaris.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CertifyConfirmationPage;
import ca.teranet.pages.polaris.CorrectionNoticesPage;
import ca.teranet.pages.polaris.DeferOrCorrectionPage;
import ca.teranet.pages.polaris.DocumentDataPage;
import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.DocumentViewPopupPage;
import ca.teranet.pages.polaris.FeesTaxesPage;
import ca.teranet.pages.polaris.HighwayPipelinePage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.ModifyHeaderPage;
import ca.teranet.pages.polaris.PINDetailsPage;
import ca.teranet.pages.polaris.PINListPage;
import ca.teranet.pages.polaris.PartiesPage;
import ca.teranet.pages.polaris.PropertyMaintenancePage;
import ca.teranet.pages.polaris.PropertyRemarksPage;
import ca.teranet.pages.polaris.RegisterViewPopupPage;
import ca.teranet.pages.polaris.SummaryPage;
import ca.teranet.pages.polaris.ViewWorkQPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class DocumentDetailSteps extends Utility {
	DocumentDetailPage documentDetailPage;
	MainPage mainPage;
	FeesTaxesPage feesTaxesPage;
	PINListPage pINListPage;
	DocumentDataPage documentDataPage;
	PINDetailsPage pINDetailsPage;
	RegisterViewPopupPage registerViewPopupPage;
	SummaryPage summaryPage;
	ViewWorkQPage viewWorkQPage;
	DeferOrCorrectionPage deferOrCorrectionPage;
	CertifyConfirmationPage certifyConfirmationPage;
	BatchPage batchPage;
	PropertyMaintenancePage propertyMaintenancePage;
	PartiesPage partiesPage;
	PropertyRemarksPage propertyRemarksPage;
	ModifyHeaderPage modifyHeaderPage;
	CorrectionNoticesPage correctionNoticesPage;
	DocumentViewPopupPage documentViewPopupPage;
	PINDetailsPage pinDetailsPage;
	PINListPage pinListPage;
	HighwayPipelinePage highwayPipelinePage;
	DeferOrCorrectionPage deferCertificationPage;
	CertifySteps certify;
	@Steps
	LogSteps logSteps = new LogSteps();
	@Steps
	ELRSCommonSteps elrsCommonSteps;
	@Steps
	CertifySteps certifySteps;

	@When("user clicks on Proceed With Receipt button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_ProceedWithReceipt(String shtName, int intRow) {
		boolean DocumentDetail_ProceedWithReceipt = false;
		try {
			String strStepName = "DocumentDetail_ProceedWithReceipt";
			// String strExpectedDocType = DocumentDetail_Retrieve_DocumentType();
			boolean intRet = false;
			if (!shtName.isEmpty() && intRow > 0) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, intRow);
				/*
				 * if (intRet == false) { logSteps.execution_log("Edit details of one or more tabs - UnSuccessful"); return false; }
				 */
				String strExpErrMsg = GetValueIfValid("ErrorMessages", shtName, intRow).trim();
			}
			documentDetailPage.ProceedWithReceipt_WebButton.click();
			if (mainPage.ApplicationError_WebElement.isPresent()) {
				SubmitApplicationErrorReport();
				return false;
			}
			if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
				logSteps.execution_log("The <Fees and Taxes> NOT exist - UnSuccessful");
				DocumentDetail_ProceedWithReceipt = false;
				String strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, "");
				if (intRet == false) {
					DocumentDetail_ProceedWithReceipt = false;
				}
				return false;
			}
			/*
			 * int intRowIndex = getRowWithCellText(feesTaxesPage.DocumentType_WebTable, "Document Type", 1, 1); String strDocType = getCellData(feesTaxesPage.DocumentType_WebTable, intRowIndex, 2).trim(); if (!strDocType.contains(strExpectedDocType)) { logSteps.execution_log("The <Document Type:> " +
			 * strExpectedDocType + "Not exist on <Fees and Taxes> page - UnSuccessful"); DocumentDetail_ProceedWithReceipt = false; return false; }
			 */
			DocumentDetail_ProceedWithReceipt = true;
			return DocumentDetail_ProceedWithReceipt;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String DocumentDetail_Retrieve_DocumentType() {
		String strHeadingText = documentDetailPage.Heading_WebTable.getText();
		String[] arrHeadingText = strHeadingText.split("Doc Type:");
		String strDocTypeText = arrHeadingText[1].trim();
		String[] arrDocTypeText = strDocTypeText.split("Status");
		String strDocType = arrDocTypeText[0].trim();
		return strDocType.trim();
	}

	public boolean DocumentDetail_EnterData_UsingDataMap(String shtName, int intRow) {
		boolean DocumentDetail_EnterData_UsingDataMap = false;
		try {
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();
			oDataMap.put("PINDetails", "");
			oDataMap.put("DocumentData", "");
			oDataMap.put("Parties", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("HighwayPipeline", "");
			oDataMap.put("Summary", "");
			oDataMap.put("CorrectionNotices", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);

			for (int i = 0; i <= arrKeys.length - 1; i++) {
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, intRow).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}

			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				intRet = DocumentDetail_Navigate_To_Tab(strSheetName);
				switch (strSheetName.toUpperCase()) {
				case "PINDETAILS":
					intRet = DocumentDetail_Edit_PINDetails(strSheetName, strRowNumber);
					break;
				case "DOCUMENTDATA":
					intRet = DocumentDetail_Edit_DocumentData(strSheetName, strRowNumber);
					break;
				case "PARTIES":
					intRet = DocumentDetail_Edit_Parties(strSheetName, strRowNumber);
					break;
				case "PROPERTYREMARKS":
					intRet = DocumentDetail_Edit_PropertyRemarks(strSheetName, strRowNumber);
					break;
				case "HIGHWAYPIPELINE":
					intRet = DocumentDetail_Edit_HighwayPipeline(strSheetName, strRowNumber);
					break;
				case "CORRECTIONNOTICES":
					intRet = DocumentDetail_Edit_CorrectionNotices(strSheetName, strRowNumber);
					break;
				case "SUMMARY":
					intRet = DocumentDetail_Edit_Summary(strSheetName, Integer.parseInt(strRowNumber));
					break;
				}
				if (intRet == false) {
				}
			}
			oDataMap = null;
			return DocumentDetail_EnterData_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Edit_Summary(String shtName, int intRow) {
		boolean DocumentDetail_Edit_Summary = false;
		try {
			String strStepName = "DocumentDetail_Edit_Summary";
			String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, intRow);
			String strPartyFromIndex = GetValueIfValid("PartyFromIndex", shtName, intRow);
			String strPartyFrom = GetValueIfValid("PartyFrom", shtName, intRow);
			String strPartyToIndex = GetValueIfValid("PartyToIndex", shtName, intRow);
			String strPartyTo = GetValueIfValid("PartyTo", shtName, intRow);
			String strNDIRestriction = GetValueIfValid("NDIRestriction", shtName, intRow);
			String strLRIRestriction = GetValueIfValid("LRIRestriction", shtName, intRow);
			String strManualLRI = GetValueIfValid("ManualLRI", shtName, intRow);
			String strManualNDI = GetValueIfValid("ManualNDI", shtName, intRow);
			if (strNDIRestriction.trim().toUpperCase().equals("!DYNAMIC!") || strNDIRestriction.trim().toUpperCase().equals("ON")) {
				if (summaryPage.NDIRestriction_WebCheckBox.isPresent()) {
					summaryPage.NDIRestriction_WebCheckBox.sendKeys("on");
				}
			}
			if (strLRIRestriction.trim().toUpperCase() == "!DYNAMIC!" || strLRIRestriction.trim().toUpperCase() == "ON") {
				if (summaryPage.NDIRestriction_WebCheckBox.isPresent()) {
					setCheckBoxValue(summaryPage.NDIRestriction_WebCheckBox, "on");
				}
			}
			if (strManualNDI.trim().toUpperCase() == "!DYNAMIC!" || strManualNDI.trim().toUpperCase() == "ON") {
				if (summaryPage.ManualNDI_WebCheckBox.isPresent()) {
					setCheckBoxValue(summaryPage.ManualNDI_WebCheckBox, "on");
				}
			}
			if (strManualLRI.trim().toUpperCase() == "!DYNAMIC!" || strManualLRI.trim().toUpperCase() == "ON") {
				if (summaryPage.ManualNDI_WebCheckBox.isPresent()) {
					setCheckBoxValue(summaryPage.ManualNDI_WebCheckBox, "on");
				}
			}
			String strReplaceOwners = GetValueIfValid("ReplaceOwners", shtName, intRow);
			String strAddNewEasements = GetValueIfValid("AddNewEasements", shtName, intRow);
			switch (strReplaceOwners.toUpperCase()) {
			case "NO":
				// summaryPage.ReplaceOwners_WebRadioGroup.click();
				break;
			case "YES":
				summaryPage.ReplaceOwners_WebRadioGroup.click();
				break;
			}
			switch (strAddNewEasements.toUpperCase()) {
			case "NO":
				// summaryPage.AddNewEasements_WebRadioGroup.click();
				break;
			case "YES":
				summaryPage.AddNewEasements_WebRadioGroup.click();
				break;
			}
			String strRefresh = GetValueIfValid("RefreshSummaryInformation", shtName, intRow);
			if (strRefresh.toUpperCase().equals("CLICK") || strRefresh.toUpperCase().equals("YES") || strRefresh.toUpperCase().equals("Y")) {
				summaryPage.RefreshSummaryInformation_WebButton.click();
			}
			DocumentDetail_Edit_Summary = true;
			return DocumentDetail_Edit_Summary;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Edit_CorrectionNotices(String shtName, String intRow) {
		boolean DocumentDetail_Edit_CorrectionNotices = false;
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
			String strNotice = null;
			environmentlib.setProperty("bTriggered", "false");
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strCorrectionAction = GetValueIfValid("CorrectionAction", shtName, iLoop);
				String strNoticeIndex = GetValueIfValid("NoticeIndex", shtName, iLoop);
				if (!strCorrectionAction.isEmpty() && !strCorrectionAction.equals("IGNORE_VALUE")) {
					switch (strCorrectionAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_CorrectionNotice_AddNotice(shtName, iLoop);
						break;
					case "REMOVE":
						intRet = DocumentDetail_CorrectionNotice_RemoveNotice(strNoticeIndex);
						break;
					}
					if (intRet != true) {
						environmentlib.setProperty("bTriggered", "true");
					}
				}
			}
			DocumentDetail_Edit_CorrectionNotices = true;
			return DocumentDetail_Edit_CorrectionNotices;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_CorrectionNotice_RemoveNotice(String intIndex) {
		boolean DocumentDetail_CorrectionNotice_RemoveNotice = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_CorrectionNotice_RemoveNotice";
			int intStart = 0;
			int intEnd = 0;
			String[] arrIndex = null;
			int iLoop = 0;
			int intNoticeIndex = 0;
			if (InStr(intIndex, "-") > 0) {
				arrIndex = (intIndex).split("-");
				intStart = Integer.parseInt(arrIndex[0]);
				intEnd = Integer.parseInt(arrIndex[1]);
			} else {
				intStart = Integer.parseInt(intIndex);
				intEnd = intStart;
			}
			for (iLoop = intStart; iLoop <= intEnd; iLoop++) {
				intNoticeIndex = iLoop - 1;
				String s = "removeCorrectionNote" + String.valueOf(intNoticeIndex);
				setCheckBoxValue(correctionNoticesPage.find(By.id(s)), "ON");
			}
			correctionNoticesPage.getDriver().switchTo().frame("Frame");
			// correctionNoticesPage.RemoveSelected_WebButton.click();
			DocumentDetail_CorrectionNotice_RemoveNotice = true;
			return DocumentDetail_CorrectionNotice_RemoveNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_CorrectionNotice_AddNotice(String shtName, int intRow) {
		try {
			String strStepName = "DocumentDetail_CorrectionNotice_AddNotice";
			boolean DocumentDetail_CorrectionNotice_AddNotice = false;
			String strNotice = GetValueIfValid("Notice", shtName, intRow);
			int intRows = 0;
			if (!correctionNoticesPage.Notice_WebTable.isPresent()) {
				intRows = 0;
			} else {
				intRows = getRowCount(correctionNoticesPage.Notice_WebTable);
			}
			environmentlib.setProperty("bTriggered", "false");
			correctionNoticesPage.CorrectionNotice_WebEdit.sendKeys(strNotice);
			correctionNoticesPage.AddNew_WebButton.click();
			String strTimeStamp = mainPage.TimeText_WebElement.getText();
			String[] arrTimeStamp = (strTimeStamp.trim()).split(" ");
			String strDate = arrTimeStamp[0].trim();
			String strUser = mainPage.UserText_WebElement.getText().trim();
			String strExpectedNotice = strNotice.toUpperCase() + " ON " + strDate + " AT <HH:MM> BY " + strUser.toUpperCase() + ".";
			setTestData("AutoGeneratedNotice", shtName, intRow, strExpectedNotice);
			boolean intRet = LocateAValueInWebTable(correctionNoticesPage.Notice_WebTable, strExpectedNotice); // In qfl
			if (intRet == true) {
				logSteps.execution_log("Verification of the added notice - Successful");
				DocumentDetail_CorrectionNotice_AddNotice = true;
				return false;
			}
			int intCounts = getRowCount(correctionNoticesPage.Notice_WebTable);
			int intDiff = intCounts - intRows;
			if (intDiff < 1) {
				logSteps.execution_log("New notice Not added - UnSuccessful");
				return false;
			}
			strExpectedNotice = getCellData(correctionNoticesPage.Notice_WebTable, intCounts, 2).trim();
			setTestData("AutoGeneratedNotice", shtName, intRow, strExpectedNotice);
			DocumentDetail_CorrectionNotice_AddNotice = true;
			return DocumentDetail_CorrectionNotice_AddNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean DocumentDetail_Edit_HighwayPipeline(String shtName, String intRow) {
		boolean DocumentDetail_Edit_HighwayPipeline = false;
		try {
			String strStepName = "DocumentDetail_Edit_HighwayPipeline";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = intRow.split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			int intPlanNumberIndex = 0;
			int intHwyNumberIndex = 0;
			int intHwyMunicipalityIndex = 0;
			int intTCPLMunicipalityIndex = 0;
			environmentlib.setProperty("bTriggered", "false");
			String strHwyDocumentRemarks = GetValueIfValid("HwyDocumentRemarks", shtName, intStart);
			String strSurveyNumber = GetValueIfValid("SurveyNumber", shtName, intStart);
			String strTCPLDocumentRemarks = GetValueIfValid("TCPLDocumentRemarks", shtName, intStart);
			if (highwayPipelinePage.HWYDocRemarks_WebEdit.isEnabled())
				highwayPipelinePage.HWYDocRemarks_WebEdit.sendKeys(strHwyDocumentRemarks);
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
				String strPlanNumberAction = GetValueIfValid("PlanNumberAction", shtName, iLoop);
				String strPlanNumberIndex = GetValueIfValid("PlanNumberIndex", shtName, iLoop);
				String strPlanNumber1 = GetValueIfValid("PlanNumber1", shtName, iLoop);
				String strPlanNumber2 = GetValueIfValid("PlanNumber2", shtName, iLoop);
				String strHwyNumberAction = GetValueIfValid("HwyNumberAction", shtName, iLoop);
				String strHwyNumberIndex = GetValueIfValid("HwyNumberIndex", shtName, iLoop);
				String strHwyNumber1 = GetValueIfValid("HwyNumber1", shtName, iLoop);
				String strHwyNumber2 = GetValueIfValid("HwyNumber2", shtName, iLoop);
				String strHwyMunicipalityAction = GetValueIfValid("HwyMunicipalityAction", shtName, iLoop);
				String strHwyMunicipalityIndex = GetValueIfValid("HwyMunicipalityIndex", shtName, iLoop);
				String strHwyMunicipalityList = GetValueIfValid("HwyMunicipalityList", shtName, iLoop);
				// strSurveyNumber = GetValueIfValid("SurveyNumber", shtName)
				// strTCPLDocumentRemarks = GetValueIfValid("TCPLDocumentRemarks", shtName)
				String strTCPLMunicipalityAction = GetValueIfValid("TCPLMunicipalityAction", shtName, iLoop);
				String strTCPLMunicipalityIndex = GetValueIfValid("TCPLMunicipalityIndex", shtName, iLoop);
				String strTCPLMunicipalityList = GetValueIfValid("TCPLMunicipalityList", shtName, iLoop);
				if (NumberUtils.isNumber(strPlanNumberIndex)) {
					intPlanNumberIndex = Integer.parseInt(strPlanNumberIndex) - 1;
					switch (strPlanNumberAction.toUpperCase()) {
					case "ADD":
						if (!highwayPipelinePage.find(By.id("hwyPlanNumberToRemove" + intPlanNumberIndex)).isPresent()) {
							highwayPipelinePage.MorePlanNumbers_WebButton.click();
						}
						highwayPipelinePage.find(By.name("indicesForm.planNumberPart1Map['" + intPlanNumberIndex + "']")).sendKeys(strPlanNumber1);
						highwayPipelinePage.find(By.name("indicesForm.planNumberPart2Map['" + intPlanNumberIndex + "']")).sendKeys(strPlanNumber2);
						break;
					case "REMOVE":
						setCheckBoxValue(highwayPipelinePage.find(By.id("hwyPlanNumberToRemove" + intPlanNumberIndex)), "ON");
						highwayPipelinePage.RemovePlanNumber_WebButton.click();
						break;
					}
				}
				if (NumberUtils.isNumber(strHwyNumberIndex)) {
					intHwyNumberIndex = Integer.parseInt(strHwyNumberIndex) - 1;
					switch (strHwyNumberAction.toUpperCase()) {
					case "ADD":
						if (!highwayPipelinePage.find(By.id("hwyNumberToRemove" + intHwyNumberIndex)).isPresent()) {
							highwayPipelinePage.MoreHighwayNumbers_WebButton.click();
						}
						highwayPipelinePage.find(By.name("indicesForm.hwyNumberPart1Map['" + intHwyNumberIndex + "']")).sendKeys(strHwyNumber1);
						highwayPipelinePage.find(By.name("indicesForm.hwyNumberPart2Map['" + intHwyNumberIndex + "']")).sendKeys(strHwyNumber2);
						break;
					case "REMOVE":
						setCheckBoxValue(highwayPipelinePage.find(By.id("hwyNumberToRemove" + intHwyNumberIndex)), "ON");
						highwayPipelinePage.RemoveHwyNumber_WebButton.click();
						break;
					}
				}
				if (NumberUtils.isNumber(strHwyMunicipalityIndex)) {
					intHwyMunicipalityIndex = Integer.parseInt(strHwyMunicipalityIndex) - 1;
					switch (strHwyMunicipalityAction.toUpperCase()) {
					case "ADD":
						if (!highwayPipelinePage.find(By.id("hwyMunicipalityToRemove" + intHwyMunicipalityIndex)).isPresent()) {
							highwayPipelinePage.MoreHwyMunicipality_WebButton.click();
						}
						highwayPipelinePage.find(By.id("hwyMunicipality" + intHwyMunicipalityIndex)).selectByVisibleText(strHwyMunicipalityList.toUpperCase());
						break;
					case "REMOVE":
						setCheckBoxValue(highwayPipelinePage.find(By.id("hwyMunicipalityToRemove" + intHwyMunicipalityIndex)), "ON");
						highwayPipelinePage.RemoveHwyMunicipality_WebButton.click();
						break;
					}
				}
				// oPage.WebEdit("HwyDocRemarks").sendKeys(strHwyDocumentRemarks)
				// //Set Survery Number/TCPL Register Document Remarks
				// .WebEdit("SurveryNumber").sendKeys(strSurveyNumber)
				// .WebEdit("TCPLDocRemarks").sendKeys(strTCPLDocumentRemarks)
				// Add/Remove TCPL Municipality affected
				if (NumberUtils.isNumber(strTCPLMunicipalityIndex)) {
					intTCPLMunicipalityIndex = Integer.parseInt(strTCPLMunicipalityIndex) - 1;
					switch (strTCPLMunicipalityAction.toUpperCase()) {
					case "ADD":
						if (!highwayPipelinePage.find(By.id("tcpMunicipalityToRemove" + intTCPLMunicipalityIndex)).isPresent()) {
							highwayPipelinePage.MoreTCPMunicipality_WebButton.click();
						}
						highwayPipelinePage.find(By.id("tcpMunicipality" + intTCPLMunicipalityIndex)).selectByVisibleText(strTCPLMunicipalityList.toUpperCase());
						break;
					case "REMOVE":
						setCheckBoxValue(highwayPipelinePage.find(By.id("tcpMunicipalityToRemove" + intTCPLMunicipalityIndex)), "ON");
						highwayPipelinePage.RemoveTCPMunicipality_WebButton.click();
						break;
					}
				}
			}
			highwayPipelinePage.SurveryNumber_WebEdit.sendKeys(strSurveyNumber);
			highwayPipelinePage.TCPLDocRemarks_WebEdit.sendKeys(strTCPLDocumentRemarks);
			DocumentDetail_Edit_HighwayPipeline = true;
			return DocumentDetail_Edit_HighwayPipeline;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Edit_PropertyRemarks(String shtName, String intRow) {
		boolean DocumentDetail_Edit_PropertyRemarks = false;
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
			String strDocumentIndex = null;
			String strInterestAction = null;
			String strInterestIndex = null;
			String strOtherRemarks = GetValueIfValid("OtherRemarks", shtName, intStart);
			environmentlib.setProperty("bTriggered", "false");
			propertyRemarksPage.PropertyRemark_WebEdit.sendKeys(strOtherRemarks);
			if (!strInterestAction.isEmpty() || !strInterestAction.equals("IGNORE_VALUE")) {
				boolean intRet = false;
				for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
					strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
					strInterestAction = GetValueIfValid("InterestAction", shtName, iLoop);
					strInterestIndex = GetValueIfValid("InterestIndex", shtName, iLoop);
					intRet = true;
					switch (strInterestAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_PropertyRemarks_Interest_Add(shtName, iLoop);
						break;
					case "REMOVE":
						intRet = DocumentDetail_PropertyRemarks_Interest_Remove(strInterestIndex);
						break;
					case "FILL":
						intRet = DocumentDetail_PropertyRemarks_Interest_Fill(shtName, iLoop);
						break;
					}
					if (!intRet == true) {
						logSteps.execution_log("<" + strInterestAction + "> OutStanding Interest - UnSuccessful");
						return false;
					}
				}
			}
			DocumentDetail_Edit_PropertyRemarks = true;
			return DocumentDetail_Edit_PropertyRemarks;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PropertyRemarks_Interest_Add(String shtName, int intRow) {
		boolean DocumentDetail_PropertyRemarks_Interest_Add = false;
		try {
			String strInterest = GetValueIfValid("Interest", shtName, intRow);
			String strInterestIndex = GetValueIfValid("InterestIndex", shtName, intRow);
			boolean intRet = false;
			environmentlib.setProperty("bTriggered", "false");
			if (!strInterest.isEmpty() || !strInterest.equals("IGNORE_VALUE")) {
				propertyRemarksPage.Interest_WebList.selectByVisibleText(strInterest.toUpperCase());
				propertyRemarksPage.getDriver().switchTo().frame("Frame");
				propertyRemarksPage.Add_WebButton.click();
			}
			if (NumberUtils.isNumber(strInterestIndex)) {
				intRet = DocumentDetail_PropertyRemarks_Interest_Fill(shtName, intRow);
				if (!intRet == true) {
					logSteps.execution_log("Add Outstanding Interest - UnSuccessful");
					return false;
				}
			}
			DocumentDetail_PropertyRemarks_Interest_Add = true;
			return DocumentDetail_PropertyRemarks_Interest_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PropertyRemarks_Interest_Remove(String strIndex) {
		boolean DocumentDetail_PropertyRemarks_Interest_Remove = false;
		try {
			if (NumberUtils.isNumber(strIndex)) {
				int intIndex = Integer.parseInt(strIndex) - 1;
				setCheckBoxValue(propertyRemarksPage.find(By.name("oiForm.interestToRemove(" + intIndex + "])")), "ON");
			}
			propertyRemarksPage.RemoveSelected_WebButton.click();
			DocumentDetail_PropertyRemarks_Interest_Remove = true;
			return DocumentDetail_PropertyRemarks_Interest_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PropertyRemarks_Interest_Fill(String shtName, int intRow) {
		boolean DocumentDetail_PropertyRemarks_Interest_Fill = false;
		try {
			String strInterest = GetValueIfValid("Interest", shtName, intRow);
			String strInterestIndex = GetValueIfValid("InterestIndex", shtName, intRow);
			String strDebtsOf = GetValueIfValid("DebtsOf", shtName, intRow);
			String strSpouseOf = GetValueIfValid("SpouseOf", shtName, intRow);
			String strExecutionFrom = GetValueIfValid("ExecutionFrom", shtName, intRow);
			String strExecutionTo = GetValueIfValid("ExecutionTo", shtName, intRow);
			String strAsIn = GetValueIfValid("AsIn", shtName, intRow);
			environmentlib.setProperty("bTriggered", "false");
			if (NumberUtils.isNumber(strInterestIndex)) {
				Object intInterestIndex = null;
				intInterestIndex = Integer.parseInt(strInterestIndex) - 1;
				switch (strInterest.toUpperCase()) {
				case "SUBJECT TO DEBTS":
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_1")).sendKeys(strDebtsOf);
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO SPOUSAL RIGHTS":
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_1")).sendKeys(strSpouseOf);
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO WRIT OF EXECUTION":
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_1")).sendKeys(strExecutionFrom);
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_3")).sendKeys(strExecutionTo);
					propertyRemarksPage.find(By.id("oi" + intInterestIndex + "_5")).sendKeys(strAsIn);
					break;
				}
			}
			DocumentDetail_PropertyRemarks_Interest_Fill = true;
			return DocumentDetail_PropertyRemarks_Interest_Fill;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * public String CheckDocumentDetailActiveTab() {
	 * 
	 * String[] arrTabs = new String[7];
	 * 
	 * arrTabs[0] = "Summary";
	 * 
	 * arrTabs[1] = "PINDetails";
	 * 
	 * arrTabs[2] = "DocumentData";
	 * 
	 * arrTabs[3] = "Parties";
	 * 
	 * arrTabs[4] = "PropertyRemarks";
	 * 
	 * arrTabs[5] = "HighwayPipeline";
	 * 
	 * arrTabs[6] = "CorrectionNotices";
	 * 
	 * String classprop = "";
	 * 
	 * for (int iLoop = 1; iLoop <= 7; iLoop++) {
	 * 
	 * switch (arrTabs[iLoop - 1].trim()) {
	 * 
	 * case "Summary":
	 * 
	 * classprop = documentDetailPage.Summary_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "PINDetails":
	 * 
	 * classprop = documentDetailPage.PINDetails_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "DocumentData":
	 * 
	 * classprop = documentDetailPage.DocumentData_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "Parties":
	 * 
	 * classprop = documentDetailPage.Parties_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "PropertyRemarks":
	 * 
	 * classprop = documentDetailPage.PropertyRemarks_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "HighwayPipeline":
	 * 
	 * classprop = documentDetailPage.HighwayPipeline_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * case "CorrectionNotices":
	 * 
	 * classprop = documentDetailPage.CorrectionNotices_Link.getAttribute("class");
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * if (classprop.equals("foretab")) {
	 * 
	 * return arrTabs[iLoop - 1];
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return "";
	 * 
	 * }
	 */

	public boolean DocumentDetail_Edit_PINDetails(String shtName, String intRow) {
		boolean DocumentDetail_Edit_PINDetails = false;
		try {
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = intRow.split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intStart);
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			String strNewEasement = GetValueIfValid("NewEasement", shtName, intStart);
			String strSplitConsolidate = GetValueIfValid("SplitConsolidate", shtName, intStart);
			String strEasementOnly = GetValueIfValid("EasementOnly", shtName, intStart);
			String strPINDetailsAction = GetValueIfValid("PINDetailsAction", shtName, intStart);
			String strDocumentRemarks = GetValueIfValid("DocumentRemarks", shtName, intStart);
			String strStreetNumber = GetValueIfValid("StreetNumber", shtName, intStart);
			String strSuffix = GetValueIfValid("Suffix", shtName, intStart);
			String strStreetName = GetValueIfValid("StreetName", shtName, intStart);
			String strCityTown = GetValueIfValid("CityTown", shtName, intStart);
			String strUnitType = GetValueIfValid("UnitType", shtName, intStart);
			String strUnitNumber = GetValueIfValid("UnitNumber", shtName, intStart);
			boolean intRet = false;
			setCheckBoxValue(mainPage.getDriver().findElement(By.xpath("(//*[@name='allSelectedReasonsForChange[" + intPropertyIndex + "].selectedReasonsForChange'])[1]")), strNewEasement);
			setCheckBoxValue(pinDetailsPage.find(By.xpath("(//*[@name='allSelectedReasonsForChange[" + intPropertyIndex + "].selectedReasonsForChange'])[2]")), strSplitConsolidate);
			setCheckBoxValue(pinDetailsPage.find(By.xpath("(//*[@name='easmentOnlyIndicators[" + intPropertyIndex + "]])")), strEasementOnly);
			if (strPINDetailsAction.toUpperCase().equals("EDIT")) {
				pinDetailsPage.find(By.id("submitEdit" + intPropertyIndex)).click();
				intRet = DocumentDetail_PINDetails_EditDescription(shtName, intRow, intPropertyIndex);
				if (intRet != true) {
					environmentlib.setProperty("bTriggered", "true");
				}
			}
			pinDetailsPage.find(By.id("DocumentRemarkForPIN[" + intPropertyIndex + "]")).sendKeys(strDocumentRemarks);
			pinDetailsPage.find(By.name("streetNumberMap['" + intPropertyIndex + "']")).sendKeys(strStreetNumber);
			pinDetailsPage.find(By.name("streetSuffixMap['" + intPropertyIndex + "']")).sendKeys(strSuffix);
			pinDetailsPage.find(By.name("streetNameMap['" + intPropertyIndex + "']")).sendKeys(strStreetName);
			pinDetailsPage.find(By.name("areaMap['" + intPropertyIndex + "']")).sendKeys(strCityTown);
			if (strUnitType.isEmpty()) {
				pinDetailsPage.find(By.xpath("//*[@id='municipalAddress(" + intPropertyIndex + ",unitTypeCode)']")).selectByIndex(0);
				// pinDetailsPage.find(By.xpath("//*[@name='unitTypeMap('" + intPropertyIndex + "']")).selectByIndex(0);
			} else {
				pinDetailsPage.find(By.id("municipalAddress(" + intPropertyIndex + ",unitTypeCode)")).selectByVisibleText(strUnitType.toUpperCase());
				// pinDetailsPage.find(By.xpath("//*[@name='unitTypeMap['" + intPropertyIndex + "']")).selectByVisibleText(strUnitType.toUpperCase());
			}
			// pinDetailsPage.find(By.id("municipalAddress(" + intPropertyIndex + ",unitId)")).sendKeys(strUnitNumber);
			// pinDetailsPage.find(By.name("unitIdMap['" + intPropertyIndex + "']")).sendKeys(strUnitNumber);
			DocumentDetail_Edit_PINDetails = true;
			return DocumentDetail_Edit_PINDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Edit_DocumentData(String shtName, String intRow) {
		boolean DocumentDetail_Edit_DocumentData = false;
		try {
			String strStepName = "DocumentDetail_Edit_DocumentData";
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
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
				String strInternalProcessingNotes = GetValueIfValid("InternalProcessingNotes", shtName, iLoop);
				String strInternalProcessingAction = GetValueIfValid("InternalProcessingAction", shtName, iLoop);
				String strDocumentRemarks = GetValueIfValid("DocumentRemarks", shtName, iLoop);
				String strDocumentRemarksAction = GetValueIfValid("DocumentRemarksAction", shtName, iLoop);
				String strAmount = GetValueIfValid("Amount", shtName, iLoop);
				String strGoodsAndChattels = GetValueIfValid("GoodsAndChattels", shtName, iLoop);
				String strFamilyDwelling = GetValueIfValid("FamilyDwelling", shtName, iLoop);
				String strStatementIndicator = GetValueIfValid("StatementIndicator", shtName, iLoop);
				String strConsentIndicator = GetValueIfValid("ConsentIndicator", shtName, iLoop);
				String strExpiryDate = GetValueIfValid("ExpiryDate", shtName, iLoop);
				String strTotalNewUnits = GetValueIfValid("TotalNewUnits", shtName, iLoop);
				String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, iLoop);
				String strNewUnit = GetValueIfValid("NewUnit", shtName, iLoop);
				String strNewLevel = GetValueIfValid("NewLevel", shtName, iLoop);
				String strMultipleRelatedDocuments = GetValueIfValid("MultipleRelatedDocuments", shtName, iLoop);
				String strPageIndex = GetValueIfValid("PageIndex", shtName, iLoop);
				String strAffectsAll = GetValueIfValid("AffectsAll", shtName, iLoop);
				String strPartList = GetValueIfValid("PartList", shtName, iLoop);
				String strStreetNameIndex = GetValueIfValid("StreetNameIndex", shtName, iLoop);
				String strStreetName = GetValueIfValid("StreetName", shtName, iLoop);
				String strQualifyingDescription = GetValueIfValid("QualifyingDescription", shtName, iLoop);
				String strBoundariesActPlanNumber = GetValueIfValid("BoundariesActPlanNumber", shtName, iLoop);
				String strPlanUnitIndex = GetValueIfValid("PlanUnitIndex", shtName, iLoop);
				String strNonStandard = GetValueIfValid("NonStandard", shtName, iLoop);
				String strUnitType = GetValueIfValid("UnitType", shtName, iLoop);
				String strStartRange = GetValueIfValid("StartRange", shtName, iLoop);
				String strEndRange = GetValueIfValid("EndRange", shtName, iLoop);
				String strQualifyingName = GetValueIfValid("QualifyingName", shtName, iLoop);
				String strUnitLevelIndex = GetValueIfValid("UnitLevelIndex", shtName, iLoop);
				String strNumberOfUnits = GetValueIfValid("NumberOfUnits", shtName, iLoop);
				String strTownshipMunicipality = GetValueIfValid("TownshipMunicipality", shtName, iLoop);
				String strNameOfSurveyFirm = GetValueIfValid("NameOfSurveyFirm", shtName, iLoop);
				String strSurveyorsFileNumber = GetValueIfValid("SurveyorsFileNumber", shtName, iLoop);
				String strCondoDeclaration = GetValueIfValid("CondoDeclaration", shtName, iLoop);
				String strRegistrationDate = GetValueIfValid("RegistrationDate", shtName, iLoop);
				String strCondoDeclarationBeingAmended = GetValueIfValid("CondoDeclarationBeingAmended", shtName, iLoop);
				String strCondoPlanBeingAmended = GetValueIfValid("CondoPlanBeingAmended", shtName, iLoop);
				String strRelatedDocument = GetValueIfValid("RelatedDocument", shtName, iLoop);
				String strNumberOfPages = GetValueIfValid("NumberOfPages", shtName, iLoop);
				if (!strPageIndex.isEmpty() && !strPageIndex.equals("IGNORE_VALUE")) {
					Thread.sleep(2000);
					pinListPage.PageValue_WebEdit.sendKeys(strPageIndex);
					Thread.sleep(2000);
					pinListPage.GoToPage_WebButton.click();
					Thread.sleep(5000);
				}
				if (!strInternalProcessingAction.isEmpty() && !strInternalProcessingAction.equals("IGNORE_VALUE")) {
					intRet = DocumentData_EnterData_InternalProcessingNotes(strInternalProcessingAction, strInternalProcessingNotes);
					if (intRet == false) {
						DocumentDetail_Edit_DocumentData = false;
						return false;
					}
				}
				if (!strDocumentRemarksAction.isEmpty() && !strDocumentRemarksAction.equals("IGNORE_VALUE")) {
					intRet = DocumentData_EnterData_DocumentRemarks(strDocumentRemarksAction, strDocumentRemarks);
					if (intRet == false) {
						DocumentDetail_Edit_DocumentData = false;
						return false;
					}
				}
				documentDataPage.Amount_WebEdit.clear();
				documentDataPage.Amount_WebEdit.sendKeys(strAmount);
				if (documentDataPage.GoodsAndChattels_WebEdit.isVisible()) {
					if (documentDataPage.GoodsAndChattels_WebEdit.isEnabled()) {
						documentDataPage.GoodsAndChattels_WebEdit.sendKeys(strGoodsAndChattels);
					}
				}
				/*
				 * if (documentDataPage.ExpiryDate_WebEdit.isEnabled()) { documentDataPage.ExpiryDate_WebEdit.sendKeys(strExpiryDate); }
				 */if (documentDataPage.FamilyDwelling_WebCheckBox.isVisible()) {
					if (documentDataPage.FamilyDwelling_WebCheckBox.isEnabled()) {
						setCheckBoxValue(documentDataPage.FamilyDwelling_WebCheckBox, strFamilyDwelling);
					}
				}
				/*
				 * if (documentDataPage.StatementIndicator_WebCheckBox.isDisplayed()) { setCheckBoxValue(documentDataPage.StatementIndicator_WebCheckBox, strStatementIndicator); } if (documentDataPage.ConsentIndicator_WebCheckBox.isDisplayed()) { setCheckBoxValue(documentDataPage.ConsentIndicator_WebCheckBox,
				 * strConsentIndicator); } if (documentDataPage.TotalNewUnits_WebEdit.isDisplayed()) { documentDataPage.TotalNewUnits_WebEdit.sendKeys(strTotalNewUnits); } if (documentDataPage.FamilyDwelling_WebCheckBox.isDisplayed()) { setCheckBoxValue(documentDataPage.FamilyDwelling_WebCheckBox,
				 * strMultipleRelatedDocuments); } if (documentDataPage.BoundariesActPlanNumber_WebEdit.isDisplayed()) { documentDataPage.BoundariesActPlanNumber_WebEdit.sendKeys(strBoundariesActPlanNumber); } if (documentDataPage.RelatedDocument_WebEdit.isDisplayed()) {
				 * documentDataPage.RelatedDocument_WebEdit.sendKeys(strRelatedDocument); } if (documentDataPage.NumberOfPages_WebEdit.isDisplayed()) { documentDataPage.NumberOfPages_WebEdit.sendKeys(strNumberOfPages); } if (documentDataPage.TownshipMunicipality_WebEdit.isDisplayed()) {
				 * documentDataPage.TownshipMunicipality_WebEdit.sendKeys(strTownshipMunicipality); } if (documentDataPage.NameOfSurveyFirm_WebEdit.isDisplayed()) { documentDataPage.NameOfSurveyFirm_WebEdit.sendKeys(strNameOfSurveyFirm); } if (documentDataPage.SurveyorsFileNumber_WebEdit.isDisplayed()) {
				 * documentDataPage.SurveyorsFileNumber_WebEdit.sendKeys(strSurveyorsFileNumber); } if (documentDataPage.CondoDeclaration_WebEdit.isDisplayed()) { documentDataPage.CondoDeclaration_WebEdit.sendKeys(strCondoDeclaration); } if (documentDataPage.RegistrationDate_WebEdit.isDisplayed()) {
				 * documentDataPage.RegistrationDate_WebEdit.sendKeys(strRegistrationDate); } if (documentDataPage.CondoDeclarationBeingAmended_WebEdit.isDisplayed()) { documentDataPage.CondoDeclarationBeingAmended_WebEdit.sendKeys(strCondoDeclarationBeingAmended); } if
				 * (documentDataPage.CondoPlanBeingAmended_WebEdit.isDisplayed()) { documentDataPage.CondoPlanBeingAmended_WebEdit.sendKeys(strCondoPlanBeingAmended); } if (!strPropertyIndex.isEmpty() && !strPropertyIndex.equals("IGNORE_VALUE")) { int intIndexStart = 0; int intIndexEnd = 0; String[] arrIndex =
				 * null; if (strPropertyIndex.contains("-")) { arrIndex = (strPropertyIndex).split("-"); intIndexStart = Integer.parseInt(arrIndex[0]); intIndexEnd = Integer.parseInt(arrIndex[1]); } else { intIndexStart = Integer.parseInt(strPropertyIndex); intIndexEnd = intIndexStart; } for (int intLoop =
				 * intIndexStart; intLoop <= intIndexEnd; intLoop++) { int intPropertyIndex = intLoop - 1; documentDataPage.find(By.id("unit" + intPropertyIndex)).sendKeys(strNewUnit); documentDataPage.find(By.id("level" + intPropertyIndex)).sendKeys(strNewLevel); documentDataPage.find(By.id("affectsAll" +
				 * intPropertyIndex)).sendKeys(strAffectsAll); documentDataPage.find(By.id("partList" + intPropertyIndex)).sendKeys(strPartList); } } if (NumberUtils.isNumber(strStreetNameIndex)) { int intStreetNameIndex = Integer.parseInt(strStreetNameIndex) - 1;
				 * 
				 * if (!documentDataPage.find(By.id("planStreetUnitName" + intStreetNameIndex)).isPresent()) { documentDataPage.AddMoreStreetName_WebButton.click(); } documentDataPage.find(By.id("planStreetUnitName" + intStreetNameIndex)).sendKeys(strStreetName);
				 * documentDataPage.find(By.id("planStreetUnitDescription" + intStreetNameIndex)).sendKeys(strQualifyingDescription); } if (NumberUtils.isNumber(strPlanUnitIndex)) { int intPlanUnitIndex = Integer.parseInt(strPlanUnitIndex) - 1; if (!documentDataPage.find(By.id("planUnitType" +
				 * intPlanUnitIndex)).isPresent()) { documentDataPage.AddMorePlanUnit_WebButton.click(); } setCheckBoxValue(documentDataPage.find(By.name("attributesVOBean.attributeVO(UnitInformation).planUnit[" + intPlanUnitIndex + "].nonStandardPlanUnitType")), strNonStandard);
				 * documentDataPage.find(By.id("planUnitType" + intPlanUnitIndex)).selectByVisibleText(strUnitType.toUpperCase()); documentDataPage.find(By.id("planUnitNumber" + intPlanUnitIndex)).sendKeys(strStartRange); documentDataPage.find(By.id("planUnitRange" + intPlanUnitIndex)).sendKeys(strEndRange);
				 * documentDataPage.find(By.id("planUnitName" + intPlanUnitIndex)).sendKeys(strQualifyingName); } if (NumberUtils.isNumber(strUnitLevelIndex)) { int intUnitLevelIndex = Integer.parseInt(strUnitLevelIndex) - 1; if (!documentDataPage.find(By.id("level" + intUnitLevelIndex)).isPresent()) {
				 * documentDataPage.AddMore_WebButton.click(); } documentDataPage.find(By.id("level" + intUnitLevelIndex)).sendKeys(strStartRange); documentDataPage.find(By.id("levelRange" + intUnitLevelIndex)).sendKeys(strEndRange); documentDataPage.find(By.id("numberOfUnits" +
				 * intUnitLevelIndex)).sendKeys(strNumberOfUnits); }
				 */
			}

			DocumentDetail_Edit_DocumentData = true;
			return DocumentDetail_Edit_DocumentData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Edit_Parties(String shtName, String intRow) {
		boolean DocumentDetail_Edit_Parties = false;
		try {
			String strStepName = "DocumentDetail_Edit_Parties";

			String strDocumentType = documentDetailPage.DocumentType_WebElement.getText();
			boolean intRet = false;
			String[] arrDocumentType = strDocumentType.split(":");
			String strDocType = arrDocumentType[1].trim();
			if (strDocType.contains("LR'S")) {
				intRet = DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "LAND REGISTRAR");
				if (intRet == false) {
					return false;
				}
			}
			if (strDocType.compareTo("DIRECTOR OF TITLES ORDER") == 0) {
				intRet = DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "DIRECTOR OF TITLES");
				if (intRet == false) {
					return false;
				}
			}
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
				String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
				String strPartyFromIndex = GetValueIfValid("PartyFromIndex", shtName, iLoop);
				String strPartyFrom = GetValueIfValid("PartyFrom", shtName, iLoop);
				String strPartyFromAction = GetValueIfValid("PartyFromAction", shtName, iLoop);
				String strPartyToIndex = GetValueIfValid("PartyToIndex", shtName, iLoop);
				String strPartyToAction = GetValueIfValid("PartyToAction", shtName, iLoop);
				if (NumberUtils.isNumber(strPartyFromIndex)) {
					int intPartyFromIndex = Integer.parseInt(strPartyFromIndex) - 1;
					switch (strPartyFromAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_Parties_PartyFrom_Add(intPartyFromIndex, strPartyFrom);
						break;
					case "REMOVE":
						intRet = DocumentDetail_Parties_PartyFrom_Remove(intPartyFromIndex);
						break;
					}
					if (!intRet == true) {
						logSteps.execution_log(strPartyFromAction + " name to/from <Party From Name(s)> list - UnSuccessful");
						return false;
					}
				} else {
					if (strPartyFromAction.toUpperCase() == "REMOVEALL") {
						intRet = DocumentDetail_Parties_PartyFrom_RemoveAll();
						if (!intRet == true) {
							logSteps.execution_log("Remove All names from <Party From Name(s):> list - UnSuccessful");
							return false;
						}
					}
				}
				if (NumberUtils.isNumber(strPartyToIndex)) {
					int intPartyToIndex = Integer.parseInt(strPartyToIndex) - 1;
					switch (strPartyToAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_Parties_PartyTo_Add(shtName, iLoop, intPartyToIndex);
						break;
					case "REMOVE":
						intRet = DocumentDetail_Parties_PartyTo_Remove(intPartyToIndex);
						break;
					}
					if (!intRet == true) {
						logSteps.execution_log(strPartyFromAction + " name to/from <Party To:> list - UnSuccessful");
						return false;
					}
				} else {
					if (strPartyToAction.toUpperCase() == "REMOVEALL") {
						intRet = DocumentDetail_Parties_PartyTo_RemoveAll();
						if (!intRet == true) {
							logSteps.execution_log("Remove All names from <Party To:> list - UnSuccessful");
							return false;
						}
					}
				}
			}
			DocumentDetail_Edit_Parties = true;
			return DocumentDetail_Edit_Parties;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyTo_Add(String shtName, int intRow, int intIndex) {
		boolean DocumentDetail_Parties_PartyTo_Add = false;
		try {
			String strPartyTo = GetValueIfValid("PartyTo", shtName, intRow);
			String strCapacity = GetValueIfValid("Capacity", shtName, intRow);
			String strShare = GetValueIfValid("Share", shtName, intRow);
			String strFrench = GetValueIfValid("French", shtName, intRow);
			environmentlib.setProperty("bTriggered", "false");
			if (!partiesPage.find(By.id("partyToRemove" + intIndex)).isPresent()) {
				partiesPage.PartyTo_MoreNames_WebButton.click();
			}
			partiesPage.find(By.id("partyToName" + intIndex)).sendKeys(strPartyTo);
			if (strFrench.toUpperCase().equals("ON")) {
				setCheckBoxValue(partiesPage.find(By.id("capacityFrenchIndicator" + intIndex)), strFrench);
			}
			partiesPage.find(By.id("partyToCapacity" + intIndex)).selectByVisibleText(strCapacity.toUpperCase());
			partiesPage.find(By.id("partyToShare" + intIndex)).sendKeys(strShare);
			return DocumentDetail_Parties_PartyTo_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyTo_Remove(int intIndex) {
		boolean DocumentDetail_Parties_PartyTo_Remove = false;
		try {
			setCheckBoxValue(partiesPage.find(By.id("partyToRemove" + intIndex)), "ON");
			partiesPage.PartyTo_RemoveSelected_WebButton.click();
			String strName = partiesPage.find(By.id("partyToName" + intIndex)).getAttribute("value");
			if (!strName.trim().isEmpty()) {
				logSteps.execution_log("Verification of the removed name - UnSuccessful. Actual:<" + strName + ">");
				return false;
			}
			DocumentDetail_Parties_PartyTo_Remove = true;
			return DocumentDetail_Parties_PartyTo_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyTo_RemoveAll() {
		boolean DocumentDetail_Parties_PartyTo_RemoveAll = false;
		try {
			boolean intRet = false;
			partiesPage.PartyTo_RemoveAll_WebButton.click();
			if (isAlertPresent())
				for (int iLoop = 1; iLoop <= 2; iLoop++) {
					String strName = partiesPage.find(By.id("partyToName" + (iLoop - 1))).getAttribute("value");
					if (!strName.trim().isEmpty()) {
						logSteps.execution_log("Name <" + strName + "> still presents in row " + iLoop + " after Remove All butto clicked - UnSuccessful");
						return false;
					}
				}
			DocumentDetail_Parties_PartyTo_RemoveAll = true;
			return DocumentDetail_Parties_PartyTo_RemoveAll;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyFrom_Add(int intIndex, String strName) {
		boolean DocumentDetail_Parties_PartyFrom_Add = false;
		try {
			if (!partiesPage.find(By.id("partyFromRemove" + intIndex)).isPresent()) {
				partiesPage.PartyFrom_MoreNames_WebButton.click();
			}
			partiesPage.find(By.id("partyFromName" + intIndex)).sendKeys(strName);
			return DocumentDetail_Parties_PartyFrom_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyFrom_Remove(int intIndex) {
		boolean DocumentDetail_Parties_PartyFrom_Remove = false;
		try {
			setCheckBoxValue(partiesPage.find(By.id("partyFromRemove" + intIndex)), "ON");
			partiesPage.PartyFrom_RemoveSelected_WebButton.click();
			String strName = partiesPage.find(By.id("partyFromName" + intIndex)).getAttribute("value");
			if (!strName.trim().isEmpty()) {
				logSteps.execution_log("Verification of the removed name - UnSuccessful. Actual:<" + strName + ">");
				return false;
			}
			DocumentDetail_Parties_PartyFrom_Remove = true;
			return DocumentDetail_Parties_PartyFrom_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_PartyFrom_RemoveAll() {
		boolean DocumentDetail_Parties_PartyFrom_RemoveAll = false;
		try {
			boolean intRet = false;
			partiesPage.PartyFrom_RemoveAll_WebButton.click();
			if (isAlertPresent())
				for (int iLoop = 1; iLoop <= 2; iLoop++) {
					String strName = partiesPage.find(By.id("partyFromName" + (iLoop - 1))).getAttribute("value");
					if (!strName.trim().isEmpty()) {
						logSteps.execution_log("Name <" + strName + "> still presents in row " + iLoop + " after Remove All butto clicked - UnSuccessful");
						return false;
					}
				}
			DocumentDetail_Parties_PartyFrom_RemoveAll = true;
			return DocumentDetail_Parties_PartyFrom_RemoveAll;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Parties_Verify_DefaultPartyFromValue(String strDocumentType, String strDefault) {
		boolean DocumentDetail_Parties_Verify_DefaultPartyFromValue = false;
		try {
			String strActualPartyFrom = documentDetailPage.find(By.id("partyFromName0")).getAttribute("value");
			if (strActualPartyFrom.trim().compareTo(strDefault) != 0) {
				logSteps.execution_log("Verification of default Party From value for <" + strDocumentType + "> document - UnSuccessful. Expected Value: <" + strDefault + ">, Actual:<" + strActualPartyFrom
						+ ">");
				DocumentDetail_Parties_Verify_DefaultPartyFromValue = false;
				return false;
			}
			DocumentDetail_Parties_Verify_DefaultPartyFromValue = true;
			return DocumentDetail_Parties_Verify_DefaultPartyFromValue;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentData_EnterData_InternalProcessingNotes(String strAction, String strNotes) {
		boolean DocumentData_EnterData_InternalProcessingNotes = true;
		try {
			switch (strAction.toUpperCase()) {
			case "APPLY":
				documentDataPage.InternalNote_Image.click();
				documentDataPage.NewNote_WebEdit.sendKeys(strNotes);
				documentDataPage.Apply1_WebButton.click();
				if (!documentDataPage.WithNote_Image.isPresent()) {
					logSteps.execution_log("The Internal Processing Notes with notes attached image NOT exist - UnSuccessful");
					DocumentData_EnterData_InternalProcessingNotes = false;
					return false;
				}
				break;
			case "DONOTAPPLY":
				break;
			}
			return DocumentData_EnterData_InternalProcessingNotes;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentData_EnterData_DocumentRemarks(String strAction, String strRemarks) {

		boolean DocumentData_EnterData_DocumentRemarks = true;

		try {

			switch (strAction.toUpperCase()) {

			case "APPLY":

				documentDataPage.WithRemarks_Image.click();

				documentDataPage.NewNote_WebEdit.sendKeys(strRemarks);

				documentDataPage.Apply2_WebButton.click();

				if (!documentDataPage.WithRemarks_Image.isCurrentlyVisible()) {

					// logSteps.execution_log("The Document Remarks with remarks attached image NOT exist - UnSuccessful");

					DocumentData_EnterData_DocumentRemarks = false;

					return false;

				}

				break;

			case "DONOTAPPLY":

				break;

			}

			return DocumentData_EnterData_DocumentRemarks;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean DocumentDetail_PINDetails_EditDescription(String shtName, String intRow, int intIndex) {
		boolean DocumentDetail_PINDetails_EditDescription = false;
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
			String strDescription = GetValueIfValid("Description", shtName, intStart);
			String strLowerMunicipality = GetValueIfValid("LowerMunicipality", shtName, intStart);
			String strUpperMunicipality = GetValueIfValid("UpperMunicipality", shtName, intStart);
			String strDescriptionAction = GetValueIfValid("DescriptionAction", shtName, intStart);
			boolean intRet = false;
			String htmlNew = null;
			String htmlExisting = null;
			String strFunctionName = mainPage.FuncID_WebElement.getText().trim();
			if (strFunctionName.compareTo("Record Historical") == 0) {
				htmlNew = "resulting";
				htmlExisting = "existing";
			} else {
				htmlNew = "newEasement";
				htmlExisting = "easement";
			}
			environmentlib.setProperty("bTriggered", "false");
			pinDetailsPage.Description_WebEdit.sendKeys(strDescription);
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strEasementAction = GetValueIfValid("EasementAction", shtName, iLoop);
				String strEasementIndex = GetValueIfValid("EasementIndex", shtName, iLoop);
				if (!strEasementAction.isEmpty() && !strEasementAction.equals("IGNORE_VALUE")) {
					switch (strEasementAction.toUpperCase()) {
					case "ADDNEW":
					case "ADDEXISTING":
						intRet = DocumentDetail_PINDetails_EditDescription_AddEasement(shtName, iLoop);
						break;
					case "REMOVENEW":
						intRet = DocumentDetail_PINDetails_EditDescription_RemoveEasement(strEasementIndex, htmlNew);
						break;
					case "REMOVEEXISTING":
						intRet = DocumentDetail_PINDetails_EditDescription_RemoveEasement(strEasementIndex, htmlExisting);
						break;
					case "FILLNEW":
						intRet = DocumentDetail_PINDetails_EditDescription_FillEasementData(shtName, iLoop, htmlNew);
						break;
					case "FILLEXISTING":
						intRet = DocumentDetail_PINDetails_EditDescription_FillEasementData(shtName, iLoop, htmlExisting);
						break;
					}
					if (!intRet == true) {
						environmentlib.setProperty("bTriggered", "true");
					}
				}
			}
			pinDetailsPage.LowerMunicipality_WebList.selectByVisibleText(strLowerMunicipality.toUpperCase());
			pinDetailsPage.UpperMunicipality_WebList.selectByVisibleText(strUpperMunicipality.toUpperCase());
			switch (strDescriptionAction.toUpperCase()) {
			case "APPLY":
				pinDetailsPage.Apply_WebButton.click();
				intRet = DocumentDetail_PINDetails_EditDescription_Verify(strDescription, intIndex);
				if (!intRet == true) {
					return false;
				}
				break;
			case "DONOTAPPLY":
				pinDetailsPage.Apply_WebButton.click();
				if (!documentDetailPage.Certify_WebButton.isPresent()) {
					logSteps.execution_log("<Document Detail> page Not displayed after modification of <Description> cancelled - UnSuccessful");
					return false;
				}
				break;
			}
			DocumentDetail_PINDetails_EditDescription = true;
			return DocumentDetail_PINDetails_EditDescription;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PINDetails_EditDescription_RemoveEasement(String strEasementIndex, String htmlPrefix) {
		boolean DocumentDetail_PINDetails_EditDescription_RemoveEasement = false;
		try {
			environmentlib.setProperty("bTriggered", "false");
			int intIndex = 0;
			String strPrefix = null;
			if (NumberUtils.isNumber(strEasementIndex)) {
				intIndex = Integer.parseInt(strEasementIndex) - 1;
				strPrefix = htmlPrefix + "EasementRemove";
				setCheckBoxValue(pinDetailsPage.find(By.id(strPrefix + intIndex)), "ON");
			}
			pinDetailsPage.RemoveSelected_WebButton.click();
			DocumentDetail_PINDetails_EditDescription_RemoveEasement = true;
			return DocumentDetail_PINDetails_EditDescription_RemoveEasement;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PINDetails_EditDescription_AddEasement(String shtName, int intRow) {
		boolean DocumentDetail_PINDetails_EditDescription_AddEasement = false;
		try {

			String strEasementAction = GetValueIfValid("EasementAction", shtName, intRow);
			String strEasement = GetValueIfValid("Easement", shtName, intRow);
			System.out.println(strEasement);
			String strEasementIndex = GetValueIfValid("EasementIndex", shtName, intRow);
			boolean intRet = false;
			String htmlPrefix = null;
			pinDetailsPage.EasementList_WebList.selectByVisibleText(strEasement.toUpperCase());
			switch (strEasementAction.toUpperCase()) {
			case "ADDNEW":
				pinDetailsPage.AddNew_WebButton.click();
				htmlPrefix = "newEasement";
				break;
			case "ADDEXISTING":
				pinDetailsPage.AddExisting_WebButton.click();
				htmlPrefix = "easement";
				break;
			}
			if (NumberUtils.isNumber(strEasementIndex)) {
				intRet = DocumentDetail_PINDetails_EditDescription_FillEasementData(shtName, intRow, htmlPrefix);
				if (!intRet == true) {
					environmentlib.setProperty("bTriggered", "true");
				}
			}
			DocumentDetail_PINDetails_EditDescription_AddEasement = true;
			return DocumentDetail_PINDetails_EditDescription_AddEasement;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PINDetails_EditDescription_FillEasementData(String shtName, int intRow, String htmlPrefix) {
		boolean DocumentDetail_PINDetails_EditDescription_FillEasementData = false;
		try {
			String strEasement = GetValueIfValid("Easement", shtName, intRow);
			String strEasementIndex = GetValueIfValid("EasementIndex", shtName, intRow);
			String strOver = GetValueIfValid("Over", shtName, intRow);
			String strFavorOf = GetValueIfValid("FavorOf", shtName, intRow);
			String strUntil = GetValueIfValid("Until", shtName, intRow);
			String strAsIn = GetValueIfValid("AsIn", shtName, intRow);
			int intIndex = 0;
			if (!NumberUtils.isNumber(strEasementIndex)) {
				logSteps.execution_log("No easement index number provided - UnSuccessful");
				DocumentDetail_PINDetails_EditDescription_FillEasementData = false;
				return false;
			}
			intIndex = Integer.parseInt(strEasementIndex);
			environmentlib.setProperty("bTriggered", "false");
			switch (strEasement.toUpperCase()) {
			case "S/T EASE - EXISTING":
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_1']")).sendKeys(strAsIn); // For Spring change
				break;
			case "S/T EASE - TIME LIMITED":
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_1']")).sendKeys(strOver);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_2']")).sendKeys(strFavorOf);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_3']")).sendKeys(strUntil);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_4]")).sendKeys(strAsIn);
				break;
			case "S/T EASE IN GROSS - NO TIME LIMIT":
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_1']")).sendKeys(strOver);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_2']")).sendKeys(strAsIn);
				break;
			case "S/T EASE - NO TIME LIMIT":
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_1']")).sendKeys(strOver);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_2']")).sendKeys(strFavorOf);
				pinDetailsPage.find(By.name("editDescriptionVO." + htmlPrefix + "VariableClausesMap['" + intIndex + "_3']")).sendKeys(strAsIn);
				break;
			}
			DocumentDetail_PINDetails_EditDescription_FillEasementData = true;
			return DocumentDetail_PINDetails_EditDescription_FillEasementData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_PINDetails_EditDescription_Verify(String strDescription, int intIndex) {
		boolean DocumentDetail_PINDetails_EditDescription_Verify = false;
		try {
			if (!documentDetailPage.PINDetails_Link.isPresent()) {
				logSteps.execution_log("<Document Detail> page Not displayed after <Description> modified - UnSuccessful");
				return false;
			}
			if (!strDescription.isEmpty() && !strDescription.equals("IGNORE_VALUE")) {
				String strCompDescription = null;
				String strFullDescription = documentDetailPage.find(By.id("fullBuiltDescription" + intIndex)).getText();
				if (!strFullDescription.contains(strDescription)) {
					strFullDescription = strFullDescription.replace(" ", "");
					strCompDescription = strDescription.replace(" ", "");
					if (!strFullDescription.contains(strCompDescription.toUpperCase())) {
						logSteps.execution_log("Modified description <" + strDescription.toUpperCase() + "> Not displayed in the <Description> section - UnSuccessful");
						return false;
					}
				}
			}
			DocumentDetail_PINDetails_EditDescription_Verify = true;
			return DocumentDetail_PINDetails_EditDescription_Verify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Certify button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_Certify(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Certify";
			boolean DocumentDetail_Certify = false;
			boolean intRet = false;
			String strExpErrMsg = null;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
				strExpErrMsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			}
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			documentDetailPage.Certify_WebButton.click();
			// JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
			// js.executeScript("arguments[0].click();", mainPage.getDriver().findElement(By.xpath("//input[@value='Certify']")));
			Thread.sleep(15);
			String strErrorMsgs = null;
			if (documentDetailPage.Certify_WebButton.isPresent()) {
				strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				String strUncerDocMsg = null;
				strUncerDocMsg = "61078: This document affects PIN(s) with Prior Uncertified Document(s). Ensure all Prior Document(s) are certified before proceeding.";
				if (strComp(strErrorMsgs, strUncerDocMsg) == 0) {
					/*
					 * if (strExpErrMsg.isEmpty() || strExpErrMsg.equals("IGNORE_VALUE")) { intRet = CertifyIngorePriorUncerDoc(); if (intRet == false) { return false; } }
					 */
				}
			}
			// Verify if the certify confirmation page present
			if (certifyConfirmationPage.CertificationResult_WebTable.isPresent()) {
				/*
				 * Reporter.reportEvent(Status.Passed,strStepName,"<Certification Results> page displayed - Successful"); utility.AddInfo("<Certification Results> page displayed - Successful");
				 */ // Verify the confirmation page
				intRet = certify.VerifyPage_CertificationConfirmation();
				if (intRet == true) {
					DocumentDetail_Certify = true;
				}
				return false;
			}
			if (propertyMaintenancePage.Header_WebElement.isPresent()) {
				String strConfirmationMsg = "Some previous transfer documents affected by this registration are not certified. Only previous certified transfers are displayed.";
				// If Browser("ELRS").Page("PropertyMaintenance").WebElement("PropertyMaintenanceMsg").Exist(1) Then
				// Reporter.ReportEvent micPass, strStepName, "Expected message <"&strConfirmationMsg&"> displayed on the <Property Maintenance> page - Successful"
				// AddMsg strConfirmationMsg
				// AddInfo "Expected message displayed on the <Property Maintenance> page as shown above - Successful"
				if (propertyMaintenancePage.Commit_WebButton.isPresent()) {
					/*
					 * Reporter.reportEvent(Status.Passed,strStepName,"<Property Maintenance> page displayed - Successful"); utility.AddInfo("<Property Maintenance> page displayed - Successful");
					 */DocumentDetail_Certify = true;
				} else {
				}
				return false;
			}
			strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpErrMsg);
			if (intRet == false) {
				DocumentDetail_Certify = false;
			}
			return DocumentDetail_Certify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Certify button on Document Detail page")

	public boolean DocumentDetail_Certify() {

		try {

			String strStepName = null;

			strStepName = "DocumentDetail_Certify";

			boolean DocumentDetail_Certify = false;

			boolean intRet = false;

			String strExpErrMsg = null;

			String strMode = null;

			strMode = mainPage.Mode_WebElement.getAttribute("outertext");

			documentDetailPage.Certify_WebButton.click();

			if (documentDetailPage.PriorUncertifiedDocument_ChechBox.isPresent()) {

				documentDetailPage.PriorUncertifiedDocument_ChechBox.click();

				documentDetailPage.Certify_WebButton.click();

			}

			if (propertyMaintenancePage.Header_WebElement.isPresent()) {

				String strConfirmationMsg = "Some previous transfer documents affected by this registration are not certified. Only previous certified transfers are displayed.";

				if (propertyMaintenancePage.Commit_WebButton.isPresent()) {

					// logSteps.execution_log("<Property Maintenance> page displayed - Successful");

					DocumentDetail_Certify = true;

				}

			}

			if (propertyMaintenancePage.Cancel_WebButton.isPresent()) {

				propertyMaintenancePage.Cancel_WebButton.click();

				Alert confirmationAlert = basePage.getDriver().switchTo().alert();

				confirmationAlert.accept();

			}

			return DocumentDetail_Certify;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean Certify_DocumentViewPopup_Close() {
		boolean Certify_DocumentViewPopup_Close = false;
		try {
			String strStepName = "Certify_DocumentViewPopup_Close";

			// Initialize the flag
			environmentlib.setProperty("bTriggered", "false");
			// Click close button
			documentViewPopupPage.Close_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Click <Close> button on Document View popup - UnSuccessful");
				// utility.AddInfo("Click <Close> button on Document View popup - UnSuccessful");
				return Certify_DocumentViewPopup_Close;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Close> button on Document View popup is clicked");
			// utility.AddInfo("<Close> button on Document View popup is clicked");
			// 2015-07-21/Jenny/Report directly once Close button is clicked
			Certify_DocumentViewPopup_Close = true;
			// 2015-07-21/Jenny/Comment the below codes due to the false fail report in some occasions
			// //Verify the popup is closed
			// If Not Browser("FullCertification_Popup").Exist(5) Then
			// Reporter.ReportEvent micPass, strStepName, "Close <Document View Popup> - Successful"
			// AddInfo "Close <Document View Popup> - Successful"
			// Certify_DocumentViewPopup_Close = True
			// Else
			// Reporter.ReportEvent micFail, strStepName, "Close <Document View Popup> - UnSuccessful"
			// AddInfo "Close <Document View Popup> - UnSuccessful"
			// End If
			return Certify_DocumentViewPopup_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentViewPopup_Close;
		}
	}

	@When("user clicks on Proceed  with Receipt button on Document Detail page")
	public boolean user_click_proceed_button_with_receipt_on_documentdetailpage() {
		boolean DocumentDetail_ProceedWithReceipt = false;
		try {
			documentDetailPage.ProceedWithReceipt_WebButton.click();
			// Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			// String alertText = confirmationAlert.getText();
			// System.out.println("Alert text is " + alertText);
			// confirmationAlert.accept();
			return DocumentDetail_ProceedWithReceipt;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String DocumentDetail_Retrieve_RegNumber() {
		String DocumentDetail_Retrieve_RegNumber = null;
		try {
			String strHeadingText = documentDetailPage.Heading_WebTable.getText();
			System.out.println(strHeadingText);
			String[] arrHeadingText = (strHeadingText).split("Reg No:");
			String strRegNoText = arrHeadingText[1].trim();
			String[] arrRegNoText = (strRegNoText).split("Reg Date/Time");
			String strRegNumber = arrRegNoText[0].trim();
			DocumentDetail_Retrieve_RegNumber = strRegNumber.trim();
			return DocumentDetail_Retrieve_RegNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@When("user verifies object exists on Document Detail page $strObject and $shtName and $intRow")
	public boolean DocumentDetail_VerifyExist(String strObject, String shtName, String intRow) {
		boolean DocumentDetail_VerifyExist = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_VerifyExist";
			boolean intRet = false;
			switch (strObject.toUpperCase()) {
			case "PINCHECKBOX":
				intRet = DocumentDetail_VerifyExist_PINCheckBox();
				break;
			case "CORRECTIONNOTICES":
				intRet = DocumentDetail_VerifyExist_CorrectionNotices(shtName, intRow);
				break;
			case "INTERNALPROCESSINGNOTES":
				intRet = DocumentDetail_VerifyExist_InternalProcessingNotes(shtName, intRow);
				break;
			case "PINDETAILSDESCRIPTION":
				intRet = DocumentDetail_VerifyExist_PINDetails_Description(shtName, intRow);
				break;
			default:
				return false;
			}
			return DocumentDetail_VerifyExist;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_VerifyExist_PINDetails_Description(String shtName, String intRow) {
		boolean DocumentDetail_VerifyExist_PINDetails_Description = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_VerifyExist_CorrectionNotices";
			String strDescription = null;
			// datatableLib.getsheet(shtName).setcurrentRow((Integer.parseInt(intRow)));
			strDescription = GetValueIfValid("Description", shtName, Integer.parseInt(intRow));
			System.out.println(strDescription);
			String strActualDescription = null;

			mainPage.getDriver().findElement(By.xpath("//input[@id='submitEdit0']")).click();
			WaitUtil.waitMSeconds(1000);

			strActualDescription = pINDetailsPage.Description_WebElement.getAttribute("value").trim();
			System.out.println(strActualDescription);
			pINDetailsPage.DoNotApply_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			if (!(strComp(strActualDescription, strDescription.toUpperCase()) == 0)) {
				logSteps.execution_log("Verification of <PIN DetailsDescription> - UnSuccessful. Expected value: <" + strDescription + ">, Actual: <" + strActualDescription + ">");
				return false;
			}
			return DocumentDetail_VerifyExist_PINDetails_Description;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_VerifyExist_InternalProcessingNotes(String shtName, String intRow) {
		boolean DocumentDetail_VerifyExist_InternalProcessingNotes = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_VerifyExist_InternalProcessingNotes";
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
			String strFullNotes = null;
			strFullNotes = documentDataPage.FullNotes_WebEdit.getText();
			environmentlib.setProperty("bTriggered", "false");
			int iLoop = 0;
			String strNotes = null;
			for (iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// datatableLib.getsheet(shtName).setcurrentRow((iLoop));
				strNotes = GetValueIfValid("InternalProcessingNotes", shtName, iLoop);
				if (!(InStr(strFullNotes, strNotes) > 0)) {
					String strTime = null;
					String strTempNotes = null;
					strTime = "<HH:MM>";
					strTempNotes = strNotes;
					if (InStr(strNotes, strTime) > 0) {
						strTempNotes = strTempNotes.replace(strTime, "[0-1][0-9]|2[0-3]:[0-5][0-9]");
					}
					if (InStr(strNotes, "$") > 0) {
						strTempNotes = strTempNotes.replace("$", "/$");
					}
					if (InStr(strTempNotes, ".*") > 0 || InStr(strTempNotes, "[0-1][0-9]|2[0-3]:[0-5][0-9]") > 0 || InStr(strTempNotes, "$") > 0) {
						String strPattern = null;
						String oRegExp = null;
						strPattern = strTempNotes;
						/*
						 * oRegExp = new RegularExpressions(); oRegExp.RegxPattern = strPattern; oRegExp.IgnoreCase = true;
						 */ // Verify the format
						// if (!oRegExp.test(strFullNotes))
						if (!Pattern.compile(strFullNotes, Pattern.CASE_INSENSITIVE).matcher(strPattern).matches()) {
							environmentlib.setProperty("bTriggered", "true");
							/*
							 * Reporter.reportEvent(Status.Failed, strStepName, "<" + strNotes + "> Not present in the notes form - UnSuccessful"); utility.AddInfo("<" + strNotes + "> Not present in the notes form - UnSuccessful");
							 */ } else {
							/*
							 * Reporter.reportEvent(Status.Completed, strStepName, "<" + strNotes + "> present in the notes form - Successful"); utility.AddInfo("<" + strNotes + "> present in the notes form - Successful");
							 */ }
					} else {
						environmentlib.setProperty("bTriggered", "true");
						// Reporter.reportEvent(Status.Failed, strStepName, "<" + strNotes + "> Not present in the notes form - UnSuccessful");
						// utility.AddInfo("<" + strNotes + "> Not present in the notes form - UnSuccessful");
						// }
						// 09-20-2012/Jenny/Verify the format
						// Environment("bTriggered") = True
						// Reporter.ReportEvent micDone, strStepName, "<"&strNotes&"> Not present in the notes form - UnSuccessful"
						// AddInfo "<"&strNotes&"> Not present in the notes form - UnSuccessful"
						// Else
						// Reporter.ReportEvent micDone, strStepName, "<"&strNotes&"> present in the notes form - Successful"
						// AddInfo "<"&strNotes&"> present in the notes form - Successful"
					}
				}
				if (environmentlib.getProperty("bTriggered").equals("true")) {
					/*
					 * Reporter.reportEvent(Status.Failed, strStepName, "Verification of one or more internal notes - UnSuccessful"); utility.AddInfo("Verification of one or more internal notes - UnSuccessful"); utility.AddInfo("Actual Value: <" + strFullNotes + ">");
					 */ return false;
				}
				/*
				 * Reporter.reportEvent(Status.Passed, strStepName, "Verification of one or more internla notes - Successful"); utility.AddInfo("Verification of one or more internal notes - Successful");
				 */ DocumentDetail_VerifyExist_InternalProcessingNotes = true;
				return DocumentDetail_VerifyExist_InternalProcessingNotes;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DocumentDetail_VerifyExist_InternalProcessingNotes;
	}

	@Then("user verifies the existance of Checkboxes in PIN list section on Document Detail page")
	public boolean DocumentDetail_VerifyExist_PINCheckBox() {
		try {
			boolean DocumentDetail_VerifyExist_PINCheckBox = false;
			int intRet = DocumentDetail_TotalTargetPINCount();
			int intPINCount = intRet;
			if (intPINCount > 15) {
				intPINCount = 15;
			}

			if (!documentDetailPage.find(By.name("addRemovePinForm.selectedPinToRemove")).isDisplayed()) {
				logSteps.execution_log("The Checkbox does Not exist in row - UnSuccessful");
				DocumentDetail_VerifyExist_PINCheckBox = false;
			}

			return DocumentDetail_VerifyExist_PINCheckBox;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int DocumentDetail_TotalTargetPINCount() {
		int DocumentDetail_TotalTargetPINCount = 0;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_TotalTargetPINCount";
			if (!(documentDetailPage.DocumentData_Link.getAttribute("class") == "foretab")) {
				documentDetailPage.DocumentData_Link.click();
			}
			String strPINCount = null;
			int intPINCount = 0;
			strPINCount = documentDataPage.TargetPINs_WebElement.getText();
			// intPINCount = Integer.parseInt(strPINCount.trim());
			DocumentDetail_TotalTargetPINCount = Integer.parseInt(strPINCount.trim());
			return DocumentDetail_TotalTargetPINCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean DocumentDetail_VerifyExist_CorrectionNotices(String shtName, String intRow) {
		boolean DocumentDetail_VerifyExist_CorrectionNotices = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_VerifyExist_CorrectionNotices";
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
			int iLoop = 0;
			String strNotice = null;
			WebElement oWebTable = null;
			boolean intRet = false;
			for (iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strNotice = GetValueIfValid("AutoGeneratedNotice", shtName, iLoop);
				intRet = LocateAValueInWebTable(oWebTable, strNotice);
			}
			return DocumentDetail_VerifyExist_CorrectionNotices;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Complete Recording button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_CompleteRecording(String shtName, String intRow) {
		boolean DocumentDetail_CompleteRecording = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_CompleteRecording";
			String strExpectedDocType = DocumentDetail_Retrieve_DocumentType();
			String strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
			}
			documentDetailPage.CompleteRecording_WebButton.click();
			if (!feesTaxesPage.FeesTaxesHeading_WebElement.isEnabled()) {
				String strExpectedMsgs = null;
				String strErrorMsgs = null;
				// datatableLib.getsheet(shtName).setcurrentRow((Integer.parseInt(intRow)));
				strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				if (documentDetailPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							DocumentDetail_CompleteRecording = false;
						}
					} else {
						/*
						 * Reporter.reportEvent(Status.Failed,strStepName,"Page <Document Detail> Not displayed - UnSuccessful"); utility.AddInfo("Page <Document Detail> Not displayed - UnSuccessful");
						 */}
				} else {
					/*
					 * Reporter.reportEvent(Status.Failed,strStepName,"Unknown page is returned - UnSuccessful "); utility.AddInfo("Unknown page is returned - UnSuccessful");
					 */}
				return false;
			}
			/*
			 * int intRowIndex = 0; String strDocType = null; String strRegNumber = null; intRowIndex = getRowWithCellText(feesTaxesPage.DocumentType_WebTable, "Document Type", 1, 1); strDocType = getCellData(feesTaxesPage.DocumentType_WebTable, intRowIndex, 2).trim(); if (!(InStr(strDocType,
			 * strExpectedDocType) > 0)) { return false; } intRowIndex = getRowWithCellText(feesTaxesPage.DocumentType_WebTable, "Registration Number", 1, 1); strRegNumber = getCellData(feesTaxesPage.DocumentType_WebTable, intRowIndex, 2).trim(); if (!(strComp(strRegNumber, strExpectedRegNumber) == 0)) { return
			 * false; }
			 */
			DocumentDetail_CompleteRecording = true;
			return DocumentDetail_CompleteRecording;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user navigates to Parties on Document Detail page")
	public boolean navigate_to_parties() {
		documentDetailPage.Navigate_parties.click();
		return true;
	}

	@When("user enter data for Parties details $PARTIESSHEETNAME and $PARTIESROW")
	public boolean user_enter_data_for_Parties_details(String shtName, String intRow) {
		boolean DocumentDetail_Edit_Parties = false;
		try {
			String strStepName = "DocumentDetail_Edit_Parties";

			String strDocumentType = documentDetailPage.DocumentType_WebElement.getText();
			boolean intRet = false;
			String[] arrDocumentType = strDocumentType.split(":");
			String strDocType = arrDocumentType[1].trim();
			// Verify the default Party From Name for "LR//S CAUTION" , "LR//S Amendment" type of document
			if (strDocType.contains("LR'S")) {
				intRet = DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "LAND REGISTRAR");
				if (intRet == false) {
					return false;
				}
			}
			// Verify the default Party From Name for "Director Of Titles Order" type of document
			if (strDocType.compareTo("DIRECTOR OF TITLES ORDER") == 0) {
				intRet = DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "DIRECTOR OF TITLES");
				if (intRet == false) {
					return false;
				}
			}
			// Check if there are multiple row numbers there
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
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// Enter data based on the provided info
				// Fetch the data
				String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
				// Party From Name(s) Section
				String strPartyFromIndex = GetValueIfValid("PartyFromIndex", shtName, iLoop);
				String strPartyFrom = GetValueIfValid("PartyFrom", shtName, iLoop);
				// 07-10-2012/Jenny/Add PartyFromAction to control the action to be performed
				String strPartyFromAction = GetValueIfValid("PartyFromAction", shtName, iLoop);
				// Party To Section
				String strPartyToIndex = GetValueIfValid("PartyToIndex", shtName, iLoop);
				String strPartyToAction = GetValueIfValid("PartyToAction", shtName, iLoop);
				// ~~~~~Party From Names(s) section~~~~~~~~~~~~~~~~
				// Enter party from name only if party from index is provided
				if (NumberUtils.isNumber(strPartyFromIndex)) {
					int intPartyFromIndex = Integer.parseInt(strPartyFromIndex) - 1;
					switch (strPartyFromAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_Parties_PartyFrom_Add(intPartyFromIndex, strPartyFrom);
						break;
					case "REMOVE":
						intRet = DocumentDetail_Parties_PartyFrom_Remove(intPartyFromIndex);
						break;
					}
					if (!intRet == true) {
						// Reporter.reportEvent(Status.Failed, strStepName, strPartyFromAction + " name to/from <Party From Name(s)> list - UnSuccessful");
						// AddInfo(strPartyFromAction + " name to/from <Party From Name(s)> list - UnSuccessful");
						return false;
					}
				} else {
					if (strPartyFromAction.toUpperCase() == "REMOVEALL") {
						intRet = DocumentDetail_Parties_PartyFrom_RemoveAll();
						if (!intRet == true) {
							// Reporter.reportEvent(Status.Failed, strStepName, "Remove All names from <Party From Name(s):> list - UnSuccessful");
							// AddInfo("Remove All names from <Party From Name(s):> list - UnSuccessful");
							return false;
						}
					}
				}
				// ~~~~~Party To section~~~~~~~~~~~~~~~~
				// Enter party to info only if party to index is provided
				if (NumberUtils.isNumber(strPartyToIndex)) {
					// intPartyToIndex = CInt(strPartyToIndex)-1 //2017-06-16/Jenny/Somehow CInt doesn//t work. No need to convert from String to Integer
					int intPartyToIndex = Integer.parseInt(strPartyToIndex) - 1; // 2017-06-16/Jenny/Add it to replace the above statement
					switch (strPartyToAction.toUpperCase()) {
					case "ADD":
						intRet = DocumentDetail_Parties_PartyTo_Add(shtName, iLoop, intPartyToIndex);
						break;
					case "REMOVE":
						intRet = DocumentDetail_Parties_PartyTo_Remove(intPartyToIndex);
						break;
					}
					if (!intRet == true) {
						// Reporter.reportEvent(Status.Failed, strStepName, strPartyToAction + " name to/from <Party To:> list - UnSuccessful");
						// AddInfo(strPartyFromAction + " name to/from <Party To:> list - UnSuccessful");
						return false;
					}
				} else {
					if (strPartyToAction.toUpperCase() == "REMOVEALL") {
						intRet = DocumentDetail_Parties_PartyTo_RemoveAll();
						if (!intRet == true) {
							// Reporter.reportEvent(Status.Failed, strStepName, "Remove All names from <Party To:> list - UnSuccessful");
							// AddInfo("Remove All names from <Party To:> list - UnSuccessful");
							return false;
						}
					}
				}
			}
			/*
			 * if (environmentlib.getProperty("bTriggered").equals("true")) { // Reporter.reportEvent(Status.Failed, strStepName, "Enter data to <Parties> page - UnSuccessful"); // AddInfo("Enter data to <Parties> page - UnSuccessful"); DocumentDetail_Edit_Parties = false; return false; }
			 */
			// Reporter.reportEvent(Status.Passed, strStepName, "Enter Data to <Parties> page - Successful");
			// AddInfo("Enter Data to <Parties> page - Successful");
			DocumentDetail_Edit_Parties = true;
			return DocumentDetail_Edit_Parties;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Defer_VerifyMessageOrPage() {
		// Object DocumentDetail_Defer_VerifyMessageOrPage = null;
		try {
			// @@ M2S WARNING : Input line number : 3121
			String strStepName = null;
			strStepName = "DocumentDetail_Defer_VerifyMessageOrPage";
			boolean DocumentDetail_Defer_VerifyMessageOrPage = false;
			// @@ M2S WARNING : Input line number : 3126
			String strExpectedMessage = null;
			// @@ M2S WARNING : Input line number : 3126
			String strActualMessage = null;
			strExpectedMessage = "49188: No reserved documents were found in the Work Queue.";
			// Retrieve the actual message from the page
			strActualMessage = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1);
			if (!strActualMessage.isEmpty()) {
				if (!(strComp(strExpectedMessage, strActualMessage.trim()) == 0)) {
					/*
					 * Reporter.reportEvent(Status.Failed, strStepName, "UnExpected error message returned - UnSuccessful"); AddMsg(strActualMessage); AddInfo("Unexpected error message is returned as shown above - UnSuccessful");
					 */ return false;
				} else {
					/*
					 * Reporter.reportEvent(Status.Passed, strStepName, "Expected message is returned - Successful"); AddMsg(strActualMessage); AddInfo("Expected message is returned as shown above - Successful");
					 */ }
			} else {
				if (!documentDetailPage.Defer_WebButton.isPresent()) {
					/*
					 * Reporter.reportEvent(Status.Failed, strStepName, "The application did Not return the next document ready to be certified from the user's queue - UnSuccessful"); AddInfo("The application did Not return the next document ready to be certified from the user's queue - UnSuccessful");
					 */ return false;
				} else {
					/*
					 * Reporter.reportEvent(Status.Passed, strStepName, "The application returns the next document ready to be certified from the user's queue - Successful"); AddInfo("The application returns the next document ready to be certified from the user's queue - Successful");
					 */ }
			}
			DocumentDetail_Defer_VerifyMessageOrPage = true;
			return DocumentDetail_Defer_VerifyMessageOrPage;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean LocateAValueInWebTable(WebElement oWebTable, String strValue) {
		boolean LocateAValueInWebTable = false;
		try {
			String strStepName = "LocateAValueInWebTable";
			LocateAValueInWebTable = false;
			int intRowCount = getRowCount(oWebTable);
			int intColCount = getColumnCount(oWebTable, 1);
			String strCellData = null;
			int iRowIndex = 0;
			int iColIndex = 0;
			for (int iRowLoop = 1; iRowLoop <= intRowCount; iRowLoop++) {
				for (int iColLoop = 1; iColLoop <= intColCount; iColLoop++) {
					strCellData = getCellData(oWebTable, iRowLoop, iColLoop);
					if (strCellData.trim().equalsIgnoreCase(strValue)) {
						iRowIndex = iRowLoop;
						iColIndex = iColLoop;
						// Reporter.reportEvent(Status.Completed, strStepName,
						// "<" + strValue + "> exists in row <" + iRowIndex + "> and column <" + iColIndex + ">");
						// utility.AddInfo(
						// "<" + strValue + "> exists in row <" + iRowIndex + "> and column <" + iColIndex + ">");
						LocateAValueInWebTable = true;
						break;
					}
				}
			}
			return LocateAValueInWebTable;
		} catch (Exception e) {
			e.printStackTrace();
			return LocateAValueInWebTable;
		}
	}

	@When("user clicks Image button on Document Detail page")
	public boolean DocumentDetail_Image() {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Image";
			boolean DocumentDetail_Image = false;
			documentDetailPage.Image_WebButton.click();
			DocumentDetail_Image = true;
			return DocumentDetail_Image;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verifies error message on documents details page")
	public boolean user_verify_error_message() {
		String expErrormsg = "66000: Document image viewing is not available, please try again later.";
		String actualErrorMsg = documentDetailPage.ErrorMsg_WebTable.getText().trim();
		if (actualErrorMsg.contains(expErrormsg)) {
			// logSteps.execution_log("Error message verified " + actualErrorMsg);
			return true;
		}
		return false;
	}

	@When("user Cancel document registration on the Document Detail page")
	public boolean DocumentDetail_Cancel() {
		boolean DocumentDetail_Cancel = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Cancel";
			documentDetailPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			DocumentDetail_Cancel = true;
			return DocumentDetail_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Cancel on the Cancel popup on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_CancelCancel(String shtName, String intRow) {
		try {
			boolean DocumentDetail_CancelCancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
			}
			String strPreActiveTab = null;
			// strPreActiveTab = CheckDocumentDetailActiveTab();
			documentDetailPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "Cancel";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			String strActiveTab = null;
			// strActiveTab = CheckDocumentDetailActiveTab();
			DocumentDetail_CancelCancel = true;
			return DocumentDetail_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Cancel on the Cancel popup on Document Detail page")
	public boolean DocumentDetail_CancelCancel() {
		try {
			boolean DocumentDetail_CancelCancel = false;
			boolean intRet = false;
			String strPreActiveTab = null;
			// strPreActiveTab = CheckDocumentDetailActiveTab();
			documentDetailPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "Cancel";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			String strActiveTab = null;
			// trActiveTab = CheckDocumentDetailActiveTab();
			DocumentDetail_CancelCancel = true;
			return DocumentDetail_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels document registration on the Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_Cancel(String shtName, String intRow) {
		boolean DocumentDetail_Cancel = false;
		try {
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
			}
			documentDetailPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "OK";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);

			intRet = VerifyPage("Main Menu");
			DocumentDetail_Cancel = true;
			return DocumentDetail_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Defer button on Document Detail page to defer a document certification $INTERNALNOTESSHEETNAME and $INTERNALNOTESROW")
	public boolean DocumentDetail_Defer(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Defer";
			boolean DocumentDetail_Defer = false;
			if (intRow.isEmpty()) {
				return false;
			}
			String strExpectedRegNumber = null;
			strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();
			WaitUtil.waitMSeconds(2000);
			documentDetailPage.Defer_WebButton.click();
			String strInternalNotes = null;
			strInternalNotes = GetValueIfValid("InternalProcessingNotes", shtName, Integer.parseInt(intRow));
			deferCertificationPage.InternalProcessingNotes_WebEdit.sendKeys(strInternalNotes);
			deferCertificationPage.Commit_WebButton.click();
			boolean intRet = false;
			intRet = DocumentDetail_Defer_VerifyMessageOrPage();
			if (intRet == false) {
				return false;
			}
			intRet = elrsCommonSteps.user_navigates_to("ViewWorkQ");
			if (intRet == false) {
				return false;
			}
			viewWorkQPage.ProcessState_WebList.selectByValue("Deferred");
			viewWorkQPage.SubmitQuery_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				return false;
			}
			WebElement oWorkQList = null;
			intRet = LocateAValueInWebTable(oWorkQList, strExpectedRegNumber);
			if (intRet == false) {
				return false;
			}
			DocumentDetail_Defer = true;
			return DocumentDetail_Defer;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on defer button on document detail to defer a document certification $shtName and $intRow")
	public boolean DocumentDetail_Defers(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Defer";
			boolean DocumentDetail_Defer = false;
			if (intRow.isEmpty()) {
				return false;
			}
			String strExpectedRegNumber = null;
			strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();
			WaitUtil.waitMSeconds(2000);
			documentDetailPage.Defer_WebButton.click();
			String strInternalNotes = null;
			strInternalNotes = GetValueIfValid("InternalProcessingNotes", shtName, Integer.parseInt(intRow));
			deferCertificationPage.InternalProcessingNotes_WebEdit.sendKeys(strInternalNotes);
			deferCertificationPage.Commit_WebButton.click();
			boolean intRet = false;
			intRet = DocumentDetail_Defer_VerifyMessageOrPage();
			if (intRet == false) {
				return false;
			}
			intRet = elrsCommonSteps.user_navigates_to("ViewWorkQ");
			if (intRet == false) {
				return false;
			}
			viewWorkQPage.ProcessState_WebList.selectByValue("Deferred");
			viewWorkQPage.SubmitQuery_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				return false;
			}
			WebElement oWorkQList = null;
			intRet = LocateAValueInWebTable(oWorkQList, strExpectedRegNumber);
			if (intRet == false) {
				return false;
			}
			DocumentDetail_Defer = true;
			return DocumentDetail_Defer;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Add PIN button and verify the page count change on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_AddPIN(String shtName, String intRow) {
		try {
			boolean DocumentDetail_AddPIN = false;
			int intPrePageCount = 0;
			intPrePageCount = DocumentDetail_PageCount();
			int intRet = 0;
			int intPrePINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			intPrePINCount = intRet;
			DocumentDetail_AddPIN_EnterData(shtName, intRow);
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			int intCurPINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			intCurPINCount = intRet;
			int intCount = 0;
			intCount = intCurPINCount - intPrePINCount;
			if (!(intCount == 1)) {
				logSteps.execution_log("Verification of the <Total Parget PIN(s)> after Add PIN button clicked - UnSuccessful");
				return false;
			}
			int intCurPageCount = 0;
			int intPageChange = 0;
			intCurPageCount = DocumentDetail_PageCount();
			intPageChange = intCurPageCount - intPrePageCount;
			if (!(intPrePINCount > 15)) {
				if (intCurPINCount > 15) {
					if (intPageChange == 1) {
						logSteps.execution_log("Verification of the page recalculation - Successful");
						DocumentDetail_AddPIN = true;
					} else {
						logSteps.execution_log("Verification of the page recalculation - UnSuccessful");
						DocumentDetail_AddPIN = false;
					}
				} else {
					if (intPageChange == 1) {
						logSteps.execution_log("Verification of the page recalculation - UnSuccessful");
						DocumentDetail_AddPIN = false;
					} else {
						logSteps.execution_log("Verification of the page recalculation - Successful");
						DocumentDetail_AddPIN = true;
					}
				}
			}
			return DocumentDetail_AddPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int DocumentDetail_PageCount() {
		int DocumentDetail_PageCount = 0;
		try {
			String strPaging = null;
			String[] arrPaging = null;
			String strPageCount = null;
			strPaging = documentDetailPage.Paging_WebTable.getText();
			arrPaging = (strPaging.trim()).split("of");
			strPageCount = arrPaging[1].trim();
			DocumentDetail_PageCount = Integer.parseInt(strPageCount);
			return DocumentDetail_PageCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean DocumentDetail_AddPIN_EnterData(String shtName, String intRow) {
		boolean DocumentDetail_AddPIN_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_AddPIN_EnterData";
			String strTargetPIN = null;
			String strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPINFrom", shtName, Integer.parseInt(intRow));
			String oPage = null;
			documentDetailPage.AddBlock_WebEdit.sendKeys(strTargetBlock);
			documentDetailPage.AddPIN_WebEdit.sendKeys(strTargetPIN);
			documentDetailPage.AddPIN_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			DocumentDetail_AddPIN_EnterData = true;
			return DocumentDetail_AddPIN_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on PIN in PIN list and verify the header on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_ClickAndVerify_PIN(String shtName, String intRow) {
		boolean DocumentDetail_ClickAndVerify_PIN = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_ClickAndVerify_PIN";
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strEasementBlock = null;
			String strEasementPINFrom = null;
			String strTargetPINType = null;
			String strPIN = null;
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPINFrom", shtName, Integer.parseInt(intRow));
			strEasementBlock = GetValueIfValid("EasementBlock", shtName, Integer.parseInt(intRow));
			strEasementPINFrom = GetValueIfValid("EasementPINFrom", shtName, Integer.parseInt(intRow));
			strTargetPINType = GetValueIfValid("TargetPINType", shtName, Integer.parseInt(intRow));
			if (strTargetPINType.toUpperCase() == "EASEMENT") {
				strPIN = strEasementBlock + "-" + strEasementPINFrom;
			} else {
				strPIN = strTargetBlock + "-" + strTargetPIN;
			}
			String oDesc = null;
			int intLinkCount = 0;
			List<WebElement> oLink = mainPage.getDriver().findElements(By.xpath("//TABLE[@id='pinLinks']"));
			intLinkCount = oLink.size();
			if (intLinkCount == 0) {
				oDesc = null;
				return false;
			}
			mainPage.getDriver().findElement(By.xpath("//TABLE[@id='pinLinks']//a[1]")).click();
			// documentDetailPage.DocPINList_WebTable.find(By.linkText(oDesc)).click();
			oDesc = null;
			WebDriver strPropertyInfo = null;
			strPropertyInfo = documentDetailPage.getDriver().switchTo().frame(documentDetailPage.DocumentInfo_WebTable);
			if (!(InStr(strPropertyInfo, strPIN) > 0)) {
				DocumentDetail_ClickAndVerify_PIN = false;
			}
			mainPage.getDriver().switchTo().defaultContent();
			mainPage.getDriver().switchTo().frame(0);
			DocumentDetail_ClickAndVerify_PIN = true;
			return DocumentDetail_ClickAndVerify_PIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Remove PIN(s) button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_RemovePIN(String shtName, String intRow) {
		boolean DocumentDetail_RemovePIN = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_RemovePIN";
			int intPrePageCount = 0;
			// intPrePageCount = DocumentDetail_PageCount();
			int intRet = 0;
			int intPrePINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			intPrePINCount = intRet;
			// Fetch valid data
			String strTargetPINIndex = null;
			String strCheckBox = null;
			String strExpectedMsgs = null;
			strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, Integer.parseInt(intRow));
			strCheckBox = GetValueIfValid("CheckBox", shtName, Integer.parseInt(intRow)).toUpperCase();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			if (InStr(strTargetPINIndex, ",") > 0) {
				String[] arrPINIndex = strTargetPINIndex.split(",");
				for (int i = 0; i <= arrPINIndex.length - 1; i++) {
					int index = Integer.parseInt(arrPINIndex[i]) - 1;
					setCheckBoxValue(documentDetailPage.find(By.xpath("//input[@name='addRemovePinForm.selectedPinToRemove'" + "and @value=" + index + "]")), strCheckBox);
				}
			} else {
				if (NumberUtils.isNumber(strTargetPINIndex)) {
					int index = Integer.parseInt(strTargetPINIndex) - 1;
					setCheckBoxValue(documentDetailPage.find(By.xpath("//input[@name='addRemovePinForm.selectedPinToRemove'" + "and @value=" + index + "]")), strCheckBox);
				}
			}
			documentDetailPage.RemovePIN_WebButton.click();
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				DocumentDetail_RemovePIN = false;
				VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				return false;
			}
			// Define and retrieve the Total Target PIN(s) count under Document Data after clicking Add PIN
			int intCurPINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			if (intRet == 0) {
				DocumentDetail_RemovePIN = false;
				return false;
			}
			intCurPINCount = intRet;
			int intCurPageCount = 0;
			int intPageChange = 0;
			intCurPageCount = DocumentDetail_PageCount();
			intPageChange = intPrePageCount - intCurPageCount;
			if (intPrePINCount > 15) {
				if (!(intCurPINCount > 15)) {
					if (intPageChange == 1) {
						DocumentDetail_RemovePIN = true;
					} else {
						DocumentDetail_RemovePIN = false;
					}
				} else {
					if (intPageChange == 1) {
						DocumentDetail_RemovePIN = false;
					} else {
						DocumentDetail_RemovePIN = true;
					}
				}
			}
			return DocumentDetail_RemovePIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Proceed with Receipt button on DocumentDetail page")
	public boolean DocumentDetail_ProceedWithReceipt() {
		boolean DocumentDetail_ProceedWithReceipt = false;
		try {
			documentDetailPage.ProceedWithReceipt_WebButton.click();
			DocumentDetail_ProceedWithReceipt = true;
			return DocumentDetail_ProceedWithReceipt;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks DocumentData tab in documentdetail page")
	public void documentdatatab() {
		mainPage.getDriver().findElement(By.xpath("//a[@id='documentDataTab']")).click();
	}

	@When("user enter page number and click Go to Page button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_GoToPage(String shtName, String intRow) {
		boolean DocumentDetail_GoToPage = false;
		try {
			int intPageCount = DocumentDetail_PageCount();
			int intPrePageIndex = DocumentDetail_CurrentPageIndex();
			String strPageNumber = null;
			strPageNumber = GetValueIfValid("PageNumber", shtName, Integer.parseInt(intRow));
			if (!strPageNumber.isEmpty() && !strPageNumber.equals("IGNORE_VALUE")) {
				documentDetailPage.PageValue_WebEdit.clear();
				documentDetailPage.PageValue_WebEdit.sendKeys(strPageNumber);
				logSteps.execution_log("Page number <" + strPageNumber + "> is entered");
			}
			documentDetailPage.GotoPage_WebButton.click();
			WaitUtil.waitMSeconds(500);
			int intCurPageIndex = DocumentDetail_CurrentPageIndex();
			if (Integer.parseInt(strPageNumber) > intPageCount) {
				if (intCurPageIndex == intPrePageIndex) {
					logSteps.execution_log("Verification of the page - Successful");
					DocumentDetail_GoToPage = true;
				} else {
					logSteps.execution_log("Verification of the page - UnSuccessful");
					DocumentDetail_GoToPage = false;
				}
				return false;
			}
			if (!(intCurPageIndex == Integer.parseInt(strPageNumber))) {
				logSteps.execution_log("Verification of the page - UnSuccessful");
				DocumentDetail_GoToPage = false;
				return false;
			}
			logSteps.execution_log("Verification of the page - Successful");
			DocumentDetail_GoToPage = true;
			return DocumentDetail_GoToPage;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int DocumentDetail_CurrentPageIndex() {
		int DocumentDetail_CurrentPageIndex = 0;
		try {
			String strPaging = null;
			String[] arrPaging = null;
			String strPageIndex = null;
			strPaging = documentDetailPage.Paging_WebTable.getText();
			arrPaging = (strPaging.trim()).split("of");
			strPageIndex = arrPaging[0].trim();
			DocumentDetail_CurrentPageIndex = Integer.parseInt(strPageIndex);
			return DocumentDetail_CurrentPageIndex;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean DocumentDetail_PINList_Paging_Verify(String strAction, String intCurrent, String intPageChange, String intCount) {
		boolean DocumentDetail_PINList_Paging_Verify = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_PINList_Paging_Verify";
			DocumentDetail_PINList_Paging_Verify = true;
			switch (strAction) {
			case "First":
				if (!(intCurrent.equals("1"))) {
					DocumentDetail_PINList_Paging_Verify = false;
				}
				break;
			case "Previous":
				if (!(intPageChange.equals("-1"))) {
					DocumentDetail_PINList_Paging_Verify = false;
				}
				break;
			case "Next":
				if (!(intPageChange.equals("1"))) {
					DocumentDetail_PINList_Paging_Verify = false;
				}
				break;
			case "Last":
				if (!(intCurrent.equals(intCount))) {
					DocumentDetail_PINList_Paging_Verify = false;
				}
				break;
			}
			return DocumentDetail_PINList_Paging_Verify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user navigating to specific page in PIN List section on Document Detail page $strAction and $value")
	public boolean DocumentDetail_PINList_Paging(String strAction, String value) {
		boolean DocumentDetail_PINList_Paging = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_PINList_Paging";
			int intPageCount = 0;
			int intPrePageIndex = 0;
			intPageCount = DocumentDetail_PageCount();
			intPrePageIndex = DocumentDetail_CurrentPageIndex();
			mainPage.getDriver().findElement(By.xpath("//*[contains(@value,'" + value + "')]")).click();
			logSteps.execution_log("<" + strAction + "> button is clicked");
			int intCurPageIndex = 0;
			int intPageChange = 0;
			intCurPageIndex = DocumentDetail_CurrentPageIndex();
			intPageChange = intCurPageIndex - intPrePageIndex;
			boolean intRet = false;
			intRet = DocumentDetail_PINList_Paging_Verify(strAction, String.valueOf(intCurPageIndex), String.valueOf(intPageChange), String.valueOf(intPageCount));
			if (intRet == false) {
				logSteps.execution_log("Verification of the page navigation - UnSuccessful");
				DocumentDetail_PINList_Paging = false;
				return false;
			}
			logSteps.execution_log("Verification of the page navigation - Successful");
			DocumentDetail_PINList_Paging = true;
			return DocumentDetail_PINList_Paging;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel document registration on the Document Detail page without data entry")
	public boolean user_clicks_Cancel_ok_the_Cancelpopup() {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_CancelCancel";
			boolean DocumentDetail_CancelCancel = false;
			boolean intRet = false;
			String strPreActiveTab = null;
			// strPreActiveTab = CheckDocumentDetailActiveTab();
			documentDetailPage.Cancel_WebButton.click();
			Alert a = mainPage.getDriver().switchTo().alert();
			a.accept();

			// String strAction = null;
			// strAction = "Cancel";
			// boolean intRet = false;
			// if (intRet == false) {
			// return false;
			// }
			// String strActiveTab = null;
			// strActiveTab = CheckDocumentDetailActiveTab();
			// if (!(strComp(strPreActiveTab, strActiveTab) == 0)) {
			// }
			DocumentDetail_CancelCancel = true;
			return DocumentDetail_CancelCancel;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verifies the register summary view section on Document Detail page $strType and $shtName and $intRow")
	public boolean DocumentDetail_Verify_SummaryView(String strType, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView";
			boolean DocumentDetail_Verify_SummaryView = true;
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strPINType = null;
			String strManualLRI = null;
			String strManualNDI = null;
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPINFrom", shtName, Integer.parseInt(intRow));
			strPINType = GetValueIfValid("TargetPINType", shtName, Integer.parseInt(intRow));
			strManualLRI = GetValueIfValid("ManualLRI", shtName, Integer.parseInt(intRow));
			strManualNDI = GetValueIfValid("ManualNDI", shtName, Integer.parseInt(intRow));
			String strEasementBlock = null;
			String strEasementPIN = null;
			String strEasementPINIndex = null;
			strEasementBlock = GetValueIfValid("EasementBlock", shtName, Integer.parseInt(intRow));
			strEasementPIN = GetValueIfValid("EasementPINFrom", shtName, Integer.parseInt(intRow));
			strEasementPINIndex = GetValueIfValid("EasementPINIndex", shtName, Integer.parseInt(intRow));
			String strHWY = null;
			String strTCPL = null;
			String strLastActiveRegistration = null;
			strHWY = GetValueIfValid("HWY", shtName, Integer.parseInt(intRow));
			strTCPL = GetValueIfValid("TCPL", shtName, Integer.parseInt(intRow));
			strLastActiveRegistration = GetValueIfValid("LastActiveRegistration", shtName, Integer.parseInt(intRow));
			String strPropertyIdentifier = null;
			String strPIN = null;
			String strPropertyInfo = null;
			boolean intRet = false;

			if (strType.toUpperCase() == "EASEMENT") {
				strPINType = "LT";
				strPIN = strEasementBlock + "-" + strEasementPIN;
			} else {
				strPIN = strTargetBlock + "-" + strTargetPIN;
			}
			switch (strType.toUpperCase()) {
			case "LANDTITLE":
			case "REGISTRY":
				strPropertyIdentifier = strTargetBlock + "-" + strTargetPIN + " (" + strPINType.toUpperCase() + ")";
				break;
			case "EASEMENT":
				strPropertyIdentifier = strEasementBlock + "-" + strEasementPIN + " (" + strPINType.toUpperCase() + ")";
				break;
			case "HWY":
				strPropertyIdentifier = "Highways Register";
				break;
			case "TCPL":
				strPropertyIdentifier = "TransCanada Pipeline";
				break;
			default:
				break;
			}
			// String strManualType = null;
			String strManualType = "LRI";
			if (strManualLRI.toUpperCase() == "YES" || strManualLRI.toUpperCase() == "Y") {
				// || strManualLRI.toUpperCase() == "ON"
				strManualLRI = "Yes";
			} else

			{
				strManualLRI = "No";
			}
			intRet = DocumentDetail_Verify_SummaryView_ManualLRIorNDI(strPropertyInfo, strManualType, strManualLRI);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}

			DocumentDetail_Verify_SummaryView = false;
			// String strPropertyInfo = null;

			// strPropertyInfo=getDriver().switchToFrame("Frame")framePage.PropertyInfo_webtable.getAttribute("text");
			//
			// strPropertyInfo=documentDetailPage.getDriver().switchTo().frame(documentDetailPage.DocumentInfo_WebTable.getAttribute("text"));

			// Verify the existance of the property identifier
			intRet = DocumentDetail_Verify_SummaryView_PropertyIdentifier(strPropertyInfo, strPropertyIdentifier, strPIN, strType);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			// Verify Cautionary/Uncertified in header
			// if (!(InStr(strPropertyInfo, "Cautionary/Uncertified") > 0)) {
			// DocumentDetail_Verify_SummaryView = false;
			// return false;

			// String strManualType = null;
			strManualType = "LRI";
			if (strManualLRI.toUpperCase() == "YES" || strManualLRI.toUpperCase() == "Y") {
				// || strManualLRI.toUpperCase() == "ON"
				strManualLRI = "Yes";
			} else

			{
				strManualLRI = "No";
			}
			intRet = DocumentDetail_Verify_SummaryView_ManualLRIorNDI(strPropertyInfo, strManualType, strManualLRI);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			strManualType = "NDI";
			if (strManualNDI.toUpperCase() == "YES" || strManualNDI.toUpperCase() == "Y") {
				// || strManualNDI.toUpperCase() == "ON"
				strManualNDI = "Yes";
			} else {
				strManualNDI = "No";
			}
			intRet = DocumentDetail_Verify_SummaryView_ManualLRIorNDI(strPropertyInfo, strManualType, strManualNDI);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			// Verify Cautionary/Undertified documents in frame
			// intRet = DocumentDetail_Verify_SummaryView_DocumentInfo();
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			intRet = DocumentDetail_Verify_SummaryView_LastActiveRegistration(strPropertyInfo, strType);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			// // Verify Description if not Easement PIN. EasementPIN verifies the Description through PIN Details tab
			if (strType.toUpperCase() == "EASEMENT") {
				intRet = DocumentDetail_Verify_PINDetails_Easement(strEasementPINIndex);
			} else {
				intRet = DocumentDetail_Verify_SummaryView_Description(strType);
			}
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			intRet = DocumentDetail_Verify_SummaryView_EstateQualifier(strPropertyInfo, strType);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			intRet = DocumentDetail_Verify_SummaryView_Owners(strType);
			if (intRet == false) {
				DocumentDetail_Verify_SummaryView = false;
				return false;
			}
			return DocumentDetail_Verify_SummaryView;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_PropertyIdentifier(String strPropertyInfo, String strPropertyIdentifier, String strPIN, String strPINType) {
		// Object DocumentDetail_Verify_SummaryView_PropertyIdentifier = null;
		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_PropertyIdentifier";
			boolean DocumentDetail_Verify_SummaryView_PropertyIdentifier = true;

			boolean intRet = false;
			if (strPINType.toUpperCase() == "LANDTITLE" || strPINType.toUpperCase() == "REGISTRY" || strPINType.toUpperCase() == "EASEMENT") {
				intRet = DocumentDetail_Verify_SummaryView_PINLink(strPIN);
			}
			if (intRet == false) {

				return false;
			}

			return DocumentDetail_Verify_SummaryView_PropertyIdentifier;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_PINLink(String strProperty) {
		boolean DocumentDetail_Verify_SummaryView_PINLink = false;
		try {

			String oDesc = null;

			boolean intLinkCount = false;

			oDesc = null;
			return DocumentDetail_Verify_SummaryView_PINLink;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_EstateQualifier(String strPropertyInfo, String strPINType) {
		// boolean DocumentDetail_Verify_SummaryView_EstateQualifier = null;
		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_EstateQualifier";
			boolean DocumentDetail_Verify_SummaryView_EstateQualifier = true;

			String strEstateQualifier = null;
			strEstateQualifier = "Estate/Qualifier:";
			// if (!(InStr(strPropertyInfo, strEstateQualifier) > 0)) {
			if (!(strPINType.toUpperCase() == "LANDTITLE")) {

			} else {
				if (strPINType.toUpperCase() == "LANDTITLE" || strPINType.toUpperCase() == "EASEMENT") {

				}
			}
			return DocumentDetail_Verify_SummaryView_EstateQualifier;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_ManualLRIorNDI(String strPropertyInfo, String strManualType, String strValue) {

		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_ManualLRIorNDI";
			boolean DocumentDetail_Verify_SummaryView_ManualLRIorNDI = true;

			String strElementName = null;

			String strElementValue = null;
			switch (strManualType.toUpperCase()) {
			case "LRI":
				// strElement = "ManualLRI"
				strElementName = "Manual LRI:";
				strElementValue = "LRIValue";
				break;
			case "NDI":
				// strElement = "ManualNDI"
				strElementName = "Manual NDI:";
				strElementValue = "NDIValue";
				break;
			default:

				break;
			}

			String strExpectedValue = null;
			strExpectedValue = strElementName + strValue;

			if (strValue == "Yes") {

				String strOuterHtml = null;

				String strStyle1 = null;

				String strStyle2 = null;
				// strOuterHtml = documentDetailPage.strElementValue_webelement.getAttribute("outerhtml");
				strStyle1 = "COLOR: mintcream";
				strStyle2 = "COLOR: red";
				if (InStr(strOuterHtml, strStyle1) > 0 || InStr(strOuterHtml, strStyle2) > 0) {

				}
			}
			return DocumentDetail_Verify_SummaryView_ManualLRIorNDI;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_LastActiveRegistration(String strPropertyInfo, String strPINType) {
		// Object DocumentDetail_Verify_SummaryView_LastActiveRegistration = null;
		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_LastActiveRegistration";
			boolean DocumentDetail_Verify_SummaryView_LastActiveRegistration = true;

			String strLastActiveReg = null;
			strLastActiveReg = "Last Active Registration:";

			return DocumentDetail_Verify_SummaryView_LastActiveRegistration;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_Description(String strPINType) {

		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_Description";
			boolean DocumentDetail_Verify_SummaryView_Description = true;
			if (!documentDetailPage.Description_WebElement.isPresent()) {
				if (strPINType.toUpperCase() == "HWY" || strPINType.toUpperCase() == "TCPL") {

					return false;
				}
			} else {
				if (!(strPINType.toUpperCase() == "HWY") && (!(strPINType.toUpperCase() == "TCPL"))) {

					return false;
				}
			}
			return DocumentDetail_Verify_SummaryView_Description;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Verify_SummaryView_Owners(String strPINType) {

		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_Owners";
			boolean DocumentDetail_Verify_SummaryView_Owners = true;

			if (!documentDetailPage.Owners_WebTable.isPresent()) {
				if ((!(strPINType.toUpperCase() == "LANDTITLE")) && (!(strPINType.toUpperCase() == "EASEMENT"))) {

				}
				return false;
			}
			// Owners exists
			if ((!(strPINType.toUpperCase() == "LANDTITLE")) && (!(strPINType.toUpperCase() == "EASEMENT"))) {

				return false;
			}
			// 2532
			String strColNames = null;
			strColNames = documentDetailPage.Owners_WebTable.getAttribute("column names");
			// Verify Owners displays
			if (!(InStr(strColNames, "Owners") > 0)) {

				return false;
			}
			// Verify Capacity displays
			if (!(InStr(strColNames, "Capacity") > 0)) {

				return false;
			}
			// Verify Share displays
			if (!(InStr(strColNames, "Share") > 0)) {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean DocumentDetail_Verify_SummaryView_DocumentInfo() {
		// Object DocumentDetail_Verify_SummaryView_DocumentInfo = null;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Verify_SummaryView_DocumentInfo";

			boolean DocumentDetail_Verify_SummaryView_DocumentInfo = true;

			if (!documentDetailPage.DocumentInfo_WebTable.isPresent()) {

				return false;
			}

			String strDocumentInfo = null;
			strDocumentInfo = documentDetailPage.DocumentInfo_WebTable.getAttribute("column names");

			String strPattern = null;

			String oRegExp = null;
			strPattern = "Cautionary and//or Uncertified Documents /(.*/)";

			// return false;

			// Verify the existance of Inst. Type
			// if (!(InStr(strDocumentInfo, "Inst. Type") > 0)) {
			//
			// return false;
			// }
			// // Verify the existance of Date
			// if (!(InStr(strDocumentInfo, "Date") > 0)) {
			//
			// return false;
			// }
			// // Verify the existance of Status
			// if (!(InStr(strDocumentInfo, "Status") > 0)) {
			//
			// return false;
			// }

			// reportEvent(Status.Passed, strStepName, "<Cautionary and/or Uncertified Documents>, <Inst. Type>, <Date>, <Status> Exist - Successful"); AddInfo("<Cautionary and/or Uncertified Documents>, <Inst. Type>, <Date>, <Status> Exist - Successful");
			// return DocumentDetail_Verify_SummaryView_DocumentInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean DocumentDetail_Verify_PINDetails_Easement(String intPINIndex) {

		try {

			String strStepName = null;
			strStepName = "DocumentDetail_Verify_PINDetails_Easement";
			boolean DocumentDetail_Verify_PINDetails_Easement = false;

			boolean intRet = false;

			intRet = DocumentDetail_Navigate_To_Tab("PINDetails");
			if (intRet == false) {

			}

			return DocumentDetail_Verify_PINDetails_Easement;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Return for Correction button on Document Detail page $INTERNALNOTESSHEEYNAME1 and $INTERNALNOTESROW2")
	public boolean DocumentDetail_DeferOrReturnForCorrection(String shtName, String intRow) {
		// Object DocumentDetail_DeferOrReturnForCorrection=null;
		try {
			// @@ M2S WARNING : Input line number : 3243
			String strStepName = null;
			strStepName = "DocumentDetail_DeferOrReturnForCorrection";
			boolean DocumentDetail_DeferOrReturnForCorrection = false;
			// Data or error message has to be provided
			if (intRow.isEmpty()) {
				/*
				 * Reporter.reportEvent(Status.Failed,strStepName,"The data input can NOT be empty - UnSuccessful"); AddInfo("The data input can NOT be empty - UnSuccessful");
				 */return false;
			}
			// Call function to retrieve the registration number
			// @@ M2S WARNING : Input line number : 3256
			String strExpectedRegNumber = "";
			// strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();

			// Click Defer button
			documentDetailPage.ReturnForCorrection_WebButton.click();
			/*
			 * if (environmentlib.getProperty("bTriggered").equals("true")) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"Click <"+strAction+"> button  - UnSuccessful"); AddInfo("Click <"+strAction+"> button  - UnSuccessful"); return false; }
			 */
			// AddInfo("<"+strAction+"> button is clicked");
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Integer.parseInt(intRow)));
			// Fetch data
			// @@ M2S WARNING : Input line number : 3275
			String strInternalNotes = null;
			strInternalNotes = GetValueIfValid("InternalProcessingNotes", shtName, Integer.parseInt(intRow));
			// Enter data and click button
			// Browser("ELRS").Page("DeferOrCorrection").WebEdit("InternalProcessingNotes").sendKeys(strInternalNotes);
			deferOrCorrectionPage.InternalProcessingNotes_WebEdit.sendKeys("strInternalNotes");
			deferOrCorrectionPage.Commit_WebButton.click();
			// .getWebElement();
			/*
			 * if (environmentlib.getProperty("bTriggered").equals("true")) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"Enter/Submit <Internal Processing Notes> - UnSuccessful"); AddInfo("Enter/Submit <Internal Processing Notes> - UnSuccessful"); return false; }
			 */
			/*
			 * AddInfo("<Internal Processing Notes>: "+strInternalNotes); AddInfo("<Commit> button is clicked");
			 */ // Verify the message or page returned after Commit button is clicked
			// @@ M2S WARNING : Input line number : 3293
			boolean intRet = false;
			String strAction = "RETURNFORCORRECTION";
			// *********10-15-2014/Jenny/Comment out the following block as workflow for Defer, Return for Correction changed in 2014-R1 release*****
			// intRet = DocumentDetail_DeferOrCorrection_VerifyMessageOrPage(strAction)
			// If intRet = False Then
			// Exit Function
			// End If
			// ********************Block End ******************************************************************************************************************************
			// **********10-15-2014/Jenny/Add the following block for 2014-R1 release*****************************************
			// Verify if the confirmation page present
			if (certifyConfirmationPage.Confirmation_WebElement.isPresent()) {
				/*
				 * Reporter.reportEvent(Status.Passed,strStepName,"<Confirmation> page displayed - Successful"); AddInfo("<Confirmation> page displayed - Successful");
				 */ // Verify the confirmation page
				// @@ M2S WARNING : Input line number : 3307
				String strActionMsg = "RETURNFORCORRECTION";
				switch (strAction.toUpperCase()) {
				case "DEFER":
					strActionMsg = "Deferred";
					break;
				case "RETURNFORCORRECTION":
					strActionMsg = "Returned for Correction";
					break;
				default:
					/*
					 * Reporter.reportEvent(Status.Failed,strStepName,"Unknown action <"+strAction+"> - UnSuccessful"); AddInfo("Unknown action <"+strAction+"> - UnSuccessful");
					 */return false;
				// break;
				}
				// intRet = VerifyPage_Confirmation_DeferReturnPass(strActionMsg, strExpectedRegNumber);
				if (intRet == false) {
					return false;
				}
				if (intRet == false) {
					DocumentDetail_DeferOrReturnForCorrection = false;
				}
			}
			// ****************************************************************************************************************************
			// Navigate to View Work Queue(s)
			// intRet = ELRS_Navigate_To_Menu("ViewWorkQ");
			if (intRet == false) {
				DocumentDetail_DeferOrReturnForCorrection = false;
				return false;
			}
			// @@ M2S WARNING : Input line number : 3335
			String strState = null;
			switch (strAction.toUpperCase()) {
			case "DEFER":
				strState = "Deferred";
				break;
			case "RETURNFORCORRECTION":
				strState = "Returned For Correction";
				break;
			default:
				/*
				 * Reporter.reportEvent(Status.Failed,strStepName,"Unknown action <"+strAction+"> - UnSuccessful"); AddInfo("Unknown action <"+strAction+"> - UnSuccessful");
				 */DocumentDetail_DeferOrReturnForCorrection = false;
				return false;
			// break;
			}
			// Verify the document is deferred or return for correction
			// Browser("ELRS").Page("ViewWorkQ").WebList("ProcessState").SelectItem(strState);
			viewWorkQPage.ProcessState_WebList.selectByValue("strState");
			viewWorkQPage.SubmitQuery_WebButton.click();
			// .getWebElement();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Select/Submit Work Queue - UnSuccessful");
				// AddInf("Select/Submit Work Queue - UnSuccessful");
				DocumentDetail_DeferOrReturnForCorrection = false;
				return false;
			}
			// AddInfo("<"+strState+"> query is submitted");
			// Verify the Registration Number is in the Deferred or Returned For Correction work queue list
			// @@ M2S WARNING : Input line number : 3363
			WebElement oWorkQList = null;
			;
			intRet = LocateAValueInWebTable(oWorkQList, strExpectedRegNumber);
			if (intRet == false) {
				/*
				 * Reporter.reportEvent(Status.Failed,strStepName,"The <Registration Number>: "+strExpectedRegNumber+"Not found in the <"+strState+"> work queue list - UnSuccessful"); AddInfo("The <Registration Number>: "+strExpectedRegNumber+"Not found in the <"+strState+"> work queue list - UnSuccessful");
				 */DocumentDetail_DeferOrReturnForCorrection = false;
				return false;
			}
			/*
			 * Reporter.reportEvent(Status.Passed,strStepName,"Verification of the <"+strState+"> state for document <"+strExpectedRegNumber+"> - Successful"); AddInfo("Verification of the <"+strState+"> state for document <"+strExpectedRegNumber+"> - Successful");
			 */if (!DocumentDetail_DeferOrReturnForCorrection == false) {
				DocumentDetail_DeferOrReturnForCorrection = true;
			}
			return DocumentDetail_DeferOrReturnForCorrection;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Add PIN button and verify the page count change on Document Detail page $PRESUBMISSIONSHEETNAME2 and $PRESUBMISSIONROW2")
	public boolean DocumentDetail_AddPINS(String shtName, String intRow) {
		boolean DocumentDetail_AddPIN = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_AddPIN";
			int intPrePageCount = 0;
			intPrePageCount = DocumentDetail_PagesCount();
			int intRet = 0;
			int intPrePINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			if (intRet == 0) {
				return false;
			}
			String strExpectedMsgs = null;
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			DocumentDetail_AddPIN_EnterData(shtName, intRow);
			if (intRet == 0) {
				return false;
			}
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				if (intRet == 0) {
					DocumentDetail_AddPIN = false;
				}
				return false;
			}
			if (intRet == 0) {
				return false;
			}
			int intCurPINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			if (intRet == 0) {
				return false;
			}
			intCurPINCount = intRet;
			int intCount = 0;
			intCount = intCurPINCount - intPrePINCount;
			if (!(intCount == 1)) {
				/*
				 * Reporter.reportEvent(Status.Failed,strStepName,"Verification of the <Total Parget PIN(s)> after Add PIN button clicked - UnSuccessful"); AddInfo("Verification of the <Total Parget PIN(s)> after Add PIN button clicked - UnSuccessful");
				 */return false;
			}
			int intCurPageCount = 0;
			int intPageChange = 0;
			intCurPageCount = DocumentDetail_PageCount();
			intPageChange = intCurPageCount - intPrePageCount;
			if (!(intPrePINCount > 15)) {
				if (intCurPINCount > 15) {
					if (intPageChange == 1) {
						/*
						 * Reporter.reportEvent(Status.Passed,strStepName,"Verification of the page recalculation - Successful"); AddInfo("Verification of the page recalculation - Successful");
						 */DocumentDetail_AddPIN = true;
					} else {
						/*
						 * Reporter.reportEvent(Status.Failed,strStepName,"Verification of the page recalculation - UnSuccessful"); AddInfo("Verification of the page recalculation - UnSuccessful");
						 */DocumentDetail_AddPIN = false;
					}
				} else {
					if (intPageChange == 1) {
						/*
						 * Reporter.reportEvent(Status.Failed,strStepName,"Verification of the page recalculation - UnSuccessful"); AddInfo("Verification of the page recalculation - UnSuccessful");
						 */DocumentDetail_AddPIN = false;
					} else {
						/*
						 * Reporter.reportEvent(Status.Passed,strStepName,"Verification of the page recalculation - Successful"); AddInfo("Verification of the page recalculation - Successful");
						 */DocumentDetail_AddPIN = true;
					}
				}
			}
			return DocumentDetail_AddPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int DocumentDetail_PagesCount() {
		int DocumentDetail_PageCount = 0;
		try {
			String strPaging = null;
			String[] arrPaging = null;
			String strPageCount = null;
			strPaging = documentDetailPage.Paging_WebTable1.getText();
			DocumentDetail_PageCount = Integer.parseInt(strPaging);
			return DocumentDetail_PageCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@When("user click on Certify button on Document Detail page")
	public boolean user_click_on_Certify() {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Certify";
			boolean DocumentDetail_Certify = false;
			boolean intRet = false;
			String strExpErrMsg = null;
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			documentDetailPage.Certify_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			String strErrorMsgs = null;
			if (propertyMaintenancePage.Header_WebElement.isPresent()) {
				String strConfirmationMsg = "Some previous transfer documents affected by this registration are not certified. Only previous certified transfers are displayed.";
				if (propertyMaintenancePage.Commit_WebButton.isPresent()) {
					logSteps.execution_log("<Property Maintenance> page displayed - Successful");
					DocumentDetail_Certify = true;
				}
			}
			propertyMaintenancePage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			return DocumentDetail_Certify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Add HWY or Add TCPipeline button and verify the PIN added to related sections $strAction")
	public boolean DocumentDetail_Add_HWY_TCPL(String strAction) {
		boolean DocumentDetail_Add_HWY_TCPL = false;
		try {
			String strButtonName = null;
			String strButton = null;
			String strPINName = null;
			switch (strAction.toUpperCase()) {
			case "ADDHWY":
				strButtonName = "Add HWY";
				strButton = "AddHWY";
				strPINName = "Highways Register";
				break;
			case "ADDTCPL":
				strButtonName = "Add TCPipeline";
				strButton = "AddTCPL";
				strPINName = "TransCanada Pipeline";
				break;
			default:
				break;
			}
			String strDocumentTypeText = null;
			String[] arrDocumentType = null;
			String strDocumentType = null;
			strDocumentTypeText = documentDetailPage.DocumentType_WebElement.getText();
			arrDocumentType = (strDocumentTypeText).split("Doc Type:");
			strDocumentType = arrDocumentType[1].trim();
			int intRet = 0;
			int intPrePINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			if (intRet == 0) {
				DocumentDetail_Add_HWY_TCPL = false;
				return false;
			}
			documentDetailPage.find(By.xpath("//*[contains(@value," + strButton + ")]")).click();
			WaitUtil.waitMSeconds(500);
			logSteps.execution_log("<" + strButtonName + "> button is clicked");
			int intCurPINCount = 0;
			intRet = DocumentDetail_TotalTargetPINCount();
			if (intRet == 0) {
				DocumentDetail_Add_HWY_TCPL = false;
				return false;
			}
			int intCount = 0;
			intCount = intCurPINCount - intPrePINCount;
			if (!(intCount == 1)) {
				logSteps.execution_log("Verification of the <Total Parget PIN(s)> after <" + strButtonName + "> button clicked - UnSuccessful");
				DocumentDetail_Add_HWY_TCPL = false;
				return false;
			}
			logSteps.execution_log("Verification of the <Total Parget PIN(s)> after <" + strButtonName + "> button clicked - Successful");
			if (!(strDocumentType == "PLAN-REFERENCE")) {
				DocumentDetail_Add_HWY_TCPL = true;
				return false;
			}
			WebElement oWebTable = null;
			boolean intValue = false;
			intValue = LocateAValueInWebTable(oWebTable, strPINName);
			if (intValue == false) {
				logSteps.execution_log("<" + strPINName + "> NOT exist in PIN/Affects All/Part List section under Document Data  - UnSuccessful");
				DocumentDetail_Add_HWY_TCPL = false;
				oWebTable = null;
				return false;
			}
			if (!(documentDetailPage.Summary_Link.getAttribute("class") == "foretab")) {
				documentDetailPage.Summary_Link.click();
			}
			intValue = LocateAValueInWebTable(oWebTable, strPINName);
			if (intValue == false) {
				logSteps.execution_log("<" + strPINName + "> NOT exist in PIN/Affects All/Part List section under Summary tab - UnSuccessful");
				DocumentDetail_Add_HWY_TCPL = false;
				oWebTable = null;
				return false;
			}
			oWebTable = null;
			return DocumentDetail_Add_HWY_TCPL;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on ProceedWithReceipt button on Document Detail page $shtName and $intRow")
	public boolean user_click_on_ProceedWithReceipt(String shtName, int intRow) {
		boolean DocumentDetail_ProceedWithReceipt = false;
		try {
			String strStepName = "DocumentDetail_ProceedWithReceipt";
			boolean intRet = false;
			if (!shtName.isEmpty() && intRow > 0) {
				intRet = DocumentDetail_EnterData_UsingMap(shtName, intRow);
				String strExpErrMsg = GetValueIfValid("ErrorMessages", shtName, intRow).trim();
			}
			documentDetailPage.ProceedWithReceipt_WebButton.click();
			if (mainPage.ApplicationError_WebElement.isPresent()) {
				SubmitApplicationErrorReport();
				return false;
			}
			if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
				logSteps.execution_log("The <Fees and Taxes> NOT exist - UnSuccessful");
				DocumentDetail_ProceedWithReceipt = false;
				String strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, "");
				if (intRet == false) {
					DocumentDetail_ProceedWithReceipt = false;
				}
				return false;
			}
			DocumentDetail_ProceedWithReceipt = true;
			return DocumentDetail_ProceedWithReceipt;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_EnterData_UsingMap(String shtName, int intRow) {
		boolean DocumentDetail_EnterData_UsingDataMap = false;
		try {
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();
			oDataMap.put("PINDetails", "");
			oDataMap.put("DocumentData", "");
			oDataMap.put("Parties", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("HighwayPipeline", "");
			oDataMap.put("Summary", "");
			oDataMap.put("CorrectionNotices", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);

			for (int i = 0; i <= arrKeys.length - 1; i++) {
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, intRow).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}

			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				intRet = DocumentDetail_Navigate_To_Tab(strSheetName);
				switch (strSheetName.toUpperCase()) {
				case "PINDETAILS":
					intRet = DocumentDetail_Edit_PINDetails(strSheetName, strRowNumber);
					break;
				case "DOCUMENTDATA":
					intRet = DocumentDetail_Enter_DocumentData(strSheetName, strRowNumber);
					break;
				case "PARTIES":
					intRet = DocumentDetail_Edit_Parties(strSheetName, strRowNumber);
					break;
				case "PROPERTYREMARKS":
					intRet = DocumentDetail_Edit_PropertyRemarks(strSheetName, strRowNumber);
					break;
				case "HIGHWAYPIPELINE":
					intRet = DocumentDetail_Edit_HighwayPipeline(strSheetName, strRowNumber);
					break;
				case "CORRECTIONNOTICES":
					intRet = DocumentDetail_Edit_CorrectionNotices(strSheetName, strRowNumber);
					break;
				case "SUMMARY":
					intRet = DocumentDetail_Edit_Summary(strSheetName, Integer.parseInt(strRowNumber));
					break;
				}
				if (intRet == false) {
				}
			}
			oDataMap = null;
			return DocumentDetail_EnterData_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Enter_DocumentData(String shtName, String intRow) {
		boolean DocumentDetail_Edit_DocumentData = false;
		try {
			String strStepName = "DocumentDetail_Edit_DocumentData";
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
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
				String strAmount = GetValueIfValid("Amount", shtName, iLoop);
				String strTotalNewUnits = GetValueIfValid("TotalNewUnits", shtName, iLoop);
				String strNewUnit = GetValueIfValid("NewUnit", shtName, iLoop);
				String strNewLevel = GetValueIfValid("NewLevel", shtName, iLoop);
				String strUnitType = GetValueIfValid("UnitType", shtName, iLoop);
				String strStartRange = GetValueIfValid("StartRange", shtName, iLoop);
				String strEndRange = GetValueIfValid("EndRange", shtName, iLoop);
				String strUnitLevelIndex = GetValueIfValid("UnitLevelIndex", shtName, iLoop);
				String strNumberOfUnits = GetValueIfValid("NumberOfUnits", shtName, iLoop);
				documentDataPage.Amount_WebEdit.clear();
				documentDataPage.Amount_WebEdit.sendKeys(strAmount);
				documentDataPage.TotalNewUnits_WebEdit.sendKeys(strTotalNewUnits);
				if (NumberUtils.isNumber(strUnitLevelIndex)) {
					int intUnitLevelIndex = Integer.parseInt(strUnitLevelIndex) - 1;
					if (!documentDataPage.find(By.id("level" + intUnitLevelIndex)).isPresent()) {
						documentDataPage.AddMore_WebButton.click();
					}
					documentDataPage.find(By.id("level" + intUnitLevelIndex)).sendKeys(strStartRange);
					documentDataPage.find(By.id("levelRange" + intUnitLevelIndex)).sendKeys(strEndRange);
					documentDataPage.find(By.id("numberOfUnits" + intUnitLevelIndex)).sendKeys(strNumberOfUnits);
				}

			}

			DocumentDetail_Edit_DocumentData = true;
			return DocumentDetail_Edit_DocumentData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean DocumentDetail_Navigate_To_Tab(String strTabName) {

		boolean DocumentDetail_Navigate_To_Tab = false;

		try {

			switch (strTabName.trim()) {

			case "Summary":

				documentDetailPage.Summary_Link.click();

				break;

			case "PINDetails":

				documentDetailPage.PINDetails_Link.click();

				break;

			case "DocumentData":

				documentDetailPage.DocumentData_Link.click();

				break;

			case "Parties":

				documentDetailPage.Parties_Link.click();

				break;

			case "PropertyRemarks":

				if (documentDetailPage.PropertyRemarks_Link.isVisible()) {

					documentDetailPage.PropertyRemarks_Link.click();

				}

				break;

			case "HighwayPipeline":

				documentDetailPage.HighwayPipeline_Link.click();

				break;

			case "CorrectionNotices":

				documentDetailPage.CorrectionNotices_Link.click();

				break;

			}

			// String strActiveTab = CheckDocumentDetailActiveTab();

			/*
			 * if (!strActiveTab.equalsIgnoreCase(strTabName)) {
			 * 
			 * // logSteps.execution_log("Verification of current active tab - UnSuccessful. Expected: <" + strTabName + ">, Actual: <" + strActiveTab + ">");
			 * 
			 * return false;
			 * 
			 * }
			 */

			if (!documentDetailPage.Cancel_WebButton.isCurrentlyVisible()) {

				// logSteps.execution_log("The <Cancel> button Not displayed on the <" + strTabName + "> page - UnSuccessful");

				return false;

			}

			DocumentDetail_Navigate_To_Tab = true;

			return DocumentDetail_Navigate_To_Tab;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}
	
	@When("user click on Complete Recording button on Document Detail page without data")
	public boolean DocumentDetail_CompleteRecording_Without() {
		boolean DocumentDetail_CompleteRecording = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_CompleteRecording";
			String strExpectedDocType = null;
			String strExpectedRegNumber = null;
			strExpectedDocType = DocumentDetail_Retrieve_DocumentType();
			strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();
			boolean intRet = false;
			documentDetailPage.CompleteRecording_webbutton.click();
			// logSteps.execution_log("<Complete Recording> button is clicked");
			if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
				String strExpectedMsgs = null;
				String strErrorMsgs = null;
				// Fetch expected error message if applicable
				// datatableLib.getsheet(shtName).setcurrentRow((Integer.parseInt(intRow)));
				// strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				// Verify error message
				if (documentDetailPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						//intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							DocumentDetail_CompleteRecording = false;
						}
					} else {
						// logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful");
					}
				} else {
					// logSteps.execution_log("Unknown page is returned - UnSuccessful");
				}
				return false;
			}
			// logSteps.execution_log("Page <Fees and Taxes> displayed - Successful");
			int intRowIndex = 0;
			String strDocType = null;
			String strRegNumber = null;
			DocumentDetail_CompleteRecording = true;
			return DocumentDetail_CompleteRecording;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify Error message on DocumentDetail page $DOCUMENTDETAIL_MAPSHEETNAME1 and $DOCUMENTDETAIL_MAPROW1")
	public boolean user_verify_Error_message_on_DocumentDetail_page(String shtName, String intRow) {
		String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
		String strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
		if (strExpectedMsgs.contains(strErrorMsgs)) {
			// logSteps.execution_log("message verified " + strErrorMsgs);
			return true;
		}
		return false;
	}
	@Then("user verifies PINDetailsDescription exists on Document Detail page $PINDETAILSSHEETNAME and $PINDETAILSROW")
	public boolean user_verify_PINdetailsdescription_message_on_DocumentDetail_page(String shtName, String intRow) {
		String expErrormsg = GetValueIfValid("Description", shtName, Integer.parseInt(intRow));
		String actualErrorMsg = documentDetailPage.PINDetails_Description.getText();
		if (actualErrorMsg.contains(expErrormsg)) {
			// logSteps.execution_log("message verified " + actualErrorMsg);
			return true;
		}
		return false;
	}
	@When("user navigate to pindetails on Document Detail page")
	public boolean navigate_to_pindetails() {
		documentDetailPage.Navigate_pindetails.click();
		return true;
	}
	
	@When("user click on Complete Recording button on Document Detail page with $DOCUMENTDETAIL_MAPSHEETNAME1 and $DOCUMENTDETAIL_MAPROW1")
	public boolean DocumentDetail_CompleteRecording_withdata(String shtName, String intRow) {
		boolean DocumentDetail_CompleteRecording = false;
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_CompleteRecording";
			String strExpectedDocType = null;
			String strExpectedRegNumber = null;
			strExpectedDocType = DocumentDetail_Retrieve_DocumentType();
			strExpectedRegNumber = DocumentDetail_Retrieve_RegNumber();
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
				if (intRet == false) {
					return false;
				}
			}
			documentDetailPage.CompleteRecording_webbutton.click();
			// AddInfo("<Complete Recording> button is clicked");
			if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
				String strExpectedMsgs = null;
				String strErrorMsgs = null;
				strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				if (documentDetailPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							DocumentDetail_CompleteRecording = false;
						}
					} else {
						/*
						 * Reporter.reportEvent(Status.Failed,strStepName,"Page <Document Detail> Not displayed - UnSuccessful"); AddInfo("Page <Document Detail> Not displayed - UnSuccessful");
						 */}
				} else {
					/*
					 * Reporter.reportEvent(Status.Failed,strStepName,"Unknown page is returned - UnSuccessful "); AddInfo("Unknown page is returned - UnSuccessful");
					 */}
				// return false;
			}
			/*
			 * Reporter.reportEvent(Status.Passed,strStepName,"Page <Fees and Taxes> displayed - Successful"); AddInfo("Page <Fees and Taxes> displayed - Successful");
			 */ // Verify the Document Type and Registration Number on the Fees and Taxes page
			// @@ M2S WARNING : Input line number : 5967
			int intRowIndex = 0;
			// @@ M2S WARNING : Input line number : 5967
			String strDocType = null;
			// @@ M2S WARNING : Input line number : 5967
			String strRegNumber = null;
			// Locate the Document Type row index
			// intRowIndex = getRowWithCellText(feesTaxesPage.DocumentType_WebTable, "Document Type", 1, 1);
			// Retrieve the Document Type displayed on the page
			// strDocType = getCellData(feesTaxesPage.DocumentType_WebTable, intRowIndex, 2).trim();
			// Verify the Document Type and Registration Number
			/*
			 * if (!(InStr(strDocType, strExpectedDocType) > 0)) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"The expected <Document Type:> "+strExpectedDocType+" Not displayed on <Fees and Taxes> page - UnSuccessful"); AddInfo("The expected <Document Type:> "+strExpectedDocType+" Not displayed on <Fees and Taxes> page - UnSuccessful"); // return false; }
			 */
			/*
			 * Reporter.reportEvent(Status.Passed,strStepName,"Verification of <Document Type:> "+strExpectedDocType+"  - Successful"); AddInfo("Verification of <Document Type:> "+strExpectedDocType+"  - Successful");
			 */ // Locate the Registration Number row index
			// intRowIndex = getRowWithCellText(feesTaxesPage.DocumentType_WebTable, "Registration Number", 1, 1);
			// Retrieve the Registration Number displayed on the page
			// strRegNumber = getCellData(feesTaxesPage.DocumentType_WebTable, intRowIndex, 2).trim();
			/*
			 * if (!(strComp(strRegNumber, strExpectedRegNumber) == 0)) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"The expected <Registration Number:> "+strExpectedRegNumber+" Not displayed on <Fees and Taxes> page - UnSuccessful"); AddInfo("The expected <Registration Number:> "+strExpectedRegNumber+" Not displayed on <Fees and Taxes> page - UnSuccessful");
			 * return false; }
			 */
			/*
			 * Reporter.reportEvent(Status.Passed,strStepName,"Verification of <Registration Number:> "+strExpectedRegNumber+"  - Successful"); AddInfo("Verification of <Registration Number:> "+strExpectedRegNumber+"  - Successful");
			 */DocumentDetail_CompleteRecording = true;
			return DocumentDetail_CompleteRecording;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@When("user clicks on ProceedWithReceipt button on Document Detail $shtName and $intRow")
    public boolean documentDetail_ProceedWithReceipt(String shtName, int intRow) {
           boolean DocumentDetail_ProceedWithReceipt = false;
           try {
                  String strStepName = "DocumentDetail_ProceedWithReceipt";
                  boolean intRet = false;
                  if (!shtName.isEmpty() && intRow > 0) {
                        intRet = documentDetail_EnterData_UsingMap(shtName, intRow);
                        String strExpErrMsg = GetValueIfValid("ErrorMessages", shtName, intRow).trim();
                  }
                  documentDetailPage.ProceedWithReceipt_WebButton.click();
                  if (mainPage.ApplicationError_WebElement.isPresent()) {
                        SubmitApplicationErrorReport();
                        return false;
                  }
                  if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
                        logSteps.execution_log("The <Fees and Taxes> NOT exist - UnSuccessful");
                        DocumentDetail_ProceedWithReceipt = false;
                        String strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
                        intRet = VerifyErrorMessage(strStepName, strErrorMsgs, "");
                        if (intRet == false) {
                               DocumentDetail_ProceedWithReceipt = false;
                        }
                        return false;
                  }
                  DocumentDetail_ProceedWithReceipt = true;
                  return DocumentDetail_ProceedWithReceipt;
           } catch (Exception e) {
                  e.printStackTrace();
                  return false;
           }
    }
public boolean documentDetail_EnterData_UsingMap(String shtName, int intRow) {
           boolean DocumentDetail_EnterData_UsingDataMap = false;
           try {
                  Map<String, String> oDataMap = new LinkedHashMap<String, String>();
                  oDataMap.put("PINDetails", "");
                  oDataMap.put("DocumentData", "");
                  oDataMap.put("Parties", "");
                  oDataMap.put("PropertyRemarks", "");
                  oDataMap.put("HighwayPipeline", "");
                  oDataMap.put("Summary", "");
                  oDataMap.put("CorrectionNotices", "");
                  Object[] arrKeys = oDataMap.keySet().toArray();
                  Map<String, Integer> headerMap = getHeaderMap(shtName);

                  for (int i = 0; i <= arrKeys.length - 1; i++) {
                        if (!headerMap.containsKey(arrKeys[i])) {
                               oDataMap.remove(arrKeys[i]);
                        } else {
                               String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, intRow).trim();
                               if (strCellValue.isEmpty()) {
                                      oDataMap.remove(arrKeys[i]);
                               } else {
                                      oDataMap.put(arrKeys[i].toString(), strCellValue);
                               }
                        }
                  }

                  boolean intRet = false;
                  Object[] arrNewKeys = oDataMap.keySet().toArray();
                  for (int i = 0; i <= arrNewKeys.length - 1; i++) {
                        String strSheetName = arrNewKeys[i].toString();
                        String strRowNumber = oDataMap.get(strSheetName);
                        intRet = DocumentDetail_Navigate_To_Tab(strSheetName);
                        switch (strSheetName.toUpperCase()) {
                        case "PINDETAILS":
                               intRet = DocumentDetail_Edit_PINDetails(strSheetName, strRowNumber);
                               break;
                        case "DOCUMENTDATA":
                               intRet = documentDetail_Enter_DocumentData(strSheetName, strRowNumber);
                               break;
                        case "PARTIES":
                               intRet = DocumentDetail_Edit_Parties(strSheetName, strRowNumber);
                               break;
                        case "PROPERTYREMARKS":
                               intRet = DocumentDetail_Edit_PropertyRemarks(strSheetName, strRowNumber);
                               break;
                        case "HIGHWAYPIPELINE":
                               intRet = DocumentDetail_Edit_HighwayPipeline(strSheetName, strRowNumber);
                               break;
                        case "CORRECTIONNOTICES":
                               intRet = DocumentDetail_Edit_CorrectionNotices(strSheetName, strRowNumber);
                               break;
                        case "SUMMARY":
                               intRet = DocumentDetail_Edit_Summary(strSheetName, Integer.parseInt(strRowNumber));
                               break;
                        }
                        if (intRet == false) {
                        }
                  }
                  oDataMap = null;
                  return DocumentDetail_EnterData_UsingDataMap;
           } catch (Exception e) {
                  e.printStackTrace();
                  return false;
           }
    }
public boolean documentDetail_Enter_DocumentData(String shtName, String intRow) {
           boolean DocumentDetail_Edit_DocumentData = false;
           try {
                  String strStepName = "DocumentDetail_Edit_DocumentData";
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
                  boolean intRet = false;
                  for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
                        String strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, iLoop);
                        String strAmount = GetValueIfValid("Amount", shtName, iLoop);
                        String strTotalNewUnits = GetValueIfValid("TotalNewUnits", shtName, iLoop);
                        String strNewUnit = GetValueIfValid("NewUnit", shtName, iLoop);
                        String strNewLevel = GetValueIfValid("NewLevel", shtName, iLoop);
                        String strUnitType = GetValueIfValid("UnitType", shtName, iLoop);
                        String strStartRange = GetValueIfValid("StartRange", shtName, iLoop);
                        String strEndRange = GetValueIfValid("EndRange", shtName, iLoop);
                        String strUnitLevelIndex = GetValueIfValid("UnitLevelIndex", shtName, iLoop);
                        String strNumberOfUnits = GetValueIfValid("NumberOfUnits", shtName, iLoop);
                        documentDataPage.Amount_WebEdit.clear();
                        documentDataPage.Amount_WebEdit.sendKeys(strAmount);
                        if (documentDataPage.TotalNewUnits_WebEdit.isPresent()) {
                               documentDataPage.TotalNewUnits_WebEdit.sendKeys(strTotalNewUnits);
                        }
                        if (NumberUtils.isNumber(strUnitLevelIndex)) {
                               int intUnitLevelIndex = Integer.parseInt(strUnitLevelIndex) - 1;
                               if (!documentDataPage.find(By.id("level" + intUnitLevelIndex)).isPresent()) {
                                      documentDataPage.AddMore_WebButton.click();
                               }
                               documentDataPage.find(By.id("level" + intUnitLevelIndex)).sendKeys(strStartRange);
                               documentDataPage.find(By.id("levelRange" + intUnitLevelIndex)).sendKeys(strEndRange);
                               documentDataPage.find(By.id("numberOfUnits" + intUnitLevelIndex)).sendKeys(strNumberOfUnits);
                        }

                  }
                  DocumentDetail_Edit_DocumentData = true;
                  return DocumentDetail_Edit_DocumentData;
           } catch (Exception e) {
                  e.printStackTrace();
                  return false;
           }
    }



}
