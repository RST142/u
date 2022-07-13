Feature: Post-Login-Landing-Page
  As a user, I Should be able to log in End User and validate the landing page
  
    @PostLoginLandingPage
 	  Scenario: Validating End-User Post Login Landing Page
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
    And Click on Security Question Option
    And Enter Security Answer
    And Click on Submit button 
    Then Redirected to Dashboard 
    Then Verify username on the Menu bar
    Then Enter the text in search field
    Then Click on the Application
    Then Navigate back to my app tab
    Then Count the Number of Applications

  
    
    
    
   
    
 
