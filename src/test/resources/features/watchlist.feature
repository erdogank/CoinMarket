Feature: Users Can do add his/her favorittes coins to watchlist

  Background:
    Given user is on the homepage


  @wip5
  Scenario: Users can add and access coins in the watchlist

    When the user clicks the star near the coin names
    Then the user verifies that the star's color changes to yellow
    And the user clicks the Watchlist
    Then the user verifies that the added coins are in the watchlist
