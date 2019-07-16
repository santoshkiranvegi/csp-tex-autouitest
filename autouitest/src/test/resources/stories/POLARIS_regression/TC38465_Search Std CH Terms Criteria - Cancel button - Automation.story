TC38465_Search Std CH Terms Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38465_Search Std CH Terms Criteria - Cancel button

Narrative:
As a user
I want to Search Standard Charge Terms Criteria and cancel it 

Scenario:  Scenario1 I want to Search Standard Charge Terms Criteria and cancel it 
Given LoadTestData UC31_Search_StandardChargeTerms.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchStandardChargeTerms
And user clicks on Cancel button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page STANDARDCHARGETERMS and <SEARCHSHEETNAME1> and <SEARCHROW1>
And user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page STANDARDCHARGETERMS and <SEARCHSHEETNAME2> and <SEARCHROW2>
And user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page STANDARDCHARGETERMS and <SEARCHSHEETNAME3> and <SEARCHROW3>
And user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user navigates to SearchStandardChargeTerms
And user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user navigates to SearchStandardChargeTerms
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME1> and <SEARCHROW1>
And user navigates to SearchStandardChargeTerms
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME2> and <SEARCHROW2>
And user navigates to SearchStandardChargeTerms
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME3> and <SEARCHROW3>
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | SEARCHSHEETNAME1 | SEARCHROW1 | SEARCHSHEETNAME2 | SEARCHROW2 | SEARCHSHEETNAME3 | SEARCHROW3 |
	| LoginInfo      | 1        | Search           | 1          | Search           | 2          | Search           | 3          |
