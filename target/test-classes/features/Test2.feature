Feature: Front end test 1
 
Scenario: Open page and verify 100 results are displayed
    Given Load Chrome driver and open page
    When Click on Filters button
    Then Verify that 100 results are displayed
    
Scenario: Open page and filter no more than 5 result and add to watchlist
    Given Load Chrome driver and open page2
    When Filter no more than 10 results by price range
    And Filter no more than 5 results by volume range
    Then Add to Watchlist and open Watchlist page
    And Verify that filtered items are in the Watchlist