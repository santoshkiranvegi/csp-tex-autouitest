TC38480_Search TCPL Criteria - Search button Neg - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38480_Search TCPL Criteria - Search button Neg - Automation

Narrative:
As a user
I want to Search TCPL Criteria and click on Search button with negative data

Scenario1: TC38480_Search TCPL Criteria - Search button Neg - Automation

Given LoadTestData UC31_Search_TCPL.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SearchTCPL
And user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW1>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW1>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW2>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW2>
When user search OK button on TransCanada Pipeline
And user navigates to SearchTCPL 
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW3>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW3>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW4>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW4>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW5>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW5>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW6>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW6>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW7>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW7>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW8>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW8>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW9>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW9>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW10>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW10>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW11>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW11>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW12>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW12>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW13>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW13>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW14>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW14>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW15>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW15>
When user clicks on search on TransCanada Pipeline <TCPLSHEETNAME> and <TCPLROW16>
Then user verifies error message <TCPLSHEETNAME> and <TCPLROW16>
When user search OK button on TransCanada Pipeline
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW |TCPLSHEETNAME|TCPLROW1|TCPLROW2|TCPLROW3|TCPLROW4|TCPLROW5|TCPLROW6|TCPLROW7|TCPLROW8|TCPLROW9|TCPLROW10|TCPLROW11|TCPLROW12|TCPLROW13|TCPLROW14|TCPLROW15|TCPLROW16|
	| LoginInfo      | 1 	    |Search       |3       |4		|5		 |6       |7	   |8       |9       |10      |11      |12       |13       |14       |15       |16       |17       |18       |
