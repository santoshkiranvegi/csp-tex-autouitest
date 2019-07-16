TC38326_Condo Amalgamation - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38326_Condo Amalgamation - Cancel button

Narrative:
As a user
I want to Cancel the Condo Amalgamation

Scenario: Scenario 1 Cancel the Condo Amalgamation
Given LoadTestData UC6431_Condo Amalgamation.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to CondoAmalgamation
And user cancels the cancel condominium amalgamation <CONDOAMALGAMATIONSEETNAME> and <CONDOAMALGAMATIONROW>
When user cancels condominium amalgamation
Then verify user navigates to main menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | SOURCE1 			  | TARGET1 					   | SOURCE2			    | TARGET2						   | CONDOAMALGAMATIONSEETNAME | CONDOAMALGAMATIONROW |
      | LoginInfo      | 1 		  | FeesTaxes,RegNumber,5 | CondoAmalgamation,RegNumber,14 | CreateProperty,Block,2 | CondoAmalgamation,BlockNumber,14 | CondoAmalgamation		   | 14					  |
