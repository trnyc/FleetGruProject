
Feature: Logout Function

  Background:
   Given User is on the homepage

    @FLT-1860
    Scenario: The user can log out and ends up on the login page.
      When user open profile menu
      And user click on logout link
      Then user land on login page

    @FLT-1862
    Scenario: The user can not go to the home page again by clicking the step back button after successfully logging out.
      When user open profile menu
      And user click on logout link
      And user land on login page
      And user click on step back button
      Then user can not go to homepage


    @FLT-1864
    Scenario: The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
      When user open two homepage tabs
      And user close all tabs
      And user reopen the url
      Then user can not land on homepage
