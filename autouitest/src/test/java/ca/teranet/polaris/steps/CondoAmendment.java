package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CondoAmendmentPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.MapMaintenanceRequestPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.PropertyReportReviewPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;

public class CondoAmendment extends Utility {

	CondoAmendmentPage condoAmendmentPage;
	PropertyDetailPage propertyDetailPage;
	MainPage mainPage;
	PropertyReportReviewPage propertyReportReviewPage;
	// PropertyCommon propertycommon = new PropertyCommon();
	MapMaintenanceRequestPage mapMaintenanceRequestPage;
	BatchPage batchPage;
	ELRSCommonSteps elrscommonsteps;
	LogSteps logSteps = new LogSteps();

	@When("user Cancel the Cancel Condominium Amendment $shtName and $intRow")
	public boolean CondoAmendment_CancelCancel(String shtName, String intRow) {
		// Object CondoAmendment_CancelCancel = null;
		try {
			String strStepName = null;
			strStepName = "CondoAmendment_CancelCancel";
			boolean intRet = false;
			boolean CondoAmendment_CancelCancel = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = CondoAmendment_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			String oPage = null;
			String strPreBlock = condoAmendmentPage.TargetBlock_WebEdit.getValue();
			String strPrePIN = condoAmendmentPage.TargetPIN_WebEdit.getValue();
			String strPreRegNumber = condoAmendmentPage.RegNumber_WebEdit.getValue();
			String strPreBlockNumber = condoAmendmentPage.BlockNumber_WebEdit.getValue();
			String strPreRemnantNumber = condoAmendmentPage.RemnantNumber_WebEdit.getValue();
			oPage = null;
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			condoAmendmentPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.dismiss();
			if (!condoAmendmentPage.RegNumber_WebElement.isPresent()) {
				return false;
			}
			// Verify data not discarded
			intRet = CondoAmendment_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPreRegNumber, strPreBlockNumber, strPreRemnantNumber);
			CondoAmendment_CancelCancel = true;
			return CondoAmendment_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean CondoAmendment_EnterData(String shtName, String intRow) {
		boolean CondoAmendment_EnterData = false;
		try {

			String strStepName = "CondoAmendment_EnterData";
			// Fetch valid data
			String strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			String strRemnantNumber = GetValueIfValid("RemnantNumber", shtName, Integer.parseInt(intRow));
			String oPage = null;
			condoAmendmentPage.TargetBlock_WebEdit.getAttribute("value");
			condoAmendmentPage.TargetPIN_WebEdit.getAttribute("value");
			if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
				String regNumber = Generate_Unique_RegNumber();
				condoAmendmentPage.RegNumber_WebEdit.sendKeys(regNumber);
			} else {
				condoAmendmentPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			}
			if (!strRegNumber.equals("IGNORE_VALUE") && !strRegNumber.isEmpty()) {
				int intCount = 0;
				boolean intRet = false;
				// intCount = 1;
				// while (condoAmendmentPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("true")) {
				// if (intCount < 10) {
				// Thread.sleep(5);
				// // intRet = ELRS_Navigate_To_Menu("CondoAmendment");
				//
				// condoAmendmentPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
				// condoAmendmentPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
				// condoAmendmentPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				//
				// intCount = intCount + 1;
				// if (condoAmendmentPage.RetrieveWIP_WebButton.getAttribute("disabled").equals("false")) {
				// break;
				// }
				// } else {
				// oPage = null;
				// return false;
				// }
				// }
			}
			condoAmendmentPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			condoAmendmentPage.RemnantNumber_WebEdit.sendKeys(strRemnantNumber);
			oPage = null;
			if (!strTargetBlock.isEmpty() || !strRegNumber.isEmpty() || !strBlockNumber.isEmpty()) {
			}
			CondoAmendment_EnterData = true;
			return CondoAmendment_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean CondoAmendment_VerifyDataNotDiscarded(String strExpectedBlock, String strExpectedPIN, String strExpectedRegNumber, String strExpectedBlockNumber, String strExpectedRemnantNumber) {
		// boolean CondoAmendment_VerifyDataNotDiscarded = null;
		try {
			// Object strStepName=null;
			String strStepName = "CondoAmendment_VerifyDataNotDiscarded";
			boolean CondoAmendment_VerifyDataNotDiscarded = false;
			// Declare variable

			// Retrieve data on the current screen
			String strActualBlock = condoAmendmentPage.TargetBlock_WebEdit.getValue();
			String strActualPIN = condoAmendmentPage.TargetPIN_WebEdit.getValue();
			String strActualRegNumber = condoAmendmentPage.RegNumber_WebEdit.getValue();
			String strActualBlockNumber = condoAmendmentPage.BlockNumber_WebEdit.getValue();
			String strActualRemnantNumber = condoAmendmentPage.RemnantNumber_WebEdit.getValue();
			String oPage = null;
			// Verify the parent block number
			if (strComp(strActualBlock, strExpectedBlock) == 0) {
				return false;
			}
			if (strComp(strActualPIN, strExpectedPIN) == 0) {
				return false;
			}
			if (strComp(strActualRegNumber, strExpectedRegNumber) == 0) {
				return false;
			}
			if (strComp(strActualBlockNumber, strExpectedBlockNumber) == 0) {
				return false;
			}
			if (strComp(strActualRemnantNumber, strExpectedRemnantNumber) == 0) {
				return false;
			}
			CondoAmendment_VerifyDataNotDiscarded = true;
			return CondoAmendment_VerifyDataNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Cancel Condominium Amendment")
	public boolean CondoAmendment_Cancel() {
		try {
			String strStepName = null;
			strStepName = "CondoAmendment_Cancel";
			boolean CondoAmendment_Cancel = false;
			boolean intRet = false;
			condoAmendmentPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.accept();
			CondoAmendment_Cancel = true;
			return CondoAmendment_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean CondoAmendment_Cancel(String shtName, String intRow) {
		// Object CondoAmendment_Cancel = null;
		try {
			String strStepName = null;
			strStepName = "CondoAmendment_Cancel";
			boolean CondoAmendment_Cancel = false;
			boolean intRet = false;
			// Enter data only data provided
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				// Call function to enter data
				intRet = CondoAmendment_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			condoAmendmentPage.Cancel_WebButton.click();
			String strAction = null;
			strAction = "OK";
			intRet = elrscommonsteps.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			// Verify the application returns to the Main Menu page
			intRet = elrscommonsteps.VerifyPage("Main Menu");
			if (intRet == false) {
				return false;
			}
			CondoAmendment_Cancel = true;
			return CondoAmendment_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
