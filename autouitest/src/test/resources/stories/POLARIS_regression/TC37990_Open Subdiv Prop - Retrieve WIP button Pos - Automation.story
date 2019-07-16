TC37990_Open Subdiv Prop - Retrieve WIP button Pos - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37990_Open Subdiv Prop - Retrieve WIP button Pos - Automation

Narrative:
As a user
I want to Open Subdiv Prop and Retrieve WIP button  

Scenario: Scenario1 I want to Open Subdiv Prop and Retrieve WIP button   
Given LoadTestData UC6412_Open Subdivision_Online_02.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty   
And user clicks on the Proceed button on the CreatProperty <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW> 
And user copies column data from source and paste it in target <SOURCE> and <TARGET>
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX>
And user clicks on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROWINDEX1>
And user click Close button on property Map Maintenance Request page
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME> and <REGISTERROWINDEX1>
And user clicks on Proceed With Receipt button on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROWINDEX>
And user click on Complete Registration button on the Fees and Taxes page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user navigates to Certify 
And user clicks on Proceed to Certification button on Document Selection page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user clicks on Certify button on Document Detail page
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user navigates to OpenSubdivision
And user clicks Proceed in OpenSubdivision <OPENSUBDIVISIONSHEETNAME> and <OPENSUBDIVISIONROWINDEX>
And user clicks the Cancel on the Close popup on Property Detail page
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SOURCE7> and <TARGET7>
And user navigates to OpenSubdivision
And user clicks the Retrieve WIP button on the Open Subdivision page <OPENSUBDIVISIONSHEETNAME1> and <OPENSUBDIVISIONROWINDEX1>
And user Edit property details for multiple tabs on property detail page in bulk edit mode <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROWINDEX2>
And user clicks Single Edit on Property Detail page
And Click Proceed button on Property Detail page
And user clicks on Proceed To Confirmation button on Print Parcel page
And user clicks on the Close Property Detail page
And user navigates to OpenSubdivision
And user clicks the Retrieve WIP button on the Open Subdivision page <OPENSUBDIVISIONSHEETNAME1> and <OPENSUBDIVISIONROWINDEX1>
And user clicks the Cancel on the Close popup on Property Detail page
And user log out of the application

Examples:
	|LOGINSHEETNAME |LOGINROW|CREATEPROPERTYSHEETNAME|CREATEPROPERTYROW|SOURCE                |TARGET                    |PROPERTYDETAILSHEETNAME|PROPERTYDETAILROWINDEX|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROWINDEX1|SOURCE2                |TARGET2                    |SOURCE3                |TARGET3                    |REGISTERSHEETNAME|REGISTERROWINDEX1|DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROWINDEX|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|SOURCE4               |TARGET4                      |SOURCE5             |TARGET5                    |SOURCE6              |TARGET6                     |OPENSUBDIVISIONSHEETNAME|OPENSUBDIVISIONROWINDEX|SOURCE7              |TARGET7	                   |PROPERTYDETAILSHEETNAME2|PROPERTYDETAILROWINDEX2|OPENSUBDIVISIONSHEETNAME1|OPENSUBDIVISIONROWINDEX1|
	|LoginInfo      |1       |CreateProperty         |1                |CreateProperty,Block,1|PropertyDetail_Map,Block,1|PropertyDetail_Map     |1                     |CreateProperty          |1                      |CreateProperty,Block,1 |Register,TargetBlock,1     |CreateProperty,PIN,1   |Register,TargetPINFrom,1   |Register         |1                |DocumentDetail_Map     |1                     |FeesTaxes         |1                |CreateProperty,Block,1|OpenSubdivision,TargetBlock,1|CreateProperty,PIN,1|OpenSubdivision,TargetPIN,1|FeesTaxes,RegNumber,1|OpenSubdivision,PlanNumber,1|OpenSubdivision         |1                      |FeesTaxes,RegNumber,1|OpenSubdivision,PlanNumber,2 |PropertyDetail_Map      |2                      |OpenSubdivision          |2                       |
	
	
	
	