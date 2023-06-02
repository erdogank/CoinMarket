Feature: Users Can do the below things

  Background:
    Given user is on the homepage

  @wip3
  Scenario: Users can access binance fees

    Then users clicks the derivatives under the Exchanges
    And users clicks the Binance
    And user clicks the fees link
    Then users looks at the new open tab

  @wip4
  Scenario Outline: Users can access binance fees

    Then users clicks the derivatives under the Exchanges
    And users clicks the "<coinName>"
    And user clicks the fees link
    Then users sees "<coinName>" in new tab

    Examples:
      | coinName |
      | OKX      |
      | Deribit  |
      | KuCoin   |
      | Bitget   |
      | Bitget   |

