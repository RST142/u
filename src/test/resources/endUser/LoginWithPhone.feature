Feature: Login-With-Phone
  End-User able to Login with and without MFA options
 
      
   @Smoke  
   Scenario: Validating End-User login with Phone Option
   When Navigate to PreLogin Page
   And Enter Username
   And Enter User Password
   And Click on Signin
   Then Click on Text Message Option
   And Enter OTP received in Phone Number
   And Submit OTP received in Phone Number
   And Redirected to Dashboard
   



      