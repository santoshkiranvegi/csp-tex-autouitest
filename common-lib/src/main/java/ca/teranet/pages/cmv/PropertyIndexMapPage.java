package ca.teranet.pages.cmv;

import ca.teranet.pages.base.WebTablePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PropertyIndexMapPage extends WebTablePage {

	String tableParcelXpath = "//table[@id='parcel-info-table']";

	@FindBy(xpath = "//span[@id='mapAreaNode']")
	public WebElementFacade button_mapArea;

	@FindBy(xpath = "//span[@id='mapCentreNode']")
	public WebElementFacade button_mapCenter;

	@FindBy(xpath = "//span[@id='searchByStreetNode']")
	public WebElementFacade button_searhByStreet;

	@FindBy(xpath = "//span[@id='measurementWidgetNode']")
	public WebElementFacade button_measurement;

	@FindBy(xpath = "//span[@id='printMap']")
	public WebElementFacade button_printMap;

	@FindBy(xpath = "//span[@id='cmv.lsw.dropDownButton']")
	public WebElementFacade button_layers;

	@FindBy(xpath = "//span[@id='goToLroMap']")
	public WebElementFacade button_goToLroMap;

	@FindBy(xpath = "//div[@id='map-info-panel-container']/table/tbody/tr[1]")
	public WebElementFacade legend_title;

	@FindBy(xpath = "//div[@id='lro-info-panel']")
	public WebElementFacade map_LRO;

	@FindBy(xpath = "//*[@id='map_graphics_layer']")
	public WebElementFacade map;

	@FindBy(xpath = "//div[@id='map_DynamicLayer']")
	public WebElementFacade map_dynamicLayer;

	@FindBy(xpath = "//div[@id='map_TileLayer']")
	public WebElementFacade map_TileLayer;

	@FindBy(xpath = "//div[@id='keyMap-map_layers']")
	public WebElementFacade map_keyMapLayers;

	public void setParcelTable() {
		this.setTablePath(tableParcelXpath);
	}

	@FindBy(xpath = "//div[@id='printSettingDialog']")
	public WebElementFacade dialog_printMap;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[1]//label[1]//div[1]")
	public WebElementFacade radioButton_Portrait;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[1]//label[2]//div[1]")
	public WebElementFacade radioButton_Landscape;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[2]//label[1]//div[1]")
	public WebElementFacade radioButton_English;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[2]//label[2]//div[1]")
	public WebElementFacade radioButton_French;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[3]//label[1]//div[1]")
	public WebElementFacade radioButton_highlight_yes;

	@FindBy(xpath = "//form[@id='printDialogForm']//fieldset[3]//label[2]//div[1]")
	public WebElementFacade radioButton_highlight_no;

	@FindBy(xpath = "//span[@Id='printButton']")
	public WebElementFacade button_continue_print;

	// Search By Street
	@FindBy(xpath = "//input[@id='streetName']")
	public WebElementFacade input_streetName;

	@FindBy(xpath = "//span[@id='findRoadButton']")
	public WebElementFacade button_findStreets;

	@FindBy(xpath = "//select[@id='selectedRoads']")
	public WebElementFacade selectedRoads;

	@FindBy(xpath = "//table[@id='parcel-info-table']//tr[2]/td[1]")
	public WebElementFacade cell_PIN;

	@FindBy(xpath = "//table[@id='parcel-info-table']//tr[2]/td[2]")
	public WebElementFacade cell_type;

	@FindBy(xpath = "//table[@id='parcel-info-table']//tr[2]/td[3]")
	public WebElementFacade cell_address;

	@FindBy(xpath = "//table[@id='parcel-info-table']//tr[2]/td[4]")
	public WebElementFacade cell_area;

	@FindBy(xpath = "//span[@id='dijit_form_Button_1']")
	public WebElementFacade button_display;

	@FindBy(xpath = "//span[@id='dijit_form_Button_2']")
	public WebElementFacade button_close;

	@FindBy(xpath = "//span[@id='printButton']")
	public WebElementFacade button_print;

	@FindBy(xpath = "//span[@id='cancelButton']")
	public WebElementFacade button_cancel_print;

	@FindBy(xpath = "//input[@id='btn-back']")
	public WebElementFacade button_return;

	@FindBy(xpath = "//input[@id='btn-cancel']")
	public WebElementFacade button_cancel;

	// direct to Map viewer --- only work in IE
	@FindBy(xpath = "//input[@id='btn-get-parcel']")
	public WebElementFacade button_getPropRecord;

	@FindBy(xpath = "//tr[@id='geo-info-menu-item']")
	public WebElementFacade checkbox_geoInfo;

	@FindBy(xpath = "//tr[@id='keymap-menu-item']")
	public WebElementFacade checkbox_kaymap;

}
