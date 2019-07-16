TC38412_Search By PIN Criteria - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38412_Search By PIN Criteria - Cancel button

Narrative:
As a user
I want to Search By PIN Criteria

Scenario: Scenario1 I want to Search by Document Criteria
Given LoadTestData UC31_Search_Register_Cancel_Search.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
When user navigates to CreateProperty
And user clicks on the Proceed button on the CreatProperty <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILMAPSHEETNAME> and <PROPERTYDETAILMAPROWINDEX>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PROPERTYDETAILMAPSHEETNAME> and <PROPERTYDETAILMAPROWINDEX>
And user clicks on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2> 
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3> 
And user navigates to SearchRegister
And user click Cancel button on Search by PIN page
And user click Cancel button on Search by PIN page <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user click Cancel_OK button on Search by PIN page
Then verify user navigates to main menu
When user navigates to SearchRegister
And user click Cancel button on Search by PIN page <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
And user click Cancel_OK button on Search by PIN page
Then verify user navigates to main menu
When user navigates to SearchRegister
And user click Cancel_OK button on Search by PIN page
And user navigates to SearchRegister
And user click Cancel_OK button on Search by PIN page <SEARCHSHEETNAME1> and <SEARCHROWINDEX1>
And user navigates to SearchRegister
And user click Cancel_OK button on Search by PIN page <SEARCHSHEETNAME2> and <SEARCHROWINDEX2>
And user log out of the application



Examples:
	| LOGINSHEETNAME  | LOGINROW | CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW | SOURCE1                 | TARGET1                     | PROPERTYDETAILMAPSHEETNAME | PROPERTYDETAILMAPROWINDEX  | PROPERTYDETAILMAPSHEETNAME | PROPERTYDETAILMAPROWINDEX  | CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW | SOURCE2                   | TARGET2                 |  SOURCE3                   | TARGET3      | SEARCHSHEETNAME1  | SEARCHROWINDEX1  | SEARCHSHEETNAME2  | SEARCHROWINDEX2 | SEARCHSHEETNAME1  | SEARCHROWINDEX1  | SEARCHSHEETNAME2  | SEARCHROWINDEX2 |                   
	| LoginInfo       | 1        | CreateProperty          | 1                 | CreateProperty,Block,1  | PropertyDetail_Map,Block,1  | PropertyDetail_Map         | 1                          | PropertyDetail_Map         | 1                          |  CreateProperty         | 1                 |  CreateProperty,Block,1   | Search,Block,1          |  CreateProperty,PIN,1      | Search,PIN,1 |  Search           | 1                | Search            | 2               | Search            | 1                | Search            | 2               |                                                         
	
	
	