TC37163_Document Selection - Proceed to Certification Button Neg - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37163_Document Selection - Proceed to Certification Button Neg - Automation

Narrative:
As a user
I want to Proceed to Certification Button Neg

Scenario: Scenario 1 Proceed to Certification Button Neg
Given LoadTestData UC52_Certify Document Registration_Automation Scripts_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROW8>
Then user verifies uiobject property <UIOBJECTSHEETNAME> and <UIOBJECTROW1>
When user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROW9>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME3> and <DOCUMENTSELECTIONROW10>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME4> and <DOCUMENTSELECTIONROW11>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME5> and <DOCUMENTSELECTIONROW12>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME6> and <DOCUMENTSELECTIONROW13>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME7> and <DOCUMENTSELECTIONROW14>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME8> and <DOCUMENTSELECTIONROW15>
And user navigates to Certify
And user clicks Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME9> and <DOCUMENTSELECTIONROW16>
Then verify user navigates to main menu
When user log out of the application

Examples:

      | LOGINSHEETNAME | LOGINROW | DOCUMENTSELECTIONSHEETNAME1 | DOCUMENTSELECTIONROW8 | UIOBJECTSHEETNAME | UIOBJECTROW1 | DOCUMENTSELECTIONSHEETNAME2 | DOCUMENTSELECTIONROW9 | DOCUMENTSELECTIONSHEETNAME3 | DOCUMENTSELECTIONROW10 | DOCUMENTSELECTIONSHEETNAME4 | DOCUMENTSELECTIONROW11 | DOCUMENTSELECTIONSHEETNAME5 | DOCUMENTSELECTIONROW12 | DOCUMENTSELECTIONSHEETNAME6 | DOCUMENTSELECTIONROW13 | DOCUMENTSELECTIONSHEETNAME7 | DOCUMENTSELECTIONROW14 | DOCUMENTSELECTIONSHEETNAME8 | DOCUMENTSELECTIONROW15 | DOCUMENTSELECTIONSHEETNAME9 | DOCUMENTSELECTIONROW16 |
      | LoginInfo      | 1 		  | DocumentSelection           | 8  				    | UIObject			| 1	   		   |DocumentSelection            | 9  				     | DocumentSelection           | 10  				    | DocumentSelection           | 11  				   | DocumentSelection           | 12  				      | DocumentSelection           | 13  				     | DocumentSelection           | 14  				    | DocumentSelection           | 15  				   | DocumentSelection           | 16   				  |
      
