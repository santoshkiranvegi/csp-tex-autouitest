TC37703_Review Correction Notices - Cancel button
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37703_Review Correction Notices - Cancel button

Narrative:
As a user
I want to review correction notice 

Scenario1: TC37703_Review Correction Notices - Cancel button
Given LoadTestData UC521_Correct Certified Document_Automation Scripts (online)_01.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <PROPERTYSHEETNAME1> and <PROPERTYROW3>
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user click on Proceed button on Property Detail page <DOCUMENTDETAILSHEETNAME1> and <DOCUMENTDETAILROW1>
And user clicks on Proceed  To Confirmation button on Print Parcel page <PRINTPARCELSHEETNAME1> and <PRINTPARCELROW1>
And user click on Certify button on Print Parcel Confirmation page strFunction and <PRINTPARCELSHEETNAME2> and <PRINTPARCELROW3>
And user click Close button on property Map Maintenance Request page
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME1> and <PRESUBMISSIONROW5>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME1> and <FEESTAXESROW5>
And user navigates to Certify 
And user clicks on Proceed to Certification button on Document Selection page <FEESTAXESSHEETNAME1> and <FEESTAXESROW8>
And user click on Certify button on Document Detail page
And user navigates to CorrectCertifiedDocument 
And user click on Proceed button on the Document selection <FEESTAXESSHEETNAME1> and <FEESTAXESROW5>
And user clicks on Proceed button on Document Detail page <DOCUMENTDETAILSHEETNAME2> and <DOCUMENTDETAILROW5>
And user Generate the dynamic notice based on the amount provided AMOUNT and <PROVIDEDSHEETNMAE1> and <PROVIDEDROW3>
Then user verify the existance of correction notices in the notice table <NOTICESHEETNAME1> and <NOTICEROW3>
When user enter data for Correction Notices <CORRECTIONSHEETNAME1> and <CORRECTIONROW1>
And user enter data for Correction Notices <CORRECTIONSHEETNAME2> and <CORRECTIONROW2>
Then user verifies the UI object properties TEXT and <UIOBJECTSHEETNAME1> and <UIOBJECTROW3>
When user Cancel the Cancel review correction notice
And user Cancel the review correction notice
And user navigates to CorrectCertifiedDocument 
And user click on Proceed button on the Document selection <FEESTAXESSHEETNAME1> and <FEESTAXESROW5>
And user clicks on Proceed button on Document Detail page <DOCUMENTDETAILSHEETNAME3> and <DOCUMENTDETAILROW5>
And user Generate the dynamic notice based on the amount provided AMOUNT and <PROVIDEDSHEETNMAE2> and <PROVIDEDROWINDEX3>
Then user verify the existance of correction notices in the notice table <NOTICESHEETNAME2> and <NOTICEROWINDEX3>
When user clicks on Return to Document Details button on Review Correction Notices page
And user clicks on Proceed button on Document Detail page <DOCUMENTDETAILSHEETNAME4> and <DOCUMENTDETAILROW6>
And user Generate the dynamic notice based on the amount provided AMOUNT and <PROVIDEDSHEETNMAE3> and <PROVIDEDROW4>
Then user verify the existance of correction notices in the notice table <NOTICESHEETNAME3> and <NOTICEROW4>
When user clicks on Commit button on Review Correction Notices page
And user clicks on the document number link on the Correction Confirmation page <FEESTAXESSHEETNAME1> and <FEESTAXESROW5>
And user Close the document detail view popup
When user log out of the application


Examples:
	| LOGINSHEETNAME | LOGINROW |PROPERTYSHEETNAME1|PROPERTYROW3|SOURCE1               |TARGET1                   |DOCUMENTDETAILSHEETNAME1|DOCUMENTDETAILROW1|PRINTPARCELSHEETNAME1|PRINTPARCELROW1|PRINTPARCELSHEETNAME2|PRINTPARCELROW3|SOURCE2               |TARGET2                                           |SOURCE3             |TARGET3                                           |PRESUBMISSIONSHEETNAME1|PRESUBMISSIONROW5|FEESTAXESSHEETNAME1|FEESTAXESROW5| FEESTAXESROW8| DOCUMENTDETAILSHEETNAME2|DOCUMENTDETAILROW5|PROVIDEDSHEETNMAE1|PROVIDEDROW3|NOTICESHEETNAME1|NOTICEROW3|CORRECTIONSHEETNAME1|CORRECTIONROW1|CORRECTIONSHEETNAME2|CORRECTIONROW2|UIOBJECTSHEETNAME1|UIOBJECTROW3|DOCUMENTDETAILSHEETNAME3|DOCUMENTDETAILROW5|PROVIDEDSHEETNMAE2|PROVIDEDROWINDEX3|NOTICESHEETNAME2|NOTICEROWINDEX3|DOCUMENTDETAILSHEETNAME4|DOCUMENTDETAILROW6|PROVIDEDSHEETNMAE3|PROVIDEDROW4|NOTICESHEETNAME3|NOTICEROW4|
	| LoginInfo      | 1        |CreateProperty    |3           |CreateProperty,Block,3|PropertyDetail_Map,Block,1|PropertyDetail_Map      |1                 |PropertyDetail_Map   |1              | CreateProperty      |3              |CreateProperty,Block,3|CreateProperty,Block,3;PreSubmission,TargetBlock,5|CreateProperty,PIN,3|CreateProperty,PIN,3;PreSubmission,TargetPINFrom,5|PreSubmission          |5                |FeesTaxes          |5            | 8           | DocumentDetail_Map      |5                 |DocumentData      |3           |DocumentData    |3         |CorrectionNotices   |1             |CorrectionNotices   |2             |UIObject          |3           |DocumentDetail_Map      |5                 |DocumentData      |3                |DocumentData    |3              |DocumentDetail_Map      |6                 |DocumentData      |4           |DocumentData    |4         |