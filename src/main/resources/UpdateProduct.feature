Feature: Update product using PUT API

  Scenario Outline: Validate put product API status code works correctly
    Given I hit the url of put product api endpoint
    When I pass the url of products in the request with "<ProductNumber>"
    And  I pass the request body of put api
    Then I should get a response code 200
    Examples:
      | ProductNumber |
      | 7             |


