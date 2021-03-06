package ca.teranet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenUtil {

	static private Pattern rxquote = Pattern.compile("\"");

	// this one only work for positive data sheet --- not be used now
	@SuppressWarnings("resource")
	public static void ConvertExcelSheetToCSV(String table_folder, String csv_folder, String fileName) throws Exception, FileNotFoundException {

		String excelFile = table_folder + fileName + ".xlsx";
		String csvFile = csv_folder + fileName + ".csv";
		FileInputStream file = new FileInputStream(new File(excelFile));
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("TestCase");
		FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
		DataFormatter formatter = new DataFormatter();
		File csv_file = new File(csvFile);
		if (!csv_file.exists())
			csv_file.createNewFile();
		PrintStream out;
		out = new PrintStream(new FileOutputStream(csvFile), true, "UTF-8");
		byte[] bom = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
		out.write(bom);
		for (int r = 0, rn = sheet.getLastRowNum(); r <= rn; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			boolean firstCell = true;
			for (int c = 0, cn = row.getLastCellNum(); c < cn; c++) {
				Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if (!firstCell)
					out.print('|');
				if (cell != null) {
					if (fe != null)
						cell = fe.evaluateInCell(cell);
					String value = formatter.formatCellValue(cell);
					if (cell.getCellTypeEnum() == CellType.FORMULA) {
						value = "=" + value;
					}
					String strOut = encodeValue(value);
					out.print(strOut);
				}
				firstCell = false;
			}
			out.print("\n");
		}
	}

	// work for both positive and negative data sheets
	public static void ConvertExcelSheetToCSVs(String table_folder, String csv_folder, String fileName) throws Exception, FileNotFoundException {

		String excelFile = table_folder + fileName + ".xlsx";
		String csvFile = "";
		FileInputStream file = new FileInputStream(new File(excelFile));
		Workbook workbook = WorkbookFactory.create(file);
		Iterator<Sheet> sheets = workbook.sheetIterator();
		FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
		DataFormatter formatter = new DataFormatter();
		while (sheets.hasNext()) {
			csvFile = "";
			Sheet sheet = sheets.next();
			String sheet_name = sheet.getSheetName();
			if (sheet_name.equals("TestCase")) {
				csvFile = csv_folder + fileName + ".csv";
			} else if (sheet_name.contains("TestCase")) {
				String sheet_No = sheet_name.replace("TestCase", "");
				csvFile = csv_folder + fileName + "_" + sheet_No + ".csv";
			}
			if (csvFile.equals(""))
				continue;
			File csv_file = new File(csvFile);
			if (!csv_file.exists())
				csv_file.createNewFile();
			PrintStream out;
			out = new PrintStream(new FileOutputStream(csvFile), true, "UTF-8");
			byte[] bom = { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF };
			out.write(bom);
			for (int r = 0, rn = sheet.getLastRowNum(); r <= rn; r++) {
				Row row = sheet.getRow(r);
				if (row == null) {
					continue;
				}
				if (r > 0 && !row.getCell(1).getStringCellValue().toUpperCase().equals("Y")) {
					continue;
				}
				boolean firstCell = true;
				for (int c = 0, cn = row.getLastCellNum(); c < cn; c++) {
					Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					if (!firstCell)
						out.print('|');
					if (cell != null) {
						if (fe != null)
							cell = fe.evaluateInCell(cell);
						String value = formatter.formatCellValue(cell);
						if (cell.getCellTypeEnum() == CellType.FORMULA) {
							value = "=" + value;
						}
						// String strOut = encodeValue(value);
						out.print(value);
					}
					firstCell = false;
				}
				out.print("\n");
			}
			out.close();
		}
	}

	public static String encodeValue(String value) {
		boolean needQuotes = false;
		if (value.indexOf('|') != -1 || value.indexOf('"') != -1 || value.indexOf('\n') != -1 || value.indexOf('\r') != -1)
			needQuotes = true;
		Matcher m = rxquote.matcher(value);
		if (m.find())
			needQuotes = true;
		value = m.replaceAll("\"\"");
		if (needQuotes)
			return "\"" + value + "\"";
		else
			return value;
	}

	// return example table format string
	public static String getRowDataFromSheet(String table_folder, String fileName, String sheetName, String row_No) throws Exception, FileNotFoundException {
		String retStr = "|";
		String excelFile = table_folder + fileName + ".xlsx";
		FileInputStream file = new FileInputStream(new File(excelFile));
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
		DataFormatter formatter = new DataFormatter();

		Row row = sheet.getRow(Integer.parseInt(row_No));
		if (row == null)
			return retStr;

		boolean firstCell = true;
		for (int c = 0, cn = row.getLastCellNum(); c < cn; c++) {
			Cell cell = row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (!firstCell)
				retStr = retStr + "|";
			if (cell != null) {
				if (fe != null)
					cell = fe.evaluateInCell(cell);
				String value = formatter.formatCellValue(cell);
				if (cell.getCellTypeEnum() == CellType.FORMULA) {
					value = "=" + value;
				}
				// String strOut = encodeValue(value);
				retStr = retStr + value;
			}
			firstCell = false;
		}
		retStr = retStr + "|\n";

		return retStr;
	}

	public static String getGridDataFromSheet(String table_folder, String fileName, String sheetName, String row_No, String col_No) throws Exception, FileNotFoundException {
		String retStr = "";
		String excelFile = table_folder + fileName + ".xlsx";
		FileInputStream file = new FileInputStream(new File(excelFile));
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
		DataFormatter formatter = new DataFormatter();

		Row row = sheet.getRow(Integer.parseInt(row_No));
		if (row == null)
			return retStr;

		Cell cell = row.getCell(Integer.parseInt(col_No), Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell != null) {
			if (fe != null)
				cell = fe.evaluateInCell(cell);
			String value = formatter.formatCellValue(cell);
			if (value.contains("$"))
				value = value.replace("$", "");
			if (cell.getCellTypeEnum() == CellType.FORMULA) {
				value = "=" + value;
			}
			// retStr = encodeValue(value);
			retStr = value;
		}
		return retStr;
	}
}
