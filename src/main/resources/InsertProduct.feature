Feature: Insert product using POST API

  Scenario Outline: Validate post product API works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And  I pass the request body of products "<title>"
    Then I should get a response code 200
    Examples:
      | title |
      | Shoes   |


