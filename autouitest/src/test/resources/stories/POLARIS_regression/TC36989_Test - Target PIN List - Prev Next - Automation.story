TC36989_Test - Target PIN List - Prev Next - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36989_Test - Target PIN List - Prev Next - Automation

Narrative:
As a user
I want to add target pin and verify ui object


Scenario1: TC36989_Test - Target PIN List - Prev Next - Automation

Given LoadTestData UC421_Pre-Submission Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX>
And user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX1>
When user clicks Cancel button on Presubmission page
And user navigates to Register
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROWINDEX1>
And user clicks on the Add PIN button on the PreSubmission page
And user Perform an action on the specified UI object <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX2>
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX2>
When user Perform an action on the specified UI object <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX>
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX>
When user clicks Cancel button on Presubmission page
And user navigates to Register
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROWINDEX1>
And user clicks on the Add PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2>
And user clicks on the Add PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX3>
And user Perform an action on the specified UI object <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX3>
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX3>
And user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX4>
When user Perform an action on the specified UI object <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX4>
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROWINDEX5>
When user clicks Cancel button on Presubmission page
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|UIOBJECTSHEETNAME|UIOBJECTROWINDEX|UIOBJECTSHEETNAME1|UIOBJECTROWINDEX1|PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROWINDEX1|UIOBJECTROWINDEX2|PRESUBMISSIONROWINDEX2|PRESUBMISSIONROWINDEX3|UIOBJECTROWINDEX3|UIOBJECTROWINDEX4|UIOBJECTROWINDEX5|
	| LoginInfo      | 1        | PreSubmission         |    24              | UIObject        |1               |UIObject          |2                |PreSubmission          |25-28        		    |2                |29-32                 |33-36                 |3                |4                |5                 |
