package ca.teranet.polaris.steps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.BatchPage;
import ca.teranet.pages.polaris.CreatePropertyPage;
import ca.teranet.pages.polaris.DividePropertyPage;
import ca.teranet.pages.polaris.DocumentDataPage;
import ca.teranet.pages.polaris.ELRSPage;
import ca.teranet.pages.polaris.LoginPage;
import ca.teranet.pages.polaris.PreSubmissionPage;
import ca.teranet.pages.polaris.PropertyDetailPage;
import ca.teranet.polaris.util.Utility;
import ca.teranet.steps.base.LogSteps;
import ca.teranet.util.WaitUtil;

public class ELRSCommonSteps extends Utility {
	LoginPage loginPage;
	CreatePropertyPage createPropertyPage;
	PropertyDetailPage propertyDetailPage;
	ELRSPage elrsPage;
	InputStream inputStream;
	LogSteps logSteps = new LogSteps();
	PreSubmissionPage preSubmissionPage;
	DocumentDataPage documentDataPage;
	BatchPage batchPage;
	DividePropertyPage dividePropertyPage;

	@Given("user login into Polaris application with $SHEETNAME and $ROW")
	@When("user login into Polaris application with $SHEETNAME and $ROW")
	public boolean user_login_into_Polaris_application_with(String SHEETNAME, int ROW) {
		boolean ELRS_Login = false;
		try {

			String strUserID = GetValueIfValid("UserID", SHEETNAME, ROW);
			String strPassword = GetValueIfValid("Password", SHEETNAME, ROW);
			String strEnvironment = GetValueIfValid("Environment", SHEETNAME, ROW);
			switch (strEnvironment.toUpperCase()) {
			case "UAT_AUTOMATION":
				environmentlib.setProperty("APP_URL", environmentlib.getProperty("UAT_Automation"));
				break;
			case "UAT_QA_MRK":
				environmentlib.setProperty("APP_URL", environmentlib.getProperty("UAT_QA_MRK"));
				break;
			case "UAT_QA_ST":
				environmentlib.setProperty("APP_URL", environmentlib.getProperty("UAT_QA_ST_URL"));
				break;
			case "UAT_SANDBOX_ST":
				environmentlib.setProperty("APP_URL", environmentlib.getProperty("UAT_SandBox_ST"));
				break;
			case "UAT_SANDBOX_MR":
				environmentlib.setProperty("APP_URL", environmentlib.getProperty("UAT_SandBox_MR"));
				break;
			}
			basePage.getDriver().get(environmentlib.getProperty("APP_URL"));
			enlargeTestScreen();
			basePage.getDriver().switchTo().frame(0);
			loginPage.UserID_WebEdit.sendKeys(strUserID);
			loginPage.Password_WebEdit.sendKeys(strPassword);
			loginPage.Submit_WebButton.click();
			boolean intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				ELRS_Login = false;
				return ELRS_Login;
			}
			ELRS_Login = true;
			return ELRS_Login;
		} catch (Exception e) {
			e.printStackTrace();
			return ELRS_Login;
		}
	}

	@Then("user log out of the application")
	@When("user log out of the application")
	public boolean user_log_out_of_the_application() throws IOException {
		boolean ELRS_Logout = false;
		try {
			WaitUtil.waitMSeconds(1000);
			String webEleCancelButton = "//input[@value='Cancel']";
			if (verify_element_present(webEleCancelButton)) {
				mainPage.getDriver().findElement(By.xpath("//input[@value='Cancel']")).click();
				Alert confirmationAlert = basePage.getDriver().switchTo().alert();
				confirmationAlert.accept();
				WaitUtil.waitMSeconds(500);
			}
			mainPage.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			WaitUtil.waitMSeconds(1000);
			mainPage.Logout_WebElement.click();
			ELRS_Logout = true;
			return ELRS_Logout;
		} catch (Exception e) {
			e.printStackTrace();
			return ELRS_Logout;
		}
	}

	public boolean verify_element_present(String eXpath) {
		try {
			mainPage.getDriver().findElement(By.xpath(eXpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@When("user navigates to $strMenu")
	public boolean user_navigates_to(String strMenu) {
		boolean ELRS_Navigate_To_Menu = false;
		try {
			String strMenuName = null;
			String strFunctionID = null;
			switch (strMenu.toUpperCase()) {

			case "CERTIFY":
				strMenuName = "Certify";
				strFunctionID = strMenu;
				documentsMenuItemsClick(strMenuName);
				break;
			case "VIEWWORKQ":
				strMenuName = "View Work Queue/(s/)";
				strFunctionID = "Work Queue";
				documentsMenuItemsClick(strMenuName);
				break;
			case "RETRIEVEDOCUMENTIMAGE":
				strMenuName = "Retrieve Document Image";
				strFunctionID = strMenuName;
				documentsMenuItemsClick(strMenuName);
				break;
			case "CORRECTCERTIFIEDDOCUMENT":
				strMenuName = "Correct Certified Document";
				strFunctionID = strMenuName;
				documentsMenuItemsClick(strMenuName);
				break;
			case "REGISTER":
				strMenuName = "Register Document(s)";
				strFunctionID = "Register";
				documentsMenuItemsClick(strMenuName);
				break;
			case "RESERVEREGNUMBER":
				strMenuName = "Reserve Registration Number";
				strFunctionID = "Reserve Reg Numbers";
				documentsMenuItemsClick(strMenuName);
				break;
			case "RECORDHISTORICAL":
				strMenuName = "Record Historical";
				strFunctionID = strMenuName;
				documentsMenuItemsClick(strMenuName);
				break;
			case "RETRIEVESAVEDFOLDER":
				strMenuName = "Retrieve Saved Folder";
				strFunctionID = "Register";
				documentsMenuItemsClick(strMenuName);
				break;
			case "VIEWBATCHQ":
				strMenuName = "View Batch Document Processing Queue";
				strFunctionID = "Batch Queue";
				documentsMenuItemsClick(strMenuName);
				break;
			case "CREATESINGLEPROPERTY":
			case "CREATEPROPERTY":
				strMenuName = "Create Single Property";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "SEARCHDOCUMENT":
				strMenuName = "Document";
				strFunctionID = "Search Document";
				searchMenuItemsClick(strMenuName);
				break;
			case "CHANGEACTIVELRO":
				strMenuName = "Change Active LRO";
				strFunctionID = "Change LRO";
				administrationMenuItemsClick(strMenuName);
				break;
			case "CORRECTUPDATECERTIFIEDPROPERTY":
				strMenuName = "Correct/Update Certified Property";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "DIVIDEPROPERTY":
				strMenuName = "Divide Single Property";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "CONSOLIDATEPROPERTY":
				strMenuName = "Consolidate Property";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "REENTERPROPERTY":
				strMenuName = "Re-enter Single Property";
				strFunctionID = "Re-Enter Property";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "WITHDRAWREGISTRATION":
				strMenuName = "Withdraw Registration";
				strFunctionID = strMenuName;
				documentsMenuItemsClick(strMenuName);
				break;
			case "OPENSUBDIVISION":
				strMenuName = "Open Subdivision";
				strFunctionID = "Open Property Subdivision";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "OPENCONDOMINIUM":
				strMenuName = "Open Condominium Property";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "CONDOAMENDMENT":
				strMenuName = "Condominium Amendment Adding Land with Units";
				strFunctionID = "Condominium Amendment";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "CREATEUNITS":
				strMenuName = "Create Units from Common Elements";
				strFunctionID = "Create Condo Amendment";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "CONDOAMALGAMATION":
				strMenuName = "Condominium Amalgamation";
				strFunctionID = "Condominium Amalgamation";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "UPDATECERTIFIEDPROPERTYBULK":
				strMenuName = "Update Certified Property Bulk";
				strFunctionID = "Update Certified Property Bulk";
				propertiesMenuItemsClick(strMenuName);
				break;
			case "FREEZEUNFREEZEPROPERTY":
				strMenuName = "Update Certified Property Freeze and Unfreeze";
				strFunctionID = strMenuName;
				propertiesMenuItemsClick(strMenuName);
				break;
			case "SEARCHREGISTER":
			case "SEARCHBYPIN":
				strMenuName = "Register";
				strFunctionID = "Search Register";
				searchMenuItemsClick(strMenuName);
				break;
			case "SEARCHNAMEADDRESS":
				strMenuName = "By Name/Address";
				strFunctionID = "Search by Name/Address";
				searchMenuItemsClick(strMenuName);
				break;
			case "SEARCHBYEXPRESSPRINT":
				strMenuName = "Express Print by PIN";
				strFunctionID = strMenuName;
				searchMenuItemsClick(strMenuName);
				break;
			case "SEARCHPOA":
				strMenuName = "Power of Attorney";
				strFunctionID = "Search Power of Attorney";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "SEARCHFTYPE":
				strMenuName = "General Register";
				strFunctionID = "Search F Type";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "SEARCHSTANDARDCHARGETERMS":
				strMenuName = "Standard Charge Terms";
				strFunctionID = "Search Standard Charge Terms";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "SEARCHSTANDARDTERMSOFAGREEMENT":
				strMenuName = "Standard Terms Of Agreement";
				strFunctionID = "Search Standard Terms of Agreement";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "SEARCHHIGHWAYSREGISTER":
			case "SEARCHHWY":
				strMenuName = "Highways Register";
				strFunctionID = "Search Highways Register";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "SEARCHTCPL":
				strMenuName = "TransCanada Pipeline Index";
				strFunctionID = "Search TransCanada Pipeline Index";
				searchSubMenuItemsClick(strMenuName);
				break;
			case "CHANGEDOCUMENTONHOLD":
				strMenuName = "Change Document On Hold Status";
				strFunctionID = "Change Document Hold";
				documentsMenuItemsClick(strMenuName);
				break;
			case "MAINTAINBLOCK":
				strMenuName = "Maintain Block";
				strFunctionID = "Maintain Block";
				administrationMenuItemsClick(strMenuName);
				break;
			default:
				ELRS_Navigate_To_Menu = false;
				break;
			}
			return ELRS_Navigate_To_Menu;
		} catch (Exception e) {
			e.printStackTrace();
			return ELRS_Navigate_To_Menu;
		}
	}

	private void documentsMenuItemsClick(String submenuitem) throws Exception {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		elrsPage.Documents_MenuItem.click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[text()='" + submenuitem + "']"));
		submItem.click();
		WaitUtil.waitMSeconds(2000);
	}

	private void propertiesMenuItemsClick(String submenuitem) {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		elrsPage.Properties_MenuItem.click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[text()='" + submenuitem + "']"));
		submItem.click();
	}

	private void searchMenuItemsClick(String submenuitem) {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		elrsPage.Search_MenuItem.click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[text()='" + submenuitem + "']"));
		submItem.click();
	}

	private void reportsMenuItemsClick(String submenuitem) {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		elrsPage.Reports_MenuItem.click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[text()='" + submenuitem + "']"));
		submItem.click();
	}

	private void administrationMenuItemsClick(String submenuitem) throws Exception {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		elrsPage.Administration_MenuItem.click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[contains(text(),'" + submenuitem + "')]"));
		submItem.click();
		// WaitUtil.waitMSeconds(1000);
	}

	private void searchSubMenuItemsClick(String submenuitem) throws Exception {
		mainPage.getDriver().switchTo().defaultContent();
		mainPage.getDriver().switchTo().frame(0);
		WaitUtil.waitMSeconds(3000);
		elrsPage.Search_MenuItem.click();
		mainPage.getDriver().findElement(By.xpath("//td[text()='Other Indices']")).click();
		WebElement submItem = mainPage.getDriver().findElement(By.xpath("//td[contains(text(),'" + submenuitem + "')]"));
		submItem.click();
		WaitUtil.waitMSeconds(3000);
	}

	@When("user click on popup actions $strAction")
	public boolean ELRS_Popup_Cancel(String strAction) {
		boolean ELRS_Popup_Cancel = false;
		try {
			Alert alert = basePage.getDriver().switchTo().alert();
			switch (strAction) {
			case "OK":
				alert.accept();
				WaitUtil.waitMSeconds(2000);
				break;
			case "Cancel":
				alert.dismiss();
				break;
			}
			ELRS_Popup_Cancel = true;
			return ELRS_Popup_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return ELRS_Popup_Cancel;
		}
	}

	@Then("verify user navigates to main menu")
	public boolean user_navigates_to_main_menu() {
		try {
			VerifyPage("Main Menu");
			logSteps.execution_log("User navigates to Main Menu");
			WaitUtil.waitMSeconds(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Then("verify user navigates to search poa menu")
	public boolean user_navigates_to_search_poa_menu() {
		try {
			VerifyPage("Search Power of Attorney");
			logSteps.execution_log("User navigates to Search Power of Attorney Menu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Then("verify user navigates to menu $strMenu")
	public boolean user_navigates_to_menu(String strMenu) {
		try {
			boolean user_navigates_to_menu = false;
			// VerifyPage(strMenu);
			String strFuncName = mainPage.FuncID_WebElement.getText().trim();
			if (strFuncName.contains(strMenu)) {
				logSteps.execution_log("User navigates to" + strMenu);
				user_navigates_to_menu = true;
			} else {
				logSteps.execution_log("VerifyPage <" + strMenu + "> - UnSuccessful. The actual page is <" + strFuncName + ">");
				user_navigates_to_menu = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Then("user verify the UI object properties $shtName and $intRow")
	public boolean UiObject_verify_Property(String shtName, String intRow) {
		String strStepName = "UiObject_verify_Property";
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

			String strObject = GetValueIfValid("Object", shtName, iLoop);
			String strObjectName = GetValueIfValid("Name", shtName, iLoop);
			String strObjectProperty = GetValueIfValid("Property", shtName, iLoop);
			String strObjectAction = GetValueIfValid("Action", shtName, iLoop);

			switch (strObject.toUpperCase()) {
			case "WEBBUTTON":
				if (strObjectName.toUpperCase().equals("PINNEXT")) {
					if (strObjectProperty.equals("disabled:=1")) {
						if (!preSubmissionPage.Next_WebButton_1.isEnabled())
							// logSteps.execution_log("Ui Object Is Disabled");
							return true;
					} else if (strObjectProperty.equals("disabled:=0")) {
						if (preSubmissionPage.Next_WebButton_1.isEnabled())
							// logSteps.execution_log("Ui Object Is Enabled");
							return true;
					} else
						return false;
				}
				if (strObjectName.toUpperCase().equals("PINPREVIOUS")) {
					if (strObjectProperty.equals("disabled:=1")) {
						if (!preSubmissionPage.Prev_WebButton_1.isEnabled())
							// logSteps.execution_log("Ui Object Is Disabled");
							return true;
					} else if (strObjectProperty.equals("disabled:=0")) {
						if (preSubmissionPage.Prev_WebButton_1.isEnabled())
							// logSteps.execution_log("Ui Object Is Enabled");
							return true;
					} else
						return false;
				}
				break;
			case "WEBTABLE":

				break;
			case "WebEdit":
				if (strObjectName.equals("Description0")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}

				if (strObjectName.equals("Over1")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}
				if (strObjectName.equals("FavorOf1")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}
				if (strObjectName.equals("Until1")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}
				if (strObjectName.equals("AsIn1")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}
				if (strObjectName.equals("Share1")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}
				if (strObjectName.equals("CorrectionNotice")) {
					if (strObjectProperty.equals("readonly:=0"))
						return true;
				}

				break;
			case "WEBLIST":
				if (strObjectName.equals("Status")) {
					// String status = propertydetailpage.Propertystatus.getText();
					if (strObjectProperty.contains("value:=ACTIVE"))
						return true;
				}
				if (strObjectName.equals("Estate0")) {
					String estate = mainPage.getDriver().findElement(By.xpath("//select[@id='Prop0Interest']")).getText();
					if (strObjectProperty.contains(estate))
						return true;
				}
				if (strObjectName.equals("Qualifier0")) {
					String qualifier = mainPage.getDriver().findElement(By.xpath("//select[@id='Prop0Qualifier']")).getText();
					if (strObjectProperty.contains(qualifier))
						return true;
				}
				if (strObjectName.equals("LowerMunicipality0")) {
					String LowerMunicipality = mainPage.getDriver().findElement(By.xpath("//select[@name='lowerTierMunicipalityMap['0']']")).getText();
					if (strObjectProperty.contains(LowerMunicipality))
						return true;
				}
				if (strObjectName.equals("Capacity1")) {
					String Capacity = mainPage.getDriver().findElement(By.xpath("//select[@id='ownerCapacity0_0']")).getText();
					if (strObjectProperty.contains(Capacity))
						return true;
				}
				if (strObjectName.equals("PINOrigin")) {
					// String Pinorigin = mainPage.getDriver().findElement(By.xpath("//td[text()='DIVISION']")).getText();
					if (strObjectProperty.equals("disabled:=1"))
						return true;
				}

				break;
			case "WebCheckBox":

				if (strObjectName.equals("Owner1")) {
					if (strObjectProperty.equals("disabled:=1"))
						return true;
				}
				if (strObjectName.equals("AddEasement1")) {
					if (strObjectProperty.equals("disabled:=1"))
						return true;
				}
				if (strObjectName.equals("French1")) {
					if (strObjectProperty.equals("disabled:=1"))
						return true;
				}

				break;
			case "WebElement":
				if (strObjectName.equals("RegSystem")) {
					String regsystem = propertyDetailPage.Registrationsystem.getText();
					if (strObjectProperty.contains(regsystem))
						return true;
				}
				if (strObjectName.equals("Notices")) {
					String notices = mainPage.getDriver().findElement(By.xpath("//td[@id='correctionNotice']")).getText();
					if (strObjectProperty.contains(notices))
						return true;
				}
				break;
			}
			return false;
		}
		return false;
	}

	@When("user Perform an action on the specified UI object $UIOBJECTSHEETNAME and $UIOBJECTROWINDEX2")
	public boolean User_perform_action_on_UiObject(String shtName, String intRow) {
		String strObject = GetValueIfValid("Object", shtName, Integer.parseInt(intRow));
		String strObjectName = GetValueIfValid("Name", shtName, Integer.parseInt(intRow));
		String strObjectProperty = GetValueIfValid("Property", shtName, Integer.parseInt(intRow));
		String strObjectAction = GetValueIfValid("Action", shtName, Integer.parseInt(intRow));

		switch (strObjectAction.toUpperCase()) {
		case "CLICK":
			if (strObjectName.toUpperCase().equals("PINNEXT")) {
				if (strObjectProperty.equals("disabled:=1")) {
					preSubmissionPage.Next_WebButton_1.click();
					return true;
				} else if (strObjectProperty.equals("disabled:=0")) {
					preSubmissionPage.Next_WebButton_1.click();
					// logSteps.execution_log("Ui Object Is Enabled");
					return true;
				} else
					return false;
			}
			if (strObjectName.toUpperCase().equals("PINPREVIOUS")) {
				if (strObjectProperty.equals("disabled:=1")) {
					preSubmissionPage.Prev_WebButton_1.click();
					// logSteps.execution_log("Ui Object Is Disabled");
					return true;
				} else if (strObjectProperty.equals("disabled:=0")) {
					preSubmissionPage.Prev_WebButton_1.click();
					// logSteps.execution_log("Ui Object Is Enabled");
					return true;
				} else
					return false;
			}
			break;
		case "WEBTABLE":

			break;
		case "WEBLIST":

			break;
		case "WEBBUTTON":
			dividePropertyPage.Cancel_WebButton.click();
			String strAction = "OK";
			ELRS_Popup_Cancel(strAction);
			break;
		}
		return false;
	}

	@Then("user verifies the UI object properties $text and $shtName and $intRow")
	public boolean verify_UiObject_Property(String text, String shtName, String intRow) {
		String strObject = GetValueIfValid("Object", shtName, Integer.parseInt(intRow));
		String strObjectName = GetValueIfValid("Name", shtName, Integer.parseInt(intRow));
		String strObjectProperty = GetValueIfValid("Property", shtName, Integer.parseInt(intRow));
		String strObjectAction = GetValueIfValid("Action", shtName, Integer.parseInt(intRow));

		switch (strObject.toUpperCase()) {
		case "WEBBUTTON":
			if (strObjectProperty.equals("disabled:=1")) {
				if (!mainPage.getDriver().findElement(By.xpath("//*[contains(@value,'" + text + "')]")).isEnabled())
					return true;
			} else if (strObjectProperty.equals("disabled:=0")) {
				if (mainPage.getDriver().findElement(By.xpath("//*[contains(@value,'" + text + "')]")).isEnabled())
					return true;
			} else
				return false;
			break;
		case "WEBTABLE":
			break;
		case "WEBLIST":
			break;
		case "WEBEDIT":
			if (strObjectProperty.equals("disabled:=1")) {
				if (!mainPage.getDriver().findElement(By.xpath("//*[contains(@name," + text + ")]")).isEnabled())
					return true;
			} else if (strObjectProperty.equals("disabled:=0")) {
				if (mainPage.getDriver().findElement(By.xpath("//*[contains(@name," + text + ")]")).isEnabled())
					return true;
			} else
				return false;

			if (strObjectProperty.equals("disabled:=1")) {
				if (!preSubmissionPage.Prev_WebButton_1.isEnabled())
					return true;
			} else if (strObjectProperty.equals("disabled:=0")) {
				if (preSubmissionPage.Prev_WebButton_1.isEnabled())
					return true;
			} else
				return false;
			break;
		}
		return false;
	}

	public String Generate_Unique_RegNumber() {
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(100000);
		String regNumber = "WE" + String.valueOf(randomInt);
		return regNumber;
	}

	public String Generate_Unique_Random_RegNumber() {
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(100000);
		String regNumber = "WE" + String.valueOf(randomInt);
		return regNumber;
	}

	@Then("user verifies the UI object properties $shtName and $intRow")
	public boolean UiObject_verify_Property(String shtName, int intRow) {
		String strObject = GetValueIfValid("Object", shtName, (intRow));
		String strObjectName = GetValueIfValid("Name", shtName, (intRow));
		String strObjectProperty = GetValueIfValid("Property", shtName, (intRow));
		String strObjectAction = GetValueIfValid("Action", shtName, (intRow));

		switch (strObject.toUpperCase()) {
		case "WEBBUTTON":
			if (strObjectName.toUpperCase().equals("PINNEXT")) {
				if (strObjectProperty.equals("disabled:=1")) {
					if (!preSubmissionPage.Next_WebButton_1.isEnabled())
						// logSteps.execution_log("Ui Object Is Disabled");
						return true;
				} else if (strObjectProperty.equals("disabled:=0")) {
					if (preSubmissionPage.Next_WebButton_1.isEnabled())
						// logSteps.execution_log("Ui Object Is Enabled");
						return true;
				} else
					return false;
			}
			if (strObjectName.toUpperCase().equals("PINPREVIOUS")) {
				if (strObjectProperty.equals("disabled:=1")) {
					if (!preSubmissionPage.Prev_WebButton_1.isEnabled())
						// logSteps.execution_log("Ui Object Is Disabled");
						return true;
				} else if (strObjectProperty.equals("disabled:=0")) {
					if (preSubmissionPage.Prev_WebButton_1.isEnabled())
						// logSteps.execution_log("Ui Object Is Enabled");
						return true;
				} else
					return false;
			}
			break;
		case "WEBTABLE":

			break;
		case "WebEdit":
			if (strObjectName.equals("Description0")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}

			if (strObjectName.equals("Over1")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}
			if (strObjectName.equals("FavorOf1")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}
			if (strObjectName.equals("Until1")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}
			if (strObjectName.equals("AsIn1")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}
			if (strObjectName.equals("Share1")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}
			if (strObjectName.equals("CorrectionNotice")) {
				if (strObjectProperty.equals("readonly:=0"))
					return true;
			}

			break;
		case "WEBLIST":
			if (strObjectName.equals("Status")) {
				// String status = propertydetailpage.Propertystatus.getText();
				if (strObjectProperty.contains("value:=ACTIVE"))
					return true;
			}
			if (strObjectName.equals("Estate0")) {
				String estate = mainPage.getDriver().findElement(By.xpath("//select[@id='Prop0Interest']")).getText();
				if (strObjectProperty.contains(estate))
					return true;
			}
			if (strObjectName.equals("Qualifier0")) {
				String qualifier = mainPage.getDriver().findElement(By.xpath("//select[@id='Prop0Qualifier']")).getText();
				if (strObjectProperty.contains(qualifier))
					return true;
			}
			if (strObjectName.equals("LowerMunicipality0")) {
				String LowerMunicipality = mainPage.getDriver().findElement(By.xpath("//select[@name='lowerTierMunicipalityMap['0']']")).getText();
				if (strObjectProperty.contains(LowerMunicipality))
					return true;
			}
			if (strObjectName.equals("Capacity1")) {
				String Capacity = mainPage.getDriver().findElement(By.xpath("//select[@id='ownerCapacity0_0']")).getText();
				if (strObjectProperty.contains(Capacity))
					return true;
			}
			if (strObjectName.equals("PINOrigin")) {
				// String Pinorigin = mainPage.getDriver().findElement(By.xpath("//td[text()='DIVISION']")).getText();
				if (strObjectProperty.equals("disabled:=1"))
					return true;
			}

			break;
		case "WebCheckBox":

			if (strObjectName.equals("Owner1")) {
				if (strObjectProperty.equals("disabled:=1"))
					return true;
			}
			if (strObjectName.equals("AddEasement1")) {
				if (strObjectProperty.equals("disabled:=1"))
					return true;
			}
			if (strObjectName.equals("French1")) {
				if (strObjectProperty.equals("disabled:=1"))
					return true;
			}

			break;
		case "WebElement":
			if (strObjectName.equals("RegSystem")) {
				String regsystem = propertyDetailPage.Registrationsystem.getText();
				if (strObjectProperty.contains(regsystem))
					return true;
			}
			if (strObjectName.equals("Notices")) {
				String notices = mainPage.getDriver().findElement(By.xpath("//td[@id='correctionNotice']")).getText();
				if (strObjectProperty.contains(notices))
					return true;
			}
			break;
		}
		return false;
	}

	@When("user navigating to the tab $tabname")
	public void clickTabLink(String tabname) {
		switch (tabname.toUpperCase()) {
		case "CORRECTIONNOTICES":
			propertyDetailPage.CorrectionNotices_Link.click();
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

	public boolean Properties_Batch_PreSubmission(String strFunction) {
		try {
			String strStepName = null;
			strStepName = "Properties_Batch_PreSubmission <" + strFunction + ">";
			boolean Properties_Batch_PreSubmission = false;
			String strBatchFunc = null;
			// strBatchFunc = batchPage.PreSubmission_WebElement.getText();
			if (!(InStr(strBatchFunc, strFunction) > 0)) {
				logSteps.execution_log("<" + strFunction + "> Not displayed on the Schedule Off-Line Pre-Submission page - UnSuccessful");
				return false;
			}
			batchPage.OK_WebButton.click();
			boolean intRet = false;
			intRet = VerifyPage("Main Menu");
			if (intRet == false) {
				logSteps.execution_log("<Main Menu> page Not displayed - UnSuccessful");
				return false;
			}
			logSteps.execution_log("<Main Menu> page displayed - Successful");
			Properties_Batch_PreSubmission = true;
			return Properties_Batch_PreSubmission;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify uiobject not exist $uiobject and $shtName and $intRow")
	public boolean verifyUIObjectNotExist(String uiobject, String shtName, String intRow) {
		try {
			WebElement uiObject = mainPage.getDriver().findElement(By.xpath("//*[contains(text(),'" + uiobject + "')]"));
			String uiObjectText = uiObject.getText();
			System.out.println(uiObjectText);
			if (!uiObject.isDisplayed()) {
				// logSteps.execution_log(uiobject + " is exist");
				return true;
			} else {
				// logSteps.execution_log(uiobject + " is not exist");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Then("user verify uiobject exist $uiobject and $shtName and $intRow")
	public boolean verifyUIObjectExist(String uiobject, String shtName, String intRow) {
		try {
			WebElement uiObject = mainPage.getDriver().findElement(By.xpath("//*[contains(text(),'" + uiobject + "')]"));
			String uiObjectText = uiObject.getText();
			System.out.println(uiObjectText);
			if (uiObject.isDisplayed()) {
				// logSteps.execution_log(uiobject + " is exist");
				return true;
			} else {
				// logSteps.execution_log(uiobject + " is not exist");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user perform action on the specified UI object $value and $shtName and $intRow")
	public boolean user_perform_an_action_on_UiObject(String value, String shtName, String intRow) {
		try {
			String strObject = GetValueIfValid("Object", shtName, Integer.parseInt(intRow));
			String strObjectName = GetValueIfValid("Name", shtName, Integer.parseInt(intRow));
			String strObjectProperty = GetValueIfValid("Property", shtName, Integer.parseInt(intRow));
			String strObjectAction = GetValueIfValid("Action", shtName, Integer.parseInt(intRow));
			switch (strObjectAction.toUpperCase()) {
			case "CLICK":
				mainPage.getDriver().findElement(By.xpath("//*[contains(@value,'" + value + "')]")).click();
				WaitUtil.waitMSeconds(2000);
				break;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}