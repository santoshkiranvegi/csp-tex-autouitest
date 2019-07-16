TC37741_PIN Entry - Proceed button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37741_PIN Entry - Proceed button Neg

Narrative:
As a user
I want to PIN Entry - Proceed button Neg

Scenario: Scenario 1 PIN Entry - Proceed button Neg
Given LoadTestData UC67_Correct Update Certified Property_Automation Scripts (online).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectUpdateCertifiedProperty
And user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME1> and <PINENTRYROW2>
Then user verify error message <PINENTRYSHEETNAME1> and <PINENTRYROW2>
When user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME2> and <PINENTRYROW3>
Then user verify error message <PINENTRYSHEETNAME2> and <PINENTRYROW3>
When user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME3> and <PINENTRYROW4>
Then user verify error message <PINENTRYSHEETNAME3> and <PINENTRYROW4>
When user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME4> and <PINENTRYROW5>
Then user verify error message <PINENTRYSHEETNAME4> and <PINENTRYROW5>
When user click on the Proceed button on the PIN Entry page <PINENTRYSHEETNAME5> and <PINENTRYROW6>
Then user verify error message <PINENTRYSHEETNAME5> and <PINENTRYROW6>
When user cancels PIN entry
And user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | PINENTRYSHEETNAME1 | PINENTRYROW2 | PINENTRYSHEETNAME2 | PINENTRYROW3 | PINENTRYSHEETNAME3 | PINENTRYROW4 | PINENTRYSHEETNAME4 | PINENTRYROW5 | PINENTRYSHEETNAME5 | PINENTRYROW6 |
 | LoginInfo      | 1 		 | PINEntry   		  | 2 			 | PINEntry			  | 3			 | PINEntry			  | 4			 | PINEntry			  | 5			 | PINEntry			  | 6			 |