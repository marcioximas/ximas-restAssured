Feature: Get all products from the api

  Scenario: Verify the response code for the get all products api
    Given I have the base url for the api
    When I send a GET request to the get all products api
    Then I should get a response code