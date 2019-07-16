TC37969_Re-enter_Property_RetrieveWIP_Cancel_WIP_Cancel
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37969_Re-enter_Property_RetrieveWIP_Cancel_WIP_Cancel

Narrative:
As a user 
I want to create a Re-enter Property RetrieveWIP Cancel WIP Automation

Scenario: Scenario 1 create a Re-enter Property RetrieveWIP Cancel WIP Automation

Given LoadTestData UC643_ReEnter Property_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to ReEnterProperty
And user cancels the Cancel Re-enter Property
And user cancels the Re-enter Property <SUBMISSIONSHEETNAME> and <SUBMISSIONROW14>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW6>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1> 
And user clicks on the Proceed button on property detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROW6>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROW6>
And user click on ParcelConfirmation to create Certify Certify and <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW6>
And user clicks on Close button on propertymapmaintenanceRequest page
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE2> and <SERVICECOPYCOLUMNTARGET2> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE3> and <SERVICECOPYCOLUMNTARGET3> 
And user navigates to ReEnterProperty
And user clicks the Retrieve WIP button on the Submission page <SUBMISSIONSHEETNAME> and <SUBMISSIONROW15>
And user cancels the Re-enter Property
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE4> and <SERVICECOPYCOLUMNTARGET4> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE5> and <SERVICECOPYCOLUMNTARGET5> 
And user navigates to ReEnterProperty
And user clicks cancelWIP on the Re-enter Property CANCEL and <SUBMISSIONSHEETNAME> and <SUBMISSIONROW16>
And user clicks cancelWIP on the Re-enter Property OK and <SUBMISSIONSHEETNAME> and <SUBMISSIONROW17>
And user cancels the Re-enter Property
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE6> and <SERVICECOPYCOLUMNTARGET6> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE7> and <SERVICECOPYCOLUMNTARGET7> 
And user navigates to ReEnterProperty
And user clicks on the Proceed button on the Submission page <SUBMISSIONSHEETNAME> and <SUBMISSIONROW18>
And user clicks Save button on PropertyDetail page
And user clicks Close button on PropertyDetail page
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE8> and <SERVICECOPYCOLUMNTARGET8> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE9> and <SERVICECOPYCOLUMNTARGET9> 
And user navigates to ReEnterProperty
And user clicks on the Proceed button on the Submission page <SUBMISSIONSHEETNAME> and <SUBMISSIONROW19>
And user clicks RetrieveWIP button on ReEnterPropertyRetrieve page
And user clicks Close button on PropertyDetail page
Then verify user navigates to main menu
When user navigates to ReEnterProperty
And user clicks cancelWIP on the Re-enter Property CANCEL and <SUBMISSIONSHEETNAME> and <SUBMISSIONROW18>
And user clicks OK button on CancelWIP on the ReEnterProperty page
Then verify user navigates to main menu
When user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE12> and <SERVICECOPYCOLUMNTARGET12> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE13> and <SERVICECOPYCOLUMNTARGET13> 
And user navigates to ReEnterProperty
And user clicks cancelWIP on the Re-enter Property OK and <SUBMISSIONSHEETNAME> and <SUBMISSIONROW20>
And user clicks the Retrieve WIP button on the Submission page <SUBMISSIONSHEETNAME> and <SUBMISSIONROW21>
And user cancels the Re-enter Property
And user log out of the application


Examples:
	|LOGINSHEETNAME |LOGINROW|SUBMISSIONSHEETNAME|SUBMISSIONROW14|CREATEPROPERTYSHEETNAME|CREATEPROPERTYROW6|SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1  |PROPERTYDETAILSHEETNAME |PROPERTYDETAILROW6|SERVICECOPYCOLUMNSOURCE2|SERVICECOPYCOLUMNTARGET2 |SERVICECOPYCOLUMNSOURCE3|SERVICECOPYCOLUMNTARGET3|SUBMISSIONROW15|SERVICECOPYCOLUMNSOURCE4|SERVICECOPYCOLUMNTARGET4 |SERVICECOPYCOLUMNSOURCE5|SERVICECOPYCOLUMNTARGET5|SUBMISSIONROW16|SUBMISSIONROW17|SERVICECOPYCOLUMNSOURCE6|SERVICECOPYCOLUMNTARGET6 |SERVICECOPYCOLUMNSOURCE7|SERVICECOPYCOLUMNTARGET7|SUBMISSIONROW18|SERVICECOPYCOLUMNSOURCE8|SERVICECOPYCOLUMNTARGET8 |SERVICECOPYCOLUMNSOURCE9|SERVICECOPYCOLUMNTARGET9|SUBMISSIONROW19|SUBMISSIONROW18|SUBMISSIONROW20|SUBMISSIONROW21|SERVICECOPYCOLUMNSOURCE12|SERVICECOPYCOLUMNTARGET12|SERVICECOPYCOLUMNSOURCE13|SERVICECOPYCOLUMNTARGET13|
	|LoginInfo      |1       |Submission          |14            |CreateProperty          |6               |CreateProperty,Block,6 |PropertyDetail_Map,Block,6|PropertyDetail_Map      |6                 |CreateProperty,Block,6 |Submission,TargetBlock,15|CreateProperty,PIN,6   |Submission,TargetPIN,15     |15             |CreateProperty,Block,6  |Submission,TargetBlock,16|CreateProperty,PIN,6    |Submission,TargetPIN,16 |16            | 17             |CreateProperty,Block,6  |Submission,TargetBlock,18|CreateProperty,PIN,6   |Submission,TargetPIN,18 |18             |CreateProperty,Block,6  |Submission,TargetBlock,19|CreateProperty,PIN,6    |Submission,TargetPIN,19 |19             |18              |20             |21             |CreateProperty,Block,6   |Submission,TargetBlock,20|CreateProperty,PIN,6     |Submission,TargetPIN,20  |
	
	
								