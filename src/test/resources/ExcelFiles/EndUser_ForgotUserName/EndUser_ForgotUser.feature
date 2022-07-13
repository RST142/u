Feature: End-User-Forgot-Username
  As a End-User, I should be able to Reset Password

  @smoke1
  Scenario: Validated End User Forgot Username using Required Security questions, Phone and Email options
    When Navigate to End User Login Page 
    And Enter User Password
    And Click on Forgot UserName link
    And Enter email address for UserName Recovery
    And Click on Submit 
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email Address
    And Enter OTP Received by you in Email
    And Submit OTP
    Then Click on Phone Option
    And Enter Phone OTP Received by you
    And Submit OTP
    And Enter New Password
    And Enter Confirm Password
    And Click on submit password button
    And Enter Username
    And Enter User Password
    And Click on Signin
    And Click on Security Question Option
    And Enter Security Answer
    And Click on Submit button
    Then Redirected to Dashboard
    
    
    @regression
     Scenario: End-User able to see error message if user enter incorrect security answer
    When Navigate to End User Login Page 
    And Enter User Password
    And Click on Forgot UserName link
    And Enter email address for UserName Recovery
    And Click on Submit 
    And Enter invalid Forgot Password Security Answer
    And Click on Security Submit button
    Then Invalid security answer error message should displayed 
    
    @regression
     Scenario: Validating error message appears if the user entered an invalid OTP for email Security
    When Navigate to End User Login Page 
    And Enter User Password
    And Click on Forgot UserName link
    And Enter email address for UserName Recovery
    And Click on Submit 
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email Address
    And Enter invalid OTP Received by you in Email
    And Submit OTP
   Then The error message should appears if the user entered an invalid OTP
   
  @regression
    Scenario: Validating error message appears if the user entered an invalid OTP for phone
    When Navigate to End User Login Page 
    And Enter User Password
    And Click on Forgot UserName link
    And Enter email address for UserName Recovery
    And Click on Submit 
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email Address
    And Enter OTP Received by you in Email
    And Submit OTP
    Then Click on Phone Option
    And Enter invalid Phone OTP
    And Submit OTP
    Then The error message should appears if the user entered an invalid OTP
    
    @regression
    Scenario Outline: Validate End User Forgot Password using optional Security questions, Phone and Email options
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
     And Click on Forgot UserName link
    And Enter email address for forgot username "<RecoveryEmail>"
    And Click on Submit 
   And Click on Security Question Option
   And Enter security answer 
    And Enter New Password
    And Enter Confirm Password
    And Click on submit password button
    And Enter Username
    And Enter User Password
    And Click on Signin
    And Click on Security Question Option
    And Enter Security Answer
    And Click on Submit button
    Then Redirected to Dashboard
    
    Examples: 
| RecoveryEmail  | password  | 
| chanchal_mahajan@quicklaunchsso.com | Test@123 |
    