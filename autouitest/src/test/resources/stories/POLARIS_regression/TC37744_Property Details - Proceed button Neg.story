TC37744_Property Details - Proceed button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37744_Property Details - Proceed button Neg

Narrative:
As a user
I want to Proceed to Property Details

Scenario: Scenario 1 Proceed to Property Details
Given LoadTestData UC67_Correct Update Certified Property_Automation Scripts (online).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectUpdateCertifiedProperty
And user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME1> and <PINENTRYROW9>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
Then user verify error message <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
When user click on the OK button on the popup
Then verify user navigates to main menu
When user navigates to CorrectUpdateCertifiedProperty
And user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME1> and <PINENTRYROW9>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
Then user verify error message <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
When user click on the OK button on the popup
And user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | PINENTRYSHEETNAME1 | PINENTRYROW9 | PROPERTYDETAIL_MAPSHEETNAME1 | PROPERTYDETAIL_MAPROW1 | PROPERTYDETAIL_MAPSHEETNAME2 | PROPERTYDETAIL_MAPROW2 |
 | LoginInfo      | 1 		 | PINEntry   		  | 9 			 | PropertyDetail_Map 			| 1						 | PropertyDetail_Map 		    | 2						 |