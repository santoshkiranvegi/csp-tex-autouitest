package ca.teranet.polaris.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jbehave.core.annotations.Given;

import ca.teranet.polaris.base.steps.PolarisBaseSteps;

public class LoadTestDataSteps extends PolarisBaseSteps {
	InputStream inputStream;
	String excelfilename;

	@Given("LoadTestData $ExcelFileName")
	public void LoadTestDataToWorkbook(String ExcelFileName) {
		try {
			excelfilename = ExcelFileName;
			String filepath = System.getProperty("user.dir") + "\\testdata\\" + ExcelFileName;
			inputStream = new FileInputStream(new File(filepath));
			PolarisBaseSteps.workbook = WorkbookFactory.create(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("CloseTestData")
	public void CloseTestData() {
		try {
			inputStream.close();
			String filepath = System.getProperty("user.dir") + "\\testdata\\" + excelfilename;
			FileOutputStream outputStream = new FileOutputStream(filepath);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
