package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertyRemarksPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='addBulkOIBtn']")
	public WebElementFacade Add_WebButton;

	@FindBy(xpath = "//INPUT[@id='addOIBtn']")
	public WebElementFacade Add_WebButton1;

	@FindBy(xpath = "//input[@name='bulkForm.appendReplaceIndctrForOtherPropRmrks' and @value='A']")
	public WebElementFacade Append_WebRadioGroup;

	@FindBy(xpath = "//input[//input[@name='bulkForm.appendReplaceIndctrForOtherPropRmrks' and @value='R']")
	public WebElementFacade Replace_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='ApplyToAllBtnForRem']")
	public WebElementFacade ApplyToAll_Divide_WebButton;

	@FindBy(xpath = "//INPUT[@id='ApplyToSomeBtnForRem']")
	public WebElementFacade ApplyToSome_Bulk_WebButton;

	@FindBy(xpath = "//TR/TD[normalize-space()='SUBJECT TO DEBTS OF , IF ANY, AS IN']/INPUT[3]")
	public WebElementFacade AsIn1_WebEdit;

	@FindBy(xpath = "//TR/TD[normalize-space()='SUBJECT TO DEBTS OF , IF ANY, AS IN']/INPUT[2]")
	public WebElementFacade DebtsOf1_WebEdit;

	@FindBy(xpath = "//SELECT[@id='bulkInterestList']")
	public WebElementFacade InterestList_WebList;

	@FindBy(xpath = "//SELECT[@id='interestList']")
	public WebElementFacade Interest_WebList;

	@FindBy(xpath = "//TEXTAREA[@name='bulkForm.freeFormRemarks']")
	public WebElementFacade OtherRemarks0_WebEdit;

	@FindBy(xpath = "//TEXTAREA[@id='bulkForm.freeFormRemarks']")
	public WebElementFacade OtherRemarks_WebEdit;

	@FindBy(xpath = "//TEXTAREA[@id='documentForm.freeformPropertyRemark']")
	public WebElementFacade PropertyRemark_WebEdit;

	@FindBy(xpath = "//TR[5]/TD[1]/INPUT[1]")
	public WebElementFacade RemoveSelected_Bulk_WebButton;

	@FindBy(xpath = "//TR[8]/TD[1]/INPUT[1]")
	public WebElementFacade RemoveSelected_WebButton;

}
