TC9264_Property Detail - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9264_Property Detail - Cancel button

Narrative:
As a user
I want to enter the details in  property detail and cancel

Scenario: Scenario 1 Property Detail - Cancel button

Given LoadTestData UC62_Create Single Property Tests_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user cancels the Cancel popup on Property Detail page
Then verify user navigates to main menu
When user cancels the Cancel popup on Property Detail with data entry <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
Then verify user navigates to main menu
When user clicks the tab Documents
And user enter data for property Documents details <DOCUMENTSSHEETNAME1> and <DOCUMENTSROW2>
Then user verifies no results found <DOCUMENTSSHEETNAME1> and <DOCUMENTSROW2>
When user clicks the OK button on the Cancel on Property Detail page
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2>
And user clicks the OK button on the Cancel on Property Detail page
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3>
And user clicks the OK button on the Cancel on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3>
And user clicks the tab Documents 
And user enter data for property Documents details <DOCUMENTSSHEETNAME2> and <DOCUMENTSROW4>
Then user verifies no results found <DOCUMENTSSHEETNAME2> and <DOCUMENTSROW4>
When user clicks the OK button on the Cancel on Property Detail page
And user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1 | CREATEPROPERTYROW1 | PROPERTYDETAIL_MAPSHEETNAME1 | PROPERTYDETAIL_MAPROW1 | DOCUMENTSSHEETNAME1 | DOCUMENTSROW2 |CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW2   |CREATEPROPERTYSHEETNAME3  |CREATEPROPERTYROW3 | PROPERTYDETAIL_MAPSHEETNAME2 | PROPERTYDETAIL_MAPROW2 | CREATEPROPERTYSHEETNAME3 | CREATEPROPERTYROW3 | DOCUMENTSSHEETNAME2 | DOCUMENTSROW4 |
 | LoginInfo      | 1 		 | CreateProperty   		| 9 				 | PropertyDetail_Map		    | 1						 | Documents		   | 2			   |  CreateProperty        | 9                   |  CreateProperty          |9                  |    PropertyDetail_Map		| 3	                     |CreateProperty   		    | 9 				 | Documents		   | 4			   |
 
 