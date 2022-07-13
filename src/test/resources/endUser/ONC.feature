Feature: Login-With-ONC
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
      @Regression
 	 Scenario: Validating End-User login with ONC
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify user navigate to policy page
    Then Click on SSO Tab
   Then Click on edit icon of defalut policy
    Then Update Policy Name
    Then Update policy for Security Question Eligible factor
    Then Update policy for Phone Validation Eligible factor
    Then Update policy for Email Validation Eligible factor
    Then Click on Save button
    And Signout from sso
    Then Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Security Question Tab Non Configured
    Then Verify the Phone Tab Non Configured
    Then Verify the Email Tab Non Configured
       
       
        @Regression
 	 Scenario Outline: Validating End-User login functionality with OCNCNC
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
 	 Scenario Outline: Validating End-User login functionality with ONCONCOC
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
    
   
    
 
