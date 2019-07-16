package ca.teranet.polaris.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ca.teranet.polaris.base.steps.PolarisBaseSteps;
import ca.teranet.util.WaitUtil;

public class Utility extends PolarisBaseSteps {

	public static String strRegNumber = null;
	public static String mainWindowHandle = null;

	// ************************************************************************************************************
	// Function Name: GetValueIfValid
	// Description: Fetch the value from the data sheet if data is valid
	// Input Parameter:
	// colName - Column name in data sheet
	// shtName - Data sheet name
	// Return value:
	// IGNORE_VALUE - if data is not valid or no action wants to be
	// performed
	// strValue - the valid data input from the data sheet
	// Change Log:
	// 05-04-2012 / Jenny / Initial version
	// **************************************************************************************************************
	public String GetValueIfValid(String colName, String shtName, int row) {

		String GetValueIfValid = "";
		try {
			Sheet sheet = PolarisBaseSteps.workbook.getSheet(shtName.trim());
			Row datarow = sheet.getRow(row);
			Row headerrow = sheet.getRow(0);
			Map<String, Integer> map = new HashMap<String, Integer>();
			int minColIx = headerrow.getFirstCellNum();
			int maxColIx = headerrow.getLastCellNum();
			for (int colIx = minColIx; colIx < maxColIx; colIx++) {
				Cell cell = headerrow.getCell(colIx);
				map.put(cell.getStringCellValue(), cell.getColumnIndex());
			}
			String strValue = getCellValue(datarow.getCell(map.get(colName)));
			// If strValue = "" OR UCase(strValue) = "N/C" OR UCase(strValue) =
			// "N/A" Then
			if (strValue.toUpperCase().equals("N/C") || strValue.toUpperCase().equals("NC") || strValue.toUpperCase().equals("N/A")
					|| strValue.toUpperCase().equals("NA")) {
			} else {
				GetValueIfValid = strValue;
			}
			return GetValueIfValid;
		} catch (Exception e) {
			// e.printStackTrace();
			return GetValueIfValid;
		}
	}

	public String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;

			case Cell.CELL_TYPE_FORMULA:
				cellValue = cell.getCellFormula();
				break;

			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue().toString();
				} else {
					DataFormatter fmt = new DataFormatter();
					cell.setCellType(CellType.STRING);
					cellValue = fmt.formatCellValue(cell);
				}
				break;

			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;

			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;

			}
		}
		return cellValue;
	}

	// ****************************************************************************************
	// Function Name: VerifyErrorMessage
	// Description: Verify the error message displayed on a page
	// Input Parameter:
	// strStepName - Function step name
	// strErrorMsgs - Actual message displayed on a page
	// strExpectedMsgs - Expected message
	// Return Value: True or False
	// Change Log:
	// 05-31-2012 / Jenny / Initial version
	// 07-19-2012 / Jenny / Update to handle message in regular expression
	// ****************************************************************************************
	public boolean VerifyErrorMessage(String strStepName, String strErrorMsgs, String strExpectedMsgs) {
		boolean VerifyErrorMessage = false;
		try {
			// VerifyErrorMessage = False
			boolean intRet = false;
			String strUpdatedMsgs = null;
			if (!strErrorMsgs.equals("")) {
				// Report fail if no error message expected
				if (strExpectedMsgs == "" || strExpectedMsgs == "IGNORE_VALUE") {
					// Reporter.reportEvent(Status.Failed, strStepName,
					// "Unexpected error message:<" + strErrorMsgs + "> is returned - UnSuccessful");
					// utility.AddMsg(strErrorMsgs);
					// utility.AddInfo("Unexpected error message is returned as shown above - UnSuccessful");
					VerifyErrorMessage = false;
				} else {
					// Case1 - Multiple message
					if (strExpectedMsgs.contains(String.valueOf((char) (10)))) {
						// Replace multiple line break with ""
						strUpdatedMsgs = strExpectedMsgs.replace(String.valueOf((char) (10)), "");
						// 08-09-2012/Jenny/Add to handle regular expression for
						// multiple messages
						if (strUpdatedMsgs.contains(".*")) {
							intRet = VerifyErrorMessage_RegExp(strErrorMsgs, strUpdatedMsgs);
							VerifyErrorMessage = intRet;
							return VerifyErrorMessage;
						}
						// Case 2 - Regular expression
					} else if (strExpectedMsgs.contains(".*")) {
						intRet = VerifyErrorMessage_RegExp(strErrorMsgs, strExpectedMsgs);
						VerifyErrorMessage = intRet;
						return VerifyErrorMessage;
						// Case 3 - Single message
					} else {
						strUpdatedMsgs = strExpectedMsgs;
					}
					if (strErrorMsgs.compareTo(strUpdatedMsgs) != 0) {
						if (strExpectedMsgs.contains(String.valueOf((char) (10)))) {
							// Work around - reorder the error messages for the
							// known issue as the application returns the error
							// messages not in consistent order
							intRet = VerifyErrorMessage_MultipleMsgs(strErrorMsgs, strExpectedMsgs);
							if (intRet == true) {
								// Reporter.reportEvent(Status.Passed, strStepName,
								// "Expected error message <" + strErrorMsgs + "> is returned - Successful");
								// utility.AddMsg(strErrorMsgs);
								// utility.AddInfo("Expected error message is returned as shown above - Successful");
								VerifyErrorMessage = true;
							} else {
								// 11-26-2012/Jenny/Add Warning case
								// Reporter.reportEvent(Status.Warning, strStepName,
								// "Unexpected error message <" + strErrorMsgs + "> is returned - UnSuccessful");
								// utility.AddMsg(strErrorMsgs);
								// VerifyErrorMessage = "Warning";
							}
						} else {
							// Reporter.reportEvent(Status.Warning, strStepName,
							// "Unexpected error message <" + strErrorMsgs + "> is returned - UnSuccessful");
							// utility.AddMsg(strErrorMsgs);
							// utility.AddInfo(
							// "Warning! Unexpected error message is returned as shown above. Expected error message: <"
							// + strExpectedMsgs + "> - UnSuccessful");
							// VerifyErrorMessage = "Warning";
						}
						return VerifyErrorMessage;
					}
					// Reporter.reportEvent(Status.Passed, strStepName,
					// "Expected error message <" + strErrorMsgs + "> is returned - Successful");
					// utility.AddMsg(strErrorMsgs);
					// utility.AddInfo("Expected error message is returned as shown above - Successful");
					VerifyErrorMessage = true;
				}
			}
			return VerifyErrorMessage;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyErrorMessage;
		}
	}

	// ***********************************************************************************************
	// Function Name: VerifyErrorMessage_RegExp
	// Description: Verify message in regular expression
	// Input Parameter:
	// strErrorMsgs - Actual message displayed on a page
	// strExpectedMsgs - Expected message in regular expression
	// Return Value: True or Warning
	// Change Log:
	// 07-19-2012 / Jenny / Initial Version
	// ************************************************************************************************
	public boolean VerifyErrorMessage_RegExp(String strErrorMsgs, String strExpectedMsgs) {
		boolean VerifyErrorMessage_RegExp = false;
		try {
			String strStepName = "VerifyErrorMessage_RegExp";
			String strPattern = strExpectedMsgs;
			if (!Pattern.compile(strPattern, Pattern.CASE_INSENSITIVE).matcher(strErrorMsgs).find(0)) {
				// Reporter.reportEvent(Status.Warning, strStepName,
				// "Unexpected message is returned - UnSuccessful, Expected message in format: <" + strExpectedMsgs
				// + ">, Actual:<" + strErrorMsgs + ">");
				// utility.AddMsg(strErrorMsgs);
				// utility.AddInfo(
				// "Unexpected message is returned as shown above - UnSuccessful, Expected message in format: <"
				// + strExpectedMsgs + ">");
				// String VerifyErrorMessage_RegExp = "Warning";
			} else {
				// Reporter.reportEvent(Status.Passed, strStepName, "Expected message is returned - Successful");
				// utility.AddMsg(strErrorMsgs);
				// utility.AddInfo("Expected message is returned as shown above - Successful");
				VerifyErrorMessage_RegExp = true;
			}
			return VerifyErrorMessage_RegExp;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyErrorMessage_RegExp;
		}
	}

	// ******************************************************************************************
	// Function Name: VerifyErrorMessage_MultipleMsgs
	// Description: Work around for multiple error messages verification
	// Input Parameter:
	// strErrorMsgs - Actual message displayed on a page
	// strExpectedMsgs - Expected multiple error messages
	// Return Value: True or False
	// Change Log:
	// 06-07-2012 / Jenny / Initial version
	// 07-18-2012 / Jenny / Update to handle more than 2 error messages
	// *************************************************************************************
	public boolean VerifyErrorMessage_MultipleMsgs(String strErrorMsgs, String strExpectedMsgs) {
		boolean VerifyErrorMessage_MultipleMsgs = false;
		try {
			// This is a workaround, only handle two error messages
			Object strMsg1 = null;
			Object strMsg2 = null;
			String[] arrExpectedMsgs = (strExpectedMsgs).split(String.valueOf((char) (10)));
			// strMsg1 = Trim(arrExpectedMsgs(0))
			// strMsg2 = Trim(arrExpectedMsgs(1))
			// 07-18-2012/Jenny/Add the following block to handle multiple
			// messages
			String strSingleMsg = null;
			int intCounts = arrExpectedMsgs.length - 1;
			int intEnd = intCounts + 1;
			VerifyErrorMessage_MultipleMsgs = true;
			for (int iLoop = 1; iLoop <= intEnd; iLoop++) {
				strSingleMsg = arrExpectedMsgs[iLoop - 1];
				if (!strErrorMsgs.contains(strSingleMsg)) {
					// Reporter.ReportEvent micWarning, strStepName,
					// "<"&strSingleMsg &"> is expected, but not present on the
					// page"
					// utility.AddInfo("<" + strSingleMsg + "> is expected, but not present on the page");
					VerifyErrorMessage_MultipleMsgs = false;
				}
			}
			// If Not StrComp(strErrorMsgs, strMsg1 & strMsg2) = 0 Then
			// If Not StrComp(strErrorMsgs, strMsg2 & strMsg1) = 0 Then
			// Reporter.ReportEvent micWarning, strStepName, strErrorMsgs &" is
			// returned, but not as expected"
			// AddMsg strErrorMsgs
			// AddInfo "Warning! Unexpected error message is returned as shown
			// above. The expected error message is " &strExpectedMsgs
			// VerifyErrorMessage_MultipleMsgs = False
			// Else
			// VerifyErrorMessage_MultipleMsgs = True
			// End If
			// Else
			// VerifyErrorMessage_MultipleMsgs = True
			// End If
			return VerifyErrorMessage_MultipleMsgs;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyErrorMessage_MultipleMsgs;
		}
	}

	public boolean CopyColumn(String strSourceDataInfo, String strTargetDataInfo) {
		boolean CopyColumn = false;
		try {
			String strStepName = "CopyColumn";
			if (strSourceDataInfo.isEmpty()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "No source data information is provided");
				// utility.AddInfo("No source data information is provided");
				CopyColumn = false;
				return false;
			}
			// Define and retrieve all the info. of the data source
			String[] arrSource = (strSourceDataInfo).split(",");
			if (arrSource.length != 3) {
				// Reporter.reportEvent(Status.Failed, strStepName,
				// "Source data sheet name, column name and row index should be provided using delimiter /, ");
				// utility.AddInfo(
				// "Source data sheet name, column name and row index should be provided using delimiter /, ");
				CopyColumn = false;
				return false;
			}
			String shtSource = arrSource[0].trim();
			String colSource = arrSource[1].trim();
			String rowSource = arrSource[2].trim();
			if (strTargetDataInfo.isEmpty()) {
				// Reporter.reportEvent(Status.Failed, strStepName, "No target data information is provided");
				// utility.AddInfo("No target data information is provided");
				CopyColumn = false;
				return false;
			}
			// Define and trieve all the info. of the data target
			String[] arrTarget = (strTargetDataInfo).split(",");
			if (arrTarget.length != 3) {
				// Reporter.reportEvent(Status.Failed, strStepName,
				// "Target data sheet name, column name and row index should be provided using delimiter /, ");
				// utility.AddInfo(
				// "Target data sheet name, column name and row index should be provided using delimiter /, ");
				CopyColumn = false;
				return false;
			}
			String shtTarget = arrTarget[0].trim();
			String colTarget = arrTarget[1].trim();
			String rowTarget = arrTarget[2].trim();
			// Retrieve the data value to be copied from the data source
			String strValue = GetValueIfValid(colSource, shtSource, Integer.parseInt(rowSource));
			// Copy the data to the target source
			Sheet sheet = PolarisBaseSteps.workbook.getSheet(shtTarget);

			Row headerrow = sheet.getRow(0);
			Map<String, Integer> map = new HashMap<String, Integer>();
			int minColIx = headerrow.getFirstCellNum();
			int maxColIx = headerrow.getLastCellNum();
			for (int colIx = minColIx; colIx < maxColIx; colIx++) {
				Cell cell = headerrow.getCell(colIx);
				map.put(cell.getStringCellValue(), cell.getColumnIndex());
			}
			sheet.getRow(Integer.parseInt(rowTarget)).getCell(map.get(colTarget)).setCellValue(strValue);
			// Check for the existence of the column inside the datasheet
			// if (Err.Number != 0) {
			// Reporter.reportEvent(Status.Warning, strStepName, "The <" + colTarget + "> column does not exist.");
			// datatableLib.getsheet(shtTarget).addparameter(colTarget, strValue);
			// Reporter.reportEvent(Status.Completed, strStepName, "The <" + colTarget + "> column is created.");
			// utility.AddInfo("The <" + colTarget + "> column is added.");
			// } else {
			// datatableLib.value(colTarget, shtTarget) = strValue;
			// }
			// Reporter.reportEvent(Status.Passed, strStepName,
			// "Copy data from datasheet <" + shtSource + "> to <" + shtTarget + "> Successful ");
			// utility.AddInfo("Copy data from datasheet <" + shtSource + "> to <" + shtTarget + "> Successful ");
			CopyColumn = true;
			return CopyColumn;
		} catch (Exception e) {
			e.printStackTrace();
			return CopyColumn;
		}
	}

	public boolean CheckExpectedValue(String strActualValue, String strExpectedValue) {
		boolean CheckExpectedValue = false;
		try {
			String strStepName = "CheckExpectedValue";
			if (strActualValue.equalsIgnoreCase(strExpectedValue)) {
				// Reporter.reportEvent(Status.Passed, strStepName,
				// "Data Verification Successful - Actual Value: " + strActualValue);
				CheckExpectedValue = true;
			} else {
				// Reporter.reportEvent(Status.Failed, strStepName, "Data Verification UnSuccessful - Actual Value: "
				// + strActualValue + ", Expected Value: " + strExpectedValue);
				CheckExpectedValue = false;
				// environmentlib.Value("Test", "bTriggered", true);
			}
			return CheckExpectedValue;
		} catch (Exception e) {
			e.printStackTrace();
			return CheckExpectedValue;
		}
	}

	public String RetrieveExpectedValue(String colName, String shtName, int row) {
		String RetrieveExpectedValue = "";
		try {
			String strValue = GetValueIfValid(colName, shtName, row).trim();
			if (strValue.toUpperCase().equals("N/C") || strValue.toUpperCase().equals("N/A")) {
				RetrieveExpectedValue = "";
			} else {
				RetrieveExpectedValue = strValue;
			}
			return RetrieveExpectedValue;
		} catch (Exception e) {
			e.printStackTrace();
			return RetrieveExpectedValue;
		}
	}

	public Map<String, Integer> getHeaderMap(String shtName) {
		Sheet sheet = PolarisBaseSteps.workbook.getSheet(shtName.trim());
		Row headerrow = sheet.getRow(0);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		int minColIx = headerrow.getFirstCellNum();
		int maxColIx = headerrow.getLastCellNum();
		for (int colIx = minColIx; colIx < maxColIx; colIx++) {
			Cell cell = headerrow.getCell(colIx);
			map.put(cell.getStringCellValue(), cell.getColumnIndex());
		}
		return map;
	}

	public void setTestData(String columnName, String shtName, int row, Object value) {
		Sheet sheet = PolarisBaseSteps.workbook.getSheet(shtName.trim());
		Map<String, Integer> header = getHeaderMap(shtName);
		int column = -1;
		if (!header.containsKey(columnName)) {
			Cell headercell = sheet.getRow(0).createCell(sheet.getRow(0).getPhysicalNumberOfCells());
			headercell.setCellValue(columnName);
			column = headercell.getColumnIndex();
		} else {
			column = header.get(columnName);
		}
		sheet.getRow(row).getCell(column).setCellValue(String.valueOf(value));
	}

	private static final String[] formats = { "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ",
			"MM/dd/y", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "HH:mm:ss a",
			"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", "MMM dd,yyyy", "dd MMM,yyyy", "MM/dd/yyyy HH:mm:ss",
			"MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS",
			"MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss", "yyyy:MM:dd HH:mm:ss", "dd-MMMM-y HH:mm:ss a",
			"dd-MMMM-y HH:mm:ss", "yyyyMMdd", "dd-MMMM-y", "HH:mm" };
	private static String[] DAYS_OF_WEEK = new String[] { "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
			"Friday", "Saturday" };

	private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

	public int asc(Object value) {
		return (int) value.toString().trim().charAt(0);

	}

	public int InStr(Object string1, Object string2) {
		return string1.toString().indexOf(string2.toString()) + 1;

	}

	public int InStr(int startpos, Object string1, Object string2) {
		return string1.toString().indexOf(string2.toString(), startpos - 1) + 1;

	}

	public int InStr(int startpos, Object string1, Object string2, int comparemode) {
		if (comparemode == 1) {
			return string1.toString().toUpperCase().indexOf(string2.toString().toUpperCase(), startpos - 1) + 1;
		} else {
			return string1.toString().indexOf(string2.toString(), startpos - 1) + 1;
		}
	}

	public int InStr(Object string1, Object string2, int comparemode) {
		if (comparemode == 1) {
			return string1.toString().toUpperCase().indexOf(string2.toString().toUpperCase()) + 1;
		} else {
			return string1.toString().indexOf(string2.toString()) + 1;
		}
	}

	public int InStrRev(Object string1, Object string2) {
		return string1.toString().toUpperCase().lastIndexOf(string2.toString().toUpperCase()) + 1;
	}

	public String exp(Object value) {
		return String.format("%6.14E", Math.exp(Double.parseDouble(value.toString())));
	}

	public int lbound(Object[] array) {
		return 0;

	}

	public int lbound(Object[][] array) {
		return 0;
	}

	public int lbound(Object[] array, int val) {
		return 0;
	}

	public int lbound(Object[][] array, int val) {
		return 0;
	}

	public int ubound(Object[] array) {
		return array.length - 1;
	}

	public int ubound(Object[][] array) {
		return array[0].length;
	}

	public int ubound(Object[] array, int val) {

		return array.length;
	}

	public int ubound(Object[][] array, int val) {
		int size = 0;
		if (val == 1)
			size = array.length;
		if (val == 2)
			size = array[1].length;
		return size;

	}

	public boolean isObject(Object obj) {
		if (obj.getClass().getName() != null)
			return true;
		else
			return false;
	}

	public String getvartype(Object value) {

		String datatype = "Object";

		try {
			Integer.parseInt(value.toString());
			datatype = "int";
			return datatype;
		} catch (NumberFormatException e) {

		}
		try {
			Float.parseFloat(value.toString());
			datatype = "float";
			return datatype;
		} catch (NumberFormatException e) {

		}
		try {

			if (value.toString().equalsIgnoreCase("true") || value.toString().equalsIgnoreCase("false")) {
				datatype = "boolean";
				return datatype;
			}
		} catch (Exception e) {

		}
		try {
			Double.parseDouble(value.toString());
			datatype = "double";
			return datatype;
		} catch (NumberFormatException e) {

		}
		try {
			Long.parseLong(value.toString());
			datatype = "long";
			return datatype;
		} catch (NumberFormatException e) {

		}
		try {
			Byte.parseByte(value.toString());
			datatype = "byte";
			return datatype;
		} catch (NumberFormatException e) {

		}
		try {
			Short.parseShort(value.toString());
			datatype = "short";
			return datatype;
		} catch (NumberFormatException e) {

		}

		try {
			if (value.toString().startsWith("\"")) {
				datatype = "String";
				return datatype;
			}

		} catch (Exception e) {

		}

		return datatype;
	}

	public int varType(Object value) {
		if (value.toString().isEmpty())
			return 0;
		else if (isNull(value))
			return 1;
		else if (getvartype(value).equals("int"))
			return 2;
		else if (getvartype(value).equals("long"))
			return 3;
		else if (getvartype(value).equals("float"))
			return 4;
		else if (getvartype(value).equals("double"))
			return 5;

		else if (getvartype(value).equals("String"))
			return 8;

		else if (getvartype(value).equals("boolean"))
			return 11;

		else
			return 10;
	}

	// public String Cstr(Object x){
	// if(!getvartype(x).equals("Object")){
	// return String.valueOf(x);
	// }
	// else{
	// return removeDateChar(x.toString());
	// }
	// }

	public boolean isNull(Object obj) {
		try {
			if (obj.toString().equalsIgnoreCase("NULL") || obj.toString().trim().length() == 0)
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			return true;
		}
	}

	public boolean CBool(Object obj) {
		int i;
		try {
			i = Integer.parseInt(obj.toString());
			if (i == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// public void Hex(Object x){
	// Math.ceil(Double.parseDouble(x.toString()));
	// }

	public String Hex(Object x) {
		if (x.toString().equalsIgnoreCase("NULL")) {
			return null;
		} else if (x.toString().isEmpty()) {
			return "";
		} else
			return Integer.toHexString((int) Math.round(Double.parseDouble(x.toString()))).toUpperCase();

	}

	public boolean isNumeric(Object obj) {
		return obj.toString().matches("-?\\d+(\\.\\d+)?"); // match a number
		// with optional '-'
		// and decimal.
	}

	public int Cbyte(double x) throws Exception {
		int byteval = 0;
		if (x <= 255 && x >= 0) {

			byteval = (int) Math.round(x);
		}

		return byteval;
	}

	public float Csng(Object x) throws Exception {
		return Float.parseFloat(x.toString());
	}

	public float Ccur(Object x) {
		try {
			String str = String.valueOf(Math.round(Double.parseDouble(x.toString()) * 10000.0) / 10000.0);
			return Float.parseFloat((str.indexOf(".") >= 0 ? str.replaceAll("\\.?0+$", "") : str));
		} catch (Exception e) {
			return 0;
		}
	}

	public int Int(double d) throws Exception {
		int intValue = (int) Math.floor(d);

		return intValue;
	}

	public String Escape(String str) {
		return URLEncoder.encode(str);
	}

	public String join(Object[] aArr, String sSep) {
		StringBuilder sbStr = new StringBuilder();
		for (int i = 0, il = aArr.length; i < il; i++) {
			if (i > 0)
				sbStr.append(sSep);
			sbStr.append(aArr[i]);
		}
		return sbStr.toString();
	}

	public String join(Object[] aArr) {
		StringBuilder sbStr = new StringBuilder();
		for (int i = 0, il = aArr.length; i < il; i++) {
			if (i > 0)
				sbStr.append(" ");
			sbStr.append(aArr[i]);
		}
		return sbStr.toString();
	}

	public Date CDate(String date) {
		date = removeDateChar(date);
		String result = null;
		Date outputDate = null;
		String dateformat = parse(date);
		Date da = null;
		if (dateformat == null) {
			return null;
		}

		if (date.contains(":")) {
			Date d = null;
			SimpleDateFormat sdf = new java.text.SimpleDateFormat(dateformat);
			try {
				d = sdf.parse(date);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(d);
			int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);
			int sec = calendar.get(Calendar.SECOND);
			result = hour + ":" + minute + ":" + sec + " " + date.substring(date.length() - 2);
			String format = parse(result);
		} else if (date.startsWith("#")) {
			date = date.substring(1, date.length() - 1);
			dateformat = parse(date);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/y");
			try {
				result = dateFormat.format(dateFormat.parse(date));
				String dateFormat1 = parse(result);

				SimpleDateFormat format1 = new SimpleDateFormat(dateFormat1);

				try {
					outputDate = format1.parse(result);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			} catch (ParseException e2) {

				e2.printStackTrace();
			}

		}

		else {
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);

			try {
				Date mon = new SimpleDateFormat("MMMM").parse(date.split(" ")[0]);
				Calendar cal = Calendar.getInstance();
				cal.setTime(mon);
				int month = (cal.get(Calendar.MONTH)) + 1;

				result = month + "/" + date.split(" ")[1].replace(",", "") + "/" + date.split(" ")[2];
				String dateFormat1 = parse(result);

				SimpleDateFormat format1 = new SimpleDateFormat(dateFormat1);

				try {
					outputDate = format1.parse(result);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}

			} catch (ParseException e) {

				e.printStackTrace();
			}
		}
		return outputDate;
	}

	public static String parse(String d) {
		String parseFunc = null;
		if (d != null) {
			for (String parse : formats) {

				SimpleDateFormat sdf = new SimpleDateFormat(parse);
				try {
					sdf.parse(d);
					parseFunc = parse;
					break;
				} catch (ParseException e) {

				}
			}
		}

		return parseFunc;
	}

	public String DateAdd(String option, int incNumber, String date) {
		String dateformat = parse(date);
		DateFormat format = new SimpleDateFormat("dd-MMMM-y", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat(dateformat);
		String resultString = null;
		Date ndate = null;
		try {
			ndate = format.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(ndate);
		if (option.trim().equals("yyyy")) {
			calendar.add(Calendar.YEAR, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			resultString = formattedDate;
		} else if (option.trim().equals("q")) {// q means Quater so incNumber*3
			calendar.add(Calendar.MONTH, incNumber * 3);
			String formattedDate = targetFormat.format(calendar.getTime());
			resultString = formattedDate;
		} else if (option.trim().equals("m")) {

			calendar.add(Calendar.MONTH, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			resultString = formattedDate;

		} else if (option.trim().equals("y")) {
			calendar.add(Calendar.DAY_OF_YEAR, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			resultString = formattedDate;

		} else if (option.trim().equals("d")) {

			calendar.add(Calendar.DAY_OF_MONTH, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());

			resultString = formattedDate;

		} else if (option.trim().equals("w")) {
			calendar.add(Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK);
			String formattedDate = targetFormat.format(calendar.getTime());

			resultString = formattedDate;

		} else if (option.trim().equals("ww")) {

			calendar.add(Calendar.WEEK_OF_YEAR, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());

			resultString = formattedDate;

		} else if (option.trim().equals("h")) {

			calendar.add(Calendar.HOUR, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			int hour = Integer.parseInt(date.split(" ")[1].split(":")[0]) + incNumber;
			String time = date.split(" ")[1];
			resultString = date.split(" ")[0] + " " + hour + ":" + time.split(":")[1] + ":" + time.split(":")[2];
		} else if (option.trim().equals("n")) {

			calendar.add(Calendar.MINUTE, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			int min = Integer.parseInt(date.split(" ")[1].split(":")[1]) + incNumber;
			String time = date.split(" ")[1];
			resultString = date.split(" ")[0] + ":" + time.split(":")[0] + ":" + min + ":" + time.split(":")[2];

		} else if (option.trim().equals("s")) {
			calendar.add(Calendar.SECOND, incNumber);
			String formattedDate = targetFormat.format(calendar.getTime());
			int sec = Integer.parseInt(date.split(" ")[1].split(":")[2]) + incNumber;
			String time = date.split(" ")[1];
			resultString = date.split(" ")[0] + ":" + time.split(":")[0] + ":" + time.split(":")[2] + ":" + sec;
		}
		return resultString;
	}

	public String DateDiff(String interval, Object dt, Object dt3) {
		String resultString = null;
		DateTime dt1 = new DateTime(dt);
		DateTime dt2 = new DateTime(dt3);

		if (interval.equals("yyyy")) {
			resultString = String.valueOf(Years.yearsBetween(dt1, dt2).getYears());

		}
		if (interval.equals("q")) {
			resultString = String.valueOf((Months.monthsBetween(dt1, dt2).getMonths() / 3));
		}
		if (interval.equals("m")) {
			resultString = String.valueOf((Months.monthsBetween(dt1, dt2).getMonths()));

		}

		if (interval.equals("y")) {
			resultString = String
					.valueOf((Days.daysBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getDays()));
		}

		if (interval.equals("d")) {
			resultString = String
					.valueOf(Days.daysBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getDays());
		}

		if (interval.equals("w")) {
			resultString = String
					.valueOf(Weeks.weeksBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getWeeks());

		}

		if (interval.equals("h")) {
			resultString = String
					.valueOf(Hours.hoursBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getHours());

		}
		if (interval.equals("n")) {
			resultString = String.valueOf(
					Minutes.minutesBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getMinutes());

		}

		if (interval.equals("s")) {
			resultString = String.valueOf(
					Seconds.secondsBetween(dt1.withTimeAtStartOfDay(), dt2.withTimeAtStartOfDay()).getSeconds());

		}
		return resultString;
	}

	public String date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public boolean isDate(String date) {

		String format = parse(date);
		if (format != null) {
			return true;
		} else
			return false;

	}

	public int day(String day) {
		String dateFormat = parse(day);
		if (dateFormat == null) {
			return 0;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sdf.parse(day);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	public int DatePart(String interval, Date date) throws Exception {
		String resultString = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		if (interval.equals("yyyy")) {
			resultString = String.valueOf(cal.get(Calendar.YEAR));
		} else if (interval.equals("q")) {
			resultString = String.valueOf((cal.get(Calendar.MONTH) + 1) / 3);

		} else if (interval.equals("m")) {
			resultString = String.valueOf(cal.get(Calendar.MONTH) + 1);

		} else if (interval.equals("y")) {
			resultString = String.valueOf(cal.get(Calendar.DAY_OF_YEAR));

		} else if (interval.equals("d")) {
			resultString = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));

		} else if (interval.equals("w")) {
			// need more details
		} else if (interval.equals("ww")) {
			resultString = String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

		} else if (interval.equals("h") || interval.equals("H")) {
			resultString = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));

		} else if (interval.equals("n")) {
			resultString = String.valueOf(cal.get(Calendar.MINUTE));

		} else if (interval.equals("s")) {
			resultString = String.valueOf(cal.get(Calendar.SECOND));

		}
		return Integer.parseInt(resultString);
	}

	public String dateSerial(int year, int month, int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String formatted = format.format(calendar.getTime());
		return formatted;
	}

	public String dateValue(String stringDate) {

		String result;
		boolean isyear = false;
		if (stringDate.length() == 6) {
			isyear = true;
			stringDate = stringDate + "-1111";
		}
		String dateFormat = parse(stringDate);

		if (dateFormat == null) {
			return null;
		}
		SimpleDateFormat format1 = new SimpleDateFormat(dateFormat);
		Date outputDate = null;
		try {
			outputDate = format1.parse(stringDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (isyear) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(outputDate);
			Calendar now = Calendar.getInstance(); // Gets the current date and
			// time
			int year = now.get(Calendar.YEAR); // The current year as an int
			calendar.set(Calendar.YEAR, year);
			SimpleDateFormat format2 = new SimpleDateFormat("M/dd/yyyy");
			result = format2.format(calendar.getTime());
			return result;
		}
		SimpleDateFormat format2 = new SimpleDateFormat("M/dd/yyyy");
		result = format2.format(outputDate);
		return result;
	}

	public String formatDateTime(Date d) {
		return formatDateTime(d, 0);
	}

	public String formatDateTime(Date d, int o) {

		// String format=AddDate.parse(d);
		String result = null;
		String targetformat = "MM/dd/yyyy hh:mm:ss a";
		if (o == 0) {

			DateFormat format = new SimpleDateFormat(targetformat, Locale.ENGLISH);
			String text = format.format(d);

			result = text;
		} else if (o == 1) {
			// Tuesday, February 16, 2010
			DateFormat format = new SimpleDateFormat("EEEE MMM dd,yyyy", Locale.ENGLISH);
			String text = format.format(d);

			result = text;

		} else if (o == 2) {
			// 2/16/2010
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
			String text = format.format(d);

			result = text;

		} else if (o == 3) {
			// 1:45:00 PM
			DateFormat format = new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);
			String text = format.format(d);

			result = text;

		} else if (o == 4) {
			// 13:45
			DateFormat format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
			String text = format.format(d);

			result = text;

		}
		return result;
	}

	public int hour(String time) {

		String hour = "";
		if ((time.startsWith(" "))) {

		} else {
			if ((time.split(" ").length) > 1)
				hour = time.split(" ")[1].split(":")[0];
			else
				hour = time.split(" ")[0].split(":")[0];
		}

		return Integer.parseInt(hour);

	}

	public String minute(String time) {

		String minute = "";
		if ((time.startsWith(" "))) {

		} else {
			if ((time.split(" ").length) > 1)
				minute = time.split(" ")[1].split(":")[1];
			else
				minute = time.split(" ")[0].split(":")[1];
		}

		return minute;

	}

	public int second(String time) {

		String second = "";
		if ((second.startsWith(" "))) {

		} else {
			if ((time.split(" ").length) > 1)
				second = time.split(" ")[1].split(":")[2];
			else
				second = time.split(" ")[0].split(":")[2];
		}

		return Integer.parseInt(second);

	}

	public Date now() {
		return new Date();
	}

	public static String monthName(int monthnumber) {
		return monthName(monthnumber, false);
	}

	public static String monthName(int monthnumber, boolean var) {
		String result;
		if (var) {
			String monthName = DateTime.now().withMonthOfYear(monthnumber).toString("MMM");

			result = monthName;
		} else {
			String monthName = DateTime.now().withMonthOfYear(monthnumber).toString("MMMM");

			result = monthName;
		}
		return result;
	}

	public int month(String sDate) {
		Date ndate = StringTODate(sDate);
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String month = sdf.format(ndate);

		return Integer.parseInt(month);
	}

	public String time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		return sdf.format(cal.getTime());

	}

	public double timer() {

		DateTime now = new DateTime();
		DateTime midnight = now.withTimeAtStartOfDay();
		Duration duration = new Duration(midnight, now);
		int seconds = duration.toStandardSeconds().getSeconds();

		double result = (seconds / 1000.0);
		return result;

	}

	public String timeSerial(int hours, int minutes, int seconds) {

		String _24HourTime = hours + ":" + minutes + ":" + seconds;
		SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm:ss a");
		Date _24HourDt = null;
		try {
			_24HourDt = _24HourSDF.parse(_24HourTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		return _12HourSDF.format(_24HourDt);
	}

	public String timeValue(String time) {

		if (time.startsWith("#"))
			time = time.substring(1, time.length() - 1);
		String dateFormat = parse(time);
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date ndate = null;
		try {
			ndate = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		DateFormat formddat = new SimpleDateFormat("HH:mm:ss a", Locale.ENGLISH);
		String text = formddat.format(ndate);

		return text;

	}

	public int weekDay(String dateString, int startDay) {
		Date date = null;

		try {
			SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = desiredFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (startDay == 0) {
			return c.get(Calendar.DAY_OF_WEEK);
		} else {
			return (((c.get(Calendar.DAY_OF_WEEK) - startDay + 7) % 7) + 1);
		}
	}

	public String weekDayName(int weekday, boolean weekdayAbb) {
		// weekday[,abbreviate[,firstdayofweek]];
		String result;
		if (weekdayAbb) {
			String weekdayName = DAYS_OF_WEEK[weekday].substring(0, 3);
			result = weekdayName;
		} else {
			String weekdayName = DAYS_OF_WEEK[weekday];

			result = weekdayName;

		}
		return result;
	}

	public String weekDayName(int weekday, boolean weekdayAbb, int firstdayofweek) {
		// weekday[,abbreviate[,firstdayofweek]];
		String result;
		if (weekdayAbb) {
			String weekdayName = DAYS_OF_WEEK[(weekday + firstdayofweek) - 1].substring(0, 3);

			result = weekdayName;
		} else {
			String weekdayName = DAYS_OF_WEEK[(weekday + firstdayofweek) - 1];

			result = weekdayName;

		}
		return result;
	}

	public String weekDayName(int weekday) {
		return weekDayName(weekday, false);
	}

	public int year(String date) {

		Date ndate = StringTODate(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(ndate);

		return Integer.parseInt(year);
	}

	public int formatPercentage(String value, int precession) {
		float i = 0;
		float j = 0;
		float result = 0;
		if (value.contains("/")) {
			i = Float.parseFloat(value.split("/")[0]);
			j = Float.parseFloat(value.split("/")[1]);

			result = (i / j) * 100;

		}
		if (precession == 0)
			return Integer.parseInt(String.valueOf(result).substring(0, 1) + "%");
		else
			return Integer.parseInt(String.valueOf(result).substring(0, 2 + precession) + "%");
	}

	public int formatPercentage(String value) {
		float i = 0;
		float j = 0;
		float result = 0;
		if (value.contains("/")) {
			i = Float.parseFloat(value.split("/")[0]);
			j = Float.parseFloat(value.split("/")[1]);

			result = (i / j) * 100;

		}
		return Integer.parseInt(String.valueOf(result).substring(0, 4) + "%");

	}

	public String formatCurrency(double currency) {

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);
		return defaultFormat.format(currency);

	}

	public String formatCurrency(double currency, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		String val = defaultFormat.format(currency).replace("(", "").replace(")", "");

		if (precession == 0)
			return val.split("\\.")[0];
		else
			return val.split("\\.")[0] + "." + sb.toString().replace(", ", "").replace("[", "").replace("]", "");

	}

	public String formatCurrency(double currency, int arg1, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		if (precession == 0)
			return "." + defaultFormat.format(currency).split("\\.")[1];
		else
			return defaultFormat.format(currency);

	}

	public String formatCurrency(double currency, int arg1, int arg2, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);
		String val = null;
		if (String.valueOf(currency).contains("-")) {
			val = "-" + defaultFormat.format(currency).replace("(", "").replace(")", "");
		} else
			val = defaultFormat.format(currency).replace("(", "").replace(")", "");
		if (precession == 0)
			return val;
		else
			return defaultFormat.format(currency);
	}

	public String formatCurrency(double currency, int arg1, int arg2, int arg3, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		if (precession == 0)
			return defaultFormat.format(currency).replace(",", "");
		else
			return defaultFormat.format(currency);

	}

	public String formatNumber(double currency) {

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		return defaultFormat.format(currency).replace("$", "");

	}

	public String formatNumber(double currency, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		String val = defaultFormat.format(currency).replace("(", "").replace(")", "");

		if (precession == 0)
			return val.split("\\.")[0].replace("$", "");
		else
			return val.split("\\.")[0] + "."
					+ sb.toString().replace(", ", "").replace("[", "").replace("]", "").replace("$", "");

	}

	public String formatNumber(double currency, int arg1, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		if (precession == 0)
			return "." + defaultFormat.format(currency).split("\\.")[1].replace("$", "");
		else
			return defaultFormat.format(currency).replace("$", "");

	}

	public String formatNumber(double currency, int arg1, int arg2, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);
		String val = null;
		if (String.valueOf(currency).contains("-")) {
			val = "-" + defaultFormat.format(currency).replace("(", "").replace(")", "");
		} else
			val = defaultFormat.format(currency).replace("(", "").replace(")", "");
		if (precession == 0)
			return val.replace("$", "");
		else
			return defaultFormat.format(currency).replace("$", "");
	}

	public String formatNumber(double currency, int arg1, int arg2, int arg3, int precession) {
		ArrayList<String> sb = new ArrayList<>();
		for (int i = 0; i < precession; i++) {
			sb.add("0");

		}

		Locale us = new Locale("EN", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(us);

		if (precession == 0)
			return defaultFormat.format(currency).replace(",", "").replace("$", "");
		else
			return defaultFormat.format(currency).replace("$", "");

	}

	public Date StringTODate(String sDate) {
		Date date = null;
		FOUND: {
			String dateFormat = parse(sDate);

			if (dateFormat == null) {

				break FOUND;
			}
			String targetformat;
			if (dateFormat.contains("HH:mm")) {
				targetformat = "MM/dd/yyyy " + "HH:mm:ss a";
			} else if (dateFormat.contains("MM/dd/y"))
				targetformat = "MM/dd/yyyy " + "HH:mm:ss a";
			else
				targetformat = "MM/dd/yyyy";

			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

			try {
				date = sdf.parse(sDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}

		}
		return date;
	}

	// String functions

	public String left(String inputString, int index) {
		return inputString.substring(0, index);
	}

	public String right(String inputString, int index) {
		return inputString.substring(inputString.length() - index, inputString.length());
	}

	public String lTrim(String input) {
		final Pattern LTRIM = Pattern.compile("^\\s+");
		return LTRIM.matcher(input).replaceAll("");
	}

	public String rTrim(String input) {
		final Pattern RTRIM = Pattern.compile("\\s+$");
		return RTRIM.matcher(input).replaceAll("");
	}

	public String mid(String input, int index) {
		return input.substring(index - 1);
	}

	public String mid(String input, int stindex, int endindex) {
		return input.substring((stindex - 1), endindex);
	}

	public String replace(String input, CharSequence target, CharSequence replacement, int stindex) {
		return input.substring(stindex - 1).replace(target, replacement);
	}

	public String replace(String input, CharSequence target, CharSequence replacement) {
		return input.replace(target, replacement);
	}

	public String replace(String input, CharSequence target, CharSequence replacement, int start, int count) {

		String result = "-1";
		for (int i = 0; i < count; i++) {
			result = input.substring(start - 1).replace(target, replacement);
		}
		return result;
	}

	public int strComp(String str1, String str2) {

		int res = str1.compareTo(str2);

		if (res == 0)
			return res;
		else if (res > 0)
			return 1;
		else
			return -1;

	}

	public int strComp(String str1, String str2, int index) {

		int res = str1.compareTo(str2);

		if (res == 0)
			return res;
		else if (res > 0) {
			if (index == 1)
				return 0;
			else
				return 1;
		} else {
			if (index == 1)
				return 0;
			else
				return -1;
		}
	}

	public String string(int no, String con) {
		if (con.length() > 1)
			con = con.substring(0, 1);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < no; i++) {
			builder.append(con);
		}
		String res = builder.toString();
		return res;
	}

	public String string(int no, int asciiVal) {
		String con = Character.toString((char) asciiVal);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < no; i++) {
			builder.append(con);
		}
		String res = builder.toString();
		return res;
	}

	// other functions

	public BufferedImage loadPicture(String imageUrl) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imageUrl));

		} catch (IOException e) {
		}
		return img;
	}

	public String getengine() {
		return "Java";
	}

	// Utility

	public String removeDateChar(String value) {
		if (value.startsWith("#"))
			value = value.substring(1).trim();
		if (value.endsWith("#"))
			value = value.substring(0, value.length() - 1);
		return value;
	}

	public String Generate_Unique_RegNumber() {
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(1000000);
		String regNumber = "AUTO" + randomInt;
		return regNumber;
	}

	private String getAlphaNumericString(int n) {
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		String randomString = new String(array, Charset.forName("UTF-8"));
		StringBuffer r = new StringBuffer();
		String AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");
		for (int k = 0; k < AlphaNumericString.length(); k++) {
			if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0) || Character.isDigit(AlphaNumericString.charAt(k)) && (n > 0)) {
				r.append(AlphaNumericString.charAt(k));
				n--;
			}
		}
		return r.toString();
	}

	public String Generate_Registration_Date() {
		String Generate_Registration_Date = null;
		try {
			String strTimeStamp = null;
			String[] arrTimeStamp = null;
			strTimeStamp = mainPage.TimeText_WebElement.getText();
			Date date1 = new SimpleDateFormat("yyyy/MM/dd hh:mm").parse(strTimeStamp);
			Date dateNew = addDays(date1, -1);

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			String strNewDate = dateFormat.format(dateNew);

			arrTimeStamp = (strNewDate.trim()).split(" ");
			Generate_Registration_Date = arrTimeStamp[0];

			return Generate_Registration_Date;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	public String Generate_Registration_Time() {
		String Generate_Registration_Time = null;
		try {
			String strTimeStamp = null;
			String[] arrTimeStamp = null;
			strTimeStamp = mainPage.TimeText_WebElement.getText();
			arrTimeStamp = (strTimeStamp.trim()).split(" ");
			Generate_Registration_Time = arrTimeStamp[1];
			return Generate_Registration_Time;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String windowHandles(WebDriver driver) {
		String strhwndval = null;
		Set<String> handleVal_Coll = driver.getWindowHandles();
		Iterator<String> IT_hwndColl = handleVal_Coll.iterator();
		while (IT_hwndColl.hasNext() == true) {
			strhwndval = IT_hwndColl.next();
			driver.switchTo().window(strhwndval);
		}
		return strhwndval;
	}

	public void switchToNewWindow() throws Throwable {
		mainWindowHandle = mainPage.getDriver().getWindowHandle();
		windowHandles(mainPage.getDriver());
		mainPage.getDriver().manage().window().maximize();
	}

	public void switchToLatestWindow(String mainWindowHandle) {
		Set<String> multipleWindows = mainPage.getDriver().getWindowHandles();
		for (String currentwindow : multipleWindows) {
			if (!(mainWindowHandle.equals(currentwindow))) {
				mainPage.getDriver().switchTo().window(currentwindow);
				mainPage.getDriver().manage().window().maximize();
			}
		}

	}

	public void closeCurrentAndSwitchToMainWindow() throws Throwable {
		mainPage.getDriver().close();
		mainPage.getDriver().switchTo().window(mainWindowHandle);
	}

	public void closeCurrentAndSwitchToMainWindow(String windowName) throws Throwable {
		mainPage.getDriver().close();
		mainPage.getDriver().switchTo().window(windowName);
	}

	public void closeCurrentWindow() throws Throwable {
		mainPage.getDriver().close();
	}

	public void switchToDefaultWindow(String windowName) throws Throwable {
		mainPage.getDriver().switchTo().window(windowName);
	}

	public String getCurrentWindow() throws Throwable {
		String windowName = mainPage.getDriver().getWindowHandle();
		return windowName;
	}

	public String Generate_Unique_Randon_RegNumber() {
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(1000000);
		String regNumber = "WE" + randomInt;
		return regNumber;
	}
	
	public static String regNumber = null;

	public String retrieveRegNumber() {
			regNumber = mainPage.getDriver().findElement(By.xpath("//table[@id='Registration Number']//tr[2]//td[1]")).getText().trim();
			System.out.println("Retrieved RegNumber: " + regNumber);
			WaitUtil.waitMSeconds(500);
			return regNumber;
		}
}
