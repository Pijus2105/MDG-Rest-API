@Smoke
Feature: Create Device

  Background:
    Given the user is logged in and token is available for device

  Scenario: Successfully create a new device
    When the user sends a POST request to create a new device
    Then the device response status code should be 201