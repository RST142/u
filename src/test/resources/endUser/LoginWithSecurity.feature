Feature: Login-With-Security-Questions
  End-User able to Login with and without MFA options
 
  @Smoke 
  Scenario: Validating End-User login with Security Question Option
  When Navigate to PreLogin Page 
  And Enter Username
  And Enter User Password
  And Click on Signin
  And Click on Security Question Option
  And Enter Security Answer
  And Click on Submit button 
  Then Redirected to Dashboard 
     