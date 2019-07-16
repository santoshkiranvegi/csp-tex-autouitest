package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.DividePropertyPage;
import ca.teranet.pages.polaris.FreezePropertyPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class DividePropertySteps extends Utility {

	DividePropertyPage dividePropertyPage;
	PropertyDetailPage propertyDetailPage;
	FreezePropertyPage freezePropertyPage;
	MainPage mainPage;
	@Steps
	ELRSCommonSteps elrscommon;
	BatchPage batchPage;
	LogSteps logSteps;
	PropertyDetailSteps propertyDetail;

	@When("user clicks on Proceed button on DivideProperty $strAction and $shtName and $intRow")
	public boolean DivideProperty_Submit(String strAction, String shtName, String intRow) {
		boolean DivideProperty_Submit = false;
		try {
			String strStepName = "DivideProperty_Submit";

			if (intRow.equals("")) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return DivideProperty_Submit;
			}
			String strBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow));
			String strPINType = GetValueIfValid("PINType", shtName, Integer.parseInt(intRow));
			String strNumber = GetValueIfValid("NumberOfNewProperties", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			switch (strPINType.toUpperCase()) {
			case "LAND TITLES":
			case "LT":
				strPINType = "LT";
				break;
			case "REGISTRY":
			case "R":
				strPINType = "R";
				break;
			}
			boolean intRet = false;
			if (!strBlock.equals("") || !strPIN.equals("") || !strNumber.equals("")) {
				intRet = DivideProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return DivideProperty_Submit;
				}
			}
			String strButtonName = null;
			switch (strAction.toUpperCase()) {
			case "PROCEED":
				strButtonName = "Proceed";
				dividePropertyPage.Proceed_WebButton.click();
				break;
			case "RETRIEVEWIP":
				strButtonName = "Retrieve WIP";
				dividePropertyPage.RetrieveWIP_WebButton.click();
				break;
			default:
				return DivideProperty_Submit;
			}
			logSteps.execution_log("<" + strButtonName + "> button is clicked");
			VerifyApplicationError();
			String strErrorMsgs = dividePropertyPage.ErrorMsg_WebTable.getText().trim();
			if (!strErrorMsgs.equals("") && (!(InStr(strErrorMsgs, "Schedule Off-Line") > 0))) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					DivideProperty_Submit = false;
				}
				String strActualBlock = dividePropertyPage.Block_WebEdit.getAttribute("value");
				String strActualPIN = dividePropertyPage.Property_WebEdit.getAttribute("value");
				String strActualNumber = dividePropertyPage.NumberOfNewProperties_WebEdit.getAttribute("value");
				String strExpectedParentPIN = strBlock + "-" + strPIN;
				String strActualParentPIN = strActualBlock.trim() + "-" + strActualPIN.trim();
				if (strComp(strActualParentPIN, strExpectedParentPIN) == 0) {
					logSteps.execution_log("Verification of Parent PIN <" + strExpectedParentPIN + "> - Successful");
				} else {
					logSteps.execution_log("Verification of Parent PIN - UnSuccessful, Expected:<" + strExpectedParentPIN + ">, Actual:<" + strActualParentPIN + ">");
				}
				if (strComp(strActualNumber, strNumber) == 0) {
					logSteps.execution_log("Verification of Number of New Properties <" + strNumber + "> - Successful");
				} else {
					logSteps.execution_log("Verification of Number of New Properties <" + strNumber + "> - UnSuccessful, Expected:<" + strNumber + ">, Actual:<" + strActualNumber + ">");
				}
				return DivideProperty_Submit;
			}
			if (isNumeric(strNumber)) {
				if (Math.round(Integer.parseInt(strNumber)) > 800) {
					intRet = DivideProperty_BatchProceed(strBlock, strPIN);
				}
			}
			logSteps.execution_log("Verification of Property Detail page - Successful");
			DivideProperty_Submit = true;
			return DivideProperty_Submit;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_Submit;
		}
	}

	public boolean DivideProperty_Submission_EnterData(String shtName, String intRow) {
		boolean DivideProperty_Submission_EnterData = false;
		try {
			String strStepName = "DivideProperty_Submission_EnterData";
			String strTargetBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strNumberOfNewProperties = GetValueIfValid("NumberOfNewProperties", shtName, Integer.parseInt(intRow)).toUpperCase();
			dividePropertyPage.Block_WebEdit.clear();
			dividePropertyPage.Block_WebEdit.sendKeys(strTargetBlock);
			dividePropertyPage.Property_WebEdit.clear();
			dividePropertyPage.Property_WebEdit.sendKeys(strTargetPIN);
			dividePropertyPage.NumberOfNewProperties_WebEdit.clear();
			dividePropertyPage.NumberOfNewProperties_WebEdit.sendKeys(strNumberOfNewProperties);
			DivideProperty_Submission_EnterData = true;
			return DivideProperty_Submission_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_Submission_EnterData;
		}
	}

	@When("user clicks on Cancel button on DivideProperty $shtName and $intRow")
	public boolean DivideProperty_Cancel(String shtName, String intRow) {
		boolean DivideProperty_Cancel = false;
		try {
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = DivideProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return DivideProperty_Cancel;
				}
			}
			dividePropertyPage.Cancel_WebButton.click();
			String strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_Cancel;
			}
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return DivideProperty_Cancel;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			DivideProperty_Cancel = true;
			return DivideProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_Cancel;
		}
	}

	@When("user clicks on Cancel button on DivideProperty")
	public boolean DivideProperty_Cancel() {
		boolean DivideProperty_Cancel = false;
		try {
			boolean intRet = false;
			dividePropertyPage.Cancel_WebButton.click();
			String strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_Cancel;
			}
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return DivideProperty_Cancel;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			DivideProperty_Cancel = true;
			return DivideProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_Cancel;
		}
	}

	public boolean DivideProperty_CancelCancel(String strButton, String shtName, String intRow) {
		boolean DivideProperty_CancelCancel = false;
		try {
			String strStepName = "DivideProperty_CancelCancel";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = DivideProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return DivideProperty_CancelCancel;
				}
			}
			String strExpectedBlock = dividePropertyPage.Block_WebEdit.getAttribute("value").trim();
			String strExpectedPIN = dividePropertyPage.Property_WebEdit.getAttribute("value").trim();
			String strExpectedNumOfNewProperties = dividePropertyPage.NumberOfNewProperties_WebEdit.getAttribute("value").trim();
			String strButtonName = null;
			switch (strButton.toUpperCase()) {
			case "CANCEL":
				strButtonName = "Cancel";
				dividePropertyPage.Cancel_WebButton.click();
				break;
			case "CANCELWIP":
				strButtonName = "Cancel WIP";
				dividePropertyPage.CancelWIP_WebButton.click();
				break;
			default:
				return DivideProperty_CancelCancel;
			}
			logSteps.execution_log("Click <" + strButton + "> button - Successful");
			String strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <Cancel> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelCancel;
			}
			String strActualBlock = dividePropertyPage.Block_WebEdit.getAttribute("value").trim();
			String strActualPIN = dividePropertyPage.Property_WebEdit.getAttribute("value").trim();
			String strActualNumOfNewProperties = dividePropertyPage.NumberOfNewProperties_WebEdit.getAttribute("value").trim();
			if (strComp(strExpectedBlock, strActualBlock) != 0) {
				if (strComp(strExpectedPIN, strActualPIN) != 0) {
					logSteps.execution_log("Verification of the <PIN> before and after Cancel clicked - UnSuccessful. Before: <" + strExpectedBlock + "-" + strExpectedPIN + ">, After:<" + strActualBlock + "-"
							+ strActualPIN + ">");
				} else {
					logSteps.execution_log("Verification of the <Block> before and after Cancel clicked - UnSuccessful. Before: <" + strExpectedBlock + ">, After:<" + strActualBlock + ">");
				}
				return DivideProperty_CancelCancel;
			}
			if (strComp(strExpectedNumOfNewProperties, strActualNumOfNewProperties) != 0) {
				logSteps.execution_log("Verification of <Number of New Properties> before and after Cancel clicked - UnSuccessful. Before: <" + strExpectedNumOfNewProperties + ">, After:<"
						+ strActualNumOfNewProperties + ">");
				return DivideProperty_CancelCancel;
			}
			logSteps.execution_log("Verification of the <Parent PIN> and <Number of New Properties> - Successful");
			DivideProperty_CancelCancel = true;
			return DivideProperty_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_CancelCancel;
		}
	}

	@When("user Cancels the Cancel or Cancel WIP on Divide Property Submission page $strButton")
	public boolean DivideProperty_CancelCancel(String strButton) {
		boolean DivideProperty_CancelCancel = false;
		try {
			boolean intRet = false;
			String strButtonName = null;
			switch (strButton.toUpperCase()) {
			case "CANCEL":
				strButtonName = "Cancel";
				dividePropertyPage.Cancel_WebButton.click();
				break;
			case "CANCELWIP":
				strButtonName = "Cancel WIP";
				dividePropertyPage.CancelWIP_WebButton.click();
				break;
			default:
				return DivideProperty_CancelCancel;
			}
			logSteps.execution_log("Click <" + strButton + "> button - Successful");
			String strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <Cancel> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelCancel;
			}
			DivideProperty_CancelCancel = true;
			return DivideProperty_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_CancelCancel;
		}
	}

	@When("user Cancels the Cancel WIP button on Divide Property Submission page $shtName and $intRow")
	public boolean DivideProperty_CancelWIP_Cancel(String shtName, String intRow) {
		boolean DivideProperty_CancelWIP = false;
		try {
			String strStepName = "DivideProperty_CancelWIP";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = DivideProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return DivideProperty_CancelWIP;
				}
			}
			dividePropertyPage.CancelWIP_WebButton.click();
			logSteps.execution_log("Click <Cancel WIP> button - Successful");
			String strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			VerifyApplicationError();
			if (dividePropertyPage.ErrorMsg_WebTable.isPresent()) {
				String strErrorMsgs = dividePropertyPage.ErrorMsg_WebTable.getText().trim();
				String strExpectedMsgs = null;
				if (!strErrorMsgs.equals("")) {
					if (!shtName.equals("") && !intRow.equals("")) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					} else {
						strExpectedMsgs = "";
					}
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						DivideProperty_CancelWIP = false;
					}
					return DivideProperty_CancelWIP;
				}
			}
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			DivideProperty_CancelWIP = true;
			return DivideProperty_CancelWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_CancelWIP;
		}
	}

	@When("user clicks on ok on Cancel WIP button on Divide Property Submission page $shtName and $intRow")
	public boolean DivideProperty_CancelWIP_OK(String shtName, String intRow) {
		boolean DivideProperty_CancelWIP = false;
		try {
			String strStepName = "DivideProperty_CancelWIP";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = DivideProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return DivideProperty_CancelWIP;
				}
			}
			dividePropertyPage.CancelWIP_WebButton.click();
			logSteps.execution_log("Click <Cancel WIP> button - Successful");
			String strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			VerifyApplicationError();
			if (dividePropertyPage.ErrorMsg_WebTable.isPresent()) {
				String strErrorMsgs = dividePropertyPage.ErrorMsg_WebTable.getText().trim();
				String strExpectedMsgs = null;
				if (!strErrorMsgs.equals("")) {
					if (!shtName.equals("") && !intRow.equals("")) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					} else {
						strExpectedMsgs = "";
					}
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						DivideProperty_CancelWIP = false;
					}
					return DivideProperty_CancelWIP;
				}
			}
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			DivideProperty_CancelWIP = true;
			return DivideProperty_CancelWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_CancelWIP;
		}
	}

	@When("user clicks Cancel WIP button on Divide Property Submission page $strAction")
	public boolean DivideProperty_CancelWIP(String strAction) {
		boolean DivideProperty_CancelWIP = false;
		try {
			String strStepName = "DivideProperty_CancelWIP";
			boolean intRet = false;
			dividePropertyPage.CancelWIP_WebButton.click();
			logSteps.execution_log("Click <Cancel WIP> button - Successful");
			// String strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return DivideProperty_CancelWIP;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			DivideProperty_CancelWIP = true;
			return DivideProperty_CancelWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_CancelWIP;
		}
	}

	public boolean RetrieveAndVerifyCreatedPIN_Divide(String strDetailInfo, String shtName, String intRow) {
		boolean RetrieveAndVerifyCreatedPIN_Divide = true;
		try {
			String strStepName = null;
			strStepName = "RetrieveAndVerifyCreatedPIN_Divide";
			String strBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow));
			String strNumbers = GetValueIfValid("NumberOfNewProperties", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			intRet = VerifyRetiredPIN(strDetailInfo, strBlock, strPIN);
			if (intRet == false) {
				logSteps.execution_log("Verification of Retired PIN - Warning!");
				RetrieveAndVerifyCreatedPIN_Divide = false;
			}
			String[] arrDetails = (strDetailInfo).split("TO");
			String strDetailsFrom = arrDetails[0];
			String strDetailsTo = arrDetails[1];
			String strPropertyFrom = right(strDetailsFrom, 10);
			String strPropertyTo = left(strDetailsTo, 10);
			String[] arrPropertyFrom = (strPropertyFrom).split("-");
			String strPINFrom = arrPropertyFrom[1];
			String[] arrPropertyTo = (strPropertyTo).split("-");
			String strPINTo = arrPropertyTo[1];
			if (!isNumeric(strPINFrom)) {
				if (!isNumeric(strPINTo)) {
					logSteps.execution_log("Attempt to retrieve PIN From <" + strPINFrom + "> and PIN To <" + strPINTo + "> - UnSuccessful");
					RetrieveAndVerifyCreatedPIN_Divide = false;
				} else {
					logSteps.execution_log("PIN To <" + strPINTo + "> retrieved successfully, but retrieve PIN From <" + strPINFrom + "> - UnSuccessful");
					RetrieveAndVerifyCreatedPIN_Divide = false;
				}
				return RetrieveAndVerifyCreatedPIN_Divide;
			}
			if (!isNumeric(strPINTo)) {
				logSteps.execution_log("PIN From <" + strPINFrom + "> retrieved successfully, but retrieve PIN To <" + strPINTo + "> - UnSuccessful");
				RetrieveAndVerifyCreatedPIN_Divide = false;
				return RetrieveAndVerifyCreatedPIN_Divide;
			}
			int intCounts = Math.round(Integer.parseInt(strPINTo)) - Math.round(Integer.parseInt(strPINFrom)) + 1;
			if (Math.round(Integer.parseInt(strNumbers)) != intCounts) {
				logSteps.execution_log("Verification of the number of PINs Created - UnSuccessful, Expected: <" + strNumbers + ">, Actual:<" + intCounts + ">");
				RetrieveAndVerifyCreatedPIN_Divide = false;
				return RetrieveAndVerifyCreatedPIN_Divide;
			}
			if (!RetrieveAndVerifyCreatedPIN_Divide == false) {
				logSteps.execution_log("<" + strNumbers + "> PINs Created - Successful");
				RetrieveAndVerifyCreatedPIN_Divide = true;
			}
			return RetrieveAndVerifyCreatedPIN_Divide;
		} catch (Exception e) {
			e.printStackTrace();
			return RetrieveAndVerifyCreatedPIN_Divide;
		}
	}

	public boolean VerifyRetiredPIN(String strDetailInfo, String strExpectedBlock, String strExpectedPIN) {
		boolean VerifyRetiredPIN = false;
		try {
			boolean intRet = false;
			String strStepName = "VerifyRetiredPIN";
			VerifyRetiredPIN = false;
			String strExpectedRetiredPIN = strExpectedBlock + "-" + strExpectedPIN;
			if (!(InStr(strDetailInfo, strExpectedRetiredPIN) > 0)) {
				if (!(InStr(strDetailInfo, strExpectedBlock) > 0)) {
					if (!(InStr(strDetailInfo, strExpectedPIN) > 0)) {
						logSteps.execution_log("The expected to be retired PIN <" + strExpectedRetiredPIN + "> Not present - UnSuccessful");
					} else {
						logSteps.execution_log("Only PIN Number <" + strExpectedPIN + "> present on page, the expected Block Number <" + strExpectedBlock + "> NOT present - UnSuccessful");
					}
				} else {
					if (!(InStr(strDetailInfo, strExpectedPIN) > 0)) {
						logSteps.execution_log("Only Block Number <" + strExpectedBlock + "> present on page, PIN Number <" + strExpectedPIN + "> Not present - UnSuccessful");
					} else {
						logSteps.execution_log("PIN <" + strExpectedRetiredPIN + "> is retired - Successful");
						VerifyRetiredPIN = true;
					}
				}
				return VerifyRetiredPIN;
			}
			logSteps.execution_log("PIN <" + strExpectedRetiredPIN + "> retired - Successful");
			VerifyRetiredPIN = true;
			return VerifyRetiredPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyRetiredPIN;
		}
	}

	public boolean DivideProperty_BatchProceed(String strBlock, String strPIN) {
		boolean DivideProperty_BatchProceed = false;
		try {
			String strStepName = "DivideProperty_BatchProceed";
			boolean intRet = false;
			if (!batchPage.PreSubmission_Historical_WebElement.isPresent()) {
				logSteps.execution_log("Schedule Off-Line <Pre-Submission> page Not exist - UnSuccessful");
				return DivideProperty_BatchProceed;
			}
			String strBatchJob = "Divide Single Property";
			intRet = elrscommon.Properties_Batch_PreSubmission(strBatchJob);
			if (intRet == false) {
				logSteps.execution_log("Batch PreSubmission - UnSuccessful");
				return DivideProperty_BatchProceed;
			}
			WaitUtil.waitMSeconds(5000);
			intRet = DivideProperty_BatchProceed_RetrieveWIP(strBlock, strPIN);
			if (intRet == false) {
				return DivideProperty_BatchProceed;
			}
			int intCount = 0;
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				if (intCount < 10) {
					logSteps.execution_log("Off-Line WIP Unavailable page present, wait and re-retrieve WIP");
					Thread.sleep((10));
					batchPage.OK_WebButton.click();
					intRet = DivideProperty_BatchProceed_RetrieveWIP(strBlock, strPIN);
					if (intRet == false) {
						return DivideProperty_BatchProceed;
					}
					intCount = intCount + 1;
				} else {
					logSteps.execution_log("Off-Line WIP Unavailable page still present after 10 times of attempts to retrieve WIP");
				}
			}
			DivideProperty_BatchProceed = true;
			return DivideProperty_BatchProceed;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_BatchProceed;
		}
	}

	public boolean DivideProperty_BatchProceed_RetrieveWIP(String strBlock, String strPIN) {
		boolean DivideProperty_BatchProceed_RetrieveWIP = false;
		try {
			boolean intRet = false;
			intRet = elrscommon.user_navigates_to("DivideProperty");
			if (intRet == false) {
				return DivideProperty_BatchProceed_RetrieveWIP;
			}
			WaitUtil.waitMSeconds(5000);
			dividePropertyPage.Block_WebEdit.sendKeys(strBlock);
			dividePropertyPage.Property_WebEdit.sendKeys(strPIN);
			dividePropertyPage.Property_WebEdit.sendKeys(strPIN);
			if (!dividePropertyPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
				if (!strPIN.equals("IGNORE_VALUE") && !strPIN.equals("")) {
					if (!strBlock.equals("IGNORE_VALUE") && !strBlock.equals("")) {
						intRet = DivideProperty_Enable_RetrieveWIP(strBlock, strPIN);
						if (intRet == false) {
							return DivideProperty_BatchProceed_RetrieveWIP;
						}
					}
				}
			}
			logSteps.execution_log("Re-Enter Parent PIN: <" + strBlock + "-" + strPIN + "> - Successful");
			WaitUtil.waitMSeconds(5000);
			dividePropertyPage.RetrieveWIP_WebButton.click();
			logSteps.execution_log("<Retrieve WIP> button is clicked");
			DivideProperty_BatchProceed_RetrieveWIP = true;
			return DivideProperty_BatchProceed_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_BatchProceed_RetrieveWIP;
		}
	}

	public boolean DivideProperty_Enable_RetrieveWIP(String strTargetBlock, String strTargetPIN) {
		boolean DivideProperty_Enable_RetrieveWIP = false;
		try {
			int intCount = 1;
			boolean intRet = false;
			while (dividePropertyPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				if (intCount < 10) {
					intRet = elrscommon.user_navigates_to("DivideProperty");
					if (intRet == false) {
						return DivideProperty_Enable_RetrieveWIP;
					}
					dividePropertyPage.Block_WebEdit.sendKeys(strTargetBlock);
					dividePropertyPage.Property_WebEdit.sendKeys(strTargetPIN);
					dividePropertyPage.Property_WebEdit.sendKeys(strTargetPIN);
					intCount = intCount + 1;
					if (dividePropertyPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
						DivideProperty_Enable_RetrieveWIP = true;
						break;
					}
				} else {
					logSteps.execution_log("<Retrieve WIP> button Not enabled after 10 times of attempts to input Parent PINs<" + strTargetBlock + "-" + strTargetPIN + ">");
					break;
				}
			}
			return DivideProperty_Enable_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return DivideProperty_Enable_RetrieveWIP;
		}
	}

	@Then("user verifies the UI object exist $text and $shtName and $intRow")
	public boolean verify_UiObject_Property(String text, String shtName, String intRow) {
		String strObject = GetValueIfValid("Object", shtName, Integer.parseInt(intRow));

		switch (strObject.toUpperCase()) {
		case "WEBBUTTON":
			if (mainPage.getDriver().findElement(By.xpath("//*[contains(@value,'" + text + "')]")).isDisplayed())
				return true;
			break;
		case "WEBTABLE":
			break;
		case "WEBLIST":
			break;
		}
		return false;
	}
}
