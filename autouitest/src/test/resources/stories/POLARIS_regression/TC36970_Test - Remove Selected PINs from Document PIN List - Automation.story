TC36970_Test - Remove Selected PINs from Document PIN List
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36970_Test - Remove Selected PINs from Document PIN List

Narrative:
As a user
I want to remove selected PINs from document PIN list

Scenario: Scenario1 I want to remove selected PINs from document PIN list
Given LoadTestData UC421_Document Detail Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register  
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME19> and <PRESUBMISSIONROW19>
And user clicks Remove PIN(s) button on Document Detail page <REMOVEPINSHEETNAME1> and <REMOVEPINROW1>
And user Cancel document registration on the Document Detail page
And user navigates to Register
Then verify user navigates to menu Register
When user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME20> and <PRESUBMISSIONROW20>
And user clicks Remove PIN(s) button on Document Detail page <REMOVEPINSHEETNAME2> and <REMOVEPINROW2>
And user Cancel document registration on the Document Detail page
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME19> and <PRESUBMISSIONROW19>
And user clicks Remove PIN(s) button on Document Detail page <REMOVEPINSHEETNAME1> and <REMOVEPINROW1>
And user clicks Remove PIN(s) button on Document Detail page <REMOVEPINSHEETNAME3> and <REMOVEPINROW3>
And user Cancel document registration on the Document Detail page
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME20> and <PRESUBMISSIONROW20>
And user clicks Remove PIN(s) button on Document Detail page <REMOVEPINSHEETNAME4> and <REMOVEPINROW4> 
And user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW | PRESUBMISSIONSHEETNAME19 | PRESUBMISSIONROW19 | REMOVEPINSHEETNAME1 | REMOVEPINROW1 | PRESUBMISSIONSHEETNAME20 | PRESUBMISSIONROW20 | REMOVEPINSHEETNAME2 | REMOVEPINROW2 | REMOVEPINSHEETNAME3 | REMOVEPINROW3 | REMOVEPINSHEETNAME4 | REMOVEPINROW4 | 
	| LoginInfo      | 1        | PreSubmission            | 19                 | RemovePIN           | 1             | PreSubmission            | 20                 | RemovePIN           | 2             | RemovePIN           | 3             | RemovePIN           | 4             |  
	