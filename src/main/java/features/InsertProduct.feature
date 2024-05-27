Feature: Insert product using POST API

  Scenario Outline: Validate post product API status code works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And  I pass the request body of products "<title>"
    Then I should get a response code 200
    Examples:
      | title |
      | shoes |

  Scenario Outline: Validate post product api response body works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And  I pass the request body of products "<title>"
    Then I receive the response body with id as "<id>"
    Examples:
      | title | id |
      | shoes | 21 |


