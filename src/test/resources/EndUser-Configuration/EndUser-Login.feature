Feature: EndUser Login with combinations
  As a Tenant, I Should be able to execute Prerequisite
  
 
      @Regression
 	 Scenario: Validating End-User login with email after all account recovery setup
   When Navigate to End User Login Page
   And Enter Username
  And Enter Password for End User
   And Click on Signin
   Then Click on Email Option
   And Enter OTP Received in Email
   And Submit OTP received in Email
   And Redirected to Dashboard
   
   
    @Regression
    Scenario: Validating End-User login with RC
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on edit policy icon
    Then Update Policy Name
    Then Update Security Question Eligible factor Required 
    Then Update Phone Validation Eligible factor Required
    Then Update Email Validation Eligible factor Required
    Then Click on Save button
    And Navigate to UserDetails Page 
    And Type Username In UserDetail Page
    And Click on Search button
    And Click on checkbox of security sequetion,primary phone and email
    Then Click on clear button in popup
    And Signout from sso
      Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
     And Select quetion from security quetion dropdown
       
       @Regression
       Scenario: End-User Login with only security configuration and policy is required and Configuring email as recovery
     Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
      And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Email Tab Non Configured
     Then Enter Primary Email address in email recovery text field
     And Enter OTP Received in Email for account recovery
     
      @Regression
       Scenario: End-User Login with security and email with required policy configuration
     Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
       And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
     
       @Regression
 	 Scenario: Validating Tenant able to remove  the policy
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
   Then Click on SSO Tab
   Then Click on delete icon
   Then Click on delete button
    And Signout from sso
     
     