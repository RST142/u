Feature: Post-Login-Menus-Verification
  As a user, I Should be able to log in as End-User Post & Validate Menus
  
    @PostLogin
 	  Scenario: Validating End-User Post Login  Menus 
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
    Then Click on the Menus
    Then Click on My Devices Menu
    Then Verify Data is Present on Devices page
    Then Click on the Menus
    Then Click on Change Password Menu
    Then Verify Change Password Heading
    Then Click on My Apps button
    
    
    
   
    
 
