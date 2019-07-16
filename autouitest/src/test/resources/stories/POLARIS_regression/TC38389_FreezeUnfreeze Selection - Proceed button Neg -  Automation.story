TC38389_FreezeUnfreeze Selection - Proceed button Neg -  Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38389_FreezeUnfreeze Selection - Proceed button Neg -  Automation

Narrative:
As a user
I want to select freezeandunfreeze and cancel

Scenario: TC38389_FreezeUnfreeze Selection - Proceed button Neg -  Automation

Given LoadTestData UC672_FreezeUnfreezeProperty_Selection.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to FreezeUnfreezeProperty 
And user clicks the Proceed button on the Update Certified Property Freeze and Unfreeze PIN Entry page <PINENTRYSHEETNAME> and <PINENTRYROW1>
And user clicks the Proceed button on the Freeze/Unfreeze Selection page <SELECTIONSHEETNAME> and <SELECTIONROW5>
Then user verifies error message <SELECTIONSHEETNAME> and <SELECTIONROW6>
When user clicks the Proceed button on the Freeze/Unfreeze Selection page <SELECTIONSHEETNAME1> and <SELECTIONROW6>
Then user verifies error message <SELECTIONSHEETNAME> and <SELECTIONROW5>
When user clicks OK button Cancel on Freeze/Unfreeze Selection page
And user log out of the application
Examples:
	| LOGINSHEETNAME | LOGINROW   |PINENTRYSHEETNAME|PINENTRYROW1|SELECTIONSHEETNAME|SELECTIONROW5|SELECTIONSHEETNAME1|SELECTIONROW6|
	| LoginInfo      | 1 		  |PINEntry         |1-2         |Selection         |5            |Selection          |6            |
