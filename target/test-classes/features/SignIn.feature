@SignIn
Feature: Login user into website

  As a site user
  I want to log in
  In order to access site options

  Background:
    Given I am on Sign In page

  @login_positive
  Scenario Outline: Successful login using correct credentials
    When I enter valid "<email>" and "<password>"
    And I click on Sign in button
    Then I am logged to My Account

    Examples:
    | email                      | password |
    | imie.nazwisko87@gmail.com  | test123  |

  @login_negative
  Scenario Outline: Unsuccessful login using incorrect credentials
    When I enter invalid "<email>" or "<password>"
    And I click on Sign in button
    Then Error "<message>" is displayed

    Examples:
    | email                        |   password     |           message             |
    |                              |                |   An email address required.  |
    | imie.nazwisko87@gmail.com    |                |     Password is required.     |
    | imie.nazwisko87@gmail.com    |      x         |        Invalid password.      |
    | nieistniejacy91234@gmail.com |    passwo      |      Authentication failed.   |