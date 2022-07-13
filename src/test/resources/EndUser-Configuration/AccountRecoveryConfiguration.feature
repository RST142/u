Feature: EndUser Login with AccountRecovery Configuration
  As a Tenant, I Should be able to execute Prerequisite
  
 @Regression
 	 Scenario: Configring End-User account recovery security quetion
    When Navigate to url
   And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on Add Policy button
    Then Select MFA cardinality
    Then Add policy name
    Then Select Policy Status
    Then Select User Group
    Then Update Security Question Eligible factor
    Then Update Phone Validation Eligible factor
    Then Update Email Validation Eligible factor
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
    
     
    
     
     
     
     