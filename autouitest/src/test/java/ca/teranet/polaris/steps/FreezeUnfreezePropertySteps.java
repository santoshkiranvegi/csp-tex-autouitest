package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import ca.teranet.pages.polaris.ELRSPage;
import ca.teranet.pages.polaris.FreezeUnfreezePropertyPage;
import ca.teranet.pages.polaris.FreezeUnfreezeSelectionPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.RegisterViewPopupPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;

public class FreezeUnfreezePropertySteps extends Utility {

	FreezeUnfreezePropertyPage freezeUnfreezePropertyPage;
	FreezeUnfreezeSelectionPage freezeUnfreezeSelectionPage;
	LogSteps logSteps = new LogSteps();
	MainPage mainPage;
	ELRSPage eLRSPage;
	RegisterViewPopupPage registerViewPopupPage;

	public static void main(String[] args) throws Exception {
	}

	@When("user clicks the Proceed button on the Update Certified Property Freeze and Unfreeze PIN Entry page $PINENTRYSHEETNAME and $PINENTRYROW1")
	public boolean user_click_the_proceed_button_on_the_update_certified_property_freeze_and_unfreeze(String shtName, String intRow) {
		boolean FreezeUnfreezeProperty_PINEntry_Proceed = false;
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeProperty_PINEntry_Proceed";
			int intRowIndex = 0;
			if (intRow.isEmpty()) {
				return false;
			} else {
				if (intRow.contains("-")) {
					String[] arrRows = null;
					arrRows = (intRow).split("-");
					intRowIndex = Integer.parseInt(arrRows[0]);
				} else {
					intRowIndex = Math.round(Integer.parseInt(intRow));
				}
			}
			String strExpectedMsgs = null;
			String strErrorMsgs = null;

			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRowIndex);
			boolean intRet = false;
			intRet = FreezeUnfreezeProperty_PINEntry_EnterData(shtName, intRow);
			if (intRet == false) {
				return false;
			}
			freezeUnfreezePropertyPage.Proceed_WebButton.click();
			freezeUnfreezePropertyPage.getActiveElement();
			VerifyApplicationError();
			if (!freezeUnfreezeSelectionPage.Header_WebElement.isPresent()) {
				freezeUnfreezePropertyPage.Proceed_WebButton.click();
				if (freezeUnfreezePropertyPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(freezeUnfreezePropertyPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							FreezeUnfreezeProperty_PINEntry_Proceed = false;
						}
					} else {
						logSteps.execution_log("<Freeze/Unfreeze Selection> page Not displayed - UnSuccessful");
					}
				} else {
					logSteps.execution_log("Unknown page is returned - UnSuccessful");
				}
				return false;
			}
			FreezeUnfreezeProperty_PINEntry_Proceed = true;
			return FreezeUnfreezeProperty_PINEntry_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FreezeUnfreezeProperty_PINEntry_EnterData(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeProperty_PINEntry_EnterData";
			boolean FreezeUnfreezeProperty_PINEntry_EnterData = false;
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
			String strAddPINAction = null;
			String strRegistrationNum = null;
			String strTCPL = null;
			String strHWY = null;
			String strTargetPINIndex = null;
			String strTargetBlock = null;
			String strTargetPINFrom = null;
			String strTargetPINTo = null;
			String oPage = null;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strAddPINAction = GetValueIfValid("AddPINAction", shtName, iLoop);
				strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, iLoop);
				strTCPL = GetValueIfValid("TCPL", shtName, iLoop);
				strHWY = GetValueIfValid("HWY", shtName, iLoop);
				strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, iLoop);
				strTargetBlock = GetValueIfValid("TargetBlock", shtName, iLoop);
				strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, iLoop);
				strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, iLoop);
				boolean intRet = true;
				environmentlib.setProperty("bTriggered", "false");
				switch (strAddPINAction.toUpperCase()) {
				case "RETRIEVEPINS":
				case "RETRIEVE PINS":
					intRet = FreezeUnfreezeProperty_PINEntry_RetrievePINs(shtName, String.valueOf(iLoop));
					break;
				case "ADDPIN":
				case "ADD PIN":
					break;
				case "REMOVEPIN":
				case "REMOVE":
				case "REMOVESELECTED":
				case "REMOVE SELECTED":
					break;
				default:
					if (!strRegistrationNum.isEmpty() && !strRegistrationNum.equals("IGNORE_VALUE")) {
						freezeUnfreezePropertyPage.RegistrationNum_WebEdit.sendKeys(strRegistrationNum);
					}
					break;
				}
				if (intRet == false) {
					oPage = null;
					return false;
				}
				if (!(freezeUnfreezePropertyPage.TCPL_WebCheckBox.isSelected())) {
					freezeUnfreezePropertyPage.TCPL_WebCheckBox.click();
				}
				if (!(freezeUnfreezePropertyPage.HWY_WebCheckBox.isSelected())) {
					freezeUnfreezePropertyPage.HWY_WebCheckBox.click();
				}
				if (isNumeric(strTargetPINIndex)) {
					int intTargetPINIndex = 0;
					intTargetPINIndex = Math.round(Integer.parseInt(strTargetPINIndex)) - 1;
					if (!freezeUnfreezePropertyPage.find(By.name("pin[" + intTargetPINIndex + "].block")).isPresent())

					{
						freezeUnfreezePropertyPage.AddPIN_WebButton.click();
					}
				}
				if (environmentlib.getProperty("bTriggered").equals("true")) {
					oPage = null;
					return false;
				}
			}
			oPage = null;
			FreezeUnfreezeProperty_PINEntry_EnterData = true;
			return FreezeUnfreezeProperty_PINEntry_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FreezeUnfreezeProperty_PINEntry_RetrievePINs(String shtName, String intRow) {
		boolean FreezeUnfreezeProperty_PINEntry_RetrievePINs = false;
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeProperty_PINEntry_RetrievePINs";
			if (shtName.isEmpty() && intRow.isEmpty()) {
				return false;
			}
			String strRegistrationNum = GetValueIfValid("RegistrationNum", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String oPage = null;
			environmentlib.setProperty("bTriggered", "false");
			freezeUnfreezePropertyPage.RegistrationNum_WebEdit.sendKeys(strRegistrationNum);
			freezeUnfreezePropertyPage.RegistrationNum_WebEdit.click();
			freezeUnfreezePropertyPage.RetrievePINs_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				oPage = null;
				return false;
			}
			String strErrorMsgs = null;
			boolean intRet = false;
			strErrorMsgs = getCellData(freezeUnfreezePropertyPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					FreezeUnfreezeProperty_PINEntry_RetrievePINs = false;
				}
				intRet = FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded(strRegistrationNum);
				if (intRet == false) {
					FreezeUnfreezeProperty_PINEntry_RetrievePINs = false;
				}
				oPage = null;
				return false;
			}
			String strActualBlock = null;
			String strActualPINFrom = null;
			strActualBlock = freezeUnfreezePropertyPage.element("value");
			strActualPINFrom = freezeUnfreezePropertyPage.element("value");
			oPage = null;
			if (strActualBlock.isEmpty() || strActualPINFrom.isEmpty()) {
				return false;
			}
			FreezeUnfreezeProperty_PINEntry_RetrievePINs = true;
			return FreezeUnfreezeProperty_PINEntry_RetrievePINs;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded(String strExpectedRegNumber) {
		boolean FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded = false;
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded";
			String strActualRegNumber = null;
			strActualRegNumber = freezeUnfreezePropertyPage.RegistrationNum_WebEdit.getAttribute("value");
			if (!(strComp(strActualRegNumber, strExpectedRegNumber) == 0)) {
				return false;
			}
			FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded = true;
			return FreezeUnfreezeProperty_VerifyRegNumberNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks OK button Cancel on Freeze/Unfreeze Selection page")
	public boolean user_clicks_OK_button_Cancel_on_freeze_unfreeze_selection_page() {
		try {
			boolean FreezeUnfreezeProperty_Selection_Cancel = false;
			freezeUnfreezeSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			if (!freezeUnfreezeSelectionPage.Header_WebElement.isPresent()) {
				return false;
			}
			FreezeUnfreezeProperty_Selection_Cancel = true;
			return FreezeUnfreezeProperty_Selection_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks the Proceed button on the Freeze/Unfreeze Selection page $SELECTIONSHEETNAME and $SELECTIONROW5")
	public boolean user_clicks_the_proceed_button_on_the_freeze_unfreeze_selection_page(String shtName, String intRow) {
		boolean FreezeUnfreezeProperty_Selection_Proceed = false;
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeSelection_Proceed";
			boolean intRet = false;
			String intOption = null;
			intRet = FreezeUnfreezeProperty_Selection_EnterData(shtName, intRow);
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if ((freezeUnfreezeSelectionPage.ErrorMsg_WebTable.containsText(strExpectedMsgs))) {
				freezeUnfreezePropertyPage.Proceed_WebButton.click();
			} else {
				freezeUnfreezePropertyPage.Unfreeze_Update_radiobtn.click();
				freezeUnfreezePropertyPage.Proceed_WebButton.click();
			}
			if (freezeUnfreezeSelectionPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(freezeUnfreezeSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
				System.out.println(strErrorMsgs);
				if (!strErrorMsgs.isEmpty()) {
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						FreezeUnfreezeProperty_Selection_Proceed = false;
					}
				}
			}
			FreezeUnfreezeProperty_Selection_Proceed = true;
			return FreezeUnfreezeProperty_Selection_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean FreezeUnfreezeProperty_Selection_EnterData(String shtName, String intRow) {
		boolean FreezeUnfreezeProperty_Selection_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "FreezeUnfreezeProperty_Selection_EnterData";
			String strFreezeUnfreezeOption = null;
			String strUser = null;
			String strUserIndex = null;
			strFreezeUnfreezeOption = GetValueIfValid("FreezeUnfreezeOption", shtName, Integer.parseInt(intRow));
			strUser = GetValueIfValid("User", shtName, Integer.parseInt(intRow));
			strUserIndex = GetValueIfValid("UserIndex", shtName, Integer.parseInt(intRow));
			if (strFreezeUnfreezeOption.isEmpty() || strFreezeUnfreezeOption.equals("IGNORE_VALUE")) {
				FreezeUnfreezeProperty_Selection_EnterData = true;
				return false;
			}
			String oPage = null;
			String strOption = null;
			int intOption = 0;
			switch (strFreezeUnfreezeOption.toUpperCase()) {
			case "FREEZEALLFOROPENPROPERTYWIPASUSER":
			case "FREEZE ALL FOR OPEN PROPERTY WIP AS USER":
				if (isNumeric(strUserIndex)) {
				} else {
				}
				strOption = "Freeze all for Open Property WIP as user";
				intOption = 1;
				break;
			case "FREEZEALLFORSEARCHANDUPDATE":
			case "FREEZE ALL FOR SEARCH AND UPDATE":
				strOption = "Freeze all for search and update";
				intOption = 2;
				break;
			case "UNFREEZEALLFORSEARCH":
			case "UNFREEZE ALL FOR SEARCH":
				strOption = "Unfreeze all for search";
				intOption = 3;
				break;
			case "UNFREEZEALLFORSEARCHANDUPDATE":
			case "UNFREEZE ALL FOR SEARCH AND UPDATE":
				strOption = "Unfreeze all for search and update";
				intOption = 4;
				break;
			}
			oPage = null;
			return FreezeUnfreezeProperty_Selection_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verifies error message $SELECTIONSHEETNAME and $SELECTIONROWINDEX1")
	public boolean user_verify_error_message(String shtName, String intRow) {
		String expErrormsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
		String actualErrorMsg = freezeUnfreezeSelectionPage.ErrorMsg_WebTable.getText();
		if (actualErrorMsg.contains(expErrormsg)) {
			logSteps.execution_log("Error message verified " + actualErrorMsg);
			return true;
		}
		return false;
	}
}