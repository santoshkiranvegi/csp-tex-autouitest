TC38138_Open Condo Prop - Proceed button Neg - Automation
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC38138_Open Condo Prop - Proceed button Neg - Automation

Narrative:
As a user
I want to open the condo proop and proceed 

Scenario 1: TC38138_Open Condo Prop - Proceed button Neg - Automation

Given LoadTestData UC6413_Open Condominium_Online.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to CreateProperty 
And user clicks on Proceed button on the Create Property <CreatePropertySHEETNAME> and <CreatePropertyROW>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE> and <SERVICECOPYCOLUMNTARGET>
And user clicks on the Proceed button on property detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROW>
And user clicks on Proceed To Confirmation button on Print Parcel page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROW>
And user click on Certify button on Print Parcel Confirmation page CREATE and <CreatePropertySHEETNAME> and <CreatePropertyROW>
And user clicks on Close button on propertymapmaintenanceRequest page
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE1> and <SERVICECOPYCOLUMNTARGET1>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE2> and <SERVICECOPYCOLUMNTARGET2>
And user navigates to Register

And user clicks on Submit button on PreSubmission page <RegisterSHEETNAME> and <RegisterROWINDEX>
And user clicks on ProceedWithReceipt button on Document Detail page <DOCUMENTDETAILSHEETNAME> and <DOCUMENTDETAILROW>
And user clicks on Complete Registration button on the Fees and Taxespage <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user navigates to Certify
And user clicks on ProceedToCertification in Certify page <FEESTAXESSHEETNAME> and <FEESTAXESROWINDEX>
And user clicks on Certify button on Document Detail page
And user navigates to OPENCONDOMINIUM
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW1> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE3> and <SERVICECOPYCOLUMNTARGET3>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE4> and <SERVICECOPYCOLUMNTARGET4>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW2> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE5> and <SERVICECOPYCOLUMNTARGET5>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW3> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE6> and <SERVICECOPYCOLUMNTARGET6>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW4> 
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW5>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE7> and <SERVICECOPYCOLUMNTARGET7>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW5> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE8> and <SERVICECOPYCOLUMNTARGET8>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE9> and <SERVICECOPYCOLUMNTARGET9>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE10> and <SERVICECOPYCOLUMNTARGET10>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW6> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE11> and <SERVICECOPYCOLUMNTARGET11>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE12> and <SERVICECOPYCOLUMNTARGET12>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE13> and <SERVICECOPYCOLUMNTARGET13>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW7> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE14> and <SERVICECOPYCOLUMNTARGET14>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE15> and <SERVICECOPYCOLUMNTARGET15>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW8> 
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE16> and <SERVICECOPYCOLUMNTARGET16>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE17> and <SERVICECOPYCOLUMNTARGET17>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE18> and <SERVICECOPYCOLUMNTARGET18>
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW9> 
And user clicks on the Cancel button on the Open Condominium page
Then verify user navigates to main menu
When user navigates to CorrectUpdateCertifiedProperty
And user clicks on the Proceed button on CorrectUpdateCertifiedProperty <CreatePropertySHEETNAME> and <CreatePropertyROW>
And user clicks on the Proceed button on property detail page <PROPERTYDETAILSHEETNAME> and <PROPERTYDETAILROWINDEX2>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE19> and <SERVICECOPYCOLUMNTARGET19>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE20> and <SERVICECOPYCOLUMNTARGET20>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE21> and <SERVICECOPYCOLUMNTARGET21>
And user copies column data from source and paste it in target <SERVICECOPYCOLUMNSOURCE22> and <SERVICECOPYCOLUMNTARGET22>
And user navigates to OPENCONDOMINIUM
And user clicks on the Proceed button on the Condominium Amendment page <CONDOAMENDMENTSHEETNAME> and <CONDAMENDMENTROW10>
And user clicks on the Cancel button on the Open Condominium page
Then verify user navigates to main menu
When user log out of the application

Examples:
| LOGINSHEETNAME | LOGINROW |CreatePropertySHEETNAME|CreatePropertyROW| SERVICECOPYCOLUMNSOURCE |SERVICECOPYCOLUMNTARGET   |PROPERTYDETAILSHEETNAME|PROPERTYDETAILROW|SERVICECOPYCOLUMNSOURCE1|SERVICECOPYCOLUMNTARGET1|SERVICECOPYCOLUMNSOURCE2|SERVICECOPYCOLUMNTARGET2|RegisterSHEETNAME|RegisterROWINDEX|DOCUMENTDETAILSHEETNAME|DOCUMENTDETAILROW|FEESTAXESSHEETNAME|FEESTAXESROWINDEX|FEESTAXESROWINDEX4|CONDOAMENDMENTSHEETNAME|CONDAMENDMENTROW1|CONDAMENDMENTROW2|CONDAMENDMENTROW3|CONDAMENDMENTROW4|CONDAMENDMENTROW5|CONDAMENDMENTROW6|CONDAMENDMENTROW7|CONDAMENDMENTROW8|CONDAMENDMENTROW9|CONDAMENDMENTROW10|SERVICECOPYCOLUMNSOURCE3|SERVICECOPYCOLUMNTARGET3|SERVICECOPYCOLUMNSOURCE4|SERVICECOPYCOLUMNTARGET4|SERVICECOPYCOLUMNSOURCE5|SERVICECOPYCOLUMNTARGET5|SERVICECOPYCOLUMNSOURCE6|SERVICECOPYCOLUMNTARGET6|SERVICECOPYCOLUMNSOURCE7|SERVICECOPYCOLUMNTARGET7|SERVICECOPYCOLUMNSOURCE8|SERVICECOPYCOLUMNTARGET8|SERVICECOPYCOLUMNSOURCE9|SERVICECOPYCOLUMNTARGET9|SERVICECOPYCOLUMNSOURCE10|SERVICECOPYCOLUMNTARGET10|SERVICECOPYCOLUMNSOURCE11|SERVICECOPYCOLUMNTARGET11|SERVICECOPYCOLUMNSOURCE12|SERVICECOPYCOLUMNTARGET12|SERVICECOPYCOLUMNSOURCE13|SERVICECOPYCOLUMNTARGET13|SERVICECOPYCOLUMNSOURCE14|SERVICECOPYCOLUMNTARGET14|SERVICECOPYCOLUMNSOURCE15|SERVICECOPYCOLUMNTARGET15|SERVICECOPYCOLUMNSOURCE16|SERVICECOPYCOLUMNTARGET16|SERVICECOPYCOLUMNSOURCE17|SERVICECOPYCOLUMNTARGET17|SERVICECOPYCOLUMNSOURCE18|PROPERTYDETAILROWINDEX2|SERVICECOPYCOLUMNTARGET18|SERVICECOPYCOLUMNSOURCE19|SERVICECOPYCOLUMNTARGET19|SERVICECOPYCOLUMNSOURCE20|SERVICECOPYCOLUMNTARGET20|SERVICECOPYCOLUMNSOURCE21|SERVICECOPYCOLUMNTARGET21|SERVICECOPYCOLUMNSOURCE22|SERVICECOPYCOLUMNTARGET22|
|  LoginInfo     | 1 		|CreateProperty         |1                |CreateProperty,Block,1   |PropertyDetail_Map,Block,1|PropertyDetail_Map     |1                |CreateProperty,Block,1  |Register,TargetBlock,1  |CreateProperty,PIN,1    |Register,TargetPINFrom,1|Register         |1               |DocumentDetail_Map     |1                |FeesTaxes         |1                |4                 |OpenCondo              |1                |2                |3                |4                |5                |6                |7                |8                |9                |10                |CreateProperty,Block,1  |OpenCondo,TargetBlock,2 |CreateProperty,PIN,1    |OpenCondo,TargetPIN,2   |CreateProperty,Block,1  |OpenCondo,BlockNumber,3 |FeesTaxes,RegNumber,1   |OpenCondo,PlanNumber,4  |CreateProperty,Block,1  |OpenCondo,BlockNumber,6 |CreateProperty,Block,1  |OpenCondo,TargetBlock,7 |CreateProperty,PIN,1    |OpenCondo,TargetPIN,7   |CreateProperty,Block,1   |OpenCondo,BlockNumber,7  |CreateProperty,Block,1   |OpenCondo,TargetBlock,8  |CreateProperty,PIN,1     |OpenCondo,TargetPIN,8    |CreateProperty,Block,1   |OpenCondo,BlockNumber,8  |FeesTaxes,RegNumber,1    |OpenCondo,PlanNumber,9   |CreateProperty,Block,1   |OpenCondo,BlockNumber,9  |CreateProperty,Block,1   |OpenCondo,TargetBlock,10 |CreateProperty,PIN,1     |OpenCondo,TargetPIN,10   |FeesTaxes,RegNumber,1    |2                      |OpenCondo,PlanNumber,10  |CreateProperty,Block,1   |OpenCondo,TargetBlock,11 |CreateProperty,PIN,1     |OpenCondo,TargetPIN,11   |FeesTaxes,RegNumber,1    |OpenCondo,PlanNumber,11   |CreateProperty,Block,1  |OpenCondo,BlockNumber,11 |

