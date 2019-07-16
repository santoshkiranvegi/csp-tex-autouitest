package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import ca.teranet.pages.polaris.UpdateCertifiedPropertyBulkPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import net.thucydides.core.annotations.Steps;

public class UpdateCertifiedPropertyBulk extends Utility {

	UpdateCertifiedPropertyBulkPage updateCertifiedPropertyBulkPage;
	@Steps
	ELRSCommonSteps elrsCommon;
	LogSteps logSteps;

	@When("user cancels the Cancel Update Certified Property Bulk $shtName and $intRow")
	public boolean UpdateCertifiedPropertyBulk_CancelCancel(String shtName, String intRow) {
		try {
			boolean UpdateCertifiedPropertyBulk_CancelCancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = UpdateCertifiedPropertyBulk_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			String strPreRegNumber = null;
			String strPreBlock = null;
			String strPrePINFrom = null;
			String oPage = null;
			oPage = null;
			strPreRegNumber = updateCertifiedPropertyBulkPage.RegistrationNum_WebEdit.getText();
			strPreBlock = updateCertifiedPropertyBulkPage.find(By.id("pin0block")).getText();
			strPrePINFrom = updateCertifiedPropertyBulkPage.find(By.id("pin0num")).getText();
			updateCertifiedPropertyBulkPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "Cancel";
			intRet = elrsCommon.ELRS_Popup_Cancel(strAction);
			intRet = UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded(strPreRegNumber);
			intRet = UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded(strPreBlock, strPrePINFrom);
			UpdateCertifiedPropertyBulk_CancelCancel = true;
			return UpdateCertifiedPropertyBulk_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels the Cancel Update Certified Property Bulk")
	public boolean UpdateCertifiedPropertyBulk_CancelCancel() {
		try {
			boolean UpdateCertifiedPropertyBulk_CancelCancel = false;
			boolean intRet = false;
			String strPreRegNumber = null;
			String strPreBlock = null;
			String strPrePINFrom = null;
			String oPage = null;
			oPage = null;
			updateCertifiedPropertyBulkPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "Cancel";
			intRet = elrsCommon.ELRS_Popup_Cancel(strAction);
			intRet = UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded(strPreRegNumber);
			intRet = UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded(strPreBlock, strPrePINFrom);
			UpdateCertifiedPropertyBulk_CancelCancel = true;
			return UpdateCertifiedPropertyBulk_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateCertifiedPropertyBulk_EnterData(String shtName, String intRow) {
		try {
			boolean UpdateCertifiedPropertyBulk_EnterData = false;
			int intStart = 0;
			int intEnd = 0;
			String arrRows[] = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strAddPINAction = null;
			String strRegistrationNum = null;
			String strTargetPINIndex = null;
			String strTargetBlock = null;
			String strTargetPINFrom = null;
			String strTargetPINTo = null;
			String oPage = null;
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strAddPINAction = GetValueIfValid("AddPINAction", shtName, iLoop);
				strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, iLoop);
				strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				strTargetBlock = GetValueIfValid("TargetBlock", shtName, iLoop);
				strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, iLoop);
				strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, iLoop);
				intRet = true;
				switch (strAddPINAction.toUpperCase()) {
				case "RETRIEVEPINS":
				case "RETRIEVE PINS":
					intRet = UpdateCertifiedPropertyBulk_RetrievePINs(shtName, String.valueOf(iLoop));
					// Case "ADDPIN", "ADD PIN"
					// Case "REMOVEPIN", "REMOVE", "REMOVESELECTED", "REMOVE SELECTED"
					break;
				default:
					if (!strRegistrationNum.isEmpty() && !strRegistrationNum.equals("IGNORE_VALUE")) {
						// oPage.WebEdit("RegistrationNum").SetValue(strRegistrationNum);
						updateCertifiedPropertyBulkPage.RegistrationNum_WebEdit.sendKeys(strRegistrationNum);
					}
					break;
				}
				if (intRet == false) {
					oPage = null;
					return false;
				}
				if (isNumeric(strTargetPINIndex)) {
					int intTargetPINIndex = 0;
					intTargetPINIndex = Math.round(Integer.parseInt(strTargetPINIndex)) - 1;
					// oPage.WebEdit("name:=pin\[" &intTargetPINIndex& "\]\.block").SetValue(strTargetBlock)
					// oPage.WebEdit("name:=pin\[" &intTargetPINIndex& "\]\.property").SetValue(strTargetPINFrom)
					// oPage.WebEdit("name:=pin\[" &intTargetPINIndex& "\]\.range").SetValue(strTargetPINTo)
					// oPage.WebEdit("html id:=pin"+intTargetPINIndex+"block").SetValue(strTargetBlock);
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "block")).clear();
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "block")).sendKeys(strTargetBlock);
					// oPage.WebEdit("html id:=pin"+intTargetPINIndex+"num").SetValue(strTargetPINFrom);
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "num")).clear();
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "num")).sendKeys(strTargetPINFrom);
					// oPage.WebEdit("html id:=pin"+intTargetPINIndex+"range").SetValue(strTargetPINTo);
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "range")).clear();
					updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "range")).sendKeys(strTargetPINTo);
				}
			}
			oPage = null;
			UpdateCertifiedPropertyBulk_EnterData = true;
			return UpdateCertifiedPropertyBulk_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateCertifiedPropertyBulk_RetrievePINs(String shtName, String intRow) {
		try {
			boolean UpdateCertifiedPropertyBulk_RetrievePINs = false;
			String strRegistrationNum = null;
			String strExpectedMsgs = null;
			strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, Integer.parseInt(intRow));
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String oPage = null;
			// oPage.WebEdit("RegistrationNum").SetValue(strRegistrationNum);
			updateCertifiedPropertyBulkPage.RegistrationNum_WebEdit.clear();
			updateCertifiedPropertyBulkPage.RegistrationNum_WebEdit.sendKeys(strRegistrationNum);
			String strErrorMsgs = null;
			boolean intRet = false;
			// Verify the data
			intRet = UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded(strRegistrationNum);
			oPage = null;
			UpdateCertifiedPropertyBulk_RetrievePINs = true;
			return UpdateCertifiedPropertyBulk_RetrievePINs;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded(String strExpectedRegNumber) {
		try {
			boolean UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded = false;
			String strActualRegNumber = null;
			// Retrieve data on the current screen
			strActualRegNumber = updateCertifiedPropertyBulkPage.RegistrationNum_WebEdit.getText();
			// Verify the registration number
			if (!strActualRegNumber.equals(strExpectedRegNumber)) {
				return false;
			}
			UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded = true;
			return UpdateCertifiedPropertyBulk_VerifyRegNumberNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded(String strExpectedBlock, String strExpectedPINFrom) {
		try {
			boolean UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded = false;
			String strActualBlock = null;
			String strActualPINFrom = null;
			int intTargetPINIndex = 0;
			// strActualBlock = updateCertifiedPropertyBulkPage.htmlidpin0block_webedit.getAttribute("value");
			strActualBlock = updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "block")).getAttribute("value");
			// strExpectedPINFrom = updateCertifiedPropertyBulkPage.htmlidpin0num_webedit.getAttribute("value");
			strActualPINFrom = updateCertifiedPropertyBulkPage.find(By.id("pin" + intTargetPINIndex + "num")).getAttribute("value");
			if (!strActualBlock.equals(strExpectedBlock) && !strActualPINFrom.equals(strExpectedPINFrom)) {
				return false;
			}
			UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded = true;
			return UpdateCertifiedPropertyBulk_VerifyPINNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Update Certified Property Bulk $shtName and $intRow")
	public boolean UpdateCertifiedPropertyBulk_Cancel(String shtName, String intRow) {
		try {
			boolean UpdateCertifiedPropertyBulk_Cancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = UpdateCertifiedPropertyBulk_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			updateCertifiedPropertyBulkPage.Cancel_WebButton.click();
			// utility.AddInfo("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "OK";
			intRet = elrsCommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			intRet = elrsCommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return false;
			}
			UpdateCertifiedPropertyBulk_Cancel = true;
			return UpdateCertifiedPropertyBulk_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Update Certified Property Bulk")
	public boolean UpdateCertifiedPropertyBulk_Cancel() {
		try {
			boolean UpdateCertifiedPropertyBulk_Cancel = false;
			boolean intRet = false;
			updateCertifiedPropertyBulkPage.Cancel_WebButton.click();
			// utility.AddInfo("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "OK";
			intRet = elrsCommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			intRet = elrsCommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return false;
			}
			// logSteps.execution_log("<Main Menu> page is displayed - Successful");
			UpdateCertifiedPropertyBulk_Cancel = true;
			return UpdateCertifiedPropertyBulk_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
