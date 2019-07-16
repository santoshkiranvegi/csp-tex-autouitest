TC8759_Create Property - Proceed button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC8759_Create Property - Proceed button Pos

Narrative:
As a user
I want to Create Property and click on the Proceed button

Scenario: Scenario 1 To Create Property - Proceed button Pos

Given LoadTestData UC62_Create Single Property Tests_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And user click on the OK button on the popup
Then verify user navigates to main menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW |
      | LoginInfo      | 1 		  | CreateProperty   		| 9 				|