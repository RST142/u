Feature: PreLogin-Notifications
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user Notifications
  
    @PreLogin-Notifications
 	  Scenario: Validating End-User Pre Login Error Notifications
    When Navigate to End User Login Page 
    And Enter Username
    And Enter Password for End User
    And Click on Signin
    And Verify Error Notification Message
    
    
    
    
   
    
 
