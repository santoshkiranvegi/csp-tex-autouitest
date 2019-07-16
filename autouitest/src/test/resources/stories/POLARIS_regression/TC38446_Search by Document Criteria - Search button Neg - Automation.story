TC38446_Search by Document Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38446_Search by Document Criteria - Search button Neg

Narrative:
As a user
I want to Search by Document Criteria

Scenario: Scenario1 I want to Search by Document Criteria
Given LoadTestData UC31_Search_Document_Cancel_SearchNeg.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchDocument
And user click Search button on the Search by Document page <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
And user click Search button on the Search by Document page <SEARCHSHEETNAME3> and <SEARCHROWINDEX3>
And user click Cancel_OK button on Search by Document page
Then verify user navigates to main menu
When user navigates to ChangeActiveLRO
And user click on the Change LRO button on the Change Active LRO entry page <LROSHEETNAME1> and <LROROWINDEX1>
And user navigates to RecordHistorical
And user click the Enter Historical Record on the Record Historical Presubmission page <RECORDSHEETNAME1> and <RECORDROWINDEX1>
And user click on Complete Recording button on Document Detail page <DOCUMENTDETAILSMAPSHEETNAME1> and <DOCUMENTDETAILSMAPROWINDEX1>
And user click on Complete Recording button on the Fees and Taxes page
And user navigates to ChangeActiveLRO
And user click on the Change LRO button on the Change Active LRO entry page <LROSHEETNAME2> and <LROROWINDEX2>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user navigates to SearchDocument
And user click Search button on the Search by Document page <SEARCHSHEETNAME4> and <SEARCHROWINDEX4>
And user click Cancel_OK button on Search by Document page
And user navigates to ChangeActiveLRO
And user click on the Change LRO button on the Change Active LRO entry page <LROSHEETNAME1> and <LROROWINDEX1>
And user navigates to RecordHistorical
And user click the Enter Historical Record on the Record Historical Presubmission page <RECORDSHEETNAME2> and <RECORDROWINDEX2>
And user click Complete Recording button on Document Detail page <DOCUMENTDETAILSMAPSHEETNAME2> and <DOCUMENTDETAILSMAPROWINDEX2>
And user click on Complete Recording button on the Fees and Taxes page
And user navigates to ChangeActiveLRO
And user click on the Change LRO button on the Change Active LRO entry page <LROSHEETNAME2> and <LROROWINDEX2>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2> 
And user navigates to SearchDocument
And user click Search button on the Search by Document page <SEARCHSHEETNAME5> and <SEARCHROWINDEX5>
And user log out of the application



Examples:
	| LOGINSHEETNAME  | LOGINROW | SEARCHSHEETNAME2 | SEARCHROWINDEX2 |  SEARCHSHEETNAME3 | SEARCHROWINDEX3 | LROSHEETNAME1 | LROROWINDEX1 | RECORDSHEETNAME1 | RECORDROWINDEX1 | DOCUMENTDETAILSMAPSHEETNAME1 | DOCUMENTDETAILSMAPROWINDEX1 | LROSHEETNAME2 | LROROWINDEX2 | SOURCE1            | TARGET1             | SEARCHSHEETNAME4 | SEARCHROWINDEX4 | RECORDSHEETNAME2 | RECORDROWINDEX2  | DOCUMENTDETAILSMAPSHEETNAME2 | DOCUMENTDETAILSMAPROWINDEX2  | SOURCE2               | TARGET2             | SEARCHSHEETNAME5 | SEARCHROWINDEX5 |                                                 
	| LoginInfo       | 1        | Search           | 2               |  Search           | 3               | LRO           | 1            | Record           | 1               | DocumentDetail_Map           | 1                           | LRO           | 2            | Record,RegNumber,1 | Search,RegNumber,4  | Search           | 4               | Record           | 2                | DocumentDetail_Map           | 2                            |  Record,RegNumber,2   | Record,RegNumber,2  | Search           | 5               |
