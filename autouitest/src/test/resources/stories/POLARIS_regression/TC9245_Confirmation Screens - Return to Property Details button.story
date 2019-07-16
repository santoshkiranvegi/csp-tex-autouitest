TC9245_Confirmation Screens - Return to Property Details button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9245_Confirmation Screens - Return to Property Details button

Narrative:
As a user
I want to Confirmation Screens - Return to Property Details button

Scenario: I want to Search Standard Terms of Agreement Criteria
Given LoadTestData UC62_Create Single Property Tests_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW12>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW9>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW9>
And user clicks Return to Property Details button on Print Parcel page
And user click on the OK button on the popup
Then verify user navigates to main menu
When user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW12>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW6>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW6>
And user clicks Return to Property Details button on Print Parcel page
And user click on the OK button on the popup
Then verify user navigates to main menu
When user log out of the application


Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1 | CREATEPROPERTYROW12 | PROPERTYDETAIL_MAPSHEETNAME1 | PROPERTYDETAIL_MAPROW9 | PROPERTYDETAIL_MAPSHEETNAME2 | PROPERTYDETAIL_MAPROW6 |  
      | LoginInfo      | 1 		  | CreateProperty           | 12                  | PropertyDetail_Map           | 9                      | PropertyDetail_Map           | 6                      |
      
      