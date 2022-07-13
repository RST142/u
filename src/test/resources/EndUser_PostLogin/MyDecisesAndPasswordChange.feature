Feature: MyDevices and Change Password functionality  
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
    @Regression
 	  Scenario: Validating End-User Change password functionality and MyDevices
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
    And Click on Security Question Option
    And Enter Security Answer
    And Click on trust this device checkbox
    And Click on Submit button 
    Then Redirected to Dashboard 
    Then Click on the Menus
    Then Click on My Devices Menu from dashboard
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Verify filter dropdown for untrusted devices
    Then Verify filter dropdown for trusted devices
    And Click on Untrust this device and verify the functionality
    Then Click on the Menus
    Then Click on Change Password Menu
    Then Verify Change Password Heading
    And Enter current and new password for password reset 
    Then verify password change message should appear
    Then Click on My Apps button
    
    
    
   
    
 
