package ca.teranet.steps.base;

import static ca.teranet.util.WaitUtil.waitUntil;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.script.ScriptException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Actions;

import ca.teranet.pages.base.BasePage;
import ca.teranet.util.DataDrivenUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;

public class BaseSteps {

	private static boolean isFrenchSession = false;

	private static final String PROPERTIES_NGTV_LOCALE = "properties/ngtv";

	protected BasePage basePage;

	private final String ACTION_ARROW_UP = Keys.chord(Keys.ARROW_UP);

	private final String ACTION_ARROW_DOWN = Keys.chord(Keys.ARROW_DOWN);

	private final String ACTION_ARROW_RIGHT = Keys.chord(Keys.ARROW_RIGHT);

	private final String ACTION_ARROW_LEFT = Keys.chord(Keys.ARROW_LEFT);

	private final String ACTION_ENTER = Keys.chord(Keys.ENTER);

	private final String ACTION_TAB = Keys.chord(Keys.TAB);
	public static int customercarereport = 0;
	public static int gwhreport = 0;

	// private final String ACTION_SHIFT = Keys.chord(Keys.LEFT_SHIFT);

	private final String ACTION_SPACE = Keys.chord(Keys.SPACE);

	private final String ACTION_DELETE = Keys.chord(Keys.DELETE);

	private final String ACTION_ESCAPE = Keys.chord(Keys.ESCAPE);

	private final int FULLSCREEN_WIDTH = 1920;

	public static int report = 0;

	private final int FULLSCREEN_HEIGHT = 1080;

	public final static String TABLE_PATH = "\\selenium\\Data\\";

	public final static String CSV_PATH = "\\selenium\\projects\\autouitest\\src\\test\\resources\\stories\\";

	public static String myTimeStamp = ":" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public static final String JAVASCRIPT_WAVE_RUNNER = "var waveExtensionPath = " + "'chrome-extension://jbbplnpkjmmeebjpijfedlgcdilocofh/';var head = document.getElementsByTagName('head')[0];var "
			+ "waveStyle = document.createElement('link');var waveScript = document.createElement('script');waveStyle" + "" + ""
			+ ".setAttribute('type', 'text/css');waveStyle.setAttribute('rel', 'stylesheet');waveStyle.setAttribute('href', "
			+ "waveExtensionPath + 'styles/report-ext.css');waveScript.setAttribute('type', 'text/javascript');waveScript" + ""
			+ ".setAttribute('src', waveExtensionPath + 'wave.min.js');head.appendChild(waveStyle);head.appendChild(waveScript);";

	public void waitLoadingDisappeared() {
		waitUntil(() -> !basePage.getSpinner().isCurrentlyVisible());
		waitUntil(() -> !basePage.getSystemWaitGlass().isCurrentlyVisible());
	}

	public void userEnablesWAVEPlugin() throws InterruptedException, ScriptException {
		waitLoadingDisappeared();
		if (getBrowserType().equals("firefox")) {
			userPressesKey(Keys.chord(Keys.ALT));
			userPressesKey("t");
			userPressesKeyDown();
			userPressesKeyDown();
			userPressesKeyDown();
			userPressesKeyDown();
			userPressesKeyRight();
			userPressesKeyEnter();
		}
		if (getBrowserType().equals("chrome")) {// run wave extension by
			// javascript
			((JavascriptExecutor) getDriver()).executeScript(JAVASCRIPT_WAVE_RUNNER);
			Thread.sleep(5000);
			basePage.getDriver().switchTo().frame("wave_sidebar_container");
			assertTrue("wave is not active", basePage.findBy("//div[@id='sidebar_container']").isPresent());// check
			// wave
			// plugin
			basePage.getDriver().switchTo().defaultContent();
		}
	}

	public void userPressesKey(final String key) {
		basePage.getActiveElement().sendKeys(key);
	}

	public void userPressesKeyUp() {
		userPressesKey(ACTION_ARROW_UP);
	}

	public void userPressesKeyDown() {
		userPressesKey(ACTION_ARROW_DOWN);
	}

	public void userPressesKeyRight() {
		userPressesKey(ACTION_ARROW_RIGHT);
	}

	public void userPressesKeyLeft() {
		userPressesKey(ACTION_ARROW_LEFT);
	}

	public void userPressesKeyTab() {
		userPressesKey(ACTION_TAB);
	}

	public void userPressesKeyTabNTimes(int n) {
		for (int i = 0; i < n; i++) {
			userPressesKeyTab();
		}
	}

	public void userPressesKeysShiftTab() {
		new Actions(getDriver()).keyDown(Keys.SHIFT).sendKeys(ACTION_TAB).build().perform();
	}

	// press key ALT, press arrow up, release key ALT. Simple double sendKeys()
	// doesn't apply here
	public void userPressesKeysAltAndKeyUp() {
		new Actions(getDriver()).keyDown(Keys.ALT).sendKeys(Keys.ARROW_UP).keyUp(Keys.ALT).perform();
	}

	// press key ALT, press arrow down, release key ALT. Simple double sendKeys()
	// doesn't apply here
	public void userPressesKeysAltAndKeyDown() {
		new Actions(getDriver()).keyDown(Keys.ALT).sendKeys(Keys.ARROW_DOWN).keyUp(Keys.ALT).perform();
	}

	public void userPressesKeysTabNTimes(int n) {
		for (int i = 0; i < n; i++) {
			userPressesKeysShiftTab();
		}
	}

	public void userPressesKeyEnter() {
		userPressesKey(ACTION_ENTER);
	}

	public void userPressesKeySpace() {
		userPressesKey(ACTION_SPACE);
	}

	public void userPressesKeyDelete() {
		userPressesKey(ACTION_DELETE);
	}

	public void userPressesKeyEscape() {
		userPressesKey(ACTION_ESCAPE);
	}

	public void robotPressedKeyEscape() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
	}

	public void userResizesBrowsersWindow(ExamplesTable parameters) {
		boolean replaceNamedParameters = true;
		int width = parameters.getRowAsParameters(0, replaceNamedParameters).valueAs("Width", Integer.class);
		int height = parameters.getRowAsParameters(0, replaceNamedParameters).valueAs("Height", Integer.class);
		getDriver().manage().window().setSize(new Dimension(width, height));
	}

	public void thereAreNoAccessibilityErrors() {
		assertEquals("Quantity of accessibility errors:", 0, basePage.getQuantityOfErrors());

	}

	public void thereAreNoAccessibilityErrorsAdministration() {
		thereAreNoAccessibilityErrorsForElement(basePage.adminPanel);
	}

	public void thereAreNoAccessibilityErrorsMessages() {
		thereAreNoAccessibilityErrorsForElement(basePage.panelMessages);
	}

	public void thereAreNoAccessibilityErrorsProjects() {
		thereAreNoAccessibilityErrorsForElement(basePage.panelProjects);
	}

	public void thereAreNoAccessibilityDocketHeader() {
		thereAreNoAccessibilityErrorsForElement(basePage.panelDocketHeader);
	}

	public void thereAreNoAccessibilityInstrumentBranchContainer() {
		thereAreNoAccessibilityErrorsForElement(basePage.containerInstrumentBranch);
	}

	private void thereAreNoAccessibilityErrorsForElement(final String xpath) {
		assertEquals("Quantity of accessibility errors:", 0, basePage.getQuantityOfErrors(xpath));
	}

	public String getBrowserType() {
		return ((WebDriverFacade) getDriver()).getCapabilities().getBrowserName();
	}

	public BasePage getBasePage() {
		return basePage;
	}

	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}

	/* to hasElementAttributes blocked cases input error message cases */
	public void user_set_text_to_clipboard_to_paste(String text) {
		try {
			StringSelection selection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);
		} catch (Exception e) {
			fail("fail to use clipboard to paste the text!");
		}
	}

	/**
	 * clear cookies from browser session
	 */
	public void clearChromeBrowserCache() {
		getDriver().manage().deleteAllCookies();

	}

	public void set_session_French() {
		isFrenchSession = true;
	}

	public void set_session_English() {
		isFrenchSession = false;
	}

	public boolean isAlertPresent() {
		try {
			getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	@Step
	public boolean is_session_french() {
		return isFrenchSession;
	}

	public static String getLocaleText(final String label) {
		Locale locale = isFrenchSession ? Locale.CANADA_FRENCH : Locale.CANADA;
		return ResourceBundle.getBundle(PROPERTIES_NGTV_LOCALE, locale).getString(label.toUpperCase());
	}

	public static List<String> getArrayFromPropertiesText(final String label) {
		Locale locale = isFrenchSession ? Locale.CANADA_FRENCH : Locale.CANADA;
		return Arrays.asList(ResourceBundle.getBundle(PROPERTIES_NGTV_LOCALE, locale).getString(label.toUpperCase()).split(","));
	}

	@Then("date picker is visible")
	public void checkDatePickerState() {
		assertTrue("date picker is in wrong state", basePage.pickerDate.isCurrentlyVisible());
	}

	@Then("date picker is not visible")
	public void checkDatePickerInvisiblity() {
		assertFalse("date picker is in wrong state", basePage.pickerDate.isCurrentlyVisible());
	}

	@When("user chooses previous date from date picker")
	public void chooseDateFromPicker() {
		basePage.previousDayFromDatePicker().click();
	}

	@When("user chooses current date from date picker")
	public void chooseCurrentDateFromPicker() {
		basePage.currentDayFromDatePicker.click();
	}

	public void enlargeTestScreen() {
		basePage.getDriver().manage().window().maximize();
	}

	@Given("user load test data")
	public void userLoadTestData() {
		try {
			String story_name = getCurrentStoryName(); // file_name = story_name
			String current_foler = getCurrentTestFolderName();
			String table_path = getTablePath();

			String csv_path = current_foler + CSV_PATH;
			DataDrivenUtil.ConvertExcelSheetToCSVs(table_path, csv_path, story_name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getExampleTableString(String sheetName, String row_index) {
		String strRet = "";
		String strRow = "";
		String story_name = getCurrentStoryName(); // file_name = story_name
		String table_path = getTablePath();

		// get example table first row
		try {
			strRet = DataDrivenUtil.getRowDataFromSheet(table_path, story_name, sheetName, "0");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] index_list = row_index.split(",");
		for (int i = 0; i < index_list.length; i++) {
			try {
				strRow = DataDrivenUtil.getRowDataFromSheet(table_path, story_name, sheetName, index_list[i]).replaceAll("\n|\r", " ");
				System.out.println("Row: " + strRow);
				strRet = strRet + strRow + System.lineSeparator();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println(strRet);
		return strRet;
	}

	// type: 0 return double, type: 1 return int
	public String getColumnSummary(String sheetName, String row_index, String col_No, int type) {
		String retStr = "";
		String story_name = getCurrentStoryName(); // file_name = story_name
		String table_path = getTablePath();

		String[] index_list = row_index.split(",");
		Double dValue = 0.00;
		int iValue = 0;
		for (int i = 0; i < index_list.length; i++) {
			try {
				String tempData = DataDrivenUtil.getGridDataFromSheet(table_path, story_name, sheetName, index_list[i], col_No);
				if (type == 0) {
					// if (tempData.contains("+"))
					tempData = tempData.replace("+", "");
					tempData = tempData.replace(",", "");
					dValue = dValue + Double.parseDouble(tempData);
				}
				if (type == 1)
					iValue = iValue + Integer.parseInt(tempData);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (type == 0) {
			dValue = Math.round(dValue * 100D) / 100D;
			return String.format("%.2f", dValue);
		}
		if (type == 1) {
			retStr = String.valueOf(iValue);
			return retStr;
		}
		return retStr;
	}

	public String getHST(String strValue) {
		Double dValue = Double.parseDouble(strValue);
		dValue = dValue * 0.13;
		dValue = Math.round(dValue * 100D) / 100D;
		return String.format("%.2f", dValue);
	}

	public String getHST(String sheetName, String row_index, String col_No) {
		String story_name = getCurrentStoryName();
		String table_path = getTablePath();

		String[] index_list = row_index.split(",");
		Double dSum = 0.00;
		for (int i = 0; i < index_list.length; i++) {
			try {
				Double dValue = 0.00;
				DecimalFormat df = new DecimalFormat("#.##");
				String tempData = DataDrivenUtil.getGridDataFromSheet(table_path, story_name, sheetName, index_list[i], col_No);
				// if (tempData.contains("+"))
				tempData = tempData.replace("+", "");
				tempData = tempData.replace(",", "");
				dValue = Double.parseDouble(tempData) * 0.13;
				dValue = Double.valueOf(df.format(dValue));
				dSum = dSum + dValue;

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dSum = Math.round(dSum * 100D) / 100D;
		return String.format("%.2f", dSum);
	}

	public String getTotalFee(String fee1, String fee2, String fee3) {
		Double dValue = Double.parseDouble(fee1) + Double.parseDouble(fee2) + Double.parseDouble(fee3);
		dValue = Math.round(dValue * 100D) / 100D;
		return String.format("%.2f", dValue);
	}

	public String getTotalFee(String fee1, String fee2) {
		Double dValue = Double.parseDouble(fee1) + Double.parseDouble(fee2);
		dValue = Math.round(dValue * 100D) / 100D;
		return String.format("%.2f", dValue);
	}

	@Then("user clean up temp csv file")
	public void userRemoveTempDataFile() {
		String current_foler = getCurrentTestFolderName();
		String csv_path = current_foler + CSV_PATH;
		String story_name = getCurrentStoryName();
		// String full_path = csv_path + story_name + ".csv";
		File folder = new File(csv_path);
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			for (File f : files) {
				if (f.isFile() && f.getName().contains(story_name) && f.getName().contains(".csv"))
					f.deleteOnExit();
			}
		}
	}

	public static String getCurrentTestFolderName() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String folder_name = variables.getProperty("test.folder");
		return folder_name;
	}

	public static String getCurrentTestDataFolderName() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String folder_name = variables.getProperty("test.data.folder");
		return folder_name;
	}

	public static String getCurrentStoryName() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String story_name = variables.getProperty("test.story.name");
		return story_name;
	}

	public static String getCurrentEnv() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String env_name = variables.getProperty("test.TestEnvironment");
		return env_name;
	}

	public static String getTablePath() {
		String current_foler = getCurrentTestFolderName();
		String current_data_foler = getCurrentTestDataFolderName();
		String current_env = getCurrentEnv();
		String table_path = null;

		// Try specified data path
		table_path = current_data_foler + "\\";
		File f = new File(table_path + current_env + "\\");
		if (f.exists() && f.isDirectory()) {
			table_path = table_path + current_env + "\\";
		} else {
			// Try default(local) data path
			table_path = current_foler + TABLE_PATH;
			f = new File(table_path + current_env + "\\");
			if (f.exists() && f.isDirectory()) {
				table_path = table_path + current_env + "\\";
			}
		}
		System.out.println("Data table path: " + table_path);
		return table_path;
	}

	public String getStartSheetName(String story_name) {
		String[] story_split_name = story_name.split("_");
		String project_name = story_split_name[0] + "_";
		String sheet_name = story_name.replace(project_name, "");
		return sheet_name;
	}

	// only work for contains 1 pair of brackets
	public String getStringBetweenBrackets(String strInput, String lBracket) {
		String rBracket;
		String strOutPut = "";
		if (lBracket == "{")
			rBracket = "}";
		else if (lBracket == "(")
			rBracket = ")";
		else if (lBracket == "[")
			rBracket = "]";
		else
			return strOutPut;

		strOutPut = strInput.substring(strInput.indexOf(lBracket) + 1);
		strOutPut = strOutPut.substring(0, strOutPut.indexOf(rBracket));
		return strOutPut;
	}

	// now move to each page to handle
	public void closeModalDialog() {
		Alert alerts = basePage.getDriver().switchTo().alert();
		alerts.dismiss();
	}

	public static void DownloadPage(String url) {
		ca.teranet.util.TestResponseCode.DownloadPage(url);
	}

	public static void ExecuteJS(String jscript) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		System.out.println("Verify javascript link using javascript executor: " + jscript);
		js.executeScript(jscript);
	}

	public void assertMatchString(String strRegExp, String strInput) {
		assertTrue(strInput.matches(strRegExp));
	}

	public void assertMatchDateTime(String pattern, String strInput) {
		boolean ret = false;
		String myDT = "";
		int strLen = pattern.length();
		String[] tmpStr = strInput.split("Date/Time:");
		if (tmpStr.length > 1)
			myDT = tmpStr[1].substring(0, strLen - 1);
		else if (tmpStr.length == 1)
			myDT = tmpStr[0].substring(0, strLen - 1);
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			format.parse(myDT);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		assertTrue(ret);
	}

	public String get_webdriver_driver() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String driver = "";
		if (variables.getProperty("webdriver.remote.url") == null) {
			driver = variables.getProperty("webdriver.driver");
		} else {
			driver = variables.getProperty("webdriver.remote.driver");
		}
		return driver;
	}

	public void sendKeys(String keys) throws AWTException {
		Robot robot = new Robot();
		for (char c : keys.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException(
						"Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.delay(100);
			robot.keyRelease(keyCode);
			robot.delay(100);
		}
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * Description:setClipboardData setClipboardData throws Throwable the throwable
	 */
	public static void set_clipboard_data(String fileName) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void upload_image_file(String fileLocation) throws AWTException {

		// Setting clipboard with file location
		set_clipboard_data(fileLocation);
		// native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// parse to remove starting and ending braces
	public String parseText(String test, String startsymbol, String endsymbol, String sourcechar, String targetchar) {

		if (test.startsWith(startsymbol) && (test.endsWith(endsymbol))) {
			test = test.substring(1, test.length() - 1);
		}
		test = test.replace(sourcechar, targetchar);
		return (test);

	}

	public int InStr(Object string1, Object string2) {
		return string1.toString().indexOf(string2.toString()) + 1;
	}

	public static String myTimeStamp() {
		return "[" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + "]";
	}
}
