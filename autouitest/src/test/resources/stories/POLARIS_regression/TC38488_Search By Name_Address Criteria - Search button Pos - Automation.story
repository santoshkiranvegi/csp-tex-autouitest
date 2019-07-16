TC38488_Search By Name_Address Criteria - Search button Pos - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38488_Search By Name_Address Criteria - Search button Pos - Automation

Narrative:
As a user Search By Name_Address Criteria  and Search button
I want to  

Scenario1: TC38488_Search By Name_Address Criteria - Search button Pos - Automation

Given LoadTestData UC31_Search_NameAddress.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user click on Proceed button on the Create Property page <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2> 
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3> 
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME1> and <REGISTERROW1>
And user clicks on ProceedWithReceipt button on Document Detail <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW1>
And user navigates to Certify 
And user clicks on the Proceed to Certification button on the Document Selection <FEESTAXESSHEETNAME1> and <FEESTAXESROW1> 
And user clicks on Certify button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME2> and <DOCUMENTDETAIL_MAPROW2>
And user clicks on Commit button on Property Maintenance page
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4> 
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5> 
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME2> and <REGISTERROW2>
And user clicks on ProceedWithReceipt button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW1>
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME2> and <FEESTAXESROW2> 
And user navigates to Certify 
And user clicks on the Proceed to Certification button on the Document Selection <FEESTAXESSHEETNAME2> and <FEESTAXESROW2> 
And user clicks on Certify button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME2> and <DOCUMENTDETAIL_MAPROW2>
And user clicks on Commit button on Property Maintenance page
And user navigates to SearchNameAddress 
And user clicks on Search button on Search page with <SEARCHSHEETNAME1> and <SEARCHROW12>
And user clicks on New Search button on Result for Search by Address or Result for Search by Name/Address page
And user clicks on Search button on Search page with <SEARCHSHEETNAME2> and <SEARCHROW13>
And user clicks on a street name link on Result for Search by Address page <SEARCHSHEETNAME3> and <SEARCHROW14>
And user clicks on Select Different Street button on Result for Search by Name/Address page
And user clicks on New Search button on Result for Search by Address or Result for Search by Name/Address page
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6> 
And user clicks on Search button on Search page with <SEARCHSHEETNAME4> and <SEARCHROW15>
And user clicks on New Search button on Result for Search by Address or Result for Search by Name/Address page
And user clicks on OK button on Search by Name/Address page with/without data entry OK
Then user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1| CREATEPROPERTYROW1| PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|SOURCE1 			  | TARGET1 			     |SOURCE2 			    | TARGET2 			   |SOURCE3 		    | TARGET3 			     |SOURCE4 		        | TARGET4 			   |SOURCE5 		    | TARGET5 			     |SOURCE6 		    | TARGET6 			         |REGISTERSHEETNAME1|REGISTERROW1|REGISTERSHEETNAME2|REGISTERROW2|DOCUMENTDETAIL_MAPSHEETNAME1|DOCUMENTDETAIL_MAPROW1|DOCUMENTDETAIL_MAPSHEETNAME2|DOCUMENTDETAIL_MAPROW2|DOCUMENTDETAIL_MAPSHEETNAME3|DOCUMENTDETAIL_MAPROW3|FEESTAXESSHEETNAME1|FEESTAXESROW1|FEESTAXESSHEETNAME2|FEESTAXESROW2|SEARCHSHEETNAME1|SEARCHROW12|SEARCHSHEETNAME2|SEARCHROW13|SEARCHSHEETNAME3|SEARCHROW14|SEARCHSHEETNAME4|SEARCHROW15|
    | LoginInfo      | 1 	    | CreateProperty		  | 1			      | PropertyDetail_Map		    | 1					   |CreateProperty,Block,1|PropertyDetail_Map,Block,1|CreateProperty,Block,1|Register,TargetBlock,1|CreateProperty,PIN,1|Register,TargetPINFrom,1|CreateProperty,Block,1|Register,TargetBlock,2|CreateProperty,PIN,1|Register,TargetPINFrom,2|Parties,PartyTo,1 |Search,LastNameOrCorpName,15|Register			|1			 |Register			|2			 |DocumentDetail_Map		  |1					 |DocumentDetail_Map		  |2					 |DocumentDetail_Map		  |3					 |FeesTaxes			 |1			   |FeesTaxes		   |2			 |Search		  |12	      |	Search		   |13		   |Search			|14			|Search			 |15		 |			
	 
