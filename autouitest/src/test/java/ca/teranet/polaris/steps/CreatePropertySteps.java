package ca.teranet.polaris.steps;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import ca.teranet.pages.polaris.CreatePropertyPage;
import ca.teranet.pages.polaris.ParcelConfirmationPage;
import ca.teranet.pages.polaris.PrintParcelPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.polaris.base.steps.PolarisBaseSteps;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Steps;

public class CreatePropertySteps extends Utility {

	PropertyDetailPage propertyDetailPage;
	CreatePropertyPage createPropertyPage;
	PrintParcelPage printParcelPage;
	ParcelConfirmationPage parcelConfirmationPage;
	@Steps
	LogSteps logSteps;
	DividePropertySteps divideproperty;
	@Steps
	ELRSCommonSteps elrsCommonSteps;

	@When("user click on Proceed button on the Create Property page $SHEETNAME and $ROW")
	public boolean CreateProperty_Proceed(String SHEETNAME, int ROW) {
		boolean CreateSingleProperty_EnterData_Proceed = false;
		try {
			String strStepName = "CreateSingleProperty_EnterData_Proceed";
			String strBlock = GetBlockNumberPerLROCode("Block", SHEETNAME, ROW);
			String strReason = GetValueIfValid("Reason", SHEETNAME, ROW);
			if (strBlock.isEmpty() && strReason.isEmpty()) {
			} else {
				boolean intRet = CreateSingleProperty_EnterData(SHEETNAME, ROW);
				if (intRet == false) {
					return CreateSingleProperty_EnterData_Proceed;
				} else {
				}
			}
			createPropertyPage.Proceed_WebButton.click();
			boolean intRet = false;
			if (!propertyDetailPage.Description_Link.isPresent()) {
				String strExpectedMsgs = GetValueIfValid("ErrorMessages", SHEETNAME, ROW);
				String strErrorMsgs = createPropertyPage.ErrorMsg_WebTable.getText().trim();
				intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				if (!intRet == true) {
				}
				return CreateSingleProperty_EnterData_Proceed;
			}
			intRet = VerifyPage("Create Single Property");
			if (intRet == false) {
				return CreateSingleProperty_EnterData_Proceed;
			}
			CreateSingleProperty_EnterData_Proceed = true;
			return CreateSingleProperty_EnterData_Proceed;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateSingleProperty_EnterData_Proceed;
		}
	}

	@When("user cancels Create Property")
	public boolean User_Cancels_Create_Property() {
		boolean CreateProperty_Cancel = false;
		try {
			createPropertyPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(500);
			CreateProperty_Cancel = true;
			return CreateProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateProperty_Cancel;
		}
	}

	@When("user cancels Create Property $SHEETNAME and $ROW")
	public boolean User_Cancels_Create_Property_Withdataentry(String SHEETNAME, int ROW) {
		boolean CreateProperty_Cancel = false;
		try {
			createPropertyPage.Block_WebEdit.clear();
			String strStepName = "user cancel the cancel with data entry";
			String strBlock = GetBlockNumberPerLROCode("Block", SHEETNAME, ROW);
			String strReason = GetValueIfValid("Reason", SHEETNAME, ROW);
			createPropertyPage.Block_WebEdit.sendKeys(strBlock);
			if (strReason != null && !strReason.isEmpty()) {
				createPropertyPage.ReasonCode_WebList.selectByVisibleText(strReason.toUpperCase());
			} else {
				createPropertyPage.ReasonCode_WebList.selectByIndex(0);
			}

			createPropertyPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(500);
			CreateProperty_Cancel = true;
			return CreateProperty_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateProperty_Cancel;
		}
	}

	@When("user cancels the Cancel Create Property $SHEETNAME and $ROW")
	public boolean User_Cancel_Create_Property(String SHEETNAME, int ROW) {
		boolean CreateProperty_Cancels_Cancel = false;
		try {
			String strStepName = "user cancel the cancel with data entry";
			String strBlock = GetBlockNumberPerLROCode("Block", SHEETNAME, ROW);
			String strReason = GetValueIfValid("Reason", SHEETNAME, ROW);
			createPropertyPage.Block_WebEdit.sendKeys(strBlock);
			if (strReason != null && !strReason.isEmpty()) {
				createPropertyPage.ReasonCode_WebList.selectByVisibleText(strReason.toUpperCase());
			} else {
				createPropertyPage.ReasonCode_WebList.selectByIndex(0);
			}
			createPropertyPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(1000);
			CreateProperty_Cancels_Cancel = true;
			return CreateProperty_Cancels_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateProperty_Cancels_Cancel;
		}
	}

	public boolean CreateSingleProperty_EnterData(String shtName, int intRow) {
		boolean CreateSingleProperty_EnterData = false;
		try {
			String strStepName = "CreateSingleProperty_EnterData";
			String strBlock = GetBlockNumberPerLROCode("Block", shtName, intRow);
			String strReason = GetValueIfValid("Reason", shtName, intRow);
			createPropertyPage.Block_WebEdit.sendKeys(strBlock);
			if (strReason != null && !strReason.isEmpty()) {
				createPropertyPage.ReasonCode_WebList.selectByVisibleText(strReason.toUpperCase());
			} else {
				createPropertyPage.ReasonCode_WebList.selectByIndex(0);
			}
			CreateSingleProperty_EnterData = true;
			return CreateSingleProperty_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return CreateSingleProperty_EnterData;
		}
	}

	public String GetBlockNumberPerLROCode(String parName, String shtName, int intRow) {
		String GetBlockNumberPerLROCode = null;
		try {
			String strLRO = mainPage.LROText_WebElement.getText();
			String[] arrLRO = strLRO.split("\\(");
			System.out.println(arrLRO);
			String strLROCode = arrLRO[1].trim();
			String[] arrLROCode = (strLROCode).split("\\)");
			String intLROCode = arrLROCode[0].trim();
			String strParName = parName + "_" + intLROCode;
			System.out.println(strParName);
			Sheet sheet = PolarisBaseSteps.workbook.getSheet(shtName.trim());
			Row datarow = sheet.getRow(intRow);
			Row headerrow = sheet.getRow(0);
			Map<String, Integer> map = new HashMap<String, Integer>();
			int minColIx = headerrow.getFirstCellNum();
			int maxColIx = headerrow.getLastCellNum();
			for (int colIx = minColIx; colIx < maxColIx; colIx++) {
				Cell cell = headerrow.getCell(colIx);
				map.put(cell.getStringCellValue(), cell.getColumnIndex());
			}
			String strBlockNumber = getCellValue(datarow.getCell(map.get(strParName.trim())));
			GetBlockNumberPerLROCode = strBlockNumber;
			return GetBlockNumberPerLROCode;
		} catch (Exception e) {
			e.printStackTrace();
			return GetBlockNumberPerLROCode;
		}
	}

	@When("user clicks on Proceed button on the Create Property $SHEETNAME and $ROW")
	public boolean user_clickproceed_createproperty(String shtName, int intRow) {
		boolean user_clickproceed_createproperty = false;
		try {
			String strBlock = GetBlockNumberPerLROCode("Block", shtName, intRow);
			String strReason = GetValueIfValid("Reason", shtName, intRow);
			createPropertyPage.Block_WebEdit.clear();
			createPropertyPage.Block_WebEdit.sendKeys(strBlock);
			if (strReason != null && !strReason.isEmpty()) {
				createPropertyPage.ReasonCode_WebList.selectByVisibleText(strReason.toUpperCase());
			} else {
				createPropertyPage.ReasonCode_WebList.selectByIndex(0);
			}
			createPropertyPage.Proceed_WebButton.click();
			user_clickproceed_createproperty = true;
			return user_clickproceed_createproperty;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Proceed To Confirmation button on Print Parcel page $shtName and $intRow")
	public boolean PrintParcel_ProceedToConfirmation(String shtName, String intRow) {
		boolean PrintParcel_ProceedToConfirmation = false;
		try {
			String strStepName = "PrintParcel_ProceedToConfirmation";
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = PrintParcel_EnterData_PropertyRange(shtName, Integer.parseInt(intRow));
				if (intRet == false) {
					return false;
				}
			}
			printParcelPage.ProceedToConfirmation_WebButton.click();
			WaitUtil.waitMSeconds(2000);
			// if (!printParcelPage.PrintParcel_WebButton.isPresent() && !printParcelPage.NextProperty_WebButton.isPresent()) {
			// return false;
			// }
			// if (!shtName.equals("") && !intRow.equals("")) {
			// intRet = ParcelConfirmation_VerifyPage(shtName, Integer.parseInt(intRow));
			// if (intRet == false) {
			// return false;
			// }
			// }
			PrintParcel_ProceedToConfirmation = true;
			return PrintParcel_ProceedToConfirmation;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Return to Property Details button on Print Parcel page")
	public boolean PrintParcel_And_Confirmation_ReturnToPropertyDetails() {
		boolean PrintParcel_And_Confirmation_ReturnToPropertyDetails = false;
		try {
			String strStepName = null;
			String strPage = null;
			strStepName = "PrintParcel_And_Confirmation_ReturnToPropertyDetails";
			if (printParcelPage.ProceedToConfirmation_WebButton.isPresent()) {
				strPage = "Print Parcel";
			} else if (printParcelPage.Certify_WebButton.isPresent()) {
				strPage = "Parcel Confirmation";
			} else {
				// Reporter.reportEvent(Status.Warning,strStepName,"Unknown page is found");
			}
			environmentlib.setProperty("bTriggered", "false");
			printParcelPage.ReturnToPropertyDetails_WebButton.click();

			// AddInfo("Click <Return to Property Details> button on "+strPage+" page - Successful");
			if (!propertyDetailPage.Description_Link.isPresent()) {
				// 29-02-2016/Jemmy/Verify if Description_bulk exists or not
				if (!propertyDetailPage.Description_bulk_Link.isPresent()) {
					// Reporter.reportEvent(Status.Failed,strStepName,"The <Description> tab on Property Detail page Not exist - UnSuccessful");
					// AddInfo("The <Description> tab on Property Detail page Not Exist - UnSuccessful");
					PrintParcel_And_Confirmation_ReturnToPropertyDetails = false;
					return false;
				}
			}
			if (!propertyDetailPage.Proceed_WebButton.isPresent()) {
				// Reporter.reportEvent(Status.Failed,strStepName,"The <Proceed> button on Property Detail page Not exist - UnSuccessful");
				// AddInfo("The <Proceed> button on Property Detail page Not exist - UnSuccessful");
				PrintParcel_And_Confirmation_ReturnToPropertyDetails = false;
				return false;
			}
			// Reporter.reportEvent(Status.Passed,strStepName,"<Property Details> page is displayed - Successful");
			// AddInfo("<Property Details> page is displayed - Successful");
			PrintParcel_And_Confirmation_ReturnToPropertyDetails = true;
			return PrintParcel_And_Confirmation_ReturnToPropertyDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean PrintParcel_EnterData_PropertyRange(String shtName, int intRow) {
		boolean PrintParcel_EnterData_PropertyRange = true;
		try {
			String strStepName = "PrintParcel_EnterData_PropertyRange";
			String strPropertyFrom = GetValueIfValid("PropertyFrom", shtName, intRow);
			String strPropertyTo = GetValueIfValid("PropertyTo", shtName, intRow);
			if (strPropertyFrom.equals("IGNORE_VALUE") && strPropertyTo.equals("IGNORE_VALUE")) {
				return false;
			}
			printParcelPage.PropertyFrom_WebEdit.sendKeys(strPropertyFrom);
			printParcelPage.PropertyTo_WebEdit.sendKeys(strPropertyTo);
			PrintParcel_EnterData_PropertyRange = true;
			return PrintParcel_EnterData_PropertyRange;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on ParcelConfirmation to create Certify $strFunction and $shtName and $intRow")
	public boolean ParcelConfirmation_Certify(String strFunction, String shtName, int intRow) {
		boolean ParcelConfirmation_Certify = false;
		try {
			String strStepName = "ParcelConfirmation_Certify";
			printParcelPage.Certify_WebButton.click();
			boolean intRet = false;
			String strAllTexts = getPDFContent(printParcelPage.PDFIFrame);
			if (strAllTexts.isEmpty()) {
				return false;
			}
			String strUnSuccessfulInfo = null;
			String strWarningInfo = null;
			String strSuccessfulInfo = null;
			switch (strFunction.toUpperCase()) {
			case "CREATE":
				intRet = RetrieveCreatedPIN_Create(strAllTexts, shtName, intRow);
				strUnSuccessfulInfo = "Retrieve Created PIN(s) - UnSuccessful";
				strWarningInfo = "Retrieve Created PIN(s) facing some error - UnSuccessful";
				strSuccessfulInfo = "Retrieve Created PIN(s) - Successful";
				break;
			}
			ParcelConfirmation_Certify = true;
			return ParcelConfirmation_Certify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean RetrieveCreatedPIN_Create(String strDetailInfo, String shtName, int intRow) {
		boolean RetrieveCreatedPIN_Create = false;
		try {
			String strBlock = GetValueIfValid("Block_62", shtName, intRow);
			String strRemarks = GetValueIfValid("Reason", shtName, intRow);
			Matcher match = Pattern.compile(strBlock + "-" + "([0-9]+)").matcher(strDetailInfo);
			if (!match.find()) {
				return false;
			}
			String strPin = match.group(1);
			setTestData("PIN", shtName, intRow, strPin);
			RetrieveCreatedPIN_Create = true;
			return RetrieveCreatedPIN_Create;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on Certify button on Print Parcel Confirmation page $strFunction and $shtName and $intRow")
	public boolean user_click_on_Certify_button_on_Print_Parcel_Confirmation_page(String strFunction, String shtName, int intRow) {
		boolean ParcelConfirmation_Certify = false;
		try {
			String strStepName = "ParcelConfirmation_Certify";
			printParcelPage.Certify_WebButton.click();
			if (!printParcelPage.PDFIFrame.isPresent()) {
				logSteps.execution_log("Certified document page Not displayed - UnSuccessful");
				return false;
			}
			String strAllTexts = getPDFContent(printParcelPage.PDFIFrame);
			if (strAllTexts.isEmpty()) {
				return false;
			}
			boolean intRet = false;
			String strUnSuccessfulInfo = null;
			String strWarningInfo = null;
			String strSuccessfulInfo = null;
			switch (strFunction.toUpperCase()) {
			case "CREATE":
				intRet = RetrieveCreatedPIN_Create(strAllTexts, shtName, intRow);
				strUnSuccessfulInfo = "Retrieve Created PIN(s) - UnSuccessful";
				strWarningInfo = "Retrieve Created PIN(s) facing some error - UnSuccessful";
				strSuccessfulInfo = "Retrieve Created PIN(s) - Successful";
				break;
			case "DIVIDE":
				intRet = divideproperty.RetrieveAndVerifyCreatedPIN_Divide(strAllTexts, shtName, String.valueOf(intRow));
				strUnSuccessfulInfo = "Retrieve Created PIN(s) - UnSuccessful";
				strWarningInfo = "Retrieve Created PIN(s) facing some error - UnSuccessful";
				strSuccessfulInfo = "Retrieve Created PIN(s) - Successful";
				break;
			// case "CONSOLIDATE":
			// intRet = consolidateproperty.RetrievePINAndVerifyRemarks_Consolidate(strAllTexts);
			// strUnSuccessfulInfo = "Verification of <Map Maintenance Request> page - UnSuccessful";
			// strSuccessfulInfo = "Verification of <Map Mainenance Request> page - Successful";
			// // 09-13-2012/Jenny/Add for re-enter property verification in ReEnterProperty.qfl
			// break;
			// case "REENTER":
			// intRet = RetrievePINAndVerifyRemarks_ReEnter(strAllTexts);
			// strUnSuccessfulInfo = "Verification of <Map Maintenance Request> page - UnSuccessful";
			// strSuccessfulInfo = "Verification of <Map Mainenance Request> page - Successful";
			// // 09-28-2012/Jenny/Add for open subdivision verification in OpenSubdivision.qfl
			// break;
			// case "OPENSUBDIVISION":
			// intRet = opensubdivision.RetrievePINAndVerifyRemarks_OpenSubdivision(strAllTexts, shtName, intRow);
			// strUnSuccessfulInfo = "Verification of <Map Maintenance Request> page - UnSuccessful";
			// strSuccessfulInfo = "Verification of <Map Mainenance Request> page - Successful";
			// // 10-17-2012/Jenny/Add for open condominium verification in OpenCondominium.qfl
			// break;
			// case "OPENCONDOMINIUM":
			// intRet = RetrievePINAndVerifyRemarks_OpenCondominium(strAllTexts, shtName, intRow);
			// strUnSuccessfulInfo = "Verification of <Map Maintenance Request> page - UnSuccessful";
			// strSuccessfulInfo = "Verification of <Map Mainenance Request> page - Successful";
			// // 10-30-2012/Jenny/Add for condominium amendment verification in CondoAmendment.qfl
			// break;
			// case "CONDOAMENDMENT":
			// intRet = RetrievePINAndVerifyRemarks_CondoAmendment(strAllTexts, shtName, intRow);
			// strUnSuccessfulInfo = "Verification of <Map Maintenance Request> page - UnSuccessful";
			// strSuccessfulInfo = "Verification of <Map Mainenance Request> page - Successful";
			// break;
			}
			ParcelConfirmation_Certify = true;
			return ParcelConfirmation_Certify;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks Next Property button on the parcel confirmation page $shtName and $intRow")
	public boolean ParcelConfirmation_NextProperty(String shtName, String intRow) {
		try {
			boolean ParcelConfirmation_NextProperty = false;
			String strFunction = null;
			boolean intRet = false;
			strFunction = mainPage.FuncID_WebElement.getText().trim();
			if (strFunction == "Open Property Subdivision" || strFunction == "Open Condominium Property" || strFunction == "Condominium Amendment") {
				// intRet = ParcelConfirmation_NextProperty_OpenSubdivision(shtName, intRow)
				intRet = ParcelConfirmation_NextProperty_OpenProperty(shtName, intRow);
				ParcelConfirmation_NextProperty = intRet;
				return false;
			}
			int intPreCount = 0;
			int count = 0;
			count = ParcelConfirmation_RetrievePropertyCount();
			intPreCount = count;
			logSteps.execution_log("<Property " + intPreCount + "> displayed before <Next Property> button clicked");
			printParcelPage.NextProperty_WebButton.click();
			logSteps.execution_log("<Next Property> button is clicked");
			int intCurCount = 0;
			int intCountDiff = 0;
			count = ParcelConfirmation_RetrievePropertyCount();
			intCurCount = count;
			logSteps.execution_log("<Property " + intCurCount + "> displayed after <Next Property> button clicked");
			intCountDiff = intCurCount - intPreCount;
			if (!(intCountDiff == 1)) {
				logSteps.execution_log("Verification of the property count before and after <Next Property> button clicked - UnSuccessful");
				return false;
			}
			logSteps.execution_log("Verification of Property Count - Successful");
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = ParcelConfirmation_VerifyPage(shtName, intRow);
			}
			ParcelConfirmation_NextProperty = true;
			return ParcelConfirmation_NextProperty;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int ParcelConfirmation_RetrievePropertyCount() {
		int ParcelConfirmation_RetrievePropertyCount = 0;
		try {
			String strCount = null;
			String[] arrCount = null;
			String strPropertyCount = null;
			// int intPropertyCount = 0;
			// strCount=getDriver().switchToFrame("Frame")framePage.PropertyCounter_webelement.getText();
			strCount = mainPage.getDriver().findElement(By.xpath("//span[@id='registrationSystem']//following-sibling::span[2]")).getText();
			arrCount = (strCount.trim()).split("of");
			strPropertyCount = arrCount[0].trim().toString();
			System.out.println(strPropertyCount);
			int intPropertyCount = Integer.valueOf(strPropertyCount);
			ParcelConfirmation_RetrievePropertyCount = intPropertyCount;
			return ParcelConfirmation_RetrievePropertyCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean ParcelConfirmation_NextProperty_OpenProperty(String shtName, String intRow) {
		try {
			boolean ParcelConfirmation_NextProperty_OpenProperty = false;
			printParcelPage.NextProperty_WebButton.click();
			logSteps.execution_log("<Next Property> button is clicked");
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				boolean intRet = false;
				intRet = ParcelConfirmation_VerifyPage(shtName, intRow);
			}
			if (!(printParcelPage.Certify_WebButton.getAttribute("disabled").equals("0"))) {
				logSteps.execution_log("Warning! <Certify> button Not enabled after clicking <Next Property> button - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Certify> button is enabled - Successful");
			ParcelConfirmation_NextProperty_OpenProperty = true;
			return ParcelConfirmation_NextProperty_OpenProperty;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ParcelConfirmation_VerifyPage(String shtName, String intRow) {
		try {

			boolean ParcelConfirmation_VerifyPage = true;
			String strBlockNumber = null;
			strBlockNumber = GetValueIfValid("Block", shtName, Integer.parseInt(intRow)).trim();
			String sDescriptionSheetIndex = null;
			String sDocumentsSheetIndex = null;
			String sOwnersSheetIndex = null;
			String sPropertyRemarksSheetIndex = null;
			sDescriptionSheetIndex = GetValueIfValid("Description", shtName, Integer.parseInt(intRow));
			sDocumentsSheetIndex = GetValueIfValid("Documents", shtName, Integer.parseInt(intRow));
			sOwnersSheetIndex = GetValueIfValid("Owners", shtName, Integer.parseInt(intRow));
			sPropertyRemarksSheetIndex = GetValueIfValid("PropertyRemarks", shtName, Integer.parseInt(intRow));
			if (sDescriptionSheetIndex.isEmpty() || sDescriptionSheetIndex.equals("IGNORE_VALUE")) {
				return false;
			}
			String strActualBlockNumber = null;
			boolean intRet = false;
			// strActualBlockNumber = getCellData(parcelConfirmationPage.BlockSection_WebTable, 2, 1);
			strActualBlockNumber = parcelConfirmationPage.BlockSection_WebTable.getText();
			System.out.println(strActualBlockNumber);
			intRet = CheckExpectedValue(strActualBlockNumber.trim(), strBlockNumber);
			if (!intRet == true) {
				logSteps.execution_log("Verification of Block Number - UnSuccessful. Expected: " + strBlockNumber + ", Actual: " + strActualBlockNumber);
				ParcelConfirmation_VerifyPage = false;
			} else {
				logSteps.execution_log("Verification of Block Number - Successful");
			}
			intRet = VerifyPropertyDetails_Description(sDescriptionSheetIndex);
			if (!intRet == true) {
				ParcelConfirmation_VerifyPage = false;
			}
			intRet = VerifyPropertyDetails_PropertyRemarks(sPropertyRemarksSheetIndex);
			if (!intRet == true) {
				ParcelConfirmation_VerifyPage = false;
			}
			String strRegistrationSystem = null;
			strRegistrationSystem = parcelConfirmationPage.RegSystem_WebEdit.getAttribute("value");
			System.out.println(strRegistrationSystem);
			if (strRegistrationSystem.equalsIgnoreCase("LAND TITLES")) {
				intRet = VerifyPropertyDetails_Owners(sOwnersSheetIndex);
				if (!intRet) {
					ParcelConfirmation_VerifyPage = false;
				}
			}
			intRet = VerifyPropertyDetails_Documents(sDocumentsSheetIndex);
			if (!intRet == true) {
				ParcelConfirmation_VerifyPage = false;
			}
			return ParcelConfirmation_VerifyPage;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPropertyDetails_Owners(String intRow) {
		boolean VerifyPropertyDetails_Owners = true;
		try {
			String strStepName = "VerifyPropertyDetails_Owners";

			String shtName = "Owners";
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
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				// Define variables and fetch the expected Owners details
				String strOwnersIndex = RetrieveExpectedValue("OwnersIndex", shtName, iLoop);
				String strName = RetrieveExpectedValue("Name", shtName, iLoop);
				String strCapacity = RetrieveExpectedValue("Capacity", shtName, iLoop);
				String strShare = RetrieveExpectedValue("Share", shtName, iLoop);
				if (strOwnersIndex.isEmpty()) {
					strOwnersIndex = "1";
				}
				int intRowIndex = 0;
				intRowIndex = Integer.parseInt(strOwnersIndex) + 1;
				String strActualName = getCellData(parcelConfirmationPage.OwnersSection_WebTable, intRowIndex, 1);
				String strActualCapacity = getCellData(parcelConfirmationPage.OwnersSection_WebTable, intRowIndex, 3);
				String strActualShare = getCellData(parcelConfirmationPage.OwnersSection_WebTable, intRowIndex, 5);
				// environmentlib.Value("Test", "bTriggered", false);
				CheckExpectedValue(strActualName.trim(), strName.toUpperCase());
				CheckExpectedValue(strActualCapacity.trim(), strCapacity);
				CheckExpectedValue(strActualShare.trim(), strShare);
			}
			return VerifyPropertyDetails_Owners;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPropertyDetails_Documents(String intRow) {
		boolean VerifyPropertyDetails_Documents = true;
		try {
			String strStepName = "VerifyPropertyDetails_Documents";

			String shtName = "Documents";
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
			int intRowCount = parcelConfirmationPage.DocumentsSection_WebTable.findElements(By.tagName("tr")).size();
			// Define variables
			// Fetch RegNumber from the first row for the initial verification
			String strRegNumber = RetrieveExpectedValue("RegNumber", shtName, intStart);
			if (intRowCount == 1) {
				if (strRegNumber.isEmpty()) {
					// Reporter.reportEvent(Status.Passed, strStepName, "<Documents> section is blank as expected");
					// AddInfo(" Verification of Documents details - Successful");
					VerifyPropertyDetails_Documents = true;
				} else {
					// Reporter.reportEvent(Status.Failed, strStepName, "<Documents> section is blank. Expected Registration Number: <" + strRegNumber + "> - UnSuccessful");
					// AddInfo(" Verification of Documents details - UnSuccessful. Expected Registration Number: <" + strRegNumber + ">, Actual:<> ");
					VerifyPropertyDetails_Documents = false;
				}
				return false;
			}
			int intIndex = 2;
			// Further verification
			for (int iLoop = intStart; iLoop <= intEnd; iLoop++) {
				strRegNumber = RetrieveExpectedValue("RegNumber", shtName, iLoop);
				String strDocumentType = RetrieveExpectedValue("DocumentType", shtName, iLoop);
				// 08-23-2012/Jenny/Remove verification of Affect This Property as no input for affect this property for bulk edit
				// strAffectThisProperty = RetrieveExpectedValue("AffectThisProperty", shtName)
				String strActualRegNumber = getCellData(parcelConfirmationPage.DocumentsSection_WebTable, intIndex, 1).trim();
				String strActualDocumentType = getCellData(parcelConfirmationPage.DocumentsSection_WebTable, intIndex, 3).trim();
				// strActualAffectThisProperty = oWebTable.GetCellData(2,5)
				// environmentlib.Value("Test", "bTriggered", false);
				CheckExpectedValue(strActualRegNumber, strRegNumber);
				CheckExpectedValue(strActualDocumentType, strDocumentType);
				// CheckExpectedValue strActualAffectThisProperty, strAffectThisProperty
				// if (environmentlib.Value("Test", "bTriggered") == true) {
				// VerifyPropertyDetails_Documents = false;
				// // Exit Function
				// }
				intIndex = intIndex + 1;
			}
			if (VerifyPropertyDetails_Documents == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "Verification of Documents details - UnSuccessful");
				// AddInfo(" Verification of Documents details - UnSuccessful");
			} else {
				// Reporter.reportEvent(Status.Passed, strStepName, "Verification of Documents details - Successful");
				// AddInfo(" Verification of Documents details - Successful");
			}
			return VerifyPropertyDetails_Documents;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPropertyDetails_PropertyRemarks(String intRow) {
		boolean VerifyPropertyDetails_PropertyRemarks = true;
		try {
			String strStepName = "VerifyPropertyDetails_PropertyRemarks";
			String shtName = "PropertyRemarks";
			if (intRow == "" || intRow.toUpperCase() == "IGNORE_VALUE") {
				VerifyPropertyDetails_PropertyRemarks = true;
				return false;
			}
			String strActualRemarks = null;
			int row = Integer.parseInt(intRow);
			String strInterestAction = RetrieveExpectedValue("InterestAction", shtName, row);
			String strRemarks = RetrieveExpectedValue("OtherRemarks", shtName, row);
			if (strInterestAction.toUpperCase() == "ADD") {
				String strInterestIndex = null;
				String strInterestToRemove = null;
				String strDebtsOf = null;
				String strSpouseOf = null;
				String strExecutionFrom = null;
				String strExecutionTo = null;
				String strInterest = RetrieveExpectedValue("Interest", shtName, row).toUpperCase();
				String strAsIn = RetrieveExpectedValue("AsIn", shtName, row);
				String strExpectedInterest = null;
				String strActualInterest = null;
				switch (strInterest) {
				case "SUBJECT TO DEBTS":
					// strInterestIndex= RetrieveExpectedValue("InterestIndex", shtName)
					strDebtsOf = RetrieveExpectedValue("DebtsOf", shtName, row);
					strExpectedInterest = "SUBJECT TO DEBTS OF " + strDebtsOf + ", IF ANY, AS IN " + strAsIn;
					break;
				case "SUBJECT TO SPOUSAL RIGHTS":
					strSpouseOf = RetrieveExpectedValue("SpouseOf", shtName, row);
					strExpectedInterest = "SUBJECT TO SPOUSAL RIGHTS OF THE SPOUSE OF " + strSpouseOf + ", IF ANY, AS IN " + strAsIn;
					break;
				case "SUBJECT TO WRIT OF EXECUTION":
					strExecutionFrom = RetrieveExpectedValue("ExecutionFrom", shtName, row);
					strExecutionTo = RetrieveExpectedValue("ExecutionTo", shtName, row);
					strExpectedInterest = "SUBJECT TO EXECUTION NUMBER " + strExecutionFrom + " - " + strExecutionTo + ", IF APPLICABLE, AS IN " + strAsIn;
					break;
				}
				strActualInterest = getCellData(parcelConfirmationPage.RemarksSection_WebTable, 1, 1);
				strActualRemarks = getCellData(parcelConfirmationPage.RemarksSection_WebTable, 2, 1);
				CheckExpectedValue(strActualInterest.trim(), strExpectedInterest);
				CheckExpectedValue(strActualRemarks.trim(), strRemarks.toUpperCase());
			} else {
				// strActualRemarks = Browser("ELRS").Page("ParcelConfirmation").WebTable("RemarksSection").GetCellData(2,1)
				strActualRemarks = parcelConfirmationPage.RemarksSection_WebTable.getText();
				CheckExpectedValue(strActualRemarks.trim(), strRemarks.toUpperCase());
			}
			logSteps.execution_log(" Verification of Property Remarks details - Successful");
			VerifyPropertyDetails_PropertyRemarks = true;
			return VerifyPropertyDetails_PropertyRemarks;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerifyPropertyDetails_Description(String intRow) {
		try {
			boolean VerifyPropertyDetails_Description = false;
			String strStepName = null;
			String shtName = null;
			strStepName = "VerifyPropertyDetails_Description";
			shtName = "Description";
			String strRegSystem = null;
			String strEstate = null;
			String strQualifier = null;
			strRegSystem = RetrieveExpectedValue("RegSystem", shtName, Integer.parseInt(intRow));
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
			if (strRegSystem.toUpperCase() == "LAND TITLES") {
				strEstate = RetrieveExpectedValue("Estate", shtName, Integer.parseInt(intRow));
				strQualifier = RetrieveExpectedValue("Qualifier", shtName, Integer.parseInt(intRow));
			}
			String strEasementDetails = null;
			String strDescription = null;
			String strLowerMunicipality = null;
			String strExpectedDescription = null;
			strDescription = RetrieveExpectedValue("Description", shtName, Integer.parseInt(intRow));
			strLowerMunicipality = RetrieveExpectedValue("LowerMunicipality", shtName, Integer.parseInt(intRow));
			strExpectedDescription = strDescription.toUpperCase();
			String strEasementAction = null;
			strEasementAction = RetrieveExpectedValue("EasementAction", shtName, Integer.parseInt(intRow));
			if (strEasementAction.toUpperCase() == "ADD") {
				String strEasement = null;
				String strOver = null;
				String strFavorOf = null;
				String strUntil = null;
				String strAsIn = null;

				strEasement = RetrieveExpectedValue("Easement", shtName, Integer.parseInt(intRow));
				strOver = RetrieveExpectedValue("Over", shtName, Integer.parseInt(intRow));
				strFavorOf = RetrieveExpectedValue("FavorOf", shtName, Integer.parseInt(intRow));
				strUntil = RetrieveExpectedValue("Until", shtName, Integer.parseInt(intRow));
				strAsIn = RetrieveExpectedValue("AsIn", shtName, Integer.parseInt(intRow));
				switch (strEasement.toUpperCase()) {
				case "S/T EASE - EXISTING":
					strEasementDetails = "SUBJECT TO AN EASEMENT AS IN " + strAsIn;
					break;
				case "S/T EASE - TIME LIMITED":
					strEasementDetails = "SUBJECT TO AN EASEMENT OVER " + strOver + " IN FAVOUR OF " + strFavorOf + " UNTIL " + strUntil + " AS IN " + strAsIn;
					break;
				case "S/T EASE IN GROSS - NO TIME LIMIT":
					strEasementDetails = "SUBJECT TO AN EASEMENT IN GROSS OVER  " + strOver + "  AS IN " + strAsIn;
					break;
				default:
					strEasementDetails = "";
					break;
				}
			}
			String strActualRegSystem = parcelConfirmationPage.RegSystem_WebEdit.getText();
			String strActualDescription = getCellData(parcelConfirmationPage.DescriptionSection_WebTable, 1, 1);
			CheckExpectedValue(strActualRegSystem.trim(), strRegSystem);
			CheckExpectedValue(strActualDescription.trim(), strExpectedDescription.toUpperCase());
			if (strActualRegSystem == "LAND TITLES") {
				String strActualEstate = null;
				String strActualQualifier = null;
				strActualEstate = getCellData(parcelConfirmationPage.EstateSection_WebTable, 2, 1);
				strActualQualifier = getCellData(parcelConfirmationPage.QualifierSection_WebTable, 2, 3);
				CheckExpectedValue(strActualEstate.trim(), strEstate);
				CheckExpectedValue(strActualQualifier.trim(), strQualifier);
			}

			logSteps.execution_log(" Verification of Description details - Successful");
			VerifyPropertyDetails_Description = true;
			return VerifyPropertyDetails_Description;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancels the Cancel on the parcel confirmation page")
	public boolean ParcelConfirmation_CancelCancel() {
		try {
			boolean ParcelConfirmation_CancelCancel = false;
			String strPreRegSystem = null;
			String strPreBlock = null;
			strPreRegSystem = parcelConfirmationPage.RegSystem_WebEdit.getText();
			strPreBlock = parcelConfirmationPage.BlockSection_WebTable.getText();
			parcelConfirmationPage.Cancel_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			// logSteps.execution_log("Click <Cancel> button on the Parcel Confirmation page - Successful");
			String strAction = null;
			boolean intRet = false;
			strAction = "Cancel";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			WaitUtil.waitMSeconds(1000);
			String strCurRegSystem = null;
			String strCurBlock = null;
			strCurRegSystem = parcelConfirmationPage.RegSystem_WebEdit.getText();
			strCurBlock = parcelConfirmationPage.BlockSection_WebTable.getText();
			if (strComp(strCurRegSystem, strPreRegSystem) == 0) {
				if (strComp(strCurBlock, strPreBlock) == 0) {
					logSteps.execution_log("Verification of the data - Successful");
					ParcelConfirmation_CancelCancel = true;
				} else {
					logSteps.execution_log("The actual Block Number " + strCurBlock + ", The expected Block Number is " + strPreBlock + " - UnSuccessful");
				}
			} else {
				logSteps.execution_log("The actual Registration System is " + strCurRegSystem + ", The expected Registration System  is " + strPreRegSystem + " - UnSuccessful");
			}
			parcelConfirmationPage.Cancel_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			strAction = "OK";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			WaitUtil.waitMSeconds(1000);
			return ParcelConfirmation_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user cancel the Create Property process on the parcel confirmation page")
	public boolean ParcelConfirmation_Cancel() {
		try {
			boolean ParcelConfirmation_Cancel = false;
			parcelConfirmationPage.Cancel_WebButton.click();
			logSteps.execution_log("Click <Cancel> button - Successful");
			String strAction = null;
			boolean intRet = false;
			strAction = "OK";
			intRet = elrsCommonSteps.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				return false;
			}
			intRet = elrsCommonSteps.VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("Verification of the page -  UnSuccessful");
				return false;
			}
			logSteps.execution_log("Verification of the page - Successful");
			ParcelConfirmation_Cancel = true;
			return ParcelConfirmation_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
