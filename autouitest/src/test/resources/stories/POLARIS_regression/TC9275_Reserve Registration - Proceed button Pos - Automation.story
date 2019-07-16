TC9275_Reserve Registration - Proceed button Pos - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC9275_Reserve Registration - Proceed button Pos - Automation

Narrative:
As a user
I want to Reserve Registration and click on Proceed button 

Scenario: TC9275_Reserve Registration - Proceed button Pos - Automation

Given LoadTestData UC411_Reserve Registration Number.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to ReserveRegNumber  
Then verify user navigates to menu Reserve Registration Number
When user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME> and <RESERVEROWINDEX>  
And user copies column data from source and paste it in target <SOURCE1> and <TARGET1> 
And user navigates to Register 
Then verify user navigates to menu Register
When user clicks on Submit button with data on PreSubmission page <SHEETNAME> and <ROWINDEX1>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX> 
And user navigates to ReserveRegNumber
And user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME1> and <RESERVEROWINDEX1> 
And user copies column data from source and paste it in target <SOURCE2> and <TARGET2>
And user navigates to Register
And user clicks on Submit button with data on PreSubmission page <SHEETNAME> and <ROWINDEX2>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX1>
And user navigates to ReserveRegNumber
And user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME2> and <RESERVEROWINDEX2>
And user copies column data from source and paste it in target <SOURCE3> and <TARGET3>
And user navigates to Register 
And user clicks on Submit button with data on PreSubmission page <SHEETNAME> and <ROWINDEX1>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes page
And user navigates to ReserveRegNumber
And user clicks the Proceed button on the Reserve Registration Number page <RESERVESHEETNAME3> and <RESERVEROWINDEX3> 
And user copies column data from source and paste it in target <SOURCE4> and <TARGET4>
And user navigates to Register
And user clicks on Submit button with data on PreSubmission page <SHEETNAME> and <ROWINDEX2>
And user clicks on Proceed  with Receipt button on Document Detail page
And user clicks on Complete Registration button on the Fees and Taxes page
And user log out of the application

Examples:
	
	| LOGINSHEETNAME | LOGINROW |RESERVESHEETNAME|RESERVEROWINDEX|SOURCE1                  |TARGET1                |SHEETNAME       |ROWINDEX1|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|RESERVESHEETNAME1|RESERVEROWINDEX1|SOURCE2                 |TARGET2                 |ROWINDEX2|FEESTAXESROWINDEX1|RESERVESHEETNAME2|RESERVEROWINDEX2|SOURCE3                 |TARGET3                           |RESERVESHEETNAME3|RESERVEROWINDEX3|SOURCE4                 |TARGET4                           |
	| LoginInfo      | 1        |Reserve         |7              |Reserve,NumReservedFrom,7|FeesTaxes,RegNumber,1  |PreSubmission   |1        | FeesTaxes        |1                |Reserve          |8               |Reserve,NumReservedFrom,8|FeesTaxes,RegNumber,2  |2        |2                 |Reserve          |9               |Reserve,NumReservedTo,9 |NewSubmission,RegNumber_Reserved,1|Reserve          |10              |Reserve,NumReservedTo,10|NewSubmission,RegNumber_Reserved,1|
