TC37164_Document Selection - Proceed to Certification Button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37164_Document Selection - Proceed to Certification Button Pos
Certify.DocumentSelection.ProceedToCertification
Narrative:
As a user
I want to Proceed to Certification Button Pos

Scenario: Scenario 1 Proceed to Certification Button Pos
Given LoadTestData UC52_Certify Document Registration_Automation Scripts_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Certify
And user cancels un defer popup when proceed to certification button is clicked for deferred document <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROW2>
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROW2>
And user click on defer button on document detail to defer a document certification <INTERNALNOTESSHEETNAME> and <INTERNALNOTESROW>
And user navigates to Certify
And user cancels un defer popup when proceed to certification button is clicked for deferred document <DOCUMENTSELECTIONSHEETNAME3> and <DOCUMENTSELECTIONROW3>
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME3> and <DOCUMENTSELECTIONROW3>
And user click on defer button on document detail to defer a document certification <INTERNALNOTESSHEETNAME> and <INTERNALNOTESROW>
And user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME4> and <DOCUMENTSELECTIONROW4>
And user Cancel document registration on the Document Detail page
Then verify user navigates to main menu
When user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME5> and <DOCUMENTSELECTIONROW5>
And user Cancel document registration on the Document Detail page
Then verify user navigates to main menu
When user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME6> and <DOCUMENTSELECTIONROW6>
And user Cancel document registration on the Document Detail page
Then verify user navigates to main menu
When user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME7> and <DOCUMENTSELECTIONROW7>
And user Cancel document registration on the Document Detail page
Then verify user navigates to main menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | DOCUMENTSELECTIONSHEETNAME2 | DOCUMENTSELECTIONROW2 | INTERNALNOTESSHEETNAME | INTERNALNOTESROW | DOCUMENTSELECTIONSHEETNAME3 | DOCUMENTSELECTIONROW3 | DOCUMENTSELECTIONSHEETNAME4 | DOCUMENTSELECTIONROW4 | DOCUMENTSELECTIONSHEETNAME5 | DOCUMENTSELECTIONROW5 | DOCUMENTSELECTIONSHEETNAME6 | DOCUMENTSELECTIONROW6 | DOCUMENTSELECTIONSHEETNAME7 | DOCUMENTSELECTIONROW7 |
      | LoginInfo      | 1        | DocumentSelection 			| 2 					| InternalNotes 		 | 1 				| DocumentSelection 		  | 3 					  | DocumentSelection 			| 4 					| DocumentSelection 		  | 5 					  | DocumentSelection 			| 6 					| DocumentSelection 		  | 7 					  |
      
      