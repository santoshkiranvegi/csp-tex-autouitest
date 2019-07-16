TC37677_Document Details - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37677_Document Details - Cancel button - Automation

Narrative:
As a user
I want to  add the document details and cancel it

Scenario1: TC37677_Document Details - Cancel button

Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CreatePropertySHEETNAME> and <CreatePropertyROWINDEX> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE> and <SERVICECOPYCOLUMNTARGET1>  
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user click on ParcelConfirmation to create Certify strFunction and <CreatePropertySHEETNAME> and <CreatePropertyROWINDEX> 
And user clicks on Close button on propertymapmaintenanceRequest page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE2> and <SERVICECOPYCOLUMNTARGET2>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
And user clicks on Proceed with Receipt button on DocumentDetail page
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX1>
And user navigates to Certify 
And user clicks on Proceed To Certification in Certify page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user clicks on Certify button on Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks the Proceed button on the Document Selection page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user click on Cancel on the Cancel popup on Document Detail page
And user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument  
And user clicks the Proceed button on the Document Selection page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user click on Cancel on the Cancel popup on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROWINDEX>
And user clicks DocumentData tab in documentdetail page
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX>  
When user click on Cancel on the Cancel popup on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROWINDEX1>
And user clicks DocumentData tab in documentdetail page
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX1>
When user Cancel document registration on the Document Detail page
And user log out of the application


Examples:
	| LOGINSHEETNAME | LOGINROW |CreatePropertySHEETNAME|CreatePropertyROWINDEX| SERVICECOPYCOLUMNSOURCE |SERVICECOPYCOLUMNTARGET1   |PROPERTYDETAILSHEETNAME|PROPERTYDETAILROWINDEX|SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1   | SERVICECOPYCOLUMNSOURCE2 |SERVICECOPYCOLUMNTARGET2     |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|FEESTAXESSHEETNAME|FEESTAXESROWINDEX |DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROWINDEX|DOCUMENTDETAILROWINDEX1 |UIOBJECTSHEETNAME|UIOBJECTROWINDEX|UIOBJECTROWINDEX1|FEESTAXESROWINDEX1|
	|  LoginInfo     | 1 		|   CreateProperty      | 1                    |CreateProperty,Block,1   |PropertyDetail_Map,Block,1 |PropertyDetail_Map     | 1                    |CreateProperty,Block,1  |PreSubmission,TargetBlock,1|CreateProperty,PIN,1      |PreSubmission,TargetPINFrom,1|PreSubmission         |1                    |FeesTaxes         |1                 |DocumentDetail_Map     |1                     |2                       |UIObject         |  1             |2                |8                 |
