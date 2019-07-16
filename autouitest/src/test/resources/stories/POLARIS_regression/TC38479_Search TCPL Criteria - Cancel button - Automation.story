TC38479_Search_TCPL_Criteria_Cancel_button_AF
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38479_Search_TCPL_Criteria_Cancel_button_AF

Narrative:
As a user
I want to Search TCPL Criteria  and  click on Cancel button

Scenario1: TC38479_Search_TCPL_Criteria_Cancel_button_AF

Given LoadTestData UC31_Search_TCPL.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchTCPL 
And user search Cancel button on TransCanada Pipeline
And user search OK button on TransCanada Pipeline
Then user verify user navigates to main menu
When user navigates to SearchTCPL 
And user search Cancel button on TransCanada Pipeline <SEARCHSHEETNAME> and <SEARCHROW1>
And user search OK button on TransCanada Pipeline <SEARCHSHEETNAME> and <SEARCHROW2>
Then user verify user navigates to main menu
When user log out of the application
Examples:
	| LOGINSHEETNAME | LOGINROW |SEARCHSHEETNAME|SEARCHROW1|SEARCHROW2|
	| LoginInfo      | 1 	    |Search         |1         |2         |