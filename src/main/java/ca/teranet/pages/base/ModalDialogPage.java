package ca.teranet.pages.base;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ModalDialogPage extends BasePage {

	public ModalDialogPage() {
	}

	public String dialogXpath = "//mat-dialog-container[contains(@class,'mat-dialog-container)']//div[@class='modal-container']";

	public String dialogMessageXpath = dialogXpath + "/div[@class='messaging']";

	public String loadingImageXpath = "//img[@class='gwt-Image progressIcon']";

	public ModalDialogPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//mat-dialog-container")
	public WebElementFacade rootModal;

	@FindBy(xpath = "//div[@class='title']//h1")
	public WebElementFacade dialog_title;

	@FindBy(xpath = "//button[@id='closeButton']")
	public WebElementFacade buttonX;

	// ===========================================================================================

	@FindBy(xpath = "//img[@id='multipdf.icon']")
	public WebElementFacade iconHeader;

	@FindBy(xpath = "//div[@id='dlg.subTitle']")
	public WebElementFacade labelStrictSubTitle;

	@FindBy(xpath = "//div[@id='dlg.title']")
	public WebElementFacade labelStrictTitle;

	@FindBy(xpath = "//div[@id='dlg.title' or @id='dlg.title1' or @id='dlg.title0']")
	public WebElementFacade labelTitle;

	@FindBy(xpath = "//div[@id='dlg.title1']")
	public WebElementFacade secondPopupLabelTitle;

	@FindBy(xpath = "//div[@id='dlg.subTitle0' or @id='dlg.subTitle']")
	public WebElementFacade labelSubTitleWithinDiv;

	@FindBy(xpath = "//span[@id='dlg.subTitle0' or @id='dlg.subTitle']")
	public WebElementFacade labelSubTitleWithinSpan;

	@FindBy(xpath = "//div[@id='dlg.msg.subheading']")
	public WebElementFacade labelHeading;

	@FindBy(xpath = "//div[@id='dlg.msg.copy']")
	public WebElementFacade labelMessage;

	@FindBy(xpath = "//div[@id='dlg.msg.copyDiv']")
	public WebElementFacade labelMessageDiv;

	@FindBy(xpath = "//div[@id='dlg.msg.callToAction']")
	public WebElementFacade labelMessageAction;

	@FindBy(xpath = "//div[@id='errorTextPanel']//div[@id='dlg.title']")
	public WebElementFacade errorMessageTitle;

	@FindBy(xpath = "//div[@id='errorTextPanel']//span[@id='dlg.subTitle']")
	public WebElementFacade errorMessageSubTitle;

	@FindBy(xpath = "//div[@id='dlg.parent.panel']//div[@id='errorWidgetPanel']")
	public WebElementFacade errorWidgetPanel;

	@FindBy(xpath = "//button[contains(@class,'helpButton')]")
	public WebElementFacade buttonHelp;

	@FindBy(xpath = "//div[@id='dlg.parent.panel']//button[contains(@id,'actionMenuButton')]")
	public WebElementFacade buttonActionMenu;

	public WebElementFacade listItemActionMenu(String item) {
		return findBy("//td[contains(@class,'gwt-MenuItem') and .='" + item + "']");
	}

	@FindBy(xpath = "//button[@id='dlg.btn.Close' or @id='dlg.btn.Fermer']")
	public WebElementFacade buttonClose;

	@FindBy(xpath = "//button[@id='dlg.btn.Add']")
	public WebElementFacade buttonAdd;

	@FindBy(xpath = "//button[@id='dlg.btn.Apply']")
	public WebElementFacade buttonApply;

	@FindBy(xpath = "//button[@id='dlg.btn.Deselect']")
	public WebElementFacade buttonDeselect;

	@FindBy(xpath = "//button[@id='dlg.btn.FR_OK' or @id='dlg.btn.OK' or @id='dlg.btn.Yes' or @id='dlg.btn.Remplacer' "
			+ "or @id ='dlg.btn.View' or @id='dlg.btn.Visualiser']")
	public WebElementFacade buttonOK;

	@FindBy(xpath = "//div[@id='dlg.parent.panel_1']//button[@id='dlg.btn.OK']")
	public WebElementFacade buttonOKofSecondDialog;

	@FindBy(xpath = "//button[@id='dlg.btn.Continue' or @id='dlg.btn.Continuer']")
	public WebElementFacade buttonContinue;

	@FindBy(xpath = "//button[@id='dlg.btn.View']")
	public WebElementFacade buttonView;

	@FindBy(xpath = "//button[@id='dlg.btn.Retrieve']")
	public WebElementFacade buttonRetrieve;

	@FindBy(xpath = "//button[@id='dlg.btn.Annuler' or @id='dlg.btn.No' or @id='dlg.btn.Cancel']")
	public WebElementFacade buttonCancel;

	@FindBy(xpath = "//button[@id='dlg.btn.Annuler' or @id='dlg.btn.Logout']")
	public WebElementFacade buttonLogout;

	@FindBy(xpath = "//div[@id='dlg.parent.panel']//button[@id='searchButton']")
	public WebElementFacade buttonSearch;

	@FindBy(xpath = "//button[(@id='010' and .='Parcel Register') or (@id='010' and .='Registre des parcelles')]")
	public WebElementFacade buttonParcelRegister;

	@FindBy(xpath = "//button[(@id='dlg.btn.Parcel.Register' and .='Parcel Register') or (@id='dlg.btn.Registre.des"
			+ ".parcelles' and .='Registre des parcelles')]")
	public WebElementFacade buttonNotificationParcelRegister;

	@FindBy(xpath = "//button[@id='dlg.btn.Delete' or @id='dlg.btn.Supprimer']")
	public WebElementFacade buttonDelete;

	@FindBy(xpath = "//button[@id='dlg.btn.Select']")
	public WebElementFacade buttonSelect;

	@FindBy(xpath = "//button[@id='dlg.btn.Create']")
	public WebElementFacade buttonCreate;

	@FindBy(xpath = "//button[@id='dlg.btn.Abandon']")
	public WebElementFacade buttonAbandon;

	@FindBy(xpath = "//button[@id='dlg.btn.Download.All' or @id='dlg.btn.Télécharger.tout']")
	public WebElementFacade buttonDownloadAllSchedules;

	/* Projects Import specific */
	@FindBy(xpath = "//button[@id='dlg.btn.No,.Select.Another' or @id='dlg.btn.FR_No,.Select.Another']")
	public WebElementFacade buttonSelectAnotherDocket;

	@FindBy(xpath = "//button[@id='dlg.btn.Yes,.Use.Current.Docket' or @id='dlg.btn.FR_Yes,.Use.Current.Docket']")
	public WebElementFacade buttonUseCurrentDocket;

	@FindBy(xpath = "//button[@id='dlg.btn.Update.Common.Information']")
	public WebElementFacade buttonUpdateCommonInfo;

	@FindBy(xpath = "//button[@id='dlg.btn.Update.Selective.Party(s)']")
	public WebElementFacade buttonSelectiveParty;

	@FindBy(xpath = "//button[.='Choose File to Import']")
	public WebElementFacade buttonChooseFileImport;

	public WebElementFacade checkBoxSelectProject(int rowNumber) {
		return findBy("//table[@id='received-instrument-list']/tbody//tr[@__gwt_row='" + (rowNumber - 1) + "']//input");
	}

	@FindBy(xpath = "//button[@id='dlg.btn.Use.Previous' or @id='dlg.btn.Utiliser.le.précédent']")
	public WebElementFacade buttonUsePrevious;

	@FindBy(xpath = "//button[@id='dlg.btn.Retrieve.New' or @id='dlg.btn.Nouvelle.extraction']")
	public WebElementFacade buttonRetrieveNew;

	@FindBy(xpath = "//button[@id='dlg.btn.Proceed' or @id='dlg.btn.Oui']")
	public WebElementFacade buttonProceed;

	@FindBy(xpath = "//button[@id='dlg.btn.Register' or @id='dlg.btn.Enregistrer']")
	public WebElementFacade buttonRegister;

	@FindBy(xpath = "//button[@id='dlg.btn.Writ.Certificate.PDF']")
	public WebElementFacade buttonWritCert;

	@FindBy(xpath = "//div[@id='dlg.content.panel']//img[@class='gwt-Image progressIcon']")
	public WebElementFacade waitingIconDialog;

	@FindBy(xpath = "//div[@id='dlg.content.panel']")
	public WebElementFacade dialogContent;
}
