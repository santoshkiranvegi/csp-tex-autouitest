TC38481_Search TCPL Criteria - Search button  and Result Screen Pos - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38481_Search TCPL Criteria - Search button  and Result Screen Pos - Automation

Narrative:
As a user
I want to Search TCPL Criteria and click on Search button  and  verify Result Screen Pos - Automation  

Scenario1: TC38481_Search TCPL Criteria - Search button  and Result Screen Pos - Automation

Given LoadTestData UC31_Search_TCPL.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <SHEETNAME> and <ROWINDEX1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTSELECTIONSHEETNAME> and <DOCUMENTSELECTIONROWINDEX1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user navigates to Certify 
And user clicks on the Proceed to Certification button on the Document Selection page <DOCUMENTSELECTIONSHEETNAME1> and <DOCUMENTSELECTIONROWINDEX1>
And user clicks on  Certify button on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROWINDEX>
And user Cancel document registration on the Document Detail page
And user navigates to SearchTCPL 
And user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW19> 
And user search NewSearch on TransCanada Pipeline
And user copies column data from source and paste it in target <SOURCE> and <TARGET1> 
And user copies column data from source and paste it in target <SOURCE> and <TARGET2> 
And user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW20> 
And user search PrintReport on TransCanada Pipeline <TCPLPAGE> and <TCPLPRINTSHEETNAME> and <TCPLROWINDEX1>
Then user verify error message <TCPLPRINTSHEETNAME> and <TCPLROWINDEX1>
When user search PrintReport on TransCanada Pipeline <TCPLPAGE> and <TCPLPRINTSHEETNAME> and <TCPLROWINDEX2>
Then user verify error message <TCPLPRINTSHEETNAME> and <TCPLROWINDEX2>
When user search PrintReport on TransCanada Pipeline <TCPLPAGE> and <TCPLPRINTSHEETNAME> and <TCPLROWINDEX3>
And user search PrintReport on TransCanada Pipeline <TCPLPAGE> and <TCPLPRINTSHEETNAME> and <TCPLROWINDEX4>
And user clicks on Close on TransCanada Pipeline
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW |SHEETNAME|ROWINDEX1|DOCUMENTSELECTIONSHEETNAME|DOCUMENTSELECTIONROWINDEX1|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|DOCUMENTSELECTIONROWINDEX2|DOCUMENTSELECTIONSHEETNAME1|DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROWINDEX|TCPLSHEETNAME|TCPLROW19|SOURCE              |TARGET1            |TARGET2          |TCPLSHEETNAME|TCPLROW20|TCPLPRINTSHEETNAME|TCPLROWINDEX1|TCPLROWINDEX2|TCPLROWINDEX3|TCPLROWINDEX4|TCPLPAGE|
	| LoginInfo      | 1 	    |Register |1        |DocumentDetail_Map        |1                         |FeesTaxes         |1                |2                         |FeesTaxes                  |DocumentDetail_Map     |2                     |Search       |19       |FeesTaxes,RegDate,1 |Search,StartDate,20|Search,EndDate,20|Search       |20       |Print             |1            |2            |3            |4            |TCPL    |
