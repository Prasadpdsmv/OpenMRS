@reg
@testFeature
Feature: add patient testing

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