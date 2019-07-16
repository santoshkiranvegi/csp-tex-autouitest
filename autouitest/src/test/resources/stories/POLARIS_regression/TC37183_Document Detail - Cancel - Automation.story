TC37183_Document Detail - Cancel
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37183_Document Detail - Cancel

Narrative:
As a user
I want to Document Detail - Cancel

Scenario: Scenario 1 Document Detail - Cancel

Given LoadTestData UC52_Certify Document Registration_Automation Scripts_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on ParcelConfirmation to create Certify CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user clicks on Close button on propertymapmaintenanceRequest page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEETAXESSHEETNAME1> and <FEETAXESROW1>
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROW1>
And user click on Cancel on the Cancel popup on Document Detail page
And user Cancel document registration on the Document Detail page
And user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROW1>
And user click on Cancel on the Cancel popup on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME2> and <DOCUMENTDETAIL_MAPROW2>
Then user verify the UI object properties <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
When user cancels document registration on the Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME3> and <DOCUMENTDETAIL_MAPROW3>
And user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROW1>
And user navigate to DocumentData
Then user verify the UI object properties <UIOBJECTSHEETNAME2> and <UIOBJECTROW2>
When user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1 | CREATEPROPERTYROW1 | SOURCE1 			  |TARGET1 					  | PROPERTYDETAIL_MAPSHEETNAME1 | PROPERTYDETAIL_MAPROW1 |CREATEPROPERTYSHEETNAME1 |CREATEPROPERTYROW1| SOURCE2			  | TARGET2					   |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW1|DOCUMENTDETAIL_MAPSHEETNAME1|DOCUMENTDETAIL_MAPROW1|FEETAXESSHEETNAME1 |FEETAXESROW1| SOURCE4 			  |TARGET4						|SOURCE5 			     |TARGET5  						  | DOCUMENTSELECTIONSHEETNAME1 | DOCUMENTSELECTIONROW1|DOCUMENTSELECTIONSHEETNAME1 | DOCUMENTSELECTIONROW1|DOCUMENTDETAIL_MAPSHEETNAME2|DOCUMENTDETAIL_MAPROW2|UIOBJECTSHEETNAME1|UIOBJECTROW1|DOCUMENTDETAIL_MAPSHEETNAME3|DOCUMENTDETAIL_MAPROW3|DOCUMENTSELECTIONSHEETNAME1|DOCUMENTSELECTIONROW1|UIOBJECTSHEETNAME2|UIOBJECTROW2|
      | LoginInfo      | 1 		  | CreateProperty			 | 1				  | CreateProperty,Block,1| PropertyDetail_Map,Block,1|PropertyDetail_Map			 | 1					  |CreateProperty			| 1				   |CreateProperty,Block,1| PreSubmission,TargetBlock,1|PreSubmission		   |1                |DocumentDetail_Map		  |1					 |FeesTaxes		     | 1		  |FeesTaxes,RegNumber,4  |DocumentSelection,RegNumber,1|FeesTaxes,DocumentType,1|DocumentSelection,DocumentType,1| DocumentSelection			| 1					   |DocumentSelection		    |1					   |DocumentDetail_Map			| 2					   |UIObject		  |1		   |DocumentDetail_Map			| 3					   |DocumentSelection		   |1	 				 |UIObject		    |2		     |
      
