Feature: Tenant-Login-Create-New-AD
  As a user, I Should be able to log in as Tenant and create new AD
  
      
    @TenantLoginCreateNewAD
 	 Scenario: Tenant able to login Admin Panel and create New AD
   When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Verify login user redirected to home page
    Then Navigate to the add users directory page
    Then Click on Configure Directory Tab
    Then Click on Add new Directory
    Then Enter AD details
    Then Click on Test Connectivity button
    Then Click on Save Connectivity button
    Then Click on sync link
    Then Delete the Created AD
    And Signout from sso

 
      
      