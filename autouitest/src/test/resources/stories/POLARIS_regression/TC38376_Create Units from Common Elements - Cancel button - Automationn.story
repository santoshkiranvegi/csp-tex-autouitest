TC38376_Create Units from Common Elements - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38376_Create Units from Common Elements - Cancel button

Narrative:
As a user
I want to Cancel the Create Units from Common Elements

Scenario: Cancel the Create Units from Common Elements
Given LoadTestData UC621_Create Units from Common Elements.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to CreateUnits
And user cancels the cancel createunits <CREATUNITSSHEETNAME> and <CREATUNITSROW8>
And user clicks on cancel button on create units from common elements
Then verify user navigates to main menu
When user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | SOURCE1				 | TARGET1				  | SOURCE2 				   | TARGET2     			   | CREATUNITSSHEETNAME | CREATUNITSROW8 |
	| LoginInfo      | 1        | FeesTaxes,RegNumber,2  | FeesTaxes,RegNumber,2  | OpenCondo,BlockNumber,1    | CreateUnits,BlockNumber,8 | CreateUnits         | 8	          |
