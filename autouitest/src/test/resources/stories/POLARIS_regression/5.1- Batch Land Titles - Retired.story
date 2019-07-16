5.1- Batch Land Titles - Retired
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name 5.1- Batch Land Titles - Retired

Narrative:
As a user
I want to Batch Land Titles - Retired

Scenario: Scenario 1 Batch Land Titles - Retired

Given LoadTestData UC51_Record Historical Document Registration_Automation Scripts_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to RecordHistorical
Then verify user navigates to menu Record Historical 
When user click on the Enter Historical Record button on the Pre-submission page in batch mode <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW4>
And user navigate to PINDetails
And user verifies object exists on Document Detail page PINDETAILSDESCRIPTION and <PINDETAILSSHEETNAME> and <PINDETAILSROW>
And user click on Complete Recording button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW4>
And user click on Complete Recording button on the Fees and Taxes page
Then user verifies uiobject exists <UIOBJECTSHEETNAME> and <UIOBJECTROW1>
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | PRESUBMISSIONSHEETNAME1 | PRESUBMISSIONROW4 | PINDETAILSSHEETNAME | PINDETAILSROW | DOCUMENTDETAIL_MAPSHEETNAME1 | DOCUMENTDETAIL_MAPROW4 | UIOBJECTSHEETNAME | UIOBJECTROW1 |
      | LoginInfo      | 1 		  | PreSubmission           | 4  				| PINDetails		  | 1			  | DocumentDetail_Map			 | 4					  | UIObject		  | 1			 |