
Feature: Top up unlinked cards

Scenario: Top up unlinked cards scenario

Given I am already on Smart Card Management Page 
When The Top Up Button is available
Then I click on Top Up Button
Then I enter smart card number
Then I enter security code
Then I enter top up amount
Then I click on Top Up Button

