Feature: Login-With-OCDOC
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
      @Regression
 	 Scenario: Validating End-User login with OCDOC
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on edit policy icon
    Then Update Policy Name
    Then Update Security Question Eligible factor
    Then Update Phone Validation Eligible factor
    Then Update Email Validation Eligible factor Disabled
    Then Click on Save button
    And Signout from sso
    Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    Then Click on Text Message Option
    And Enter OTP received in Phone Number
   And Submit OTP received in Phone Number
   And Redirected to Dashboard
    
    
   
    
 
