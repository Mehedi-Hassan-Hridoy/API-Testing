Feature: Sample POST API Test
  Scenario: Test a sample POST API
    Given url 'https://reqres.in/api/users'
    And request { "name": "Mehedi", "job": "QA Engineer"}
    When method post
    Then status 201
    And print response
    And match response.name != null
    And match response.job == "QA Engineer"