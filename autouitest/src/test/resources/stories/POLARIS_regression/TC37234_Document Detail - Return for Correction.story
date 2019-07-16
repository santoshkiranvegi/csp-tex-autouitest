TC37234_Document Detail - Return for Correction
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37234_Document Detail - Return for Correction

Narrative:
As a user
I want to navigate to Document Detail and Return for Correction


Scenario: Scenario 1 Document Detail - Return for Correction

Given LoadTestData UC52_Certify Document Registration_Automation Scripts_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to Register
Then verify user navigates to menu Register
When user clicks on Submit button on PreSubmission page <SHEETNAME> and <ROWINDEX2>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTSELECTIONSHEETNAME> and <DOCUMENTSELECTIONROWINDEX1>
And user clicks on Complete Registration button on the Fees and Taxes page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user navigates to Certify
And user clicks on  the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX3>
And user navigate to Parties on Document Detail page
And user enter data for Parties details <PARTIESSHEETNAME1> and <PARTIESROW2>
And user click on Return for Correction button on Document Detail page <INTERNALNOTESSHEEYNAME1> and <INTERNALNOTESROW2>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user navigates to Certify
And user clicks on  the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX4>
And user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | SOURCE1 			   | TARGET1 					  | SOURCE2				 | TARGET2						 | SHEETNAME    | ROWINDEX2  | DOCUMENTSELECTIONSHEETNAME | DOCUMENTSELECTIONROWINDEX1 |FEESTAXESSHEETNAME  |FEESTAXESROWINDEX | SOURCE3   		      | TARGET3 				      | SOURCE4 				 | TARGET4 						    | DOCUMENTSELECTIONSHEETNAME1 | DOCUMENTSELECTIONROWINDEX3 | PARTIESSHEETNAME1 | PARTIESROW2 | INTERNALNOTESSHEEYNAME1 |INTERNALNOTESROW2 | SOURCE5 			   | TARGET5 					  | SOURCE6 				 | TARGET6 						    | DOCUMENTSELECTIONSHEETNAME2 | DOCUMENTSELECTIONROWINDEX4 |
      | LoginInfo      | 1 		  | CreateProperty,Block,1 | PreSubmission,TargetBlock,2  | CreateProperty,PIN,1 | PreSubmission,TargetPINFrom,2 | PreSubmission|	2		 | DocumentDetail_Map		  | 1		 				   | FeesTaxes		    | 2			       |FeesTaxes,RegNumber,2 | DocumentSelection,RegNumber,3 | FeesTaxes,DocumentType,2 | DocumentSelection,DocumentType,3 | DocumentSelection		      | 3					       | Parties		   | 2			 | InternalNotes		   |2				  | FeesTaxes,RegNumber,2 | DocumentSelection,RegNumber,4 | FeesTaxes,DocumentType,2 | DocumentSelection,DocumentType,4 | DocumentSelection		      | 4					       |
      