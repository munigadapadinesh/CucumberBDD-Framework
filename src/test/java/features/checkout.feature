Feature: Place the order for Product
@Placeorder
  Scenario Outline: Checkout Scenario
    Given User is on GreenCart Landing page
    When user searched with Shortname <Name> and extracted actual name of product
    And Add 3 items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order
    Examples:
    |Name|
    |Tom|
    |Bea|