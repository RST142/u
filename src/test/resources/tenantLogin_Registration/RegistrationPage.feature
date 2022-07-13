Feature: Regression for Registration Page
  As a user, I should be able to create Tenant account on SSO Application

	   
     @RegressionTest 
    Scenario: Tenant not able to register with already existing domain
    When Navigate to url
    And Enter Organization Name
    And Enter Full Name
    And Select Job Title
    And Select Country
    And Enter Phone Number
    And Enter Existing Email
    And Select Checkbox for privacy policy
    And Select Checkbox for consent to recieve notifications
    Then The error message "Domain already exists" appears on the screen
    

        @RegressionTest  
     Scenario: Tenant not able to register with same organization name
    When Navigate to url
    And Enter existing Organization Name
    And Enter Full Name
    Then The error message "Organization name already exists" appears on the screen
    
          
  
      
    @RegressionTest
    Scenario: Tenant able to enter only string value for Full Name
    When Navigate to url
    And Enter Organization Name
    And Enter invalid full name
    Then The error message "Invalid full name" appears on the screen
    

  	@RegressionTest 
    Scenario: Tenant is not be able to register if terms of service are not selected
    When Navigate to url
    And Enter Organization Name
    And Enter Full Name
    And Select Job Title
    And Select Country
    And Enter Phone Number
    And Enter Email 
    And Select Checkbox for consent to recieve notifications
    Then Verify start free trial button is disabled
    
      
    @RegressionTest 
  	Scenario: Tenant notified when login failed with incorrect username on WSO
   	When Navigate to wso
    And Enter invalid username for wso
    And Enter password for wso
    And Click signin
    Then The error message "Login failed!" appears on the screen


    @RegressionTest 
  	Scenario: Tenant notified when login with empty username field on WSO
  	When Navigate to wso
    And Enter empty username for wso
    And Enter password for wso
    And Click signin
    Then The error message "Please enter a valid user name and a password." appears on the screen

  
    @RegressionTest 
  	Scenario: Tenant notified when login with empty password field on WSO
  	When Navigate to wso
    And Enter WSO2 Username for Registration
    And Enter empty password for wso
    And Click signin
    Then The error message "Please enter a valid user name and a password." appears on the screen
