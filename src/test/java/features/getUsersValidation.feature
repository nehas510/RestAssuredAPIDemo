Feature: Validate the Users API to get the user's detail

  Scenario: Verify List of all users
    Given Users API
    When calling the users api
    Then get response with status code "200"

  Scenario: Verify getting a single user by Id 1122 (Path Parameter)
    Given Users API
    When calling the users api by path id "374985798"
    Then get response with status code "200"

  Scenario: Verify getting a user whose name is John (Query parameter)
    Given Users API by name "John"
    When calling the users api by path id "1234"
    Then get response with status code "200"

  Scenario: Verify updating users detail by id 77866 (Put request)
    Given Users API
    When calling the users api by id "1234"
    Then get response with status code "202"

  Scenario: Verify deleting a single user by Id (delete request)
    Given Delete API with  "23454"
    When calling the delete api with "23454"
    Then get response with status code "204"
