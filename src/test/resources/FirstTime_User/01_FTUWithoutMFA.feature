 Feature: First-Time-User-Without-MFA-Option
  As a End-User, I should be able to Login as a FTU 
  
  
 @smokeTest @FirstTimeUser
  Scenario: End-User ables to Login as a FTU without MFA option.
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Enter New Password
    And Enter Confirm Password
    And Click on submit password button
    Then User should redirect to login page
    And Enter Username
    And Enter User Password
    And Click on Signin
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    
   