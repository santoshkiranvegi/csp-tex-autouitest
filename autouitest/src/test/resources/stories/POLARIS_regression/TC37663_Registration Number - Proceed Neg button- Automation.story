TC37663_Registration Number - Proceed Neg button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37663_Registration Number - Proceed Neg button

Narrative:
As a user
I want to  proceed with registration number

Scenario: Scenario 1 Registration Number - Proceed Neg button

Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_03.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME> and <DOCUMENTSELECTIONROWINDEX>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME> and <DOCUMENTSELECTIONROWINDEX>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX1>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX1>
When user Cancel document registration on the Document Detail page
And user navigates to Register 
And user clicks on Submit button with data on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
And user clicks on Proceed  with Receipt button on Document Detail page
And user click on Complete Registration button on the Fees and Taxes page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE> and <SERVICECOPYCOLUMNTARGET> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1>  
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROWINDEX2>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROWINDEX2>
When user Cancel document registration on the Document Detail page
And user navigates to Certify 
And user clicks on  the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME11> and <DOCUMENTSELECTIONROWINDEX11>
And user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME3> and <DOCUMENTSELECTIONROWINDEX3>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME3> and <DOCUMENTSELECTIONROWINDEX3>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME4> and <DOCUMENTSELECTIONROWINDEX4>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME4> and <DOCUMENTSELECTIONROWINDEX4>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME5> and <DOCUMENTSELECTIONROWINDEX5>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME5> and <DOCUMENTSELECTIONROWINDEX5>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME6> and <DOCUMENTSELECTIONROWINDEX6>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME6> and <DOCUMENTSELECTIONROWINDEX6>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME7> and <DOCUMENTSELECTIONROWINDEX7>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME7> and <DOCUMENTSELECTIONROWINDEX7>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME8> and <DOCUMENTSELECTIONROWINDEX8>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME8> and <DOCUMENTSELECTIONROWINDEX8>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME9> and <DOCUMENTSELECTIONROWINDEX9>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME9> and <DOCUMENTSELECTIONROWINDEX9>
When user Cancel document registration on the Document Detail page
And user navigates to CorrectCertifiedDocument 
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME10> and <DOCUMENTSELECTIONROWINDEX10>
Then user verify error message <DOCUMENTSELECTIONSHEETNAME10> and <DOCUMENTSELECTIONROWINDEX10>
When user Cancel document registration on the Document Detail page
And user log out of the application

Examples:
	|LOGINSHEETNAME |LOGINROW | DOCUMENTSELECTIONSHEETNAME | DOCUMENTSELECTIONROWINDEX |DOCUMENTSELECTIONSHEETNAME1|DOCUMENTSELECTIONROWINDEX1|PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|SERVICECOPYCOLUMNSOURCE|SERVICECOPYCOLUMNTARGET      |SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1     |DOCUMENTSELECTIONSHEETNAME2  |DOCUMENTSELECTIONROWINDEX2|DOCUMENTSELECTIONSHEETNAME11|DOCUMENTSELECTIONROWINDEX11|DOCUMENTSELECTIONSHEETNAME3|DOCUMENTSELECTIONROWINDEX3|DOCUMENTSELECTIONSHEETNAME4|DOCUMENTSELECTIONROWINDEX4|DOCUMENTSELECTIONSHEETNAME5|DOCUMENTSELECTIONROWINDEX5|DOCUMENTSELECTIONSHEETNAME6|DOCUMENTSELECTIONROWINDEX6|DOCUMENTSELECTIONSHEETNAME7|DOCUMENTSELECTIONROWINDEX7|DOCUMENTSELECTIONSHEETNAME8|DOCUMENTSELECTIONROWINDEX8|DOCUMENTSELECTIONSHEETNAME9|DOCUMENTSELECTIONROWINDEX9|DOCUMENTSELECTIONSHEETNAME10|DOCUMENTSELECTIONROWINDEX10|
	| LoginInfo     | 1       | DocumentSelection          |2                          |DocumentSelection          |3                         |PreSubmission         |1                    |FeesTaxes         |1                |FeesTaxes,RegNumber,1  |DocumentSelection,RegNumber,4|FeesTaxes,RegNumber,1   |DocumentSelection,RegNumber,5|DocumentSelection            |4                         |FeesTaxes                   |1                          |DocumentSelection          |5                         |DocumentSelection          |6                         |DocumentSelection          |7                         |DocumentSelection          |8                         |DocumentSelection          |9                         |DocumentSelection          |10                        |DocumentSelection          |11                        |DocumentSelection           |12                         |
