Feature: Bookstore API - Create Book

  Scenario: Create a new book
    Given I have a valid book payload
    When I POST it to /books endpoint
    Then I should receive status code 201
    And response should contain the book ID
