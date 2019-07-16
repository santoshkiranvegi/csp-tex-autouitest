TC8985_Property Detail - Proceed button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC8985_Property Detail - Proceed button Pos

Narrative:
As a user
I want to Property Detail - Proceed button Pos

Scenario: Scenario 1 Property Detail - Proceed button Pos

Given LoadTestData UC62_Create Single Property Tests_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user click Close button on property Map Maintenance Request page
When user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2>
And user click Close button on property Map Maintenance Request page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME3> and <PROPERTYDETAIL_MAPROW3>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME3> and <PROPERTYDETAIL_MAPROW3>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3>
And user click Close button on property Map Maintenance Request page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW4>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME4> and <PROPERTYDETAIL_MAPROW4>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME4> and <PROPERTYDETAIL_MAPROW4>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW4>
And user click Close button on property Map Maintenance Request page
Then user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW |CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW1|PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW2|PROPERTYDETAIL_MAPSHEETNAME2|PROPERTYDETAIL_MAPROW2|CREATEPROPERTYSHEETNAME3|CREATEPROPERTYROW3|PROPERTYDETAIL_MAPSHEETNAME3|PROPERTYDETAIL_MAPROW3|CREATEPROPERTYSHEETNAME4|CREATEPROPERTYROW4|PROPERTYDETAIL_MAPSHEETNAME4|PROPERTYDETAIL_MAPROW4|
      | LoginInfo      | 1 		  |CreateProperty		   |1				  |PropertyDetail_Map		   |1	     			  |CreateProperty		   |2				  |PropertyDetail_Map		   |2					  |CreateProperty		   |3				  |PropertyDetail_Map		   |3					  |CreateProperty		   |4				  |PropertyDetail_Map		   |4					  |
      