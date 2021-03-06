TC38472_Search Std Terms of Agreement Criteria - Cancel button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38472_Search Std Terms of Agreement Criteria - Cancel button - Automation

Narrative:
As a user
I want to Search Standard Terms of Agreement Criteria


Scenario: TC38472_Search Std Terms of Agreement Criteria - Cancel button - Automation
Given LoadTestData UC31_Search_StandardTermsOfAgreement.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchStandardTermsOfAgreement
And user clicks on Cancel button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page <STANDARDCHARGETERMS> and <SEARCHSHEETNAME1> and <SEARCHROW1>
And user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page <STANDARDCHARGETERMS> and <SEARCHSHEETNAME2> and <SEARCHROW2>
And user clicks on Cancel button on Standard Charge Terms And Agreement Selection Criteria page <STANDARDCHARGETERMS> and <SEARCHSHEETNAME3> and <SEARCHROW3>
And user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user navigates to SearchStandardTermsOfAgreement
And user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user navigates to SearchStandardTermsOfAgreement
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME1> and <SEARCHROW1>
And user navigates to SearchStandardTermsOfAgreement
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME2> and <SEARCHROW2>
And user navigates to SearchStandardTermsOfAgreement
And user clicks on Ok button on Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME3> and <SEARCHROW3>
And user log out of the application


Examples:
	| LOGINSHEETNAME | LOGINROW | SEARCHSHEETNAME1 | SEARCHROW1 | SEARCHSHEETNAME2 | SEARCHROW2 | SEARCHSHEETNAME3 | SEARCHROW3 |
	| LoginInfo      | 1        | Search           | 1          | Search           | 2          | Search           | 3          |
	
	
	
