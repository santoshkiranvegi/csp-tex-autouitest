TC38497_Search HWY Criteria - Search button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38497_Search HWY Criteria - Search button Neg

Narrative:
As a user
I want to  search HWY criteria with and with out data


Scenario: TC38497_Search HWY Criteria - Search button Neg

Given LoadTestData UC31_Search_HWY.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX1>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX1>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX2>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX2>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX3>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX3>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX4>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX4>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX5>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX5>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX6>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX6>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX7>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX7>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX8>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX8>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX9>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX9>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX10>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX10>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX11>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX11>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX12>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX12>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX13>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX13>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX14>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX14>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX15>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX15>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX16>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX16>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX17>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX17>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX18>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX18>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX19>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX19>
When user clicks on  Ok button on Search Highways Register page
And user navigates to SEARCHHIGHWAYSREGISTER
And user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX20>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX20>
When user clicks on  Search button on Search Highways Register page with HWY <HWYSHEETNAME> and <HWYROWINDEX21>
Then user verify highways register page error message <HWYSHEETNAME> and <HWYROWINDEX21>
When user clicks on  Ok button on Search Highways Register page
And user log out of the application

Examples:
	| LOGINSHEETNAME | LOGINROW |HWYSHEETNAME|HWYROWINDEX|HWYROWINDEX1|HWYROWINDEX2|HWYROWINDEX3|HWYROWINDEX4|HWYROWINDEX5|HWYROWINDEX6|HWYROWINDEX7|HWYROWINDEX8|HWYROWINDEX9|HWYROWINDEX10|HWYROWINDEX11|HWYROWINDEX12|HWYROWINDEX13|HWYROWINDEX14|HWYROWINDEX15|HWYROWINDEX16|HWYROWINDEX17|HWYROWINDEX18|HWYROWINDEX19|HWYROWINDEX20|HWYROWINDEX21|
	| LoginInfo      | 1        |Search      |5          |6           |     7      |       8    |      9     |   10       |    11      |      12    | 13         |     14     |   15        |  16         |17           |   18        |    19       |   20        | 21          |    22       |   23        |     24      |     25      |26           |
