Feature: Get all products from the api

  Scenario: Verify the response code for the get all products api
    Given I have the base url for the api
    When I send a GET request to the get all products api
    Then I should get a response code 200

  Scenario:  Verify the rate of the first product is correct
    Given I hit the url of get products api endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is '<FirstProductRate>'
    Example:
        | FirstProductRate   |
        | 3.9                |
