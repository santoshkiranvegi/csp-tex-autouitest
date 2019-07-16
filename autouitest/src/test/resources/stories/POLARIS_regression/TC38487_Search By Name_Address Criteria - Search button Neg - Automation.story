TC38487_Search By Name_Address Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38487_Search By Name_Address Criteria - Search button Neg

Narrative:
As a user
I want to search by Name or address criteria and verify error message

Scenario: Scenario1 I want to search by Name or address criteria and verify error message
Given LoadTestData UC31_Search_NameAddress.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchNameAddress 
And user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME2> and <ADDRESSPAGEROW2>
Then user verifies error message <ADDRESSPAGESHEETNAME2> and <ADDRESSPAGEROW2>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME3> and <ADDRESSPAGEROW3>
Then user verifies error message <ADDRESSPAGESHEETNAME3> and <ADDRESSPAGEROW3>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME4> and <ADDRESSPAGEROW4>
Then user verifies error message <ADDRESSPAGESHEETNAME4> and <ADDRESSPAGEROW4>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME5> and <ADDRESSPAGEROW5>
Then user verifies error message <ADDRESSPAGESHEETNAME5> and <ADDRESSPAGEROW5>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME6> and <ADDRESSPAGEROW6>
Then user verifies error message <ADDRESSPAGESHEETNAME6> and <ADDRESSPAGEROW6>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME7> and <ADDRESSPAGEROW7>
Then user verifies error message <ADDRESSPAGESHEETNAME7> and <ADDRESSPAGEROW7>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME8> and <ADDRESSPAGEROW8>
Then user verifies error message <ADDRESSPAGESHEETNAME8> and <ADDRESSPAGEROW8>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME9> and <ADDRESSPAGEROW9>
Then user verifies error message <ADDRESSPAGESHEETNAME9> and <ADDRESSPAGEROW9>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME10> and <ADDRESSPAGEROW10>
Then user verifies error message <ADDRESSPAGESHEETNAME10> and <ADDRESSPAGEROW10>
When user clicks on Search button on Search page with <ADDRESSPAGESHEETNAME11> and <ADDRESSPAGEROW11>
Then user verifies error message <ADDRESSPAGESHEETNAME11> and <ADDRESSPAGEROW11>
When user clicks on Ok button on Search page
And user log out of the application

Examples:
		| LOGINSHEETNAME | LOGINROW |ADDRESSPAGESHEETNAME2|ADDRESSPAGEROW2| ADDRESSPAGESHEETNAME3 | ADDRESSPAGEROW3| ADDRESSPAGESHEETNAME4 | ADDRESSPAGEROW4| ADDRESSPAGESHEETNAME5 | ADDRESSPAGEROW5| ADDRESSPAGESHEETNAME6 |ADDRESSPAGEROW6| ADDRESSPAGESHEETNAME7 |ADDRESSPAGEROW7| ADDRESSPAGESHEETNAME8 | ADDRESSPAGEROW8| ADDRESSPAGESHEETNAME9 |ADDRESSPAGEROW9| ADDRESSPAGESHEETNAME10 | ADDRESSPAGEROW10| ADDRESSPAGESHEETNAME11 |ADDRESSPAGEROW11|
	    | LoginInfo      | 1        |Search               |2              | Search                | 3			   | Search                | 4              | Search                | 5              | Search                |6              | Search                |7              | Search                | 8              | Search                | 9             | Search                 | 10	             | Search                 | 11             | 
