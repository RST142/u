Feature: Login-With-RCOCOC
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
      @Regression
 	 Scenario: Tenant able to update the policy with RCOCOC & validating End-User login
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
    Then Update Phone Validation Eligible factor
    Then Update Email Validation Eligible factor
    Then Click on Save button
    And Signout from sso
    Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And Enter Security Answer
    And Click on Submit button
    Then Click on Email Option
    And Enter OTP Received in Email
    And Submit OTP received in Email
    Then Redirected to Dashboard 
    
    
   
    
 
