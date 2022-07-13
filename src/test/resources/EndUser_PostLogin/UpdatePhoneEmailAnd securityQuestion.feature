Feature: Update-Phone-Emial-SecurityQuestion
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
  
    @UpdateFunctionality
 	  Scenario: Validating Update Phone, Email & Security Question functionality on Account recovery page
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
    And Click on Submit button 
    Then Redirected to Dashboard  
    Then Click on the Menus
    Then Click on My Account Menu
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Security Question Tab Configured
    Then Update First Security Question
    Then Add Custom Security Question 
    Then Enter Answer for Custom Security Question
    Then Submit the Security Question Changes 
    Then Verify the Phone Tab Configured
    Then Click on Primary Phone Update button
    Then Select Country to Update Phone
    Then Enter Phone Number to Update
    Then Click on Verify button
    Then Enter OTP Received in Phone
    Then Click on Phone OTP Submit button
    Then Verify the Email Tab Configured
    Then Click on Email Recovery Update button
    Then Enter Email Id Needs to be Updated
    Then Click on Validate Email ID button
    Then Enter verification Code received in email
    Then Click on Submit button for Email Id
    Then Click on the Menus
    Then Click on My Apps Menu
    Then Redirected to Dashboard 
    
    
    
   
    
 
