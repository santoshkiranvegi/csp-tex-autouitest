TC10135_Registration Number - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC10135_Registration Number - Cancel button

Narrative:
As a user
I want to verify cancel button functionality during registration

Scenario: Scenario1 I want to verify cancel button functionality during registration
Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectCertifiedDocument 
And user cancels the Cancel document selection
And user cancels the Document Selection
And user navigates to CorrectCertifiedDocument 
And user cancels the Cancel document selection <DOCUMENTSECTIONSHEETNAME> and <DOCUMENTSECTIONROW1>
Then verify user navigates to main menu
When user cancels the Document Selection <DOCUMENTSECTIONSHEETNAME> and <DOCUMENTSECTIONROW1>
Then verify user navigates to main menu
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | DOCUMENTSECTIONSHEETNAME | DOCUMENTSECTIONROW1 |
	| LoginInfo      | 1        | DocumentSelection        | 1                   |
