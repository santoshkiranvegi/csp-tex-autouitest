DivideProp_PINEntry_RetrieveWIP_CancelWIP_Cancel_AF
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name DivideProp_PINEntry_RetrieveWIP_CancelWIP_Cancel_AF

Narrative:
As a user
I want to create a Divide Property Retrieve WIP Cancel WIP Cancel button POS Automation

Scenario: Scenario 1 create a Divide Property Retrieve WIP Cancel WIP Cancel button POS Automation

Given LoadTestData UC641_Divide Single Property_RetrieveWIP_CancelWIP_Cancel.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW5>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW5>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE2> and <SERVICECOPYCOLUMNTARGET2> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE3> and <SERVICECOPYCOLUMNTARGET3> 
And user navigates to DivideProperty
Then verify user navigates to menu DivideProperty
When user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW13>
And user click on close button on Property Detail page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE4> and <SERVICECOPYCOLUMNTARGET4> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE5> and <SERVICECOPYCOLUMNTARGET5> 
And user navigates to DivideProperty
And user clicks on Proceed button on DivideProperty RETRIEVEWIP and <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW14>
And user click on close button on Property Detail page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE6> and <SERVICECOPYCOLUMNTARGET6> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE7> and <SERVICECOPYCOLUMNTARGET7> 
And user navigates to DivideProperty
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME3> and <SUBMISSIONROW15>
And user Cancels the Cancel or Cancel WIP on Divide Property Submission page CANCEL
And user clicks on Cancel button on DivideProperty
And user navigates to DivideProperty
And user Cancels the Cancel WIP button on Divide Property Submission page <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW14>
And user clicks Cancel WIP button on Divide Property Submission page OK
And user navigates to DivideProperty
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE8> and <SERVICECOPYCOLUMNTARGET8> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE9> and <SERVICECOPYCOLUMNTARGET9> 
And user clicks on ok on Cancel WIP button on Divide Property Submission page <SUBMISSIONSHEETNAME4> and <SUBMISSIONROW16>
Then user verify error message <SUBMISSIONSHEETNAME4> and <SUBMISSIONROW16>
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE10> and <SERVICECOPYCOLUMNTARGET10> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE11> and <SERVICECOPYCOLUMNTARGET11> 
And user clicks on Proceed button on DivideProperty RETRIEVEWIP and <SUBMISSIONSHEETNAME5> and <SUBMISSIONROW17>
Then user verify error message <SUBMISSIONSHEETNAME5> and <SUBMISSIONROW17>
When user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW6>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE12> and <SERVICECOPYCOLUMNTARGET12> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW4>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW4>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW6>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE13> and <SERVICECOPYCOLUMNTARGET13> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE14> and <SERVICECOPYCOLUMNTARGET14> 
And user navigates to DivideProperty
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME6> and <SUBMISSIONROW18>
And user click on close button on Property Detail page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE15> and <SERVICECOPYCOLUMNTARGET15> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE16> and <SERVICECOPYCOLUMNTARGET16> 
And user navigates to DivideProperty
And user clicks on Proceed button on DivideProperty RETRIEVEWIP and <SUBMISSIONSHEETNAME7> and <SUBMISSIONROW19>
And user click on close button on Property Detail page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE17> and <SERVICECOPYCOLUMNTARGET17> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE18> and <SERVICECOPYCOLUMNTARGET18> 
And user navigates to DivideProperty
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME8> and <SUBMISSIONROW20>
And user Cancels the Cancel or Cancel WIP on Divide Property Submission page CANCEL
And user clicks on Cancel button on DivideProperty
And user navigates to DivideProperty
And user Cancels the Cancel WIP button on Divide Property Submission page <SUBMISSIONSHEETNAME7> and <SUBMISSIONROW19>
And user clicks Cancel WIP button on Divide Property Submission page OK
And user navigates to DivideProperty
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE19> and <SERVICECOPYCOLUMNTARGET19> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE20> and <SERVICECOPYCOLUMNTARGET20> 
And user clicks on ok on Cancel WIP button on Divide Property Submission page <SUBMISSIONSHEETNAME9> and <SUBMISSIONROW21>
Then user verify error message <SUBMISSIONSHEETNAME9> and <SUBMISSIONROW21>
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE21> and <SERVICECOPYCOLUMNTARGET21> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE22> and <SERVICECOPYCOLUMNTARGET22> 
And user clicks on Proceed button on DivideProperty RETRIEVEWIP and <SUBMISSIONSHEETNAME10> and <SUBMISSIONROW22>
Then user verify error message <SUBMISSIONSHEETNAME10> and <SUBMISSIONROW22>
When user clicks on Cancel button on DivideProperty
And user log out of the application

Examples:
	|LOGINSHEETNAME |LOGINROW|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW5|SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1  |PROPERTYDETAILSHEETNAME1|PROPERTYDETAILROW1|SERVICECOPYCOLUMNSOURCE2|SERVICECOPYCOLUMNTARGET2|SERVICECOPYCOLUMNSOURCE3|SERVICECOPYCOLUMNTARGET3|SUBMISSIONSHEETNAME1|SUBMISSIONROW13|SERVICECOPYCOLUMNSOURCE4|SERVICECOPYCOLUMNTARGET4|SERVICECOPYCOLUMNSOURCE5|SERVICECOPYCOLUMNTARGET5|SUBMISSIONSHEETNAME2|SUBMISSIONROW14|SERVICECOPYCOLUMNSOURCE6|SERVICECOPYCOLUMNTARGET6|SERVICECOPYCOLUMNSOURCE7|SERVICECOPYCOLUMNTARGET7|SUBMISSIONSHEETNAME3|SUBMISSIONROW15|SERVICECOPYCOLUMNSOURCE8|SERVICECOPYCOLUMNTARGET8|SERVICECOPYCOLUMNSOURCE9|SERVICECOPYCOLUMNTARGET9|SUBMISSIONSHEETNAME4|SUBMISSIONROW16|SERVICECOPYCOLUMNSOURCE10|SERVICECOPYCOLUMNTARGET10|SERVICECOPYCOLUMNSOURCE11|SERVICECOPYCOLUMNTARGET11|SUBMISSIONSHEETNAME5|SUBMISSIONROW17|CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW6|SERVICECOPYCOLUMNSOURCE12|SERVICECOPYCOLUMNTARGET12 |PROPERTYDETAILSHEETNAME2|PROPERTYDETAILROW4|SERVICECOPYCOLUMNSOURCE13|SERVICECOPYCOLUMNTARGET13|SERVICECOPYCOLUMNSOURCE14|SERVICECOPYCOLUMNTARGET14|SUBMISSIONSHEETNAME6|SUBMISSIONROW18|SERVICECOPYCOLUMNSOURCE15|SERVICECOPYCOLUMNTARGET15|SERVICECOPYCOLUMNSOURCE16|SERVICECOPYCOLUMNTARGET16|SUBMISSIONSHEETNAME7|SUBMISSIONROW19|SERVICECOPYCOLUMNSOURCE17|SERVICECOPYCOLUMNTARGET17|SERVICECOPYCOLUMNSOURCE18|SERVICECOPYCOLUMNTARGET18|SUBMISSIONSHEETNAME8|SUBMISSIONROW20|SERVICECOPYCOLUMNSOURCE19|SERVICECOPYCOLUMNTARGET19|SERVICECOPYCOLUMNSOURCE20|SERVICECOPYCOLUMNTARGET20|SUBMISSIONSHEETNAME9|SUBMISSIONROW21|SERVICECOPYCOLUMNSOURCE21|SERVICECOPYCOLUMNTARGET21|SERVICECOPYCOLUMNSOURCE22|SERVICECOPYCOLUMNTARGET22|SUBMISSIONSHEETNAME10|SUBMISSIONROW22|
	|LoginInfo      |1       |CreateProperty          |5                 |CreateProperty,Block,5  |PropertyDetail_Map,Block,1|PropertyDetail_Map      |1                 |CreateProperty,Block,5  |Submission,Block,13     |CreateProperty,PIN,5    |Submission,PIN,13       |Submission          |13             |CreateProperty,Block,5  |Submission,Block,14     |CreateProperty,PIN,5    |Submission,PIN,14       |Submission          |14             |CreateProperty,Block,5  |Submission,Block,15     |CreateProperty,PIN,5    |Submission,PIN,15       |Submission          |15             |CreateProperty,Block,5  |Submission,Block,16     |CreateProperty,PIN,5    |Submission,PIN,16       |Submission          |16             |CreateProperty,Block,5   |Submission,Block,17      |CreateProperty,PIN,5     |Submission,PIN,17        |Submission          |17             |CreateProperty          |6                 |CreateProperty,Block,6   |PropertyDetail_Map,Block,4|PropertyDetail_Map      |4                 |CreateProperty,Block,6   |Submission,Block,18      |CreateProperty,PIN,6     |Submission,PIN,18        |Submission          |18             |CreateProperty,Block,6   |Submission,Block,19      |CreateProperty,PIN,6     |Submission,PIN,19        |Submission          |19             |CreateProperty,Block,6   |Submission,Block,20      |CreateProperty,PIN,6     |Submission,PIN,20        |Submission          |20             |CreateProperty,Block,6   |Submission,Block,21      |CreateProperty,PIN,6     |Submission,PIN,21        |Submission          |21             |CreateProperty,Block,6   |Submission,Block,22      |CreateProperty,PIN,6     | Submission,PIN,22       |Submission           |22             |       
	                  