TC38310_Condo Amendment - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38310_Condo Amendment - Cancel button

Narrative:
As a user
I want to  cancel the Condo Amendment

Scenario: Scenario 1 Cancel the Condo Amalgamation
Given LoadTestData UC64131_Condo Amendment_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user navigates to CondoAmendment 
And user Cancel the Cancel Condominium Amendment <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW>
And user Cancel Condominium Amendment
Then verify user navigates to main menu
When user log out of the application

Examples:
	 | LOGINSHEETNAME | LOGINROW | SOURCE1                 | TARGET1                       | SOURCE2             | TARGET2                     | SOURCE3               | TARGET3                     | SOURCE4                 | TARGET4                       | CONDOAMENDMENTSHEETNAME | CONDAMENDMENTROW |
	 | LoginInfo      | 1 		 | OpenCondo,BlockNumber,1 | CondoAmendment,TargetBlock,12 | OpenCondo,PINFrom,1 | CondoAmendment,TargetPIN,12 | FeesTaxes,RegNumber,2 | CondoAmendment,RegNumber,12 | OpenCondo,BlockNumber,1 | CondoAmendment,BlockNumber,12 | CondoAmendment          | 12               |