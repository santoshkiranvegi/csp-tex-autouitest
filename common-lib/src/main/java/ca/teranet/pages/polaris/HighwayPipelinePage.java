package ca.teranet.pages.polaris;
import ca.teranet.pages.base.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;

public class HighwayPipelinePage extends BasePage {

@FindBy(xpath = "//TEXTAREA[@id='indicesForm.highwayDetails.documentRemarks']")
public WebElementFacade HWYDocRemarks_WebEdit;

@FindBy(xpath = "//TR[6]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/INPUT[2]")
public WebElementFacade MoreHighwayNumbers_WebButton;

@FindBy(xpath = "//DIV[@id='highwayPiplelineContent']/INPUT[6]")
public WebElementFacade MoreHwyMunicipality_WebButton;

@FindBy(xpath = "//TR[6]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/INPUT[2]")
public WebElementFacade MorePlanNumbers_WebButton;

@FindBy(xpath = "//DIV[@id='highwayPiplelineContent']/INPUT[8]")
public WebElementFacade MoreTCPMunicipality_WebButton;

@FindBy(xpath = "//DIV[@id='highwayPiplelineContent']/INPUT[5]")
public WebElementFacade RemoveHwyMunicipality_WebButton;

@FindBy(xpath = "//TR[6]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/INPUT[1]")
public WebElementFacade RemoveHwyNumber_WebButton;

@FindBy(xpath = "//TR[6]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/INPUT[1]")
public WebElementFacade RemovePlanNumber_WebButton;

@FindBy(xpath = "//DIV[@id='highwayPiplelineContent']/INPUT[7]")
public WebElementFacade RemoveTCPMunicipality_WebButton;

@FindBy(xpath = "//INPUT[@id='indicesForm.pipelineDetails.surveyNumber']")
public WebElementFacade SurveryNumber_WebEdit;

@FindBy(xpath = "//TEXTAREA[@id='indicesForm.pipelineDetails.documentRemarks']")
public WebElementFacade TCPLDocRemarks_WebEdit;

}
