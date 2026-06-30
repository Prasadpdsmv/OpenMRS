@reg
Feature: VitalsAndBiometrics

  @VitalsBiometrics
  Scenario: entering valid vitals and biometrics
    Given user is on add vitals and biometrics page
    And user enters vitals and biometrics
    |temparature|28|
    |sysBP      | 110 |
    |disBP      |  80 |
    |HeartRate |63   |
    |Respiration|23  |
    |SP2        |99  |
    |Notes      |sdassd|
    |weight     |67    |
    |height     |165   |
    |muac       |      |

    When user clicks save and close successfull message should appear
    Then vitals and biometrics should display on Patient Summary page
    And verify deatails from input details.