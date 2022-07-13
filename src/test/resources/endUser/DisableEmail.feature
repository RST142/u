Feature: Login-With-Disable-Email-In-Policy
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
      
      @Regression
 	 Scenario Outline: Validating End-User Login With Disable Email In Policy functionality
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
 Scenario Outline: Validating End-User login functionality with OCDONC
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
 Scenario Outline: Validating End-User login functionality with ONCDOC
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
| Ram | Test@123 |

@Regression
Scenario Outline: Validating End-User login functionality with ONCDONC
   When Navigate to End User Login Page 
    And Enter Username "<username>"
    And Enter Password for End User "<password>"
    And Click on Signin
    Then Redirected to login page of PWMS 
     And After login user should redirect to Account Recovery Setting
     
     Examples: 
| username  | password  |
| ql10test10 | Test@123 |

    
 
