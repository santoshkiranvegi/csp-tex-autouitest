TC38450_Search F Type Criteria - Search button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38450_Search F Type Criteria - Search button Pos

Narrative:
As a user
I want to Search F Type Criteria 

Scenario: Scenario1 Search F Type Criteria
Given LoadTestData UC31_Search_FType.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
!-- And user navigates to Register
!-- And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME> and <REGISTERROW>
!-- And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAILMAPSHEET> and <DOCUMENTDETAILMAPROW>
!-- And user click on Complete Registration button on the Fees and Taxes page <FEESTAXESSHEET> and <FEESTAXESROW>
And user navigates to certify
And user clicks on Proceed to Certification button on Document Selection page <FEESTAXESSHEET1> and <FEESTAXESROW1>
And user clicks on Certify button on Document Detail page
And user navigates to SearchFType
And user click on search on SearchFType <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user copies column data from source and paste it in target <FEESTAXESSOURCE> and <FEESTAXESTARGET>
And user clicks on RegNo link on SearchFType <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user clicks on Close in Document Detail popup
And user clicks on New Search on SearchFType
And user click on search on SearchFType <SEARCHSHEET2> and <SEARCHROW2>
And user clicks on Close in SearchFType
And user log out of the application

Examples:
	  | LOGINSHEETNAME | LOGINROW | REGISTERSHEETNAME|REGISTERROW| FEESTAXESSHEET1 | FEESTAXESROW1 | DOCUMENTDETAILMAPSHEET |DOCUMENTDETAILMAPROW| FEESTAXESSHEET | FEESTAXESROW| SEARCHSHEETNAME1 | SEARCHROWINDEX1 |FEESTAXESSOURCE       |FEESTAXESTARGET    | SEARCHSHEET2  |SEARCHROW2| FEESTAXESSHEETNAME | FEESTAXESROWINDEX |  
      | LoginInfo      |1         | Register         |1          | FeesTaxes       | 2             | DocumentDetail_Map     |1                   | FeesTaxes      |1            | Search           | 3               |FeesTaxes,RegNumber,1 |FeesTaxes,RegNo,1  | Search        |4         | FeesTaxes          | 3                 |
	
	
	
	
	
	
	
