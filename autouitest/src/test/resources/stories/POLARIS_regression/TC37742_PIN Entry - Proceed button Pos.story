TC37742_PIN Entry - Proceed button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37742_PIN Entry - Proceed button Pos

Narrative:
As a user
I want to PIN Entry - Proceed button Pos

Scenario: Scenario 1 PIN Entry - Proceed button Pos
Given LoadTestData UC67_Correct Update Certified Property_Automation Scripts (online).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectUpdateCertifiedProperty
And user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME1> and <PINENTRYROW7>
And user click on the OK button on the popup
Then verify user navigates to main menu
When user navigates to CorrectUpdateCertifiedProperty
And user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME2> and <PINENTRYROW8>
And user click on the OK button on the popup
And user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | PINENTRYSHEETNAME1 | PINENTRYROW7 | PINENTRYSHEETNAME2 | PINENTRYROW8 |
 | LoginInfo      | 1 		 | PINEntry   		  | 7 			 | PINEntry			  | 8			 |