TC38448_Search F Type Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38448_Search F Type Criteria - Cancel button

Narrative:
As a user
I want to Search F Type Criteria 

Scenario: Scenario1 Search F Type Criteria
Given LoadTestData UC31_Search_FType.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchFType
And user clicks on Cancel on SearchFType
And user clicks on Cancel on SearchFType <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user clicks on Cancel on SearchFType <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
And user navigates to SearchFType
And user clicks on Cancel on SearchFType
And user navigates to SearchFType
And user clicks on Cancel_OK on SearchFType <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user navigates to SearchFType
And user clicks on Cancel_OK on SearchFType <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
Then verify user navigates to main menu
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | SEARCHSHEETNAME1 | SEARCHROWINDEX1| SEARCHSHEETNAME2 | SEARCHROWINDEX2 |
	| LoginInfo      | 1        | Search           | 1              | Search           | 2               |