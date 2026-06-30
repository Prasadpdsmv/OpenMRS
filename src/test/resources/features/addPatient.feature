@reg
@addPatient
Feature: add patient

  Background:
    Given user goes to the add patient page

  Scenario: Add a new patient
    And user enters patient details
      |Patient Identifier|Yes|
      |First_Name|John|
      |Family_name|doe|
      |Gender|Male        |
      |Birth_Date|01-01-1993|
      |adress|123 Main St|
      |phoneNumber|1234567890|
    When user clicks on register patient button
    Then system adds the patient into the system
    And system shows the patient dashboard page

  Scenario: Add a new patient with missing required fields
    And user enters patient details
      |Patient Identifier|Yes|
      |First_Name| |
      |Family_name| |
      |Gender|Male|
      |Birth_Date|01-01-1993|
      |adress|123 Main St|
      |phoneNumber|1234567890|
    When user clicks on register patient button
    Then system shows validation error messages for missing required fields

  Scenario: add new patient with existing user details
    And user enters patient details
      |Patient Identifier|Yes|
      |First_Name|John|
      |Family_name|doe|
      |Gender|Male        |
      |Birth_Date|01-01-1993|
      |adress|123 Main St|
      |phoneNumber|1234567890|
    When user clicks on register patient button
    Then system shows validation error messages for existing patient details