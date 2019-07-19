package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SearchResultsCommonPage extends BasePage {

@FindBy(xpath = "//TD[@id='blankLine']/INPUT[1]")
public WebElementFacade BlankLineNumber_WebEdit;

@FindBy(xpath = "//TD[3]/INPUT[1]")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR/TD/TABLE/TBODY/TR/TD[normalize-space()='Please select one language for your report: English French']/INPUT[1]")
public WebElementFacade ReportLanguage_WebRadioGroup;

@FindBy(xpath = "//TABLE/TBODY/TR/TD[normalize-space()='Results for Search Highways Register']")
public WebElementFacade ResultsHeader_WebElement;

}
