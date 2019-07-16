TC8760_Create Property - Proceed button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC8760_Create Property - Proceed button Neg

Narrative:
As a user
I want to create property and click on proceed button

Scenario: Scenario 1 Create Property - CProceed button Neg

Given LoadTestData UC62_Create Single Property Tests_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW3>
Then user verify error message <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW3>
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW4>
Then user verify error no results found <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW4>
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW5>
Then user verify error message <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW5>
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW6>
Then user verify error message <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW6>
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME5> and <CREATEPROPERTYROW7>
Then user verify error message <CREATEPROPERTYSHEETNAME5> and <CREATEPROPERTYROW7>
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME6> and <CREATEPROPERTYROW8>
Then user verify error no results found <CREATEPROPERTYSHEETNAME6> and <CREATEPROPERTYROW8>
When user log out of the application

Examples:

 | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1 | CREATEPROPERTYROW3 | CREATEPROPERTYSHEETNAME2 | CREATEPROPERTYROW4 | CREATEPROPERTYSHEETNAME3 | CREATEPROPERTYROW5 | CREATEPROPERTYSHEETNAME4 | CREATEPROPERTYROW6 | CREATEPROPERTYSHEETNAME5 | CREATEPROPERTYROW7 | CREATEPROPERTYSHEETNAME6 | CREATEPROPERTYROW8 | 
 | LoginInfo      | 1 		 | CreateProperty   		| 3 				 | CreateProperty		    | 4					 | CreateProperty			| 5					 | CreateProperty			| 6					 | CreateProperty			| 7					 | CreateProperty			| 8					 |