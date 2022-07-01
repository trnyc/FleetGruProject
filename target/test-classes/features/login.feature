Feature: Login 3 - With parameters and Scenario Outline

  Background:
    Given The user is on the login page


  Scenario Outline: Login as a <userType>
    When The user logs in as a "<userType>"
    Then The user is on the "<pageSubTitle>" page

    Examples:
      | userType      | pageSubTitle    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |



  Scenario Outline: Can not login with invalid credentials - Negative Scenario
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and page title is "Login"

    Examples:
      | username        | password    |
      | salesmanager101 |             |
      |                 | UserUser123 |
      |                 |             |
      | abcdefgh        | UserUser123 |
      | storemanager51  | aad3412!    |
      | asdaw           | sdf323'+%   |


   @wip
  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
      When The user tries to login with "<username>" and "<password>"
      Then The user should see "Please fill out this field" message if "<username>" or "<password>" is empty

     Examples:
       | username        | password    |
       | salesmanager101 |             |
       |                 | UserUser123 |













