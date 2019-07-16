package ca.teranet.polaris.steps;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import ca.teranet.pages.polaris.DescriptionPage;

//import com.libraries.VB2JavaLibrary.EnvironmentLibrary;

//import ca.teranet.pages.polaris.DescriptionPage;
import ca.teranet.pages.polaris.FreezePropertyPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.ReEnterPropertyPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import net.thucydides.core.annotations.Step;

public class ReEnterProperty extends Utility {

	// DataTable datatableLib = new DataTable();

	// EnvironmentLibrary environmentlib = new EnvironmentLibrary();
	// ReEnterProperty reenterproperty = new ReEnterProperty();
	ReEnterPropertyPage reEnterPropertyPage;
	// ELRSCommon elrscommon = new ELRSCommon();
	FreezePropertyPage freezePropertyPage;
	PropertyDetailPage propertyDetailPage;
	// JavaLibrary gallopjavalib = new JavaLibrary();
	// DescriptionPage descriptionPage;
	DescriptionPage descriptionPage;
	ELRSCommonSteps elrscommon;
	// ELRSCommonSteps elrscommonsteps;
	LogSteps logsteps;

	@Step
	public void testStep() {
		try {
			// ******************************************************************************************
			// Function Name: ReEnterProperty_Submission_EnterData
			// Description: Fill the data in the Re-enter Property Submission page
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-07-2012 / Jenny / Initial version
			// ******************************************************************************************
			// ***********************************************************************************************
			// Function Name: ReEnterProperty_CancelCancel
			// Description: Cancel the Cancel Re-enter Property with/without data entry
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False or Warning
			// Change Log:
			// 09-07-2012 / Jenny / Initial version
			// **********************************************************************************************
			// ********************************************************************************
			// Function Name: ReEnterProperty_Cancel
			// Description: Cancel Re-enter Property with/without data entry
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-07-2012 / Jenny / Initial version
			// ********************************************************************************
			// ***************************************************************************************************************
			// Function Name: ReEnterProperty_Proceed
			// Description: Click the Proceed button on the Submission page with/without data entry
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-10-2012 / Jenny / Initial version
			// ***************************************************************************************************************
			// *****************************************************************************************************************************************************
			// Function Name: ReEnterProperty_CancelWIP
			// Description: Click Cancel or OK on the Cancel WIP popup on Re-enter Property Submission page with/without data entry
			// Input Parameter:
			// strAction - action to be performed, click Cancel or OK
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-11-2012 / Jenny / Initial version
			// ******************************************************************************************************************************************************
			// ********************************************************************************************************************
			// Function Name: ReEnterProperty_RetrieveWIP
			// Description: Click the Retrieve WIP button on the Submission page with/without data entry
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-11-2012 / Jenny / Initial version
			// ********************************************************************************************************************
			// **********************************************************************************************
			// Function Name: ReEnterProperty_Verify_ParentPIN
			// Description: Verify the parent pin displayed on the property detail page
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-13-2012 / Jenny / Initial version
			// **********************************************************************************************
			// *************************************************************************************************
			// Function Name: ReEnterProperty_Verify_BlockNumber
			// Description: Verify the block number displayed on the property detail page
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-13-2012 / Jenny / Initial version
			// **********************************************************************************************
			// *******************************************************************************************************
			// Function Name: ReEnterProperty_Verify_RegSystem
			// Description: Verify the registration system displayed on the property detail page
			// Input Parameter:
			// shtName - sheet name
			// intRow - row index
			// Return Value: True or False
			// Change Log:
			// 09-13-2012 / Jenny / Initial version
			// *******************************************************************************************************
			// *********************************************************************************************
			// Function Name: RetrievePINAndVerifyRemarks_ReEnter
			// Description: Verify the remarks on the PDF page for Re-enter Property
			// Input Parameter:
			// strDetailInfo - detail information from PDF page
			// Return Value: True or False
			// Change Log:
			// 09-13-2012 / Jenny / Initial version
			// *********************************************************************************************
			// *******************************************************************************************************
			// Function Name: ReEnterProperty_VerifyDataNotDiscarded
			// Description: Verify the registration system displayed on the property detail page
			// Input Parameter:
			// strExpectedBlock - expected block number
			// strExoectedPIN - expected PIN number
			// strExpectedNewBlock - expected new block number
			// strExpectedConversionType - expected conversion type
			// Return Value: True or Warning
			// Change Log:
			// 09-14-2012 / Jenny / Initial version
			// *******************************************************************************************************
			System.out.println("Test Passed");
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		}
	}

	public boolean ReEnterProperty_Submission_EnterData(String shtName, String intRow) {
		// Object ReEnterProperty_Submission_EnterData=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_Submission_EnterData";
			boolean ReEnterProperty_Submission_EnterData = false;
			// Declare variables
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strNewBlock = null;
			String strConversionType = null;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
			// Fetch valid data
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			strNewBlock = GetValueIfValid("NewBlock", shtName, Integer.parseInt(intRow));
			strConversionType = GetValueIfValid("ConversionType", shtName, Integer.parseInt(intRow));
			// Object oPage = null;

			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Enter data
			// oPage.WebEdit("TargetBlock").SetValue(strTargetBlock);
			// if (!(strTargetBlock) == "n/c"){
			// reEnterPropertyPage.TargetBlock_WebEdit
			// }
			// reEnterPropertyPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
			// oPage.WebEdit("TargetPIN").TypeStr(strTargetPIN);
			// reEnterPropertyPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
			// oPage.WebEdit("TargetPIN").SetValue(strTargetPIN);
			// reEnterPropertyPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
			// 02-12-2013/Jenny/Re-enter target pin if Retrieve WIP button not enabled
			if (!strTargetPIN.equals("IGNORE_VALUE") && !strTargetPIN.isEmpty() && !strTargetPIN.equals("n/c")) {
				int intCount = 1;
				// while (reEnterPropertyPage.EnterData_WebButton.getAttribute("disabled").equals("True")) {
				if (intCount < 10) {
					// Work around - re-navigate to the page
					Thread.sleep(5);
					// intRet =
					// elrscommon.user_navigates_to("ReEnterProperty");
					// oPage.WebEdit("TargetBlock").SetValue(strTargetBlock);
					reEnterPropertyPage.TargetBlock_WebEdit.clear();
					reEnterPropertyPage.TargetBlock_WebEdit.sendKeys(strTargetBlock);
					// oPage.WebEdit("TargetPIN").TypeStr(strTargetPIN);
					// oPage.WebEdit("TargetPIN").SetValue(strTargetPIN);
					reEnterPropertyPage.TargetPIN_WebEdit.clear();
					reEnterPropertyPage.TargetPIN_WebEdit.sendKeys(strTargetPIN);
					intCount = intCount + 1;
					// if (reEnterPropertyPage.EnterData_WebButton.getAttribute("disabled").equals("false")) {
					// break;
					// }
					// } else {
					// // Reporter.reportEvent(Status.Failed,strStepName,"<Retrieve WIP> button Not enabled after 10 times of attempts to input Parent PIN <"+strTargetBlock+"-"+strTargetPIN+">");
					// logsteps.execution_log("<Retrieve WIP> button Not enabled after 10 times of attempts to input Parent PIN <" + strTargetBlock + "-" + strTargetPIN + ">");
					// oPage = null;
					// return false;
					// }
				}

				reEnterPropertyPage.TargetBlock_WebEdit.sendKeys("");
				reEnterPropertyPage.TargetPIN_WebEdit.sendKeys("");
				reEnterPropertyPage.NewBlock_WebEdit.sendKeys(strNewBlock);
				// oPage.WebEdit("NewBlock").SetValue(strNewBlock);
				// Select conversion type
				// if (!strConversionType.equals("n/c")) {
				switch (strConversionType.toUpperCase()) {
				case "NO":
				case "":
				case "n/c":
				case "IGNORE_VALUE":
					// selectWebRadioGroup(
					reEnterPropertyPage.ConversionTypeNO_WebRadioGroup.click();
					// ConversionType_WebRadioGroup, 0);
					break;
				case "REGISTRYTOLANDTITLES":
					// selectWebRadioGroupByIndex(by, index);
					reEnterPropertyPage.ConversionTyperToL_WebRadioGroup.click();
					// selectByIndex(1);
					break;
				case "LANDTITLESTOREGISTRY":
					reEnterPropertyPage.ConversionTypeltTo_WebRadioGroup.click();
					// selectByIndex(2);
					break;

				// Reporter.reportEvent(Status.Failed,strSstepName,"UnKnown conversion type:<"+strConversionType+"> - UnSuccessful");
				// AddInfo("UnKnown conversion type:<"+strConversionType+"> - UnSuccessful");

				// break;
				}

				// }
				// oPage = null;
				// if (environmentlib.getProperty("bTriggered").equals("true")) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Enter data to <Submission> page - UnSuccessful");
				// logsteps.execution_log("Enter data to <Submission> page - UnSuccessful");
				// return false;
				// }
				// 09-11-2012/Jenny/Report only data not IGNORE-VALUE
				// if (!strTargetBlock.equals("IGNORE_VALUE") && !strTargetPIN.equals("IGNORE_VALUE")) {
				// Reporter.reportEvent(Status.Passed,strStepName,"Enter data to <Submission> page - Successful");
				// logsteps.execution_log("Parent PIN: <" + strTargetBlock + "-" + strTargetPIN + ">");
				// logsteps.execution_log("Enter data to <Submission> page - Successful");
				// }
			}
			ReEnterProperty_Submission_EnterData = true;
			return ReEnterProperty_Submission_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// return false;
	}

	public boolean ReEnterProperty_CancelCancel(String shtName, String intRow) {
		// Object ReEnterProperty_CancelCancel=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_CancelCancel";
			boolean intRet = false;
			boolean ReEnterProperty_CancelCancel = false;
			// Enter data only data provided
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				// Call function to enter data
				intRet = ReEnterProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			// Declare variables
			String strPreBlock = null;
			String strPrePIN = null;
			String strPreNewBlock = null;
			String strPreConversionType = null;
			String oPage = null;

			// Retrieve data before clicking Cancel button
			strPreBlock = reEnterPropertyPage.TargetBlock_WebEdit.getValue();
			strPrePIN = reEnterPropertyPage.TargetPIN_WebEdit.getValue();
			strPreNewBlock = reEnterPropertyPage.NewBlock_WebEdit.getValue();
			// strPreConversionType=reEnterPropertyPage.getWebElement("selected item index");
			// strPreConversionType = reEnterPropertyPage.ConversionType_WebRadioGroupno.getValue();
			// strPreConversionType = reEnterPropertyPage.ConversionType_WebRadioGroup.getSelectedValue();
			oPage = null;
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Click Cancel button
			reEnterPropertyPage.Cancel_WebButton.click();
			if (environmentlib.getProperty("bTriggered").equals("true")) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Click <Cancel> button - UnSuccessful");
				// AddInfo("Click <Cancel> button - UnSuccessful");
				return false;
			}
			// AddInfo("Click <Cancel> button - Successful");
			// Click Cancel on the Cancel popup
			String strAction = null;
			strAction = "Cancel";
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Click <Cancel> button on the Cancel Popup - UnSuccessful");
				// AddInfo("Click <Cancel> button on the Cancel Popup - UnSuccessful");
				// return TargetBlock;
			}
			// Verify the page
			if (!reEnterPropertyPage.Conversion_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The texts of <Conversion?> Not present on the page. Verification of the <Re-enter Property Submission> page - UnSuccessful");
				// AddInfo("The texts of <Conversion?> Not present on the page. Verification of the <Re-enter Property Submission> page - UnSuccessful");
				return false;
			}
			// Verify data not discarded
			intRet = ReEnterProperty_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPreNewBlock, strPreConversionType);
			// Exit function directly if verification failed
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Verification of the page - UnSuccessful");
				// AddInfo("Verification of the page - UnSuccessful");
				ReEnterProperty_CancelCancel = false;
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Verification of the page - Successful");
			// AddInfo("Verification of the page - Successful");
			ReEnterProperty_CancelCancel = true;
			return ReEnterProperty_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels the Re-enter Property $shtName and $intRow")
	public boolean ReEnterProperty_Cancel(String shtName, String intRow) {
		// Object ReEnterProperty_Cancel = null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_Cancel";
			boolean ReEnterProperty_Cancel = false;
			boolean intRet = false;
			// Enter data only data provided
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				// Call function to enter data
				intRet = ReEnterProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Click Cancel button
			reEnterPropertyPage.Cancel_WebButton.click();
			Alert a = mainPage.getDriver().switchTo().alert();
			a.accept();
			// if (environmentlib.getProperty("bTriggered").equals("true")) {
			// Reporter.reportEvent(Status.Failed, strStepName, "Click <Cancel> button - UnSuccessful");
			// logsteps.execution_log("Click <Cancel> button - UnSuccessful");
			// return false;
			// }
			// logsteps.execution_log("Click <Cancel> button - Successful");
			// Click OK on the cancel popup
			// String strAction = null;
			// strAction = "OK";
			// intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			// if (intRet == false) {
			// // Reporter.reportEvent(Status.Failed, strStepName, "Click <OK> button on the Cancel Popup - UnSuccessful");
			// logsteps.execution_log("Click <OK> button on the Cancel Popup - UnSuccessful");
			// return false;
			// }
			// Verify the application returns to the Main Menu page
			// intRet = elrscommon.VerifyPage("Main Menu");
			// intRet = VerifyPage("Main Menu");
			// if (intRet == false) {
			// // Reporter.reportEvent(Status.Failed, strStepName, "<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
			// logsteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
			// return false;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName, "<Main Menu> page is displayed - Successful");
			// logsteps.execution_log("<Main Menu> page is displayed - Successful");
			ReEnterProperty_Cancel = true;
			return ReEnterProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on the Proceed button on the Submission page $shtName and $intRow")
	public boolean ReEnterProperty_Proceed(String shtName, String intRow) {
		// Object ReEnterProperty_Proceed=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_Proceed";
			boolean ReEnterProperty_Proceed = false;
			// Input data can//t be empty
			if (shtName.isEmpty() || intRow.isEmpty()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The data input can NOT be empty - UnSuccessful");
				// AddInfo("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			boolean intRet = false;
			// Call function to enter data
			intRet = ReEnterProperty_Submission_EnterData(shtName, intRow);
			if (intRet == false) {
				return false;
			}
			// // Declare variables
			// String strPreBlock = null;
			// String strPrePIN = null;
			// String strPreNewBlock = null;
			// String strPreConversionType = null;
			// String oPage = null;
			// Retrieve data before clicking Proceed or Retrieve WIP button
			// strPreBlock = reEnterPropertyPage.TargetBlock_WebEdit.getAttribute("Value");
			// strPrePIN = reEnterPropertyPage.TargetPIN_WebEdit.getAttribute("Value");
			// strPreNewBlock = reEnterPropertyPage.NewBlock_WebEdit.getAttribute("Value");
			// strPreConversionType = reEnterPropertyPage.ConversionType_WebRadioGroup.selectByValue("selected item index");
			// oPage = null;
			// Initialization
			// environmentlib.setProperty("bTriggered", "false");
			// Click the Proceed button
			reEnterPropertyPage.Proceed_WebButton.click();
			// if (environmentlib.getProperty("bTriggered").equals("true")) {
			// Reporter.reportEvent(Status.Failed,strStepName,"Click <Proceed> button - UnSuccessful");
			// AddInfo("Click <Proceed> button - UnSuccessful");
			// return false;
			// }
			// AddInfo("<Proceed> button is clicked");
			// Verify error message
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			// Retrieve actual error message from the screen
			// 2015-07-10/Jenny/In Spring, GetCellData works only if there is only one message. It failed to retireve messages 2 or more
			// strErrorMsgs = Trim(Browser("ELRS").Page("ReEnterProperty").WebTable("ErrorMsg").GetCellData(1,1))
			// 2015-07-10/Jenny/Use innertext to retrieve 1 or more messages due to Spring change

			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (reEnterPropertyPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = reEnterPropertyPage.ErrorMsg_WebTable.getText().trim();
				// Set focus
				// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
				// Retrieve expected error message from datasheet

				if (!strErrorMsgs.isEmpty()) {
					// Verify the error message
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						ReEnterProperty_Proceed = false;
					}
				} else {
					strErrorMsgs = "";
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						ReEnterProperty_Proceed = false;
					}
				}

				// Verify the data
				// intRet = ReEnterProperty_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPreNewBlock, strPreConversionType);
				// if (intRet == false) {
				// ReEnterProperty_Proceed = false;
				// }
				// return false;
				// }
				// Verify the existance of Freeze Property page
				// if (freezePropertyPage.Header_WebElement.isPresent()) {
				// // intRet = VerifyFreezePropertyMessage(strExpectedMsgs);
				// if (intRet == false) {
				// ReEnterProperty_Proceed = false;
				// }
				// return false;
				// }
				// // Verify the page
				// if (!propertyDetailPage.ParentPINHeader_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"<Property Detail> page Not displayed - UnSuccessful");
				// AddInfo("<Property Detail> page Not displayed - UnSuccessful");
				// return false;
				// }
				// Reporter.reportEvent(Status.Passed,strStepName,"<Property Detail> page displayed - Successful");
				// AddInfo("<Property Detail> page displayed - Successful");
				// Verify the Parent PIN
				// intRet = ReEnterProperty_Verify_ParentPIN(shtName, intRow);
				// if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Verification of <Property Detail> page - UnSuccessful");
				// AddInfo("Verification of <Property Detail> page - UnSuccessful");
				// return false;
				// }
				// Verify the block number
				// intRet = ReEnterProperty_Verify_BlockNumber(shtName, intRow);
				// if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Verification of <Property Detail> page - UnSuccessful");
				// AddInfo("Verification of <Property Detail> page - UnSuccessful");
				// return false;
				// }
				// Verify the registration system
				// intRet = ReEnterProperty_Verify_RegSystem(shtName, intRow);
				// if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Verification of <Property Detail> page - UnSuccessful");
				// AddInfo("Verification of <Property Detail> page - UnSuccessful");
				// return false;
				// }
				// Reporter.reportEvent(Status.Passed,strStepName,"Verification of <Property Detail> page - Successful");
				// AddInfo("Verification of <Property Detail> page - Successful");
				ReEnterProperty_Proceed = true;
				return ReEnterProperty_Proceed;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@When("user cancels the Cancel Re-enter Property")
	public void user_cancels_theCancelRe_enterProperty() {
		mainPage.getDriver().findElement(By.xpath("//input[@value='Cancel']")).click();
		Alert a = mainPage.getDriver().switchTo().alert();
		a.dismiss();
	}

	@When("user cancels the Re-enter Property")
	public void user_CancelRe_enterProperty() {
		mainPage.getDriver().findElement(By.xpath("//input[@value='Cancel']")).click();
		Alert a = mainPage.getDriver().switchTo().alert();
		a.accept();
	}

	@When("user clicks Close button on PropertyDetail page")
	public void user_clicks_closebutton() {

		reEnterPropertyPage.Close_WebButton.click();
		Alert a = mainPage.getDriver().switchTo().alert();
		a.accept();
	}

	@When("user clicks Save button on PropertyDetail page")
	public void user_clicks_savebutton() {
		reEnterPropertyPage.Save_WebButton.click();

	}

	@When("user clicks OK button on CancelWIP on the ReEnterProperty page")
	public void ReEnterProperty_CancelWIP_OK() {
		reEnterPropertyPage.CancelWIP_WebButton.click();
		Alert a = mainPage.getDriver().switchTo().alert();
		a.accept();
	}

	@When("user clicks cancelWIP on the Re-enter Property $strAction and $shtName and $intRow")
	public boolean ReEnterProperty_CancelWIP(String strAction, String shtName, String intRow) {
		// Object ReEnterProperty_CancelWIP=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_CancelWIP";
			boolean ReEnterProperty_CancelWIP = false;
			boolean intRet = false;
			// Enter data only if applicable
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = ReEnterProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			// Declare variables and fetch the data on the screen before Cancel WIP is clicked as expected values
			String strPreBlock = null;
			String strPrePIN = null;
			String strPreNewBlock = null;
			String strPreConversionType = null;
			String oPage = null;
			strPreBlock = reEnterPropertyPage.TargetBlock_WebEdit.getValue();
			strPrePIN = reEnterPropertyPage.TargetPIN_WebEdit.getValue();
			strPreNewBlock = reEnterPropertyPage.NewBlock_WebEdit.getValue();
			// strPreConversionType=.getWebElement("selected item index");
			oPage = null;
			// Initialization
			// environmentlib.setProperty("bTriggered","false");
			// Click Cancel WIP button
			reEnterPropertyPage.CancelWIP_WebButton.click();
			// if (environmentlib.getProperty("bTriggered").equals("true")) {
			// Reporter.reportEvent(Status.Failed,strStepName,"Click <Cancel WIP> button - UnSuccessful");
			// AddInfo("Click <Cancel WIP> button - UnSuccessful");
			// return false;
			// }
			// AddInfo("<Cancel WIP> button is clicked");
			// Click OK or Cancel based on the data provided//divstartReEnterForm.errors

			String strButton = null;
			switch (strAction.toUpperCase()) {
			case "OK":
				strButton = "OK";
				Alert a = mainPage.getDriver().switchTo().alert();
				a.accept();
				break;
			case "CANCEL":
				strButton = "Cancel";
				Alert a1 = mainPage.getDriver().switchTo().alert();
				a1.dismiss();
				break;
			// default:
			// Reporter.reportEvent(Status.Failed,strStepName,"UnKnown action <"+strAction+"> is provided - UnSuccessful");
			// AddInfo("UnKnown action <"+strAction+"> is provided - UnSuccessful");
			// return false;
			// break;
			}
			// intRet = elrscommon.ELRS_Popup_Cancel(strButton);
			// if (intRet == false) {
			// Reporter.reportEvent(Status.Failed,strStepName,"Click <"+strButton+"> button on the Cancel WIP Popup - UnSuccessful");
			// AddInfo("Click <"+strButton+"> button on the Cancel WIP Popup - UnSuccessful");
			// return false;
			// }
			// // 2015-07-09/Jenny/Add the condition to verify the error message only when error message is present
			// 2015-07-09/Jenny/After Spring migration, error message object is present only when there is a error. Struts had the object available all the time even if no error presents
			if (reEnterPropertyPage.ErrorMsg_WebTable.isPresent())

			{
				// Verify error message
				String strExpectedMsgs = null;
				String strErrorMsgs = null;
				// Retrieve actual error message from the screen
				// strErrorMsgs = getCellData(reEnterPropertyPage.ErrorMsg_WebTable, 1, 1).trim();
				strErrorMsgs = reEnterPropertyPage.ErrorMsg_WebTable.getText().trim();

				if (!strErrorMsgs.isEmpty()) {
					if (!shtName.isEmpty() && !intRow.isEmpty()) {
						// Set focus
						// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
						// Retrieve expected error message from datasheet
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
						if (strErrorMsgs.equals(strExpectedMsgs)) {
						}
					}
				} else {
					strExpectedMsgs = "";
				}
				// Verify the error message
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					ReEnterProperty_CancelWIP = false;
				}
				// // Verify data not discarded
				// intRet = ReEnterProperty_VerifyDataNotDiscarded(strPreBlock, strPrePIN, strPreNewBlock, strPreConversionType);
				// // Exit function directly if verification failed
				// if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"Verification of the page - UnSuccessful");
				// AddInfo("Verification of the page - UnSuccessful");
				ReEnterProperty_CancelWIP = false;
				// }
				// return false;
				// }
				// }
				// if (strButton == "OK") {
				// Verify the application returns to the Main Menu page
				// intRet = elrscommon.VerifyPage("Main Menu");
				// if (intRet == false) {
				// Reporter.reportEvent(Status.Failed,strStepName,"<Main Menu> page NOT displayed after <OK> button is clicked on the Cancel WIP Popup - UnSuccessful");
				// AddInfo("<Main Menu> page NOT displayed after <OK> button is clicked on the Cancel WIP Popup - UnSuccessful");
				// } else {
				// Reporter.reportEvent(Status.Passed,strStepName,"<Main Menu> page displayed - Successful");
				// AddInfo("<Main Menu> page displayed - Successful");
				// ReEnterProperty_CancelWIP = true;
				// }
				// return false;
				// }
				// Verify the page
				// if (!reEnterPropertyPage.Conversion_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The texts of <Conversion?> Not present on the page. Verification of the <Re-enter Property Submission> page - UnSuccessful");
				// AddInfo("The texts of <Conversion?> Not present on the page. Verification of the <Re-enter Property Submission> page - UnSuccessful");
				// return false;
				// }
				// Reporter.reportEvent(Status.Passed,strStepName,"Verification of the page - Successful");
				// AddInfo("Verification of the page - Successful");
			}

			ReEnterProperty_CancelWIP = true;
			return ReEnterProperty_CancelWIP;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks RetrieveWIP button on ReEnterPropertyRetrieve page")
	public void user_clicks_RetrieveWIPbutton() {
		reEnterPropertyPage.RetrieveWIP_WebButton.click();
	}

	@When("user clicks the Retrieve WIP button on the Submission page $shtName and $intRow")
	public boolean ReEnterProperty_RetrieveWIP(String shtName, String intRow) {
		// Object ReEnterProperty_RetrieveWIP=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_RetrieveWIP";
			boolean ReEnterProperty_RetrieveWIP = false;
			boolean intRet = false;
			// Enter data only if applicable
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = ReEnterProperty_Submission_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			// Declare variables and fetch the data on the screen before Retrieve WIP is clicked as expected values
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strExpectedPIN = null;
			String strNewBlock = null;
			String strConversionType = null;
			String oPage = null;

			String strPreBlock = reEnterPropertyPage.TargetBlock_WebEdit.getValue();
			String strPrePIN = reEnterPropertyPage.TargetPIN_WebEdit.getValue();
			String strPreNewBlock = reEnterPropertyPage.NewBlock_WebEdit.getValue();
			// strConversionType=.getWebElement("selected item index");
			// strExpectedPIN = strTargetBlock.trim() + "-" + strTargetPIN.trim();
			oPage = null;
			// //Initialization
			// Environment("bTriggered") = False
			// if (!reEnterPropertyPage.RetrieveWIP_WebButton.isPresent()) {
			// Reporter.reportEvent(Status.Failed,strStepName,"<Retrieve WIP> button Not exist - UnSuccessful");
			// AddInfo("<Retrieve WIP> button Not exist - UnSuccessful");
			// return false;
			// }
			// String strDisabled = null;
			// strDisabled = reEnterPropertyPage.RetrieveWIP_WebButton.getAttribute("disabled");
			// if (strDisabled.equals("true")) {
			// Reporter.reportEvent(Status.Failed,strStepName,"<Retrieve WIP> button is disabled - UnSuccessful");
			// AddInfo("<Retrieve WIP> button is disabled - UnSuccessful");
			// return false;
			// }
			// Click the Retrieve WIP button
			// if (reEnterPropertyPage.RetrieveWIP_WebButton.isDisplayed()) {
			reEnterPropertyPage.RetrieveWIP_WebButton.click();
			// }
			// If Environment("bTriggered") = True Then
			// Reporter.ReportEvent micFail, strStepName, "Click <Retrieve WIP> button - UnSuccessful"
			// AddInfo "Click <Retrieve WIP> button - UnSuccessful"
			// Exit Function
			// End If
			// AddInfo("<Retrieve WIP> button is clicked");
			// Verify error message
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			// Retrieve actual error message from the screen
			// strErrorMsgs = getCellData(reEnterPropertyPage.ErrorMsg_WebTable, 1, 1).trim();
			strErrorMsgs = reEnterPropertyPage.ErrorMsg_WebTable.getText().trim();
			// Retrieve expected error message from datasheet
			// div[@id='startReEnterForm.errors']
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				// Verify the error message
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					// Set focus
					// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
					// Retrieve expected error message from datasheet
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					if (strErrorMsgs.equals(strExpectedMsgs)) {
					} else {
						strExpectedMsgs = "";
					}
				}
				// intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				// if (intRet == false) {
				// ReEnterProperty_RetrieveWIP = false;
				// }
				// Verify the data
				// intRet = ReEnterProperty_VerifyDataNotDiscarded(strTargetBlock, strTargetPIN, strNewBlock, strConversionType);
				// if (intRet == false) {
				// ReEnterProperty_RetrieveWIP = false;
				// }
				return false;
			}
			// Verify the page
			if (!propertyDetailPage.ParentPINHeader_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"<Property Detail> page Not displayed - UnSuccessful");
				// AddInfo("<Property Detail> page Not displayed - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed,strStepName,"<Property Detail> page displayed - Successful");
			// AddInfo("<Property Detail> page displayed - Successful");
			// Declare variables
			String strParentPIN = null;
			// Retrieve the parent pins from property detail screen
			strParentPIN = propertyDetailPage.ParentPINHeader_WebElement.getText();
			// Verify the Parent PIN
			// if (InStr(strParentPIN, strExpectedPIN) > 0) {
			// Reporter.reportEvent(Status.Failed,strStepName,"Verification of <Parent PIN(s) : "+strExpectedPINs+" > - UnSuccessful, Actual: <"+strParentPIN+">");
			// AddInfo("Verification of <Parent PIN(s) : "+strExpectedPINs+" > - UnSuccessful, Actual: <"+strParentPIN+">");
			// return false;
			// }
			// Reporter.reportEvent(Status.Passed,strStepName,"Verification of <"+strParentPIN.trim()+"> - Successful");
			// AddInfo("Verification of <"+strParentPIN.trim()+"> - Successful");
			ReEnterProperty_RetrieveWIP = true;
			return ReEnterProperty_RetrieveWIP;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ReEnterProperty_Verify_ParentPIN(String shtName, String intRow) {
		// Object ReEnterProperty_Verify_ParentPIN = null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_Verify_ParentPIN";
			boolean ReEnterProperty_Verify_ParentPIN = false;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
			// Declare variables
			String strTargetBlock = null;
			String strTargetPIN = null;
			String strExpectedPIN = null;
			String strParentPIN = null;
			// Fetch valid data
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strTargetPIN = GetValueIfValid("TargetPIN", shtName, Integer.parseInt(intRow));
			// Set expected value
			strExpectedPIN = strTargetBlock + "-" + strTargetPIN;
			// Retrieve the parent pins from property detail screen
			strParentPIN = propertyDetailPage.ParentPINHeader_WebElement.getText();
			// Verify parent pin
			if (InStr(strParentPIN, strExpectedPIN) > 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Verification of <Parent PIN(s) : " + strExpectedPINs + "> - UnSuccessful. Actual: <" + strParentPIN + ">");
				// AddInfo("Verification of <Parent PIN(s) : " + strExpectedPINs + "> - UnSuccessful. Actual: <" + strParentPIN + ">");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Verification of <" + strParentPIN + "> - Successful");
			// AddInfo("Verification of <" + strParentPIN + "> - Successful");
			ReEnterProperty_Verify_ParentPIN = true;
			return ReEnterProperty_Verify_ParentPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ReEnterProperty_Verify_BlockNumber(String shtName, String intRow) {
		// Object ReEnterProperty_Verify_BlockNumber = null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_Verify_BlockNumber";
			boolean ReEnterProperty_Verify_BlockNumber = false;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
			// Declare variables
			String strTargetBlock = null;
			String strNewBlock = null;
			String strActualBlockNumber = null;
			// Fetch valid data
			strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			strNewBlock = GetValueIfValid("NewBlock", shtName, Integer.parseInt(intRow));
			// Retrieve the block number from property detail screen
			strActualBlockNumber = descriptionPage.BlockNumber0_WebEdit.getAttribute("value").trim();
			// Verify the block number
			if (strNewBlock.isEmpty() || strNewBlock.equals("IGNORE_VALUE")) {
				if (strComp(strActualBlockNumber, strTargetBlock) == 0) {
					// Reporter.reportEvent(Status.Passed, strStepName, "Verification of Block Number: <" + strTargetBlock + "> - Successful");
					// AddInfo("Verification of Block Number: <" + strTargetBlock + "> - Successful");
					ReEnterProperty_Verify_BlockNumber = true;
				} else {
					// Reporter.reportEvent(Status.Failed, strStepName, "Verification of Block Number: <" + strTargetBlock + "> - UnSuccessful. Actual: <" + strActualBlockNumber + ">");
					// AddInfo("Verification of Block Number: <" + strTargetBlock + "> - UnSuccessful. Actual: <" + strActualBlockNumber + ">");
				}
				return false;
			}
			if (strComp(strActualBlockNumber, strNewBlock) == 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Verification of Block Number: <" + strNewBlock + "> - UnSuccessful. Actual: <" + strActualBlockNumber + ">");
				// AddInfo("Verification of Block Number: <" + strNewBlock + "> - UnSuccessful. Actual: <" + strActualBlockNumber + ">");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Verification of Block Number: <" + strNewBlock + "> - Successful");
			// AddInfo("Verification of Block Number: <" + strNewBlock + "> - Successful");
			ReEnterProperty_Verify_BlockNumber = true;
			return ReEnterProperty_Verify_BlockNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ReEnterProperty_Verify_RegSystem(String shtName, String intRow) {
		// Object ReEnterProperty_Verify_RegSystem = null;
		try {
			Object strStepName = null;
			strStepName = "ReEnterProperty_Verify_RegSystem";
			boolean ReEnterProperty_Verify_RegSystem = false;
			// Set focus
			// datatableLib.getsheet(shtName).setcurrentRow((Math.round(intRow)));
			// Declare variables
			String strPINType = null;
			String strConversionType = null;
			String strActualRegSystem = null;
			String strExpectedType = null;
			// Fetch valid data
			strPINType = GetValueIfValid("PINType", shtName, Integer.parseInt(intRow));
			strConversionType = GetValueIfValid("ConversionType", shtName, Integer.parseInt(intRow));
			// Set the expected value of the registration system based on the data provided
			switch (strConversionType.toUpperCase()) {
			case "":
			case "IGNORE_VALUE":
			case "NO":
				if (strPINType.isEmpty() || strPINType.equals("IGNORE_VALUE")) {
					// Set true directly, no verification
					ReEnterProperty_Verify_RegSystem = true;
					return false;
				}
				switch (strPINType.toUpperCase()) {
				case "LT":
				case "LANDTITLES":
				case "LAND TITLES":
					strExpectedType = "LAND TITLES";
					break;
				case "R":
				case "REGISTRY":
					strExpectedType = "REGISTRY";
					break;
				default:
					// Reporter.reportEvent(Status.Failed, strStepName, "UnKnown PIN Type:<" + strPINType + "> provided - UnSuccessful");
					// AddInfo("UnKnown PIN Type:<" + strPINType + "> provided - UnSuccessful");
					return false;
				// break;
				}
				break;
			case "REGISTRYTOLANDTITLES":
			case "REGISTRY TO LAND TITLES":
			case "RTOLT":
			case "R TO LT":
				strExpectedType = "LAND TITLES";
				break;
			case "LANDTITLESTOREGISTRY":
			case "LAND TITLES TO REGISTRY":
			case "LTTOR":
			case "LT TO R":
				strExpectedType = "REGISTRY";
				break;
			default:
				// Reporter.reportEvent(Status.Failed, strStepName, "UnKnown Conversion: <" + strConversionType + "> provided - UnSuccessful");
				// AddInfo("UnKnown Conversion: <" + strConversionType + "> provided - UnSuccessful");
				return false;
			// break;
			}
			// Retrieve the actual registration system displayed on the property detail screen
			strActualRegSystem = descriptionPage.RegSystem_WebElement.getText().trim();
			// Verify the registration system
			if (strComp(strActualRegSystem, strExpectedType) == 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Verification of Registration System: <" + strExpectedType + "> - UnSuccessful. Actual: <" + strActualRegSystem + ">");
				// AddInfo("Verification of Registration System: <" + strExpectedType + "> - UnSuccessful. Actual: <" + strActualRegSystem + ">");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Verification of Registration System: <" + strExpectedType + "> - Successful");
			// AddInfo("Verification of Registration System: <" + strExpectedType + "> - Successful");
			ReEnterProperty_Verify_RegSystem = true;
			return ReEnterProperty_Verify_RegSystem;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrievePINAndVerifyRemarks_ReEnter(String strDetailInfo) {
		// Object RetrievePINAndVerifyRemarks_ReEnter = null;
		try {
			String strStepName = null;
			Object intRet = null;
			strStepName = "RetrievePINAndVerifyRemarks_ReEnter";
			boolean RetrievePINAndVerifyRemarks_ReEnter = false;
			String strRemarks = null;
			strRemarks = "Re-entry";
			if (InStr(strDetailInfo, strRemarks) > 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "The expected Remarks <" + strRemarks + "> NOT displayed on the PDF page - UnSuccessful");
				// AddInfo("The expected Remarks <" + strRemarks + "> NOT displayed on the PDF page - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Remarks: Re-entry> displayed on the <Map Maintenance Request> page - Successful");
			// AddInfo("<Remarks: Re-entry> displayed on the <Map Maintenance Request> page - Successful");
			RetrievePINAndVerifyRemarks_ReEnter = true;
			return RetrievePINAndVerifyRemarks_ReEnter;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ReEnterProperty_VerifyDataNotDiscarded(String strExpectedBlock, String strExpectedPIN, String strExpectedNewBlock, String strExpectedConversionType) {
		// Object ReEnterProperty_VerifyDataNotDiscarded=null;
		try {
			String strStepName = null;
			strStepName = "ReEnterProperty_VerifyDataNotDiscarded";
			boolean ReEnterProperty_VerifyDataNotDiscarded = false;
			// Declare variable
			String strActualBlock = null;
			String strActualPIN = null;
			String strActualNewBlock = null;
			String strActualConversionType = null;
			String oPage = null;

			// Retrieve data on the current screen
			String strPreBlock = reEnterPropertyPage.TargetBlock_WebEdit.getAttribute("value");
			String strPrePIN = reEnterPropertyPage.TargetPIN_WebEdit.getValue();
			String strPreNewBlock = reEnterPropertyPage.NewBlock_WebEdit.getValue();
			// strActualConversionType=.getWebElement("selected item index");
			oPage = null;
			// Verify the parent block number
			// if (strComp(strActualBlock, strExpectedBlock) == 0) {
			// Reporter.reportEvent(Status.Warning,strStepName,"Verification of Parent Block: <"+strExpectedBlock+"> - UnSuccessful. Actual: <"+strActualBlock+">");
			// AddInfo("Verification of Parent Block: <"+strExpectedBlock+"> - UnSuccessful. Actual: <"+strActualBlock+">");
			// return false;
			// }
			// if (strComp(strActualPIN, strExpectedPIN) == 0) {
			// Reporter.reportEvent(Status.Warning,strStepName,"Verification of Parent PIN: <"+strExpectedBlock+"-"+strExpectedPIN+"> - UnSuccessful. Actual: <"+strActualBlock+"-"+strActualPIN+">");
			// AddInfo("Verification of Parent PIN: <"+strExpectedBlock+"-"+strExpectedPIN+"> - UnSuccessful. Actual: <"+strActualBlock+"-"+strActualPIN+">");
			// return false;
			// }
			// if (strComp(strActualNewBlock, strExpectedNewBlock) == 0) {
			// Reporter.reportEvent(Status.Warning,strStepName,"Verification of New Block: <"+strExpectedNewBlock+"> - UnSuccessful. Actual: <"+strActualNewBlock+">");
			// AddInfo("Verification of New Block: <"+strExpectedNewBlock+"> - UnSuccessful. Actual: <"+strActualNewBlock+">");
			// return false;
			// }
			// if (strComp(strActualConversionType, strExpectedConversionType) == 0) {
			// Reporter.reportEvent(Status.Warning,strStepName,"Verification of Conversion: <"+strExpectedConversionType+"> - UnSuccessful. Actual: <"+strActualConversionType+">");
			// AddInfo("Verification of Conversion: <"+strExpectedConversionType+"> - UnSuccessful. Actual: <"+strActualConversionType+">");
			// return false;
			// }
			ReEnterProperty_VerifyDataNotDiscarded = true;
			return ReEnterProperty_VerifyDataNotDiscarded;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
