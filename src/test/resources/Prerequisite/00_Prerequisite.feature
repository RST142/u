Feature: Prerequisite-FTU
  As a Tenant, I Should be able to execute Prerequisite
  
      
    @PrerequisiteFTU 
 	 Scenario: Clear Existing FTU Data from Tenant
    When Navigate to url
    And Click on login here 
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    And Navigate to UserDetails Page 
    And Type Username In UserDetail Page
    And Click on Search button
    And Search a record of Enduser with Username
    Then Click on clear button
  
    
    