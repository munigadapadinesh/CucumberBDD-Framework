Feature: Search and Place the order for Product
@searchproduct
Scenario: Search Experience for product search in both home and Offers page
Given User is on GreenCart Landing page
When user searched with Shortname Tom and extracted actual name of product
Then user searched for Tom shortname in offers page
  And validate product name in offers page matches with Landing Page

  Scenario Outline: Search Experience for multiple product search
    Given User is on GreenCart Landing page
    When user searched with Shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name in offers page matches with Landing Page
    Examples:
    |Name|
    |Tom |
    |Bea|