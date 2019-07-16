TC8759_Create Property - Proceed button Pos
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC8759_Create Property - Proceed button Pos

Narrative:
As a user
I want to Create Property - Proceed button Pos 


Lifecycle:
Before:
Scope: SCENARIO
Given LoadTestData UC62_Create Single Property Tests_01.xlsx
After:
Scope: SCENARIO
Given CloseTestData
 
Scenario: Scenario 1 To Create Property - Proceed button Pos
Given ELRS_Login <LOGINSHEETNAME> and <LOGINROW>
Then ELRS_Navigate <CreateProperty>
And CreateProperty_Proceed <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And PropertyDetail_Cancel
And ELRS_Logout

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW | CreateProperty |
      | LoginInfo    | 1 | CreateProperty | 9 | CreateProperty |