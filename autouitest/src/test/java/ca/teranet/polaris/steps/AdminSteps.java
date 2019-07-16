package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;

import ca.teranet.pages.polaris.BlockEditPage;
import ca.teranet.pages.polaris.ChangeLROPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;

public class AdminSteps extends Utility {
	ChangeLROPage changeLROPage;
	MainPage mainPage;
	BlockEditPage blockEditPage;
	ELRSCommonSteps elrscommon;
	LogSteps logSteps;

	@When("user click on the Change LRO button on the Change Active LRO entry page $shtName and $intRow")
	public boolean Admin_ChangeActiveLRO_ChangeLRO(String shtName, String intRow) {
		boolean Admin_ChangeActiveLRO_ChangeLRO = false;
		try {
			String strStepName = "Admin_ChangeActiveLRO_ChangeLRO";
			Admin_ChangeActiveLRO_ChangeLRO = false;
			boolean intRet = false;
			String strLRO = null;
			String strExpectedMsgs = null;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = Admin_ChangeActiveLRO_EnterData(shtName, Integer.parseInt(intRow));
				if (intRet == false) {
					return Admin_ChangeActiveLRO_ChangeLRO;
				}
			}
			if (!shtName.equals("") && !intRow.equals("")) {
				strLRO = GetValueIfValid("LRO", shtName, Integer.parseInt(intRow)).toUpperCase();
				strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			} else {
				strLRO = "IGNORE_VALUE";
				strExpectedMsgs = "";
			}
			changeLROPage.ChangeLRO_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				return Admin_ChangeActiveLRO_ChangeLRO;
			}
			VerifyApplicationError();
			// if (changeLROPage.ErrorMsg_WebTable.isPresent()) {
			// String strErrorMsgs = getCellData(changeLROPage.ErrorMsg_WebTable, 1, 1).trim();
			// if (!strErrorMsgs.equals("")) {
			// intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
			// if (intRet == false) {
			// Admin_ChangeActiveLRO_ChangeLRO = false;
			// }
			// return Admin_ChangeActiveLRO_ChangeLRO;
			// }
			// }
			// String strActiveLRO = mainPage.LROText_WebElement.getText().trim();
			// String strExpectedQ = null;
			// String strWorkQ = mainPage.WorkQueue_WebElement.getText().trim();
			// if (!strLRO.equals("IGNORE_VALUE")) {
			// if (strLRO.contains("*")) {
			// strExpectedQ = "General";
			// String[] arrLRO = strLRO.split("*");
			// strLRO = arrLRO[0].trim();
			// } else {
			// strExpectedQ = "Local";
			// }
			// if (strComp(strLRO, strActiveLRO) != 0) {
			// return Admin_ChangeActiveLRO_ChangeLRO;
			// }
			// if (strComp(strWorkQ, strExpectedQ) != 0) {
			// return Admin_ChangeActiveLRO_ChangeLRO;
			// }
			// }
			Admin_ChangeActiveLRO_ChangeLRO = true;
			return Admin_ChangeActiveLRO_ChangeLRO;
		} catch (Exception e) {
			e.printStackTrace();
			return Admin_ChangeActiveLRO_ChangeLRO;
		}
	}

	@When("Click the Change LRO button on the Change Active LRO")
	public boolean Admin_ChangeActiveLRO_ChangeLRO() {
		boolean Admin_ChangeActiveLRO_ChangeLRO = false;
		try {
			String strStepName = "Admin_ChangeActiveLRO_ChangeLRO";
			Admin_ChangeActiveLRO_ChangeLRO = false;
			boolean intRet = false;
			String strLRO = null;
			String strExpectedMsgs = null;
			changeLROPage.ChangeLRO_WebButton.click();

			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				logSteps.execution_log("Click <Change LRO> button - UnSuccessful");
				return Admin_ChangeActiveLRO_ChangeLRO;
			}
			VerifyApplicationError();
			if (changeLROPage.ErrorMsg_WebTable.isPresent()) {
				String strErrorMsgs = getCellData(changeLROPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.equals("")) {
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						Admin_ChangeActiveLRO_ChangeLRO = false;
					}
					return Admin_ChangeActiveLRO_ChangeLRO;
				}
			}
			String strActiveLRO = mainPage.LROText_WebElement.getText().trim();
			String strExpectedQ = null;
			String strWorkQ = mainPage.WorkQueue_WebElement.getText().trim();
			// changeLROPage.Cancel_WebButton.click();

			if (!strLRO.equals("IGNORE_VALUE")) {
				if (strLRO.contains("*")) {
					strExpectedQ = "General";
					String[] arrLRO = strLRO.split("*");
					strLRO = arrLRO[0].trim();
				} else {
					strExpectedQ = "Local";
				}
				if (strComp(strLRO, strActiveLRO) != 0) {
					logSteps.execution_log("Verification of LRO - UnSuccessful. Expected: <" + strLRO + ">, Actual: <" + strActiveLRO + ">");
					return Admin_ChangeActiveLRO_ChangeLRO;
				}
				if (strComp(strWorkQ, strExpectedQ) != 0) {
					logSteps.execution_log("Verification of Work Queue - UnSuccessful. Expected: <" + strExpectedQ + ">, Actual: <" + strWorkQ + ">");
					return Admin_ChangeActiveLRO_ChangeLRO;
				}
				logSteps.execution_log("Verification of LRO - Successful");
			}
			Admin_ChangeActiveLRO_ChangeLRO = true;
			return Admin_ChangeActiveLRO_ChangeLRO;
		} catch (Exception e) {
			e.printStackTrace();
			return Admin_ChangeActiveLRO_ChangeLRO;
		}
	}

	public boolean Admin_ChangeActiveLRO_EnterData(String shtName, int intRow) {
		boolean Admin_ChangeActiveLRO_EnterData = false;
		try {
			String strStepName = "Admin_ChangeActiveLRO_EnterData";
			Admin_ChangeActiveLRO_EnterData = false;
			String strLRO = GetValueIfValid("LRO", shtName, intRow).toUpperCase();

			changeLROPage.LROList_WebList.selectByVisibleText(strLRO);
			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				return Admin_ChangeActiveLRO_EnterData;
			}
			Admin_ChangeActiveLRO_EnterData = true;
			return Admin_ChangeActiveLRO_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return Admin_ChangeActiveLRO_EnterData;
		}
	}

}
