TC37745_Property Details - Proceed button POS
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC37745_Property Details - Proceed button POS

Narrative:
As a user
I want to Property Details - Proceed button POS

Scenario: Scenario 1 Property Details - Proceed button POS 

Given LoadTestData UC67_Correct Update Certified Property_Automation Scripts (online).xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW1>
And user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW3>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW3>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW1>
And user clicks on Close button on propertymapmaintenanceRequest page
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1>
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to CorrectUpdateCertifiedProperty
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <PINENTRYSHEETNAME> and <PINENTRYROW10>
And user clicks the tab DESCRIPTION
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW1>
When user clicks the tab MANAGERS
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW2>
When user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW4>
And user navigates to CreateProperty
And user cancels Create Property
And user navigates to CorrectUpdateCertifiedProperty
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <PINENTRYSHEETNAME> and <PINENTRYROW10>
And user clicks the tab DESCRIPTION
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW1>
When user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW5>
And user navigates to CreateProperty
And user cancels Create Property
And user navigates to CorrectUpdateCertifiedProperty
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <PINENTRYSHEETNAME> and <PINENTRYROW10>
And user clicks the tab DESCRIPTION
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW11>
When user clicks the tab OWNERS
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW12>
When user clicks the tab CORRECTIONNOTICES
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW17>
When user clicks the tab MANAGERS
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW20>
When user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW6>
And user navigates to CreateProperty
And user clicks on Proceed button on the Create Property <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW2>
And user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW7>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW7>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CREATEPROPERTYSHEETNAME> and <CREATEPROPERTYROW2>
And user clicks on Close button on propertymapmaintenanceRequest page
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user navigates to CorrectUpdateCertifiedProperty
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <PINENTRYSHEETNAME> and <PINENTRYROW11>
And user clicks the tab DESCRIPTION
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW24>
When user clicks the tab MANAGERS
Then user verify the UI object properties <UIOBJECTSHEETNAME> and <UIOBJECTROW2>
When user clicks on the Proceed button on property detail page <PROPERTYDETAIL_MAPSHEETNAME> and <PROPERTYDETAIL_MAPROW8>
And user log out of the application

Examples:
      | LOGINSHEETNAME | LOGINROW |CREATEPROPERTYSHEETNAME | CREATEPROPERTYROW1 | PROPERTYDETAIL_MAPSHEETNAME | PROPERTYDETAIL_MAPROW3  | SOURCE1                     | TARGET1                 | SOURCE2                   | TARGET2          |PINENTRYSHEETNAME     | PINENTRYROW10 | UIOBJECTSHEETNAME|UIOBJECTROW1|PROPERTYDETAIL_MAPROW4|UIOBJECTROW11|UIOBJECTROW12|PROPERTYDETAIL_MAPSHEETNAME|PROPERTYDETAIL_MAPROW6|CREATEPROPERTYROW2|PROPERTYDETAIL_MAPROW5|PINENTRYROW10 |UIOBJECTROW3-11|UIOBJECTROW2|UIOBJECTROW12|UIOBJECTROW17|UIOBJECTROW20|PROPERTYDETAIL_MAPROW6|CREATEPROPERTYROW2|PROPERTYDETAIL_MAPROW7  |SOURCE3               |TARGET3           |SOURCE4             |TARGET4         |PINENTRYSHEETNAME2|PINENTRYROW11 |UIOBJECTROW24|UIOBJECTROW2|PROPERTYDETAIL_MAPSHEETNAME6|PROPERTYDETAIL_MAPROW8|
      | LoginInfo      | 1 		  | CreateProperty          | 1 		        | PropertyDetail_Map          | 3 		                | CreateProperty,Block,1      | PINEntry,Block,10 		| CreateProperty,PIN,1      | PINEntry,PIN,10  |PINEntry              | 10            | UIObject         |1           |4                     |3-11         |12-16        |PropertyDetail_Map         |6                     |2                 |5                     |10            |3-11           |2           |12-16        |17-19        |20-23        |6				       |2				  |7					   |CreateProperty,Block,2|PINEntry,Block,11 |CreateProperty,PIN,2|PINEntry,PIN,11 |PINEntry		  |11            |24           |2           |PropertyDetail_Map          |8                     |																				