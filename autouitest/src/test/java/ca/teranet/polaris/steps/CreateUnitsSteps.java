package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CreateUnitsPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import net.thucydides.core.annotations.Steps;

public class CreateUnitsSteps extends Utility {

	CreateUnitsPage createUnitsPage;
	BatchPage batchPage;
	@Steps
	ELRSCommonSteps elrsCommonSteps;
	@Steps
	PropertyCommonSteps propertyCommonSteps;
	@Steps
	LogSteps logSteps;

	public boolean CreateUnits_EnterData(String shtName, String intRow) {
		boolean CreateUnits_EnterData = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			createUnitsPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			CreateUnits_EnterData = true;
			return CreateUnits_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_EnterData;
		}
	}

	public boolean CreateUnits_VerifyDataNotDiscarded(String strExpectedRegNumber, String strExpectedBlockNumber) {
		boolean CreateUnits_VerifyDataNotDiscarded = false;
		try {
			CreateUnits_VerifyDataNotDiscarded = false;
			String strActualRegNumber = createUnitsPage.RegNumber_WebEdit.getAttribute("value");
			String strActualBlockNumber = createUnitsPage.BlockNumber_WebEdit.getAttribute("value");
			if (strComp(strActualRegNumber, strExpectedRegNumber) != 0) {
			}
			if (strComp(strActualBlockNumber, strExpectedBlockNumber) != 0) {
			}
			CreateUnits_VerifyDataNotDiscarded = true;
			return CreateUnits_VerifyDataNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_VerifyDataNotDiscarded;
		}
	}

	@When("user clicks on cancel button on create units from common elements $shtName and $intRow")
	public boolean user_click_on_cancelbutton_on_createunitsfromcommonlements(String shtName, String intRow) {
		boolean CreateUnits_Cancel = false;
		try {
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = CreateUnits_EnterData(shtName, intRow);
				if (intRet == false) {
					return CreateUnits_Cancel;
				}
			}
			createUnitsPage.Cancel_WebButton.click();
			String strAction = "OK";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			intRet = VerifyPage("Main Menu");
			CreateUnits_Cancel = true;
			return CreateUnits_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_Cancel;
		}
	}

	@When("user clicks on cancel button on create units from common elements")
	public boolean user_click_on_cancelbutton_on_createunitsfromcommonlements() {
		boolean CreateUnits_Cancel = false;
		try {
			createUnitsPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.accept();
			CreateUnits_Cancel = true;
			return CreateUnits_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_Cancel;
		}
	}

	@When("user cancels the cancel createunits $shtName and $intRow")
	public boolean user_cancels_the_cancel_createunits(String shtName, String intRow) {
		boolean CreateUnits_CancelCancel = false;
		try {
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = CreateUnits_EnterData(shtName, intRow);
				if (intRet == false) {
					return CreateUnits_CancelCancel;
				}
			}
			String strPreRegNumber = createUnitsPage.RegNumber_WebEdit.getAttribute("value");
			String strPreBlockNumber = createUnitsPage.BlockNumber_WebEdit.getAttribute("value");
			createUnitsPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.dismiss();
			intRet = CreateUnits_VerifyDataNotDiscarded(strPreRegNumber, strPreBlockNumber);
			return CreateUnits_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_CancelCancel;
		}
	}

	public boolean CreateUnits_BatchProceed_RetrieveWIP(String strRegNumber) {
		boolean CreateUnits_BatchProceed_RetrieveWIP = false;
		try {
			String strStepName = "CreateUnits_BatchProceed_RetrieveWIP";
			CreateUnits_BatchProceed_RetrieveWIP = false;
			boolean intRet = false;
			// Navigate to Create Units from Common Elements
			intRet = elrsCommonSteps.user_navigates_to("CreateUnits");
			if (intRet == false) {
				return CreateUnits_BatchProceed_RetrieveWIP;
			}
			Thread.sleep(2000);
			// Initialization
			environmentlib.setProperty("bTriggered", "false");
			// Enter data

			createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			if (Boolean.parseBoolean(environmentlib.getValue("Test", "bTriggered")) == true) {
				/*
				 * Reporter.reportEvent(Status.Failed, strStepName, "Re-Enter Registration Number:<" + strRegNumber + "> - UnSuccessful"); AddInfo("Re-Enter Registration Number:<" + strRegNumber + "> - UnSuccessful");
				 */ return CreateUnits_BatchProceed_RetrieveWIP;
			}
			/*
			 * Reporter.reportEvent(Status.Passed, strStepName, "Registration Number:<" + strRegNumber + "> is re-entered"); AddInfo("Registration Number:<" + strRegNumber + "> is re-entered");
			 */ // If Retrieve WIP button is disabled, re-enter data as many as 10
			// times
			int intCounter = 1;
			while (createUnitsPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				if (intCounter == 10) {
					/*
					 * Reporter.reportEvent(Status.Failed, strStepName, "<Retrieve WIP> button is still disabled after 10 times attempts to trigger it"); AddInfo("<Retrieve WIP> button is still Disabled after 10 times attempts to trigger it");
					 */ return CreateUnits_BatchProceed_RetrieveWIP;
				}
				// Re-Enter data
				createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				createUnitsPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				intCounter = intCounter + 1;
			}
			// Click Retrieve WIP button
			createUnitsPage.RetrieveWIP_WebButton.click();
			if (Boolean.parseBoolean(environmentlib.getValue("Test", "bTriggered")) == true) {
				/*
				 * Reporter.reportEvent(Status.Failed, strStepName, "Click <Retrieve WIP> button - UnSuccessful"); AddInfo("Click <Retrieve WIP> button - UnSuccessful");
				 */ return CreateUnits_BatchProceed_RetrieveWIP;
			}
			// AddInfo("<Retrieve WIP> button is clicked");
			CreateUnits_BatchProceed_RetrieveWIP = true;
			return CreateUnits_BatchProceed_RetrieveWIP;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateUnits_BatchProceed_RetrieveWIP;
		}
	}

	public boolean RetrievePINAndVerifyRemarks_CreateUnits(String strDetailInfo, String shtName, String intRow) {
		boolean RetrievePINAndVerifyRemarks_CreateUnits = false;
		try {
			String strStepName = "RetrievePINAndVerifyRemarks_CreateUnits";
			RetrievePINAndVerifyRemarks_CreateUnits = false;
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow));
			strDocumentType = strDocumentType.toUpperCase();
			String strRemarks = strDocumentType + strRegNumber;
			if (!(InStr(strDetailInfo, strRemarks) > 0)) {
				// Use Registration Number only as sometimes document type
				// can//t be retrieved successful
				// strRemarks = strRegNumber
				// strRemarks = UCase(strRemarks)
				if (!(InStr(strDetailInfo, strRegNumber) > 0)) {
					logSteps.execution_log("The expected Remarks <" + strDocumentType + " " + strRegNumber + ">  NOT displayed on the PDF page - UnSuccessful");
					return RetrievePINAndVerifyRemarks_CreateUnits;
				}
			}
			logSteps.execution_log("<Remarks: " + strDocumentType + " " + strRegNumber + "> displayed on the <Map Maintenance Request> page - Successful");
			RetrievePINAndVerifyRemarks_CreateUnits = true;
			boolean intRet = false;
			intRet = propertyCommonSteps.RetrieveCreatedPINRange(strDetailInfo, strBlockNumber, shtName, intRow);
			if (intRet == false) {
				logSteps.execution_log("Retrieve Created Pins - Warning!");
				RetrievePINAndVerifyRemarks_CreateUnits = false;
				return RetrievePINAndVerifyRemarks_CreateUnits;
			}
			logSteps.execution_log("Retrieve Created Pins - Successful");
			RetrievePINAndVerifyRemarks_CreateUnits = true;
			return RetrievePINAndVerifyRemarks_CreateUnits;
		} catch (Exception e) {
			e.printStackTrace();
			return RetrievePINAndVerifyRemarks_CreateUnits;
		}
	}
}
