TC38462_Search POA Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38462_Search POA Criteria - Search button Neg

Narrative:
As a user
I want to search for POA Criteria

Scenario: Scenario 1 search for POA Criteria
Given LoadTestData UC31_Search_POA.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchPOA 
And user click on search on SearchPOA <SEARCHSHEETNAME1> and <SEARCHROW5>
Then user verify error message <SEARCHSHEETNAME1> and <SEARCHROW5>
When user click on search on SearchPOA <SEARCHSHEETNAME2> and <SEARCHROW6>
Then user verify error message <SEARCHSHEETNAME2> and <SEARCHROW6>
When user click on search on SearchPOA <SEARCHSHEETNAME3> and <SEARCHROW7> 
Then user verify error no results found <SEARCHSHEETNAME3> and <SEARCHROW7> 
When user click on search on SearchPOA <SEARCHSHEETNAME4> and <SEARCHROW8>
Then user verify error message <SEARCHSHEETNAME4> and <SEARCHROW8>
When user clicks on Ok button on Search page
And user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |SEARCHSHEETNAME1 |SEARCHROW5 |SEARCHSHEETNAME2|SEARCHROW6|SEARCHSHEETNAME3|SEARCHROW7|SEARCHSHEETNAME4|SEARCHROW8| 
    | LoginInfo      | 1        |Search           |5          | Search         |6         | Search         |7         |Search          |8         | 