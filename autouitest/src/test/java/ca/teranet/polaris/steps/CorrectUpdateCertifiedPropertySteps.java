package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.CorrectUpdateCertifiedPropertyPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import net.thucydides.core.annotations.Steps;

public class CorrectUpdateCertifiedPropertySteps extends Utility {
	@Steps
	LogSteps logSteps;
	CorrectUpdateCertifiedPropertyPage correctUpdateCertifiedPropertyPage;

	@When("user clicks on the Proceed button on CorrectUpdateCertifiedProperty $shtName and $intRow")
	public boolean CorrectUpdateCertifiedProperty_Proceed(String shtName, String intRow) {
		boolean CorrectUpdateCertifiedProperty_Proceed = false;
		try {
			String strStepName = "CorrectUpdateCertifiedProperty_Proceed";

			if (intRow.equals("")) {
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
			CorrectUpdateCertifiedProperty_Proceed = true;
			return CorrectUpdateCertifiedProperty_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_Proceed;
		}
	}

	public boolean CorrectUpdateCertifiedProperty_PINEntry_EnterData(String shtName, String intRow) {
		boolean CorrectUpdateCertifiedProperty_PINEntry_EnterData = false;
		try {
			String strStepName = "CorrectUpdateCertifiedProperty_PINEntry_EnterData";

			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(Integer.parseInt(intRow))));
			// Declare variables
			// Fetch data
			String strTargetBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));
			String strTargetPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow)).toUpperCase();
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Enter data
			correctUpdateCertifiedPropertyPage.Block_WebEdit.sendKeys(strTargetBlock);
			correctUpdateCertifiedPropertyPage.Property_WebEdit.sendKeys(strTargetPIN);
			// if (Boolean.parseBoolean(environmentlib.getValue("bTriggered")) == true) {
			// /*
			// * Reporter.reportEvent(Status.Failed, strStepName, "Enter data to <PIN Entry> page - UnSuccessful"); AddInfo("Enter data to <PIN Entry> page - UnSuccessful");
			// */ return CorrectUpdateCertifiedProperty_PINEntry_EnterData;
			// }
			//
			// logsteps.execution_log(Status.Passed, strStepName, "Enter PIN <" + strTargetBlock + "-" + strTargetPIN + "> - Successful");
			// AddInfo("Enter PIN <" + strTargetBlock + "-" + strTargetPIN + "> - Successful");
			CorrectUpdateCertifiedProperty_PINEntry_EnterData = true;
			return CorrectUpdateCertifiedProperty_PINEntry_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_PINEntry_EnterData;
		}
	}
	
	
	@When("user cancels the Cancel correctupdate certified property")
	public boolean CorrectUpdateCertifiedProperty_CancelCancel() {
		boolean CorrectUpdateCertifiedProperty_CancelCancel = false;
		try {
			String strStepName = "CorrectUpdateCertifiedProperty_CancelCancel";
			correctUpdateCertifiedPropertyPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.dismiss();
			logSteps.execution_log("user clicks on the Cancel button on correctupdate certified property Successfully");
			CorrectUpdateCertifiedProperty_CancelCancel = true;
			return CorrectUpdateCertifiedProperty_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_CancelCancel;
		}
	}
	
	@When("user cancels the Cancel correctupdate certified property $shtName and $intRow")
	public boolean CorrectUpdateCertifiedProperty_CancelCancel(String shtName, String intRow) {
		boolean CorrectUpdateCertifiedProperty_CancelCancel = false;
		try {
			String strStepName = "CorrectUpdateCertifiedProperty_CancelCancel";
			boolean intRet = false;
			if (!shtName.equals("") && !intRow.equals("")) {
				intRet = CorrectUpdateCertifiedProperty_PINEntry_EnterData(shtName, intRow);
				if (intRet == false) {
					return CorrectUpdateCertifiedProperty_CancelCancel;
				}
			}
			String strExpectedBlock = correctUpdateCertifiedPropertyPage.Block_WebEdit.getAttribute("value").trim();
			String strExpectedPIN = correctUpdateCertifiedPropertyPage.Property_WebEdit.getAttribute("value").trim();
			correctUpdateCertifiedPropertyPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.dismiss();
			logSteps.execution_log("Click <Cancel> button - Successful");
			String strAction = null;
			strAction = "Cancel";
			String strActualBlock = correctUpdateCertifiedPropertyPage.Block_WebEdit.getAttribute("value").trim();
			String strActualPIN = correctUpdateCertifiedPropertyPage.Property_WebEdit.getAttribute("value").trim();
			if (strComp(strExpectedBlock, strActualBlock) != 0) {
				if (strComp(strExpectedPIN, strActualPIN) != 0) {
					logSteps.execution_log("Verification of the <PIN> before and after Cancel clicked - UnSuccessful. Before: <" + strExpectedBlock + "-" + strExpectedPIN + ">, After:<" + strActualBlock + "-"
							+ strActualPIN + ">");
				} else {
					logSteps.execution_log("Verification of the <Block> before and after Cancel clicked - UnSuccessful");
				}
				return CorrectUpdateCertifiedProperty_CancelCancel;
			}
			logSteps.execution_log("Verification of the <PIN> on PIN Entry page - Successful");
			CorrectUpdateCertifiedProperty_CancelCancel = true;
			return CorrectUpdateCertifiedProperty_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CorrectUpdateCertifiedProperty_CancelCancel;
		}
	}
}
