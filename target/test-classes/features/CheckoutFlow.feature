@Checkout
Feature: Checkout flow

  As a site user
  I want to complete checkout flow
  In order to buy products

  Background:
    Given I am a logged user

  Scenario Outline: Successful order payment
    When I have a product in my Cart
    And I go to the checkout
    Then I am able to complete payment using "<payment>" option
    Examples:
    | payment  |
    | bankwire |
    | cheque   |


