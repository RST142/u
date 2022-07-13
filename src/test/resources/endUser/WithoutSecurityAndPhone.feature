Feature: Login-Without-Security-And-Phone-Configuration
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
      @Regression
 	 Scenario: Validating End-User login without Security and phone configuration 
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on edit icon of defalut policy
    Then Update Policy Name
     Then Update policy for Security Question Eligible factor
    Then Update policy for Phone Validation Eligible factor
    Then Update policy for Email Validation Eligible factor
   Then Click on Save button
    And Signout from sso
    Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Security Question Tab Non Configured
    Then Verify the Phone Tab Non Configured
    Then Verify the Email Tab Non Configured
    
    
   
    
 
