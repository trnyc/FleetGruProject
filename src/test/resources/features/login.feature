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


  Scenario: "Please fill out this field" message should be displayed if the password or username is empty
    When The user tries to login with "salesmanager101" and ""
    Then The user should see "Please fill out this field." message if password is empty


  Scenario: "Please fill out this field" message should be displayed if the password or username is empty
    When The user tries to login with "" and "UserUser123"
    Then And The user should see "Please fill out this field." message if username is empty


  Scenario: User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    When The user clicks Forgot your password? link
    Then The user should land on 'Forgot Password' page


  Scenario: User can see "Remember Me" link exists and is clickable on the login page
    When User can see Remember Me Link
    Then User able to click on Remember Me link

@wip
  Scenario: User should see the password in bullet signs by default
    When User can pass "anything" as a password
    Then The password should be seen in bullet sign












