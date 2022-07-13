Feature: Tenant Forgot Password
  As a user, I Should be able to Reset Tenant Password
  
      
	  
    @smokeTest @Forgotpassword1
      Scenario: Tenant reset the password from forgot password link
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password
    And Enter email address
    And Navigate to forgot password page
    And Change password 
    And Verify Otp for change password
    And User verifies by log in with new password
    Then Verify login user redirected to home page
    
      
    @regressionTest @Forgotpassword
      Scenario: An Error message appears when user enters an invalid email on forgot password page.
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password 
    When Enter invalid email address   
    Then Error message Please enter a valid email address should be visible
    
    
     @regressionTest  @Forgotpassword
      Scenario: An error message appears when user enters mismatch password on confirm password field.
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password
    And Enter email address
    And Navigate to forgot password page
    And Mismatch password on confirms password field
    Then Passwords do not match error message appear
    
     @regressionTest  @Forgotpassword
      Scenario: Test Eye button functionality.
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password
    And Enter email address
    And Navigate to forgot password page
    And Mismatch password on confirms password field
    And Click on Eye Icon
    Then Password filed should appear in text and encrypted form
    
    
     @regressionTest @Forgotpassword
      Scenario: An error message appears when user enters a low complex password. 
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password
    And Enter email address
    And Navigate to forgot password page
    And Low complex password
    Then Password complexity error message should appears     
    
    
    @regressionTest @Forgotpassword
      Scenario: Verification failed error message should appears after enter invalid OTP. 
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Click forgot password
    And Enter email address
    And Navigate to forgot password page
    And Change password 
    And Enter Invalid OTP 
    Then Verification failed error message should appears
    
    
    @smokeTest   @Forgotpassword
 	Scenario: Tenant able to login WSO2
    When Navigate to wso
    And Enter username for wso
    And Enter password for wso
    And Click signin 
    Then Verify user is redirected to wso home page
    And Signout from wso


 
   

 
      