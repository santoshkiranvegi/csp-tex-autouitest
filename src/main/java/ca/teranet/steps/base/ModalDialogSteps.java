package ca.teranet.steps.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Dialog;
import java.awt.Window;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ca.teranet.pages.base.ModalDialogPage;
import ca.teranet.util.WaitUtil;
import net.thucydides.core.annotations.Step;

public class ModalDialogSteps extends BaseSteps {

	ModalDialogPage modalDialog;

	String line_change_in_subtitle = "\n\n";

	@Then("user sees dialog with title $title")
	public void user_see_dialog_with_title(String title) {
		System.out.println("entered user_see_dialog_with_title()");
		modalDialog.waitUntilElementDisplayed(modalDialog.rootModal);
		assertEquals(title, modalDialog.dialog_title.getText().trim());
	}

	@Given("pop up is not displayed")
	@Then("pop up is not displayed")
	public void popUpIsNotDisplayed() {
		assertFalse(modalDialog.rootModal.isVisible());
	}

	@When("'Communication Error' notification is visible")
	public void popUpIsDisplayed() {
		assertTrue(modalDialog.rootModal.isVisible());
	}

	@Then("icon in header is not displayed")
	public void iconInHeaderIsNotDisplayed() {
		assertFalse(modalDialog.iconHeader.isVisible());
	}

	@Then("$state icon is displayed in header")
	public void iconIsDisplayedInHeader(String state) {
		assertTrue(modalDialog.iconHeader.getAttribute("alt").contains(state));
	}

	@Given("user clicked title on Pop Up")
	@When("user clicks title on Pop Up")
	public void userClickedTitleOnPopUp() {
		modalDialog.labelTitle.click();
	}

	@Given("pop up '$title' is displayed")
	@When("pop up '$title' is displayed")
	@Then("pop up '$title' is displayed")
	@Alias("title of pop up is: $title")
	public void titleOfPopUpIs(String title) {
		assertEquals(title, modalDialog.labelTitle.getText());
	}

	@Step
	public String get_dialog_title() {
		return modalDialog.labelTitle.getText();
	}

	@Step
	public String get_dialog_title_by_waiting() {
		String title = "";
		final long watch = System.currentTimeMillis();
		while ((System.currentTimeMillis() - watch) < 20000)// change it to a constant somewhere please{
			try {
				title = modalDialog.labelTitle.getText();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return title;
	}

	@Step
	public String get_dialog_content() {
		return modalDialog.dialogContent.getText();
	}

	@Then("second pop up '$title' is displayed")
	public void titleOfSecondPopUpIs(String title) {
		assertEquals(title, modalDialog.secondPopupLabelTitle.getText());
	}

	@Then("title in header is displayed")
	public void titleInHeaderIsDisplayed() {
		assertTrue(modalDialog.labelTitle.isVisible());
	}

	@Then("subtitle in header is displayed")
	public void subTitleInHeaderIsDisplayed() {
		assertTrue(modalDialog.labelSubTitleWithinDiv.isVisible());
	}

	@Then("subtitle of pop up is: $subtitle")
	public void subtitleOfPopUpIs(String subtitle) {
		assertEquals(subtitle, modalDialog.labelSubTitleWithinDiv.getText());
	}

	@Then("user closed all modal dialogs")
	public void userClosedAllModalDialogs() {
		while (modalDialog.buttonX.isVisible()) {
			modalDialog.buttonX.waitUntilClickable().click();
			waitLoadingDisappeared();
		}
	}

	@Given("user clos{ed|es} modal dialog")
	@When("user clos{ed|es} modal dialog")
	@Then("user clos{ed|es} modal dialog")
	public void userClosedModalDialog() {
		modalDialog.buttonX.waitUntilClickable().click();
	}

	@Then("button 'X' is displayed")
	public void buttonXIsDisplayed() {
		assertTrue(modalDialog.buttonX.isVisible());
	}

	@Then("button 'X' is focused")
	public void buttonXIsFocused() {
		assertTrue(modalDialog.getActiveElement().equals(modalDialog.buttonX));
	}

	@Then("value of button 'X' is: $value")
	public void valueOfButtonXIs(String value) {
		assertEquals(value, modalDialog.buttonX.getText());
	}

	@Given("user clicked button 'Retrieve'")
	public void clickButtonRetrieve() {
		modalDialog.buttonRetrieve.click();
	}

	@Given("user selected $item from Action Menu on Modal Dialog")
	public void selectFromActionMenu_ModalDialog(String item) {
		modalDialog.buttonActionMenu.click();
		modalDialog.listItemActionMenu(item).click();
	}

	@Then("button 'Retrieve' is focused")
	public void buttonRetrieveIsFocused() {
		assertTrue(modalDialog.getActiveElement().equals(modalDialog.buttonRetrieve));
	}

	@Given("user click{ed|s} button 'OK'")
	@When("user click{ed|s} button 'OK'")
	@Then("user click{ed|s} button 'OK'")
	public void clickButtonOk() {
		modalDialog.buttonOK.waitUntilClickable().click();
		waitLoadingDisappeared();
	}

	/*
	 * used when user input registered instrument in statement blank the first OK click will display instrument registered time the second OK click is to confirm input
	 */
	@Given("user clicks button 'OK' twice")
	@When("user clicks button 'OK' twice")
	public void user_click_ok_button_twice() {
		clickButtonOk();
		clickButtonOk();
	}

	@Given("user clicks button 'OK' on the second modal dialog")
	@Then("user clicks button 'OK' on the second modal dialog")
	public void click_Ok_button_on_second_dialog() {
		modalDialog.buttonOKofSecondDialog.click();
	}

	@Given("user skipped '$title' notification")
	@When("user skips '$title' notification")
	public void skipNotificationModal(String title) {
		if (modalDialog.buttonOK.isVisible()) {
			clickButtonOk();
			wait_until_dialog_waiting_finished();
		}
		if (modalDialog.buttonContinue.isVisible()) {
			clickButtonContinue();
			wait_until_dialog_waiting_finished();
		}
	}

	@Step
	public void wait_until_dialog_waiting_finished() {
		WaitUtil.waitUntilElementDisappears(modalDialog.waitingIconDialog);
	}

	@Then("button 'OK' is focused")
	public void buttonOkIsFocused() {
		assertTrue(modalDialog.getActiveElement().equals(modalDialog.buttonOK));
	}

	@Then("value of button 'OK' is $value")
	public void valueOfButtonOkIs(String value) {
		assertEquals(value, modalDialog.buttonOK.getText());
	}

	@Given("user click{ed|s} button 'Continue'")
	@When("user clicks button 'Continue'")
	@Alias("user clicks button 'Continuer'")
	public void clickButtonContinue() {
		if (modalDialog.buttonContinue.isVisible()) {
			modalDialog.buttonContinue.click();
			waitLoadingDisappeared();
		}
	}

	@When("user clicks button 'Cancel'")
	@Then("user click{ed|s} button 'Cancel'")
	public void clickButtonCancel() {
		modalDialog.buttonCancel.click();
		waitLoadingDisappeared();
	}

	@Then("user clicks button 'Logout' on modal dialog")
	public void clickButtonLogout() {
		modalDialog.buttonLogout.click();
		waitLoadingDisappeared();
	}

	@Then("button Help is focused on modal")
	public void buttonHelpIsFocused() {
		assertTrue(modalDialog.getActiveElement().equals(modalDialog.buttonHelp));
	}

	@Then("value of button Help on modal is: $value")
	public void buttonHelpHasValue(final String value) {
		assertEquals("button Help has wrong value", value, modalDialog.buttonHelp.getText());
	}

	@Then("button 'Cancel' is focused")
	public void buttonCancelIsFocused() {
		assertTrue(modalDialog.getActiveElement().equals(modalDialog.buttonCancel));
	}

	@Then("value of button 'Cancel' is $value")
	public void valueOfButtonCancelIs(String value) {
		assertEquals(value, modalDialog.buttonCancel.getText());
	}

	@Given("user clicks button 'Close'")
	@When("user clicks button 'Close'")
	@Then("user clicks button 'Close'")
	public void userClicksButtonClose() {
		modalDialog.buttonClose.click();
	}

	@When("user clicks button 'Add'")
	public void userClicksButtonAdd() {
		modalDialog.buttonAdd.click();
	}

	@Given("user clicks button 'Fermer'")
	@When("user clicks button 'Fermer'")
	@Then("user clicks button 'Fermer'")
	public void user_click_button_close_French() {
		userClicksButtonClose();
	}

	@Then("button 'Close' is displayed")
	public void buttonCloseIsDisplayed() {
		assertTrue(modalDialog.buttonClose.isDisplayed());
	}

	@Then("value of button 'Close' is $value")
	public void valueOfButtonCloseIs(String value) {
		assertEquals(value, modalDialog.buttonClose.getText());
	}

	@Given("user clicked button 'Parcel Register' on Modal Dialog")
	public void clickButtonParcelRegisterOnModalDialog() {
		modalDialog.buttonParcelRegister.click();
	}

	@Step
	public void confirmDeletion() {
		modalDialog.buttonDelete.waitUntilEnabled();
		assertTrue(modalDialog.buttonDelete.isEnabled());
		modalDialog.buttonDelete.click();
		waitLoadingDisappeared();
		// 2nd popup when deletion fails
		if (modalDialog.buttonOK.isVisible()) {
			modalDialog.buttonOK.waitUntilEnabled();
			assertTrue(modalDialog.buttonOK.isEnabled());
			modalDialog.buttonOK.click();
			System.out.println("cleanup deletion failed ");
		}
	}

	@Then("the text of the page level error is: $thePageLevelError")
	public void the_text_of_the_page_level_error_is(String thePageLevelError) {
		assertEquals(thePageLevelError, modalDialog.labelTitle.getText());
	}

	@Step
	public void the_page_level_error_message_on_top_of_edit_page_is(String thePageLevelError) {
		assertEquals(thePageLevelError,
				modalDialog.labelTitle.getText() + System.lineSeparator() + modalDialog.labelSubTitleWithinSpan.getText());
	}

	@Then("the text of the dialog level error is: $theDialogLevelError")
	public void the_dialog_level_error_message_on_top_of_the_dialog_is(String theDialogLevelError) {
		// in subtitle, there is no "\r\n", line change using "\n\n"
		assertEquals(theDialogLevelError, modalDialog.errorMessageTitle.getText() + System.lineSeparator()
				+ modalDialog.errorMessageSubTitle.getText().replace(line_change_in_subtitle, System.lineSeparator()));
	}

	@Then("the text of error message on the dialog is: $errorMessage")
	public void the_error_message_on_the_dialog_is(String errorMessage) {
		assertEquals(errorMessage,
				modalDialog.labelTitle.getText() + System.lineSeparator() + modalDialog.labelSubTitleWithinDiv.getText());
	}

	@Then("modal warning message text including subtitle is: $errorMessage")
	public void the_error_message_on_the_second_dialog_is(String errorMessage) {
		assertEquals(errorMessage,
				modalDialog.labelStrictTitle.getText() + System.lineSeparator() + modalDialog.labelStrictSubTitle.getText());
	}

	@Given("the modal warning message text is: $warningMessage")
	@Then("the modal warning message text is: $warningMessage")
	public void the_modal_warning_message_is(String warningMessage) {
		the_dialog_level_error_message_on_top_of_the_dialog_is(warningMessage);
		waitLoadingDisappeared();
		clickButtonOk();
	}

	@Then("system displays warning with content text: $warningMessage")
	public void the_text_include_the_dialog_all_content_is(String warningMessage) {
		String subTitle = "";
		if (modalDialog.labelSubTitleWithinDiv.isVisible())
			subTitle = System.lineSeparator() + modalDialog.labelSubTitleWithinDiv.getText();
		String heading = "";
		if (modalDialog.labelHeading.isVisible())
			heading = System.lineSeparator() + modalDialog.labelHeading.getText();
		String message = "";
		if (modalDialog.labelMessage.isVisible())
			message = System.lineSeparator() + modalDialog.labelMessage.getText();
		String msgAction = "";
		if (modalDialog.labelMessageAction.isVisible())
			msgAction = System.lineSeparator() + modalDialog.labelMessageAction.getText();
		assertEquals(warningMessage, modalDialog.labelTitle.getText() + subTitle + heading + message + msgAction);
	}

	@Then("system displays warning title with messages: $warningMessage")
	public void the_text_include_the_dialog_all_contents_are(String warningMessage) {
		String subTitle = "";
		// if (modalDialog.labelSubTitleWithinDiv.isPresent())
		// subTitle = System.lineSeparator() +
		// modalDialog.labelSubTitleWithinDiv.getText();
		String heading = "";
		// if (modalDialog.labelHeading.isPresent())
		// heading = System.lineSeparator() + modalDialog.labelHeading.getText();
		String message = "";
		// if (modalDialog.labelMessage.isPresent())
		message = System.lineSeparator() + modalDialog.labelMessageDiv.getText();
		String msgAction = "";
		// if (modalDialog.labelMessageAction.isPresent())
		// msgAction = System.lineSeparator() +
		// modalDialog.labelMessageAction.getText();
		assertEquals(warningMessage, modalDialog.labelTitle.getText() + subTitle + heading + message + msgAction);
	}

	@Then("system displays popup error with content text: $errorMessage")
	public void the_modal_error_message_is(String errorMessage) {
		the_text_include_the_dialog_all_content_is(errorMessage);
		waitLoadingDisappeared();
		clickButtonOk();
	}

	@Given("user clicks button 'Select' on modal dialog")
	@When("user clicks button 'Select' on modal dialog")
	public void click_button_select() {
		modalDialog.buttonSelect.click();
	}

	@Step
	public void user_click_abandon_button() {
		modalDialog.buttonAbandon.click();
	}

	@Step
	public void user_click_view_button() {
		modalDialog.buttonView.click();
	}

	@Given("user clicks button 'Retrieve New'")
	@When("user clicks button 'Retrieve New'")
	public void user_click_retrieve_new_writs_button() {
		if (modalDialog.rootModal.isVisible()) {
			modalDialog.buttonRetrieveNew.click();
			waitLoadingDisappeared();
		}
	}

	@Given("user clicks button 'Nouvelle extraction'")
	@When("user clicks button 'Nouvelle extraction'")
	public void user_click_retrieve_new_writs_button_French() {
		user_click_retrieve_new_writs_button();

	}

	@Given("user clicks button 'Use Previous'")
	@When("user clicks button 'Use Previous'")
	public void user_click_use_previous_writs_button() {
		if (modalDialog.rootModal.isVisible()) {
			modalDialog.buttonUsePrevious.click();
			waitLoadingDisappeared();
		}
	}

	@Given("user clicks button 'Utiliser le précédent'")
	@When("user clicks button 'Utiliser le précédent'")
	public void user_click_use_previous_writs_button_French() {
		user_click_use_previous_writs_button();
	}

	@Given("user clicks button 'Proceed'")
	@When("user clicks button 'Proceed'")
	public void user_click_proceed_button() {
		if (modalDialog.rootModal.isVisible()) {
			modalDialog.buttonProceed.click();
			waitLoadingDisappeared();
		}
	}

	@Step
	public void user_click_register_button() {
		if (modalDialog.rootModal.isVisible()) {
			modalDialog.buttonRegister.click();
			waitLoadingDisappeared();
		}
	}

	@Given("user clicks button 'Oui'")
	public void user_click_processed_button_French() {
		modalDialog.buttonProceed.click();
		waitLoadingDisappeared();
	}

	/**
	 * @return the modalDialog
	 */
	public ModalDialogPage getModalDialog() {
		return modalDialog;
	}

	/**
	 * @param modalDialog
	 *          the modalDialog to set
	 */
	public void setModalDialog(ModalDialogPage modalDialog) {
		this.modalDialog = modalDialog;
	}

	// window modal dialog
	public static boolean isModalDialogShowing() {
		Window[] windows = Window.getWindows();
		if (windows != null) {
			for (Window w : windows) {
				if (w.isShowing() && w instanceof Dialog && ((Dialog) w).isModal())
					return true;
			}
		}
		return false;
	}

	public static String getModalDialogContent() {
		Window[] windows = Window.getWindows();
		if (windows != null) {
			for (Window w : windows) {
				if (w.isShowing() && w instanceof Dialog && ((Dialog) w).isModal())
					return w.getWarningString().trim();
			}
		}
		return "";
	}
}
