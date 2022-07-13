Feature: Mobile-Push-Login-Verification
  As a user, I Should be able to log in as End-User Post & Validate Mobile Push
  
    @MobilePushLogin
 	  Scenario: Validating End-Uses Mobile Push Login 
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
    Then Update policy for MobilePush Validation Eligible factor
    Then Click on Save button
    And Signout from sso
    Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And Click on Mobile Push Option
    And Enter Mobile Push OTP
    And Click on Submit button for mobile push
    Then Redirected to Dashboard 
    Then Click on the Menus
    Then Click on My Account Menu
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    
    
    
   
    
 
