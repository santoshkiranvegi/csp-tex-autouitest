TC38486_Search By Name_Address Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38486_Search By Name_Address Criteria - Cancel button

Narrative:
As a user
I want to search by name or address criteria and cancel it.

Scenario: Scenario1 I want to search by name or address criteria and cancel it.
Given LoadTestData UC31_Search_NameAddress.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchNameAddress
And user clicks on Cancel button on Search page
And user clicks on Ok button on Search page
And user navigates to SearchNameAddress
And user clicks on Cancel button on Search page <ADDRESSPAGESHEETNAME> and <ADDRESSPAGEROW>
Then verify user navigates to main menu
When user clicks on Ok button on Search page <ADDRESSPAGESHEETNAME> and <ADDRESSPAGEROW>
Then verify user navigates to main menu
When user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | ADDRESSPAGESHEETNAME | ADDRESSPAGEROW |
	| LoginInfo      | 1        | Search               | 1              |
