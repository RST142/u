 Feature: First-Time-User-With-Phone-Option
  As a End-User, I should be able to Login as a FTU 
  
  
  @smokeTest @FirstTimeUser
  Scenario: The error message appears if the user entered an invalid OTP for send me a text message option.
    When Navigate to tenant url
    And Click on login here 
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    And Navigate to UserDetails Page 
    And Type Username In UserDetail Page
    And Click on Search button
    And Search a record of Enduser with Username
    Then Click on clear button
    When Navigate to PreLogin Page
    And Click on First Time User link 
    And Enter Username in Inputfield
    And Click on Submit Button 
    And Click on Send me a Text Message Option
    And Click on back button on submitting necessary information wizard
    And Click on Send me a Text Message Option
    And Click on Phone Verification Option link
    And Enter Invalid Email OTP 
    And Submit the OTP
    Then The error message appears when user entered an invalid OTP
    
   