Feature: Validate the login API

  Scenario Outline: Verify User is sucessfully logged in
    Given Login API with <username> and <password>
    When  requests login
    Then  is sucessfully logged in with status code "200"
    And sessionToken is "0d628281-4f88-4a02-8223-5185e2fd71fd"

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
      | user3    | pass4    |
      | user3    | pass4    |
      | user5    | pass5    |
      | user6    | pass6    |



  @LoginTestCases @regressionTests @smoketests
  Scenario: Verify User gets an error if password is incorrect
    Given LoginAPI with "dataUser" and "wrong"
    When  requests login
    Then  gets an error with status code "200"
    And "Error" is "0001"
    And "Details" is "Invalid Password"
  @LoginTestCases
  Scenario: Verify User gets 500 status code if parameters are missing
    Given LoginAPI with "empty" and "password"
    When requests login
    Then gets an error with status code "500"
    And "Error" is "0002"
    And "Details" is "missing mandatory parameters"
