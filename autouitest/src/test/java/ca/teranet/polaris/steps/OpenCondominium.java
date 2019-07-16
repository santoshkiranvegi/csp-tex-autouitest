package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.OpenCondominiumPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class OpenCondominium extends Utility {

	OpenCondominiumPage openCondominiumPage;
	@Steps
	ELRSCommonSteps elrscommon;
	@Steps
	LogSteps logSteps;
	@Steps
	DividePropertySteps dividePropertySteps;
	@Steps
	PropertyCommonSteps propertyCommon;
	PropertyDetailPage propertyDetailPage;

	public boolean OpenCondominium_BatchProceed_RetrieveWIP(String strPlanNumber) {
		try {
			String strStepName = null;
			strStepName = "OpenCondominium_BatchProceed_RetrieveWIP";
			boolean OpenCondominium_BatchProceed_RetrieveWIP = false;
			boolean intRet;
			intRet = elrscommon.user_navigates_to("OpenCondominium");
			if (intRet == false) {
				return false;
			}
			WaitUtil.waitMSeconds(2000);
			// Browser("ELRS").Page("OpenCondominium").WebEdit("PlanNumber").TypeStr(strPlanNumber);
			openCondominiumPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);
			// Browser("ELRS").Page("OpenCondominium").WebEdit("PlanNumber").SetValue(strPlanNumber);
			int intCount = 1;
			while (openCondominiumPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				if (intCount < 10) {
					WaitUtil.waitMSeconds(2000);
					intRet = elrscommon.user_navigates_to("OpenCondominium");
					// Browser("ELRS").Page("OpenCondominium").WebEdit("PlanNumber").TypeStr(strPlanNumber);
					openCondominiumPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);
					// Browser("ELRS").Page("OpenCondominium").WebEdit("PlanNumber").SetValue(strPlanNumber);
					if (openCondominiumPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
						break;
					}
				} else {
					logSteps.execution_log("<Retrieve WIP> button Not enabled after 10 times of attempts to input Condominium Plan Number <" + strPlanNumber + ">");
					return false;
				}
			}
			openCondominiumPage.RetrieveWIP_WebButton.click();
			logSteps.execution_log("<Retrieve WIP> button is clicked");
			OpenCondominium_BatchProceed_RetrieveWIP = true;
			return OpenCondominium_BatchProceed_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrievePINAndVerifyRemarks_OpenCondominium(String strDetailInfo, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "RetrievePINAndVerifyRemarks_OpenCondominium";
			boolean RetrievePINAndVerifyRemarks_OpenCondominium = true;
			String strPlanNumber = null;
			String strDocumentType = null;
			String strRemarks = null;
			strPlanNumber = GetValueIfValid("PlanNumber", shtName, Integer.parseInt(intRow));
			strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow));
			strDocumentType = strDocumentType.toUpperCase();
			strRemarks = strDocumentType + strPlanNumber;
			if (!(InStr(strDetailInfo, strRemarks) > 0)) {
				// strRemarks = strPlanNumber
				// strRemarks = UCase(strRemarks)
				if (!(InStr(strDetailInfo, strPlanNumber) > 0)) {
					logSteps.execution_log("The expected Remarks <" + strDocumentType + " " + strPlanNumber + "> NOT displayed on the PDF page - UnSuccessful");
					RetrievePINAndVerifyRemarks_OpenCondominium = false;
				} else {
					logSteps.execution_log("<Remarks: " + strDocumentType + " " + strPlanNumber + "> displayed on the <Map Maintenance Request> page - Successful");
					RetrievePINAndVerifyRemarks_OpenCondominium = true;
				}
			}
			String strTargetBlock = null;
			String strTargetPIN = null;
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			boolean intRet;
			intRet = dividePropertySteps.VerifyRetiredPIN(strDetailInfo, strTargetBlock, strTargetPIN);
			if (intRet == false) {
				logSteps.execution_log("Verification of Retired PIN - Warning!");
				RetrievePINAndVerifyRemarks_OpenCondominium = false;
			}
			String strBlockNumber = null;
			String strNewBlock = null;
			strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			strNewBlock = GetValueIfValid("NewBlock", shtName, Integer.parseInt(intRow));
			if (strNewBlock.equals("IGNORE_VALUE") || strNewBlock.isEmpty()) {
				strNewBlock = strBlockNumber;
			}
			intRet = propertyCommon.RetrieveCreatedPINRange(strDetailInfo, strNewBlock, shtName, intRow);
			if (intRet == false) {
				logSteps.execution_log("Retrieve Created Pins - Warning!");
				RetrievePINAndVerifyRemarks_OpenCondominium = false;
				return false;
			}
			if (RetrievePINAndVerifyRemarks_OpenCondominium == true) {
				logSteps.execution_log("Retrieve Created Pins - Successful");
			}
			return RetrievePINAndVerifyRemarks_OpenCondominium;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels the Cancel Open Condominium $shtName and $intRow")
	public boolean OpenCondominium_CancelCancel(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "OpenCondominium_CancelCancel";
			boolean intRet;
			boolean OpenCondominium_CancelCancel = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = OpenCondominium_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			String oPage = null;
			String strPreBlock = openCondominiumPage.TargetBlock_WebEdit.getAttribute("value");
			String strPrePIN = openCondominiumPage.TargetPIN_WebEdit.getAttribute("value");
			String strPrePlanNumber = openCondominiumPage.PlanNumber_WebEdit.getAttribute("value");
			String strPreBlockNumber = openCondominiumPage.BlockNumber_WebEdit.getAttribute("value");
			String strPreRemnantNumber = openCondominiumPage.RemnantNumber_WebEdit.getAttribute("value");
			openCondominiumPage.Cancel_WebButton.click();
			logSteps.execution_log("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <Cancel> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			if (!openCondominiumPage.PlanNumber_WebEdit.isPresent()) {
				logSteps.execution_log("The texts of <Condominium Plan Number> Not present on the page. Verification of the <Open Condominium> page - UnSuccessful");
				return false;
			}
			intRet = OpenCondominium_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPrePlanNumber, strPreBlockNumber, strPreRemnantNumber);
			if (intRet == false) {
				logSteps.execution_log("Verification of the page - UnSuccessful");
				OpenCondominium_CancelCancel = false;
				return false;
			}
			logSteps.execution_log("Verification of the page - Successful");
			OpenCondominium_CancelCancel = true;
			return OpenCondominium_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean OpenCondominium_EnterData(String shtName, String intRow) {
		try {
			String strStepName = "OpenCondominium_EnterData";
			boolean OpenCondominium_EnterData = false;
			String strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			String strPlanNumber = GetValueIfValid("PlanNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			String strRemnantNumber = GetValueIfValid("RemnantNumber", shtName, Integer.parseInt(intRow));
			String oPage = null;
			openCondominiumPage.TargetBlock_WebEdit.clear();
			openCondominiumPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
			openCondominiumPage.TargetPIN_WebEdit.clear();
			openCondominiumPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
			if (!strPlanNumber.equals("IGNORE_VALUE") && !strPlanNumber.isEmpty()) {
				if (strPlanNumber.equals("!GENERATE!")) {
					openCondominiumPage.PlanNumber_WebEdit.clear();
					openCondominiumPage.PlanNumber_WebEdit.sendKeys(strRegNumber);
				} else {
					openCondominiumPage.PlanNumber_WebEdit.clear();
					openCondominiumPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);
				}

			} else {
				openCondominiumPage.PlanNumber_WebEdit.clear();
				openCondominiumPage.PlanNumber_WebEdit.sendKeys(strPlanNumber);
			}
			openCondominiumPage.BlockNumber_WebEdit.clear();
			openCondominiumPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			openCondominiumPage.RemnantNumber_WebEdit.clear();
			openCondominiumPage.RemnantNumber_WebEdit.sendKeys(strRemnantNumber);
			oPage = null;
			// if (environmentlib.getProperty("bTriggered").equals("true")) {
			// // AddInfo("Enter data to <Open Condominium> page - UnSuccessful");
			// return false;
			// }
			// Report only when parent pin or plan number entered
			if (!strTargetBlock.isEmpty() || !strPlanNumber.isEmpty() || !strBlockNumber.isEmpty()) {
				// Reporter.reportEvent(Status.Passed,strStepName,"Enter data to <Open Condominium> page - Successful");
				/*
				 * AddInfo("Parent PIN: <"+strTargetBlock+"-"+strTargetPIN+">"); AddInfo("Condominium Plan Number: <"+strPlanNumber+">"); AddInfo("Block Number: <"+strBlockNumber+">"); AddInfo("Number of Remnant Properties: <"+strRemnantNumber+">");
				 * AddInfo("Enter data to <Open Condominium> page - Successful");
				 */
			}
			OpenCondominium_EnterData = true;
			return OpenCondominium_EnterData;
		} catch (

				Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean OpenCondominium_VerifyDataNotDiscarded(String strExpectedBlock, String strExpectedPIN, String strExpectedPlanNumber, String strExpectedBlockNumber, String strExpectedRemnantNumber) {
		boolean OpenCondominium_VerifyDataNotDiscarded = false;
		try {
			String strStepName = null;
			strStepName = "OpenCondominium_VerifyDataNotDiscarded";
			String oPage = null;
			String strActualBlock = openCondominiumPage.TargetBlock_WebEdit.getAttribute("value");
			String strActualPIN = openCondominiumPage.TargetPIN_WebEdit.getAttribute("value");
			String strActualPlanNumber = openCondominiumPage.PlanNumber_WebEdit.getAttribute("value");
			String strActualBlockNumber = openCondominiumPage.BlockNumber_WebEdit.getAttribute("value");
			String strActualRemnantNumber = openCondominiumPage.RemnantNumber_WebEdit.getAttribute("value");
			oPage = null;
			if (!(strComp(strActualBlock, strExpectedBlock) == 0)) {
				logSteps.execution_log("Verification of Parent Block: <" + strExpectedBlock + "> - UnSuccessful. Actual: <" + strActualBlock + ">");
				return false;
			}
			if (!(strComp(strActualPIN, strExpectedPIN) == 0)) {
				logSteps.execution_log("Verification of Parent PIN: <" + strExpectedBlock + "-" + strExpectedPIN + "> - UnSuccessful. Actual: <" + strActualBlock + "-" + strActualPIN + ">");
				return false;
			}
			if (!(strComp(strActualPlanNumber, strExpectedPlanNumber) == 0)) {
				logSteps.execution_log("Verification of Condominium Plan Number: <" + strExpectedPlanNumber + "> - UnSuccessful. Actual: <" + strActualPlanNumber + ">");
				return false;
			}
			if (!(strComp(strActualBlockNumber, strExpectedBlockNumber) == 0)) {
				logSteps.execution_log("Verification of Block Number: <" + strExpectedBlockNumber + "> - UnSuccessful. Actual: <" + strActualBlockNumber + ">");
				return false;
			}
			if (!(strComp(strActualRemnantNumber, strExpectedRemnantNumber) == 0)) {
				logSteps.execution_log("Verification of Number of Remnant Properties: <" + strExpectedRemnantNumber + "> - UnSuccessful. Actual: <" + strActualRemnantNumber + ">");
				return false;
			}
			OpenCondominium_VerifyDataNotDiscarded = true;
			return OpenCondominium_VerifyDataNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on cancel button Open Condominium with data entry")
	public boolean OpenCondominium_Cancel(String shtName, String intRow) {
		try {
			boolean OpenCondominium_Cancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = OpenCondominium_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			openCondominiumPage.Cancel_WebButton.click();
			logSteps.execution_log("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Main Menu> page is displayed - Successful");
			OpenCondominium_Cancel = true;
			return OpenCondominium_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on cancel button Open Condominium without data entry")
	public boolean OpenCondominium_Cancel() {
		try {
			boolean OpenCondominium_Cancel = false;
			boolean intRet = false;
			openCondominiumPage.Cancel_WebButton.click();
			logSteps.execution_log("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "OK";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Main Menu> page is displayed - Successful");
			OpenCondominium_Cancel = true;
			return OpenCondominium_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@When("user clicks on the Proceed button on the Condominium Amendment page $shtName and $intRow")
    public boolean OpenCondominium_Proceed(String shtName, String intRow) {
           try {
                  String strStepName = "OpenCondominium_Proceed";
                  boolean OpenCondominium_Proceed = false;
                  if (shtName.isEmpty() || intRow.isEmpty()) {
                        logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
                        return false;
                  }
                  boolean intRet = OpenCondominium_EnterData(shtName, intRow);
                  if (intRet == false) {
                        return false;
                  }
                  String strPreBlock = openCondominiumPage.TargetBlock_WebEdit.getAttribute("value");
                  String strPrePIN = openCondominiumPage.TargetPIN_WebEdit.getAttribute("value");
                  String strPrePlanNumber = openCondominiumPage.PlanNumber_WebEdit.getAttribute("value");
                  String strPreBlockNumber = openCondominiumPage.BlockNumber_WebEdit.getAttribute("value");
                  String strPreRemnantNumber = openCondominiumPage.RemnantNumber_WebEdit.getAttribute("value");
                  String oPage = null;
                  openCondominiumPage.Proceed_WebButton.click();
                  if (environmentlib.getProperty("bTriggered").equals("true")) {
                	  logSteps.execution_log("Click <Proceed> button - UnSuccessful");
                        return false;
                  }
                  // logsteps.execution_log("<Proceed> button is clicked");
                  VerifyApplicationError();
                  String strExpectedMsgs = null;
                  String strErrorMsgs = null;
                  strErrorMsgs = openCondominiumPage.ErrorMsg_WebTable.getText().trim();
                  strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
                  if (!strErrorMsgs.isEmpty()) {
                        intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
                        if (intRet == false) {
                               OpenCondominium_Proceed = false;
                        }
                        intRet = OpenCondominium_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPrePlanNumber, strPreBlockNumber, strPreRemnantNumber);
                        if (intRet == false) {
                               OpenCondominium_Proceed = false;
                        }
                        return false;
                  }
                  
                  if (!propertyDetailPage.ParentPINHeader_WebElement.isPresent()) {
                                                   logSteps.execution_log("<Property Detail> page Not displayed - UnSuccessful");
                        return false;
                  }
                  
                  if (intRet == false) {
                                                   logSteps.execution_log("Verification of <Property Detail> page - UnSuccessful");
                        return false;
                  }
                  
                  if (!propertyDetailPage.BulkEdit_WebButton.isPresent()) {
                                                   logSteps.execution_log("<Property Detail Bulk Edit> page displayed - Successful");
                        OpenCondominium_Proceed = true;
                  } else {
                                                   // logsteps.execution_log("<Property Detail Bulk Edit> page Not displayed - UnSuccessful");
                  }
                  return OpenCondominium_Proceed;
           } catch (Exception e) {
                  e.printStackTrace();
                  return false;
           }
    }
	
	@When("user clicks on the Cancel button on the Open Condominium page")
    public boolean OpenCondominium_Cancel_button() {
           openCondominiumPage.Cancel_WebButton.click();
           Alert a = mainPage.getDriver().switchTo().alert();
           a.accept();
           return false;
    }


}
