@reg
Feature: add orders
  @AddOrder
  Scenario: no active visit patient
    Given when user "test" is on oreders
    And click on record oredrs
    Then No active visit pop up will be displayed

  Scenario: add lab records

    Given when user "test name" is on oreders
    And click on record oredrs
    Then record lab orders
