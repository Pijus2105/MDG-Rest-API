@Smoke
Feature: Create User

  Background:
    Given the user is logged in and token is available

  Scenario: Successfully create a new user
    When the user sends a POST request to create a new user
    Then the response status code should be 201
