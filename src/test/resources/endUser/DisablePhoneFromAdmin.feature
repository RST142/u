Feature: Login-Scenarios-With-Disable-Phone-Configuration
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
      
      
      
       @Regression
       Scenario: Disabling Phone configuration from admin side
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    And Verify user navigate to MFA configuration page
      And Click on phone configuration and disable phone configuration
      Then Click on disabled button
      
      @Regression
 	 Scenario Outline: Validating End-User login functionality with OCOCNA
    When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
   And Click on Security Question Option
  And Enter Security Answer
  And Click on Submit button 
  Then Redirected to Dashboard
     
     Examples: 
| username  | password  | 
| AuRam | Test@123 |
@Regression
 Scenario Outline: Validating End-User login functionality with OCONCNA
   When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
     And Enter Security Answer
  And Click on Submit button 
  Then Redirected to Dashboard
     
     Examples: 
| username  | password  |
| AuRam1 | Test@123 |
@Regression
 Scenario Outline: Validating End-User login functionality with ONCOCNA
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
@Regression
Scenario Outline: Validating End-User login functionality with ONCONCNA
   When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
    Then Redirected to login page of PWMS 
    Then Verify the Email Tab Non Configured
     
     Examples: 
| username  | password  |
| ql10test10 | Test@123 |

     @Regression
       Scenario: Enabling Phone configuration from admin side
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    And Verify user navigate to MFA configuration page
      And Click on phone configuration and enable phone configuration
 
