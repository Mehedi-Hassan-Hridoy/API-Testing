Feature: Sample DELETE API Test
  Scenario: Test a sample DELETE API
    Given url 'https://reqres.in/api/users/2'
   # And def payload = read(classpath:"demo/jsonData/delete.json")
    And request {"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://reqres.in/img/faces/2-image.jpg"}
    When method delete
    Then status 204
    And print response
    And print responseStatus