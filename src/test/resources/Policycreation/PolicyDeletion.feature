Feature: Policy Deletion
  As a Tenant, I Should be able to execute PostExecution
  
    
      @PostExecution
 	 Scenario: Validating Tenant able to remove  the policy
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Verify user navigate to policy page
   Then Click on SSO Tab
   Then Click on delete icon to delete policy
    And Signout from sso