Feature: Inventories creation
  As a user, I Should be able to log in as Tenant, set the policy & Validate End-user login
  
  
      @Regression
 	 Scenario: Inventory creation with inventory type Product
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Click on administrator button and navigate to inventories page
    And Click on add inventory button and fill all inventory detail
    
     @Regression
 	 Scenario: Inventory creation with inventory type Feature
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Click on administrator button and navigate to inventories page
    And Click on add inventory button and fill all inventory detail with inventory type feature
    
     @Regression
 	 Scenario: Inventory creation with inventory type professional services
    When Navigate to url
    And Click on login here
    And Enter Email ID
    And Enter password
    And Click Login
    Then Click on administrator button and navigate to inventories page
    And Click on add inventory button and fill all inventory detail with inventory type professional services
    
    
   
    
 
