Feature: Tenant Login
  As a user, I Should be able to log in as Tenant
  
      
       @smokeTest @regressionTest @TenantLogin
 	 Scenario: Tenant able to login Admin Panel
   When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    And Signout from sso



     	@regressionTest @TenantLogin
  	Scenario: Tenant not able to login with incorrect email
    When Navigate to url
    And Click on login here
    And Enter invalid email
    And Enter password
    And Click Login
    Then The error message "Incorrect username or password." appears on the screen

      
     @regressionTest @TenantLogin
  	Scenario: Tenant notified when login with an empty email field
    When Navigate to url
    And Click on login here
    And Empty email field
    And Enter password
    And Click Login
    Then The error message "Email is required." appears on the screen

    @regressionTest  @Known_Issue @TenantLogin
 	Scenario: Tenant notified when login with the empty password field
    When Navigate to url
    And Click on login here
    And Empty email field
    And Empty password
    And Click Login
    Then The error message "Password is required." appears on the screen
      
    @regressionTest @TenantLogin
  	Scenario: Verify Terms & Conditions link on page 
    When Navigate to url
    And Click on login here
    And Verify Terms & Condition Link on login page
 
    
    @regressionTest @TenantLogin
  	Scenario: Verify Registration link on page 
    When Navigate to url
    And Click on login here
    Then Verify Registration link on login page
  
 
      
      