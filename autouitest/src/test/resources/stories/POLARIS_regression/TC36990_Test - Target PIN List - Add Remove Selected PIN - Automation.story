TC36990_Test - Target PIN List - Add Remove Selected PIN - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36990_Test - Target PIN List - Add Remove Selected PIN - Automation

Narrative:
As a user
I want to  Add and Remove the selected PIN

Scenario1: TC36990_Test - Target PIN List - Add Remove Selected PIN - Automation

Given LoadTestData UC421_Pre-Submission Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register
Then verify user navigates to menu Register
When user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
And user clicks on the Add PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX1>
And user clicks on the Add PIN button on the PreSubmission page
And user clicks on the Remove PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2>
Then user verify Error message of RemovePIN on PresubmissionPage with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2>
When user clicks Cancel button on Presubmission page
And user navigates to Register
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX3>
And user clicks on the Remove PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX4>
And user clicks on the Remove PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX5>
Then user verify Error message of RemovePIN on PresubmissionPage with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX4>
When user clicks Cancel button on Presubmission page
And user navigates to Register
And user clicks on the Add Document button on the PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX6>
And user clicks on the Remove PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX7>
And user clicks on the Remove PIN button on the PreSubmission page with <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX8>
And user clicks Cancel button on Presubmission page
And user log out of the application


Examples:
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|PRESUBMISSIONROWINDEX1|PRESUBMISSIONROWINDEX2|PRESUBMISSIONROWINDEX3|PRESUBMISSIONROWINDEX4|PRESUBMISSIONROWINDEX5|PRESUBMISSIONROWINDEX6|PRESUBMISSIONROWINDEX7|PRESUBMISSIONROWINDEX8|
	| LoginInfo      | 1        |PreSubmission         |5-8                  |9-12                  |13                    | 14-17                |    18                |  19                  |14-17                 |20-21                 |22-23                 |      
