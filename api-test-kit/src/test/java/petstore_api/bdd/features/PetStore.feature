Feature: PetStore API Tests

  Background:
    Given the base URI is "https://petstore.swagger.io/v2"

  Scenario: Find pets by status
    Given the endpoint is "/pet/findByStatus"
    And the request method is "GET"
    And the query parameter "status" is "available"
    When the request is sent
    Then the status code is 200
    And the content type is "application/json"
    And the response is not empty

  Scenario: Add a new pet
    Given the endpoint is "/pet"
    And the request method is "POST"
    And the request body is:
      """
      {
          "id": 12345,
          "name": "TestPet",
          "status": "available"
      }
      """
    When the request is sent
    Then the status code is 200
    And the content type is "application/json"
    And the field "id" is 12345

  Scenario: Get pet by ID
    Given the endpoint is "/pet/{petId}"
    And the request method is "GET"
    And the path parameter "petId" is "12345"
    When the request is sent
    Then the status code is 200
    And the content type is "application/json"
    And the field "id" is 12345

  Scenario: Delete pet
    Given the endpoint is "/pet/{petId}"
    And the request method is "DELETE"
    And the path parameter "petId" is "12345"
    When the request is sent
    Then the status code is 200
    And the content type is "application/json"
    And the field "type" is "unknown"