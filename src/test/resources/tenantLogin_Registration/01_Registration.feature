Feature: Tenant Registration
  As a user, I should be able to create Tenant account on SSO Application

    @SmokeTest  
 		Scenario: Tenant Registered Successfully
    When Navigate to url
    And Enter Organization Name
    And Enter Full Name
    And Select Job Title
    And Select Country
    And Enter Phone Number 
    And Enter Email 
    And Select Checkbox for privacy policy
    And Select Checkbox for consent to recieve notifications
    And Click start free trial
    And Verify OTP is generated 
    And Enter Password and login
    Then Verify login user redirected to home page
   
      
    @RegressionTest 
 	  Scenario: Tenant able to login WSO2
    When Navigate to wso
    And Enter WSO2 Username for Registration
    And Enter WSO2 Password and login
    And Click WSO2 Signin
    Then Verify User Redirected to WSO2
    And Signout from wso

 
   	@RegressionTest  
   	Scenario: Verify host Name on CPS
    When Navigate to cps
    And Enter CPS Username
    And Enter CPS Password
    And Click signin for cps 
    And Verify user redirected to CPS
    And Click on settings
    And Click on Federation Partners 
    And Set host name
    Then Verify CPS host created
    And Logoff from cps

      