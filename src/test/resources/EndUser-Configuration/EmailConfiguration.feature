Feature: End-User_Email_Configuration in account
  As a Tenant, I Should be able to execute Prerequisite
  
 
     
     @Regression
     Scenario: End-User Login with only security quetion as MFA and configuring email in account recovery page.
     Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
     And Enter Security Answer
  And Click on Submit button
   And Click on My Account
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Email Tab Non Configured
     Then Enter Primary Email address in email recovery text field
     And Enter OTP Received in Email for account recovery
     
   