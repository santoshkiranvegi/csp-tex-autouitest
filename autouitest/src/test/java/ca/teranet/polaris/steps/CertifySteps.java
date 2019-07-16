package ca.teranet.polaris.steps;

import java.util.List;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CertifyConfirmationPage;
import ca.teranet.pages.polaris.DeferOrCorrectionPage;
import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.DocumentSelectionPage;
import ca.teranet.pages.polaris.DocumentViewPopupPage;
import ca.teranet.pages.polaris.PropertyMaintenancePage;
import ca.teranet.pages.polaris.PropertyMaintenance_BulkEditPage;
import ca.teranet.pages.polaris.ViewWorkQPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;

public class CertifySteps extends Utility {
	DocumentSelectionPage documentSelectionPage;
	DocumentDetailPage documentDetailPage;
	PropertyMaintenancePage propertyMaintenancePage;
	CertifyConfirmationPage certifyConfirmationPage;
	PropertyMaintenance_BulkEditPage propertyMaintenance_BulkEditPage;
	DocumentViewPopupPage documentViewPopupPage;
	ViewWorkQPage viewWorkQPage;
	ELRSCommonSteps elrscommon;
	BatchPage batchPage;
	LogSteps logSteps;
	DeferOrCorrectionPage deferCertificationPage;

	public boolean DocumentSelection_EnterData(String shtName, String intRow) {
		boolean DocumentSelection_EnterData = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			if (strRegNumber.equalsIgnoreCase("!GENERATE!")) {
				strRegNumber = Generate_Unique_RegNumber().toUpperCase();
			}
			if (strRegNumber.isEmpty()) {
				strRegNumber = Generate_Unique_RegNumber();
			}
			documentSelectionPage.RegistrationNumber_WebEdit.clear();
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);

			DocumentSelection_EnterData = true;
			return DocumentSelection_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return DocumentSelection_EnterData;
		}
	}

	@When("user cancels document selection $shtName and $intRow")
	public boolean user_cancel_documentselection(String shtName, String intRow) {
		boolean Certify_DocumentSelection_Cancel = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			documentSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.dismiss();
			return Certify_DocumentSelection_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_Cancel;
		}
	}

	@When("user cancels the cancel document selection")
	public boolean user_cancelthecancel_documentselection() {
		boolean Certify_DocumentSelection_CancelCancel = false;
		try {
			documentSelectionPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			Certify_DocumentSelection_CancelCancel = true;
			return Certify_DocumentSelection_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_CancelCancel;
		}
	}

	public boolean Certify_DocumentViewPopup_Close() {
		boolean Certify_DocumentViewPopup_Close = false;
		try {
			documentViewPopupPage.Close_WebButton.click();
			Certify_DocumentViewPopup_Close = true;
			return Certify_DocumentViewPopup_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentViewPopup_Close;
		}
	}

	/*
	 * @When("user clicks on Proceed to Certification button on Document Selection page $shtName and $intRow") public boolean Certify_DocumentSelection_ProceedToCertification(String shtName, String intRow) { boolean Certify_DocumentSelection_ProceedToCertification = false; try { String strStepName =
	 * "Certify_DocumentSelection_ProceedToCertification"; if (intRow.equals("")) { logSteps.execution_log("The data input can NOT be empty - UnSuccessful"); return false; } String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow)); String strDocumentType =
	 * GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase(); String strState = GetValueIfValid("State", shtName, Integer.parseInt(intRow)); String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
	 * 
	 * boolean intRet = Certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
	 * 
	 * 
	 * if (intRet == false) { return Certify_DocumentSelection_ProceedToCertification; } if (strState.toUpperCase().equals("DEFERRED")) { if (isAlertPresent()) { logSteps.execution_log("The expected popup window for Deferred document <" + strRegNumber + "> Not displayed - UnSuccessful"); return
	 * Certify_DocumentSelection_ProceedToCertification; } else { Alert alert = mainPage.getDriver().switchTo().alert(); alert.accept(); if (intRet == false) { return Certify_DocumentSelection_ProceedToCertification; } } } String strErrorMsgs = null; if (!documentDetailPage.Heading_WebTable.isPresent())
	 * { if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) { strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim(); if (!strErrorMsgs.equals("")) { intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs); if (intRet == false) {
	 * Certify_DocumentSelection_ProceedToCertification = false; } } else { logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful"); } } else { logSteps.execution_log("Unknown page is returned - UnSuccessful"); } return Certify_DocumentSelection_ProceedToCertification; } String
	 * strHeadingText = documentDetailPage.Heading_WebTable.getAttribute("text"); if (!(InStr(strHeadingText, strRegNumber) > 0)) { logSteps.execution_log("The <Reg No: " + strRegNumber + "> Not exist on the <Document Detail> page - UnSuccessful"); return false; } if (!strDocumentType.equals("") &&
	 * !strDocumentType.equals("IGNORE_VALUE")) { if (!(InStr(strHeadingText, strDocumentType) > 0)) { logSteps.execution_log("The <Doc Type: " + strDocumentType + "> Not exist on the <Document Detail> page - UnSuccessful"); } else { logSteps.execution_log("The <Document Detail> page with <Reg No: " +
	 * strRegNumber + ">, <Doc Type: " + strDocumentType + "> displayed - Successful"); Certify_DocumentSelection_ProceedToCertification = true; } return Certify_DocumentSelection_ProceedToCertification; }
	 * 
	 * return true; } catch (Exception e) { e.printStackTrace(); return Certify_DocumentSelection_ProceedToCertification; } }
	 */

	public boolean Certify_DocumentSelection_Click_ProceedToCertification(String shtName, String intRow) {
		boolean Certify_DocumentSelection_Click_ProceedToCertification = false;
		try {
			if (intRow.equals("")) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return Certify_DocumentSelection_Click_ProceedToCertification;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			if (!strRegNumber.equals("") && !strRegNumber.equals("IGNORE_VALUE")) {
				// intRet = Certify_DocumentSelection_EnterData(shtName, intRow)
				intRet = DocumentSelection_EnterData(shtName, intRow);
				if (intRet == false) {
					return Certify_DocumentSelection_Click_ProceedToCertification;
				}
			}
			documentSelectionPage.Proceed_WebButton.click();
			Certify_DocumentSelection_Click_ProceedToCertification = true;
			return Certify_DocumentSelection_Click_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_Click_ProceedToCertification;
		}
	}

	public boolean VerifyPage_CertificationConfirmation() {
		boolean VerifyPage_CertificationConfirmation = false;
		try {
			String strStepName = "VerifyPage_CertificationConfirmation";

			List<WebElement> oLink = certifyConfirmationPage.CertificationResult_WebTable.findElements(By.xpath("//a[@class='ro']"));
			// Retrieve the number of links
			int intLinkCount = oLink.size();
			// Report fail when no link exists
			if (intLinkCount == 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "No link found on <Certification Results> confirmation page - UnSuccessful");
				// utility.AddInfo("No link found on <Certification Results> confirmation page - UnSuccessful");
				return VerifyPage_CertificationConfirmation;
			}
			// Report fail when two or more links found
			if (intLinkCount > 1) {
				// Reporter.reportEvent(Status.Failed, strStepName, "More than 1link found on <Certification Results> confirmation page - UnSuccessful");
				// utility.AddInfo("More than 1link found on <Certification Results> confirmation page - UnSuccessful");
				return VerifyPage_CertificationConfirmation;
			}
			// Retrieve the document number
			String strDocumentNumber = oLink.get(0).getText().trim();
			// Reporter.reportEvent(Status.Passed, strStepName, "Certification of <" + strDocumentNumber + "> displayed - Successful");
			// utility.AddInfo("Certification of <" + strDocumentNumber + "> displayed - Successful");
			// Call function to save the document number to data sheet CertificationResults
			Save_DocumentNumber_To_Datasheet(strDocumentNumber);
			// Click Document Hyperlink
			certifyConfirmationPage.CertificationResult_WebTable.find(By.xpath("//a[@class='ro']")).click();

			// Verify a window popup
			// if (!Browser("FullCertification_Popup").Page("DocumentViewPopup").Exist(10)) {
			// // Reporter.reportEvent(Status.Failed, strStepName, "Document detail full view popup Not exist - UnSuccessful");
			// // utility.AddInfo("Document detail full view popup Not exist - UnSuccessful");
			// return VerifyPage_CertificationConfirmation;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName, "Document detail full view popup displayed - Successful");
			// utility.AddInfo("Document detail full view popup displayed - Successful");
			// Verify the registration number
			String strRegNumber = getCellData(documentViewPopupPage.RegistrationNumber_WebTable, 1, 2);
			if (strComp(strRegNumber.trim(), strDocumentNumber) != 0) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Document number <" + strDocumentNumber + "> Not exist on popup - UnSuccessful");
				// utility.AddInfo("Document number <" + strDocumentNumber + "> Not exist on popup - UnSuccessful");
				return VerifyPage_CertificationConfirmation;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Document number <" + strDocumentNumber + "> displayed on popup - Successful");
			// utility.AddInfo("Document number <" + strDocumentNumber + "> displayed on popup - Successful");
			// Close the popup
			boolean intRet = Certify_DocumentViewPopup_Close();
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Close <Document View Popup> - UnSuccessful");
				return VerifyPage_CertificationConfirmation;
			}
			// 10-10-2013/Jenny/Changed Next In My Queue to Next In Queue for 2013-R1
			if (!certifyConfirmationPage.NextInMyQueue_WebButton.isPresent()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Next In Queue> button Not exist - UnSuccessful");
				// utility.AddInfo("<Next In Queue> button Not exist - UnSuccessful");
				return VerifyPage_CertificationConfirmation;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Next In Queue> button displayed - Successful");
			// utility.AddInfo("<Next In Queue> button displayed - Successful");
			VerifyPage_CertificationConfirmation = true;
			return VerifyPage_CertificationConfirmation;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyPage_CertificationConfirmation;
		}
	}

	public void Save_DocumentNumber_To_Datasheet(String strDocumentNumber) {
		try {
			// Disable Error Reporting in QTP

			// Add datasheet if not exist
			// if (Err.Number != 0) {
			// datatableLib.addsheet(("CertificationResults"));
			// datatableLib.getsheet("CertificationResults").addparameter("RegNumber");
			// // Reporter.reportEvent(Status.Completed, strStepName, "Sheet <CertificationResults> is added - Successful");
			// // utility.AddInfo("Sheet <CertificationResults> is added - Successful");
			// }
			// Set focus

			// Post the document number to the datasheet
			setTestData("RegNumber", "CertificationResults", 1, strDocumentNumber);

			// Enable Error Reporting in QTP
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user clicks on the Proceed to Certification button on the Document Selection page $shtName and $intRow")
	public boolean user_click_on_the_Proceed_to_Certification_button_on_the_Document_Selection_page(String shtName, String intRow) {
		boolean Certify_DocumentSelection_ProceedToCertification = false;
		try {
			String strStepName = "Certify_DocumentSelection_ProceedToCertification";

			// Input data can//t be empty
			if (intRow.equals("")) {
				return false;
			}
			// Fetch data
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strState = GetValueIfValid("State", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = Certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
			if (intRet == false) {
				return Certify_DocumentSelection_ProceedToCertification;
			}
			// Verify the window popup for Deferred document
			if (strState.toUpperCase().equals("DEFERRED")) {

				intRet = CloseDialog("OK");
				if (intRet == false) {
					return Certify_DocumentSelection_ProceedToCertification;
				}
			}
			String strErrorMsgs = null;
			// Verify the page
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				// Verify error message
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							Certify_DocumentSelection_ProceedToCertification = false;
						}
					} else {
					}
				} else {
				}
				return Certify_DocumentSelection_ProceedToCertification;
			}
			String strHeadingText = documentDetailPage.Heading_WebTable.getText();
			// Verify the Registration Number
			if (!(InStr(strHeadingText, strRegNumber) > 0)) {
				return false;
			}
			// Verify the Document Type if applicable
			if (!strDocumentType.equals("") && !strDocumentType.equals("IGNORE_VALUE")) {
				if (!(InStr(strHeadingText, strDocumentType) > 0)) {
				} else {
					Certify_DocumentSelection_ProceedToCertification = true;
				}
				return Certify_DocumentSelection_ProceedToCertification;
			}
			Certify_DocumentSelection_ProceedToCertification = true;
			return Certify_DocumentSelection_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_ProceedToCertification;
		}
	}

	public boolean CloseDialog(String strAction) {

		boolean CloseDialog = false;

		try {
			String strStepName = null;
			strStepName = "CloseDialog";
			// Declare and set button name
			Object strButton = null;
			switch (strAction.toUpperCase()) {
			case "OK":
				strButton = "OK";
				break;
			case "CANCEL":
				strButton = "Cancel";
				break;
			}
			environmentlib.setProperty("bTriggered", "false");
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			// Browser("ELRS").Dialog("Dialog").WinButton(strButton).Click();
			/*
			 * if (environmentlib.getProperty("bTriggered").equals("true")) { // Reporter.reportEvent(Status.Failed,strStepName,"Click <"+strButton+"> on popup - UnSuccessful"); // utility.AddInfo("Click <"+strButton+"> on popup - UnSuccessful");
			 * 
			 * CloseDialog = false;
			 * 
			 * }
			 */
			// Reporter.reportEvent(Status.Passed,strStepName,"<"+strButton+"> button is clicked on popup - Successful");
			// utility.AddInfo("<"+strButton+"> button is clicked on popup - Successful");
			CloseDialog = true;
			return CloseDialog;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Proceed to Certification button on Document Selection page $shtName and $intRow")
	public boolean Certify_DocumentSelection_ProceedToCertification_navigate(String shtName, String intRow) {
		boolean Certify_DocumentSelection_ProceedToCertification = false;
		try {
			String strStepName = "Certify_DocumentSelection_ProceedToCertification";
			if (intRow.equals("")) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strState = GetValueIfValid("State", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = Certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
			documentDetailPage.Cancel_WebButton.click();
			Alert alert = basePage.getDriver().switchTo().alert();
			alert.accept();
			Certify_DocumentSelection_ProceedToCertification = true;
			return Certify_DocumentSelection_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_ProceedToCertification;
		}
	}

	@Then("user verifies uiobject property $shtName and $intRow")
	public boolean uiobject_property(String shtName, String intRow) {
		boolean uiobject_property = false;
		try {
			String strRegNumber = GetValueIfValid("Property", shtName, Integer.parseInt(intRow));
			String strActualRegNumber = documentSelectionPage.RegistrationNumber_WebEdit.getAttribute("value");
			if (strComp(strRegNumber, strActualRegNumber) != 0) {
				return false;
			}
			uiobject_property = true;
			return uiobject_property;
		} catch (Exception e) {
			e.printStackTrace();
			return uiobject_property;
		}
	}

	@When("user cancels un defer popup when proceed to certification button is clicked for deferred document $shtName and $intRow")
	public boolean Certify_DocumentSelection_Cancel_Un_Defer(String shtName, String intRow) {
		boolean Certify_DocumentSelection_Cancel_Un_Defer = false;
		try {
			String strStepName = "Certify_DocumentSelection_Cancel_Un_Defer";
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet;
			intRet = Certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
			if (intRet == false) {
				return Certify_DocumentSelection_Cancel_Un_Defer;
			}
			// VerifyApplicationError();
			String strErrorMsgs = null;
			if (documentSelectionPage.Proceed_WebButton.isPresent()) {
				strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.equals("")) {
					VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					return Certify_DocumentSelection_Cancel_Un_Defer;
				}
			}
			intRet = CancelDialog();
			if (intRet == false) {
				return Certify_DocumentSelection_Cancel_Un_Defer;
			}
			if (documentSelectionPage.Proceed_WebButton.isPresent()) {
				strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.equals("")) {
					VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					return Certify_DocumentSelection_Cancel_Un_Defer;
				}
			} else {
				// logSteps.execution_log("Unknown page returned - UnSuccessful");
				return Certify_DocumentSelection_Cancel_Un_Defer;
			}
			String strActualRegNumber = documentSelectionPage.RegistrationNumber_WebEdit.getAttribute("value");
			if (strComp(strRegNumber, strActualRegNumber) != 0) {
				return false;
			}
			Certify_DocumentSelection_Cancel_Un_Defer = true;
			return Certify_DocumentSelection_Cancel_Un_Defer;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_Cancel_Un_Defer;
		}
	}

	@When("user clicks on Proceed to Certification button on Document Selection page $shtName and $intRow")
	public boolean Certify_DocumentSelection_ProceedToCertification(String shtName, String intRow) {
		boolean Certify_DocumentSelection_ProceedToCertification = false;
		try {
			String strStepName = "Certify_DocumentSelection_ProceedToCertification";

			if (intRow.equals("")) {
				return false;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strState = GetValueIfValid("State", shtName, Integer.parseInt(intRow));
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = Certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
			if (intRet == false) {
				return Certify_DocumentSelection_ProceedToCertification;
			}
			if (strState.toUpperCase().equals("DEFERRED")) {
				intRet = CloseDialog("OK");
				if (intRet == false) {
					return Certify_DocumentSelection_ProceedToCertification;
				}
			}
			String strErrorMsgs = null;
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							Certify_DocumentSelection_ProceedToCertification = false;
						}
					} else {
						logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful");
					}
				} else {
					logSteps.execution_log("Page <Document Detail> Not displayed - UnSuccessful");
				}
				return Certify_DocumentSelection_ProceedToCertification;
			}
			String strHeadingText = documentDetailPage.Heading_WebTable.getAttribute("text");
			Certify_DocumentSelection_ProceedToCertification = true;
			return Certify_DocumentSelection_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_ProceedToCertification;
		}
	}

	public String DocumentDetail_Retrieve_RegNumber() {
		String DocumentDetail_Retrieve_RegNumber = null;
		try {
			// Retrieve the Reg No from the page as the expected Registration Number
			String strHeadingText = null;
			strHeadingText = documentDetailPage.Heading_WebTable.getText();
			System.out.println(strHeadingText);
			String[] arrHeadingText = null;
			String strRegNoText = null;
			arrHeadingText = (strHeadingText).split("Reg No:");
			strRegNoText = arrHeadingText[1].trim();
			String[] arrRegNoText = null;
			String strRegNumber = null;
			arrRegNoText = (strRegNoText).split("Reg Date/Time");
			strRegNumber = arrRegNoText[0].trim();
			DocumentDetail_Retrieve_RegNumber = strRegNumber.trim();
			return DocumentDetail_Retrieve_RegNumber;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean CancelDialog() {
		boolean CancelDialog = false;
		try {
			String strStepName = "CancelDialog";
			// Alert alert = mainPage.getDriver().switchTo().alert();
			// alert.dismiss();

			if (Boolean.parseBoolean(environmentlib.getProperty("Test", "bTriggered")) == true) {
				CancelDialog = false;
				return CancelDialog;
			}

			CancelDialog = true;
			return CancelDialog;
		} catch (Exception e) {
			e.printStackTrace();
			return CancelDialog;
		}
	}

	@When("user clicks on Proceed To Certification in Certify page $shtName and $intRow")
	public boolean Certify_DocumentSelection_Click_Proceed_T_Certification(String shtName, String intRow) {
		boolean Certify_DocumentSelection_Click_ProceedToCertification = false;
		try {
			String strStepName = "Certify_DocumentSelection_Click_ProceedToCertification";
			if (intRow.equals("")) {
				return Certify_DocumentSelection_Click_ProceedToCertification;
			}
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			if (!strRegNumber.equals("") && !strRegNumber.equals("IGNORE_VALUE")) {
				intRet = DocumentSelection_EnterData(shtName, intRow);
				if (intRet == false) {
					return Certify_DocumentSelection_Click_ProceedToCertification;
				}
			}
			documentSelectionPage.Proceed_WebButton.click();
			WaitUtil.waitMSeconds(10000);
			Certify_DocumentSelection_Click_ProceedToCertification = true;
			return Certify_DocumentSelection_Click_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_Click_ProceedToCertification;
		}
	}
		
	@When("user clicks on the Proceed to Certification button on the Document Selection $shtName and $intRow")
	public boolean certify_DocumentSelection_ProceedToCertification(String shtName, String intRow) {
		boolean Certify_DocumentSelection_ProceedToCertification = false;
		try {
			String strStepName = "Certify_DocumentSelection_ProceedToCertification";
			if (intRow.equals("")) {
				return false;
			}
			// strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			String strDocumentType = GetValueIfValid("DocumentType", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			boolean intRet = certify_DocumentSelection_Click_ProceedToCertification(shtName, intRow);
			if (intRet == false) {
				return Certify_DocumentSelection_ProceedToCertification;
			}
			String strErrorMsgs = null;
			if (!documentDetailPage.Heading_WebTable.isPresent()) {
				if (documentSelectionPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(documentSelectionPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.equals("")) {
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							Certify_DocumentSelection_ProceedToCertification = false;
						}
					} else {
					}
				} else {
				}
				return Certify_DocumentSelection_ProceedToCertification;
			}
			Certify_DocumentSelection_ProceedToCertification = true;
			return Certify_DocumentSelection_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_ProceedToCertification;
		}
	}
	
	public boolean certify_DocumentSelection_Click_ProceedToCertification(String shtName, String intRow) {
		boolean Certify_DocumentSelection_Click_ProceedToCertification = false;
		try {
			if (intRow.equals("")) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return Certify_DocumentSelection_Click_ProceedToCertification;
			}
			// String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			if (!strRegNumber.equals("") && !strRegNumber.equals("IGNORE_VALUE")) {
				// intRet = Certify_DocumentSelection_EnterData(shtName, intRow)
				intRet = documentSelection_EnterData(shtName, intRow);
				if (intRet == false) {
					return Certify_DocumentSelection_Click_ProceedToCertification;
				}
			}
			documentSelectionPage.Proceed_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			Certify_DocumentSelection_Click_ProceedToCertification = true;
			return Certify_DocumentSelection_Click_ProceedToCertification;
		} catch (Exception e) {
			e.printStackTrace();
			return Certify_DocumentSelection_Click_ProceedToCertification;
		}
	}

public boolean documentSelection_EnterData(String shtName, String intRow) {
		boolean DocumentSelection_EnterData = false;
		try {
			documentSelectionPage.RegistrationNumber_WebEdit.clear();
			documentSelectionPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);

			DocumentSelection_EnterData = true;
			return DocumentSelection_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return DocumentSelection_EnterData;
		}
	}
}
