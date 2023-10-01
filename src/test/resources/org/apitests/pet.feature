@ApiTests
Feature: Test Pets API

  Background:
    Given url "http://localhost:8088/v3"

  Scenario: 1 - Find pets by status
    Given path "/pet/findByStatus"
    And param status = "available"
    When method GET
    Then status 200
    * print response
    * def xml = read('mocks/xml_mocks/pets/find_by_status.xml')
    * match response == xml
