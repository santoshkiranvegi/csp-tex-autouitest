package ca.teranet.pages.polaris;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class InternalPINNotesPage extends BasePage {

	@FindBy(xpath = "//INPUT[@name='bulkForm.appendReplaceIndctrForInternalNote' and @value='A']")
	public WebElementFacade Append_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@name='bulkForm.appendReplaceIndctrForInternalNote' and @value='R']")
	public WebElementFacade Replace_WebRadioGroup;

	@FindBy(xpath = "//INPUT[@value='Apply to All']")
	public WebElementFacade ApplyToAll_WebButton;

	@FindBy(xpath = "//INPUT[@value='Apply to Some']")
	public WebElementFacade ApplyToSome_WebButton;

	@FindBy(xpath = "//TEXTAREA[@id='bulkForm.freeFormInternalNote']")
	public WebElementFacade InternalPINNotes_WebEdit;

}
