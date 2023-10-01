@ApiTests
Feature: Test pet API

  Background:
    * def appUrl = "http://localhost:8088"
    * def PATH = "/v3/pet/findByStatus"

  Scenario: 1- Get by status
    Given url appUrl
    And path PATH
    And param status = "available"
    When method GET
    Then status 200
