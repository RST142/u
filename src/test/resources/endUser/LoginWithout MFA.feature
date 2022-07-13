Feature: Login-Without-MFA
  End-User able to Login with and without MFA options
 
      
  @Smoke
   Scenario: Validating End-User login without using MFA options
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on Add Policy button
    Then Add policy name
    Then Select Policy Status
    Then Select User Group
    Then Click on Save button
    And Signout from sso
   When Navigate to End User Login Page 
   And Enter Username
   And Enter User Password
   And Click on Signin
  And ReEnter Password for End User
    And Click on signin button to submit password
    Then Redirected to the account recovery page
    Then Verify the Security Question Tab Non Configured
    Then Verify the Phone Tab Non Configured
    Then Verify the Email Tab Non Configured
     When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
   Then Click on SSO Tab
   Then Click on delete icon of policy
   Then Click on delete button
  
      