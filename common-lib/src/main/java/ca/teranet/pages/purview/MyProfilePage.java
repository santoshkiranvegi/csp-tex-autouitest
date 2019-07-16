package ca.teranet.pages.purview;

import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyProfilePage extends BasePage {

	// First Name text box
	@FindBy(xpath = "//label[text()='First Name']/../following-sibling::td/span//input")
	public WebElementFacade FirstName_Text_Box;

	// Last Name tex box
	@FindBy(xpath = "//label[text()='Last Name']/../following-sibling::td/span//input")
	public WebElementFacade LastName_Text_Box;

	// Title text box
	@FindBy(xpath = "//label[text()='Title']/../following-sibling::td/span//input")
	public WebElementFacade Title_Text_Box;

	// Email address text box
	@FindBy(xpath = "//label[text()='Email Address']/../following-sibling::td/span//input")
	public WebElementFacade Email_Text_Box;

	// Company text box
	@FindBy(xpath = "//label[text()='Company']/../following-sibling::td/span//input")
	public WebElementFacade Company_Text_Box;

	// Company Website text box
	@FindBy(xpath = "//label[text()='Company Website']/../following-sibling::td/span//input")
	public WebElementFacade CompanyWebsite_Text_Box;

	// Phone Number text box
	@FindBy(xpath = "(//label[text()='Phone Number']/../following-sibling::td/span//input)[1]")
	public WebElementFacade PhoneNumber_Text_Box;

	// user image browser button
	@FindBy(xpath = "//a[@id='userImageUploadButton']")
	public WebElementFacade user_logo_browse_btn;

	// Company Image browser button
	@FindBy(xpath = "//a[@id='companyLogoUploadButton']")
	public WebElementFacade company_logo_browse_btn;

	// Fax text box
	@FindBy(xpath = "//label[text()='Fax Number']/../following-sibling::td/span//input")
	public WebElementFacade FaxNumber_Text_Box;

	// Address 1 text box
	@FindBy(xpath = "(//label[text()='Address 1']/../following-sibling::td/span//input)[1]")
	public WebElementFacade Address1_Text_Box;

	// Address 2 text box
	@FindBy(xpath = "(//label[text()='Address 2']/../following-sibling::td/span//input)[2]")
	public WebElementFacade Address2_Text_Box;

	// City text box
	@FindBy(xpath = "//label[text()='City']/../following-sibling::td/span//input")
	public WebElementFacade City_Text_Box;

	// Province text box
	@FindBy(xpath = "//label[text()='Province']/../following-sibling::td/span//input")
	public WebElementFacade Province_Text_Box;

	// Postal code text box
	@FindBy(xpath = "//label[text()='Postal Code']/../following-sibling::td/span//input")
	public WebElementFacade PostalCode_Text_Box;

	// Top of report Radio button
	@FindBy(xpath = "//span[@class='nameCardPositionRadioButton']/label/b[text()='Top']/../../input")
	public WebElementFacade Topofreport_radio_btn;

	// Bottom of report Radio button
	@FindBy(xpath = "//span[@class='nameCardPositionRadioButton']/label/b[text()='Bottom']/../../input")
	public WebElementFacade Bottomofreport_radio_btn;

	// Top and Bottom of report Radio button
	@FindBy(xpath = "//span[@class='nameCardPositionRadioButton']/label/b[text()='Top and Bottom']/../../input")
	public WebElementFacade TopAndBottomofreport_radio_btn;

	// No Personalization of report Radio button
	@FindBy(xpath = "//span[@class='nameCardPositionRadioButton']/label/b[text()='No Personalization']/../../input")
	public WebElementFacade NoPersonalization_radio_btn;

	// Save button
	@FindBy(xpath = "//a[@id='saveButton1']")
	public WebElementFacade Save_btn;

	// Company or User Logo save button
	@FindBy(xpath = "//a[@id='saveButton2']")
	public WebElementFacade image_Save_btn;

	// Reset button
	@FindBy(xpath = "//a[@id='resetButton1']")
	public WebElementFacade Reset_btn;

	// profile update message
	@FindBy(xpath = "//div[@id='userProfileSaveSuccessPanelDiv']/div[@class='saveSuccessPanel']")
	public WebElementFacade Profile_Update_Message;

	// user image update message
	@FindBy(xpath = "//div[@id='userImageSaveSuccessPanelDiv']/div")
	public WebElementFacade UserImage_Update_Message;

	// company image update message
	@FindBy(xpath = "//div[@id='companyLogoSaveSuccessPanelDiv']/div")
	public WebElementFacade CompanyImage_Update_Message;

	// user image remove button
	@FindBy(xpath = "//a[@id='removeUserImageButton']")
	public WebElementFacade remove_user_image;

	// Company image remove button
	@FindBy(xpath = "//a[@id='removeCompanyLogoButton']")
	public WebElementFacade remove_company_image;

}
