Feature: Sample PATCH API Test
  Scenario: Test a sample PATCH API
    Given url 'https://reqres.in/api/users/2'
    And request {"name": "Hridoy","job": "QAE"}
    When method patch
    Then status 200
    And print response
    And match response.name == "Hridoy"
    And match response.job == "QAE"