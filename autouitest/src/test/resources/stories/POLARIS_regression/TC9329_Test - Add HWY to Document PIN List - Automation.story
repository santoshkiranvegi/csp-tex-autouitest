TC9329_Test - Add HWY to Document PIN List
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9329_Test - Add HWY to Document PIN List

Narrative:
As a user
I want to add HWY to Document PIN List 

Scenario: Scenario 1 Add HWY to Document PIN List - Automation

Given LoadTestData UC421_Document Detail Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1> 
Then user verifies the UI object properties Add HWY and <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
And user verify uiobject not exist Highways Register and <UIOBJECTSHEETNAME2> and <UIOBJECTROW2>
When user Cancel document registration on the Document Detail page
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME2> and <PRESUBMISSIONROW2> 
Then user verifies the UI object properties Add HWY and <UIOBJECTSHEETNAME3> and <UIOBJECTROW4>
When user perform action on the specified UI object Add HWY and <UIOBJECTSHEETNAME3> and <UIOBJECTROW4>
Then user verifies the UI object properties Add HWY and <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
And user verify uiobject exist Highways Register and <UIOBJECTSHEETNAME2> and <UIOBJECTROW2>
When user Cancel document registration on the Document Detail page
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME3> and <PRESUBMISSIONROW3> 
And user perform action on the specified UI object Add HWY and <UIOBJECTSHEETNAME4> and <UIOBJECTROW5>
And user Cancel document registration on the Document Detail page
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME4> and <PRESUBMISSIONROW4>
And user click on Add HWY or Add TCPipeline button and verify the PIN added to related sections ADDHWY
And user Cancel document registration on the Document Detail page
Then user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW1|UIOBJECTSHEETNAME1|UIOBJECTROW1 |UIOBJECTSHEETNAME2|UIOBJECTROW2|PRESUBMISSIONSHEETNAME2|PRESUBMISSIONROW2|UIOBJECTSHEETNAME3|UIOBJECTROW4|PRESUBMISSIONSHEETNAME3|PRESUBMISSIONROW3|UIOBJECTSHEETNAME4|UIOBJECTROW5|PRESUBMISSIONSHEETNAME4|PRESUBMISSIONROW4|
	| LoginInfo      | 1        |PreSubmission          |1                | UIObject         |1            |UIObject          |2           |PreSubmission          |2                | UIObject         |4           |PreSubmission          |3                |UIObject          |5           |PreSubmission          |4-5              |
