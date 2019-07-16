TC37226_Document Detail - Defer
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37226_Document Detail - Defer

Narrative:
As a user
I want to Document to Defer the Document Detail

Scenario: Scenario 1 Document Detail - Defer

Given LoadTestData UC52_Certify Document Registration_Automation Scripts_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to Certify
Then verify user navigates to menu Certify
When user clicks on the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX2>
And user navigates to Parties on Document Detail page
And user enter data for Parties details <PARTIESSHEETNAME> and <PARTIESROW>
And user click on Defer button on Document Detail page to defer a document certification <INTERNALNOTESSHEETNAME> and <INTERNALNOTESROW>
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | SOURCE1 			  | TARGET1 					  | SOURCE2					 | TARGET2							| DOCUMENTSELECTIONSHEETNAME1 | DOCUMENTSELECTIONROWINDEX2 | PARTIESSHEETNAME    | PARTIESROW | INTERNALNOTESSHEETNAME | INTERNALNOTESROW |
      | LoginInfo      | 1 		  | FeesTaxes,RegNumber,1 | DocumentSelection,RegNumber,2 | FeesTaxes,DocumentType,1 | DocumentSelection,DocumentType,2 | DocumentSelection			  |	2					       | Parties			 | 1		  | InternalNotes		   | 1				  |