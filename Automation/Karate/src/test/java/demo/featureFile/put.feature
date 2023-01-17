Feature: Sample PUT API Test
  Scenario: Test a sample PUT API
    Given url 'https://reqres.in/api/users/2'
    And request {"name": "MHH","job": "SQAE"}
    When method put
    Then status 200
    And print response
    And match response.name == "MHH"
    And match response.job == "SQAE"