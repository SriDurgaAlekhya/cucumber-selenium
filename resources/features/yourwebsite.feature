Feature: This features verify the functionality on automationpractice.com

  Scenario: Complete a transaction
    Given Given launch firefox browser and open "http://automationpractice.com/index.php"
    And Signin with my existing credentials "sridurga.alekhya@gmail.com"
    Then Go to womens section and select a t-shirt. Also proceed to checkout
    Then Proceed to checkout in summary page
    Then Proceed to checkout in Address page by selecting delivery address
    And Agree the terms and proceed to checkout in Shipping page
    And Select one of the avaliable payment options
    Then Confirm the order
    Then The order should be placed
    Then Close the browser
    
