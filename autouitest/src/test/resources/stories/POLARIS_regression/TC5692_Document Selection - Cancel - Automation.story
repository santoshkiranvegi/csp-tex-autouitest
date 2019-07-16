TC5692_Document Selection - Cancel
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC5692_Document Selection - Cancel

Narrative:
As a user
I want to cancel the document selection

Scenario: Scenario 1 Document Selection - Cancel

Given LoadTestData UC52_Certify Document Registration_Automation Scripts_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Certify
And user cancels the cancel document selection
And user cancels document selection <DOCUMENTSELECTIONSHEETNAME> and <DOCUMENTSELECTIONROW>
Then verify user navigates to main menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | DOCUMENTSELECTIONSHEETNAME | DOCUMENTSELECTIONROW |
      | LoginInfo      | 1 		  |DocumentSelection           |1  				      |