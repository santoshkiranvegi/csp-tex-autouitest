TC9217_Confirmation Screens - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9217_Confirmation Screens - Cancel button

Narrative:
As a user
I want to Confirmation Screens - Cancel button

Scenario: Scenario 1 Confirmation Screens - Cancel button

Given LoadTestData UC62_Create Single Property Tests_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW5>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW6>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW6>
And user cancels the Cancel on the parcel confirmation page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW7>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW5>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW5>
And user cancels the Cancel on the parcel confirmation page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW6>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW6>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW6>
And user cancel the Create Property process on the parcel confirmation page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW8>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW5>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME4> and <PROPERTYDETAIL_MAPROW5>
And user cancel the Create Property process on the parcel confirmation page
Then user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1| CREATEPROPERTYROW5| PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW6|CREATEPROPERTYSHEETNAME2 | CREATEPROPERTYROW7 |PROPERTYDETAIL_MAPSHEETNAME2|PROPERTYDETAIL_MAPROW5|CREATEPROPERTYSHEETNAME3|CREATEPROPERTYROW6|CREATEPROPERTYSHEETNAME4|CREATEPROPERTYROW8|
      | LoginInfo      | 1 		  | CreateProperty			| 5					| PropertyDetail_Map		  | 6					 | CreateProperty		   | 7					|PropertyDetail_Map			 |5				        |CreateProperty	         | 6				|CreateProperty	   		 |8					|
      
