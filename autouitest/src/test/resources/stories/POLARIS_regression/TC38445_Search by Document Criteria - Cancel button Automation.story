TC38445_Search by Document Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38445_Search by Document Criteria - Cancel button

Narrative:
As a user
I want to Cancel Search by Document Criteria 

Scenario: Scenario 1 Cancel Search by Document Criteria

Given LoadTestData UC31_Search_Document_Cancel_SearchNeg.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchDocument
And user clicks on Cancel button and clicks on Cancel button on popup
Then verify user navigates to main menu
When user clicks on Cancel button and clicks on OK button on popup <SEARCHSHEETNAME1> and <SEARCHROW1>
Then verify user navigates to main menu
When user log out of the application

Examples:
| LOGINSHEETNAME  | LOGINROW | SEARCHSHEETNAME1 | SEARCHROW1 |
|  LoginInfo      | 1        | Search           | 1          |
