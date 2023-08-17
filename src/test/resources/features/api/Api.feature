@api
Feature: Automate sample API requests using https://reqres.in/

  Background: User generates token for Authorisation

  Scenario: Verify unauthorized user can get a list of all users
    Given the endpoint is "/users"
    When I send a "GET" request
    Then the response status code should be 200
    And the get users body is valid

  Scenario: Verify unauthorized user can create a user
    Given the endpoint is "/users"
    When I send a "POST" request
    Then the response status code should be 201
    And the post user body is valid

  Scenario: Verify unauthorized user can get a user
    Given the endpoint is "/users/2"
    When I send a "GET" request
    Then the response status code should be 200
    And the get user body is valid

  Scenario: Verify unauthorized user can put a user
    Given the endpoint is "/users/2"
    When I send a "PUT" request
    Then the response status code should be 200
    And the put user body is valid

  Scenario: Verify unauthorized user can patch a user
    Given the endpoint is "/users/2"
    When I send a "PATCH" request
    Then the response status code should be 200
    And the patch user body is valid

  Scenario: Verify unauthorized user can delete a user
    Given the endpoint is "/users/3"
    When I send a "DELETE" request
    Then the response status code should be 204
