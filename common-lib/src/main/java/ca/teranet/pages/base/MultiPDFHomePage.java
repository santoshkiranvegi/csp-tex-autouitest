package ca.teranet.pages.base;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://jenkins1.aws.tera-land.projects.epam.com:8082/multipdf/#home")
public class MultiPDFHomePage extends ModalDialogPage
{

  public MultiPDFHomePage() {
  }

  public MultiPDFHomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//table[contains(@aria-label,'Pour le bureau de')]//tbody//tr[1]//div[1]")
  public WebElementFacade fieldExecutionNumber;

  @FindBy(xpath = "//div[@id='dlg.parent.panel']")
  public WebElementFacade panelMain;

  public int getPaddingRightWidget() {
    String paddingRight = panelMain.getCssValue("padding-right").replace("px", "");
    return Integer.parseInt(paddingRight);
  }

  public float getWidthOfWidget() {
    String widthOfWidget = panelMain.getCssValue("width").replace("px", "");
    return Float.parseFloat(widthOfWidget);
  }

  @FindBy(xpath = "//div[@id='multipdf.title']")
  public WebElementFacade labelTitle;

  @FindBy(xpath = "//div[@id='multipdf.subTitle']")
  public WebElementFacade labelSubTitle;

  @FindBy(xpath = "//div[@class='multipdf-aside']")
  public WebElementFacade panelLeftNavigation;

  public int getWidthOfLeftNavigationPanel() {
    String widthOfLeftNavigationPanel = panelLeftNavigation.getCssValue("width").replace("px", "");
    return Integer.parseInt(widthOfLeftNavigationPanel);
  }

  @FindBy(xpath = "//div[.='Item List']")
  public WebElementFacade labelItemList;

  public WebElementFacade listItemPDF(String title) {
    return findBy("//li[.='" + title + "']");
  }

  @FindBy(xpath = "//div[@class='multipdf-content fullscreen']//button[@id='multipdf.toggleOpenButton']")
  public WebElementFacade buttonExpand;

  @FindBy(xpath = "//div[@class='multipdf-content']//button[@id='multipdf.toggleOpenButton']")
  public WebElementFacade buttonHide;

  @FindBy(xpath = ".//div[@class='gwt-SplitLayoutPanel-HDragger']")
  public WebElementFacade splitLayoutPanel;

  public int getWidthOfSplitLayoutPanel() {
    String widthOfSplitLayoutPanel = splitLayoutPanel.getCssValue("width").replace("px", "");
    return Integer.parseInt(widthOfSplitLayoutPanel);
  }

  @FindBy(xpath = "//button[@id='multipdf.previousButton']")
  public WebElementFacade buttonPreviousPDF;

  @FindBy(xpath = "//button[@id='multipdf.previousButton']/following-sibling::strong[.=' | ']")
  public WebElementFacade dividerPreviousNext;

  @FindBy(xpath = "//button[@id='multipdf.nextButton']")
  public WebElementFacade buttonNextPDF;

  @FindBy(xpath = "//button[.='Download All']")
  public WebElementFacade buttonDownloadAll;

  public WebElementFacade pdfDocument(String title) {
    return findBy("//iframe[contains(@title,'" + title + "')]");
  }

  public WebElementFacade pdfDocumentContainingTitle(String title) {
    return findBy("//iframe[contains(@title,'" + title + "')]");
  }

  final String errorPanelBelowHeaderXPath = "//div[@class='multipdf-main']/div[@class='gwt-HTML']/following-sibling"
      + "::div/div[@id='errorWidgetPanel']";

  @FindBy(xpath = errorPanelBelowHeaderXPath)
  public WebElementFacade errorPanelBelowHeader;

  @FindBy(xpath = errorPanelBelowHeaderXPath + "//div[@id='dlg.title']")
  public WebElementFacade errorPanelBelowHeaderTitle;

  @FindBy(xpath = errorPanelBelowHeaderXPath + "//span[@id='dlg.subTitle']")
  public WebElementFacade errorPanelBelowHeaderSubTitle;

  @FindBy(xpath = errorPanelBelowHeaderXPath + "//button[.='X']")
  public WebElementFacade errorPanelBelowHeaderButtonX;

  final String errorPanelInTheIFrameXPath = "//div[@class='multipdf-error-container']/div[@id='errorWidgetPanel']";

  @FindBy(xpath = errorPanelInTheIFrameXPath)
  public WebElementFacade errorPanelInTheIFrame;

  @FindBy(xpath = errorPanelInTheIFrameXPath + "//div[@id='dlg.title']")
  public WebElementFacade errorPanelInTheIFrameTitle;

  @FindBy(xpath = errorPanelInTheIFrameXPath + "//span[@id='dlg.subTitle']")
  public WebElementFacade errorPanelInTheIFrameSubTitle;

  @FindBy(xpath = errorPanelInTheIFrameXPath + "//button[.='X']")
  public WebElementFacade errorPanelInTheIFrameButtonX;

  // Number of pdf's in the left panel
  @FindBy(xpath = "count(//ul[@id='tabList']/li)")
  public int numberOfElements;

  // Get Active PDF
  @FindBy(xpath = "//li[@class='active']")
  public WebElementFacade activePDF;

  @FindBy(xpath = "//img[@id='multipdf.icon']")
  public WebElement multiPdfImage;

  @FindBy(xpath = "//ul[@id='multipdf-tab-list']")
  public WebElementFacade pdfList;

  @FindBy(xpath = "count(//ul[@id='multipdf-tab-list']/li)")
  public int numPDFListItem;

  public String getPDFListText() {
    String retStr = "";
    List<WebElementFacade> pdfItemList = findAll("//ul[@id='multipdf-tab-list']/li");
    for (int index = 0; index < pdfItemList.size(); index++) {
      if (!pdfItemList.get(index).isVisible()) {
        this.buttonExpand.click();
      }
      retStr = retStr + pdfItemList.get(index).getText();
      if (index < pdfItemList.size() - 1)
        retStr = retStr + "\r\n";
    }
    return retStr;
  }

  public WebElementFacade getPDFListItem(int rowIndex) {
    return findBy("//ul[@id='multipdf-tab-list']/li[" + rowIndex + "]");
  }
}
