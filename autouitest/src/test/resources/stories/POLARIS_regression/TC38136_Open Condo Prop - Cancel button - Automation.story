TC38136_Open Condo Prop - Cancel button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38136_Open Condo Prop - Cancel button - Automation

Narrative:
As a user
I want to Open Condo Prop and Cancel it

Scenario: Scenario 1 Open Condo Prop - Cancel button - Automation

Given LoadTestData UC6413_Open Condominium_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW2>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW2>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2> 
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register
Then verify user navigates to menu Register
When user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME1> and <REGISTERROW2>
And user clicks on ProceedWithReceipt button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW2>
And user navigates to Certify 
Then verify user navigates to menu Certify
When user clicks on the Proceed to Certification button on the Document Selection page <FEESTAXESSHEETNAME2> and <FEESTAXESROW4>
And user click on Certify button on Document Detail page
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4> 
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5> 
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6> 
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7> 
And user navigates to OpenCondominium 
Then verify user navigates to menu Open Condominium
When user cancels the Cancel Open Condominium <OPENCONDOSHEETNAME1> and <OPENCONDOROW12>
And user clicks on cancel button Open Condominium without data entry
Then user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1| CREATEPROPERTYROW2| PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|SOURCE1 			    | TARGET1 			        |SOURCE2 			   | TARGET2    		  |SOURCE3 			   | TARGET3    		    |REGISTERSHEETNAME1|REGISTERROW2|DOCUMENTDETAIL_MAPSHEETNAME1|DOCUMENTDETAIL_MAPROW1|FEESTAXESSHEETNAME1|FEESTAXESROW2|OPENCONDOSHEETNAME1|OPENCONDOROW12|SOURCE4 				|TARGET4				 |SOURCE5  			  |TARGET5				 |SOURCE6   		   |TARGET6 			   |SOURCE7  			  |TARGET7				   |FEESTAXESSHEETNAME2|FEESTAXESROW4|
    | LoginInfo      | 1 	    | CreateProperty		  | 2		          | PropertyDetail_Map		    | 1					   | CreateProperty,Block,2 | PropertyDetail_Map,Block,1|CreateProperty,Block,2|Register,TargetBlock,2|CreateProperty,PIN,2|Register,TargetPINFrom,2|Register		   |2			|DocumentDetail_Map			 |1						|FeesTaxes			|2			  |OpenCondo		  |12		     |CreateProperty,Block,2|OpenCondo,TargetBlock,12|CreateProperty,PIN,2|OpenCondo,TargetPIN,12|FeesTaxes,RegNumber,2|OpenCondo,PlanNumber,12|CreateProperty,Block,2|OpenCondo,BlockNumber,12|FeesTaxes		   |4			 |	
	
