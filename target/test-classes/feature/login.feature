# src/test/resources/features/login.feature

@Login @Smoke
Feature: Login API

  @Positive
  Scenario: Valid login returns 200 with token
    Given user has valid login credentials
    When user sends login POST request
    Then login response status should be 200
    And response should contain valid token
    And response should contain workspace path