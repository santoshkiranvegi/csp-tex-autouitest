TC9199_Create Property - Cancel Button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9199_Create Property - Cancel Button

Narrative:
As a user
I want to create property and cancel 

Scenario: Scenario 1 Create Property - Cancel Button

Given LoadTestData UC62_Create Single Property Tests_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user cancels Create Property
And user navigates to CreateProperty
And user cancels the Cancel Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
Then verify user navigates to main menu
When user cancels Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2>
Then verify user navigates to main menu
When user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1 |CREATEPROPERTYROW1 | CREATEPROPERTYSHEETNAME2 | CREATEPROPERTYROW2 |
 | LoginInfo      | 1 		 | CreateProperty   		| 1 				| CreateProperty		   | 2					 |