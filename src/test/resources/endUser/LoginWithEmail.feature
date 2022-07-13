Feature: Login-With-Email-Security
  End-User able to Login with and without MFA options
 
   @Smoke
 	 Scenario: Validating End-User login with Using Email Security Option
   When Navigate to PreLogin Page
   And Enter Username
   And Enter User Password
   And Click on Signin
   Then Click on Email Option
   And Enter OTP Received in Email
   And Submit OTP received in Email
   And Redirected to Dashboard
     