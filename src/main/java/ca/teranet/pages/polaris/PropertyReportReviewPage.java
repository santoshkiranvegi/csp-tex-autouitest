package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PropertyReportReviewPage extends BasePage {

@FindBy(xpath = "//INPUT[@id='bulkEdit']")
public WebElementFacade BulkEdit_WebButton;

@FindBy(xpath = "//INPUT[@id='certify']")
public WebElementFacade Certify_WebButton;

@FindBy(xpath = "//FORM[1]/SPAN[2]")
public WebElementFacade ChildProperty_WebElement;

@FindBy(xpath = "//INPUT[@id='close']")
public WebElementFacade Close_WebButton;

@FindBy(xpath = "//TD[3]/INPUT[1]")
public WebElementFacade DoNotApply_WebButton;

@FindBy(xpath = "//INPUT[@id='editChildWithRowId']")
public WebElementFacade EditChildProperty_WebButton;

@FindBy(xpath = "//TABLE[@id='messages']")
public WebElementFacade ErrorMsg_WebTable;

@FindBy(xpath = "//TR/TD[normalize-space()='For Parent Pin: 16927-1816(LT)']")
public WebElementFacade ParentPIN_WebElement;

@FindBy(xpath = "//INPUT[@id='returnToPropDetails']")
public WebElementFacade ReturnToPropertyDetails_WebButton;

@FindBy(xpath = "//FORM[1]/INPUT[2]")
public WebElementFacade ReturnToReviewSelection_WebButton;

@FindBy(xpath = "//INPUT[@id='reviewStatusIndr']")
public WebElementFacade ReviewStatusIndicator_WebCheckBox;

@FindBy(xpath = "//INPUT[@id='rowId']")
public WebElementFacade RowID_WebEdit;

@FindBy(xpath = "//INPUT[@id='viewDraftParcelRegister']")
public WebElementFacade ViewDraftParcelRegister_WebButton;

@FindBy(xpath = "//INPUT[@id='viewSummaryReport']")
public WebElementFacade ViewSummaryReport_WebButton;

}
