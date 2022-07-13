Feature: First-Time-User-With-Email-Option
  As a End-User, I should be able to Login as a FTU
  
  @regressionTestt @FirstTimeUserr
  Scenario: End User able to see Error message if the user-name is not the first-time user
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username which is not FTU
    And Click on Submit Button 
    Then The error message appears if the user name is not the first time user
    
    @regressionTest @FirstTimeUser
  Scenario: Validating error message appears if the user entered invalid user-name.
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Invalid Username in Inputfield
    And Click on Submit Button 
    Then The error message appears if the user entered invalid user name
    
     @regressionTest @FirstTimeUser
  Scenario: Validating error message appears if the user entered an invalid OTP for email Security and Back button functionality
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Click on Send me an Email Option
    And Click on back button on submitting necessary information wizard
    And Click on Send me an Email Option
    And Click on Email link
    And Enter Invalid Email OTP 
    And Submit the OTP
    Then The error message appears when user entered an invalid OTP
   
   
   @regressionTest @FirstTimeUser
  Scenario: Validating error message appears if the user entered a mismatch Password.
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Click on Send me an Email Option
    And Click on Email link
    And Enter Email OTP 
    And Submit the OTP
    And Enter New Password
    And Enter Invalid Confirm Password
    Then Submit button should be disabled
    
    
    @KnownIssue @FirstTimeUser 
  Scenario: Validating error message appears if the user does not meet the password policy requirement
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Click on Send me an Email Option
    And Click on Email link
    And Enter Email OTP 
    And Submit the OTP
    And Enter New Less Secure Password
    And Enter Confirm Less Secure Password
    And Click on submit password button
    Then The error message appears if the user does not meet the password policy requirement
   
   @smokeTest @FirstTimeUser
  Scenario: End-User ables to Login as a FTU with Email MFA option.
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Click on Send me an Email Option
    And Click on Email link
    And Enter Email OTP 
    And Submit the OTP
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
    
     
  
   
    