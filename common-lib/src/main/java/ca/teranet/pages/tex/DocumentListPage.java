package ca.teranet.pages.tex;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentListPage extends WebTablePage {

	private final String tableDocumentList = "//table[@id='namesLoop']";

	public void setDocumentListTable() {
		this.setTablePath(tableDocumentList);
	}

	public WebElementFacade desp_document(int docNo) {
		return findBy(tableDocumentList + "/tbody/tr[" + docNo + "]/td/div[@class='form-label']");
	}

	public WebElementFacade radiobutton_allPages(int docNo) {
		return findBy(tableDocumentList + "/tbody/tr[" + docNo + "]/td//tr[2]/td[1]/input");
	}

	public WebElementFacade radiobutton_selectPages(int docNo) {
		return findBy(tableDocumentList + "/tbody/tr[" + docNo + "]/td//tr[2]/td[2]//input[@type='radio']");
	}

	public WebElementFacade input_selectPages(int docNo) {
		return findBy(tableDocumentList + "/tbody/tr[" + docNo + "]/td//tr[2]/td[2]//input[@type='text']");
	}

	@FindBy(xpath = "//input[@id='btn-submit']")
	public WebElementFacade button_submit;

	// ============== negative ==================================

	// for list document and some error message in document view page
	@FindBy(xpath = "//span[@id='doc.errors']")
	public WebElementFacade page_errorMsg_docList;

}
