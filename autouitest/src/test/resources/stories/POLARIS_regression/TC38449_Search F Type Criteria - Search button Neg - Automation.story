TC38449_Search F Type Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38449_Search F Type Criteria - Search button Neg

Narrative:
As a user
I want to Search F Type Criteria

Scenario: Scenario1 Search F Type Criteria
Given LoadTestData UC31_Search_FType.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchFType 
And user click on search on SearchFType <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user click on search on SearchFType <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
And user click on search on SearchFType <SEARCHSHEETNAME3> and <SEARCHROWINDEX3>
And user click on search on SearchFType <SEARCHSHEETNAME4> and <SEARCHROWINDEX4>
And user clicks on Cancel_OK on SearchFType
Then verify user navigates to main menu
And user log out of the application



Examples:
	| LOGINSHEETNAME  |  LOGINROW  | SEARCHSHEETNAME1 | SEARCHROWINDEX1 | SEARCHSHEETNAME2 | SEARCHROWINDEX2 | SEARCHSHEETNAME3  | SEARCHROWINDEX3 | SEARCHSHEETNAME4 | SEARCHROWINDEX4 |
	| LoginInfo       |1           |  Search          | 5               | Search           |6                |Search             |7                |Search            |8                |
	
	
	
	