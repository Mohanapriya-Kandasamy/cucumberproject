

@facebook1

Feature: 
  To validate Login Functionality of Facebook Application
  
  
 
    

  Scenario Outline: 
    To Validate Login using invalid username and invalid password

    Given user enter in to facebook login page
    When User enter "<username>" and "<password>"
    And User click the login button
    Then User should be in invalid credential page
    

    Examples: 
      | username            | password  |
      | priya123@gmail.com  | priya123  |
      | mohana123@gmail.com | mohana123 |
      | tharun123@gmail.com | tharun123 |
      | rudran123@gmail.com | rudran123 |
