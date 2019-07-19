package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PINDetailsPage extends BasePage {

	@FindBy(xpath = "//INPUT[@id='addToExistingEasement']")
	public WebElementFacade AddExisting_WebButton;

	@FindBy(xpath = "//INPUT[@id='addToResultingEasement']")
	public WebElementFacade AddNew_WebButton;

	@FindBy(xpath = "//INPUT[@id='submitSave']")
	public WebElementFacade Apply_WebButton;

	@FindBy(xpath = "//TEXTAREA[@id='editDescriptionVO.newLegalDescription.description']")
	public WebElementFacade Description_WebEdit;

	@FindBy(xpath = "//textarea[@id='editDescriptionVO.newLegalDescription.description']")
	public WebElementFacade Description_WebElement;

	@FindBy(xpath = "//INPUT[@id='submitCancel']")
	public WebElementFacade DoNotApply_WebButton;

	@FindBy(xpath = "//select[@name='editDescriptionVO.selectedTemplateType']")
	public WebElementFacade EasementList_WebList;

	@FindBy(xpath = "//select[@name='editDescriptionVO.lowerTierMunicipality']")
	public WebElementFacade LowerMunicipality_WebList;

	@FindBy(xpath = "//INPUT[@id='removeAllSelectedEasements']")
	public WebElementFacade RemoveSelected_WebButton;

	@FindBy(xpath = "//select[@name='editDescriptionVO.upperTierMunicipality']")
	public WebElementFacade UpperMunicipality_WebList;

}
