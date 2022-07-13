Feature: EndUser Login with diffrent Usergroups
  
      @Smoke
 	 Scenario Outline: Validating End-User login functionality with RC
    When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
  And Enter Security Answer
    And Click on Submit button 
    Then Click on Email Option for RC
    And Enter OTP Received by Email
    And Submit OTP received in Email
    Then Click on Text Message Option for RC
    And Enter OTP received by Phone Number
    And Submit OTP received in Phone Number
    Then Redirected to Dashboard
     
     Examples: 
| username  | password  | 
| AutomationTest | Test@123 |
    
     @Smoke
     Scenario Outline: Validating End-User login functionality with OC
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
| Automation | Test@123 |
    
     @Smoke
    Scenario Outline: Validating End-User login functionality with OCOCRC
    When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
  Then Click on Text Message Option for RC
    And Enter OTP received by Phone Number
    And Submit OTP received in Phone Number
    Then Click on Email Option
    And Enter OTP Received by Email
    And Submit OTP received in Email
    Then Redirected to Dashboard
     
     Examples: 
| username  | password  | 
| RPAutomation | Test@123 |
    
     @Smoke
    Scenario Outline: Validating End-User login with disabled all MFA options
    When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
    Then Redirected to Dashboard
    
      Examples: 
| username  | password  | 
| RPAutomationTest | Test@123 |


  @Smoke
    Scenario Outline: Validating End-User login with disabled all MFA options
    When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Security Question Tab Non Configured
    Then Verify the Phone Tab Non Configured
    Then Verify the Email Tab Non Configured
   Examples: 
| username  | password  | 
| RPAutomationTest1 | Test@123 |
