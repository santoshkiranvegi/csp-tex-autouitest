TC38103_Confirmation Screens - Certify button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38103_Confirmation Screens - Certify button

Narrative:
As a user
I want to Confirmation Screens - Certify button


Scenario: Scenario 1 Confirmation Screens - Certify button

Given LoadTestData UC62_Create Single Property Tests_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW9>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW7>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW7>
And user click on ParcelConfirmation to create Certify Certify and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW9>
And user click Close button on property Map Maintenance Request page
Then verify user navigates to main menu
When user navigates to CreateProperty
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW10>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on ParcelConfirmation to create Certify Certify and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW10>
And user click Close button on property Map Maintenance Request page
Then verify user navigates to main menu
When user navigates to CreateProperty
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW11>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW8>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW8>
And user click on ParcelConfirmation to create Certify Certify and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW11>
And user click Close button on property Map Maintenance Request page
Then verify user navigates to main menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW |CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW9|PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW7|PROPERTYDETAIL_MAPROW1|CREATEPROPERTYROW10|PROPERTYDETAIL_MAPROW8|CREATEPROPERTYROW11|
      | LoginInfo      | 1 		  |CreateProperty          |9                 |PropertyDetail_Map          |7                     |1                     |10                 |8                     |11                 |
