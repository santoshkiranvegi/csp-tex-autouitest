TC37698_Document Detail - Image Button Neg - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37698_Document Detail - Image Button Neg - Automation

Narrative:
As a user
I want to cancel document registration on the Document Detail page 


Scenario: TC37698_Document Detail - Image Button Neg - Automation
 
Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_03.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectCertifiedDocument
And user clicks on the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME13> and <DOCUMENTSELECTIONROWINDEX13>
And user clicks Image button on Document Detail page
Then user verifies error message on documents details page
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument
And user clicks on the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME14> and <DOCUMENTSELECTIONROWINDEX14>
And user clicks Image button on Document Detail page
Then user verifies error message on documents details page
When user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
	| LOGINSHEETNAME  | LOGINROW | DOCUMENTSELECTIONSHEETNAME13 | DOCUMENTSELECTIONROWINDEX13 | DOCUMENTSELECTIONSHEETNAME14 | DOCUMENTSELECTIONROWINDEX14 |
	| LoginInfo       | 1        | DocumentSelection            | 13                          | DocumentSelection            | 14                          |
	
	
	
	
