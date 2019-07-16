TC8774_PIN Entry - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC8774_PIN Entry - Cancel button

Narrative:
As a user
I want to PIN Entry - Cancel button

Scenario: Scenario 1 PIN Entry - Cancel button

Given LoadTestData UC67_Correct Update Certified Property_Automation Scripts (online).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectUpdateCertifiedProperty
And user cancels the Cancel correctupdate certified property
And user cancels PIN entry
Then verify user navigates to main menu
When user navigates to CorrectUpdateCertifiedProperty
And user cancels the Cancel correctupdate certified property <PINENTRYSHEETNAME1> and <PINENTRYROW1>
And user cancels PIN entry
Then verify user navigates to main menu
When user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | PINENTRYSHEETNAME1 | PINENTRYROW1 |
 | LoginInfo      | 1 		 | PINEntry   		  | 1 			 | 