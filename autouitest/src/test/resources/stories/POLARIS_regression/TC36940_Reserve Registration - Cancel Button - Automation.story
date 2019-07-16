TC36940_Reserve Registration - Cancel Button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36940_Reserve Registration - Cancel Button

Narrative:
As a user
I want to Cancel the Reserve Registration

Scenario: Scenario1 Cancel the Reserve Registration
Given LoadTestData UC411_Reserve Registration Number.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to ReserveRegNumber
And user Cancel Reserve Registration Number <RESERVESHEETNAME> and <RESERVEROW>
Then verify user navigates to main menu
When user navigates to ReserveRegNumber 
And user Cancel the Cancel Reserve Registration Number <RESERVESHEETNAME1> and <RESERVEROW1>
Then verify user navigates to main menu
When user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |RESERVESHEETNAME|RESERVEROW|RESERVESHEETNAME1|RESERVEROW1|
    | LoginInfo      | 1        |Reserve         |1         |Reserve          |1          |