package ca.teranet.polaris.steps;

import java.util.regex.Pattern;

import org.jbehave.core.annotations.When;
import org.openqa.selenium.Alert;

import ca.teranet.pages.polaris.DocumentSelectionPage;
import ca.teranet.pages.polaris.ReserveRegNumberPage;
import ca.teranet.polaris.util.Utility;

public class ReserveRegNumberSteps extends Utility {
	ReserveRegNumberPage reserveRegNumberPage;
	ELRSCommonSteps elrsCommon;
	DocumentSelectionPage documentSelectionPage;

	@When("user clicks the Proceed button on the Reserve Registration Number page $shtName and $intRow")
	public boolean user_clicks_proceed_on_ReserveRegNumber(String shtName, int intRow) {
		boolean ReserveRegNumber_Proceed = false;
		try {

			String strSeriesID = GetValueIfValid("SeriesID", shtName, intRow);
			String strNumToReserve = GetValueIfValid("NumToReserve", shtName, intRow);
			reserveRegNumberPage.SeriesID_WebList.selectByVisibleText(strSeriesID);
			reserveRegNumberPage.NumberReserved_WebTable.sendKeys(strNumToReserve);
			reserveRegNumberPage.Proceed_WebButton.click();
			ReserveRegNumber_Proceed = true;
			return ReserveRegNumber_Proceed;
		} catch (

		Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Cancel Reserve Registration Number $shtName and $intRow")
	public boolean user_cancel_ReserveRegNumber(String shtName, String intRow) {
		boolean ReserveRegNumber_Cancel = false;
		try {

			if (!shtName.isEmpty() && !intRow.isEmpty()) {
				String strSeriesID = GetValueIfValid("SeriesID", shtName, Integer.parseInt(intRow));
				String strNumToReserve = GetValueIfValid("NumToReserve", shtName, Integer.parseInt(intRow));
				reserveRegNumberPage.SeriesID_WebList.selectByVisibleText(strSeriesID);
				reserveRegNumberPage.NumberReserved_WebTable.sendKeys(strNumToReserve);
			}
			reserveRegNumberPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.accept();

			ReserveRegNumber_Cancel = true;
			return ReserveRegNumber_Cancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@When("user Cancel the Cancel Reserve Registration Number $shtName and $intRow")
	public boolean user_cancel_the_cancel_ReserveRegNumber_CancelCancel(String shtName, int intRow) {
		boolean ReserveRegNumber_CancelCancel = false;
		try {
			String strSeriesID = GetValueIfValid("SeriesID", shtName, intRow);
			String strNumToReserve = GetValueIfValid("NumToReserve", shtName, intRow);
			reserveRegNumberPage.SeriesID_WebList.selectByVisibleText(strSeriesID);
			reserveRegNumberPage.NumberReserved_WebTable.sendKeys(strNumToReserve);
			reserveRegNumberPage.Cancel_WebButton.click();
			Alert confirmationAlert = basePage.getDriver().switchTo().alert();
			String alertText = confirmationAlert.getText();
			System.out.println("Alert text is " + alertText);
			confirmationAlert.dismiss();
			return ReserveRegNumber_CancelCancel;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ReserveRegNumber_EnterData(String shtName, String intRow) {
		boolean ReserveRegNumber_EnterData = false;
		try {
			String strStepName = null;
			strStepName = "ReserveRegNumber_EnterData";
			String strSeriesID = GetValueIfValid("SeriesID", shtName, Integer.parseInt(intRow));
			String strNumToReserve = GetValueIfValid("NumToReserve", shtName, Integer.parseInt(intRow));

			if (strSeriesID.isEmpty()) {
				reserveRegNumberPage.SeriesID_WebList.selectByIndex(1);
			} else {
				reserveRegNumberPage.SeriesID_WebList.selectByValue("strSeriesID");
			}
			reserveRegNumberPage.NumberReserved_WebTable.sendKeys("strNumToReserve");
			ReserveRegNumber_EnterData = true;
			return ReserveRegNumber_EnterData;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Verify_ReservedRegNumbers(String shtName, String intRow) {
		boolean Verify_ReservedRegNumbers = false;
		try {
			String strStepName = null;
			strStepName = "Verify_ReservedRegNumbers";
			String strExpectedSeriesID = null;
			int intExpectedNumToReserve = 0;
			strExpectedSeriesID = GetValueIfValid("SeriesID", shtName, Integer.parseInt(intRow));
			intExpectedNumToReserve = Integer.parseInt((GetValueIfValid("NumToReserve", shtName, Integer.parseInt(intRow))));
			String strNumReserved = null;
			String strNumReservedFrom = null;
			strNumReserved = getCellData(reserveRegNumberPage.NumberReserved_WebTable, 2, 1);
			if (intExpectedNumToReserve == 1) {
				if (InStr(strNumReserved, "to") > 0) {
					return false;
				}
				if (!(InStr(strNumReserved, strExpectedSeriesID) > 0)) {
					Verify_ReservedRegNumbers = false;
					return false;
				}
				strNumReservedFrom = strNumReserved.trim();
				Verify_ReservedRegNumbers = true;
				return false;
			}
			String[] arrNumReserved = null;
			String[] arrNumReservedTo = null;
			String strNumReservedTo = null;
			arrNumReserved = (strNumReserved).split("to");
			strNumReservedFrom = arrNumReserved[0].trim();
			arrNumReservedTo = (arrNumReserved[1]).split(",");
			strNumReservedTo = arrNumReservedTo[0].trim();
			if (!(InStr(strNumReservedFrom, strExpectedSeriesID) > 0)) {
				Verify_ReservedRegNumbers = false;
				return false;
			}
			if (!(InStr(strNumReservedTo, strExpectedSeriesID) > 0)) {
				Verify_ReservedRegNumbers = false;
				return false;
			}
			String[] arrNumFrom = null;

			arrNumFrom = (strNumReservedFrom).split(strExpectedSeriesID);
			int intNumFrom = Integer.parseInt(arrNumFrom[1].trim());
			String[] arrNumTo = null;
			arrNumTo = (strNumReservedTo).split(strExpectedSeriesID);
			int intNumTo = Integer.parseInt(arrNumTo[1].trim());
			int intCounts = 0;
			intCounts = intNumTo - intNumFrom + 1;
			if (!(intCounts == intExpectedNumToReserve)) {
				Verify_ReservedRegNumbers = false;
				return false;
			}
			Verify_ReservedRegNumbers = true;
			return Verify_ReservedRegNumbers;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Verify_ReservedRegNumbers_DateTimeFormat() {
		boolean Verify_ReservedRegNumbers_DateTimeFormat = false;
		try {
			String strStepName = null;
			strStepName = "Verify_ReservedRegNumbers_DateTimeFormat";
			String strTimeStamp = null;
			String[] arrTimeStamp = null;
			String strDateTime = null;
			strTimeStamp = getCellData(reserveRegNumberPage.NumberReserved_WebTable, 4, 1);
			arrTimeStamp = (strTimeStamp).split("Date/Time Assigned:");
			strDateTime = arrTimeStamp[1].trim();
			String strDatePattern = null;
			strDatePattern = "([1-2]/d/d/d)/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])";
			String strTimePattern = null;
			strTimePattern = "([01][0-9]|2[0-3]):([0-5]/d)";
			String strPattern = null;
			strPattern = "^" + strDatePattern + " " + strTimePattern + "$";
			String oRegExp = null;
			if (!Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE).matcher(strTimePattern).matches()) {
				return false;
			}
			Verify_ReservedRegNumbers_DateTimeFormat = true;
			return Verify_ReservedRegNumbers_DateTimeFormat;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
