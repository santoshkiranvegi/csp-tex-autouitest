TC37992_Open Subdiv Prop - Cancel button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37992_Open Subdiv Prop - Cancel button - Automation

Narrative:
As a user
I want to open subdiv prop and cancel it 

Scenario: Scenario1 I want to open subdiv prop and cancel it.
Given LoadTestData UC6412_Open Subdivision_Online_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And user copies column data from source and paste it in target <SOURCE> and <TARGET>
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user click on ParcelConfirmation to create Certify CREATE and <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to Register
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME> and <REGISTERROWINDEX1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROWINDEX>
And user click on Complete Registration button on the Fees and Taxes page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user navigates to Certify
And user clicks on Proceed to Certification button on Document Selection page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX6>
And user clicks on Certify button on Document Detail page
And user navigates to OpenSubdivision
And user Cancel the Cancel Open Subdivision
And user Cancel Open Subdivision
Then verify user navigates to main menu
When user navigates to OpenSubdivision
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user Cancel the Cancel Open Subdivision <OPENSUBDIVISIONSHEETNAME> and <OPENSUBDIVISIONROWINDEX>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7>
And user Cancel the Cancel Open Subdivision <OPENSUBDIVISIONSHEETNAME1> and <OPENSUBDIVISIONROWINDEX1>
And user Cancel Open Subdivision
Then verify user navigates to main menu
When user log out of the application

Examples:
	|LOGINSHEETNAME |LOGINROW|CREATEPROPERTYSHEETNAME|CREATEPROPERTYROW|SOURCE                 |TARGET                    |PROPERTYDETAILSHEETNAME|PROPERTYDETAILROWINDEX|SOURCE1                 |TARGET1                 |SOURCE2                 |TARGET2                 |REGISTERSHEETNAME|REGISTERROWINDEX1|DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROWINDEX|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|SOURCE3                 |TARGET3                      |SOURCE4                 |TARGET4                    |OPENSUBDIVISIONSHEETNAME|OPENSUBDIVISIONROWINDEX|SOURCE5                 |TARGET5                      |SOURCE6                 |TARGET6                    |SOURCE7                 |TARGET7                     |OPENSUBDIVISIONSHEETNAME1|OPENSUBDIVISIONROWINDEX1|FEESTAXESSHEETNAME | FEESTAXESROWINDEX6 | 
	|LoginInfo      |1       |CreateProperty         |1                |CreateProperty,Block,1 |PropertyDetail_Map,Block,1|PropertyDetail_Map     |1                     |CreateProperty,Block,1  |Register,TargetBlock,1  |CreateProperty,PIN,1    |Register,TargetPINFrom,1|Register         |1                |DocumentDetail_Map     |1                     |FeesTaxes         |1                |CreateProperty,Block,1  |OpenSubdivision,TargetBlock,1|CreateProperty,PIN,1    |OpenSubdivision,TargetPIN,1|OpenSubdivision         |1                      |CreateProperty,Block,1  |OpenSubdivision,TargetBlock,2|CreateProperty,PIN,1    |OpenSubdivision,TargetPIN,2|FeesTaxes,RegNumber,1   |OpenSubdivision,PlanNumber,2|OpenSubdivision          |2                       | FeesTaxes         | 6                  | 