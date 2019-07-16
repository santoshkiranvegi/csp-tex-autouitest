TC38395_PIN Entry - Cancel button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38395_PIN Entry - Cancel button - Automation

Narrative:
As a user
I want to enter the pin and click cancel button

Scenario: Scenario1 TC38395_PIN Entry - Cancel button - Automation

Given LoadTestData UC671_UpdatePropertyBulk_PINEntry_CancelButton.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty  
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register 
Then verify user navigates to menu Register
When user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME1> and <REGISTERROW1>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW1>
And user navigates to Certify 
Then verify user navigates to menu Certify
When user clicks on the Proceed to Certification button on the Document Selection page <FEESTAXESSHEETNAME2> and <FEESTAXESROW2>
And user click on Certify button on Document Detail page
And user navigates to UpdateCertifiedPropertyBulk 
Then verify user navigates to menu Update Certified Property Bulk
When user cancels the Cancel Update Certified Property Bulk
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user cancels the Cancel Update Certified Property Bulk <PINENTRYSHEETNAME1> and <PINENTRYROW1>
And user clicks on Cancel button on Update Certified Property Bulk
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user navigates to UpdateCertifiedPropertyBulk 
And user cancels the Cancel Update Certified Property Bulk <PINENTRYSHEETNAME2> and <PINENTRYROW2>
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7>
And user cancels the Cancel Update Certified Property Bulk <PINENTRYSHEETNAME3> and <PINENTRYROW3>
And user clicks on Cancel button on Update Certified Property Bulk
And user navigates to UpdateCertifiedPropertyBulk 
And user clicks on Cancel button on Update Certified Property Bulk
And user navigates to UpdateCertifiedPropertyBulk 
And user clicks on Cancel button on Update Certified Property Bulk <PINENTRYSHEETNAME1> and <PINENTRYROW1>
And user navigates to UpdateCertifiedPropertyBulk  
And user clicks on Cancel button on Update Certified Property Bulk <PINENTRYSHEETNAME2> and <PINENTRYROW2>
And user navigates to UpdateCertifiedPropertyBulk 
And user clicks on Cancel button on Update Certified Property Bulk <PINENTRYSHEETNAME3> and <PINENTRYROW3>
Then user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1| CREATEPROPERTYROW1| PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|SOURCE1 			    | TARGET1 				    |SOURCE2 			   | TARGET2    		  |SOURCE3 			   | TARGET3    		    |REGISTERSHEETNAME1|REGISTERROW1|FEESTAXESSHEETNAME1|FEESTAXESROW1|PINENTRYSHEETNAME1|PINENTRYROW1|PINENTRYSHEETNAME2|PINENTRYROW2|PINENTRYSHEETNAME3|PINENTRYROW3|SOURCE4 			     | TARGET4    		    |SOURCE5 			 | TARGET5    		      |SOURCE6 			    | TARGET6    		       |SOURCE7 			 | TARGET7    		        |FEESTAXESSHEETNAME2|FEESTAXESROW2|
	| LoginInfo      | 1 	    | CreateProperty		  | 1			      | PropertyDetail_Map		    | 1					   | CreateProperty,Block,1 | PropertyDetail_Map,Block,1|CreateProperty,Block,1|Register,TargetBlock,1|CreateProperty,PIN,1|Register,TargetPINFrom,1|Register		   |1			|FeesTaxes			|1			  |	PINEntry		 |1			  |	PINEntry		 |2			  |PINEntry			 |3			  |CreateProperty,Block,1|PINEntry,TargetBlock,1|CreateProperty,PIN,1|PINEntry,TargetPINFrom,1|FeesTaxes,RegNumber,2|PINEntry,RegistrationNum,2|FeesTaxes,RegNumber,2|PINEntry,RegistrationNum,3|FeesTaxes			|2            |
	