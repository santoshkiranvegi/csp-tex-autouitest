package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class Description_BulkEditPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='addToResultingEasement']")
	public WebElementFacade Add_WebButton;

	@FindBy(xpath = "//input[@id='bulkForm.appendReplaceIndicator1']")
	public WebElementFacade Append_WebRadioGroup;

	@FindBy(xpath = "//input[@id='bulkForm.appendReplaceIndicator2']")
	public WebElementFacade Replace_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@id='ApplyToAllBtnForDesc']")
	public WebElementFacade ApplyToAll_WebButton;

	@FindBy(xpath = "//INPUT[@id='ApplyToSomeBtnForDesc']")
	public WebElementFacade ApplyToSome_WebButton;

	@FindBy(xpath = "//INPUT[@id='bulkForm.blockNum']")
	public WebElementFacade BlockNumber_WebEdit;

	@FindBy(xpath = "//TEXTAREA[@id='bulkForm.description']")
	public WebElementFacade Description_WebEdit;

	@FindBy(xpath = "//SELECT[@id='bulkEaseSelectList']")
	public WebElementFacade EasementList_WebList;

	@FindBy(xpath = "//SELECT[@id='BulkInterest']")
	public WebElementFacade Estate_WebList;

	@FindBy(xpath = "//INPUT[@id='BulkEstateQualifierFrenchIndicator']")
	public WebElementFacade French_WebCheckBox;

	@FindBy(xpath = "//SELECT[@name='bulkForm.lowerTierMunicipality']")
	public WebElementFacade LowerMunicipality_WebList;

	@FindBy(xpath = "//SELECT[@id='BulkQualifier']")
	public WebElementFacade Qualifier_WebList;

	@FindBy(xpath = "//INPUT[@id='removeAllSelectedBulkEasements']")
	public WebElementFacade Remove_WebButton;

	@FindBy(xpath = "//SELECT[@name='bulkForm.upperTierMunicipality']")
	public WebElementFacade UpperMunicipality_WebList;

	@FindBy(xpath = "//INPUT[@id='ApplyToAllBtnForDesc']")
	public WebElementFacade ApplyToAll_Divide_WebButton;

	@FindBy(xpath = "//INPUT[@id='ApplyToSomeBtnForDesc']")
	public WebElementFacade ApplyToSome_Bulk_WebButton;

}
