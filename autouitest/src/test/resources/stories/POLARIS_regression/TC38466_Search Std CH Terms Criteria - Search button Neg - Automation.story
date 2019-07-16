TC38466_Search Std CH Terms Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38466_Search Std CH Terms Criteria - Search button Neg

Narrative:
As a user
I want to Search Standard Charge Terms Criteria

Scenario: Search Standard Charge Terms Criteria
Given LoadTestData UC31_Search_StandardChargeTerms.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchStandardChargeTerms
And user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME4> and <SEARCHROW4>
Then user verify error message <SEARCHSHEETNAME4> and <SEARCHROW4>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME5> and <SEARCHROW5>
Then user verify error message <SEARCHSHEETNAME5> and <SEARCHROW5>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME6> and <SEARCHROW6>
Then user verify error message <SEARCHSHEETNAME6> and <SEARCHROW6>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME7> and <SEARCHROW7>
Then user verify error no results found <SEARCHSHEETNAME7> and <SEARCHROW7>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME8> and <SEARCHROW8>
Then user verify error message <SEARCHSHEETNAME8> and <SEARCHROW8>
When user clicks Search button on the Standard Charge Terms And Agreement Selection Criteria page <SEARCHSHEETNAME9> and <SEARCHROW9>
Then user verify error message <SEARCHSHEETNAME9> and <SEARCHROW9>
When user clicks on Ok button on Standard Charge Terms And Agreement Criteria page
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW | SEARCHSHEETNAME4 | SEARCHROW4 | SEARCHSHEETNAME5 | SEARCHROW5 | SEARCHSHEETNAME6 | SEARCHROW6 | SEARCHSHEETNAME7 | SEARCHROW7 | SEARCHSHEETNAME8 | SEARCHROW8 | SEARCHSHEETNAME9 | SEARCHROW9 |
	| LoginInfo      | 1        | Search           | 4          | Search           | 5          | Search           | 6          | Search           | 7          | Search           |  8         | Search           | 9          |
	
	