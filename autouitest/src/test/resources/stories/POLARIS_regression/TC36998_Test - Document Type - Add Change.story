TC36998_Test - Document Type - Add Change
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36998_Test - Document Type - Add Change

Narrative:
As a user
I want to  add the document type and cancel it

Scenario1: TC36998_Test - Document Type - Add Change

Given LoadTestData UC421_Pre-Submission Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
And user clicks on Change Type button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX1>
And user clicks Cancel button on Presubmission page
Then verify user navigates to main menu
When user navigates to Register 
And user clicks on Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2>
And user clicks on the Change Type button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX3>
And user clicks Cancel button on Presubmission page
And user log out of the application
Examples:
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|PRESUBMISSIONROWINDEX1|PRESUBMISSIONROWINDEX2|PRESUBMISSIONROWINDEX3|
	| LoginInfo      | 1        |PreSubmission         |1                    |2                     |3                     |4                     |
