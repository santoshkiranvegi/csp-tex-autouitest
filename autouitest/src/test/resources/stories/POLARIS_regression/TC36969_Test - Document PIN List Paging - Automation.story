TC36969_Test - Document PIN List Paging - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36969_Test - Document PIN List Paging - Automation

Narrative:
As a user
I want to test document PIN List Paging

Scenario: Scenario1 TC36969_Test - Document PIN List Paging - Automation

Given LoadTestData UC421_Document Detail Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW21> 
Then user verifies the UI object properties Go to Page and <UIOBJECTSHEETNAME> and <UIOBJECTROW10> 
And user verifies the UI object properties PageValue and <UIOBJECTSHEETNAME1> and <UIOBJECTROW11>  
When user navigating to specific page in PIN List section on Document Detail page Next and >>
And user navigating to specific page in PIN List section on Document Detail page First and |<
And user navigating to specific page in PIN List section on Document Detail page Last and >|
And user navigating to specific page in PIN List section on Document Detail page Previous and <<
And user enter page number and click Go to Page button on Document Detail page <PAGINGSHEETNAME> and <PAGINGROW1> 
And user enter page number and click Go to Page button on Document Detail page <PAGINGSHEETNAME1> and <PAGINGROW2> 
And user enter page number and click Go to Page button on Document Detail page <PAGINGSHEETNAME2> and <PAGINGROW3> 
And user navigating to specific page in PIN List section on Document Detail page First and |< 
Then user verifies the UI object properties |< and <UIOBJECTSHEETNAME2> and <UIOBJECTROW12> 
And user verifies the UI object properties << and <UIOBJECTSHEETNAME3> and <UIOBJECTROW13>
When user navigating to specific page in PIN List section on Document Detail page Last and >| 
Then user verifies the UI object properties >| and <UIOBJECTSHEETNAME4> and <UIOBJECTROW14> 
And user verifies the UI object properties >> and <UIOBJECTSHEETNAME5> and <UIOBJECTROW15> 
When user enter page number and click Go to Page button on Document Detail page <PAGINGSHEETNAME3> and <PAGINGROW4> 
And user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW21|UIOBJECTSHEETNAME|UIOBJECTROW10   |UIOBJECTSHEETNAME1|UIOBJECTROW11 |PAGINGSHEETNAME|PAGINGROW1 |PAGINGSHEETNAME1|PAGINGROW2   |PAGINGSHEETNAME2|PAGINGROW3|UIOBJECTSHEETNAME2|UIOBJECTROW12 |UIOBJECTSHEETNAME3|UIOBJECTROW13|UIOBJECTSHEETNAME4|UIOBJECTROW14|UIOBJECTSHEETNAME5|UIOBJECTROW15|PAGINGSHEETNAME3|PAGINGROW4|
	| LoginInfo      | 1        |PreSubmission          |21                |UIObject         |10              |UIObject          |11            |Paging         |1          |Paging          |2            |Paging          |3         |UIObject          |12            |UIObject          |13           |UIObject          |14           |UIObject          |15           |Paging          |4         |
