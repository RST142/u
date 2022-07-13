Feature: End-User-Forgot-Password
  As a End-User, I should be able to Reset Password

  @smokeTest @Forgotpassword
  Scenario: Validate End User Forgot Password using Required Security questions, Phone and Email options
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password 
    And Click on username submit button
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email
    And Enter OTP Received by you in Email
    And Submit Email OTP Received
    Then Click on Primary Phone Option
    And Enter Phone OTP Received by you
    And Submit Phone OTP Received
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
    
    @Forgotpassword
     Scenario: End-User able to see error message if user enter incorrect security answer
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password
    And Click on username submit button
    And Enter invalid Forgot Password Security Answer
    And Click on Security Submit button
    Then Invalid security answer error message should displayed 
    
    @Forgotpassword1
     Scenario: Validating error message appears if the user entered an invalid OTP for email Security
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password
    And Click on username submit button
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email
    And Enter invalid OTP Received by you in Email
    And Submit Email OTP Received
   Then The error message appears if the user entered an invalid OTP
   
   @Forgotpassword
    Scenario: Validating error message appears if the user entered an invalid OTP for phone
   When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password
    And Click on username submit button
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email
    And Enter OTP Received by you in Email
    And Submit Email OTP Received
    Then Click on Primary Phone Option
    And Enter invalid Phone OTP
    And Submit Phone OTP Received
    Then The error message appears if the user entered an invalid OTP
    
    
    @smokeTest @Forgotpassword
  Scenario: Validating error message appears if the user entered a mismatch Password.
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password
    And Click on username submit button
    And Enter Forgot Password Security Answer
    And Click on Security Submit button
    Then Click on Primary Email
    And Enter OTP Received by you in Email
    And Submit Email OTP Received
    Then Click on Primary Phone Option
    And Enter Phone OTP Received by you
    And Submit Phone OTP Received
    And Enter New Password
    And Enter Invalid Confirm Password
    Then Submit button should be disabled
    
    
    @Forgotpassword
    Scenario Outline: Validate End User Forgot Password using optional Security questions, Phone and Email options
    When Navigate to End User Login Page 
    And Enter Username
    And Click on Signin
    And Click on forgot Password link
    And Enter Username to Reset Password "<username>" 
    And Click on username submit button
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
| username  | password  | 
| qatest3 | Test@123 |