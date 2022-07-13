Feature: Login-With-Disabled-Security-And-Optional-Configuration
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
        @Regression
 	 Scenario Outline: Validating End-User login functionality with NAOCONC
   When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
   Then Click on edit icon of defalut policy
    Then Update Policy Name
    Then Update policy for Phone Validation Eligible factor
    Then Update policy for Email Validation Eligible factor
    Then Click on Save button
    And Signout from sso
   When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
     Then Click on Email Option for RC
   And Enter OTP Received by Email
   And Submit OTP received in Email
   And Redirected to Dashboard
     
     Examples: 
| username  | password  | 
| midland2 | Test@123 |
    
    
    @LoginWithOptionalConfig
 	 Scenario Outline: Validating End-User login functionality with NAONCOC
   When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
    Then Click on Text Message Option for RC
   And Enter OTP received by Phone Number
   And Submit OTP received in Phone Number
   And Redirected to Dashboard
     
     Examples: 
| username  | password  | 
| AuRam | Test@123 |
   
    
 
