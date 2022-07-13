Feature: EndUser Phone Configuration in account
  As a Tenant, I Should be able to execute Prerequisite
     
     @Regression
     Scenario: End-User Login with security and email as MFA and also configuring phone number in account recovery page
     Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And Click on Security Question Option
  And Enter Security Answer
  And Click on Submit button
   And Click on My Account
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Phone Tab Non Configured
     Then Select country drop dropdown for phone configuration
     And Enter OTP Received in phone for account recovery
     
     