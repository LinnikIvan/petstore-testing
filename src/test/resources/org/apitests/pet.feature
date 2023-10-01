@ApiTests
Feature: Test pet API

  Background:
    Given url "http://localhost:8088/v3"

  Scenario: 1- Get by status
    Given path "/pet/findByStatus"
    And param status = "available"
    When method GET
    Then status 200
    * print response
    * def xml = read('files/find.xml')
    * match response == xml
