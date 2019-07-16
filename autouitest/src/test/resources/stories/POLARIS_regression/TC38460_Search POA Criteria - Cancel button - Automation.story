TC38460_Search POA Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38460_Search POA Criteria - Cancel button

Narrative:
As a user
I want to cancel the Search POA Criteria 

Scenario: Scenario 1 cancel the Search POA Criteria
Given LoadTestData UC31_Search_POA.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchPOA 
Then verify user navigates to search poa menu
When user clicks on Cancel button on Search page
And user clicks on Cancel button on Search POA page <SEARCHSHEETNAME1> and <SEARCHROW1>
And user clicks on Cancel button on Search POA page <SEARCHSHEETNAME2> and <SEARCHROW2>
And user navigates to SearchPOA 
And user clicks on Ok button on Search page
And user navigates to SearchPOA
And user clicks on Cancel button and clicks on OK button on Search POA <SEARCHSHEETNAME3> and <SEARCHROW3>
Then verify user navigates to main menu
When user navigates to SearchPOA 
And user clicks on Cancel button and clicks on OK button on Search POA <SEARCHSHEETNAME4> and <SEARCHROW4>
And user log out of the application

Examples:
	
      | LOGINSHEETNAME | LOGINROW |SEARCHSHEETNAME1 |SEARCHROW1 | SEARCHSHEETNAME2|SEARCHROW2 |SEARCHSHEETNAME3|SEARCHROW3 |SEARCHSHEETNAME3| SEARCHROW4 |
      | LoginInfo      | 1        |Search           |1          | Search          |2          |Search          |1          |Search          | 2          |