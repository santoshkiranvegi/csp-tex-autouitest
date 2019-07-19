package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class ModifyHeaderPage extends BasePage {

@FindBy(xpath = "//TR[10]/TD[1]/INPUT[1]")
public WebElementFacade Apply_WebButton;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.newCashDrawer']")
public WebElementFacade CashDrawer_WebEdit;

@FindBy(xpath = "//TR[10]/TD[1]/INPUT[2]")
public WebElementFacade DoNotApply_WebButton;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.feeTaxRec.summary.cashDrawer']")
public WebElementFacade ExistingCashDrawer_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.feeTaxRec.LTT.valueAmount']")
public WebElementFacade ExistingLandTransferTax_WebEdit;

@FindBy(xpath = "//TR[normalize-space()='Registration Date/Time']/TD[2]/INPUT[1]")
public WebElementFacade ExistingRegDate_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.feeTaxRec.FEE.valueAmount']")
public WebElementFacade ExistingRegFees_WebEdit;

@FindBy(xpath = "//INPUT[@id='regDet.registrationNumber.docNumber']")
public WebElementFacade ExistingRegNumber_WebEdit;

@FindBy(xpath = "//TR[normalize-space()='Registration Date/Time']/TD[2]/INPUT[2]")
public WebElementFacade ExistingRegTime_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.feeTaxRec.RST.valueAmount']")
public WebElementFacade ExistingRetailSalesTax_WebEdit;

@FindBy(xpath = "//TR/TH[normalize-space()='MODIFY DOCUMENT HEADER']")
public WebElementFacade Header_WebElement;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.newLandTransferTax']")
public WebElementFacade LandTransferTax_WebEdit;

@FindBy(xpath = "//TR[normalize-space()='Registration Date/Time']/TD[3]/INPUT[1]")
public WebElementFacade RegDate_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.newRegistrationFees']")
public WebElementFacade RegFees_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.newDocNum']")
public WebElementFacade RegNumber_WebEdit;

@FindBy(xpath = "//TR[normalize-space()='Registration Date/Time']/TD[3]/INPUT[2]")
public WebElementFacade RegTime_WebEdit;

@FindBy(xpath = "//INPUT[@id='modifyHeaderForm.newRetailSalesTax']")
public WebElementFacade RetailSalesTax_WebEdit;

}
