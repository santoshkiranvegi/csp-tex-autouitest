TC37769_Divide_Property_Proceed_button_POS_Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37769_Divide_Property_Proceed_button_POS_Automation

Narrative:
As a user
I want to create a Divide Property Proceed button POS Automation

Scenario: Scenario 1 create a Divide Property Proceed button POS Automation

Given LoadTestData UC641_Divide Single Property_ProceedPos.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW7>
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1> 
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW7>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE2> and <SERVICECOPYCOLUMNTARGET2> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE3> and <SERVICECOPYCOLUMNTARGET3> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE4> and <SERVICECOPYCOLUMNTARGET4> 
And user navigates to DivideProperty
Then verify user navigates to menu DivideProperty
When user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW23>
And user clicks on Save button on PropertyDetail page for bulk edit <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW5>
And user clicks single edit button on property details page
And user clicks on the Proceed button on property detail page
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW5>
And user clicks Next Property button on the parcel confirmation page <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW5>
And user clicks Next Property button on the parcel confirmation page <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW5>
And user click on Certify button on Print Parcel Confirmation page DIVIDE and <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW23>
And user click Close button on property Map Maintenance Request page
And user navigates to CreateProperty
Then verify user navigates to menu CreateProperty
When user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW8>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE5> and <SERVICECOPYCOLUMNTARGET5> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE6> and <SERVICECOPYCOLUMNTARGET6> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW4>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW4>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW8>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE7> and <SERVICECOPYCOLUMNTARGET7> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE8> and <SERVICECOPYCOLUMNTARGET8> 
And user navigates to DivideProperty
Then verify user navigates to menu DivideProperty
When user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW24>
And user clicks on Save button on PropertyDetail page for bulk edit <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW6>
And user clicks single edit button on property details page
And user clicks on the Proceed button on property detail page
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW6>
And user clicks Next Property button on the parcel confirmation page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW6>
And user clicks Next Property button on the parcel confirmation page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW6>
And user click on Certify button on Print Parcel Confirmation page DIVIDE and <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW24>
And user click Close button on property Map Maintenance Request page
And user log out of the application

Examples:

	|LOGINSHEETNAME |LOGINROW|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW7|PROPERTYDETAILSHEETNAME1|PROPERTYDETAILROW1|SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1  |SERVICECOPYCOLUMNSOURCE2|SERVICECOPYCOLUMNTARGET2|SERVICECOPYCOLUMNSOURCE3|SERVICECOPYCOLUMNTARGET3|SERVICECOPYCOLUMNSOURCE4|SERVICECOPYCOLUMNTARGET4   |SUBMISSIONSHEETNAME1 |SUBMISSIONROW23|PROPERTYDETAILSHEETNAME2 | PROPERTYDETAILROW5|CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW8|SERVICECOPYCOLUMNSOURCE5|SERVICECOPYCOLUMNTARGET5  |SERVICECOPYCOLUMNSOURCE6|SERVICECOPYCOLUMNTARGET6   |PROPERTYDETAILSHEETNAME3|PROPERTYDETAILROW4|SERVICECOPYCOLUMNSOURCE7|SERVICECOPYCOLUMNTARGET7|SERVICECOPYCOLUMNSOURCE8|SERVICECOPYCOLUMNTARGET8|SUBMISSIONSHEETNAME2  |SUBMISSIONROW24|PROPERTYDETAILSHEETNAME4|PROPERTYDETAILROW6|
	|LoginInfo      |1       |CreateProperty          |7                 |PropertyDetail_Map      |1                 |CreateProperty,Block,7  |PropertyDetail_Map,Block,1|CreateProperty,Block,7  |Submission,Block,23      |CreateProperty,PIN,7    |Submission,PIN,23       | CreateProperty,Block,7 |PropertyDetail_Map,Block,5|Submission           |23             |PropertyDetail_Map       |5                  |CreateProperty          |8                 |CreateProperty,Block,8  |PropertyDetail_Map,Block,4|CreateProperty,Block,8  |PropertyDetail_Map,Block,6 | PropertyDetail_Map     |4                 |CreateProperty,Block,8  |Submission,Block,24     |CreateProperty,PIN,8    |Submission,PIN,24       |  Submission          |24             |	PropertyDetail_Map	   | 6                |