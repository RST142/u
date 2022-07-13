Feature: Login-Scenarios-With-Disable-Security-Configuration
  As a user, I Should be able to log in as Tenant with Login Scenarios With Disable Security Configuration
      
      @Regression
 	 Scenario: Validating End-User Login Scenarios With Disable Security Configuration functionality 
   When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on edit icon of defalut policy
    Then Update Policy Name
    Then Update policy for Phone Validation Eligible factor
    Then Update policy for Email Validation Eligible factor
    Then Click on Save button
    And Signout from sso
    When Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    Then Redirected to login page of PWMS 
     And After login user should redirect to Account Recovery Setting
    
 
