TC10151_Modify Document Header Edit - Do Not Apply button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC10151_Modify Document Header Edit - Do Not Apply button

Narrative:
As a user
I want to  Modify Document Header and  click on Do Not Apply

Scenario: TC10151_Modify Document Header Edit - Do Not Apply button
Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAILSHEETNAME1> and <DOCUMENTDETAILROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW1>
And user navigates to Certify 
Then verify user navigates to menu Certify
When user clicks on the Proceed to Certification button on the Document Selection page <FEESTAXESSHEETNAME2> and <FEESTAXESROW2>
And user clicks on Certify button on Document Detail page <DOCUMENTDETAILSHEETNAME2> and <DOCUMENTDETAILROW2>
And user clicks on Commit button on Property Maintenance page
And user navigates to CorrectCertifiedDocument
And user clicks on Proceed to Certification button on Document Selection page <DOCUMENTSELECTIONSHEETNAME2> and <DOCUMENTSELECTIONROW1>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME3> and <DOCUMENTDETAILROW1>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME4> and <DOCUMENTDETAILROW2>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME5> and <DOCUMENTDETAILROW3>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME6> and <DOCUMENTDETAILROW4>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME7> and <DOCUMENTDETAILROW5>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME8> and <DOCUMENTDETAILROW6>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME9> and <DOCUMENTDETAILROW7>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME10> and <DOCUMENTDETAILROW8>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME11> and <DOCUMENTDETAILROW9>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME12> and <DOCUMENTDETAILROW10>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME13> and <DOCUMENTDETAILROW11>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME14> and <DOCUMENTDETAILROW12>
And user clicks on Modify Header button on Document Detail page
And user verify the UI object properties <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
And user clicks on Do Not Apply button on Modify Header page
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME15> and <DOCUMENTDETAILROW13>
And user clicks on Modify Header button on Document Detail page
And user Apply/DoNotApply the modification <DOCUMENTDETAILSHEETNAME16> and <DOCUMENTDETAILROW14>
And user clicks on Cancel document registration on the Document Detail page without data entry
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW1|DOCUMENTDETAILSHEETNAME1|DOCUMENTDETAILROW1|FEESTAXESSHEETNAME1|FEESTAXESROW1|FEESTAXESSHEETNAME2 |FEESTAXESROW2|DOCUMENTDETAILSHEETNAME2|DOCUMENTDETAILROW2|DOCUMENTSELECTIONSHEETNAME2|DOCUMENTSELECTIONROW1|DOCUMENTDETAILSHEETNAME3|DOCUMENTDETAILROW1|DOCUMENTDETAILSHEETNAME4|DOCUMENTDETAILROW2|DOCUMENTDETAILSHEETNAME5|DOCUMENTDETAILROW3|DOCUMENTDETAILSHEETNAME6|DOCUMENTDETAILROW4|DOCUMENTDETAILSHEETNAME7|DOCUMENTDETAILROW5|DOCUMENTDETAILSHEETNAME8|DOCUMENTDETAILROW6|DOCUMENTDETAILSHEETNAME9|DOCUMENTDETAILROW7|DOCUMENTDETAILSHEETNAME10|DOCUMENTDETAILROW8|DOCUMENTDETAILSHEETNAME11|DOCUMENTDETAILROW9|DOCUMENTDETAILSHEETNAME12|DOCUMENTDETAILROW10|DOCUMENTDETAILSHEETNAME13|DOCUMENTDETAILROW11|DOCUMENTDETAILSHEETNAME14|DOCUMENTDETAILROW12|UIOBJECTSHEETNAME1|UIOBJECTROW1|DOCUMENTDETAILSHEETNAME15|DOCUMENTDETAILROW13|DOCUMENTDETAILSHEETNAME16|DOCUMENTDETAILROW14|
	| LoginInfo      | 1        |PreSubmission          |1                |DocumentDetail_Map      |1                 |FeesTaxes          |1            |FeesTaxes           |2            |DocumentDetail_Map      |2                 |FeesTaxes                  |2                    |ModifyHeader            |1                 |ModifyHeader            |2                 |ModifyHeader            |3                 |ModifyHeader            |4                 |ModifyHeader            |5                 |ModifyHeader            |6                 |ModifyHeader            |7                 |ModifyHeader             |8                 |ModifyHeader             |9                 |ModifyHeader             |10                 |ModifyHeader             |11                 |ModifyHeader             |12                 |UIObject         |1            |ModifyHeader             |13                 |   ModifyHeader          |14                 |