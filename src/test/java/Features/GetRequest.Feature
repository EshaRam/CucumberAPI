Feature: to verify getrequest with Rest Assured
  Scenario: to do rest api - GET method
    Given i use reqres get endpoint
    When submit get request
    Then get status code
    And assert the response body email
    And assert the response body firstname