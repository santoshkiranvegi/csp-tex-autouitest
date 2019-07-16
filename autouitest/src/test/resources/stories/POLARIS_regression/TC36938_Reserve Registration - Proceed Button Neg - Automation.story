TC36938_Reserve Registration - Proceed Button Neg 
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36938_Reserve Registration - Proceed Button Neg 

Narrative:
As a user
I want to Proceed the Reserve Registration and verify error message 

Scenario: Scenario1 I want to Proceed the Reserve Registration and verify error message 
Given LoadTestData UC411_Reserve Registration Number.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to ReserveRegNumber
And user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME2> and <RESERVEROW2> 
Then user verifies error message <RESERVESHEETNAME2> and <RESERVEROW2>
When user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME3> and <RESERVEROW3> 
Then user verifies error message <RESERVESHEETNAME3> and <RESERVEROW3> 
When user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME4> and <RESERVEROW4>
Then user verifies error message <RESERVESHEETNAME4> and <RESERVEROW4>
When user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME5> and <RESERVEROW5> 
Then user verifies error message <RESERVESHEETNAME5> and <RESERVEROW5>
When user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME6> and <RESERVEROW6> 
Then user verifies error message <RESERVESHEETNAME6> and <RESERVEROW6> 
When user log out of the application

Examples:
	
    | LOGINSHEETNAME | LOGINROW |RESERVESHEETNAME2|RESERVEROW2  |RESERVESHEETNAME3|RESERVEROW3	|RESERVESHEETNAME4|RESERVEROW4 |RESERVESHEETNAME5|RESERVEROW5 |RESERVESHEETNAME6| RESERVEROW6 |
    | LoginInfo      | 1        |Reserve          |2            |Reserve          |3            |Reserve          |4           |Reserve          |5           |Reserve          |6            |
    