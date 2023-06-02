Feature:Rows Tests

  Background:
    Given user is on the homepage
  @wip
  Scenario:The user should be able to see three options for the "Show rows", and set the table based on three options;
    When The user clicks on Show rows
    Then The user should see below options

      | 100 |
      | 50  |
      | 20  |

  @wip1
  Scenario Outline: user click on numbers from options the amount of rows must be displayed
    When The user clicks on Show rows
    And User click a number from "<options>"
    Then The "<options>" number should match
  Examples:
    | options |
    | 100 |
    | 50  |
    | 20  |

  @wip2
  Scenario: Price Filter Test
  When user clicks on filters
  And click on add filter
  And clicks on price
  And writes price range 10 to 20
  And click apply filter
  And click show results
  Then all prices should be more then 10 and less then 20
























#The user should be able to click the community module on the main page and write and post a message as a guest after entering there.
#AC: The max character can be 999
#Without entering a message, the user can't click Post

#2.The user should be able to see three options for the "Show rows", and set the table based on three options;
#AC: First option 100
#Second option 50
#Third option 20

#The user should be able to click "Filters" on the main page and add a price filter between 10 to 20.
#AC: The table should not display any price which is more than 20 and less than 10 dolar.