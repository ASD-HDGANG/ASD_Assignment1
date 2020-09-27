#----------------------------------
# Empty Cucumber .feature file
#----------------------------------
Feature: TripPlanner Functionality Feature

In order to ensure TripPlanner Functionality works,
I want to run the cucumber test to verify it is working

Scenario: TripPlanner Functionality

Given user navigates to http://localhost:8080/ASD_Assignment1/tripPlanner.jsp
When user logs in using Departure as “mq” and Destination “epping”
Then login should be successful

Scenario: Login Functionality

Given user navigates to http://localhost:8080/ASD_Assignment1/tripPlanner.jsp
When user logs in using Departure as “china” and Destination “guangzhou”
Then error message should be thrown

   
