Feature: Delete product using DELETE API

  Scenario Outline: Validate delete product API status code works correctly
    Given I hit the url of delete product api endpoint
    When I pass the url of delete product in the request with "<ProductNumber>"
    Then I should get a response code 200
    Examples:
      | ProductNumber |
      | 7             |


