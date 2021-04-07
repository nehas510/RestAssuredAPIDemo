Feature: Validate the login API
  @LoginTestCases
  Scenario: Verify User is able to log in
    Given LoginAPI have "username" and "password"
    When  requesting login
    Then  is logged in with status code "200"