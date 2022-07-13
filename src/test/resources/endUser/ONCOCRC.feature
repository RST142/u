Feature: Login-With-ONCOCRC
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
      @Regression
 	  Scenario: Validating End-User login with ONCOCRC
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
    Then Click on Text Message Option for RC
    And Enter OTP received in Phone Number
    And Submit OTP received in Phone Number
    Then Click on Email Option for RC
    And Enter OTP Received in Email
    And Submit OTP received in Email
    Then Redirected to Dashboard 
    
    
    
   
    
 
