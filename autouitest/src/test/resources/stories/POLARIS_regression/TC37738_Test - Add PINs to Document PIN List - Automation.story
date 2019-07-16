TC37738_Test - Add PINs to Document PIN List
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37738_Test - Add PINs to Document PIN List

Narrative:
As a user
I want to Add PINs to Document PIN List

Scenario: Scenario 1 Add PINs to Document PIN List

Given LoadTestData UC51_Record Historical Document Registration_Automation Scripts_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to RecordHistorical
Then verify user navigates to menu RecordHistorical
When user click on the Enter Historical Record on the Record Historical Presubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1>
And user click on Add PIN button and verify the page count change on Document Detail page <PRESUBMISSIONSHEETNAME2> and <PRESUBMISSIONROW2>
And user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | PRESUBMISSIONSHEETNAME1 | PRESUBMISSIONROW1 | PRESUBMISSIONSHEETNAME2 | PRESUBMISSIONROW2 |
      | LoginInfo      | 1 		  | PreSubmission           | 2  				| PreSubmission			  | 3				  |