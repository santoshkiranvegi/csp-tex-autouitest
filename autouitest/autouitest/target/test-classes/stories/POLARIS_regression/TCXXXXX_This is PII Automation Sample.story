TCXXXXX_This is PII Automation Sample
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TCXXXXX_This is PII Automation Sample

Narrative:
As a user
I want to Create Property - Proceed button Pos 

Lifecycle:
Before:
Scope: SCENARIO
Given LoadTestData POC_PII_Sample.xlsx
After:
Scope: SCENARIO
Given CloseTestData

 
Scenario: Scenario 1 To Create Property - Proceed button Pos
Given ELRS_Login <LOGINSHEETNAME> and <LOGINROW>
Then ELRS_Navigate <CreateProperty>
And CreateProperty_Proceed <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And Service_CopyColumn CreateProperty,Block,1 and PropertyDetail_Map,Block,1
And PropertyDetail_Proceed PropertyDetail_Map and 1
And PrintParcel_ProceedToConfirmation <PRINTPARCELSHEETNAME> and <PRINTPARCELROWNAME>
And ParcelConfirmation_Certify Create CreateProperty 1
And PropertyMapMaintenanceRequest_Close
And Service_CopyColumn CreateProperty,Block,1 and Register,TargetBlock,1
And Service_CopyColumn CreateProperty,PIN,1 and Register,TargetPINFrom,1
And ELRS_Navigate Register
And Register_PreSubmission_Submit Register and 1
And ELRS_Logout

Examples:
      | LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW | CreateProperty | SOURCE | TARGET | PRINTPARCELSHEETNAME | PRINTPARCELROWNAME|
      | LoginInfo    | 1 | CreateProperty | 1 | CreateProperty | CreateProperty,Block,1 | PropertyDetail_Map,Block,1 |||
      


