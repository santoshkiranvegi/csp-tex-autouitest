TC37768_Divide Property - Proceed button Neg
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37768_Divide Property - Proceed button Neg

Narrative:
As a user
I want to create divide property and click proceed button

Scenario: Scenario1 TC37768_Divide Property - Proceed button Neg

Given LoadTestData UC641_Divide Single Property_ProceedNeg.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW1>
Then user verify error message <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW1>
When user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW2>
Then user verify error message <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW2>
When user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME3> and <SUBMISSIONROW3>
Then user verify error message <SUBMISSIONSHEETNAME3> and <SUBMISSIONROW3>
When user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1> 
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1> 
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME4> and <SUBMISSIONROW4>
And user click on the OK button on the Cancel on Property Detail page
And user navigates to DivideProperty 
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME5> and <SUBMISSIONROW5>
Then user verify error message <SUBMISSIONSHEETNAME5> and <SUBMISSIONROW5>
When user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2>
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page strFunction and <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2> 
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7>
And user copies column data from source and paste it in target <SOURCE8> and <TARGET8>
And user navigates to CorrectUpdateCertifiedProperty 
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <SUBMISSIONSHEETNAME6> and <SUBMISSIONROW6>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME2> and <PROPERTYDETAIL_MAPROW2>
And user copies column data from source and paste it in target <SOURCE9> and <TARGET9>
And user copies column data from source and paste it in target <SOURCE10> and <TARGET10>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME7> and <SUBMISSIONROW7>
And user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3> 
And user copies column data from source and paste it in target <SOURCE11> and <TARGET11>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page strFunction and <CREATEPROPERTYSHEETNAME3> and <CREATEPROPERTYROW3> 
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE12> and <TARGET12>
And user copies column data from source and paste it in target <SOURCE13> and <TARGET13>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME8> and <SUBMISSIONROW8>
Then user verify error message <SUBMISSIONSHEETNAME8> and <SUBMISSIONROW8>
When user clicks on Cancel button on DivideProperty
And user copies column data from source and paste it in target <SOURCE14> and <TARGET14>
And user copies column data from source and paste it in target <SOURCE15> and <TARGET15>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME9> and <SUBMISSIONROW9>
Then user verify error message <SUBMISSIONSHEETNAME9> and <SUBMISSIONROW9>
When user clicks on Cancel button on DivideProperty
And user copies column data from source and paste it in target <SOURCE16> and <TARGET16>
And user copies column data from source and paste it in target <SOURCE17> and <TARGET17>
And user navigates to CorrectUpdateCertifiedProperty 
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <SUBMISSIONSHEETNAME10> and <SUBMISSIONROW10>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME3> and <PROPERTYDETAIL_MAPROW3>
And user copies column data from source and paste it in target <SOURCE18> and <TARGET18>
And user copies column data from source and paste it in target <SOURCE19> and <TARGET19>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME11> and <SUBMISSIONROW11>
Then user verify error message <SUBMISSIONSHEETNAME11> and <SUBMISSIONROW11>
When user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW4>
And user click on Proceed button on Property Detail page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME1> and <PROPERTYDETAIL_MAPROW1>
And user click on Certify button on Print Parcel Confirmation page strFunction and <CREATEPROPERTYSHEETNAME4> and <CREATEPROPERTYROW4>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE20> and <TARGET20>
And user copies column data from source and paste it in target <SOURCE21> and <TARGET21>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <REGISTERSHEETNAME1> and <REGISTERROW1> 
And user clicks on Proceed with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes <REGISTERSHEETNAME1> and <REGISTERROW1>
And user copies column data from source and paste it in target <SOURCE22> and <TARGET22>
And user copies column data from source and paste it in target <SOURCE23> and <TARGET23>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME12> and <SUBMISSIONROW12>
Then user verify error message <SUBMISSIONSHEETNAME12> and <SUBMISSIONROW12>
And user verifies the UI object exist Cancel and <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
When user Perform an action on the specified UI object <UIOBJECTSHEETNAME1> and <UIOBJECTROW1>
And user log out of the application

Examples:

	|LOGINSHEETNAME |LOGINROW|SUBMISSIONSHEETNAME1|SUBMISSIONROW1|SUBMISSIONSHEETNAME2|SUBMISSIONROW2|SUBMISSIONSHEETNAME3|SUBMISSIONROW3|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW1|SOURCE1               |TARGET1                   |PROPERTYDETAIL_MAPSHEETNAME1|PROPERTYDETAIL_MAPROW1|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW1|SOURCE2               |TARGET2           |SOURCE3             |TARGET3         |SUBMISSIONSHEETNAME4|SUBMISSIONROW4|SOURCE4               |TARGET4           |SOURCE5             |TARGET5         |SUBMISSIONSHEETNAME5|SUBMISSIONROW5|CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW2|SOURCE6               |TARGET6           		 |SOURCE7               |TARGET7        	 |SUBMISSIONSHEETNAME6|SUBMISSIONROW6| PROPERTYDETAIL_MAPSHEETNAME2|PROPERTYDETAIL_MAPROW2|SOURCE8             |TARGET8          |SOURCE9               |TARGET9           |SUBMISSIONSHEETNAME7|SUBMISSIONROW7|CREATEPROPERTYSHEETNAME3|CREATEPROPERTYROW3|SOURCE10              |TARGET10        |SOURCE11              |TARGET11                  |SUBMISSIONSHEETNAME8|SUBMISSIONROW8|SOURCE12              |TARGET12          |SOURCE13            |TARGET13        |SUBMISSIONSHEETNAME9|SUBMISSIONROW9|SOURCE14              |TARGET14              |SOURCE15            |TARGET15        |SUBMISSIONSHEETNAME10|SUBMISSIONROW10|PROPERTYDETAIL_MAPSHEETNAME3|PROPERTYDETAIL_MAPROW3|REGISTERSHEETNAME1|REGISTERROW1 |SOURCE16              |TARGET16           |SOURCE17            |TARGET17         |SUBMISSIONSHEETNAME11|SUBMISSIONROW11|CREATEPROPERTYSHEETNAME4|CREATEPROPERTYROW4|UIOBJECTSHEETNAME1|UIOBJECTROW1|SUBMISSIONSHEETNAME12|SUBMISSIONROW12|SOURCE18 			  | TARGET18		  |SOURCE19			   |TARGET19         |SOURCE20			    |TARGET20			   |SOURCE21		    |TARGET21				 |SOURCE22			    |TARGET22			|SOURCE23			 |TARGET23		   |
	|LoginInfo      |1       |Submission	      |1             |Submission          |2             |Submission	      |3             |CreateProperty          |1                 |CreateProperty,Block,1|PropertyDetail_Map,Block,1|PropertyDetail_Map          |1                     |CreateProperty          |1                 |CreateProperty,Block,5|Submission,Block,4|CreateProperty,PIN,5|Submission,PIN,4|Submission          |4             |CreateProperty,Block,1|Submission,Block,5|CreateProperty,PIN,1|Submission,PIN,5|Submission          |5             |CreateProperty          |2                 |CreateProperty,Block,2|PropertyDetail_Map,Block,1|CreateProperty,Block,5|Submission,Block,6  |Submission          |6             |	PropertyDetail_Map		   | 2				      |CreateProperty,PIN,5|Submission,PIN,6 |CreateProperty,Block,2|Submission,Block,7|Submission          |7             |CreateProperty			|	3			   |CreateProperty,PIN,2  |Submission,PIN,7|CreateProperty,Block,3|PropertyDetail_Map,Block,1|Submission          |8             |CreateProperty,Block,3|Submission,Block,8|CreateProperty,PIN,3|Submission,PIN,8|Submission          |9             |CreateProperty,Block,3|Submission,Block,9    |CreateProperty,PIN,3|Submission,PIN,9|Submission           |10             |PropertyDetail_Map          |3				       | Register         |1            |CreateProperty,Block,5|Submission,Block,10|CreateProperty,PIN,5|Submission,PIN,10|Submission           |11             |CreateProperty		     |4                 |UIObject          |1            |Submission          |12             | CreateProperty,Block,3|Submission,Block,11|CreateProperty,PIN,3|Submission,PIN,11|CreateProperty,Block,6|Register,TargetBlock,1|CreateProperty,PIN,6|Register,TargetPINFrom,1|CreateProperty,Block,4|Submission,Block,12|CreateProperty,PIN,4|Submission,PIN,12|
