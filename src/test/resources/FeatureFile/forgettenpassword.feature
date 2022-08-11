@facebook2
Feature: 
  user validate login page and the forgetten password field
  
  
  Background:
  Given user enter in to facebook login page

  Scenario: 
    to validate the loginpage of facebook application

   
    When user enter the invalid username and invalid password
      | priyakandasamy | 12345 | tharun | 23456 | rudran | 23456567 |
    And user click the login button
    Then user should be in inavlid credential page

  Scenario: 
    to validate the loginpage of facebook application

   
    When user enter the valid username and invalid password
      | priyakandasamy | 2345678345 | tharun | 23456 | rudran | 23456567 |
    And user click the login button
    Then user should be in inavlid credential page

  Scenario: 
    to validate the loginpage of facebook application

    
    When user enter the valid username and valid password
      
      | siddharth.tharun@gmail.com | Support_162021 |
    And user click the login button
    Then user should not be in inavlid credential page
