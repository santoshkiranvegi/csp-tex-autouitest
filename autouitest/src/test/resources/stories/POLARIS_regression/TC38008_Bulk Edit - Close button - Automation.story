TC38008_Bulk Edit - Close button - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38008_Bulk Edit - Close button - Automation

Narrative:
As a user
I want to bulk edit close button   

Scenario: TC38008_Bulk Edit - Close button - Automation

Given LoadTestData UC6412_Open Subdivision_BulkEdit.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW2>  
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>  
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1> 
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW2>  
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2> 
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3> 
And user navigates to Register
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME1> and <REGISTERROW2>  
And user clicks on ProceedWithReceipt button on Document Detail page <DOCUMENTDETAIL_MAPSHEETNAME1> and <DOCUMENTDETAIL_MAPROW3> 
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW2> 
And user navigates to Certify 
And user clicks on the Proceed to Certification button on the Document Selection page <FEESTAXESSHEETNAME1> and <FEESTAXESROW2> 
And user click on Certify button on Document Detail page
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>  
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>  
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>  
And user navigates to OpenSubdivision 
And user clicks Proceed in OpenSubdivision <OPENSUBDIVISIONSHEETNAME1> and <OPENSUBDIVISIONROW3>
And user clicks the Cancel on the Close popup on Property Detail page
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7> 
And user navigates to OpenSubdivision 
And user clicks the Retrieve WIP button on the Open Subdivision page <OPENSUBDIVISIONSHEETNAME1> and <OPENSUBDIVISIONROW4> 
And user clicks Close button on PropertyDetail page for bulk edit <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW6>
Then user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW | CREATEPROPERTYSHEETNAME1| CREATEPROPERTYROW2| PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|SOURCE1 			    | TARGET1 				    |SOURCE2 			   | TARGET2    		  |SOURCE3 			   | TARGET3    		    |REGISTERSHEETNAME1|REGISTERROW2|DOCUMENTDETAIL_MAPSHEETNAME1|DOCUMENTDETAIL_MAPROW3|FEESTAXESSHEETNAME1|FEESTAXESROW2|OPENSUBDIVISIONSHEETNAME1|OPENSUBDIVISIONROW3|OPENSUBDIVISIONSHEETNAME2|OPENSUBDIVISIONROW4|SOURCE4 				  |TARGET4				        |SOURCE5  			  |TARGET5				      |SOURCE6   		    |TARGET6 			         |SOURCE7  			   |TARGET7				        |FEESTAXESSHEETNAME2|FEESTAXESROW4|PROPERTYDETAIL_MAPSHEETNAME2|PROPERTYDETAIL_MAPROW6|
    | LoginInfo      | 1 	    | CreateProperty		  | 2			      | PropertyDetail_Map		    | 1					   | CreateProperty,Block,2 | PropertyDetail_Map,Block,1|CreateProperty,Block,2|Register,TargetBlock,2|CreateProperty,PIN,2|Register,TargetPINFrom,2|Register		   |2			|DocumentDetail_Map			 |3						|FeesTaxes	    	|2		      |OpenSubdivision          | 3                 |OpenSubdivision	      |4				  |CreateProperty,Block,2 |OpenSubdivision,TargetBlock,3|CreateProperty,PIN,2 |OpenSubdivision,TargetPIN,3|FeesTaxes,RegNumber,2|OpenSubdivision,PlanNumber,3|FeesTaxes,RegNumber,2|OpenSubdivision,PlanNumber,4|FeesTaxes		    |4			  |	PropertyDetail_Map		   |6					  |
	
