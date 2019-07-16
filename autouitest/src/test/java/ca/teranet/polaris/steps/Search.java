package ca.teranet.polaris.steps;

import java.util.Set;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import ca.teranet.pages.polaris.DocumentDetailPage;
import ca.teranet.pages.polaris.ELRSPage;
import ca.teranet.pages.polaris.ResultsForSearchByNamePage;
import ca.teranet.pages.polaris.SearchByNamePage;
import ca.teranet.pages.polaris.SearchChargeTermsAndAgreementPage;
import ca.teranet.pages.polaris.SearchDocumentPage;
import ca.teranet.pages.polaris.SearchHwyTCPLPage;
import ca.teranet.pages.polaris.SearchNameAddressPage;
import ca.teranet.pages.polaris.SearchNameAddressResultPage;
import ca.teranet.pages.polaris.SearchPOAPage;
import ca.teranet.pages.polaris.SearchRegisterPage;
import ca.teranet.pages.polaris.SearchResultsCommonPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;
import net.serenitybdd.core.annotations.findby.By;

public class Search extends Utility {
	SearchDocumentPage searchDocumentPage;
	ELRSCommonSteps elrscommon;
	SearchNameAddressPage searchNameAddressPage;
	SearchNameAddressResultPage searchNameAddressResultPage;
	SearchChargeTermsAndAgreementPage searchChargeTermsAndAgreementPage;
	LogSteps logSteps = new LogSteps();
	SearchPOAPage searchPOAPage;
	ELRSPage elrsPage;
	DocumentDetailPage documentDetailPage;
	ResultsForSearchByNamePage resultsForSearchByNamePage;
	SearchHwyTCPLPage searchHwyTCPLPage;
	public String mainWindowHandle = null;
	SearchResultsCommonPage searchResultsCommonPage;
	SearchRegisterPage searchRegisterPage;
	SearchByNamePage searchByNamePage;
	@When("user clicks on Cancel button and clicks on OK button on popup $shtName and $intRow")
	public boolean user_click_on_cancel_and_click_on_ok_on_popup(String shtName, String intRow) {
		boolean Search_Document_Cancel = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			searchDocumentPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			searchDocumentPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			return Search_Document_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button and clicks on Cancel button on popup $shtName and $intRow")
	public boolean user_click_on_cancel_and_click_on_cancel_on_popup(String shtName, String intRow) {
		boolean Search_Document_Cancel = false;
		try {
			String strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			searchDocumentPage.RegNumber_WebEdit.sendKeys(strRegNumber);
			searchDocumentPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			return Search_Document_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button and clicks on Cancel button on popup")
	public boolean user_click_on_cancel_and_click_on_cancel_on_popup() {
		boolean Search_Document_Cancel = false;
		try {
			searchDocumentPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			return Search_Document_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button and clicks on OK button on popup")
	public boolean user_click_on_cancel_and_click_on_ok_on_popup() {
		boolean Search_Document_Cancel = false;
		try {
			searchDocumentPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			return Search_Document_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Search button on Search page with $shtName and $intRow")
	public boolean user_click_Search_on_Search_page(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_Search";
			boolean Search_NameAddress_Search = false;
			boolean intRet = false;
			if (searchNameAddressPage.IncludeActiveCharge_WebCheckBox.isSelected()) {
				searchNameAddressPage.IncludeActiveCharge_WebCheckBox.click();
			}
			if (searchNameAddressPage.IncludeDeletedDoc_WebCheckBox.isSelected()) {
				searchNameAddressPage.IncludeDeletedDoc_WebCheckBox.click();
			}
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			System.out.println(strLastName);
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			System.out.println(strGivenName);
			String strIncludeActive = GetValueIfValid("IncludeActiveChargeDocuments", shtName, Integer.parseInt(intRow));
			System.out.println(strIncludeActive);
			String strIncludeDeleted = GetValueIfValid("IncludeDeletedDocuments", shtName, Integer.parseInt(intRow));
			String strStreetNumber = GetValueIfValid("StreetNumber", shtName, Integer.parseInt(intRow));
			String strSuffix = GetValueIfValid("Suffix", shtName, Integer.parseInt(intRow));
			String strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow));
			String strCityTown = GetValueIfValid("CityTown", shtName, Integer.parseInt(intRow));
			String strUnitType = GetValueIfValid("UnitType", shtName, Integer.parseInt(intRow));
			String strUnitNumber = GetValueIfValid("UnitNumber", shtName, Integer.parseInt(intRow));
			searchNameAddressPage.LastName_WebEdit.sendKeys(strLastName);
			searchNameAddressPage.GivenName_WebEdit.clear();
			searchNameAddressPage.GivenName_WebEdit.sendKeys(strGivenName);
			if (strIncludeActive.equalsIgnoreCase("On")) {
				searchNameAddressPage.IncludeActiveCharge_WebCheckBox.click();
			}
			if (strIncludeDeleted.equalsIgnoreCase("On")) {
				searchNameAddressPage.IncludeDeletedDoc_WebCheckBox.click();
			}
			searchNameAddressPage.StreetNumber_WebEdit.clear();
			searchNameAddressPage.StreetNumber_WebEdit.sendKeys(strStreetNumber);
			searchNameAddressPage.Suffix_WebEdit.clear();
			searchNameAddressPage.Suffix_WebEdit.sendKeys(strSuffix);
			searchNameAddressPage.StreetName_WebEdit.clear();
			searchNameAddressPage.StreetName_WebEdit.sendKeys(strStreetName);
			searchNameAddressPage.CityTown_WebEdit.clear();
			searchNameAddressPage.CityTown_WebEdit.sendKeys(strCityTown);
			searchNameAddressPage.UnitType_WebList.selectByVisibleText(strUnitType.toUpperCase());
			searchNameAddressPage.UnitNumber_WebEdit.clear();
			searchNameAddressPage.UnitNumber_WebEdit.sendKeys(strUnitNumber);
			String strErrorMsgs = null;
			String strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			searchNameAddressPage.Search_WebButton.click();
			VerifyApplicationError();
			if (searchNameAddressPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = searchNameAddressPage.ErrorMsg_WebTable.getText().trim();
				System.out.println(strErrorMsgs);
				if (!strErrorMsgs.isEmpty()) {
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
				}
			}
			final String strAddressResultHeader = "Result for Search by Address";
			final String strNameResultHeader = "Result for Search by Name/Address";
			final String strActualHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			switch (strActualHeader) {
			case strAddressResultHeader:
				intRet = Search_NameAddress_Verify_AddressResults(shtName, intRow);
				break;
			case strNameResultHeader:
				intRet = Search_NameAddress_Verify_NameResults(shtName, intRow);
				break;
			default:
				return false;
			}
			Search_NameAddress_Search = intRet;
			return Search_NameAddress_Search;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_NameAddress_Verify_NameResults(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_Verify_NameResults";
			boolean Search_NameAddress_Verify_NameResults = false;
			String strStreetName = null;
			String strLastName = null;
			String strExpectedAddress = null;
			strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow)).toUpperCase();
			strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow)).toUpperCase();
			if (strStreetName.equals("IGNORE_VALUE")) {
				strStreetName = "";
			}
			if (!searchNameAddressResultPage.RequestedAddress_WebEdit.isPresent()) {
				return false;
			}
			String strRequestedAddress = null;
			String strActualLastName = null;
			String strReport = null;
			strRequestedAddress = searchNameAddressResultPage.RequestedAddress_WebEdit.getAttribute("value").trim();
			strActualLastName = searchNameAddressResultPage.LastName_WebEdit.getAttribute("value").trim();
			if (strRequestedAddress.isEmpty()) {
				if (!strStreetName.isEmpty()) {
					return false;
				} else {
					if (!(strComp(strActualLastName, strLastName) == 0)) {
						return false;
					} else {
						strReport = "Last Name or Corporation Name: <" + strLastName + ">";
					}
				}
			} else {
				if (!(InStr(strRequestedAddress, strStreetName) > 0)) {
					return false;
				} else {
					strReport = "Requested Address: <" + strRequestedAddress + ">";
				}
			}
			if (!searchNameAddressResultPage.TotalCountOfSearch_WebEdit.isPresent()) {
				return false;
			}
			String strTotalCounts = null;
			strTotalCounts = searchNameAddressResultPage.TotalCountOfSearch_WebEdit.getAttribute("value").trim();
			if (!isNumeric(strTotalCounts)) {
				return false;
			}
			if (!searchNameAddressResultPage.NameResults_WebTable.isPresent()) {
				return false;
			}
			String oWebTable = null;
			int intCount = 0;
			if (!strActualLastName.isEmpty()) {
				String strCellData = null;
				if (!(strComp(strCellData, strActualLastName) == 0)) {
					return false;
				}
			}
			if (!(intCount == Math.round(Integer.parseInt(strTotalCounts)))) {
				return false;
			}
			Search_NameAddress_Verify_NameResults = true;
			return Search_NameAddress_Verify_NameResults;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_NameAddress_Verify_AddressResults(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_Verify_AddressResults";
			boolean Search_NameAddress_Verify_AddressResults = true;
			String strStreetNumber = null;
			String strStreetName = null;
			strStreetNumber = GetValueIfValid("StreetNumber", shtName, Integer.parseInt(intRow)).toUpperCase();
			System.out.println(strStreetNumber);
			strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow)).toUpperCase();
			System.out.println(strStreetName);
			String strActualStreetNumber = null;
			String strActualStreetName = null;
			strActualStreetNumber = searchNameAddressResultPage.StreetNumber_WebEdit.getAttribute("value").trim();
			System.out.println(strActualStreetNumber);
			strActualStreetName = searchNameAddressResultPage.StreetName_WebEdit.getAttribute("value").trim();
			System.out.println(strActualStreetName);
			if (!(strComp(strActualStreetNumber, strStreetNumber) == 0)) {
				if (!(strComp(strActualStreetName, strStreetName) == 0)) {
					System.out.println("Verification successfully completed");
				} else {
					System.out.println("Verification not completed");
				}
				Search_NameAddress_Verify_AddressResults = false;
				return false;
			}
			if (!(strComp(strActualStreetName, strStreetName) == 0)) {
				Search_NameAddress_Verify_AddressResults = false;
				return false;
			}
			if (!searchNameAddressResultPage.AddressResults_WebTable.isPresent()) {
				Search_NameAddress_Verify_AddressResults = false;
				return false;
			}
			String oWebTable = null;
			int intCount = 0;
			int intRowCount = 0;
			String strCellData = null;
			intCount = intRowCount - 1;
			for (int iLoop = 2; iLoop <= intRowCount; iLoop++) {
				strCellData = getCellData(searchNameAddressResultPage.AddressResults_WebTable, iLoop, 1).trim();
				if (!(InStr(strCellData, strStreetName) > 0)) {
					Search_NameAddress_Verify_AddressResults = false;
				}
			}
			oWebTable = null;
			if (Search_NameAddress_Verify_AddressResults == false) {
				return false;
			}
			Search_NameAddress_Verify_AddressResults = true;
			return Search_NameAddress_Verify_AddressResults;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Ok button on Search page $shtName and $intRow")
	public boolean user_click_Ok_on_Search_page(String strAction, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_Cancel";
			boolean Search_NameAddress_Cancel = false;
			boolean intRet = false;
			// Enter data only data provided
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			System.out.println(strLastName);
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			System.out.println(strGivenName);
			String strIncludeActive = GetValueIfValid("IncludeActiveChargeDocuments", shtName, Integer.parseInt(intRow));
			String strIncludeDeleted = GetValueIfValid("IncludeDeletedDocuments", shtName, Integer.parseInt(intRow));
			String strStreetNumber = GetValueIfValid("StreetNumber", shtName, Integer.parseInt(intRow));
			String strSuffix = GetValueIfValid("Suffix", shtName, Integer.parseInt(intRow));
			String strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow));
			String strCityTown = GetValueIfValid("CityTown", shtName, Integer.parseInt(intRow));
			String strUnitType = GetValueIfValid("UnitType", shtName, Integer.parseInt(intRow));
			String strUnitNumber = GetValueIfValid("UnitNumber", shtName, Integer.parseInt(intRow));
			searchNameAddressPage.LastName_WebEdit.sendKeys(strLastName);
			searchNameAddressPage.GivenName_WebEdit.clear();
			searchNameAddressPage.GivenName_WebEdit.sendKeys(strGivenName);
			searchNameAddressPage.IncludeActiveCharge_WebCheckBox.sendKeys(strIncludeActive);
			searchNameAddressPage.IncludeDeletedDoc_WebCheckBox.sendKeys(strIncludeDeleted);
			searchNameAddressPage.StreetNumber_WebEdit.clear();
			searchNameAddressPage.StreetNumber_WebEdit.sendKeys(strStreetNumber);
			searchNameAddressPage.Suffix_WebEdit.clear();
			searchNameAddressPage.Suffix_WebEdit.sendKeys(strSuffix);
			searchNameAddressPage.StreetName_WebEdit.clear();
			searchNameAddressPage.StreetName_WebEdit.sendKeys(strStreetName);
			searchNameAddressPage.CityTown_WebEdit.clear();
			searchNameAddressPage.CityTown_WebEdit.sendKeys(strCityTown);
			searchNameAddressPage.UnitType_WebList.selectByVisibleText(strUnitType.toUpperCase());
			searchNameAddressPage.UnitNumber_WebEdit.clear();
			searchNameAddressPage.UnitNumber_WebEdit.sendKeys(strUnitNumber);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Search page $shtName and $intRow")
	public boolean user_click_Cancel_on_Search_page(String strAction, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_Cancel";
			boolean Search_NameAddress_Cancel = false;
			boolean intRet = false;
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			System.out.println(strLastName);
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			System.out.println(strGivenName);
			String strStreetNumber = GetValueIfValid("StreetNumber", shtName, Integer.parseInt(intRow));
			String strSuffix = GetValueIfValid("Suffix", shtName, Integer.parseInt(intRow));
			String strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow));
			String strCityTown = GetValueIfValid("CityTown", shtName, Integer.parseInt(intRow));
			String strUnitType = GetValueIfValid("UnitType", shtName, Integer.parseInt(intRow));
			String strUnitNumber = GetValueIfValid("UnitNumber", shtName, Integer.parseInt(intRow));
			searchNameAddressPage.LastName_WebEdit.sendKeys(strLastName);
			searchNameAddressPage.GivenName_WebEdit.clear();
			searchNameAddressPage.GivenName_WebEdit.sendKeys(strGivenName);
			searchNameAddressPage.StreetNumber_WebEdit.clear();
			searchNameAddressPage.StreetNumber_WebEdit.sendKeys(strStreetNumber);
			searchNameAddressPage.Suffix_WebEdit.clear();
			searchNameAddressPage.Suffix_WebEdit.sendKeys(strSuffix);
			searchNameAddressPage.StreetName_WebEdit.clear();
			searchNameAddressPage.StreetName_WebEdit.sendKeys(strStreetName);
			searchNameAddressPage.CityTown_WebEdit.clear();
			searchNameAddressPage.CityTown_WebEdit.sendKeys(strCityTown);
			searchNameAddressPage.UnitType_WebList.selectByVisibleText(strUnitType.toUpperCase());
			searchNameAddressPage.UnitNumber_WebEdit.clear();
			searchNameAddressPage.UnitNumber_WebEdit.sendKeys(strUnitNumber);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Search page")
	public boolean user_click_Cancel_on_Search_page() {
		boolean Search_NameAddress_Cancel = false;
		try {
			WaitUtil.waitMSeconds(1000);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Ok button on Search page")
	public boolean user_click_Ok_on_Search_page() {
		boolean Search_NameAddress_Cancel = false;
		try {
			WaitUtil.waitMSeconds(1000);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(1000);
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on search on SearchPOA $shtName and $intRow")
	public boolean user_click_on_search_on_SearchPOA(String shtName, String intRow) {
		try {
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			searchPOAPage.LastName_WebEdit.clear();
			searchPOAPage.LastName_WebEdit.sendKeys(strLastName);
			searchPOAPage.GivenName_WebEdit.clear();
			searchPOAPage.GivenName_WebEdit.sendKeys(strGivenName);
			searchPOAPage.Search_WebButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Then("user verify error message $shtName and $intRow")
	public boolean user_verify_error_message(String shtName, String intRow) {
		try {
			String expErrorMsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String actualErrorMsg = searchPOAPage.ErrorMsg_WebTable.getText();
			if (expErrorMsg.contains(actualErrorMsg)) {
				logSteps.execution_log("Error Messages Matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Then("user verify error no results found $shtName and $intRow")
	public boolean user_verify_error_message_for_no_results_found(String shtName, String intRow) {
		try {
			String expErrorMsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String actualErrorMsg = searchPOAPage.ErrorMsgNoResultsFound_WebTable.getText();
			if (expErrorMsg.equalsIgnoreCase(actualErrorMsg)) {
				logSteps.execution_log("Error Messages Matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@When("user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page $shtName and $intRow")
	public boolean Search_StandardChargeTermsAndAgreement_Search(String strPage, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Search";
			boolean Search_StandardChargeTermsAndAgreement_Search = false;
			String strSortBy = null;
			String strSearchBy = null;
			strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
			strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));

			if (strSortBy.isEmpty()) {
				strSortBy = "IGNORE_VALUE";
			}
			if (strSearchBy.isEmpty()) {
				strSearchBy = "IGNORE_VALUE";
			} else {
				if (strSearchBy.toUpperCase() == "FILENUMBER" || strSearchBy.toUpperCase() == "FILE NUMBER") {
					strSearchBy = "Number";
				}
			}
			boolean intRet = false;
			if (!strSortBy.equals("IGNORE_VALUE") || !strSearchBy.equals("IGNORE_VALUE")) {
				intRet = Search_StandardChargeTermsAndAgreement_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				}
			}
			searchChargeTermsAndAgreementPage.Search_WebButton.click();
			VerifyApplicationError();
			if (searchChargeTermsAndAgreementPage.ErrorMsg_WebTable.isPresent()) {
				String strResultPage = null;
				switch (strPage.toUpperCase()) {
				case "STANDARDCHARGETERMS":
					strResultPage = "Search Standard Charge Terms By " + strSearchBy + " Results";
					break;
				case "STANDARDTERMSOFAGREEMENT":
					strResultPage = "Search Standard Terms of Agreement " + strSearchBy + " Results";
					break;
				}
				if (!searchChargeTermsAndAgreementPage.ResultsHeader_WebElement.isPresent()) {
					return false;
				}
				intRet = Search_StandardChargeTermsAndAgreement_Verify_SortBy(strSortBy);
				if (intRet == false) {
					return false;
				}
				intRet = Search_StandardChargeTermsAndAgreement_Verify_SearchBy(strSearchBy);
				if (intRet == false) {
					return false;
				}
				if (!searchChargeTermsAndAgreementPage.ResultsTable_WebTable.isVisible()) {
					return false;
				}
				Search_StandardChargeTermsAndAgreement_Search = true;
				return Search_StandardChargeTermsAndAgreement_Search;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean verifyErrorMessage(String strStepName, String shtName, String intRow) {
		try {
			strStepName = "verifyErrorMessage";
			String strExpectedMsgs = null;
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			String strErrorMsgs = null;
			strErrorMsgs = getCellData(searchChargeTermsAndAgreementPage.ErrorMsg_WebTable, 1, 1).trim();
			VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
			logSteps.execution_log("Error message matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean Search_StandardChargeTermsAndAgreement_EnterData(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_EnterData";
			boolean Search_StandardChargeTermsAndAgreement_EnterData = false;
			String strSortBy = null;
			String strSearchBy = null;
			String strStartDate = null;
			String strEndDate = null;
			String strLastName = null;
			String strGivenName = null;
			String strFileNumber = null;
			strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
			strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
			String oPage = null;
			if (!strSortBy.isEmpty() && !strSortBy.equals("IGNORE_VALUE")) {
				switch (strSortBy.toUpperCase()) {
				case "DATE":
					searchChargeTermsAndAgreementPage.SortByDate_WebRadioGroup.click();
					break;
				case "NAME":
					searchChargeTermsAndAgreementPage.SortByName_WebRadioGroup.click();
					break;
				case "NUMBER":
				case "FILENUMBER":
				case "FILE NUMBER":
					searchChargeTermsAndAgreementPage.SortByNumber_WebRadioGroup.click();
					break;
				default:
					oPage = null;
					return false;
				}
			}
			if (!strSearchBy.isEmpty() && !strSearchBy.equals("IGNORE_VALUE")) {
				switch (strSearchBy.toUpperCase()) {
				case "DATE":
					searchChargeTermsAndAgreementPage.SearchByDate_WebRadioGroup.click();
					strStartDate = GetValueIfValid("StartDate", shtName, Integer.parseInt(intRow));
					strEndDate = GetValueIfValid("EndDate", shtName, Integer.parseInt(intRow));
					searchChargeTermsAndAgreementPage.StartDate_WebEdit.clear();
					searchChargeTermsAndAgreementPage.StartDate_WebEdit.sendKeys(strStartDate);
					searchChargeTermsAndAgreementPage.EndDate_WebEdit.clear();
					searchChargeTermsAndAgreementPage.EndDate_WebEdit.sendKeys(strEndDate);
					break;
				case "NAME":
					searchChargeTermsAndAgreementPage.SearchByName_WebRadioGroup.click();
					strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
					strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
					searchChargeTermsAndAgreementPage.LastName_WebEdit.clear();
					searchChargeTermsAndAgreementPage.LastName_WebEdit.sendKeys(strLastName);
					searchChargeTermsAndAgreementPage.GivenName_WebEdit.clear();
					searchChargeTermsAndAgreementPage.GivenName_WebEdit.sendKeys(strGivenName);
					break;
				case "NUMBER":
				case "FILENUMBER":
				case "FILE NUMBER":
					searchChargeTermsAndAgreementPage.SearchByNumber_WebRadioGroup.click();
					strFileNumber = GetValueIfValid("FileNumber", shtName, Integer.parseInt(intRow));
					searchChargeTermsAndAgreementPage.FileNumber_WebEdit.clear();
					searchChargeTermsAndAgreementPage.FileNumber_WebEdit.sendKeys(strFileNumber);
					break;
				default:
					oPage = null;
					return false;
				}
			}
			Search_StandardChargeTermsAndAgreement_EnterData = true;
			return Search_StandardChargeTermsAndAgreement_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_StandardChargeTermsAndAgreement_Verify_SortBy(String strExpectedOption) {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Verify_SortBy";
			boolean Search_StandardChargeTermsAndAgreement_Verify_SortBy = false;
			int intSortBy = 0;
			if (strExpectedOption.isEmpty()) {
				strExpectedOption = "IGNORE_VALUE";
			} else {
				switch (strExpectedOption.toUpperCase()) {
				case "DATE":
					intSortBy = 1;
					break;
				case "NAME":
					intSortBy = 2;
					break;
				case "NUMBER":
					intSortBy = 3;
					break;
				}
			}
			if (!strExpectedOption.equals("IGNORE_VALUE")) {
				int intActualSortBy = 0;
				int intActualSortDate = 0;
				int intActualSortName = 0;
				int intActualSortNumber = 0;
				intActualSortDate = Math.round(Integer.parseInt(searchChargeTermsAndAgreementPage.SortByDate_WebRadioGroup.getAttribute("selected item index").trim()));
				intActualSortName = Math.round(Integer.parseInt(searchChargeTermsAndAgreementPage.SortByName_WebRadioGroup.getAttribute("selected item index").trim()));
				intActualSortNumber = Math.round(Integer.parseInt(searchChargeTermsAndAgreementPage.SortByNumber_WebRadioGroup.getAttribute("selected item index").trim()));
				String intActualSortByDate = String.valueOf(intActualSortDate);
				String intActualSortByName = String.valueOf(intActualSortName);
				String intActualSortByNumber = String.valueOf(intActualSortNumber);

				switch (intActualSortBy) {
				case 1:
					intActualSortByDate = "Date";
					break;
				case 2:
					intActualSortByName = "Name";
					break;
				case 3:
					intActualSortByNumber = "Number";
					break;
				}
				if (!(intActualSortBy == intSortBy)) {
					return false;
				}
			}
			Search_StandardChargeTermsAndAgreement_Verify_SortBy = true;
			return Search_StandardChargeTermsAndAgreement_Verify_SortBy;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_StandardChargeTermsAndAgreement_Verify_SearchBy(String strExpectedOption) {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Cancel";
			boolean Search_StandardChargeTermsAndAgreement_Verify_SearchBy = false;
			int intSearchBy = 0;
			if (strExpectedOption.isEmpty()) {
				strExpectedOption = "IGNORE_VALUE";
			} else {
				switch (strExpectedOption.toUpperCase()) {
				case "DATE":
					intSearchBy = 1;
					break;
				case "NAME":
					intSearchBy = 2;
					break;
				case "NUMBER":
				case "FILENUMBER":
				case "FILE NUMBER":
					intSearchBy = 3;
					strExpectedOption = "Number";
					break;
				}
			}
			if (!strExpectedOption.equals("IGNORE_VALUE")) {
				String strActualSearchByName;
				String strActualSearchByDate;
				String strActualSearchByNumber;
				if (searchChargeTermsAndAgreementPage.SearchByDate_WebRadioGroup.isSelected()) {
					strActualSearchByName = "Date";
					logSteps.execution_log("Search By Date");
				}
				if (searchChargeTermsAndAgreementPage.SearchByName_WebRadioGroup.isSelected()) {
					strActualSearchByDate = "Name";
					logSteps.execution_log("Search By name");
				}
				if (searchChargeTermsAndAgreementPage.SearchByNumber_WebRadioGroup.isSelected()) {
					strActualSearchByNumber = "Number";
					logSteps.execution_log("Search By Number");
				}
			}
			Search_StandardChargeTermsAndAgreement_Verify_SearchBy = true;
			return Search_StandardChargeTermsAndAgreement_Verify_SearchBy;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Search POA page $shtName and $intRow")
	public boolean user_click_Cancel_on_Search_POA_page(String shtName, String intRow) {
		try {
			boolean Search_NameAddress_Cancel = false;
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			searchNameAddressPage.LastName_WebEdit.clear();
			searchNameAddressPage.LastName_WebEdit.sendKeys(strLastName);
			searchNameAddressPage.GivenName_WebEdit.clear();
			searchNameAddressPage.GivenName_WebEdit.sendKeys(strGivenName);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button and clicks on OK button on Search POA $shtName and $intRow")
	public boolean user_click_on_cancel_and_click_on_ok_on_search_poa(String shtName, String intRow) {
		boolean Search_Document_Cancel = false;
		try {
			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			searchNameAddressPage.LastName_WebEdit.clear();
			searchNameAddressPage.LastName_WebEdit.sendKeys(strLastName);
			searchNameAddressPage.GivenName_WebEdit.clear();
			searchNameAddressPage.GivenName_WebEdit.sendKeys(strGivenName);
			searchNameAddressPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			return Search_Document_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Standard Charge Terms And Agreement Criteria page")
	public boolean user_click_cancel_on_standard_charge_terms_and_agreement() {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Cancel";
			boolean Search_StandardChargeTermsAndAgreement_Cancel = false;
			// Click Cancel button
			searchChargeTermsAndAgreementPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(1000);
			Search_StandardChargeTermsAndAgreement_Cancel = true;
			return Search_StandardChargeTermsAndAgreement_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page $strPage and $shtName and $intRow")
	public boolean user_click_cancel_on_standard_charge_terms_and_agreement(String strPage, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Cancel";
			boolean Search_StandardChargeTermsAndAgreement_Cancel = false;
			boolean intRet = false;
			String strSortBy = null;
			String strSearchBy = null;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_StandardChargeTermsAndAgreement_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				} else {
					strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
					strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
				}
			}
			searchChargeTermsAndAgreementPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(1000);
			String strPageHeader = null;
			String strActualHeader = null;
			switch (strPage.toUpperCase()) {
			case "STANDARDCHARGETERMS":
				strPageHeader = "Standard Charge Terms Selection Criteria";
				break;
			case "STANDARDTERMSOFAGREEMENT":
				strPageHeader = "Standard Terms of Agreement Selection Criteria";
				break;
			}
			if (!searchChargeTermsAndAgreementPage.Header_WebElement.isPresent()) {
				return false;
			}
			strActualHeader = searchChargeTermsAndAgreementPage.Header_WebElement.getText().trim();
			System.out.println(strActualHeader);
			/*
			 * if (!(strComp(strActualHeader, strPageHeader) == 0)) { logSteps.execution_log("Compared Successfully"); }
			 */
			intRet = Search_StandardChargeTermsAndAgreement_Verify_SortBy(strSortBy);
			if (intRet == false) {
				return false;
			}
			intRet = Search_StandardChargeTermsAndAgreement_Verify_SearchBy(strSearchBy);
			if (intRet == false) {
				return false;
			}
			Search_StandardChargeTermsAndAgreement_Cancel = true;
			return Search_StandardChargeTermsAndAgreement_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Ok button on Standard Charge Terms And Agreement Criteria page")
	public boolean user_click_Ok_on_standard_charge_terms_and_agreement() {

		try {
			boolean Search_StandardChargeTermsAndAgreement_Cancel = false;
			searchChargeTermsAndAgreementPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(1000);
			Search_StandardChargeTermsAndAgreement_Cancel = true;
			return Search_StandardChargeTermsAndAgreement_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page $shtName and $intRow")
	public boolean user_click_Ok_on_standard_charge_terms_and_agreement(String strPage, String strAction, String shtName, String intRow) {

		try {
			String strStepName = null;
			strStepName = "Search_StandardChargeTermsAndAgreement_Cancel";
			boolean Search_StandardChargeTermsAndAgreement_Cancel = false;
			boolean intRet = false;
			String strSortBy = null;
			String strSearchBy = null;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_StandardChargeTermsAndAgreement_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				} else {
					strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
					strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
				}
			}
			searchChargeTermsAndAgreementPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(1000);
			String strPageHeader = null;
			String strActualHeader = null;
			switch (strPage.toUpperCase()) {
			case "STANDARDCHARGETERMS":
				strPageHeader = "Standard Charge Terms Selection Criteria";
				break;
			case "STANDARDTERMSOFAGREEMENT":
				strPageHeader = "Standard Terms of Agreement Selection Criteria";
				break;
			}
			if (!searchChargeTermsAndAgreementPage.Header_WebElement.isPresent()) {
				return false;
			}
			strActualHeader = searchChargeTermsAndAgreementPage.Header_WebElement.getText().trim();
			if (!(strComp(strActualHeader, strPageHeader) == 0)) {
				return false;
			}
			intRet = Search_StandardChargeTermsAndAgreement_Verify_SortBy(strSortBy);
			if (intRet == false) {
				return false;
			}
			intRet = Search_StandardChargeTermsAndAgreement_Verify_SearchBy(strSearchBy);
			if (intRet == false) {
				return false;
			}
			Search_StandardChargeTermsAndAgreement_Cancel = true;
			return Search_StandardChargeTermsAndAgreement_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on RegNo link on SearchPOA $shtName and $intRow")
	public boolean Search_POA_SelectRegNo(String shtName, String intRow) {
		try {
			boolean Search_SearchByName_SelectRegNo = false;
			String strRegNo = null;
			strRegNo = GetValueIfValid("RegNo", shtName, Integer.parseInt(intRow)).toUpperCase();
			mainWindowHandle = mainPage.getDriver().getWindowHandle();
			mainPage.getDriver().findElement(By.xpath("//a[contains(@onclick,'makeDocumentViewWindow')]")).click();
			WaitUtil.waitMSeconds(3000);
			Search_SearchByName_SelectRegNo = true;
			return Search_SearchByName_SelectRegNo;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Close in Document Detail popup")

	public boolean DocumentDetailPopup_Close() throws Throwable {

		try {

			boolean DocumentDetailPopup_Close = true;

			String mainWindowHandle = mainPage.getDriver().getWindowHandle();

			Set<String> multipleWindows = mainPage.getDriver().getWindowHandles();

			for (String currentwindow : multipleWindows) {

				if (!(mainWindowHandle.equals(currentwindow))) {

					mainPage.getDriver().switchTo().window(currentwindow);

				}

			}

			WaitUtil.waitMSeconds(3000);

			documentDetailPage.Close_WebButton.click();

			WaitUtil.waitMSeconds(3000);

			mainPage.getDriver().switchTo().window(mainWindowHandle);

			WaitUtil.waitMSeconds(3000);

			mainPage.getDriver().switchTo().defaultContent();

			mainPage.getDriver().switchTo().frame(0);

			return DocumentDetailPopup_Close;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user clicks on New Search on SearchPOA")
	@Alias("user clicks on New Search on SearchFType")
	public boolean Search_SearchByName_NewSearch() {
		try {
			boolean Search_SearchByName_NewSearch = false;
			WaitUtil.waitMSeconds(3000);
			mainPage.getDriver().switchTo().defaultContent();
			mainPage.getDriver().switchTo().frame(0);
			// JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
			// js.executeScript("arguments[0].click();", mainPage.getDriver().findElement(By.xpath("//input[@value='New Search']")));
			resultsForSearchByNamePage.NewSearch_WebButton.click();
			WaitUtil.waitMSeconds(1000);
			Search_SearchByName_NewSearch = true;
			return Search_SearchByName_NewSearch;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Close in SearchPOA")
	@Alias("user clicks on Close in SearchFType")
	public boolean Search_SearchByName_Close() {
		try {
			boolean Search_SearchByName_Close = false;
			mainPage.getDriver().switchTo().defaultContent();
			mainPage.getDriver().switchTo().frame(0);
			if (!resultsForSearchByNamePage.Header_WebElement.isPresent()) {
				logSteps.execution_log("<Results for Search by Name> page Not displayed - UnSuccessful");
				return false;
			}
			// resultsForSearchByNamePage.Close_WebButton.click();
			JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
			js.executeScript("arguments[0].click();", mainPage.getDriver().findElement(By.xpath("//input[@value='Close']")));
			Search_SearchByName_Close = true;
			return Search_SearchByName_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user search Cancel button on TransCanada Pipeline")
	public boolean Search_HwyTCPL_Cancel() {
		boolean Search_HwyTCPL_Cancel = false;
		try {
			Thread.sleep(1000);
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			Search_HwyTCPL_Cancel = true;
			return Search_HwyTCPL_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user click on OK button on TransCanada Pipeline $shtName and $intRow")
	public boolean Search_HwyTCPL_Cancel(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_Cancel";
			boolean Search_HwyTCPL_Cancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_HWY_EnterData(shtName, intRow);
			}
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			Search_HwyTCPL_Cancel = true;
			return Search_HwyTCPL_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user search OK button on TransCanada Pipeline")
	public boolean user_click_Ok_on_TCPL_page() {
		boolean Search_NameAddress_Cancel = false;
		try {
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			Search_NameAddress_Cancel = true;
			return Search_NameAddress_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify user navigates to main menu")
	public boolean user_navigates_to_main_menu() {
		try {
			VerifyPage("Main Menu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@When("user search Cancel button on TransCanada Pipeline $shtName and $intRow")
	public boolean user_click_on_cancel_TCPL(String shtName, String intRow) {
		// Object Search_HwyTCPL_Cancel = null;
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_Cancel";
			boolean Search_HwyTCPL_Cancel = false;
			boolean intRet = false;
			// Enter data only data provided
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_TCPL_EnterData(shtName, intRow);
			}
			if (intRet == false) {
				return false;
			}
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			WaitUtil.waitMSeconds(2000);
			Search_HwyTCPL_Cancel = true;
			return Search_HwyTCPL_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user search OK button on TransCanada Pipeline $shtName and $intRow")
	public boolean user_click_Ok_on_TCPL_page(String shtName, String intRow) {
		// Object Search_HwyTCPL_Cancel = null;
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_Cancel";
			boolean Search_HwyTCPL_Cancel = false;
			boolean intRet = false;
			// Enter data only data provided
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_HWY_EnterData(shtName, intRow);
			}
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			Search_HwyTCPL_Cancel = true;
			return Search_HwyTCPL_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_HWY_EnterData(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_HWY_EnterData";
			boolean Search_HWY_EnterData = false;
			String strSortBy = null;
			String strSearchBy = null;
			String strStartDate = null;
			String strEndDate = null;
			String strHwyMunicipalityAction = null;
			String strHwyMunicipalityIndex = null;
			String strHwyMunicipalityList = null;
			String strPlanNumber1 = null;
			String strPlanNumber2 = null;
			String strHwyNumber1 = null;
			String strHwyNumber2 = null;
			String strRegNumber = null;
			String strIncludeDeletedDocuments = null;
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
			strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
			strStartDate = GetValueIfValid("StartDate", shtName, Integer.parseInt(intRow));
			strEndDate = GetValueIfValid("EndDate", shtName, Integer.parseInt(intRow));
			strHwyMunicipalityAction = GetValueIfValid("HwyMunicipalityAction", shtName, Integer.parseInt(intRow));
			strHwyMunicipalityIndex = GetValueIfValid("HwyMunicipalityIndex", shtName, Integer.parseInt(intRow));
			strHwyMunicipalityList = GetValueIfValid("HwyMunicipalityList", shtName, Integer.parseInt(intRow));
			strPlanNumber1 = GetValueIfValid("PlanNumber1", shtName, Integer.parseInt(intRow));
			strPlanNumber2 = GetValueIfValid("PlanNumber2", shtName, Integer.parseInt(intRow));
			strHwyNumber1 = GetValueIfValid("HwyNumber1", shtName, Integer.parseInt(intRow));
			strHwyNumber2 = GetValueIfValid("HwyNumber2", shtName, Integer.parseInt(intRow));
			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));
			strIncludeDeletedDocuments = GetValueIfValid("IncludeDeletedDocuments", shtName, Integer.parseInt(intRow));
			String oPage = null;
			boolean intRet = false;
			if (!strSortBy.isEmpty() && !strSortBy.equals("IGNORE_VALUE")) {
				switch (strSortBy.toUpperCase()) {
				case "DATE":
					if (!searchHwyTCPLPage.SortBy_Date.isSelected()) {
						searchHwyTCPLPage.SortBy_Date.click();
					}
					break;
				case "MUNICIPALITY":
					if (!searchHwyTCPLPage.SortBy_Municipality.isSelected()) {
						searchHwyTCPLPage.SortBy_Municipality.click();
					}
					break;
				case "HIGHWAYNUMBER":
				case "HIGHWAY NUMBER":
				case "HWYNUMBER":
					if (!searchHwyTCPLPage.SortBy_Date.isSelected()) {
						searchHwyTCPLPage.SortBy_Date.click();
					}
					break;
				case "REGISTRATIONNUMBER":
				case "REGISTRATION NUMBER":
				case "REGNUMBER":
					if (!searchHwyTCPLPage.SortBy_Municipality.isSelected()) {
						searchHwyTCPLPage.SortBy_Municipality.click();
					}
					break;
				default:
					oPage = null;
					return false;

				}
			}
			if (!strSearchBy.isEmpty() && !strSearchBy.equals("IGNORE_VALUE")) {
				if (InStr(strSearchBy, ";") > 0) {
					String[] arrSearchBy = null;
					int intCounts = 0;
					String strSearchByOption = null;
					arrSearchBy = (strSearchBy).split(";");
					intCounts = ubound(arrSearchBy) + 1;
					for (int iLoop = 1; iLoop <= intCounts; iLoop++) {
						strSearchByOption = arrSearchBy[iLoop - 1];
						intRet = Search_HWY_EnterData_SetSearchByOption(strSearchByOption, oPage);
						if (intRet == false) {
							oPage = null;
							return false;
						}
					}
				} else {
					intRet = Search_HWY_EnterData_SetSearchByOption(strSearchBy, oPage);
					if (intRet == false) {
						oPage = null;
						return false;
					}
				}
			}
			searchHwyTCPLPage.StartDate_WebEdit.clear();
			searchHwyTCPLPage.StartDate_WebEdit.sendKeys(strStartDate);
			searchHwyTCPLPage.EndDate_WebEdit.clear();
			searchHwyTCPLPage.EndDate_WebEdit.sendKeys(strEndDate);
			int intHwyMunicipalityIndex = 0;
			if (isNumeric(strHwyMunicipalityIndex)) {

				intHwyMunicipalityIndex = Math.round(Integer.parseInt(strHwyMunicipalityIndex)) - 1;
			}
			switch (strHwyMunicipalityAction.toUpperCase()) {
			case "ADD":
				if (isNumeric(strHwyMunicipalityIndex)) {
					if (!searchHwyTCPLPage.find(By.id("hwyMunicipalityToRemove" + intHwyMunicipalityIndex)).isPresent()) {
						searchHwyTCPLPage.MoreHwyMunicipality_WebButton.click();
					}
					searchHwyTCPLPage.find(By.id("hwyMunicipality" + intHwyMunicipalityIndex)).selectByValue(strHwyMunicipalityList.toUpperCase());
				}
				break;
			case "REMOVE":
				if (isNumeric(strHwyMunicipalityIndex)) {
				}
				searchHwyTCPLPage.RemoveHwyMunicipality_WebButton.click();
				if (searchHwyTCPLPage.ErrorMsg_WebTable.isPresent()) {
					strErrorMsgs = getCellData(searchHwyTCPLPage.ErrorMsg_WebTable, 1, 1).trim();
					if (!strErrorMsgs.isEmpty()) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
						intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
						if (intRet == false) {
							Search_HWY_EnterData = false;
						}
						return false;
					}
				}
				break;
			}
			searchHwyTCPLPage.PlanNumber1_WebEdit.sendKeys(strPlanNumber1);
			searchHwyTCPLPage.PlanNumber2_WebEdit.sendKeys(strPlanNumber2);
			searchHwyTCPLPage.HwyNumber1_WebEdit.sendKeys(strHwyNumber1);
			searchHwyTCPLPage.HwyNumber2_WebEdit.sendKeys(strHwyNumber2);
			searchHwyTCPLPage.RegistrationNumber_WebEdit.sendKeys(strRegNumber);
			if (strIncludeDeletedDocuments.equalsIgnoreCase("yes")) {
				searchHwyTCPLPage.IncludeDeletedDocuments_WebCheckBox.click();
			}
			oPage = null;
			// logSteps.execution_log("Enter Data to <Search Highways Register> page - Successful");
			Search_HWY_EnterData = true;
			return Search_HWY_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public boolean Search_HWY_EnterData_SetSearchByOption(String strSearchByOption, String oPage) {
		// Object Search_HWY_EnterData_SetSearchByOption=null;
		try {
			String strStepName = null;
			strStepName = "Search_HWY_EnterData_SetSearchByOption";
			boolean Search_HWY_EnterData_SetSearchByOption = false;
			String strOptionValue = null;
			// Set search by option value
			switch (strSearchByOption.toUpperCase()) {
			case "DATE":
				strOptionValue = "date";
				break;
			case "MUNICIPALITY":
				strOptionValue = "municipality";
				// searchHwyTCPLPage.SortBy_Municipality.click();
				break;
			case "PLANNUMBER":
			case "PLAN NUMBER":
				strOptionValue = "hwyPlanNo";
				break;
			case "HIGHWAYNUMBER":
			case "HIGHWAY NUMBER":
				strOptionValue = "hwyNo";
				break;
			case "REGISTRATIONNUMBER":
			case "REGISTRATION NUMBER":
			case "REGNUMBER":
				strOptionValue = "registrationNumber";
				break;
			default:
				// Reporter.reportEvent(Status.Failed,strStepName,"UnKnow search by option <"+strSearchByOption+"> provided - UnSuccessful");
				// utility.AddInfo("UnKnow search by option <"+strSearchByOption+"> provided - UnSuccessful");
				return false;

			}
			// Declare Search By web check box object
			Object oDesc = null;

			// oDesc("name").value()="criteriaView.searchByOptions";
			// oDesc("value").value()=strOptionValue;
			// Verify the existance of the web checkbox
			// *if(!.getWebElement(2)){

			// Reporter.reportEvent(Status.Failed,strStepName,"Search By <"+strSearchByOption+"> check box Not exist - UnSuccessful");
			// utility.AddInfo("Search By <"+strSearchByOption+"> check box Not exist - UnSuccessful");

			return false;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_TCPL_EnterData(String shtName, String intRow) {
		boolean Search_TCPL_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "Search_TCPL_EnterData";
			// Declare variables
			String strSortBy = null;
			String strSearchBy = null;
			String strStartDate = null;
			String strEndDate = null;
			String strTCPLMunicipalityList = null;
			String strIncludeDeletedDocuments = null;
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			// Fetch data
			strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
			strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
			strStartDate = GetValueIfValid("StartDate", shtName, Integer.parseInt(intRow));
			strEndDate = GetValueIfValid("EndDate", shtName, Integer.parseInt(intRow));
			strTCPLMunicipalityList = GetValueIfValid("TCPLMunicipalityList", shtName, Integer.parseInt(intRow));
			strIncludeDeletedDocuments = GetValueIfValid("IncludeDeletedDocuments", shtName, Integer.parseInt(intRow));
			// Fill data - Sort By section
			if (!strSortBy.isEmpty() && !strSortBy.equals("IGNORE_VALUE")) {
				switch (strSortBy.toUpperCase()) {
				case "DATE":
					searchHwyTCPLPage.SortBy_Date.click();
					break;
				case "MUNICIPALITY":
					searchHwyTCPLPage.SortBy_Municipality.click();
					break;
				default:
					return false;
				}
			}
			if (!strSearchBy.isEmpty() && !strSearchBy.equals("IGNORE_VALUE")) {
				switch (strSearchBy.toUpperCase()) {
				case "DATE":
					searchHwyTCPLPage.SearchBy_Date.click();
					break;
				case "MUNICIPALITY":
					searchHwyTCPLPage.SearchBy_Municipality.click();
					break;
				default:
					return false;
				}
			}

			searchHwyTCPLPage.StartDate_WebEdit.sendKeys(strStartDate);
			searchHwyTCPLPage.EndDate_WebEdit.sendKeys(strEndDate);
			if (!strTCPLMunicipalityList.isEmpty()) {
				searchHwyTCPLPage.TCPLMunicipality_WebList.selectByVisibleText(strTCPLMunicipalityList.toUpperCase());
			}
			searchHwyTCPLPage.IncludeDeletedDocuments_WebCheckBox.click();
			Search_TCPL_EnterData = true;
			return Search_TCPL_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@When("user search NewSearch on TransCanada Pipeline")
	public boolean Search_HwyTCPL_NewSearch() {
		// Object Search_HwyTCPL_NewSearch = null;
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_NewSearch";
			boolean Search_HwyTCPL_NewSearch = false;
			String strPageHeader = null;
			strPageHeader = searchHwyTCPLPage.Header_WebElement.getText().trim();
			searchHwyTCPLPage.Search_WebButton.click();
			// utility.AddInfo("<New Search> button is clicked on <" + strPageHeader + "> page");
			String strExpectedPage = "";
			strPageHeader = searchHwyTCPLPage.Header_WebElement.getText().trim();
			if (!(strComp(strPageHeader, strExpectedPage) == 0)) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<" + strPageHeader + "> page displayed instead of the expected <" + strExpectedPage + "> page - UnSuccessful");
				// utility.AddInfo("<" + strPageHeader + "> page displayed instead of the expected <" + strExpectedPage + "> page - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<" + strExpectedPage + "> page displayed - Successful");
			// utility.AddInfo("<" + strExpectedPage + "> page displayed - Successful");
			Search_HwyTCPL_NewSearch = true;
			return Search_HwyTCPL_NewSearch;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on search on TransCanada Pipeline $shtName and $intRow19")
	public boolean user_click_search_on_TCPL_page(String shtName, String intRow) {
		// Object Search_HwyTCPL_Cancel = null;
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_Cancel";
			boolean Search_HwyTCPL_Cancel = false;
			boolean intRet = false;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_TCPL_EnterData(shtName, intRow);
			}
			searchHwyTCPLPage.Search_WebButton.click();
			Search_HwyTCPL_Cancel = true;
			return Search_HwyTCPL_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user search PrintReport on TransCanada Pipeline $TCPLPAGE and $TCPLSHEETNAME and $TCPLROWINDEX1")
	public boolean Search_HwyTCPL_PrintReport(String strPage, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_PrintReport";
			boolean Search_HwyTCPL_PrintReport = true;
			boolean intRet = false;
			String strHeader = null;
			strHeader = searchHwyTCPLPage.Header_WebElement.getText().trim();
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_SearchResults_PrintReport_EnterData(shtName, intRow);
				if (intRet == false) {
					logSteps.execution_log("Enter Data to <" + strHeader + "> page for <Print Report> - UnSuccessful");
					Search_HwyTCPL_PrintReport = false;
					return false;
				} else {
					logSteps.execution_log("Enter Data to <" + strHeader + "> page for <Print Report> - Successful");
				}
			}
			String strLanguage = null;
			strLanguage = searchResultsCommonPage.ReportLanguage_WebRadioGroup.getText().trim();
			String strPageHeader = null;
			String strPageName = null;
			String strPageHeader1 = null;
			Object strPageHeader2 = null;
			switch (strPage.toUpperCase()) {
			case "HWY":
				if (strLanguage == "fr") {
					strPageHeader = "Autoroute";
				} else {
					strPageHeader = "HIGHWAYS REGISTER";
				}
				break;
			case "TCPL":
				if (strLanguage == "fr") {
					strPageHeader = "Pipeline Transcanadien";
				} else {
					strPageHeader = "Trans-Canada Pipe Line";
				}
				break;
			}
			searchHwyTCPLPage.PrintReport_WebButton.click();
			logSteps.execution_log("<Print Report> button is clicked");
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			if (searchHwyTCPLPage.ErrorMsg_WebTable.isPresent()) {
				strErrorMsgs = getCellData(searchHwyTCPLPage.ErrorMsg_WebTable, 1, 1).trim();
				if (!strErrorMsgs.isEmpty()) {
					if (!shtName.isEmpty() && !intRow.isEmpty()) {
						strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
					}
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						Search_HwyTCPL_PrintReport = false;
					} else {
						Search_HwyTCPL_PrintReport = false;
					}
					return false;
				}
			}
			Thread.sleep(5);
			Object strFullTexts = null;
			if (!(InStr(strFullTexts, strPageHeader) > 0) && !(InStr(strFullTexts, strPageHeader1) > 0) && !(InStr(strFullTexts, strPageHeader2) > 0)) {
				logSteps.execution_log("The expected texts of <" + strPageHeader + "> Not displayed on the popup - UnSuccessful");
				Search_HwyTCPL_PrintReport = false;
			} else {
				logSteps.execution_log("<" + strPageHeader + "> popup displayed - Successful");
			}
			String strCurHeader = null;
			strCurHeader = searchHwyTCPLPage.Header_WebElement.getText().trim();
			if (!(strComp(strCurHeader, strHeader) == 0)) {
				Search_HwyTCPL_PrintReport = false;
				return false;
			}
			if (!Search_HwyTCPL_PrintReport == false) {
				logSteps.execution_log("<" + strHeader + "> page returned - Successful");
				Search_HwyTCPL_PrintReport = true;
			}
			return Search_HwyTCPL_PrintReport;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_SearchResults_PrintReport_EnterData(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_SearchResults_PrintReport_EnterData";
			boolean Search_SearchResults_PrintReport_EnterData = false;
			String strNumberOfBlankLine = null;
			String strLanguage = null;
			String oPage = null;
			strNumberOfBlankLine = GetValueIfValid("NumberOfBlankLines", shtName, Integer.parseInt(intRow));
			strLanguage = GetValueIfValid("Language", shtName, Integer.parseInt(intRow));
			searchResultsCommonPage.BlankLineNumber_WebEdit.sendKeys(strNumberOfBlankLine);
			if (!strLanguage.isEmpty() || !strLanguage.equals("IGNORE_VALUE")) {
				switch (strLanguage.toUpperCase()) {
				case "ENGLISH":
					searchResultsCommonPage.ReportLanguage_WebRadioGroup.click();
					break;
				case "FRENCH":
					searchResultsCommonPage.ReportLanguage_WebRadioGroup.click();

					break;
				default:
					oPage = null;
					return false;
				}
			}
			oPage = null;
			Search_SearchResults_PrintReport_EnterData = true;
			return Search_SearchResults_PrintReport_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify error message on TCPL $shtName and $intRow")
	public boolean user_verify_message_on_TCPL(String shtName, String intRow) {
		String expErrormsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
		String actualErrorMsg = searchHwyTCPLPage.ErrorMsg_WebTable_Tcpl.getText();
		if (actualErrorMsg.contains(expErrormsg)) {
			logSteps.execution_log("Error message verified " + actualErrorMsg);
			return true;
		}
		return false;
	}

	@When("user clicks on Close on TransCanada Pipeline")
	public boolean user_click_close_Search_on_TCPL() {
		try {
			String strStepName = null;
			strStepName = "Search_SearchByName_Close";
			boolean Search_SearchByName_Close = false;
			if (!resultsForSearchByNamePage.Header_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Results for Search by Name> page Not displayed - UnSuccessful");
				// utility.AddInfo("<Results for Search by Name> page Not displayed - UnSuccessful");
				return false;
			}
			resultsForSearchByNamePage.Close_WebButton.click();
			// utility.AddInfo("<Close> button is clicked on <Results for Search by Name> page");
			// Verify the application returns to the Main Menu page
			boolean intRet = false;
			intRet = elrscommon.VerifyPage("Main Menu");
			if (intRet == false) {
				// Reporter.reportEvent(Status.Failed, strStepName, "<Main Menu> page is NOT displayed - UnSuccessful");
				// utility.AddInfo("<Main Menu> page is NOT displayed - UnSuccessful");
				return false;
			}
			// Reporter.reportEvent(Status.Passed, strStepName, "<Main Menu> page is displayed - Successful");
			// utility.AddInfo("<Main Menu> page is displayed - Successful");
			Search_SearchByName_Close = true;
			return Search_SearchByName_Close;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Cancel on SearchFType")

	public boolean Search_FType_Cancel_Cancel() {

		boolean Search_FType_Cancel_Cancel = false;

		try {

			WaitUtil.waitMSeconds(1000);

			searchPOAPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.dismiss();

			WaitUtil.waitMSeconds(2000);

			Search_FType_Cancel_Cancel = true;

			return Search_FType_Cancel_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user clicks on Cancel on SearchFType $shtName and $intRow")

	public boolean Search_FType_Cancel_Cancel(String shtName, String intRow) {

		boolean Search_FType_Cancel_Cancel = false;

		try {

			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));

			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));

			searchPOAPage.LastName_WebEdit.clear();

			searchPOAPage.LastName_WebEdit.sendKeys(strLastName);

			searchPOAPage.GivenName_WebEdit.clear();

			searchPOAPage.GivenName_WebEdit.sendKeys(strGivenName);

			WaitUtil.waitMSeconds(1000);

			searchPOAPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.dismiss();

			WaitUtil.waitMSeconds(2000);

			Search_FType_Cancel_Cancel = true;

			return Search_FType_Cancel_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user clicks on Cancel_OK on SearchFType $shtName and $intRow")

	public boolean Search_FType_Cancel_OK(String shtName, String intRow) {

		boolean Search_FType_Cancel_OK = false;

		try {

			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));

			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));

			searchPOAPage.LastName_WebEdit.clear();

			searchPOAPage.LastName_WebEdit.sendKeys(strLastName);

			searchPOAPage.GivenName_WebEdit.clear();

			searchPOAPage.GivenName_WebEdit.sendKeys(strGivenName);

			WaitUtil.waitMSeconds(1000);

			searchPOAPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.accept();

			WaitUtil.waitMSeconds(3000);

			Search_FType_Cancel_OK = true;

			return Search_FType_Cancel_OK;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user clicks on Search button on the Search by PIN page $shtName and $intRow")

	public boolean Search_Register_Search(String shtName, String intRow) {

		boolean Search_Register_Search = false;

		try {

			String strStepName = null;

			strStepName = "Search_Register_Search";

			if (intRow.isEmpty()) {

				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");

				return false;

			}

			boolean intRet = false;

			intRet = Search_Register_EnterData(shtName, intRow);

			if (intRet == false) {

				logSteps.execution_log("Enter data to <Search by PIN> page - UnSuccessful");

				return false;

			}

			String strBlock = null;

			String strPIN = null;

			String strPINType = null;

			String strExpectedMsgs = null;

			String strErrorMsgs = null;

			strBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));

			strPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow));

			strPINType = GetValueIfValid("PINType", shtName, Integer.parseInt(intRow));

			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();

			searchRegisterPage.Search_WebButton.click();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Search> button - UnSuccessful");

				return false;

			}

			logSteps.execution_log("The data input can NOT be empty - UnSuccessful");

			VerifyApplicationError();

			if (searchRegisterPage.ErrorMsg_WebTable.isPresent()) {

				strErrorMsgs = searchRegisterPage.ErrorMsg_WebTable.getText().trim();

				if (!strErrorMsgs.isEmpty()) {

					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);

					if (intRet == false) {

						Search_Register_Search = false;

					}

					return false;

				}

			}

			if (!searchRegisterPage.RegisterView_WebTable.isPresent()) {

				logSteps.execution_log("<Search by PIN Register View> page Not displayed - UnSuccessful");

				return false;

			}

			logSteps.execution_log("<Search by PIN Register View> page displayed - Successful");

			String strPINText = null;

			String strExpectedPINText = null;

			strPINText = searchRegisterPage.RegisterView_WebTable.getText();

			if (strPINType.isEmpty() || strPINType.equals("IGNORE_VALUE")) {

				strExpectedPINText = "PIN:" + strBlock + "-" + strPIN;

			} else {

				strExpectedPINText = "PIN:" + strBlock + "-" + strPIN + " (" + strPINType + ")";

			}

			if (!(InStr(strPINText, strExpectedPINText) > 0)) {

				logSteps.execution_log("The expected <" + strExpectedPINText + "> Not displayed on the page - UnSuccessful");

				return false;

			}

			logSteps.execution_log("The expected <" + strExpectedPINText + "> displayed on the page - Successful");

			Search_Register_Search = true;

			return Search_Register_Search;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean Search_Register_EnterData(String shtName, String intRow) {

		boolean Search_Register_EnterData = false;

		try {

			String strStepName = null;

			strStepName = "Search_Register_EnterData";

			String strBlock = null;

			String strPIN = null;

			String strDocumentFilter = null;

			String strDateFrom = null;

			String strDateTo = null;

			String strDocumentOrder = null;

			String strIncludeDeletedDocuments = null;

			strBlock = GetValueIfValid("Block", shtName, Integer.parseInt(intRow));

			strPIN = GetValueIfValid("PIN", shtName, Integer.parseInt(intRow));

			strDocumentFilter = GetValueIfValid("DocumentFilter", shtName, Integer.parseInt(intRow));

			strDateFrom = GetValueIfValid("DateFrom", shtName, Integer.parseInt(intRow));

			strDateTo = GetValueIfValid("DateTo", shtName, Integer.parseInt(intRow));

			strDocumentOrder = GetValueIfValid("DocumentOrder", shtName, Integer.parseInt(intRow));

			strIncludeDeletedDocuments = GetValueIfValid("IncludeDeletedDocuments", shtName, Integer.parseInt(intRow));

			Object oPage = null;

			searchRegisterPage.Block_WebEdit.sendKeys(strBlock);

			searchRegisterPage.PIN_WebEdit.sendKeys(strPIN);

			switch (strDocumentFilter.toUpperCase()) {

			case "ALL DOCUMENTS":

			case "ALLDOCUMENTS":

			case "ALL":

				searchRegisterPage.AllDocuments_WebRadioGroup.click();

				break;

			case "SELECTED DATE RANGE":

			case "SELECTEDDATERANGE":

			case "RANGE":

				searchRegisterPage.SelectedDateRange_WebRadioGroup.click();

				searchRegisterPage.DateFrom_WebEdit.sendKeys(strDateFrom);

				searchRegisterPage.DateTo_WebEdit.sendKeys(strDateTo);

				break;

			}

			switch (strDocumentOrder.toUpperCase()) {

			case "FORWARD":

				searchRegisterPage.DocumentOrderForword_WebRadioGroup.click();

				break;

			case "BACKWARD":

				searchRegisterPage.DocumentOrderBackword_WebRadioGroup.click();

				break;

			}

			searchRegisterPage.IncludeDeleted_WebCheckBox.sendKeys(strIncludeDeletedDocuments);

			oPage = null;

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				// Reporter.reportEvent(Status.Failed,strStepName,"One or more fields could NOT be set successfully. Please check the results for the details");

				// utility.AddInfo("One or more fields could NOT be set successfully. Please check the results for the details");

				return false;

			}

			// Reporter.reportEvent(Status.Passed,strStepName,"Enter Data to <Search by PIN> page - Successful");

			// utility.AddInfo("Enter Data to <Search by PIN> page - Successful");

			Search_Register_EnterData = true;

			return Search_Register_EnterData;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click on search on SearchFType $shtName and $intRow")

	public boolean user_click_on_search_on_SearchFType(String shtName, String intRow) {

		try {

			String strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));

			String strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));

			searchPOAPage.LastName_WebEdit.clear();

			searchPOAPage.LastName_WebEdit.sendKeys(strLastName);

			searchPOAPage.GivenName_WebEdit.clear();

			searchPOAPage.GivenName_WebEdit.sendKeys(strGivenName);

			searchPOAPage.Search_WebButton.click();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	@When("user clicks on Cancel_OK on SearchFType")

	public boolean Search_FType_Cancel_OK() {

		boolean Search_FType_Cancel_OK = false;

		try {

			WaitUtil.waitMSeconds(1000);

			searchPOAPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.accept();

			Search_FType_Cancel_OK = true;

			return Search_FType_Cancel_OK;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Cancel button on Search by PIN page")

	public boolean Search_Register_Cancel_Cancel() {

		boolean Search_FType_Cancel_Cancel = false;

		try {

			WaitUtil.waitMSeconds(1000);

			searchRegisterPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.dismiss();

			WaitUtil.waitMSeconds(2000);

			Search_FType_Cancel_Cancel = true;

			return Search_FType_Cancel_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Cancel button on Search by PIN page $shtName and $intRow")

	public boolean Search_Register_Cancel(String strAction, String shtName, String intRow) {

		boolean Search_Register_Cancel = false;

		try {

			String strStepName = null;

			strStepName = "Search_Register_Cancel";

			boolean intRet = false;

			if (!shtName.isEmpty() && !intRow.isEmpty()) {

				intRet = Search_Register_EnterData(shtName, intRow);

				if (intRet == false) {

					return false;

				}

			}

			String strPreBlock = null;

			String strPrePIN = null;

			String strPreProperty = null;

			strPreBlock = searchRegisterPage.Block_WebEdit.getValue();

			strPrePIN = searchRegisterPage.PIN_WebEdit.getTextValue();

			strPreProperty = strPreBlock + "-" + strPrePIN;

			searchRegisterPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.dismiss();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - UnSuccessful");

				return false;

			}

			if (strAction == "OK") {

				intRet = VerifyPage("Main Menu");

				if (intRet == false) {

					logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");

				} else {

					logSteps.execution_log("<Main Menu> page is displayed - Successful");

					Search_Register_Cancel = true;

				}

				return false;

			}

			if (!searchRegisterPage.Header_WebElement.isPresent()) {

				logSteps.execution_log("<Search by PIN> page Not dispayed - UnSuccessful");

				return false;

			}

			String strCurBlock = null;

			String strCurPIN = null;

			String strCurProperty = null;

			strCurBlock = searchRegisterPage.Block_WebEdit.getAttribute("value");

			strCurPIN = searchRegisterPage.PIN_WebEdit.getAttribute("value");

			strCurProperty = strCurBlock + "-" + strCurPIN;

			if (!(strComp(strCurProperty, strPreProperty) == 0)) {

				logSteps.execution_log("Verification of the PIN before and after the <Cancel> button clicked - UnSuccessful, Before:<" + strPreProperty + ">, After: <" + strCurProperty + ">");

				return false;

			}

			logSteps.execution_log("Verification of the page - Successful");

			Search_Register_Cancel = true;

			return Search_Register_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Cancel_OK button on Search by PIN page")

	public boolean Search_Register_Cancel_OK() {

		boolean Search_FType_Cancel_Cancel = false;

		try {

			WaitUtil.waitMSeconds(1000);

			searchRegisterPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.accept();

			WaitUtil.waitMSeconds(2000);

			Search_FType_Cancel_Cancel = true;

			return Search_FType_Cancel_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Cancel_OK button on Search by PIN page $shtName and $intRow")

	public boolean Search_Register_Cancel_OK(String strAction, String shtName, String intRow) {

		boolean Search_Register_Cancel = false;

		try {

			String strStepName = null;

			strStepName = "Search_Register_Cancel";

			boolean intRet = false;

			if (!shtName.isEmpty() && !intRow.isEmpty()) {

				intRet = Search_Register_EnterData(shtName, intRow);

				if (intRet == false) {

					return false;

				}

			}

			String strPreBlock = null;

			String strPrePIN = null;

			String strPreProperty = null;

			strPreBlock = searchRegisterPage.Block_WebEdit.getValue();

			strPrePIN = searchRegisterPage.PIN_WebEdit.getTextValue();

			strPreProperty = strPreBlock + "-" + strPrePIN;

			searchRegisterPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			String alertText = confirmationAlert.getText();

			confirmationAlert.accept();

			WaitUtil.waitMSeconds(2000);

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - UnSuccessful");

				return false;

			}

			if (!searchRegisterPage.Header_WebElement.isPresent()) {

				logSteps.execution_log("<Search by PIN> page Not dispayed - UnSuccessful");

				return false;

			}

			String strCurBlock = null;

			String strCurPIN = null;

			String strCurProperty = null;

			strCurBlock = searchRegisterPage.Block_WebEdit.getAttribute("value");

			strCurPIN = searchRegisterPage.PIN_WebEdit.getAttribute("value");

			strCurProperty = strCurBlock + "-" + strCurPIN;

			if (!(strComp(strCurProperty, strPreProperty) == 0)) {

				logSteps.execution_log("Verification of the PIN before and after the <Cancel> button clicked - UnSuccessful, Before:<" + strPreProperty + ">, After: <" + strCurProperty + ">");

				return false;

			}

			logSteps.execution_log("Verification of the page - Successful");

			Search_Register_Cancel = true;

			return Search_Register_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Search button on the Search by Document page $shtName and $intRow")

	public boolean Search_Document_Search(String shtName, String intRow) {

		boolean Search_Document_Search = false;

		try {

			String strStepName = null;

			strStepName = "Search_Document_Search";

			if (intRow.isEmpty()) {

				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");

				return false;

			}

			boolean intRet = false;

			intRet = Search_Document_EnterData(shtName, intRow);

			if (intRet == false) {

				logSteps.execution_log("Enter data to <Search by Document> page - UnSuccessful");

				return false;

			}

			String strRegNumber = null;

			String strExpectedMsgs = null;

			String strErrorMsgs = null;

			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));

			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();

			searchDocumentPage.Search_WebButton.click();

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Search> button - UnSuccessful");

				return false;

			}

			VerifyApplicationError();

			if (searchDocumentPage.ErrorMsg_WebTable.isPresent()) {

				strErrorMsgs = searchDocumentPage.ErrorMsg_WebTable.getText().trim();

				if (!strErrorMsgs.isEmpty()) {

					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);

					if (intRet == false) {

						Search_Document_Search = false;

					}

					return false;

				}

			}

			if (!searchDocumentPage.DocumentViewHeader_WebTable.isPresent()) {

				logSteps.execution_log("<Search by Document Document View> page Not displayed - UnSuccessful");

				return false;

			}

			logSteps.execution_log("<Search by Document Document View> page displayed - Successful");

			String strDocHeader = null;

			strDocHeader = searchDocumentPage.DocumentViewHeader_WebTable.getAttribute("text");

			String strExpectedRegNumberText = null;

			strExpectedRegNumberText = "Registration Number:" + strRegNumber;

			if (!(InStr(strDocHeader, strExpectedRegNumberText) > 0)) {

				logSteps.execution_log("The expected <" + strExpectedRegNumberText + "> Not displayed on the page - UnSuccessful");

				return false;

			}

			return Search_Document_Search;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean Search_Document_EnterData(String shtName, String intRow) {

		// Object Search_Document_EnterData = null;

		try {

			String strStepName = null;

			strStepName = "Search_Document_EnterData";

			boolean Search_Document_EnterData = false;

			String strRegNumber = null;

			strRegNumber = GetValueIfValid("RegNumber", shtName, Integer.parseInt(intRow));

			if (!searchDocumentPage.RegNumber_WebEdit.isPresent()) {

				logSteps.execution_log("<Registration Number> field Not exist - UnSuccessful");

				return false;

			}

			if (strRegNumber.toUpperCase().equalsIgnoreCase("!GENERATE!")) {

				strRegNumber = Generate_Unique_Randon_RegNumber();

			}

			if (!strRegNumber.equals("IGNORE_VALUE")) {

				searchDocumentPage.RegNumber_WebEdit.sendKeys(strRegNumber);

				logSteps.execution_log("Enter Registration Number: <" + strRegNumber + "> - Successful");

			}

			Search_Document_EnterData = true;

			return Search_Document_EnterData;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user click Cancel_OK button on Search by Document page")

	public boolean Search_Document_Cancel() {

		boolean Search_Document_Cancel = false;

		try {

			String strStepName = null;

			strStepName = "Search_Document_Cancel";

			boolean intRet = false;

			String strRegNumber = null;

			strRegNumber = searchDocumentPage.RegNumber_WebEdit.getAttribute("value").toUpperCase();

			searchDocumentPage.Cancel_WebButton.click();

			Alert confirmationAlert = basePage.getDriver().switchTo().alert();

			confirmationAlert.accept();

			WaitUtil.waitMSeconds(3000);

			if (environmentlib.getProperty("bTriggered").equals("true")) {

				logSteps.execution_log("Click <Cancel> button - Successful");

				return false;

			}

			if (!searchDocumentPage.Header_WebElement.isPresent()) {

				logSteps.execution_log("<Search by Document> page Not dispayed - UnSuccessful");

				return false;

			}

			String strCurRegNumber = null;

			strCurRegNumber = searchDocumentPage.RegNumber_WebEdit.getAttribute("value");

			if (!(strComp(strCurRegNumber, strRegNumber) == 0)) {

				logSteps.execution_log("Verification of the Registration Number before and after the <Cancel> button clicked - UnSuccessful, Before:<" + strRegNumber + ">, After: <" + strCurRegNumber + ">");

				return false;

			}

			logSteps.execution_log("Verification of Registration Number: <" + strRegNumber + "> - Successful");

			Search_Document_Cancel = true;

			return Search_Document_Cancel;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	@When("user clicks on RegNo link on SearchFType $shtName and $intRow")

	public boolean Search_FType_SelectRegNo(String shtName, String intRow) {

		try {

			boolean Search_SearchByName_SelectRegNo = false;

			String strRegNo = null;

			strRegNo = GetValueIfValid("RegNo", shtName, Integer.parseInt(intRow)).toUpperCase();

			mainPage.getDriver().findElement(By.xpath("//a[contains(@onclick,'makeDocumentViewWindow')]")).click();

			WaitUtil.waitMSeconds(5000);

			Search_SearchByName_SelectRegNo = true;

			return Search_SearchByName_SelectRegNo;

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}
	
	@When("user clicks on  Search button on Search Highways Register page with $strPage $shtName and $intRow")
	public boolean Search_HwyTCPL_Search(String strPage, String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_HwyTCPL_Search";
			boolean Search_HwyTCPL_Search = false;
			if (intRow.isEmpty()) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			String strSortBy = null;
			String strSearchBy = null;
			String strExpectedMsgs = null;
			String strErrorMsgs = null;
			strSortBy = GetValueIfValid("SortBy", shtName, Integer.parseInt(intRow));
			strSearchBy = GetValueIfValid("SearchBy", shtName, Integer.parseInt(intRow));
			strExpectedMsgs = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow)).trim();
			boolean intRet = false;
			switch (strPage.toUpperCase()) {
			case "HWY":
				intRet = Search_HWY_EnterData(shtName, intRow);
				break;
			case "TCPL":
				intRet = Search_TCPL_EnterData(shtName, intRow);
				break;
			}
			if (intRet == false) {
				return false;
			}
			searchHwyTCPLPage.Search_WebButton.click();
			// logSteps.execution_log("<Search> button is clicked");
			VerifyApplicationError();
			if (searchHwyTCPLPage.ErrorMsg_WebTable.isVisible()) {
				strErrorMsgs = searchHwyTCPLPage.ErrorMsg_WebTable.getText().trim();
				if (!strErrorMsgs.isEmpty()) {
					intRet = VerifyErrorMessage(strStepName, strErrorMsgs, strExpectedMsgs);
					if (intRet == false) {
						Search_HwyTCPL_Search = false;
					}
				}
			}
			String strResultPage = null;
			String strResultTable = null;
			switch (strPage.toUpperCase()) {
			case "HWY":
				strResultPage = "Results for Search Highways Register";
				strResultTable = "HwyResultsTable";
				break;
			case "TCPL":
				strResultPage = "Results for Search TransCanada Pipeline Index";
				strResultTable = "TCPLResultsTable";
				break;
			}
			String strPageHeader = null;
			Search_HwyTCPL_Search = true;
			return Search_HwyTCPL_Search;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Then("user verify highways register page error message $shtName and $intRow")
	public boolean user_verify_error_message_on_Highways_Register_page(String shtName, String intRow) {
		try {
			String expErrorMsg = GetValueIfValid("ErrorMessages", shtName, Integer.parseInt(intRow));
			String actualErrorMsg = searchHwyTCPLPage.ErrorMsg_WebTable.getText().trim();
			if (expErrorMsg.contains(actualErrorMsg)) {
				// logSteps.execution_log("Error Messages Matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@When("user clicks on  Ok button on Search Highways Register page")
	public boolean user_click_Ok_on_HWY_page() {
		boolean Search_HWY_Cancel = false;
		try {
			searchHwyTCPLPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();
			WaitUtil.waitMSeconds(2000);
			// logSteps.execution_log("user clicks on Ok button on Search Highways Register page successfully");
			Search_HWY_Cancel = true;
			return Search_HWY_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@When("user clicks on New Search button on Result for Search by Address or Result for Search by Name/Address page")
	public boolean Search_NameAddress_NewSearch() {
		try {
			boolean Search_NameAddress_NewSearch = false;
			String strPageHeader = null;
			strPageHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			searchNameAddressResultPage.NewSearch_WebButton.click();
			WaitUtil.waitMSeconds(500);
			if (!searchNameAddressPage.Header_WebElement.isPresent()) {
				logSteps.execution_log("<Search by Name/Address> page Not dispayed - UnSuccessful");
				return false;
			}
			Search_NameAddress_NewSearch = true;
			return Search_NameAddress_NewSearch;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@When("user clicks on a street name link on Result for Search by Address page $shtName and $intRow")
	public boolean Search_NameAddress_SelectStreet(String shtName, String intRow) {
		try {
			String strStepName = null;
			strStepName = "Search_NameAddress_SelectStreet";
			boolean Search_NameAddress_SelectStreet = false;
			if (shtName.isEmpty() || intRow.isEmpty()) {
				logSteps.execution_log("The data input can NOT be empty - UnSuccessful");
				return false;
			}
			String strStreetName = null;
			strStreetName = GetValueIfValid("StreetName", shtName, Integer.parseInt(intRow)).toUpperCase();
			String strResultHeader = null;
			strResultHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			if (!searchNameAddressResultPage.AddressResults_WebTable.isPresent()) {
				logSteps.execution_log("<Matching Street Name> table Not displayed on <" + strResultHeader + "> page - UnSuccessful");
				return false;
			}
			mainPage.getDriver().findElement(By.xpath("//table[@id='addressSearchResults']//tr[2]//td[1]//a")).click();
			strResultHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			if (!(strResultHeader == "Result for Search by Name/Address")) {
				logSteps.execution_log("<Result for Search by Name/Address> page Not displayed - UnSuccessful");
				return false;
			}
			boolean intRet = false;
			intRet = Search_NameAddress_Verify_NameResults(shtName, intRow);
			Search_NameAddress_SelectStreet = intRet;
			return Search_NameAddress_SelectStreet;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user clicks on Select Different Street button on Result for Search by Name/Address page")
	public boolean Search_NameAddress_SelectDifferentStreet() {
		try {
			boolean Search_NameAddress_SelectDifferentStreet = false;
			String strPageHeader = null;
			String oWebButton = null;
			strPageHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			if (!searchNameAddressResultPage.SelectDifferentStreet_WebButton.isPresent()) {
				logSteps.execution_log("<Select Different Street> button Not exist on <" + strPageHeader + "> page - UnSuccessful");
				oWebButton = null;
				return false;
			}
			searchNameAddressResultPage.SelectDifferentStreet_WebButton.click();
			WaitUtil.waitMSeconds(100);
			oWebButton = null;
			strPageHeader = searchNameAddressResultPage.ResultHeader_WebElement.getText().trim();
			if (!(strComp(strPageHeader, "Result for Search by Address") == 0)) {
				logSteps.execution_log("<Result for Search by Address> page Not dispayed - UnSuccessful");
				return false;
			}
			Search_NameAddress_SelectDifferentStreet = true;
			return Search_NameAddress_SelectDifferentStreet;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@When("user clicks on OK button on Search by Name/Address page with/without data entry $strAction and $shtname and $intRow")
	public boolean Search_SearchByName_Cancel(String strAction, String shtName, String intRow) {
		try {
			boolean Search_SearchByName_Cancel = false;
			boolean intRet = false;
			String strLastName = null;
			String strGivenName = null;
			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				intRet = Search_SearchByName_EnterData(shtName, intRow);
				if (intRet == false) {
					return false;
				} else {
					strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
					strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
					if (strLastName.equals("IGNORE_VALUE")) {
						strLastName = "";
					}
					if (strGivenName.equals("IGNORE_VALUE")) {
						strGivenName = "";
					}
				}
			}
			searchByNamePage.Cancel_WebButton.click();
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <" + strAction + "> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			if (strAction == "OK") {
				intRet = elrscommon.VerifyPage("Main Menu");
				if (intRet == false) {
					logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				} else {
					logSteps.execution_log("<Main Menu> page is displayed - Successful");
					Search_SearchByName_Cancel = true;
				}
				return false;
			}
			if (!searchByNamePage.Header_WebElement.isPresent()) {
				logSteps.execution_log("<Search by Name> page Not dispayed - UnSuccessful");
				return false;
			}
			String strActualLastName = null;
			String strActualGivenName = null;
			strActualLastName = searchByNamePage.LastName_WebEdit.getAttribute("value").trim();
			strActualGivenName = searchByNamePage.GivenName_WebEdit.getAttribute("value").trim();
			if (!(strComp(strActualLastName, strLastName) == 0)) {
				logSteps.execution_log("Verification of <Last Name of Corporation Name> - UnSuccessful. Expected: <" + strLastName + ">, Actual: <" + strActualLastName + ">");
				if (!(strComp(strActualGivenName, strGivenName) == 0)) {
					logSteps.execution_log("Verification of <Given Name> - UnSuccessful. Expected: <" + strGivenName + ">, Actual: <" + strActualGivenName + ">");
				}
				return false;
			}
			Search_SearchByName_Cancel = true;
			return Search_SearchByName_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@When("user clicks on OK button on Search by Name/Address page with/without data entry $strAction")
	public boolean Search_SearchByName_Cancel(String strAction) {
		try {
			boolean Search_SearchByName_Cancel = false;
			boolean intRet = false;
			String strLastName = null;
			String strGivenName = null;
			searchByNamePage.Cancel_WebButton.click();
			intRet = elrscommon.ELRS_Popup_Cancel(strAction);
			if (intRet == false) {
				logSteps.execution_log("Click <" + strAction + "> button on the Cancel Popup - UnSuccessful");
				return false;
			}
			if (strAction == "OK") {
				intRet = elrscommon.VerifyPage("Main Menu");
				if (intRet == false) {
					logSteps.execution_log("<Main Menu> page is NOT displayed after <OK> button is clicked on the Cancel Popup - UnSuccessful");
				} else {
					logSteps.execution_log("<Main Menu> page is displayed - Successful");
					Search_SearchByName_Cancel = true;
				}
				return false;
			}
			if (!searchByNamePage.Header_WebElement.isPresent()) {
				logSteps.execution_log("<Search by Name> page Not dispayed - UnSuccessful");
				return false;
			}
			Search_SearchByName_Cancel = true;
			return Search_SearchByName_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Search_SearchByName_EnterData(String shtName, String intRow) {
		try {
			boolean Search_SearchByName_EnterData = false;
			String strLastName = null;
			String strGivenName = null;
			strLastName = GetValueIfValid("LastNameOrCorpName", shtName, Integer.parseInt(intRow));
			strGivenName = GetValueIfValid("GivenName", shtName, Integer.parseInt(intRow));
			searchByNamePage.LastName_WebEdit.clear();
			searchByNamePage.LastName_WebEdit.sendKeys(strLastName);
			searchByNamePage.GivenName_WebEdit.clear();
			searchByNamePage.GivenName_WebEdit.sendKeys(strGivenName);
			Search_SearchByName_EnterData = true;
			return Search_SearchByName_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
