package ca.teranet.pages.base;

import static ca.teranet.util.StreamUtil.getCurrentDateIndexFromList;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePage extends PageObject {

	public final String panelMessages = "//div[contains(@id,'messagePanelHomePage')]";

	public final String panelProjects = "//div[contains(@id,'projectPanelHomePage')]";

	public final String panelDocketHeader = "//div[contains(@id,'docketHeaderPanel')]";

	public final String adminPanel = "//div[contains(@id,'adminPanel')]";

	public final String containerInstrumentBranch = "//div[@id='edit-inst-editor-widget']";

	@FindBy(xpath = "//table[@class='gwt-DatePicker']")
	public WebElementFacade pickerDate;

	@FindBy(xpath = "//div[contains(@class,'datePickerDay') and contains(@class,'datePickerDayIsToday')]")
	public WebElementFacade currentDayFromDatePicker;

	public WebElementFacade previousDayFromDatePicker() {
		List<WebElementFacade> enabledDaysFromPickerDate = findAll(
				"//div[contains(@class,'datePickerDay') and not(contains(@class,'datePickerDayIsDisabled'))]");
		int todayIndex = getCurrentDateIndexFromList(enabledDaysFromPickerDate);
		return enabledDaysFromPickerDate.get(todayIndex - 1);
	}

	@FindBy(xpath = "//mat-progress-spinner]")
	private WebElementFacade spinner;

	@FindBy(xpath = "//cycle[conayins(@style, 'mat-progress-spinner')]")
	private WebElementFacade systemWaitGlass;

	public BasePage() {
	}

	public BasePage(WebDriver driver) {
		super(driver);
	}

	public void waitUntilElementDisplayed(WebElement we) {
		final long watch = System.currentTimeMillis();
		while ((System.currentTimeMillis() - watch) < 20000) // change it to a constant somewhere please{
			try {
				we.isDisplayed();
				return;
			} catch (Exception e) {

			}
	}

	public void clickSafelyByWaiting(WebElement we) {
		final long watch = System.currentTimeMillis();
		while ((System.currentTimeMillis() - watch) < 20000)// change it to a constant somewhere please{
			try {
				we.click();
				return;
			} catch (Exception e) {

			}
	}

	public WebElement getActiveElement() {
		return getDriver().switchTo().activeElement();
	}

	public int getQuantityOfErrors() {
		int count = 0;
		List<WebElementFacade> errorList = new ArrayList<>();
		if (findAll("//div[@class='dateBoxPopup']").size() != 0) {
			errorList = findAll(
					"//div[@class='dateBoxPopup']//img[(@class='wave4tip' or @class='wave5icon') and contains(@alt,'ERROR') and "
							+ "not" + "(contains(@alt,'CONTRAST'))]");
		}
		if (findAll("//div[@id='actionMenuPopup']").size() != 0) {
			errorList.addAll(findAll(
					"//div[@id='actionMenuPopup']//img[(@class='wave4tip' or @class='wave5icon') and contains(@alt,'ERROR') and "
							+ "not" + "(contains(@alt,'CONTRAST'))]"));
		}
		if (findAll("//div[@class='formDialog']").size() != 0) {
			errorList.addAll(findAll(
					"//div[@class='formDialog']//img[(@class='wave4tip' or @class='wave5icon') and contains(@alt,'ERROR') and not"
							+ "(contains(@alt,'CONTRAST'))]"));
		}
		errorList.addAll(findAll(
				"//img[(@class='wave4tip' or @class='wave5icon') and contains(@alt,'ERROR') and not(contains(@alt,'CONTRAST'))]"));
		for (WebElementFacade error : errorList) {
			if (error.isVisible()) {
				count++;
			}
		}
		return count;
	}

	public int getQuantityOfErrors(String path) {
		int count = 0;
		List<WebElementFacade> list = findAll(
				path + "//img[(@class='wave4tip' or @class='wave5icon') and contains(@alt,'ERROR') and not(contains(@alt,"
						+ "'CONTRAST'))]");
		for (WebElementFacade error : list) {
			if (error.isVisible()) {
				count++;
			}
		}
		return count;
	}

	public WebElementFacade getCheckBoxByLabel(String value) {
		return findBy("//input[@type='checkbox' and contains(@aria-label,'" + value + "')]");
	}

	public WebElementFacade getSpinner() {
		waitABit(500);
		return spinner;
	}

	public WebElementFacade getSystemWaitGlass() {
		waitABit(500);
		return systemWaitGlass;
	}

	public String getRowNumber(String rowNumber) {
		String result = "";
		int row;
		if (rowNumber != null) {
			row = Integer.parseInt(rowNumber) - 1;
			result = new Integer(row).toString();
		}
		return result;
	}

	public void setArttribute(WebElementFacade element, String attName, String attValue) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
		js.executeScript(scriptSetAttrValue, element, attName, attValue);
	}
}
