Feature: Get all equities

  Scenario: Get all equities
    Given I have a list of equities
    When I request all equities
    Then I should receive a list of equities