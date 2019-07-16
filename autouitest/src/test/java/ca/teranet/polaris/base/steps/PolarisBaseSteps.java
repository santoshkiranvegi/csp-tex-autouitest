package ca.teranet.polaris.base.steps;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ca.teranet.pages.polaris.ApplicationErrorPage;
import ca.teranet.pages.polaris.MainPage;
import ca.teranet.steps.base.BaseSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class PolarisBaseSteps extends BaseSteps {
	public static Workbook workbook;
	public ApplicationErrorPage applicationErrorPage;
	public MainPage mainPage;
	public EnvironmentVariables environmentlib = SystemEnvironmentVariables.createEnvironmentVariables();
	public static FileOutputStream outputStream;
	private final int FULLSCREEN_WIDTH = 1920;
	private final int FULLSCREEN_HEIGHT = 1080;

	public boolean VerifyPage(String strFuncID) {
		boolean VerifyPage = false;
		try {
			if (!mainPage.FuncID_WebElement.isPresent()) {
				// Reporter.reportEvent(Status.Failed, "VerifyPage <" + strFuncID + "> page- UnSuccessful", " No Function name is found on the page");
				// utility.AddInfo("VerifyPage <" + strFuncID + "> -UnSuccessful. No Function name is found on the page");
				return VerifyPage;
			}
			String strFuncName = mainPage.FuncID_WebElement.getText().trim();
			if (strFuncName.equals(strFuncID)) {
				VerifyPage = true;
			} else {
				// Reporter.reportEvent(Status.Failed, "VerifyPage <" + strFuncID + "> - UnSuccessful", " The actual page is <" + strFuncName + ">");
				// utility.AddInfo("VerifyPage <" + strFuncID + "> - UnSuccessful. The actual page is <" + strFuncName + ">");
				VerifyPage = false;
			}
			return VerifyPage;
		} catch (Exception e) {
			e.printStackTrace();
			return VerifyPage;
		}
	}

	public boolean SubmitApplicationErrorReport() {
		boolean SubmitApplicationErrorReport = false;
		try {
			String strStepName = "SubmitApplicationErrorReport";

			// Declare and define error description
			String strDescription = "This message is sent automatically. Exception occurred while executing automation scripts. Please investigate it. Thanks.";
			// Initialization
			// environmentlib.Value("Test", "bTriggered", false);
			// Fill description
			applicationErrorPage.Description_WebEdit.sendKeys(strDescription);
			// Click Submit Error Report button
			applicationErrorPage.Submit_WebButton.click();
			// if (environmentlib.Value("Test", "bTriggered") == true) {
			// Reporter.reportEvent(Status.Failed, "Application Error!", "Attempt to Submit Error Report - UnSuccessful!");
			// utility.AddInfo("Application Error! - Attempt to Submit Error Report - UnSuccessful!");
			// return 0;
			// }
			// Reporter.reportEvent(Status.Completed, "Application Error!", "Error Report <" + strDescription + "> has been submitted");
			// utility.AddInfo("Error Report <" + strDescription + "> has been submitted");
			SubmitApplicationErrorReport = true;
			return SubmitApplicationErrorReport;
		} catch (Exception e) {
			e.printStackTrace();
			return SubmitApplicationErrorReport;
		}
	}

	public void VerifyApplicationError() {
		try {
			if (mainPage.ApplicationError_WebElement.isCurrentlyVisible()) {
				// Declare and set description
				String strDescription = "Exception occures while automation scripts are running";
				applicationErrorPage.Description_WebEdit.sendKeys(strDescription);
				// Click Submit button
				applicationErrorPage.Submit_WebButton.click();
				// Reporter.reportEvent(Status.Failed,"Application Error!","Test execution is stopped");
				// utility.AddInfo("Application Error! - Test execution is stopped");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectWebRadioGroupByIndex(By by, int index) {
		List<WebElement> radiobuttons = mainPage.getDriver().findElements(by);
		radiobuttons.get(index).click();
	}

	public void setCheckBoxValue(WebElement element, String value) {
		if (element != null && value != null) {
			if (value.trim().equalsIgnoreCase("ON")) {
				if (!element.isSelected()) {
					element.click();
				} else if (value.trim().isEmpty() || value.trim().equalsIgnoreCase("OFF")) {
					if (element.isSelected()) {
						element.click();
					}
				}
			}
		}
	}

	public String getCellData(WebElement table, int row, int column) {
		try {
			if (table != null && row >= 0 && column >= 0) {
				WebElement tableBody = table.findElement(By.tagName("tbody"));
				WebElement tablerow = tableBody.findElements(By.tagName("tr")).get(row - 1);
				List<WebElement> td = tablerow.findElements(By.tagName("td"));
				String text = td.get(column - 1).getText();
				if (text != null)
					return text;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public int getRowWithCellText(WebElement table, String text, int column, int row) {
		try {
			if (table != null && row >= 0 && column >= 0) {
				WebElement tableBody = table.findElement(By.tagName("tbody"));
				List<WebElement> tablerows = tableBody.findElements(By.tagName("tr"));
				for (int i = 0; i < tablerows.size(); i++) {
					WebElement td = tablerows.get(i).findElements(By.tagName("td")).get(column - 1);
					if (td.getText() != null && td.getText().contains(text)) {
						return (i + 1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	public int getRowCount(WebElement table) {
		try {
			if (table != null) {
				WebElement tableBody = table.findElement(By.tagName("tbody"));
				return tableBody.findElements(By.tagName("tr")).size();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	public int getColumnCount(WebElement table, int row) {
		try {
			if (table != null) {
				WebElement tableBody = table.findElement(By.tagName("tbody"));
				WebElement tablerow = tableBody.findElements(By.tagName("tr")).get(row - 1);
				return tablerow.findElements(By.tagName("td")).size();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}

	public boolean LocateAValueInWebTable(WebElement oWebTable, String strValue) {
		boolean LocateAValueInWebTable = false;
		try {
			String strStepName = "LocateAValueInWebTable";
			LocateAValueInWebTable = false;
			int intRowCount = getRowCount(oWebTable);
			int intColCount = getColumnCount(oWebTable, 1);
			String strCellData = null;
			int iRowIndex = 0;
			int iColIndex = 0;
			for (int iRowLoop = 1; iRowLoop <= intRowCount; iRowLoop++) {
				for (int iColLoop = 1; iColLoop <= intColCount; iColLoop++) {
					strCellData = getCellData(oWebTable, iRowLoop, iColLoop);
					if (strCellData.trim().equalsIgnoreCase(strValue)) {
						iRowIndex = iRowLoop;
						iColIndex = iColLoop;
						// Reporter.reportEvent(Status.Completed, strStepName,
						// "<" + strValue + "> exists in row <" + iRowIndex + "> and column <" + iColIndex + ">");
						// utility.AddInfo(
						// "<" + strValue + "> exists in row <" + iRowIndex + "> and column <" + iColIndex + ">");
						LocateAValueInWebTable = true;
						break;
					}
				}
			}
			return LocateAValueInWebTable;
		} catch (Exception e) {
			e.printStackTrace();
			return LocateAValueInWebTable;
		}
	}

	public String getPDFContent(WebElement pdfsrc) {
		String content = "";
		try {
			String currenturl = mainPage.getDriver().getCurrentUrl();
			Set<Cookie> cookies = mainPage.getDriver().manage().getCookies();
			String src = pdfsrc.getAttribute("src");
			if (currenturl.endsWith("elrs") || currenturl.endsWith("elrs/")) {
				currenturl = currenturl.substring(0, currenturl.indexOf("/elrs"));
			}
			URL pdfurl = new URL(currenturl + src);
			URLConnection conn = pdfurl.openConnection();
			StringBuffer cookiebuffer = new StringBuffer("");
			for (Cookie cookie : cookies) {
				cookiebuffer.append(cookie.getName() + "=" + cookie.getValue() + ";");
			}
			conn.setRequestProperty("Cookie", cookiebuffer.toString());
			conn.connect();
			BufferedInputStream file = new BufferedInputStream(conn.getInputStream());
			PDDocument document = null;
			try {
				document = PDDocument.load(file);
				content = new PDFTextStripper().getText(document);
			} finally {
				if (document != null) {
					document.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	public void setCheckBoxValueWithJS(WebElement element, String value) {
		if (element != null && value != null) {
			if (value.trim().equalsIgnoreCase("ON")) {
				if (!element.isSelected()) {
					JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
					js.executeScript("arguments[0].click();", element);
				} else if (value.trim().isEmpty() || value.trim().equalsIgnoreCase("OFF")) {
					if (element.isSelected()) {
						JavascriptExecutor js = (JavascriptExecutor) mainPage.getDriver();
						js.executeScript("arguments[0].click();", element);
					}
				}
			}
		}
	}

}
