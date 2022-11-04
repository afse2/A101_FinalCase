Feature: As a user, I should be able to add items to chart with login and without login

  Scenario: User can add item to cart with login
    Given user navigate home page
    When user enter mail and password in login page and display they profile name "Test" on homepage
    And user enter "Parfum" the name of the item they wish to buy in the search box
    And user select 40 th item on the page
    And user add two item from 1 seller and 2 seller to cart
    Then user display correct item on the Sepetim page

    @wip
    Scenario: User can add item to cart without login
      Given user navigate home page
      When user does not login to the page
      And user enter "Parfum" the name of the item they wish to buy in the search box
      And user select 40 th item on the page
      And user add two item from 1 seller and 2 seller to cart
      Then user display correct item on the Sepetim page
