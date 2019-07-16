package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CondoAmalgamationPage;
import ca.teranet.pages.polaris.FreezePropertyPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import net.thucydides.core.annotations.Steps;

public class CondoAmalgamation extends Utility {

	@Steps
	CondoAmalgamationPage condoAmalgamationPage;
	BatchPage batchPage;
	FreezePropertyPage freezePropertyPage;
	ELRSCommonSteps elrsCommonSteps;
	LogSteps logSteps;
	PropertyCommonSteps propertyCommonSteps;

	public boolean CondoAmalgamation_EnterData(String shtName, String intRow) {
		boolean CondoAmalgamation_EnterData = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			condoAmalgamationPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			condoAmalgamationPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			CondoAmalgamation_EnterData = true;
			return CondoAmalgamation_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean CondoAmalgamation_VerifyDataNotDiscarded(String strExpectedRegNumber, String strExpectedBlockNumber) {
		boolean CondoAmalgamation_VerifyDataNotDiscarded = false;
		try {
			CondoAmalgamation_VerifyDataNotDiscarded = false;
			String strActualRegNumber = condoAmalgamationPage.RegNumber_WebEdit.getAttribute("value");
			String strActualBlockNumber = condoAmalgamationPage.BlockNumber_WebEdit.getAttribute("value");
			if (strComp(strActualRegNumber, strExpectedRegNumber) != 0) {
				return CondoAmalgamation_VerifyDataNotDiscarded;
			}
			if (strComp(strActualBlockNumber, strExpectedBlockNumber) != 0) {
				return CondoAmalgamation_VerifyDataNotDiscarded;
			}
			CondoAmalgamation_VerifyDataNotDiscarded = true;
			return CondoAmalgamation_VerifyDataNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels condominium amalgamation $shtName and $intRow")
	public boolean user_cancels_condominium_amalgamation(String shtName, String intRow) {
		boolean CondoAmalgamation_Cancel = false;
		try {
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = CondoAmalgamation_EnterData(shtName, intRow);
				if (intRet == false) {
					return CondoAmalgamation_Cancel;
				}
			}
			condoAmalgamationPage.Cancel_WebButton.click();
			String strAction = "OK";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return CondoAmalgamation_Cancel;
			}
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				return CondoAmalgamation_Cancel;
			}
			CondoAmalgamation_Cancel = true;
			return CondoAmalgamation_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels condominium amalgamation")
	public boolean user_cancel_condominium_amalgamation() {
		boolean CondoAmalgamation_Cancel = false;
		try {
			condoAmalgamationPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.accept();
			CondoAmalgamation_Cancel = true;
			return CondoAmalgamation_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels the cancel condominium amalgamation $shtName and $intRow")
	public boolean user_cancel_the_cancel_condominium_amalgamation(String shtName, String intRow) {
		boolean CondoAmalgamation_CancelCancel = false;
		try {
			boolean intRet = false;
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
				String regNumber = Generate_Unique_RegNumber();
				String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
				condoAmalgamationPage.RegNumber_WebEdit.sendKeys(regNumber);
				condoAmalgamationPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			}
			String strPreRegNumber = condoAmalgamationPage.RegNumber_WebEdit.getAttribute("value");
			String strPreBlockNumber = condoAmalgamationPage.BlockNumber_WebEdit.getAttribute("value");
			condoAmalgamationPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.dismiss();
			intRet = CondoAmalgamation_VerifyDataNotDiscarded(strPreRegNumber, strPreBlockNumber);
			CondoAmalgamation_CancelCancel = true;
			return CondoAmalgamation_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean CondoAmalgamation_BatchProceed_RetrieveWIP(String strRegNumber) {
		boolean CondoAmalgamation_BatchProceed_RetrieveWIP = false;
		try {
			String strStepName = "CondoAmalgamation_BatchProceed_RetrieveWIP";
			boolean intRet = false;
			int intCounter = 0;
			intRet = elrsCommonSteps.user_navigates_to("CondoAmalgamation");
			if (intRet == false) {
				return CondoAmalgamation_BatchProceed_RetrieveWIP;
			}
			Thread.sleep(2000);
			condoAmalgamationPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			condoAmalgamationPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			intCounter = 1;
			while (condoAmalgamationPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				if (intCounter == 10) {
					// Reporter.reportEvent(Status.Failed, strStepName, "<Retrieve WIP> button is still disabled after 10 times attempts to trigger it");
					// AddInfo("<Retrieve WIP> button is still Disabled after 10 times attempts to trigger it");
					return CondoAmalgamation_BatchProceed_RetrieveWIP;
				}
				// Re-Enter data
				// condoAmalgamationPage.RegNumber_WebEdit.TypeStr(strRegNumber);
				condoAmalgamationPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				condoAmalgamationPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				intCounter = intCounter + 1;
			}
			// Click Retrieve WIP button
			condoAmalgamationPage.RetrieveWIP_WebButton.click();
			// AddInfo("<Retrieve WIP> button is clicked");
			CondoAmalgamation_BatchProceed_RetrieveWIP = true;
			return CondoAmalgamation_BatchProceed_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrievePINAndVerifyRemarks_CondoAmalgamation(String strDetailInfo, String shtName, String intRow) {
		boolean RetrievePINAndVerifyRemarks_CondoAmalgamation = false;
		try {
			String strStepName = "RetrievePINAndVerifyRemarks_CondoAmalgamation";
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow));
			strDocumentType = strDocumentType.toUpperCase();
			String strRemarks = strDocumentType + strRegNumber;
			if (!(InStr(strDetailInfo, strRemarks) > 0)) {
				// strRemarks = strRegNumber
				// strRemarks = UCase(strRemarks)
				if (!(InStr(strDetailInfo, strRegNumber) > 0)) {
					logSteps.execution_log("The expected Remarks <" + strDocumentType + " " + strRegNumber + ">  NOT displayed on the PDF page - UnSuccessful");
					return RetrievePINAndVerifyRemarks_CondoAmalgamation;
				}
			}
			logSteps.execution_log("<Remarks: " + strDocumentType + " " + strRegNumber + "> displayed on the <Map Maintenance Request> page - Successful");
			RetrievePINAndVerifyRemarks_CondoAmalgamation = true;
			boolean intRet = false;
			intRet = propertyCommonSteps.RetrieveCreatedPINRange(strDetailInfo, strBlockNumber, shtName, intRow);
			if (intRet = false) {
				logSteps.execution_log("Retrieve Created Pins - Warning!");
				RetrievePINAndVerifyRemarks_CondoAmalgamation = false;
			}
			logSteps.execution_log("Retrieve Created Pins - Successful");
			RetrievePINAndVerifyRemarks_CondoAmalgamation = true;
			return RetrievePINAndVerifyRemarks_CondoAmalgamation;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
