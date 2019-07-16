TC38453_Search HWY Criteria - Cancel button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38453_Search HWY Criteria - Cancel button - Automation

Narrative:
As a user
I want to  search HWY criteria and cancel it


Scenario1: TC38453_Search HWY Criteria - Cancel button - Automation

Given LoadTestData UC31_Search_HWY.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SEARCHHIGHWAYSREGISTER
And user search Cancel button on TransCanada Pipeline
And user search OK button on TransCanada Pipeline
Then verify user navigates to main menu
When user navigates to SEARCHHIGHWAYSREGISTER
And user search Cancel button on TransCanada Pipeline <HWYSHEETNAME> and <HWTROWINDEX>
And user search OK button on TransCanada Pipeline
Then verify user navigates to main menu
When user navigates to SEARCHHIGHWAYSREGISTER
And user click on OK button on TransCanada Pipeline <HWYSHEETNAME> and <HWTROWINDEX1>
Then verify user navigates to main menu
When user navigates to SEARCHHIGHWAYSREGISTER
And user search Cancel button on TransCanada Pipeline <HWYSHEETNAME> and <HWTROWINDEX2>
And user search OK button on TransCanada Pipeline
Then verify user navigates to main menu
When user navigates to SEARCHHIGHWAYSREGISTER
And user click on OK button on TransCanada Pipeline <HWYSHEETNAME> and <HWTROWINDEX3>
And user log out of the application


Examples:
	| LOGINSHEETNAME | LOGINROW |HWYSHEETNAME|HWTROWINDEX|HWTROWINDEX1|HWTROWINDEX2|HWTROWINDEX3|
	| LoginInfo      | 1        |Search      |1          |2           |  3         |4           |
