TC37888_Divide Property - Proceed button POS -  Batch Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37888_Divide Property - Proceed button POS -  Batch Automation

Narrative:
As a user
I want to create divide property and click proceed button

Scenario: Scenario1 TC37888_Divide Property - Proceed button POS -  Batch Automation

Given LoadTestData UC641_Divide Single Property_Automation Scripts (batch).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME1> and <PROPERTYDETAILROW1>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME1> and <CREATEPROPERTYROW1> 
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE> and <TARGET>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW1>
And user click on Proceed or Apply Bulk Changes button on Property Detail page for online and batch mode <PROPERTYDETAILSHEETNAME2> and <PROPERTYDETAILROW2>
And user click on View Draft Parcel Register or View Summary Report button to review report VIEWDRAFTPARCELREGISTER
And user click on Return To Review Selection button on Draft Parcel Register or Summary Report PDF page
And user click on View Draft Parcel Register or View Summary Report button to review report VIEWSUMMARYREPORT 
And user click on Return To Review Selection button on Draft Parcel Register or Summary Report PDF page
And user click on Edit Child with Row ID after Row ID is entered <EDITCHILDSHEETNAME1> and <EDITCHILDROW1>
And user click on Certify on Summary Report & Draft Parcel Register Review page <SUBMISSIONSHEETNAME1> and <SUBMISSIONROW1>
And user click on Correlation List button on Map Maintenance Request page for Divide Property
And user click on Remove Batch Open Property Record button on Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME2> and <SUBMISSIONROW2>
And user clicks on Cancel button on DivideProperty
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2> 
And user click on Proceed button on Property Detail page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW3>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME3> and <PROPERTYDETAILROW3>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME2> and <CREATEPROPERTYROW2> 
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user copies column data from source and paste it in target <SOURCE5> and <TARGET5>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME3> and <SUBMISSIONROW3>
And user click on Proceed or Apply Bulk Changes button on Property Detail page for online and batch mode <PROPERTYDETAILSHEETNAME4> and <PROPERTYDETAILROW4>
And user click on View Draft Parcel Register or View Summary Report button to review report VIEWDRAFTPARCELREGISTER
And user click on Return To Review Selection button on Draft Parcel Register or Summary Report PDF page
And user click on View Draft Parcel Register or View Summary Report button to review report VIEWSUMMARYREPORT
And user click on Return To Review Selection button on Draft Parcel Register or Summary Report PDF page
And user click on Edit Child with Row ID after Row ID is entered <EDITCHILDSHEETNAME1> and <EDITCHILDROW1>
And user click on Certify on Summary Report & Draft Parcel Register Review page <SUBMISSIONSHEETNAME3> and <SUBMISSIONROW3>
And user click on Correlation List button on Map Maintenance Request page for Divide Property
And user click on Remove Batch Open Property Record button on Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE6> and <TARGET6>
And user copies column data from source and paste it in target <SOURCE7> and <TARGET7>
And user navigates to DivideProperty 
And user clicks on Proceed button on DivideProperty PROCEED and <SUBMISSIONSHEETNAME4> and <SUBMISSIONROW4>
And user clicks on Cancel button on DivideProperty
And user log out of the application

Examples:

	|LOGINSHEETNAME |LOGINROW|CREATEPROPERTYSHEETNAME1|CREATEPROPERTYROW1|PROPERTYDETAILSHEETNAME1|PROPERTYDETAILROW1|PROPERTYDETAILSHEETNAME2|PROPERTYDETAILROW2|CREATEPROPERTYSHEETNAME2|CREATEPROPERTYROW2|SOURCE                 |TARGET            |SOURCE1             |TARGET1         |SUBMISSIONSHEETNAME1|SUBMISSIONROW1|EDITCHILDSHEETNAME1|EDITCHILDROW1|SUBMISSIONSHEETNAME2|SUBMISSIONROW2|SOURCE2           |TARGET2           |SOURCE3         |TARGET3         |SUBMISSIONSHEETNAME3|SUBMISSIONROW3|SOURCE4               |TARGET4           |SOURCE5             |TARGET5         |SUBMISSIONSHEETNAME4|SUBMISSIONROW4|PROPERTYDETAILSHEETNAME3|PROPERTYDETAILROW3|PROPERTYDETAILSHEETNAME4|PROPERTYDETAILROW4|SOURCE6           |TARGET6           |SOURCE7           |TARGET7         |
    |LoginInfo      |1       |CreateProperty          |1                 |PropertyDetail_Map      |1                 |PropertyDetail_Map      |2                 |CreateProperty          | 2                |CreateProperty,Block,1|Submission,Block,1|CreateProperty,PIN,1|Submission,PIN,1|Submission           |1             |EditChild          |1            |Submission          |2             |Submission,Block,1|Submission,Block,2|Submission,PIN,1|Submission,PIN,2|Submission          |3             |CreateProperty,Block,2|Submission,Block,3|CreateProperty,PIN,2|Submission,PIN,3|Submission          |4             |PropertyDetail_Map      |3                 |PropertyDetail_Map      |4                 |Submission,Block,3|Submission,Block,4|Submission,PIN,3  |Submission,PIN,4|
    