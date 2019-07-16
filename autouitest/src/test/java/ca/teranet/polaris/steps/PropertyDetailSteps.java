package ca.teranet.polaris.steps;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CorrectUpdateCertifiedPropertyPage;
import ca.teranet.pages.polaris.DescriptionPage;
import ca.teranet.pages.polaris.Description_BulkEditPage;
import ca.teranet.pages.polaris.Description_ChildEditPage;
import ca.teranet.pages.polaris.Documents_BulkEditPage;
import ca.teranet.pages.polaris.InternalPINNotesPage;
import ca.teranet.pages.polaris.ManagersPage;
import ca.teranet.pages.polaris.OwnersPage;
import ca.teranet.pages.polaris.PendingBulkEditsPage;
import ca.teranet.pages.polaris.PrintParcelPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.pages.polaris.PropertyDetail_ApplyToSomePage;
import ca.teranet.pages.polaris.PropertyMaintenancePage;
import ca.teranet.pages.polaris.PropertyRemarksPage;
import ca.teranet.pages.polaris.Property_CorrectionNoticesPage;
import ca.teranet.pages.polaris.UpdateCertifiedPropertyBulkPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class PropertyDetailSteps extends Utility {

	@Steps
	PropertyDetailPage propertyDetailPage;
	CorrectUpdateCertifiedPropertyPage correctUpdateCertifiedPropertyPage;
	PrintParcelPage printParcelPage;
	DescriptionPage descriptionPage;
	PropertyMaintenancePage propertyMaintenancePage;
	OwnersPage ownersPage;
	Property_CorrectionNoticesPage property_CorrectionNoticesPage;
	ManagersPage managersPage;
	InternalPINNotesPage internalPINNotesPage;
	LogSteps logSteps = new LogSteps();
	Description_BulkEditPage description_BulkEditPage;
	PropertyDetail_ApplyToSomePage propertyDetail_ApplyToSomePage;
	PendingBulkEditsPage pendingBulkEditsPage;
	Documents_BulkEditPage documents_BulkEditPage;
	PropertyRemarksPage propertyRemarksPage;
	UpdateCertifiedPropertyBulkPage updateCertifiedPropertyBulkPage;
	BatchPage batchPage;
	DividePropertySteps divideproperty;
	CondoAmalgamation condoAmalgamation;
	CreateUnitsSteps createUnits;
	OpenCondominium openCondominium;
	OpenSubdivision openSubdivision;
	Description_ChildEditPage description_ChildEdit;
	ELRSCommonSteps elrsCommon;

	@When("user click on the OK button on the popup")
	public boolean user_click_on_the_OK_button_on_the_popup() {
		boolean PropertyDetail_Cancel = false;
		try {
			propertyDetailPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			PropertyDetail_Cancel = true;
			return PropertyDetail_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Cancel;
		}

	}

	public String PropertyDetail_Retrieve_ParentPIN() {
		try {
			String strParentPINs = null;
			strParentPINs = propertyDetailPage.ParentPINHeader_WebElement.getText();
			return strParentPINs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@When("user cancels the Cancel popup on Property Detail with data entry $shtName and $intRow")
	public boolean PropertyDetail_EnterData_UsingDataMap(String shtName, int intRow) {
		boolean PropertyDetail_EnterData_UsingDataMap = true;
		try {
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();

			oDataMap.put("Description", "");
			oDataMap.put("Documents", "");
			oDataMap.put("Owners", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("CorrectionNotices", "");
			oDataMap.put("Managers", "");
			oDataMap.put("InternalPINNotes", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);
			for (int i = 0; i <= arrKeys.length - 1; i++) {
				// if(Err.Number!=0){
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, intRow).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}
			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				// Navigate to the tab
				intRet = PropertyDetail_Navigate_To_Tab(strSheetName);
				/*
				 * if (intRet == false) { PropertyDetail_EnterData_UsingDataMap = false; return PropertyDetail_EnterData_UsingDataMap; }
				 */
				switch (strSheetName.toUpperCase()) {
				case "DESCRIPTION":
					intRet = PropertyDetail_Edit_Description(strSheetName, strRowNumber);
					break;
				case "DOCUMENTS":
					intRet = PropertyDetail_Edit_Documents(strSheetName, strRowNumber);
					break;
				case "OWNERS":
					intRet = PropertyDetail_Edit_Owners(strSheetName, strRowNumber);
					break;
				case "PROPERTYREMARKS":
					intRet = PropertyDetail_Edit_PropertyRemarks(strSheetName, strRowNumber);
					break;
				case "CORRECTIONNOTICES":
					intRet = PropertyDetail_Edit_CorrectionNotices(strSheetName, strRowNumber);
					break;
				case "MANAGERS":
					intRet = PropertyDetail_Edit_Managers(strSheetName, Integer.parseInt(strRowNumber));
					break;
				case "INTERNALPINNOTES":
					intRet = PropertyDetail_Edit_InternalPINNotes(strSheetName, strRowNumber);
					break;
				}
				/*
				 * if (intRet == false) { PropertyDetail_EnterData_UsingDataMap = false; }
				 */
			}
			oDataMap = null;
			return PropertyDetail_EnterData_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_EnterData_UsingDataMap;
		}
	}

	@Then("user verifies no results found $shtName and $intRow")

	public boolean user_verify_error_message_for_no_results_found(String shtName, String intRow) {

		try {

			String expErrorMsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));

			System.out.println("Expected " + expErrorMsg);

			String actualErrorMsg = mainPage.getDriver().findElement(By.xpath("//div[@id='createPropertyDetailsForm.errors']")).getText();

			System.out.println("Actual " + actualErrorMsg);

			if (expErrorMsg.equalsIgnoreCase(actualErrorMsg)) {

				// logSteps.execution_log("Error Messages Matched");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	@When("user clicks the OK button on the Cancel on Property Detail page $shtName and $intRow")
	public boolean PropertyDetail_OK_Cancel(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_CancelCancel";
			boolean PropertyDetail_CancelCancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = PropertyDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
				if (intRet == false) {
					return false;
				}
			}
			// String strPreActiveTab = null;
			// String strActiveTab;
			// strPreActiveTab = CheckPropertyDetailActiveTab();
			propertyDetailPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			Thread.sleep(2000);
			// if (environmentlib.getProperty("bTriggered").equals("true")) {
			// return false;
			// }
			String strAction = null;
			strAction = "Cancel";
			// intRet = ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			// strActiveTab = CheckPropertyDetailActiveTab();
			// if (!(strComp(strPreActiveTab, strActiveTab) == 0)) {
			// return false;
			// }
			PropertyDetail_CancelCancel = true;
			return PropertyDetail_CancelCancel;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks the OK button on the Cancel on Property Detail page")
	public boolean PropertyDetail_Ok_Cancel() {
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_CancelCancel";
			boolean PropertyDetail_CancelCancel = false;
			boolean intRet = false;
			// if (intRet == false) {
			// return false;
			// }

			String strPreActiveTab = null;
			String strActiveTab;

			String strAction = null;

			propertyDetailPage.Cancel_WebButton.click();
			Alert alerttext = mainPage.getDriver().switchTo().alert();
			alerttext.accept();
			PropertyDetail_CancelCancel = true;
			return PropertyDetail_CancelCancel;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks the tab $tabname")
	public void clickTabLink(String tabname) {
		switch (tabname.toUpperCase()) {
		case "CORRECTIONNOTICES":
			propertyDetailPage.CorrectionNotices_Link.click();
			break;
		case "DESCRIPTION":
			propertyDetailPage.Description_Link.click();
			break;
		case "DOCUMENTS":
			propertyDetailPage.Documents_Link.click();
			break;
		case "MANAGERS":
			propertyDetailPage.Managers_Link.click();
			break;
		case "OWNERS":
			propertyDetailPage.Owners_Link.click();
			break;
		case "PROPERTYREMARKS":
			propertyDetailPage.PropertyRemarks_Link.click();
			break;
		}
	}

	@When("user enter data for property Documents details $shtName and $intRow")
	public boolean PropertyDetail_Edit_Documents(String shtName, String intRow) {
		boolean PropertyDetail_Edit_Documents = false;
		try {
			String strStepName = "PropertyDetail_Edit_Documents";

			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = intRow.split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			// Define variables
			int intPropertyIndex = 0;
			// Set focus on the first row
			// Fetch valid data from the first row of the input block
			String strBrought_Forward = GetValueIfValid("Brought_Forward", shtName, intStart);
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intStart);
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("0") || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			String strActionForAllPINs = GetValueIfValid("ActionForAllPINs", shtName, intStart);
			boolean intRet = false;
			setCheckBoxValue(propertyDetailPage.find(By.name("crdFromPropIndexNoDocToBeCarriedFwdMap['" + intPropertyIndex + "']")), strBrought_Forward);
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strDocumentAction = GetValueIfValid("DocumentAction", shtName, iLoop);
				String strRegNumber = GetValueIfValid("RegNumber", shtName, iLoop);
				String strRegDate = GetValueIfValid("RegDate", shtName, iLoop);
				String strAffectThisProperty = GetValueIfValid("AffectThisProperty", shtName, iLoop);
				if (strDocumentAction.toUpperCase().equals("ADD")) {
					propertyDetailPage.find(By.id("registrationNumber" + intPropertyIndex)).sendKeys(strRegNumber);
					propertyDetailPage.find(By.id("propertyDetailsFormDocument[" + intPropertyIndex + "].registrationDate")).sendKeys(strRegDate);
					propertyDetailPage.find(By.id("addDocCarryFwd")).click();
					WaitUtil.waitMSeconds(1000);
					VerifyApplicationError();
					// Verify the error message if any returned
					// 2015-07-30/Jenny/Change to use innertext to retrieve error message(s) due to Spring change
					// strErrorMsgs = Trim(Browser("ELRS").Page("PropertyDetail").WebTable("ErrorMsg").GetCellData(1,1))
					String strErrorMsgs = propertyDetailPage.ErrorMsg_WebTable.getText().trim();
					String strExpectedMsgs = null;
					if (!strErrorMsgs.isEmpty()) {
						// Verify the error message
						if (!shtName.isEmpty() && !intRow.isEmpty()) {
							// Set focus
							// Retrieve expected error message from datasheet
							strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, iLoop);
						} else {
							strExpectedMsgs = "";
						}
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						return PropertyDetail_Edit_Documents;
					}
				}
				switch (strAffectThisProperty.toUpperCase()) {
				case "YES":
					// selectWebRadioGroupByIndex(By.id("affectsThisDocument(" + intPropertyIndex + "," + strRegNumber + ")"), 1);
					selectWebRadioGroupByIndex(By.name("affectsThisDocumentMap['" + intPropertyIndex + "," + strRegNumber + "']"), 1);
					WaitUtil.waitMSeconds(500);
					break;
				case "NO":
					// selectWebRadioGroupByIndex(By.id("affectsThisDocument\\(" + intPropertyIndex + "\\," + strRegNumber + "\\)"), 2);
					selectWebRadioGroupByIndex(By.name("affectsThisDocumentMap['" + intPropertyIndex + "," + strRegNumber + "']"), 2);
					WaitUtil.waitMSeconds(500);
					break;
				}
				// End If
			}
			if (!strActionForAllPINs.isEmpty() && !strActionForAllPINs.equals("IGNORE_VALUE")) {
				intRet = PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs(strActionForAllPINs);
				if (intRet != true) {
					return intRet;
				}
			}
			if (!PropertyDetail_Edit_Documents) {
				// Reporter.reportEvent(Status.Passed, strStepName, "Enter data to <Documents> page - Successful");
				// AddInfo("Enter data to <Documents> page - Successful");
				PropertyDetail_Edit_Documents = true;
			}
			return PropertyDetail_Edit_Documents;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Documents;
		}
	}

	@When("user cancels the Cancel popup on Property Detail page")
	public boolean user_cancels_Cancelpopup() {
		try {
			String strStepName = "PropertyDetail_CancelCancel";
			boolean PropertyDetail_CancelCancel = false;
			boolean intRet = false;

			// String strButtonName = null;
			propertyDetailPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			// String alertText = confirmationAlert.getText();
			confirmationAlert.dismiss();
			// Thread.sleep(3000);
			PropertyDetail_CancelCancel = true;
			return PropertyDetail_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean PropertyDetail_Navigate_To_Tab(String strTabName) {
		boolean PropertyDetail_Navigate_To_Tab = false;
		try {
			String strStepName = "PropertyDetail_Navigate_To_Tab";
			if (propertyDetailPage.SingleEdit_WebButton.isCurrentlyVisible()) {
				clickTabBulkLink(strTabName);
			} else {
				if (propertyDetailPage.FullDetails_WebElement.isCurrentlyVisible()) {
					String strFullDetails = propertyDetailPage.FullDetails_WebElement.getText().toUpperCase();
					if (strFullDetails.contains("BULK EDIT")) {
						clickTabBulkLink(strTabName);
					} else {
						clickTabLink(strTabName);
					}
				} else {
					clickTabLink(strTabName);
				}
			}
			PropertyDetail_Navigate_To_Tab = true;
			return PropertyDetail_Navigate_To_Tab;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Navigate_To_Tab;
		}
	}

	public boolean PropertyDetail_Edit_Description_Easement_Add(int intIndex, String shtName, int intRow) {
		boolean PropertyDetail_Edit_Description_Easement_Add = false;
		try {

			// propertyDetailPage.find(By.id("newProperties[0].newProperty.legalDescription.description")).clear();
			String strEasement = GetValueIfValid("Easement", shtName, intRow);
			String strEasementIndex = GetValueIfValid("EasementIndex", shtName, intRow);
			descriptionPage.find(By.name("easementFormSelectedTemplateTypeMap['" + intIndex + "']")).selectByVisibleText(strEasement.toUpperCase());
			descriptionPage.find(By.id("addToResultingEasement" + intIndex)).click();
			boolean intRet = false;
			if (NumberUtils.isNumber(strEasementIndex)) {
				intRet = PropertyDetail_Edit_Description_Easement_Fill(intIndex, shtName, intRow);
				if (!intRet == true) {
					PropertyDetail_Edit_Description_Easement_Add = true;
				}
			}
			return PropertyDetail_Edit_Description_Easement_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Description_Easement_Add;
		}
	}

	public boolean PropertyDetail_Edit_Description_Easement_Fill(int intIndex, String shtName, int intRow) {
		boolean PropertyDetail_Edit_Description_Easement_Fill = false;
		try {
			String strStepName = "PropertyDetail_Edit_Description_Easement_Fill";
			String strEasement = GetValueIfValid("Easement", shtName, intRow);
			String strEasementIndex = GetValueIfValid("EasementIndex", shtName, intRow);
			String strOver = GetValueIfValid("Over", shtName, intRow);
			String strFavorOf = GetValueIfValid("FavorOf", shtName, intRow);
			String strUntil = GetValueIfValid("Until", shtName, intRow);
			String strAsIn = GetValueIfValid("AsIn", shtName, intRow);
			if (!NumberUtils.isNumber(strEasementIndex)) {
				return false;
			}
			int intEasementIndex = Integer.parseInt(strEasementIndex) - 1;
			switch (strEasement.toUpperCase()) {
			case "S/T EASE - EXISTING":
			case "CONDO PLAN - S/T AND T/W EASE":
			case "CONDO PLAN - S/T EASE ONLY":
			case "CONDO PLAN - T/W EASE ONLY":
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_0")).sendKeys(strAsIn);
				break;
			case "S/T EASE - TIME LIMITED":
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_0")).sendKeys(strOver);
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_1")).sendKeys(strFavorOf);
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_2")).sendKeys(strUntil);
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_3")).sendKeys(strAsIn);
				break;
			case "S/T EASE IN GROSS - NO TIME LIMIT":
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_0")).sendKeys(strOver);
				propertyDetailPage.find(By.id("clauseSpec" + intIndex + "_" + intEasementIndex + "_1")).sendKeys(strAsIn);
				break;
			}
			PropertyDetail_Edit_Description_Easement_Fill = true;
			return PropertyDetail_Edit_Description_Easement_Fill;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Description_Easement_Fill;
		}
	}

	public boolean PropertyDetail_Edit_Description_Easement_Remove(int intIndex, String intEasementIndex, String strExpectedMsgs) {
		boolean PropertyDetail_Edit_Description_Easement_Remove = false;
		try {
			String strStepName = "PropertyDetail_Edit_Description_Easement_Remove";
			int intStartIndex = 0;
			int intEndIndex = 0;
			if (!intEasementIndex.isEmpty() && !intEasementIndex.equals("IGNORE_VALUE")) {
				if (intEasementIndex.contains("-")) {
					String[] arrEasements = (intEasementIndex).split("-");
					intStartIndex = Integer.parseInt(arrEasements[0]);
					intEndIndex = Integer.parseInt(arrEasements[1]);
				} else {
					intStartIndex = Integer.parseInt(intEasementIndex);
					intEndIndex = intStartIndex;
				}
				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					propertyDetailPage.find(By.id("easementRemove" + (iLoop - 1))).sendKeys("ON");
				}
				propertyDetailPage.find(By.id("easementForm\\[" + intIndex + "\\].remove")).click();
				String strErrorMsgs = propertyDetailPage.ErrorMsg_WebTable.getText().trim();
				if (!strErrorMsgs.isEmpty()) {
					boolean intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				}
				return PropertyDetail_Edit_Description_Easement_Remove;
			}
			PropertyDetail_Edit_Description_Easement_Remove = true;
			return PropertyDetail_Edit_Description_Easement_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Description_Easement_Remove;
		}
	}

	public boolean PropertyDetail_Edit_Description(String shtName, String intRow) {
		boolean PropertyDetail_Edit_Description = true;
		try {
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = intRow.split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intStart);
			String strRegSystem = GetValueIfValid("RegSystem", shtName, intStart);
			String strEstate = GetValueIfValid("Estate", shtName, intStart);
			String strQualifier = GetValueIfValid("Qualifier", shtName, intStart);
			String strFrench = GetValueIfValid("French", shtName, intStart);
			String strDescription = GetValueIfValid("Description", shtName, intStart);
			String strLowerMunicipality = GetValueIfValid("LowerMunicipality", shtName, intStart);
			String strCopyAction = GetValueIfValid("CopyAction", shtName, intStart);
			String strBlockNumber = GetValueIfValid("BlockNumber", shtName, intStart);
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intStart);
			switch (strRegSystem.toUpperCase()) {
			case "LAND TITLES":
			case "LT":
				strRegSystem = "LAND TITLES";
				break;
			case "REGISTRY":
			case "R":
				strRegSystem = "REGISTRY";
				break;
			}

			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("0") || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			boolean intRet = false;
			String strFunction = mainPage.FuncID_WebElement.getText().trim();
			if (strFunction.equals("Re-Enter Property") || strFunction.equals("Create Condo Amendment")) {
				propertyDetailPage.find(By.id("blockNumber" + intPropertyIndex)).sendKeys(strBlockNumber);
			}
			if ((!strRegSystem.isEmpty() && !strRegSystem.equals("N/C"))) {
				propertyDetailPage.find(By.name("registrationSystemMap['" + intPropertyIndex + "']")).selectByVisibleText(strRegSystem);
				WaitUtil.waitMSeconds(2000);
			}
			setCheckBoxValue(propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "EstateQualifierFrenchIndicator")), strFrench);
			if (strEstate.contains("ESTATE: N/A (Retired)")) {
				if (propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Interest")).isDisplayed())
					propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Interest")).selectByVisibleText(strEstate);
			} else {
				propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Interest")).selectByVisibleText(strEstate.toUpperCase());

			}
			if (strQualifier.equals("QUALIFIER: N/A (Retired)")) {
				if (propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Qualifier")).isDisplayed())
					propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Qualifier")).selectByVisibleText(strQualifier);
			} else {
				propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Qualifier")).selectByVisibleText(strQualifier.toUpperCase());
			}

			// propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Interest")).selectByVisibleText(strEstate.toUpperCase());
			// propertyDetailPage.find(By.id("Prop" + intPropertyIndex + "Qualifier")).selectByVisibleText(strQualifier.toUpperCase());
			if (!strCopyAction.isEmpty() && !strCopyAction.equals("IGNORE_VALUE")) {
				switch (strCopyAction.toUpperCase()) {
				case "DOCUMENT":
				case "COPYFROMDOCUMENT":
				case "COPY FROM DOCUMENT":
					propertyDetailPage.find(By.id("copyDescFromDocumentBtn" + intPropertyIndex)).click();
					break;
				case "PARENTPIN":
				case "PARENT PIN":
				case "COPYFROMPARENTPIN":
				case "COPY FROM PARENT PIN":
					propertyDetailPage.find(By.id("copyDescFromParentPINBtn" + intPropertyIndex)).click();
					break;
				}
			}
			propertyDetailPage.find(By.id("newProperties[" + intPropertyIndex + "].newProperty.legalDescription.description")).sendKeys(strDescription);
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strEasementAction = GetValueIfValid("EasementAction", shtName, iLoop);
				String strEasementIndex = GetValueIfValid("EasementIndex", shtName, iLoop);
				if (!strEasementAction.isEmpty() && !strEasementAction.equals("IGNORE_VALUE")) {
					switch (strEasementAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_Edit_Description_Easement_Add(intPropertyIndex, shtName, iLoop);
						break;
					case "FILL":
						intRet = PropertyDetail_Edit_Description_Easement_Fill(intPropertyIndex, shtName, iLoop);
						break;
					case "REMOVE":
						intRet = PropertyDetail_Edit_Description_Easement_Remove(intPropertyIndex, strEasementIndex, strExpectedMsgs);
						break;
					}
					PropertyDetail_Edit_Description = intRet;
				}
			}
			propertyDetailPage.find(By.name("lowerTierMunicipalityMap['" + intPropertyIndex + "']")).selectByVisibleText(strLowerMunicipality.toUpperCase());
			if (PropertyDetail_Edit_Description == false) {
				return PropertyDetail_Edit_Description;
			}
			PropertyDetail_Edit_Description = true;
			return PropertyDetail_Edit_Description;
		} catch (

		Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Description;
		}
	}

	public boolean PropertyDetail_Edit_Owners(String shtName, String intRow) {
		boolean PropertyDetail_Edit_Owners = true;
		try {
			String strStepName = "PropertyDetail_Edit_Owners";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strOwnersAction = GetValueIfValid("OwnersAction", shtName, iLoop);
				if (!strOwnersAction.isEmpty() && !strOwnersAction.equals("IGNORE_VALUE")) {
					switch (strOwnersAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_Edit_Owners_Add(shtName, iLoop);
						break;
					case "REMOVE":
						intRet = PropertyDetail_Edit_Owners_Remove(shtName, iLoop);
						break;
					case "ADDMORE":
						ownersPage.MoreNames_WebButton.click();
						intRet = PropertyDetail_Edit_Owners_Add(shtName, iLoop);
						break;
					case "COPYFROMPARENTPIN":
						intRet = PropertyDetail_Edit_Owners_CopyFromParentPIN(shtName, iLoop);
						break;
					}
					PropertyDetail_Edit_Owners = intRet;
				}
			}
			if (PropertyDetail_Edit_Owners == false) {
				return false;
			}
			PropertyDetail_Edit_Owners = true;
			return PropertyDetail_Edit_Owners;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_PropertyRemarks(String shtName, String intRow) {
		boolean PropertyDetail_Edit_PropertyRemarks = true;
		try {
			String strStepName = "PropertyDetail_Edit_PropertyRemarks";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intStart);
			String strOtherRemarks = GetValueIfValid("OtherRemarks", shtName, intStart);
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strInterestAction = GetValueIfValid("InterestAction", shtName, iLoop);
				if (!strInterestAction.isEmpty() && !strInterestAction.equals("IGNORE_VALUE")) {
					switch (strInterestAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_PropertyRemarks_Interest_Add(shtName, iLoop);
						break;
					case "REMOVE":
						intRet = PropertyDetail_PropertyRemarks_Interest_Remove(shtName, iLoop);
						break;
					case "FILL":
						intRet = PropertyDetail_PropertyRemarks_Interest_Fill(shtName, iLoop);
						break;
					}
					if (intRet != true) {
						PropertyDetail_Edit_PropertyRemarks = intRet;
					}
				}
			}
			if (strPropertyIndex == "" || strPropertyIndex == "IGNORE_VALUE") {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			propertyDetailPage.find(By.id("freeformPropertyRemark" + intPropertyIndex)).clear();
			propertyDetailPage.find(By.id("freeformPropertyRemark" + intPropertyIndex)).sendKeys(strOtherRemarks);
			if (intRet != true) {
				return false;
			}
			PropertyDetail_Edit_PropertyRemarks = true;
			return PropertyDetail_Edit_PropertyRemarks;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PropertyRemarks_Interest_Add(String shtName, int intRow) {
		boolean PropertyDetail_PropertyRemarks_Interest_Add = false;
		try {
			String strStepName = "PropertyDetail_PropertyRemarks_Interest_Add";

			// Set focus
			// Declare and fetch the data
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strInterest = GetValueIfValid("Interest", shtName, intRow);
			String strInterestIndex = GetValueIfValid("InterestIndex", shtName, intRow);
			boolean intRet = false;
			// Set default value of property index as "1"
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			if (!strInterest.isEmpty() || !strInterest.equals("IGNORE_VALUE")) {
				propertyDetailPage.find(By.id("interestList" + intPropertyIndex)).selectByVisibleText(strInterest.toUpperCase());
				propertyDetailPage.find(By.id("addInterestBtn" + intPropertyIndex)).click();
			}

			if (NumberUtils.isNumber(strInterestIndex)) {
				intRet = PropertyDetail_PropertyRemarks_Interest_Fill(shtName, intRow);
				if (!intRet == true) {
					// // Reporter.reportEvent(Status.Failed,strStepName,"Fill Outstanding Interest - UnSuccessful");
					// // AddInfo("Fill Outstanding Interest - UnSuccessful");
					return false;
				}
			}
			if (!propertyDetailPage.find(By.name("oiFormInterestToRemoveMap[" + "'" + intPropertyIndex + "_" + (intPropertyIndex) + "'" + "]")).isPresent()) {
				propertyDetailPage.find(By.name("oiFormInterestToRemoveMap[" + "'" + intPropertyIndex + "_" + (intPropertyIndex) + "'" + "]")).click();
				propertyDetailPage.find(By.xpath("//input[@value='Remove Selected']")).click();
			}
			// Reporter.reportEvent(Status.Passed,strStepName,"Add Outstanding Interest - Successful");
			PropertyDetail_PropertyRemarks_Interest_Add = true;
			return PropertyDetail_PropertyRemarks_Interest_Add;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PropertyRemarks_Interest_Fill(String shtName, int intRow) {
		boolean PropertyDetail_PropertyRemarks_Interest_Fill = false;
		try {
			String strStepName = "PropertyDetail_PropertyRemarks_Interest_Fill";

			// Set focus
			// Declare and fetch the data
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strInterest = GetValueIfValid("Interest", shtName, intRow);
			String strInterestIndex = GetValueIfValid("InterestIndex", shtName, intRow);
			String strDebtsOf = GetValueIfValid("DebtsOf", shtName, intRow);
			String strSpouseOf = GetValueIfValid("SpouseOf", shtName, intRow);
			String strExecutionFrom = GetValueIfValid("ExecutionFrom", shtName, intRow);
			String strExecutionTo = GetValueIfValid("ExecutionTo", shtName, intRow);
			String strAsIn = GetValueIfValid("AsIn", shtName, intRow);
			// Set default value for property index as "1"
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;

			if (NumberUtils.isNumber(strInterestIndex)) {
				Object intInterestIndex = null;
				intInterestIndex = Integer.parseInt(strInterestIndex) - 1;
				switch (strInterest.toUpperCase()) {
				case "SUBJECT TO DEBTS":
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).sendKeys(strDebtsOf);
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO SPOUSAL RIGHTS":
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).sendKeys(strSpouseOf);
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO WRIT OF EXECUTION":
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_1")).sendKeys(strExecutionFrom);
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).sendKeys(strExecutionTo);
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_3")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_5")).clear();
					propertyDetailPage.find(By.id("oi" + intPropertyIndex + "_" + intInterestIndex + "_5")).sendKeys(strAsIn);
					break;
				}
			}
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, strStepName, "Fill data to outstanding interest <" + strInterest + "> - UnSuccessful");
			// AddInfo("Fill data to outstanding interest <" + strInterest + "> - UnSuccessful");
			// return 0;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName, "Fill data to outstanding interest <" + strInterest + "> - Successful");
			PropertyDetail_PropertyRemarks_Interest_Fill = true;
			return PropertyDetail_PropertyRemarks_Interest_Fill;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PropertyRemarks_Interest_Remove(String shtName, int intRow) {
		boolean PropertyDetail_PropertyRemarks_Interest_Remove = false;
		try {
			String strStepName = "PropertyDetail_PropertyRemarks_Interest_Remove";
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strInterestIndex = GetValueIfValid("InterestIndex", shtName, intRow);
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			int intStartIndex = 0;
			int intEndIndex = 0;
			String[] arrInterests = null;
			if (!strInterestIndex.isEmpty() && !strInterestIndex.equals("IGNORE_VALUE")) {
				if (strInterestIndex.contains("-")) {
					arrInterests = (strInterestIndex).split("-");
					intStartIndex = Integer.parseInt(arrInterests[0]);
					intEndIndex = Integer.parseInt(arrInterests[1]);
				} else {
					intStartIndex = Integer.parseInt(strInterestIndex);
					intEndIndex = intStartIndex;
				}
				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					// Check the specified checkbox oiFormInterestToRemoveMap['0_1']
					propertyDetailPage.find(By.name("oiForm[" + intPropertyIndex + "].interestToRemove(" + (iLoop - 1) + ")")).click();

				}
			}
			propertyDetailPage.find(By.id("newProperties[" + intPropertyIndex + "].outstandingInterests")).click();
			VerifyApplicationError();
			// 11-02-2012/Jenny/Add block to verify error message
			boolean intRet = false;
			// Retrieve actual error message from the screen
			String strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				return false;
			}
			PropertyDetail_PropertyRemarks_Interest_Remove = true;
			return PropertyDetail_PropertyRemarks_Interest_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_CorrectionNotices(String shtName, String intRow) {
		boolean PropertyDetail_Edit_CorrectionNotices = true;
		try {
			String strStepName = "PropertyDetail_Edit_CorrectionNotices";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			// Declare variables
			boolean intRet = false;
			// Enter data based on the correction action provided
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				String strCorrectionAction = GetValueIfValid("CorrectionAction", shtName, iLoop);
				String strNoticeIndex = GetValueIfValid("NoticeIndex", shtName, iLoop);
				if (!strCorrectionAction.isEmpty() && !strCorrectionAction.equals("IGNORE_VALUE"))
					;
				switch (strCorrectionAction.toUpperCase()) {
				case "ADD":
					intRet = PropertyDetail_CorrectionNotice_AddNotice(shtName, iLoop);
					break;
				case "REMOVE":
					intRet = PropertyDetail_CorrectionNotice_RemoveNotice(strNoticeIndex);
					break;
				}
				if (!intRet == true) {
					PropertyDetail_Edit_CorrectionNotices = false;
				}
			}

			return PropertyDetail_Edit_CorrectionNotices;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_CorrectionNotice_RemoveNotice(String intIndex) {
		boolean PropertyDetail_CorrectionNotice_RemoveNotice = false;
		try {
			String strStepName = "PropertyDetail_CorrectionNotice_RemoveNotice";

			int intStart = 0;
			int intEnd = 0;
			String[] arrIndex = null;
			if (intIndex.contains("-")) {
				arrIndex = (intIndex).split("-");
				intStart = Integer.parseInt(arrIndex[0]);
				intEnd = Integer.parseInt(arrIndex[1]);
			} else {
				intStart = Integer.parseInt(intIndex);
				intEnd = intStart + 1;
			}
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				property_CorrectionNoticesPage.find(By.xpath("//*[@name='correctionNoticesToRemove' and @value='" + (iLoop) + "']")).click();
			}
			if (property_CorrectionNoticesPage.RemoveSelected_WebButton.isVisible())
				property_CorrectionNoticesPage.RemoveSelected_WebButton.click();
			PropertyDetail_CorrectionNotice_RemoveNotice = true;
			return PropertyDetail_CorrectionNotice_RemoveNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_Managers(String shtName, int intRow) {
		boolean PropertyDetail_Edit_Managers = false;
		try {
			String strStepName = "PropertyDetail_Edit_Managers";

			// Set focus
			// Fetch valid data
			String strPINOrigin = GetValueIfValid("PINOrigin", shtName, intRow);
			String strPropertyStatus = GetValueIfValid("PropertyStatus", shtName, intRow);
			String strManualLRI = GetValueIfValid("ManualLRI", shtName, intRow);
			String strManualNDI = GetValueIfValid("ManualNDI", shtName, intRow);
			// Initialization
			// environmentlib.Value("Test","bTriggered",false);
			// Enter data
			// managersPage.PINOrigin_WebList.selectByVisibleText(strPINOrigin.toUpperCase());
			// managersPage.Status_WebList.selectByVisibleText(strPropertyStatus.toUpperCase());
			// Set Manual LRI radio button
			switch (strManualLRI.toUpperCase()) {
			case "ON":
			case "YES":
			case "Y":
				if (!managersPage.LRIIndicatorON_WebRadioGroup.isSelected())
					managersPage.LRIIndicatorON_WebRadioGroup.click();
				break;
			case "OFF":
			case "NO":
			case "N":
				if (!managersPage.LRIIndicatorOFF_WebRadioGroup.isSelected())
					managersPage.LRIIndicatorOFF_WebRadioGroup.click();
				break;
			}
			// Set Manual NDI radio button
			switch (strManualNDI.toUpperCase()) {
			case "ON":
			case "YES":
			case "Y":
				managersPage.NDIIndicatorON_WebRadioGroup.click();
				break;
			case "OFF":
			case "NO":
			case "N":
				managersPage.NDIIndicatorOFF_WebRadioGroup.click();
				break;
			}
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, strStepName, "Enter data to <Managers> page - UnSuccessful");
			// AddInfo("Enter data to <Managers> page - UnSuccessful");
			// return 0;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName, "Enter data to <Managers> page - Successful");
			// AddInfo("Enter data to <Managers> page - Successful");
			PropertyDetail_Edit_Managers = true;
			return PropertyDetail_Edit_Managers;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_InternalPINNotes(String shtName, String intRow) {
		boolean PropertyDetail_Edit_InternalPINNotes = true;
		try {
			String strStepName = "PropertyDetail_Edit_InternalPINNotes";

			// Check if there are multiple row numbers there
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			// Declare variable
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// Set focus
				// Fetch valid data
				String strInternalPINNotesAction = GetValueIfValid("InternalPINNotesAction", shtName, iLoop);
				// Perform action based on the data provided
				switch (strInternalPINNotesAction.toUpperCase()) {
				case "ADD":
				case "ADDNEW":
				case "ADD NEW":
					intRet = PropertyDetail_Edit_InternalPINNotes_Add(shtName, iLoop);
					break;
				case "REMOVE":
				case "REMOVE SELECTED":
				case "REMOVESELECTED":
					intRet = PropertyDetail_Edit_InternalPINNotes_Remove(shtName, iLoop);
					break;
				default:
					// Reporter.reportEvent(Status.Failed, strStepName, "UnKnown action <" + strInternalPINNotesAction + " provided - UnSuccessful");
					// AddInfo("UnKnown action <" + strInternalPINNotesAction + " provided - UnSuccessful");
					return false;
				}
				if (!intRet == true) {
					PropertyDetail_Edit_InternalPINNotes = intRet;
				}
			}
			// Exit function directly if not true
			if (!PropertyDetail_Edit_InternalPINNotes == true) {
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Enter data to <Internal PIN Notes> - Successful");
			// AddInfo("Enter data to <Internal PIN Notes> - Successful");
			PropertyDetail_Edit_InternalPINNotes = true;
			return PropertyDetail_Edit_InternalPINNotes;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_InternalPINNotes_Add(String shtName, int intRow) {
		boolean PropertyDetail_Edit_InternalPINNotes_Add = false;
		try {
			String strStepName = "PropertyDetail_Edit_InternalPINNotes_Add";

			// Declare variables
			// Set focus
			// Fetch valid data
			String strInternalPINNotes = GetValueIfValid("InternalPINNotes", shtName, intRow);
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			// Set default value as 1 for property index
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			if (!NumberUtils.isNumber(strPropertyIndex)) {
				// Reporter.reportEvent(Status.Failed, strStepName, "The provided <Property Index: " + strPropertyIndex + "> has to be a number - UnSuccessful");
				// AddInfo("The provided <Property Index: " + strPropertyIndex + "> has to be a number - UnSuccessful");
				return false;
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getText().trim();
			if (strMode.equals("Batch")) {
				internalPINNotesPage.find(By.id("internalNote" + intPropertyIndex)).sendKeys(strInternalPINNotes);
			} else {
				internalPINNotesPage.find(By.name("visibleNewPropertyListPortion[" + intPropertyIndex + "].internalNote")).sendKeys(strInternalPINNotes);
			}
			internalPINNotesPage.find(By.id("addInternalNoteBtn" + intPropertyIndex)).click();
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, strStepName, "<Add New> Internal PIN Notes - UnSuccessful");
			// AddInfo("<Add New> Internal PIN Notes - UnSuccessful");
			// return 0;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName, "<Add New> Internal PIN Notes - Successful");
			// AddInfo "Enter data to <Internal PIN Notes> - Successful"
			PropertyDetail_Edit_InternalPINNotes_Add = true;
			return PropertyDetail_Edit_InternalPINNotes_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_InternalPINNotes_Remove(String shtName, int intRow) {
		boolean PropertyDetail_Edit_InternalPINNotes_Remove = false;
		try {
			String strStepName = "PropertyDetail_Edit_InternalPINNotes_Remove";

			// Set focus
			// Declare and fetch the data
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strInternalPINNotesIndex = GetValueIfValid("InternalPINNotesIndex", shtName, intRow);
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
			// Set default value for property index as "1"
			if (strPropertyIndex.isEmpty() || strPropertyIndex.equals("IGNORE_VALUE")) {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			// Initialization
			// environmentlib.Value("Test","bTriggered",false);
			int intStartIndex = 0;
			int intEndIndex = 0;
			String[] arrInternalPINNotes = null;
			if (!strInternalPINNotesIndex.isEmpty() && !strInternalPINNotesIndex.equals("IGNORE_VALUE")) {
				// Check if multiple notes to be removed
				if (strInternalPINNotesIndex.contains("-")) {
					arrInternalPINNotes = (strInternalPINNotesIndex).split("-");
					intStartIndex = Integer.parseInt(arrInternalPINNotes[0]);
					intEndIndex = Integer.parseInt(arrInternalPINNotes[1]);
				} else {
					intStartIndex = Integer.parseInt(strInternalPINNotesIndex);
					intEndIndex = intStartIndex;
				}
				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					// Check the specified checkbox
					internalPINNotesPage.find(By.xpath("//input[@name='visibleNewPropertyListPortion[" + intPropertyIndex + "].internalNotesToRemove' and @value='" + (iLoop + 1) + "']")).sendKeys("ON");
				}
			}
			// Click the Remove Selected button
			internalPINNotesPage.find(By.id("newProperties[" + intPropertyIndex + "].visibleInternalNotesListPortion")).click();
			// if(environmentlib.Value("Test","bTriggered")==true){
			// Reporter.ReportEventmicFail,strStepName,"Remove Selected Internal PIN Notes - UnSuccessful";
			// AddInfo("Remove Selected Internal PIN Notes - UnSuccessful");
			// return 0;
			// }
			boolean intRet = false;
			// Retrieve actual error message from the screen
			String strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				// if (intRet == "Warning") {
				// PropertyDetail_Edit_InternalPINNotes_Remove = "Warning";
				// }
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Remove Selected Internal PIN Notes - Successful");
			PropertyDetail_Edit_InternalPINNotes_Remove = true;
			return PropertyDetail_Edit_InternalPINNotes_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void clickTabBulkLink(String tabname) {
		switch (tabname.toUpperCase()) {
		case "DESCRIPTION":
			propertyDetailPage.Description_bulk_Link.click();
			break;
		case "DOCUMENTS":
			propertyDetailPage.Documents_bulk_Link.click();
			break;
		case "INTERNALPINNOTES":
			propertyDetailPage.InternalPINNotes_bulk_Link.click();
			break;
		case "OWNERS":
			propertyDetailPage.Owners_bulk_Link.click();
			break;
		case "PENDINGBULKEDITS":
			propertyDetailPage.PendingBulkEdits_bulk_Link.click();
			break;
		case "PROPERTYREMARKS":
			propertyDetailPage.PropertyRemarks_bulk_Link.click();
			break;
		}
	}

	public boolean PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs(String strAction) {
		boolean PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs = false;
		try {
			String strStepName = "PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs";

			String strButtonName = null;
			switch (strAction.toUpperCase()) {
			case "DELETEALLPINS":
				strButtonName = "Delete All PINs";
				break;
			case "UNDODELETEALLPINS":
				strButtonName = "Undo Delete All PINs";
				break;
			default:
				return PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs;
			}
			// oDesc("name").value()=strButtonName;
			// Set web button object
			List<WebElement> oWebButton = propertyMaintenancePage.getDriver().findElements(By.xpath(
					"//TR/TD[contains(text(),'Description Documents Owners Property Remarks Registration NumberThis PIN onlyAction For All PINs Document')]/DIV[1]/TABLE[1]//*[text(),'" + strButtonName + "']"));
			// Retrieve the count of web buttons
			int intButtonCount = oWebButton.size();
			// Report fail and exit function if no button found
			if (intButtonCount == 0) {
				// Reporter.reportEvent(Status.Failed,strStepName,"No <"+strButtonName+"> button found - UnSuccessful");
				// AddInfo("No <"+strButtonName+"> button found - UnSuccessful");
				return false;
			}
			for (int iLoop = 0; iLoop <= intButtonCount - 1; iLoop++) {
				// Click the button if not disabled
				if (Boolean.parseBoolean(oWebButton.get(iLoop).getAttribute("disabled")) == false) {
					oWebButton.get(iLoop).click();
				}
			}
			PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs = true;
			return PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Documents_DeleteOrUndoDelete_AllPIINs;
		}
	}

	public boolean PropertyDetail_CorrectionNotice_AddNotice(String shtName, int intRow) {
		boolean PropertyDetail_CorrectionNotice_AddNotice = false;
		try {
			String strStepName = "PropertyDetail_CorrectionNotice_AddNotice";

			// Declare variables
			// Set focus
			// Fetch data
			String strNotice = GetValueIfValid("Notice", shtName, intRow);
			// Initialization
			// environmentlib.Value("Test","bTriggered",false);
			// Fill data
			property_CorrectionNoticesPage.CorrectionNotice_WebEdit.sendKeys(strNotice);
			// Click Add New button
			property_CorrectionNoticesPage.AddNew_WebButton.click();
			String strTimeStamp = mainPage.TimeText_WebElement.getText();
			String[] arrTimeStamp = (strTimeStamp.trim()).split(" ");
			String strDate = arrTimeStamp[0].trim();
			// Retrieve the user
			String strUser = mainPage.UserText_WebElement.getText().trim();
			// Declare and re-assemble the Notice
			String strExpectedNotice = "Correction: " + strNotice + " On " + strDate + " By " + strUser.toUpperCase();
			// Post the expected notice to the datasheet for later possible verification
			setTestData("AutoGeneratedNotice", shtName, intRow, strExpectedNotice);
			// Verify the added notice

			PropertyDetail_CorrectionNotice_AddNotice = true;
			return PropertyDetail_CorrectionNotice_AddNotice;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_Owners_Add(String shtName, int intRow) {
		boolean PropertyDetail_Edit_Owners_Add = true;
		try {
			String strStepName = "PropertyDetail_Edit_Owners_Add";
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strOwnersIndex = GetValueIfValid("OwnersIndex", shtName, intRow);
			String strName = GetValueIfValid("Name", shtName, intRow);
			String strShare = GetValueIfValid("Share", shtName, intRow);
			String strCapacity = GetValueIfValid("Capacity", shtName, intRow);
			String strFrench = GetValueIfValid("French", shtName, intRow);
			if (strPropertyIndex == "" || strPropertyIndex == "IGNORE_VALUE") {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			if (NumberUtils.isNumber(strOwnersIndex)) {
				int intOwnersIndex = Integer.parseInt(strOwnersIndex) - 1;
				propertyDetailPage.find(By.id("ownersForm[" + intPropertyIndex + "].name(" + intOwnersIndex + ")")).clear();
				propertyDetailPage.find(By.id("ownersForm[" + intPropertyIndex + "].name(" + intOwnersIndex + ")")).sendKeys(strName);
				propertyDetailPage.find(By.id("capacityFrenchIndicator" + intPropertyIndex + "_" + intOwnersIndex)).sendKeys(strFrench);
				setCheckBoxValueWithJS(propertyDetailPage.find(By.id("ownerCapacity" + intPropertyIndex + "_" + intOwnersIndex)), strCapacity);
				propertyDetailPage.find(By.id("ownersForm[" + intPropertyIndex + "].share(" + intOwnersIndex + ")")).clear();
				propertyDetailPage.find(By.id("ownersForm[" + intPropertyIndex + "].share(" + intOwnersIndex + ")")).sendKeys(strShare);
			}
			return PropertyDetail_Edit_Owners_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Edit_Owners_Add;
		}
	}

	public boolean PropertyDetail_Edit_Owners_Remove(String shtName, int intRow) {
		boolean PropertyDetail_Edit_Owners_Remove = false;
		try {
			String strStepName = "PropertyDetail_Edit_Owners_Remove";
			String strPropertyIndex = GetValueIfValid("PropertyIndex", shtName, intRow);
			String strOwnersIndex = GetValueIfValid("OwnersIndex", shtName, intRow);
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
			if (strPropertyIndex == "" || strPropertyIndex == "IGNORE_VALUE") {
				strPropertyIndex = "1";
			}
			int intPropertyIndex = Integer.parseInt(strPropertyIndex) - 1;
			int intStartIndex = 0;
			int intEndIndex = 0;
			String[] arrOwners = null;
			if (!strOwnersIndex.isEmpty() && !strOwnersIndex.equals("IGNORE_VALUE")) {
				if (strOwnersIndex.contains("-")) {
					arrOwners = (strOwnersIndex).split("-");
					intStartIndex = Integer.parseInt(arrOwners[0]);
					intEndIndex = Integer.parseInt(arrOwners[1]);
				} else {
					intStartIndex = Integer.parseInt(strOwnersIndex);
					intEndIndex = intStartIndex;
				}

				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					setCheckBoxValue(ownersPage.find(By.xpath("//*[@id='ownersForm[" + intPropertyIndex + "].ownersToRemove' and @value='" + (iLoop - 1) + "']")), "ON");
					ownersPage.RemoveSelected_WebButton.click();
					WaitUtil.waitMSeconds(1000);
				}
			}
			if (propertyDetailPage.BulkEdit_WebButton.isPresent()) {
			} else {
				propertyDetailPage.find(By.id("ownersForm[" + intPropertyIndex + "].remove")).click();
				propertyDetailPage.find(By.id("ownersForm.remove")).click();
			}
			VerifyApplicationError();
			boolean intRet = false;
			// Retrieve actual error message from the screen
			String strErrorMsgs = getCellData(ownersPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				return false;
			}
			PropertyDetail_Edit_Owners_Remove = true;
			return PropertyDetail_Edit_Owners_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Edit_Owners_CopyFromParentPIN(String shtName, int intRow) {
		boolean PropertyDetail_Edit_Owners_CopyFromParentPIN = false;
		try {
			String strStepName = "PropertyDetail_Edit_Owners_CopyFromParentPIN";

			// Initialization
			// environmentlib.Value("Test", "bTriggered", false);
			// Click the button
			ownersPage.CopyFromParentPIN_WebButton.click();
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, strStepName, "Click <Copy From Parent PIN> button - UnSuccessful");
			// AddInfo("Click <Copy From Parent PIN> button - UnSuccessful");
			// return 0;
			// }
			// Verify error message
			boolean intRet = false;
			// Retrieve actual error message from the screen
			String strErrorMsgs = getCellData(ownersPage.ErrorMsg_WebTable, 1, 1).trim();
			// Set focus
			// Retrieve expected error message from datasheet
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
			if (!strErrorMsgs.isEmpty()) {
				// Verify the error message
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				// if (intRet == "Warning") {
				// PropertyDetail_Edit_Owners_CopyFromParentPIN = "Warning";
				// }
				return false;
			}
			PropertyDetail_Edit_Owners_CopyFromParentPIN = true;
			return PropertyDetail_Edit_Owners_CopyFromParentPIN;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Proceed button on Property Detail page $shtName and $intRow")
	public boolean user_click_on_Proceed_button_on_Property_Detail_page(String shtName, int intRow) {
		boolean PropertyDetail_Proceed = false;
		try {
			String strStepName = "PropertyDetail_Proceed";
			boolean intRet = false;
			if (shtName != null && intRow >= 0) {
				intRet = PropertyDetail_EnterData_UsingDataMap(shtName, intRow);
				/*
				 * if (intRet == false) { logSteps.execution_log("Edit details of one or more tabs - UnSuccessful"); return PropertyDetail_Proceed; }
				 */
			}
			propertyDetailPage.Proceed_WebButton.click();
			WaitUtil.waitMSeconds(2000);
			/*
			 * String strErrorMsgs = propertyDetailPage.ErrorMsg_WebTable.getText().trim(); if (!strErrorMsgs.equals("")) { if (shtName != null && intRow >= 0) { String strExpErrMsgs = GetValueIfValid("ErrorMessages", shtName, intRow).trim(); intRet = VerifyErrorMessage(strStepName, strErrorMsgs,
			 * strExpErrMsgs); if (intRet == false) { PropertyDetail_Proceed = false; } } else { logSteps.execution_log("Unexpected error message is returned as shown above - UnSuccessful"); } return PropertyDetail_Proceed; } String strFunction = mainPage.FuncID_WebElement.getText(); if
			 * (strFunction.contains("Correct/Update Certified Property")) { if (!correctUpdateCertifiedPropertyPage.ConfirmationHeader_WebElement.isPresent()) { logSteps.execution_log("<Correct/Update Certified Property> confirmation page Not displayed - UnSuccessful"); } else {
			 * logSteps.execution_log("<Correct/Update Certified Property> confirmation page displayed - Successful"); PropertyDetail_Proceed = true; } return PropertyDetail_Proceed; } if (!printParcelPage.PrintParcel_WebElement.isPresent()) {
			 * logSteps.execution_log("The <Print Parcel> page NOT displayed - UnSuccessful"); return PropertyDetail_Proceed; }
			 */
			PropertyDetail_Proceed = true;
			return PropertyDetail_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Proceed;
		}
	}

	@When("user click on the OK button on the Cancel on Property Detail page")
	public boolean userclick_onthe_OKbutton() {
		try {
			String strStepName = "PropertyDetail_CancelCancel";
			boolean PropertyDetail_CancelCancel = false;
			boolean intRet = false;
			propertyDetailPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			PropertyDetail_CancelCancel = true;
			return PropertyDetail_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@When("user clicks on the Proceed button on property detail page $SHEET and $ROW")
	public boolean PropertyDetail_Proceed(String SHEET, int ROW) {
		boolean PropertyDetail_Proceed = false;
		try {
			String strStepName = "PropertyDetail_Proceed";
			boolean intRet = false;
			if (SHEET != null && ROW >= 0) {
				intRet = PropertyDetail_EnterData_UsingDataMap(SHEET, ROW);

			}
			propertyDetailPage.Proceed_WebButton.click();
			String strErrorMsgs = propertyDetailPage.ErrorMsg_WebTable.getText().trim();
			if (!strErrorMsgs.equals("")) {

				if (SHEET != null && ROW >= 0) {
					String strExpErrMsgs = GetValueIfValid("ErrorMessages", SHEET, ROW).trim();
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpErrMsgs);
				} else {
				}
				return PropertyDetail_Proceed;
			}
			String strFunction = mainPage.FuncID_WebElement.getText();
			if (strFunction.contains("Correct/Update Certified Property")) {
				if (!correctUpdateCertifiedPropertyPage.ConfirmationHeader_WebElement.isPresent()) {
				} else {
					PropertyDetail_Proceed = true;
				}
				return PropertyDetail_Proceed;
			}
			if (!printParcelPage.PrintParcel_WebElement.isPresent()) {
				return PropertyDetail_Proceed;
			}
			PropertyDetail_Proceed = true;
			return PropertyDetail_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Proceed;
		}

	}

	@When("user clicks on the Proceed button on property detail page")
	public boolean PropertyDetail_Proceed() {
		boolean PropertyDetail_Proceed = false;
		try {
			propertyDetailPage.Proceed_WebButton.click();
			String strErrorMsgs = propertyDetailPage.ErrorMsg_WebTable.getText().trim();
			String strFunction = mainPage.FuncID_WebElement.getText();
			if (strFunction.contains("Correct/Update Certified Property")) {
				if (!correctUpdateCertifiedPropertyPage.ConfirmationHeader_WebElement.isPresent()) {
				} else {
					PropertyDetail_Proceed = true;
				}
				return PropertyDetail_Proceed;
			}
			if (!printParcelPage.PrintParcel_WebElement.isPresent()) {
				return PropertyDetail_Proceed;
			}
			PropertyDetail_Proceed = true;
			return PropertyDetail_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return PropertyDetail_Proceed;
		}

	}

	@When("user clicks on Save button on PropertyDetail page for bulk edit $shtName and $intRow")
	public boolean PropertyDetail_BulkEdit_Save(String shtName, String intRow) {
		try {
			boolean PropertyDetail_BulkEdit_Save = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = PropertyDetail_BulkEdit_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
			}
			String strPreParentPIN = null;
			strPreParentPIN = propertyDetailPage.ParentPIN_WebElement.getText();
			propertyDetailPage.Save_WebButton.click();
			logSteps.execution_log("<Save> button is clicked");
			intRet = VerifyPage_PropertyDetail("Bulk Edit");
			String strActualParentPIN = null;
			strActualParentPIN = propertyDetailPage.ParentPIN_WebElement.getText();
			if (strComp(strActualParentPIN, strPreParentPIN) == 0) {
				logSteps.execution_log("Verification of <Parent PIN> before and after Save button clicked - UnSuccessful. Before: <" + strPreParentPIN + ">, After: <" + strActualParentPIN + ">");
				return false;
			}
			logSteps.execution_log("Verification of <" + strPreParentPIN + "> on <Property Detail> page - Successful");
			PropertyDetail_BulkEdit_Save = true;
			return PropertyDetail_BulkEdit_Save;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks single edit button on property details page")
	public boolean PropertyDetail_SingleEdit() {
		try {
			boolean PropertyDetail_SingleEdit = false;
			propertyDetailPage.SingleEdit_WebButton.click();
			logSteps.execution_log("<Single Edit> button is clicked");
			boolean intRet = false;
			String strEditMode = null;
			strEditMode = "Single Edit";
			intRet = VerifyPage_PropertyDetail(strEditMode);
			if (intRet == false) {
				logSteps.execution_log("Verification of <Property Detail Single Edit> page - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Verification of <Property Detail Single Edit> page - Successful");
			PropertyDetail_SingleEdit = true;
			return PropertyDetail_SingleEdit;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_EnterData_UsingDataMap(String shtName, int intRow) {
		try {
			boolean PropertyDetail_BulkEdit_EnterData_UsingDataMap = false;
			// Object oDataMap=null;
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();
			oDataMap.put("Description", "");
			oDataMap.put("Documents", "");
			oDataMap.put("Owners", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("CorrectionNotices", "");
			oDataMap.put("Managers", "");
			oDataMap.put("InternalPINNotes", "");
			oDataMap.put("PendingBulkEdits", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);
			for (int i = 0; i <= arrKeys.length - 1; i++) {
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, intRow).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}
			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				intRet = PropertyDetail_Navigate_To_Tab(strSheetName);
				switch (strSheetName.toUpperCase()) {
				case "DESCRIPTION":
					intRet = PropertyDetail_BulkEdit_Description(strSheetName, strRowNumber);
					break;
				case "DOCUMENTS":
					intRet = PropertyDetail_BulkEdit_Documents(strSheetName, strRowNumber);
					break;
				case "OWNERS":
					intRet = PropertyDetail_BulkEdit_Owners(strSheetName, strRowNumber);
					break;
				case "PROPERTYREMARKS":
					intRet = PropertyDetail_BulkEdit_PropertyRemarks(strSheetName, strRowNumber);
					break;
				case "CORRECTIONNOTICES":
					// intRet = PropertyDetail_BulkEdit_CorrectionNotices(strSheetName, strRowNumber);
					break;
				case "MANAGERS":
					// intRet = PropertyDetail_BulkEdit_Managers(strSheetName, strRowNumber);
					break;
				case "INTERNALPINNOTES":
					intRet = PropertyDetail_BulkEdit_InternalPINNotes(strSheetName, strRowNumber);
					break;
				case "PENDINGBULKEDITS":
					intRet = PropertyDetail_BulkEdit_PendingBulkEdits(strSheetName, strRowNumber);
					break;
				}
				if (intRet == false) {
					PropertyDetail_BulkEdit_EnterData_UsingDataMap = false;
				}
			}
			oDataMap = null;
			return PropertyDetail_BulkEdit_EnterData_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_PropertyDetail(String strEditMode) {
		boolean VerifyPage_PropertyDetail = false;
		try {
			if (!propertyDetailPage.FullDetails_WebElement.isPresent()) {
				logSteps.execution_log("<Property Detail> page Not displayed - UnSuccessful");
				return false;
			}
			String strFullDetails = null;
			strFullDetails = propertyDetailPage.FullDetails_WebElement.getText();
			strEditMode = strEditMode.toUpperCase();
			if (!(InStr(strFullDetails, strEditMode) > 0)) {
				logSteps.execution_log("<" + strEditMode + "> Not displayed on the <Property Detail> page - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Property Detail " + strEditMode + "> page displayed - Successful");
			VerifyPage_PropertyDetail = true;
			return VerifyPage_PropertyDetail;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Description(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Description = true;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Description";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				// intStart=Math.round(arrRows[0]);
				// intEnd=Math.round(arrRows[1]);
				intStart = Integer.parseInt(arrRows[0]);
				intEnd = Integer.parseInt(arrRows[1]);
			} else {
				intStart = Integer.parseInt(intRow);
				intEnd = intStart;
			}
			String strBlockNumber = null;
			String strEstate = null;
			String strQualifier = null;
			String strFrench = null;
			String strAppendOrReplace = null;
			String strApplyToAction = null;
			String strDescription = null;
			String strEasementAction = null;
			String strEasementIndex = null;
			String strLowerMunicipality = null;
			String strUpperMunicipality = null;
			strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			strEstate = GetValueIfValid("Estate", shtName, Integer.parseInt(intRow));
			strQualifier = GetValueIfValid("Qualifier", shtName, Integer.parseInt(intRow));
			strFrench = GetValueIfValid("French", shtName, Integer.parseInt(intRow));
			strAppendOrReplace = GetValueIfValid("AppendOrReplace", shtName, Integer.parseInt(intRow));
			strApplyToAction = GetValueIfValid("ApplyToAction", shtName, Integer.parseInt(intRow));
			strDescription = GetValueIfValid("Description", shtName, Integer.parseInt(intRow));
			strLowerMunicipality = GetValueIfValid("LowerMunicipality", shtName, Integer.parseInt(intRow));
			strUpperMunicipality = GetValueIfValid("UpperMunicipality", shtName, Integer.parseInt(intRow));
			// String oPage = null;
			boolean intRet = false;
			description_BulkEditPage.BlockNumber_WebEdit.clear();
			description_BulkEditPage.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			setCheckBoxValue(description_BulkEditPage.French_WebCheckBox, strFrench);
			description_BulkEditPage.Estate_WebList.selectByVisibleText(strEstate.toUpperCase());
			description_BulkEditPage.Qualifier_WebList.selectByVisibleText(strQualifier.toUpperCase());
			description_BulkEditPage.Description_WebEdit.clear();
			description_BulkEditPage.Description_WebEdit.sendKeys(strDescription);
			switch (strAppendOrReplace.toUpperCase()) {
			case "APPEND":
			case "A":
				description_BulkEditPage.Append_WebRadioGroup.click();
				break;
			case "REPLACE":
			case "R":
				description_BulkEditPage.Replace_WebRadioGroup.click();
				break;
			}
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strEasementAction = GetValueIfValid("EasementAction", shtName, Integer.parseInt(intRow));
				strEasementIndex = GetValueIfValid("EasementIndex", shtName, Integer.parseInt(intRow));
				if (!strEasementAction.isEmpty() && !strEasementAction.equals("IGNORE_VALUE")) {
					switch (strEasementAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_BulkEdit_Description_Easement_Add(shtName, String.valueOf(iLoop));
						break;
					case "FILL":
						intRet = PropertyDetail_BulkEdit_Description_Easement_Fill(shtName, String.valueOf(iLoop));
						break;
					case "REMOVE":
						intRet = PropertyDetail_BulkEdit_Description_Easement_Remove(strEasementIndex);
						break;
					}
					if (!intRet == true) {
						PropertyDetail_BulkEdit_Description = false;
					}
				}
			}
			description_BulkEditPage.LowerMunicipality_WebList.selectByVisibleText(strLowerMunicipality.toUpperCase());
			description_BulkEditPage.UpperMunicipality_WebList.selectByVisibleText(strUpperMunicipality.toUpperCase());
			switch (strApplyToAction.toUpperCase()) {
			case "APPLYTOALL":
			case "ALL":
				String strFunction = null;
				strFunction = mainPage.FuncID_WebElement.getText().trim();
				System.out.println(strFunction);
				if (strFunction.equalsIgnoreCase("Divide Single Property")) {
					description_BulkEditPage.ApplyToAll_Divide_WebButton.click();
				} else {
					description_BulkEditPage.ApplyToSome_Bulk_WebButton.click();
				}
				break;
			case "APPLYTOSOME":
			case "SOME":
				propertyRemarksPage.ApplyToSome_Bulk_WebButton.click();
				WaitUtil.waitMSeconds(3000);
				intRet = PropertyDetail_BulkEdit_ApplyToSome("Description", shtName, intRow);
				PropertyDetail_BulkEdit_Description = intRet;
				if (!intRet == true) {
					return false;
				}
				break;
			}
			// oPage = null;
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				} else {
					strExpectedMsgs = "";
				}
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					PropertyDetail_BulkEdit_Description = false;
				} else {
					PropertyDetail_BulkEdit_Description = false;
				}
				return false;
			}
			PropertyDetail_BulkEdit_Description = true;
			return PropertyDetail_BulkEdit_Description;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Description_Easement_Add(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Description_Easement_Add = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Description_Easement_Add";

			String strEasement = null;
			String strEasementIndex = null;
			strEasement = GetValueIfValid("Easement", shtName, Integer.parseInt(intRow));
			strEasementIndex = GetValueIfValid("EasementIndex", shtName, Integer.parseInt(intRow));
			description_BulkEditPage.EasementList_WebList.selectByVisibleText(strEasement.toUpperCase());
			description_BulkEditPage.Add_WebButton.click();
			boolean intRet = false;
			if (isNumeric(strEasementIndex)) {
				intRet = PropertyDetail_BulkEdit_Description_Easement_Fill(shtName, intRow);
			}
			PropertyDetail_BulkEdit_Description_Easement_Add = true;
			return PropertyDetail_BulkEdit_Description_Easement_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Description_Easement_Fill(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Description_Easement_Fill = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Description_Easement_Fill";
			String strEasement = null;
			String strEasementIndex = null;
			String strOver = null;
			String strFavorOf = null;
			String strUntil = null;
			String strAsIn = null;
			strEasement = GetValueIfValid("Easement", shtName, Integer.parseInt(intRow));
			strEasementIndex = GetValueIfValid("EasementIndex", shtName, Integer.parseInt(intRow));
			strOver = GetValueIfValid("Over", shtName, Integer.parseInt(intRow));
			strFavorOf = GetValueIfValid("FavorOf", shtName, Integer.parseInt(intRow));
			strUntil = GetValueIfValid("Until", shtName, Integer.parseInt(intRow));
			strAsIn = GetValueIfValid("AsIn", shtName, Integer.parseInt(intRow));
			int intEasementIndex;
			if (!isNumeric(strEasementIndex)) {
				logSteps.execution_log("No easement index number provided - UnSuccessful");
				PropertyDetail_BulkEdit_Description_Easement_Fill = false;
				return false;
			}
			intEasementIndex = Math.round(Integer.parseInt(strEasementIndex)) - 1;
			String oPage = null;
			switch (strEasement.toUpperCase()) {
			case "S/T EASE - EXISTING":
			case "CONDO PLAN - S/T AND T/W EASE":
			case "CONDO PLAN - S/T EASE ONLY":
			case "CONDO PLAN - T/W EASE ONLY":
				// .WebEdit(WebEdit"html id:=clauseSpec"+intEasementIndex+"_0").setValue(strAsIn);
				description_BulkEditPage.find(By.id("clauseSpec" + intEasementIndex + "_0")).sendKeys(strAsIn);
				break;
			case "S/T EASE - TIME LIMITED":
				// .WebEdit(WebEdit"html id:=clauseSpec"+intEasementIndex+"_0").setValue(strOver);
				description_BulkEditPage.find(By.id("clauseSpec " + intEasementIndex + "_0")).sendKeys(strOver);
				// .WebEdit("html id:=clauseSpec"&intEasementIndex&"_1").SetValue(strFavorOf)
				description_BulkEditPage.find(By.id("clauseSpec" + intEasementIndex + "_1")).sendKeys(strFavorOf);
				// .WebEdit("html id:=clauseSpec"&intEasementIndex&"_2").SetValue(strUntil)
				description_BulkEditPage.find(By.id("clauseSpec" + intEasementIndex + "_2")).sendKeys(strUntil);
				// .WebEdit("html id:=clauseSpec"&intEasementIndex&"_3").SetValue(strAsIn)
				description_BulkEditPage.find(By.id("clauseSpec" + intEasementIndex + "_3")).sendKeys(strAsIn);
				break;
			case "S/T EASE IN GROSS - NO TIME LIMIT":
				// .WebEdit(WebEdit"html id:=clauseSpec"+intEasementIndex+"_0").setValue(strOver);
				description_BulkEditPage.find(By.id("clauseSpec " + intEasementIndex + "_0")).sendKeys(strOver);
				// .WebEdit("html id:=clauseSpec"&intEasementIndex&"_1").SetValue(strAsIn)
				description_BulkEditPage.find(By.id("clauseSpec" + intEasementIndex + "_1")).sendKeys(strAsIn);
				break;
			}
			oPage = null;
			PropertyDetail_BulkEdit_Description_Easement_Fill = true;
			return PropertyDetail_BulkEdit_Description_Easement_Fill;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Description_Easement_Remove(String intEasementIndex) {
		boolean PropertyDetail_BulkEdit_Description_Easement_Remove = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Description_Easement_Remove";

			int intStartIndex = 0;
			int intEndIndex = 0;
			String arrEasementIndex = null;
			if (!intEasementIndex.isEmpty() && !intEasementIndex.equals("IGNORE_VALUE")) {
				if (InStr(intEasementIndex, "-") > 0) {
					String[] arrEasements = (intEasementIndex).split("-");
					intStartIndex = Math.round(Integer.parseInt(arrEasements[0]));
					intEndIndex = Math.round(Integer.parseInt(arrEasements[1]));
				} else {
					intStartIndex = Math.round(Integer.parseInt(intEasementIndex));
					intEndIndex = intStartIndex;
				}
				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					description_BulkEditPage.find(By.id("existingEasementRemove + (iLoop - 1)")).sendKeys("ON");
				}
			}
			description_BulkEditPage.Remove_WebButton.click();
			PropertyDetail_BulkEdit_Description_Easement_Remove = true;
			return PropertyDetail_BulkEdit_Description_Easement_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_ApplyToSome(String strTab, String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_ApplyToSome = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_ApplyToSome";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			boolean intRet = false;
			if (!propertyDetail_ApplyToSomePage.ApplyChanges_WebElement.isPresent()) {
				logSteps.execution_log("Enter data to <" + strTab + "> Tab - UnSuccessful");
				String strExpectedMsgs = null;
				String strErrorMsgs = null;
				strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				if (!strErrorMsgs.isEmpty()) {
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						PropertyDetail_BulkEdit_ApplyToSome = false;
					} else {
						PropertyDetail_BulkEdit_ApplyToSome = false;
					}
				} else {
					logSteps.execution_log("<Apply " + strTab + " Changes to Selected Properties> page Not displayed - UnSuccessful");
				}
				return false;
			}
			String strHeading = null;
			strHeading = propertyDetail_ApplyToSomePage.ApplyChanges_WebElement.getText();
			if (!(InStr(strHeading, strTab) > 0)) {
				logSteps.execution_log("The unexpected <" + strHeading + "> displayed - UnSuccessful, Expected: <Apply " + strTab + " Changes to Selected Properties>");
				return false;
			}
			String strChangesAction = null;
			strChangesAction = GetValueIfValid("ChangesAction", shtName, Integer.parseInt(intRow));
			String strMode = null;
			strMode = mainPage.Mode_WebElement.getText().trim();
			switch (strMode) {
			case "Online":
				intRet = PropertyDetail_BulkEdit_ApplyToSome_Online(shtName, intRow);
				break;
			case "Batch":
				intRet = PropertyDetail_BulkEdit_ApplyToSome_Batch(shtName, intRow);
				break;
			}
			if (intRet == false) {
				return false;
			}
			String strButton = null;
			switch (strChangesAction.toUpperCase()) {
			case "YES":
			case "Y":
				strButton = "Yes";
				break;
			case "NO":
			case "N":
				strButton = "No";
				break;
			default:
				return false;
			}
			propertyDetail_ApplyToSomePage.find(By.name(strButton)).click();
			intRet = VerifyPage_PropertyDetail("Bulk Edit");
			PropertyDetail_BulkEdit_ApplyToSome = intRet;
			return PropertyDetail_BulkEdit_ApplyToSome;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_ApplyToSome_Online(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_ApplyToSome_Online = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_ApplyToSome_Online";
			String strAffectedPropertyIndex = null;
			strAffectedPropertyIndex = GetValueIfValid("AffectedPropertyIndex", shtName, Integer.parseInt(intRow));
			String[] arrAffectedPropertyIndex = null;
			int intIndexStart = 0;
			int intIndexEnd = 0;
			if (!strAffectedPropertyIndex.isEmpty() && !strAffectedPropertyIndex.equals("IGNORE_VALUE")) {
				if (InStr(strAffectedPropertyIndex, "-") > 0) {
					arrAffectedPropertyIndex = (strAffectedPropertyIndex).split("-");
					intIndexStart = Math.round(Integer.parseInt(arrAffectedPropertyIndex[0]));
					intIndexEnd = Math.round(Integer.parseInt(arrAffectedPropertyIndex[1]));
				} else {
					intIndexStart = Math.round(Integer.parseInt(strAffectedPropertyIndex));
					intIndexEnd = intIndexStart;
				}
				propertyDetail_ApplyToSomePage.AffectedPropertyList_WebList.selectByVisibleText("#" + (intIndexStart - 1));
				if (intIndexEnd > intIndexStart) {
					for (int iLoop = intIndexStart; iLoop <= (intIndexEnd - 1); iLoop++) {
						// Browser("ELRS").Page("PropertyDetail_ApplyToSome").WebList("AffectedPropertyList").ExtendSelect("#" + iLoop);
						propertyDetail_ApplyToSomePage.AffectedPropertyList_WebList.selectByVisibleText("#" + iLoop);
					}
				}
			}
			PropertyDetail_BulkEdit_ApplyToSome_Online = true;
			return PropertyDetail_BulkEdit_ApplyToSome_Online;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_ApplyToSome_Batch(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_ApplyToSome_Batch = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_ApplyToSome_Batch";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strRowIDIndex = null;
			String strRowFrom = null;
			String strRowTo = null;
			String strAddMoreRows = null;
			boolean intRet = false;
			int intIndex = 0;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strRowIDIndex = GetValueIfValid("RowIDIndex", shtName, Integer.parseInt(intRow));
				strRowFrom = GetValueIfValid("RowFrom", shtName, Integer.parseInt(intRow));
				strRowTo = GetValueIfValid("RowTo", shtName, Integer.parseInt(intRow));
				strAddMoreRows = GetValueIfValid("AddMoreRows", shtName, Integer.parseInt(intRow));
				if (strAddMoreRows.toUpperCase() == "YES") {
					intRet = PropertyDetail_PendingBulkEdit_Edit_AddMoreRows(shtName, String.valueOf(iLoop));
					if (intRet == false) {
						return false;
					}
				}
				if (isNumeric(strRowIDIndex)) {
					intIndex = Math.round(Integer.parseInt(strRowIDIndex)) - 1;
					// Browser("ELRS").Page("PendingBulkEdits").WebEdit("html id:=bulkTarget" + intIndex + "from").SetValue(strRowFrom);
					pendingBulkEditsPage.find(By.id("bulkTarget" + intIndex + "from")).sendKeys(strRowFrom);
					// Browser("ELRS").Page("PendingBulkEdits").WebEdit("html id:=bulkTarget" + intIndex + "to").SetValue(strRowTo);
					pendingBulkEditsPage.find(By.id("bulkTarget" + intIndex + "to")).sendKeys(strRowTo);
				}
			}
			PropertyDetail_BulkEdit_ApplyToSome_Batch = true;
			return PropertyDetail_BulkEdit_ApplyToSome_Batch;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PendingBulkEdit_Edit_AddMoreRows(String shtName, String intRow) {
		boolean PropertyDetail_PendingBulkEdit_Edit_AddMoreRows = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_PendingBulkEdit_Edit_AddMoreRows";
			String strLastRowIndex = null;
			strLastRowIndex = GetValueIfValid("LastRowIndex", shtName, Integer.parseInt(intRow));
			if (!pendingBulkEditsPage.AddMoreRows_WebButton.isPresent()) {
				logSteps.execution_log("<Add More Rows> button Not exist - UnSuccessful");
				return false;
			}
			pendingBulkEditsPage.AddMoreRows_WebButton.click();
			int intNewLastRowIndex = 0;
			int intIndex = 0;
			intNewLastRowIndex = Math.round(Integer.parseInt(strLastRowIndex)) + 2;
			intIndex = intNewLastRowIndex - 1;
			if (!pendingBulkEditsPage.find(By.id("bulkTarget" + intIndex + "from")).isPresent()) {
				logSteps.execution_log("Row <" + intNewLastRowIndex + "> Not exist after <Add More Rows> button clicked when the last row index was <" + strLastRowIndex + ">");
				return false;
			}
			PropertyDetail_PendingBulkEdit_Edit_AddMoreRows = true;
			return PropertyDetail_PendingBulkEdit_Edit_AddMoreRows;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Documents(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Documents = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Documents";
			String strFunction = null;
			boolean intRet;
			strFunction = mainPage.FuncID_WebElement.getText().trim();
			if (strComp(strFunction, "Condominium Amalgamation") == 0) {
				intRet = PropertyDetail_BulkEdit_Documents_CondoAmalgamation(shtName, intRow);
				PropertyDetail_BulkEdit_Documents = intRet;
			}
			String strAffectAction = null;
			String strDocumentAction = null;
			String strRegNumber = null;
			String strRegDate = null;
			strAffectAction = GetValueIfValid("AffectAction", shtName, Integer.parseInt(intRow));
			strDocumentAction = GetValueIfValid("DocumentAction", shtName, Integer.parseInt(intRow));
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			strRegDate = GetValueIfValid("RegDate", shtName, Integer.parseInt(intRow));
			String oPage = null;
			if (strDocumentAction.toUpperCase().equalsIgnoreCase("ADD")) {
				documents_BulkEditPage.RegNumber_WebEdit.sendKeys(strRegNumber);
				documents_BulkEditPage.RegDate_WebEdit.sendKeys(strRegDate);
				documents_BulkEditPage.Add_WebButton.click();
				String strErrorMsgs = null;
				String strExpectedMsgs = null;
				strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.isEmpty()) {
					logSteps.execution_log("Enter data to <Documents> page - Successful");
					if (!shtName.isEmpty() && !intRow.isEmpty()) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					} else {
						strExpectedMsgs = "";
					}
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						PropertyDetail_BulkEdit_Documents = false;
					}
					return false;
				}
			}
			switch (strAffectAction.toUpperCase()) {
			case "EVERY":
			case "EVERYDOCUMENTAFFECTS":
			case "APPLYTOALL":
				documents_BulkEditPage.EveryDocumentAffects_WebButton.click();
				break;
			case "ALL":
			case "AFFECTALL":
				documents_BulkEditPage.AffectAll_WebButton.click();
				break;
			case "SOME":
			case "AFFECTSOME":
				documents_BulkEditPage.AffectSome_WebButton.click();
				break;
			case "NONE":
			case "AFFECTNONE":
				documents_BulkEditPage.AffectNone_WebButton.click();
				break;
			}
			oPage = null;
			logSteps.execution_log("Enter data to <Documents> page - Successful");
			PropertyDetail_BulkEdit_Documents = true;
			return PropertyDetail_BulkEdit_Documents;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Documents_CondoAmalgamation";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strAffectAction = null;
			String strDocumentAction = null;
			String strRemoveFromPropertiesAction = null;
			boolean intRet;
			intRet = true;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strAffectAction = GetValueIfValid("AffectAction", shtName, iLoop);
				strDocumentAction = GetValueIfValid("DocumentAction", shtName, iLoop);
				strRemoveFromPropertiesAction = GetValueIfValid("RemoveFromPropertiesAction", shtName, iLoop);
				switch (strDocumentAction.toUpperCase()) {
				case "ADD":
					intRet = PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add(shtName, String.valueOf(iLoop));
					break;
				case "REMOVE":
					intRet = PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove(shtName, String.valueOf(iLoop));
					break;
				}
				if (intRet == false) {
					PropertyDetail_BulkEdit_Documents_CondoAmalgamation = false;
					return false;
				}
				if (intRet == false) {
					PropertyDetail_BulkEdit_Documents_CondoAmalgamation = false;
					return false;
				}
			}
			switch (strAffectAction.toUpperCase()) {
			case "REMOVEFROMPROPERTIES":
			case "REMOVE FROM PROPERTIES":
				intRet = PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties(strRemoveFromPropertiesAction);
				PropertyDetail_BulkEdit_Documents_CondoAmalgamation = intRet;
				break;
			case "":
			case "IGNORE_VALUE":
				PropertyDetail_BulkEdit_Documents_CondoAmalgamation = true;
				break;
			}
			PropertyDetail_BulkEdit_Documents_CondoAmalgamation = true;
			return PropertyDetail_BulkEdit_Documents_CondoAmalgamation;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add";
			String strDocumentIndex = null;
			String strRegNumber = null;
			String strRegDate = null;
			strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, Integer.parseInt(intRow));
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			strRegDate = GetValueIfValid("RegDate", shtName, Integer.parseInt(intRow));
			if (!isNumeric(strDocumentIndex)) {
				// Reporter.reportEvent(Status.Warning,strStepName,"No document index number provided - UnSuccessful");
				// AddInfo("No document index number provided - UnSuccessful");
				return false;
			}
			String oPage = null;
			int intDocumentIndex = 0;

			intDocumentIndex = Math.round(Integer.parseInt(strDocumentIndex)) - 1;
			// oPage.WebEdit("name:=bulkForm/.docBeingRemoved/["+intDocumentIndex+"/]/.docNumber").SetValue(strRegNumber);
			documents_BulkEditPage.find(By.name("bulkForm.docBeingRemoved[" + intDocumentIndex + "].docNumber")).sendKeys(strRegNumber);
			// oPage.WebEdit("name:=bulkForm/.docBeingRemoved/["+intDocumentIndex+"/]/.date").SetValue(strRegDate);
			documents_BulkEditPage.find(By.name("bulkForm.docBeingRemoved[" + intDocumentIndex + "].date")).sendKeys(strRegDate);
			PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add = true;
			return PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove";
			String strDocumentIndex = null;
			String strExpectedMsgs = null;
			strDocumentIndex = GetValueIfValid("DocumentIndex", shtName, Integer.parseInt(intRow));
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String[] arrDocuments = null;
			int intStartIndex = 0;
			int intEndIndex = 0;
			if (!strDocumentIndex.isEmpty() && !strDocumentIndex.equals("IGNORE_VALUE")) {
				if (InStr(strDocumentIndex, "-") > 0) {
					arrDocuments = (strDocumentIndex).split("-");
					intStartIndex = Math.round(Integer.parseInt(arrDocuments[0]));
					intEndIndex = Math.round(Integer.parseInt(arrDocuments[1]));
				} else {
					intStartIndex = Math.round(Integer.parseInt(strDocumentIndex));
					intEndIndex = intStartIndex;
				}
				String oDesc = null;
				/*
				 * oDesc = Description.Create; for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) { oDesc("html id").value() = "bulkForm/.docsToRemove"; oDesc("value").value() = iLoop - 1; // Check the specified checkbox documents_BulkEditPage.oDesc_webcheckbox.sendKeys("ON"); } oDesc = null;
				 */
			}
			// Click Remove Selected button
			documents_BulkEditPage.RemoveSelected_WebButton.click();
			String strErrorMsgs = null;
			boolean intRet = false;
			strErrorMsgs = getCellData(documents_BulkEditPage.ErrorMsg_WebTable, 1, 1).trim();
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove = false;
				}
				return false;
			}
			PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove = true;
			return PropertyDetail_BulkEdit_Documents_CondoAmalgamation_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties(String strButton) {
		boolean PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties";
			documents_BulkEditPage.RemovefromProperties_WebButton.click();
			logSteps.execution_log("<Remove from Properties> button is clicked");

			String strConfirmationMsg = null;
			String strExpectedMsg = null;
			// strConfirmationMsg = Browser("ELRS").Dialog("MessageFromWebPage_Popup").Static("ConfirmationMsg").GetROProperty("text").trim();
			strExpectedMsg = "Documents will be removed from the properties regardless. No Bulk Edits will be generated. However, the change is not saved if you explicitly cancel it from <Close> button. Continue?";
			if (!(strComp(strConfirmationMsg, strExpectedMsg) == 0)) {
				// AddInfo("Unexpected confirmation message is returned as shown above. Expected message: <" + strExpectedMsg + "> - UnSuccessful");
				PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties = false;
			} else {
				// AddInfo("Expected confirmation message is returned as shown above - Successful");
			}
			String strPreRegNumber = null;
			String strPreRegDate = null;
			String strButtonName = null;
			boolean intRet = false;
			switch (strButton.toUpperCase()) {
			case "OK":
				strButtonName = "OK";
				break;
			case "CANCEL":
				strButtonName = "Cancel";
				strPreRegNumber = documents_BulkEditPage.find(By.name("bulkForm.docBeingRemoved[0].docNumber")).getAttribute("value").trim();
				strPreRegDate = documents_BulkEditPage.find(By.name("bulkForm.docBeingRemoved[0].date")).getAttribute("value").trim();
				break;
			default:
				// AddInfo("UnKnown button name <" + strButton + "> provided - UnSuccessful");
				PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties = false;
				return false;
			}
			// Browser("ELRS").Dialog("MessageFromWebPage_Popup").WinButton(strButtonName).Click;
			// Alert alert= mainPage.getDriver().switchTo().alert();
			// alert.accept();
			// AddInfo("<" + strButtonName + "> button is clicked on the confirmation popup");
			switch (strButton.toUpperCase()) {
			case "OK":
				intRet = VerifyPage_Documents_RemoveFromProperties_OK();
				break;
			case "CANCEL":
				intRet = VerifyPage_Documents_RemoveFromProperties_Cancel(strPreRegNumber, strPreRegDate);
				break;
			}
			PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties = intRet;
			return PropertyDetail_BulkEdit_Documents_CondoAmalgamation_RemoveFromProperties;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_Documents_RemoveFromProperties_OK() {
		boolean VerifyPage_Documents_RemoveFromProperties_OK = false;
		try {
			String strStepName = null;
			strStepName = "VerifyPage_Documents_RemoveFromProperties_OK";
			String strRegNumber = null;
			String strRegDate = null;
			for (int iLoop = 1; iLoop <= 2; iLoop++) {
				strRegNumber = documents_BulkEditPage.find(By.name("bulkFormdocBeingRemovediLoop1docNumber")).getAttribute("value").trim();
				strRegDate = documents_BulkEditPage.find(By.name("bulkFormdocBeingRemoved0date")).getAttribute("value").trim();
				if (!strRegNumber.isEmpty()) {
					// AddInfo("Retistration Number <" + strRegNumber + "> displayed on the <" + iLoop + "> row - UnSuccessful");
					VerifyPage_Documents_RemoveFromProperties_OK = false;
				}
				if (!strRegDate.isEmpty()) {
					// AddInfo("Registration Date <" + strRegDate + "> displayed on the <" + iLoop + "> row - UnSuccessful");
					VerifyPage_Documents_RemoveFromProperties_OK = false;
				}
			}
			if (VerifyPage_Documents_RemoveFromProperties_OK == false) {
				// AddInfo("Remove documents from properties - UnSuccessful");
				return false;
			}
			// AddInfo("No document displayed on the page. Verification of the page - Successful");
			VerifyPage_Documents_RemoveFromProperties_OK = true;
			return VerifyPage_Documents_RemoveFromProperties_OK;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPage_Documents_RemoveFromProperties_Cancel(String strExpectedRegNumber, String strExpectedRegDate) {
		boolean VerifyPage_Documents_RemoveFromProperties_Cancel = false;
		try {
			String strStepName = null;
			strStepName = "VerifyPage_Documents_RemoveFromProperties_Cancel";
			String strRegNumber = null;
			String strRegDate = null;
			strRegNumber = documents_BulkEditPage.find(By.name("bulkFormdocBeingRemoved0docNumber")).getAttribute("value").trim();
			strRegDate = documents_BulkEditPage.find(By.name("bulkFormdocBeingRemoved0date")).getAttribute("value").trim();
			if (!(strComp(strRegNumber, strExpectedRegNumber) == 0)) {
				if (!(strComp(strRegDate, strExpectedRegDate) == 0)) {
					// AddInfo("The expected Registration Number:<" + strExpectedRegNumber + "> and Registration Date:<" + strRegDate + "> Not exist - UnSuccessful");
				} else {
					// AddInfo("The expected Registration Number:<" + strExpectedRegNumber + "> Not exist, but Registration Date:<" + strRegDate + "> displayed - UnSuccessful");
				}
				return false;
			}
			if (!(strComp(strRegDate, strExpectedRegDate) == 0)) {
				// AddInfo("The expected Registration Number:<" + strExpectedRegNumber + "> displayed, but the Registration Date:<" + strRegDate + "> Not exist - UnSuccessful");
				return false;
			}
			// AddInfo("Verification of the listed documents - Successful");
			VerifyPage_Documents_RemoveFromProperties_Cancel = true;
			return VerifyPage_Documents_RemoveFromProperties_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Owners(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Owners = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Owners";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strOwnersAction = null;
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strOwnersAction = GetValueIfValid("OwnersAction", shtName, iLoop);
				if (!strOwnersAction.isEmpty() && !strOwnersAction.equals("IGNORE_VALUE")) {
					switch (strOwnersAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_BulkEdit_Owners_Add(shtName, String.valueOf(iLoop));
						break;
					case "REMOVE":
						intRet = PropertyDetail_BulkEdit_Owners_Remove(shtName, String.valueOf(iLoop));
						break;
					case "ADDMORE":
						ownersPage.MoreNames_WebButton.click();
						intRet = PropertyDetail_BulkEdit_Owners_Add(shtName, String.valueOf(iLoop));
						break;
					}
				}
			}

			String strApplyToAction = GetValueIfValid("ApplyToAction", shtName, Integer.parseInt(intRow));
			switch (strApplyToAction.toUpperCase()) {
			case "APPLYTOALL":
			case "ALL":
				ownersPage.ApplyToAll_WebButton.click();
				break;
			case "APPLYTOSOME":
			case "SOME":
				ownersPage.ApplyToSome_WebButton.click();
				intRet = PropertyDetail_BulkEdit_ApplyToSome("Owner", shtName, String.valueOf(intStart));
				PropertyDetail_BulkEdit_Owners = intRet;
				break;
			}
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				} else {
					strExpectedMsgs = "";
				}
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
			}
			PropertyDetail_BulkEdit_Owners = true;
			return PropertyDetail_BulkEdit_Owners;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Owners_Add(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Owners_Add = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Owners_Add";
			String oPage = null;
			String strOwnersIndex = null;
			String strName = null;
			String strCapacity = null;
			String strShare = null;
			String strFrench = null;
			int intOwnersIndex;
			String strButtonName = null;
			strOwnersIndex = GetValueIfValid("OwnersIndex", shtName, Integer.parseInt(intRow));
			strName = GetValueIfValid("Name", shtName, Integer.parseInt(intRow));
			strShare = GetValueIfValid("Share", shtName, Integer.parseInt(intRow));
			strCapacity = GetValueIfValid("Capacity", shtName, Integer.parseInt(intRow));
			strFrench = GetValueIfValid("French", shtName, Integer.parseInt(intRow));
			if (isNumeric(strOwnersIndex)) {
				intOwnersIndex = Math.round(Integer.parseInt(strOwnersIndex)) - 1;
				ownersPage.find(By.id("bulkForm.owner[" + intOwnersIndex + "].name")).clear();
				ownersPage.find(By.id("bulkForm.owner[" + intOwnersIndex + "].name")).sendKeys(strName);
				setCheckBoxValue(ownersPage.find(By.id("capacityFrenchIndicator" + intOwnersIndex)), strFrench);
				ownersPage.find(By.id("ownerCapacity" + intOwnersIndex)).selectByVisibleText(strCapacity);
				ownersPage.find(By.id("bulkForm.owner[" + intOwnersIndex + "].share")).clear();
				ownersPage.find(By.id("bulkForm.owner[" + intOwnersIndex + "].share")).sendKeys(strShare);
			}
			oPage = null;
			return PropertyDetail_BulkEdit_Owners_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_Owners_Remove(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Owners_Remove = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Owners_Remove";
			String strOwnersIndex = null;
			strOwnersIndex = GetValueIfValid("OwnersIndex", shtName, Integer.parseInt(intRow));
			int intStartIndex = 0;
			int intEndIndex = 0;
			String[] arrOwners = null;
			String iLoop = null;
			if (!strOwnersIndex.isEmpty() && !strOwnersIndex.equals("IGNORE_VALUE")) {
				if (InStr(strOwnersIndex, "-") > 0) {
					arrOwners = (strOwnersIndex).split("-");
					intStartIndex = Math.round(Integer.parseInt(arrOwners[0]));
					intEndIndex = Math.round(Integer.parseInt(arrOwners[1]));
				} else {
					intStartIndex = Math.round(Integer.parseInt(strOwnersIndex));
					intEndIndex = intStartIndex;
				}
			}
			// Description for checkbox
			/*
			 * Object oDesc = null; oDesc = Description.Create; for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) { oDesc("html id").value() = "bulkForm/.ownersToRemove"; oDesc("value").value() = iLoop - 1; // Check the specified checkbox ownersPage.oDesc_webcheckbox.sendKeys("ON"); } oDesc = null;
			 * }
			 */
			// Click Remove Selected button
			ownersPage.RemoveSelected_Bulk_WebButton.click();
			PropertyDetail_BulkEdit_Owners_Remove = true;
			return PropertyDetail_BulkEdit_Owners_Remove;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PropertyRemarks(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PropertyRemarks = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PropertyRemarks";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strInterestAction = null;
			String strOtherRemarks = null;
			String strAppendOrReplace = null;
			String strApplyToAction = null;
			strOtherRemarks = GetValueIfValid("OtherRemarks", shtName, Integer.parseInt(intRow));
			strAppendOrReplace = GetValueIfValid("AppendOrReplace", shtName, Integer.parseInt(intRow));
			strApplyToAction = GetValueIfValid("ApplyToAction", shtName, Integer.parseInt(intRow));
			boolean intRet = false;
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strInterestAction = GetValueIfValid("InterestAction", shtName, Integer.parseInt(intRow));
				if (!strInterestAction.isEmpty() && !strInterestAction.equals("IGNORE_VALUE")) {
					switch (strInterestAction.toUpperCase()) {
					case "ADD":
						intRet = PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add(shtName, String.valueOf(iLoop));
						break;
					case "REMOVE":
						intRet = PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove(shtName, String.valueOf(iLoop));
						break;
					case "FILL":
						intRet = PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill(shtName, String.valueOf(iLoop));
						break;
					}
					if (!intRet == true) {
						PropertyDetail_BulkEdit_PropertyRemarks = false;
					}
				}
			}
			propertyRemarksPage.OtherRemarks0_WebEdit.clear();
			propertyRemarksPage.OtherRemarks0_WebEdit.sendKeys(strOtherRemarks);
			switch (strAppendOrReplace.toUpperCase()) {
			case "APPEND":
			case "A":
				propertyRemarksPage.Append_WebRadioGroup.click();
				break;
			case "REPLACE":
			case "R":
				propertyRemarksPage.Replace_WebRadioGroup.click();
				break;
			}
			switch (strApplyToAction.toUpperCase()) {
			case "APPLYTOALL":
			case "ALL":
				String strFunction = null;
				strFunction = mainPage.FuncID_WebElement.getText().trim();
				if (strFunction.equalsIgnoreCase("Divide Single Property")) {
					propertyRemarksPage.ApplyToAll_Divide_WebButton.click();
				} else {
					propertyRemarksPage.ApplyToSome_Bulk_WebButton.click();
				}
				break;
			case "APPLYTOSOME":
			case "SOME":
				propertyRemarksPage.ApplyToSome_Bulk_WebButton.click();
				WaitUtil.waitMSeconds(3000);
				intRet = PropertyDetail_BulkEdit_ApplyToSome("Remark", shtName, intRow);
				PropertyDetail_BulkEdit_PropertyRemarks = intRet;
				if (!intRet == true) {
					return false;
				}
				break;
			}
			String strFunction = mainPage.FuncID_WebElement.getText().trim();
			if (strComp(strFunction, "Correct/Update") == 0) {
				PropertyDetail_BulkEdit_PropertyRemarks = true;
				return false;
			}
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				} else {
					strExpectedMsgs = "";
				}
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					PropertyDetail_BulkEdit_PropertyRemarks = false;
				} else {
					PropertyDetail_BulkEdit_PropertyRemarks = false;
				}
				return false;
			}
			PropertyDetail_BulkEdit_PropertyRemarks = true;
			return PropertyDetail_BulkEdit_PropertyRemarks;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add";
			String strInterest = null;
			String strInterestIndex = null;
			strInterest = GetValueIfValid("Interest", shtName, Integer.parseInt(intRow));
			strInterestIndex = GetValueIfValid("InterestIndex", shtName, Integer.parseInt(intRow));
			if (!strInterest.isEmpty() || !strInterest.equals("IGNORE_VALUE")) {
				// Browser("ELRS").Page("PropertyRemarks").WebList("InterestList").SelectItem(strInterest.toUpperCase());
				propertyRemarksPage.InterestList_WebList.selectByVisibleText(strInterest.toUpperCase());
				propertyRemarksPage.Add_WebButton.click();
			}
			boolean intRet = false;
			if (isNumeric(strInterestIndex)) {
				intRet = PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill(shtName, intRow);
			}
			PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add = true;
			return PropertyDetail_BulkEdit_PropertyRemarks_Interest_Add;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill";
			String strInterest = null;
			String strInterestIndex = null;
			strInterest = GetValueIfValid("Interest", shtName, Integer.parseInt(intRow));
			strInterestIndex = GetValueIfValid("InterestIndex", shtName, Integer.parseInt(intRow));
			String strDebtsOf = null;
			String strSpouseOf = null;
			String strExecutionFrom = null;
			String strExecutionTo = null;
			String strAsIn = null;
			strDebtsOf = GetValueIfValid("DebtsOf", shtName, Integer.parseInt(intRow));
			strSpouseOf = GetValueIfValid("SpouseOf", shtName, Integer.parseInt(intRow));
			strExecutionFrom = GetValueIfValid("ExecutionFrom", shtName, Integer.parseInt(intRow));
			strExecutionTo = GetValueIfValid("ExecutionTo", shtName, Integer.parseInt(intRow));
			strAsIn = GetValueIfValid("AsIn", shtName, Integer.parseInt(intRow));
			String oPage = null;

			if (isNumeric(strInterestIndex)) {
				int intInterestIndex;
				intInterestIndex = Math.round(Integer.parseInt(strInterestIndex)) - 1;
				switch (strInterest.toUpperCase()) {
				case "SUBJECT TO DEBTS":
					// .WebEdit(WebEdit"html id:=bulkoi"+intInterestIndex+"_1").setValue(strDebtsOf);
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_1")).sendKeys(strDebtsOf);
					// .WebEdit("html id:=bulkoi"&intInterestIndex&"_3").SetValue(strAsIn)
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO SPOUSAL RIGHTS":
					// .WebEdit(WebEdit"html id:=bulkoi"+intInterestIndex+"_1").setValue(strSpouseOf);
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_1")).sendKeys(strSpouseOf);
					// .WebEdit("html id:=bulkoi"&intInterestIndex&"_3").SetValue(strAsIn)
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_3")).sendKeys(strAsIn);
					break;
				case "SUBJECT TO WRIT OF EXECUTION":
					// .WebEdit(WebEdit"html id:=bulkoi"+intInterestIndex+"_1").setValue(strExecutionFrom);
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_1")).sendKeys(strExecutionFrom);
					// .WebEdit("html id:=bulkoi"&intInterestIndex&"_3").SetValue(strExecutionTo)
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_3")).sendKeys(strExecutionTo);
					// .WebEdit("html id:=bulkoi"&intInterestIndex&"_5").SetValue(strAsIn)
					propertyDetailPage.find(By.id("bulkoi" + intInterestIndex + "_5")).sendKeys(strAsIn);
					break;
				}
			}
			oPage = null;
			PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill = true;
			return PropertyDetail_BulkEdit_PropertyRemarks_Interest_Fill;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove";
			String strInterestIndex = null;
			strInterestIndex = GetValueIfValid("InterestIndex", shtName, Integer.parseInt(intRow));
			int intStartIndex;
			int intEndIndex;
			String[] arrInterests = null;
			if (!strInterestIndex.isEmpty() && !strInterestIndex.equals("IGNORE_VALUE")) {
				if (InStr(strInterestIndex, "-") > 0) {
					arrInterests = (strInterestIndex).split("-");
					intStartIndex = Math.round(Integer.parseInt(arrInterests[0]));
					intEndIndex = Math.round(Integer.parseInt(arrInterests[1]));
				} else {
					intStartIndex = Math.round(Integer.parseInt(strInterestIndex));
					intEndIndex = intStartIndex;
				}
				for (int iLoop = intStartIndex; iLoop <= intEndIndex; iLoop++) {
					// Check the specified checkbox
					// propertyRemarksPage.outerhtmlINPUTvalueiLoop1typecheckboxnamebulkFormoiToRemove_webcheckbox.sendKeys("ON");
					setCheckBoxValue(propertyRemarksPage.find(By.xpath("//input[@value=" + (iLoop - 1) + "and @name=bulkForm.oiToRemove]")), "ON");
				}
			}
			// Click the Remove Selected button
			propertyRemarksPage.RemoveSelected_Bulk_WebButton.click();
			// Reporter.reportEvent(Status.Passed, strStepName, "Remove Selected Outstanding Interest - Successful");
			PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove = true;
			return PropertyDetail_BulkEdit_PropertyRemarks_Interest_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_InternalPINNotes(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_InternalPINNotes = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_InternalPINNotes";
			String strAppendOrReplace = null;
			String strApplyToAction = null;
			String strInternalPINNotes = GetValueIfValid("InternalPINNotes", shtName, Integer.parseInt(intRow));
			strAppendOrReplace = GetValueIfValid("AppendOrReplace", shtName, Integer.parseInt(intRow));
			strApplyToAction = GetValueIfValid("ApplyToAction", shtName, Integer.parseInt(intRow));
			internalPINNotesPage.InternalPINNotes_WebEdit.sendKeys(strInternalPINNotes);
			switch (strAppendOrReplace.toUpperCase()) {
			case "APPEND":
			case "A":
				internalPINNotesPage.Append_WebRadioGroup.click();
				break;
			case "REPLACE":
			case "R":
				internalPINNotesPage.Replace_WebRadioGroup.click();
				break;
			}
			boolean intRet;
			switch (strApplyToAction.toUpperCase()) {
			case "APPLYTOALL":
			case "ALL":
				internalPINNotesPage.ApplyToAll_WebButton.click();
				break;
			case "APPLYTOSOME":
			case "SOME":
				internalPINNotesPage.ApplyToSome_WebButton.click();
				intRet = PropertyDetail_BulkEdit_ApplyToSome("Internal PIN Notes", shtName, intRow);
				PropertyDetail_BulkEdit_InternalPINNotes = intRet;
				if (!intRet == true) {
					return false;
				}
				break;
			}
			String strFunction = null;
			strFunction = mainPage.FuncID_WebElement.getAttribute("outertext").trim();
			if (strComp(strFunction, "Correct/Update") == 0) {
				PropertyDetail_BulkEdit_InternalPINNotes = true;
				return false;
			}
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				if (!shtName.isEmpty() && !intRow.isEmpty()) {
					strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
				} else {
					strExpectedMsgs = "";
				}
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					PropertyDetail_BulkEdit_InternalPINNotes = false;
				}
				return false;
			}
			PropertyDetail_BulkEdit_InternalPINNotes = true;
			return PropertyDetail_BulkEdit_InternalPINNotes;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PendingBulkEdits(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PendingBulkEdits = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PendingBulkEdits";
			String strPendingAction = null;
			strPendingAction = GetValueIfValid("PendingAction", shtName, Integer.parseInt(intRow));
			// strPendingItem = GetValueIfValid("PendingItem", shtName)
			// strPendingItemIndex = GetValueIfValid("PendingItemIndex", shtName)
			// Perform Remove/Edit action only when data provided
			if (strPendingAction.isEmpty() || strPendingAction.equals("IGNORE_VALUE")) {
				// Reporter.reportEvent(Status.Failed, strStepName, "No <PendingAction> provided. Please fill <Remove> or <Edit> in <PendingAction> column in worksheet <PendingBulkEdits>");
				// AddInfo("No <PendingAction> provided. Please fill <Remove> or <Edit> in <PendingAction> column in worksheet <PendingBulkEdits>");
				return false;
			}
			boolean intRet = false;
			switch (strPendingAction.toUpperCase()) {
			case "REMOVE":
			case "REMOVESELECTED":
			case "REMOVE SELECTED":
				int intPreCount = 0;
				intPreCount = getRowCount(pendingBulkEditsPage.PendingBulkEditsContent_WebTable);
				intRet = PropertyDetail_BulkEdit_PendingBulkEdit_Remove(String.valueOf(intPreCount), shtName, intRow);
				break;
			case "EDIT":
				intRet = PropertyDetail_BulkEdit_PendingBulkEdit_Edit(shtName, intRow);
				break;
			}
			PropertyDetail_BulkEdit_PendingBulkEdits = intRet;
			return PropertyDetail_BulkEdit_PendingBulkEdits;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_PendingBulkEdit_Remove(String intPreCount, String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PendingBulkEdit_Remove = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PendingBulkEdit_Remove";
			String strPendingItem = null;
			String strPendingItemIndex = null;
			boolean intRet;
			strPendingItem = GetValueIfValid("PendingItem", shtName, Integer.parseInt(intRow));
			strPendingItemIndex = GetValueIfValid("PendingItemIndex", shtName, Integer.parseInt(intRow));
			if (!strPendingItemIndex.isEmpty() && !strPendingItemIndex.equals("IGNORE_VALUE")) {
				intRet = PropertyDetail_PendingBulkEdit_SelectItemUsingIndex(strPendingItemIndex);
			} else if (!strPendingItem.isEmpty() && !strPendingItem.equals("IGNORE_VALUE")) {
				intRet = PropertyDetail_PendingBulkEdit_SelectItemUsingText(strPendingItem);
			} else {
				intRet = true;
			}
			pendingBulkEditsPage.Remove_WebButton.click();
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(pendingBulkEditsPage.ErrorMsg_WebTable, 1, 1).trim();
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			if (!strErrorMsgs.isEmpty()) {
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (intRet == false) {
					PropertyDetail_BulkEdit_PendingBulkEdit_Remove = false;
				}
				return false;
			}
			int intCurCount = 0;
			intCurCount = getRowCount(pendingBulkEditsPage.PendingBulkEditsContent_WebTable);
			if (!(intCurCount < Integer.parseInt(intPreCount))) {
				// Reporter.reportEvent(Status.Failed, strStepName, "The row counts of the pending bulk edits list is Not less than the counts before the Remove Selected button clicked - UnSuccessful");
				// AddInfo("The row counts of the pending bulk edits list is Not less than the counts before the Remove Selected button clicked - UnSuccessful");
				return false;
			}
			PropertyDetail_BulkEdit_PendingBulkEdit_Remove = true;
			return PropertyDetail_BulkEdit_PendingBulkEdit_Remove;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PendingBulkEdit_SelectItemUsingIndex(String strIndex) {
		boolean PropertyDetail_PendingBulkEdit_SelectItemUsingIndex = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_PendingBulkEdit_SelectItemUsingIndex";
			int intCount = 0;
			String[] arrIndex = null;
			if (InStr(strIndex, ";") > 0) {
				arrIndex = (strIndex).split(";");
				intCount = ubound(arrIndex);
			} else {
				// arrIndex = new Object[0];
				arrIndex[0] = strIndex;
				intCount = 0;
			}
			String strPendingItemIndex = null;
			boolean intRet = false;
			int intIndex = 0;
			environmentlib.setProperty("bTriggered", "false");
			for (int iLoop = 0; iLoop <= intCount; iLoop++) {
				strPendingItemIndex = arrIndex[iLoop].trim();
				intIndex = Math.round(Integer.parseInt(strPendingItemIndex)) - 1;
				setCheckBoxValue(pendingBulkEditsPage.find(By.id("removeBEI + intIndex")), "On");
			}
			PropertyDetail_PendingBulkEdit_SelectItemUsingIndex = true;
			return PropertyDetail_PendingBulkEdit_SelectItemUsingIndex;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PendingBulkEdit_SelectItemUsingText(String strItems) {
		boolean PropertyDetail_PendingBulkEdit_SelectItemUsingText = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_PendingBulkEdit_SelectItemUsingText";
			// Check if multiple items to be selected
			int intCount = 0;
			String[] arrItems = null;
			if (InStr(strItems, ";") > 0) {
				arrItems = (strItems).split(";");
				intCount = ubound(arrItems);
			} else {
				// arrItems = new arrItems[0];
				arrItems[0] = strItems;
				intCount = 0;
			}
			// Object iLoop = null;
			String strPendingItem = null;
			int intRet;
			int intIndex;
			for (int iLoop = 0; iLoop <= intCount; iLoop++) {
				strPendingItem = arrItems[iLoop].trim();
				intRet = LocatePendingItemIndex(strPendingItem);
				if (intRet == 0) {
					// Reporter.reportEvent(Status.Failed, strStepName, "The pending item with Type/Description <" + strPendingItem + "> Not found on the list - UnSuccessful");
					// AddInfo("The pending item with Type/Description <" + strPendingItem + "> Not found on the list - UnSuccessful");
					return false;
				}
				intIndex = intRet - 1;
				// Set the checkbox on beside the item
				setCheckBoxValue(pendingBulkEditsPage.find(By.id("removeBEI" + intIndex)), "On");
			}
			PropertyDetail_PendingBulkEdit_SelectItemUsingText = true;
			return PropertyDetail_PendingBulkEdit_SelectItemUsingText;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int LocatePendingItemIndex(String strItem) {
		int LocatePendingItemIndex = 0;
		try {
			String strStepName = null;
			strStepName = " LocatePendingItemIndex";

			String oWebTable = null;
			int intRowCount = 0;
			int intColCount = 0;

			// Count the rows and columns in the table
			intRowCount = getRowCount(pendingBulkEditsPage.PendingBulkEditsContent_WebTable);
			intColCount = getColumnCount(pendingBulkEditsPage.PendingBulkEditsContent_WebTable, 1);
			// Declare variables
			// int iRowLoop;
			// int iColLoop;
			String strCellData = null;
			String strItemIndex = null;
			String[] arrItemIndex = null;
			int intItemIndex = 0;
			// Locate the item in the table by looping all the rows and columns
			for (int iRowLoop = 1; iRowLoop <= intRowCount; iRowLoop++) {
				for (int iColLoop = 1; iColLoop <= intColCount; iColLoop++) {
					strCellData = getCellData(pendingBulkEditsPage.PendingBulkEditsContent_WebTable, iRowLoop, iColLoop);
					if (strComp(strCellData.trim(), strItem, 1) == 0) {
						// The order number of the item always on the 1st column in the format of 3.
						// strItemIndex = pendingBulkEditsPage.webtable_PendingBulkEditsContent.GetCellData(iRowLoop, 1);
						arrItemIndex = (strItemIndex.trim()).split(".");
						intItemIndex = Math.round(Integer.parseInt(arrItemIndex[0]));
						// Reporter.reportEvent(Status.Passed, strStepName, "The index number of item <" + strItem + "> is <" + intItemIndex + ">");
						// AddInfo "The index number of item <"&strItem& "> is <"&intItemIndex&">"
						LocatePendingItemIndex = intItemIndex;
						break;
					}
				}
			}
			return LocatePendingItemIndex;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean PropertyDetail_BulkEdit_PendingBulkEdit_Edit(String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_PendingBulkEdit_Edit = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_PendingBulkEdit_Edit";
			String strPendingItemIndex = null;
			String strRowIndex = null;
			String strRowFrom = null;
			String strRowTo = null;
			String strEditAction = null;
			strPendingItemIndex = GetValueIfValid("PendingItemIndex", shtName, Integer.parseInt(intRow));
			// strRowIndex = GetValueIfValid("RowIndex", shtName)
			// strRowFrom = GetValueIfValid("RowFrom", shtName)
			// strRowTo = GetValueIfValid("RowTo", shtName)
			strEditAction = GetValueIfValid("EditAction", shtName, Integer.parseInt(intRow));
			// Object intIndex = null;
			int intIndex = Integer.parseInt(strPendingItemIndex) - 1;
			// Report Fail if Edit button not exist
			if (!pendingBulkEditsPage.find(By.id("editRange" + intIndex)).isPresent()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Edit> button Not exist - UnSuccessful");
				// AddInfo("<Edit> button Not exist - UnSuccessful");
				return false;
			}
			// Click Edit button
			pendingBulkEditsPage.find(By.id("editRange" + intIndex)).click();
			// Verify the page
			if (!pendingBulkEditsPage.Header_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Apply Changes to Selected Properties> page Not displayed - UnSuccessful");
				// AddInfo("<Apply Changes to Selected Properties> page Not displayed - UnSuccessful");
				return false;
			}
			String strButton = null;
			boolean intRet;
			// Call appropiate function based on the different action provided
			switch (strEditAction.toUpperCase()) {
			case "YES":
				strButton = "Yes";
				intRet = PropertyDetail_PendingBulkEdit_Edit_YesNo(strButton, shtName, intRow);
				break;
			case "NO":
				strButton = "No";
				intRet = PropertyDetail_PendingBulkEdit_Edit_YesNo(strButton, shtName, intRow);
				break;
			default:
				// Reporter.reportEvent(Status.Failed, strStepName, "UnKnown edit action <" + strEditAction + "> provided - UnSuccessful");
				// AddInfo("UnKnown edit action <" + strEditAction + "> provided - UnSuccessful");
				return false;
			}
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Enter data to <Pending Bulk Edits> - UnSuccessful");
				// AddInfo("Enter data to <Pending Bulk Edits> - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "Enter data to <Pending Bulk Edits> - Successful");
			// AddInfo("Enter data to <Pending Bulk Edits> - Successful");
			PropertyDetail_BulkEdit_PendingBulkEdit_Edit = true;
			return PropertyDetail_BulkEdit_PendingBulkEdit_Edit;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_PendingBulkEdit_Edit_YesNo(String strButton, String shtName, String intRow) {
		boolean PropertyDetail_PendingBulkEdit_Edit_YesNo = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_PendingBulkEdit_Edit_YesNo";
			String strRowIDIndex = null;
			String strRowFrom = null;
			String strRowTo = null;
			String strAddMoreRows = null;
			strRowIDIndex = GetValueIfValid("RowIDIndex", shtName, Integer.parseInt(intRow));
			strRowFrom = GetValueIfValid("RowFrom", shtName, Integer.parseInt(intRow));
			strRowTo = GetValueIfValid("RowTo", shtName, Integer.parseInt(intRow));
			strAddMoreRows = GetValueIfValid("AddMoreRows", shtName, Integer.parseInt(intRow));
			boolean intRet;
			int intIndex = 0;
			if (strAddMoreRows.toUpperCase() == "YES") {
				intRet = PropertyDetail_PendingBulkEdit_Edit_AddMoreRows(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			if (isNumeric(strRowIDIndex)) {
				intIndex = Math.round(Integer.parseInt(strRowIDIndex)) - 1;
				// Browser("ELRS").Page("PendingBulkEdits").WebEdit("html id:=bulkTarget" + intIndex + "from").SetValue(strRowFrom);
				pendingBulkEditsPage.find(By.id("bulkTarget" + intIndex + "from")).sendKeys(strRowFrom);
				// Browser("ELRS").Page("PendingBulkEdits").WebEdit("html id:=bulkTarget" + intIndex + "to").SetValue(strRowTo);
				pendingBulkEditsPage.find(By.id("bulkTarget" + intIndex + "to")).sendKeys(strRowTo);
			}
			// Report Fail if Yes/No button not exist
			pendingBulkEditsPage.find(By.name(strButton)).click();
			PropertyDetail_PendingBulkEdit_Edit_YesNo = true;
			return PropertyDetail_PendingBulkEdit_Edit_YesNo;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on close button on Property Detail page")
	public boolean propertyDetail_Close() {
		try {
			boolean PropertyDetail_CancelCancel = false;
			boolean intRet = false;
			propertyDetailPage.Close_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			PropertyDetail_CancelCancel = true;
			return PropertyDetail_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Proceed or Apply Bulk Changes button on Property Detail page for online and batch mode $shtName and $intRow")
	public boolean PropertyDetail_BulkEdit_Proceed(String shtName, int intRow) {
		boolean PropertyDetail_BulkEdit_Proceed = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Proceed";
			boolean intRet = false;
			if (shtName != null && intRow >= 0) {
				intRet = PropertyDetail_BulkEdit_EnterData_UsingDataMap(shtName, intRow);
				// intRet = PropertyDetail_EnterData_UsingDataMap(shtName, Integer.parseInt(intRow));
				if (intRet == false) {
					logSteps.execution_log("Edit details of one or more tabs - UnSuccessful");
					return false;
				}
			}
			String strMode = null;
			String strFunction = null;
			String strParentPIN = null;
			String strButtonName = null;
			strMode = mainPage.Mode_WebElement.getText().trim();
			strFunction = mainPage.FuncID_WebElement.getText().trim();
			strParentPIN = PropertyDetail_Retrieve_ParentPIN();
			if (strFunction == "Divide Single Property") {
				strParentPIN = PropertyDetail_Retrieve_ParentPIN();
			} else {
				strParentPIN = "";
			}
			switch (strMode) {
			case "Online":
				strButtonName = "Proceed";
				break;
			case "Batch":
				strButtonName = "Apply Bulk Changes/Proceed";
				break;
			}
			propertyDetailPage.Proceed_WebButton.click();
			WaitUtil.waitMSeconds(5000);
			logSteps.execution_log("<" + strButtonName + "> button is clicked");
			if (strMode == "Batch") {
				intRet = PropertyDetail_BulkEdit_BatchProceed(strFunction, strParentPIN, shtName, String.valueOf(intRow));
				PropertyDetail_BulkEdit_Proceed = intRet;
				if (intRet == false) {
					logSteps.execution_log("<" + strButtonName + "> for bulk edit in batch mode - UnSuccessful");
				} else {
					logSteps.execution_log("<" + strButtonName + "> for bulk edit in batch mode - Successful");
					PropertyDetail_BulkEdit_Proceed = true;
				}
				return false;
			}
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			if (propertyDetailPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(propertyDetailPage.ErrorMsg_WebTable, 1, 1).trim();
				strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
				if (!strErrorMsgs.isEmpty()) {
					if (shtName != null && intRow >= 0) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, intRow);
					} else {
						strExpectedMsgs = "";
					}
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						PropertyDetail_BulkEdit_Proceed = false;
					}
					return false;
				}
			}
			if (strComp(strFunction, "Correct/Update") == 0) {
				if (!updateCertifiedPropertyBulkPage.ConfirmationHeader_WebElement.isPresent()) {
					logSteps.execution_log("<Update Certified Property Bulk> confirmation page Not displayed - UnSuccessful");
				} else {
					logSteps.execution_log("<Update Certified Property Bulk> confirmation page displayed - Successful");
					PropertyDetail_BulkEdit_Proceed = true;
				}
				return false;
			}
			if (!printParcelPage.PrintParcel_WebElement.isPresent()) {
				logSteps.execution_log("The <Print Parcel> page NOT displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Print Parcel> page displayed - Successful");
			PropertyDetail_BulkEdit_Proceed = true;
			return PropertyDetail_BulkEdit_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed(String strFunction, String strParentPIN, String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_BatchProceed = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_BatchProceed";
			String strSummaryReport = null;
			String strPrintParcel = null;
			String strRowFrom = null;
			String strRowTo = null;
			String strRequestAction = null;
			String strRegNumber = null;
			strSummaryReport = GetValueIfValid("RequestSummaryReport", shtName, Integer.parseInt(intRow));
			strPrintParcel = GetValueIfValid("RequestPrintParcel", shtName, Integer.parseInt(intRow));
			strRowFrom = GetValueIfValid("RangeRowFrom", shtName, Integer.parseInt(intRow));
			strRowTo = GetValueIfValid("RangeRowTo", shtName, Integer.parseInt(intRow));
			strRequestAction = GetValueIfValid("RequestAction", shtName, Integer.parseInt(intRow));
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			if (strSummaryReport.toUpperCase() == "YES" || strSummaryReport.toUpperCase() == "ON") {
				// Browser("ELRS").Page("Batch").WebCheckBox("SummaryReportRequest").SetValue("ON");
				setCheckBoxValue(batchPage.SummaryReportRequest_WebCheckBox, "ON");
			}
			if (strPrintParcel.toUpperCase() == "YES" || strPrintParcel.toUpperCase() == "ON") {
				// Browser("ELRS").Page("Batch").WebCheckBox("PrintParcelRequest").SetValue("ON");
				setCheckBoxValue(batchPage.PrintParcelRequest_WebCheckBox, "ON");
				// Browser("ELRS").Page("Batch").WebEdit("RowFrom").SetValue(strRowFrom);
				batchPage.RowFrom_WebEdit.sendKeys(strRowFrom);
				// Browser("ELRS").Page("Batch").WebEdit("RowTo").SetValue(strRowTo);
				batchPage.RowTo_WebEdit.sendKeys(strRowTo);
			}
			String strRequestActionName = null;
			switch (strRequestAction.toUpperCase()) {
			case "YES":
			case "Y":
			case "IGNORE_VALUE":
			case "":
				strRequestActionName = "Yes";
				break;
			case "NO":
			case "N":
				strRequestActionName = "No";
				break;
			default:
				return false;
			}
			// batchPage.strRequestActionName_webbutton.click();
			batchPage.find(By.name(strRequestActionName)).click();
			logSteps.execution_log("<" + strRequestActionName + "> button is clicked");
			boolean intRet = false;
			String strEditMode = null;
			strEditMode = "Bulk Edit";
			if (strRequestActionName == "No") {
				intRet = VerifyPage_PropertyDetail(strEditMode);
				if (intRet == false) {
					logSteps.execution_log("Verification of <Property Detail Bulk Edit> page - UnSuccessful");
				} else {
					logSteps.execution_log("Verification of <Property Detail Bulk Edit> page - Successful");
					PropertyDetail_BulkEdit_BatchProceed = true;
				}
				return false;
			}
			logSteps.execution_log("<Open Property WIP Off-line Bulk Edit Confirmation> page displayed - Successful");
			batchPage.OK_WebButton.click();
			logSteps.execution_log("<OK> button is clicked");
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> is NOT displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Page <Main Menu> is displayed - Successful");
			switch (strFunction) {
			case "Divide Single Property":
				String[] arrParentPIN = null;
				String strProperty = null;
				String arrProperty[] = null;
				String strBlock = null;
				String strPIN = null;
				arrParentPIN = (strParentPIN).split("(");
				strProperty = arrParentPIN[0].trim();
				arrProperty = (strProperty).split("-");
				strBlock = arrProperty[0].trim();
				strPIN = arrProperty[1].trim();
				intRet = PropertyDetail_BulkEdit_BatchProceed_Divide(strBlock, strPIN);
				break;
			case "Open Property Subdivision":
				intRet = PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision(strRegNumber);
				break;
			case "Open Condominium Property":
				intRet = PropertyDetail_BulkEdit_BatchProceed_OpenCondominium(strRegNumber);
				break;
			case "Create Condo Amendment":
				intRet = PropertyDetail_BulkEdit_BatchProceed_CreateUnits(strRegNumber);
				break;
			case "Condominium Amalgamation":
				intRet = PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation(strRegNumber);
				break;
			default:
				break;
			}
			logSteps.execution_log("<Summary Report & Draft Parcel Register Review> page displayed - Successful");
			PropertyDetail_BulkEdit_BatchProceed = true;
			return PropertyDetail_BulkEdit_BatchProceed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation(String strRegNumber) {
		boolean PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation = false;
		try {
			boolean intRet = false;
			intRet = condoAmalgamation.CondoAmalgamation_BatchProceed_RetrieveWIP(strRegNumber);
			if (intRet == false) {
				return false;
			}
			// If Batch WIP Unavailable screen present, click OK button and re-retrieve wip
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				// Reporter.ReportEvent micDone, strStepName, "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				// AddInfo "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				batchPage.OK_WebButton.click();
				WaitUtil.waitMSeconds(500);
				// Re-retrieve
				intRet = condoAmalgamation.CondoAmalgamation_BatchProceed_RetrieveWIP(strRegNumber);
				if (intRet == false) {
					return false;
				}
			}
			// PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation = intRet;
			return PropertyDetail_BulkEdit_BatchProceed_CondoAmalgamation;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed_CreateUnits(String strRegNumber) {
		boolean PropertyDetail_BulkEdit_BatchProceed_CreateUnits = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_BatchProceed_CreateUnits";

			Thread.sleep((5));
			boolean intRet = false;
			// Call function CreateUnits_BatchProceed_RetrieveWIP to retrieve WIP which is in CreateUnits.qfl
			intRet = createUnits.CreateUnits_BatchProceed_RetrieveWIP(strRegNumber);
			if (intRet == false) {
				return false;
			}
			// If Batch WIP Unavailable screen present, click OK button and re-retrieve wip
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				// Reporter.ReportEvent micDone, strStepName, "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				// AddInfo "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				Thread.sleep((5));
				batchPage.OK_WebButton.click();
				Thread.sleep((2));
				// Re-retrieve
				intRet = createUnits.CreateUnits_BatchProceed_RetrieveWIP(strRegNumber);
				if (intRet == false) {
					return false;
				}
			}
			PropertyDetail_BulkEdit_BatchProceed_CreateUnits = intRet;
			return PropertyDetail_BulkEdit_BatchProceed_CreateUnits;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed_OpenCondominium(String strPlanNumber) {
		boolean PropertyDetail_BulkEdit_BatchProceed_OpenCondominium = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_BatchProceed_OpenCondominium";

			Thread.sleep((5));
			boolean intRet;
			// Call function OpenCondominium_BatchProceed_RetrieveWIP to retrieve WIP which is in opencondominium.qfl
			intRet = openCondominium.OpenCondominium_BatchProceed_RetrieveWIP(strPlanNumber);
			if (intRet == false) {
				return false;
			}
			// If Batch WIP Unavailable screen present, click OK button and re-retrieve wip
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				// Reporter.ReportEvent micDone, strStepName, "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				// AddInfo "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				Thread.sleep((5));
				batchPage.OK_WebButton.click();
				Thread.sleep((2));
				// Re-retrieve
				intRet = openCondominium.OpenCondominium_BatchProceed_RetrieveWIP(strPlanNumber);
				if (intRet == false) {
					return false;
				}
			}
			PropertyDetail_BulkEdit_BatchProceed_OpenCondominium = intRet;
			return PropertyDetail_BulkEdit_BatchProceed_OpenCondominium;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision(String strPlanNumber) {
		boolean PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision";

			Thread.sleep((5));
			boolean intRet = false;
			// Call function OpenSubdivision_BatchProceed_RetrieveWIP to retrieve WIP which is in opensubdivision.qfl
			intRet = openSubdivision.OpenSubdivision_BatchProceed_RetrieveWIP(strPlanNumber);
			if (intRet == false) {
				return false;
			}
			// If Batch WIP Unavailable screen present, click OK button and re-retrieve wip
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				// Reporter.ReportEvent micDone, strStepName, "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				// AddInfo "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				Thread.sleep((5));
				batchPage.OK_WebButton.click();
				Thread.sleep((2));
				// Re-retrieve
				intRet = openSubdivision.OpenSubdivision_BatchProceed_RetrieveWIP(strPlanNumber);
				if (intRet == false) {
					return false;
				}
			}
			PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision = intRet;
			return PropertyDetail_BulkEdit_BatchProceed_OpenSubdivision;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_BatchProceed_Divide(String strTargetBlock, String strTargetPIN) {
		boolean PropertyDetail_BulkEdit_BatchProceed_Divide = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_BatchProceed_Divide";

			Thread.sleep((5));
			// Call function DivideProperty_BatchProceed_RetrieveWIP to retrieve WIP which is in DivideProperty.qfl
			boolean intRet = false;
			intRet = divideproperty.DivideProperty_BatchProceed_RetrieveWIP(strTargetBlock, strTargetPIN);
			if (intRet == false) {
				return false;
			}
			// If Batch WIP Unavailable screen present, click OK button and re-retrieve wip
			while (batchPage.BatchWIPUnavailable_WebElement.isPresent()) {
				// Reporter.ReportEvent micDone, strStepName, "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				// AddInfo "Off-Line WIP Unavailable page present, wait and re-retrieve WIP"
				Thread.sleep((5));
				batchPage.OK_WebButton.click();
				Thread.sleep((2));
				// Re-retrieve
				intRet = divideproperty.DivideProperty_BatchProceed_RetrieveWIP(strTargetBlock, strTargetPIN);
				if (intRet == false) {
					return false;
				}
			}
			PropertyDetail_BulkEdit_BatchProceed_Divide = intRet;
			return PropertyDetail_BulkEdit_BatchProceed_Divide;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Batch_EditChildProperty_UsingDataMap(String shtName, String intRow) {
		boolean PropertyDetail_Batch_EditChildProperty_UsingDataMap = false;
		try {
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();
			oDataMap.put("Description", "");
			oDataMap.put("Documents", "");
			oDataMap.put("Owners", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("CorrectionNotices", "");
			oDataMap.put("Managers", "");
			oDataMap.put("InternalPINNotes", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);
			for (int i = 0; i <= arrKeys.length - 1; i++) {
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, Integer.parseInt(intRow)).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}
			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				intRet = PropertyDetail_Navigate_To_Tab(strSheetName);
				switch (strSheetName.toUpperCase()) {
				case "DESCRIPTION":
					intRet = PropertyDetail_Batch_EditChildProperty_Description(strSheetName, strRowNumber);
					break;
				case "DOCUMENTS":
					// intRet = PropertyDetail_Batch_EditChildProperty_Documents(strSheetName, strRowNumber); // Function not implemented as of 10-03-2012
					System.out.println("PropertyDetail_Batch_EditChildProperty_Documents - Method not implemented");
					break;
				case "OWNERS":
					// intRet = PropertyDetail_Batch_EditChildProperty_Owners(strSheetName, strRowNumber);
					System.out.println("PropertyDetail_Batch_EditChildProperty_Documents - Method not implemented");
					break;
				case "PROPERTYREMARKS":
					// intRet = PropertyDetail_Batch_EditChildProperty_PropertyRemarks(strSheetName, strRowNumber); // Function not implemented as of 10-03-2012
					break;
				case "CORRECTIONNOTICES":
					// intRet = PropertyDetail_Batch_EditChildProperty_CorrectionNotices(strSheetName, strRowNumber); // Function not implemented as of 10-03-2012
					break;
				case "MANAGERS":
					// intRet = PropertyDetail_Batch_EditChildProperty_Managers(strSheetName, strRowNumber); // Function not implemented as of 10-03-2012
					break;
				case "INTERNALPINNOTES":
					// intRet = PropertyDetail_Batch_EditChildProperty_InternalPINNotes(strSheetName, strRowNumber)
					intRet = PropertyDetail_Edit_InternalPINNotes(strSheetName, strRowNumber);
					break;
				case "PENDINGBULKEDITS":
					// intRet = PropertyDetail_Batch_EditChildProperty_PendingBulkEdits(strSheetName, strRowNumber); // Function not implemented as of 10-03-2012
					break;
				}
				if (intRet == false) {
					PropertyDetail_Batch_EditChildProperty_UsingDataMap = false;
				}
			}
			oDataMap = null;
			return PropertyDetail_Batch_EditChildProperty_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_Batch_EditChildProperty_Description(String shtName, String intRow) {
		boolean PropertyDetail_Batch_EditChildProperty_Description = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_Batch_EditChildProperty_Description";
			int intStart = 0;
			int intEnd = 0;
			String[] arrRows = null;
			if (intRow.contains("-")) {
				arrRows = (intRow).split("-");
				intStart = Math.round(Integer.parseInt(arrRows[0]));
				intEnd = Math.round(Integer.parseInt(arrRows[1]));
			} else {
				intStart = Math.round(Integer.parseInt(intRow));
				intEnd = intStart;
			}
			String strBlockNumber = null;
			String strEstate = null;
			String strQualifier = null;
			String strFrench = null;
			String strEasementAction = null;
			String strEasementIndex = null;
			String strLowerMunicipality = null;
			String strUpperMunicipality = null;
			strBlockNumber = GetValueIfValid("BlockNumber", shtName, Integer.parseInt(intRow));
			strEstate = GetValueIfValid("Estate", shtName, Integer.parseInt(intRow));
			strQualifier = GetValueIfValid("Qualifier", shtName, Integer.parseInt(intRow));
			strFrench = GetValueIfValid("French", shtName, Integer.parseInt(intRow));
			strLowerMunicipality = GetValueIfValid("LowerMunicipality", shtName, Integer.parseInt(intRow));
			strUpperMunicipality = GetValueIfValid("UpperMunicipality", shtName, Integer.parseInt(intRow));
			String oPage = null;
			boolean intRet = false;
			description_ChildEdit.BlockNumber_WebEdit.sendKeys(strBlockNumber);
			// oPage.WebCheckBox("French").SetValue(strFrench);
			setCheckBoxValue(description_ChildEdit.French_WebCheckBox, strFrench);
			// oPage.WebList("Estate").SelectItem(strEstate.toUpperCase());
			description_ChildEdit.Estate_WebList.selectByVisibleText(strEstate.toUpperCase());
			// oPage.WebList("Qualifier").SelectItem(strQualifier.toUpperCase());
			description_ChildEdit.Qualifier_WebList.selectByVisibleText(strQualifier.toUpperCase());
			// Enter data -Easement section - be able to handle multiple rows of inputs
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// Fetch data
				strEasementAction = GetValueIfValid("EasementAction", shtName, Integer.parseInt(intRow));
				strEasementIndex = GetValueIfValid("EasementIndex", shtName, Integer.parseInt(intRow));
				if (!strEasementAction.isEmpty() && !strEasementAction.equals("IGNORE_VALUE")) {
					// Perform action based on the value provided
					switch (strEasementAction.toUpperCase()) {
					case "ADD":
						// intRet = PropertyDetail_Batch_EditChildProperty_Description_Easement_Add(shtName, iLoop); // Function not implemented as of 10-03-2012
						break;
					case "FILL":
						// intRet = PropertyDetail_Batch_EditChildProperty_Description_Easement_Fill(shtName, iLoop); // Function not implemented as of 10-03-2012
						break;
					case "REMOVE":
						// intRet = PropertyDetail_Batch_EditChildProperty_Description_Easement_Remove(strEasementIndex); // Function not implemented as of 10-03-2012
						break;
					}
					if (!intRet == true) {
						PropertyDetail_Batch_EditChildProperty_Description = false;
					}
				}
			}
			// oPage.WebList("LowerMunicipality").SelectItem(strLowerMunicipality.toUpperCase());
			description_ChildEdit.LowerMunicipality_WebList.selectByVisibleText(strLowerMunicipality.toUpperCase());
			// oPage.WebList("UpperMunicipality").SelectItem(strUpperMunicipality.toUpperCase());
			description_ChildEdit.UpperMunicipality_WebList.selectByVisibleText(strUpperMunicipality.toUpperCase());
			oPage = null;
			logSteps.execution_log("Enter data to <Description> page - Successful");
			PropertyDetail_Batch_EditChildProperty_Description = true;
			return PropertyDetail_Batch_EditChildProperty_Description;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Close button on PropertyDetail page for bulk edit $shtName and $intRow")
	public boolean PropertyDetail_BulkEdit_Close(String strAction, String shtName, String intRow) {
		boolean PropertyDetail_BulkEdit_Close = false;
		try {
			String strStepName = null;
			strStepName = "PropertyDetail_BulkEdit_Close";
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = PropertyDetail_BulkEdit_EnterData_UsingDataMap(shtName, intRow);
				if (intRet == false) {
					logSteps.execution_log("Edit details of one or more tabs - UnSuccessful");
					return false;
				}
			}
			String strButtonName = null;
			strButtonName = propertyDetailPage.Cancel_WebButton.getAttribute("value");
			String strPreActiveTab = null;
			String strActiveTab = null;
			strPreActiveTab = CheckPropertyDetailActiveTab();
			propertyDetailPage.Cancel_WebButton.click();
			Thread.sleep(2);
			logSteps.execution_log("<" + strButtonName + "> button is clicked");
			String strButton = null;
			switch (strAction.toUpperCase()) {
			case "OK":
				strButton = "OK";
				break;
			case "CANCEL":
				strButton = "Cancel";
				break;
			default:
				return false;
			}
			intRet = elrsCommon.ELRS_Popup_Cancel(strButton);
			if (intRet == false) {
				logSteps.execution_log("Click <" + strButton + "> button on the Close popup confirmation page - UnSuccessful");
				return false;
			}
			String strFunction = null;
			strFunction = mainPage.FuncID_WebElement.getAttribute("outertext").trim();
			if (strComp(strFunction, "Correct/Update") == 0) {
				strActiveTab = CheckPropertyDetailActiveTab();
				if (!(strComp(strPreActiveTab, strActiveTab) == 0)) {
					logSteps.execution_log("Different screen returned. Before: <" + strPreActiveTab + ">, After: <" + strActiveTab + ">");
					return false;
				}
				logSteps.execution_log("Verification of the <Property Detail> page - Successful");
				PropertyDetail_BulkEdit_Close = true;
				return false;
			}
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Page <Main Menu> NOT displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Main Menu> page displayed - Successful");
			PropertyDetail_BulkEdit_Close = true;
			return PropertyDetail_BulkEdit_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PropertyDetail_BulkEdit_EnterData_UsingDataMap(String shtName, String intRow) {
		try {
			boolean PropertyDetail_BulkEdit_EnterData_UsingDataMap = true;
			// Object oDataMap=null;
			Map<String, String> oDataMap = new LinkedHashMap<String, String>();
			oDataMap.put("Description", "");
			oDataMap.put("Documents", "");
			oDataMap.put("Owners", "");
			oDataMap.put("PropertyRemarks", "");
			oDataMap.put("CorrectionNotices", "");
			oDataMap.put("Managers", "");
			oDataMap.put("InternalPINNotes", "");
			oDataMap.put("PendingBulkEdits", "");
			Object[] arrKeys = oDataMap.keySet().toArray();
			Map<String, Integer> headerMap = getHeaderMap(shtName);
			for (int i = 0; i <= arrKeys.length - 1; i++) {
				if (!headerMap.containsKey(arrKeys[i])) {
					oDataMap.remove(arrKeys[i]);
				} else {
					String strCellValue = GetValueIfValid(arrKeys[i].toString(), shtName, Integer.parseInt(intRow)).trim();
					if (strCellValue.isEmpty()) {
						oDataMap.remove(arrKeys[i]);
					} else {
						oDataMap.put(arrKeys[i].toString(), strCellValue);
					}
				}
			}
			boolean intRet = false;
			Object[] arrNewKeys = oDataMap.keySet().toArray();
			for (int i = 0; i <= arrNewKeys.length - 1; i++) {
				String strSheetName = arrNewKeys[i].toString();
				String strRowNumber = oDataMap.get(strSheetName);
				intRet = PropertyDetail_Navigate_To_Tab(strSheetName);
				switch (strSheetName.toUpperCase()) {
				case "DESCRIPTION":
					intRet = PropertyDetail_BulkEdit_Description(strSheetName, strRowNumber);
					break;
				case "DOCUMENTS":
					intRet = PropertyDetail_BulkEdit_Documents(strSheetName, strRowNumber);
					break;
				case "OWNERS":
					intRet = PropertyDetail_BulkEdit_Owners(strSheetName, strRowNumber);
					break;
				case "PROPERTYREMARKS":
					intRet = PropertyDetail_BulkEdit_PropertyRemarks(strSheetName, strRowNumber);
					break;
				case "CORRECTIONNOTICES":
					// intRet = PropertyDetail_BulkEdit_CorrectionNotices(strSheetName, strRowNumber);
					break;
				case "MANAGERS":
					// intRet = PropertyDetail_BulkEdit_Managers(strSheetName, strRowNumber);
					break;
				case "INTERNALPINNOTES":
					intRet = PropertyDetail_BulkEdit_InternalPINNotes(strSheetName, strRowNumber);
					break;
				case "PENDINGBULKEDITS":
					intRet = PropertyDetail_BulkEdit_PendingBulkEdits(strSheetName, strRowNumber);
					break;
				}
				if (intRet == false) {
					PropertyDetail_BulkEdit_EnterData_UsingDataMap = false;
				}
			}
			oDataMap = null;
			return PropertyDetail_BulkEdit_EnterData_UsingDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String CheckPropertyDetailActiveTab() {
		String CheckPropertyDetailActiveTab = null;
		try {
			String oPage = null;
			// 08-16-2012/Jenny/Check the tabs only when the tabs exist
			if (propertyDetailPage.Description_Link.isPresent()) {
				if (propertyDetailPage.Description_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "Description";
					oPage = null;
					return null;
				}
			}
			if (propertyDetailPage.Documents_Link.isPresent()) {
				if (propertyDetailPage.Documents_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "Documents";
					oPage = null;
					return null;
				}
			}
			// 08-20-2012/Jenny/Add Frame as Owners can//t be identified for Divide Property if no frame
			if (propertyDetailPage.Owners_Link.isPresent()) {
				if (propertyDetailPage.Owners_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "Owners";
					oPage = null;
					return null;
				}
			}
			if (propertyDetailPage.PropertyRemarks_Link.isPresent()) {
				if (propertyDetailPage.PropertyRemarks_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "PropertyRemarks";
					oPage = null;
					return null;
				}
			}
			// 08-16-2012/Jenny/Add "Correction Notices"
			if (propertyDetailPage.CorrectionNotices_Link.isPresent()) {
				if (propertyDetailPage.CorrectionNotices_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "CorrectionNotices";
					oPage = null;
					return null;
				}
			}
			// 08-16-2012/Jenny/Add "Managers"
			if (propertyDetailPage.Managers_Link.isPresent()) {
				if (propertyDetailPage.Managers_Link.getAttribute("class") == "foretab") {
					CheckPropertyDetailActiveTab = "Managers";
					oPage = null;
					return null;
				}
			}
			oPage = null;
			return CheckPropertyDetailActiveTab;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
