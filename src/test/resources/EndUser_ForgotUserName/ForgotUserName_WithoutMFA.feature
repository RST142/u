Feature: End-User-Forgot-Username with disable password manager
  As a End-User, I should be able to Reset Password

  @smoke
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
    
   