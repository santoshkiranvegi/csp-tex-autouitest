package ca.teranet.polaris.steps;

import java.util.List;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CorrectionConfirmationPage;
import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.DocumentViewPopupPage;
import ca.teranet.pages.polaris.DocumentsPage;
import ca.teranet.pages.polaris.FeesTaxesPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.pages.polaris.RecordHistoricalConfirmationPage;
import ca.teranet.pages.polaris.RecordHistoricalPage;
import ca.teranet.pages.polaris.SearchPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;

public class RecordHistoricalSteps extends Utility {

	RecordHistoricalPage recordHistoricalPage;
	DocumentDetailPage documentDetailPage;
	RecordHistoricalConfirmationPage recordHistoricalConfirmationPage;
	DocumentViewPopupPage documentViewPopupPage;
	BatchPage batchPage;
	MainPage mainPage;
	BatchPage batchQPage;
	DocumentsPage documentsPage;
	SearchPage searchPage;
	CorrectionConfirmationPage correctionconfirmationPage;
	LogSteps logSteps = new LogSteps();
	DocumentDetailSteps documentDetailSteps;
	FeesTaxesPage feesTaxesPage;
	Register register;
	// String strRegNumber = "";
	@Steps
	ELRSCommonSteps elrsCommonSteps;

	public boolean RecordHistorical_PreSubmission_EnterData(String shtName, String intRow) {
		boolean RecordHistorical_PreSubmission_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "RecordHistorical_PreSubmission_EnterData";
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));

			String strRegDate = GetValueIfValid("RegDate", shtName, Integer.parseInt(intRow));
			String strRegTime = GetValueIfValid("RegTime", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow));
			String strFrench = GetValueIfValid("French", shtName, Integer.parseInt(intRow));
			String strActiveRetired = GetValueIfValid("ActiveRetired", shtName, Integer.parseInt(intRow));
			String strTargetPINIndex = GetValueIfValid("TargetPINIndex", shtName, Integer.parseInt(intRow));
			String strTargetBlock = GetValueIfValid("TargetBlock", shtName, Integer.parseInt(intRow));
			String strTargetPINFrom = GetValueIfValid("TargetPINFrom", shtName, Integer.parseInt(intRow));
			String strTargetPINTo = GetValueIfValid("TargetPINTo", shtName, Integer.parseInt(intRow));

			if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
				strRegNumber = Generate_Unique_RegNumber().toUpperCase();
			}
			if (strRegDate.equalsIgnoreCase("!GENERATE!")) {
				strRegDate = Generate_Registration_Date();
			}
			if (strRegTime.equalsIgnoreCase("!GENERATE!")) {
				strRegTime = Generate_Registration_Time();
			}
			String oPage = null;
			recordHistoricalPage.RegNumber_WebEdit.sendKeys(strRegNumber + Keys.TAB);
			recordHistoricalPage.RegDate_WebEdit.sendKeys(strRegDate + Keys.TAB);
			recordHistoricalPage.RegTime_WebEdit.sendKeys(strRegTime + Keys.TAB);
			setCheckBoxValue(recordHistoricalPage.French_WebCheckBox, strFrench + Keys.TAB);
			switch (strActiveRetired.toUpperCase()) {
			case "ACTIVE":
			case "1":
				mainPage.getDriver().findElement(By.id("activeIndRadio")).click();
				break;
			case "RETIRED":
			case "2":
				mainPage.getDriver().findElement(By.id("retiredIndRadio")).click();
				JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
				js.executeScript(
						"swapListContentsWithoutBlankEntryForRecordHistorical('frenchIndBox' , 'activeIndRadio' , 'docTypeSelection',frenchActiveDocType, englishActiveDocType,frenchRetiredDocType,englishRetiredDocType);");
				break;
			}
			recordHistoricalPage.DocumentType_WebList.selectByVisibleText(strDocumentType.toUpperCase());
			WaitUtil.waitMSeconds(2000);
			if (isNumeric(strTargetPINIndex)) {
				int intTargetPINIndex = Math.round(Integer.parseInt(strTargetPINIndex)) - 1;
				recordHistoricalPage.find(By.id("pin" + intTargetPINIndex + "block")).sendKeys(strTargetBlock + Keys.TAB);
				/*
				 * Actions action = new Actions(mainPage.getDriver()); action.contextClick(recordHistoricalPage.find(By.id("pin" + intTargetPINIndex + "block"))) .sendKeys(Keys.TAB).build() .perform();
				 */
				recordHistoricalPage.find(By.id("pin" + intTargetPINIndex + "num")).sendKeys(strTargetPINFrom + Keys.TAB);
				recordHistoricalPage.find(By.id("pin" + intTargetPINIndex + "range")).sendKeys(strTargetPINTo + Keys.TAB);
			}
			oPage = null;
			RecordHistorical_PreSubmission_EnterData = true;
			return RecordHistorical_PreSubmission_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on the Enter Historical Record button on the Pre-submission page in batch mode $shtName and $intRow")
	public boolean RecordHistorical_EnterHistoricalRecord_Batch(String shtName, String intRow) {
		boolean RecordHistorical_EnterHistoricalRecord_Batch = false;
		try {
			String strStepName = null;
			strStepName = "RecordHistorical_EnterHistoricalRecord_Batch";
			boolean intRet = false;
			intRet = RecordHistorical_PreSubmission_EnterData(shtName, intRow);
			if (intRet == false) {
				return false;
			}
			recordHistoricalPage.EnterHistoricalRecord_WebButton.click();
			WaitUtil.waitMSeconds(2000);
			String strBatchJob = null;
			strBatchJob = "Historical Document";
			intRet = Documents_Batch_Presub(strBatchJob);
			mainPage.getDriver().findElement(By.xpath("//td[contains(text(),'" + strRegNumber + "')]/..//input[@name='btn'][1]")).click();
			WaitUtil.waitMSeconds(2000);
			String strExpectedFunction = "Record Historical";
			String strActualFunction = mainPage.FuncID_WebElement.getAttribute("outertext");
			String strMode = mainPage.Mode_WebElement.getAttribute("outertext");
			String strActualRegNumber = null;
			// strActualRegNumber = documentDetailSteps.DocumentDetail_Retrieve_RegNumber();

			/*
			 * if (!(strComp(strActualRegNumber, strRegNumber) == 0)) { logSteps.execution_log("Verification of <Reg No.> - UnSuccessful. Expected: <" + strRegNumber + ">, Actual: <" + strActualRegNumber + ">"); return false; }
			 */

			return RecordHistorical_EnterHistoricalRecord_Batch;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Documents_Batch_Presub(String strFunction) {
		boolean Documents_Batch_Presub = false;
		try {
			String strStepName = null;
			strStepName = "Documents_Batch_Presub <" + strFunction + ">";
			String strBatchFunc = null;
			// strBatchFunc = batchQPage.PreCertification_WebElement.getText();
			/*
			 * if (InStr(strBatchFunc, strFunction) == 0) { return false; }
			 */
			documentsPage.OK_WebButton.click();
			String strRequest = null;
			String[] arrRequest = null;
			String strJobs = null;
			String[] arrJobs = null;
			String intBatchID = null;
			documentsPage.OK_WebButton.click();
			boolean intRet = false;
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				Documents_Batch_Presub = false;
				return false;
			}
			intRet = elrsCommonSteps.user_navigates_to("ViewBatchQ");
			WaitUtil.waitMSeconds(2000);
			/*
			 * mainPage.getDriver().findElement(By.xpath("//input[@value='Select']")).click(); WaitUtil.waitMSeconds(2000);
			 */
			/*
			 * String oWebTable = null; int intBatchRowIndex = 0; intBatchRowIndex = LocateBatchIDRowIndex(oWebTable, intBatchID); if (intBatchRowIndex == 0) { return false; } if (intBatchRowIndex == -1) { return false; }
			 */
			/*
			 * if (bWaitUntilJobComplete(oWebTable, intBatchRowIndex) == true) { Documents_Batch_Presub = true; } else { Documents_Batch_Presub = false; }
			 */
			return Documents_Batch_Presub;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click the Enter Historical Record on the Record Historical Presubmission page $shtName and $intRow")

	public boolean RecordHistorical_EnterHistoricalRecord(String shtName, String intRow) {

		boolean RecordHistorical_EnterHistoricalRecord = false;

		try {

			String strStepName = null;

			strStepName = "RecordHistorical_EnterHistoricalRecord";

			if (intRow.isEmpty()) {

				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");

				return false;

			}

			boolean intRet = false;

			intRet = RecordHistorical_PreSubmission_EnterData(shtName, intRow);

			if (intRet == false) {

				return false;

			}

			String strRegNumber = recordHistoricalPage.RegNumber_WebEdit.getValue().trim().toUpperCase();

			String strDocumentType = recordHistoricalPage.DocumentType_WebList.getValue().trim();

			recordHistoricalPage.EnterHistoricalRecord_WebButton.click();
			WaitUtil.waitMSeconds(2000);

			String strErrorMsgs = null;

			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));

			if (!documentDetailPage.Heading_WebTable.isPresent()) {

				// Verify error message

				if (recordHistoricalPage.ErrorMsg_WebTable.isPresent()) {

					strErrorMsgs = getCellData(recordHistoricalPage.ErrorMsg_WebTable, 1, 1).trim();

					if (!strErrorMsgs.isEmpty()) {

						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);

						if (intRet == false) {

							RecordHistorical_EnterHistoricalRecord = false;

						}

					} else {

						logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful");

					}

				} else {

					logSteps.execution_log("Unknown page is returned - UnSuccessful");

				}

				return false;

			}

			logSteps.execution_log("<Document Detail> page displayed");

			String strHeadingText = null;

			strHeadingText = documentDetailPage.Heading_WebTable.getText().trim();

			if (!(InStr(strHeadingText, strRegNumber) > 0)) {

				logSteps.execution_log("The <Reg No: " + strRegNumber + "> Not displayed on the <Document Detail> page - UnSuccessful");

				return false;

			}

			logSteps.execution_log("Verification of <Reg No: " + strRegNumber + "> - Successful");

			if (!(InStr(strHeadingText, strDocumentType.toUpperCase()) > 0)) {

				logSteps.execution_log("The <Doc Type: " + strDocumentType + "> Not displayed on the <Document Detail> page - UnSuccessful");

				return false;

			}

			logSteps.execution_log("Verification of <Doc Type: " + strDocumentType.toUpperCase() + "> - Successful");

			RecordHistorical_EnterHistoricalRecord = true;

			return RecordHistorical_EnterHistoricalRecord;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click on the document number link on the Recording Historical Results Confirmation page $PRESUBMISSIONSHEETNAME1 and $PRESUBMISSIONROW1")
	public boolean RecordHistorical_Document_ClickAndOpen(String shtName, String intRow) {
		boolean RecordHistorical_Document_ClickAndOpen = false;
		try {
			String strStepName = null;
			strStepName = "RecordHistorical_Document_ClickAndOpen";
			if (intRow.isEmpty()) {
				// logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			String strExpectedRegNumber = null;
			strExpectedRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			intRet = RecordHistorical_VerifyExist_RegNumberLink();
			if (intRet == false) {
				return false;
			}
			String oDesc = null;
			String intLinkCount = null;
			// String oLink=null;
			/*
			 * oDesc=Description.Create(); oDesc("micclass").value()="link"; oDesc("class").value()="ro";
			 */ // oLink=recordHistoricalConfirmationPage.RecordingHistoricalResults_webtable.ChildObjects(oDesc);
			List<WebElement> oLink = correctionconfirmationPage.CorrectionResult_WebTable.findElements(By.xpath("//a[@class='ro']"));
			// Retrieve the document number
			// @@ M2S WARNING : Input line number : 320
			String strDocumentNumber = null;
			// strDocumentNumber=oLink(0).GetROProperty("text").trim();
			strDocumentNumber = oLink.get(0).getText().trim();
			if (!(strComp(strDocumentNumber, strExpectedRegNumber) == 0)) {
				/*
				 * 
				 * Reporter.reportEvent(Status.Failed,strStepName,"Expected document number <"+strExpectedRegNumber+"> Not displayed on the confirmation page, Actual:<"+strDocumentNumber+"> - UnSuccessful");
				 * AddInfo("Expected document number <"+strExpectedRegNumber+"> Not displayed on the confirmation page, Actual:<"+strDocumentNumber+"> - UnSuccessful"); oLink = null; oDesc = null; return false;
				 */}
			// Click Document Hyperlink
			// Browser("ELRS").Page("RecordHistoricalConfirmation").WebTable("RecordingHistoricalResults").Link(oDesc).Click
			// recordingHistoricalResultsPage.oDesc_link.click();
			mainWindowHandle = mainPage.getDriver().getWindowHandle();
			recordHistoricalConfirmationPage.RecordingHistoricalResults_WebElement.click();
			// AddInfo("Hyperlink of document <"+strExpectedRegNumber+"> is clicked");
			oLink = null;
			oDesc = null;
			// Verify a window popup

			/*
			 * if(!documentViewPopupPage.) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"Document detail full view popup Not exist - UnSuccessful"); AddInfo("Document detail full view popup Not exist - UnSuccessful"); return false; }
			 * 
			 * 
			 * Reporter.reportEvent(Status.Passed,strStepName,"Document detail full view popup displayed - Successful"); AddInfo("Document detail full view popup displayed - Successful");
			 */ // Verify the registration number
			// @@ M2S WARNING : Input line number : 350
			String strRegNumber = null;
			// strRegNumber = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 1, 2);
			/*
			 * if (!(strComp(strRegNumber.trim(), strDocumentNumber) == 0)) {
			 * 
			 * Reporter.reportEvent(Status.Failed,strStepName,"Document number <"+strDocumentNumber+"> Not displayed on popup - UnSuccessful"); AddInfo("Document number <"+strDocumentNumber+"> Not displayed on popup - UnSuccessful"); return false; }
			 */
			/*
			 * Reporter.reportEvent(Status.Passed,strStepName,"Document number <"+strDocumentNumber+"> displayed on popup - Successful"); AddInfo("Document number <"+strDocumentNumber+"> displayed on popup - Successful");
			 */ RecordHistorical_Document_ClickAndOpen = true;
			return RecordHistorical_Document_ClickAndOpen;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
		public boolean RecordHistorical_VerifyExist_RegNumberLink() {
				boolean RecordHistorical_VerifyExist_RegNumberLink = false;
				try {
					String strStepName = null;
					strStepName = "RecordHistorical_VerifyExist_RegNumberLink";
					String oDesc = null;
					int intLinkCount = 0;
					List<WebElement> oLink = correctionconfirmationPage.CorrectionResult_WebTable.findElements(By.xpath("//a[@class='ro']"));
					intLinkCount = oLink.size();
					if (intLinkCount == 0) {
						// logSteps.execution_log("No link found on <Recording Historical Results> confirmation page - UnSuccessful");
						Object oWebTable = null;
						oDesc = null;
						return false;
					}
					if (intLinkCount > 1) {
						// logSteps.execution_log("More than 1link found on <Recording Historical Results> confirmation page - UnSuccessful");
						oLink = null;
						oDesc = null;
						return false;
					}
					String strDocumentNumber = null;
					strDocumentNumber = oLink.get(0).getText().trim();
					// logSteps.execution_log("A hyperlink with document number <" + strDocumentNumber + "> displayed on confirmation page - Successful");
					RecordHistorical_VerifyExist_RegNumberLink = true;
					return RecordHistorical_VerifyExist_RegNumberLink;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			} 
		 

		
		@When("user click on Cancel Recording button on the Fees and Taxes page")
		public boolean FeesTaxes_CancelRecording() {
			try {
				boolean FeesTaxes_CancelRecording = false;
				feesTaxesPage.Cancel_Recording_WebButton.click();
				Alert alert = basePage.getDriver().switchTo().alert();
				alert.dismiss();
				if (!feesTaxesPage.FeesTaxesHeading_WebElement.isPresent()) {
					// logSteps.execution_log("Page <Fees and Taxes> is Not displayed - UnSuccessful");
					return false;
				}
				// logSteps.execution_log("Page <Fees and Taxes> displayed - Successful");
				FeesTaxes_CancelRecording = true;
				return FeesTaxes_CancelRecording;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} 
		
		@When("user click on the Enter Historical Record on the Record Historical Presubmission page $PRESUBMISSIONSHEETNAME1 and $PRESUBMISSIONROW1")
		public boolean user_click_RecordHistorical_EnterHistoricalRecord(String shtName, String intRow) {
		 boolean RecordHistorical_EnterHistoricalRecord = false;
		 try {
		  String strStepName = null;
		  strStepName = "RecordHistorical_EnterHistoricalRecord";
		  boolean intRet = false;
		  intRet = RecordHistorical_PreSubmission_EnterData(shtName, intRow);
		  if (intRet == false) {
		   return false;
		  }
		  String strRegNumber = null;
		  String strDocumentType = null;
		  strRegNumber = recordHistoricalPage.RegNumber_WebEdit.getAttribute("value").trim().toUpperCase();
		  strDocumentType = recordHistoricalPage.DocumentType_WebList.getAttribute("value").trim();
		  recordHistoricalPage.EnterHistoricalRecord_WebButton.click();
		  String strExpectedMsgs = null;
		  String strErrorMsgs = null;
		  strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
		  if (!documentDetailPage.Heading_WebTable.isPresent()) {
		   if (recordHistoricalPage.ErrorMsg_WebTable.isPresent()) {
		    strErrorMsgs = getCellData(recordHistoricalPage.ErrorMsg_WebTable, 1, 1).trim();
		    if (!strErrorMsgs.isEmpty()) {
		     intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
		     if (intRet == false) {
		      RecordHistorical_EnterHistoricalRecord = false;
		     }
		    } else {
		     /*
		      * Reporter.reportEvent(Status.Failed, strStepName, "Page <Document Detail> Not displayed - UnSuccessful"); AddInfo("Page <Document Detail> Not displayed - UnSuccessful");
		      */ }
		   } else {
		    /*
		     * Reporter.reportEvent(Status.Failed, strStepName, "Unknown page is returned - UnSuccessful "); AddInfo("Unknown page is returned - UnSuccessful");
		     */ }
		   return false;
		  }
		  String strHeadingText = null;
		  strHeadingText = documentDetailPage.Heading_WebTable.getText().trim();
		  if (!(InStr(strHeadingText, strRegNumber) > 0)) {
		   /*
		    * Reporter.reportEvent(Status.Failed, strStepName, "The <Reg No: " + strRegNumber + "> Not displayed on the <Document Detail> page - UnSuccessful"); AddInfo("The <Reg No: " + strRegNumber + "> Not displayed on the <Document Detail> page - UnSuccessful");
		    */ return true;
		  }
		  /*
		   * Reporter.reportEvent(Status.Passed, strStepName, "Verification of <Reg No: " + strRegNumber + "> - Successful"); AddInfo("Verification of <Reg No: " + strRegNumber + "> - Successful");
		   */ // Verify the DocumentType
		  if (!(InStr(strHeadingText, strDocumentType.toUpperCase()) > 0)) {
		   /*
		    * Reporter.reportEvent(Status.Failed, strStepName, "The <Doc Type: " + strDocumentType + "> Not displayed on the <Document Detail> page - UnSuccessful"); AddInfo("The <Doc Type: " + strDocumentType + "> Not displayed on the <Document Detail> page - UnSuccessful");
		    */ return true;
		  }
		  /*
		   * Reporter.reportEvent(Status.Passed, strStepName, "Verification of <Doc Type: " + strDocumentType.toUpperCase() + "> - Successful"); AddInfo("Verification of <Doc Type: " + strDocumentType.toUpperCase() + "> - Successful");
		   */ RecordHistorical_EnterHistoricalRecord = true;
		  return RecordHistorical_EnterHistoricalRecord;
		 } catch (Exception e) {
		  e.printStackTrace();
		  return false;
		 }
		}

}


