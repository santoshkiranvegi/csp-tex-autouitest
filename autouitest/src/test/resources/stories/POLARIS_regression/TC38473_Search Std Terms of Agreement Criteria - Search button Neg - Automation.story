TC38473_Search Std Terms of Agreement Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38473_Search Std Terms of Agreement Criteria - Search button Neg

Narrative:
As a user
I want to search by Standard Charge Terms And Agreement Criteria and verify error message

Scenario: Scenario1 I want to search by Standard Charge Terms And Agreement Criteria and verify error message
Given LoadTestData UC31_Search_StandardTermsOfAgreement.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchStandardTermsOfAgreement
And user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME4> and <SEARCHROW4> 
Then user verifies error message <SEARCHSHEETNAME4> and <SEARCHROW4> 
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME5> and <SEARCHROW5> 
Then user verifies error message <SEARCHSHEETNAME5> and <SEARCHROW5>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME6> and <SEARCHROW6> 
Then user verifies error message <SEARCHSHEETNAME6> and <SEARCHROW6>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME7> and <SEARCHROW7> 
Then user verify error no results found <SEARCHSHEETNAME7> and <SEARCHROW7>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME8> and <SEARCHROw8> 
Then user verifies error message <SEARCHSHEETNAME8> and <SEARCHROw8>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME9> and <SEARCHROW9> 
Then user verifies error message <SEARCHSHEETNAME9> and <SEARCHROW9>
When user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
Then verify user navigates to main menu
When user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | SEARCHSHEETNAME4 | SEARCHROW4 | SEARCHSHEETNAME5 | SEARCHROW5 | SEARCHSHEETNAME6 | SEARCHROW6 | SEARCHSHEETNAME7 | SEARCHROW7 | SEARCHSHEETNAME8 | SEARCHROw8 | SEARCHSHEETNAME9 | SEARCHROW9 |
	| LoginInfo      | 1        | Search           | 4          | Search           | 5          | Search           | 6          | Search           | 7          | Search           |  8         | Search           | 9          |