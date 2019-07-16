TC37735_Document Detail - Complete Recording Net and Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37735_Document Detail - Complete Recording Net and Pos

Narrative:
As a user
I want to Complete Recording Net and Pos


Given LoadTestData UC51_Record Historical Document Registration_Automation Scripts_Online.xlsx


Scenario: Scenario 1 Complete Recording Net and Pos

Given LoadTestData UC51_Record Historical Document Registration_Automation Scripts_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to RecordHistorical
And user click on the Enter Historical Record on the Record Historical Presubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1>
And user click on Complete Recording button on Document Detail page with <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
Then user verify Error message on DocumentDetail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
When user navigate to pindetails on Document Detail page
Then user verifies PINDetailsDescription exists on Document Detail page <PINDETAILSSHEETNAME> and <PINDETAILSROW>
When user click on Complete Recording button on Document Detail page with <DOCUMENTDETAIL_MAPSHEETNAME2> and <DOCUMENTDETAIL_MAPROW2>
Then user verify Error message on DocumentDetail page <DOCUMENTDETAIL_MAPSHEETNAME2> and <DOCUMENTDETAIL_MAPROW2>
When user click on Complete Recording button on Document Detail page with <DOCUMENTDETAIL_MAPSHEETNAME3> and <DOCUMENTDETAIL_MAPROW3>
Then user verify Error message on DocumentDetail page <DOCUMENTDETAIL_MAPSHEETNAME3> and <DOCUMENTDETAIL_MAPROW3>
When user click on Cancel Recording button on the Fees and Taxes page
And user click on Return to Document Details button on Fees and Taxes page
And user click on Complete Recording button on Document Detail page without data
And user click on Complete Recording button on the Fees and Taxes page without data
And user click on the document number link on the Recording Historical Results Confirmation page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1>
And user clicks on Close in Document Detail popup
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | PRESUBMISSIONSHEETNAME1 | DOCUMENTSELECTIONROW1 | DOCUMENTDETAIL_MAPSHEETNAME1 | PRESUBMISSIONROW1 | PINDETAILSSHEETNAME | PINDETAILSROW | DOCUMENTDETAIL_MAPSHEETNAME2 | DOCUMENTDETAIL_MAPROW2 | DOCUMENTDETAIL_MAPSHEETNAME3 | DOCUMENTDETAIL_MAPROW3 |DOCUMENTDETAIL_MAPROW1|
      | LoginInfo      | 1 		  | PreSubmission           | 1  				    | DocumentDetail_Map		   | 1				   | PINDetails		     | 1			 | DocumentDetail_Map			| 2						 | DocumentDetail_Map			| 3						 |1                     |
      