Feature: Sample GET API Test
  Scenario: Test a sample GET API
    Given url 'https://reqres.in/api/users?page=2'
    When  method GET
    Then  status 200
    And print response
    And match response.data[0].first_name != null
    And assert response.data.length == 6
    And match $.data[1].id == 8
    And match $.data[3].last_name == 'Fields'