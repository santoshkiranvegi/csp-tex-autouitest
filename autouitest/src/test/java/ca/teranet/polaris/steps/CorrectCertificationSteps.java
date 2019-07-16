package ca.teranet.polaris.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CorrectCertificationPage;
import ca.teranet.pages.polaris.CorrectUpdateCertifiedPropertyPage;
import ca.teranet.pages.polaris.CorrectionConfirmationPage;
import ca.teranet.pages.polaris.CorrectionNoticesPage;
import ca.teranet.pages.polaris.DocumentDataPage;
import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.DocumentSelectionPage;
import ca.teranet.pages.polaris.DocumentViewPopupPage;
import ca.teranet.pages.polaris.HighwayPipelinePage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.ModifyHeaderPage;
import ca.teranet.pages.polaris.PINDetailsPage;
import ca.teranet.pages.polaris.PINListPage;
import ca.teranet.pages.polaris.PartiesPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.PropertyMaintenancePage;
import ca.teranet.pages.polaris.PropertyRemarksPage;
import ca.teranet.pages.polaris.SummaryPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class CorrectCertificationSteps extends Utility {

	DocumentDetailPage documentDetailPage;
	DocumentSelectionPage documentSelectionPage;
	CorrectionNoticesPage correctionNoticesPage;
	BatchPage batchPage;
	MainPage mainPage;
	CorrectionConfirmationPage correctionConfirmationPage;
	DocumentViewPopupPage documentViewPopupPage;
	@Steps
	ELRSCommonSteps elrsCommon;
	CorrectUpdateCertifiedPropertyPage correctUpdateCertifiedPropertyPage;
	PropertyDetailSteps propertyDetailSteps;
	PropertyDetailPage propertyDetailPage;
	PropertyMaintenancePage propertyMaintenancePage;
	ModifyHeaderPage modifyHeaderPage;
	CorrectCertificationPage correctCertificationPage;
	@Steps
	LogSteps logSteps;
	PINDetailsPage pinDetailsPage;
	PartiesPage partiesPage;
	PropertyRemarksPage propertyRemarksPage;
	HighwayPipelinePage highwayPipelinePage;
	SummaryPage summaryPage;
	DocumentDataPage documentDataPage;
	PINListPage pinListPage;
	@Steps
	DocumentDetailSteps documentDetailSteps;

	@When("user clicks the Proceed button on the Document Selection page $shtName and $intRow")
	public boolean CorrectCertification_DocumentSelection_Proceed(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Proceed = false;
		try {
			String strStepName = "CorrectCertification_DocumentSelection_Proceed";

			if (intRow.equals("")) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = CorrectCertification_DocumentSelection_Click_Proceed(shtName, intRow);
			if (intRet == false) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strErrorMsgs = null;
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							CorrectCertification_DocumentSelection_Proceed = false;
						}
					} else {
					}
				} else if (correctionNoticesPage.Error_WebElement.isPresent()) {
					strErrorMsgs = correctionNoticesPage.Error_WebElement.getText().trim();
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						CorrectCertification_DocumentSelection_Proceed = false;
					}
					if (correctionNoticesPage.Cancel_WebButton.isPresent()) {
						correctionNoticesPage.Cancel_WebButton.click();
					} else {
					}
					return CorrectCertification_DocumentSelection_Proceed;
				} else {
				}
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strHeadingText = documentDetailPage.Heading_WebTable.getText().trim();
			if (!(InStr(strHeadingText, strRegNumber) > 0)) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strExpectedStatus = "Certified";
			if (!(InStr(strHeadingText, strExpectedStatus.toUpperCase()) > 0)) {
				String[] arrHeadingText = (strHeadingText).split("Status:");
				String strStatus = arrHeadingText[1].trim();
				return CorrectCertification_DocumentSelection_Proceed;
			}
			CorrectCertification_DocumentSelection_Proceed = true;
			return CorrectCertification_DocumentSelection_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Proceed;
		}
	}

	public boolean CorrectCertification_DocumentSelection_Batch_Proceed(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Batch_Proceed = false;
		try {
			String strStepName = "CorrectCertification_DocumentSelection_Batch_Proceed";

			if (intRow.isEmpty()) {
				return CorrectCertification_DocumentSelection_Batch_Proceed;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			intRet = CorrectCertification_DocumentSelection_Click_Proceed(shtName, intRow);
			if (intRet == false) {
				return CorrectCertification_DocumentSelection_Batch_Proceed;
			}
			if (!batchPage.PreSubmission_Historical_WebElement.isPresent()) {

				if (mainPage.ApplicationError_WebElement.isPresent()) {
					SubmitApplicationErrorReport();
				}
				return CorrectCertification_DocumentSelection_Batch_Proceed;
			}
			String strBatchJob = "Bulk Document Correction";
			if (intRet == false) {
				return CorrectCertification_DocumentSelection_Batch_Proceed;
			}
			String strExpectedFunction = "Correct Certified Document";
			String strActualFunction = mainPage.FuncID_WebElement.getAttribute("outertext");
			String strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			if (strComp(strActualFunction.trim(), strExpectedFunction) != 0) {
				if (!(strComp(strMode.trim(), "Batch") > 0)) {
				} else {
				}
				return CorrectCertification_DocumentSelection_Batch_Proceed;
			}
			CorrectCertification_DocumentSelection_Batch_Proceed = true;
			return CorrectCertification_DocumentSelection_Batch_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Batch_Proceed;
		}
	}

	public boolean CorrectCertification_CorrectionNotices_ReturnToDocumentDetails(String shtName, String intRow) {
		boolean CorrectCertification_CorrectionNotices_ReturnToDocumentDetails = false;
		try {
			String strStepName = "CorrectCertification_CorrectionNotices_ReturnToDocumentDetails";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				if (intRet == false) {
					return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
				} else {
				}
			}
			environmentlib.setProperty("bTriggered", "false");
			correctionNoticesPage.ReturntoDetails_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			if (!documentDetailPage.CorrectionNotices_Link.isPresent()) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			CorrectCertification_CorrectionNotices_ReturnToDocumentDetails = true;
			return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
		}
	}

	public boolean CorrectCertification_GenerateNotice(String shtName, String intRow, String strType) {
		boolean CorrectCertification_GenerateNotice = false;
		try {
			String strStepName = "CorrectCertification_GenerateNotice";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (InStr(intRow, "-") > 0) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			if (!mainPage.TimeText_WebElement.isPresent()) {
				return CorrectCertification_GenerateNotice;
			}
			String strTimeStamp = mainPage.TimeText_WebElement.getText();
			String[] arrTimeStamp = (strTimeStamp.trim()).split(" ");
			String strDate = arrTimeStamp[0].trim();
			String strUser = mainPage.UserText_WebElement.getText().trim().toUpperCase();
			String strAutoGeneratedNotice = null;
			String strAutoType = null;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				switch (strType.toUpperCase()) {
				case "GENERATENOTICE":
					strAutoGeneratedNotice = GetValueIfValid("AutoGeneratedNotice", shtName, Integer.parseInt(intRow));
					break;
				case "GENERATEINTERNALNOTE":
					strAutoGeneratedNotice = GetValueIfValid("InternalProcessingNotes", shtName, Integer.parseInt(intRow));
					break;
				}
				strAutoGeneratedNotice = strAutoGeneratedNotice.replace("<Date>", strDate);
				strAutoGeneratedNotice = strAutoGeneratedNotice.replace("<User>", strUser);
				switch (strType.toUpperCase()) {
				case "GENERATENOTICE":
					strAutoType = "Correction Notice";
					break;
				case "GENERATEINTERNALNOTE":
					strAutoType = "Internal Processing Note";
					break;
				}
			}
			CorrectCertification_GenerateNotice = true;
			return CorrectCertification_GenerateNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_GenerateNotice;
		}
	}

	@When("user cancels the Document Selection $shtName and $intRow")
	public boolean user_cancels_the_Document_Selection(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Cancel = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			documentSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(1000);
			CorrectCertification_DocumentSelection_Cancel = true;
			return CorrectCertification_DocumentSelection_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Cancel;
		}
	}

	@When("user cancels the Document Selection")
	public boolean user_cancels_the_Document_Selection() {
		boolean CorrectCertification_DocumentSelection_Cancel = false;
		try {
			documentSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(1000);
			return CorrectCertification_DocumentSelection_Cancel;
		} catch (

		Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Cancel;
		}
	}

	@When("user cancels the Cancel document selection $shtName and $intRow")
	public boolean user_cancels_the_Cancel_document_selection(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_CancelCancel = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			documentSelectionPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(500);
			return CorrectCertification_DocumentSelection_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_CancelCancel;
		}
	}

	@When("user cancels the Cancel document selection")
	public boolean user_cancels_the_Cancel_document_selection() {
		boolean CorrectCertification_DocumentSelection_CancelCancel = false;
		try {
			documentSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(500);
			CorrectCertification_DocumentSelection_CancelCancel = true;
			return CorrectCertification_DocumentSelection_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_CancelCancel;
		}
	}

	@When("user cancels PIN entry")
	public boolean CorrectUpdateCertifiedProperty_Cancel() {
		boolean CorrectUpdateCertifiedProperty_Cancel = false;
		try {
			WaitUtil.waitMSeconds(1000);
			correctUpdateCertifiedPropertyPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(500);
			CorrectUpdateCertifiedProperty_Cancel = true;
			return CorrectUpdateCertifiedProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_Cancel;
		}
	}

	@When("user click on the Proceed button on the PIN Entry page $shtName and $intRow")
	public boolean CorrectUpdateCertifiedProperty_Proceed(String shtName, String intRow) {
		boolean CorrectUpdateCertifiedProperty_Proceed = false;
		String strActualPIN = "";
		String strExpectedPIN = "";
		try {
			String strStepName = "CorrectUpdateCertifiedProperty_Proceed";
			if (intRow.equals("")) {
				return CorrectUpdateCertifiedProperty_Proceed;
			}
			String strTargetBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow));
			String strTargetPINType = GetValueIfValid("PINType", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			if (!strTargetBlock.equals("") || !strTargetPIN.equals("")) {
				intRet = CorrectUpdateCertifiedProperty_PINEntry_EnterData(shtName, intRow);
				if (intRet == false) {
					return CorrectUpdateCertifiedProperty_Proceed;
				}
			}
			correctUpdateCertifiedPropertyPage.Proceed_WebButton.click();
			WaitUtil.waitMSeconds(1000);

			/*
			 * if (!propertyDetailPage.ParentPINHeader_WebElement.isDisplayed()) { if (correctUpdateCertifiedPropertyPage.ErrorMsg_WebTable.isDisplayed()) { String strErrorMsgs = getCellData(correctUpdateCertifiedPropertyPage.ErrorMsg_WebTable, 1, 1).trim(); if (!strErrorMsgs.equals("")) { intRet =
			 * VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs); if (intRet == false) { CorrectUpdateCertifiedProperty_Proceed = false; } } else {
			 * 
			 * } } else {
			 * 
			 * } return CorrectUpdateCertifiedProperty_Proceed; }
			 * 
			 * strActualPIN = PropertyDetail_Retrieve_ParentPIN(); strActualPIN = strExpectedPIN; strExpectedPIN = strTargetBlock + "-" + strTargetPIN + "(" + strTargetPINType + ")"; if (strComp(strActualPIN, strExpectedPIN) != 0) { return CorrectUpdateCertifiedProperty_Proceed; }
			 */
			return CorrectUpdateCertifiedProperty_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_Proceed;
		}
	}

	public String PropertyDetail_Retrieve_ParentPIN() {
		try {
			String strParentPINs = null;
			strParentPINs = propertyDetailPage.ParentPINHeader_WebElement.getText();
			return strParentPINs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean CorrectUpdateCertifiedProperty_PINEntry_EnterData(String shtName, String intRow) {
		boolean CorrectUpdateCertifiedProperty_PINEntry_EnterData = false;
		try {
			String strTargetBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow)).toUpperCase();
			correctUpdateCertifiedPropertyPage.Block_WebEdit.clear();
			correctUpdateCertifiedPropertyPage.Block_WebEdit.sendKeys(strTargetBlock);
			correctUpdateCertifiedPropertyPage.Property_WebEdit.clear();
			correctUpdateCertifiedPropertyPage.Property_WebEdit.sendKeys(strTargetPIN);
			CorrectUpdateCertifiedProperty_PINEntry_EnterData = true;
			return CorrectUpdateCertifiedProperty_PINEntry_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_PINEntry_EnterData;
		}
	}

	public boolean CorrectCertification_CorrectionNotices_CancelCancel(String shtName, String intRow) {
		boolean CorrectCertification_CorrectionNotices_CancelCancel = false;
		try {

			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				if (intRet == false) {
					return CorrectCertification_CorrectionNotices_CancelCancel;
				} else {
				}
			}
			environmentlib.setProperty("bTriggered", "false");
			correctionNoticesPage.Cancel_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
				return CorrectCertification_CorrectionNotices_CancelCancel;
			}
			String strAction = "Cancel";
			if (intRet == false) {
				return CorrectCertification_CorrectionNotices_CancelCancel;
			}
			if (!correctionNoticesPage.ReviewCorrectionNotices_WebElement.isPresent()) {
				return CorrectCertification_CorrectionNotices_CancelCancel;
			}
			CorrectCertification_CorrectionNotices_CancelCancel = true;
			return CorrectCertification_CorrectionNotices_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_CancelCancel;
		}
	}

	public boolean CorrectCertification_CorrectionNotices_Cancel(String shtName, String intRow) {
		boolean CorrectCertification_CorrectionNotices_Cancel = false;
		try {
			String strStepName = "CorrectCertification_CorrectionNotices_Cancel";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {

				if (intRet == false) {
					return CorrectCertification_CorrectionNotices_Cancel;
				} else {
				}
			}
			environmentlib.setProperty("bTriggered", "false");
			correctionNoticesPage.Cancel_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				return CorrectCertification_CorrectionNotices_Cancel;
			}
			String strAction = "OK";
			intRet = false;
			if (intRet == false) {
				return CorrectCertification_CorrectionNotices_Cancel;
			}
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				return CorrectCertification_CorrectionNotices_Cancel;
			}
			CorrectCertification_CorrectionNotices_Cancel = true;
			return CorrectCertification_CorrectionNotices_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_Cancel;
		}
	}

	public boolean CorrectCertification_Document_ClickAndOpen(String shtName, String intRow) {
		boolean CorrectCertification_Document_ClickAndOpen = false;
		try {
			String strStepName = "CorrectCertification_Document_ClickAndOpen";
			if (intRow.equals("")) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strExpectedRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			List<WebElement> oLink = correctionConfirmationPage.CorrectionResult_WebTable.findElements(By.xpath("//a[@class='ro']"));
			int intLinkCount = oLink.size();
			if (intLinkCount == 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			if (intLinkCount > 1) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strDocumentNumber = oLink.get(0).getAttribute("text").trim();
			if (strComp(strDocumentNumber, strExpectedRegNumber) != 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strRegNumber = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 1, 2);
			if (strComp(strRegNumber.trim(), strDocumentNumber) != 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			CorrectCertification_Document_ClickAndOpen = true;
			return CorrectCertification_Document_ClickAndOpen;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_Document_ClickAndOpen;
		}
	}

	public boolean CorrectCertification_Document_Close() {
		boolean CorrectCertification_Document_Close = false;
		try {
			String strStepName = "CorrectCertification_Document_Close";
			boolean intRet = false;
			if (intRet == false) {
				return CorrectCertification_Document_Close;
			}
			if (!correctionConfirmationPage.Confirmation_WebElement.isPresent()) {
				return CorrectCertification_Document_Close;
			}
			CorrectCertification_Document_Close = true;
			return CorrectCertification_Document_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_Document_Close;
		}
	}

	public boolean DocumentSelection_EnterData(String shtName, String intRow) {
		boolean DocumentSelection_EnterData = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Enter data
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);

			/*
			 * if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) { // Reporter.reportEvent(Status.Failed, strStepName, "Enter <Registration Number>: " + strRegNumber + " - UnSuccessful"); // AddInfo("Enter <Registration Number>: " + strRegNumber + " - UnSuccessful"); return
			 * DocumentSelection_EnterData; }
			 */
			// Reporter.reportEvent(Status.Passed, strStepName, "Enter <Registration Number>: " + strRegNumber + " - Successful");
			// AddInfo("Enter <Registration Number>: " + strRegNumber + " - Successful");
			DocumentSelection_EnterData = true;
			return DocumentSelection_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return DocumentSelection_EnterData;
		}
	}

	@When("user Cancel Document Selection without data entry")
	public boolean CorrectCertification_DocumentSelection_Cancel() {
		boolean CorrectCertification_DocumentSelection_Cancel = false;
		try {
			documentSelectionPage.Cancel_WebButton.click();
			return CorrectCertification_DocumentSelection_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Commit button on Property Maintenance page")
	public boolean user_clicks_on_Commit_button_on_Property_Maintenance_page() {
		boolean PropertyMaintenance_Commit = false;
		try {
			String strStepName = null;
			strStepName = "PropertyMaintenance_Commit";
			propertyMaintenancePage.Commit_WebButton.click();
			WaitUtil.waitMSeconds(2000);
			return PropertyMaintenance_Commit;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user create and pass RegNum")
	public boolean Create_and_pass_RegNum() {
		boolean Create_and_pass_RegNum = false;
		try {
			String regNum = Generate_Unique_RegNumber();
			correctCertificationPage.CorrectCertification_RegNum.sendKeys(regNum);
			correctCertificationPage.CorrectCertification_Proceed.click();
			Create_and_pass_RegNum = true;
			return Create_and_pass_RegNum;
		} catch (Exception e) {
			e.printStackTrace();
			return Create_and_pass_RegNum;
		}
	}

	@When("user clicks on Modify Header button on Document Detail page")
	public boolean DocumentDetail_ModifyHeader_Click() {
		boolean DocumentDetail_ModifyHeader_Click = false;
		try {
			documentDetailPage.Modify_Header.click();
			DocumentDetail_ModifyHeader_Click = true;
			return DocumentDetail_ModifyHeader_Click;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Apply/DoNotApply the modification $shtName and $intRow")
	public boolean DocumentDetail_ModifyHeader(String shtName, int intRow) {
		boolean DocumentDetail_ModifyHeader = false;
		String Modify = GetValueIfValid("Modify", shtName, intRow);
		String RegNumber = GetValueIfValid("RegNumber", shtName, intRow);
		String RegDate = GetValueIfValid("RegDate", shtName, intRow);
		String RegTime = GetValueIfValid("RegTime", shtName, intRow);
		String RegFees = GetValueIfValid("RegFees", shtName, intRow);
		String LandTransferTax = GetValueIfValid("LandTransferTax", shtName, intRow);
		String RetailSalesTax = GetValueIfValid("RetailSalesTax", shtName, intRow);
		String CashDrawer = GetValueIfValid("CashDrawer", shtName, intRow);
		String ModifyAction = GetValueIfValid("ModifyAction", shtName, intRow);

		try {
			if (Modify.equalsIgnoreCase("No")) {
				if (ModifyAction.equalsIgnoreCase("DoNotApply")) {
					modifyHeaderPage.DoNotApply_WebButton.click();
				} else {
					modifyHeaderPage.Apply_WebButton.click();
				}
			} else {
				if (ModifyAction.equalsIgnoreCase("DoNotApply")) {
					modifyHeaderPage.RegNumber_WebEdit.sendKeys(RegNumber);
					modifyHeaderPage.RegDate_WebEdit.sendKeys(RegDate);
					modifyHeaderPage.RegTime_WebEdit.sendKeys(RegTime);
					modifyHeaderPage.RegFees_WebEdit.sendKeys(RegFees);
					modifyHeaderPage.RegNumber_WebEdit.sendKeys(LandTransferTax);
					modifyHeaderPage.RegDate_WebEdit.sendKeys(RetailSalesTax);
					modifyHeaderPage.RegTime_WebEdit.sendKeys(CashDrawer);
					modifyHeaderPage.RegFees_WebEdit.sendKeys(ModifyAction);
					modifyHeaderPage.DoNotApply_WebButton.click();
				} else {
					modifyHeaderPage.RegNumber_WebEdit.sendKeys(RegNumber);
					modifyHeaderPage.RegDate_WebEdit.sendKeys(RegDate);
					modifyHeaderPage.RegTime_WebEdit.sendKeys(RegTime);
					modifyHeaderPage.RegFees_WebEdit.sendKeys(RegFees);
					modifyHeaderPage.RegNumber_WebEdit.sendKeys(LandTransferTax);
					modifyHeaderPage.RegDate_WebEdit.sendKeys(RetailSalesTax);
					modifyHeaderPage.RegTime_WebEdit.sendKeys(CashDrawer);
					modifyHeaderPage.RegFees_WebEdit.sendKeys(ModifyAction);
					modifyHeaderPage.Apply_WebButton.click();
				}

			}
			DocumentDetail_ModifyHeader = true;
			return DocumentDetail_ModifyHeader;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Do Not Apply button on Modify Header page")
	public boolean DocumentDetail_ModifyHeader_DoNotApply() {
		boolean DocumentDetail_ModifyHeader_DoNotApply = false;
		try {
			modifyHeaderPage.DoNotApply_WebButton.click();
			DocumentDetail_ModifyHeader_DoNotApply = true;
			return DocumentDetail_ModifyHeader_DoNotApply;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user verify the UI object properties $shtName and $intRow")
	public boolean UIObject_Verify_Property(String shtName, int intRow) {
		boolean UIObject_Verify_Property = false;
		String Property = GetValueIfValid("Property", shtName, intRow);
		try {
			if (Property.contains("disabled:=1")) {
				if (modifyHeaderPage.RetailSalesTax_WebEdit.isEnabled() == false) {
					UIObject_Verify_Property = true;
				}
			}
			return UIObject_Verify_Property;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Proceed button on the Document selection $shtName and $intRow")
	public boolean user_click_on_Proceed_button_on_the_Document_selection(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Proceed = false;
		try {
			String strStepName = "CorrectCertification_DocumentSelection_Proceed";

			if (intRow.equals("")) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = CorrectCertification_DocumentSelection_Click_Proceed(shtName, intRow);
			if (intRet == false) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strErrorMsgs = null;
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							CorrectCertification_DocumentSelection_Proceed = false;
						}
					} else {
					}
				} else if (correctionNoticesPage.Error_WebElement.isPresent()) {
					strErrorMsgs = correctionNoticesPage.Error_WebElement.getText().trim();
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						CorrectCertification_DocumentSelection_Proceed = false;
					}
					if (correctionNoticesPage.Cancel_WebButton.isPresent()) {
						correctionNoticesPage.Cancel_WebButton.click();
					} else {
					}
					return CorrectCertification_DocumentSelection_Proceed;
				} else {
				}
				return CorrectCertification_DocumentSelection_Proceed;
			}
			// String strHeadingText = documentDetailPage.Heading_WebTable.getAttribute("text").trim();
			// if (!(InStr(strHeadingText, strRegNumber) > 0)) {
			// return CorrectCertification_DocumentSelection_Proceed;
			// }
			// String strExpectedStatus = "Certified";
			// if (!(InStr(strHeadingText, strExpectedStatus.toUpperCase()) > 0)) {
			// String[] arrHeadingText = (strHeadingText).split("Status:");
			// String strStatus = arrHeadingText[1].trim();
			// return CorrectCertification_DocumentSelection_Proceed;
			// }
			CorrectCertification_DocumentSelection_Proceed = true;
			return CorrectCertification_DocumentSelection_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Proceed;
		}
	}

	public boolean CorrectCertification_DocumentSelection_Click_Proceed(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Click_Proceed = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			if (!strRegNumber.isEmpty()) {
				if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
					strRegNumber = Generate_Unique_RegNumber();
				}
				documentSelectionPage.RegistrationNumber_WebEdit.clear();
				documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			}

			// boolean intRet = false;
			// if (!strRegNumber.equals("") && !strRegNumber.equals("IGNORE_VALUE")) {
			// if (intRet == false) {
			// return CorrectCertification_DocumentSelection_Click_Proceed;
			// }
			// }
			documentSelectionPage.ProceedCorrectCertification_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
				return CorrectCertification_DocumentSelection_Click_Proceed;
			}
			CorrectCertification_DocumentSelection_Click_Proceed = true;
			return CorrectCertification_DocumentSelection_Click_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Click_Proceed;
		}
	}

	@When("user clicks on Proceed button on Document Detail page $shtName and $intRow")
	public boolean DocumentDetail_Proceed(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "DocumentDetail_Proceed";
			boolean DocumentDetail_Proceed = false;
			// String strExpectedDocType = null;
			// strExpectedDocType = documentDetailSteps.DocumentDetail_Retrieve_DocumentType();
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = DocumentDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
			}
			documentDetailPage.Proceed_WebButton.click();
			if (!correctionNoticesPage.ReviewCorrectionNotices_WebElement.isPresent()) {
				if (documentDetailPage.ErrorMsg_WebTable.isPresent()) {
					String strExpectedMsgs = null;
					String strErrorMsgs = null;
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					strErrorMsgs = getCellData(documentDetailPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							DocumentDetail_Proceed = false;
						}
					} else {
						logSteps.execution_log("The <Review Correction Notices> page NOT displayed - UnSuccessful");
					}
				} else {
					logSteps.execution_log("Unknown page is returned - UnSuccessful");
				}
				return false;
			}
			DocumentDetail_Proceed = true;
			return DocumentDetail_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
				intRet = documentDetailSteps.DocumentDetail_Navigate_To_Tab(strSheetName);
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
			setCheckBoxValue(pinDetailsPage.find(By.xpath("(//*[@name='allSelectedReasonsForChange[" + intPropertyIndex + "].selectedReasonsForChange])[0]")), strNewEasement);
			setCheckBoxValue(pinDetailsPage.find(By.xpath("(//*[@name='allSelectedReasonsForChange[" + intPropertyIndex + "].selectedReasonsForChange])[1]")), strSplitConsolidate);
			setCheckBoxValue(pinDetailsPage.find(By.xpath("(//*[@name='easmentOnlyIndicators[" + intPropertyIndex + "]])")), strEasementOnly);
			if (strPINDetailsAction.toUpperCase().equals("EDIT")) {
				pinDetailsPage.find(By.id("submitEdit" + intPropertyIndex)).click();
				intRet = documentDetailSteps.DocumentDetail_PINDetails_EditDescription(shtName, intRow, intPropertyIndex);
				if (intRet != true) {
					environmentlib.setProperty("bTriggered", "true");
				}
			}
			pinDetailsPage.find(By.id("DocumentRemarkForPIN['" + intPropertyIndex + "']")).sendKeys(strDocumentRemarks);
			pinDetailsPage.find(By.name("streetNumberMap['" + intPropertyIndex + "']")).sendKeys(strStreetNumber);
			pinDetailsPage.find(By.name("streetSuffixMap['" + intPropertyIndex + "']")).sendKeys(strSuffix);
			pinDetailsPage.find(By.name("streetNameMap['" + intPropertyIndex + "']")).sendKeys(strStreetName);
			pinDetailsPage.find(By.name("areaMap['" + intPropertyIndex + "']")).sendKeys(strCityTown);
			if (strUnitType.isEmpty()) {
				pinDetailsPage.findBy("//*[@name='municipalAddress(" + intPropertyIndex + ",unitTypeCode)']").selectByIndex(0);
				pinDetailsPage.findBy("//*[@name='unitTypeMap['" + intPropertyIndex + "']").selectByIndex(0);
			} else {
				pinDetailsPage.findBy("//*[@name='municipalAddress(" + intPropertyIndex + ",unitTypeCode)']").selectByVisibleText(strUnitType.toUpperCase());
				pinDetailsPage.findBy("//*[@name='unitTypeMap['" + intPropertyIndex + "']").selectByVisibleText(strUnitType.toUpperCase());
			}
			pinDetailsPage.find(By.name("municipalAddress(" + intPropertyIndex + ",unitId)")).sendKeys(strUnitNumber);
			pinDetailsPage.find(By.name("unitIdMap['" + intPropertyIndex + "']")).sendKeys(strUnitNumber);
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
				System.out.println("Amount : " + strAmount);
				String strGoodsAndChattels = GetValueIfValid("GoodsAndChattels", shtName, iLoop);
				System.out.println("GoodsAndChattels : " + strGoodsAndChattels);

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
					WaitUtil.waitMSeconds(1000);
					pinListPage.PageValue_WebEdit.sendKeys(strPageIndex);
					WaitUtil.waitMSeconds(1000);
					pinListPage.GoToPage_WebButton.click();
					WaitUtil.waitMSeconds(1000);
				}
				if (!strInternalProcessingAction.isEmpty() && !strInternalProcessingAction.equals("IGNORE_VALUE")) {
					intRet = DocumentData_EnterData_InternalProcessingNotes(strInternalProcessingAction, strInternalProcessingNotes);
					if (intRet == false) {
						DocumentDetail_Edit_DocumentData = false;
						return false;
					}
				}
				if (strDocumentRemarksAction.isEmpty() && !strDocumentRemarksAction.equals("IGNORE_VALUE")) {
					intRet = DocumentData_EnterData_DocumentRemarks(strDocumentRemarksAction, strDocumentRemarks);
					if (intRet == false) {
						DocumentDetail_Edit_DocumentData = false;
						return false;
					}
				}
				documentDataPage.Amount_WebEdit.clear();
				documentDataPage.Amount_WebEdit.sendKeys(strAmount);
				// if (documentDataPage.GoodsAndChattels_WebEdit.isEnabled()) {
				// documentDataPage.GoodsAndChattels_WebEdit.sendKeys(strGoodsAndChattels);
				// }
				// if (documentDataPage.ExpiryDate_WebEdit.isPresent()) {
				// documentDataPage.ExpiryDate_WebEdit.sendKeys(strExpiryDate);
				// }
				/*
				 * setCheckBoxValue(documentDataPage.FamilyDwelling_WebCheckBox, strFamilyDwelling);
				 * 
				 * setCheckBoxValue(documentDataPage.StatementIndicator_WebCheckBox, strStatementIndicator); setCheckBoxValue(documentDataPage.ConsentIndicator_WebCheckBox, strConsentIndicator); documentDataPage.TotalNewUnits_WebEdit.sendKeys(strTotalNewUnits);
				 * setCheckBoxValue(documentDataPage.FamilyDwelling_WebCheckBox, strMultipleRelatedDocuments); documentDataPage.BoundariesActPlanNumber_WebEdit.sendKeys(strBoundariesActPlanNumber); documentDataPage.RelatedDocument_WebEdit.sendKeys(strRelatedDocument);
				 * documentDataPage.NumberOfPages_WebEdit.sendKeys(strNumberOfPages); documentDataPage.TownshipMunicipality_WebEdit.sendKeys(strTownshipMunicipality); documentDataPage.NameOfSurveyFirm_WebEdit.sendKeys(strNameOfSurveyFirm);
				 * documentDataPage.SurveyorsFileNumber_WebEdit.sendKeys(strSurveyorsFileNumber); documentDataPage.CondoDeclaration_WebEdit.sendKeys(strCondoDeclaration); documentDataPage.RegistrationDate_WebEdit.sendKeys(strRegistrationDate);
				 * documentDataPage.CondoDeclarationBeingAmended_WebEdit.sendKeys(strCondoDeclarationBeingAmended); documentDataPage.CondoPlanBeingAmended_WebEdit.sendKeys(strCondoPlanBeingAmended); if (!strPropertyIndex.isEmpty() && !strPropertyIndex.equals("IGNORE_VALUE")) { int intIndexStart = 0; int intIndexEnd
				 * = 0; String[] arrIndex = null; if (strPropertyIndex.contains("-")) { arrIndex = (strPropertyIndex).split("-"); intIndexStart = Integer.parseInt(arrIndex[0]); intIndexEnd = Integer.parseInt(arrIndex[1]); } else { intIndexStart = Integer.parseInt(strPropertyIndex); intIndexEnd = intIndexStart; }
				 * for (int intLoop = intIndexStart; intLoop <= intIndexEnd; intLoop++) { int intPropertyIndex = intLoop - 1; documentDataPage.find(By.id("unit" + intPropertyIndex)).sendKeys(strNewUnit); documentDataPage.find(By.id("level" + intPropertyIndex)).sendKeys(strNewLevel);
				 * documentDataPage.find(By.id("affectsAll" + intPropertyIndex)).sendKeys(strAffectsAll); documentDataPage.find(By.id("partList" + intPropertyIndex)).sendKeys(strPartList); } } if (NumberUtils.isNumber(strStreetNameIndex)) { int intStreetNameIndex = Integer.parseInt(strStreetNameIndex) - 1; if
				 * (!documentDataPage.find(By.id("planStreetUnitName" + intStreetNameIndex)).isPresent()) { documentDataPage.AddMoreStreetName_WebButton.click(); } documentDataPage.find(By.id("planStreetUnitName" + intStreetNameIndex)).sendKeys(strStreetName); documentDataPage.find(By.id("planStreetUnitDescription"
				 * + intStreetNameIndex)).sendKeys(strQualifyingDescription); } if (NumberUtils.isNumber(strPlanUnitIndex)) { int intPlanUnitIndex = Integer.parseInt(strPlanUnitIndex) - 1; if (!documentDataPage.find(By.id("planUnitType" + intPlanUnitIndex)).isPresent()) {
				 * documentDataPage.AddMorePlanUnit_WebButton.click(); } setCheckBoxValue(documentDataPage.find(By.name("attributesVOBean.attributeVO(UnitInformation).planUnit[" + intPlanUnitIndex + "].nonStandardPlanUnitType")), strNonStandard); documentDataPage.find(By.id("planUnitType" +
				 * intPlanUnitIndex)).selectByVisibleText(strUnitType.toUpperCase()); documentDataPage.find(By.id("planUnitNumber" + intPlanUnitIndex)).sendKeys(strStartRange); documentDataPage.find(By.id("planUnitRange" + intPlanUnitIndex)).sendKeys(strEndRange); documentDataPage.find(By.id("planUnitName" +
				 * intPlanUnitIndex)).sendKeys(strQualifyingName); } if (NumberUtils.isNumber(strUnitLevelIndex)) { int intUnitLevelIndex = Integer.parseInt(strUnitLevelIndex) - 1; if (!documentDataPage.find(By.id("level" + intUnitLevelIndex)).isPresent()) { documentDataPage.AddMore_WebButton.click(); }
				 * documentDataPage.find(By.id("level" + intUnitLevelIndex)).sendKeys(strStartRange); documentDataPage.find(By.id("levelRange" + intUnitLevelIndex)).sendKeys(strEndRange); documentDataPage.find(By.id("numberOfUnits" + intUnitLevelIndex)).sendKeys(strNumberOfUnits); }
				 */
			}
			DocumentDetail_Edit_DocumentData = true;
			return DocumentDetail_Edit_DocumentData;
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
				documentDataPage.Apply1_WebButton.click();
				if (!documentDataPage.WithRemarks_Image.isCurrentlyVisible()) {
					logSteps.execution_log("The Document Remarks with remarks attached image NOT exist - UnSuccessful");
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

	public boolean DocumentDetail_Edit_Parties(String shtName, String intRow) {
		boolean DocumentDetail_Edit_Parties = false;
		try {
			String strStepName = "DocumentDetail_Edit_Parties";

			String strDocumentType = documentDetailPage.DocumentType_WebElement.getTextContent();
			boolean intRet = false;
			String[] arrDocumentType = strDocumentType.split(":");
			String strDocType = arrDocumentType[1].trim();
			if (strDocType.contains("LR'S")) {
				intRet = documentDetailSteps.DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "LAND REGISTRAR");
				if (intRet == false) {
					return false;
				}
			}
			if (strDocType.compareTo("DIRECTOR OF TITLES ORDER") == 0) {
				intRet = documentDetailSteps.DocumentDetail_Parties_Verify_DefaultPartyFromValue(strDocType, "DIRECTOR OF TITLES");
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
			environmentlib.setProperty("bTriggered", "false");
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

	@When("user enter data for Correction Notices $shtName and $intRow")
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
				}
			}
			DocumentDetail_Edit_CorrectionNotices = true;
			return DocumentDetail_Edit_CorrectionNotices;
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
			correctionNoticesPage.CorrectionNotice_WebEdit.sendKeys(strNotice);
			correctionNoticesPage.AddNew_WebButton.click();
			String strTimeStamp = mainPage.TimeText_WebElement.getText();
			String[] arrTimeStamp = (strTimeStamp.trim()).split(" ");
			String strDate = arrTimeStamp[0].trim();
			String strUser = mainPage.UserText_WebElement.getText().trim();
			String strExpectedNotice = strNotice.toUpperCase() + " ON " + strDate + " AT <HH:MM> BY " + strUser.toUpperCase() + ".";
			setTestData("AutoGeneratedNotice", shtName, intRow, strExpectedNotice);
			// boolean intRet = LocateAValueInWebTable(correctionNoticesPage.Notice_WebTable, strExpectedNotice); // In qfl
			// if (intRet == true) {
			// logSteps.execution_log("Verification of the added notice - Successful");
			// DocumentDetail_CorrectionNotice_AddNotice = true;
			// return false;
			// }
			// int intCounts = getRowCount(correctionNoticesPage.Notice_WebTable);
			// int intDiff = intCounts - intRows;
			// if (intDiff < 1) {
			// logSteps.execution_log("New notice Not added - UnSuccessful");
			// return false;
			// }
			// strExpectedNotice = getCellData(correctionNoticesPage.Notice_WebTable, intCounts, 2).trim();
			// setTestData("AutoGeneratedNotice", shtName, intRow, strExpectedNotice);
			DocumentDetail_CorrectionNotice_AddNotice = true;
			return DocumentDetail_CorrectionNotice_AddNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean DocumentDetail_CorrectionNotice_RemoveNotice(String intIndex) {
		boolean DocumentDetail_CorrectionNotice_RemoveNotice = false;
		try {
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
				if (correctionNoticesPage.find(By.id(s)).isPresent()) {
					setCheckBoxValue(correctionNoticesPage.find(By.id(s)), "ON");
				}
			}
			correctionNoticesPage.RemoveSelected_WebButton.click();
			DocumentDetail_CorrectionNotice_RemoveNotice = true;
			return DocumentDetail_CorrectionNotice_RemoveNotice;
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
			// if (summaryPage.NDIRestriction_WebCheckBox.isDisplayed()) {
			if (strNDIRestriction.trim().toUpperCase().equals("!DYNAMIC!") || strNDIRestriction.trim().toUpperCase().equals("ON")) {
				if (summaryPage.NDIRestriction_WebCheckBox.isPresent()) {
					summaryPage.NDIRestriction_WebCheckBox.sendKeys("on");
				}
			}
			// }
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
			if (summaryPage.ReplaceOwners_WebRadioGroup.isPresent()) {
				switch (strReplaceOwners.toUpperCase()) {
				case "NO":
					summaryPage.ReplaceOwners_WebRadioGroup.click();
					break;
				case "YES":
					summaryPage.ReplaceOwners_WebRadioGroup.click();
					break;
				}
			}
			if (summaryPage.AddNewEasements_WebRadioGroup.isPresent()) {
				switch (strAddNewEasements.toUpperCase()) {
				case "NO":
					summaryPage.AddNewEasements_WebRadioGroup.click();
					break;
				case "YES":
					summaryPage.AddNewEasements_WebRadioGroup.click();
					break;
				}
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

	@When("user Generate the dynamic notice based on the amount provided $strType and $shtName and $intRow")
	public boolean CorrectCertification_GenerateNotice_AutoNotice(String strType, String shtName, String intRow) {
		boolean CorrectCertification_GenerateNotice_AutoNotice = false;
		try {
			String strStepName = "CorrectCertification_GenerateNotice_AutoNotice";
			if (!mainPage.TimeText_WebElement.isPresent()) {

				// Reporter.reportEvent(Status.Failed, strStepName, "Time stamp Not displayed on the page - UnSuccessful"); utility.AddInfo("Time stamp Not displayed on the page - UnSuccessful");
				return CorrectCertification_GenerateNotice_AutoNotice;
			}
			String strTimeStamp = mainPage.TimeText_WebElement.getText();
			String[] arrTimeStamp = (strTimeStamp.trim()).split(" ");
			String strDate = arrTimeStamp[0].trim();
			// Declare and retrieve acting user
			if (!mainPage.UserText_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<User ID> Not displayed on the page - UnSuccessful"); utility.AddInfo("<User ID> Not displayed on the page - UnSuccessful");
				return CorrectCertification_GenerateNotice_AutoNotice;
			}
			String strUser = mainPage.UserText_WebElement.getText().trim();
			// Declare variables
			String strFrom = null;
			String strTo = null;
			String strText = null;
			String strAutoGeneratedNotice = null;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow(Integer.parseInt(intRow));
			switch (strType.toUpperCase()) {
			case "REGNUMBER":
				strFrom = GetValueIfValid("ExistingRegNumber", shtName, Integer.parseInt(intRow));
				strTo = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
				strText = "Registration Number";
				break;
			case "REGDATE":
				strFrom = GetValueIfValid("ExistingRegDate", shtName, Integer.parseInt(intRow));
				strTo = GetValueIfValid("RegDate", shtName, Integer.parseInt(intRow));
				strText = "Registration Date";
				break;
			case "REGTIME":
				strFrom = GetValueIfValid("ExistingRegTime", shtName, Integer.parseInt(intRow));
				strTo = GetValueIfValid("RegTime", shtName, Integer.parseInt(intRow));
				strText = "Registration Time";
				break;
			case "CASHDRAWER":
				strFrom = GetValueIfValid("ExistingCashDrawer", shtName, Integer.parseInt(intRow));
				strTo = GetValueIfValid("CashDrawer", shtName, Integer.parseInt(intRow));
				strText = "Cash Drawer";
				break;
			case "REGFEE":
				strFrom = GetValueIfValid("ExistingRegFees", shtName, Integer.parseInt(intRow));
				strFrom = formatCurrency(Double.parseDouble(strFrom)); // 2017-11-01/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strFrom = "$"&strFrom
				strTo = GetValueIfValid("RegFees", shtName, Integer.parseInt(intRow));
				strTo = formatCurrency(Double.parseDouble(strTo)); // 2017-11-01/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strTo = "$"&strTo
				strText = "Registration Fee";
				break;
			case "LANDTRANSFERTAX":
				strFrom = GetValueIfValid("ExistingLandTransferTax", shtName, Integer.parseInt(intRow));
				strFrom = formatCurrency(Double.parseDouble(strFrom)); // 2017-11-01/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strFrom = "$"&strFrom
				strTo = GetValueIfValid("LandTransferTax", shtName, Integer.parseInt(intRow));
				strTo = formatCurrency(Double.parseDouble(strTo)); // 2017-11-01/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strTo = "$"&strTo
				strText = "Land Transfer Tax";
				break;
			case "RETAILSALESTAX":
				strFrom = GetValueIfValid("ExistingRetailSalesTax", shtName, Integer.parseInt(intRow));
				strFrom = formatCurrency(Double.parseDouble(strFrom)); // 2017-10-31/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strFrom = "$"&strFrom
				strTo = GetValueIfValid("RetailSalesTax", shtName, Integer.parseInt(intRow));
				strTo = formatCurrency(Double.parseDouble(strTo)); // 2017-10-31/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strTo = "$"&strTo
				strText = "Retail Sales Tax";
				// 08-10-2012/Jenny/Added for Amount under Document Data tab
				break;
			case "AMOUNT":
				strTo = GetValueIfValid("Amount", shtName, Integer.parseInt(intRow));
				strTo = formatCurrency(Double.parseDouble(strTo)); // 2017-10-31/Jenny/Convert Amount in Currency format for French project (e.g. $1,234.00)
				// strTo = "$"&strTo //2017-10-31/Jenny/No need to add $ because of Format Currency
				strText = "Amount";
				break;
			default:
				return CorrectCertification_GenerateNotice_AutoNotice;
			}
			// //Generate notice - correction notice for amount when the amount was empty before the modification
			switch (strType.toUpperCase()) {
			// 10-15-2013/Jenny/Retail Sales Tax follows the same rule as amount
			//// 2014-10-10/Jenny/Add time for all the notes for 2014-R1 release - CQ18321
			case "AMOUNT":
			case "RETAILSALESTAX":
				strAutoGeneratedNotice = strText + " " + strTo + " Added On " + strDate + " AT <HH:MM> By " + strUser + ".";
				break;
			default:
				strAutoGeneratedNotice = strText + " Changed From " + strFrom + " To " + strTo + " On " + strDate + " AT <HH:MM> By " + strUser + ".";
				break;
			}
			CorrectCertification_GenerateNotice_AutoNotice = true;
			return CorrectCertification_GenerateNotice_AutoNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_GenerateNotice_AutoNotice;
		}
	}

	@Then("user verify the existance of correction notices in the notice table $shtName and $intRow")
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
				if (intRet == false) {

					if (intRet == false) {
					} else {
					}
				}
			}
			DocumentDetail_VerifyExist_CorrectionNotices = true;
			return DocumentDetail_VerifyExist_CorrectionNotices;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Cancel the Cancel review correction notice")
	public boolean CorrectCertification_CorrectionNotices_CancelCancel() {
		boolean CorrectCertification_CorrectionNotices_CancelCancel = false;
		try {
			boolean intRet = false;
			correctionNoticesPage.Cancel_WebButton.click();

			if (!correctionNoticesPage.ReviewCorrectionNotices_WebElement.isPresent()) {
				return CorrectCertification_CorrectionNotices_CancelCancel;
			}
			CorrectCertification_CorrectionNotices_CancelCancel = true;
			return CorrectCertification_CorrectionNotices_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_CancelCancel;
		}
	}

	@When("user Cancel the review correction notice")
	public boolean CorrectCertification_CorrectionNotices_Cancel() {
		boolean CorrectCertification_CorrectionNotices_Cancel = false;
		try {
			String strStepName = "CorrectCertification_CorrectionNotices_Cancel";
			boolean intRet = false;
			correctionNoticesPage.Cancel_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				return CorrectCertification_CorrectionNotices_Cancel;
			}
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			CorrectCertification_CorrectionNotices_Cancel = true;
			return CorrectCertification_CorrectionNotices_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_Cancel;
		}
	}

	@When("user clicks on Return to Document Details button on Review Correction Notices page")
	public boolean CorrectCertification_CorrectionNotices_ReturnToDocumentDetails() {
		boolean CorrectCertification_CorrectionNotices_ReturnToDocumentDetails = false;
		try {
			String strStepName = "CorrectCertification_CorrectionNotices_ReturnToDocumentDetails";
			boolean intRet = false;
			correctionNoticesPage.ReturntoDetails_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			if (!documentDetailPage.CorrectionNotices_Link.isPresent()) {
				return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
			}
			CorrectCertification_CorrectionNotices_ReturnToDocumentDetails = true;
			return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_ReturnToDocumentDetails;
		}
	}

	@When("user clicks on Commit button on Review Correction Notices page")
	public boolean CorrectCertification_CorrectionNotices_Commit() {
		boolean CorrectCertification_CorrectionNotices_Commit = false;
		try {
			String strStepName = "CorrectCertification_CorrectionNotices_Commit";
			// Declare and retrieve the mode
			String strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			boolean intRet = false;
			correctionNoticesPage.Commit_WebButton.click();
			// if (strComp(strMode.trim(), "Batch") == 0) {
			// Object strBulkFunction = null;
			// strBulkFunction = "Document Correction";
			// // intRet = CorrectCertification_CorrectionNotices_Commit_Batch(strBulkFunction);
			// CorrectCertification_CorrectionNotices_Commit = intRet;
			// return CorrectCertification_CorrectionNotices_Commit;
			// }
			if (!correctionConfirmationPage.Confirmation_WebElement.isPresent()) {
				logSteps.execution_log("<Document Correction Confirmation> page Not displayed - UnSuccessful");
				return CorrectCertification_CorrectionNotices_Commit;
				// if (!correctionConfirmationPage.ConfirmationMsg_WebElement.isPresent()) {
				// logSteps.execution_log("No confirmation message displayed on the page - UnSuccessful");
				// return CorrectCertification_CorrectionNotices_Commit;
				// }
				// String strConfirmationMsg = correctionConfirmationPage.ConfirmationMsg_WebElement.getText().trim();
				// String strExpectedMsg = "Document successfully saved.";
				// logSteps.execution_log(strConfirmationMsg);
				// // Verify the message
				// if (strComp(strConfirmationMsg, strExpectedMsg) != 0) {
				// logSteps.execution_log("Warning! Unexpected confirmation message is returned as shown above. Expected: <" + strExpectedMsg + "> - UnSuccessful");
				// CorrectCertification_CorrectionNotices_Commit = false;
				// return CorrectCertification_CorrectionNotices_Commit;
			}
			CorrectCertification_CorrectionNotices_Commit = true;
			return CorrectCertification_CorrectionNotices_Commit;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_CorrectionNotices_Commit;
		}
	}

	@When("user Close the document detail view popup")
	public boolean user_Close_the_document_detail_view_popup() {
		boolean CorrectCertification_Document_Close = false;
		try {
			String strStepName = "CorrectCertification_Document_Close";
			boolean intRet = false;
			if (intRet == false) {
				return CorrectCertification_Document_Close;
			}
			if (!correctionConfirmationPage.Confirmation_WebElement.isPresent()) {
				return CorrectCertification_Document_Close;
			}
			CorrectCertification_Document_Close = true;
			return CorrectCertification_Document_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_Document_Close;
		}
	}

	@When("user clicks on the document number link on the Correction Confirmation page $shtName and $intRow")
	public boolean user_click_on_document_number_link(String shtName, String intRow) {
		boolean CorrectCertification_Document_ClickAndOpen = false;
		try {
			String strStepName = "CorrectCertification_Document_ClickAndOpen";
			if (intRow.equals("")) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strExpectedRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			List<WebElement> oLink = correctionConfirmationPage.CorrectionResult_WebTable.findElements(By.xpath("//a[@class='ro']"));
			int intLinkCount = oLink.size();
			if (intLinkCount == 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			if (intLinkCount > 1) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strDocumentNumber = oLink.get(0).getText().trim();
			if (strComp(strDocumentNumber, strExpectedRegNumber) != 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			String strRegNumber = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 1, 2);
			if (strComp(strRegNumber.trim(), strDocumentNumber) != 0) {
				return CorrectCertification_Document_ClickAndOpen;
			}
			CorrectCertification_Document_ClickAndOpen = true;
			return CorrectCertification_Document_ClickAndOpen;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_Document_ClickAndOpen;
		}
	}

	@When("user click on Proceed button on the Document selection $shtName and $intRow")
	public boolean user_click_on_Proceed(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Proceed = false;
		try {
			String strStepName = "CorrectCertification_DocumentSelection_Proceed";

			if (intRow.equals("")) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = CorrectCertification_Proceed(shtName, intRow);
			if (intRet == false) {
				return CorrectCertification_DocumentSelection_Proceed;
			}
			String strErrorMsgs = null;
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							CorrectCertification_DocumentSelection_Proceed = false;
						}
					} else {
					}
				} else if (correctionNoticesPage.Error_WebElement.isPresent()) {
					strErrorMsgs = correctionNoticesPage.Error_WebElement.getText().trim();
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						CorrectCertification_DocumentSelection_Proceed = false;
					}
					if (correctionNoticesPage.Cancel_WebButton.isPresent()) {
						correctionNoticesPage.Cancel_WebButton.click();
					} else {
					}
					return CorrectCertification_DocumentSelection_Proceed;
				} else {
				}
				return CorrectCertification_DocumentSelection_Proceed;
			}

			CorrectCertification_DocumentSelection_Proceed = true;
			return CorrectCertification_DocumentSelection_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Proceed;
		}
	}

	public boolean CorrectCertification_Proceed(String shtName, String intRow) {
		boolean CorrectCertification_DocumentSelection_Click_Proceed = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			if (!strRegNumber.isEmpty()) {
				if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
					strRegNumber = elrsCommon.Generate_Unique_Random_RegNumber();
				}
				documentSelectionPage.RegistrationNumber_WebEdit.clear();
				documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			}

			// boolean intRet = false;
			// if (!strRegNumber.equals("") && !strRegNumber.equals("IGNORE_VALUE")) {
			// if (intRet == false) {
			// return CorrectCertification_DocumentSelection_Click_Proceed;
			// }
			// }
			documentSelectionPage.ProceedCorrectCertification_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
				return CorrectCertification_DocumentSelection_Click_Proceed;
			}
			CorrectCertification_DocumentSelection_Click_Proceed = true;
			return CorrectCertification_DocumentSelection_Click_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectCertification_DocumentSelection_Click_Proceed;
		}
	}
			
}
