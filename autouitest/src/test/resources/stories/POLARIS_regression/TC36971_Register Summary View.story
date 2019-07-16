TC36971_Register Summary View
Meta:
@regression
@UAT
@project POLARIS
@application POLARIS
@name TC36971_Register Summary View - Automation

Narrative:
As a user
I want to register summary view 



Scenario:Scenario1 TC36971_Register Summary View - Automation

Given LoadTestData UC421_Document Detail Screen - Screen Subflow Tests.xlsx
When user login into Polaris application with <LOGINSHEETNAME> and <LOGINROW>
And user navigates to Register  
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>  
Then user verifies the register summary view section on Document Detail page LandTitle and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX>
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX1> 
Then user verifies the register summary view section on Document Detail page LandTitle and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX1>
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2> 
And user click on PIN in PIN list and verify the header on Document Detail page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2> 
Then user verifies the register summary view section on Document Detail page Easement and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX2> 
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX3> 
Then user verifies the register summary view section on Document Detail page Registry and  <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX3> 
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register  
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX4>
Then user verifies the register summary view section on Document Detail page Registry and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX4> 
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX5> 
Then user verifies the register summary view section on Document Detail page TCPL and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX5>
When user clicks on Cancel document registration on the Document Detail page without data entry
And user navigates to Register 
And user clicks on Submit button on PreSubmission page <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX6> 
Then user verifies the register summary view section on Document Detail page HWY and <PRESUBMISSIONSHEETNAME> and <PRESUBMISSIONROWINDEX6>
When user clicks on Cancel document registration on the Document Detail page without data entry
And user log out of the application

Examples:

	| LOGINSHEETNAME | LOGINROW |PRESUBMISSIONSHEETNAME|PRESUBMISSIONROWINDEX|PRESUBMISSIONROWINDEX1|PRESUBMISSIONROWINDEX2|PRESUBMISSIONROWINDEX3|PRESUBMISSIONROWINDEX4|PRESUBMISSIONROWINDEX5|PRESUBMISSIONROWINDEX6|
    | LoginInfo      | 1        |PreSubmission         |22                   |23                    |24                    |25                     |26                    |27                    |28                    |s