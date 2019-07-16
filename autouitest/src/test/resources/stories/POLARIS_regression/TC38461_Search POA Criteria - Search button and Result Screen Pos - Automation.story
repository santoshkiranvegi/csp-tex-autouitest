TC38461_Search POA Criteria - Search button and Result Screen Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38461_Search POA Criteria - Search button and Result Screen Pos

Narrative:
As a user
I want to search POA Criteria - Search button and Result Screen

Scenario: Scenario 1 TC38461_Search POA Criteria - Search button and Result Screen Pos

Given LoadTestData UC31_Search_POA.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME> and <REGISTERROW1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW2>
And user navigates to Certify 
And user clicks on Proceed to Certification button on Document Selection page <FEESTAXESSHEETNAME2> and <FEESTAXESROW1>
And user click on Certify button on Document Detail page
And user navigates to SearchPOA 
And user click on search on SearchPOA <SEARCHSHEETNAME1> and <SEARCHROW3>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user clicks on RegNo link on SearchPOA <FEESTAXESSHEETNAME3> and <FEESTAXESROW1>
And user clicks on Close in Document Detail popup
And user clicks on New Search on SearchPOA
And user click on search on SearchPOA <SEARCHSHEETNAME2> and <SEARCHROW4>
And user clicks on RegNo link on SearchPOA <FEESTAXESSHEETNAME4> and <FEESTAXESROW1>
And user clicks on Close in Document Detail popup
And user clicks on Close in SearchPOA
Then verify user navigates to main menu
And user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |REGISTERSHEETNAME|REGISTERROW1 |DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROW1|FEESTAXESSHEETNAME1|FEESTAXESROW2|FEESTAXESSHEETNAME2|FEESTAXESROW1|SEARCHSHEETNAME1|SEARCHROW3|SOURCE1                |TARGET1           |FEESTAXESSHEETNAME3|FEESTAXESROW1|SEARCHSHEETNAME2|SEARCHROW4|FEESTAXESSHEETNAME4|FEESTAXESROW1|
	| LoginInfo      | 1        |Register         |1            |DocumentDetail_Map     |1                 |FeesTaxes          |2            |FeesTaxes          |1            |Search          |3         |FeesTaxes,RegNumber,1  |FeesTaxes,RegNo,1 |FeesTaxes          |1            |Search          |4         |FeesTaxes          |1            |