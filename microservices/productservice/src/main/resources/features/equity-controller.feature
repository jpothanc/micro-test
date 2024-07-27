Feature: Equity Controller Tests

  Scenario: Get all equities
    Given I have a list of equities
    When I request all equities
    Then I should receive a list of equities



  Scenario Outline: Get equity by code
    Given I have a list of equities
    When I request <equity> equity
    Then I should receive <equity> equity
  Examples:
    | equity   |
    | "0005.HK"|
    | "0001.HK"|