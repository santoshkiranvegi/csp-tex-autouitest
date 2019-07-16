TC9246_Create Single Property - Print Parcel - Return to Property Details - Land Titles - RSC1
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9246_Create Single Property - Print Parcel - Return to Property Details - Land Titles - RSC1

Narrative:
As a user
I want to Create Single Property - Print Parcel - Return to Property Details - Land Titles - RSC1

Scenario: Scenario 1 Create Single Property - Print Parcel - Return to Property Details - Land Titles - RSC1

Given LoadTestData UC62_Create Single Property Tests_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW5>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW5>
And user clicks Return to Property Details button on Print Parcel page
And user click on the OK button on the Cancel on Property Detail page
Then verify user navigates to menu Main Menu
When user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW6>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW6>
And user clicks Return to Property Details button on Print Parcel page
And user click on the OK button on the Cancel on Property Detail page
Then verify user navigates to menu Main Menu
When user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW5|PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW5|CREATEPROPERTYROW6|PROPERTYDETAIL_MAPROW6|
      | LoginInfo      | 1 		  |CreateProperty           |5                 |PropertyDetail_Map          |5                     |6                 |6                     |




      
      