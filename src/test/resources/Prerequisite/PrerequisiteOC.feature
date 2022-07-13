Feature: Prerequisite-End-User
  As a Tenant, I Should be able to execute Prerequisite
  
 @Prerequisite
 	 Scenario: Validating Tenant able to add the policy
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
    Then Click on SSO Tab
    Then Click on Add Policy button
    Then Select MFA cardinality
    Then Add policy name
    Then Select Policy Status
    Then Select User Group
    Then Select Security Question Eligible factor
    Then Select Phone Validation Eligible factor
    Then Select Email Validation Eligible factor
    Then Click on Save button
    And Signout from sso