package ca.teranet.pages.base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;

public class WebTablePage extends BasePage {

	public String WebTableXpath;

	public WebTablePage() {
	}

	public WebTablePage(WebDriver driver) {
		super(driver);
	}

	public void setTablePath(String tableXpath) {
		WebTableXpath = tableXpath;
	}

	public int getRowCount() {
		WebElement element = this.getActiveElement();
		List<WebElement> list = element.findElements(By.xpath(WebTableXpath + "/tbody/tr"));
		return list.size();
	}

	public WebElement getRowOfTable(int rowNumber) {
		String xpathForRow = WebTableXpath + "/tbody/tr[" + rowNumber + "]";
		return findBy(xpathForRow);
	}

	public WebElement getCellOfTable(int rowNumber, int columnNumber) {
		String xpathForCell = WebTableXpath + "/tbody/tr[" + rowNumber + "]" + "/td[" + columnNumber + "]";
		return findBy(xpathForCell);
	}

	public WebElement getWebElementAtRowOfTableBody(int rowNumber) {
		WebElement element = this.getActiveElement();
		String xpathForRow = WebTableXpath + "/tbody/tr[" + rowNumber + "]";
		try {
			return element.findElement(By.xpath(xpathForRow));
		} catch (Exception e) {
			return null;
			// this is the case when the element is not visible, so return null.
		}
	}

	public WebElement getWebElementAtRowAndColumnOfTableBody(int rowNumber, int columnNumber) {
		WebElement element = this.getActiveElement();
		String xpathForRow = WebTableXpath + "/tbody/tr[" + rowNumber + "]" + "/td[" + columnNumber + "]";
		try {
			return element.findElement(By.xpath(xpathForRow));
		} catch (Exception e) {
			return null;
			// this is the case when the element is not visible, so return null.
		}
	}

	public WebElement getWebElementAtRowAndColumnOfTableFoot(int rowNumber, int columnNumber) {
		WebElement element = this.getActiveElement();
		String xpathForRow = WebTableXpath + "/tfoot/tr[" + rowNumber + "]" + "/td[" + columnNumber + "]";
		try {
			return element.findElement(By.xpath(xpathForRow));
		} catch (Exception e) {
			return null;
			// this is the case when the element is not visible, so return null.
		}
	}
}