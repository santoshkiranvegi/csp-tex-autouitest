TC36968_Test - Add PINs to Document PIN List - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36968_Test - Add PINs to Document PIN List - Automation

Narrative:
As a user
I want to  add PINs to Document PIN List

Background:

Scenario: Scenario1 TC36968_Test - Add PINs to Document PIN List - Automation

Given LoadTestData UC421_Document Detail Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROW6>  
Then user verify uiobject exist Highways Register and <UIOBJECTSHEETNAME> and <UIOBJECTROW2>
And user verify uiobject exist TransCanada Pipeline and <UIOBJECTSHEETNAME1> and <UIOBJECTROW6> 
When user Cancel document registration on the Document Detail page
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW9> 
And user clicks on Add PIN button and verify the page count change on Document Detail page <PRESUBMISSIONSHEETNAME2> and <PRESUBMISSIONROW11>
Then user verifies the existance of Checkboxes in PIN list section on Document Detail page
When user Cancel document registration on the Document Detail page
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME3> and <PRESUBMISSIONROW12> 
And user click on PIN in PIN list and verify the header on Document Detail page <PRESUBMISSIONSHEETNAME4> and <PRESUBMISSIONROW12>
And user click on PIN in PIN list and verify the header on Document Detail page <PRESUBMISSIONSHEETNAME5> and <PRESUBMISSIONROW13>
And user Cancel document registration on the Document Detail page
And user log out of the application


Examples:
	
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROW6  |UIOBJECTSHEETNAME|UIOBJECTROW2|UIOBJECTSHEETNAME1|UIOBJECTROW6 |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW9	|PRESUBMISSIONSHEETNAME2|PRESUBMISSIONROW11 |PRESUBMISSIONSHEETNAME3|PRESUBMISSIONROW12 |PRESUBMISSIONSHEETNAME4|PRESUBMISSIONROW12|PRESUBMISSIONSHEETNAME5|PRESUBMISSIONROW13|
	| LoginInfo      | 1        |PreSubmission         |6-8                |UIObject         |2           |UIObject          |6            |PreSubmission          |9-10                |PreSubmission          |11                 |PreSubmission          |12-13              |PreSubmission          |12                |PreSubmission          |13                |
	
