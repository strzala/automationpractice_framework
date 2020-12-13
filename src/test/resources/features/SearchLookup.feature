@Search
Feature: Searching for products

  As a site user
  I want to use search lookup
  In order find products

  Background:
    Given I am on Home page

  Scenario Outline: After typing first letters hints are shown
    When I type initial "<letters>" of product name
    Then "<Hints>" with corresponding product names are shown in the search lookup

    Examples:
    | letters   |   Hints        |
    |  Blou     |     Blouse     |
    |  pri      |     Printed    |

