Feature: to verify post request in rest assured
  Scenario: to do restapi with post method
    Given use post request for reqres endpoint
    When send the response payload
    Then assert the status code

    Scenario:  to do restapi with post method and assert response body
      Given use post request for reqres endpoint
      When send the json response payload
      Then assert the response body